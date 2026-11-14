package com.bytedance.sdk.component.xj;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class et extends xj {
    static final /* synthetic */ boolean tf = true;
    protected com.bytedance.sdk.component.g.w d;
    protected String f;

    @Override // com.bytedance.sdk.component.xj.xj
    public Context getContext(tf tfVar) {
        Context context = tfVar.kd;
        if (context != null) {
            return context;
        }
        com.bytedance.sdk.component.g.w wVar = tfVar.xj;
        if (wVar != null) {
            View view = wVar.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = tfVar.xj.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.xj.xj
    public void hf() {
        super.hf();
        u();
    }

    @Override // com.bytedance.sdk.component.xj.xj
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    public void u() {
        com.bytedance.sdk.component.g.w wVar = this.d;
        if (wVar != null) {
            wVar.removeJavascriptInterface(this.f);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void w() {
        if (!tf && this.d == null) {
            throw new AssertionError();
        }
        com.bytedance.sdk.component.g.w wVar = this.d;
        if (wVar != null) {
            wVar.addJavascriptInterface(this, this.f);
        }
    }

    @Override // com.bytedance.sdk.component.xj.xj
    public String xj() {
        return this.d.getUrl();
    }

    @Override // com.bytedance.sdk.component.xj.xj
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void xj(tf tfVar) {
        this.d = tfVar.xj;
        this.f = tfVar.w;
        if (tfVar.am) {
            return;
        }
        w();
    }

    private void xj(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.u.post(runnable);
        }
    }

    @Override // com.bytedance.sdk.component.xj.xj
    public void xj(String str, zg zgVar) {
        if (zgVar != null && !TextUtils.isEmpty(zgVar.f)) {
            String str2 = zgVar.f;
            xj(str, CtFAbx.B25kr6(A2egSU.BChYOn("javascript:(function(){   const iframe = document.querySelector(atob('", Base64.encodeToString(("iframe[src=\"" + str2 + "\"").getBytes(), 2), "'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(", str, ", atob('"), Base64.encodeToString(str2.getBytes(), 2), "'));   }})()"));
            return;
        }
        super.xj(str, zgVar);
    }

    @Override // com.bytedance.sdk.component.xj.xj
    public void xj(String str) {
        xj(str, com.bykv.vk.component.ttvideo.player.A2egSU.AzWtSf(new StringBuilder("javascript:"), this.f, "._handleMessageFromToutiao(", str, ")"));
    }

    private void xj(String str, final String str2) {
        if (this.y || TextUtils.isEmpty(str2)) {
            return;
        }
        xj(new Runnable() { // from class: com.bytedance.sdk.component.xj.et.1
            @Override // java.lang.Runnable
            public void run() {
                if (et.this.y) {
                    return;
                }
                try {
                    d.xj("Invoking Jsb using evaluateJavascript: " + str2);
                    et.this.d.evaluateJavascript(str2, null);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
        });
    }
}
