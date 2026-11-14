package com.bytedance.sdk.openadsdk.core.v.xj;

import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class io extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private String hf;
    private SSWebView xj;

    public io(SSWebView sSWebView, String str) {
        this.xj = sSWebView;
        this.hf = str;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.f.zg().xj(com.bytedance.sdk.openadsdk.core.pz.getContext()) && this.xj != null) {
                jSONObject.put(PluginConstants.KEY_ERROR_CODE, 0);
                jSONObject.put("codeMsg", cb.o);
                this.xj.I_();
                return jSONObject;
            }
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, SSWebView sSWebView, String str) {
        eVar.xj("close_wobble_observer", (com.bytedance.sdk.component.xj.kd<?, ?>) new io(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        return w();
    }
}
