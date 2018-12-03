DESCRIPTON = "F&S Startup scripts"
LICENSE = "MIT"

#default license in /mnt/yocto/fsl-release-bsp-l4.1.15_2.0.0-ga/sources/poky/LICENSE
#LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

SRC_URI = "file://fsdistro-wayland.sh \
	   file://fsdistro-x11.sh \
	   file://fsalias.sh \
"

HAS_WAYLAND = "${@bb.utils.contains("DISTRO_FEATURES", "wayland", "yes", "no", d)}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/fsalias.sh   ${D}${sysconfdir}/profile.d/
    
    if [ "${HAS_WAYLAND}" = "yes" ]; then
	install -m 0755 ${WORKDIR}/fsdistro-wayland.sh  ${D}${sysconfdir}/profile.d/
    else
	install -m 0755 ${WORKDIR}/fsdistro-x11.sh  ${D}${sysconfdir}/profile.d/
    fi
}