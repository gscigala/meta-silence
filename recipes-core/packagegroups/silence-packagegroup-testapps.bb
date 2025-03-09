DESCRIPTION = "Silence test application packagegroup"
SUMMARY = "Silence packagegroup - tools/testapps"
LICENSE = "GPL-3.0-only"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
    htop \
    mc \
    nano \
"
