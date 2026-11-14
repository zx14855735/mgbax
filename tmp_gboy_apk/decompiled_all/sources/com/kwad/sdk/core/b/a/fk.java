package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fk implements com.kwad.sdk.core.d<AdInfo.H5Config> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        a2(h5Config, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        return b2(h5Config, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        h5Config.apiMisTouch = jSONObject.optInt("apiMisTouch");
        h5Config.apiAdTag = jSONObject.optInt("apiAdTag");
        h5Config.apiBreathLamp = jSONObject.optInt("apiBreathLamp");
        h5Config.tagTip = jSONObject.optString("tagTip");
        if (JSONObject.NULL.toString().equals(h5Config.tagTip)) {
            h5Config.tagTip = "";
        }
        h5Config.aggregateMiddlePageShowPathSwitch = jSONObject.optBoolean("aggregateMiddlePageShowPathSwitch");
        h5Config.deeplinkOptimizeSwitch = jSONObject.optBoolean("deepLinkEvokeOpt", new Boolean("false").booleanValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = h5Config.apiMisTouch;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiMisTouch", i);
        }
        int i2 = h5Config.apiAdTag;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiAdTag", i2);
        }
        int i3 = h5Config.apiBreathLamp;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiBreathLamp", i3);
        }
        String str = h5Config.tagTip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        boolean z = h5Config.aggregateMiddlePageShowPathSwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregateMiddlePageShowPathSwitch", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "deepLinkEvokeOpt", h5Config.deeplinkOptimizeSwitch);
        return jSONObject;
    }
}
