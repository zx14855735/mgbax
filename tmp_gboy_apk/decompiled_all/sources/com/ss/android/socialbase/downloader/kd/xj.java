package com.ss.android.socialbase.downloader.kd;

import android.os.Process;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.tf.y;
import com.ss.android.socialbase.downloader.y.zg;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements hf {
    private volatile Throwable am;
    private com.ss.android.socialbase.downloader.y.xj c;
    private com.ss.android.socialbase.downloader.y.xj d;
    private com.ss.android.socialbase.downloader.y.xj f;
    private volatile boolean g;
    private final int hf;
    private com.ss.android.socialbase.downloader.y.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private volatile boolean f13852pl;
    private volatile Future qt;
    private com.ss.android.socialbase.downloader.y.xj tf;
    private final int w;
    private final InputStream xj;
    private com.ss.android.socialbase.downloader.y.xj y;
    private int zg;
    private final Object u = new Object();
    private final Object kd = new Object();
    private final Runnable e = new Runnable() { // from class: com.ss.android.socialbase.downloader.kd.xj.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.y.xj u;
            Process.setThreadPriority(10);
            do {
                try {
                    u = xj.this.u();
                    u.w = xj.this.xj.read(u.xj);
                    xj.this.w(u);
                } catch (Throwable th) {
                    try {
                        xj.this.am = th;
                        pl.xj(th);
                        synchronized (xj.this.kd) {
                            xj.this.g = true;
                            xj.this.kd.notify();
                            y.xj(xj.this.xj);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (xj.this.kd) {
                            xj.this.g = true;
                            xj.this.kd.notify();
                            y.xj(xj.this.xj);
                            throw th2;
                        }
                    }
                }
            } while (u.w != -1);
            synchronized (xj.this.kd) {
                xj.this.g = true;
                xj.this.kd.notify();
            }
            y.xj(xj.this.xj);
        }
    };

    public xj(InputStream inputStream, int i, int i2) {
        this.xj = inputStream;
        this.hf = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.w = i2;
        w();
    }

    private com.ss.android.socialbase.downloader.y.xj kd() {
        com.ss.android.socialbase.downloader.y.xj xjVar;
        com.ss.android.socialbase.downloader.y.xj xjVar2 = this.p;
        if (xjVar2 != null) {
            this.p = xjVar2.u;
            xjVar2.u = null;
            return xjVar2;
        }
        synchronized (this.kd) {
            try {
                xjVar = this.d;
                if (xjVar == null) {
                    do {
                        if (this.g) {
                            y();
                        }
                        this.kd.wait();
                        xjVar = this.d;
                    } while (xjVar == null);
                }
                this.p = xjVar.u;
                this.tf = null;
                this.d = null;
                xjVar.u = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.y.xj u() {
        int i;
        com.ss.android.socialbase.downloader.y.xj xjVar = this.f;
        if (xjVar != null) {
            if (this.f13852pl) {
                throw new zg("");
            }
            this.f = xjVar.u;
            xjVar.u = null;
            return xjVar;
        }
        synchronized (this.u) {
            try {
                if (this.f13852pl) {
                    throw new zg("");
                }
                com.ss.android.socialbase.downloader.y.xj xjVar2 = this.y;
                if (xjVar2 == null && (i = this.zg) < this.w) {
                    this.zg = i + 1;
                    return new com.ss.android.socialbase.downloader.y.xj(this.hf);
                }
                while (xjVar2 == null) {
                    this.u.wait();
                    if (this.f13852pl) {
                        throw new zg("");
                    }
                    xjVar2 = this.y;
                }
                this.f = xjVar2.u;
                this.c = null;
                this.y = null;
                xjVar2.u = null;
                return xjVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void y() {
        Throwable th = this.am;
        if (th != null) {
            if (th instanceof zg) {
                throw new BaseException(1068, "async reader closed!");
            }
            y.xj(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private void w() {
        this.qt = com.ss.android.socialbase.downloader.downloader.w.e().submit(this.e);
    }

    @Override // com.ss.android.socialbase.downloader.kd.hf
    public void hf() {
        synchronized (this.u) {
            this.f13852pl = true;
            this.u.notify();
        }
        Future future = this.qt;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.qt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.ss.android.socialbase.downloader.y.xj xjVar) {
        synchronized (this.kd) {
            try {
                com.ss.android.socialbase.downloader.y.xj xjVar2 = this.tf;
                if (xjVar2 == null) {
                    this.tf = xjVar;
                    this.d = xjVar;
                    this.kd.notify();
                } else {
                    xjVar2.u = xjVar;
                    this.tf = xjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kd.hf
    public com.ss.android.socialbase.downloader.y.xj xj() {
        return kd();
    }

    @Override // com.ss.android.socialbase.downloader.kd.hf
    public void xj(com.ss.android.socialbase.downloader.y.xj xjVar) {
        hf(xjVar);
    }

    private void hf(com.ss.android.socialbase.downloader.y.xj xjVar) {
        synchronized (this.u) {
            try {
                com.ss.android.socialbase.downloader.y.xj xjVar2 = this.c;
                if (xjVar2 == null) {
                    this.c = xjVar;
                    this.y = xjVar;
                    this.u.notify();
                } else {
                    xjVar2.u = xjVar;
                    this.c = xjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
