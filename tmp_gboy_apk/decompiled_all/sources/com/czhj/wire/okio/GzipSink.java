package com.czhj.wire.okio;

import ADYaiT.CtFAbx;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class GzipSink implements Sink {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedSink f10690a;
    private final Deflater b;
    private final DeflaterSink c;
    private boolean d;
    private final CRC32 e = new CRC32();

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.b = deflater;
        BufferedSink buffer = Okio.buffer(sink);
        this.f10690a = buffer;
        this.c = new DeflaterSink(buffer, deflater);
        a();
    }

    private void a() {
        Buffer buffer = this.f10690a.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private void b() {
        this.f10690a.writeIntLe((int) this.e.getValue());
        this.f10690a.writeIntLe((int) this.b.getBytesRead());
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d) {
            return;
        }
        try {
            this.c.a();
            b();
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
            this.f10690a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.d = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    public final Deflater deflater() {
        return this.b;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() {
        this.c.flush();
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.f10690a.timeout();
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) {
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (j == 0) {
            return;
        }
        a(buffer, j);
        this.c.write(buffer, j);
    }

    private void a(Buffer buffer, long j) {
        Segment segment = buffer.b;
        while (j > 0) {
            int min = (int) Math.min(j, segment.e - segment.d);
            this.e.update(segment.c, segment.d, min);
            j -= min;
            segment = segment.h;
        }
    }
}
