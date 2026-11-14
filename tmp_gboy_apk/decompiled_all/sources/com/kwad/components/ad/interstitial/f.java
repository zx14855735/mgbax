package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.t;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class f {
    public static void loadInterstitialAd(KsScene ksScene, final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!l.DP().CW()) {
            com.kwad.sdk.core.d.c.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    KsLoadManager.InterstitialAdListener.this.onError(com.kwad.sdk.core.network.e.aJc.errorCode, com.kwad.sdk.core.network.e.aJc.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        boolean b = t.uI().b(covert, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(23);
        com.kwad.components.ad.interstitial.report.c.eT().m(covert.getPosId());
        KsAdLoadManager.M().a(new a.C0312a().e(new ImpInfo(covert)).aQ(b).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.interstitial.f.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg);
                    k.ar("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.2.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class);
                        adTemplateList.get(0);
                        com.kwad.sdk.core.response.b.e.er(adTemplateList.get(0));
                    }
                } catch (Exception unused) {
                }
                com.kwad.components.ad.interstitial.report.c.eT().a(adTemplateList.get(0), z);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, adTemplateList.size());
                SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                if (com.kwad.sdk.core.response.b.c.u(adResultData)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (AdTemplate adTemplate : adTemplateList) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = SceneImpl.this;
                            }
                            String L = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.er(adTemplate));
                            if (!com.kwad.sdk.core.response.b.b.dm(adTemplate)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.eX();
                                com.kwad.components.ad.interstitial.report.realtime.a.F(adTemplate);
                            }
                            if (TextUtils.isEmpty(L)) {
                                arrayList2.add(adTemplate);
                            } else {
                                boolean s = com.kwad.components.ad.interstitial.a.a.s(adTemplate);
                                if (com.kwad.sdk.core.config.e.GJ() || s) {
                                    arrayList2.add(adTemplate);
                                }
                            }
                        }
                    }
                    adResultData.setAdTemplateList(arrayList2);
                    arrayList.add(e.f(adResultData));
                } else {
                    for (AdTemplate adTemplate2 : adTemplateList) {
                        if (adTemplate2 != null) {
                            if (adTemplate2.mAdScene == null) {
                                adTemplate2.mAdScene = SceneImpl.this;
                            }
                            String L2 = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.er(adTemplate2));
                            if (!com.kwad.sdk.core.response.b.b.dm(adTemplate2)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.eX();
                                com.kwad.components.ad.interstitial.report.realtime.a.F(adTemplate2);
                            }
                            AdResultData a2 = com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate2);
                            if (TextUtils.isEmpty(L2)) {
                                arrayList.add(e.f(a2));
                            } else {
                                boolean s2 = com.kwad.components.ad.interstitial.a.a.s(adTemplate2);
                                if (com.kwad.sdk.core.config.e.GJ() || s2) {
                                    arrayList.add(e.f(a2));
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() != 0) {
                    com.kwad.components.ad.interstitial.report.c.eT().b(adTemplateList.get(0), z);
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.2.3
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            KsAdLoadManager.M().b(arrayList);
                            k.ar("insertAd_", "onInterstitialAdCacheSuccess");
                            interstitialAdListener.onInterstitialAdLoad(arrayList);
                        }
                    });
                } else {
                    onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg);
                    com.kwad.components.ad.interstitial.report.realtime.a.eX();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.aJc);
                    k.ar("insertAd_", "onInterstitialAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.interstitial.report.c.eT().a(i, str, SceneImpl.this.getPosId());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.interstitial.f.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        interstitialAdListener.onError(i, str);
                    }
                });
            }
        }).tR());
    }
}
