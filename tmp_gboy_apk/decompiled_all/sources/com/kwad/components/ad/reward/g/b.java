package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.core.request.e;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.t;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class b {
    public static void a(KsScene ksScene, final c cVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        d.c(covert);
        com.kwad.components.ad.reward.monitor.d.a(true, covert.getPosId());
        boolean b = t.uI().b(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.M().a(new a.C0312a().e(new ImpInfo(covert)).aQ(b).a(new j() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.j
            public final void ah() {
                com.kwad.components.ad.reward.monitor.d.b(true, SceneImpl.this.posId);
            }
        }).a(new e() { // from class: com.kwad.components.ad.reward.g.b.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.d.a(true, i, str, SceneImpl.this.getPosId());
                if (i != com.kwad.sdk.core.network.e.aJc.errorCode && i != com.kwad.sdk.core.network.e.aIX.errorCode) {
                    com.kwad.components.ad.reward.monitor.c.c(true, i);
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        cVar.onError(i, str);
                    }
                });
            }

            public static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z) {
                anonymousClass1.aaL = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                com.kwad.components.ad.reward.monitor.d.c(true, SceneImpl.this.posId);
                List a2 = b.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a2.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg);
                    k.ar("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Dz());
                final ArrayList arrayList = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) a2.get(0);
                arrayList.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.e.a(adTemplate, z, obtainVideoPreCacheConfig);
                com.kwad.components.ad.reward.monitor.d.a(true, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                d.a(SceneImpl.this, a2.size());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            KsAdLoadManager.M().b(arrayList);
                            cVar.c(adTemplate, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            z.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class);
                        a2.get(0);
                        com.kwad.sdk.core.response.b.e.er((AdTemplate) a2.get(0));
                    }
                } catch (Exception unused) {
                }
                final ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.d.d(true, adTemplate);
                final boolean HU = com.kwad.sdk.core.config.e.HU();
                Iterator it = arrayList.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    final KsRewardVideoAd ksRewardVideoAd = (KsRewardVideoAd) it.next();
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate2);
                    if (!adTemplate2.isNativeRewardPreview && !com.kwad.sdk.core.response.b.a.cS(er) && !com.kwad.sdk.core.response.b.a.be(er)) {
                        com.kwad.components.ad.d.b.a(adTemplate2, true, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void af() {
                                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksRewardVideoAd);
                                b.a(adTemplate, cVar, arrayList2);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ag() {
                                if (!HU || AnonymousClass1.this.aaL) {
                                    return;
                                }
                                b.a(adTemplate, cVar, arrayList);
                            }
                        });
                    } else {
                        arrayList2.add(ksRewardVideoAd);
                        b.a(adTemplate, cVar, arrayList2);
                        z2 = true;
                    }
                }
                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!HU && !z2 && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJd;
                    onError(eVar.errorCode, eVar.msg);
                    k.ar("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.d.c(true, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
            }
        }).tR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final c cVar, final List<KsRewardVideoAd> list) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                k.ar("rewardAd_", "onRewardVideoAdCacheSuccess");
                c.this.d(adTemplate, list);
            }
        });
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
                    int bf = com.kwad.sdk.core.response.b.a.bf(er);
                    if (adTemplate.isNativeRewardPreview) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.cS(er)) {
                        arrayList.add(adTemplate);
                    } else if (1 == bf && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(er))) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.be(er)) {
                        arrayList.add(adTemplate);
                    }
                }
            }
        }
        return arrayList;
    }
}
