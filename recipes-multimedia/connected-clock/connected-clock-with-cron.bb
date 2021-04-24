SUMMARY = "Silence recipe to activate connected-clock with cron"
LICENSE = "GPL-3.0-only"

RDEPENDS:${PN} = "connected-clock cronie"

do_install() {
        install -d ${D}${sysconfdir}/cron.d
        cat >> ${D}${sysconfdir}/cron.d/connected-clock.crontab <<EOF
#  m  h  dom mon dow user       command
  50  6    *  *  *   root       ${base_bindir}/systemctl start connected-clock
  10  0    *  *  *   root       ${base_bindir}/systemctl stop  connected-clock
EOF
}