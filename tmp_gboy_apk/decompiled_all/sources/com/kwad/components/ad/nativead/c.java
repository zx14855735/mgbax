package com.kwad.components.ad.nativead;

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
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class c {
    public static void loadNativeAd(KsScene ksScene, final KsLoadManager.NativeAdListener nativeAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(covert);
        boolean b = t.uI().b(covert, "loadNativeAd");
        covert.setAdStyle(10000);
        KsAdLoadManager.M().a(new a.C0312a().e(new ImpInfo(covert)).aQ(b).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.nativead.c.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void b(AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                com.kwad.sdk.commercial.d.d.a(covert, adTemplateList.size());
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = covert;
                        arrayList.add(new d(adTemplate));
                    }
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
                try {
                    for (AdTemplate adTemplate2 : adResultData.getAdTemplateList()) {
                        if (adTemplate2 != null) {
                            com.kwad.sdk.core.response.b.e.er(adTemplate2);
                            try {
                                if (com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class) != null) {
                                    com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        KsLoadManager.NativeAdListener.this.onError(i, str);
                    }
                });
            }
        }).tR());
    }

    public static void loadNativeAd(String str, final KsLoadManager.NativeAdListener nativeAdListener) {
        if (t.uI().b(null, "loadNativeAdByJson") && t.uI().uJ() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJc;
                    nativeAdListener2.onError(eVar.errorCode, eVar.msg);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.3
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.e("KsAdNativeLoadManager", "loadNativeAd onError:".concat(AdResultData.this.result + "__" + AdResultData.this.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = AdResultData.this;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
                return;
            }
            if (adResultData.isAdResultDataEmpty()) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.4
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        KsLoadManager.NativeAdListener.this.onError(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg);
                    }
                });
                return;
            }
            final ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    arrayList.add(new d(adTemplate));
                }
            }
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.nativead.c.5
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJb;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
