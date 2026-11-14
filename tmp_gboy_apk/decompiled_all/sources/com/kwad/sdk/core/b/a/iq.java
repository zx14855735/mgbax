package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class iq implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bcv = jSONObject.optString("typeStr");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.bcv)) {
            aVar.bcv = "";
        }
        aVar.bcw = jSONObject.optString("valueStr");
        if (obj.toString().equals(aVar.bcw)) {
            aVar.bcw = "";
        }
        aVar.bcx = jSONObject.optString("listValueType");
        if (obj.toString().equals(aVar.bcx)) {
            aVar.bcx = "";
        }
        aVar.bcy = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.bcy.add((String) optJSONArray.opt(i));
            }
        }
        aVar.fieldName = jSONObject.optString("fieldName");
        Object obj2 = JSONObject.NULL;
        if (obj2.toString().equals(aVar.fieldName)) {
            aVar.fieldName = "";
        }
        aVar.className = jSONObject.optString("className");
        if (obj2.toString().equals(aVar.className)) {
            aVar.className = "";
        }
        aVar.bcz = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                b.a aVar2 = new b.a();
                aVar2.parseJson(optJSONArray2.optJSONObject(i2));
                aVar.bcz.add(aVar2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.bcv;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeStr", aVar.bcv);
        }
        String str2 = aVar.bcw;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStr", aVar.bcw);
        }
        String str3 = aVar.bcx;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listValueType", aVar.bcx);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStrList", aVar.bcy);
        String str4 = aVar.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fieldName", aVar.fieldName);
        }
        String str5 = aVar.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "className", aVar.className);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "childParamList", aVar.bcz);
        return jSONObject;
    }
}
