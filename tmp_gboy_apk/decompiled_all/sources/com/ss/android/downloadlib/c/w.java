package com.ss.android.downloadlib.c;

import java.lang.ref.SoftReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w<P, R> implements Runnable {
    private R hf;
    private w<?, P> kd;
    private SoftReference<xj<P, R>> u;
    private int w;
    private P xj;
    private w<R, ?> y;

    public interface xj<PARAM, RESULT> {
        RESULT xj(PARAM param);
    }

    private w(int i, xj<P, R> xjVar, P p) {
        this.w = i;
        this.u = new SoftReference<>(xjVar);
        this.xj = p;
    }

    private R hf() {
        return this.hf;
    }

    public static <P, R> w<P, R> xj(xj<P, R> xjVar, P p) {
        return new w<>(2, xjVar, p);
    }

    @Override // java.lang.Runnable
    public void run() {
        w<?, P> wVar;
        if (this.w == 0 && !g.hf()) {
            com.ss.android.downloadlib.f.xj().hf().post(this);
            return;
        }
        if (this.w == 1 && g.hf()) {
            com.ss.android.downloadlib.kd.xj().xj(this);
            return;
        }
        if (this.w == 2 && g.hf()) {
            com.ss.android.downloadlib.kd.xj().hf(this);
            return;
        }
        if (this.xj == null && (wVar = this.kd) != null) {
            this.xj = wVar.hf();
        }
        xj<P, R> xjVar = this.u.get();
        if (xjVar == null) {
            return;
        }
        this.hf = xjVar.xj(this.xj);
        w<R, ?> wVar2 = this.y;
        if (wVar2 != null) {
            wVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> w<R, NR> xj(int i, xj<R, NR> xjVar) {
        w wVar = (w<R, ?>) new w(i, xjVar, null);
        this.y = wVar;
        wVar.kd = this;
        return wVar;
    }

    public <NR> w<R, NR> xj(xj<R, NR> xjVar) {
        return xj(0, xjVar);
    }

    public void xj() {
        w<?, P> wVar = this.kd;
        if (wVar != null) {
            wVar.xj();
        } else {
            run();
        }
    }
}
