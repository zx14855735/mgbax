package com.sigmob.sdk.videocache.file;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g extends e {

    /* renamed from: a, reason: collision with root package name */
    private final int f13725a;

    public g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f13725a = i;
    }

    @Override // com.sigmob.sdk.videocache.file.e
    public boolean a(File file, long j, int i) {
        return i <= this.f13725a;
    }
}
