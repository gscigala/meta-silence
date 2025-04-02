SUMMARY = "Silence Commutator IDFM line reports recipe"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

FILES:${PN}:append = "${THISDIR}/files"
SRC_URI = " \
    git://github.com/gscigala/commutator-idfm-line-reports;protocol=https;branch=master \
    file://${BPN}.service \
    file://com.commutator.IdfmLineReports.conf \
"
SRCREV = "e01eb40b98f3a448542a6376e7153787bd42d314"

S = "${WORKDIR}/git"

inherit setuptools3 systemd

FILES:${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/commutator_idfm_line_reports/* \
    ${PYTHON_SITEPACKAGES_DIR}/commutator_idfm_line_reports-*.dist-info/* \
"

RDEPENDS:${PN} += " \
    python3-dbus \
    python3-requests \
    python3-sdnotify \
"

do_configure:append() {
    sed -i "s/%%TOKEN%%/${SILENCE_COMMUTATOR_IDFM_LINE_REPORTS_TOKEN}/" ${WORKDIR}/${BPN}.service
}

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}

    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 644 ${WORKDIR}/com.commutator.IdfmLineReports.conf ${D}${sysconfdir}/dbus-1/system.d/
}

SYSTEMD_SERVICE:${PN} = "${BPN}.service"