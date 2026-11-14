package com.kwad.components.core.e.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    private static int E(AdInfo adInfo) {
        com.kwad.sdk.core.download.a.J(adInfo);
        return 3;
    }

    private static int a(a.C0291a c0291a, AdTemplate adTemplate, Context context) {
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0304a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aK(c0291a.px()).aQ(1).rV());
        a.d(adTemplate, 14);
        return 14;
    }

    private static int b(a.C0291a c0291a) {
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0304a().aI(com.kwad.sdk.core.response.b.b.cR(adTemplate)).aG(adTemplate).aJ(true).rV());
        a.d(adTemplate, 20);
        return 20;
    }

    private static int d(final AdTemplate adTemplate, AdInfo adInfo) {
        h.execute(new bg() { // from class: com.kwad.components.core.e.d.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
        as.av(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.az(adInfo));
        return 6;
    }

    private static boolean j(a.C0291a c0291a) {
        AdTemplate adTemplate = c0291a.getAdTemplate();
        boolean l = com.kwad.sdk.utils.e.l(c0291a.getContext(), adTemplate);
        if (l) {
            t(c0291a);
            a.d(adTemplate, 11);
        }
        return l;
    }

    public static int q(a.C0291a c0291a) {
        e.aC(false);
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (c0291a.pA()) {
            return b(c0291a);
        }
        int F = e.F(c0291a);
        if (F == 1) {
            t(c0291a);
            return 13;
        }
        if (F == 2) {
            return 16;
        }
        int s = s(c0291a);
        if (s == 1) {
            return 12;
        }
        if (s == 2) {
            return 17;
        }
        if (!com.kwad.sdk.core.response.b.a.aG(er)) {
            if (adTemplate.isWebViewDownload) {
                int a2 = a(c0291a, adTemplate, er);
                t(c0291a);
                adTemplate.isWebViewDownload = false;
                return a2;
            }
            if (j(c0291a)) {
                return 11;
            }
            t(c0291a);
            return a(c0291a, adTemplate, context);
        }
        if (c0291a.pM() == 2 || c0291a.pM() == 1) {
            c0291a.av(false);
            t(c0291a);
            return a(c0291a, adTemplate, er);
        }
        if (!c0291a.pH() || !com.kwad.sdk.core.response.b.a.b(er, com.kwad.sdk.core.config.e.Hc()) || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aT(er)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
            t(c0291a);
            c0291a.av(true);
            return a(c0291a, adTemplate, er);
        }
        int u = c0291a.ik().u(c0291a);
        if (u == 0) {
            t(c0291a);
            return a(c0291a, adTemplate, context);
        }
        t(c0291a);
        a.d(adTemplate, u);
        return u;
    }

    private static int r(a.C0291a c0291a) {
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        if (com.kwad.sdk.utils.e.a(context, com.kwad.sdk.core.response.b.a.cX(er), adTemplate) || a(c0291a, adTemplate)) {
            return 11;
        }
        if (ao.isNetworkConnected(context)) {
            return E(er);
        }
        ac.S(context, ae.cZ(context));
        return 2;
    }

    private static int s(a.C0291a c0291a) {
        Context context = c0291a.getContext();
        AdTemplate adTemplate = c0291a.getAdTemplate();
        int f = f.f(context, adTemplate);
        if (f == 1) {
            t(c0291a);
            a.d(adTemplate, 12);
        }
        return f;
    }

    private static void t(a.C0291a c0291a) {
        if (c0291a.pw() != null) {
            try {
                c0291a.pw().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    private static int a(a.C0291a c0291a, AdTemplate adTemplate, AdInfo adInfo) {
        int r;
        d ik = c0291a.ik();
        ik.pW();
        switch (adInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                r = r(c0291a);
                break;
            case 2:
            case 3:
            case 10:
            default:
                r = 0;
                break;
            case 4:
                r = ik.qe();
                break;
            case 8:
            case 9:
            case 11:
                r = ik.qb();
                break;
            case 12:
                r = d(adTemplate, adInfo);
                break;
        }
        a.d(c0291a.getAdTemplate(), r);
        return r;
    }

    private static boolean a(a.C0291a c0291a, AdTemplate adTemplate) {
        return com.kwad.sdk.utils.e.l(c0291a.getContext(), adTemplate);
    }
}
