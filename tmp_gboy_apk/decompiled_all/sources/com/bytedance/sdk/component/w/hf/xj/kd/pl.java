package com.bytedance.sdk.component.w.hf.xj.kd;

import java.util.concurrent.CountDownLatch;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class pl {
    private final CountDownLatch xj = new CountDownLatch(1);
    private long hf = -1;
    private long w = -1;

    public void hf() {
        if (this.w != -1 || this.hf == -1) {
            throw new IllegalStateException();
        }
        this.w = System.nanoTime();
        this.xj.countDown();
    }

    public void w() {
        if (this.w == -1) {
            long j = this.hf;
            if (j != -1) {
                this.w = j - 1;
                this.xj.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void xj() {
        if (this.hf != -1) {
            throw new IllegalStateException();
        }
        this.hf = System.nanoTime();
    }
}
