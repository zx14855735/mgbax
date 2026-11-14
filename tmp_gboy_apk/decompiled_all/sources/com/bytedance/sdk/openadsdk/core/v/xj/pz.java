package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.j;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pz extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.j hf;
    private String xj;

    public pz(String str, com.bytedance.sdk.openadsdk.core.j jVar) {
        this.hf = jVar;
        this.xj = str;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("appInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("appInfo", jVar));
        eVar.xj("adInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("adInfo", jVar));
        eVar.xj("getTemplateInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("getTemplateInfo", jVar));
        eVar.xj("getTeMaiAds", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("getTeMaiAds", jVar));
        eVar.xj("isViewable", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("isViewable", jVar));
        eVar.xj("getScreenSize", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("getScreenSize", jVar));
        eVar.xj("getCloseButtonInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("getCloseButtonInfo", jVar));
        eVar.xj("getVolume", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("getVolume", jVar));
        eVar.xj("sendReward", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("sendReward", jVar));
        eVar.xj("subscribe_app_ad", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("subscribe_app_ad", jVar));
        eVar.xj("download_app_ad", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("download_app_ad", jVar));
        eVar.xj("cancel_download_app_ad", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("cancel_download_app_ad", jVar));
        eVar.xj("unsubscribe_app_ad", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("unsubscribe_app_ad", jVar));
        eVar.xj("clickEvent", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("clickEvent", jVar));
        eVar.xj("renderDidFinish", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("renderDidFinish", jVar));
        eVar.xj("dynamicTrack", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("dynamicTrack", jVar));
        eVar.xj("skipVideo", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("skipVideo", jVar));
        eVar.xj("muteVideo", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("muteVideo", jVar));
        eVar.xj("changeVideoState", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("changeVideoState", jVar));
        eVar.xj("getCurrentVideoState", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("getCurrentVideoState", jVar));
        eVar.xj("send_temai_product_ids", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("send_temai_product_ids", jVar));
        eVar.xj("getMaterialMeta", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("getMaterialMeta", jVar));
        eVar.xj("endcard_load", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("endcard_load", jVar));
        eVar.xj("pauseWebView", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("pauseWebView", jVar));
        eVar.xj("pauseWebViewTimers", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("pauseWebViewTimers", jVar));
        eVar.xj("webview_time_track", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("webview_time_track", jVar));
        eVar.xj("adInfoStash", (com.bytedance.sdk.component.xj.kd<?, ?>) new pz("adInfoStash", jVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        j.xj xjVar = new j.xj();
        xjVar.xj = "call";
        xjVar.w = this.xj;
        xjVar.u = jSONObject;
        return this.hf.xj(xjVar, 3);
    }
}
