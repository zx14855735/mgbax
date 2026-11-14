package com.kwad.sdk.utils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class k {
    public static void ar(String str, String str2) {
        com.kwad.sdk.core.d.c.d("callbackLog", str + str2);
    }

    public static void b(String str, String str2, String str3, String str4) {
        ar(str, str2 + "_" + str3 + "_" + str4);
    }

    public static void s(String str, int i) {
        com.kwad.sdk.core.d.c.d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }
}
