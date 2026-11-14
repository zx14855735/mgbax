package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.d.f;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class xj implements f.xj {
    private final SparseArray<DownloadTask> hf = new SparseArray<>();
    private final SparseArray<DownloadTask> w = new SparseArray<>();
    private final SparseArray<DownloadTask> u = new SparseArray<>();
    private final SparseArray<DownloadTask> kd = new SparseArray<>();
    private final SparseArray<DownloadTask> y = new SparseArray<>();
    private final SparseArray<SparseArray<DownloadTask>> c = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.tf.f<Integer, DownloadTask> f = new com.ss.android.socialbase.downloader.tf.f<>();
    private final SparseArray<Long> d = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> tf = new LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.d.f xj = new com.ss.android.socialbase.downloader.d.f(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.tf p = com.ss.android.socialbase.downloader.downloader.w.et();

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask qt(int i) {
        DownloadTask downloadTask = this.hf.get(i);
        return (downloadTask == null && (downloadTask = this.u.get(i)) == null && (downloadTask = this.w.get(i)) == null && (downloadTask = this.kd.get(i)) == null) ? this.y.get(i) : downloadTask;
    }

    private void w(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.tf.isEmpty()) {
                xj(downloadTask, true);
                this.tf.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_TAIL) {
                DownloadTask first = this.tf.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && xj(downloadTask.getDownloadId())) {
                    return;
                }
                kd(first.getDownloadId());
                xj(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.tf.putFirst(downloadTask);
                    return;
                }
                return;
            }
            if (this.tf.getFirst().getDownloadId() == downloadTask.getDownloadId() && xj(downloadTask.getDownloadId())) {
                return;
            }
            Iterator<DownloadTask> it = this.tf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadTask next = it.next();
                if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                    it.remove();
                    break;
                }
            }
            this.tf.put(downloadTask);
            new com.ss.android.socialbase.downloader.downloader.y(downloadTask, this.xj).xj();
        } catch (InterruptedException unused) {
        }
    }

    private void zg(int i) {
        DownloadTask first;
        if (this.tf.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.tf.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.tf.poll();
        }
        if (this.tf.isEmpty() || (first = this.tf.getFirst()) == null) {
            return;
        }
        xj(first, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r1.u.get(r2) != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean am(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L1b
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.hf     // Catch: java.lang.Throwable -> L14
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L16
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.u     // Catch: java.lang.Throwable -> L14
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L1b
            goto L16
        L14:
            r2 = move-exception
            goto L19
        L16:
            monitor-exit(r1)
            r2 = 1
            return r2
        L19:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L14
            throw r2
        L1b:
            monitor-exit(r1)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.xj.am(int):boolean");
    }

    public synchronized boolean c(int i) {
        try {
            DownloadTask downloadTask = this.u.get(i);
            if (downloadTask == null) {
                downloadTask = this.kd.get(i);
            }
            if (downloadTask == null) {
                return false;
            }
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            xj(downloadTask);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized io d(int i) {
        DownloadTask downloadTask = this.hf.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.w.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.u.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.kd.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.y.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized j f(int i) {
        DownloadTask downloadTask = this.hf.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.w.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.u.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.kd.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.y.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public synchronized void g(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.hf.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            xj(downloadTask);
        }
    }

    public abstract void hf(int i);

    public synchronized boolean kd(int i) {
        com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        DownloadInfo hf = this.p.hf(i);
        if (hf != null && hf.getStatus() == 11) {
            return false;
        }
        synchronized (this.hf) {
            hf(i);
        }
        if (hf == null) {
            DownloadTask downloadTask = this.hf.get(i);
            if (downloadTask != null) {
                new com.ss.android.socialbase.downloader.downloader.y(downloadTask, this.xj).u();
                return true;
            }
        } else {
            xj(hf);
            if (hf.getStatus() == 1) {
                DownloadTask downloadTask2 = this.hf.get(i);
                if (downloadTask2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.y(downloadTask2, this.xj).u();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(hf.getStatus())) {
                hf.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean p(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.kd.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                xj(downloadTask, false);
            }
            return true;
        }
        DownloadInfo hf = this.p.hf(i);
        if (hf != null && hf.canStartRetryDelayTask()) {
            xj(new DownloadTask(hf), false);
        }
        return false;
    }

    public synchronized boolean pl(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.y.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            xj(downloadTask);
        }
        return true;
    }

    public synchronized IDownloadFileUriProvider tf(int i) {
        DownloadTask downloadTask = this.hf.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.w.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.u.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.kd.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.y.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized DownloadInfo u(int i) {
        DownloadInfo hf;
        DownloadTask downloadTask;
        hf = this.p.hf(i);
        if (hf == null && (downloadTask = this.hf.get(i)) != null) {
            hf = downloadTask.getDownloadInfo();
        }
        return hf;
    }

    public abstract com.ss.android.socialbase.downloader.d.w w(int i);

    public abstract List<Integer> xj();

    public abstract void xj(int i, long j);

    public abstract void xj(int i, DownloadTask downloadTask);

    public abstract void xj(com.ss.android.socialbase.downloader.d.w wVar);

    public abstract boolean xj(int i);

    public synchronized boolean y(int i) {
        try {
            DownloadTask downloadTask = this.hf.get(i);
            if (downloadTask != null) {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                if (downloadInfo != null) {
                    downloadInfo.setDownloadFromReserveWifi(false);
                }
                xj(downloadTask);
            } else {
                c(i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    private void hf(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.c.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.c.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void xj(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.ss.android.socialbase.downloader.u.xj.xj(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.tf.y.w(com.ss.android.socialbase.downloader.downloader.w.tj()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.y(downloadTask, this.xj).xj(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            xj(downloadInfo);
        }
        if (this.u.get(id) != null) {
            this.u.remove(id);
        }
        if (this.w.get(id) != null) {
            this.w.remove(id);
        }
        if (this.kd.get(id) != null) {
            this.kd.remove(id);
        }
        if (this.y.get(id) != null) {
            this.y.remove(id);
        }
        if (xj(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.u.xj.xj(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(id)));
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.xj.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.tf.xj.xj(32768) && (remove = this.f.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.hf.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i = 0;
        } else {
            i = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + i);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        hf(downloadTask);
        this.hf.put(id, downloadTask);
        this.d.put(id, Long.valueOf(uptimeMillis));
        xj(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(int i, boolean z) {
        com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            DownloadInfo hf = this.p.hf(i);
            if (hf != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.tf.y.xj(hf);
                } else {
                    com.ss.android.socialbase.downloader.tf.y.w(hf.getTempPath(), hf.getTempName());
                }
                hf.erase();
            }
            try {
                this.p.y(i);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            xj(i, 0, -4);
            if (this.u.get(i) != null) {
                this.u.remove(i);
            }
            if (this.w.get(i) != null) {
                this.w.remove(i);
            }
            this.f.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.f.xj.hf(i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public synchronized void hf(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (com.ss.android.socialbase.downloader.tf.y.hf(com.ss.android.socialbase.downloader.downloader.w.tj())) {
                for (int i = 0; i < this.hf.size(); i++) {
                    DownloadTask downloadTask = this.hf.get(this.hf.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && hf(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        xj(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.ss.android.socialbase.downloader.downloader.yo reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.xj(downloadInfo, 5, 2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void w(final int i, final boolean z) {
        DownloadInfo hf = this.p.hf(i);
        if (hf != null) {
            xj(hf);
        }
        this.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.xj.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.hf.xj().y(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.w.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.xj.5
            @Override // java.lang.Runnable
            public void run() {
                xj.this.w(i);
                xj.this.kd(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(int i, boolean z) {
        try {
            DownloadInfo hf = this.p.hf(i);
            if (hf != null) {
                com.ss.android.socialbase.downloader.tf.y.xj(hf, z);
                hf.erase();
            }
            try {
                this.p.u(i);
                this.p.xj(hf);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            if (this.u.get(i) != null) {
                this.u.remove(i);
            }
            if (this.w.get(i) != null) {
                this.w.remove(i);
            }
            this.f.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.f.xj.hf(i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private boolean hf(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void hf() {
        List<Integer> xj = xj();
        if (xj == null) {
            return;
        }
        Iterator<Integer> it = xj.iterator();
        while (it.hasNext()) {
            kd(it.next().intValue());
        }
    }

    public void hf(final int i, final boolean z) {
        DownloadInfo hf = this.p.hf(i);
        if (hf != null) {
            xj(hf);
        }
        this.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.xj.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.hf.xj().y(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.w.xj(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.xj.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask qt;
                if (xj.this.w(i) == null && (qt = xj.this.qt(i)) != null) {
                    DownloadInfo downloadInfo = qt.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = qt.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                try {
                                    IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                                    if (iDownloadListener != null) {
                                        iDownloadListener.onCanceled(downloadInfo);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                xj.this.u(i, z);
            }
        }, false);
    }

    public synchronized void hf(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        xj(i, i2, iDownloadListener, yVar, z, true);
    }

    public List<DownloadInfo> hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = xj().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo u = u(it.next().intValue());
            if (u != null && str.equals(u.getMimeType())) {
                arrayList.add(u);
            }
        }
        return arrayList;
    }

    public synchronized void xj(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            w(downloadTask);
        } else {
            xj(downloadTask, true);
        }
    }

    public void hf(int i, long j) {
        DownloadInfo hf = this.p.hf(i);
        if (hf != null) {
            hf.setThrottleNetSpeed(j);
        }
        xj(i, j);
    }

    public synchronized List<DownloadInfo> xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> xj = this.p.xj(str);
        if (xj != null && !xj.isEmpty()) {
            return xj;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hf.size();
        for (int i = 0; i < size; i++) {
            DownloadTask valueAt = this.hf.valueAt(i);
            if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                arrayList.add(valueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean xj(int i, boolean z) {
        try {
            DownloadTask downloadTask = this.hf.get(i);
            if (downloadTask == null && com.ss.android.socialbase.downloader.tf.xj.xj(65536)) {
                downloadTask = qt(i);
            }
            if (downloadTask != null) {
                if (!com.ss.android.socialbase.downloader.f.xj.xj(i).hf("fix_on_cancel_call_twice", true)) {
                    new com.ss.android.socialbase.downloader.downloader.y(downloadTask, this.xj).w();
                }
                final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                final SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.MAIN);
                final SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.NOTIFICATION);
                this.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.xj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SparseArray sparseArray;
                        SparseArray sparseArray2 = downloadListeners;
                        if (sparseArray2 != null) {
                            synchronized (sparseArray2) {
                                for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                    try {
                                        IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i2));
                                        if (iDownloadListener != null) {
                                            iDownloadListener.onCanceled(downloadInfo);
                                        }
                                    } finally {
                                    }
                                }
                            }
                        }
                        DownloadInfo downloadInfo2 = downloadInfo;
                        if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                            return;
                        }
                        synchronized (sparseArray) {
                            for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                                try {
                                    IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                                    if (iDownloadListener2 != null) {
                                        iDownloadListener2.onCanceled(downloadInfo);
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                });
            }
            DownloadInfo hf = this.p.hf(i);
            if (com.ss.android.socialbase.downloader.tf.xj.xj(65536)) {
                if (hf != null) {
                    hf.setStatus(-4);
                }
            } else if (hf != null && DownloadStatus.isDownloading(hf.getStatus())) {
                hf.setStatus(-4);
            }
            hf(i, z);
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    private void xj(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() != 7 && downloadInfo.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.c.DELAY_RETRY_NONE) {
                    return;
                }
                downloadInfo.setStatus(5);
                downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.c.DELAY_RETRY_NONE);
                com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "cancelAlarm");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
    }

    public synchronized void xj(int i, io ioVar) {
        DownloadTask downloadTask = this.hf.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(ioVar);
        }
    }

    public synchronized void xj(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            try {
                boolean hf = com.ss.android.socialbase.downloader.tf.xj.xj(1048576) ? com.ss.android.socialbase.downloader.tf.y.hf(com.ss.android.socialbase.downloader.downloader.w.tj()) : true;
                for (int i = 0; i < this.u.size(); i++) {
                    DownloadTask downloadTask = this.u.get(this.u.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || hf)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        xj(downloadTask);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void xj(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        try {
            DownloadTask qt = qt(i);
            if (qt == null) {
                qt = this.f.get(Integer.valueOf(i));
            }
            if (qt != null) {
                qt.removeDownloadListener(i2, iDownloadListener, yVar, z);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void xj(int i, int i2, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z, boolean z2) {
        DownloadInfo hf;
        try {
            DownloadTask qt = qt(i);
            if (qt != null) {
                qt.addDownloadListener(i2, iDownloadListener, yVar, z);
                final DownloadInfo downloadInfo = qt.getDownloadInfo();
                if (z2) {
                    if (downloadInfo != null) {
                        if (!xj(i)) {
                            if (yVar != com.ss.android.socialbase.downloader.constants.y.MAIN) {
                                if (yVar == com.ss.android.socialbase.downloader.constants.y.NOTIFICATION) {
                                }
                            }
                            if (yVar != com.ss.android.socialbase.downloader.constants.y.NOTIFICATION || downloadInfo.canShowNotification()) {
                                this.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.xj.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (iDownloadListener != null) {
                                            if (downloadInfo.getStatus() == -3) {
                                                iDownloadListener.onSuccessed(downloadInfo);
                                            } else if (downloadInfo.getStatus() == -1) {
                                                iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
                return;
            }
            if (com.ss.android.socialbase.downloader.tf.xj.xj(32768) && (hf = this.p.hf(i)) != null && hf.getStatus() != -3) {
                DownloadTask downloadTask = this.f.get(Integer.valueOf(i));
                if (downloadTask == null) {
                    downloadTask = new DownloadTask(hf);
                    this.f.put(Integer.valueOf(i), downloadTask);
                }
                downloadTask.addDownloadListener(i2, iDownloadListener, yVar, z);
            }
        } finally {
        }
    }

    private void xj(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.tf.w.xj(i, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.tf.w.xj(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void xj(int i, int i2) {
        com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.hf.remove(i);
            this.c.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.c.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.hf.remove(i);
                this.c.remove(i);
                return;
            }
            return;
        }
        this.hf.remove(i);
    }

    public synchronized void xj(int i, int i2, int i3) {
        try {
            if (i3 != -7) {
                if (i3 != -6) {
                    if (i3 == -4) {
                        xj(i, i2);
                    } else if (i3 == -3) {
                        this.w.put(i, this.hf.get(i));
                        xj(i, i2);
                    } else if (i3 != -1) {
                        if (i3 != 7) {
                            if (i3 == 8) {
                                DownloadTask downloadTask = this.hf.get(i);
                                if (downloadTask != null && this.y.get(i) == null) {
                                    this.y.put(i, downloadTask);
                                }
                            }
                            return;
                        }
                        DownloadTask downloadTask2 = this.hf.get(i);
                        if (downloadTask2 != null) {
                            if (this.kd.get(i) == null) {
                                this.kd.put(i, downloadTask2);
                            }
                            xj(i, i2);
                        }
                        zg(i);
                        return;
                    }
                    zg(i);
                    return;
                }
                this.w.put(i, this.hf.get(i));
                xj(i, i2);
                return;
            }
            DownloadTask downloadTask3 = this.hf.get(i);
            if (downloadTask3 != null) {
                if (this.u.get(i) == null) {
                    this.u.put(i, downloadTask3);
                }
                xj(i, i2);
            }
            zg(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.f.xj
    public void xj(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.ss.android.socialbase.downloader.w.xj.hf("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            try {
                if (i2 == 0) {
                    downloadTask = this.hf.get(i);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.c.get(i);
                    if (sparseArray != null) {
                        downloadTask = sparseArray.get(i2);
                    }
                }
                if (downloadTask == null) {
                    return;
                }
                xj(message.what, baseException, downloadTask);
                xj(i, i2, message.what);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
