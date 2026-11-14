package com.ss.android.socialbase.downloader.y;

import com.fl.saas.videocache.ProxyCacheUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class hf implements kd, u, w {
    private xj c;
    private xj d;
    private xj f;
    private final int hf;
    private xj kd;
    private int p;
    private volatile boolean tf;
    private final int xj;
    private xj y;
    private final Object w = new Object();
    private final Object u = new Object();

    public hf(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? ProxyCacheUtils.DEFAULT_BUFFER_SIZE : i2;
        this.xj = i;
        this.hf = i2;
    }

    @Override // com.ss.android.socialbase.downloader.y.w
    public xj hf() {
        synchronized (this.w) {
            try {
                if (this.tf) {
                    throw new zg("obtain");
                }
                xj xjVar = this.kd;
                if (xjVar == null) {
                    int i = this.p;
                    if (i < this.xj) {
                        this.p = i + 1;
                        return new xj(this.hf);
                    }
                    do {
                        this.w.wait();
                        if (this.tf) {
                            throw new zg("obtain");
                        }
                        xjVar = this.kd;
                    } while (xjVar == null);
                }
                this.kd = xjVar.u;
                if (xjVar == this.y) {
                    this.y = null;
                }
                xjVar.u = null;
                return xjVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void w() {
        this.tf = true;
        synchronized (this.w) {
            this.w.notifyAll();
        }
        synchronized (this.u) {
            this.u.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.u
    public xj xj() {
        xj xjVar;
        xj xjVar2 = this.d;
        if (xjVar2 != null) {
            this.d = xjVar2.u;
            xjVar2.u = null;
            return xjVar2;
        }
        synchronized (this.u) {
            try {
                xjVar = this.c;
                while (xjVar == null) {
                    if (this.tf) {
                        throw new zg("read");
                    }
                    this.u.wait();
                    xjVar = this.c;
                }
                this.d = xjVar.u;
                this.f = null;
                this.c = null;
                xjVar.u = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xjVar;
    }

    @Override // com.ss.android.socialbase.downloader.y.w
    public void xj(xj xjVar) {
        synchronized (this.w) {
            try {
                xj xjVar2 = this.y;
                if (xjVar2 == null) {
                    this.y = xjVar;
                    this.kd = xjVar;
                } else {
                    xjVar2.u = xjVar;
                    this.y = xjVar;
                }
                this.w.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.kd
    public void hf(xj xjVar) {
        synchronized (this.u) {
            try {
                xj xjVar2 = this.f;
                if (xjVar2 == null) {
                    this.f = xjVar;
                    this.c = xjVar;
                    this.u.notify();
                } else {
                    xjVar2.u = xjVar;
                    this.f = xjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
