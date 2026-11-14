package com.bytedance.sdk.openadsdk.core.j;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    public boolean xj = false;
    public boolean hf = true;

    public static y xj(String str) {
        y yVar = new y();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                yVar.xj = jSONObject.optBoolean("encrypt", false);
                yVar.hf = jSONObject.optBoolean("wait_io", true);
            } catch (Throwable unused) {
            }
        }
        return yVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.xj);
            jSONObject.put("wait_io", this.hf);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
