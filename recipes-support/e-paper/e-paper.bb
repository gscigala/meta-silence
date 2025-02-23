SUMMARY = "Waveshare e-Paper library"
DESCRIPTION = "Library for controlling Waveshare e-Paper displays"
HOMEPAGE = "https://github.com/waveshareteam/e-Paper"
LICENSE = "CLOSED"

SRC_URI = " \
    git://github.com/waveshareteam/e-Paper;protocol=https;branch=master \
    file://0001-Modifications-for-cross-compile.patch \
"
SRCREV = "ecdd8cf7bab311e6e290c84c68d474deafb7ca8d"

S = "${WORKDIR}/git"

DEPENDS = "bcm2835"

do_compile() {
    cd E-paper_Separate_Program/2in15_e-Paper_G/RaspberryPi_JetsonNano/c
    make EPD=epd2in15g
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/E-paper_Separate_Program/2in15_e-Paper_G/RaspberryPi_JetsonNano/c/epd ${D}${bindir}

    install -d ${D}${sysconfdir}/${BPN}
    install -m 0444 ${S}/E-paper_Separate_Program/2in15_e-Paper_G/RaspberryPi_JetsonNano/c/pic/2in15g.bmp ${D}${sysconfdir}/${BPN}/
}