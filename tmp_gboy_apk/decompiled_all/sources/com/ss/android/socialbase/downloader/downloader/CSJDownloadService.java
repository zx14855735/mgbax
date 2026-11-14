package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CSJDownloadService extends Service {
    private static final String hf = "CSJDownloadService";
    protected qt xj;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = hf;
        StringBuilder sb = new StringBuilder("onBind downloadServiceHandler != null:");
        sb.append(this.xj != null);
        com.ss.android.socialbase.downloader.w.xj.hf(str, sb.toString());
        qt qtVar = this.xj;
        if (qtVar != null) {
            return qtVar.xj(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        w.xj(this);
        qt io2 = w.io();
        this.xj = io2;
        io2.xj(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.w.xj.xj()) {
            com.ss.android.socialbase.downloader.w.xj.hf(hf, "Service onDestroy");
        }
        qt qtVar = this.xj;
        if (qtVar != null) {
            qtVar.u();
            this.xj = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.w.xj.xj()) {
            com.ss.android.socialbase.downloader.w.xj.hf(hf, "DownloadService onStartCommand");
        }
        this.xj.w();
        ExecutorService pl2 = w.pl();
        if (pl2 != null) {
            pl2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    qt qtVar = CSJDownloadService.this.xj;
                    if (qtVar != null) {
                        qtVar.xj(intent, i, i2);
                    }
                }
            });
        }
        return w.tf() ? 2 : 3;
    }
}
