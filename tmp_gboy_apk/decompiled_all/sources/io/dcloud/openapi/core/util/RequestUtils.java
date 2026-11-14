package io.dcloud.openapi.core.util;

import android.content.Context;
import android.util.Base64;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaav;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaae;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaeaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class RequestUtils {
    public static String get(Context context, String str) {
        return aaaaaaau.aaaaaaaa(context, "dcloud-ads", str);
    }

    public static String getDid(Context context) {
        return aaaaaaav.aaaaaaaa(context, true, true);
    }

    public static String getOid(Context context) {
        return aaaaaaae.aaaaaaaa().aaaaaaaa(context);
    }

    public static String getPost(String str, String str2, String str3) {
        return Base64.encodeToString(aaaaaaaa.aaaaaaa0(aaaeaaaa.aaaaaaaa(str), str2, str3), 2);
    }

    public static byte[] httpGet(String str, HashMap<String, String> hashMap) {
        return aaaaaaac.aaaaaaaa(str, (HashMap) hashMap, true);
    }

    public static byte[] httpPost(String str, String str2, HashMap<String, String> hashMap) {
        return aaaaaaac.aaaaaaaa(str, str2, hashMap);
    }

    public static String mc(Context context) {
        return aaaaaaao.aaaaaaaa(context);
    }

    public static void postMessage(Runnable runnable) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaac.aaaaaaaa().post(runnable);
    }

    public static void save(Context context, String str, String str2) {
        aaaaaaau.aaaaaaaa(context, "dcloud-ads", str, str2);
    }
}
