package com.bytedance.msdk.w.f;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.f.j;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static Map<String, List<com.bytedance.msdk.core.tf.kd>> xj = new ConcurrentHashMap();
    public static Map<String, String> hf = new ConcurrentHashMap();

    static {
        cGsc();
    }

    private static /* synthetic */ void cGsc() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (hf.size() == 0) {
            w();
        }
        return hf.get(str);
    }

    private static void w() {
        String hf2 = com.bytedance.msdk.c.xj.w().hf("mediation_adn_map");
        if (TextUtils.isEmpty(hf2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(hf2);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                        hf.put(next, string);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static PluginValueSet xj(String str, hf.xj xjVar, int i) {
        long j;
        int i2;
        String str2;
        int i3;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(xjVar.xj());
        }
        if (com.bytedance.msdk.core.p.xj.xj().xj(str)) {
            return com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(xjVar.xj());
        }
        String xj2 = xj(str);
        if (TextUtils.isEmpty(xj2)) {
            long currentTimeMillis = System.currentTimeMillis();
            String hf2 = hf(str);
            j = System.currentTimeMillis() - currentTimeMillis;
            i2 = !TextUtils.isEmpty(hf2) ? 2 : 3;
            str2 = str;
            i3 = i;
            str3 = hf2;
        } else {
            j = 0;
            i2 = 1;
            str2 = str;
            i3 = i;
            str3 = xj2;
        }
        com.bytedance.msdk.kd.y.xj(i3, i2, j, str2, str3);
        int i4 = i2;
        String str4 = str3;
        if (TextUtils.isEmpty(str4)) {
            return com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(xjVar.xj());
        }
        xjVar.u(str4);
        return com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(xjVar.xj(), str2, i4 == 2);
    }

    private static void hf() {
        String hf2 = com.bytedance.msdk.c.xj.w().hf("mediation_csj_map");
        if (TextUtils.isEmpty(hf2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(hf2);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            String optString = optJSONObject.optString("csj_code_id");
                            if (TextUtils.isEmpty(optString)) {
                                optString = optJSONObject.optString("csj_rit_id");
                            }
                            double optDouble = optJSONObject.optDouble("price");
                            if (optDouble <= 0.0d) {
                                optDouble = optJSONObject.optDouble("ecpm");
                            }
                            copyOnWriteArrayList.add(new com.bytedance.msdk.core.tf.kd(optString, optDouble, optJSONObject.optInt("load_sort"), optJSONObject.optInt("show_sort")));
                        }
                        xj.put(next, copyOnWriteArrayList);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void xj(final JSONObject jSONObject) {
        JSONArray optJSONArray;
        double d;
        if (jSONObject == null) {
            return;
        }
        xj.clear();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONArray = jSONObject.optJSONArray(next)) != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("price");
                        long optLong = jSONObject2.optLong("csj_code_id");
                        try {
                            d = Double.valueOf(optString).doubleValue();
                        } catch (Throwable unused) {
                            d = 0.0d;
                        }
                        copyOnWriteArrayList.add(new com.bytedance.msdk.core.tf.kd(String.valueOf(optLong), d, 0, 0));
                    }
                    xj.put(next, copyOnWriteArrayList);
                }
            }
        } catch (Throwable unused2) {
        }
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.w.f.u.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.c.xj.w().xj("mediation_csj_map", jSONObject.toString());
            }
        });
    }

    public static void xj() {
        if (hf.size() == 0) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : hf.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.w.f.u.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.c.xj.w().xj("mediation_adn_map", jSONObject.toString());
            }
        });
    }

    public static boolean xj(String str, String str2) {
        List<com.bytedance.msdk.core.tf.kd> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (list = xj.get(str)) == null || list.size() == 0) {
            return true;
        }
        j.xj(list);
        return str2.equals(list.get(0).xj());
    }

    private static String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (xj.size() == 0) {
            hf();
        }
        for (String str2 : xj.keySet()) {
            List<com.bytedance.msdk.core.tf.kd> list = xj.get(str2);
            if (list != null) {
                Iterator<com.bytedance.msdk.core.tf.kd> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().xj())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }
}
