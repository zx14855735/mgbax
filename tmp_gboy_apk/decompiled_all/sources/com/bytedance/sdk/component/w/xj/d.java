package com.bytedance.sdk.component.w.xj;

import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends jk {
    private jk xj;

    public d(jk jkVar) {
        if (jkVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.xj = jkVar;
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public void c() {
        this.xj.c();
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public jk kd() {
        return this.xj.kd();
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public long n_() {
        return this.xj.n_();
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public long o_() {
        return this.xj.o_();
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public boolean w() {
        return this.xj.w();
    }

    public final jk xj() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public jk y() {
        return this.xj.y();
    }

    public final d xj(jk jkVar) {
        if (jkVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.xj = jkVar;
        return this;
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public jk xj(long j, TimeUnit timeUnit) {
        return this.xj.xj(j, timeUnit);
    }

    @Override // com.bytedance.sdk.component.w.xj.jk
    public jk xj(long j) {
        return this.xj.xj(j);
    }
}
