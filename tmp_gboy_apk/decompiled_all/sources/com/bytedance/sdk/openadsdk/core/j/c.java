package com.bytedance.sdk.openadsdk.core.j;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    public boolean xj = false;
    public boolean hf = false;
    public boolean w = false;
    public boolean u = false;
    private boolean kd = false;

    public static c xj(String str) {
        c cVar = new c();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                cVar.xj = jSONObject.optBoolean("use_csj_main", false);
                cVar.hf = jSONObject.optBoolean("use_layze_layout", false);
                cVar.w = jSONObject.optBoolean("create_ad_in_io", false);
                cVar.u = jSONObject.optBoolean("opt_panel_view", false);
                boolean optBoolean = jSONObject.optBoolean("so_lock", false);
                cVar.kd = optBoolean;
                if (optBoolean) {
                    com.bytedance.sdk.openadsdk.x.y.xj().mkdirs();
                }
            } catch (Throwable unused) {
            }
        }
        return cVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.xj);
            jSONObject.put("use_layze_layout", this.hf);
            jSONObject.put("create_ad_in_io", this.w);
            jSONObject.put("opt_panel_view", this.u);
            jSONObject.put("so_lock", this.kd);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
