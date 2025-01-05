DESCRIPTION = "Silence develop image"
LICENSE = "GPL-3.0-only"

include recipes-core/images/silence-image.bb

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-debug \
    tools-testapps \
    ssh-server-dropbear \
"

IMAGE_INSTALL:append = " \
    connected-clock-with-cron \
    commutator-sytadin \
    commutator-vigicrues \
    commutator-idfm-line-reports \
    silence-packagegroup-testapps \
"