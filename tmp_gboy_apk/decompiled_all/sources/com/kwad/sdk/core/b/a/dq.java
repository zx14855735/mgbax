package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class dq implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aGW = jSONObject.optString("imei");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aGW)) {
            bVar.aGW = "";
        }
        bVar.aMP = jSONObject.optString("imei1");
        if (obj.toString().equals(bVar.aMP)) {
            bVar.aMP = "";
        }
        bVar.aMQ = jSONObject.optString("imei2");
        if (obj.toString().equals(bVar.aMQ)) {
            bVar.aMQ = "";
        }
        bVar.aMR = jSONObject.optString("meid");
        if (obj.toString().equals(bVar.aMR)) {
            bVar.aMR = "";
        }
        bVar.aGX = jSONObject.optString("oaid");
        if (obj.toString().equals(bVar.aGX)) {
            bVar.aGX = "";
        }
        bVar.aMS = jSONObject.optString("appMkt");
        if (obj.toString().equals(bVar.aMS)) {
            bVar.aMS = "";
        }
        bVar.aMT = jSONObject.optString("appMktParam");
        if (obj.toString().equals(bVar.aMT)) {
            bVar.aMT = "";
        }
        bVar.Mk = jSONObject.optString("romName");
        if (obj.toString().equals(bVar.Mk)) {
            bVar.Mk = "";
        }
        bVar.ahe = jSONObject.optInt("osType");
        bVar.ahg = jSONObject.optInt("osApi");
        bVar.Mj = jSONObject.optString("osVersion");
        if (obj.toString().equals(bVar.Mj)) {
            bVar.Mj = "";
        }
        bVar.ahh = jSONObject.optString(MediaFormat.KEY_LANGUAGE);
        if (obj.toString().equals(bVar.ahh)) {
            bVar.ahh = "";
        }
        bVar.QX = jSONObject.optInt("screenWidth");
        bVar.QW = jSONObject.optInt("screenHeight");
        bVar.aMU = jSONObject.optInt("deviceWidth");
        bVar.aMV = jSONObject.optInt("deviceHeight");
        bVar.aMW = jSONObject.optString("androidId");
        if (obj.toString().equals(bVar.aMW)) {
            bVar.aMW = "";
        }
        bVar.Ml = jSONObject.optString("deviceId");
        if (obj.toString().equals(bVar.Ml)) {
            bVar.Ml = "";
        }
        bVar.aMX = jSONObject.optString("deviceVendor");
        if (obj.toString().equals(bVar.aMX)) {
            bVar.aMX = "";
        }
        bVar.aMY = jSONObject.optInt("platform");
        bVar.Mh = jSONObject.optString("deviceModel");
        if (obj.toString().equals(bVar.Mh)) {
            bVar.Mh = "";
        }
        bVar.Mi = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(bVar.Mi)) {
            bVar.Mi = "";
        }
        bVar.aMZ = jSONObject.optString("deviceSig");
        if (obj.toString().equals(bVar.aMZ)) {
            bVar.aMZ = "";
        }
        bVar.aNa = jSONObject.optString("eGid");
        if (obj.toString().equals(bVar.aNa)) {
            bVar.aNa = "";
        }
        bVar.aNb = jSONObject.optJSONArray("appPackageName");
        bVar.aNc = jSONObject.optString("uaidToken");
        if (obj.toString().equals(bVar.aNc)) {
            bVar.aNc = "";
        }
        bVar.uaid = jSONObject.optString("uaid");
        if (obj.toString().equals(bVar.uaid)) {
            bVar.uaid = "";
        }
        bVar.aNd = jSONObject.optString("arch");
        if (obj.toString().equals(bVar.aNd)) {
            bVar.aNd = "";
        }
        bVar.aNe = jSONObject.optInt("screenDirection");
        bVar.aNf = jSONObject.optString("kwaiVersionName");
        if (obj.toString().equals(bVar.aNf)) {
            bVar.aNf = "";
        }
        bVar.aNg = jSONObject.optString("kwaiNebulaVersionName");
        if (obj.toString().equals(bVar.aNg)) {
            bVar.aNg = "";
        }
        bVar.aNh = jSONObject.optString("wechatVersionName");
        if (obj.toString().equals(bVar.aNh)) {
            bVar.aNh = "";
        }
        bVar.aNi = jSONObject.optLong("sourceFlag");
        bVar.aNj = jSONObject.optString("systemBootTime");
        if (obj.toString().equals(bVar.aNj)) {
            bVar.aNj = "";
        }
        bVar.aNk = jSONObject.optString("systemUpdateTime");
        if (obj.toString().equals(bVar.aNk)) {
            bVar.aNk = "";
        }
        bVar.aNl = jSONObject.optInt("probeBatch");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aGW;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", bVar.aGW);
        }
        String str2 = bVar.aMP;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei1", bVar.aMP);
        }
        String str3 = bVar.aMQ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei2", bVar.aMQ);
        }
        String str4 = bVar.aMR;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "meid", bVar.aMR);
        }
        String str5 = bVar.aGX;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", bVar.aGX);
        }
        String str6 = bVar.aMS;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMkt", bVar.aMS);
        }
        String str7 = bVar.aMT;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMktParam", bVar.aMT);
        }
        String str8 = bVar.Mk;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "romName", bVar.Mk);
        }
        int i = bVar.ahe;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", i);
        }
        int i2 = bVar.ahg;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", i2);
        }
        String str9 = bVar.Mj;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osVersion", bVar.Mj);
        }
        String str10 = bVar.ahh;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_LANGUAGE, bVar.ahh);
        }
        int i3 = bVar.QX;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", i3);
        }
        int i4 = bVar.QW;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", i4);
        }
        int i5 = bVar.aMU;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceWidth", i5);
        }
        int i6 = bVar.aMV;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceHeight", i6);
        }
        String str11 = bVar.aMW;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", bVar.aMW);
        }
        String str12 = bVar.Ml;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceId", bVar.Ml);
        }
        String str13 = bVar.aMX;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceVendor", bVar.aMX);
        }
        int i7 = bVar.aMY;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "platform", i7);
        }
        String str14 = bVar.Mh;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceModel", bVar.Mh);
        }
        String str15 = bVar.Mi;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", bVar.Mi);
        }
        String str16 = bVar.aMZ;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", bVar.aMZ);
        }
        String str17 = bVar.aNa;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", bVar.aNa);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appPackageName", bVar.aNb);
        String str18 = bVar.aNc;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaidToken", bVar.aNc);
        }
        String str19 = bVar.uaid;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaid", bVar.uaid);
        }
        String str20 = bVar.aNd;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "arch", bVar.aNd);
        }
        int i8 = bVar.aNe;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenDirection", i8);
        }
        String str21 = bVar.aNf;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiVersionName", bVar.aNf);
        }
        String str22 = bVar.aNg;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiNebulaVersionName", bVar.aNg);
        }
        String str23 = bVar.aNh;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "wechatVersionName", bVar.aNh);
        }
        long j = bVar.aNi;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sourceFlag", j);
        }
        String str24 = bVar.aNj;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemBootTime", bVar.aNj);
        }
        String str25 = bVar.aNk;
        if (str25 != null && !str25.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemUpdateTime", bVar.aNk);
        }
        int i9 = bVar.aNl;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "probeBatch", i9);
        }
        return jSONObject;
    }
}
