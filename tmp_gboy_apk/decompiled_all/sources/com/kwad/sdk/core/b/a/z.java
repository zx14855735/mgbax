package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.core.response.model.AdInfo;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class z implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        a2(adInsertScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return b2(adInsertScreenInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = A2egSU.A5SV6n(PointType.SIGMOB_APP, "cycleAggregateDailyShowCount", jSONObject);
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = A2egSU.A5SV6n(PointType.SIGMOB_APP, "cycleAggregateInterval", jSONObject);
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (JSONObject.NULL.toString().equals(adInsertScreenInfo.retainWindowText)) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adInsertScreenInfo.cycleAggregateSwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateSwitch", z);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i = adInsertScreenInfo.cycleAggregateStyle;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateStyle", i);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i2 = adInsertScreenInfo.autoCloseTime;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "autoCloseTime", i2);
        }
        int i3 = adInsertScreenInfo.retainWindowStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowStyle", i3);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i4 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowBasedAdShowCount", i4);
        }
        int i5 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowDailyShowCount", i5);
        }
        return jSONObject;
    }
}
