package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f9734a;
    final /* synthetic */ WebView b;
    final /* synthetic */ ae c;

    public ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.c = aeVar;
        this.f9734a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9734a == null || this.b == null) {
            return;
        }
        this.b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f9734a.toString().replace("\"", "\\\"") + "\")");
    }
}
