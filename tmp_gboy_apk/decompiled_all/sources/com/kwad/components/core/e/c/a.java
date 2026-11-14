package com.kwad.components.core.e.c;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.e.c.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a extends KSFrameLayout {
    private final b Pg;
    private final b.C0290b Ph;
    private d Pi;
    private InterfaceC0289a Pj;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.e.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0289a {
        void pk();
    }

    public a(Context context, b bVar, b.C0290b c0290b) {
        super(context);
        this.mContext = context;
        this.Pg = bVar;
        this.Ph = c0290b;
        this.mAdTemplate = c0290b.adTemplate;
        m.inflate(context, R.layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        b(adBaseFrameLayout, "rootView is null");
        b((KsAdWebView) adBaseFrameLayout.findViewById(R.id.ksad_download_tips_web_card_webView), "webView is null");
    }

    private void b(View view, String str) {
        if (view != null) {
            return;
        }
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("inflateView fail ", str, "\n--viewCount:");
        B3GDIM2.append(getChildCount());
        B3GDIM2.append("\n--context:");
        B3GDIM2.append(this.mContext.getClass().getName());
        B3GDIM2.append("\n--LayoutInflater context: ");
        B3GDIM2.append(LayoutInflater.from(this.mContext).getContext().getClass().getName());
        B3GDIM2.append("\n--classloader:");
        B3GDIM2.append(a.class.getClassLoader().getClass().getName());
        throw new RuntimeException(B3GDIM2.toString());
    }

    private static Presenter bC() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d pj() {
        d dVar = new d();
        dVar.Pg = this.Pg;
        dVar.Ph = this.Ph;
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aG(com.kwad.sdk.core.response.b.e.er(adTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        }
        return dVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.Pi = pj();
        Presenter bC = bC();
        this.mPresenter = bC;
        bC.M(this.mRootContainer);
        this.mPresenter.o(this.Pi);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        d dVar = this.Pi;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0289a interfaceC0289a = this.Pj;
        if (interfaceC0289a != null) {
            interfaceC0289a.pk();
        }
    }

    public final void setChangeListener(InterfaceC0289a interfaceC0289a) {
        this.Pj = interfaceC0289a;
    }
}
