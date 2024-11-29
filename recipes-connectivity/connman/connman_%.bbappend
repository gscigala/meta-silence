FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://silence.config"

SILENCE_WIFI_NAME ?= ""
SILENCE_WIFI_PASSPHRASE ?= ""
SILENCE_WIFI_SECURITY ?= ""

do_configure:append() {
    sed -i "s/\(^Name=\)\(.*$\)/\1${SILENCE_WIFI_NAME}/g" ${UNPACKDIR}/silence.config
    sed -i "s/\(^Passphrase=\)\(.*$\)/\1${SILENCE_WIFI_PASSPHRASE}/g" ${UNPACKDIR}/silence.config
    sed -i "s/\(^Security=\)\(.*$\)/\1${SILENCE_WIFI_SECURITY}/g" ${UNPACKDIR}/silence.config
}

do_install:append() {
    install -d ${D}/var/lib/${PN}
    install -m 0600 ${UNPACKDIR}/silence.config ${D}/var/lib/${PN}
	cat >> ${D}${systemd_unitdir}/system/${PN}.service <<EOF
[Service]
ExecStartPost=/bin/sleep 20
ExecStartPost=/usr/bin/connmanctl enable wifi
EOF
}