package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k aYW;
    List<PngChunk> baP = new ArrayList();
    boolean baQ = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.aYW = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.asJ.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.asJ.equals(str)) {
                    return false;
                }
                if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                    return !(pngChunk instanceof n) || ((n) pngChunk).QB().equals(str2);
                }
                return false;
            }
        });
    }

    public final List<PngChunk> Qs() {
        return this.baP;
    }

    public final List<? extends PngChunk> an(String str, String str2) {
        return a(this.baP, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.baP.size();
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.eH(i);
        this.baP.add(pngChunk);
        if (pngChunk.asJ.equals("PLTE")) {
            this.baQ = true;
        }
    }
}
