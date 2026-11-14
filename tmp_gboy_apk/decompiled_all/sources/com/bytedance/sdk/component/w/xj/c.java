package com.bytedance.sdk.component.w.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class c implements yo {
    private final yo xj;

    public c(yo yoVar) {
        if (yoVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.xj = yoVar;
    }

    @Override // com.bytedance.sdk.component.w.xj.yo
    public void a_(w wVar, long j) {
        this.xj.a_(wVar, j);
    }

    @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.xj.close();
    }

    @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
    public void flush() {
        this.xj.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.xj.toString() + ")";
    }

    @Override // com.bytedance.sdk.component.w.xj.yo
    public jk xj() {
        return this.xj.xj();
    }
}
