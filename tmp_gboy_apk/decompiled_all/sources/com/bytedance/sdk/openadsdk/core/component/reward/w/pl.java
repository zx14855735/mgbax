package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl extends xj {
    public pl(Activity activity, ws wsVar, xv xvVar) {
        super(activity, wsVar, xvVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public int c() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public float f() {
        return 0.75f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(tf tfVar) {
        return w(tfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.xj);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject.toString();
    }
}
