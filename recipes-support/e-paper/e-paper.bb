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

do_compile() {
    cd RaspberryPi_JetsonNano/c
    make EPD=epd2in15g
}