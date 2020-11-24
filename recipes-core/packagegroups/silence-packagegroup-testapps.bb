DESCRIPTION = "Silence test application packagegroup"
SUMMARY = "Silence packagegroup - tools/testapps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    htop \
    mc \
    nano \
"
