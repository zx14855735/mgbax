package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.t;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
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
public final class f {
    public static void a(KsScene ksScene, final e eVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        com.kwad.components.ad.reward.monitor.d.a(false, covert.getPosId());
        boolean b = t.uI().b(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.M().a(new a.C0312a().e(new ImpInfo(covert)).aQ(b).a(new j() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.j
            public final void ah() {
                com.kwad.components.ad.reward.monitor.d.b(false, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.e() { // from class: com.kwad.components.ad.fullscreen.f.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.d.a(false, i, str, SceneImpl.this.getPosId());
                if (i != com.kwad.sdk.core.network.e.aJc.errorCode && i != com.kwad.sdk.core.network.e.aIX.errorCode) {
                    com.kwad.components.ad.reward.monitor.c.c(false, i);
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        eVar.onError(i, str);
                    }
                });
            }

            public static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z) {
                anonymousClass1.aaL = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                com.kwad.components.ad.reward.monitor.d.c(false, SceneImpl.this.posId);
                List<AdTemplate> a2 = f.a(SceneImpl.this, adResultData.getAdTemplateList());
                if (a2.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg);
                    k.ar("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Dz());
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : a2) {
                    arrayList.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.e.a(adTemplate, z, obtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) a2.get(0);
                com.kwad.components.ad.reward.monitor.d.a(false, adTemplate2, a2.size(), elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, a2.size());
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            z.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
                com.kwad.components.ad.reward.monitor.d.d(false, adTemplate2);
                final boolean HU = com.kwad.sdk.core.config.e.HU();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    final KsFullScreenVideoAd ksFullScreenVideoAd = (KsFullScreenVideoAd) it.next();
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate3);
                    if (!com.kwad.sdk.core.response.b.a.be(er) && !com.kwad.sdk.core.response.b.a.cS(er)) {
                        com.kwad.components.ad.d.b.a(adTemplate3, false, obtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void af() {
                                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                                f.a(adTemplate2, eVar, arrayList2);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void ag() {
                                if (!HU || AnonymousClass1.this.aaL) {
                                    return;
                                }
                                f.a(adTemplate2, eVar, arrayList);
                            }
                        });
                    } else {
                        arrayList2.add(ksFullScreenVideoAd);
                        this.aaL = true;
                        f.a(adTemplate2, eVar, arrayList2);
                    }
                }
                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!HU && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aJd;
                    onError(eVar2.errorCode, eVar2.msg);
                    k.ar("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.d.c(false, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
            }
        }).tR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final e eVar, final List<KsFullScreenVideoAd> list) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                k.ar("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.M().b(list);
                eVar.b(adTemplate, list);
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
                    if (1 == com.kwad.sdk.core.response.b.a.bf(er) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(er))) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.be(er)) {
                        arrayList.add(adTemplate);
                    } else if (com.kwad.sdk.core.response.b.a.cS(er)) {
                        arrayList.add(adTemplate);
                    }
                }
            }
        }
        return arrayList;
    }
}
