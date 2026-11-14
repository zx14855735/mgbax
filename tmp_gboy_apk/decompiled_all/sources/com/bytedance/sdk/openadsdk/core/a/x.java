package com.bytedance.sdk.openadsdk.core.a;

import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class x {
    private static AtomicBoolean hf = new AtomicBoolean(true);
    public static volatile Map<String, Boolean> xj = new ConcurrentHashMap();

    public static final class xj {
        private static final com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.ats.u.xj("tt_scheme_check_list_cache");

        static {
            GnjOGm();
        }

        private static /* synthetic */ void GnjOGm() {
            char[] charArray = "\r\u0001\u0003@\t\u000f\u0003\u000b@\f\u0001\u0017@\u001d\u0006\u000b\u0002\u0002@$\u0000\u0007,\u001c\u0007\n\t\u000b".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'n');
            }
            String str = new String(charArray);
            char[] charArray2 = "\r\u0002\u0007\u0000\u0007\u001a".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'n');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        uffb();
    }

    private x() {
    }

    public static Map<String, Boolean> hf(long j) {
        HashMap hashMap = new HashMap();
        try {
            Map all = xj.xj.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long currentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String str = (String) entry.getKey();
                    if (currentTimeMillis > 259200000) {
                        xj(str);
                    } else if (currentTimeMillis <= j) {
                        hashMap.put(str, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get("value").toString())));
                    }
                }
                if (xj == null) {
                    xj = new ConcurrentHashMap();
                } else {
                    xj.clear();
                }
                xj.putAll(hashMap);
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    private static /* synthetic */ void uffb() {
        char[] charArray = "kge&oiem&jgq&{`mdd&BfaJzalom".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\b');
        }
        String str = new String(charArray);
        char[] charArray2 = "kdafa|".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\b');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(String str, Boolean bool) {
        String bool2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            bool2 = "";
        } else {
            try {
                bool2 = bool.toString();
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", bool2);
        jSONObject.put("time", System.currentTimeMillis());
        xj.xj.put(str, jSONObject.toString());
        hf.set(true);
    }

    public static Map<String, Boolean> xj(long j) {
        try {
            if (hf.get()) {
                synchronized (x.class) {
                    try {
                        if (hf.get()) {
                            Map<String, Boolean> hf2 = hf(j);
                            hf.set(false);
                            return hf2;
                        }
                    } finally {
                    }
                }
            }
            return new HashMap(xj);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    private static JSONObject hf(String str) {
        String str2 = xj.xj.get(str, "");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean xj(String str, long j) {
        JSONObject hf2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            hf2 = hf(str);
        } catch (Throwable unused) {
        }
        if (hf2 == null) {
            return null;
        }
        if (System.currentTimeMillis() - hf2.getLong("time") <= j) {
            return Boolean.valueOf(Boolean.parseBoolean(hf2.getString("value")));
        }
        return null;
    }

    private static void xj(String str) {
        xj.xj.remove(str);
    }

    public static String xj(Uri uri) {
        if (uri == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getScheme());
        sb.append("://");
        sb.append(uri.getHost());
        int port = uri.getPort();
        if (port > 0) {
            sb.append(":");
            sb.append(port);
        }
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            sb.append(path);
        }
        return sb.toString();
    }
}
