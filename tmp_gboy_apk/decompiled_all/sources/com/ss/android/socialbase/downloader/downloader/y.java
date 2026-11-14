package com.ss.android.socialbase.downloader.downloader;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.dk;
import com.ss.android.socialbase.downloader.depend.ff;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private static final String xj = "y";
    private int am;
    private SparseArray<IDownloadListener> c;
    private SparseArray<IDownloadListener> d;
    private dk e;
    private SparseArray<IDownloadListener> f;
    private final boolean hf;
    private final Handler kd;
    private long qt;
    private final tf u;
    private DownloadInfo w;
    private DownloadTask y;
    private com.ss.android.socialbase.downloader.depend.am zg;
    private boolean tf = false;
    private volatile long p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private final AtomicLong f13850pl = new AtomicLong();
    private boolean g = false;

    public y(DownloadTask downloadTask, Handler handler) {
        this.y = downloadTask;
        tf();
        this.kd = handler;
        this.u = w.et();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.hf = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).xj("fix_start_with_file_exist_update_error");
        } else {
            this.hf = false;
        }
    }

    private void g() {
        List<com.ss.android.socialbase.downloader.depend.g> downloadCompleteHandlers = this.y.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.w;
        xj(11, (BaseException) null);
        this.u.xj(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.g gVar : downloadCompleteHandlers) {
            try {
                if (gVar.hf(downloadInfo)) {
                    gVar.xj(downloadInfo);
                    this.u.xj(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    private void p() {
        ExecutorService pl2 = w.pl();
        if (pl2 != null) {
            pl2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.this.u.d(y.this.w.getId());
                    y.this.xj(1, (BaseException) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl() {
        try {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "saveFileAsTargetName onSuccess");
            try {
                g();
                this.w.setFirstSuccess(false);
                this.w.setSuccessByCache(false);
                xj(-3, (BaseException) null);
                this.u.w(this.w.getId(), this.w.getTotalBytes());
                this.u.u(this.w.getId());
                this.u.g(this.w.getId());
            } catch (BaseException e) {
                xj(e);
            }
        } catch (Throwable th) {
            xj(new BaseException(1008, com.ss.android.socialbase.downloader.tf.y.hf(th, "onCompleted")));
        }
    }

    private void tf() {
        DownloadTask downloadTask = this.y;
        if (downloadTask != null) {
            this.w = downloadTask.getDownloadInfo();
            this.c = this.y.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.MAIN);
            this.d = this.y.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.NOTIFICATION);
            this.f = this.y.getDownloadListeners(com.ss.android.socialbase.downloader.constants.y.SUB);
            this.zg = this.y.getDepend();
            this.e = this.y.getMonitorDepend();
        }
    }

    public void c() {
        if (!this.hf) {
            g();
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "onCompleteForFileExist");
            this.w.setSuccessByCache(true);
            xj(-3, (BaseException) null);
            this.u.w(this.w.getId(), this.w.getTotalBytes());
            this.u.u(this.w.getId());
            this.u.g(this.w.getId());
            return;
        }
        g();
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "onCompleteForFileExist");
        this.w.setSuccessByCache(true);
        xj(-3, (BaseException) null);
        this.u.w(this.w.getId(), this.w.getTotalBytes());
        this.u.u(this.w.getId());
        this.u.xj(this.w);
        this.u.g(this.w.getId());
    }

    public void f() {
        this.w.setStatus(8);
        this.w.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.xj.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.xj z = w.z();
        if (z != null) {
            z.xj(this.w.getId(), this.y.getHashCodeForSameTask(), 8);
        }
    }

    public void kd() {
        this.w.setStatus(-7);
        try {
            this.u.tf(this.w.getId());
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        xj(-7, (BaseException) null);
    }

    public void u() {
        this.w.setStatus(-2);
        try {
            this.u.u(this.w.getId(), this.w.getCurBytes());
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        xj(-2, (BaseException) null);
    }

    public void y() {
        this.w.setFirstDownload(false);
        if (!this.w.isIgnoreDataVerify() && this.w.getCurBytes() != this.w.getTotalBytes()) {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, this.w.getErrorBytesLog());
            xj(new com.ss.android.socialbase.downloader.exception.y(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.w.getByteInvalidRetryStatus()));
            return;
        }
        if (this.w.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, this.w.getErrorBytesLog());
            xj(new com.ss.android.socialbase.downloader.exception.y(1026, "curBytes is 0, bytes changed with process : " + this.w.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.w.isIgnoreDataVerify() && this.w.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, this.w.getErrorBytesLog());
            xj(new com.ss.android.socialbase.downloader.exception.y(1044, "TotalBytes is 0, bytes changed with process : " + this.w.getByteInvalidRetryStatus()));
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.hf(xj, this.w.getName() + " onCompleted start save file as target name");
        dk dkVar = this.e;
        DownloadTask downloadTask = this.y;
        if (downloadTask != null) {
            dkVar = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.tf.y.xj(this.w, dkVar, new ff() { // from class: com.ss.android.socialbase.downloader.downloader.y.2
            @Override // com.ss.android.socialbase.downloader.depend.ff
            public void xj() {
                y.this.pl();
            }

            @Override // com.ss.android.socialbase.downloader.depend.ff
            public void xj(BaseException baseException) {
                String str = y.xj;
                StringBuilder sb = new StringBuilder("saveFileAsTargetName onFailed : ");
                sb.append(baseException != null ? baseException.getErrorMessage() : "");
                com.ss.android.socialbase.downloader.w.xj.hf(str, sb.toString());
                y.this.xj(baseException);
            }
        });
    }

    public void hf() {
        if (this.w.canSkipStatusHandler()) {
            this.w.changeSkipStatus();
            return;
        }
        this.u.c(this.w.getId());
        if (this.w.isFirstDownload()) {
            xj(6, (BaseException) null);
        }
        xj(2, (BaseException) null);
    }

    public void w() {
        xj(-4, (BaseException) null);
    }

    private BaseException w(BaseException baseException) {
        Context tj;
        if (com.ss.android.socialbase.downloader.f.xj.xj(this.w.getId()).xj("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.tf.y.d(baseException) || (tj = w.tj()) == null || com.ss.android.socialbase.downloader.tf.y.w(tj)) {
            return baseException;
        }
        return new BaseException(this.w.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void xj() {
        if (this.w.canSkipStatusHandler()) {
            return;
        }
        this.w.setStatus(1);
        p();
    }

    public void xj(long j, String str, String str2) {
        long j2;
        this.w.setTotalBytes(j);
        this.w.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.w.getName())) {
            this.w.setName(str2);
        }
        try {
            j2 = j;
            try {
                this.u.xj(this.w.getId(), j2, str, str2);
            } catch (Exception e) {
                e = e;
                com.bytedance.sdk.component.utils.pl.xj(e);
                xj(3, (BaseException) null);
                this.qt = this.w.getMinByteIntervalForPostToMainThread(j2);
                this.am = this.w.getMinProgressTimeMsInterval();
                this.tf = true;
                com.ss.android.socialbase.downloader.impls.yo.xj().kd();
            }
        } catch (Exception e2) {
            e = e2;
            j2 = j;
        }
        xj(3, (BaseException) null);
        this.qt = this.w.getMinByteIntervalForPostToMainThread(j2);
        this.am = this.w.getMinProgressTimeMsInterval();
        this.tf = true;
        com.ss.android.socialbase.downloader.impls.yo.xj().kd();
    }

    private void hf(BaseException baseException) {
        new Throwable();
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.u.y(this.w.getId());
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        } else {
            try {
                try {
                    this.u.hf(this.w.getId(), this.w.getCurBytes());
                } catch (SQLiteException unused) {
                    this.u.y(this.w.getId());
                }
            } catch (SQLiteException e2) {
                com.bytedance.sdk.component.utils.pl.xj(e2);
            }
        }
        BaseException w = w(baseException);
        this.w.setFailedException(w);
        xj(w instanceof com.ss.android.socialbase.downloader.exception.kd ? -2 : -1, w);
        if (com.ss.android.socialbase.downloader.f.xj.xj(this.w.getId()).xj("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.yo.xj().xj(this.w);
        }
    }

    public boolean xj(long j) {
        this.f13850pl.addAndGet(j);
        this.w.increaseCurBytes(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return xj(uptimeMillis, hf(uptimeMillis));
    }

    private boolean hf(long j) {
        boolean z = true;
        if (!this.g) {
            this.g = true;
            return true;
        }
        long j2 = j - this.p;
        if (this.f13850pl.get() < this.qt && j2 < this.am) {
            z = false;
        }
        if (z) {
            this.p = j;
            this.f13850pl.set(0L);
        }
        return z;
    }

    public void xj(BaseException baseException, boolean z) {
        this.w.setFirstDownload(false);
        this.f13850pl.set(0L);
        hf(baseException, z);
    }

    public void xj(com.ss.android.socialbase.downloader.model.hf hfVar, BaseException baseException, boolean z) {
        this.w.setFirstDownload(false);
        this.f13850pl.set(0L);
        this.u.f(this.w.getId());
        xj(z ? 10 : 9, baseException, true);
    }

    private void hf(BaseException baseException, boolean z) {
        this.u.f(this.w.getId());
        xj(z ? 7 : 5, baseException);
    }

    public void xj(BaseException baseException) {
        this.w.setFirstDownload(false);
        hf(baseException);
    }

    public void xj(String str) {
        String str2 = xj;
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("onCompleteForFileExist existTargetFileName is ", str, " but curName is ");
        B3GDIM2.append(this.w.getName());
        com.ss.android.socialbase.downloader.w.xj.hf(str2, B3GDIM2.toString());
        if (this.hf) {
            com.ss.android.socialbase.downloader.tf.y.xj(this.w, str);
            g();
            this.w.setSuccessByCache(true);
            xj(-3, (BaseException) null);
            this.u.xj(this.w);
            return;
        }
        this.u.xj(this.w);
        com.ss.android.socialbase.downloader.tf.y.xj(this.w, str);
        this.w.setSuccessByCache(true);
        g();
        xj(-3, (BaseException) null);
    }

    private boolean xj(long j, boolean z) {
        boolean z2 = false;
        if (this.w.getCurBytes() == this.w.getTotalBytes()) {
            try {
                this.u.xj(this.w.getId(), this.w.getCurBytes());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            return false;
        }
        if (this.tf) {
            this.tf = false;
            this.w.setStatus(4);
        }
        if (this.w.isNeedPostProgress() && z) {
            z2 = true;
        }
        xj(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, BaseException baseException) {
        xj(i, baseException, true);
    }

    private void xj(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.w.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        tf();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.w.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.w.updateDownloadTime();
            }
        }
        if (!this.w.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.u.xj.xj(this.y, baseException, i);
        }
        if (i == 6) {
            this.w.setStatus(2);
        } else if (i == -6) {
            this.w.setStatus(-3);
        } else {
            this.w.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.w.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.c.DELAY_RETRY_DOWNLOADING) {
                this.w.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.c.DELAY_RETRY_DOWNLOADED);
            }
            if (this.w.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.xj.ASYNC_HANDLE_DOWNLOADING) {
                this.w.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.xj.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.w.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.hf.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.w.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.hf.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.tf.w.xj(i, this.f, true, this.w, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.kd != null && (((sparseArray = this.c) != null && sparseArray.size() > 0) || ((sparseArray2 = this.d) != null && sparseArray2.size() > 0 && (this.w.canShowNotification() || this.w.isAutoInstallWithoutNotification())))) {
            this.kd.obtainMessage(i, this.w.getId(), this.y.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.xj z2 = w.z();
        if (z2 != null) {
            z2.xj(this.w.getId(), this.y.getHashCodeForSameTask(), i);
        }
    }
}
