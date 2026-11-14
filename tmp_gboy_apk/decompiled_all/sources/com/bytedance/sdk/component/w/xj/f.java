package com.bytedance.sdk.component.w.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class f implements v {
    private final v xj;

    public f(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.xj = vVar;
    }

    @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.xj.close();
    }

    public final v hf() {
        return this.xj;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.xj.toString() + ")";
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public long xj(w wVar, long j) {
        return this.xj.xj(wVar, j);
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public jk xj() {
        return this.xj.xj();
    }
}
