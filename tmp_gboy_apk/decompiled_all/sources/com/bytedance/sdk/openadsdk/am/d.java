package com.bytedance.sdk.openadsdk.am;

import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    private static void hf(com.bytedance.sdk.component.g.w wVar) {
        try {
            wVar.removeJavascriptInterface("searchBoxJavaBridge_");
            wVar.removeJavascriptInterface("accessibility");
            wVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            c.xj("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void xj(com.bytedance.sdk.component.g.w wVar) {
        hf(wVar);
        try {
            wVar.setJavaScriptEnabled(true);
            wVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            c.xj("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            wVar.setSupportZoom(false);
        } catch (Throwable th2) {
            c.xj("WebViewSettings", "setSupportZoom error", th2);
        }
        wVar.setLoadWithOverviewMode(true);
        wVar.setUseWideViewPort(true);
        wVar.setDomStorageEnabled(true);
        wVar.setAllowFileAccess(false);
        wVar.setBlockNetworkImage(false);
        wVar.setDisplayZoomControls(false);
        int i = Build.VERSION.SDK_INT;
        wVar.setAllowFileAccessFromFileURLs(false);
        wVar.setAllowUniversalAccessFromFileURLs(false);
        wVar.setSavePassword(false);
        boolean z = i >= 28;
        try {
        } catch (Throwable th3) {
            c.xj("WebViewSettings", "setLayerType error", th3);
        }
        if (z) {
            if (z) {
                wVar.setLayerType(2, null);
            }
            wVar.setMixedContentMode(0);
        }
        wVar.setLayerType(0, null);
        wVar.setMixedContentMode(0);
    }
}
