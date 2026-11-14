package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import android.app.Activity;
import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.czhj.sdk.common.Constants;
import io.dcloud.openapi.core.util.ReflectUtil;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaau {
    ViewGroup aaaaaaa0;
    WebView aaaaaaaa;

    public class aaaaaaa0 implements DownloadListener {
        public aaaaaaa0() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }
    }

    public class aaaaaaaa extends WebViewClient {

        /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaau$aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
        public class RunnableC0547aaaaaaaa implements Runnable {
            final /* synthetic */ String aaaaaaaa;

            public RunnableC0547aaaaaaaa(String str) {
                this.aaaaaaaa = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (aaaaaaau.this.aaaaaaaa == null) {
                    return;
                }
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("adh", "onPageFinished-remove--url=" + this.aaaaaaaa);
                aaaaaaau aaaaaaauVar = aaaaaaau.this;
                ViewGroup viewGroup = aaaaaaauVar.aaaaaaa0;
                if (viewGroup != null) {
                    viewGroup.removeView(aaaaaaauVar.aaaaaaaa);
                    aaaaaaau.this.aaaaaaaa = null;
                }
            }
        }

        public aaaaaaaa() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa.aaaaaaaa("adh", "onPageFinished---url=" + str);
            aaaaaaau.this.aaaaaaa0.postDelayed(new RunnableC0547aaaaaaaa(str), (long) aaaaaaac.aaaaaaaa(5000, 20000));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                ReflectUtil.invokeMethod(sslErrorHandler, "proceed", new Class[0], new Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ENGLISH).startsWith(Constants.HTTP);
        }
    }

    public aaaaaaau(Context context) {
        if (context instanceof Activity) {
            this.aaaaaaa0 = (ViewGroup) ((Activity) context).getWindow().getDecorView();
        }
        WebView webView = new WebView(context);
        this.aaaaaaaa = webView;
        webView.setVisibility(4);
        this.aaaaaaa0.addView(this.aaaaaaaa, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.aaaaaaaa.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        context.getApplicationContext().getCacheDir().getAbsolutePath();
        settings.setAllowFileAccess(false);
        ReflectUtil.invokeMethod(settings, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaae.aaaaaaao("e218SWRkZ39OYWRtSWtrbXt7"), new Class[]{Boolean.TYPE}, Boolean.TRUE);
        settings.setSavePassword(false);
        this.aaaaaaaa.removeJavascriptInterface("searchBoxJavaBridge_");
        this.aaaaaaaa.removeJavascriptInterface("accessibilityTraversal");
        this.aaaaaaaa.removeJavascriptInterface("accessibility");
        this.aaaaaaaa.setWebViewClient(new aaaaaaaa());
        aaaaaaaa();
        this.aaaaaaaa.setDownloadListener(new aaaaaaa0());
    }

    private void aaaaaaaa() {
    }

    public void aaaaaaaa(String str) {
        WebView webView = this.aaaaaaaa;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }
}
