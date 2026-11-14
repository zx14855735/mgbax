package com.kwad.sdk.core.videocache;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class c {
    public final com.kwad.sdk.core.videocache.a.c aPA;
    public final com.kwad.sdk.core.videocache.a.a aPB;
    public final com.kwad.sdk.core.videocache.d.c aPC;
    public final com.kwad.sdk.core.videocache.b.b aPD;
    public final int aPE;
    public final int aPF;
    public final File aPz;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i, int i2) {
        this.aPz = file;
        this.aPA = cVar;
        this.aPB = aVar;
        this.aPC = cVar2;
        this.aPD = bVar;
        this.aPE = i;
        this.aPF = i2;
    }

    public final File eW(String str) {
        return new File(this.aPz, this.aPA.generate(str));
    }
}
