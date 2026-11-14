package com.kwad.components.ad.draw;

import ADYaiT.CtFAbx;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.t;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, final KsLoadManager.DrawAdListener drawAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        if (covert.getAdNum() <= 0) {
            com.kwad.components.ad.draw.a.c.a(covert, "ad_num");
        }
        boolean b = t.uI().b(covert, "loadDrawAd");
        covert.setAdStyle(6);
        com.kwad.components.ad.draw.a.c.b(covert);
        com.kwad.sdk.commercial.d.d.c(covert);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        KsAdLoadManager.M().a(new a.C0312a().e(new ImpInfo(covert)).aQ(b).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void b(AdResultData adResultData) {
                com.kwad.components.ad.draw.a.c.a(SceneImpl.this, adResultData.getAdTemplateList().size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        AdInfo er = e.er(adTemplate);
                        if (adTemplate.adStyle != 6) {
                            com.kwad.components.ad.draw.a.c.h(adTemplate);
                        }
                        if (com.kwad.sdk.core.response.b.a.cS(er) || !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(er))) {
                            arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                        } else {
                            com.kwad.components.ad.draw.a.c.h(adTemplate);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? CtFAbx.B25kr6(new StringBuilder(), com.kwad.sdk.core.network.e.aJc.msg, "(无视频资源)") : adResultData.testErrorMsg);
                } else {
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.draw.d.1.2
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            KsAdLoadManager.M().b(arrayList);
                            drawAdListener.onDrawAdLoad(arrayList);
                        }
                    });
                }
                com.kwad.components.ad.draw.a.c.b(SceneImpl.this, arrayList.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                com.kwad.sdk.commercial.d.d.a(SceneImpl.this, arrayList.size());
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.draw.a.c.a(SceneImpl.this, i, str, SystemClock.elapsedRealtime() - elapsedRealtime);
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        drawAdListener.onError(i, str);
                    }
                });
            }
        }).tR());
    }
}
