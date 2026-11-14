package com.bytedance.sdk.component.w.xj;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.views.r;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w implements kd, u, Cloneable, ByteChannel {
    private static final byte[] w = {com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 56, 57, 97, 98, 99, 100, 101, 102};
    long hf;
    qt xj;

    @Override // com.bytedance.sdk.component.w.xj.yo
    public void a_(w wVar, long j) {
        qt qtVar;
        if (wVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (wVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        pz.xj(wVar.hf, 0L, j);
        while (j > 0 && (qtVar = wVar.xj) != null) {
            if (j < qtVar.w - qtVar.hf) {
                qt qtVar2 = this.xj;
                qt qtVar3 = qtVar2 != null ? qtVar2.c : null;
                if (qtVar3 != null && qtVar3.kd) {
                    if ((qtVar3.w + j) - (qtVar3.u ? 0 : qtVar3.hf) <= 8192) {
                        qtVar.xj(qtVar3, (int) j);
                        wVar.hf -= j;
                        this.hf += j;
                        return;
                    }
                }
                wVar.xj = qtVar.xj((int) j);
            }
            qt qtVar4 = wVar.xj;
            long j2 = qtVar4.w - qtVar4.hf;
            wVar.xj = qtVar4.hf();
            qt qtVar5 = this.xj;
            if (qtVar5 == null) {
                this.xj = qtVar4;
                qtVar4.c = qtVar4;
                qtVar4.y = qtVar4;
            } else {
                qtVar5.c.xj(qtVar4).w();
            }
            wVar.hf -= j2;
            this.hf += j2;
            j -= j2;
        }
    }

    public y am() {
        return new y(e());
    }

    @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public byte[] e() {
        return c(this.hf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        long j = this.hf;
        if (j != wVar.hf) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        qt qtVar = this.xj;
        qt qtVar2 = wVar.xj;
        int i = qtVar.hf;
        int i2 = qtVar2.hf;
        while (j2 < this.hf) {
            long min = Math.min(qtVar.w - i, qtVar2.w - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (qtVar.xj[i] != qtVar2.xj[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == qtVar.w) {
                qtVar = qtVar.y;
                i = qtVar.hf;
            }
            if (i2 == qtVar2.w) {
                qtVar2 = qtVar2.y;
                i2 = qtVar2.hf;
            }
            j2 += min;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.w.xj.u, com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
    public void flush() {
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095 A[EDGE_INSN: B:40:0x0095->B:37:0x0095 BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    @Override // com.bytedance.sdk.component.w.xj.kd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long g() {
        /*
            r15 = this;
            long r0 = r15.hf
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9c
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.bytedance.sdk.component.w.xj.qt r6 = r15.xj
            byte[] r7 = r6.xj
            int r8 = r6.hf
            int r9 = r6.w
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
            com.bytedance.sdk.component.w.xj.w r0 = new com.bytedance.sdk.component.w.xj.w
            r0.<init>()
            com.bytedance.sdk.component.w.xj.w r0 = r0.p(r4)
            com.bytedance.sdk.component.w.xj.w r0 = r0.d(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.qt()
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
            com.bytedance.sdk.component.w.xj.qt r7 = r6.hf()
            r15.xj = r7
            com.bytedance.sdk.component.w.xj.zg.xj(r6)
            goto L8f
        L8d:
            r6.hf = r8
        L8f:
            if (r1 != 0) goto L95
            com.bytedance.sdk.component.w.xj.qt r6 = r15.xj
            if (r6 != 0) goto Lb
        L95:
            long r1 = r15.hf
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.hf = r1
            return r4
        L9c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.xj.w.g():long");
    }

    public int hashCode() {
        qt qtVar = this.xj;
        if (qtVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = qtVar.w;
            for (int i3 = qtVar.hf; i3 < i2; i3++) {
                i = (i * 31) + qtVar.xj[i3];
            }
            qtVar = qtVar.y;
        } while (qtVar != this.xj);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final y jk() {
        long j = this.hf;
        if (j <= 2147483647L) {
            return y((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.hf);
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public boolean kd() {
        return this.hf == 0;
    }

    public String qt() {
        try {
            return xj(this.hf, pz.xj);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        qt qtVar = this.xj;
        if (qtVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), qtVar.w - qtVar.hf);
        byteBuffer.put(qtVar.xj, qtVar.hf, min);
        int i = qtVar.hf + min;
        qtVar.hf = i;
        this.hf -= min;
        if (i == qtVar.w) {
            this.xj = qtVar.hf();
            zg.xj(qtVar);
        }
        return min;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public int tf() {
        long j = this.hf;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.hf);
        }
        qt qtVar = this.xj;
        int i = qtVar.hf;
        int i2 = qtVar.w;
        if (i2 - i < 4) {
            return ((f() & 255) << 24) | ((f() & 255) << 16) | ((f() & 255) << 8) | (f() & 255);
        }
        byte[] bArr = qtVar.xj;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.hf = j - 4;
        if (i5 != i2) {
            qtVar.hf = i5;
            return i6;
        }
        this.xj = qtVar.hf();
        zg.xj(qtVar);
        return i6;
    }

    public String toString() {
        return jk().toString();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public w pz() {
        return this;
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public w clone() {
        w wVar = new w();
        if (this.hf == 0) {
            return wVar;
        }
        qt xj = this.xj.xj();
        wVar.xj = xj;
        xj.c = xj;
        xj.y = xj;
        qt qtVar = this.xj;
        while (true) {
            qtVar = qtVar.y;
            if (qtVar == this.xj) {
                wVar.hf = this.hf;
                return wVar;
            }
            wVar.xj.c.xj(qtVar.xj());
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public w w() {
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            qt kd = kd(1);
            int min = Math.min(i, 8192 - kd.w);
            byteBuffer.get(kd.xj, kd.w, min);
            i -= min;
            kd.w += min;
        }
        this.hf += remaining;
        return remaining;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public void xj(long j) {
        if (this.hf < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public InputStream y() {
        return new InputStream() { // from class: com.bytedance.sdk.component.w.xj.w.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(w.this.hf, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                w wVar = w.this;
                if (wVar.hf > 0) {
                    return wVar.f() & 255;
                }
                return -1;
            }

            public String toString() {
                return w.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return w.this.xj(bArr, i, i2);
            }
        };
    }

    public final void yo() {
        try {
            f(this.hf);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public String zg() {
        return kd(Long.MAX_VALUE);
    }

    public final long c() {
        long j = this.hf;
        if (j == 0) {
            return 0L;
        }
        qt qtVar = this.xj.c;
        return (qtVar.w >= 8192 || !qtVar.kd) ? j : j - (r3 - qtVar.hf);
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public short d() {
        long j = this.hf;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.hf);
        }
        qt qtVar = this.xj;
        int i = qtVar.hf;
        int i2 = qtVar.w;
        if (i2 - i < 2) {
            return (short) (((f() & 255) << 8) | (f() & 255));
        }
        byte[] bArr = qtVar.xj;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.hf = j - 2;
        if (i5 == i2) {
            this.xj = qtVar.hf();
            zg.xj(qtVar);
        } else {
            qtVar.hf = i5;
        }
        return (short) i6;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public byte f() {
        long j = this.hf;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        qt qtVar = this.xj;
        int i = qtVar.hf;
        int i2 = qtVar.w;
        int i3 = i + 1;
        byte b = qtVar.xj[i];
        this.hf = j - 1;
        if (i3 != i2) {
            qtVar.hf = i3;
            return b;
        }
        this.xj = qtVar.hf();
        zg.xj(qtVar);
        return b;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public String kd(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long xj = xj((byte) 10, 0L, j2);
        if (xj != -1) {
            return y(xj);
        }
        if (j2 < hf() && hf(j2 - 1) == 13 && hf(j2) == 10) {
            return y(j2);
        }
        w wVar = new w();
        xj(wVar, 0L, Math.min(32L, hf()));
        throw new EOFException("\\n not found: limit=" + Math.min(hf(), j) + " content=" + wVar.am().kd() + (char) 8230);
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public short p() {
        return pz.xj(d());
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public int pl() {
        return pz.xj(tf());
    }

    public String u(long j) {
        return xj(j, pz.xj);
    }

    public final w xj(w wVar, long j, long j2) {
        if (wVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        long j3 = j;
        pz.xj(this.hf, j3, j2);
        if (j2 != 0) {
            wVar.hf += j2;
            qt qtVar = this.xj;
            while (true) {
                int i = qtVar.w;
                int i2 = qtVar.hf;
                if (j3 < i - i2) {
                    break;
                }
                j3 -= i - i2;
                qtVar = qtVar.y;
            }
            qt qtVar2 = qtVar;
            long j4 = j2;
            while (j4 > 0) {
                qt xj = qtVar2.xj();
                int i3 = (int) (xj.hf + j3);
                xj.hf = i3;
                xj.w = Math.min(i3 + ((int) j4), xj.w);
                qt qtVar3 = wVar.xj;
                if (qtVar3 == null) {
                    xj.c = xj;
                    xj.y = xj;
                    wVar.xj = xj;
                } else {
                    qtVar3.c.xj(xj);
                }
                j4 -= xj.w - xj.hf;
                qtVar2 = qtVar2.y;
                j3 = 0;
            }
        }
        return this;
    }

    public String y(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (hf(j2) == 13) {
                String u = u(j2);
                f(2L);
                return u;
            }
        }
        String u2 = u(j);
        f(1L);
        return u2;
    }

    public final long hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public w c(int i) {
        qt kd = kd(4);
        byte[] bArr = kd.xj;
        int i2 = kd.w;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        kd.w = i2 + 4;
        this.hf += 4;
        return this;
    }

    public final byte hf(long j) {
        int i;
        long j2 = j;
        pz.xj(this.hf, j2, 1L);
        long j3 = this.hf;
        if (j3 - j2 > j2) {
            qt qtVar = this.xj;
            while (true) {
                int i2 = qtVar.w;
                int i3 = qtVar.hf;
                long j4 = i2 - i3;
                if (j2 < j4) {
                    return qtVar.xj[i3 + ((int) j2)];
                }
                j2 -= j4;
                qtVar = qtVar.y;
            }
        } else {
            long j5 = j2 - j3;
            try {
                qt qtVar2 = this.xj;
                do {
                    qtVar2 = qtVar2.c;
                    int i4 = qtVar2.w;
                    i = qtVar2.hf;
                    j5 += i4 - i;
                } while (j5 < 0);
                return qtVar2.xj[i + ((int) j5)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public y w(long j) {
        return new y(c(j));
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public w f(int i) {
        qt kd = kd(2);
        byte[] bArr = kd.xj;
        int i2 = kd.w;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        kd.w = i2 + 2;
        this.hf += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public byte[] c(long j) {
        pz.xj(this.hf, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            xj(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final y y(int i) {
        if (i == 0) {
            return y.hf;
        }
        return new e(this, i);
    }

    public qt kd(int i) {
        if (i > 0 && i <= 8192) {
            qt qtVar = this.xj;
            if (qtVar == null) {
                qt xj = zg.xj();
                this.xj = xj;
                xj.c = xj;
                xj.y = xj;
                return xj;
            }
            qt qtVar2 = qtVar.c;
            return (qtVar2.w + i > 8192 || !qtVar2.kd) ? qtVar2.xj(zg.xj()) : qtVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public void f(long j) {
        qt qtVar;
        while (j > 0 && (qtVar = this.xj) != null) {
            int min = (int) Math.min(j, qtVar.w - qtVar.hf);
            long j2 = min;
            this.hf -= j2;
            j -= j2;
            qt qtVar2 = this.xj;
            int i = qtVar2.hf + min;
            qtVar2.hf = i;
            if (i == qtVar2.w) {
                this.xj = qtVar2.hf();
                zg.xj(qtVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public w w(byte[] bArr) {
        if (bArr != null) {
            return w(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public w pl(long j) {
        boolean z;
        if (j == 0) {
            return d(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return hf("-9223372036854775808");
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
        qt kd = kd(i);
        byte[] bArr = kd.xj;
        int i2 = kd.w + i;
        while (j != 0) {
            i2--;
            bArr[i2] = w[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        kd.w += i;
        this.hf += i;
        return this;
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public w w(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            pz.xj(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                qt kd = kd(1);
                int min = Math.min(i3 - i, 8192 - kd.w);
                System.arraycopy(bArr, i, kd.xj, kd.w, min);
                i += min;
                kd.w += min;
            }
            this.hf += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public String xj(Charset charset) {
        try {
            return xj(this.hf, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: tf, reason: merged with bridge method [inline-methods] */
    public w p(long j) {
        if (j == 0) {
            return d(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        qt kd = kd(numberOfTrailingZeros);
        byte[] bArr = kd.xj;
        int i = kd.w;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = w[(int) (15 & j)];
            j >>>= 4;
        }
        kd.w += numberOfTrailingZeros;
        this.hf += numberOfTrailingZeros;
        return this;
    }

    public String xj(long j, Charset charset) {
        pz.xj(this.hf, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        qt qtVar = this.xj;
        int i = qtVar.hf;
        if (i + j > qtVar.w) {
            return new String(c(j), charset);
        }
        String str = new String(qtVar.xj, i, (int) j, charset);
        int i2 = (int) (qtVar.hf + j);
        qtVar.hf = i2;
        this.hf -= j;
        if (i2 == qtVar.w) {
            this.xj = qtVar.hf();
            zg.xj(qtVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public w d(int i) {
        qt kd = kd(1);
        byte[] bArr = kd.xj;
        int i2 = kd.w;
        kd.w = i2 + 1;
        bArr[i2] = (byte) i;
        this.hf++;
        return this;
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public void xj(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int xj = xj(bArr, i, bArr.length - i);
            if (xj == -1) {
                throw new EOFException();
            }
            i += xj;
        }
    }

    public int xj(byte[] bArr, int i, int i2) {
        pz.xj(bArr.length, i, i2);
        qt qtVar = this.xj;
        if (qtVar == null) {
            return -1;
        }
        int min = Math.min(i2, qtVar.w - qtVar.hf);
        System.arraycopy(qtVar.xj, qtVar.hf, bArr, i, min);
        int i3 = qtVar.hf + min;
        qtVar.hf = i3;
        this.hf -= min;
        if (i3 == qtVar.w) {
            this.xj = qtVar.hf();
            zg.xj(qtVar);
        }
        return min;
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public w hf(y yVar) {
        if (yVar != null) {
            yVar.xj(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public w hf(String str) {
        return xj(str, 0, str.length());
    }

    public w xj(String str, int i, int i2) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
                B9tovu2.append(str.length());
                throw new IllegalArgumentException(B9tovu2.toString());
            }
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    qt kd = kd(1);
                    byte[] bArr = kd.xj;
                    int i3 = kd.w - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                    }
                    int i5 = kd.w;
                    int i6 = (i3 + i) - i5;
                    kd.w = i5 + i6;
                    this.hf += i6;
                } else {
                    if (charAt2 < 2048) {
                        d((charAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                        d((charAt2 & '?') | r.b.d);
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            d((i8 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                            d(((i8 >> 12) & 63) | r.b.d);
                            d(((i8 >> 6) & 63) | r.b.d);
                            d((i8 & 63) | r.b.d);
                            i += 2;
                        } else {
                            d(63);
                            i = i7;
                        }
                    } else {
                        d((charAt2 >> '\f') | 224);
                        d(((charAt2 >> 6) & 63) | r.b.d);
                        d((charAt2 & '?') | r.b.d);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
    }

    public w xj(int i) {
        if (i < 128) {
            d(i);
            return this;
        }
        if (i < 2048) {
            d((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            d((i & 63) | r.b.d);
            return this;
        }
        if (i >= 65536) {
            if (i <= 1114111) {
                d((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                d(((i >> 12) & 63) | r.b.d);
                d(((i >> 6) & 63) | r.b.d);
                d((i & 63) | r.b.d);
                return this;
            }
            throw new IllegalArgumentException(CtFAbx.AzWtSf(new StringBuilder("Unexpected code point: "), i));
        }
        if (i >= 55296 && i <= 57343) {
            d(63);
            return this;
        }
        d((i >> 12) | 224);
        d(((i >> 6) & 63) | r.b.d);
        d((i & 63) | r.b.d);
        return this;
    }

    public w xj(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
                B9tovu2.append(str.length());
                throw new IllegalArgumentException(B9tovu2.toString());
            }
            if (charset != null) {
                if (charset.equals(pz.xj)) {
                    return xj(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return w(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
    }

    public long xj(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long xj = vVar.xj(this, 8192L);
            if (xj == -1) {
                return j;
            }
            j += xj;
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public long xj(w wVar, long j) {
        if (wVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.hf;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            wVar.a_(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public long xj(byte b) {
        return xj(b, 0L, Long.MAX_VALUE);
    }

    public long xj(byte b, long j, long j2) {
        qt qtVar;
        long j3 = j;
        long j4 = j2;
        long j5 = 0;
        if (j3 >= 0 && j4 >= j3) {
            long j6 = this.hf;
            if (j4 > j6) {
                j4 = j6;
            }
            if (j3 == j4 || (qtVar = this.xj) == null) {
                return -1L;
            }
            if (j6 - j3 < j3) {
                while (j6 > j3) {
                    qtVar = qtVar.c;
                    j6 -= qtVar.w - qtVar.hf;
                }
            } else {
                while (true) {
                    long j7 = (qtVar.w - qtVar.hf) + j5;
                    if (j7 >= j3) {
                        break;
                    }
                    qtVar = qtVar.y;
                    j5 = j7;
                }
                j6 = j5;
            }
            while (j6 < j4) {
                byte[] bArr = qtVar.xj;
                int min = (int) Math.min(qtVar.w, (qtVar.hf + j4) - j6);
                for (int i = (int) ((qtVar.hf + j3) - j6); i < min; i++) {
                    if (bArr[i] == b) {
                        return (i - qtVar.hf) + j6;
                    }
                }
                j6 += qtVar.w - qtVar.hf;
                qtVar = qtVar.y;
                j3 = j6;
            }
            return -1L;
        }
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("size=", this.hf, " fromIndex=");
        B2KMhB2.append(j3);
        B2KMhB2.append(" toIndex=");
        B2KMhB2.append(j4);
        throw new IllegalArgumentException(B2KMhB2.toString());
    }

    @Override // com.bytedance.sdk.component.w.xj.kd
    public boolean xj(long j, y yVar) {
        return xj(j, yVar, 0, yVar.c());
    }

    public boolean xj(long j, y yVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.hf - j < i2 || yVar.c() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (hf(i3 + j) != yVar.xj(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public jk xj() {
        return jk.w;
    }
}
