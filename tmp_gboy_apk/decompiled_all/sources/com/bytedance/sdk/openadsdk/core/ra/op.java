package com.bytedance.sdk.openadsdk.core.ra;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class op {
    private int hf;
    private int w;
    private int xj;
    private int u = 1;
    private int kd = 0;

    private int c() {
        return com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext()));
    }

    private int y() {
        return com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), com.bytedance.sdk.openadsdk.core.a.r.kd(com.bytedance.sdk.openadsdk.core.pz.getContext()));
    }

    public int hf() {
        return this.hf;
    }

    public int kd() {
        return this.kd;
    }

    public int u() {
        return this.u == 2 ? 2 : 1;
    }

    public int w() {
        return this.w;
    }

    public int xj() {
        return this.xj;
    }

    public void hf(int i) {
        if (i <= 0 || i >= c()) {
            this.hf = 16;
        } else {
            this.hf = i;
        }
    }

    public void kd(int i) {
        this.kd = i;
    }

    public void u(int i) {
        this.u = i;
    }

    public void w(int i) {
        if (i > 0 && i < y()) {
            this.w = i;
            return;
        }
        int i2 = this.xj;
        if (i2 == 3 || i2 == 4) {
            this.w = 30;
        } else {
            this.w = 16;
        }
    }

    public void xj(int i) {
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            this.xj = i;
        } else {
            this.xj = 2;
        }
    }

    public static boolean xj(ws wsVar) {
        return (wsVar == null || wsVar.dx() == null || wsVar.dx().kd() != 1) ? false : true;
    }
}
