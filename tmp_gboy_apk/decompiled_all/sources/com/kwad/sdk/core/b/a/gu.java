package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.commercial.j.a;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.h.a;
import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdCouponReceiveParam;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import com.kwad.sdk.o.l;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class gu {
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> aIE;

    static {
        HashMap hashMap = new HashMap();
        aIE = hashMap;
        hashMap.put(ABParams.class, new a());
        aIE.put(FeedSlideConf.class, new eo());
        aIE.put(l.a.C0386a.class, new la());
        aIE.put(com.kwad.sdk.commercial.j.b.class, new az());
        aIE.put(com.kwad.sdk.commercial.d.b.class, new n());
        aIE.put(AdInfo.AdInsertScreenInfo.class, new z());
        aIE.put(AdInfo.AdAggregateInfo.class, new h());
        aIE.put(AdStyleInfo.PlayEndInfo.class, new iw());
        aIE.put(AdMatrixInfo.RewardWebTaskCloseInfo.class, new jt());
        aIE.put(TKAdLiveShopItemInfo.class, new lj());
        aIE.put(StatusInfo.SplashAdInfo.class, new kn());
        aIE.put(AdStyleInfo.ExposeTagInfo.class, new ef());
        aIE.put(AdMatrixInfo.BottomBannerInfo.class, new cd());
        aIE.put(com.kwad.sdk.core.network.i.class, new ie());
        aIE.put(AdInfo.NativeAdShakeInfo.class, new hu());
        aIE.put(AdMatrixInfo.class, new al());
        aIE.put(AdMatrixInfo.InnerEcAuthInfo.class, new fy());
        aIE.put(AdMatrixInfo.Styles.class, new li());
        aIE.put(com.kwad.sdk.core.request.model.d.class, new id());
        aIE.put(AdMatrixInfo.CycleAggregateInfo.class, new di());
        aIE.put(AdInfo.ComplianceInfo.class, new cq());
        aIE.put(AdMatrixInfo.SplashEndCardTKInfo.class, new ko());
        aIE.put(AdMatrixInfo.RewardVideoTaskInfo.class, new js());
        aIE.put(com.kwad.sdk.core.threads.d.class, new lt());
        aIE.put(AdInfo.class, new y());
        aIE.put(AdInfo.SmallAppJumpInfo.class, new kj());
        aIE.put(AdGlobalConfigInfo.RefreshToken.class, new jh());
        aIE.put(PhotoInfo.VideoInfo.class, new mg());
        aIE.put(VideoPlayerStatus.class, new ml());
        aIE.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new dn());
        aIE.put(com.kwad.sdk.commercial.a.b.class, new bj());
        aIE.put(AdInfo.AdSplashInfo.class, new ar());
        aIE.put(AdGlobalConfigInfo.class, new w());
        aIE.put(AdInfo.PlayableStyleInfo.class, new ja());
        aIE.put(com.kwad.sdk.h.a.a.class, new ik());
        aIE.put(AdInfo.FullScreenVideoInfo.class, new fa());
        aIE.put(AdStyleInfo.PlayDetailInfo.DrawAdInfo.class, new dw());
        aIE.put(AdStyleInfo.class, new au());
        aIE.put(com.kwad.sdk.core.request.model.g.class, new me());
        aIE.put(AdMatrixInfo.RotateDegreeInfo.class, new jv());
        aIE.put(AdMatrixInfo.StyleComponentInfo.class, new lg());
        aIE.put(NativeAdExtraDataImpl.class, new hr());
        aIE.put(AdMatrixInfo.SplashSlideInfo.class, new kx());
        aIE.put(CouponInfo.class, new de());
        aIE.put(AdInfo.AdConversionInfo.class, new m());
        aIE.put(AdInfo.CutRuleInfo.class, new dh());
        aIE.put(AdInfo.DownloadSafeInfo.class, new dt());
        aIE.put(AdMatrixInfo.AdDataV2.class, new s());
        aIE.put(AdStyleInfo.AdBrowseInfo.class, new l());
        aIE.put(PhotoInfo.BaseInfo.class, new bx());
        aIE.put(AdMatrixInfo.SplashPlayCardTKInfo.class, new kt());
        aIE.put(HybridLoadMsg.class, new ft());
        aIE.put(ImageLoaderInfo.class, new fw());
        aIE.put(AdInfo.MaterialSize.class, new hk());
        aIE.put(StatusInfo.NativeAdStyleControl.class, new hv());
        aIE.put(AdMatrixInfo.NativeMatrixAdInfo.class, new hx());
        aIE.put(com.kwad.sdk.core.threads.b.class, new ls());
        aIE.put(AdInfo.AdvertiserInfo.class, new bc());
        aIE.put(AdInfo.H5Config.class, new fk());
        aIE.put(AdInfo.AdDrawInfo.class, new t());
        aIE.put(AdMatrixInfo.ActionBarInfoNew.class, new d());
        aIE.put(AdMatrixInfo.ActivityMiddlePageInfo.class, new g());
        aIE.put(com.kwad.sdk.commercial.i.a.class, new hg());
        aIE.put(com.kwad.sdk.core.network.j.class, new Cif());
        aIE.put(StatusInfo.SplashStyleControl.class, new ky());
        aIE.put(AdMatrixInfo.SplashInfo.class, new kq());
        aIE.put(AdInfo.AdFeedInfo.class, new u());
        aIE.put(SplashExtraDataImpl.class, new kp());
        aIE.put(AdProductInfo.SpikeInfo.class, new kl());
        aIE.put(AdProductInfo.class, new ao());
        aIE.put(AdInfo.UnDownloadConf.class, new lz());
        aIE.put(AdMatrixInfo.StyleInfo.class, new lh());
        aIE.put(AdMatrixInfo.SlideInfo.class, new ki());
        aIE.put(AdMatrixInfo.RewardVideoInteractInfo.class, new jr());
        aIE.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new c());
        aIE.put(AdStyleInfo.FeedAdInfo.class, new ej());
        aIE.put(com.kwad.sdk.core.request.model.f.class, new ln());
        aIE.put(AdInfo.AdShowVideoH5Info.class, new aq());
        aIE.put(AdMatrixInfo.BaseMatrixTemplate.class, new bz());
        aIE.put(AdStyleInfo.ExtraDisplayInfo.class, new eh());
        aIE.put(AdInfo.RewardFraudVerifyInfo.class, new jl());
        aIE.put(HttpDnsInfo.class, new fs());
        aIE.put(AdInfo.AdStyleConfInfo.class, new at());
        aIE.put(AdVideoPreCacheConfig.class, new ba());
        aIE.put(AdMatrixInfo.AdInteractionInfo.class, new aa());
        aIE.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new Cdo());
        aIE.put(AdMatrixInfo.DynamicAdStyleInfo.class, new dz());
        aIE.put(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo.class, new hc());
        aIE.put(URLPackage.class, new lx());
        aIE.put(AdInfo.AdBannerInfo.class, new i());
        aIE.put(AdGlobalConfigInfo.NeoScanAggregationSceneInfo.class, new ia());
        aIE.put(AdInfo.AdPreloadInfo.class, new an());
        aIE.put(PhotoInfo.class, new it());
        aIE.put(AdInfo.UnDownloadRegionConf.class, new ma());
        aIE.put(com.kwad.sdk.commercial.e.c.class, new r());
        aIE.put(StatusInfo.class, new le());
        aIE.put(AdCouponReceiveParam.class, new p());
        aIE.put(AdStyleInfo.PlayDetailInfo.PatchEcInfo.class, new is());
        aIE.put(com.kwad.sdk.commercial.g.b.class, new fn());
        aIE.put(AdInfo.AdConversionInfo.DeeplinkItemInfo.class, new dl());
        aIE.put(AdMatrixInfo.FullScreenInfo.class, new ez());
        aIE.put(com.kwad.sdk.commercial.e.b.class, new q());
        aIE.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new eb());
        aIE.put(TemplateConfig.class, new lp());
        aIE.put(AdMatrixInfo.ComponentTemplateInfo.class, new cs());
        aIE.put(com.kwad.sdk.core.config.d.class, new im());
        aIE.put(AdTemplate.class, new aw());
        aIE.put(com.kwad.sdk.commercial.f.b.class, new dm());
        aIE.put(AdLabelImpl.class, new ab());
        aIE.put(com.kwad.sdk.commercial.c.a.class, new by());
        aIE.put(SceneImpl.class, new kb());
        aIE.put(AdInfo.CallBackStrategyInfo.class, new cf());
        aIE.put(AdMatrixInfo.MatrixTemplate.class, new hm());
        aIE.put(AdStatusInfo.class, new as());
        aIE.put(AdMatrixInfo.InstalledActivateInfo.class, new gg());
        aIE.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new bb());
        aIE.put(StatusInfo.NativeAdRequestInfo.class, new ht());
        aIE.put(AdGlobalConfigInfo.CycleAggregationInfo.class, new dj());
        aIE.put(AdInfo.NativeAdInfo.class, new hs());
        aIE.put(a.C0351a.class, new lw());
        aIE.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new hi());
        aIE.put(AdInfo.AdLiveTypeInfo.class, new af());
        aIE.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new dp());
        aIE.put(com.kwad.sdk.commercial.smallApp.b.class, new kk());
        aIE.put(AdMatrixInfo.SplashActionBarInfo.class, new km());
        aIE.put(AdMatrixInfo.MerchantLiveReservationInfo.class, new hn());
        aIE.put(AdMatrixInfo.ComponentParam.class, new cr());
        aIE.put(AdInfo.RewardRetryTaskInfo.class, new jq());
        aIE.put(com.kwad.sdk.h.a.b.class, new il());
        aIE.put(WebViewCommercialMsg.class, new mt());
        aIE.put(AdInfo.AdRewardInfo.class, new ap());
        aIE.put(AdMatrixInfo.TemplateData.class, new lr());
        aIE.put(PageInfo.class, new io());
        aIE.put(AdMatrixInfo.InterstitialCardInfo.class, new gk());
        aIE.put(AdMatrixInfo.NeoVideoInfo.class, new ic());
        aIE.put(AdMatrixInfo.ShakeInfo.class, new kc());
        aIE.put(AdMatrixInfo.MatrixTag.class, new hl());
        aIE.put(AdInfo.AdMaterialInfo.class, new ak());
        aIE.put(WebViewLoadMsg.class, new mu());
        aIE.put(AdInfo.AdTrackInfo.class, new ax());
        aIE.put(AdMatrixInfo.FeedInfo.class, new el());
        aIE.put(com.kwad.sdk.utils.b.a.class, new gz());
        aIE.put(AdInfo.AdBaseInfo.class, new j());
        aIE.put(AdMatrixInfo.RotateInfo.class, new jw());
        aIE.put(com.kwad.sdk.core.request.model.b.class, new dq());
        aIE.put(SDKInitMsg.class, new jx());
        aIE.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new mv());
        aIE.put(a.C0365a.class, new ll());
        aIE.put(AdMatrixInfo.EndCardInfo.class, new ea());
        aIE.put(AdMatrixInfo.DownloadTexts.class, new dv());
        aIE.put(AdStyleInfo.PlayDetailInfo.class, new iu());
        aIE.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new ir());
        aIE.put(com.kwad.sdk.commercial.b.b.class, new bn());
        aIE.put(com.kwad.sdk.core.report.j.class, new ec());
        aIE.put(l.a.class, new mw());
        aIE.put(AdMatrixInfo.AggregationCardInfo.class, new bd());
        aIE.put(HttpDnsInfo.IpInfo.class, new go());
        aIE.put(WebCloseStatus.class, new ms());
        aIE.put(AdMatrixInfo.PreLandingPageTKInfo.class, new jc());
        Je();
        UwzTMMd();
    }

    @ForInvoker(methodId = "registerHolder")
    private static void Je() {
        ct.Je();
        cu.Je();
        cv.Je();
        cw.Je();
        cx.Je();
        cy.Je();
        cz.Je();
        da.Je();
        db.Je();
        dc.Je();
        es.Je();
        et.Je();
        eu.Je();
        ev.Je();
        ew.Je();
        ex.Je();
    }

    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> Jf() {
        return aIE;
    }

    private static /* synthetic */ void UwzTMMd() {
        char[] charArray = "ÅÉË\u0088ÁÇËÃ\u0088ÄÉß\u0088ÕÎÃÊÊ\u0088ìÈÏäÔÏÂÁÃ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 166);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÅÊÏÈÏÒ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 166);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.kwad.sdk.core.d getHolder(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        return aIE.get(cls);
    }
}
