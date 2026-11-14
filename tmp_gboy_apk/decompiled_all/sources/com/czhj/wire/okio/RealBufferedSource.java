package com.czhj.wire.okio;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class RealBufferedSource implements BufferedSource {

    /* renamed from: a, reason: collision with root package name */
    boolean f10706a;
    public final Buffer buffer = new Buffer();
    public final Source source;

    public RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.source = source;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f10706a) {
            return;
        }
        this.f10706a = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean exhausted() {
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public Buffer getBuffer() {
        return this.buffer;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.czhj.wire.okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int available() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.f10706a) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.buffer.c, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.f10706a) {
                    throw new IOException("closed");
                }
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.c == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.readByte() & 255;
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                if (RealBufferedSource.this.f10706a) {
                    throw new IOException("closed");
                }
                Util.checkOffsetAndCount(bArr.length, i, i2);
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                Buffer buffer = realBufferedSource.buffer;
                if (buffer.c == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.buffer.read(bArr, i, i2);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f10706a;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        Buffer buffer = this.buffer;
        if (buffer.c == 0 && this.source.read(buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readAll(Sink sink) {
        Buffer buffer;
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (true) {
            long read = this.source.read(this.buffer, 8192L);
            buffer = this.buffer;
            if (read == -1) {
                break;
            }
            long completeSegmentByteCount = buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(this.buffer, completeSegmentByteCount);
            }
        }
        if (buffer.size() <= 0) {
            return j;
        }
        long size = this.buffer.size() + j;
        Buffer buffer2 = this.buffer;
        sink.write(buffer2, buffer2.size());
        return size;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte readByte() {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray() {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString() {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r2 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9] or '-' character but was %#x", java.lang.Byte.valueOf(r4)));
     */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readDecimalLong() {
        /*
            r7 = this;
            r0 = 1
            r1 = 1
            r7.require(r1)
            r1 = 0
            r2 = 0
        L8:
            int r3 = r2 + 1
            long r4 = (long) r3
            boolean r4 = r7.request(r4)
            if (r4 == 0) goto L40
            com.czhj.wire.okio.Buffer r4 = r7.buffer
            long r5 = (long) r2
            byte r4 = r4.getByte(r5)
            r5 = 48
            if (r4 < r5) goto L20
            r5 = 57
            if (r4 <= r5) goto L27
        L20:
            if (r2 != 0) goto L29
            r5 = 45
            if (r4 == r5) goto L27
            goto L29
        L27:
            r2 = r3
            goto L8
        L29:
            if (r2 == 0) goto L2c
            goto L40
        L2c:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.Byte r3 = java.lang.Byte.valueOf(r4)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r3
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r2.<init>(r0)
            throw r2
        L40:
            com.czhj.wire.okio.Buffer r0 = r7.buffer
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.RealBufferedSource.readDecimalLong():long");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(Buffer buffer, long j) {
        try {
            require(j);
            this.buffer.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(this.buffer);
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r2 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r4)));
     */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r7 = this;
            r0 = 1
            r1 = 1
            r7.require(r1)
            r1 = 0
            r2 = 0
        L8:
            int r3 = r2 + 1
            long r4 = (long) r3
            boolean r4 = r7.request(r4)
            if (r4 == 0) goto L4a
            com.czhj.wire.okio.Buffer r4 = r7.buffer
            long r5 = (long) r2
            byte r4 = r4.getByte(r5)
            r5 = 48
            if (r4 < r5) goto L20
            r5 = 57
            if (r4 <= r5) goto L31
        L20:
            r5 = 97
            if (r4 < r5) goto L28
            r5 = 102(0x66, float:1.43E-43)
            if (r4 <= r5) goto L31
        L28:
            r5 = 65
            if (r4 < r5) goto L33
            r5 = 70
            if (r4 <= r5) goto L31
            goto L33
        L31:
            r2 = r3
            goto L8
        L33:
            if (r2 == 0) goto L36
            goto L4a
        L36:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.Byte r3 = java.lang.Byte.valueOf(r4)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r3
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r2.<init>(r0)
            throw r2
        L4a:
            com.czhj.wire.okio.Buffer r0 = r7.buffer
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readInt() {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readIntLe() {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLong() {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLongLe() {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShort() {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShortLe() {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(long j, Charset charset) {
        require(j);
        if (charset != null) {
            return this.buffer.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8() {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readUtf8CodePoint() {
        long j;
        require(1L);
        byte b = this.buffer.getByte(0L);
        if ((b & 224) == 192) {
            j = 2;
        } else {
            if ((b & 240) != 224) {
                if ((b & 248) == 240) {
                    j = 4;
                }
                return this.buffer.readUtf8CodePoint();
            }
            j = 3;
        }
        require(j);
        return this.buffer.readUtf8CodePoint();
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.a(indexOf);
        }
        long j = this.buffer.c;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean request(long j) {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        do {
            buffer = this.buffer;
            if (buffer.c >= j) {
                return true;
            }
        } while (this.source.read(buffer, 8192L) != -1);
        return false;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void require(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int select(Options options) {
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        do {
            int a2 = this.buffer.a(options, true);
            if (a2 == -1) {
                return -1;
            }
            if (a2 != -2) {
                this.buffer.skip(options.f10698a[a2].size());
                return a2;
            }
        } while (this.source.read(this.buffer, 8192L) != -1);
        return -1;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void skip(long j) {
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            Buffer buffer = this.buffer;
            if (buffer.c == 0 && this.source.read(buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.buffer.size());
            this.buffer.skip(min);
            j -= min;
        }
    }

    @Override // com.czhj.wire.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            Buffer buffer = this.buffer;
            long j2 = buffer.c;
            if (this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!request(1 + j2) || this.buffer.getByte(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray(long j) {
        require(j);
        return this.buffer.readByteArray(j);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString(long j) {
        require(j);
        return this.buffer.readByteString(j);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(byte[] bArr) {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer buffer = this.buffer;
                long j = buffer.c;
                if (j <= 0) {
                    throw e;
                }
                int read = buffer.read(bArr, i, (int) j);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8(long j) {
        require(j);
        return this.buffer.readUtf8(j);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8LineStrict(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("limit < 0: ", j));
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return this.buffer.a(indexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.buffer.getByte(j2 - 1) == 13 && request(1 + j2) && this.buffer.getByte(j2) == 10) {
            return this.buffer.a(j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("fromIndex=", j, " toIndex=");
            B2KMhB2.append(j2);
            throw new IllegalArgumentException(B2KMhB2.toString());
        }
        long j3 = j;
        while (j3 < j2) {
            byte b2 = b;
            long j4 = j2;
            long indexOf = this.buffer.indexOf(b2, j3, j4);
            if (indexOf == -1) {
                Buffer buffer = this.buffer;
                long j5 = buffer.c;
                if (j5 >= j4 || this.source.read(buffer, 8192L) == -1) {
                    break;
                }
                j3 = Math.max(j3, j5);
                b = b2;
                j2 = j4;
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        Buffer buffer = this.buffer;
        if (buffer.c == 0 && this.source.read(buffer, 8192L) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i, (int) Math.min(j, this.buffer.c));
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer2 = this.buffer;
        if (buffer2.c == 0 && this.source.read(buffer2, 8192L) == -1) {
            return -1L;
        }
        return this.buffer.read(buffer, Math.min(j, this.buffer.c));
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString, long j) {
        if (this.f10706a) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.buffer;
            long j2 = buffer.c;
            if (this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - byteString.size()) + 1);
        }
    }
}
