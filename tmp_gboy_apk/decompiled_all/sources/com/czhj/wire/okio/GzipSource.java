package com.czhj.wire.okio;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class GzipSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    private static final byte f10691a = 1;
    private static final byte b = 2;
    private static final byte c = 3;
    private static final byte d = 4;
    private static final byte e = 0;
    private static final byte f = 1;
    private static final byte g = 2;
    private static final byte h = 3;
    private final BufferedSource j;
    private final Inflater k;
    private final InflaterSource l;
    private int i = 0;
    private final CRC32 m = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.k = inflater;
        BufferedSource buffer = Okio.buffer(source);
        this.j = buffer;
        this.l = new InflaterSource(buffer, inflater);
    }

    private void a() {
        this.j.require(10L);
        byte b2 = this.j.buffer().getByte(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            a(this.j.buffer(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.j.readShort());
        this.j.skip(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.j.require(2L);
            if (z) {
                a(this.j.buffer(), 0L, 2L);
            }
            long readShortLe = this.j.buffer().readShortLe() & 65535;
            this.j.require(readShortLe);
            if (z) {
                a(this.j.buffer(), 0L, readShortLe);
            }
            this.j.skip(readShortLe);
        }
        if (((b2 >> 3) & 1) == 1) {
            long indexOf = this.j.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.buffer(), 0L, indexOf + 1);
            }
            this.j.skip(indexOf + 1);
        }
        if (((b2 >> d) & 1) == 1) {
            long indexOf2 = this.j.indexOf((byte) 0);
            if (indexOf2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.buffer(), 0L, indexOf2 + 1);
            }
            this.j.skip(indexOf2 + 1);
        }
        if (z) {
            a("FHCRC", this.j.readShortLe(), (short) this.m.getValue());
            this.m.reset();
        }
    }

    private void b() {
        a("CRC", this.j.readIntLe(), (int) this.m.getValue());
        a("ISIZE", this.j.readIntLe(), (int) this.k.getBytesWritten());
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.l.close();
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        GzipSource gzipSource;
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.i == 0) {
            a();
            this.i = 1;
        }
        if (this.i == 1) {
            long j2 = buffer.c;
            long read = this.l.read(buffer, j);
            gzipSource = this;
            if (read != -1) {
                gzipSource.a(buffer, j2, read);
                return read;
            }
            gzipSource.i = 2;
        } else {
            gzipSource = this;
        }
        if (gzipSource.i == 2) {
            b();
            gzipSource.i = 3;
            if (!gzipSource.j.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.j.timeout();
    }

    private void a(Buffer buffer, long j, long j2) {
        Segment segment = buffer.b;
        while (true) {
            int i = segment.e;
            int i2 = segment.d;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            segment = segment.h;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.e - r7, j2);
            this.m.update(segment.c, (int) (segment.d + j), min);
            j2 -= min;
            segment = segment.h;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
