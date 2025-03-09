SUMMARY = "Silence Commutator Display Manager recipe"
DESCRIPTION = "Program to display on a epaper screen multiple informations."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

FILES:${PN}:append = "${THISDIR}/files"
SRC_URI = " \
    gitsm://github.com/gscigala/commutator-display-manager;protocol=https;branch=feature/yocto-integration \
    file://${BPN}.service \
    file://${BPN}.cron \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig systemd

DEPENDS = " \
    boost \
    sdbus-c++ \
    pugixml \
    opencv \
    nlohmann-json \
"

RDEPENDS:${PN} += " \
    boost \
    sdbus-c++ \
    pugixml \
    opencv \
    nlohmann-json \
    cronie \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}

    install -d ${D}/${sysconfdir}/cron.d
    install ${WORKDIR}/${BPN}.cron ${D}/${sysconfdir}/cron.d/
}

SYSTEMD_SERVICE:${PN} = "${BPN}.service"