package com.kwad.components.core.page;

import android.content.Context;
import android.view.ViewGroup;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends com.kwad.components.core.m.c<com.kwad.components.core.page.d.a.b> {
    private AdWebViewActivityProxy.a UY;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private String mH5AuthUrl;
    private com.kwad.components.core.page.a.b mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    public d(Context context) {
        super(context);
    }

    public static d b(Context context, AdWebViewActivityProxy.a aVar) {
        d dVar = new d(context);
        dVar.c(context, aVar);
        return dVar;
    }

    @Override // com.kwad.components.core.m.c
    public void a(ViewGroup viewGroup) {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.release();
            this.mAdWebView = null;
        }
    }

    public final void c(Context context, AdWebViewActivityProxy.a aVar) {
        this.UY = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.rO();
        this.mH5AuthUrl = aVar.rT();
        this.mPageTitle = aVar.rN();
        this.mShowPermission = aVar.rQ();
        this.mAutoShow = aVar.rS();
    }

    public boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.d.a.b) this.mPresenter.PC()).sf();
    }

    @Override // com.kwad.components.core.m.c
    public int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    @Override // com.kwad.components.core.m.c
    public final void initData() {
    }

    @Override // com.kwad.components.core.m.c
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.core.page.d.a.f());
        presenter.a(new com.kwad.components.core.page.d.a.e());
        if (com.kwad.sdk.core.response.b.e.O(((com.kwad.components.core.page.d.a.b) this.SR).mAdTemplate)) {
            presenter.a(new com.kwad.components.core.page.d.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.aP(com.kwad.sdk.core.response.b.e.er(((com.kwad.components.core.page.d.a.b) this.SR).mAdTemplate)) && com.kwad.components.core.q.a.ua().ug() && com.kwad.components.core.q.a.ua().ub() == 1) {
            presenter.a(new com.kwad.components.core.page.d.a.d());
        }
        presenter.a(new com.kwad.components.core.page.d.a.g());
        return presenter;
    }

    @Override // com.kwad.components.core.m.c
    /* renamed from: rW */
    public com.kwad.components.core.page.d.a.b ak() {
        com.kwad.components.core.page.d.a.b bVar = new com.kwad.components.core.page.d.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.UY = this.UY;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mH5AuthUrl = this.mH5AuthUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.Vx = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.mRootContainer = this.nX;
        return bVar;
    }

    public final void rX() {
        ((com.kwad.components.core.page.d.a.b) this.mPresenter.PC()).rX();
    }

    public void setLandPageViewListener(com.kwad.components.core.page.a.b bVar) {
        this.mLandPageViewListener = bVar;
    }

    public void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView != null || bVar == null) {
            return;
        }
        bVar.b(null);
    }
}
