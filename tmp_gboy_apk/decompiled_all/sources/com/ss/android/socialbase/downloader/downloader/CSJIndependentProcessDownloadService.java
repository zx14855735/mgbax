package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        w.xj(this);
        if (w.wn() == null) {
            w.xj(new ht());
        }
        qt x = w.x();
        this.xj = x;
        x.xj(new WeakReference(this));
    }
}
