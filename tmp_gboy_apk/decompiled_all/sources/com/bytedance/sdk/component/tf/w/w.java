package com.bytedance.sdk.component.tf.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends com.bytedance.sdk.component.tf.xj.w implements Runnable {
    final Runnable u;

    public w(Runnable runnable) {
        super(runnable);
        this.u = runnable;
        hf(false);
        xj(false);
    }

    @Override // com.bytedance.sdk.component.tf.xj.w, java.lang.Runnable
    public void run() {
        this.u.run();
    }
}
