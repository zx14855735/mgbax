package com.bytedance.embedapplog;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class q {
    private long hf;
    private final JSONObject kd = new JSONObject();
    private String u;
    private String w;
    private String xj;
    private int y;

    public void hf(String str) {
        this.w = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FingerInfo{name='");
        sb.append(this.xj);
        sb.append("', duration=");
        sb.append(this.hf);
        sb.append(", data='");
        sb.append(this.w);
        sb.append("', error='");
        return CtFAbx.B25kr6(sb, this.u, "'}");
    }

    public void w(String str) {
        this.u = str;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public JSONObject hf() {
        return this.kd;
    }

    public void w() {
        try {
            this.kd.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(this.hf));
            if (!"d_i0".equals(this.xj) && !"d_a0".equals(this.xj)) {
                this.kd.putOpt(PointParamKey.DATA, this.w);
                this.kd.putOpt(MediationConstant.KEY_ERROR_MSG, this.u);
            }
            this.kd.putOpt(PointParamKey.DATA, new JSONObject(this.w));
            this.kd.putOpt(MediationConstant.KEY_ERROR_MSG, this.u);
        } catch (JSONException e) {
            v.xj("__kite json error " + e.getMessage());
        }
    }

    public String xj() {
        return this.xj;
    }

    public void xj(long j) {
        this.hf = j;
    }

    public void xj(int i) {
        this.y = i;
    }
}
