SUMMARY = "Silence Connected clock recipe"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

FILES:${PN}:append = "${THISDIR}/files"
SRC_URI = "git://github.com/gscigala/connected-clock;protocol=https;branch=master \
           file://connected-clock.service \
"
SRCREV = "aeba8a2243f89a9afe50d163d7f092822d5ff12b"

S = "${WORKDIR}/git" 

DEPENDS = "gstreamer1.0 boost"
RDEPENDS:${PN} = "gstreamer1.0 gstreamer1.0-plugins-base boost"

inherit meson systemd pkgconfig

do_install:append() {
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${UNPACKDIR}/connected-clock.service ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE:${PN} = "connected-clock.service"