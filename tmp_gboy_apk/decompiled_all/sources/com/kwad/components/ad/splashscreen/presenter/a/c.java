package com.kwad.components.ad.splashscreen.presenter.a;

import android.app.Activity;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class c extends e implements j {
    private b JH;

    public void a(az azVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        int nq = nq();
        b bVar = new b(getContext(), nq, nq);
        this.JH = bVar;
        bVar.a((Activity) null, this.GC.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.GC.mRootContainer;
    }

    public int nq() {
        return 1000;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.JH.kK();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0315a c0315a) {
        String str = c0315a.agb;
        str.getClass();
        switch (str) {
            case "adShowCallback":
                this.GC.lU();
                break;
            case "adDownloadConfirmTipCancel":
                this.GC.lZ();
                break;
            case "adCloseCallback":
                this.GC.lW();
                break;
            case "adDownloadConfirmTipShow":
                this.GC.lY();
                break;
            case "adDownloadConfirmTipDismiss":
                this.GC.ma();
                break;
            case "adAutoCloseCallback":
                this.GC.lV();
                break;
            case "adShowErrorCallback":
                this.GC.lT();
                break;
            case "adClickCallback":
                this.GC.lX();
                break;
        }
    }
}
