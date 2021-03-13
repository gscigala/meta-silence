DESCRIPTION = "Silence connected-clock with cron image"
LICENSE = "MIT"

require silence-image.bb

IMAGE_INSTALL_append = " \
    connected-clock-with-cron \
"