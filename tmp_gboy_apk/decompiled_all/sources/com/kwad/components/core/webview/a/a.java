package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.d;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.cc;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private d PB;
    private WebView UA;
    private boolean afE;
    private KsAppDownloadListener afQ;
    private int afR = -100;
    private int afS = 0;
    private com.kwad.sdk.core.webview.b eQ;
    private AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a, reason: collision with other inner class name */
    public static final class C0314a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.UA = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.eQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(String str) {
        try {
            C0314a c0314a = new C0314a();
            c0314a.parseJson(new JSONObject(str));
            if (q(c0314a.url, c0314a.packageName)) {
                return;
            }
            if (this.PB == null) {
                p(c0314a.url, c0314a.packageName);
            }
            a.C0291a av = new a.C0291a(this.eQ.UA.getContext()).as(true).at(false).aE(this.mAdTemplate).av(false);
            if (this.PB.w(av)) {
                return;
            }
            this.PB.d(this.afQ);
            this.PB.v(av);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private void o(String str, String str2) {
        WebView webView;
        if (this.afE || TextUtils.isEmpty(str) || (webView = this.UA) == null) {
            return;
        }
        cc.a(webView, str, str2);
    }

    private synchronized void p(String str, String str2) {
        this.PB = new d(this.mAdTemplate, null, str, str2);
        if (this.afQ == null) {
            KsAppDownloadListener wa = wa();
            this.afQ = wa;
            this.PB.b(wa);
        }
    }

    private static boolean q(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, int i2) {
        this.afS = i2;
        if (this.afR != i) {
            this.afR = i;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            o("onDownLoadStatusCallback", sb.toString());
        }
    }

    private KsAppDownloadListener wa() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.r(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.r(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.r(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.r(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    a.this.r(1, 0);
                } else {
                    a.this.r(2, i);
                }
            }
        };
    }

    public final void destroy() {
        this.afE = true;
        d dVar = this.PB;
        if (dVar != null) {
            dVar.c(this.afQ);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.PB == null) {
            p(str, str2);
        }
        return this.PB.pR();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (q(str, str2)) {
            return 0;
        }
        if (this.PB == null) {
            p(str, str2);
        }
        return this.afS;
    }

    @JavascriptInterface
    public final void handleAdClick(final String str) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.bc(str);
            }
        });
    }
}
