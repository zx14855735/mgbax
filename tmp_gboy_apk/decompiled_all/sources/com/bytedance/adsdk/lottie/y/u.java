package com.bytedance.adsdk.lottie.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private float hf;
    private float xj;

    public u(float f, float f2) {
        this.xj = f;
        this.hf = f2;
    }

    public float hf() {
        return this.hf;
    }

    public String toString() {
        return xj() + "x" + hf();
    }

    public float xj() {
        return this.xj;
    }

    public boolean hf(float f, float f2) {
        return this.xj == f && this.hf == f2;
    }

    public void xj(float f, float f2) {
        this.xj = f;
        this.hf = f2;
    }

    public u() {
        this(1.0f, 1.0f);
    }
}
