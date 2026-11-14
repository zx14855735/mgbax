package com.bytedance.sdk.openadsdk.y.w;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements u {
    private com.bykv.vk.openvk.component.video.api.w.u xj;

    public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar) {
        this.xj = uVar;
    }

    public com.bykv.vk.openvk.component.video.api.w.u xj() {
        return this.xj;
    }

    public void xj(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.w.u uVar = this.xj;
            if (uVar == null || jSONObject == null) {
                return;
            }
            JSONObject xj = uVar.xj();
            jSONObject.put("pitaya_cache_size", this.xj.hf());
            jSONObject.put("pitaya_code", this.xj.w());
            jSONObject.put("pitaya_msg", this.xj.u());
            jSONObject.put("ext_plugin_code", xj.optInt("ext_plugin_code"));
            jSONObject.put("package", xj.optJSONObject("package"));
        } catch (Exception unused) {
        }
    }
}
