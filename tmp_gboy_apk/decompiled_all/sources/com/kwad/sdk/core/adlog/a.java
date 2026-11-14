package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bp;
import com.qq.e.comm.pi.IBidding;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int aBq;
    private final com.kwad.sdk.core.adlog.c.a aBr;
    private final AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    public static class C0353a extends com.kwad.sdk.core.response.a.a {
        public int aBA;
        public int aBB;
        public boolean aBC;
        public String aBD;
        public JSONObject aBE;
        public int aBG;
        public int aBH;
        public int aBI;
        public String aBJ;
        public String aBK;
        public int aBL;
        public int aBM;
        public AdTrackLog aBN;
        public int aBs;
        public String aBt;
        public String aBu;
        public String aBw;
        public int aBx;
        public int aBy;
        public int aBz;
        public String templateId;
        public int aBv = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int aBF = 0;
        public int showLiveStyle = -1;

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.Dy()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.aBN = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.aBN);
            }
            return this.aBN;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.aBv;
            if (i != -1) {
                aa.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                aa.putValue(jSONObject, MediationConstant.EXTRA_DURATION, j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                aa.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                aa.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.aBN;
            if (adTrackLog != null) {
                aa.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.aBE;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.aBE.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public a(com.kwad.sdk.core.adlog.c.a aVar) {
        this.aBr = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.aBq = aVar.aAV;
    }

    private void Gl() {
        JSONObject jSONObject = this.aBr.aCl;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        aa.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    private void a(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.aCS;
        if (i >= 0) {
            putBody("adOrder", i);
        }
        int i2 = aVar.PH;
        if (i2 >= 0) {
            putBody("adInterstitialSource", i2);
        }
        if (!TextUtils.isEmpty(aVar.aCq)) {
            putBody("adRenderArea", aVar.aCq);
        }
        putBody("adxResult", aVar.adxResult);
        int i3 = aVar.aCW;
        if (i3 != 0) {
            putBody("fingerSwipeType", i3);
        }
        int i4 = aVar.aCX;
        if (i4 != 0) {
            putBody("fingerSwipeDistance", i4);
        }
        int i5 = aVar.aCP;
        if (i5 != -1) {
            putBody("installStatus", i5);
        }
        C0353a c0353a = aVar.PJ;
        if (c0353a != null) {
            putBody("clientExtData", c0353a.toJson().toString());
        }
        String str2 = aVar.aDa;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i6 = aVar.PL;
        if (i6 != -1) {
            putBody("triggerType", i6);
        }
        int i7 = aVar.PK;
        if (i7 != 0) {
            putBody("photoSizeStyle", i7);
        }
    }

    private void b(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.mH;
        if (i != 0) {
            putBody("itemClickType", i);
        }
        if (!TextUtils.isEmpty(aVar.PI)) {
            putBody("payload", aVar.PI);
        }
        int i2 = aVar.aCH;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        int i3 = aVar.aCS;
        if (i3 >= 0) {
            putBody("adOrder", i3);
        }
        int i4 = aVar.PH;
        if (i4 >= 0) {
            putBody("adInterstitialSource", i4);
        }
        int i5 = aVar.PL;
        if (i5 != -1) {
            putBody("triggerType", i5);
        }
        int i6 = aVar.aCZ;
        if (i6 != 0) {
            putBody("cardCloseType", i6);
        }
        putBody("adxResult", aVar.adxResult);
        double d = aVar.mK;
        if (d > 0.0d) {
            putBody("splashShakeAcceleration", d);
        }
        if (!TextUtils.isEmpty(aVar.aCT)) {
            putBody("splashInteractionRotateAngle", aVar.aCT);
        }
        int i7 = aVar.aCW;
        if (i7 != 0) {
            putBody("fingerSwipeType", i7);
        }
        int i8 = aVar.aCX;
        if (i8 != 0) {
            putBody("fingerSwipeDistance", i8);
        }
        long j = aVar.yY;
        if (j > 0) {
            putBody("playedDuration", j);
        }
        int i9 = aVar.aCR;
        if (i9 > 0) {
            putBody("playedRate", i9);
        }
        String str2 = aVar.aDa;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i10 = aVar.aCz;
        if (i10 != -1) {
            putBody("retainCodeType", i10);
        }
        C0353a c0353a = aVar.PJ;
        if (c0353a != null) {
            putBody("clientExtData", c0353a.toJson().toString());
        }
        int i11 = aVar.aCY;
        if (i11 != 0) {
            putBody("finger_swiper_angle", i11);
        }
        int i12 = aVar.PK;
        if (i12 != 0) {
            putBody("photoSizeStyle", i12);
        }
    }

    private void c(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.aCo;
        if (i != 0) {
            putBody("itemCloseType", i);
        }
        int i2 = aVar.aCm;
        if (i2 > 0) {
            putBody("photoPlaySecond", i2);
        }
        int i3 = aVar.aCn;
        if (i3 != 0) {
            putBody("awardReceiveStage", i3);
        }
        int i4 = aVar.aCp;
        if (i4 != 0) {
            putBody("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.PI)) {
            putBody("payload", aVar.PI);
        }
        C0353a c0353a = aVar.PJ;
        if (c0353a != null) {
            putBody("clientExtData", c0353a.toJson().toString());
        }
        int i5 = aVar.aCA;
        if (i5 > 0) {
            putBody("deeplinkType", i5);
        }
        if (!TextUtils.isEmpty(aVar.aCB)) {
            putBody("deeplinkAppName", aVar.aCB);
        }
        int i6 = aVar.aCC;
        if (i6 != 0) {
            putBody("deeplinkFailedReason", i6);
        }
        int i7 = aVar.downloadSource;
        if (i7 > 0) {
            putBody("downloadSource", i7);
        }
        int i8 = aVar.aCZ;
        if (i8 != 0) {
            putBody("cardCloseType", i8);
        }
        int i9 = aVar.aCD;
        if (i9 > 0) {
            putBody("isPackageChanged", i9);
        }
        putBody("installedFrom", aVar.aCE);
        putBody("isChangedEndcard", aVar.aCG);
        int i10 = aVar.aCH;
        if (i10 != 0) {
            putBody("adAggPageSource", i10);
        }
        String str2 = aVar.aCF;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!bp.isNullString(aVar.aCJ)) {
            putBody("installedPackageName", aVar.aCJ);
        }
        if (!bp.isNullString(aVar.aCI)) {
            putBody("serverPackageName", aVar.aCI);
        }
        int i11 = aVar.aCL;
        if (i11 > 0) {
            putBody("closeButtonClickTime", i11);
        }
        int i12 = aVar.aCK;
        if (i12 > 0) {
            putBody("closeButtonImpressionTime", i12);
        }
        int i13 = aVar.downloadStatus;
        if (i13 >= 0) {
            putBody("downloadStatus", i13);
        }
        long j = aVar.aCM;
        if (j > 0) {
            putBody("landingPageLoadedDuration", j);
        }
        long j2 = aVar.Ql;
        if (j2 > 0) {
            putBody("leaveTime", j2);
        }
        long j3 = aVar.aCN;
        if (j3 > 0) {
            putBody("adItemClickBackDuration", j3);
        }
        int i14 = aVar.aCz;
        if (i14 != -1) {
            putBody("retainCodeType", i14);
        }
        long j4 = aVar.aCr;
        if (j4 > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, j4);
        }
        int i15 = aVar.aCs;
        if (i15 >= 0 || i15 == -9999) {
            putBody("impFailReason", i15);
        }
        long j5 = aVar.aCt;
        if (j5 > -1 || j5 == -9999) {
            putBody("winEcpm", j5);
        }
        int i16 = aVar.adnType;
        if (i16 > 0 || i16 == -9999) {
            putBody("adnType", i16);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (!TextUtils.isEmpty(aVar.aCu)) {
            putBody("adnAdvertiser", aVar.aCu);
        }
        if (!TextUtils.isEmpty(aVar.aCv)) {
            putBody("adnTitle", aVar.aCv);
        }
        if (!TextUtils.isEmpty(aVar.aCw)) {
            putBody("adnRequestId", aVar.aCw);
        }
        putBody("adnShowType", aVar.aCx);
        putBody("adnClickType", aVar.aCy);
        putBody("adnMaterialType", aVar.adnMaterialType);
        if (!TextUtils.isEmpty(aVar.adnMaterialUrl)) {
            putBody("adnMaterialUrl", aVar.adnMaterialUrl);
        }
        putBody("downloadCardType", aVar.aCQ);
        putBody("landingPageType", aVar.UO);
        int i17 = aVar.PH;
        if (i17 >= 0) {
            putBody("adInterstitialSource", i17);
        }
        int i18 = aVar.aCU;
        if (i18 > 0) {
            putBody("downloadInstallType", i18);
        }
        int i19 = aVar.aCW;
        if (i19 != 0) {
            putBody("fingerSwipeType", i19);
        }
        int i20 = aVar.aCX;
        if (i20 != 0) {
            putBody("fingerSwipeDistance", i20);
        }
        int i21 = aVar.aCV;
        if (i21 > 0) {
            putBody("businessSceneType", i21);
        }
        long j6 = aVar.yY;
        if (j6 > 0) {
            putBody("playedDuration", j6);
        }
        int i22 = aVar.aCR;
        if (i22 > 0) {
            putBody("playedRate", i22);
        }
        int i23 = aVar.aCO;
        if (i23 != -1) {
            putBody("appStorePageType", i23);
        }
        int i24 = aVar.PL;
        if (i24 != -1) {
            putBody("triggerType", i24);
        }
        int i25 = aVar.PK;
        if (i25 != 0) {
            putBody("photoSizeStyle", i25);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String replaceFirst;
        Context context = ServiceProvider.getContext();
        AdInfo er = e.er(this.mAdTemplate);
        int i = this.aBq;
        if (i == 1) {
            String str = er.adBaseInfo.showUrl;
            replaceFirst = ((this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).Dn()) ? str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aS(e.er(this.mAdTemplate)))) : str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm))).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.aBr);
            a(replaceFirst, this.mAdTemplate, this.aBr);
        } else if (i == 2) {
            replaceFirst = aj.ar(context, aj.a(er.adBaseInfo.clickUrl, this.aBr.mJ)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.aBr);
            a(replaceFirst, this.mAdTemplate, this.aBr);
        } else {
            replaceFirst = er.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.aBr);
        }
        Gl();
        return replaceFirst;
    }

    private void a(String str, AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i = adTemplate.mInitVoiceStatus;
        if (i != 0) {
            putBody("initVoiceStatus", i);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        int i2 = aVar.aCH;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        if (TextUtils.isEmpty(aVar.PI)) {
            return;
        }
        putBody("payload", aVar.PI);
    }
}
