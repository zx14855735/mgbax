package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static AdHttpProxy aJY;

    /* renamed from: com.kwad.sdk.core.network.a.a$a, reason: collision with other inner class name */
    public static class C0366a {
        public String msg;
    }

    private static boolean Jw() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.Du();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C0366a c0366a, long j, boolean z, AdHttpResponseListener adHttpResponseListener) {
        boolean Jw = Jw();
        AdHttpProxy adHttpProxy = aJY;
        if (adHttpProxy == null) {
            A2egSU.B9tovu("isAdCacheEnable:", "VideoCacheHelper", Jw);
            adHttpProxy = Jw ? g.Cm() : new com.kwad.sdk.core.network.c.a();
            aJY = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (com.kwad.framework.b.a.oy.booleanValue()) {
            if (adHttpProxy2 instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j, z, adHttpResponseListener);
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", Log.getStackTraceString(e));
            c0366a.msg = e.getMessage();
            return false;
        }
    }
}
