package com.ss.android.socialbase.downloader.y;

import ADYaiT.CtFAbx;
import android.os.Process;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private BaseException f13858a;
    private volatile boolean ai;
    private final com.ss.android.socialbase.downloader.f.xj am;
    private com.ss.android.socialbase.downloader.tf.kd b;
    volatile long c;
    String d;
    private volatile boolean dk;
    private long en;
    private volatile boolean et;
    String f;
    private boolean ff;
    private final DownloadInfo g;
    e hf;
    private volatile long ht;

    /* renamed from: io, reason: collision with root package name */
    private volatile boolean f13859io;
    private int j;
    private volatile long jk;
    volatile long kd;
    private int l;
    private final y p;

    /* renamed from: pl, reason: collision with root package name */
    private final w f13860pl;
    private int q;
    private com.ss.android.socialbase.downloader.network.d qt;
    private boolean r;
    private Future ra;
    String tf;
    volatile long u;
    private volatile long v;
    final int w;
    private boolean wo;
    private Thread x;
    volatile d xj;
    volatile long y;
    private long yo;
    private int z;
    private com.ss.android.socialbase.downloader.model.u zg;
    private final List<d> e = new ArrayList();
    private volatile long pz = -1;

    public g(DownloadInfo downloadInfo, p pVar, w wVar, e eVar, int i) {
        this.g = downloadInfo;
        this.p = pVar;
        this.f13860pl = wVar;
        this.am = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
        this.hf = eVar;
        this.w = i;
    }

    private void d() {
        this.en = this.u;
        this.u = -1L;
        this.kd = -1L;
        this.y = -1L;
        this.c = -1L;
        tf();
    }

    private long g() {
        long j = this.v;
        this.v = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    private void hf(d dVar) {
        w(dVar);
        this.p.xj(this, dVar, this.hf, this.zg);
        this.hf.w();
    }

    private void p() {
        this.ff = false;
        pl();
    }

    private void pl() {
        this.z = this.hf.u ? this.g.getRetryCount() : this.g.getBackUpUrlRetryCount();
        this.j = 0;
    }

    private void tf() {
        com.ss.android.socialbase.downloader.network.d dVar = this.qt;
        if (dVar != null) {
            try {
                com.ss.android.socialbase.downloader.w.xj.w("SegmentReader", "closeConnection: thread = " + this.w);
                dVar.u();
                dVar.w();
            } catch (Throwable unused) {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:187:0x0157
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void u(com.ss.android.socialbase.downloader.y.d r41) {
        /*
            Method dump skipped, instructions count: 1059
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.y.g.u(com.ss.android.socialbase.downloader.y.d):void");
    }

    private void w(d dVar) {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.d xj;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.kd = 0L;
                this.u = currentTimeMillis;
                this.yo = dVar.kd();
                this.jk = dVar.y();
                if (this.jk > 0 && this.yo > this.jk) {
                    throw new tf(6, "createConn, ".concat(String.valueOf(dVar)));
                }
                this.b = new com.ss.android.socialbase.downloader.tf.kd();
                List<com.ss.android.socialbase.downloader.model.w> xj2 = com.ss.android.socialbase.downloader.tf.y.xj(this.g.getExtraHeaders(), this.g.geteTag(), this.yo, this.jk);
                xj2.add(new com.ss.android.socialbase.downloader.model.w("Segment-Index", String.valueOf(dVar.c())));
                xj2.add(new com.ss.android.socialbase.downloader.model.w("Thread-Index", String.valueOf(this.w)));
                com.ss.android.socialbase.downloader.tf.y.xj(xj2, this.g);
                com.ss.android.socialbase.downloader.tf.y.hf(xj2, this.g);
                str = this.hf.xj;
                if (this.ff && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", Constants.HTTP);
                }
                str2 = this.hf.hf;
                com.ss.android.socialbase.downloader.w.xj.w("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + dVar + ", threadIndex = " + this.w);
                this.f = str;
                this.d = str2;
                xj = com.ss.android.socialbase.downloader.downloader.w.xj(this.g.isNeedDefaultHttpServiceBackUp(), this.g.getMaxBytes(), str, str2, xj2, 0, currentTimeMillis - this.en > 3000 && this.am.hf("monitor_download_connect") > 0, this.g);
            } catch (Throwable th) {
                this.kd = System.currentTimeMillis();
                throw th;
            }
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th2) {
            com.ss.android.socialbase.downloader.tf.y.xj(th2, "createConn");
        }
        if (xj == null) {
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        }
        this.qt = xj;
        this.zg = new com.ss.android.socialbase.downloader.model.u(str, xj);
        if (this.dk) {
            throw new zg("createConn");
        }
        if (xj instanceof com.ss.android.socialbase.downloader.network.xj) {
            this.tf = ((com.ss.android.socialbase.downloader.network.xj) xj).kd();
        }
        com.bytedance.sdk.component.utils.pl.xj("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.tf + ", threadIndex = " + this.w);
        this.kd = System.currentTimeMillis();
    }

    private boolean xj(d dVar) {
        p();
        while (true) {
            try {
                hf(dVar);
                u(dVar);
                d();
                return true;
            } catch (tf e) {
                this.f13858a = e;
                throw e;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.w.xj.kd("SegmentReader", "download: e = " + th + ", threadIndex = " + this.w + ", reconnect = " + this.et + ", closed = " + this.dk);
                    if (this.dk) {
                        d();
                        return false;
                    }
                    if (this.et) {
                        this.et = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            com.bytedance.sdk.component.utils.pl.xj(th2);
                        }
                        if (this.f13859io) {
                            this.f13859io = false;
                            throw new tf(5, "download");
                        }
                    } else {
                        com.bytedance.sdk.component.utils.pl.xj(th);
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.tf.y.xj((Throwable) th, "download");
                                e = null;
                            } catch (BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !xj(dVar, e)) {
                            d();
                            return false;
                        }
                    }
                    d();
                } catch (Throwable th3) {
                    d();
                    throw th3;
                }
            }
        }
    }

    public boolean c() {
        return this.wo;
    }

    public long f() {
        return this.yo;
    }

    public void kd() {
        com.ss.android.socialbase.downloader.w.xj.w("SegmentReader", "close: threadIndex = " + this.w);
        synchronized (this) {
            this.dk = true;
            this.ai = true;
        }
        tf();
        Future future = this.ra;
        if (future != null) {
            this.ra = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        d xj;
        y yVar;
        y yVar2;
        Process.setThreadPriority(10);
        try {
            this.x = Thread.currentThread();
            this.p.xj(this);
            this.hf.xj(this);
            while (true) {
                xj = this.p.xj(this, this.hf);
                if (xj == null) {
                    com.ss.android.socialbase.downloader.w.xj.w("SegmentReader", "no more segment, thread_index = " + this.w);
                    break;
                }
                this.xj = xj;
                try {
                    try {
                    } catch (tf e) {
                        com.ss.android.socialbase.downloader.w.xj.kd("SegmentReader", "run: SegmentApplyException, e = ".concat(String.valueOf(e)));
                        int i = this.q;
                        if (i >= 50) {
                            com.ss.android.socialbase.downloader.w.xj.kd("SegmentReader", "segment apply failed " + this.q + "times, thread_index = " + this.w);
                            this.xj = null;
                            yVar = this.p;
                            break;
                        }
                        this.q = i + 1;
                        this.xj = null;
                        yVar2 = this.p;
                    }
                    if (!xj(xj)) {
                        if (!this.dk) {
                            com.ss.android.socialbase.downloader.w.xj.kd("SegmentReader", "download segment failed, segment = " + xj + ", thread_index = " + this.w + ", failedException = " + this.f13858a);
                            break;
                        }
                        break;
                    }
                    this.e.add(xj);
                    this.xj = null;
                    yVar2 = this.p;
                    yVar2.xj(this, xj);
                } catch (Throwable th) {
                    this.xj = null;
                    this.p.xj(this, xj);
                    throw th;
                }
            }
            this.xj = null;
            yVar = this.p;
            yVar.xj(this, xj);
        } catch (Throwable th2) {
            try {
                com.bytedance.sdk.component.utils.pl.xj(th2);
                try {
                    this.hf.hf(this);
                    this.p.hf(this);
                } catch (Throwable unused) {
                }
                this.x = null;
            } finally {
                try {
                    this.hf.hf(this);
                    this.p.hf(this);
                } catch (Throwable unused2) {
                }
                this.x = null;
            }
        }
    }

    public void y() {
        xj(false);
    }

    public long hf() {
        long w;
        synchronized (this.p) {
            w = this.ht + w();
        }
        return w;
    }

    public void hf(boolean z) {
        this.wo = z;
    }

    public void hf(long j) {
        long j2 = this.pz;
        com.ss.android.socialbase.downloader.tf.kd kdVar = this.b;
        if (j2 < 0 || kdVar == null) {
            return;
        }
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("markProgress: curSegmentReadOffset = ", j2, ", threadIndex = ");
        B2KMhB2.append(this.w);
        com.bytedance.sdk.component.utils.pl.xj("SegmentReader", B2KMhB2.toString());
        kdVar.xj(j2, j);
    }

    public boolean xj(e eVar) {
        int i = this.l;
        if (i >= 30) {
            return false;
        }
        this.l = i + 1;
        e eVar2 = this.hf;
        if (eVar2 != null) {
            eVar2.hf(this);
        }
        eVar.xj(this);
        this.hf = eVar;
        pl();
        return true;
    }

    private boolean xj(d dVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.w.xj.kd("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.j + ", retryCount = " + this.z);
        this.f13858a = baseException;
        this.hf.hf();
        this.p.xj(this, this.hf, dVar, baseException, this.j, this.z);
        int i = this.j;
        if (i < this.z) {
            this.j = i + 1;
            return true;
        }
        if (xj(baseException)) {
            return true;
        }
        this.p.xj(this, this.hf, dVar, baseException);
        return false;
    }

    public long w() {
        synchronized (this.p) {
            try {
                long j = this.pz;
                long j2 = this.yo;
                if (j2 < 0 || j <= j2) {
                    return 0L;
                }
                return j - j2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean xj(BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.tf.y.w(baseException)) {
            return false;
        }
        String str = this.hf.xj;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.g.isNeedHttpsToHttpRetry() || this.ff) {
            return false;
        }
        this.ff = true;
        pl();
        return true;
    }

    public void w(boolean z) {
        this.r = z;
    }

    private xj xj(w wVar, InputStream inputStream) {
        int i;
        xj hf = wVar.hf();
        try {
            i = inputStream.read(hf.xj);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i != -1) {
                hf.w = i;
                if (i == -1) {
                    wVar.xj(hf);
                }
                return hf;
            }
            throw new BaseException(1073, "probe");
        } catch (Throwable th2) {
            th = th2;
            if (i == -1) {
                wVar.xj(hf);
            }
            throw th;
        }
    }

    public boolean xj(long j) {
        long j2 = this.jk;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.v = j;
        this.ai = true;
        return true;
    }

    public void xj() {
        e eVar = this.hf;
        try {
            synchronized (this.p) {
                try {
                    long w = w();
                    if (w > 0) {
                        this.ht += w;
                        eVar.xj(w);
                    }
                    this.pz = -1L;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(boolean z) {
        com.ss.android.socialbase.downloader.w.xj.w("SegmentReader", "reconnect: threadIndex = " + this.w);
        synchronized (this) {
            this.f13859io = z;
            this.et = true;
            this.ai = true;
        }
        tf();
        Thread thread = this.x;
        if (thread != null) {
            try {
                com.bytedance.sdk.component.utils.pl.xj("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.w);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void xj(Future future) {
        this.ra = future;
    }

    public long xj(long j, long j2) {
        com.ss.android.socialbase.downloader.tf.kd kdVar = this.b;
        if (kdVar == null) {
            return -1L;
        }
        return kdVar.hf(j, j2);
    }

    public long u() {
        return this.pz;
    }
}
