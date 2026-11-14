package com.kwad.components.core.n;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    private ImpInfo SS;

    public a(ImpInfo impInfo) {
        this.SS = impInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.l
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        p(adResultData);
    }

    private static void p(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo er = e.er(adTemplate);
            if (com.kwad.sdk.core.response.b.a.be(er)) {
                if (com.kwad.sdk.core.response.b.a.bb(er).size() == 0) {
                    com.kwad.components.core.o.a.tz().f(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.b.a.bj(er) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(er))) {
                com.kwad.components.core.o.a.tz().f(adTemplate, 21006);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.l
    /* renamed from: ai */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.SS.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    @Override // com.kwad.sdk.core.network.a
    public ExecutorService getExecutor() {
        return GlobalThreadPools.Lm();
    }

    @Override // com.kwad.sdk.core.network.a
    /* renamed from: oJ */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.SS);
    }
}
