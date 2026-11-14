package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaau {
    public static void aaaaaaaa(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static String aaaaaaaa(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
