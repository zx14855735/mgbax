package com.bytedance.sdk.openadsdk.core.ra;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b {
    private int hf;
    private String u;
    private String w;
    private int xj;

    public static b xj(String str) {
        try {
            return xj(new JSONObject(str));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.hf("LiveSdkConfig", "parse failed:".concat(String.valueOf(e)));
            return new b();
        }
    }

    public int hf() {
        return this.hf;
    }

    public boolean kd() {
        return this.xj == 1;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", xj());
            jSONObject.put(PluginConstants.KEY_APP_ID, hf());
            jSONObject.put("partner", w());
            jSONObject.put("secure_key", u());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject.toString();
    }

    public String u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public void hf(int i) {
        this.hf = i;
    }

    public void w(String str) {
        this.u = str;
    }

    public void hf(String str) {
        this.w = str;
    }

    public static b xj(JSONObject jSONObject) {
        b bVar = new b();
        bVar.xj(jSONObject.optInt("ad_live_status"));
        bVar.hf(jSONObject.optInt(PluginConstants.KEY_APP_ID));
        bVar.hf(jSONObject.optString("partner"));
        bVar.w(jSONObject.optString("secure_key"));
        return bVar;
    }

    public int xj() {
        return this.xj;
    }

    public void xj(int i) {
        this.xj = i;
    }
}
