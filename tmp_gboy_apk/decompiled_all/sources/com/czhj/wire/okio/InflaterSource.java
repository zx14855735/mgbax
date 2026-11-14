package com.czhj.wire.okio;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class InflaterSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    private final BufferedSource f10694a;
    private final Inflater b;
    private int c;
    private boolean d;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f10694a = bufferedSource;
        this.b = inflater;
    }

    private void a() {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.f10694a.skip(remaining);
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.f10694a.close();
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        boolean refill;
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            refill = refill();
            try {
                Segment a2 = buffer.a(1);
                int inflate = this.b.inflate(a2.c, a2.e, (int) Math.min(j, 8192 - a2.e));
                if (inflate > 0) {
                    a2.e += inflate;
                    long j2 = inflate;
                    buffer.c += j2;
                    return j2;
                }
                if (!this.b.finished() && !this.b.needsDictionary()) {
                }
                a();
                if (a2.d != a2.e) {
                    return -1L;
                }
                buffer.b = a2.pop();
                SegmentPool.a(a2);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!refill);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean refill() {
        if (!this.b.needsInput()) {
            return false;
        }
        a();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f10694a.exhausted()) {
            return true;
        }
        Segment segment = this.f10694a.buffer().b;
        int i = segment.e;
        int i2 = segment.d;
        int i3 = i - i2;
        this.c = i3;
        this.b.setInput(segment.c, i2, i3);
        return false;
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.f10694a.timeout();
    }

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }
}
