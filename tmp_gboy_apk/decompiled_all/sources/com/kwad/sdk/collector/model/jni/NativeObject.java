package com.kwad.sdk.collector.model.jni;

import A5SV6n.A2egSU;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class NativeObject {

    @A2egSU
    protected long mPtr;

    public abstract void destroy();

    public long getNativePtr() {
        return this.mPtr;
    }
}
