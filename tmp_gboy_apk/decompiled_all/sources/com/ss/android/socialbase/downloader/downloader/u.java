package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static volatile u xj;
    private volatile SparseArray<Boolean> hf = new SparseArray<>();
    private Handler w = new Handler(Looper.getMainLooper());
    private volatile List<ai> u = new ArrayList();

    public static u xj() {
        if (xj == null) {
            synchronized (u.class) {
                xj = new u();
            }
        }
        return xj;
    }

    public void am(int i) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.tf(i);
    }

    public void c(int i) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.u(i);
    }

    public int d(int i) {
        g w = w(i);
        if (w == null) {
            return 0;
        }
        return w.y(i);
    }

    public void e(int i) {
        if (i == 0) {
            return;
        }
        hf(i, true);
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        if (xj2 == null) {
            return;
        }
        xj2.startService();
    }

    public long f(int i) {
        g w = w(i);
        if (w == null) {
            return 0L;
        }
        return w.kd(i);
    }

    public j g(int i) {
        g w = w(i);
        if (w == null) {
            return null;
        }
        return w.yo(i);
    }

    public void hf(ai aiVar) {
        if (aiVar == null) {
            return;
        }
        synchronized (this.u) {
            try {
                if (this.u.contains(aiVar)) {
                    this.u.remove(aiVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean kd(int i) {
        g w = w(i);
        if (w == null) {
            return false;
        }
        return w.hf(i);
    }

    public DownloadInfo p(int i) {
        g w = w(i);
        if (w == null) {
            return null;
        }
        return w.f(i);
    }

    public io pl(int i) {
        g w = w(i);
        if (w == null) {
            return null;
        }
        return w.e(i);
    }

    public boolean qt(int i) {
        g w = w(i);
        if (w == null) {
            return false;
        }
        return w.pl(i);
    }

    public boolean tf(int i) {
        g w = w(i);
        if (w == null) {
            return false;
        }
        return w.c(i);
    }

    public void u(int i) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.xj(i);
    }

    public g w(int i) {
        return com.ss.android.socialbase.downloader.impls.pl.xj(xj(i) == 1 && !com.ss.android.socialbase.downloader.tf.y.w());
    }

    public void y(int i) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.w(i);
    }

    public IDownloadFileUriProvider yo(int i) {
        g w = w(i);
        if (w == null) {
            return null;
        }
        return w.v(i);
    }

    public void zg(int i) {
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        if (xj2 != null) {
            xj2.p(i);
        }
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        if (xj3 != null) {
            xj3.p(i);
        }
    }

    public void w(int i, boolean z) {
        if (!com.ss.android.socialbase.downloader.tf.y.xj()) {
            g w = w(i);
            if (w != null) {
                w.xj(i, z);
            }
            com.ss.android.socialbase.downloader.impls.pl.xj(true).xj(2, i);
            return;
        }
        if (com.ss.android.socialbase.downloader.tf.xj.xj(8388608)) {
            g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
            if (xj2 != null) {
                xj2.xj(i, z);
            }
            g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
            if (xj3 != null) {
                xj3.xj(i, z);
                return;
            }
            return;
        }
        g xj4 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        if (xj4 != null) {
            xj4.xj(i, z);
        }
        g xj5 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        if (xj5 != null) {
            xj5.xj(i, z);
        }
    }

    public List<DownloadInfo> kd(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        List<DownloadInfo> kd = xj2 != null ? xj2.kd(str) : null;
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        return xj(kd, xj3 != null ? xj3.kd(str) : null, sparseArray);
    }

    public void u(int i, boolean z) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.hf(i, z);
    }

    public boolean y() {
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        if (xj2 != null) {
            return xj2.kd();
        }
        return false;
    }

    public void hf() {
        synchronized (this.u) {
            try {
                Iterator<ai> it = this.u.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean u() {
        return w.n();
    }

    public List<DownloadInfo> u(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        List<DownloadInfo> u = xj2 != null ? xj2.u(str) : null;
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        return xj(u, xj3 != null ? xj3.u(str) : null, sparseArray);
    }

    public void xj(ai aiVar) {
        if (aiVar == null || com.ss.android.socialbase.downloader.tf.y.w()) {
            return;
        }
        com.ss.android.socialbase.downloader.impls.pl.xj(true);
        synchronized (this.u) {
            try {
                if (!this.u.contains(aiVar)) {
                    this.u.add(aiVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<DownloadInfo> kd() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        List<DownloadInfo> u = xj2 != null ? xj2.u() : null;
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        return xj(u, xj3 != null ? xj3.u() : null, sparseArray);
    }

    public synchronized void hf(int i, boolean z) {
        try {
            this.hf.put(i, z ? Boolean.TRUE : Boolean.FALSE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int hf(int i) {
        if (this.hf.get(i) == null) {
            return -1;
        }
        return this.hf.get(i).booleanValue() ? 1 : 0;
    }

    public void xj(int i, boolean z) {
        hf(i, z);
        if (w.dc() && !com.ss.android.socialbase.downloader.tf.y.w() && com.ss.android.socialbase.downloader.impls.pl.xj(true).c()) {
            com.ss.android.socialbase.downloader.impls.pl.xj(true).w(i, z);
        }
        if (w.w() || com.ss.android.socialbase.downloader.tf.y.w() || com.ss.android.socialbase.downloader.tf.y.xj()) {
            return;
        }
        try {
            Intent intent = new Intent(w.tj(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            w.tj().startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private g hf(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.hf> d;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean isNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (com.ss.android.socialbase.downloader.tf.y.w() || !com.ss.android.socialbase.downloader.tf.y.xj()) {
            isNeedIndependentProcess = true;
        }
        int xj2 = xj(downloadInfo.getId());
        if (xj2 >= 0 && xj2 != isNeedIndependentProcess) {
            try {
                if (xj2 == 1) {
                    if (com.ss.android.socialbase.downloader.tf.y.xj()) {
                        com.ss.android.socialbase.downloader.impls.pl.xj(true).xj(downloadInfo.getId());
                        DownloadInfo f = com.ss.android.socialbase.downloader.impls.pl.xj(true).f(downloadInfo.getId());
                        if (f != null) {
                            com.ss.android.socialbase.downloader.impls.pl.xj(false).hf(f);
                        }
                        if (f.getChunkCount() > 1 && (d = com.ss.android.socialbase.downloader.impls.pl.xj(true).d(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.pl.xj(false).xj(downloadInfo.getId(), com.ss.android.socialbase.downloader.tf.y.xj(d));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.tf.y.xj()) {
                    com.ss.android.socialbase.downloader.impls.pl.xj(false).xj(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.hf> d2 = com.ss.android.socialbase.downloader.impls.pl.xj(false).d(downloadInfo.getId());
                    if (d2 != null) {
                        com.ss.android.socialbase.downloader.impls.pl.xj(true).xj(downloadInfo.getId(), com.ss.android.socialbase.downloader.tf.y.xj(d2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.pl.xj(true).xj(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        xj(downloadInfo.getId(), isNeedIndependentProcess);
        return com.ss.android.socialbase.downloader.impls.pl.xj(isNeedIndependentProcess);
    }

    public void w() {
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        if (xj2 != null) {
            xj2.xj();
        }
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        if (xj3 != null) {
            xj3.xj();
        }
    }

    public List<DownloadInfo> w(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        List<DownloadInfo> w = xj2 != null ? xj2.w(str) : null;
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        return xj(w, xj3 != null ? xj3.w(str) : null, sparseArray);
    }

    public int xj(int i) {
        if (!w.dc()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.tf.y.w() && com.ss.android.socialbase.downloader.impls.pl.xj(true).c()) {
            return com.ss.android.socialbase.downloader.impls.pl.xj(true).g(i);
        }
        return hf(i);
    }

    public int xj(String str, String str2) {
        return w.xj(str, str2);
    }

    public List<DownloadInfo> xj(String str) {
        List<DownloadInfo> xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false).xj(str);
        List<DownloadInfo> xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true).xj(str);
        if (xj2 == null && xj3 == null) {
            return null;
        }
        if (xj2 == null || xj3 == null) {
            return xj2 != null ? xj2 : xj3;
        }
        ArrayList arrayList = new ArrayList(xj2);
        arrayList.addAll(xj3);
        return arrayList;
    }

    public void xj(int i, io ioVar) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.xj(i, ioVar);
    }

    private List<DownloadInfo> xj(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public DownloadInfo hf(String str, String str2) {
        int xj2 = xj(str, str2);
        g w = w(xj2);
        if (w == null) {
            return null;
        }
        return w.f(xj2);
    }

    public List<DownloadInfo> hf(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        List<DownloadInfo> hf = xj2 != null ? xj2.hf(str) : null;
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        return xj(hf, xj3 != null ? xj3.hf(str) : null, sparseArray);
    }

    public void xj(List<String> list) {
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        if (xj2 != null) {
            xj2.xj(list);
        }
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        if (xj3 != null) {
            xj3.xj(list);
        }
    }

    public void hf(List<String> list) {
        g xj2 = com.ss.android.socialbase.downloader.impls.pl.xj(false);
        if (xj2 != null) {
            xj2.hf(list);
        }
        g xj3 = com.ss.android.socialbase.downloader.impls.pl.xj(true);
        if (xj3 != null) {
            xj3.hf(list);
        }
    }

    public void xj(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        int hashCode;
        IDownloadListener iDownloadListener2;
        com.ss.android.socialbase.downloader.constants.y yVar2;
        boolean z2;
        int i2;
        g w = w(i);
        if (w == null) {
            return;
        }
        if (iDownloadListener == null) {
            hashCode = 0;
            i2 = i;
            iDownloadListener2 = iDownloadListener;
            yVar2 = yVar;
            z2 = z;
        } else {
            hashCode = iDownloadListener.hashCode();
            iDownloadListener2 = iDownloadListener;
            yVar2 = yVar;
            z2 = z;
            i2 = i;
        }
        w.hf(i2, hashCode, iDownloadListener2, yVar2, z2);
    }

    public void hf(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.xj(i, iDownloadListener.hashCode(), iDownloadListener, yVar, z);
    }

    public void xj(int i, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z, boolean z2) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.xj(i, iDownloadListener.hashCode(), iDownloadListener, yVar, z, z2);
    }

    public void hf(com.ss.android.socialbase.downloader.depend.p pVar) {
        w.hf(pVar);
    }

    public boolean xj(DownloadInfo downloadInfo) {
        g w;
        if (downloadInfo == null || (w = w(downloadInfo.getId())) == null) {
            return false;
        }
        return w.xj(downloadInfo);
    }

    public void xj(final DownloadTask downloadTask) {
        final g hf = hf(downloadTask);
        if (hf == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.u.xj.xj(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.w.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.u.1
                @Override // java.lang.Runnable
                public void run() {
                    hf.xj(downloadTask);
                }
            }, 500L);
        } else {
            hf.xj(downloadTask);
        }
    }

    public void xj(com.ss.android.socialbase.downloader.depend.p pVar) {
        w.xj(pVar);
    }

    public void xj(int i, long j) {
        g w = w(i);
        if (w == null) {
            return;
        }
        w.xj(i, j);
    }
}
