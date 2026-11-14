package com.sigmob.sdk.videocache.file;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h extends e {

    /* renamed from: a, reason: collision with root package name */
    private final long f13726a;

    public h(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f13726a = j;
    }

    @Override // com.sigmob.sdk.videocache.file.e
    public boolean a(File file, long j, int i) {
        return j <= this.f13726a;
    }
}
