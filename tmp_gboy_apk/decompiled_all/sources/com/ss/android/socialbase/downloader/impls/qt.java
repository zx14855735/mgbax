package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.wo;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class qt implements com.ss.android.socialbase.downloader.downloader.am, com.ss.android.socialbase.downloader.downloader.g {
    private static final String xj = "qt";
    private volatile com.ss.android.socialbase.downloader.downloader.d hf;
    private com.ss.android.socialbase.downloader.downloader.g u = new zg();
    private com.ss.android.socialbase.downloader.downloader.qt<CSJIndependentProcessDownloadService> w;

    public qt() {
        com.ss.android.socialbase.downloader.downloader.qt<CSJIndependentProcessDownloadService> x = com.ss.android.socialbase.downloader.downloader.w.x();
        this.w = x;
        x.xj(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean am(int i) {
        if (this.hf == null) {
            return this.u.am(i);
        }
        try {
            return this.hf.am(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean c(int i) {
        if (this.hf == null) {
            return false;
        }
        try {
            return this.hf.c(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<com.ss.android.socialbase.downloader.model.hf> d(int i) {
        if (this.hf == null) {
            return this.u.d(i);
        }
        try {
            return this.hf.d(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public io e(int i) {
        if (this.hf == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.tf.c.xj(this.hf.e(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public DownloadInfo f(int i) {
        if (this.hf == null) {
            return this.u.f(i);
        }
        try {
            return this.hf.f(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int g(int i) {
        if (this.hf == null) {
            return com.ss.android.socialbase.downloader.downloader.u.xj().hf(i);
        }
        try {
            return this.hf.g(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public long kd(int i) {
        if (this.hf == null) {
            return 0L;
        }
        try {
            return this.hf.kd(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void p(int i) {
        com.ss.android.socialbase.downloader.downloader.qt<CSJIndependentProcessDownloadService> qtVar = this.w;
        if (qtVar != null) {
            qtVar.xj(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean pl(int i) {
        if (this.hf == null) {
            return false;
        }
        try {
            return this.hf.p(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void qt(int i) {
        if (this.hf == null) {
            this.u.qt(i);
            return;
        }
        try {
            this.hf.qt(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.qt<CSJIndependentProcessDownloadService> qtVar = this.w;
        if (qtVar != null) {
            qtVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void tf(int i) {
        if (this.hf == null) {
            this.u.tf(i);
            return;
        }
        try {
            this.hf.tf(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void u(int i) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.u(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public IDownloadFileUriProvider v(int i) {
        if (this.hf == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.tf.c.xj(this.hf.v(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void w(int i) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.w(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.xj(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int y(int i) {
        if (this.hf == null) {
            return 0;
        }
        try {
            return this.hf.y(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public j yo(int i) {
        if (this.hf == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.tf.c.xj(this.hf.yo(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean zg(int i) {
        if (this.hf == null) {
            return this.u.zg(i);
        }
        try {
            return this.hf.zg(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean hf(int i) {
        if (this.hf == null) {
            return false;
        }
        try {
            return this.hf.hf(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean c() {
        return this.hf != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> kd(String str) {
        if (this.hf == null) {
            return null;
        }
        try {
            return this.hf.u(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> u() {
        if (this.hf == null) {
            return this.u.u();
        }
        try {
            return this.hf.hf();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> w(String str) {
        if (this.hf == null) {
            return this.u.w(str);
        }
        try {
            return this.hf.w(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, boolean z) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.xj(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void y() {
        if (this.hf == null) {
            this.u.y();
            return;
        }
        try {
            this.hf.kd();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.am
    public void f() {
        this.hf = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public DownloadInfo hf(String str, String str2) {
        return f(xj(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> hf(String str) {
        if (this.hf == null) {
            return this.u.hf(str);
        }
        try {
            return this.hf.hf(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean kd() {
        if (this.hf == null) {
            return this.u.kd();
        }
        try {
            return this.hf.u();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj() {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.xj();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> u(String str) {
        if (this.hf == null) {
            return this.u.u(str);
        }
        try {
            return this.hf.kd(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean w() {
        return com.ss.android.socialbase.downloader.downloader.w.n();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void w(int i, boolean z) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.u(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public List<DownloadInfo> xj(String str) {
        if (this.hf == null) {
            return this.u.xj(str);
        }
        try {
            return this.hf.xj(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(List<String> list) {
        if (this.hf == null) {
            this.u.hf(list);
            return;
        }
        try {
            this.hf.hf(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean w(DownloadInfo downloadInfo) {
        if (this.hf == null) {
            return this.u.w(downloadInfo);
        }
        try {
            return this.hf.hf(downloadInfo);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int xj(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.w.xj(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(int i, boolean z) {
        if (this.hf == null) {
            this.u.hf(i, z);
            return;
        }
        try {
            this.hf.hf(i, z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(List<String> list) {
        if (this.hf == null) {
            this.u.xj(list);
            return;
        }
        try {
            this.hf.xj(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.xj(i, i2, com.ss.android.socialbase.downloader.tf.c.xj(iDownloadListener, yVar != com.ss.android.socialbase.downloader.constants.y.SUB), yVar.ordinal(), z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.hf(i, i2, com.ss.android.socialbase.downloader.tf.c.xj(iDownloadListener, yVar != com.ss.android.socialbase.downloader.constants.y.SUB), yVar.ordinal(), z);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean hf() {
        if (this.hf == null) {
            com.ss.android.socialbase.downloader.w.xj.u(xj, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.w.xj.w(xj, "aidlService.isServiceForeground");
        try {
            return this.hf.y();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.y yVar, boolean z, boolean z2) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.xj(i, i2, com.ss.android.socialbase.downloader.tf.c.xj(iDownloadListener, yVar != com.ss.android.socialbase.downloader.constants.y.SUB), yVar.ordinal(), z, z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public boolean xj(DownloadInfo downloadInfo) {
        if (this.hf == null) {
            return this.u.xj(downloadInfo);
        }
        try {
            this.hf.xj(downloadInfo);
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.qt<CSJIndependentProcessDownloadService> qtVar;
        if (downloadTask == null || (qtVar = this.w) == null) {
            return;
        }
        qtVar.w(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        if (this.hf == null) {
            this.u.hf(i, list);
            return;
        }
        try {
            this.hf.xj(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, Notification notification) {
        if (this.hf == null) {
            com.ss.android.socialbase.downloader.w.xj.u(xj, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.w(xj, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.hf.xj(i, notification);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(boolean z, boolean z2) {
        if (this.hf == null) {
            com.ss.android.socialbase.downloader.w.xj.u(xj, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.w(xj, "aidlService.stopForeground");
        try {
            this.hf.xj(z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.qt<CSJIndependentProcessDownloadService> qtVar;
        if (downloadTask == null || (qtVar = this.w) == null) {
            return;
        }
        qtVar.hf(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.hf(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(com.ss.android.socialbase.downloader.model.hf hfVar) {
        if (this.hf == null) {
            this.u.xj(hfVar);
            return;
        }
        try {
            this.hf.xj(hfVar);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, long j) {
        if (this.hf == null) {
            this.u.xj(i, i2, j);
            return;
        }
        try {
            this.hf.xj(i, i2, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, int i3, long j) {
        if (this.hf == null) {
            this.u.xj(i, i2, i3, j);
            return;
        }
        try {
            this.hf.xj(i, i2, i3, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2, int i3, int i4) {
        if (this.hf == null) {
            this.u.xj(i, i2, i3, i4);
            return;
        }
        try {
            this.hf.xj(i, i2, i3, i4);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(wo woVar) {
        if (this.hf != null) {
            try {
                this.hf.xj(com.ss.android.socialbase.downloader.tf.c.xj(woVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, int i2) {
        if (this.hf != null) {
            try {
                this.hf.xj(i, i2);
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, io ioVar) {
        if (this.hf != null) {
            try {
                this.hf.xj(i, com.ss.android.socialbase.downloader.tf.c.xj(ioVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.am
    public void xj(IBinder iBinder) {
        this.hf = d.xj.xj(iBinder);
        if (com.ss.android.socialbase.downloader.tf.y.xj()) {
            xj(new wo() { // from class: com.ss.android.socialbase.downloader.impls.qt.1
                @Override // com.ss.android.socialbase.downloader.depend.wo
                public void xj(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).cancel(i);
                        }
                    } else {
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).pause(i);
                        List<com.ss.android.socialbase.downloader.model.hf> d = pl.xj(false).d(i);
                        if (d != null) {
                            pl.xj(true).xj(i, com.ss.android.socialbase.downloader.tf.y.xj(d));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.g
    public void xj(int i, long j) {
        if (this.hf == null) {
            return;
        }
        try {
            this.hf.xj(i, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }
}
