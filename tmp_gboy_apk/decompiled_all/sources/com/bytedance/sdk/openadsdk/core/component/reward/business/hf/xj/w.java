package com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    public w(Activity activity, ws wsVar, xv xvVar) {
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

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj xj(tf tfVar) {
        return w(tfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean y() {
        return (TextUtils.isEmpty(this.p) || TextUtils.isEmpty(this.f10325pl)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.REWARD_NAME, this.p);
            jSONObject.put(MediationConstant.REWARD_AMOUNT, this.f10325pl);
            jSONObject.put("extra_info", this.xj);
        } catch (JSONException e) {
            pl.xj(e);
        }
        return jSONObject.toString();
    }
}
