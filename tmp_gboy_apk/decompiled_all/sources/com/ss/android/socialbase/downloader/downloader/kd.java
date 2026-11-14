package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    private static String hf = "ResponseHandler";
    private long ai;
    private final com.ss.android.socialbase.downloader.d.y am;
    private tf c;
    private jk d;
    private final long dk;
    private volatile long e;
    private final boolean et;
    private com.ss.android.socialbase.downloader.impls.p f;
    private volatile boolean g;
    private final boolean ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f13845io;
    private final com.ss.android.socialbase.downloader.f.xj jk;
    private final com.ss.android.socialbase.downloader.model.hf kd;
    private BaseException p;

    /* renamed from: pl, reason: collision with root package name */
    private volatile boolean f13846pl;
    private final com.ss.android.socialbase.downloader.xj.xj pz;
    private long q;
    private long qt;
    private final long ra;
    private com.ss.android.socialbase.downloader.model.kd tf;
    private final String u;
    private final boolean v;
    private final DownloadInfo w;
    private long x;
    private final com.ss.android.socialbase.downloader.network.d y;
    private volatile long yo;
    private long z;
    private long zg;
    boolean xj = false;
    private volatile long j = 0;
    private volatile long en = 0;

    public kd(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.d dVar, com.ss.android.socialbase.downloader.model.hf hfVar, com.ss.android.socialbase.downloader.d.y yVar) {
        this.w = downloadInfo;
        this.u = str;
        tf et = w.et();
        this.c = et;
        if (et instanceof com.ss.android.socialbase.downloader.impls.u) {
            com.ss.android.socialbase.downloader.impls.u uVar = (com.ss.android.socialbase.downloader.impls.u) et;
            this.f = uVar.xj();
            this.d = uVar.y();
        }
        this.y = dVar;
        this.kd = hfVar;
        this.am = yVar;
        long am = hfVar.am();
        this.qt = am;
        this.zg = am;
        if (hfVar.u()) {
            this.yo = hfVar.e();
        } else {
            this.yo = hfVar.w(false);
        }
        this.e = hfVar.zg();
        this.pz = com.ss.android.socialbase.downloader.xj.xj.xj();
        com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
        this.jk = xj;
        boolean z = xj.xj("sync_strategy", 0) == 1;
        this.ht = z;
        if (z) {
            long xj2 = xj.xj("sync_interval_ms_fg", 5000);
            long xj3 = xj.xj("sync_interval_ms_bg", 1000);
            this.ra = Math.max(xj2, 500L);
            this.dk = Math.max(xj3, 500L);
        } else {
            this.ra = 0L;
            this.dk = 0L;
        }
        this.et = xj.hf("monitor_rw") == 1;
        this.v = com.ss.android.socialbase.downloader.tf.xj.xj(65536);
    }

    private void c() {
        ExecutorService pl2;
        if (this.y == null || (pl2 = w.pl()) == null) {
            return;
        }
        pl2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.kd.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    kd.this.y.u();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void f() {
        long nanoTime = this.et ? System.nanoTime() : 0L;
        try {
            this.tf.xj();
            this.w.updateRealDownloadTime(true);
            boolean z = this.w.getChunkCount() > 1;
            g xj = com.ss.android.socialbase.downloader.impls.pl.xj(com.ss.android.socialbase.downloader.tf.y.hf());
            if (z) {
                xj(this.d);
                if (xj != null) {
                    xj.w(this.w);
                } else {
                    this.d.xj(this.w.getId(), this.w.getCurBytes());
                }
            } else if (xj != null) {
                xj.w(this.w);
            } else {
                this.d.xj(this.kd.p(), this.qt);
            }
            this.j = this.qt;
        } catch (Exception unused) {
        }
        if (this.et) {
            this.q += System.nanoTime() - nanoTime;
        }
    }

    private boolean hf(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private boolean y() {
        return this.f13846pl || this.g;
    }

    public long kd() {
        return this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0369 A[Catch: all -> 0x0373, TRY_ENTER, TryCatch #11 {all -> 0x0373, blocks: (B:147:0x02fc, B:183:0x0369, B:185:0x036f, B:187:0x0376, B:221:0x043a, B:222:0x043c, B:239:0x043d, B:241:0x0456, B:274:0x04ad, B:276:0x04b3, B:277:0x04b6, B:278:0x04b8), top: B:8:0x0028, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04b3 A[Catch: all -> 0x0373, TryCatch #11 {all -> 0x0373, blocks: (B:147:0x02fc, B:183:0x0369, B:185:0x036f, B:187:0x0376, B:221:0x043a, B:222:0x043c, B:239:0x043d, B:241:0x0456, B:274:0x04ad, B:276:0x04b3, B:277:0x04b6, B:278:0x04b8), top: B:8:0x0028, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u() {
        /*
            Method dump skipped, instructions count: 1354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.kd.u():void");
    }

    public void w() {
        if (this.g) {
            return;
        }
        synchronized (this.am) {
            this.g = true;
        }
        c();
    }

    public void hf() {
        if (this.f13846pl) {
            return;
        }
        this.f13846pl = true;
        c();
    }

    public long xj() {
        return this.qt;
    }

    public void xj(long j, long j2, long j3) {
        this.qt = j;
        this.zg = j;
        this.e = j2;
        this.yo = j3;
    }

    public void xj(long j, long j2) {
        this.e = j;
        this.yo = j2;
    }

    private com.ss.android.socialbase.downloader.kd.hf xj(InputStream inputStream) {
        int a2 = w.a();
        if (this.jk.xj("rw_concurrent", 0) == 1 && this.w.getChunkCount() == 1 && this.w.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.kd.xj xjVar = new com.ss.android.socialbase.downloader.kd.xj(inputStream, a2, this.jk.xj("rw_concurrent_max_buffer_count", 4));
                this.f13845io = true;
                return xjVar;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
        com.ss.android.socialbase.downloader.kd.w wVar = new com.ss.android.socialbase.downloader.kd.w(inputStream, a2);
        this.f13845io = false;
        return wVar;
    }

    private void xj(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.en;
        if (this.ht) {
            if (j <= (this.pz.hf() ? this.ra : this.dk)) {
                return;
            }
        } else {
            long j2 = this.qt - this.j;
            if (!z && !hf(j2, j)) {
                return;
            }
        }
        f();
        this.en = uptimeMillis;
    }

    private void xj(tf tfVar) {
        g gVar;
        com.ss.android.socialbase.downloader.model.hf hfVar;
        tf tfVar2;
        if (tfVar == null) {
            return;
        }
        boolean z = tfVar instanceof com.ss.android.socialbase.downloader.hf.kd;
        if (z) {
            gVar = com.ss.android.socialbase.downloader.impls.pl.xj(com.ss.android.socialbase.downloader.tf.y.hf());
            if (gVar == null) {
                return;
            }
        } else {
            gVar = null;
        }
        g gVar2 = gVar;
        if (this.kd.u()) {
            hfVar = this.kd.kd();
        } else {
            hfVar = this.kd;
        }
        if (hfVar != null) {
            hfVar.hf(this.qt);
            if (z && gVar2 != null) {
                gVar2.xj(hfVar.p(), hfVar.v(), hfVar.hf(), this.qt);
                tfVar2 = tfVar;
            } else {
                tfVar2 = tfVar;
                tfVar2.xj(hfVar.p(), hfVar.v(), hfVar.hf(), this.qt);
            }
            if (hfVar.f()) {
                if (hfVar.d()) {
                    long tf = hfVar.tf();
                    if (tf > this.qt) {
                        if (z && gVar2 != null) {
                            gVar2.xj(hfVar.p(), hfVar.hf(), tf);
                            return;
                        } else {
                            tfVar2.xj(hfVar.p(), hfVar.hf(), tf);
                            return;
                        }
                    }
                }
                if (z && gVar2 != null) {
                    gVar2.xj(hfVar.p(), hfVar.hf(), this.qt);
                    return;
                } else {
                    tfVar2.xj(hfVar.p(), hfVar.hf(), this.qt);
                    return;
                }
            }
            return;
        }
        if (this.kd.u()) {
            if (z && gVar2 != null) {
                gVar2.xj(this.kd.p(), this.kd.v(), this.qt);
            } else {
                tfVar.xj(this.kd.p(), this.kd.v(), this.qt);
            }
        }
    }
}
