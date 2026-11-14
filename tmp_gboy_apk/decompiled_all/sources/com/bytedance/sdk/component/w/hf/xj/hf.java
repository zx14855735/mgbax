package com.bytedance.sdk.component.w.hf.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf implements Runnable {
    protected final String hf;

    public hf(String str, Object... objArr) {
        this.hf = w.xj(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.hf);
        try {
            w();
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    public abstract void w();
}
