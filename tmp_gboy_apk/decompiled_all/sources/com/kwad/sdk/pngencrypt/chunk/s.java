package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class s extends p {
    private int bbu;
    private int bbv;
    private int bbw;
    private int bbx;
    private int[] bby;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.bby = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.aZU;
        if (kVar.bab) {
            this.bbu = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (!kVar.bac) {
            this.bbv = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.bbw = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.bbx = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.bby = new int[length];
            for (int i = 0; i < length; i++) {
                this.bby[i] = dVar.data[i] & 255;
            }
        }
    }
}
