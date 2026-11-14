package com.bytedance.sdk.component.c.w.xj;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.u.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class w {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> xj;

    private static void hf(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = xj;
        if (softReference == null || softReference.get() == null) {
            xj = new SoftReference<>(new ConcurrentHashMap());
        }
        String u = u(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = xj.get();
        if (concurrentHashMap.get(u) == null) {
            concurrentHashMap.put(u, new HashMap());
        }
        concurrentHashMap.get(u).put(str2, obj);
    }

    private static void kd(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = xj;
        if (softReference == null || softReference.get() == null || (map = xj.get().get(u(str))) == null) {
            return;
        }
        map.clear();
    }

    private static String u(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static SharedPreferences w(String str) {
        return ((d) com.bytedance.sdk.openadsdk.ats.w.xj("kv_store_factory")).get(u(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T> void xj(String str, String str2, T t) {
        synchronized (w.class) {
            try {
                SharedPreferences w = w(str);
                if (w == null) {
                    return;
                }
                if (t.equals(w(str, str2))) {
                    return;
                }
                SharedPreferences.Editor edit = w.edit();
                if (t instanceof Boolean) {
                    edit.putBoolean(str2, ((Boolean) t).booleanValue());
                }
                if (t instanceof String) {
                    edit.putString(str2, (String) t);
                }
                if (t instanceof Integer) {
                    edit.putInt(str2, ((Integer) t).intValue());
                }
                if (t instanceof Long) {
                    edit.putLong(str2, ((Long) t).longValue());
                }
                if (t instanceof Float) {
                    edit.putFloat(str2, ((Float) t).floatValue());
                }
                edit.apply();
                hf(str, str2, t);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Object w(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = xj;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(u(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static String w(String str, String str2, String str3) {
        SharedPreferences w = w(str);
        return w == null ? str3 : w.getString(str2, str3);
    }

    private static Object hf(String str, String str2, String str3) {
        String u = u(str);
        if (!xj(u, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return w(u, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(xj(u, str2, false));
        }
        if (str3.equalsIgnoreCase(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return Integer.valueOf(xj(u, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(xj(u, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(xj(u, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return w(u, str2, null);
        }
        return null;
    }

    public static String xj(String str, String str2, String str3) {
        Object w = w(str, str2);
        if (w != null) {
            return String.valueOf(w);
        }
        Object hf = hf(str, str2, str3);
        hf(str, str2, hf);
        return String.valueOf(hf);
    }

    public static void hf(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences w = w(str);
            if (w == null) {
                return;
            }
            SharedPreferences.Editor edit = w.edit();
            edit.remove(str2);
            edit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = xj;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String u = u(str);
            if (!TextUtils.isEmpty(u) && (map = xj.get().get(u)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = xj;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                xj.get().put(u, map);
            }
        } catch (Throwable unused) {
        }
    }

    private static int xj(String str, String str2, int i) {
        SharedPreferences w = w(str);
        return w == null ? i : w.getInt(str2, i);
    }

    private static float xj(String str, String str2, float f) {
        SharedPreferences w = w(str);
        return w == null ? f : w.getFloat(str2, f);
    }

    private static boolean xj(String str, String str2, boolean z) {
        SharedPreferences w = w(str);
        return w == null ? z : w.getBoolean(str2, z);
    }

    private static long xj(String str, String str2, long j) {
        SharedPreferences w = w(str);
        return w == null ? j : w.getLong(str2, j);
    }

    public static boolean xj(String str, String str2) {
        SharedPreferences w = w(str);
        return w != null && w.contains(str2);
    }

    public static void xj(String str) {
        SharedPreferences.Editor edit = w(str).edit();
        edit.clear();
        edit.apply();
        kd(str);
    }

    public static Map<String, ?> hf(String str) {
        return w(str).getAll();
    }
}
