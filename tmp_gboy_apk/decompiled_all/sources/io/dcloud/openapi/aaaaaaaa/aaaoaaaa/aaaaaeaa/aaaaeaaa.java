package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import ADYaiT.CtFAbx;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaeaaa implements aaaaoaaa {
    private final Inflater aaaaaaa0;
    private final aaaaaaau aaaaaaaa;
    private boolean aaaaaaac;
    private int aaaaaaao;

    public aaaaeaaa(aaaaaaau aaaaaaauVar, Inflater inflater) {
        if (aaaaaaauVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.aaaaaaaa = aaaaaaauVar;
        this.aaaaaaa0 = inflater;
    }

    private void aaaeaaaa() {
        int i = this.aaaaaaao;
        if (i == 0) {
            return;
        }
        int remaining = i - this.aaaaaaa0.getRemaining();
        this.aaaaaaao -= remaining;
        this.aaaaaaaa.skip(remaining);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public aaaaaoaa aaaaaaa0() {
        return this.aaaaaaaa.aaaaaaa0();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa
    public long aaaaaaaa(aaaaaaao aaaaaaaoVar, long j) {
        boolean aaaaaaeo;
        if (j < 0) {
            throw new IllegalArgumentException(CtFAbx.AaHO0E("byteCount < 0: ", j));
        }
        if (this.aaaaaaac) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            aaaaaaeo = aaaaaaeo();
            try {
                aeaaaaaa aaaaaaa0 = aaaaaaaoVar.aaaaaaa0(1);
                int inflate = this.aaaaaaa0.inflate(aaaaaaa0.aaaaaaaa, aaaaaaa0.aaaaaaao, (int) Math.min(j, 8192 - aaaaaaa0.aaaaaaao));
                if (inflate > 0) {
                    aaaaaaa0.aaaaaaao += inflate;
                    long j2 = inflate;
                    aaaaaaaoVar.aaaaaaa0 += j2;
                    return j2;
                }
                if (!this.aaaaaaa0.finished() && !this.aaaaaaa0.needsDictionary()) {
                }
                aaaeaaaa();
                if (aaaaaaa0.aaaaaaa0 != aaaaaaa0.aaaaaaao) {
                    return -1L;
                }
                aaaaaaaoVar.aaaaaaaa = aaaaaaa0.aaaaaaa0();
                aoaaaaaa.aaaaaaaa(aaaaaaa0);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!aaaaaaeo);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean aaaaaaeo() {
        if (!this.aaaaaaa0.needsInput()) {
            return false;
        }
        aaaeaaaa();
        if (this.aaaaaaa0.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.aaaaaaaa.aaaaaaan()) {
            return true;
        }
        aeaaaaaa aeaaaaaaVar = this.aaaaaaaa.aaaaaaaa().aaaaaaaa;
        int i = aeaaaaaaVar.aaaaaaao;
        int i2 = aeaaaaaaVar.aaaaaaa0;
        int i3 = i - i2;
        this.aaaaaaao = i3;
        this.aaaaaaa0.setInput(aeaaaaaaVar.aaaaaaaa, i2, i3);
        return false;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.aaaaaaac) {
            return;
        }
        this.aaaaaaa0.end();
        this.aaaaaaac = true;
        this.aaaaaaaa.close();
    }
}
