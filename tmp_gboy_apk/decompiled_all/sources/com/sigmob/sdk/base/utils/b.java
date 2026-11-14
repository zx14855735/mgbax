package com.sigmob.sdk.base.utils;

import android.util.Base64;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return new String(Base64.decode(str, 2));
    }
}
