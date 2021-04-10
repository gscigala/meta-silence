SUMMARY = "Silence image image"
LICENSE = "GPLv3"

inherit core-image

IMAGE_FEATURES += "splash"

IMAGE_FEATURES_remove = " \
    nfs-client \
    nfs-server \
"

IMAGE_INSTALL_append = " \
    connman \
    connman-client \
    tzdata \
"

EXTRA_IMAGE_FEATURES += " read-only-rootfs"