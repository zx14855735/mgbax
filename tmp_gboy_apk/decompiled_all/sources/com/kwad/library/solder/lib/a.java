package com.kwad.library.solder.lib;

import J3FDQU.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private static String Bn() {
        return "";
    }

    private static String D(String str, String str2) {
        StringBuilder BChYOn2 = A2egSU.BChYOn("[", str, "]: ", str2, " ");
        BChYOn2.append(Bn());
        return BChYOn2.toString();
    }

    public static void e(String str, String str2) {
        D(str, str2);
    }

    public static void e(String str, Throwable th) {
        D(str, "");
    }

    public static void e(String str, String str2, Throwable th) {
        D(str, str2);
    }
}
