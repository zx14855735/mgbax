package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaeaaaa implements aaaaoaaa {
    private final aaaaaaau aaaaaaa0;
    private final aaaaeaaa aaaaaaac;
    private final Inflater aaaaaaao;
    private int aaaaaaaa = 0;
    private final CRC32 aaaaaaau = new CRC32();

    public aaaeaaaa(aaaaoaaa aaaaoaaaVar) {
        if (aaaaoaaaVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.aaaaaaao = inflater;
        aaaaaaau aaaaaaaa = aaaaaeaa.aaaaaaaa(aaaaoaaaVar);
        this.aaaaaaa0 = aaaaaaaa;
        this.aaaaaaac = new aaaaeaaa(aaaaaaaa, inflater);
    }

    private void aaaaaaeo() {
        this.aaaaaaa0.aaaaaaau(10L);
        byte aaaaaaan = this.aaaaaaa0.aaaaaaaa().aaaaaaan(3L);
        boolean z = ((aaaaaaan >> 1) & 1) == 1;
        if (z) {
            aaaaaaaa(this.aaaaaaa0.aaaaaaaa(), 0L, 10L);
        }
        aaaaaaaa("ID1ID2", 8075, this.aaaaaaa0.readShort());
        this.aaaaaaa0.skip(8L);
        if (((aaaaaaan >> 2) & 1) == 1) {
            this.aaaaaaa0.aaaaaaau(2L);
            if (z) {
                aaaaaaaa(this.aaaaaaa0.aaaaaaaa(), 0L, 2L);
            }
            long aaaaaaae = this.aaaaaaa0.aaaaaaaa().aaaaaaae();
            this.aaaaaaa0.aaaaaaau(aaaaaaae);
            if (z) {
                aaaaaaaa(this.aaaaaaa0.aaaaaaaa(), 0L, aaaaaaae);
            }
            this.aaaaaaa0.skip(aaaaaaae);
        }
        if (((aaaaaaan >> 3) & 1) == 1) {
            long aaaaaaaa = this.aaaaaaa0.aaaaaaaa((byte) 0);
            if (aaaaaaaa == -1) {
                throw new EOFException();
            }
            if (z) {
                aaaaaaaa(this.aaaaaaa0.aaaaaaaa(), 0L, aaaaaaaa + 1);
            }
            this.aaaaaaa0.skip(aaaaaaaa + 1);
        }
        if (((aaaaaaan >> 4) & 1) == 1) {
            long aaaaaaaa2 = this.aaaaaaa0.aaaaaaaa((byte) 0);
            if (aaaaaaaa2 == -1) {
                throw new EOFException();
            }
            if (z) {
                aaaaaaaa(this.aaaaaaa0.aaaaaaaa(), 0L, aaaaaaaa2 + 1);
            }
            this.aaaaaaa0.skip(aaaaaaaa2 + 1);
        }
        if (z) {
            aaaaaaaa("FHCRC", this.aaaaaaa0.aaaaaaae(), (short) this.aaaaaaau.getValue());
            this.aaaaaaau.reset();
        }
    }

    private void aaaeaaaa() {
        aaaaaaaa("CRC", this.aaaaaaa0.aaaaaaau(), (int) this.aaaaaaau.getValue());
        aaaaaaaa("ISIZE", this.aaaaaaa0.aaaaaaau(), (int) this.aaaaaaao.getBytesWritten());
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public aaaaaoaa aaaaaaa0() {
        return this.aaaaaaa0.aaaaaaa0();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public long aaaaaaaa(aaaaaaao aaaaaaaoVar, long j) {
        aaaeaaaa aaaeaaaaVar;
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.aaaaaaaa == 0) {
            aaaaaaeo();
            this.aaaaaaaa = 1;
        }
        if (this.aaaaaaaa == 1) {
            long j2 = aaaaaaaoVar.aaaaaaa0;
            long aaaaaaaa = this.aaaaaaac.aaaaaaaa(aaaaaaaoVar, j);
            if (aaaaaaaa != -1) {
                aaaaaaaa(aaaaaaaoVar, j2, aaaaaaaa);
                return aaaaaaaa;
            }
            aaaeaaaaVar = this;
            aaaeaaaaVar.aaaaaaaa = 2;
        } else {
            aaaeaaaaVar = this;
        }
        if (aaaeaaaaVar.aaaaaaaa == 2) {
            aaaeaaaa();
            aaaeaaaaVar.aaaaaaaa = 3;
            if (!aaaeaaaaVar.aaaaaaa0.aaaaaaan()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.aaaaaaac.close();
    }

    private void aaaaaaaa(aaaaaaao aaaaaaaoVar, long j, long j2) {
        aeaaaaaa aeaaaaaaVar = aaaaaaaoVar.aaaaaaaa;
        while (true) {
            long j3 = aeaaaaaaVar.aaaaaaao - aeaaaaaaVar.aaaaaaa0;
            if (j < j3) {
                break;
            }
            j -= j3;
            aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
        }
        while (j2 > 0) {
            int min = (int) Math.min(aeaaaaaaVar.aaaaaaao - r6, j2);
            this.aaaaaaau.update(aeaaaaaaVar.aaaaaaaa, (int) (aeaaaaaaVar.aaaaaaa0 + j), min);
            j2 -= min;
            aeaaaaaaVar = aeaaaaaaVar.aaaaaaan;
            j = 0;
        }
    }

    private void aaaaaaaa(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
