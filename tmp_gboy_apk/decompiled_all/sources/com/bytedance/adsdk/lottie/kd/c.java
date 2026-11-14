package com.bytedance.adsdk.lottie.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    private int hf;
    private float xj;

    public void xj(float f) {
        float f2 = this.xj + f;
        this.xj = f2;
        int i = this.hf + 1;
        this.hf = i;
        if (i == Integer.MAX_VALUE) {
            this.xj = f2 / 2.0f;
            this.hf = i / 2;
        }
    }
}
