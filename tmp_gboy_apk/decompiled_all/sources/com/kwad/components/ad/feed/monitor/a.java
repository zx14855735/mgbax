package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static Pair<Integer, String> m(AdTemplate adTemplate) {
        String L = com.kwad.sdk.core.response.b.a.L(e.er(adTemplate));
        if (TextUtils.isEmpty(L)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int Dz = com.kwad.sdk.core.config.e.Dz();
        int i = 1;
        String str = "";
        if (Dz < 0) {
            File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(L);
            if (!w.O(cr)) {
                a.C0366a c0366a = new a.C0366a();
                int i2 = com.kwad.sdk.core.diskcache.b.a.IJ().a(L, c0366a) ? 1 : 2;
                str = c0366a.msg;
                i = i2;
            }
            adTemplate.setDownloadSize(cr != null ? cr.length() : 0L);
        } else if (Dz > 0) {
            a.C0366a c0366a2 = new a.C0366a();
            f ca = com.kwad.sdk.core.videocache.c.a.ca(ServiceProvider.getContext());
            if (!ca.fb(L)) {
                i = ca.a(L, (long) (Dz * 1024), c0366a2, null) ? 1 : 2;
            }
            str = c0366a2.msg;
            adTemplate.setDownloadSize(Dz * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i), str);
    }
}
