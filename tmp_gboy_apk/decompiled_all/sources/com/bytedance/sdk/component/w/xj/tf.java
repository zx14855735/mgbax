package com.bytedance.sdk.component.w.xj;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class tf implements v {
    private final kd hf;
    private final p u;
    private final Inflater w;
    private int xj = 0;
    private final CRC32 kd = new CRC32();

    public tf(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.w = inflater;
        kd xj = pl.xj(vVar);
        this.hf = xj;
        this.u = new p(xj, inflater);
    }

    private void hf() {
        this.hf.xj(10L);
        byte hf = this.hf.w().hf(3L);
        boolean z = ((hf >> 1) & 1) == 1;
        if (z) {
            xj(this.hf.w(), 0L, 10L);
        }
        xj("ID1ID2", 8075, this.hf.d());
        this.hf.f(8L);
        if (((hf >> 2) & 1) == 1) {
            this.hf.xj(2L);
            if (z) {
                xj(this.hf.w(), 0L, 2L);
            }
            long p = this.hf.w().p();
            this.hf.xj(p);
            if (z) {
                xj(this.hf.w(), 0L, p);
            }
            this.hf.f(p);
        }
        if (((hf >> 3) & 1) == 1) {
            long xj = this.hf.xj((byte) 0);
            if (xj == -1) {
                throw new EOFException();
            }
            if (z) {
                xj(this.hf.w(), 0L, xj + 1);
            }
            this.hf.f(xj + 1);
        }
        if (((hf >> 4) & 1) == 1) {
            long xj2 = this.hf.xj((byte) 0);
            if (xj2 == -1) {
                throw new EOFException();
            }
            if (z) {
                xj(this.hf.w(), 0L, xj2 + 1);
            }
            this.hf.f(xj2 + 1);
        }
        if (z) {
            xj("FHCRC", this.hf.p(), (short) this.kd.getValue());
            this.kd.reset();
        }
    }

    private void w() {
        xj("CRC", this.hf.pl(), (int) this.kd.getValue());
        xj("ISIZE", this.hf.pl(), (int) this.w.getBytesWritten());
    }

    @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.u.close();
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public long xj(w wVar, long j) {
        tf tfVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.xj == 0) {
            hf();
            this.xj = 1;
        }
        if (this.xj == 1) {
            long j2 = wVar.hf;
            long xj = this.u.xj(wVar, j);
            if (xj != -1) {
                xj(wVar, j2, xj);
                return xj;
            }
            tfVar = this;
            tfVar.xj = 2;
        } else {
            tfVar = this;
        }
        if (tfVar.xj == 2) {
            w();
            tfVar.xj = 3;
            if (!tfVar.hf.kd()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public jk xj() {
        return this.hf.xj();
    }

    private void xj(w wVar, long j, long j2) {
        qt qtVar = wVar.xj;
        while (true) {
            int i = qtVar.w;
            int i2 = qtVar.hf;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            qtVar = qtVar.y;
        }
        while (j2 > 0) {
            int min = (int) Math.min(qtVar.w - r7, j2);
            this.kd.update(qtVar.xj, (int) (qtVar.hf + j), min);
            j2 -= min;
            qtVar = qtVar.y;
            j = 0;
        }
    }

    private void xj(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
