package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.interstitial.report.InterstitialReportInfo;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gn implements com.kwad.sdk.core.d<InterstitialReportInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        a2(interstitialReportInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        return b2(interstitialReportInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialReportInfo.status = jSONObject.optInt("status");
        interstitialReportInfo.type = jSONObject.optInt(PointParamKey.TYPE);
        interstitialReportInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialReportInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialReportInfo.renderType = jSONObject.optInt("render_type");
        interstitialReportInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        interstitialReportInfo.materialType = jSONObject.optInt("material_type");
        interstitialReportInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialReportInfo.downloadType = jSONObject.optInt("download_type");
        interstitialReportInfo.downloadSize = jSONObject.optLong("download_size");
        interstitialReportInfo.creativeId = jSONObject.optLong("creative_id");
        interstitialReportInfo.videoUrl = jSONObject.optString("video_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(interstitialReportInfo.videoUrl)) {
            interstitialReportInfo.videoUrl = "";
        }
        interstitialReportInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        interstitialReportInfo.playStartedDuration = jSONObject.optLong("play_started_duration_ms");
        interstitialReportInfo.abParams = jSONObject.optString("ab_params");
        if (obj.toString().equals(interstitialReportInfo.abParams)) {
            interstitialReportInfo.abParams = "";
        }
        interstitialReportInfo.actionType = jSONObject.optLong("action_type");
        interstitialReportInfo.callbackType = jSONObject.optLong("callback_type");
        interstitialReportInfo.clickSceneType = jSONObject.optLong("click_scene_type");
        interstitialReportInfo.itemClickType = jSONObject.optLong("item_click_type");
        interstitialReportInfo.visiblePercent = jSONObject.optDouble("visible_percent");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = interstitialReportInfo.status;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", i);
        }
        int i2 = interstitialReportInfo.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointParamKey.TYPE, i2);
        }
        long j = interstitialReportInfo.loadDataTime;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = interstitialReportInfo.renderDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", j2);
        }
        int i3 = interstitialReportInfo.renderType;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_type", i3);
        }
        int i4 = interstitialReportInfo.expectedRenderType;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expected_render_type", i4);
        }
        int i5 = interstitialReportInfo.materialType;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", i5);
        }
        long j3 = interstitialReportInfo.downloadDuration;
        if (j3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_duration_ms", j3);
        }
        int i6 = interstitialReportInfo.downloadType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_type", i6);
        }
        long j4 = interstitialReportInfo.downloadSize;
        if (j4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_size", j4);
        }
        long j5 = interstitialReportInfo.creativeId;
        if (j5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j5);
        }
        String str = interstitialReportInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", interstitialReportInfo.videoUrl);
        }
        long j6 = interstitialReportInfo.videoDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", j6);
        }
        long j7 = interstitialReportInfo.playStartedDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "play_started_duration_ms", j7);
        }
        String str2 = interstitialReportInfo.abParams;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ab_params", interstitialReportInfo.abParams);
        }
        long j8 = interstitialReportInfo.actionType;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action_type", j8);
        }
        long j9 = interstitialReportInfo.callbackType;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", j9);
        }
        long j10 = interstitialReportInfo.clickSceneType;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "click_scene_type", j10);
        }
        long j11 = interstitialReportInfo.itemClickType;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "item_click_type", j11);
        }
        double d = interstitialReportInfo.visiblePercent;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "visible_percent", d);
        }
        return jSONObject;
    }
}
