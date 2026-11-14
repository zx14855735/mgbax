package com.kwad.sdk.core.videocache.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class g extends e {
    private final long maxSize;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public final boolean aL(long j) {
        return j <= this.maxSize;
    }
}
