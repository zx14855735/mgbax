package com.sigmob.sdk.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.czhj.sdk.logger.SigmobLogger;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13228a = "s";
    private static final String b = "com.wind.Settings";
    private static final int c = 4;

    private s() {
    }

    public static float a(Context context, String str, String str2, float f) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            return a2.getFloat(str2, f);
        }
        SigmobLogger.e(f13228a, "getFloat: sp is unavailable.", new Object[0]);
        return f;
    }

    public static void b(Context context, String str, String str2, float f) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null) {
            SigmobLogger.e(f13228a, "saveFloat: sp is unavailable.", new Object[0]);
        } else {
            a2.edit().putFloat(str2, f).apply();
        }
    }

    public static int a(Context context, String str, String str2, int i) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            return a2.getInt(str2, i);
        }
        SigmobLogger.e(f13228a, "getInt: sp is unavailable.", new Object[0]);
        return i;
    }

    public static void b(Context context, String str, String str2, int i) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null) {
            SigmobLogger.e(f13228a, "saveInt: sp is unavailable.", new Object[0]);
        } else {
            a2.edit().putInt(str2, i).apply();
        }
    }

    public static long a(Context context, String str, String str2, long j) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            return a2.getLong(str2, j);
        }
        SigmobLogger.e(f13228a, "getLong: sp is unavailable.", new Object[0]);
        return j;
    }

    public static void b(Context context, String str, String str2, long j) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null) {
            SigmobLogger.e(f13228a, "saveLong: sp is unavailable.", new Object[0]);
        } else {
            a2.edit().putLong(str2, j).apply();
        }
    }

    public static SharedPreferences a(Context context, String str) {
        if (context == null) {
            SigmobLogger.e(f13228a, "getPrefs: ctx is unavailable.", new Object[0]);
            return null;
        }
        if (o.a((CharSequence) str)) {
            str = b;
        }
        return context.getSharedPreferences(str, 4);
    }

    public static void b(Context context, String str, String str2, String str3) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null) {
            SigmobLogger.e(f13228a, "saveString: sp is unavailable.", new Object[0]);
        } else {
            a2.edit().putString(str2, str3).apply();
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            return a2.getString(str2, str3);
        }
        SigmobLogger.e(f13228a, "getString: sp is unavailable.", new Object[0]);
        return str3;
    }

    public static void b(Context context, String str, String str2, boolean z) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null) {
            SigmobLogger.e(f13228a, "saveBoolean: sp is unavailable.", new Object[0]);
        } else {
            a2.edit().putBoolean(str2, z).apply();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null || map == null || map.isEmpty()) {
            SigmobLogger.e(f13228a, "apply: sp or map is unavailable.", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = a2.edit();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            }
        }
        edit.apply();
    }

    public static void a(Context context, String str, Object[] objArr) {
        SharedPreferences a2 = a(context, str);
        if (a2 == null || objArr == null) {
            SigmobLogger.e(f13228a, "apply: sp or pairs is unavailable.", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = a2.edit();
        for (int i = 0; i < objArr.length; i += 2) {
            String str2 = (String) objArr[i];
            Object obj = objArr[i + 1];
            if (obj instanceof String) {
                edit.putString(str2, (String) obj);
            } else if (obj instanceof Boolean) {
                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str2, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(str2, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str2, ((Float) obj).floatValue());
            }
        }
        edit.apply();
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        SharedPreferences a2 = a(context, str);
        if (a2 != null) {
            return a2.getBoolean(str2, z);
        }
        SigmobLogger.e(f13228a, "getBoolean: sp is unavailable.", new Object[0]);
        return z;
    }
}
