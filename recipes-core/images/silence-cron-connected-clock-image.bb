DESCRIPTION = "Silence connected-clock with cron image"
LICENSE = "GPLv3"

require silence-image.bb

IMAGE_INSTALL:append = " \
    connected-clock-with-cron \
"