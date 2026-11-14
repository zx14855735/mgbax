package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class hr implements com.kwad.sdk.core.d<NativeAdExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        a2(nativeAdExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        return b2(nativeAdExtraDataImpl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdExtraDataImpl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdExtraDataImpl.enableRotate = jSONObject.optBoolean("enableRotate");
        nativeAdExtraDataImpl.showLiveStatus = jSONObject.optInt("showLiveStatus");
        nativeAdExtraDataImpl.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = nativeAdExtraDataImpl.enableShake;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableShake", z);
        }
        boolean z2 = nativeAdExtraDataImpl.enableRotate;
        if (z2) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableRotate", z2);
        }
        int i = nativeAdExtraDataImpl.showLiveStatus;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStatus", i);
        }
        int i2 = nativeAdExtraDataImpl.showLiveStyle;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStyle", i2);
        }
        return jSONObject;
    }
}
