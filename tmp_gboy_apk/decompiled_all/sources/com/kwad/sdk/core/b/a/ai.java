package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ai implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        aVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.aCl = jSONObject.optJSONObject("extData");
        aVar.aAV = jSONObject.optInt("adActionType");
        aVar.aCm = jSONObject.optInt("photoPlaySecond");
        aVar.aCn = jSONObject.optInt("awardReceiveStage");
        aVar.mH = jSONObject.optInt("itemClickType");
        aVar.aCo = jSONObject.optInt("itemCloseType");
        aVar.aCp = jSONObject.optInt("elementType");
        aVar.aCq = jSONObject.optString("adRenderArea");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aCq)) {
            aVar.aCq = "";
        }
        aVar.aCr = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        aVar.aCs = jSONObject.optInt("impFailReason");
        aVar.aCt = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString(MediationConstant.KEY_ADN_NAME);
        if (obj.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.aCu = jSONObject.optString("adnAdvertiser");
        if (obj.toString().equals(aVar.aCu)) {
            aVar.aCu = "";
        }
        aVar.aCv = jSONObject.optString("adnTitle");
        if (obj.toString().equals(aVar.aCv)) {
            aVar.aCv = "";
        }
        aVar.aCw = jSONObject.optString("adnRequestId");
        if (obj.toString().equals(aVar.aCw)) {
            aVar.aCw = "";
        }
        aVar.aCx = jSONObject.optInt("adnShowType");
        aVar.aCy = jSONObject.optInt("adnClickType");
        aVar.adnMaterialType = jSONObject.optInt("adnMaterialType");
        aVar.adnMaterialUrl = jSONObject.optString("adnMaterialUrl");
        if (obj.toString().equals(aVar.adnMaterialUrl)) {
            aVar.adnMaterialUrl = "";
        }
        aVar.aCz = jSONObject.optInt("retainCodeType");
        aVar.PK = jSONObject.optInt("photoSizeStyle");
        aVar.PI = jSONObject.optString("payload");
        if (obj.toString().equals(aVar.PI)) {
            aVar.PI = "";
        }
        aVar.aCA = jSONObject.optInt("deeplinkType");
        aVar.aCB = jSONObject.optString("deeplinkAppName");
        if (obj.toString().equals(aVar.aCB)) {
            aVar.aCB = "";
        }
        aVar.aCC = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt("downloadSource");
        aVar.aCD = jSONObject.optInt("isPackageChanged");
        aVar.aCE = jSONObject.optString("installedFrom");
        if (obj.toString().equals(aVar.aCE)) {
            aVar.aCE = "";
        }
        aVar.aCF = jSONObject.optString("downloadFailedReason");
        if (obj.toString().equals(aVar.aCF)) {
            aVar.aCF = "";
        }
        aVar.aCG = jSONObject.optInt("isChangedEndcard");
        aVar.aCH = jSONObject.optInt("adAggPageSource");
        aVar.aCI = jSONObject.optString("serverPackageName");
        if (obj.toString().equals(aVar.aCI)) {
            aVar.aCI = "";
        }
        aVar.aCJ = jSONObject.optString("installedPackageName");
        if (obj.toString().equals(aVar.aCJ)) {
            aVar.aCJ = "";
        }
        aVar.aCK = jSONObject.optInt("closeButtonImpressionTime");
        aVar.aCL = jSONObject.optInt("closeButtonClickTime");
        aVar.aCM = jSONObject.optLong("landingPageLoadedDuration");
        aVar.Ql = jSONObject.optLong("leaveTime");
        aVar.aCN = jSONObject.optLong("adItemClickBackDuration");
        aVar.aCO = jSONObject.optInt("appStorePageType");
        aVar.aCP = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.aCQ = jSONObject.optInt("downloadCardType");
        a.C0353a c0353a = new a.C0353a();
        aVar.PJ = c0353a;
        c0353a.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.UO = jSONObject.optInt("landingPageType");
        aVar.yY = jSONObject.optLong("playedDuration");
        aVar.aCR = jSONObject.optInt("playedRate");
        aVar.aCS = jSONObject.optInt("adOrder");
        aVar.PH = jSONObject.optInt("adInterstitialSource");
        aVar.mK = jSONObject.optDouble("splashShakeAcceleration");
        aVar.aCT = jSONObject.optString("splashInteractionRotateAngle");
        if (obj.toString().equals(aVar.aCT)) {
            aVar.aCT = "";
        }
        aVar.aCU = jSONObject.optInt("downloadInstallType");
        aVar.aCV = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.aCW = jSONObject.optInt("fingerSwipeType");
        aVar.aCX = jSONObject.optInt("fingerSwipeDistance");
        aVar.aCY = jSONObject.optInt("finger_swipe_angle");
        aVar.PL = jSONObject.optInt("triggerType");
        aVar.aCZ = jSONObject.optInt("cardCloseType");
        aVar.aDa = jSONObject.optString("clientPkFailAdInfo");
        if (obj.toString().equals(aVar.aDa)) {
            aVar.aDa = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extData", aVar.aCl);
        int i = aVar.aAV;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionType", i);
        }
        int i2 = aVar.aCm;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoPlaySecond", i2);
        }
        int i3 = aVar.aCn;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "awardReceiveStage", i3);
        }
        int i4 = aVar.mH;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", i4);
        }
        int i5 = aVar.aCo;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemCloseType", i5);
        }
        int i6 = aVar.aCp;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "elementType", i6);
        }
        String str = aVar.aCq;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adRenderArea", aVar.aCq);
        }
        long j = aVar.aCr;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j);
        }
        int i7 = aVar.aCs;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impFailReason", i7);
        }
        long j2 = aVar.aCt;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "winEcpm", j2);
        }
        int i8 = aVar.adnType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnType", i8);
        }
        String str2 = aVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        String str3 = aVar.aCu;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnAdvertiser", aVar.aCu);
        }
        String str4 = aVar.aCv;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnTitle", aVar.aCv);
        }
        String str5 = aVar.aCw;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnRequestId", aVar.aCw);
        }
        int i9 = aVar.aCx;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnShowType", i9);
        }
        int i10 = aVar.aCy;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnClickType", i10);
        }
        int i11 = aVar.adnMaterialType;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialType", i11);
        }
        String str6 = aVar.adnMaterialUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialUrl", aVar.adnMaterialUrl);
        }
        int i12 = aVar.aCz;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainCodeType", i12);
        }
        int i13 = aVar.PK;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSizeStyle", i13);
        }
        String str7 = aVar.PI;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", aVar.PI);
        }
        int i14 = aVar.aCA;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkType", i14);
        }
        String str8 = aVar.aCB;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkAppName", aVar.aCB);
        }
        int i15 = aVar.aCC;
        if (i15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkFailedReason", i15);
        }
        int i16 = aVar.downloadSource;
        if (i16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadSource", i16);
        }
        int i17 = aVar.aCD;
        if (i17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isPackageChanged", i17);
        }
        String str9 = aVar.aCE;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedFrom", aVar.aCE);
        }
        String str10 = aVar.aCF;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFailedReason", aVar.aCF);
        }
        int i18 = aVar.aCG;
        if (i18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isChangedEndcard", i18);
        }
        int i19 = aVar.aCH;
        if (i19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", i19);
        }
        String str11 = aVar.aCI;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPackageName", aVar.aCI);
        }
        String str12 = aVar.aCJ;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedPackageName", aVar.aCJ);
        }
        int i20 = aVar.aCK;
        if (i20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonImpressionTime", i20);
        }
        int i21 = aVar.aCL;
        if (i21 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonClickTime", i21);
        }
        long j3 = aVar.aCM;
        if (j3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageLoadedDuration", j3);
        }
        long j4 = aVar.Ql;
        if (j4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leaveTime", j4);
        }
        long j5 = aVar.aCN;
        if (j5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adItemClickBackDuration", j5);
        }
        int i22 = aVar.aCO;
        if (i22 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStorePageType", i22);
        }
        int i23 = aVar.aCP;
        if (i23 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installStatus", i23);
        }
        int i24 = aVar.downloadStatus;
        if (i24 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadStatus", i24);
        }
        int i25 = aVar.aCQ;
        if (i25 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadCardType", i25);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExtData", aVar.PJ);
        int i26 = aVar.UO;
        if (i26 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageType", i26);
        }
        long j6 = aVar.yY;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedDuration", j6);
        }
        int i27 = aVar.aCR;
        if (i27 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedRate", i27);
        }
        int i28 = aVar.aCS;
        if (i28 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adOrder", i28);
        }
        int i29 = aVar.PH;
        if (i29 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adInterstitialSource", i29);
        }
        double d = aVar.mK;
        if (d != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashShakeAcceleration", d);
        }
        String str13 = aVar.aCT;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashInteractionRotateAngle", aVar.aCT);
        }
        int i30 = aVar.aCU;
        if (i30 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadInstallType", i30);
        }
        int i31 = aVar.aCV;
        if (i31 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "businessSceneType", i31);
        }
        int i32 = aVar.adxResult;
        if (i32 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adxResult", i32);
        }
        int i33 = aVar.aCW;
        if (i33 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeType", i33);
        }
        int i34 = aVar.aCX;
        if (i34 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeDistance", i34);
        }
        int i35 = aVar.aCY;
        if (i35 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finger_swipe_angle", i35);
        }
        int i36 = aVar.PL;
        if (i36 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "triggerType", i36);
        }
        int i37 = aVar.aCZ;
        if (i37 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardCloseType", i37);
        }
        String str14 = aVar.aDa;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clientPkFailAdInfo", aVar.aDa);
        }
        return jSONObject;
    }
}
