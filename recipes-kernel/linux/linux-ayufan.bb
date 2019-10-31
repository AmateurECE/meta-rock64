# Copyright (C) 2019 Leonardo Urrego
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Rock64 kernel"
DESCRIPTION = "Rock64 machine kernel"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

# LINUX_VERSION = "4.4.167"
# SRC_URI = "git://github.com/ayufan-rock64/linux-kernel.git;protocol=https;branch=release-4.4.167"
# SRCREV = "63f19620adb5ae098acc00f78a9c623fa4b070e8"

LINUX_VERSION = "4.4.190"
SRC_URI = "git://github.com/ayufan-rock64/linux-kernel.git;protocol=https;branch=release-4.4.190"
SRCREV = "4.4.190-1233-rockchip-ayufan"

# SRC_URI += "file://defconfig"

require recipes-kernel/linux/linux-yocto.inc

# DEPENDS += "openssl-native"
# DEPENDS += "coreutils-native"

# Override local version in order to use the one generated by linux build system
# And not "yocto-standard"
# LINUX_VERSION_EXTENSION = ""
# PR = "r1"
# PV = "${LINUX_VERSION}+git${SRCPV}"
PV = "${LINUX_VERSION}"

S = "${WORKDIR}/git"

KCONFIG_MODE="--alldefconfig"

# KERNEL_DEFCONFIG = "${WORKDIR}/defconfig"

COMPATIBLE_MACHINE = "(rock64)"

FILES_${KERNEL_PACKAGE_NAME}-base += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"
deltask kernel_configme
