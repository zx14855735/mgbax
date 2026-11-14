package com.kwad.components.ad.c.a;

import android.text.TextUtils;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static boolean a(AdTemplate adTemplate, final AdVideoPreCacheConfig adVideoPreCacheConfig, final b bVar) {
        String str;
        boolean z;
        boolean a2;
        String L = com.kwad.sdk.core.response.b.a.L(e.er(adTemplate));
        if (TextUtils.isEmpty(L)) {
            a(bVar, "字段为null");
            return false;
        }
        final long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        if (adVideoPreCacheSize > 0) {
            long j = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            a.C0366a c0366a = new a.C0366a();
            f ca = com.kwad.sdk.core.videocache.c.a.ca(ServiceProvider.getContext());
            if (ca.fa(L)) {
                a(bVar);
                a2 = true;
            } else {
                a2 = ca.a(L, j, c0366a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.c.a.a.1
                    private boolean cg = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j2, long j3) {
                        if ((j2 >= adVideoPreCacheSize || j2 >= j3) && !this.cg) {
                            this.cg = true;
                            a.a(bVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }
                });
            }
            str = c0366a.msg;
            z = a2;
        } else {
            str = "";
            if (adVideoPreCacheSize < 0) {
                File cr = com.kwad.sdk.core.diskcache.b.a.IJ().cr(L);
                if (w.O(cr)) {
                    z = true;
                } else {
                    a.C0366a c0366a2 = new a.C0366a();
                    z = com.kwad.sdk.core.diskcache.b.a.IJ().a(L, c0366a2);
                    str = c0366a2.msg;
                }
                adTemplate.setDownloadSize(cr != null ? cr.length() : 0L);
                if (z) {
                    a(bVar);
                }
            } else {
                a(bVar);
                z = true;
            }
        }
        if (z) {
            k.n(L, adVideoPreCacheConfig.getAdVideoPreCacheSize());
            return z;
        }
        a(bVar, str);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.af();
    }

    private static void a(b bVar, String str) {
        if (bVar == null) {
            return;
        }
        bVar.ag();
    }
}
