package GYpKKt;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZOQYO {
    public static void A2egSU(WebView webView, int i, int i2) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (i == 0) {
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
        }
        settings.setDomStorageEnabled(true);
        if (i2 == 0) {
            settings.setCacheMode(2);
        }
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setMixedContentMode(0);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
    }
}
