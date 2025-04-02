SUMMARY = "Silence Commutator Sytadin recipe"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

FILES:${PN}:append = "${THISDIR}/files"
SRC_URI = " \
    git://github.com/gscigala/commutator-sytadin;protocol=https;branch=master \
    file://${BPN}.service \
    file://com.commutator.Sytadin.conf \
"
SRCREV = "3c87ea680c55ca0655381be0a32335c5ee05de15"

S = "${WORKDIR}/git"

inherit setuptools3 systemd

FILES:${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/commutator_sytadin/* \
    ${PYTHON_SITEPACKAGES_DIR}/commutator_sytadin-*.dist-info/* \
"

RDEPENDS:${PN} += " \
    python3-dbus \
    python3-requests \
    python3-beautifulsoup4 \
    python3-sdnotify \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}

    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 644 ${WORKDIR}/com.commutator.Sytadin.conf ${D}${sysconfdir}/dbus-1/system.d/
}

SYSTEMD_SERVICE:${PN} = "${BPN}.service"