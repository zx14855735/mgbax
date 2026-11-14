package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.et;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import com.czhj.sdk.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends xj {
    private String e;

    public d(Activity activity, ws wsVar, xv xvVar) {
        super(activity, wsVar, xvVar);
        et hq = this.c.hq();
        if (hq != null) {
            this.e = hq.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public int c() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public float f() {
        return 0.6f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(tf tfVar) {
        return w(tfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.e);
            boolean z = false;
            try {
                if (Double.parseDouble(this.e) != 0.0d) {
                    z = true;
                }
            } catch (NumberFormatException unused) {
            }
            jSONObject.put("is_display_unit", z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean y() {
        String str = this.e;
        return (str == null || str.equals(Constants.FAIL) || TextUtils.isEmpty(this.e)) ? false : true;
    }
}
