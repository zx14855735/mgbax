package com.kwad.sdk.core.b.a;

import J3FDQU.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.fl.saas.common.util.CommConstant;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ji implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong("timestamp");
        nVar.sessionId = jSONObject.optString("sessionId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.ND = jSONObject.optLong("seq");
        nVar.aLq = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong("actionType");
        nVar.PI = jSONObject.optString("payload");
        if (obj.toString().equals(nVar.PI)) {
            nVar.PI = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.aLr = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
        nVar.aLs = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong("position");
        nVar.aLt = jSONObject.optLong("serverPosition");
        nVar.aLu = jSONObject.optLong("photoDuration");
        nVar.aLv = jSONObject.optLong("effectivePlayDuration");
        nVar.age = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.aLw = jSONObject.optLong("intervalDuration");
        nVar.aLx = jSONObject.optLong("allIntervalDuration");
        nVar.aLy = jSONObject.optLong("flowSdk");
        nVar.aLz = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = A2egSU.A5SV6n(Constants.FAIL, "contentSourceType", jSONObject);
        nVar.aCH = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (obj.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        nVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        nVar.aLA = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.abv = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.aLB = jSONObject.optString("photoSize");
        if (obj.toString().equals(nVar.aLB)) {
            nVar.aLB = "";
        }
        nVar.aLC = jSONObject.optJSONArray("appInstalled");
        nVar.aLD = jSONObject.optJSONArray("appUninstalled");
        n.a aVar = new n.a();
        nVar.aLE = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.aLF = jSONObject.optInt("playerType");
        nVar.aLG = jSONObject.optInt("uiType");
        nVar.aLH = A2egSU.A5SV6n(Constants.FAIL, "isLeftSlipStatus", jSONObject);
        nVar.ahA = jSONObject.optInt("refreshType");
        nVar.aLI = A2egSU.A5SV6n(Constants.FAIL, "photoResponseType", jSONObject);
        nVar.aLJ = jSONObject.optString("failUrl");
        if (obj.toString().equals(nVar.aLJ)) {
            nVar.aLJ = "";
        }
        nVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (obj.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = A2egSU.A5SV6n(Constants.FAIL, MediationConstant.KEY_ERROR_CODE, jSONObject);
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.aLM = jSONObject.optString("cacheFailedReason");
        if (obj.toString().equals(nVar.aLM)) {
            nVar.aLM = "";
        }
        nVar.aLN = jSONObject.optJSONObject("appExt");
        nVar.aLO = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = A2egSU.A5SV6n(Constants.FAIL, "pageType", jSONObject);
        nVar.aLP = jSONObject.optInt("speedLimitStatus");
        nVar.aLQ = jSONObject.optInt("speedLimitThreshold");
        nVar.aLR = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.aLT = jSONObject.optJSONArray("sdkPlatform");
        nVar.aLU = jSONObject.optBoolean("isKsUnion");
        nVar.aLV = jSONObject.optString("trackMethodName");
        if (obj.toString().equals(nVar.aLV)) {
            nVar.aLV = "";
        }
        nVar.aLW = A2egSU.A5SV6n(Constants.FAIL, "viewModeType", jSONObject);
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.aLY = jSONObject.optLong("frameRenderTime");
        nVar.aLZ = jSONObject.optInt("playerEnterAction");
        nVar.aMa = jSONObject.optString("requestUrl");
        if (obj.toString().equals(nVar.aMa)) {
            nVar.aMa = "";
        }
        nVar.aMb = jSONObject.optLong("requestTotalTime");
        nVar.aMc = jSONObject.optLong("requestResponseTime");
        nVar.aMd = jSONObject.optLong("requestParseDataTime");
        nVar.aMe = jSONObject.optLong("requestCallbackTime");
        nVar.aMf = jSONObject.optString("requestFailReason");
        if (obj.toString().equals(nVar.aMf)) {
            nVar.aMf = "";
        }
        nVar.aau = jSONObject.optString("pageName");
        if (obj.toString().equals(nVar.aau)) {
            nVar.aau = "";
        }
        nVar.aaC = jSONObject.optLong("pageCreateTime");
        nVar.aaD = jSONObject.optLong("pageResumeTime");
        nVar.aMg = jSONObject.optInt("trackUrlType");
        nVar.aMh = jSONObject.optJSONArray("trackUrlList");
        nVar.aaB = jSONObject.optLong("pageLaunchTime");
        nVar.aMk = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.aMl = jSONObject.optString("tkVersion");
        if (obj.toString().equals(nVar.aMl)) {
            nVar.aMl = "";
        }
        nVar.aMm = jSONObject.optString("jsVersion");
        if (obj.toString().equals(nVar.aMm)) {
            nVar.aMm = "";
        }
        nVar.aMn = jSONObject.optString("jsFileName");
        if (obj.toString().equals(nVar.aMn)) {
            nVar.aMn = "";
        }
        nVar.aMo = jSONObject.optString("jsErrorMsg");
        if (obj.toString().equals(nVar.aMo)) {
            nVar.aMo = "";
        }
        nVar.aMp = jSONObject.optString("jsConfig");
        if (obj.toString().equals(nVar.aMp)) {
            nVar.aMp = "";
        }
        nVar.aMq = jSONObject.optInt("adBizType");
        nVar.aMr = jSONObject.optString("customKey");
        if (obj.toString().equals(nVar.aMr)) {
            nVar.aMr = "";
        }
        nVar.aMs = jSONObject.optString("customValue");
        if (obj.toString().equals(nVar.aMs)) {
            nVar.aMs = "";
        }
        nVar.trace = jSONObject.optString("trace");
        if (obj.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.aMt = jSONObject.optInt("filterCode");
        nVar.aMu = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString(CommConstant.SdkVersion.SDK_VERSION_KEY);
        if (obj.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.aMv = jSONObject.optString("adSdkVersion");
        if (obj.toString().equals(nVar.aMv)) {
            nVar.aMv = "";
        }
        nVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(nVar.sdkApiVersion)) {
            nVar.sdkApiVersion = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.aMw = jSONObject.optLong("appUseDuration");
        nVar.aMx = jSONObject.optLong("appStartType");
        nVar.aHN = jSONObject.optLong("sequenceNumber");
        nVar.Nz = jSONObject.optString("appColdStart");
        if (obj.toString().equals(nVar.Nz)) {
            nVar.Nz = "";
        }
        nVar.NB = jSONObject.optString("appStart");
        if (obj.toString().equals(nVar.NB)) {
            nVar.NB = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = nVar.timestamp;
        if (j != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "timestamp", j);
        }
        String str = nVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        long j2 = nVar.ND;
        if (j2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "seq", j2);
        }
        long j3 = nVar.aLq;
        if (j3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listId", j3);
        }
        long j4 = nVar.actionType;
        if (j4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", j4);
        }
        String str2 = nVar.PI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", nVar.PI);
        }
        long j5 = nVar.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j5);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, BaseConstants.EVENT_LABEL_EXTRA, nVar.aLr);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "impAdExtra", nVar.aLs);
        long j6 = nVar.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j6);
        }
        int i = nVar.contentType;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentType", i);
        }
        int i2 = nVar.realShowType;
        if (i2 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realShowType", i2);
        }
        long j7 = nVar.photoId;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", j7);
        }
        long j8 = nVar.position;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "position", j8);
        }
        long j9 = nVar.aLt;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPosition", j9);
        }
        long j10 = nVar.aLu;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoDuration", j10);
        }
        long j11 = nVar.aLv;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "effectivePlayDuration", j11);
        }
        long j12 = nVar.age;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", j12);
        }
        long j13 = nVar.blockDuration;
        if (j13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockDuration", j13);
        }
        long j14 = nVar.aLw;
        if (j14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "intervalDuration", j14);
        }
        long j15 = nVar.aLx;
        if (j15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "allIntervalDuration", j15);
        }
        long j16 = nVar.aLy;
        if (j16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "flowSdk", j16);
        }
        long j17 = nVar.aLz;
        if (j17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTimes", j17);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        int i3 = nVar.aCH;
        if (i3 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", i3);
        }
        String str3 = nVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.aa.a(jSONObject, "referURLPackage", nVar.aLA);
        long j18 = nVar.abv;
        if (j18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j18);
        }
        String str4 = nVar.aLB;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSize", nVar.aLB);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appInstalled", nVar.aLC);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appUninstalled", nVar.aLD);
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExt", nVar.aLE);
        int i4 = nVar.aLF;
        if (i4 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerType", i4);
        }
        int i5 = nVar.aLG;
        if (i5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uiType", i5);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "isLeftSlipStatus", nVar.aLH);
        int i6 = nVar.ahA;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", i6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "photoResponseType", nVar.aLI);
        String str5 = nVar.aLJ;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "failUrl", nVar.aLJ);
        }
        String str6 = nVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, nVar.errorMsg);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, nVar.errorCode);
        long j19 = nVar.creativeId;
        if (j19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", j19);
        }
        String str7 = nVar.aLM;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheFailedReason", nVar.aLM);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appExt", nVar.aLN);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appRunningInfoList", nVar.aLO);
        long j20 = nVar.downloadDuration;
        if (j20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadDuration", j20);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "pageType", nVar.pageType);
        int i7 = nVar.aLP;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitStatus", i7);
        }
        int i8 = nVar.aLQ;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitThreshold", i8);
        }
        int i9 = nVar.aLR;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentRealDownloadSpeed", i9);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkPlatform", nVar.aLT);
        boolean z = nVar.aLU;
        if (z) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isKsUnion", z);
        }
        String str8 = nVar.aLV;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackMethodName", nVar.aLV);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "viewModeType", nVar.aLW);
        long j21 = nVar.clickTime;
        if (j21 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickTime", j21);
        }
        long j22 = nVar.aLY;
        if (j22 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "frameRenderTime", j22);
        }
        int i10 = nVar.aLZ;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerEnterAction", i10);
        }
        String str9 = nVar.aMa;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestUrl", nVar.aMa);
        }
        long j23 = nVar.aMb;
        if (j23 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestTotalTime", j23);
        }
        long j24 = nVar.aMc;
        if (j24 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestResponseTime", j24);
        }
        long j25 = nVar.aMd;
        if (j25 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestParseDataTime", j25);
        }
        long j26 = nVar.aMe;
        if (j26 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestCallbackTime", j26);
        }
        String str10 = nVar.aMf;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestFailReason", nVar.aMf);
        }
        String str11 = nVar.aau;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageName", nVar.aau);
        }
        long j27 = nVar.aaC;
        if (j27 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageCreateTime", j27);
        }
        long j28 = nVar.aaD;
        if (j28 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageResumeTime", j28);
        }
        int i11 = nVar.aMg;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlType", i11);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlList", nVar.aMh);
        long j29 = nVar.aaB;
        if (j29 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageLaunchTime", j29);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appAuthorityInfoList", nVar.aMk);
        String str12 = nVar.aMl;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", nVar.aMl);
        }
        String str13 = nVar.aMm;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsVersion", nVar.aMm);
        }
        String str14 = nVar.aMn;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsFileName", nVar.aMn);
        }
        String str15 = nVar.aMo;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsErrorMsg", nVar.aMo);
        }
        String str16 = nVar.aMp;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsConfig", nVar.aMp);
        }
        int i12 = nVar.aMq;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adBizType", i12);
        }
        String str17 = nVar.aMr;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customKey", nVar.aMr);
        }
        String str18 = nVar.aMs;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customValue", nVar.aMs);
        }
        String str19 = nVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trace", nVar.trace);
        }
        int i13 = nVar.aMt;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "filterCode", i13);
        }
        int i14 = nVar.aMu;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkVersionCode", i14);
        }
        String str20 = nVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, CommConstant.SdkVersion.SDK_VERSION_KEY, nVar.sdkVersion);
        }
        String str21 = nVar.aMv;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSdkVersion", nVar.aMv);
        }
        String str22 = nVar.sdkApiVersion;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", nVar.sdkApiVersion);
        }
        int i15 = nVar.sdkType;
        if (i15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", i15);
        }
        long j30 = nVar.aMw;
        if (j30 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appUseDuration", j30);
        }
        long j31 = nVar.aMx;
        if (j31 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStartType", j31);
        }
        long j32 = nVar.aHN;
        if (j32 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sequenceNumber", j32);
        }
        String str23 = nVar.Nz;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appColdStart", nVar.Nz);
        }
        String str24 = nVar.NB;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStart", nVar.NB);
        }
        return jSONObject;
    }
}
