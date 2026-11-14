package com.bytedance.sdk.openadsdk.core.widget.xj;

import ADYaiT.CtFAbx;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.x.c;
import com.czhj.sdk.common.Constants;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private WeakReference<Context> xj;
    private boolean hf = true;
    private boolean w = true;
    private boolean u = true;
    private boolean kd = true;
    private boolean y = true;
    private boolean c = true;
    private boolean f = true;

    private hf(Context context) {
        this.xj = new WeakReference<>(context);
    }

    public static hf xj(Context context) {
        return new hf(context);
    }

    public hf hf(boolean z) {
        this.w = z;
        return this;
    }

    private void hf(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            pl.w(th.toString());
        }
    }

    public hf xj(boolean z) {
        this.f = z;
        return this;
    }

    public void xj(final com.bytedance.sdk.component.g.w wVar) {
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.xj.hf.1
            @Override // java.lang.Runnable
            public void run() {
                hf.this.xj(wVar.getWebView());
            }
        });
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0069 -> B:22:0x006c). Please report as a decompilation issue!!! */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void xj(WebView webView) {
        if (webView == null || this.xj.get() == null) {
            return;
        }
        hf(webView);
        WebSettings settings = webView.getSettings();
        xj(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            pl.xj(e);
        }
        try {
            if (this.w) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.u);
        settings.setDomStorageEnabled(this.kd);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.c);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.f = false;
        }
        try {
            boolean z = this.f;
            if (!z) {
                webView.setLayerType(0, null);
            } else if (z) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            pl.xj(th2);
        }
    }

    private void xj(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            pl.w(th.toString());
        }
    }

    public static String xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Constants.FAIL.equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return CtFAbx.BI9f7h("javascript:(function () {    var JS_ACTLOG_URL = '", str.replace("{{ad_id}}", str2), "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();");
    }
}
