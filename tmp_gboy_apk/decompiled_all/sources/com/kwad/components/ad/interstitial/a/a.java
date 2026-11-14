package com.kwad.components.ad.interstitial.a;

import android.text.TextUtils;
import com.kwad.components.ad.interstitial.report.b;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static boolean s(AdTemplate adTemplate) {
        boolean z;
        String L = com.kwad.sdk.core.response.b.a.L(e.er(adTemplate));
        if (TextUtils.isEmpty(L)) {
            b.eR().b(adTemplate, "empty videoUrl");
            return false;
        }
        b.eR().x(adTemplate);
        int Dz = com.kwad.sdk.core.config.e.Dz();
        String str = "";
        if (Dz < 0) {
            File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(L);
            if (w.O(cr)) {
                z = true;
            } else {
                a.C0366a c0366a = new a.C0366a();
                z = com.kwad.sdk.core.diskcache.b.a.IJ().a(L, c0366a);
                str = c0366a.msg;
            }
            adTemplate.setDownloadSize(cr != null ? cr.length() : 0L);
            adTemplate.setDownloadType(2);
        } else if (Dz > 0) {
            a.C0366a c0366a2 = new a.C0366a();
            f b = com.kwad.sdk.core.config.e.HT() == 1 ? com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 0) : com.kwad.sdk.core.config.e.HT() == 2 ? com.kwad.sdk.core.videocache.c.a.b(ServiceProvider.getContext(), 1, 1) : com.kwad.sdk.core.videocache.c.a.ca(ServiceProvider.getContext());
            z = !b.fb(L) ? b.a(L, Dz * 1024, c0366a2, null) : true;
            str = c0366a2.msg;
            adTemplate.setDownloadSize(Dz * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            z = true;
        }
        if (z) {
            adTemplate.setDownloadStatus(1);
            return z;
        }
        adTemplate.setDownloadStatus(2);
        b.eR().b(adTemplate, str);
        com.kwad.components.ad.interstitial.report.realtime.a.eX();
        com.kwad.components.ad.interstitial.report.realtime.a.b(str, adTemplate);
        return z;
    }
}
