package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface qt<T extends CSJDownloadService> {
    void hf(DownloadTask downloadTask);

    boolean hf();

    void startService();

    void u();

    void w();

    void w(DownloadTask downloadTask);

    IBinder xj(Intent intent);

    void xj(int i);

    void xj(int i, Notification notification);

    void xj(Intent intent, int i, int i2);

    void xj(am amVar);

    void xj(WeakReference<T> weakReference);

    void xj(boolean z);

    boolean xj();
}
