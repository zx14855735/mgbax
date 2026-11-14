package com.bytedance.sdk.component.w.xj;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class am implements kd {
    public final v hf;
    boolean w;
    public final w xj = new w();

    public am(v vVar) {
        if (vVar == null) {
            throw new NullPointerException("source == null");
        }
        this.hf = vVar;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public byte[] c(long j) {
        xj(j);
        return this.xj.c(j);
    }

    @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.w) {
            return;
        }
        this.w = true;
        this.hf.close();
        this.xj.yo();
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public short d() {
        xj(2L);
        return this.xj.d();
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public byte[] e() {
        this.xj.xj(this.hf);
        return this.xj.e();
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public byte f() {
        xj(1L);
        return this.xj.f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r2 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r4)));
     */
    @Override // com.bytedance.sdk.component.w.xj.kd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long g() {
        /*
            r7 = this;
            r0 = 1
            r1 = 1
            r7.xj(r1)
            r1 = 0
            r2 = 0
        L8:
            int r3 = r2 + 1
            long r4 = (long) r3
            boolean r4 = r7.hf(r4)
            if (r4 == 0) goto L4a
            com.bytedance.sdk.component.w.xj.w r4 = r7.xj
            long r5 = (long) r2
            byte r4 = r4.hf(r5)
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
            com.bytedance.sdk.component.w.xj.w r0 = r7.xj
            long r0 = r0.g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.xj.am.g():long");
    }

    public boolean hf(long j) {
        w wVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        do {
            wVar = this.xj;
            if (wVar.hf >= j) {
                return true;
            }
        } while (this.hf.xj(wVar, 8192L) != -1);
        return false;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.w;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public boolean kd() {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        return this.xj.kd() && this.hf.xj(this.xj, 8192L) == -1;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public short p() {
        xj(2L);
        return this.xj.p();
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public int pl() {
        xj(4L);
        return this.xj.pl();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        w wVar = this.xj;
        if (wVar.hf == 0 && this.hf.xj(wVar, 8192L) == -1) {
            return -1;
        }
        return this.xj.read(byteBuffer);
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public int tf() {
        xj(4L);
        return this.xj.tf();
    }

    public String toString() {
        return "buffer(" + this.hf + ")";
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public w w() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public long xj(w wVar, long j) {
        if (wVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        w wVar2 = this.xj;
        if (wVar2.hf == 0 && this.hf.xj(wVar2, 8192L) == -1) {
            return -1L;
        }
        return this.xj.xj(wVar, Math.min(j, this.xj.hf));
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public InputStream y() {
        return new InputStream() { // from class: com.bytedance.sdk.component.w.xj.am.1
            @Override // java.io.InputStream
            public int available() {
                am amVar = am.this;
                if (amVar.w) {
                    throw new IOException("closed");
                }
                return (int) Math.min(amVar.xj.hf, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                am.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                am amVar = am.this;
                if (amVar.w) {
                    throw new IOException("closed");
                }
                w wVar = amVar.xj;
                if (wVar.hf == 0 && amVar.hf.xj(wVar, 8192L) == -1) {
                    return -1;
                }
                return am.this.xj.f() & 255;
            }

            public String toString() {
                return am.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                if (!am.this.w) {
                    pz.xj(bArr.length, i, i2);
                    am amVar = am.this;
                    w wVar = amVar.xj;
                    if (wVar.hf == 0 && amVar.hf.xj(wVar, 8192L) == -1) {
                        return -1;
                    }
                    return am.this.xj.xj(bArr, i, i2);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public String zg() {
        return kd(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public y w(long j) {
        xj(j);
        return this.xj.w(j);
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public void f(long j) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            w wVar = this.xj;
            if (wVar.hf == 0 && this.hf.xj(wVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.xj.hf());
            this.xj.f(min);
            j -= min;
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public String kd(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long xj = xj((byte) 10, 0L, j2);
            if (xj != -1) {
                return this.xj.y(xj);
            }
            if (j2 < Long.MAX_VALUE && hf(j2) && this.xj.hf(j2 - 1) == 13 && hf(1 + j2) && this.xj.hf(j2) == 10) {
                return this.xj.y(j2);
            }
            w wVar = new w();
            w wVar2 = this.xj;
            wVar2.xj(wVar, 0L, Math.min(32L, wVar2.hf()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.xj.hf(), j) + " content=" + wVar.am().kd() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public void xj(long j) {
        if (!hf(j)) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public void xj(byte[] bArr) {
        try {
            xj(bArr.length);
            this.xj.xj(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                w wVar = this.xj;
                long j = wVar.hf;
                if (j > 0) {
                    int xj = wVar.xj(bArr, i, (int) j);
                    if (xj == -1) {
                        throw new AssertionError();
                    }
                    i += xj;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public String xj(Charset charset) {
        if (charset != null) {
            this.xj.xj(this.hf);
            return this.xj.xj(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public long xj(byte b) {
        return xj(b, 0L, Long.MAX_VALUE);
    }

    public long xj(byte b, long j, long j2) {
        if (this.w) {
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
            long xj = this.xj.xj(b2, j3, j4);
            if (xj == -1) {
                w wVar = this.xj;
                long j5 = wVar.hf;
                if (j5 >= j4 || this.hf.xj(wVar, 8192L) == -1) {
                    break;
                }
                j3 = Math.max(j3, j5);
                b = b2;
                j2 = j4;
            } else {
                return xj;
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public boolean xj(long j, y yVar) {
        return xj(j, yVar, 0, yVar.c());
    }

    public boolean xj(long j, y yVar, int i, int i2) {
        if (!this.w) {
            if (j < 0 || i < 0 || i2 < 0 || yVar.c() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!hf(1 + j2) || this.xj.hf(j2) != yVar.xj(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public jk xj() {
        return this.hf.xj();
    }
}
