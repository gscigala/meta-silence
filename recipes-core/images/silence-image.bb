SUMMARY = "Silence image image"
LICENSE = "GPL-3.0-only"

include recipes-core/images/core-image-base.bb

IMAGE_FEATURES:remove = " \
    nfs-client \
    nfs-server \
"

IMAGE_INSTALL:append = " \
    connman \
    connman-client \
    tzdata \
"

EXTRA_IMAGE_FEATURES += " read-only-rootfs"