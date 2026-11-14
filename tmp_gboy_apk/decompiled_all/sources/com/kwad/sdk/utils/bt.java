package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class bt {
    public static long A(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!z) {
            return currentTimeMillis;
        }
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return Math.abs(currentTimeMillis);
            }
            long j = sharedPreferences.getLong("key_time_diff_s2c", 0L);
            if (j != 0) {
                return currentTimeMillis + j;
            }
        }
        return Math.abs(currentTimeMillis);
    }

    public static void a(long j, int i, Context context) {
        if (j == 0 || context == null || i <= 0 || i > 100) {
            return;
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return;
            }
            if (Math.abs(currentTimeMillis) / com.kuaishou.weapon.p0.bi.s > i) {
                sharedPreferences.edit().putLong("key_time_diff_s2c", currentTimeMillis).apply();
            } else {
                sharedPreferences.edit().remove("key_time_diff_s2c").apply();
            }
        } catch (Throwable unused) {
        }
    }
}
