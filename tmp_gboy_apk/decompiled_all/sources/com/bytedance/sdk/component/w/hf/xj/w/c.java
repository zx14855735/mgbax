package com.bytedance.sdk.component.w.hf.xj.w;

import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.zg;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c implements jk.xj {
    private final com.bytedance.sdk.component.w.hf.kd c;
    private final int d;
    private final zg f;
    private final com.bytedance.sdk.component.w.hf.xj.hf.c hf;
    private final int kd;
    private final int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10241pl;
    private final int tf;
    private final com.bytedance.sdk.component.w.hf.xj.hf.w u;
    private final w w;
    private final List<jk> xj;
    private final io y;

    public c(List<jk> list, com.bytedance.sdk.component.w.hf.xj.hf.c cVar, w wVar, com.bytedance.sdk.component.w.hf.xj.hf.w wVar2, int i, io ioVar, com.bytedance.sdk.component.w.hf.kd kdVar, zg zgVar, int i2, int i3, int i4) {
        this.xj = list;
        this.u = wVar2;
        this.hf = cVar;
        this.w = wVar;
        this.kd = i;
        this.y = ioVar;
        this.c = kdVar;
        this.f = zgVar;
        this.d = i2;
        this.tf = i3;
        this.p = i4;
    }

    public w c() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk.xj
    public com.bytedance.sdk.component.w.hf.kd call() {
        return this.c;
    }

    public zg f() {
        return this.f;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk.xj
    public int hf() {
        return this.d;
    }

    public com.bytedance.sdk.component.w.hf.d kd() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk.xj
    public int u() {
        return this.p;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk.xj
    public int w() {
        return this.tf;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk.xj
    public io xj() {
        return this.y;
    }

    public com.bytedance.sdk.component.w.hf.xj.hf.c y() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.w.hf.jk.xj
    public q xj(io ioVar) {
        return xj(ioVar, this.hf, this.w, this.u);
    }

    public q xj(io ioVar, com.bytedance.sdk.component.w.hf.xj.hf.c cVar, w wVar, com.bytedance.sdk.component.w.hf.xj.hf.w wVar2) {
        if (this.kd < this.xj.size()) {
            this.f10241pl++;
            if (this.w != null && !this.u.xj(ioVar.xj())) {
                throw new IllegalStateException("network interceptor " + this.xj.get(this.kd - 1) + " must retain the same host and port");
            }
            if (this.w != null && this.f10241pl > 1) {
                throw new IllegalStateException("network interceptor " + this.xj.get(this.kd - 1) + " must call proceed() exactly once");
            }
            c cVar2 = new c(this.xj, cVar, wVar, wVar2, this.kd + 1, ioVar, this.c, this.f, this.d, this.tf, this.p);
            jk jkVar = this.xj.get(this.kd);
            q xj = jkVar.xj(cVar2);
            if (wVar != null && this.kd + 1 < this.xj.size() && cVar2.f10241pl != 1) {
                throw new IllegalStateException("network interceptor " + jkVar + " must call proceed() exactly once");
            }
            if (xj == null) {
                throw new NullPointerException("interceptor " + jkVar + " returned a null response");
            }
            if (xj.f() != null) {
                return xj;
            }
            throw new IllegalStateException("interceptor " + jkVar + " returned a response with no body");
        }
        throw new AssertionError();
    }
}
