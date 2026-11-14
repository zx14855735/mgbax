package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.kd;
import com.ss.android.socialbase.downloader.d.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.tf.y;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadNotificationService extends Service {
    private static volatile long c = 0;
    private static long d = 900;
    private static boolean f = false;
    private static int hf = -1;
    private static boolean kd = false;
    private static boolean u = true;
    private static int w = -1;
    private static final String xj = "DownloadNotificationService";
    private static volatile long y;
    private final SparseArray<Notification> p = new SparseArray<>(2);
    private c tf;

    private void u() {
        if (this.tf == null) {
            c cVar = new c("DownloaderNotifyThread");
            this.tf = cVar;
            cVar.xj();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        u();
        w.xj(this);
        com.ss.android.socialbase.downloader.f.xj w2 = com.ss.android.socialbase.downloader.f.xj.w();
        int xj2 = w2.xj("download_service_foreground", 0);
        if ((xj2 == 1 || xj2 == 3) && hf == -1) {
            hf = 0;
        }
        if ((xj2 == 2 || xj2 == 3) && w == -1) {
            w = 0;
        }
        kd = w2.hf("non_going_notification_foreground", false);
        f = w2.hf("notify_too_fast", false);
        long xj3 = w2.xj("notification_time_window", 900L);
        d = xj3;
        if (xj3 < 0 || xj3 > 1200) {
            d = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.tf;
        if (cVar != null) {
            try {
                cVar.hf();
            } catch (Throwable unused) {
            }
            this.tf = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        xj(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0026, code lost:
    
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.w == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hf(android.app.NotificationManager r6, int r7, android.app.Notification r8) {
        /*
            r5 = this;
            boolean r0 = r5.xj(r7, r8)
            if (r0 == 0) goto L76
            com.ss.android.socialbase.downloader.downloader.u r0 = com.ss.android.socialbase.downloader.downloader.u.xj()     // Catch: java.lang.Throwable -> L18
            int r0 = r0.xj(r7)     // Catch: java.lang.Throwable -> L18
            r1 = 1
            if (r0 != r1) goto L1a
            boolean r0 = com.ss.android.socialbase.downloader.tf.y.w()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            goto L1b
        L18:
            r0 = move-exception
            goto L72
        L1a:
            r1 = 0
        L1b:
            if (r1 != 0) goto L22
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.hf     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L22
            goto L28
        L22:
            if (r1 == 0) goto L8b
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.w     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L8b
        L28:
            com.ss.android.socialbase.downloader.downloader.u r0 = com.ss.android.socialbase.downloader.downloader.u.xj()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.downloader.g r0 = r0.w(r7)     // Catch: java.lang.Throwable -> L18
            boolean r2 = r0.c()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L62
            boolean r2 = r0.hf()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L62
            java.lang.String r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.xj     // Catch: java.lang.Throwable -> L18
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "doNotify, startForeground, ======== id = "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r7)     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = ", isIndependentProcess = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L18
            r3.append(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.w.xj.w(r2, r3)     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L5c
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.w = r7     // Catch: java.lang.Throwable -> L18
            goto L5e
        L5c:
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.hf = r7     // Catch: java.lang.Throwable -> L18
        L5e:
            r0.xj(r7, r8)     // Catch: java.lang.Throwable -> L18
            goto L8b
        L62:
            java.lang.String r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.xj     // Catch: java.lang.Throwable -> L18
            java.lang.String r2 = "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = r2.concat(r1)     // Catch: java.lang.Throwable -> L18
            com.ss.android.socialbase.downloader.w.xj.w(r0, r1)     // Catch: java.lang.Throwable -> L18
            goto L8b
        L72:
            com.bytedance.sdk.component.utils.pl.xj(r0)
            goto L8b
        L76:
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.hf
            if (r0 == r7) goto L7e
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.w
            if (r0 != r7) goto L8b
        L7e:
            boolean r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.kd
            if (r0 == 0) goto L8b
            int r0 = r8.flags
            r0 = r0 & 2
            if (r0 != 0) goto L8b
            r5.hf(r6, r7)
        L8b:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9a
            long r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.y     // Catch: java.lang.Throwable -> L9a
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L97
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.y = r0     // Catch: java.lang.Throwable -> L9a
        L97:
            r6.notify(r7, r8)     // Catch: java.lang.Throwable -> L9a
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.hf(android.app.NotificationManager, int, android.app.Notification):void");
    }

    private void xj(final Intent intent) {
        c cVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (cVar = this.tf) == null) {
            return;
        }
        cVar.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (!action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                        if (intExtra != 0) {
                            DownloadNotificationService.this.hf(notificationManager, intExtra);
                            return;
                        }
                        return;
                    }
                    if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception e) {
                                pl.xj(e);
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (y.xj((Context) DownloadNotificationService.this, g.b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(kd.xj)) {
                                arrayList.add(kd.xj);
                            }
                            arrayList.add("mime_type_plg");
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        pl.xj(e2);
                        return;
                    }
                }
                final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.f) {
                            DownloadNotificationService.this.xj(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.hf(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (DownloadNotificationService.f) {
                        DownloadNotificationService.this.xj(notificationManager, intExtra, notification);
                        return;
                    } else {
                        if (DownloadNotificationService.this.tf != null) {
                            DownloadNotificationService.this.tf.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.hf(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (Downloader.getInstance(w.tj()).isDownloading(intExtra)) {
                    DownloadInfo downloadInfo = Downloader.getInstance(w.tj()).getDownloadInfo(intExtra);
                    if (!DownloadNotificationService.f) {
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.hf(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.c <= DownloadNotificationService.d) {
                        return;
                    }
                    DownloadNotificationService.this.hf(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.p) {
            try {
                int indexOfKey = this.p.indexOfKey(i);
                if (indexOfKey >= 0 && indexOfKey < this.p.size()) {
                    this.p.setValueAt(indexOfKey, notification);
                    return;
                }
                long currentTimeMillis = d - (System.currentTimeMillis() - y);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis > 20000) {
                    currentTimeMillis = 20000;
                }
                long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
                c = currentTimeMillis2;
                y = currentTimeMillis2;
                if (currentTimeMillis <= 0) {
                    hf(notificationManager, i, notification);
                } else if (this.tf != null) {
                    synchronized (this.p) {
                        this.p.put(i, notification);
                    }
                    this.tf.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadNotificationService.this.xj(notificationManager, i);
                        }
                    }, currentTimeMillis);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(NotificationManager notificationManager, int i) {
        boolean z;
        xj xjVar;
        int xj2;
        int i2 = hf;
        if (i2 != i && w != i) {
            try {
                notificationManager.cancel(i);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i2 == i) {
            hf = 0;
            z = false;
        } else {
            w = 0;
            z = true;
        }
        try {
            com.ss.android.socialbase.downloader.downloader.g w2 = u.xj().w(i);
            if (!w2.hf()) {
                u = false;
                com.ss.android.socialbase.downloader.w.xj.u(xj, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
            }
            com.ss.android.socialbase.downloader.w.xj.w(xj, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
            w2.xj(false, true);
        } catch (Throwable th) {
            pl.xj(th);
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused2) {
        }
        if (u) {
            try {
                SparseArray<xj> hf2 = hf.xj().hf();
                if (hf2 != null) {
                    for (int size = hf2.size() - 1; size >= 0; size--) {
                        xjVar = hf2.valueAt(size);
                        if (xjVar != null && (xj2 = xjVar.xj()) != i && xj2 != hf && xj2 != w && xjVar.f()) {
                            if ((u.xj().xj(xjVar.xj()) == 1 && !y.w()) == z) {
                                break;
                            }
                        }
                    }
                }
                xjVar = null;
                if (xjVar != null) {
                    int xj3 = xjVar.xj();
                    try {
                        notificationManager.cancel(xj3);
                    } catch (Throwable th2) {
                        pl.xj(th2);
                    }
                    if (Downloader.getInstance(this).getStatus(xj3) != 1) {
                        z2 = false;
                    }
                    com.ss.android.socialbase.downloader.w.xj.w(xj, "doCancel, updateNotification id = ".concat(String.valueOf(xj3)));
                    xjVar.xj((BaseException) null, z2);
                }
            } catch (Throwable th3) {
                pl.xj(th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.p) {
            notification = this.p.get(i);
            this.p.remove(i);
        }
        if (notification != null) {
            hf(notificationManager, i, notification);
        }
    }

    private boolean xj(int i, Notification notification) {
        int i2;
        int i3;
        String channelId;
        if (!u || (i2 = hf) == i || (i3 = w) == i) {
            return false;
        }
        if (i2 != 0 && i3 != 0) {
            return false;
        }
        if (kd && (notification.flags & 2) == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        channelId = notification.getChannelId();
        return !TextUtils.isEmpty(channelId);
    }
}
