# Copyright (C) 2014 O.S. Systems Software LTDA.

DESCRIPTION = "Target packages for F&S Qt5 SDK"
LICENSE = "MIT"

inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

# Requires Wayland to work
USE_WAYLAND = " \
    qtwayland-dev \
    qtwayland-mkspecs \
    qtwayland-plugins \
    qtwayland-tools \
"

# Requires X11 to work
USE_X11 = " \
    qtx11extras-dev \
    qtx11extras-mkspecs \
"

RDEPENDS_${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qt3d-dev', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qt3d-mkspecs', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qt3d-qmlplugins', '', d)} \
    qtbase-dev \
    qtbase-fonts \
    qtbase-mkspecs \
    qtbase-plugins \
    qtconnectivity-dev \
    qtconnectivity-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtconnectivity-qmlplugins', '', d)} \
    qtenginio-dev \
    qtenginio-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtenginio-qmlplugins', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtgraphicaleffects-qmlplugins', '', d)} \
    qtimageformats-dev \
    qtimageformats-plugins \
    qtlocation-dev \
    qtlocation-mkspecs \
    qtlocation-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtlocation-qmlplugins', '', d)} \
    qtmultimedia-dev \
    qtmultimedia-mkspecs \
    qtmultimedia-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtmultimedia-qmlplugins', '', d)} \
    qtscript-dev \
    qtscript-mkspecs \
    qtsensors-dev \
    qtsensors-mkspecs \
    qtsensors-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtsensors-qmlplugins', '', d)} \
    qtserialport-dev \
    qtserialport-mkspecs \
    qtsvg-dev \
    qtsvg-mkspecs \
    qtsvg-plugins \
    qtsystems-dev \
    qtsystems-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtsystems-qmlplugins', '', d)} \
    qttools-dev \
    qttools-mkspecs \
    qttools-staticdev \
    qttools-tools \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '${USE_WAYLAND}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '${USE_X11}', '', d)} \
    qtwebsockets-dev \
    qtwebsockets-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtwebsockets-qmlplugins', '', d)} \
    qtwebchannel-dev \
    qtwebchannel-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtwebchannel-qmlplugins', '', d)} \
    qtxmlpatterns-dev \
    qtxmlpatterns-mkspecs \
"

RRECOMMENDS_${PN} += " \
    qtquickcontrols-qmlplugins \
    qttools-plugins \
"