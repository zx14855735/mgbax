package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f extends e {
    private final List<PngChunk> baT;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + Qs().size() + " queue: " + this.baT.size();
    }
}
