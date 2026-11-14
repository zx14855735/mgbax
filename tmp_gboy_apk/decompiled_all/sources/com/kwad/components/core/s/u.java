package com.kwad.components.core.s;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u {
    public static Map<String, String> a(Uri uri) {
        HashMap hashMap = new HashMap();
        Set<String> b = b(uri);
        if (!com.kwad.sdk.crash.utils.c.b(b)) {
            for (String str : b) {
                if (!TextUtils.isEmpty(str)) {
                    String a2 = a(uri, str);
                    if (!TextUtils.isEmpty(a2)) {
                        hashMap.put(str, a2);
                    }
                }
            }
        }
        return hashMap;
    }

    private static Set<String> b(Uri uri) {
        try {
            return uri.getQueryParameterNames();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("SafetyUriUtil", "getQueryParameterNamesFromUri", th);
            th.printStackTrace();
            return null;
        }
    }

    private static String a(Uri uri, String str) {
        return a(uri, str, null);
    }

    public static String a(Uri uri, String str, String str2) {
        try {
            String queryParameter = uri.getQueryParameter(str);
            return TextUtils.isEmpty(queryParameter) ? str2 : queryParameter;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("SafetyUriUtil", "getQueryParameterFromUri", th);
            th.printStackTrace();
            return str2;
        }
    }
}
