package com.ss.android.socialbase.downloader.hf;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.jk;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.hf.hf;
import com.ss.android.socialbase.downloader.hf.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.y.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y implements ServiceConnection, jk {
    private static boolean hf;
    private static long u;
    private static int w;
    private w.xj.InterfaceC0498xj c;
    private Future<?> d;
    private w xj;
    private Handler kd = new Handler(Looper.getMainLooper());
    private hf y = null;
    private Runnable f = new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.y.1
        @Override // java.lang.Runnable
        public void run() {
            if (y.hf || y.this.c == null) {
                return;
            }
            y.this.c.xj();
        }
    };
    private CountDownLatch tf = new CountDownLatch(1);

    public y() {
        SqlDownloadCacheService.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo d(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.d(i);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void g(int i) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        hf = true;
        this.kd.removeCallbacks(this.f);
        try {
            this.xj = w.xj.xj(iBinder);
        } catch (Throwable th) {
            pl.xj(th);
        }
        this.d = com.ss.android.socialbase.downloader.downloader.w.pl().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.y.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (y.this.y != null && y.this.xj != null) {
                                y.this.xj.xj(y.this.y);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.hf.y.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = y.hf = false;
                                    if (y.this.c() || y.this.c == null) {
                                        return;
                                    }
                                    y.this.kd.postDelayed(y.this.f, 2000L);
                                }
                            };
                        } catch (Throwable th2) {
                            try {
                                com.ss.android.socialbase.downloader.w.xj.hf("SqlDownloadCacheAidlWra", "onServiceConnected fail", th2);
                                if (y.this.c != null) {
                                    y.this.c.xj();
                                }
                                y.this.tf.countDown();
                                iBinder2 = iBinder;
                                deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.hf.y.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = y.hf = false;
                                        if (y.this.c() || y.this.c == null) {
                                            return;
                                        }
                                        y.this.kd.postDelayed(y.this.f, 2000L);
                                    }
                                };
                            } finally {
                                y.this.tf.countDown();
                                try {
                                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.hf.y.2.1
                                        @Override // android.os.IBinder.DeathRecipient
                                        public void binderDied() {
                                            boolean unused = y.hf = false;
                                            if (y.this.c() || y.this.c == null) {
                                                return;
                                            }
                                            y.this.kd.postDelayed(y.this.f, 2000L);
                                        }
                                    }, 0);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        iBinder2.linkToDeath(deathRecipient, 0);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.xj = null;
        hf = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public Map<Long, d> pl(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo tf(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.tf(i);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public ArrayList<d> am(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (Build.VERSION.SDK_INT >= 26 || hf) {
            return false;
        }
        if (w > 5) {
            com.ss.android.socialbase.downloader.w.xj.u("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - u < 15000) {
            com.ss.android.socialbase.downloader.w.xj.u("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        w++;
        u = currentTimeMillis;
        this.kd.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.y.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), y.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo f(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.f(i);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo hf(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.hf(i);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean kd(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.kd(i);
            }
            return false;
        } catch (RemoteException e) {
            pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> u(String str) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.u(str);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> w(String str) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.w(str);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean xj(int i, Map<Long, d> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean y(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.y(i);
            }
            return false;
        } catch (RemoteException e) {
            pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> hf(String str) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.hf(str);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean kd() {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.kd();
            }
            return false;
        } catch (RemoteException e) {
            pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void u(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.u(i);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<com.ss.android.socialbase.downloader.model.hf> w(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.w(i);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    public void xj(w.xj.InterfaceC0498xj interfaceC0498xj) {
        this.c = interfaceC0498xj;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.jk
    public void xj(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> sparseArray2, final u uVar) {
        com.ss.android.socialbase.downloader.downloader.w.pl().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.hf.y.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                u uVar2;
                Future future;
                y.this.xj(new hf.xj() { // from class: com.ss.android.socialbase.downloader.hf.y.4.1
                    @Override // com.ss.android.socialbase.downloader.hf.hf
                    public void xj(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.tf.y.xj(sparseArray, map);
                        com.ss.android.socialbase.downloader.tf.y.xj(sparseArray2, map2);
                        uVar.xj();
                        y.this.xj((hf) null);
                    }
                });
                try {
                    z = !y.this.tf.await(PushUIConfig.dismissTime, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    pl.xj(th);
                    z = false;
                }
                if (z && (future = y.this.d) != null) {
                    future.cancel(true);
                }
                y.this.xj();
                if (!z || (uVar2 = uVar) == null) {
                    return;
                }
                uVar2.xj();
            }
        });
    }

    public void xj(hf hfVar) {
        synchronized (this) {
            w wVar = this.xj;
            if (wVar != null) {
                try {
                    wVar.xj(hfVar);
                } catch (RemoteException e) {
                    pl.xj(e);
                }
            } else {
                this.y = hfVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> hf() {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.hf();
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo u(int i, long j) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.u(i, j);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void w() {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.w();
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(com.ss.android.socialbase.downloader.model.hf hfVar) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.hf(hfVar);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean u() {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.u();
            }
            return false;
        } catch (RemoteException e) {
            pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo w(int i, long j) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.w(i, j);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo c(int i) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.c(i);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    public void xj() {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.xj();
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo hf(int i, long j) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.hf(i, j);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public List<DownloadInfo> xj(String str) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.xj(str);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(DownloadInfo downloadInfo) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.hf(downloadInfo);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(com.ss.android.socialbase.downloader.model.hf hfVar) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.xj(hfVar);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.hf(i, list);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, int i2, long j) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.xj(i, i2, j);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, int i2, int i3, long j) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.xj(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, int i2, int i3, int i4) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.xj(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, int i2) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.xj(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean xj(DownloadInfo downloadInfo) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.xj(downloadInfo);
            }
            return false;
        } catch (RemoteException e) {
            pl.xj(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j, String str, String str2) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.xj(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                return wVar.xj(i, j);
            }
            return null;
        } catch (RemoteException e) {
            pl.xj(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        try {
            w wVar = this.xj;
            if (wVar != null) {
                wVar.xj(i, list);
            }
        } catch (RemoteException e) {
            pl.xj(e);
        }
    }
}
