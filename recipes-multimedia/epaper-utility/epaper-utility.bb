SUMMARY = "Silence epaper utility recipe"
DESCRIPTION = "Tool to manage WaveShare 2.15 inch G+ e-paper screen, with cleaning sequence and splash screen."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " \
    gitsm://github.com/gscigala/epaper-utility;protocol=https;branch=develop \
    file://epaper-utility-clean.cron \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "bcm2835"

RDEPENDS:${PN} += " \
    cronie \
"

inherit meson

do_install:append() {
    install -d ${D}/${sysconfdir}/cron.d
    install ${WORKDIR}/${BPN}-clean.cron ${D}/${sysconfdir}/cron.d/
}