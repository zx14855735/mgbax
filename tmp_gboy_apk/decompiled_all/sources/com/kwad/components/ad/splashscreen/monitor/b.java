package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.reward.A2egSU;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class b {
    private static volatile b Gq;

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        SplashMonitorInfo tkRenderType = A2egSU.A2egSU(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dB(adTemplate));
        e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(tkRenderType.setTkDefaultTimeout(h.af(adTemplate) ? com.kwad.sdk.core.response.b.b.dA(adTemplate) : com.kwad.sdk.core.response.b.b.dK(e.er(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void al(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(4).setBuriedPointOptimizeType(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGu)).setVisibleCheckDelayTime(com.kwad.sdk.core.config.e.Ie()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void am(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(200).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void an(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(201).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ao(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(204).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ap(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(205).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void aq(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(206).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ar(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(207).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void as(AdTemplate adTemplate) {
        String str;
        boolean z;
        int i;
        AdMatrixInfo.SplashPlayCardTKInfo dz = com.kwad.sdk.core.response.b.b.dz(adTemplate);
        boolean z2 = true;
        if (TextUtils.isEmpty(dz.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z = true;
        } else {
            str = "";
            z = false;
        }
        if (dz.renderType != 1) {
            str = str.concat(SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR);
            i = dz.renderType;
        } else {
            i = -1;
            z2 = z;
        }
        if (z2) {
            com.kwad.sdk.commercial.c.o(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
        }
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        SplashMonitorInfo templateVersionCode = A2egSU.A2egSU(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dB(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(h.af(adTemplate) ? com.kwad.sdk.core.response.b.b.dA(adTemplate) : com.kwad.sdk.core.response.b.b.dK(e.er(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        SplashMonitorInfo templateVersionCode = A2egSU.A2egSU(106).setTkRenderType(com.kwad.sdk.core.response.b.b.dB(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(h.af(adTemplate) ? com.kwad.sdk.core.response.b.b.dA(adTemplate) : com.kwad.sdk.core.response.b.b.dK(e.er(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void d(AdTemplate adTemplate, int i, String str) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.g(true, A2egSU.A2egSU(2).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setUrl(com.kwad.sdk.core.response.b.a.bd(er) ? com.kwad.sdk.core.response.b.a.L(er) : com.kwad.sdk.core.response.b.a.aV(er).materialUrl).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.b.a.bd(er) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn) ? 1L : 2L).setBuriedPointOptimizeType(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGu)).setVisibleCheckDelayTime(com.kwad.sdk.core.config.e.Ie()).setPreloadId(com.kwad.sdk.core.response.b.a.ba(e.er(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void f(long j, long j2) {
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j2).setLoadProcessType(com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn) ? 1L : 2L).setBuriedPointOptimizeType(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGu)).setVisibleCheckDelayTime(com.kwad.sdk.core.config.e.Ie()).setPosId(j));
    }

    public static void g(AdTemplate adTemplate, long j) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(5).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setAdTemplate(adTemplate));
    }

    public static void k(AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                com.kwad.sdk.commercial.c.l(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setMaterialTypes(arrayList3).setStatus(1).setPosId(adResultData.getPosId()));
                return;
            }
            AdTemplate next = it.next();
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.K(e.er(next))));
            arrayList2.add(com.kwad.sdk.core.response.b.a.ba(e.er(next)));
            if (com.kwad.sdk.core.response.b.a.bd(e.er(next))) {
                i = 2;
            }
            arrayList3.add(Integer.valueOf(i));
        }
    }

    public static b mk() {
        if (Gq == null) {
            synchronized (b.class) {
                try {
                    if (Gq == null) {
                        Gq = new b();
                    }
                } finally {
                }
            }
        }
        return Gq;
    }

    public static void u(long j) {
        com.kwad.sdk.commercial.c.j(A2egSU.A2egSU(1).setLoadProcessType(com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn) ? 1L : 2L).setBuriedPointOptimizeType(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGu)).setVisibleCheckDelayTime(com.kwad.sdk.core.config.e.Ie()).setPosId(j));
    }

    public static void v(long j) {
        com.kwad.sdk.commercial.c.k(new SplashMonitorInfo().setStatus(1).setPosId(j));
    }

    public static void f(AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(1).setBuriedPointOptimizeType(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGu)).setVisibleCheckDelayTime(com.kwad.sdk.core.config.e.Ie()).setType(com.kwad.sdk.core.response.b.a.be(e.er(adTemplate)) ? 2 : 1).setCostTime(j).setLoadProcessType(com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate, int i, String str) {
        String L;
        AdInfo er = e.er(adTemplate);
        boolean be = com.kwad.sdk.core.response.b.a.be(er);
        SplashMonitorInfo type = new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setType(be ? 2 : 1);
        if (be) {
            L = com.kwad.sdk.core.response.b.a.aV(er).materialUrl;
        } else {
            L = com.kwad.sdk.core.response.b.a.L(er);
        }
        com.kwad.sdk.commercial.c.m(type.setUrl(L).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void c(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.c.j(A2egSU.A2egSU(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i, long j, int i2, long j2, long j3, long j4, long j5, long j6) {
        long dK;
        SplashMonitorInfo templateVersionCode = A2egSU.A2egSU(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dB(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.er(adTemplate);
        if (h.af(adTemplate)) {
            dK = com.kwad.sdk.core.response.b.b.dA(adTemplate);
        } else {
            dK = com.kwad.sdk.core.response.b.b.dK(e.er(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(dK).setSoSource(i).setSoLoadTime(j).setOfflineSource(i2).setOfflineLoadTime(j2).setTkFileLoadTime(j3).setTkInitTime(j4).setTkRenderTime(j5).setTkTotalTime(j6).setAdTemplate(adTemplate));
    }

    public static void b(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.c.p(A2egSU.A2egSU(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long dK;
        StyleTemplate c = c(adTemplate);
        SplashMonitorInfo errorMsg = A2egSU.A2egSU(105).setTemplateId(c.templateId).setTemplateVersionCode(c.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dB(adTemplate)).setErrorMsg(str);
        e.er(adTemplate);
        if (h.af(adTemplate)) {
            dK = com.kwad.sdk.core.response.b.b.dA(adTemplate);
        } else {
            dK = com.kwad.sdk.core.response.b.b.dK(e.er(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(errorMsg.setTkDefaultTimeout(dK).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long dK;
        StyleTemplate c = c(adTemplate);
        SplashMonitorInfo templateVersionCode = A2egSU.A2egSU(103).setTkRenderType(com.kwad.sdk.core.response.b.b.dB(adTemplate)).setTemplateId(c.templateId).setTemplateVersionCode(c.templateVersionCode);
        e.er(adTemplate);
        if (h.af(adTemplate)) {
            dK = com.kwad.sdk.core.response.b.b.dA(adTemplate);
        } else {
            dK = com.kwad.sdk.core.response.b.b.dK(e.er(adTemplate));
        }
        com.kwad.sdk.commercial.c.m(templateVersionCode.setTkDefaultTimeout(dK).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, int i, long j, long j2) {
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo er = e.er(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bd(er)) {
            str = com.kwad.sdk.core.response.b.a.L(er);
        } else {
            str = com.kwad.sdk.core.response.b.a.aV(er).materialUrl;
        }
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate, int i, int i2) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(3001).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setUrl(com.kwad.sdk.core.response.b.a.aV(er).materialUrl).setShowType(i2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, long j, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        com.kwad.sdk.commercial.c.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j2).setLoadProcessType(com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setBuriedPointOptimizeType(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGu)).setVisibleCheckDelayTime(com.kwad.sdk.core.config.e.Ie()).setPreloadId(com.kwad.sdk.core.response.b.a.ba(e.er(adTemplate))).setAdTemplate(adTemplate));
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dO(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k != null) {
            styleTemplate.templateId = k.templateId;
            styleTemplate.templateMd5 = k.templateMd5;
            styleTemplate.templateUrl = k.templateUrl;
            styleTemplate.templateVersionCode = (int) k.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void b(int i, String str, long j) {
        com.kwad.sdk.commercial.c.k(new SplashMonitorInfo().setStatus(3).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void b(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(3003).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setUrl(com.kwad.sdk.core.response.b.a.aV(er).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }

    public static void a(List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.b.a.ba(e.er(it.next())));
        }
        com.kwad.sdk.commercial.c.k(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).setPosId(j2));
    }

    public static void a(AdTemplate adTemplate, long j, int i, int i2) {
        String str;
        AdInfo er = e.er(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bd(er)) {
            str = com.kwad.sdk.core.response.b.a.L(er);
        } else {
            str = com.kwad.sdk.core.response.b.a.aV(er).materialUrl;
        }
        File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(com.kwad.sdk.core.response.b.a.ba(er));
        com.kwad.sdk.commercial.c.g(false, A2egSU.A2egSU(1).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setCostTime(j).setCacheValidTime(er.adPreloadInfo.validityPeriod * 1000).setSize((cr == null || !cr.exists()) ? 0L : cr.length()).setUrl(str).setMaterialType(com.kwad.sdk.core.response.b.a.bd(er) ? 1 : 2).setType(i).setRequestType(i2).setAdTemplate(adTemplate));
    }

    public static void a(long j, List<String> list, List<Integer> list2) {
        com.kwad.sdk.commercial.c.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setStatus(2).setPosId(j));
    }

    public static void a(long j, List<String> list, List<Integer> list2, int i, int i2, int i3, int i4) {
        com.kwad.sdk.commercial.c.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setUpdateType(i).setClearCount(i2).setClearImageCount(i3).setClearVideoCount(i4).setStatus(3).setPosId(j));
    }

    public static void a(AdTemplate adTemplate, long j, long j2, long j3) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(2).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setCostTime(j).setAddLoadTime(j2).setRequestLoadTime(j3).setBuriedPointOptimizeType(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aGu)).setVisibleCheckDelayTime(com.kwad.sdk.core.config.e.Ie()).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setLoadProcessType(com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setViewSource(z ? 1 : 2).setLoadDataTime(elapsedRealtime).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(202).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setRootVisible(z).setParentVisible(z2).setHasUnbind(z3).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, boolean z, boolean z2) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(A2egSU.A2egSU(203).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setLoadDataTime(SystemClock.elapsedRealtime() - j).setRootVisible(z).setParentVisible(z2).setType(com.kwad.sdk.core.response.b.a.be(er) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, boolean z) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.c.n(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.c.n(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.K(e.er(adTemplate))).setErrorMsg(str).setViewSource(z ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo er = e.er(adTemplate);
        com.kwad.sdk.commercial.c.m(new SplashMonitorInfo().setStatus(3002).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.ba(er)).setCreativeId(com.kwad.sdk.core.response.b.a.K(er)).setUrl(com.kwad.sdk.core.response.b.a.aV(er).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }
}
