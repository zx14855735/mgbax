package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bp;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    private static Random aNB = new Random();

    static {
        CNoYqaK();
    }

    private static /* synthetic */ void CNoYqaK() {
        char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'i');
        }
        String str = new String(charArray);
        char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'i');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int a(boolean z, AdInfo adInfo) {
        return z ? adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType : adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    public static String cA(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        boolean z = e.eL(adTemplate) || e.el(adTemplate) == 2;
        if (a.cS(er)) {
            return "";
        }
        if (z && a.cs(adTemplate)) {
            AdMatrixInfo.MatrixTemplate k = k(adTemplate, dx(adTemplate).templateId);
            return k != null ? k.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate k2 = k(adTemplate, cz(adTemplate).templateId);
        return k2 != null ? k2.templateUrl : "";
    }

    public static long cB(AdTemplate adTemplate) {
        return cz(adTemplate).maxTimeOut;
    }

    public static boolean cC(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cA(adTemplate));
    }

    private static AdMatrixInfo.AggregationCardInfo cD(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.aggregationCardInfo;
    }

    public static String cE(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cD(adTemplate).templateId);
        return k != null ? k.templateUrl : "";
    }

    public static long cF(AdTemplate adTemplate) {
        return m(adTemplate, cD(adTemplate).templateId);
    }

    public static long cG(AdTemplate adTemplate) {
        return cD(adTemplate).changeTime * 1000;
    }

    public static int cH(AdTemplate adTemplate) {
        return cD(adTemplate).maxTimesPerDay;
    }

    public static long cI(AdTemplate adTemplate) {
        return cD(adTemplate).intervalTime;
    }

    public static boolean cJ(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        return !a.aG(er) && a.au(er);
    }

    public static boolean cK(AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cE(adTemplate)) && cF(adTemplate) > 0) {
            return aq.isOrientationPortrait();
        }
        return false;
    }

    private static AdMatrixInfo.BaseMatrixTemplate cL(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.halfCardInfo;
    }

    public static String cM(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cL(adTemplate).templateId);
        return k != null ? k.templateUrl : "";
    }

    private static AdMatrixInfo.EndCardInfo cN(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.endCardInfo;
    }

    public static String cO(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cN(adTemplate).templateId);
        return k != null ? k.templateUrl : "";
    }

    public static boolean cP(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cO(adTemplate));
    }

    private static String cQ(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, e.er(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return k != null ? k.templateUrl : "";
    }

    public static String cR(AdTemplate adTemplate) {
        return cS(adTemplate) ? cQ(adTemplate) : a.aT(e.er(adTemplate));
    }

    private static boolean cS(AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.cq(adTemplate) || !dH(e.er(adTemplate))) ? false : true;
    }

    private static AdMatrixInfo.FeedInfo cT(AdTemplate adTemplate) {
        return cV(adTemplate) ? ct(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo : ct(adTemplate).adDataV2.feedInfo;
    }

    private static AdMatrixInfo.NativeMatrixAdInfo cU(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.nativeAdInfo;
    }

    private static boolean cV(AdTemplate adTemplate) {
        return a.cS(e.er(adTemplate));
    }

    private static AdMatrixInfo.FeedInfo cW(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    public static String cX(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cT(adTemplate).templateId);
        return k != null ? k.templateUrl : "";
    }

    private static AdMatrixInfo.FeedTKInfo cY(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.feedTKCardInfo;
    }

    public static String cZ(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cW(adTemplate).templateId);
        return k != null ? k.templateUrl : "";
    }

    public static AdMatrixInfo ct(AdTemplate adTemplate) {
        return e.ej(adTemplate) ? e.er(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cu(AdTemplate adTemplate) {
        return ct(adTemplate).styles.templateList;
    }

    public static AdMatrixInfo.AdDataV2 cv(AdTemplate adTemplate) {
        return e.er(adTemplate).adMatrixInfo.adDataV2;
    }

    public static FeedSlideConf cw(AdTemplate adTemplate) {
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData l = l(adTemplate, cT(adTemplate).templateId);
        try {
            JSONObject optJSONObject = new JSONObject(l != null ? l.data : "").optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("angle")) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static AdMatrixInfo.InterstitialCardInfo cx(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static String cy(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, ct(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return k != null ? k.templateUrl : "";
    }

    private static AdMatrixInfo.ActionBarInfoNew cz(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.actionBarInfo;
    }

    public static long dA(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int dB(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static boolean dC(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dD(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dE(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dF(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dG(AdInfo adInfo) {
        if (dH(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dH(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dI(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String dJ(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.subtitle;
        } catch (Exception unused) {
            return "摇一摇";
        }
    }

    public static long dK(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dL(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dM(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dN(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dO(AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 1;
        }
    }

    public static boolean dP(AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean dQ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dR(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int dS(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean dT(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean dU(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean dV(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean dW(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean dX(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean dY(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean dZ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 10;
    }

    public static boolean da(AdTemplate adTemplate) {
        return cT(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    public static boolean db(AdTemplate adTemplate) {
        return cT(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    public static int dc(AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cT(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    public static boolean dd(AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cU(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return false;
        }
        return shakeInfo.enable;
    }

    public static int de(AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cU(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    public static double df(AdTemplate adTemplate) {
        return e.er(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean dg(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cX(adTemplate));
    }

    public static boolean dh(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cY(adTemplate).templateId);
    }

    public static boolean di(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dZ(adTemplate));
    }

    public static String dj(AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo cY = cY(adTemplate);
        return TextUtils.isEmpty(cY.templateId) ? "ksad-feed-card" : cY.templateId;
    }

    public static boolean dk(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cZ(adTemplate));
    }

    public static float dl(AdTemplate adTemplate) {
        int i;
        try {
            i = e.er(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean dm(AdTemplate adTemplate) {
        try {
            return e.er(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static float dn(AdTemplate adTemplate) {
        int i;
        try {
            i = e.er(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    /* renamed from: do, reason: not valid java name */
    public static AdMatrixInfo.RotateInfo m15do(AdTemplate adTemplate) {
        try {
            return e.er(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dp(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = cT(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dq(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = cU(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    private static AdMatrixInfo.BaseMatrixTemplate dr(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.complianceCardInfo;
    }

    public static String ds(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, dr(adTemplate).templateId);
        return k != null ? k.templateUrl : "";
    }

    public static boolean dt(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(ds(adTemplate));
    }

    private static AdMatrixInfo.BaseMatrixTemplate du(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    public static String dv(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, du(adTemplate).templateId);
        return k != null ? k.templateUrl : "";
    }

    public static boolean dw(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dv(adTemplate));
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dx(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo dy(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dz(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static boolean eO(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).cs(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ea(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 9;
    }

    public static boolean eb(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 12;
    }

    public static boolean ec(AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            return i == 4 || i == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ed(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean ee(AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static long ef(AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j <= 0) {
                return 1500L;
            }
            return j;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean eg(AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static float eh(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static float ei(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static String ej(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String ek(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String el(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String em(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts en(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts eo(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean ep(AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean eq(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static boolean er(AdInfo adInfo) {
        return (a.bL(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    public static int es(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String et(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static boolean eu(AdInfo adInfo) {
        return a.be(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    public static boolean g(AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.cY(adInfo) || a.bL(adInfo)) ? false : true;
    }

    public static AdMatrixInfo.MatrixTemplate k(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : ct(adTemplate).styles.templateList) {
            if (bp.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    private static AdMatrixInfo.TemplateData l(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : ct(adTemplate).adDataV2.templateDataList) {
            if (bp.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long m(AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l = l(adTemplate, str);
        if (l != null) {
            return l.templateDelayTime;
        }
        return 0L;
    }

    public static AdMatrixInfo.AdBannerTKInfo dC(AdTemplate adTemplate) {
        return ct(adTemplate).adDataV2.bannerTKInfo;
    }

    public static boolean dD(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        return (g(er) || e.eD(adTemplate) || cz(adTemplate).cardType == 4 || e.er(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType > 0 || er.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static boolean dE(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        return (g(er) || e.eD(adTemplate) || cz(adTemplate).cardType == 4 || e.er(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || er.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static AdMatrixInfo.PreLandingPageTKInfo dF(AdTemplate adTemplate) {
        return e.er(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static long dH(AdTemplate adTemplate) {
        long j = cv(adTemplate).installedActivateInfo.showTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }

    public static String dI(AdTemplate adTemplate) {
        return cv(adTemplate).topFloorTKInfo.templateId;
    }

    public static String dK(AdTemplate adTemplate) {
        return cv(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String dL(AdTemplate adTemplate) {
        return cv(adTemplate).videoImageTKInfo.templateId;
    }

    public static String dM(AdTemplate adTemplate) {
        return cv(adTemplate).fullScreenInfo.templateId;
    }

    public static String dN(AdTemplate adTemplate) {
        return cv(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String dP(AdTemplate adTemplate) {
        return cv(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String dQ(AdTemplate adTemplate) {
        return cv(adTemplate).bannerTKInfo.templateId;
    }

    public static String dR(AdTemplate adTemplate) {
        return cv(adTemplate).interstitialCardInfo.templateId;
    }

    public static String dS(AdTemplate adTemplate) {
        return cv(adTemplate).confirmTKInfo.templateId;
    }

    public static String dT(AdTemplate adTemplate) {
        return cv(adTemplate).activityTKInfo.templateId;
    }

    public static String dU(AdTemplate adTemplate) {
        return cv(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String dV(AdTemplate adTemplate) {
        return cv(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String dW(AdTemplate adTemplate) {
        return cv(adTemplate).pushTKInfo.templateId;
    }

    public static String dX(AdTemplate adTemplate) {
        return cv(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String dY(AdTemplate adTemplate) {
        return cv(adTemplate).feedTKCardInfo.templateId;
    }

    public static String dZ(AdTemplate adTemplate) {
        return cv(adTemplate).drawTKCardInfo.templateId;
    }

    public static boolean ea(AdTemplate adTemplate) {
        return cv(adTemplate).innerEcAuthInfo.closureAuthToastSwitch;
    }

    public static String eb(AdTemplate adTemplate) {
        return cv(adTemplate).innerEcAuthInfo.closureAuthToastText;
    }

    public static boolean dG(AdTemplate adTemplate) {
        return cv(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static String dJ(AdTemplate adTemplate) {
        return cv(adTemplate).neoTKInfo.templateId;
    }

    public static String dO(AdTemplate adTemplate) {
        return cv(adTemplate).splashPlayCardTKInfo.templateId;
    }
}
