package com.bytedance.sdk.component.hf.xj;

import com.bytedance.sdk.component.w.hf.ai;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    public long c;
    public long hf;
    public long kd;
    public long u;
    public long w;
    public long xj;
    public long y;

    public p() {
        this.xj = System.currentTimeMillis();
    }

    public void hf() {
        this.u = System.currentTimeMillis();
    }

    public void u() {
        this.hf = System.currentTimeMillis();
    }

    public void w() {
        this.kd = System.currentTimeMillis();
    }

    public void xj() {
        this.w = System.currentTimeMillis();
    }

    public void hf(long j) {
        this.c = j;
    }

    public void xj(long j) {
        this.y = j;
    }

    public p(Object obj) {
        this.xj = System.currentTimeMillis();
        try {
            if (obj instanceof ai) {
                ai aiVar = (ai) obj;
                this.xj = aiVar.u();
                this.hf = aiVar.tf();
                this.w = aiVar.kd();
                this.u = aiVar.y();
                this.kd = aiVar.c();
                this.y = aiVar.f();
                this.c = aiVar.d();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }
}
