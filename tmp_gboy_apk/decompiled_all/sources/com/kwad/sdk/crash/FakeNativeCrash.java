package com.kwad.sdk.crash;

import A5SV6n.A2egSU;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class FakeNativeCrash {
    public static final String TAG = "FakeNativeCrash";

    @A2egSU
    public static native void init(boolean z, int i);

    @A2egSU
    public static void upload(int i, int i2, String str) {
        StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(i, i2, "upload: signal=", ", code=", ", nativeBacktraceStr=");
        B7CMnp2.append(str);
        com.kwad.sdk.core.d.c.e(TAG, B7CMnp2.toString());
    }
}
