package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private int hf;
    private float kd;
    private float u;
    private long w;
    private int xj;

    public hf(JSONObject jSONObject) {
        this.xj = 0;
        this.hf = 0;
        this.w = 0L;
        this.u = 0.1f;
        this.kd = 0.1f;
        if (jSONObject == null) {
            return;
        }
        this.xj = jSONObject.optInt("time");
        this.hf = jSONObject.optInt(PointParamKey.TYPE);
        this.w = jSONObject.optLong(MediationConstant.EXTRA_DURATION);
        this.u = (float) jSONObject.optDouble("intensity");
        this.kd = (float) jSONObject.optDouble("density");
        if (this.hf == 1 || this.w < 100) {
            xj(100L);
        }
    }

    public int getType() {
        return this.hf;
    }

    public long hf() {
        return this.w;
    }

    public float u() {
        return this.kd;
    }

    public float w() {
        return this.u;
    }

    public int xj() {
        return this.xj;
    }

    public void xj(long j) {
        this.w = j;
    }
}
