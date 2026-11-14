package com.ss.android.socialbase.downloader.c;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.kd;
import com.ss.android.socialbase.downloader.d.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.tf.y;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private static volatile xj c;
    private volatile long hf;
    private volatile c u;
    private volatile long xj;
    private long w = 1000;
    private final SparseArray<Notification> kd = new SparseArray<>(2);
    private AtomicBoolean y = new AtomicBoolean(false);

    public void hf() {
        if (this.y.compareAndSet(false, true)) {
            this.u = new c("DownloaderNotifyThread");
            this.u.xj();
            long xj = com.ss.android.socialbase.downloader.f.xj.w().xj("notification_time_window", 1000L);
            this.w = xj;
            if (xj < 0 || xj > 1200) {
                this.w = 1000L;
            }
        }
    }

    public static xj xj() {
        if (c == null) {
            synchronized (xj.class) {
                try {
                    if (c == null) {
                        c = new xj();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        DownloadInfo downloadInfo;
        Context tj = w.tj();
        if (tj == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) tj.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 != -2 && intExtra2 != -3) {
                    xj(notificationManager, intExtra, notification);
                    return;
                } else {
                    xj(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (Downloader.getInstance(w.tj()).isDownloading(intExtra) && (downloadInfo = Downloader.getInstance(w.tj()).getDownloadInfo(intExtra)) != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - this.hf > this.w) {
                hf(notificationManager, intExtra, notification);
                downloadInfo.setLastNotifyProgressTime();
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                hf(notificationManager, intExtra);
                return;
            }
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            try {
                if (y.xj(tj, g.b) && (connectivityManager = (ConnectivityManager) tj.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(kd.xj)) {
                        arrayList.add(kd.xj);
                    }
                    arrayList.add("mime_type_plg");
                    Downloader.getInstance(tj).restartAllFailedDownloadTasks(arrayList);
                    Downloader.getInstance(tj).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                    return;
                }
                return;
            } catch (Exception e) {
                pl.xj(e);
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                Downloader.getInstance(w.tj()).pauseAll();
            } catch (Exception e2) {
                pl.xj(e2);
            }
        }
    }

    public void xj(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        hf();
        if (this.u == null) {
            return;
        }
        this.u.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.xj.1
            @Override // java.lang.Runnable
            public void run() {
                xj.this.hf(intent);
            }
        });
    }

    private void xj(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.kd) {
            try {
                int indexOfKey = this.kd.indexOfKey(i);
                if (indexOfKey >= 0 && indexOfKey < this.kd.size()) {
                    this.kd.setValueAt(indexOfKey, notification);
                    return;
                }
                long currentTimeMillis = this.w - (System.currentTimeMillis() - this.xj);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis > 20000) {
                    currentTimeMillis = 20000;
                }
                long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
                this.hf = currentTimeMillis2;
                this.xj = currentTimeMillis2;
                if (currentTimeMillis <= 0) {
                    hf(notificationManager, i, notification);
                } else if (this.u != null) {
                    synchronized (this.kd) {
                        this.kd.put(i, notification);
                    }
                    this.u.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.c.xj.2
                        @Override // java.lang.Runnable
                        public void run() {
                            xj.this.xj(notificationManager, i);
                        }
                    }, currentTimeMillis);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.kd) {
            notification = this.kd.get(i);
            this.kd.remove(i);
        }
        if (notification != null) {
            hf(notificationManager, i, notification);
        }
    }

    private void hf(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.xj < currentTimeMillis) {
                this.xj = currentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    private void hf(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused) {
        }
    }
}
