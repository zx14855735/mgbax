package com.bytedance.sdk.component.hf.xj.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class kd implements Runnable {
    protected final String hf;

    public kd(String str, Object... objArr) {
        this.hf = tf.xj(str, objArr);
    }

    public abstract void hf();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.hf);
        try {
            hf();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
