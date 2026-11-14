package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.wo;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class zg implements com.ss.android.socialbase.downloader.downloader.g {
    private final com.ss.android.socialbase.downloader.downloader.tf hf;
    private final boolean u;
    private final com.ss.android.socialbase.downloader.downloader.qt w;
    private final xj xj;

    public zg() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean am(int i) {
        return this.hf.kd(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean c(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.xj(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<com.ss.android.socialbase.downloader.model.hf> d(int i) {
        return this.hf.w(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public io e(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.d(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public DownloadInfo f(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.u(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int g(int i) {
        return com.ss.android.socialbase.downloader.downloader.u.xj().xj(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean hf(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.am(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public long kd(int i) {
        DownloadInfo hf;
        com.ss.android.socialbase.downloader.downloader.tf tfVar = this.hf;
        if (tfVar == null || (hf = tfVar.hf(i)) == null) {
            return 0L;
        }
        int chunkCount = hf.getChunkCount();
        if (chunkCount <= 1) {
            return hf.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.hf> w = this.hf.w(i);
        if (w == null || w.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.tf.y.hf(w);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void p(int i) {
        com.ss.android.socialbase.downloader.w.xj.xj(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean pl(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.p(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void qt(int i) {
        this.hf.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void tf(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.g(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void u(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public IDownloadFileUriProvider v(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.tf(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void w(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.y(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.kd(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int y(int i) {
        DownloadInfo u;
        xj xjVar = this.xj;
        if (xjVar == null || (u = xjVar.u(i)) == null) {
            return 0;
        }
        return u.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public j yo(int i) {
        xj xjVar = this.xj;
        j f = xjVar != null ? xjVar.f(i) : null;
        return f == null ? com.ss.android.socialbase.downloader.downloader.w.r() : f;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean zg(int i) {
        return this.hf.y(i);
    }

    public zg(boolean z) {
        this.xj = com.ss.android.socialbase.downloader.downloader.w.z();
        this.hf = com.ss.android.socialbase.downloader.downloader.w.et();
        if (z) {
            this.w = com.ss.android.socialbase.downloader.downloader.w.x();
        } else {
            this.w = com.ss.android.socialbase.downloader.downloader.w.io();
        }
        this.u = com.ss.android.socialbase.downloader.f.xj.w().hf("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean c() {
        com.ss.android.socialbase.downloader.downloader.qt qtVar;
        return this.u && (qtVar = this.w) != null && qtVar.xj();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> hf(String str) {
        com.ss.android.socialbase.downloader.downloader.tf tfVar = this.hf;
        if (tfVar != null) {
            return tfVar.hf(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> u() {
        com.ss.android.socialbase.downloader.downloader.tf tfVar = this.hf;
        if (tfVar != null) {
            return tfVar.hf();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> w(String str) {
        com.ss.android.socialbase.downloader.downloader.tf tfVar = this.hf;
        if (tfVar != null) {
            return tfVar.w(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, boolean z) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void y() {
        this.hf.w();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(List<String> list) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.hf(list);
        }
    }

    public void u(int i, boolean z) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.w(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean w() {
        return com.ss.android.socialbase.downloader.downloader.w.n();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj() {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.hf();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void w(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.u.xj().xj(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public DownloadInfo hf(String str, String str2) {
        return f(com.ss.android.socialbase.downloader.downloader.w.xj(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> u(String str) {
        com.ss.android.socialbase.downloader.downloader.tf tfVar = this.hf;
        if (tfVar != null) {
            return tfVar.u(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean w(DownloadInfo downloadInfo) {
        return this.hf.xj(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(List<String> list) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> kd(String str) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.hf(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(int i, boolean z) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.hf(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> xj(String str) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.xj(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean kd() {
        return this.hf.u();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(i, i2, iDownloadListener, yVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int xj(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.w.xj(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.hf(i, i2, iDownloadListener, yVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean hf() {
        com.ss.android.socialbase.downloader.downloader.qt qtVar = this.w;
        if (qtVar != null) {
            return qtVar.hf();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z, boolean z2) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(i, i2, iDownloadListener, yVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.qt qtVar = this.w;
        if (qtVar != null) {
            qtVar.w(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean xj = com.ss.android.socialbase.downloader.tf.y.xj(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (xj) {
            if (com.ss.android.socialbase.downloader.tf.xj.xj(33554432)) {
                hf(downloadInfo.getId(), true);
                return xj;
            }
            u(downloadInfo.getId(), true);
        }
        return xj;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(DownloadInfo downloadInfo) {
        this.hf.hf(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        this.hf.hf(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.qt qtVar = this.w;
        if (qtVar != null) {
            qtVar.xj(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.qt qtVar = this.w;
        if (qtVar != null) {
            qtVar.xj(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.qt qtVar = this.w;
        if (qtVar != null) {
            qtVar.hf(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.u.xj.xj(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        this.hf.xj(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(com.ss.android.socialbase.downloader.model.hf hfVar) {
        this.hf.xj(hfVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, long j) {
        this.hf.xj(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, int i3, long j) {
        this.hf.xj(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, int i3, int i4) {
        this.hf.xj(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(wo woVar) {
        com.ss.android.socialbase.downloader.downloader.w.xj(woVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.w.kd() != null) {
            for (wo woVar : com.ss.android.socialbase.downloader.downloader.w.kd()) {
                if (woVar != null) {
                    woVar.xj(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, io ioVar) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(i, ioVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, long j) {
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.hf(i, j);
        }
    }
}
