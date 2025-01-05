SUMMARY = "Silence Commutator Vigicrues recipe"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

FILES:${PN}:append = "${THISDIR}/files"
SRC_URI = " \
    git://github.com/gscigala/commutator-vigicrues;protocol=https;branch=master \
    file://commutator-vigicrues.service \
    file://com.commutator.Vigicrues.conf \
"
SRCREV = "e208142146b2ab0da673ae3c98273eebc312ffd1"

S = "${WORKDIR}/git"

inherit setuptools3 systemd

FILES:${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/commutator_vigicrues/* \
    ${PYTHON_SITEPACKAGES_DIR}/commutator_vigicrues-*.dist-info/* \
"

RDEPENDS:${PN} += "python3-dbus python3-pyvigicrues"

do_configure:append() {
    sed -i "s/%%STATIONID%%/${SILENCE_COMMUTATOR_VIGICRUES_STATION_ID}/" ${WORKDIR}/commutator-vigicrues.service
}

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/commutator-vigicrues.service ${D}${systemd_system_unitdir}

    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 644 ${WORKDIR}/com.commutator.Vigicrues.conf ${D}${sysconfdir}/dbus-1/system.d/
}

SYSTEMD_SERVICE:${PN} = "commutator-vigicrues.service"