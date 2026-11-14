package com.kwad.sdk.core.b.a;

import com.kwad.components.core.innerEc.qcpx.ReceiveQcpxBody;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class jg implements com.kwad.sdk.core.d<ReceiveQcpxBody> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        a2(receiveQcpxBody, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        return b2(receiveQcpxBody, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        receiveQcpxBody.flowTag = jSONObject.optString("flowTag");
        if (JSONObject.NULL.toString().equals(receiveQcpxBody.flowTag)) {
            receiveQcpxBody.flowTag = "";
        }
        receiveQcpxBody.llsid = jSONObject.optLong("llsid");
        receiveQcpxBody.creativeId = jSONObject.optLong("creativeId");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = receiveQcpxBody.flowTag;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "flowTag", receiveQcpxBody.flowTag);
        }
        long j = receiveQcpxBody.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j);
        }
        long j2 = receiveQcpxBody.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", j2);
        }
        return jSONObject;
    }
}
