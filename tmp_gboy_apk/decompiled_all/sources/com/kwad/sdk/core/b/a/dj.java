package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class dj implements com.kwad.sdk.core.d<AdGlobalConfigInfo.CycleAggregationInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        a2(cycleAggregationInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        return b2(cycleAggregationInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregationInfo.cycleAggregationSwitch = jSONObject.optBoolean("cycleAggregationSwitch");
        cycleAggregationInfo.cycleAggregationInterval = jSONObject.optInt("cycleAggregationInterval");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = cycleAggregationInfo.cycleAggregationSwitch;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregationSwitch", z);
        }
        int i = cycleAggregationInfo.cycleAggregationInterval;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregationInterval", i);
        }
        return jSONObject;
    }
}
