package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class l {
    private int hf;
    private boolean xj;

    public l(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (optJSONObject != null) {
            this.xj = optJSONObject.optInt("swipe_back_type", 0) == 1;
            this.hf = optJSONObject.optInt("filter_track", 0);
        }
    }

    public static boolean hf(ws wsVar) {
        l w = w(wsVar);
        return w != null && w.hf == 1;
    }

    private static l w(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.ie();
    }

    public void xj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.xj ? 1 : 0);
            jSONObject2.put("filter_track", this.hf);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
    }

    public static boolean xj(ws wsVar) {
        l w = w(wsVar);
        if (w == null) {
            return false;
        }
        return w.xj;
    }
}
