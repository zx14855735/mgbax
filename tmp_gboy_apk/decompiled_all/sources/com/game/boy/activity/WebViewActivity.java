package com.game.boy.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class WebViewActivity extends A5SV6n {
    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492907);
        String stringExtra = getIntent().getStringExtra("extra_title");
        if (stringExtra == null) {
            stringExtra = "";
        }
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        materialToolbar.setTitle(stringExtra);
        setSupportActionBar(materialToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().AlLFFp(true);
        }
        WebView webView = (WebView) findViewById(2131298319);
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        String stringExtra2 = getIntent().getStringExtra("extra_url");
        if (stringExtra2 != null) {
            webView.loadUrl(stringExtra2);
        }
    }
}
