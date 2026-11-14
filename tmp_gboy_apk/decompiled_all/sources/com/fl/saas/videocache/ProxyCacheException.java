package com.fl.saas.videocache;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 2.7.1";

    public ProxyCacheException(String str) {
        super(CtFAbx.AcNBzu(str, LIBRARY_VERSION));
    }

    public ProxyCacheException(String str, Throwable th) {
        super(CtFAbx.AcNBzu(str, LIBRARY_VERSION), th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 2.7.1", th);
    }
}
