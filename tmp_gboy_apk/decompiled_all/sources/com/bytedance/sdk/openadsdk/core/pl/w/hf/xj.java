package com.bytedance.sdk.openadsdk.core.pl.w.hf;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public String hf;
    public JSONObject u;
    public String w;
    public ws xj;

    public static xj xj() {
        return new xj();
    }

    public xj hf(String str) {
        this.w = str;
        return this;
    }

    public static xj xj(JSONObject jSONObject) {
        String str;
        String str2;
        JSONObject jSONObject2;
        ws wsVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            str = jSONObject.optString("tag", null);
        } catch (Exception unused) {
            str = null;
            str2 = null;
        }
        try {
            str2 = jSONObject.optString("label", null);
            try {
                jSONObject2 = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
                try {
                    wsVar = com.bytedance.sdk.openadsdk.core.xj.xj(jSONObject.optJSONObject("material_meta"));
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                jSONObject2 = null;
            }
        } catch (Exception unused4) {
            str2 = null;
            jSONObject2 = str2;
            return xj().xj(str).hf(str2).hf(jSONObject2).xj(wsVar);
        }
        return xj().xj(str).hf(str2).hf(jSONObject2).xj(wsVar);
    }

    public xj hf(JSONObject jSONObject) {
        this.u = jSONObject;
        return this;
    }

    public JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.hf);
            jSONObject.put("label", this.w);
            JSONObject jSONObject2 = this.u;
            if (jSONObject2 != null) {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, jSONObject2);
            }
            ws wsVar = this.xj;
            if (wsVar != null) {
                jSONObject.put("material_meta", wsVar.ac());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public xj xj(ws wsVar) {
        this.xj = wsVar;
        return this;
    }

    public xj xj(String str) {
        this.hf = str;
        return this;
    }
}
