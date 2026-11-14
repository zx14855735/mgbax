package com.bytedance.sdk.component.w.xj;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class p implements v {
    private final Inflater hf;
    private boolean u;
    private int w;
    private final kd xj;

    public p(kd kdVar, Inflater inflater) {
        if (kdVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.xj = kdVar;
        this.hf = inflater;
    }

    private void w() {
        int i = this.w;
        if (i == 0) {
            return;
        }
        int remaining = i - this.hf.getRemaining();
        this.w -= remaining;
        this.xj.f(remaining);
    }

    @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.u) {
            return;
        }
        this.hf.end();
        this.u = true;
        this.xj.close();
    }

    public final boolean hf() {
        if (!this.hf.needsInput()) {
            return false;
        }
        w();
        if (this.hf.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.xj.kd()) {
            return true;
        }
        qt qtVar = this.xj.w().xj;
        int i = qtVar.w;
        int i2 = qtVar.hf;
        int i3 = i - i2;
        this.w = i3;
        this.hf.setInput(qtVar.xj, i2, i3);
        return false;
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public long xj(w wVar, long j) {
        boolean hf;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.u) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            hf = hf();
            try {
                qt kd = wVar.kd(1);
                int inflate = this.hf.inflate(kd.xj, kd.w, (int) Math.min(j, 8192 - kd.w));
                if (inflate > 0) {
                    kd.w += inflate;
                    long j2 = inflate;
                    wVar.hf += j2;
                    return j2;
                }
                if (!this.hf.finished() && !this.hf.needsDictionary()) {
                }
                w();
                if (kd.hf != kd.w) {
                    return -1L;
                }
                wVar.xj = kd.hf();
                zg.xj(kd);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!hf);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // com.bytedance.sdk.component.w.xj.v
    public jk xj() {
        return this.xj.xj();
    }
}
