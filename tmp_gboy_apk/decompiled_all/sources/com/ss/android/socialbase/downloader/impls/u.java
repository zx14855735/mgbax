package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.ss.android.socialbase.downloader.d.f;
import com.ss.android.socialbase.downloader.downloader.jk;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u implements com.ss.android.socialbase.downloader.downloader.tf {
    private jk hf;
    private volatile boolean u;
    private volatile boolean w;
    private com.ss.android.socialbase.downloader.d.f y;
    private f.xj kd = new f.xj() { // from class: com.ss.android.socialbase.downloader.impls.u.1
        @Override // com.ss.android.socialbase.downloader.d.f.xj
        public void xj(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.u.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            u.this.d();
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                        }
                    }
                });
            }
        }
    };
    private final p xj = new p();

    public u() {
        this.y = null;
        if (!com.ss.android.socialbase.downloader.f.xj.w().xj("fix_sigbus_downloader_db")) {
            this.hf = new com.ss.android.socialbase.downloader.hf.kd();
        } else if (com.ss.android.socialbase.downloader.tf.y.xj() || !com.ss.android.socialbase.downloader.downloader.w.dc()) {
            this.hf = new com.ss.android.socialbase.downloader.hf.kd();
        } else {
            this.hf = com.ss.android.socialbase.downloader.downloader.w.wn().xj(new w.xj.InterfaceC0498xj() { // from class: com.ss.android.socialbase.downloader.impls.u.2
                @Override // com.ss.android.socialbase.downloader.downloader.w.xj.InterfaceC0498xj
                public void xj() {
                    u.this.hf = new com.ss.android.socialbase.downloader.hf.kd();
                    com.bytedance.sdk.component.utils.pl.u("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        }
        this.w = false;
        this.y = new com.ss.android.socialbase.downloader.d.f(Looper.getMainLooper(), this.kd);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf() {
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<com.ss.android.socialbase.downloader.y.d> am(int i) {
        List<com.ss.android.socialbase.downloader.y.d> am = this.xj.am(i);
        return (am == null || am.size() == 0) ? this.hf.am(i) : am;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo c(int i) {
        DownloadInfo c = this.xj.c(i);
        w(c);
        return c;
    }

    public void d() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.w) {
            if (this.u) {
                com.ss.android.socialbase.downloader.w.xj.hf("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.u = true;
            if (com.ss.android.socialbase.downloader.tf.y.xj()) {
                com.ss.android.socialbase.downloader.downloader.pl dk = com.ss.android.socialbase.downloader.downloader.w.dk();
                if (dk != null) {
                    list = dk.xj();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    try {
                        SparseArray<DownloadInfo> xj = this.xj.xj();
                        for (int i = 0; i < xj.size(); i++) {
                            int keyAt = xj.keyAt(i);
                            if (keyAt != 0 && (downloadInfo2 = xj.get(keyAt)) != null) {
                                sparseArray.put(keyAt, downloadInfo2);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int keyAt2 = sparseArray.keyAt(i2);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit > 0 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.u.xj.xj(com.ss.android.socialbase.downloader.downloader.w.c(), downloadInfo, (BaseException) null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).hf("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (dk == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                dk.xj(arrayList, 1);
            }
        }
    }

    public void f() {
        this.y.sendMessageDelayed(this.y.obtainMessage(1), com.ss.android.socialbase.downloader.f.xj.w().xj("task_resume_delay") ? 4000L : Build.VERSION.SDK_INT >= 23 ? 1000L : PushUIConfig.dismissTime);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void g(int i) {
        this.xj.g(i);
        this.hf.g(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean kd() {
        if (this.w) {
            return true;
        }
        synchronized (this) {
            if (!this.w) {
                com.ss.android.socialbase.downloader.w.xj.u("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(PushUIConfig.dismissTime);
                } catch (InterruptedException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
                com.ss.android.socialbase.downloader.w.xj.u("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.w;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public Map<Long, com.ss.android.socialbase.downloader.y.d> pl(int i) {
        Map<Long, com.ss.android.socialbase.downloader.y.d> pl2 = this.xj.pl(i);
        if (pl2 != null && !pl2.isEmpty()) {
            return pl2;
        }
        Map<Long, com.ss.android.socialbase.downloader.y.d> pl3 = this.hf.pl(i);
        this.xj.xj(i, pl3);
        return pl3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean u() {
        return this.w;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> w(String str) {
        return this.xj.w(str);
    }

    public jk y() {
        return this.hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo hf(int i) {
        return this.xj.hf(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> u(String str) {
        return this.xj.u(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<com.ss.android.socialbase.downloader.model.hf> w(int i) {
        return this.xj.w(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean y(int i) {
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.zg(i);
            } else {
                this.hf.y(i);
            }
        } else {
            this.hf.y(i);
        }
        return this.xj.y(i);
    }

    public void c() {
        List<com.ss.android.socialbase.downloader.model.hf> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.w.xj(com.ss.android.socialbase.downloader.constants.u.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> sparseArray2 = new SparseArray<>();
        synchronized (this.xj) {
            try {
                SparseArray<DownloadInfo> xj = this.xj.xj();
                for (int i = 0; i < xj.size(); i++) {
                    int keyAt = xj.keyAt(i);
                    if (keyAt != 0 && (downloadInfo = xj.get(keyAt)) != null) {
                        sparseArray.put(keyAt, downloadInfo);
                    }
                }
                SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> y = this.xj.y();
                for (int i2 = 0; i2 < y.size(); i2++) {
                    int keyAt2 = y.keyAt(i2);
                    if (keyAt2 != 0 && (list = y.get(keyAt2)) != null) {
                        sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.hf.xj(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.hf.u() { // from class: com.ss.android.socialbase.downloader.impls.u.3
            @Override // com.ss.android.socialbase.downloader.hf.u
            public void xj() {
                synchronized (u.this.xj) {
                    try {
                        SparseArray<DownloadInfo> xj2 = u.this.xj.xj();
                        if (sparseArray != null) {
                            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                                int keyAt3 = sparseArray.keyAt(i3);
                                if (keyAt3 != 0) {
                                    xj2.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                                }
                            }
                        }
                        SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> y2 = u.this.xj.y();
                        if (sparseArray2 != null) {
                            for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                                int keyAt4 = sparseArray2.keyAt(i4);
                                if (keyAt4 != 0) {
                                    y2.put(keyAt4, (List) sparseArray2.get(keyAt4));
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                u.this.tf();
                u.this.f();
                com.ss.android.socialbase.downloader.downloader.w.xj(com.ss.android.socialbase.downloader.constants.u.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> hf(String str) {
        return this.xj.hf(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void u(int i) {
        this.xj.u(i);
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.qt(i);
                return;
            } else {
                this.hf.u(i);
                return;
            }
        }
        this.hf.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void w() {
        try {
            this.xj.w();
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.y();
                return;
            } else {
                this.hf.w();
                return;
            }
        }
        this.hf.w();
    }

    public p xj() {
        return this.xj;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> hf() {
        return this.xj.hf();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> xj(String str) {
        return this.xj.xj(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo f(int i) {
        DownloadInfo f = this.xj.f(i);
        w(f);
        return f;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(com.ss.android.socialbase.downloader.model.hf hfVar) {
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.xj(hfVar);
                return;
            } else {
                this.hf.xj(hfVar);
                return;
            }
        }
        this.hf.xj(hfVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo tf(int i) {
        DownloadInfo tf = this.xj.tf(i);
        w(tf);
        return tf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(com.ss.android.socialbase.downloader.model.hf hfVar) {
        synchronized (this.xj) {
            this.xj.xj(hfVar);
        }
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.xj(hfVar);
                return;
            } else {
                this.hf.xj(hfVar);
                return;
            }
        }
        this.hf.xj(hfVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo u(int i, long j) {
        DownloadInfo u = this.xj.u(i, j);
        hf(i, (List<com.ss.android.socialbase.downloader.model.hf>) null);
        return u;
    }

    private void w(DownloadInfo downloadInfo) {
        xj(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo hf(int i, long j) {
        DownloadInfo hf = this.xj.hf(i, j);
        hf(i, (List<com.ss.android.socialbase.downloader.model.hf>) null);
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean kd(int i) {
        try {
            if (com.ss.android.socialbase.downloader.tf.y.hf()) {
                com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
                if (xj != null) {
                    xj.am(i);
                } else {
                    this.hf.kd(i);
                }
            } else {
                this.hf.kd(i);
            }
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return this.xj.kd(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo w(int i, long j) {
        DownloadInfo w = this.xj.w(i, j);
        hf(i, (List<com.ss.android.socialbase.downloader.model.hf>) null);
        return w;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.xj.xj(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        try {
            xj(this.xj.hf(i));
            if (list == null) {
                list = this.xj.w(i);
            }
            if (com.ss.android.socialbase.downloader.tf.y.hf()) {
                com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
                if (xj != null) {
                    xj.hf(i, list);
                    return;
                } else {
                    this.hf.hf(i, list);
                    return;
                }
            }
            this.hf.hf(i, list);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, int i2, long j) {
        this.xj.xj(i, i2, j);
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.xj(i, i2, j);
                return;
            } else {
                this.hf.xj(i, i2, j);
                return;
            }
        }
        this.hf.xj(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.xj(i, i2, i3, j);
                return;
            } else {
                this.hf.xj(i, i2, i3, j);
                return;
            }
        }
        this.hf.xj(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.tf.y.hf()) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.xj(i, i2, i3, i4);
                return;
            } else {
                this.hf.xj(i, i2, i3, i4);
                return;
            }
        }
        this.hf.xj(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, int i2) {
        DownloadInfo xj = this.xj.xj(i, i2);
        w(xj);
        return xj;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean xj = this.xj.xj(downloadInfo);
        w(downloadInfo);
        return xj;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j, String str, String str2) {
        DownloadInfo xj = this.xj.xj(i, j, str, str2);
        w(xj);
        return xj;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo d(int i) {
        DownloadInfo d = this.xj.d(i);
        w(d);
        return d;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j) {
        DownloadInfo xj = this.xj.xj(i, j);
        xj(xj, false);
        return xj;
    }

    private void xj(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.tf.y.hf()) {
            this.hf.xj(downloadInfo);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.g xj = pl.xj(true);
            if (xj != null) {
                xj.w(downloadInfo);
            } else {
                this.hf.xj(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.xj.xj(i, list);
        if (com.ss.android.socialbase.downloader.tf.y.w()) {
            this.hf.hf(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean xj(int i, Map<Long, com.ss.android.socialbase.downloader.y.d> map) {
        this.xj.xj(i, map);
        this.hf.xj(i, map);
        return false;
    }
}
