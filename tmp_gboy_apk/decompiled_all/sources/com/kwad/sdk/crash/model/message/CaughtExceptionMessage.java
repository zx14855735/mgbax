package com.kwad.sdk.crash.model.message;

import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class CaughtExceptionMessage extends JavaExceptionMessage implements Serializable {
    private static final long serialVersionUID = -4220068453451250185L;

    @Override // com.kwad.sdk.crash.model.message.JavaExceptionMessage, com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String getTypePrefix() {
        return "CAUGHT_";
    }
}
