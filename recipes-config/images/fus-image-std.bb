DESCRIPTION = "F&S standard image based on X11 and matchbox"
LICENSE = "MIT"

inherit core-image

## Select Image Features
IMAGE_FEATURES += " \
    splash \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
"

SOC_TOOLS_GPU = ""

SOC_TOOLS_GPU_IMX6QDLSX = " \
    imx-gpu-viv-g2d \
    imx-gpu-viv-tools \
"
SOC_TOOLS_GPU_mx6q  = "${SOC_TOOLS_GPU_IMX6QDLSX}"
SOC_TOOLS_GPU_mx6dl = "${SOC_TOOLS_GPU_IMX6QDLSX}"
SOC_TOOLS_GPU_mx6sx = "${SOC_TOOLS_GPU_IMX6QDLSX}"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    alsa-utils \
    alsa-tools \
    dosfstools \
    evtest \
    e2fsprogs-mke2fs \
    fbset \
    i2c-tools \
    iproute2 \
    memtester \
    ethtool \
    mtd-utils \
    mtd-utils-ubifs \
    lmbench \
    fbset \
    strace \
    ltrace \
    gdb \
    kbd \
    pciutils \
    libsndfile1 \
    libusb1 \
    libxml2 \
    bluez5 \
    canutils \
    iw \
    openssh \
    wpa-supplicant \
    liberation-fonts \
    firmware-imx \
    linux-firmware-wl12xx \
    linux-firmware-wl18xx \
    linux-firmware-sd8787 \
    v4l-utils \
    fs-startscript \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston-init', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'matchbox-keyboard matchbox-keyboard-applet matchbox-keyboard-im matchbox-panel-2 \
    matchbox-desktop matchbox-terminal \
    shutdown-desktop \
    libsdl', '', d)} \
"
