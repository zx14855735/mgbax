package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class l extends p {
    private long bbi;
    private long bbj;
    private int bbk;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long g = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.bbi = g;
        if (g < 0) {
            this.bbi = g + 4294967296L;
        }
        long g2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.bbj = g2;
        if (g2 < 0) {
            this.bbj = g2 + 4294967296L;
        }
        this.bbk = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
