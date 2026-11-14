package com.bytedance.sdk.component.xj;

import com.bytedance.component.sdk.annotation.CallSuper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class u<P, R> extends com.bytedance.sdk.component.xj.hf<P, R> {
    private xj hf;
    private y w;
    private boolean xj = true;

    public interface hf {
        u xj();
    }

    public interface xj {
        void xj(Object obj);

        void xj(Throwable th);
    }

    private boolean c() {
        if (this.xj) {
            return true;
        }
        d.xj(new IllegalStateException("Jsb async call already finished: " + xj() + ", hashcode: " + hashCode()));
        return false;
    }

    @CallSuper
    public void kd() {
        this.xj = false;
        this.w = null;
    }

    public abstract void u();

    public final void w() {
        xj((Throwable) null);
    }

    @Override // com.bytedance.sdk.component.xj.hf
    public /* bridge */ /* synthetic */ String xj() {
        return super.xj();
    }

    public abstract void xj(P p, y yVar);

    public void y() {
        u();
        kd();
    }

    public final void xj(R r) {
        if (c()) {
            this.hf.xj(r);
            kd();
        }
    }

    public final void xj(Throwable th) {
        if (c()) {
            this.hf.xj(th);
            kd();
        }
    }

    public void xj(P p, y yVar, xj xjVar) {
        this.w = yVar;
        this.hf = xjVar;
        xj(p, yVar);
    }
}
