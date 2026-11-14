package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class yy {
    private int xj;

    public yy(JSONObject jSONObject) {
        this.xj = 0;
        if (jSONObject == null) {
            return;
        }
        this.xj = jSONObject.optInt("playable_reward_type", 0);
    }

    private static yy hf(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.vm();
    }

    public void xj(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.xj);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static int xj(ws wsVar) {
        int i;
        yy hf = hf(wsVar);
        if (hf == null || (i = hf.xj) < 0 || i > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.pz.hf().r()) || v.p(wsVar)) {
            return hf.xj;
        }
        return 1;
    }

    public static int xj(ws wsVar, int i) {
        com.bykv.vk.openvk.component.video.api.w.w xj = h.xj(wsVar, i);
        String d = xj != null ? xj.d() : null;
        if (TextUtils.isEmpty(d)) {
            return 0;
        }
        String[] split = d.split("x");
        if (split.length < 2) {
            return 0;
        }
        return Integer.parseInt(split[0]) > Integer.parseInt(split[1]) ? 1 : 0;
    }
}
