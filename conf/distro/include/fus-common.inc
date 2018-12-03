# Common settings for all F&S boards

UBOOT_ENTRYPOINT = "0x80800000"
UBOOT_ENTRYPOINT_mx6 = "0x10800000"
UBOOT_ENTRYPOINT_mx6sx = "0x80800000"
UBOOT_ENTRYPOINT_mx6ul = "0x80800000"

PREFERRED_PROVIDER_u-boot_mx6 = "u-boot-fus"
PREFERRED_PROVIDER_u-boot_mx6ul = "u-boot-fus"
PREFERRED_PROVIDER_u-boot_mx6sx = "u-boot-fus"

PREFERRED_PROVIDER_virtual/bootloader_mx6 = "u-boot-fus"
PREFERRED_PROVIDER_virtual/bootloader_mx6ul = "u-boot-fus"
PREFERRED_PROVIDER_virtual/bootloader_mx6sx = "u-boot-fus"

PREFERRED_PROVIDER_virtual/kernel_mx6 = "linux-fus"
PREFERRED_PROVIDER_virtual/kernel_mx6ul = "linux-fus"
PREFERRED_PROVIDER_virtual/kernel_mx6sx = "linux-fus"

IMAGE_FSTYPES = "ubifs ext3 sdcard"
MKUBIFS_ARGS = "-m 2048 -e 126976 -c 2048"

# Remove image_types_fsl because there is a awk command which search after a
# point(.) in the devicetrees. But we have 2 points in the devicetree 
# picocom1.2.dtb so the awk command find the first point, so the new name is
# picocom1 instead of picocom1.2. And thats why you get an error at compile 
# time. Thats why we copy the image_types_fsl and rename it as image_types_fus
# and changed the line in the original file from
# "DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F "." '{print $1}'`" to
# "DTS_BASE_NAME=`basename ${DTS_FILE} | awk -F ".dtb" '{print $1}'`"
# The Original file will be find in sources/meta-fsl-arm/classes/
# image_types_fsl.bbclass
IMAGE_CLASSES_remove = "image_types_fsl"
IMAGE_CLASSES += "image_types_fus"
