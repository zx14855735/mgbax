package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SqlDownloadCacheService extends Service {
    private static final String xj = "SqlDownloadCacheService";

    public static void xj(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.hf(xj, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        tf et = w.et();
        jk y = et instanceof com.ss.android.socialbase.downloader.impls.u ? ((com.ss.android.socialbase.downloader.impls.u) et).y() : et instanceof jk ? (jk) et : null;
        return y instanceof IBinder ? (IBinder) y : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        w.xj(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (w.tf()) {
            return 2;
        }
        return onStartCommand;
    }
}
