SUMMARY = "Silence Connected clock recipe"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI = "git://github.com/gscigala/connected-clock;protocol=https;branch=master \
           file://connected-clock.service \
"
SRCREV = "4febff21498cf83624fa52e213fbde6506e4eebf"

S = "${WORKDIR}/git" 

DEPENDS = "gstreamer1.0 boost"
RDEPENDS:${PN} = "gstreamer1.0 gstreamer1.0-plugins-base boost"

inherit meson systemd pkgconfig

do_install:append() {
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/connected-clock.service ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE:${PN} = "connected-clock.service"