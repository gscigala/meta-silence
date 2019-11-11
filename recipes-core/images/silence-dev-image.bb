DESCRIPTION = "Silence develop image"

inherit core-image

DISTRO_FEATURES_append = " \
    bluez5 \
    bluetooth \
    wifi \
"

IMAGE_FEATURES += " \
    package-management \
    ssh-server-openssh \
    debug-tweaks \
"

IMAGE_INSTALL_append = " \
    linux-firmware-bcm43430 \
    bluez5 \
    i2c-tools \
    python-smbus \
    bridge-utils \
    hostapd \
    dhcp-server \
    iptables \
    wpa-supplicant \
"
