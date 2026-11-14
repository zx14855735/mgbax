package com.kwad.sdk.core.a;

import J3FDQU.A2egSU;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.liteapi.encrypt.LiteKsSig1Util;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f {
    public static void a(String str, Map<String, String> map, String str2) {
        map.put(LiteKsSig1Util.PARAM_SIGNATURE, ej(generateInputString(str, str2)));
    }

    private static String ej(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String doSign = com.kwad.sdk.core.f.c.doSign(context, str);
                return doSign == null ? "" : doSign;
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return "";
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    private static String generateInputString(String str, String str2) {
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getPath());
        sb.append("&");
        return A2egSU.B3GDIM(sb, getSortedQuery(parse.getQuery()), "&", str2);
    }

    private static String getSortedQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }
}
