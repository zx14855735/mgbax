package com.czhj.wire.okio;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ForwardingSink implements Sink {

    /* renamed from: a, reason: collision with root package name */
    private final Sink f10687a;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10687a = sink;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10687a.close();
    }

    public final Sink delegate() {
        return this.f10687a;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() {
        this.f10687a.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f10687a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10687a.toString() + ")";
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) {
        this.f10687a.write(buffer, j);
    }
}
