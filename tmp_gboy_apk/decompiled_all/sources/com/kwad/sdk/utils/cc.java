package com.kwad.sdk.utils;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class cc {
    public static void a(WebView webView, String str, String str2) {
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("javascript:", str, "(");
        B3GDIM2.append(JSONObject.quote(str2));
        B3GDIM2.append(")");
        a(webView, B3GDIM2.toString(), (ValueCallback<String>) null);
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private static void a(final WebView webView, final String str, ValueCallback<String> valueCallback) {
        final ValueCallback valueCallback2 = null;
        runOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.cc.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    webView.evaluateJavascript(str, valueCallback2);
                } catch (Exception unused) {
                }
            }
        });
    }
}
