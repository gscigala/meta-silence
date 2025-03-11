SUMMARY = "Silence epaper utility recipe"
DESCRIPTION = "Tool to manage WaveShare 2.15 inch G e-paper screen, with cleaning sequence and splash screen."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " \
    gitsm://github.com/gscigala/epaper-utility;protocol=https;branch=develop \
    file://0001-Modifications-for-cross-compile.patch \
    file://${BPN}-clean.cron \
    file://${BPN}-splash.service \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "bcm2835"

RDEPENDS:${PN} += " \
    cronie \
"

inherit meson systemd

do_patch() {
    cd ${S}/lib/e-Paper
    bbnote "Applying patch to lib/e-Paper submodule"
    git apply '${WORKDIR}/0001-Modifications-for-cross-compile.patch'
}

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}-splash.service ${D}${systemd_system_unitdir}

    install -d ${D}/${sysconfdir}/cron.d
    install ${WORKDIR}/${BPN}-clean.cron ${D}/${sysconfdir}/cron.d/
}

SYSTEMD_SERVICE:${PN} = "${BPN}-splash.service"