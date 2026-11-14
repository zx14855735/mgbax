package com.czhj.wire.okio;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class PeekSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedSource f10699a;
    private final Buffer b;
    private Segment c;
    private int d;
    private boolean e;
    private long f;

    public PeekSource(BufferedSource bufferedSource) {
        this.f10699a = bufferedSource;
        Buffer buffer = bufferedSource.buffer();
        this.b = buffer;
        Segment segment = buffer.b;
        this.c = segment;
        this.d = segment != null ? segment.d : -1;
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = true;
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        Segment segment;
        Segment segment2;
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        Segment segment3 = this.c;
        if (segment3 != null && (segment3 != (segment2 = this.b.b) || this.d != segment2.d)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.f10699a.request(this.f + 1)) {
            return -1L;
        }
        if (this.c == null && (segment = this.b.b) != null) {
            this.c = segment;
            this.d = segment.d;
        }
        long min = Math.min(j, this.b.c - this.f);
        this.b.copyTo(buffer, this.f, min);
        this.f += min;
        return min;
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f10699a.timeout();
    }
}
