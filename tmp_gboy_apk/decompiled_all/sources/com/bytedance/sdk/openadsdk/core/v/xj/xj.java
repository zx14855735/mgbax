package com.bytedance.sdk.openadsdk.core.v.xj;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.sdk.internal.cb;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private Context hf;
    private String xj;

    public xj(String str, Context context) {
        this.xj = str;
        this.hf = context;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, Context context) {
        eVar.xj("closeView", (com.bytedance.sdk.component.xj.kd<?, ?>) new xj("closeView", context));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.xj;
        str.getClass();
        if (!str.equals("closeView")) {
            return jSONObject2;
        }
        Context context = this.hf;
        if (context != null) {
            ((Activity) context).finish();
            jSONObject2.put(cb.o, true);
            return jSONObject2;
        }
        jSONObject2.put(cb.o, false);
        return jSONObject2;
    }
}
