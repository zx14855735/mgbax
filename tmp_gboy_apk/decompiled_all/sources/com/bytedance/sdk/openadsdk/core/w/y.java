package com.bytedance.sdk.openadsdk.core.w;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.g;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static volatile y xj;

    public static y xj() {
        if (xj == null) {
            synchronized (y.class) {
                try {
                    if (xj == null) {
                        xj = new y();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private Pair<Integer, JSONObject> y(String str) {
        return u(str);
    }

    public com.bytedance.sdk.openadsdk.core.z.hf hf(String str) {
        int i;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.z.hf hfVar = new com.bytedance.sdk.openadsdk.core.z.hf();
        HashMap hashMap = new HashMap();
        try {
            hfVar.xj(str.length());
            Pair<Integer, JSONObject> xj2 = xj().xj(str, false);
            if (xj2 != null) {
                JSONObject jSONObject2 = (JSONObject) xj2.second;
                try {
                    Object obj = xj2.first;
                    i = obj != null ? ((Integer) obj).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                i = 3;
            }
            jSONObject.put("ad_sdk_version", ai.u);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            if (i != 3) {
                hashMap.put("x-ad-sdk-version", ai.u);
                hashMap.put("x-plugin-version", "7.1.3.2");
                hashMap.put("x-pglcypher", String.valueOf(i));
            }
        } catch (Throwable unused2) {
        }
        hfVar.xj(hashMap);
        hfVar.hf(jSONObject);
        return hfVar;
    }

    public JSONObject kd(String str) {
        com.bytedance.sdk.component.u.xj hf = dk.hf();
        if (!TextUtils.isEmpty(str) && hf != null && hf.getArmorLoadStatus()) {
            try {
                byte[] encrypt = hf.encrypt(str.getBytes(StandardCharsets.UTF_8));
                if (encrypt != null) {
                    String encodeToString = Base64.encodeToString(encrypt, 0);
                    if (!TextUtils.isEmpty(encodeToString)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("message", encodeToString);
                        jSONObject.put("cypher", 4);
                        return jSONObject;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public Pair<Integer, JSONObject> u(String str) {
        return new Pair<>(3, com.bytedance.sdk.component.utils.xj.xj(str));
    }

    public Pair<Integer, ?> w(String str) {
        try {
            if (!TextUtils.isEmpty(str) && pz.hf().le()) {
                return xj(str, "get_ad");
            }
        } catch (Throwable th) {
            pl.w(th.getMessage());
        }
        return u(str);
    }

    public com.bytedance.sdk.openadsdk.core.z.hf xj(String str) {
        int i;
        Object obj;
        com.bytedance.sdk.openadsdk.core.z.hf hfVar = new com.bytedance.sdk.openadsdk.core.z.hf();
        HashMap hashMap = new HashMap();
        try {
            hfVar.xj(str.length());
            Pair<Integer, ?> w = xj().w(str);
            i = 3;
            if (w != null) {
                obj = w.second;
                Object obj2 = w.first;
                if (obj2 != null) {
                    i = ((Integer) obj2).intValue();
                }
            } else {
                obj = null;
            }
        } catch (Throwable unused) {
        }
        if (i == 4) {
            hashMap.put("x-ad-sdk-version", ai.u);
            hashMap.put("x-plugin-version", "7.1.3.2");
            hashMap.put("x-pglcypher", String.valueOf(i));
            hashMap.put("Content-Type", "application/octet-stream");
            hfVar.xj((byte[]) obj);
            hfVar.xj(hashMap);
            return hfVar;
        }
        JSONObject jSONObject = (JSONObject) obj;
        jSONObject.put("ad_sdk_version", ai.u);
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
        hfVar.hf(jSONObject);
        hfVar.xj(hashMap);
        return hfVar;
    }

    private Pair<Integer, JSONObject> hf(String str, boolean z) {
        com.bytedance.sdk.component.u.xj hf = dk.hf();
        JSONObject kd = (TextUtils.isEmpty(str) || hf == null || !hf.getArmorLoadStatus()) ? null : kd(str);
        if (kd != null && !TextUtils.isEmpty(kd.optString("message"))) {
            return new Pair<>(4, kd);
        }
        if (hf != null && hf.getArmorLoadStatus() && z) {
            am.xj().xj(3, -1L, (String) null);
        }
        return y(str);
    }

    private static String hf(byte[] bArr, String str) {
        com.bytedance.sdk.component.u.xj hf;
        int i;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (hf = dk.hf()) == null) {
                    return null;
                }
                byte[] decrypt = hf.decrypt(bArr);
                String hf2 = g.hf(decrypt);
                if (!TextUtils.isEmpty(hf2)) {
                    return hf2;
                }
                am xj2 = am.xj();
                if (decrypt != null && decrypt.length != 0) {
                    i = 2;
                    xj2.xj(i, -1L, str);
                    return null;
                }
                i = 1;
                xj2.xj(i, -1L, str);
                return null;
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return null;
    }

    public Pair<Integer, JSONObject> xj(String str, boolean z) {
        try {
            if (pz.hf().le()) {
                return hf(str, z);
            }
        } catch (Throwable th) {
            pl.w(th.getMessage());
        }
        return u(str);
    }

    public Pair<Integer, ?> xj(String str, String str2) {
        com.bytedance.sdk.component.u.xj hf = dk.hf();
        if (TextUtils.isEmpty(str)) {
            return y(str);
        }
        byte[] encrypt = (hf == null || !hf.getArmorLoadStatus()) ? null : hf.encrypt(g.xj(str.getBytes(StandardCharsets.UTF_8)));
        if (encrypt != null && encrypt.length != 0) {
            return new Pair<>(4, encrypt);
        }
        if (hf != null && hf.getArmorLoadStatus()) {
            am.xj().xj(3, -1L, str2);
        }
        return y(str);
    }

    public static Pair<Boolean, JSONObject> xj(com.bytedance.sdk.component.d.hf hfVar, String str, boolean z) {
        if (com.bytedance.sdk.component.d.u.xj.xj(hfVar.w())) {
            return new Pair<>(Boolean.FALSE, xj(hfVar.tf(), str));
        }
        String u = hfVar.u();
        if (u != null && !u.startsWith("{") && !u.endsWith("}") && !u.contains("message") && !u.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, xj(hfVar.tf(), str));
        }
        JSONObject jSONObject = null;
        if (u != null) {
            try {
                jSONObject = new JSONObject(u);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return new Pair<>(Boolean.TRUE, xj(jSONObject, true, z));
    }

    public static JSONObject xj(JSONObject jSONObject, boolean z, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String xj2 = xj(jSONObject, z);
            String optString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(xj2)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(xj2);
            if (!z2) {
                return jSONObject2;
            }
            try {
                jSONObject2.put("auction_price", optString);
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String xj(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString("message");
            com.bytedance.sdk.component.u.xj hf = dk.hf();
            if (optInt == 3) {
                return com.bytedance.sdk.component.utils.xj.w(optString);
            }
            if (optInt == 4 && hf != null) {
                optString = hf.decryptWithCBC(optString);
                if (TextUtils.isEmpty(optString) && z) {
                    am.xj().xj(1, -1L, (String) null);
                }
            }
            return optString;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject xj(byte[] bArr, String str) {
        try {
            String hf = hf(bArr, str);
            if (TextUtils.isEmpty(hf)) {
                return null;
            }
            return new JSONObject(hf);
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }
}
