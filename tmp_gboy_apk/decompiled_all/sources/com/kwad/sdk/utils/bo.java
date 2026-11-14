package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class bo {
    static final String TAG = "bo";

    public static void a(String str, String str2, long j) {
        SharedPreferences hF = hF(str);
        if (hF == null) {
            return;
        }
        hF.edit().putLong(str2, j).apply();
    }

    public static void ax(String str, String str2) {
        SharedPreferences hF = hF(str);
        if (hF == null) {
            return;
        }
        hF.edit().remove(str2).apply();
    }

    public static void b(String str, String str2, int i) {
        SharedPreferences hF = hF(str);
        if (hF == null) {
            return;
        }
        hF.edit().putInt(str2, i).apply();
    }

    public static int c(String str, String str2, int i) {
        SharedPreferences hF = hF(str);
        return hF == null ? i : hF.getInt(str2, i);
    }

    public static void g(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    public static String h(String str, String str2, String str3) {
        String string;
        try {
            SharedPreferences hF = hF(str);
            if (hF != null && (string = hF.getString(str2, str3)) != null && !TextUtils.isEmpty(string)) {
                return (TextUtils.equals(string, str3) || !com.kwad.sdk.core.a.c.isEncodeKsSdk(string)) ? string : com.kwad.sdk.core.a.c.decodeKsSdk(string);
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    public static SharedPreferences hF(String str) {
        try {
            return ServiceProvider.Re().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static void i(String str, String str2, String str3) {
        if (com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) {
            return;
        }
        g(str2, str3, com.kwad.sdk.core.a.c.encodeKsSdk(str));
    }

    public static void l(String str, String str2, boolean z) {
        SharedPreferences hF = hF(str);
        if (hF == null) {
            return;
        }
        hF.edit().putBoolean(str2, z).apply();
    }

    public static boolean m(String str, String str2, boolean z) {
        SharedPreferences hF = hF(str);
        return hF == null ? z : hF.getBoolean(str2, z);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        try {
            SharedPreferences hF = hF(str);
            if (hF == null) {
                return;
            }
            if (z && !com.kwad.sdk.core.a.c.isEncodeKsSdk(str3)) {
                hF.edit().putString(str2, com.kwad.sdk.core.a.c.encodeKsSdk(str3)).apply();
            } else {
                hF.edit().putString(str2, str3).apply();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static long b(String str, String str2, long j) {
        SharedPreferences hF = hF(str);
        return hF == null ? j : hF.getLong(str2, j);
    }

    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences hF = hF(str);
        if (hF == null) {
            return;
        }
        SharedPreferences.Editor edit = hF.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }
}
