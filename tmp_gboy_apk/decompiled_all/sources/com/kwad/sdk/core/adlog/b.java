package com.kwad.sdk.core.adlog;

import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static void Gm() {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a Gs = com.kwad.sdk.core.adlog.a.b.Gp().Gs();
                if (Gs != null) {
                    JSONObject jSONObject = Gs.aBT;
                    aa.putValue(jSONObject, "retryCount", Gs.retryCount);
                    aa.putValue(jSONObject, "cacheType", 1);
                    b.a(Gs.url, jSONObject, Gs.aBU, Gs);
                }
            }
        });
    }

    public static void a(final com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.Lq().execute(new bg() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a aVar2 = new a(com.kwad.sdk.core.adlog.c.a.this);
                b.a(aVar2.getUrl(), aVar2.getBody(), com.kwad.sdk.core.adlog.c.a.this, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static void a(String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar, com.kwad.sdk.core.adlog.a.a aVar2) {
        int i;
        AdTemplate adTemplate;
        AdTemplate adTemplate2 = aVar.adTemplate;
        int i2 = aVar.aAV;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate2, i2, aVar2);
            try {
                if (!ao.isNetworkConnected(ServiceProvider.getContext())) {
                    com.kwad.sdk.core.d.c.w("AdLogRequestManager", "no network while report log");
                    com.kwad.sdk.core.adlog.b.c.a(adTemplate2, i2, str, 100004, "no network", aVar2);
                    com.kwad.sdk.core.adlog.a.b.Gp().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                    return;
                }
                if (bw.hR(str)) {
                    com.kwad.sdk.core.adlog.b.c.b(adTemplate2, i2, str, FraudVerifyCode.RerwardFraudUnknown, "", aVar2);
                    return;
                }
                com.kwad.sdk.core.network.c doPost = g.Cm().doPost(str, (Map<String, String>) null, jSONObject);
                AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
                adLogRequestResult.parseResult(doPost.aIW);
                int i3 = doPost.code;
                ?? r8 = 200;
                try {
                    if (i3 != 200) {
                        try {
                            int cM = e.cM(i3);
                            String str2 = doPost.aIW;
                            com.kwad.sdk.core.adlog.b.c.d(adTemplate2, i2, str, cM, str2, aVar2);
                            com.kwad.sdk.core.adlog.a.b.Gp().a(aVar2, str, jSONObject, aVar, cM, str2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            r8 = adTemplate2;
                            adTemplate = r8;
                            i = i2;
                            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, "", 100000, bw.r(th), aVar2);
                            com.kwad.sdk.core.d.c.printStackTrace(th);
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }
                    if (adLogRequestResult.isResultOk()) {
                        com.kwad.sdk.core.adlog.b.c.b(adTemplate2, i2, aVar2);
                        b(aVar);
                        com.kwad.sdk.core.adlog.a.b.Gp().Gq();
                        return;
                    }
                    if (!adLogRequestResult.isCheatingFlow()) {
                        int i4 = adLogRequestResult.result;
                        String str3 = adLogRequestResult.errorMsg;
                        com.kwad.sdk.core.d.c.w("AdLogRequestManager", "request fail code:" + i4 + ", errorMsg:" + str3 + ", url=" + str);
                        com.kwad.sdk.core.adlog.b.c.c(adTemplate2, i2, str, i4, str3, aVar2);
                        com.kwad.sdk.core.adlog.a.b.Gp().a(aVar2, str, jSONObject, aVar, i4, str3);
                        return;
                    }
                    try {
                        adTemplate2.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                        com.kwad.sdk.core.adlog.b.c.c(adTemplate2, i2, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                    } catch (Throwable th2) {
                        th = th2;
                        adTemplate2 = adTemplate2;
                        i2 = i2;
                        adTemplate = adTemplate2;
                        i = i2;
                        com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, "", 100000, bw.r(th), aVar2);
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static void b(com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.e(aVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
