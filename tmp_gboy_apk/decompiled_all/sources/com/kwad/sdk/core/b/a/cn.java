package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.h;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class cn implements com.kwad.sdk.core.d<h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.sW = jSONObject.optString("closeBtnText");
        if (obj.toString().equals(cVar.sW)) {
            cVar.sW = "";
        }
        cVar.sX = jSONObject.optString("continueBtnText");
        if (obj.toString().equals(cVar.sX)) {
            cVar.sX = "";
        }
        cVar.sY = jSONObject.optString("viewDetailText");
        if (obj.toString().equals(cVar.sY)) {
            cVar.sY = "";
        }
        cVar.sZ = jSONObject.optString("unWatchedVideoTime");
        if (obj.toString().equals(cVar.sZ)) {
            cVar.sZ = "";
        }
        cVar.ta = jSONObject.optString("iconUrl");
        if (obj.toString().equals(cVar.ta)) {
            cVar.ta = "";
        }
        cVar.tb = jSONObject.optString("desc");
        if (obj.toString().equals(cVar.tb)) {
            cVar.tb = "";
        }
        cVar.tc = jSONObject.optString("descTxt");
        if (obj.toString().equals(cVar.tc)) {
            cVar.tc = "";
        }
        cVar.td = jSONObject.optString("currentPlayTime");
        if (obj.toString().equals(cVar.td)) {
            cVar.td = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.style;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "style", i);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.sW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeBtnText", cVar.sW);
        }
        String str3 = cVar.sX;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "continueBtnText", cVar.sX);
        }
        String str4 = cVar.sY;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewDetailText", cVar.sY);
        }
        String str5 = cVar.sZ;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unWatchedVideoTime", cVar.sZ);
        }
        String str6 = cVar.ta;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "iconUrl", cVar.ta);
        }
        String str7 = cVar.tb;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "desc", cVar.tb);
        }
        String str8 = cVar.tc;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "descTxt", cVar.tc);
        }
        String str9 = cVar.td;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentPlayTime", cVar.td);
        }
        return jSONObject;
    }
}
