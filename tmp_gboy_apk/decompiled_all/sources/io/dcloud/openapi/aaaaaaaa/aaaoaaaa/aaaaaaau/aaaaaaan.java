package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import com.baidu.mobads.sdk.internal.an;
import com.sigmob.sdk.downloader.core.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaan {
    public static boolean aaaaaaa0(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean aaaaaaaa(String str) {
        return (str.equals(an.c) || str.equals(c.f13360a)) ? false : true;
    }

    public static boolean aaaaaaac(String str) {
        return str.equals(an.b) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean aaaaaaao(String str) {
        return str.equals("PROPFIND");
    }
}
