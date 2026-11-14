package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.base.views.r;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaao implements aaaaaaau, aaaaaaac, Cloneable, ByteChannel {
    private static final byte[] aaaaaaao = {e.H, e.I, e.J, e.K, e.L, e.M, e.N, e.O, 56, 57, 97, 98, 99, 100, 101, 102};
    long aaaaaaa0;
    aeaaaaaa aaaaaaaa;

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public aaaaaaan aaaaaaa0(long j) {
        return new aaaaaaan(aaaaaaao(j));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaao aaaaaaaa() {
        return this;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public String aaaaaaac(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("limit < 0: ", j));
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long aaaaaaaa = aaaaaaaa((byte) 10, 0L, j2);
        if (aaaaaaaa != -1) {
            return aaaaaaav(aaaaaaaa);
        }
        if (j2 < size() && aaaaaaan(j2 - 1) == 13 && aaaaaaan(j2) == 10) {
            return aaaaaaav(j2);
        }
        aaaaaaao aaaaaaaoVar = new aaaaaaao();
        aaaaaaaa(aaaaaaaoVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + aaaaaaaoVar.aaaaeaaa().aaaaaaa0() + (char) 8230);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public short aaaaaaae() {
        return aaaaaaoa.aaaaaaaa(readShort());
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public boolean aaaaaaan() {
        return this.aaaaaaa0 == 0;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public String aaaaaaao() {
        return aaaaaaac(Long.MAX_VALUE);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public void aaaaaaau(long j) {
        if (this.aaaaaaa0 < j) {
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095 A[EDGE_INSN: B:40:0x0095->B:37:0x0095 BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long aaaaaaav() {
        /*
            r15 = this;
            long r0 = r15.aaaaaaa0
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9c
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aeaaaaaa r6 = r15.aaaaaaaa
            byte[] r7 = r6.aaaaaaaa
            int r8 = r6.aaaaaaa0
            int r9 = r6.aaaaaaao
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
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao
            r0.<init>()
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r0 = r0.aaaaaaaa(r4)
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.aaaaaeaa()
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
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aeaaaaaa r7 = r6.aaaaaaa0()
            r15.aaaaaaaa = r7
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aoaaaaaa.aaaaaaaa(r6)
            goto L8f
        L8d:
            r6.aaaaaaa0 = r8
        L8f:
            if (r1 != 0) goto L95
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aeaaaaaa r6 = r15.aaaaaaaa
            if (r6 != 0) goto Lb
        L95:
            long r1 = r15.aaaaaaa0
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.aaaaaaa0 = r1
            return r4
        L9c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao.aaaaaaav():long");
    }

    public final aaaaaaan aaaaaaea() {
        long j = this.aaaaaaa0;
        if (j <= 2147483647L) {
            return aaaaaaaa((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.aaaaaaa0);
    }

    public final void aaaaaaeo() {
        try {
            skip(this.aaaaaaa0);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String aaaaaeaa() {
        try {
            return aaaaaaaa(this.aaaaaaa0, aaaaaaoa.aaaaaaaa);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public aaaaaaan aaaaeaaa() {
        return new aaaaaaan(aaaaaaac());
    }

    public final long aaaeaaaa() {
        long j = this.aaaaaaa0;
        if (j == 0) {
            return 0L;
        }
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa.aaaaaaae;
        return (aeaaaaaaVar.aaaaaaao >= 8192 || !aeaaaaaaVar.aaaaaaau) ? j : j - (r3 - aeaaaaaaVar.aaaaaaa0);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aaaaaaao)) {
            return false;
        }
        aaaaaaao aaaaaaaoVar = (aaaaaaao) obj;
        long j = this.aaaaaaa0;
        if (j != aaaaaaaoVar.aaaaaaa0) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        aeaaaaaa aeaaaaaaVar2 = aaaaaaaoVar.aaaaaaaa;
        int i = aeaaaaaaVar.aaaaaaa0;
        int i2 = aeaaaaaaVar2.aaaaaaa0;
        while (j2 < this.aaaaaaa0) {
            long min = Math.min(aeaaaaaaVar.aaaaaaao - i, aeaaaaaaVar2.aaaaaaao - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (aeaaaaaaVar.aaaaaaaa[i] != aeaaaaaaVar2.aaaaaaaa[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == aeaaaaaaVar.aaaaaaao) {
                aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
                i = aeaaaaaaVar.aaaaaaa0;
            }
            if (i2 == aeaaaaaaVar2.aaaaaaao) {
                aeaaaaaaVar2 = aeaaaaaaVar2.aaaaaaan;
                i2 = aeaaaaaaVar2.aaaaaaa0;
            }
            j2 += min;
        }
        return true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        if (aeaaaaaaVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = aeaaaaaaVar.aaaaaaao;
            for (int i3 = aeaaaaaaVar.aaaaaaa0; i3 < i2; i3++) {
                i = (i * 31) + aeaaaaaaVar.aaaaaaaa[i3];
            }
            aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
        } while (aeaaaaaaVar != this.aaaaaaaa);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public int read(byte[] bArr, int i, int i2) {
        aaaaaaoa.aaaaaaaa(bArr.length, i, i2);
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        if (aeaaaaaaVar == null) {
            return -1;
        }
        int min = Math.min(i2, aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0);
        System.arraycopy(aeaaaaaaVar.aaaaaaaa, aeaaaaaaVar.aaaaaaa0, bArr, i, min);
        int i3 = aeaaaaaaVar.aaaaaaa0 + min;
        aeaaaaaaVar.aaaaaaa0 = i3;
        this.aaaaaaa0 -= min;
        if (i3 == aeaaaaaaVar.aaaaaaao) {
            this.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
            aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
        }
        return min;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public byte readByte() {
        long j = this.aaaaaaa0;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        int i = aeaaaaaaVar.aaaaaaa0;
        int i2 = aeaaaaaaVar.aaaaaaao;
        int i3 = i + 1;
        byte b = aeaaaaaaVar.aaaaaaaa[i];
        this.aaaaaaa0 = j - 1;
        if (i3 != i2) {
            aeaaaaaaVar.aaaaaaa0 = i3;
            return b;
        }
        this.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
        aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
        return b;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
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

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public int readInt() {
        long j = this.aaaaaaa0;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.aaaaaaa0);
        }
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        int i = aeaaaaaaVar.aaaaaaa0;
        int i2 = aeaaaaaaVar.aaaaaaao;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = aeaaaaaaVar.aaaaaaaa;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.aaaaaaa0 = j - 4;
        if (i5 != i2) {
            aeaaaaaaVar.aaaaaaa0 = i5;
            return i6;
        }
        this.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
        aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
        return i6;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public short readShort() {
        long j = this.aaaaaaa0;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.aaaaaaa0);
        }
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        int i = aeaaaaaaVar.aaaaaaa0;
        int i2 = aeaaaaaaVar.aaaaaaao;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = aeaaaaaaVar.aaaaaaaa;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.aaaaaaa0 = j - 2;
        if (i5 == i2) {
            this.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
            aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
        } else {
            aeaaaaaaVar.aaaaaaa0 = i5;
        }
        return (short) i6;
    }

    public final long size() {
        return this.aaaaaaa0;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public void skip(long j) {
        while (j > 0) {
            if (this.aaaaaaaa == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.aaaaaaao - r0.aaaaaaa0);
            long j2 = min;
            this.aaaaaaa0 -= j2;
            j -= j2;
            aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
            int i = aeaaaaaaVar.aaaaaaa0 + min;
            aeaaaaaaVar.aaaaaaa0 = i;
            if (i == aeaaaaaaVar.aaaaaaao) {
                this.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
                aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
            }
        }
    }

    public String toString() {
        return aaaaaaea().toString();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    /* renamed from: aaaaaaa0, reason: merged with bridge method [inline-methods] */
    public aaaaaaao aaaaaaaa(String str) {
        return aaaaaaaa(str, 0, str.length());
    }

    public String aaaaaaae(long j) {
        return aaaaaaaa(j, aaaaaaoa.aaaaaaaa);
    }

    public final byte aaaaaaan(long j) {
        aaaaaaoa.aaaaaaaa(this.aaaaaaa0, j, 1L);
        long j2 = this.aaaaaaa0;
        if (j2 - j > j) {
            aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
            long j3 = j;
            while (true) {
                int i = aeaaaaaaVar.aaaaaaao;
                int i2 = aeaaaaaaVar.aaaaaaa0;
                long j4 = i - i2;
                if (j3 < j4) {
                    return aeaaaaaaVar.aaaaaaaa[i2 + ((int) j3)];
                }
                j3 -= j4;
                aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
            }
        } else {
            long j5 = j - j2;
            aeaaaaaa aeaaaaaaVar2 = this.aaaaaaaa.aaaaaaae;
            while (true) {
                int i3 = aeaaaaaaVar2.aaaaaaao;
                int i4 = aeaaaaaaVar2.aaaaaaa0;
                j5 += i3 - i4;
                if (j5 >= 0) {
                    return aeaaaaaaVar2.aaaaaaaa[i4 + ((int) j5)];
                }
                aeaaaaaaVar2 = aeaaaaaaVar2.aaaaaaae;
            }
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public byte[] aaaaaaao(long j) {
        aaaaaaoa.aaaaaaaa(this.aaaaaaa0, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount > Integer.MAX_VALUE: ", j));
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public int aaaaaaau() {
        return aaaaaaoa.aaaaaaaa(readInt());
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public aaaaaaao m21clone() {
        aaaaaaao aaaaaaaoVar = new aaaaaaao();
        if (this.aaaaaaa0 == 0) {
            return aaaaaaaoVar;
        }
        aeaaaaaa aaaaaaao2 = this.aaaaaaaa.aaaaaaao();
        aaaaaaaoVar.aaaaaaaa = aaaaaaao2;
        aaaaaaao2.aaaaaaae = aaaaaaao2;
        aaaaaaao2.aaaaaaan = aaaaaaao2;
        for (aeaaaaaa aeaaaaaaVar = this.aaaaaaaa.aaaaaaan; aeaaaaaaVar != this.aaaaaaaa; aeaaaaaaVar = aeaaaaaaVar.aaaaaaan) {
            aaaaaaaoVar.aaaaaaaa.aaaaaaae.aaaaaaaa(aeaaaaaaVar.aaaaaaao());
        }
        aaaaaaaoVar.aaaaaaa0 = this.aaaaaaa0;
        return aaaaaaaoVar;
    }

    public aeaaaaaa aaaaaaa0(int i) {
        if (i >= 1 && i <= 8192) {
            aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
            if (aeaaaaaaVar == null) {
                aeaaaaaa aaaaaaaa = aoaaaaaa.aaaaaaaa();
                this.aaaaaaaa = aaaaaaaa;
                aaaaaaaa.aaaaaaae = aaaaaaaa;
                aaaaaaaa.aaaaaaan = aaaaaaaa;
                return aaaaaaaa;
            }
            aeaaaaaa aeaaaaaaVar2 = aeaaaaaaVar.aaaaaaae;
            return (aeaaaaaaVar2.aaaaaaao + i > 8192 || !aeaaaaaaVar2.aaaaaaau) ? aeaaaaaaVar2.aaaaaaaa(aoaaaaaa.aaaaaaaa()) : aeaaaaaaVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    /* renamed from: aaaaaaau, reason: merged with bridge method [inline-methods] */
    public aaaaaaao writeShort(int i) {
        aeaaaaaa aaaaaaa0 = aaaaaaa0(2);
        byte[] bArr = aaaaaaa0.aaaaaaaa;
        int i2 = aaaaaaa0.aaaaaaao;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        aaaaaaa0.aaaaaaao = i2 + 2;
        this.aaaaaaa0 += 2;
        return this;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    /* renamed from: aaaaaaeo, reason: merged with bridge method [inline-methods] */
    public aaaaaaao aaaaaaaa(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        aeaaaaaa aaaaaaa0 = aaaaaaa0(numberOfTrailingZeros);
        byte[] bArr = aaaaaaa0.aaaaaaaa;
        int i = aaaaaaa0.aaaaaaao;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = aaaaaaao[(int) (15 & j)];
            j >>>= 4;
        }
        aaaaaaa0.aaaaaaao += numberOfTrailingZeros;
        this.aaaaaaa0 += numberOfTrailingZeros;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                aeaaaaaa aaaaaaa0 = aaaaaaa0(1);
                int min = Math.min(i, 8192 - aaaaaaa0.aaaaaaao);
                byteBuffer.get(aaaaaaa0.aaaaaaaa, aaaaaaa0.aaaaaaao, min);
                i -= min;
                aaaaaaa0.aaaaaaao += min;
            }
            this.aaaaaaa0 += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final aaaaaaao aaaaaaaa(aaaaaaao aaaaaaaoVar, long j, long j2) {
        if (aaaaaaaoVar != null) {
            long j3 = j;
            aaaaaaoa.aaaaaaaa(this.aaaaaaa0, j3, j2);
            if (j2 != 0) {
                aaaaaaaoVar.aaaaaaa0 += j2;
                aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
                while (true) {
                    long j4 = aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0;
                    if (j3 < j4) {
                        break;
                    }
                    j3 -= j4;
                    aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
                }
                aeaaaaaa aeaaaaaaVar2 = aeaaaaaaVar;
                long j5 = j2;
                while (j5 > 0) {
                    aeaaaaaa aaaaaaao2 = aeaaaaaaVar2.aaaaaaao();
                    int i = (int) (aaaaaaao2.aaaaaaa0 + j3);
                    aaaaaaao2.aaaaaaa0 = i;
                    aaaaaaao2.aaaaaaao = Math.min(i + ((int) j5), aaaaaaao2.aaaaaaao);
                    aeaaaaaa aeaaaaaaVar3 = aaaaaaaoVar.aaaaaaaa;
                    if (aeaaaaaaVar3 == null) {
                        aaaaaaao2.aaaaaaae = aaaaaaao2;
                        aaaaaaao2.aaaaaaan = aaaaaaao2;
                        aaaaaaaoVar.aaaaaaaa = aaaaaaao2;
                    } else {
                        aeaaaaaaVar3.aaaaaaae.aaaaaaaa(aaaaaaao2);
                    }
                    j5 -= aaaaaaao2.aaaaaaao - aaaaaaao2.aaaaaaa0;
                    aeaaaaaaVar2 = aeaaaaaaVar2.aaaaaaan;
                    j3 = 0;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
    public void aaaaaaa0(aaaaaaao aaaaaaaoVar, long j) {
        if (aaaaaaaoVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (aaaaaaaoVar != this) {
            aaaaaaoa.aaaaaaaa(aaaaaaaoVar.aaaaaaa0, 0L, j);
            while (j > 0) {
                aeaaaaaa aeaaaaaaVar = aaaaaaaoVar.aaaaaaaa;
                if (j < aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0) {
                    aeaaaaaa aeaaaaaaVar2 = this.aaaaaaaa;
                    aeaaaaaa aeaaaaaaVar3 = aeaaaaaaVar2 != null ? aeaaaaaaVar2.aaaaaaae : null;
                    if (aeaaaaaaVar3 != null && aeaaaaaaVar3.aaaaaaau) {
                        if ((aeaaaaaaVar3.aaaaaaao + j) - (aeaaaaaaVar3.aaaaaaac ? 0 : aeaaaaaaVar3.aaaaaaa0) <= 8192) {
                            aeaaaaaaVar.aaaaaaaa(aeaaaaaaVar3, (int) j);
                            aaaaaaaoVar.aaaaaaa0 -= j;
                            this.aaaaaaa0 += j;
                            return;
                        }
                    }
                    aaaaaaaoVar.aaaaaaaa = aeaaaaaaVar.aaaaaaaa((int) j);
                }
                aeaaaaaa aeaaaaaaVar4 = aaaaaaaoVar.aaaaaaaa;
                long j2 = aeaaaaaaVar4.aaaaaaao - aeaaaaaaVar4.aaaaaaa0;
                aaaaaaaoVar.aaaaaaaa = aeaaaaaaVar4.aaaaaaa0();
                aeaaaaaa aeaaaaaaVar5 = this.aaaaaaaa;
                if (aeaaaaaaVar5 == null) {
                    this.aaaaaaaa = aeaaaaaaVar4;
                    aeaaaaaaVar4.aaaaaaae = aeaaaaaaVar4;
                    aeaaaaaaVar4.aaaaaaan = aeaaaaaaVar4;
                } else {
                    aeaaaaaaVar5.aaaaaaae.aaaaaaaa(aeaaaaaaVar4).aaaaaaaa();
                }
                aaaaaaaoVar.aaaaaaa0 -= j2;
                this.aaaaaaa0 += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        if (aeaaaaaaVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0);
        byteBuffer.put(aeaaaaaaVar.aaaaaaaa, aeaaaaaaVar.aaaaaaa0, min);
        int i = aeaaaaaaVar.aaaaaaa0 + min;
        aeaaaaaaVar.aaaaaaa0 = i;
        this.aaaaaaa0 -= min;
        if (i == aeaaaaaaVar.aaaaaaao) {
            this.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
            aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
        }
        return min;
    }

    public aaaaaaao aaaaaaan(int i) {
        if (i < 128) {
            writeByte(i);
            return this;
        }
        if (i < 2048) {
            writeByte((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            writeByte((i & 63) | r.b.d);
            return this;
        }
        if (i >= 65536) {
            if (i <= 1114111) {
                writeByte((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                writeByte(((i >> 12) & 63) | r.b.d);
                writeByte(((i >> 6) & 63) | r.b.d);
                writeByte((i & 63) | r.b.d);
                return this;
            }
            throw new IllegalArgumentException(CtFAbx.AzWtSf(new StringBuilder("Unexpected code point: "), i));
        }
        if (i >= 55296 && i <= 57343) {
            writeByte(63);
            return this;
        }
        writeByte((i >> 12) | 224);
        writeByte(((i >> 6) & 63) | r.b.d);
        writeByte((i & 63) | r.b.d);
        return this;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    /* renamed from: aaaaaaao, reason: merged with bridge method [inline-methods] */
    public aaaaaaao writeByte(int i) {
        aeaaaaaa aaaaaaa0 = aaaaaaa0(1);
        byte[] bArr = aaaaaaa0.aaaaaaaa;
        int i2 = aaaaaaa0.aaaaaaao;
        aaaaaaa0.aaaaaaao = i2 + 1;
        bArr[i2] = (byte) i;
        this.aaaaaaa0++;
        return this;
    }

    public String aaaaaaaa(long j, Charset charset) {
        aaaaaaoa.aaaaaaaa(this.aaaaaaa0, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount > Integer.MAX_VALUE: ", j));
        }
        if (j == 0) {
            return "";
        }
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa;
        int i = aeaaaaaaVar.aaaaaaa0;
        if (i + j > aeaaaaaaVar.aaaaaaao) {
            return new String(aaaaaaao(j), charset);
        }
        String str = new String(aeaaaaaaVar.aaaaaaaa, i, (int) j, charset);
        int i2 = (int) (aeaaaaaaVar.aaaaaaa0 + j);
        aeaaaaaaVar.aaaaaaa0 = i2;
        this.aaaaaaa0 -= j;
        if (i2 == aeaaaaaaVar.aaaaaaao) {
            this.aaaaaaaa = aeaaaaaaVar.aaaaaaa0();
            aoaaaaaa.aaaaaaaa(aeaaaaaaVar);
        }
        return str;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public byte[] aaaaaaac() {
        try {
            return aaaaaaao(this.aaaaaaa0);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    /* renamed from: aaaaaaac, reason: merged with bridge method [inline-methods] */
    public aaaaaaao writeInt(int i) {
        aeaaaaaa aaaaaaa0 = aaaaaaa0(4);
        byte[] bArr = aaaaaaa0.aaaaaaaa;
        int i2 = aaaaaaa0.aaaaaaao;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        aaaaaaa0.aaaaaaao = i2 + 4;
        this.aaaaaaa0 += 4;
        return this;
    }

    public String aaaaaaav(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (aaaaaaan(j2) == 13) {
                String aaaaaaae = aaaaaaae(j2);
                skip(2L);
                return aaaaaaae;
            }
        }
        String aaaaaaae2 = aaaaaaae(j);
        skip(1L);
        return aaaaaaae2;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public aaaaaoaa aaaaaaa0() {
        return aaaaaoaa.aaaaaaac;
    }

    public aaaaaaao aaaaaaaa(aaaaaaan aaaaaaanVar) {
        if (aaaaaaanVar != null) {
            aaaaaaanVar.aaaaaaaa(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public aaaaaaao aaaaaaaa(String str, int i, int i2) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "beginIndex < 0: "));
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
                    aeaaaaaa aaaaaaa0 = aaaaaaa0(1);
                    byte[] bArr = aaaaaaa0.aaaaaaaa;
                    int i3 = aaaaaaa0.aaaaaaao - i;
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
                    int i5 = aaaaaaa0.aaaaaaao;
                    int i6 = (i3 + i) - i5;
                    aaaaaaa0.aaaaaaao = i5 + i6;
                    this.aaaaaaa0 += i6;
                } else {
                    if (charAt2 < 2048) {
                        writeByte((charAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                        writeByte((charAt2 & '?') | r.b.d);
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            writeByte((i8 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                            writeByte(((i8 >> 12) & 63) | r.b.d);
                            writeByte(((i8 >> 6) & 63) | r.b.d);
                            writeByte((i8 & 63) | r.b.d);
                            i += 2;
                        } else {
                            writeByte(63);
                            i = i7;
                        }
                    } else {
                        writeByte((charAt2 >> '\f') | 224);
                        writeByte(((charAt2 >> 6) & 63) | r.b.d);
                        writeByte((charAt2 & '?') | r.b.d);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
    }

    public aaaaaaao aaaaaaaa(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError(CtFAbx.ARc23Z(i, "beginIndex < 0: "));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                StringBuilder B9tovu2 = A2egSU.B9tovu(i2, "endIndex > string.length: ", " > ");
                B9tovu2.append(str.length());
                throw new IllegalArgumentException(B9tovu2.toString());
            }
            if (charset != null) {
                if (charset.equals(aaaaaaoa.aaaaaaaa)) {
                    return aaaaaaaa(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return write(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i2, i, "endIndex < beginIndex: ", " < "));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
    public aaaaaaao write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
    public aaaaaaao write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            aaaaaaoa.aaaaaaaa(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                aeaaaaaa aaaaaaa0 = aaaaaaa0(1);
                int min = Math.min(i3 - i, 8192 - aaaaaaa0.aaaaaaao);
                System.arraycopy(bArr, i, aaaaaaa0.aaaaaaaa, aaaaaaa0.aaaaaaao, min);
                i += min;
                aaaaaaa0.aaaaaaao += min;
            }
            this.aaaaaaa0 += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        if (aaaaoaaaVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long aaaaaaaa = aaaaoaaaVar.aaaaaaaa(this, 8192L);
            if (aaaaaaaa == -1) {
                return j;
            }
            j += aaaaaaaa;
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public long aaaaaaaa(aaaaaaao aaaaaaaoVar, long j) {
        if (aaaaaaaoVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.aaaaaaa0;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            aaaaaaaoVar.aaaaaaa0(this, j);
            return j;
        }
        throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public long aaaaaaaa(byte b) {
        return aaaaaaaa(b, 0L, Long.MAX_VALUE);
    }

    public long aaaaaaaa(byte b, long j, long j2) {
        aeaaaaaa aeaaaaaaVar;
        long j3 = j;
        long j4 = j2;
        long j5 = 0;
        if (j3 >= 0 && j4 >= j3) {
            long j6 = this.aaaaaaa0;
            if (j4 > j6) {
                j4 = j6;
            }
            if (j3 == j4 || (aeaaaaaaVar = this.aaaaaaaa) == null) {
                return -1L;
            }
            if (j6 - j3 < j3) {
                while (j6 > j3) {
                    aeaaaaaaVar = aeaaaaaaVar.aaaaaaae;
                    j6 -= aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0;
                }
            } else {
                while (true) {
                    long j7 = (aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0) + j5;
                    if (j7 >= j3) {
                        break;
                    }
                    aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
                    j5 = j7;
                }
                j6 = j5;
            }
            while (j6 < j4) {
                byte[] bArr = aeaaaaaaVar.aaaaaaaa;
                int min = (int) Math.min(aeaaaaaaVar.aaaaaaao, (aeaaaaaaVar.aaaaaaa0 + j4) - j6);
                for (int i = (int) ((aeaaaaaaVar.aaaaaaa0 + j3) - j6); i < min; i++) {
                    if (bArr[i] == b) {
                        return (i - aeaaaaaaVar.aaaaaaa0) + j6;
                    }
                }
                j6 += aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0;
                aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
                j3 = j6;
            }
            return -1L;
        }
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("size=", this.aaaaaaa0, " fromIndex=");
        B2KMhB2.append(j3);
        B2KMhB2.append(" toIndex=");
        B2KMhB2.append(j4);
        throw new IllegalArgumentException(B2KMhB2.toString());
    }

    public final aaaaaaan aaaaaaaa(int i) {
        if (i == 0) {
            return aaaaaaan.aaaaaaau;
        }
        return new aaoaaaaa(this, i);
    }
}
