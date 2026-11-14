package com.bytedance.sdk.component.hf.xj.xj.xj;

import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.hf.xj.g;
import com.bytedance.sdk.component.hf.xj.p;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.w.hf.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends zg {
    public q xj;

    public d(q qVar) {
        this.xj = qVar;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public com.bytedance.sdk.component.hf.xj.y c() {
        return new com.bytedance.sdk.component.hf.xj.y(this.xj.c().xj);
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.xj.close();
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public p d() {
        q qVar = this.xj;
        if (qVar == null) {
            return null;
        }
        return new p(qVar.qt());
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public g f() {
        try {
            return g.xj(this.xj.hf().toString());
        } catch (Exception unused) {
            return g.HTTP_1_1;
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public long hf() {
        return this.xj.g();
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public String kd() {
        return this.xj.kd();
    }

    public String toString() {
        return this.xj.toString();
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public boolean u() {
        return this.xj.u();
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public int w() {
        q qVar = this.xj;
        if (qVar != null) {
            return qVar.w();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public long xj() {
        return this.xj.am();
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public e y() {
        return new tf(this.xj.f());
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public String xj(String str) {
        return this.xj.xj(str);
    }

    @Override // com.bytedance.sdk.component.hf.xj.zg
    public String xj(String str, String str2) {
        return this.xj.xj(str, str2);
    }
}
