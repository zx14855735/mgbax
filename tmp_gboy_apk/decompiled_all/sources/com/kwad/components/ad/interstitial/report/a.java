package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.report.a$a, reason: collision with other inner class name */
    public static class C0241a {
        private static final a nL = new a();

        static {
            ldCiQR();
        }

        private static /* synthetic */ void ldCiQR() {
            char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 216);
            }
            String str = new String(charArray);
            char[] charArray2 = "»´±¶±¬".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 216);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private static void a(String str, com.kwad.sdk.commercial.c.a aVar) {
        if (l.DP().CW()) {
            try {
                com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_interstitial_callback", str).b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static a eP() {
        return C0241a.nL;
    }

    public final void b(AdTemplate adTemplate, long j, long j2) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void v(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void w(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, long j, long j2) {
        a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, double d) {
        a("action_type", new InterstitialReportInfo().setActionType(2L).setVisiblePercent(d).setAdTemplate(adTemplate));
    }
}
