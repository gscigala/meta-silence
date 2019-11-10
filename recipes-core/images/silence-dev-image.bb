DESCRIPTION = "Silence develop image"

inherit core-image

DISTRO_FEATURES += "wifi"

IMAGE_FEATURES += "\
    package-management \
    ssh-server-openssh \
    debug-tweaks \
"
