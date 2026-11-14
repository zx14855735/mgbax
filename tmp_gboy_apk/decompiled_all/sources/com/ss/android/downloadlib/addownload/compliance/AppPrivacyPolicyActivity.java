package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.czhj.sdk.common.Constants;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.p;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AppPrivacyPolicyActivity extends Activity {
    private WebView hf;
    private String kd;
    private long u;
    private long w;
    private ImageView xj;

    private void hf() {
        this.xj = (ImageView) findViewById(2131296799);
        this.hf = (WebView) findViewById(2131297773);
        this.xj.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.xj("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.u);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.hf.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.hf.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean xj(Uri uri) {
                String scheme = uri.getScheme();
                return (Constants.HTTP.equals(scheme) || "https".equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (renderProcessGoneDetail.didCrash()) {
                    p.xj("The WebView rendering process crashed!");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                p.xj("System killed the WebView rendering process to reclaim memory. Recreating...");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return xj(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return xj(Uri.parse(str));
            }
        });
        xj(this.hf);
        this.hf.setScrollBarStyle(0);
        this.hf.loadUrl(this.kd);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c.xj("lp_app_privacy_click_close", this.u);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131493353);
        if (xj()) {
            hf();
        } else {
            com.ss.android.socialbase.appdownloader.w.xj((Activity) this);
        }
    }

    public static void xj(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean xj() {
        this.w = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.hf.hf xj = w.xj().xj(this.w);
        if (xj == null) {
            return false;
        }
        this.u = xj.hf;
        String str = xj.d;
        this.kd = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.kd = pl.d().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void xj(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
