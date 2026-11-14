package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class eaaaaaaa implements aaaaaaau {
    public final aaaaoaaa aaaaaaa0;
    public final aaaaaaao aaaaaaaa = new aaaaaaao();
    boolean aaaaaaao;

    public eaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        if (aaaaoaaaVar == null) {
            throw new NullPointerException("source == null");
        }
        this.aaaaaaa0 = aaaaoaaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public aaaaaaan aaaaaaa0(long j) {
        aaaaaaau(j);
        return this.aaaaaaaa.aaaaaaa0(j);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaao aaaaaaaa() {
        return this.aaaaaaaa;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public byte[] aaaaaaac() {
        this.aaaaaaaa.aaaaaaaa(this.aaaaaaa0);
        return this.aaaaaaaa.aaaaaaac();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public short aaaaaaae() {
        aaaaaaau(2L);
        return this.aaaaaaaa.aaaaaaae();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public boolean aaaaaaan() {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        return this.aaaaaaaa.aaaaaaan() && this.aaaaaaa0.aaaaaaaa(this.aaaaaaaa, 8192L) == -1;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public byte[] aaaaaaao(long j) {
        aaaaaaau(j);
        return this.aaaaaaaa.aaaaaaao(j);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public void aaaaaaau(long j) {
        if (!aaaaaaan(j)) {
            throw new EOFException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r2 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r4)));
     */
    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long aaaaaaav() {
        /*
            r7 = this;
            r0 = 1
            r1 = 1
            r7.aaaaaaau(r1)
            r1 = 0
            r2 = 0
        L8:
            int r3 = r2 + 1
            long r4 = (long) r3
            boolean r4 = r7.aaaaaaan(r4)
            if (r4 == 0) goto L4a
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r4 = r7.aaaaaaaa
            long r5 = (long) r2
            byte r4 = r4.aaaaaaan(r5)
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
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao r0 = r7.aaaaaaaa
            long r0 = r0.aaaaaaav()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.eaaaaaaa.aaaaaaav():long");
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.aaaaaaao) {
            return;
        }
        this.aaaaaaao = true;
        this.aaaaaaa0.close();
        this.aaaaaaaa.aaaaaaeo();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.aaaaaaao;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        if (aaaaaaaoVar.aaaaaaa0 == 0 && this.aaaaaaa0.aaaaaaaa(aaaaaaaoVar, 8192L) == -1) {
            return -1;
        }
        return this.aaaaaaaa.read(byteBuffer);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public byte readByte() {
        aaaaaaau(1L);
        return this.aaaaaaaa.readByte();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public void readFully(byte[] bArr) {
        try {
            aaaaaaau(bArr.length);
            this.aaaaaaaa.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
                long j = aaaaaaaoVar.aaaaaaa0;
                if (j <= 0) {
                    throw e;
                }
                int read = aaaaaaaoVar.read(bArr, i, (int) j);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public int readInt() {
        aaaaaaau(4L);
        return this.aaaaaaaa.readInt();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public short readShort() {
        aaaaaaau(2L);
        return this.aaaaaaaa.readShort();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public void skip(long j) {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
            if (aaaaaaaoVar.aaaaaaa0 == 0 && this.aaaaaaa0.aaaaaaaa(aaaaaaaoVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.aaaaaaaa.size());
            this.aaaaaaaa.skip(min);
            j -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.aaaaaaa0 + ")";
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public long aaaaaaaa(aaaaaaao aaaaaaaoVar, long j) {
        if (aaaaaaaoVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        aaaaaaao aaaaaaaoVar2 = this.aaaaaaaa;
        if (aaaaaaaoVar2.aaaaaaa0 == 0 && this.aaaaaaa0.aaaaaaaa(aaaaaaaoVar2, 8192L) == -1) {
            return -1L;
        }
        return this.aaaaaaaa.aaaaaaaa(aaaaaaaoVar, Math.min(j, this.aaaaaaaa.aaaaaaa0));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public int aaaaaaau() {
        aaaaaaau(4L);
        return this.aaaaaaaa.aaaaaaau();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public aaaaaoaa aaaaaaa0() {
        return this.aaaaaaa0.aaaaaaa0();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public String aaaaaaac(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long aaaaaaaa = aaaaaaaa((byte) 10, 0L, j2);
            if (aaaaaaaa != -1) {
                return this.aaaaaaaa.aaaaaaav(aaaaaaaa);
            }
            if (j2 < Long.MAX_VALUE && aaaaaaan(j2) && this.aaaaaaaa.aaaaaaan(j2 - 1) == 13 && aaaaaaan(1 + j2) && this.aaaaaaaa.aaaaaaan(j2) == 10) {
                return this.aaaaaaaa.aaaaaaav(j2);
            }
            aaaaaaao aaaaaaaoVar = new aaaaaaao();
            aaaaaaao aaaaaaaoVar2 = this.aaaaaaaa;
            aaaaaaaoVar2.aaaaaaaa(aaaaaaaoVar, 0L, Math.min(32L, aaaaaaaoVar2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.aaaaaaaa.size(), j) + " content=" + aaaaaaaoVar.aaaaeaaa().aaaaaaa0() + (char) 8230);
        }
        throw new IllegalArgumentException(CtFAbx.AaHO0E("limit < 0: ", j));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public String aaaaaaao() {
        return aaaaaaac(Long.MAX_VALUE);
    }

    public boolean aaaaaaan(long j) {
        aaaaaaao aaaaaaaoVar;
        if (j >= 0) {
            if (this.aaaaaaao) {
                throw new IllegalStateException("closed");
            }
            do {
                aaaaaaaoVar = this.aaaaaaaa;
                if (aaaaaaaoVar.aaaaaaa0 >= j) {
                    return true;
                }
            } while (this.aaaaaaa0.aaaaaaaa(aaaaaaaoVar, 8192L) != -1);
            return false;
        }
        throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau
    public long aaaaaaaa(byte b) {
        return aaaaaaaa(b, 0L, Long.MAX_VALUE);
    }

    public long aaaaaaaa(byte b, long j, long j2) {
        if (this.aaaaaaao) {
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
            long aaaaaaaa = this.aaaaaaaa.aaaaaaaa(b2, j3, j4);
            if (aaaaaaaa == -1) {
                aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
                long j5 = aaaaaaaoVar.aaaaaaa0;
                if (j5 >= j4 || this.aaaaaaa0.aaaaaaaa(aaaaaaaoVar, 8192L) == -1) {
                    break;
                }
                j3 = Math.max(j3, j5);
                b = b2;
                j2 = j4;
            } else {
                return aaaaaaaa;
            }
        }
        return -1L;
    }
}
