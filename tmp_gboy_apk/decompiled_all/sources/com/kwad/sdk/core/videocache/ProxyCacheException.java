package com.kwad.sdk.core.videocache;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 4.9.20.1";

    public ProxyCacheException(String str) {
        super(CtFAbx.AcNBzu(str, LIBRARY_VERSION));
    }

    public ProxyCacheException(String str, Throwable th) {
        super(CtFAbx.AcNBzu(str, LIBRARY_VERSION), th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 4.9.20.1", th);
    }
}
