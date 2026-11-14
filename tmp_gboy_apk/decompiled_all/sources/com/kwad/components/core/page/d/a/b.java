package com.kwad.components.core.page.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.d.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public AdWebViewActivityProxy.a UY;

    @Deprecated
    public com.kwad.components.core.webview.jshandler.b VA;
    public com.kwad.components.core.page.a.a VB;
    public com.kwad.components.core.b.a VC;
    public boolean VD = false;
    public boolean VE = false;
    public WebView Vw;
    public com.kwad.components.core.page.a.b Vx;
    public KsAdWebView.c Vy;
    public f.a Vz;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    public Context mContext;
    public String mH5AuthUrl;
    public String mPageTitle;
    public String mPageUrl;
    public ViewGroup mRootContainer;
    public boolean mShowPermission;
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private void aM(boolean z) {
        this.VE = z;
    }

    public final void a(KsAdWebView.c cVar) {
        this.Vy = cVar;
    }

    public final boolean rQ() {
        return this.mShowPermission;
    }

    public final void rX() {
        com.kwad.components.core.webview.jshandler.b bVar = this.VA;
        if (bVar != null) {
            bVar.ss();
        }
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.Vy = null;
        this.Vz = null;
        this.mWebCardCloseListener = null;
        this.VA = null;
    }

    public final void setH5AuthListener(com.kwad.components.core.page.a.a aVar) {
        this.VB = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final boolean sf() {
        return this.VE;
    }

    public final void sg() {
        this.VA = null;
        aM(false);
    }

    public final boolean sh() {
        return !rQ();
    }

    public final void a(f.a aVar) {
        this.Vz = aVar;
    }

    public final void a(boolean z, View view) {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            if (z) {
                com.kwad.sdk.core.adlog.c.cc(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.b bVar = this.Vx;
        if (bVar != null) {
            bVar.rL();
        }
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.VA = bVar;
        aM(true);
    }
}
