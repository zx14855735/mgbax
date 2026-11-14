package com.czhj.wire.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class RealBufferedSink implements BufferedSink {

    /* renamed from: a, reason: collision with root package name */
    boolean f10704a;
    public final Buffer buffer = new Buffer();
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.sink = sink;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.BufferedSource
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f10704a) {
            return;
        }
        try {
            Buffer buffer = this.buffer;
            long j = buffer.c;
            if (j > 0) {
                this.sink.write(buffer, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f10704a = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emit() {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emitCompleteSegments() {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.buffer, completeSegmentByteCount);
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.buffer;
        long j = buffer.c;
        if (j > 0) {
            this.sink.write(buffer, j);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f10704a;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.czhj.wire.okio.RealBufferedSink.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f10704a) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f10704a) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.writeByte((int) ((byte) i));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f10704a) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.write(bArr, i, i2);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        int write = this.buffer.write(byteBuffer);
        emitCompleteSegments();
        return write;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public long writeAll(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.buffer, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeByte(int i) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeByte(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeDecimalLong(long j) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeInt(int i) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeInt(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeIntLe(int i) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeLong(long j) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLong(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeLongLe(long j) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeShort(int i) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShort(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeShortLe(int i) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeString(String str, int i, int i2, Charset charset) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, i, i2, charset);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8(String str) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(ByteString byteString) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i, int i2) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str, i, i2);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this.buffer, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(byte[] bArr) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr, i, i2);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) {
        if (this.f10704a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(buffer, j);
        emitCompleteSegments();
    }
}
