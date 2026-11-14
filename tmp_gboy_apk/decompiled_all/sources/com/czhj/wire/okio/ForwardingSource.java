package com.czhj.wire.okio;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ForwardingSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    private final Source f10688a;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10688a = source;
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10688a.close();
    }

    public final Source delegate() {
        return this.f10688a;
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        return this.f10688a.read(buffer, j);
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f10688a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10688a.toString() + ")";
    }
}
