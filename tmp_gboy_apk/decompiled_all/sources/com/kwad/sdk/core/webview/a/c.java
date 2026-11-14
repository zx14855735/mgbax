package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.czhj.sdk.common.Constants;
import com.kwad.components.ad.reward.A2egSU;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a MD;

    public static class a {
        private int UO;
        private KsAdWebView.c Vy;
        private KsAdWebView.e aRZ;
        private KsAdWebView.d aSa;
        private boolean aSb;
        private boolean aSe;
        private KsAdWebView.b ajO;
        private AdTemplate mAdTemplate;
        private Context mContext;
        private boolean aSc = true;
        private boolean aSd = true;
        private boolean aRY = true;
        private boolean aSf = false;
        private long aSg = 600;
        private long aSh = 0;

        public a(Context context) {
            this.mContext = context;
        }

        private boolean MF() {
            return this.aSf;
        }

        public final KsAdWebView.d ME() {
            return this.aSa;
        }

        public final boolean MG() {
            return this.aSd;
        }

        public final boolean MH() {
            return this.aRY;
        }

        public final boolean MI() {
            return this.aSc;
        }

        public final boolean MJ() {
            return this.aSe;
        }

        public final boolean MK() {
            if (!MF()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.aSh;
            return j > 0 && currentTimeMillis - j <= this.aSg;
        }

        public final boolean ML() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dy(e.er(adTemplate));
        }

        public final boolean MM() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return false;
            }
            return com.kwad.sdk.core.response.b.a.dz(e.er(adTemplate));
        }

        public final a a(KsAdWebView.d dVar) {
            this.aSa = dVar;
            return this;
        }

        public final void aM(long j) {
            this.aSh = j;
        }

        public final a b(KsAdWebView.e eVar) {
            this.aRZ = eVar;
            return this;
        }

        public final a bD(boolean z) {
            this.aSf = true;
            return this;
        }

        public final a bE(boolean z) {
            this.aSb = true;
            return this;
        }

        public final a bF(boolean z) {
            this.aSd = z;
            return this;
        }

        public final a bG(boolean z) {
            this.aSc = z;
            return this;
        }

        public final a bH(boolean z) {
            this.aSe = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.Vy = cVar;
            return this;
        }

        public final a eP(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final a ek(int i) {
            this.UO = i;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.e jv() {
            return this.aRZ;
        }

        public final KsAdWebView.b nV() {
            return this.ajO;
        }

        public final com.kwad.sdk.core.adlog.c.a pF() {
            return com.kwad.sdk.core.adlog.c.a.Gz().dt(this.UO).du(this.aSb ? 1 : 0);
        }

        public final void release() {
            this.ajO = null;
            this.aSa = null;
            this.Vy = null;
            this.aRZ = null;
            this.mContext = null;
            this.mAdTemplate = null;
        }

        public final KsAdWebView.c so() {
            return this.Vy;
        }

        public final a a(KsAdWebView.b bVar) {
            this.ajO = bVar;
            return this;
        }
    }

    public static int a(a aVar, String str) {
        int H = com.kwad.sdk.core.download.a.b.H(aVar.getContext(), str);
        if (H == 1) {
            if (aVar.nV() != null) {
                aVar.nV().onSuccess();
            }
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
            return H;
        }
        if (aVar.nV() != null) {
            aVar.nV().onFailed();
        }
        if (H == -1) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), "", 2, null);
        }
        return H;
    }

    private boolean fj(String str) {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (!str.startsWith(Constants.HTTP) && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                a aVar = this.MD;
                if (aVar != null) {
                    if (aVar.MG()) {
                        a(this.MD, str);
                        return true;
                    }
                    if (fk(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            a aVar2 = this.MD;
            if (aVar2 != null) {
                aVar2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    private static boolean fk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwfastapp://") || str.startsWith("hap://app") || str.startsWith("intent://hapjs.org/") || str.startsWith("intent://");
    }

    public final void R(String str) {
        this.mUniqueId = str;
    }

    public final void destroy() {
        a aVar = this.MD;
        if (aVar != null) {
            aVar.release();
            this.MD = null;
        }
    }

    public final a getClientConfig() {
        return this.MD;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.af(this.mUniqueId, "onPageFinished");
        a aVar = this.MD;
        if (aVar == null || aVar.jv() == null) {
            return;
        }
        this.MD.jv().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.af(this.mUniqueId, "onPageStart");
        a aVar = this.MD;
        if (aVar == null || aVar.jv() == null) {
            return;
        }
        this.MD.jv().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        A2egSU.A4TApA(i, "onReceivedError ", "KsAdWebViewClient");
        a aVar = this.MD;
        if (aVar != null && aVar.jv() != null) {
            this.MD.jv().onReceivedHttpError(i, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.ah(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(a aVar) {
        this.MD = aVar;
        setNeedHybridLoad(aVar.MH());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.af(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.MD;
        if (aVar == null || !aVar.MK() || ((this.MD.ME() != null && this.MD.ME().shouldOverrideUrlLoading(webView, str)) || fj(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
