SUMMARY = "Silence recipe to activate connected-clock with cron"
LICENSE = "GPLv3"

RDEPENDS_${PN} = "connected-clock cronie"

do_install() {
        install -d ${D}${sysconfdir}/cron.d
        cat >> ${D}${sysconfdir}/cron.d/connected-clock.crontab <<EOF
#  m  h  dom mon dow user       command
  50  7    *  *  *   root       ${base_bindir}/systemctl start connected-clock
  10  0    *  *  *   root       ${base_bindir}/systemctl stop  connected-clock
EOF
}