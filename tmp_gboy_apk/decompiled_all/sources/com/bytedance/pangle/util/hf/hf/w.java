package com.bytedance.pangle.util.hf.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private int c;
    private long d;
    private String f;
    private int kd;
    private int xj;
    private int y;
    private long hf = 0;
    private long w = 0;
    private long u = 0;
    private final long tf = 30;

    public long c() {
        return this.hf;
    }

    public long d() {
        return this.u;
    }

    public long f() {
        return this.w;
    }

    public long g() {
        return this.d;
    }

    public long hf() {
        long j = this.w;
        return j > 0 ? j : this.u;
    }

    public long kd() {
        return 28L;
    }

    public int p() {
        return this.y;
    }

    public String pl() {
        return this.f;
    }

    public int tf() {
        return this.kd;
    }

    public long u() {
        return this.kd + 30 + this.c;
    }

    public long w() {
        return hf() + u();
    }

    public int xj() {
        return this.xj;
    }

    public int y() {
        return this.c;
    }

    public void u(int i) {
        this.y = i;
    }

    public void w(long j) {
        this.u = j;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public void hf(int i) {
        this.c = i;
    }

    public void u(long j) {
        this.d = j;
    }

    public void w(int i) {
        this.kd = i;
    }

    public void xj(long j) {
        this.hf = j;
    }

    public void hf(long j) {
        this.w = j;
    }

    public void xj(String str) {
        this.f = str;
    }
}
