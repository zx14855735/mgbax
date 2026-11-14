package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends xj {
    private int e;
    private String jk;
    private String v;
    private int yo;

    public u(Activity activity, ws wsVar, xv xvVar) {
        super(activity, wsVar, xvVar);
        JSONObject optJSONObject;
        JSONObject hf = xvVar.hf();
        if (hf == null || (optJSONObject = hf.optJSONObject("coupon")) == null) {
            return;
        }
        this.e = optJSONObject.optInt("amount");
        this.yo = optJSONObject.optInt("threshold");
        this.v = optJSONObject.optString("start_time");
        this.jk = optJSONObject.optString("expire_time");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public int c() {
        return 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public float f() {
        return 0.55f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(tf tfVar) {
        return w(tfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", this.e);
            jSONObject.put("threshold", "满" + this.yo + "元可用");
            if (TextUtils.isEmpty(this.v)) {
                if (TextUtils.isEmpty(this.jk)) {
                    str = "领取当日起30分钟内有效";
                } else {
                    str = "有效期至" + this.jk;
                }
            } else if (TextUtils.isEmpty(this.jk)) {
                str = "有效期至" + this.v;
            } else {
                str = "有效期" + this.v + "至" + this.jk;
            }
            jSONObject.put("start_time", this.v);
            jSONObject.put("expire_text", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean y() {
        return (this.e == 0 || this.yo == 0) ? false : true;
    }
}
