package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.czhj.sdk.common.utils.Preconditions;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class SharedPreferencesUtil {

    /* renamed from: a, reason: collision with root package name */
    private static String f10612a = "com.sigmob.Settings";

    private SharedPreferencesUtil(String str) {
        f10612a = str;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        Preconditions.NoThrow.checkNotNull(context);
        return context.getSharedPreferences(f10612a, 4);
    }

    public static SharedPreferences getSharedPreferences(Context context, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(str);
        return context.getSharedPreferences(str, 4);
    }
}
