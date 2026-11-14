package com.kwad.framework.filedownloader.download;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    final long arp;
    final long arq;
    final long arr;
    final long contentLength;

    public a(long j, long j2, long j3, long j4) {
        this.arp = j;
        this.arq = j2;
        this.arr = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("range[%d, %d) current offset[%d]", Long.valueOf(this.arp), Long.valueOf(this.arr), Long.valueOf(this.arq));
    }
}
