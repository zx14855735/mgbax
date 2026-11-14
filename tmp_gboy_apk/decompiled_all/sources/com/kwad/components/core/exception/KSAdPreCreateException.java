package com.kwad.components.core.exception;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class KSAdPreCreateException extends RuntimeException {
    private static final String LIBRARY_VERSION = ". Version: 4.9.20.1";

    public KSAdPreCreateException(String str) {
        super(CtFAbx.AcNBzu(str, LIBRARY_VERSION));
    }

    public KSAdPreCreateException(String str, Throwable th) {
        super(CtFAbx.AcNBzu(str, LIBRARY_VERSION), th);
    }
}
