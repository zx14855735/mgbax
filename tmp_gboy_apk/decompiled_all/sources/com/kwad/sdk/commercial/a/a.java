package com.kwad.sdk.commercial.a;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void bj(AdTemplate adTemplate) {
        a(adTemplate, b.FI().cN(3).setAdTemplate(adTemplate));
    }

    public static void bk(AdTemplate adTemplate) {
        a(adTemplate, b.FI().cN(4).setAdTemplate(adTemplate));
    }

    public static void bl(AdTemplate adTemplate) {
        a(adTemplate, b.FI().cN(5).setAdTemplate(adTemplate));
    }

    public static void bm(AdTemplate adTemplate) {
        h(adTemplate, 100002, "");
    }

    public static void bn(AdTemplate adTemplate) {
        a(adTemplate, b.FI().cN(7).cO(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate));
    }

    public static void bo(AdTemplate adTemplate) {
        int i = 2;
        b cO = b.FI().cN(8).cO(adTemplate.mInstallApkFormUser ? 1 : 2);
        if (adTemplate.mInstallApkFromSDK) {
            i = 1;
        } else if (!adTemplate.mClickOpenAppStore) {
            i = 0;
        }
        a(adTemplate, cO.cP(i).setAdTemplate(adTemplate));
    }

    public static void bp(AdTemplate adTemplate) {
        a(adTemplate, b.FI().cN(10).cP(adTemplate.mInstallApkFromSDK ? 1 : adTemplate.mClickOpenAppStore ? 2 : 0).setAdTemplate(adTemplate));
    }

    public static void h(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.FI().cN(6).setAdTemplate(adTemplate).setErrorCode(i).setErrorMsg(str));
    }

    public static void i(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.FI().cN(9).cO(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }

    public static void k(AdTemplate adTemplate, long j) {
        a(adTemplate, b.FI().cN(2).ar(j).setAdTemplate(adTemplate));
    }

    public static void x(AdTemplate adTemplate) {
        a(adTemplate, b.FI().cN(1).setAdTemplate(adTemplate));
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            c.d(d.FH().cR(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.1d).b(e.bh(adTemplate)).O("ad_sdk_download_performance", "status").z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
