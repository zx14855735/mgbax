package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class m extends p {
    private int bbl;
    private int[] bbm;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.bbl = 0;
    }

    private void c(int i, int i2, int i3, int i4) {
        this.bbm[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    private void eP(int i) {
        this.bbl = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.bbl);
        }
        int[] iArr = this.bbm;
        if (iArr == null || iArr.length != i) {
            this.bbm = new int[i];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        eP(dVar.len / 3);
        int i = 0;
        for (int i2 = 0; i2 < this.bbl; i2++) {
            byte[] bArr = dVar.data;
            int i3 = bArr[i] & 255;
            int i4 = i + 2;
            int i5 = bArr[i + 1] & 255;
            i += 3;
            c(i2, i3, i5, bArr[i4] & 255);
        }
    }
}
