package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.api.model.liveModel.KsCouponInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveBaseInfo;
import com.kwad.sdk.api.model.liveModel.KsLiveShopInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private static g KJ() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.xQ();
        }
        return null;
    }

    public static boolean O(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo er = er(adTemplate);
        return (a.aG(er) || a.cY(er) || ez(adTemplate) != 3) ? false : true;
    }

    public static AdTemplate a(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (b(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j, int i) {
        AdTemplate a2 = a(list, j, i);
        if (a2 == null) {
            return false;
        }
        long eB = eB(a2);
        return i > 0 ? eB == j && el(a2) == i : eB == j;
    }

    public static String eA(AdTemplate adTemplate) {
        return ej(adTemplate) ? a.cJ(er(adTemplate)) : h.c(es(adTemplate));
    }

    public static long eB(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return er(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean eC(AdTemplate adTemplate) {
        return er(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean eD(AdTemplate adTemplate) {
        int l = l(adTemplate, true);
        return l == 1 || l == 2;
    }

    public static boolean eE(AdTemplate adTemplate) {
        int l = l(adTemplate, false);
        return l == 1 || l == 2;
    }

    public static int eF(AdTemplate adTemplate) {
        return er(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean eG(AdTemplate adTemplate) {
        AdInfo er = er(adTemplate);
        return er.adStyleConfInfo.adPushDownloadJumpType == 0 && el(adTemplate) == 17 && a.aG(er);
    }

    public static int eH(AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig != null) {
            return adVideoPreCacheConfig.adVideoPreCacheSize;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar != null) {
            return hVar.Dz();
        }
        return 800;
    }

    public static KsLiveInfo eI(AdTemplate adTemplate) {
        AdInfo er = er(adTemplate);
        if (er.adBaseInfo.roiType == 0) {
            return null;
        }
        KsLiveInfo ksLiveInfo = new KsLiveInfo();
        ksLiveInfo.setRoiType(er.adBaseInfo.roiType);
        KsLiveBaseInfo ksLiveBaseInfo = ksLiveInfo.getKsLiveBaseInfo();
        String str = er.advertiserInfo.userName;
        if (str != null) {
            ksLiveBaseInfo.setUserName(str);
        }
        String str2 = er.advertiserInfo.portraitUrl;
        if (str2 != null) {
            ksLiveBaseInfo.setPortraitUrl(str2);
        }
        long j = er.adBaseInfo.liveDisplayWatchingCount;
        if (j > 0) {
            ksLiveBaseInfo.setLiveDisplayWatchingCount(j);
        }
        KsLiveShopInfo ksLiveShopInfo = new KsLiveShopInfo();
        AdProductInfo adProductInfo = er.adProductInfo;
        ksLiveShopInfo.setIcon(adProductInfo.icon);
        ksLiveShopInfo.setName(adProductInfo.name);
        ksLiveShopInfo.setPrice(adProductInfo.price);
        ksLiveShopInfo.setOriginPrice(adProductInfo.originPrice);
        ksLiveShopInfo.setVolume(adProductInfo.volume);
        List<CouponInfo> list = adProductInfo.couponList;
        if (list != null && list.size() > 0) {
            ksLiveShopInfo.setHaveCoupon(true);
        }
        ksLiveInfo.getKsLiveShopInfo().add(ksLiveShopInfo);
        KsCouponInfo ksCouponInfo = new KsCouponInfo();
        CouponInfo firstCouponList = adProductInfo.getFirstCouponList();
        if (firstCouponList != null) {
            ksCouponInfo.setDisplayBase(firstCouponList.displayBase);
            ksCouponInfo.setDisplayType(firstCouponList.displayType);
            ksCouponInfo.setDisplayValue(firstCouponList.displayValue);
            ksCouponInfo.setEndFetchTime(firstCouponList.endFetchTime);
            ksCouponInfo.setStartFetchTime(firstCouponList.startFetchTime);
            ksLiveInfo.getKsCouponInfo().add(ksCouponInfo);
        }
        return ksLiveInfo;
    }

    public static int eJ(AdTemplate adTemplate) {
        return er(adTemplate).adBaseInfo.adRolloutSize;
    }

    public static boolean eK(AdTemplate adTemplate) {
        int el = el(adTemplate);
        if (el == 13) {
            return true;
        }
        return el == 23 && eJ(adTemplate) == 2;
    }

    public static boolean eL(AdTemplate adTemplate) {
        int el = el(adTemplate);
        if (el == 3) {
            return true;
        }
        return el == 23 && eJ(adTemplate) == 1;
    }

    public static int eM(AdTemplate adTemplate) {
        return adTemplate.type;
    }

    public static int eN(AdTemplate adTemplate) {
        return adTemplate.defaultType;
    }

    public static boolean ej(AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long ek(AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int el(AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int em(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0;
        }
        SceneImpl sceneImpl = adTemplate.mAdScene;
        return (sceneImpl == null || sceneImpl.adStyle == 0) ? el(adTemplate) : sceneImpl.getAdStyle();
    }

    public static int en(AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long eo(AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String ep(AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String eq(AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    public static AdInfo er(AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo != null) {
            return adInfo;
        }
        com.kwad.sdk.core.d.c.e("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    public static PhotoInfo es(AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String et(AdTemplate adTemplate) {
        return ej(adTemplate) ? a.L(er(adTemplate)) : h.a(es(adTemplate));
    }

    public static String eu(AdTemplate adTemplate) {
        return er(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String ev(AdTemplate adTemplate) {
        g KJ = KJ();
        String KN = KJ == null ? "" : KJ.KN();
        return TextUtils.isEmpty(KN) ? KN : a.Z(er(adTemplate));
    }

    public static String ew(AdTemplate adTemplate) {
        if (ej(adTemplate)) {
            return a.cp(er(adTemplate));
        }
        g KJ = KJ();
        return KJ == null ? "" : KJ.KO();
    }

    public static long ex(AdTemplate adTemplate) {
        if (ej(adTemplate)) {
            return a.ac(er(adTemplate));
        }
        g KJ = KJ();
        return KJ == null ? adTemplate.hashCode() : KJ.KP();
    }

    public static int ey(AdTemplate adTemplate) {
        g KJ = KJ();
        if (KJ == null) {
            return 0;
        }
        return KJ.KQ();
    }

    public static int ez(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return er(adTemplate).adBaseInfo.taskType;
    }

    public static boolean k(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo er = er(adTemplate);
        return a.aG(er) && !a.cY(er) && !z && ez(adTemplate) == 2;
    }

    public static int l(AdTemplate adTemplate, boolean z) {
        AdInfo er = er(adTemplate);
        if (!eL(adTemplate)) {
            return er.adBaseInfo.mABParams.playableStyle;
        }
        int i = z ? er.adMatrixInfo.adDataV2.actionBarInfo.cardType : er.adMatrixInfo.adDataV2.endCardInfo.cardType;
        if (i == 5) {
            return 1;
        }
        return i == 6 ? 2 : -1;
    }

    public static boolean b(AdTemplate adTemplate, long j, int i) {
        long eB = eB(adTemplate);
        return i > 0 ? eB == j && el(adTemplate) == i : eB == j;
    }
}
