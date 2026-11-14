package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class n implements c {

    /* renamed from: com.kwad.components.core.c.n$1, reason: invalid class name */
    public class AnonymousClass1 extends k {
        final /* synthetic */ com.kwad.components.core.request.model.a bD;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.kwad.components.core.request.model.a aVar, com.kwad.components.core.request.model.a aVar2) {
            super(aVar);
            this.bD = aVar2;
        }

        @Override // com.kwad.components.core.c.k
        public final boolean a(final com.kwad.components.core.request.model.a aVar, final AdResultData adResultData) {
            AdResultData e;
            final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
            final int adNum = adScene.getAdNum();
            if (adResultData.isAdResultDataEmpty()) {
                GlobalThreadPools.Ll().submit(new Runnable() { // from class: com.kwad.components.core.c.n.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(adScene, adResultData, adNum, new l() { // from class: com.kwad.components.core.c.n.1.1.1
                            @Override // com.kwad.components.core.c.l
                            public final void oI() {
                                RunnableC02831 runnableC02831 = RunnableC02831.this;
                                com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                            }
                        });
                    }
                });
                return true;
            }
            if (adResultData.isBidding() && (e = m.e(aVar)) != null && !e.isAdResultDataEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(e.getProceedTemplateList());
                arrayList.addAll(adResultData.getProceedTemplateList());
                List<AdTemplate> m = n.m(arrayList);
                List<AdTemplate> subList = m.subList(0, Math.min(adNum, m.size()));
                if (subList != null && subList.size() > 0) {
                    com.kwad.components.core.request.model.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.components.core.c.k, com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public final void onError(final com.kwad.components.core.request.a aVar, final int i, final String str) {
            GlobalThreadPools.Ll().submit(new Runnable() { // from class: com.kwad.components.core.c.n.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new l() { // from class: com.kwad.components.core.c.n.1.2.1
                        @Override // com.kwad.components.core.c.l
                        public final void oI() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bD, i, str, false);
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SceneImpl sceneImpl, AdResultData adResultData, int i, l lVar) {
            AdResultData e = m.e(this.bD);
            if (e == null || e.isAdResultDataEmpty()) {
                if (lVar != null) {
                    lVar.oI();
                    return;
                }
                return;
            }
            List<AdTemplate> m = n.m(e.getProceedTemplateList());
            List<AdTemplate> subList = m.subList(0, Math.min(i, m.size()));
            if (subList.size() > 0) {
                if (adResultData == null) {
                    adResultData = new AdResultData(sceneImpl);
                }
                com.kwad.components.core.request.model.a.a(this.bD, new AdResultData(adResultData, sceneImpl, subList), false);
            }
        }
    }

    public static class a implements Comparator<AdTemplate> {
        private a() {
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int eF = com.kwad.sdk.core.response.b.e.eF(adTemplate2) - com.kwad.sdk.core.response.b.e.eF(adTemplate);
            if (eF != 0) {
                return eF;
            }
            boolean z = adTemplate.fromCache;
            if (z && adTemplate2.fromCache) {
                return 0;
            }
            return z ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static List<AdTemplate> m(List<AdTemplate> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new a((byte) 0));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : list) {
            long eB = com.kwad.sdk.core.response.b.e.eB(adTemplate);
            if (!hashSet.contains(Long.valueOf(eB))) {
                hashSet.add(Long.valueOf(eB));
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        o.a(aVar, new AnonymousClass1(aVar, aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkFirst";
    }
}
