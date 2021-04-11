DESCRIPTION = "AirPlay audio player. Shairport Sync adds multi-room capability with Audio Synchronisation"
LICENSE="MIT & BSD"
LIC_FILES_CHKSUM = "file://LICENSES;md5=9f329b7b34fcd334fb1f8e2eb03d33ff"

SRC_URI = " \ 
	git://github.com/mikebrady/shairport-sync.git;protocol=git \
	file://shairport-sync.conf \	
	file://shairport-sync \
	file://shairport-sync.service \
	"

SRCREV = "02cd3f8fdb4f2ba0a601a1d395b558c95a49afa2"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
	--with-alsa \
	--with-stdout \
	--with-ssl=openssl \
	--with-avahi \
	--with-metadata \
"

DEPENDS = " libconfig popt avahi openssl alsa-lib"

inherit autotools pkgconfig update-rc.d systemd

do_install() {
		
	install -d ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}${bindir}/

	install -m 0644 ${WORKDIR}/shairport-sync.conf ${D}${sysconfdir}/
	install -m 0755 ${WORKDIR}/shairport-sync ${D}${sysconfdir}/init.d/
	install -m 0755 ${B}/shairport-sync ${D}${bindir}

	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/shairport-sync.service ${D}${systemd_unitdir}/system
}

INITSCRIPT_NAME = "shairport-sync"
INITSCRIPT_PARAMS = "defaults"

# systemd
SYSTEMD_SERVICE_${PN} = "shairport-sync.service"

FILE_${PN} = "${datadir}/*"
