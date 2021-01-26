DESCRIPTION = "Silence develop image"
LICENSE = "GPLv3"

require silence-image.bb

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-debug \
    tools-testapps \
    ssh-server-dropbear \
"

IMAGE_INSTALL_append = " \
    connected-clock-with-cron \
    silence-packagegroup-testapps \
"