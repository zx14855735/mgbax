package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.ra.r;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private ws xj;

    public qt(ws wsVar) {
        this.xj = wsVar;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, ws wsVar) {
        eVar.xj("getLiveSaasAuthStatus", (com.bytedance.sdk.component.xj.kd<?, ?>) new qt(wsVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        r xj;
        ws wsVar;
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.ra.zg zgVar = null;
        if (jSONObject != null) {
            try {
                xj = r.xj(jSONObject.optJSONObject("live_info"));
                JSONObject optJSONObject = jSONObject.optJSONObject("deep_link");
                if (optJSONObject != null) {
                    zgVar = new com.bytedance.sdk.openadsdk.core.ra.zg(optJSONObject);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.u("glsas", "method:" + th.getMessage());
                return jSONObject2;
            }
        } else {
            xj = null;
        }
        if (zgVar == null && (wsVar = this.xj) != null) {
            zgVar = wsVar.yt();
        }
        if (xj == null) {
            xj = this.xj.bi();
        }
        jSONObject2.put("has_live_silent_auth", xj != null && xj.w());
        jSONObject2.put("has_install_douyin", com.bytedance.sdk.openadsdk.core.live.kd.xj.xj(zgVar));
        jSONObject2.put("has_live_authed", com.bytedance.sdk.openadsdk.core.live.hf.xj().kd() == 2);
        boolean z = xj != null && xj.u();
        if (z) {
            z = com.bytedance.sdk.openadsdk.core.live.hf.xj().w() == 2;
        }
        jSONObject2.put("has_playable_auth_switch", z);
        JSONObject jSONObject3 = new JSONObject();
        if (xj != null) {
            jSONObject3.put("aweme_agreements", xj.kd());
            jSONObject3.put("aweme_privacy", xj.y());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}
