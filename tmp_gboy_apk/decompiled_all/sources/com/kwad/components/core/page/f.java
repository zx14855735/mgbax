package com.kwad.components.core.page;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.offline.api.core.adInnerEc.ExternalExitListener;
import com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f extends com.kwad.components.core.m.c<com.kwad.components.core.page.d.a.b> implements YodaWebPageListener {
    private static final Set<WeakReference<f>> Va = new HashSet();
    private WebView UA;
    private AdWebViewActivityProxy.a UY;
    private ExternalExitListener UZ;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private String mPageTitle;
    private String mPageUrl;

    static {
        DXbf();
    }

    public f(Context context) {
        super(context);
    }

    private static /* synthetic */ void DXbf() {
        char[] charArray = "\f\u0000\u0002A\b\u000e\u0002\nA\r\u0000\u0016A\u001c\u0007\n\u0003\u0003A%\u0001\u0006-\u001d\u0006\u000b\b\n".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'o');
        }
        String str = new String(charArray);
        char[] charArray2 = "\f\u0003\u0006\u0001\u0006\u001b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'o');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.c
    /* renamed from: rW, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.page.d.a.b ak() {
        com.kwad.components.core.page.d.a.b bVar = new com.kwad.components.core.page.d.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.UY = this.UY;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mRootContainer = this.nX;
        bVar.Vw = this.UA;
        return bVar;
    }

    @Override // com.kwad.components.core.m.c
    public final void a(ViewGroup viewGroup) {
    }

    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        WebView webView = this.UA;
        if (webView != null) {
            webView.destroy();
            this.UA = null;
        }
        ((com.kwad.components.core.page.d.a.b) this.SR).Vw = null;
        this.mContext = null;
        super.ab();
    }

    public final void c(Context context, AdWebViewActivityProxy.a aVar) {
        this.UY = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.rO();
        this.mPageTitle = aVar.rN();
    }

    @Override // com.kwad.components.core.m.c
    public final int getLayoutId() {
        return R.layout.ksad_merchant_landing_view;
    }

    @Override // com.kwad.components.core.m.c
    public final void initData() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onBackground() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onBackground");
    }

    @Override // com.kwad.components.core.m.c
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.core.page.b.a());
        return presenter;
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onForeground() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onForeground");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        StringBuilder B9tovu2 = A2egSU.B9tovu(i, "onKey ", " ");
        B9tovu2.append(keyEvent.getAction());
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", B9tovu2.toString());
        return false;
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onLeave() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onLeave");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onLoadPage() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onLoadPage");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onPageFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        boolean z = false;
        if (adTemplate != null) {
            boolean dB = com.kwad.sdk.core.response.b.a.dB(com.kwad.sdk.core.response.b.e.er(adTemplate));
            if (com.kwad.sdk.core.response.b.b.ea(this.mAdTemplate) && this.mAdTemplate.isDoAuth && !dB) {
                z = true;
            }
            if (z) {
                bw.postOnUiThread(new bg() { // from class: com.kwad.components.core.page.f.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        ac.c(f.this.mContext, com.kwad.sdk.core.response.b.b.eb(f.this.mAdTemplate), 0);
                        f.this.mAdTemplate.isDoAuth = false;
                    }
                });
            }
        }
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onPageFinished enableInnerEcToast: " + z);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onPagePause() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onPagePause");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onPageResume() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onPageFinished");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onReceivedError() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onReceivedError");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onReentry() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onReentry");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onVisibleChange(boolean z) {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onVisibleChange " + z);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final boolean overrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "overrideUrlLoading url:" + str);
        return true;
    }

    @Override // com.kwad.components.core.m.c
    public final ViewGroup rk() {
        return this;
    }

    public final void setExternalExitListener(ExternalExitListener externalExitListener) {
        this.UZ = externalExitListener;
    }

    private void b(com.kwad.components.core.b.b bVar) {
        T t = this.SR;
        if (t == 0 || ((com.kwad.components.core.page.d.a.b) t).VC == null) {
            return;
        }
        ((com.kwad.components.core.page.d.a.b) t).VC.a(bVar);
    }

    public static void a(WebView webView, com.kwad.components.core.b.b bVar) {
        f a2 = a(webView);
        if (a2 != null) {
            a2.b(bVar);
        }
    }

    public final void b(Activity activity) {
        FrameLayout frameLayout = (FrameLayout) this.nX.findViewById(R.id.ksad_merchant_web_container);
        WebView a2 = com.kwad.components.core.innerEc.f.a(activity, this, this.UZ);
        this.UA = a2;
        if (a2 != null) {
            frameLayout.addView(a2, -1, -1);
        }
    }

    private static f a(WebView webView) {
        f fVar;
        WebView webView2;
        if (webView == null) {
            return null;
        }
        for (WeakReference<f> weakReference : Va) {
            if (weakReference != null && weakReference.get() != null && (fVar = weakReference.get()) != null && (webView2 = fVar.UA) != null && webView.equals(webView2)) {
                return fVar;
            }
        }
        return null;
    }
}
