package com.czhj.wire.okio;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.base.views.r;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Buffer implements BufferedSink, BufferedSource, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    static final int f10681a = 65533;
    private static final byte[] d = {e.H, e.I, e.J, e.K, e.L, e.M, e.N, e.O, 56, 57, 97, 98, 99, 100, 101, 102};
    Segment b;
    long c;

    public static final class UnsafeCursor implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private Segment f10684a;
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.f10684a = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "minByteCount <= 0: "));
            }
            if (i > 8192) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "minByteCount > Segment.SIZE: "));
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = buffer.c;
            Segment a2 = buffer.a(i);
            int i2 = 8192 - a2.e;
            a2.e = ProxyCacheUtils.DEFAULT_BUFFER_SIZE;
            long j2 = i2;
            this.buffer.c = j + j2;
            this.f10684a = a2;
            this.offset = j;
            this.data = a2.c;
            this.start = 8192 - i2;
            this.end = ProxyCacheUtils.DEFAULT_BUFFER_SIZE;
            return j2;
        }

        public final int next() {
            long j = this.offset;
            if (j != this.buffer.c) {
                return seek(j == -1 ? 0L : j + (this.end - this.start));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.c;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException(CtFAbx.AaHO0E("newSize < 0: ", j));
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    Buffer buffer2 = this.buffer;
                    Segment segment = buffer2.b.i;
                    int i = segment.e;
                    long j4 = i - segment.d;
                    if (j4 > j3) {
                        segment.e = (int) (i - j3);
                        break;
                    }
                    buffer2.b = segment.pop();
                    SegmentPool.a(segment);
                    j3 -= j4;
                }
                this.f10684a = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    Segment a2 = this.buffer.a(1);
                    int min = (int) Math.min(j5, 8192 - a2.e);
                    int i2 = a2.e + min;
                    a2.e = i2;
                    j5 -= min;
                    if (z) {
                        this.f10684a = a2;
                        this.offset = j2;
                        this.data = a2.c;
                        this.start = i2 - min;
                        this.end = i2;
                        z = false;
                    }
                }
            }
            this.buffer.c = j;
            return j2;
        }

        public final int seek(long j) {
            if (j >= -1) {
                Buffer buffer = this.buffer;
                long j2 = buffer.c;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.f10684a = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment = buffer.b;
                    Segment segment2 = this.f10684a;
                    long j3 = 0;
                    if (segment2 != null) {
                        long j4 = this.offset - (this.start - segment2.d);
                        if (j4 > j) {
                            segment2 = segment;
                            segment = segment2;
                            j2 = j4;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segment2 = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = segment2.e;
                            int i2 = segment2.d;
                            if (j < (i - i2) + j3) {
                                break;
                            }
                            j3 += i - i2;
                            segment2 = segment2.h;
                        }
                    } else {
                        while (j2 > j) {
                            segment = segment.i;
                            j2 -= segment.e - segment.d;
                        }
                        segment2 = segment;
                        j3 = j2;
                    }
                    if (this.readWrite && segment2.f) {
                        Segment b = segment2.b();
                        Buffer buffer2 = this.buffer;
                        if (buffer2.b == segment2) {
                            buffer2.b = b;
                        }
                        segment2 = segment2.push(b);
                        segment2.i.pop();
                    }
                    this.f10684a = segment2;
                    this.offset = j;
                    this.data = segment2.c;
                    int i3 = segment2.d + ((int) (j - j3));
                    this.start = i3;
                    int i4 = segment2.e;
                    this.end = i4;
                    return i4 - i3;
                }
            }
            long j5 = this.buffer.c;
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("offset=", j, " > size=");
            B2KMhB2.append(j5);
            throw new ArrayIndexOutOfBoundsException(B2KMhB2.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r19 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(com.czhj.wire.okio.Options r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            com.czhj.wire.okio.Segment r2 = r1.b
            r3 = -2
            if (r2 != 0) goto L13
            if (r19 == 0) goto Lc
            return r3
        Lc:
            com.czhj.wire.okio.ByteString r2 = com.czhj.wire.okio.ByteString.EMPTY
            int r0 = r0.indexOf(r2)
            return r0
        L13:
            byte[] r4 = r2.c
            int r5 = r2.d
            int r6 = r2.e
            int[] r0 = r0.b
            r7 = 0
            r8 = -1
            r10 = r2
            r9 = 0
            r11 = -1
        L20:
            int r12 = r9 + 1
            r13 = r0[r9]
            int r9 = r9 + 2
            r12 = r0[r12]
            if (r12 == r8) goto L2b
            r11 = r12
        L2b:
            if (r10 != 0) goto L2e
            goto L55
        L2e:
            r12 = 0
            if (r13 >= 0) goto L71
            int r13 = r13 * (-1)
            int r14 = r13 + r9
        L35:
            int r13 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + 1
            r9 = r0[r9]
            if (r5 == r9) goto L42
            goto L7b
        L42:
            if (r15 != r14) goto L46
            r5 = 1
            goto L47
        L46:
            r5 = 0
        L47:
            if (r13 != r6) goto L61
            com.czhj.wire.okio.Segment r4 = r10.h
            int r6 = r4.d
            byte[] r9 = r4.c
            int r10 = r4.e
            if (r4 != r2) goto L5b
            if (r5 != 0) goto L58
        L55:
            if (r19 == 0) goto L7b
            return r3
        L58:
            r4 = r9
            r9 = r12
            goto L64
        L5b:
            r16 = r9
            r9 = r4
            r4 = r16
            goto L64
        L61:
            r9 = r10
            r10 = r6
            r6 = r13
        L64:
            if (r5 == 0) goto L6c
            r5 = r0[r15]
            r3 = r6
            r6 = r10
            r10 = r9
            goto L92
        L6c:
            r5 = r6
            r6 = r10
            r10 = r9
            r9 = r15
            goto L35
        L71:
            int r14 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + r13
        L79:
            if (r9 != r15) goto L7c
        L7b:
            return r11
        L7c:
            r3 = r0[r9]
            if (r5 != r3) goto L99
            int r9 = r9 + r13
            r5 = r0[r9]
            if (r14 != r6) goto L91
            com.czhj.wire.okio.Segment r10 = r10.h
            int r3 = r10.d
            byte[] r4 = r10.c
            int r6 = r10.e
            if (r10 != r2) goto L92
            r10 = r12
            goto L92
        L91:
            r3 = r14
        L92:
            if (r5 < 0) goto L95
            return r5
        L95:
            int r9 = -r5
            r5 = r3
            r3 = -2
            goto L20
        L99:
            int r9 = r9 + 1
            r3 = -2
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.Buffer.a(com.czhj.wire.okio.Options, boolean):int");
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Buffer m8clone() {
        Buffer buffer = new Buffer();
        if (this.c == 0) {
            return buffer;
        }
        Segment a2 = this.b.a();
        buffer.b = a2;
        a2.i = a2;
        a2.h = a2;
        Segment segment = this.b;
        while (true) {
            segment = segment.h;
            if (segment == this.b) {
                buffer.c = this.c;
                return buffer;
            }
            buffer.b.i.push(segment.a());
        }
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.c;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.b.i;
        return (segment.e >= 8192 || !segment.g) ? j : j - (r3 - segment.d);
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        long j3 = j;
        Util.checkOffsetAndCount(this.c, j3, j2);
        if (j2 != 0) {
            buffer.c += j2;
            Segment segment = this.b;
            while (true) {
                int i = segment.e;
                int i2 = segment.d;
                if (j3 < i - i2) {
                    break;
                }
                j3 -= i - i2;
                segment = segment.h;
            }
            Segment segment2 = segment;
            long j4 = j2;
            while (j4 > 0) {
                Segment a2 = segment2.a();
                int i3 = (int) (a2.d + j3);
                a2.d = i3;
                a2.e = Math.min(i3 + ((int) j4), a2.e);
                Segment segment3 = buffer.b;
                if (segment3 == null) {
                    a2.i = a2;
                    a2.h = a2;
                    buffer.b = a2;
                } else {
                    segment3.i.push(a2);
                }
                j4 -= a2.e - a2.d;
                segment2 = segment2.h;
                j3 = 0;
            }
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.c;
        if (j != buffer.c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment segment = this.b;
        Segment segment2 = buffer.b;
        int i = segment.d;
        int i2 = segment2.d;
        while (j2 < this.c) {
            long min = Math.min(segment.e - i, segment2.e - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (segment.c[i] != segment2.c[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == segment.e) {
                segment = segment.h;
                i = segment.d;
            }
            if (i2 == segment2.e) {
                segment2 = segment2.h;
                i2 = segment2.d;
            }
            j2 += min;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean exhausted() {
        return this.c == 0;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        int i;
        long j2 = j;
        Util.checkOffsetAndCount(this.c, j2, 1L);
        long j3 = this.c;
        if (j3 - j2 <= j2) {
            long j4 = j2 - j3;
            Segment segment = this.b;
            do {
                segment = segment.i;
                int i2 = segment.e;
                i = segment.d;
                j4 += i2 - i;
            } while (j4 < 0);
            return segment.c[i + ((int) j4)];
        }
        Segment segment2 = this.b;
        while (true) {
            int i3 = segment2.e;
            int i4 = segment2.d;
            long j5 = i3 - i4;
            if (j2 < j5) {
                return segment2.c[i4 + ((int) j2)];
            }
            j2 -= j5;
            segment2 = segment2.h;
        }
    }

    public int hashCode() {
        Segment segment = this.b;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.e;
            for (int i3 = segment.d; i3 < i2; i3++) {
                i = (i * 31) + segment.c[i3];
            }
            segment = segment.h;
        } while (segment != this.b);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return a("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return a("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return a("HmacSHA512", byteString);
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
        return new InputStream() { // from class: com.czhj.wire.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.c, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.c > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return a("MD5");
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.czhj.wire.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }
        };
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
        Segment segment = this.b;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.e - segment.d);
        byteBuffer.put(segment.c, segment.d, min);
        int i = segment.d + min;
        segment.d = i;
        this.c -= min;
        if (i == segment.e) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        }
        return min;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readAll(Sink sink) {
        long j = this.c;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte readByte() {
        long j = this.c;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        int i3 = i + 1;
        byte b = segment.c[i];
        this.c = j - 1;
        if (i3 != i2) {
            segment.d = i3;
            return b;
        }
        this.b = segment.pop();
        SegmentPool.a(segment);
        return b;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2 A[EDGE_INSN: B:46:0x00a2->B:40:0x00a2 BREAK  A[LOOP:0: B:4:0x0011->B:45:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lad
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L11:
            com.czhj.wire.okio.Segment r8 = r0.b
            byte[] r9 = r8.c
            int r10 = r8.d
            int r11 = r8.e
        L19:
            if (r10 >= r11) goto L8e
            r12 = r9[r10]
            r13 = 48
            if (r12 < r13) goto L69
            r13 = 57
            if (r12 > r13) goto L69
            int r13 = 48 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L3f
            if (r16 != 0) goto L38
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L38
            goto L3f
        L38:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L74
        L3f:
            com.czhj.wire.okio.Buffer r1 = new com.czhj.wire.okio.Buffer
            r1.<init>()
            com.czhj.wire.okio.Buffer r1 = r1.writeDecimalLong(r4)
            com.czhj.wire.okio.Buffer r1 = r1.writeByte(r12)
            if (r2 != 0) goto L51
            r1.readByte()
        L51:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L69:
            r13 = 45
            r14 = 1
            if (r12 != r13) goto L79
            if (r1 != 0) goto L79
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L74:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L19
        L79:
            if (r1 == 0) goto L7d
            r3 = 1
            goto L8e
        L7d:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.<init>(r3)
            java.lang.String r2 = ADYaiT.CtFAbx.AzWtSf(r2, r12)
            r1.<init>(r2)
            throw r1
        L8e:
            if (r10 != r11) goto L9a
            com.czhj.wire.okio.Segment r9 = r8.pop()
            r0.b = r9
            com.czhj.wire.okio.SegmentPool.a(r8)
            goto L9c
        L9a:
            r8.d = r10
        L9c:
            if (r3 != 0) goto La2
            com.czhj.wire.okio.Segment r8 = r0.b
            if (r8 != 0) goto L11
        La2:
            long r6 = r0.c
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.c = r6
            if (r2 == 0) goto Lab
            return r4
        Lab:
            long r1 = -r4
            return r1
        Lad:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) {
        a(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(Buffer buffer, long j) {
        long j2 = this.c;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095 A[EDGE_INSN: B:40:0x0095->B:37:0x0095 BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    @Override // com.czhj.wire.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9c
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.czhj.wire.okio.Segment r6 = r15.b
            byte[] r7 = r6.c
            int r8 = r6.d
            int r9 = r6.e
        L13:
            if (r8 >= r9) goto L81
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6c
            r11 = 70
            if (r10 > r11) goto L6c
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            com.czhj.wire.okio.Buffer r0 = new com.czhj.wire.okio.Buffer
            r0.<init>()
            com.czhj.wire.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            com.czhj.wire.okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L6c:
            if (r0 == 0) goto L70
            r1 = 1
            goto L81
        L70:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r1 = ADYaiT.CtFAbx.AzWtSf(r1, r10)
            r0.<init>(r1)
            throw r0
        L81:
            if (r8 != r9) goto L8d
            com.czhj.wire.okio.Segment r7 = r6.pop()
            r15.b = r7
            com.czhj.wire.okio.SegmentPool.a(r6)
            goto L8f
        L8d:
            r6.d = r8
        L8f:
            if (r1 != 0) goto L95
            com.czhj.wire.okio.Segment r6 = r15.b
            if (r6 != 0) goto Lb
        L95:
            long r1 = r15.c
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.c = r1
            return r4
        L9c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readInt() {
        long j = this.c;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.c);
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.c;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.c = j - 4;
        if (i5 != i2) {
            segment.d = i5;
            return i6;
        }
        this.b = segment.pop();
        SegmentPool.a(segment);
        return i6;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLong() {
        long j = this.c;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.c);
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.c;
        int i3 = i + 7;
        long j2 = ((bArr[i + 1] & 255) << 48) | ((bArr[i] & 255) << 56) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        int i4 = i + 8;
        long j3 = j2 | (bArr[i3] & 255);
        this.c = j - 8;
        if (i4 != i2) {
            segment.d = i4;
            return j3;
        }
        this.b = segment.pop();
        SegmentPool.a(segment);
        return j3;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShort() {
        long j = this.c;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.c);
        }
        Segment segment = this.b;
        int i = segment.d;
        int i2 = segment.e;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.c;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.c = j - 2;
        if (i5 == i2) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        } else {
            segment.d = i5;
        }
        return (short) i6;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(long j, Charset charset) {
        Util.checkOffsetAndCount(this.c, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount > Integer.MAX_VALUE: ", j));
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.b;
        int i = segment.d;
        if (i + j > segment.e) {
            return new String(readByteArray(j), charset);
        }
        String str = new String(segment.c, i, (int) j, charset);
        int i2 = (int) (segment.d + j);
        segment.d = i2;
        this.c -= j;
        if (i2 == segment.e) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        }
        return str;
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.c, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int readUtf8CodePoint() {
        int i;
        int i2;
        int i3;
        if (this.c == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
        if ((b & 128) == 0) {
            i = b & Byte.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((b & 224) == 192) {
            i = b & 31;
            i2 = 2;
            i3 = r.b.d;
        } else if ((b & 240) == 224) {
            i = b & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & 248) != 240) {
                skip(1L);
                return f10681a;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.c < j) {
            StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "size < ", ": ");
            B9tovu2.append(this.c);
            B9tovu2.append(" (to read code point prefixed 0x");
            B9tovu2.append(Integer.toHexString(b));
            B9tovu2.append(")");
            throw new EOFException(B9tovu2.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return f10681a;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        return i > 1114111 ? f10681a : ((i < 55296 || i > 57343) && i >= i3) ? i : f10681a;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return a(indexOf);
        }
        long j = this.c;
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
        return this.c >= j;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void require(long j) {
        if (this.c < j) {
            throw new EOFException();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int select(Options options) {
        int a2 = a(options, false);
        if (a2 == -1) {
            return -1;
        }
        try {
            skip(options.f10698a[a2].size());
            return a2;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public final ByteString sha1() {
        return a(MessageDigestAlgorithms.SHA_1);
    }

    public final ByteString sha256() {
        return a(MessageDigestAlgorithms.SHA_256);
    }

    public final ByteString sha512() {
        return a(MessageDigestAlgorithms.SHA_512);
    }

    public final long size() {
        return this.c;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void skip(long j) {
        while (j > 0) {
            if (this.b == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.e - r0.d);
            long j2 = min;
            this.c -= j2;
            j -= j2;
            Segment segment = this.b;
            int i = segment.d + min;
            segment.d = i;
            if (i == segment.e) {
                this.b = segment.pop();
                SegmentPool.a(segment);
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.c;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.c);
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment a2 = a(1);
            int min = Math.min(i, 8192 - a2.e);
            byteBuffer.get(a2.c, a2.e, min);
            i -= min;
            a2.e += min;
        }
        this.c += remaining;
        return remaining;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public long writeAll(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment a2 = a(1);
        byte[] bArr = a2.c;
        int i2 = a2.e;
        a2.e = i2 + 1;
        bArr[i2] = (byte) i;
        this.c++;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        boolean z;
        if (j == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < C.NANOS_PER_SECOND ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            i = j < C.MICROS_PER_SECOND ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment a2 = a(i);
        byte[] bArr = a2.c;
        int i2 = a2.e + i;
        while (j != 0) {
            i2--;
            bArr[i2] = d[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        a2.e += i;
        this.c += i;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment a2 = a(numberOfTrailingZeros);
        byte[] bArr = a2.c;
        int i = a2.e;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (15 & j)];
            j >>>= 4;
        }
        a2.e += numberOfTrailingZeros;
        this.c += numberOfTrailingZeros;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment a2 = a(4);
        byte[] bArr = a2.c;
        int i2 = a2.e;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        a2.e = i2 + 4;
        this.c += 4;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment a2 = a(8);
        byte[] bArr = a2.c;
        int i = a2.e;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        a2.e = i + 8;
        this.c += 8;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment a2 = a(2);
        byte[] bArr = a2.c;
        int i2 = a2.e;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        a2.e = i2 + 2;
        this.c += 2;
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytesShort((short) i));
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError(CtFAbx.ARc23Z(i, "beginIndex < 0: "));
        }
        if (i2 < i) {
            throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
        }
        if (i2 > str.length()) {
            StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
            B9tovu2.append(str.length());
            throw new IllegalArgumentException(B9tovu2.toString());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(Util.UTF_8)) {
            return writeUtf8(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return write(bytes, 0, bytes.length);
    }

    public final Buffer writeTo(OutputStream outputStream) {
        return writeTo(outputStream, this.c);
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        int i2;
        int i3;
        if (i < 128) {
            writeByte(i);
            return this;
        }
        if (i < 2048) {
            i3 = (i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT;
        } else {
            if (i < 65536) {
                if (i >= 55296 && i <= 57343) {
                    writeByte(63);
                    return this;
                }
                i2 = (i >> 12) | 224;
            } else {
                if (i > 1114111) {
                    throw new IllegalArgumentException(CtFAbx.AzWtSf(new StringBuilder("Unexpected code point: "), i));
                }
                writeByte((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                i2 = ((i >> 12) & 63) | r.b.d;
            }
            writeByte(i2);
            i3 = ((i >> 6) & 63) | r.b.d;
        }
        writeByte(i3);
        writeByte((i & 63) | r.b.d);
        return this;
    }

    private ByteString a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.b;
            if (segment != null) {
                byte[] bArr = segment.c;
                int i = segment.d;
                messageDigest.update(bArr, i, segment.e - i);
                Segment segment2 = this.b;
                while (true) {
                    segment2 = segment2.h;
                    if (segment2 == this.b) {
                        break;
                    }
                    byte[] bArr2 = segment2.c;
                    int i2 = segment2.d;
                    messageDigest.update(bArr2, i2, segment2.e - i2);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final Buffer copyTo(OutputStream outputStream) {
        return copyTo(outputStream, 0L, this.c);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.b;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.c;
        if (j3 - j < j) {
            while (j3 > j) {
                segment = segment.i;
                j3 -= segment.e - segment.d;
            }
        } else {
            while (true) {
                long j4 = (segment.e - segment.d) + j2;
                if (j4 >= j) {
                    break;
                }
                segment = segment.h;
                j2 = j4;
            }
            j3 = j2;
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.c) {
                byte[] bArr = segment.c;
                i = (int) ((segment.d + j) - j3);
                int i2 = segment.e;
                while (i < i2) {
                    byte b3 = bArr[i];
                    if (b3 != b && b3 != b2) {
                        i++;
                    }
                    return (i - segment.d) + j3;
                }
                j3 += segment.e - segment.d;
                segment = segment.h;
                j = j3;
            }
            return -1L;
        }
        byte[] a2 = byteString.a();
        while (j3 < this.c) {
            byte[] bArr2 = segment.c;
            i = (int) ((segment.d + j) - j3);
            int i3 = segment.e;
            while (i < i3) {
                byte b4 = bArr2[i];
                for (byte b5 : a2) {
                    if (b4 == b5) {
                        return (i - segment.d) + j3;
                    }
                }
                i++;
            }
            j3 += segment.e - segment.d;
            segment = segment.h;
            j = j3;
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.c - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(i3 + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public byte[] readByteArray(long j) {
        Util.checkOffsetAndCount(this.c, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount > Integer.MAX_VALUE: ", j));
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public ByteString readByteString(long j) {
        return new ByteString(readByteArray(j));
    }

    public final Buffer readFrom(InputStream inputStream, long j) {
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        a(inputStream, j, false);
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8(long j) {
        return readString(j, Util.UTF_8);
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readUtf8LineStrict(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("limit < 0: ", j));
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return a(indexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return a(j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    public final ByteString snapshot(int i) {
        return i == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i);
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    public final Buffer writeTo(OutputStream outputStream, long j) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.c, 0L, j);
        Segment segment = this.b;
        long j2 = j;
        while (j2 > 0) {
            int min = (int) Math.min(j2, segment.e - segment.d);
            outputStream.write(segment.c, segment.d, min);
            int i = segment.d + min;
            segment.d = i;
            long j3 = min;
            this.c -= j3;
            j2 -= j3;
            if (i == segment.e) {
                Segment pop = segment.pop();
                this.b = pop;
                SegmentPool.a(segment);
                segment = pop;
            }
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "beginIndex < 0: "));
        }
        if (i2 < i) {
            throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
        }
        if (i2 > str.length()) {
            StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
            B9tovu2.append(str.length());
            throw new IllegalArgumentException(B9tovu2.toString());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                Segment a2 = a(1);
                byte[] bArr = a2.c;
                int i4 = a2.e - i;
                int min = Math.min(i2, 8192 - i4);
                int i5 = i + 1;
                bArr[i + i4] = (byte) charAt;
                while (i5 < min) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) charAt2;
                    i5++;
                }
                int i6 = a2.e;
                int i7 = (i4 + i5) - i6;
                a2.e = i6 + i7;
                this.c += i7;
                i = i5;
            } else {
                if (charAt < 2048) {
                    i3 = (charAt >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT;
                } else if (charAt < 55296 || charAt > 57343) {
                    writeByte((charAt >> '\f') | 224);
                    i3 = ((charAt >> 6) & 63) | r.b.d;
                } else {
                    int i8 = i + 1;
                    char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        writeByte(63);
                        i = i8;
                    } else {
                        int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                        writeByte((i9 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                        writeByte(((i9 >> 12) & 63) | r.b.d);
                        writeByte(((i9 >> 6) & 63) | r.b.d);
                        writeByte((i9 & 63) | r.b.d);
                        i += 2;
                    }
                }
                writeByte(i3);
                writeByte((charAt & '?') | r.b.d);
                i++;
            }
        }
        return this;
    }

    private ByteString a(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.b;
            if (segment != null) {
                byte[] bArr = segment.c;
                int i = segment.d;
                mac.update(bArr, i, segment.e - i);
                Segment segment2 = this.b;
                while (true) {
                    segment2 = segment2.h;
                    if (segment2 == this.b) {
                        break;
                    }
                    byte[] bArr2 = segment2.c;
                    int i2 = segment2.d;
                    mac.update(bArr2, i2, segment2.e - i2);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        long j3 = j;
        Util.checkOffsetAndCount(this.c, j3, j2);
        if (j2 != 0) {
            Segment segment = this.b;
            while (true) {
                int i = segment.e;
                int i2 = segment.d;
                if (j3 < i - i2) {
                    break;
                }
                j3 -= i - i2;
                segment = segment.h;
            }
            Segment segment2 = segment;
            long j4 = j2;
            while (j4 > 0) {
                int min = (int) Math.min(segment2.e - r1, j4);
                outputStream.write(segment2.c, (int) (segment2.d + j3), min);
                j4 -= min;
                segment2 = segment2.h;
                j3 = 0;
            }
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = j;
        long j4 = j2;
        long j5 = 0;
        if (j3 < 0 || j4 < j3) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("size=", this.c, " fromIndex=");
            B2KMhB2.append(j3);
            B2KMhB2.append(" toIndex=");
            B2KMhB2.append(j4);
            throw new IllegalArgumentException(B2KMhB2.toString());
        }
        long j6 = this.c;
        if (j4 > j6) {
            j4 = j6;
        }
        if (j3 == j4 || (segment = this.b) == null) {
            return -1L;
        }
        if (j6 - j3 < j3) {
            while (j6 > j3) {
                segment = segment.i;
                j6 -= segment.e - segment.d;
            }
        } else {
            while (true) {
                long j7 = (segment.e - segment.d) + j5;
                if (j7 >= j3) {
                    break;
                }
                segment = segment.h;
                j5 = j7;
            }
            j6 = j5;
        }
        while (j6 < j4) {
            byte[] bArr = segment.c;
            int min = (int) Math.min(segment.e, (segment.d + j4) - j6);
            for (int i = (int) ((segment.d + j3) - j6); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - segment.d) + j6;
                }
            }
            j6 += segment.e - segment.d;
            segment = segment.h;
            j3 = j6;
        }
        return -1L;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.b;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.e - segment.d);
        System.arraycopy(segment.c, segment.d, bArr, i, min);
        int i3 = segment.d + min;
        segment.d = i3;
        this.c -= min;
        if (i3 == segment.e) {
            this.b = segment.pop();
            SegmentPool.a(segment);
        }
        return min;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Segment a(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.b;
        if (segment != null) {
            Segment segment2 = segment.i;
            return (segment2.e + i > 8192 || !segment2.g) ? segment2.push(SegmentPool.a()) : segment2;
        }
        Segment a2 = SegmentPool.a();
        this.b = a2;
        a2.i = a2;
        a2.h = a2;
        return a2;
    }

    @Override // com.czhj.wire.okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        long j2 = this.c;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer.write(this, j);
        return j;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment a2 = a(1);
            int min = Math.min(i3 - i, 8192 - a2.e);
            System.arraycopy(bArr, i, a2.c, a2.e, min);
            i += min;
            a2.e += min;
        }
        this.c += j;
        return this;
    }

    public String a(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1L);
        return readUtf82;
    }

    public List<Integer> a() {
        if (this.b == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.b;
        arrayList.add(Integer.valueOf(segment.e - segment.d));
        Segment segment2 = this.b;
        while (true) {
            segment2 = segment2.h;
            if (segment2 == this.b) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.e - segment2.d));
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    private void a(InputStream inputStream, long j, boolean z) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment a2 = a(1);
            int read = inputStream.read(a2.c, a2.e, (int) Math.min(j, 8192 - a2.e));
            if (read == -1) {
                if (a2.d == a2.e) {
                    this.b = a2.pop();
                    SegmentPool.a(a2);
                }
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            a2.e += read;
            long j2 = read;
            this.c += j2;
            j -= j2;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.c, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    private boolean a(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.e;
        byte[] bArr = segment.c;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.h;
                byte[] bArr2 = segment.c;
                bArr = bArr2;
                i = segment.d;
                i4 = segment.e;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0L);
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.c, 0L, j);
        while (j > 0) {
            Segment segment = buffer.b;
            if (j < segment.e - segment.d) {
                Segment segment2 = this.b;
                Segment segment3 = segment2 != null ? segment2.i : null;
                if (segment3 != null && segment3.g) {
                    if ((segment3.e + j) - (segment3.f ? 0 : segment3.d) <= 8192) {
                        segment.writeTo(segment3, (int) j);
                        buffer.c -= j;
                        this.c += j;
                        return;
                    }
                }
                buffer.b = segment.split((int) j);
            }
            Segment segment4 = buffer.b;
            long j2 = segment4.e - segment4.d;
            buffer.b = segment4.pop();
            Segment segment5 = this.b;
            if (segment5 == null) {
                this.b = segment4;
                segment4.i = segment4;
                segment4.h = segment4;
            } else {
                segment5.i.push(segment4).compact();
            }
            buffer.c -= j2;
            this.c += j2;
            j -= j2;
        }
    }

    @Override // com.czhj.wire.okio.BufferedSource
    public long indexOf(ByteString byteString, long j) {
        Buffer buffer = this;
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = buffer.b;
        long j3 = -1;
        if (segment == null) {
            return -1L;
        }
        long j4 = buffer.c;
        if (j4 - j < j) {
            while (j4 > j) {
                segment = segment.i;
                j4 -= segment.e - segment.d;
            }
        } else {
            while (true) {
                long j5 = (segment.e - segment.d) + j2;
                if (j5 >= j) {
                    break;
                }
                segment = segment.h;
                j2 = j5;
            }
            j4 = j2;
        }
        byte b = byteString.getByte(0);
        long j6 = j4;
        int size = byteString.size();
        long j7 = (buffer.c - size) + 1;
        Segment segment2 = segment;
        long j8 = j;
        while (j6 < j7) {
            byte[] bArr = segment2.c;
            long j9 = j3;
            int min = (int) Math.min(segment2.e, (segment2.d + j7) - j6);
            int i = (int) ((segment2.d + j8) - j6);
            while (i < min) {
                if (bArr[i] == b && buffer.a(segment2, i + 1, byteString, 1, size)) {
                    return (i - segment2.d) + j6;
                }
                i++;
                buffer = this;
            }
            j6 += segment2.e - segment2.d;
            segment2 = segment2.h;
            buffer = this;
            j8 = j6;
            j3 = j9;
        }
        return j3;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }
}
