package com.kwad.sdk.core.webview.d;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    public static final class C0372a extends com.kwad.sdk.core.response.a.a {
        public String Mi;
        public int QW;
        public int QX;
        public String SDKVersion;
        public int SDKVersionCode;
        public String aGW;
        public String aGX;
        public String aMW;
        public String aMZ;
        public String aMl;
        public String aNa;
        public String aNn;
        public String aSG;
        public String aSH;
        public boolean aSI;
        public String aSJ;
        public String ahc;
        public String ahd;
        public int ahe;
        public String ahf;
        public int ahg;
        public String ahh;
        public String ahi;
        public int ahj;
        public int ahk;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static C0372a MR() {
            C0372a c0372a = new C0372a();
            c0372a.SDKVersion = BuildConfig.VERSION_NAME;
            c0372a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c0372a.aMl = "6.1.8";
            c0372a.aSJ = "1.3";
            c0372a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0372a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0372a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0372a.appVersion = m.cN(context);
            c0372a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0372a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0372a.aSG = "";
            c0372a.aNa = ag.getEGid();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c0372a.aMZ = hVar.qt();
            }
            c0372a.ahc = String.valueOf(ao.dp(context));
            c0372a.ahd = br.TU();
            c0372a.model = br.TK();
            c0372a.Mi = br.TM();
            c0372a.ahe = 1;
            c0372a.ahf = br.getOsVersion();
            c0372a.ahg = br.TX();
            c0372a.ahh = br.getLanguage();
            c0372a.ahi = br.getLocale();
            c0372a.aSI = ((f) ServiceProvider.get(f.class)).CT();
            c0372a.aSH = bd.getDeviceId();
            c0372a.QX = br.getScreenWidth(context);
            c0372a.QW = br.getScreenHeight(context);
            c0372a.aGW = bd.dA(context);
            c0372a.aGX = bd.getOaid();
            c0372a.aMW = bd.dB(context);
            c0372a.aNn = bd.dC(context);
            c0372a.ahj = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0372a.ahk = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0372a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        cVar.a(C0372a.MR());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
