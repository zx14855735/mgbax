package com.czhj.wire.okio;

import java.util.zip.Deflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DeflaterSink implements Sink {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedSink f10686a;
    private final Deflater b;
    private boolean c;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f10686a = bufferedSink;
        this.b = deflater;
    }

    public void a() {
        this.b.finish();
        a(false);
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c) {
            return;
        }
        try {
            a();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f10686a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() {
        a(true);
        this.f10686a.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f10686a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f10686a + ")";
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) {
        Util.checkOffsetAndCount(buffer.c, 0L, j);
        while (j > 0) {
            Segment segment = buffer.b;
            int min = (int) Math.min(j, segment.e - segment.d);
            this.b.setInput(segment.c, segment.d, min);
            a(false);
            long j2 = min;
            buffer.c -= j2;
            int i = segment.d + min;
            segment.d = i;
            if (i == segment.e) {
                buffer.b = segment.pop();
                SegmentPool.a(segment);
            }
            j -= j2;
        }
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }

    private void a(boolean z) {
        Segment a2;
        Buffer buffer = this.f10686a.buffer();
        while (true) {
            a2 = buffer.a(1);
            Deflater deflater = this.b;
            byte[] bArr = a2.c;
            int i = a2.e;
            int i2 = 8192 - i;
            int deflate = z ? deflater.deflate(bArr, i, i2, 2) : deflater.deflate(bArr, i, i2);
            if (deflate > 0) {
                a2.e += deflate;
                buffer.c += deflate;
                this.f10686a.emitCompleteSegments();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (a2.d == a2.e) {
            buffer.b = a2.pop();
            SegmentPool.a(a2);
        }
    }
}
