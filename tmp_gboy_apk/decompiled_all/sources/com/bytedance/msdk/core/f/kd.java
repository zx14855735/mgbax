package com.bytedance.msdk.core.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private long hf;
    private int kd;
    private long u;
    private String w;
    private int xj;

    public long hf() {
        return this.hf;
    }

    public int kd() {
        return this.kd;
    }

    public long u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public void xj(kd kdVar) {
        this.xj = kdVar.xj();
        this.hf = kdVar.hf();
        this.w = kdVar.w();
        this.u = kdVar.u();
        this.kd = kdVar.kd();
    }

    public void hf(long j) {
        this.u = j;
    }

    public void hf(int i) {
        this.kd = i;
    }

    public int xj() {
        return this.xj;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public void xj(long j) {
        this.hf = j;
    }

    public void xj(String str) {
        this.w = str;
    }
}
