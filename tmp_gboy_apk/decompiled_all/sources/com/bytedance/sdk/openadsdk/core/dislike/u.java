package com.bytedance.sdk.openadsdk.core.dislike;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private String hf;
    private com.bytedance.sdk.openadsdk.core.dislike.w.w u;
    private String w;
    private boolean xj;

    public static u xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xj(new JSONObject(str));
        } catch (JSONException e) {
            pl.hf("OncallUploadConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public boolean hf() {
        return this.xj;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.w.w kd() {
        return this.u;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.xj));
            jSONObject.putOpt("upload_api", this.hf);
            jSONObject.putOpt("alert_text", this.w);
            com.bytedance.sdk.openadsdk.core.dislike.w.w wVar = this.u;
            if (wVar != null) {
                jSONObject.putOpt("filter_word", wVar.c());
            }
        } catch (JSONException e) {
            pl.hf("OncallUploadConfig", e);
        }
        return jSONObject.toString();
    }

    public String u() {
        return this.w;
    }

    public String w() {
        return this.hf;
    }

    public static u xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.xj = jSONObject.optBoolean("enable");
        uVar.hf = jSONObject.optString("upload_api");
        uVar.w = jSONObject.optString("alert_text");
        JSONObject optJSONObject = jSONObject.optJSONObject("filter_word");
        if (optJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.dislike.w.w xj = com.bytedance.sdk.openadsdk.core.dislike.w.w.xj(optJSONObject);
            if (xj != null) {
                if (TextUtils.isEmpty(xj.xj())) {
                    xj.xj("99:1");
                }
                if (TextUtils.isEmpty(xj.hf())) {
                    xj.hf("素材反馈");
                }
            }
            uVar.u = xj;
        }
        return uVar;
    }

    public static com.bytedance.sdk.openadsdk.core.dislike.w.w xj() {
        u se = pz.hf().se();
        if (se != null) {
            return se.kd();
        }
        return null;
    }
}
