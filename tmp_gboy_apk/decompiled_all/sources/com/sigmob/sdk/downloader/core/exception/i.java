package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private final int f13399a;

    public i(int i, long j) {
        super("Response code can't handled on internal " + i + " with current offset " + j);
        this.f13399a = i;
    }

    public int a() {
        return this.f13399a;
    }
}
