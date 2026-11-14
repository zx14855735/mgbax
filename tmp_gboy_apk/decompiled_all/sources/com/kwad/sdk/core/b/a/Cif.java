package com.kwad.sdk.core.b.a;

import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.if, reason: invalid class name */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class Cif implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.aJv = jSONObject.optLong("request_prepare_cost");
        jVar.aJw = jSONObject.optLong("request_add_params_cost");
        jVar.aJx = jSONObject.optLong("request_create_cost");
        jVar.aJy = jSONObject.optInt("keep_alive");
        jVar.aJz = jSONObject.optLong("dns_start");
        jVar.aJA = jSONObject.optLong("dns_cost");
        jVar.aJB = jSONObject.optLong("connect_establish_start");
        jVar.aJC = jSONObject.optLong("connect_establish_cost");
        jVar.aJD = jSONObject.optLong("request_start");
        jVar.aJE = jSONObject.optLong("request_cost");
        jVar.aJF = jSONObject.optLong("request_size");
        jVar.aJG = jSONObject.optLong("response_start");
        jVar.aJH = jSONObject.optLong("response_cost");
        jVar.aJI = jSONObject.optLong("response_parse_cost");
        jVar.aJJ = jSONObject.optLong("response_size");
        jVar.aJK = jSONObject.optLong("waiting_response_cost");
        jVar.aJL = jSONObject.optLong("total_cost");
        jVar.aJM = jSONObject.optInt("proxy_used");
        jVar.aJN = jSONObject.optString(PointParamKey.REQUEST_ID);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(jVar.aJN)) {
            jVar.aJN = "";
        }
        jVar.aJO = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.aJP = jSONObject.optLong("response_done_cost");
        jVar.aJQ = jSONObject.optString("host_ip");
        if (obj.toString().equals(jVar.aJQ)) {
            jVar.aJQ = "";
        }
        jVar.aJR = jSONObject.optInt("ip_type");
        jVar.aJS = jSONObject.optInt("recommend_ping_time");
        jVar.aJT = jSONObject.optInt("backup_ping_time");
        jVar.aJU = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = jVar.aJv;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_prepare_cost", j);
        }
        long j2 = jVar.aJw;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_add_params_cost", j2);
        }
        long j3 = jVar.aJx;
        if (j3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_create_cost", j3);
        }
        int i = jVar.aJy;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "keep_alive", i);
        }
        long j4 = jVar.aJz;
        if (j4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_start", j4);
        }
        long j5 = jVar.aJA;
        if (j5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_cost", j5);
        }
        long j6 = jVar.aJB;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_start", j6);
        }
        long j7 = jVar.aJC;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_cost", j7);
        }
        long j8 = jVar.aJD;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_start", j8);
        }
        long j9 = jVar.aJE;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_cost", j9);
        }
        long j10 = jVar.aJF;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_size", j10);
        }
        long j11 = jVar.aJG;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_start", j11);
        }
        long j12 = jVar.aJH;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_cost", j12);
        }
        long j13 = jVar.aJI;
        if (j13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_parse_cost", j13);
        }
        long j14 = jVar.aJJ;
        if (j14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_size", j14);
        }
        long j15 = jVar.aJK;
        if (j15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "waiting_response_cost", j15);
        }
        long j16 = jVar.aJL;
        if (j16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_cost", j16);
        }
        int i2 = jVar.aJM;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "proxy_used", i2);
        }
        String str = jVar.aJN;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointParamKey.REQUEST_ID, jVar.aJN);
        }
        int i3 = jVar.aJO;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "has_data_v2", i3);
        }
        int i4 = jVar.result;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "result", i4);
        }
        long j17 = jVar.aJP;
        if (j17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_done_cost", j17);
        }
        String str2 = jVar.aJQ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "host_ip", jVar.aJQ);
        }
        int i5 = jVar.aJR;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ip_type", i5);
        }
        int i6 = jVar.aJS;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recommend_ping_time", i6);
        }
        int i7 = jVar.aJT;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backup_ping_time", i7);
        }
        int i8 = jVar.aJU;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "other_ping_time", i8);
        }
        return jSONObject;
    }
}
