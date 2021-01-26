DESCRIPTION = "Silence connected-clock with cron image"
LICENSE = "GPLv3"

require silence-image.bb

IMAGE_INSTALL_append = " \
    connected-clock-with-cron \
"