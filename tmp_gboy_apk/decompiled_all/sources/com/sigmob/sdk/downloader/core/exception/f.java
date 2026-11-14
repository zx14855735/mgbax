package com.sigmob.sdk.downloader.core.exception;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private final com.sigmob.sdk.downloader.core.cause.b f13398a;

    public f(com.sigmob.sdk.downloader.core.cause.b bVar) {
        super("Resume failed because of " + bVar);
        this.f13398a = bVar;
    }

    public com.sigmob.sdk.downloader.core.cause.b a() {
        return this.f13398a;
    }
}
