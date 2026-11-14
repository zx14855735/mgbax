package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    public int hf = -1;
    public String kd;
    public String u;
    public String w;
    public String xj;

    public JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        xj(jSONObject);
        return jSONObject;
    }

    public String xj() {
        return hf().toString();
    }

    public void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.xj);
            jSONObject.put("error_code", String.valueOf(this.hf));
            jSONObject.put("error_msg", this.w);
            jSONObject.put("real_device_plan", this.u);
            jSONObject.put("device_plans", this.kd);
        } catch (Throwable unused) {
        }
    }

    public static xj xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        xj xjVar = new xj();
        try {
            JSONObject jSONObject = new JSONObject(str);
            xjVar.kd = jSONObject.optString("device_plans", null);
            xjVar.u = jSONObject.optString("real_device_plan", null);
            xjVar.w = jSONObject.optString("error_msg", null);
            xjVar.xj = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                xjVar.hf = -1;
                return xjVar;
            }
            xjVar.hf = Integer.parseInt(optString);
            return xjVar;
        } catch (Throwable th) {
            pl.xj(th);
            return xjVar;
        }
    }
}
