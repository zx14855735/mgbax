package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class d {

    public static class a {
        private static final d nO = new d();

        static {
            HxXW();
        }

        private static /* synthetic */ void HxXW() {
            char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'g');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'g');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.FH().cR(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_interstitial_play", "status").b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static d eV() {
        return a.nO;
    }

    public final void E(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, long j) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.eB(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(e.er(adTemplate))).setVideoDuration(com.kwad.sdk.core.response.b.a.M(r0) * 1000).setPlayStartedDuration(j).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, int i, String str) {
        AdInfo er = e.er(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(er)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.M(er) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }
}
