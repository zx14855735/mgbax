package com.kwad.components.ad.c;

import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.t;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class g {
    public static KsScene bV;

    public static void loadBannerAd(KsScene ksScene, final KsLoadManager.BannerAdListener bannerAdListener) {
        if (!l.DP().CW()) {
            com.kwad.sdk.core.d.c.e("KsAdBannerLoadManager", "loadBannerAd please init sdk first");
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    KsLoadManager.BannerAdListener.this.onError(com.kwad.sdk.core.network.e.aJc.errorCode, com.kwad.sdk.core.network.e.aJc.msg + "sdk not init");
                }
            });
            return;
        }
        ksScene.setAdNum(com.kwad.sdk.core.config.e.HY());
        bV = ksScene;
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        boolean b = t.uI().b(covert, "loadBannerAd");
        covert.setAdStyle(5);
        KsAdLoadManager.M().a(new a.C0312a().e(new ImpInfo(covert)).aQ(b).a(new j() { // from class: com.kwad.components.ad.c.g.3
            @Override // com.kwad.components.core.request.j
            public final void ah() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.g.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                List a2 = g.a(covert, adResultData.getAdTemplateList());
                if (a2.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg);
                    k.ar("bannerAd_", "onBannerAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Dz());
                final AdTemplate adTemplate = (AdTemplate) a2.get(0);
                new h(adResultData);
                com.kwad.sdk.commercial.d.d.a(covert, a2.size());
                final h hVar = new h(adResultData);
                com.kwad.sdk.core.config.e.HU();
                AdTemplate adTemplate2 = hVar.getAdTemplate();
                if (com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.er(adTemplate2))) {
                    g.a(KsLoadManager.BannerAdListener.this, hVar);
                } else {
                    com.kwad.components.ad.c.a.a.a(adTemplate2, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a.b() { // from class: com.kwad.components.ad.c.g.2.2
                        @Override // com.kwad.components.ad.c.a.b
                        public final void af() {
                            com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                            AdTemplate adTemplate3 = adTemplate;
                            g.a(KsLoadManager.BannerAdListener.this, hVar);
                        }

                        @Override // com.kwad.components.ad.c.a.b
                        public final void ag() {
                            AdTemplate adTemplate3 = adTemplate;
                            g.a(KsLoadManager.BannerAdListener.this, hVar);
                        }
                    });
                }
                com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd after cache");
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                int i2 = com.kwad.sdk.core.network.e.aJc.errorCode;
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        KsLoadManager.BannerAdListener.this.onError(i, str);
                    }
                });
            }
        }).tR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (AdTemplate adTemplate : list) {
                if (adTemplate != null) {
                    if (adTemplate.mAdScene == null) {
                        adTemplate.mAdScene = sceneImpl;
                    }
                    AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
                    if (1 == com.kwad.sdk.core.response.b.a.bf(er)) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.be(er)) {
                        arrayList.add(adTemplate);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.BannerAdListener bannerAdListener, final KsBannerAd ksBannerAd) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                k.ar("bannerAd_", "onBannerAdCacheSuccess");
                KsLoadManager.BannerAdListener.this.onBannerAdLoad(ksBannerAd);
            }
        });
    }
}
