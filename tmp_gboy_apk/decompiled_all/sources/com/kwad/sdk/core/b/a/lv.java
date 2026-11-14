package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class lv implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aUD = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = A2egSU.A5SV6n("1", "repeatCount", jSONObject);
        aVar.aUE = jSONObject.optBoolean("runIdle");
        aVar.aUF = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aUF)) {
            aVar.aUF = "";
        }
        aVar.aUG = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.aUD;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endTimestamp", j);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z = aVar.aUE;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "runIdle", z);
        }
        String str = aVar.aUF;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "stackTraceDetail", aVar.aUF);
        }
        long j2 = aVar.aUG;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "startTimestamp", j2);
        }
        return jSONObject;
    }
}
