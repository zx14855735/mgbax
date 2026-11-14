package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13558a = "mraid_storage";

    public static String a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(f13558a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public static Object b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13558a, 0);
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str, (Set) obj);
        }
        return null;
    }

    public static boolean c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13558a, 0);
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public static Map<String, ?> a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13558a, 0);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13558a, 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    public static void a(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13558a, 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Set) {
            edit.remove(str);
            edit.putStringSet(str, (Set) obj);
        }
        edit.apply();
    }

    public static void b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f13558a, 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str);
        edit.apply();
    }
}
