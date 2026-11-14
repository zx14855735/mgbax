package com.ss.android.socialbase.downloader.downloader;

import J3FDQU.A2egSU;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class xj implements qt {
    private static final String kd = "xj";
    protected volatile boolean w;
    private WeakReference<Service> y;
    protected final SparseArray<List<DownloadTask>> xj = new SparseArray<>();
    protected volatile boolean hf = false;
    protected volatile boolean u = false;
    private Handler c = new Handler(Looper.getMainLooper());
    private Runnable f = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.xj.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                com.ss.android.socialbase.downloader.w.xj.hf(xj.kd, "tryDownload: 2 try");
            }
            if (xj.this.hf) {
                return;
            }
            if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                com.ss.android.socialbase.downloader.w.xj.hf(xj.kd, "tryDownload: 2 error");
            }
            xj.this.startService(w.tj(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public boolean hf() {
        com.ss.android.socialbase.downloader.w.xj.w(kd, "isServiceForeground = " + this.w);
        return this.w;
    }

    public void kd() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.xj) {
            com.ss.android.socialbase.downloader.w.xj.hf(kd, "resumePendingTask pendingTasks.size:" + this.xj.size());
            clone = this.xj.clone();
            this.xj.clear();
        }
        com.ss.android.socialbase.downloader.impls.xj z = w.z();
        if (z != null) {
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.ss.android.socialbase.downloader.w.xj.hf(kd, "resumePendingTask key:" + downloadTask.getDownloadId());
                        z.xj(downloadTask);
                    }
                }
            }
        }
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void u() {
        this.hf = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void w() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void xj(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void startService() {
        if (this.hf) {
            return;
        }
        if (com.ss.android.socialbase.downloader.w.xj.xj()) {
            com.ss.android.socialbase.downloader.w.xj.hf(kd, "startService");
        }
        startService(w.tj(), null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void w(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void xj(am amVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void hf(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.hf) {
            if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                com.ss.android.socialbase.downloader.w.xj.hf(kd, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.tf.xj.xj(262144)) {
                xj(downloadTask);
                if (!this.u) {
                    if (com.ss.android.socialbase.downloader.w.xj.xj()) {
                        com.ss.android.socialbase.downloader.w.xj.hf(kd, "tryDownload: 1");
                    }
                    startService(w.tj(), null);
                    this.u = true;
                    return;
                }
                this.c.removeCallbacks(this.f);
                this.c.postDelayed(this.f, 10L);
                return;
            }
            xj(downloadTask);
            startService(w.tj(), null);
            return;
        }
        String str = kd;
        com.ss.android.socialbase.downloader.w.xj.hf(str, "tryDownload when isServiceAlive");
        kd();
        com.ss.android.socialbase.downloader.impls.xj z = w.z();
        if (z != null) {
            com.ss.android.socialbase.downloader.w.xj.hf(str, "tryDownload current task: " + downloadTask.getDownloadId());
            z.xj(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void xj(WeakReference weakReference) {
        this.y = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public boolean xj() {
        return this.hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public IBinder xj(Intent intent) {
        com.ss.android.socialbase.downloader.w.xj.hf(kd, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void xj(int i, Notification notification) {
        WeakReference<Service> weakReference = this.y;
        if (weakReference != null && weakReference.get() != null) {
            String str = kd;
            StringBuilder B9tovu2 = A2egSU.B9tovu(i, "startForeground  id = ", ", service = ");
            B9tovu2.append(this.y.get());
            B9tovu2.append(",  isServiceAlive = ");
            B9tovu2.append(this.hf);
            com.ss.android.socialbase.downloader.w.xj.w(str, B9tovu2.toString());
            try {
                this.y.get().startForeground(i, notification);
                this.w = true;
                return;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                return;
            }
        }
        com.ss.android.socialbase.downloader.w.xj.u(kd, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void xj(boolean z) {
        WeakReference<Service> weakReference = this.y;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.w(kd, "stopForeground  service = " + this.y.get() + ",  isServiceAlive = " + this.hf);
        try {
            this.w = false;
            this.y.get().stopForeground(z);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void xj(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.xj) {
            try {
                String str = kd;
                com.ss.android.socialbase.downloader.w.xj.hf(str, "pendDownloadTask pendingTasks.size:" + this.xj.size() + " downloadId:" + downloadId);
                List<DownloadTask> list = this.xj.get(downloadId);
                if (list == null) {
                    list = new ArrayList<>();
                    this.xj.put(downloadId, list);
                }
                com.ss.android.socialbase.downloader.w.xj.hf(str, "before pendDownloadTask taskArray.size:" + list.size());
                list.add(downloadTask);
                com.ss.android.socialbase.downloader.w.xj.hf(str, "after pendDownloadTask pendingTasks.size:" + this.xj.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.qt
    public void xj(int i) {
        com.ss.android.socialbase.downloader.w.xj.xj(i);
    }
}
