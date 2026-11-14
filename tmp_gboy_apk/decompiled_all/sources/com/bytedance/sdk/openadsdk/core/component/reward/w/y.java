package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends xj {
    private int e;
    private int yo;

    public y(Activity activity, ws wsVar, xv xvVar) {
        super(activity, wsVar, xvVar);
        JSONObject hf;
        xv xvVar2 = this.d;
        if (xvVar2 == null || (hf = xvVar2.hf()) == null) {
            return;
        }
        this.e = hf.optInt("reduce_time");
        this.yo = hf.optInt("reduce_duration");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public int c() {
        return 3;
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
    public void u(tf tfVar) {
        if (tfVar != null) {
            tfVar.xj(this.e);
        }
        this.d.xj(true);
        if (tfVar != null) {
            tfVar.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public void xj(com.bytedance.sdk.openadsdk.core.widget.y yVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public boolean y() {
        int i;
        xv xvVar = this.d;
        return (xvVar == null || !xvVar.y()) && this.e > 0 && (i = this.yo) > 0 && this.hf < i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.e + "s");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject.toString();
    }
}
