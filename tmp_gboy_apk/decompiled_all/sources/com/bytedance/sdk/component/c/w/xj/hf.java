package com.bytedance.sdk.component.c.w.xj;

import ADYaiT.CtFAbx;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static Context getContext() {
        return com.bytedance.sdk.component.c.w.getContext();
    }

    private static ContentResolver hf() {
        try {
            if (xj()) {
                return com.bytedance.sdk.component.c.w.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String w() {
        return CtFAbx.B25kr6(new StringBuilder(), kd.hf, "/t_sp/");
    }

    public static boolean xj() {
        return com.bytedance.sdk.component.c.w.getContext() != null;
    }

    public static synchronized void xj(String str, String str2, Boolean bool) {
        synchronized (hf.class) {
            if (xj()) {
                try {
                    ContentResolver hf = hf();
                    if (hf != null) {
                        Uri parse = Uri.parse(w("boolean", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        hf.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String hf(String str, String str2, String str3) {
        String type;
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null && (type = hf.getType(Uri.parse(w("string", str2, str)))) != null && !type.equals("null")) {
                    if (!TextUtils.isEmpty(type)) {
                        return type;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str3;
    }

    private static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=".concat(String.valueOf(str));
    }

    @TargetApi(11)
    public static Set<String> hf(String str, String str2, Set<String> set) {
        String type;
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null && (type = hf.getType(Uri.parse(w("string_set", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type) && type.matches("\\[.*\\]")) {
                    String substring = type.substring(1, type.length() - 1);
                    String[] split = substring.split(", ");
                    HashSet hashSet = new HashSet();
                    if (!TextUtils.isEmpty(substring)) {
                        for (String str3 : split) {
                            hashSet.add(str3.replace("__COMMA__", ", "));
                        }
                    }
                    return hashSet;
                }
            } catch (Throwable unused) {
            }
        }
        return set;
    }

    private static String w(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        A2egSU.BIYEnU(sb, w(), str, "/", str2);
        sb.append(w(str3));
        return sb.toString();
    }

    public static synchronized void xj(String str, String str2, String str3) {
        synchronized (hf.class) {
            if (xj()) {
                try {
                    ContentResolver hf = hf();
                    if (hf != null) {
                        Uri parse = Uri.parse(w("string", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        hf.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void hf(String str, String str2) {
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null) {
                    hf.delete(Uri.parse(w("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void xj(String str, String str2, Integer num) {
        synchronized (hf.class) {
            if (xj()) {
                try {
                    ContentResolver hf = hf();
                    if (hf != null) {
                        Uri parse = Uri.parse(w(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        hf.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Long] */
    public static Map<String, ?> hf(String str) {
        Cursor cursor;
        String str2;
        if (!xj()) {
            return null;
        }
        try {
            ContentResolver hf = hf();
            if (hf != null) {
                cursor = hf.query(Uri.parse(w() + "get_all" + w(str)), null, null, null, null);
                try {
                    HashMap hashMap = new HashMap();
                    if (cursor != null && cursor.moveToFirst()) {
                        int columnIndex = cursor.getColumnIndex("cursor_name");
                        int columnIndex2 = cursor.getColumnIndex("cursor_type");
                        int columnIndex3 = cursor.getColumnIndex("cursor_value");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            if (string2.equalsIgnoreCase("string")) {
                                String string3 = cursor.getString(columnIndex3);
                                boolean contains = string3.contains("__COMMA__");
                                str2 = string3;
                                if (contains) {
                                    boolean matches = string3.matches("\\[.*\\]");
                                    str2 = string3;
                                    if (matches) {
                                        String substring = string3.substring(1, string3.length() - 1);
                                        String[] split = substring.split(", ");
                                        ?? hashSet = new HashSet();
                                        if (!TextUtils.isEmpty(substring)) {
                                            for (String str3 : split) {
                                                hashSet.add(str3.replace("__COMMA__", ", "));
                                            }
                                        }
                                        str2 = hashSet;
                                    }
                                }
                            } else if (string2.equalsIgnoreCase("boolean")) {
                                str2 = cursor.getString(columnIndex3);
                            } else if (string2.equalsIgnoreCase(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                                str2 = Integer.valueOf(cursor.getInt(columnIndex3));
                            } else if (string2.equalsIgnoreCase("long")) {
                                str2 = Long.valueOf(cursor.getLong(columnIndex3));
                            } else if (string2.equalsIgnoreCase("float")) {
                                str2 = Float.valueOf(cursor.getFloat(columnIndex3));
                            } else {
                                str2 = string2.equalsIgnoreCase("string_set") ? cursor.getString(columnIndex3) : null;
                            }
                            hashMap.put(string, str2);
                        } while (cursor.moveToNext());
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return hashMap;
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return null;
                }
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        return null;
    }

    public static synchronized void xj(String str, String str2, Long l) {
        synchronized (hf.class) {
            if (xj()) {
                try {
                    ContentResolver hf = hf();
                    if (hf != null) {
                        Uri parse = Uri.parse(w("long", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l);
                        hf.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void xj(String str, String str2, Float f) {
        synchronized (hf.class) {
            if (xj()) {
                try {
                    ContentResolver hf = hf();
                    if (hf != null) {
                        Uri parse = Uri.parse(w("float", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", f);
                        hf.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void xj(String str, String str2, Set<String> set) {
        synchronized (hf.class) {
            if (xj()) {
                try {
                    ContentResolver hf = hf();
                    if (hf != null) {
                        Uri parse = Uri.parse(w("string_set", str2, str));
                        ContentValues contentValues = new ContentValues();
                        HashSet hashSet = new HashSet();
                        Iterator<String> it = set.iterator();
                        while (it.hasNext()) {
                            hashSet.add(it.next().replace(",", "__COMMA__"));
                        }
                        contentValues.put("value", hashSet.toString());
                        hf.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static int xj(String str, String str2, int i) {
        String type;
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null && (type = hf.getType(Uri.parse(w(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Integer.parseInt(type);
                }
            } catch (Throwable unused) {
            }
        }
        return i;
    }

    public static float xj(String str, String str2, float f) {
        String type;
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null && (type = hf.getType(Uri.parse(w("float", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Float.parseFloat(type);
                }
            } catch (Throwable unused) {
            }
        }
        return f;
    }

    public static boolean xj(String str, String str2, boolean z) {
        String type;
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null && (type = hf.getType(Uri.parse(w("boolean", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Boolean.parseBoolean(type);
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public static long xj(String str, String str2, long j) {
        String type;
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null && (type = hf.getType(Uri.parse(w("long", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Long.parseLong(type);
                }
            } catch (Throwable unused) {
            }
        }
        return j;
    }

    public static boolean xj(String str, String str2) {
        String type;
        if (!xj()) {
            return false;
        }
        try {
            ContentResolver hf = hf();
            if (hf != null && (type = hf.getType(Uri.parse(w("contain", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void xj(String str) {
        if (xj()) {
            try {
                ContentResolver hf = hf();
                if (hf != null) {
                    hf.delete(Uri.parse(w() + "clean" + w(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
