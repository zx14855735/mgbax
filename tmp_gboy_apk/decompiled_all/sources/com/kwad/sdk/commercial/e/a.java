package com.kwad.sdk.commercial.e;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static void a(SceneImpl sceneImpl, long j, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.c.d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(e.cL(sceneImpl.getAdStyle())).O("ad_sdk_ad_parse_performance", "default").z(c.FM().db(str).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bP(AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, "llsid", "");
            }
            if (com.kwad.sdk.core.response.b.e.eB(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
            int i = er.adBaseInfo.adOperationType;
            if (i == 1) {
                String cV = com.kwad.sdk.core.response.b.a.cV(er);
                if (bw.hR(cV)) {
                    c(adTemplate, "download_url", cV);
                }
            } else if (i == 2) {
                String aT = com.kwad.sdk.core.response.b.a.aT(er);
                if (bw.hR(aT)) {
                    c(adTemplate, "h5_url", aT);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature O = com.kwad.sdk.core.response.b.a.O(er);
            int i2 = O.featureType;
            String str = O.materialUrl;
            if (i2 == 1) {
                if (bw.hR(str)) {
                    c(adTemplate, "video_url", str);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (bw.hR(str)) {
                    c(adTemplate, "image_url", str);
                }
            } else if (i2 == 3) {
                long cq = com.kwad.sdk.core.response.b.a.cq(er);
                String bi = com.kwad.sdk.core.response.b.a.bi(er);
                if (cq == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(bi)) {
                    c(adTemplate, "live_stream_id", bi);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.c.d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(e.bh(adTemplate)).O("ad_sdk_ad_data_performance", "error_name").z(b.FL().cZ(str).da(str2).setAdTemplate(adTemplate)));
    }

    public static void e(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }

    public static void a(SceneImpl sceneImpl, long j, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.c.d(d.FH().cR(ILoggerReporter.Category.ERROR_LOG).i(0.01d).b(e.cL(sceneImpl.getAdStyle())).O("ad_sdk_ad_parse_performance", "default").z(c.FM().db(str).dc(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
