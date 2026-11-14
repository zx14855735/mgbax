package com.bytedance.msdk.w.c.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements Runnable {
    private Runnable hf;
    private boolean w = false;
    private com.bytedance.msdk.core.tf.hf xj;

    public hf(com.bytedance.msdk.core.tf.hf hfVar, Runnable runnable) {
        this.xj = hfVar;
        this.hf = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.msdk.core.tf.hf hfVar = this.xj;
        if (hfVar != null && hfVar.c() == 4) {
            this.xj.y().put("serverBidding_timeout", Boolean.TRUE);
        }
        this.w = true;
        Runnable runnable = this.hf;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean xj() {
        return this.w;
    }
}
