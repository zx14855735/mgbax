package com.bytedance.sdk.openadsdk.core.v.xj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ht extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private ws hf;
    private Context xj;

    public ht(Context context, ws wsVar) {
        this.xj = context;
        this.hf = wsVar;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, Context context, ws wsVar) {
        eVar.xj("openNewCommonWebPage", (com.bytedance.sdk.component.xj.kd<?, ?>) new ht(context, wsVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        try {
            String optString = jSONObject.optString("web_url");
            String optString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "";
            }
            TTDelegateActivity.u(this.xj, optString, optString2);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
