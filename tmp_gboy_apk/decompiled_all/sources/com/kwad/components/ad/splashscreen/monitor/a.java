package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a, reason: collision with other inner class name */
    public static class C0267a {
        private static final a Gp = new a();

        static {
            gLSe();
        }

        private static /* synthetic */ void gLSe() {
            char[] charArray = "[WU\u0016_YU]\u0016ZWA\u0016KP]TT\u0016rVQzJQ\\_]".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '8');
            }
            String str = new String(charArray);
            char[] charArray2 = "[TQVQL".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '8');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private static SplashMonitorInfo ag(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        return new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setMaterialType(com.kwad.sdk.core.response.b.a.bd(er) ? 1 : 2).setAdTemplate(adTemplate);
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (l.DP().CW()) {
            com.kwad.sdk.commercial.c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_callback", "callback_type").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        }
    }

    private static void e(com.kwad.sdk.commercial.c.a aVar) {
        if (l.DP().CW()) {
            com.kwad.sdk.commercial.c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_action", "action_type").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
        }
    }

    public static a mi() {
        return C0267a.Gp;
    }

    public final void ah(AdTemplate adTemplate) {
        d(ag(adTemplate).setCallbackType(2));
    }

    public final void ai(AdTemplate adTemplate) {
        d(ag(adTemplate).setCallbackType(5));
    }

    public final void aj(AdTemplate adTemplate) {
        e(ag(adTemplate).setActionType(1));
    }

    public final void ak(AdTemplate adTemplate) {
        e(ag(adTemplate).setActionType(2));
    }

    public final void t(long j) {
        d(new SplashMonitorInfo().setCallbackType(4).setPosId(j));
    }

    public final void v(AdTemplate adTemplate) {
        d(ag(adTemplate).setCallbackType(1));
    }

    public final void w(AdTemplate adTemplate) {
        d(ag(adTemplate).setCallbackType(3));
    }
}
