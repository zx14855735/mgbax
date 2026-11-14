package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus apZ;

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus Al = ((DownloadServiceConnectChangedEvent) bVar).Al();
        this.apZ = Al;
        if (Al == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            yO();
            return false;
        }
        yP();
        return false;
    }

    public abstract void yO();

    public abstract void yP();

    public final DownloadServiceConnectChangedEvent.ConnectStatus yQ() {
        return this.apZ;
    }
}
