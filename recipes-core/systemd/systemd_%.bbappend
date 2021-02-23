do_install_append() {

    # enable time-wait-sync service
    install -d ${D}${sysconfdir}/systemd/system/sysinit.target.wants
    ln -sf ${systemd_unitdir}/system/systemd-time-wait-sync.service \
            ${D}${sysconfdir}/systemd/system/sysinit.target.wants/systemd-time-wait-sync.service
}
