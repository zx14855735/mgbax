package com.bytedance.sdk.openadsdk.core.component.splash.w.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends xj {
    private long c;
    private long d;
    private long f;
    private boolean kd;
    private com.bytedance.sdk.openadsdk.core.ra.xj u;
    private long y;

    public y(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, boolean z) {
        this.u = xjVar;
        if (xjVar != null && xjVar.hf() != null && !this.u.hf().isEmpty()) {
            this.hf = this.u.hf().get(0);
        }
        this.kd = z;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public long f() {
        return this.f;
    }

    public void hf(long j) {
        this.y = j;
    }

    public boolean kd() {
        return this.kd;
    }

    public com.bytedance.sdk.openadsdk.core.ra.xj u() {
        return this.u;
    }

    public void w(long j) {
        this.c = j;
    }

    public long y() {
        return this.y;
    }

    public void kd(long j) {
        this.d = j;
    }

    public void u(long j) {
        this.f = j;
    }
}
