package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cb;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends WebView {
    private boolean aRQ;
    private com.kwad.sdk.core.webview.a.a aRR;

    public c(Context context) {
        super(cc(context));
        this.aRQ = true;
        init();
    }

    private static Context cc(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context ew = m.ew(context);
        if (m.ez(ew)) {
            return ew;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + ew.getClass().getName() + "--classloader:" + ew.getClass().getClassLoader() + "--context2:" + m.ew(ServiceProvider.Re()).getClass().getName()));
        return m.ew(ServiceProvider.Re());
    }

    private void init() {
        cb.b(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aRR = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aRQ) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public void setEnableDestroy(boolean z) {
        this.aRQ = z;
    }

    public void setNeedHybridLoad(boolean z) {
        this.aRR.setNeedHybridLoad(z);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(cc(context), attributeSet);
        this.aRQ = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(cc(context), attributeSet, i);
        this.aRQ = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(cc(context), attributeSet, i, i2);
        this.aRQ = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(cc(context), attributeSet, i, z);
        this.aRQ = true;
        init();
    }
}
