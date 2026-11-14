package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class yo {
    private static int hf;
    private static JSONObject u;
    private static int w;
    private static int xj;

    public static boolean hf() {
        return hf == 1;
    }

    public static boolean w() {
        return w == 1;
    }

    public static boolean xj() {
        return xj == 1;
    }

    private static void hf(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        xj = jSONObject.optInt("use_dex_load_gdt");
        hf = jSONObject.optInt("use_dex_load_ks");
        w = jSONObject.optInt("use_dex_load_xiaomi");
        u = jSONObject;
    }

    public static void xj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("app_common_config")) == null) {
            return;
        }
        hf(optJSONObject.optJSONObject("dex_strategy"));
    }

    public static void xj(com.bytedance.sdk.component.u.hf.w wVar) {
        JSONObject jSONObject;
        if (wVar == null || (jSONObject = u) == null) {
            return;
        }
        wVar.put("dex_strategy", jSONObject.toString());
    }

    public static void hf(com.bytedance.sdk.component.u.hf.w wVar) {
        if (wVar != null) {
            try {
                hf(new JSONObject(wVar.get("dex_strategy", "")));
            } catch (JSONException unused) {
            }
        }
    }
}
