package com.octopus.ad.internal.a.a;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g extends e {

    /* renamed from: a, reason: collision with root package name */
    private final long f12386a;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f12386a = j;
    }

    @Override // com.octopus.ad.internal.a.a.e, com.octopus.ad.internal.a.a.a
    public /* bridge */ /* synthetic */ void a(File file) {
        super.a(file);
    }

    @Override // com.octopus.ad.internal.a.a.e
    public boolean a(File file, long j, int i) {
        return j <= this.f12386a;
    }
}
