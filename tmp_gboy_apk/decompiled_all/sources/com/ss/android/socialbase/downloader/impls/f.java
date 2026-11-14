package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends com.ss.android.socialbase.downloader.downloader.xj {
    private static final String kd = "f";

    @Override // com.ss.android.socialbase.downloader.downloader.xj
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.hf = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public void w() {
        if (com.ss.android.socialbase.downloader.tf.xj.xj(262144)) {
            this.hf = true;
            this.u = false;
            if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                com.ss.android.socialbase.downloader.w.xj.hf(kd, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.xj, com.ss.android.socialbase.downloader.downloader.qt
    public void xj(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.w.xj.xj()) {
            com.ss.android.socialbase.downloader.w.xj.hf(kd, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.tf.xj.xj(262144)) {
            this.hf = true;
        }
        kd();
    }
}
