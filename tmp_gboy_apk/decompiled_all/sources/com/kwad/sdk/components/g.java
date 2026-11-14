package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class g {
    public static boolean ds(String str) {
        DevelopMangerComponents.DevelopValue dr = d.dr(str);
        return dr != null && ((Boolean) dr.getValue()).booleanValue();
    }

    public static boolean encryptDisable() {
        return ds("KEY_HOST_ENCRYPT_DISABLE");
    }
}
