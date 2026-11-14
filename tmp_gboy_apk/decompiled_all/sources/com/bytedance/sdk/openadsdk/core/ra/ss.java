package com.bytedance.sdk.openadsdk.core.ra;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ss {
    private String c;
    private String f;
    private String hf;
    private JSONObject kd;
    private String u;
    private String w;
    private String xj;
    private int y;

    public int c() {
        return this.y;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, this.xj);
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.hf);
            jSONObject.put("url", this.w);
            jSONObject.put(PointParamKey.DATA, this.u);
            jSONObject.put("material_type", this.y);
            jSONObject.put("custom_components", this.kd);
            jSONObject.put("express_gesture_priority", this.c);
            jSONObject.put("rule_id", this.f);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    public String f() {
        return this.f;
    }

    public String hf() {
        return this.hf;
    }

    public JSONObject kd() {
        return this.kd;
    }

    public String u() {
        return this.u;
    }

    public String w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public String y() {
        return this.c;
    }

    public static ss xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ss ssVar = new ss();
        ssVar.xj = jSONObject.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a);
        ssVar.u = jSONObject.optString(PointParamKey.DATA);
        ssVar.w = jSONObject.optString("url");
        ssVar.hf = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        ssVar.c = jSONObject.optString("express_gesture_priority");
        ssVar.y = jSONObject.optInt("material_type");
        ssVar.kd = jSONObject.optJSONObject("custom_components");
        ssVar.f = jSONObject.optString("rule_id");
        return ssVar;
    }
}
