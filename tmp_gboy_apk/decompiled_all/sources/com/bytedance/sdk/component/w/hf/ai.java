package com.bytedance.sdk.component.w.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ai {
    long c;
    long hf;
    long kd;
    long u;
    long w;
    long xj = System.currentTimeMillis();
    long y;

    public long c() {
        return this.kd;
    }

    public long d() {
        return this.c;
    }

    public long f() {
        return this.y;
    }

    public void hf() {
        this.u = System.currentTimeMillis();
    }

    public long kd() {
        return this.w;
    }

    public void p() {
        this.hf = System.currentTimeMillis();
    }

    public long tf() {
        return this.hf;
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.xj + ", asyncCallExecTs=" + this.hf + ", requestStartExecTs=" + this.w + ", requestConnectStartTs=" + this.u + ", requestConnectFinishTs=" + this.kd + ", reqCallServerStartTs=" + this.y + ", reqCallServerFinishTs=" + this.c + '}';
    }

    public long u() {
        return this.xj;
    }

    public void w() {
        this.kd = System.currentTimeMillis();
    }

    public void xj() {
        this.w = System.currentTimeMillis();
    }

    public long y() {
        return this.u;
    }

    public void hf(long j) {
        this.c = j;
    }

    public void xj(long j) {
        this.y = j;
    }
}
