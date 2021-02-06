SUMMARY = "Silence image image"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "splash"

IMAGE_INSTALL_append = " \
    connman \
    connman-client \
    tzdata \
"