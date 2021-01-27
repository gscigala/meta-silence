FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://silence.config"

SILENCE_WIFI_NAME ?= ""
SILENCE_WIFI_PASSPHRASE ?= ""
SILENCE_WIFI_SECURITY ?= ""

do_configure_append() {
    sed -i 's/\(^Name=\)\(.*$\)/\1${SILENCE_WIFI_NAME}/g' ${WORKDIR}/silence.config
    sed -i 's/\(^Passphrase=\)\(.*$\)/\1${SILENCE_WIFI_PASSPHRASE}/g' ${WORKDIR}/silence.config
    sed -i 's/\(^Security=\)\(.*$\)/\1${SILENCE_WIFI_SECURITY}/g' ${WORKDIR}/silence.config
}

do_install_append() {
    install -d ${D}/var/lib/${PN}
    install -m 0600 ${WORKDIR}/silence.config ${D}/var/lib/${PN}
	cat >> ${D}${systemd_unitdir}/system/${PN}.service <<EOF
[Service]
ExecStartPost=/bin/sleep 5
ExecStartPost=/usr/bin/connmanctl enable wifi
EOF
}