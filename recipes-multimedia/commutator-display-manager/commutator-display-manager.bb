SUMMARY = "Silence Commutator Sytadin recipe"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

FILES:${PN}:append = "${THISDIR}/files"
SRC_URI = " \
    gitsm://github.com/gscigala/commutator-display-manager;protocol=https;branch=feature/yocto-integration \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig

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
"
