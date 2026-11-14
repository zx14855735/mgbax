package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.resourceCache.model.WarmUpReportMessage;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class mp implements com.kwad.sdk.core.d<WarmUpReportMessage> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        a2(warmUpReportMessage, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        return b2(warmUpReportMessage, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        warmUpReportMessage.downloadStatus = A2egSU.A5SV6n(Constants.FAIL, "status", jSONObject);
        warmUpReportMessage.resourceType = jSONObject.optInt("resource_type");
        warmUpReportMessage.resourceKey = jSONObject.optString("resource_key");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(warmUpReportMessage.resourceKey)) {
            warmUpReportMessage.resourceKey = "";
        }
        warmUpReportMessage.url = jSONObject.optString("url");
        if (obj.toString().equals(warmUpReportMessage.url)) {
            warmUpReportMessage.url = "";
        }
        warmUpReportMessage.localItems = jSONObject.optString("local_items");
        if (obj.toString().equals(warmUpReportMessage.localItems)) {
            warmUpReportMessage.localItems = "";
        }
        warmUpReportMessage.configItems = jSONObject.optString("config_items");
        if (obj.toString().equals(warmUpReportMessage.configItems)) {
            warmUpReportMessage.configItems = "";
        }
        warmUpReportMessage.freeDisk = jSONObject.optLong("free_disk");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "status", warmUpReportMessage.downloadStatus);
        int i = warmUpReportMessage.resourceType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_type", i);
        }
        String str = warmUpReportMessage.resourceKey;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_key", warmUpReportMessage.resourceKey);
        }
        String str2 = warmUpReportMessage.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", warmUpReportMessage.url);
        }
        String str3 = warmUpReportMessage.localItems;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "local_items", warmUpReportMessage.localItems);
        }
        String str4 = warmUpReportMessage.configItems;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "config_items", warmUpReportMessage.configItems);
        }
        long j = warmUpReportMessage.freeDisk;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "free_disk", j);
        }
        return jSONObject;
    }
}
