DESCRIPTION = "Silence develop image"
LICENSE = "MIT"

require silence-image.bb

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-debug \
    tools-testapps \
    ssh-server-dropbear \
"

IMAGE_INSTALL_append = " \
    connected-clock \
    silence-packagegroup-testapps \
"