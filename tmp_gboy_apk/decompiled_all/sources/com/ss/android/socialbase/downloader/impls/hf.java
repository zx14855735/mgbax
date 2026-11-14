package com.ss.android.socialbase.downloader.impls;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements com.ss.android.socialbase.downloader.downloader.c {
    @Override // com.ss.android.socialbase.downloader.downloader.c
    public int xj(int i, com.ss.android.socialbase.downloader.network.pl plVar) {
        if (plVar.ordinal() <= com.ss.android.socialbase.downloader.network.pl.MODERATE.ordinal()) {
            return 1;
        }
        return plVar == com.ss.android.socialbase.downloader.network.pl.GOOD ? i - 1 : i;
    }
}
