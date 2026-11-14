package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.fl.saas.base.custom.MedProConst;
import com.kwad.sdk.core.webview.d.a;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class fm implements com.kwad.sdk.core.d<a.C0372a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0372a c0372a, JSONObject jSONObject) {
        a2(c0372a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0372a c0372a, JSONObject jSONObject) {
        return b2(c0372a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0372a c0372a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0372a.SDKVersion = jSONObject.optString("SDKVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0372a.SDKVersion)) {
            c0372a.SDKVersion = "";
        }
        c0372a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c0372a.aMl = jSONObject.optString("tkVersion");
        if (obj.toString().equals(c0372a.aMl)) {
            c0372a.aMl = "";
        }
        c0372a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(c0372a.sdkApiVersion)) {
            c0372a.sdkApiVersion = "";
        }
        c0372a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c0372a.sdkType = jSONObject.optInt("sdkType");
        c0372a.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(c0372a.appVersion)) {
            c0372a.appVersion = "";
        }
        c0372a.appName = jSONObject.optString("appName");
        if (obj.toString().equals(c0372a.appName)) {
            c0372a.appName = "";
        }
        c0372a.appId = jSONObject.optString(MedProConst.AD_APPID);
        if (obj.toString().equals(c0372a.appId)) {
            c0372a.appId = "";
        }
        c0372a.aSG = jSONObject.optString("globalId");
        if (obj.toString().equals(c0372a.aSG)) {
            c0372a.aSG = "";
        }
        c0372a.aNa = jSONObject.optString("eGid");
        if (obj.toString().equals(c0372a.aNa)) {
            c0372a.aNa = "";
        }
        c0372a.aMZ = jSONObject.optString("deviceSig");
        if (obj.toString().equals(c0372a.aMZ)) {
            c0372a.aMZ = "";
        }
        c0372a.ahc = jSONObject.optString("networkType");
        if (obj.toString().equals(c0372a.ahc)) {
            c0372a.ahc = "";
        }
        c0372a.ahd = jSONObject.optString("manufacturer");
        if (obj.toString().equals(c0372a.ahd)) {
            c0372a.ahd = "";
        }
        c0372a.model = jSONObject.optString(com.baidu.mobads.sdk.internal.bn.i);
        if (obj.toString().equals(c0372a.model)) {
            c0372a.model = "";
        }
        c0372a.Mi = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(c0372a.Mi)) {
            c0372a.Mi = "";
        }
        c0372a.ahe = jSONObject.optInt("osType");
        c0372a.ahf = jSONObject.optString("systemVersion");
        if (obj.toString().equals(c0372a.ahf)) {
            c0372a.ahf = "";
        }
        c0372a.ahg = jSONObject.optInt("osApi");
        c0372a.ahh = jSONObject.optString(MediaFormat.KEY_LANGUAGE);
        if (obj.toString().equals(c0372a.ahh)) {
            c0372a.ahh = "";
        }
        c0372a.ahi = jSONObject.optString("locale");
        if (obj.toString().equals(c0372a.ahi)) {
            c0372a.ahi = "";
        }
        c0372a.aSH = jSONObject.optString("uuid");
        if (obj.toString().equals(c0372a.aSH)) {
            c0372a.aSH = "";
        }
        c0372a.aSI = jSONObject.optBoolean("isDynamic");
        c0372a.QX = jSONObject.optInt("screenWidth");
        c0372a.QW = jSONObject.optInt("screenHeight");
        c0372a.aGW = jSONObject.optString("imei");
        if (obj.toString().equals(c0372a.aGW)) {
            c0372a.aGW = "";
        }
        c0372a.aGX = jSONObject.optString("oaid");
        if (obj.toString().equals(c0372a.aGX)) {
            c0372a.aGX = "";
        }
        c0372a.aMW = jSONObject.optString("androidId");
        if (obj.toString().equals(c0372a.aMW)) {
            c0372a.aMW = "";
        }
        c0372a.aNn = jSONObject.optString("mac");
        if (obj.toString().equals(c0372a.aNn)) {
            c0372a.aNn = "";
        }
        c0372a.ahj = jSONObject.optInt("statusBarHeight");
        c0372a.ahk = jSONObject.optInt("titleBarHeight");
        c0372a.aSJ = jSONObject.optString("bridgeVersion");
        if (obj.toString().equals(c0372a.aSJ)) {
            c0372a.aSJ = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0372a c0372a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0372a.SDKVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", c0372a.SDKVersion);
        }
        int i = c0372a.SDKVersionCode;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c0372a.aMl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", c0372a.aMl);
        }
        String str3 = c0372a.sdkApiVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", c0372a.sdkApiVersion);
        }
        int i2 = c0372a.sdkApiVersionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c0372a.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c0372a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", c0372a.appVersion);
        }
        String str5 = c0372a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", c0372a.appName);
        }
        String str6 = c0372a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MedProConst.AD_APPID, c0372a.appId);
        }
        String str7 = c0372a.aSG;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "globalId", c0372a.aSG);
        }
        String str8 = c0372a.aNa;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", c0372a.aNa);
        }
        String str9 = c0372a.aMZ;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", c0372a.aMZ);
        }
        String str10 = c0372a.ahc;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", c0372a.ahc);
        }
        String str11 = c0372a.ahd;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", c0372a.ahd);
        }
        String str12 = c0372a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.sdk.internal.bn.i, c0372a.model);
        }
        String str13 = c0372a.Mi;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", c0372a.Mi);
        }
        int i4 = c0372a.ahe;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", i4);
        }
        String str14 = c0372a.ahf;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", c0372a.ahf);
        }
        int i5 = c0372a.ahg;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c0372a.ahh;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_LANGUAGE, c0372a.ahh);
        }
        String str16 = c0372a.ahi;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", c0372a.ahi);
        }
        String str17 = c0372a.aSH;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uuid", c0372a.aSH);
        }
        boolean z = c0372a.aSI;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDynamic", z);
        }
        int i6 = c0372a.QX;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c0372a.QW;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c0372a.aGW;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", c0372a.aGW);
        }
        String str19 = c0372a.aGX;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", c0372a.aGX);
        }
        String str20 = c0372a.aMW;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", c0372a.aMW);
        }
        String str21 = c0372a.aNn;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mac", c0372a.aNn);
        }
        int i8 = c0372a.ahj;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c0372a.ahk;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", i9);
        }
        String str22 = c0372a.aSJ;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bridgeVersion", c0372a.aSJ);
        }
        return jSONObject;
    }
}
