package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ls implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aOn = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aOn)) {
            bVar.aOn = "";
        }
        bVar.aOo = jSONObject.optInt("core_pool_size");
        bVar.aOp = jSONObject.optInt("max_pool_size");
        bVar.aOq = jSONObject.optInt("current_pool_size");
        bVar.aOr = jSONObject.optInt("active_count");
        bVar.aOs = jSONObject.optLong("task_wait_avg_ms");
        bVar.aOt = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aOu = jSONObject.optInt("queue_size");
        bVar.aOv = jSONObject.optLong("pass_timestamp");
        bVar.aOw = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aOn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pool_name", bVar.aOn);
        }
        int i = bVar.aOo;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "core_pool_size", i);
        }
        int i2 = bVar.aOp;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "max_pool_size", i2);
        }
        int i3 = bVar.aOq;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "current_pool_size", i3);
        }
        int i4 = bVar.aOr;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "active_count", i4);
        }
        long j = bVar.aOs;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_wait_avg_ms", j);
        }
        long j2 = bVar.aOt;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_succ_count", j2);
        }
        long j3 = bVar.interval;
        if (j3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interval_ms", j3);
        }
        int i5 = bVar.aOu;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "queue_size", i5);
        }
        long j4 = bVar.aOv;
        if (j4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pass_timestamp", j4);
        }
        int i6 = bVar.aOw;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "func_ratio_count", i6);
        }
        return jSONObject;
    }
}
