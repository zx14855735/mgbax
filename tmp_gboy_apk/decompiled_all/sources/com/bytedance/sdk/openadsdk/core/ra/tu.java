package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tu {
    private boolean hf;
    private int u;
    private int w;
    private boolean xj;

    public tu(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("window_landing");
        if (optJSONObject == null) {
            return;
        }
        this.xj = optJSONObject.optBoolean("can_jump_to_landing", false);
        this.hf = optJSONObject.optBoolean("can_click_to_landing", false);
        this.w = optJSONObject.optInt("auto_to_landing_type", 0);
        this.u = optJSONObject.optInt("auto_to_landing_time", 0);
    }

    public static boolean hf(ws wsVar) {
        tu ht = aq.ht(wsVar);
        if (ht == null) {
            return false;
        }
        return ht.hf;
    }

    public static String kd(ws wsVar) {
        return wsVar == null ? "" : wsVar.ol();
    }

    public static int u(ws wsVar) {
        tu ht = aq.ht(wsVar);
        if (ht == null) {
            return 0;
        }
        return ht.u;
    }

    public static int w(ws wsVar) {
        tu ht = aq.ht(wsVar);
        if (ht == null) {
            return 0;
        }
        return ht.w;
    }

    public void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.xj);
            jSONObject2.put("can_click_to_landing", this.hf);
            jSONObject2.put("auto_to_landing_type", this.w);
            jSONObject2.put("auto_to_landing_time", this.u);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.w("parse json:" + e.getMessage());
        }
    }

    public static boolean xj(ws wsVar) {
        tu ht = aq.ht(wsVar);
        if (ht == null || !ht.xj || hl.xj(wsVar) == 1) {
            return false;
        }
        if (hl.xj(wsVar) == 2 && hl.hf(wsVar) == 3) {
            return false;
        }
        if (hl.xj(wsVar) == 2 && hl.hf(wsVar) == 7) {
            return false;
        }
        return (wsVar.rx() == 5 || wsVar.rx() == 15) && !TextUtils.isEmpty(kd(wsVar));
    }
}
