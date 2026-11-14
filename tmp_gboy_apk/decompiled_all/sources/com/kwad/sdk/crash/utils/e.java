package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private static Context aMG;

    public static long Kv() {
        long bN = bN(aMG);
        b(aMG, 1 + bN);
        return bN;
    }

    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        edit.putLong("crashseq", j);
        return edit.commit();
    }

    private static long bN(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    public static void init(Context context) {
        aMG = context;
    }
}
