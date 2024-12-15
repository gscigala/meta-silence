FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
FILES:${PN} += "${sysconfdir}/modprobe.d/alsa-base.conf"

SRC_URI += "file://alsa-base.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/alsa-base.conf ${D}${sysconfdir}/modprobe.d
}