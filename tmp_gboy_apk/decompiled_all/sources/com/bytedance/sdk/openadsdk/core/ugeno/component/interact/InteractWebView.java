package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.sdk.component.adexpress.u.tf;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.pz;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class InteractWebView extends SSWebView {
    private Map<String, Object> c;
    private am d;
    private ws f;
    private Context kd;
    private j y;

    public InteractWebView(Context context) {
        super(context);
        this.kd = context;
    }

    private void xj(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.kd).xj(false).xj(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            pz.xj(sSWebView, ai.w, ws.u(this.f));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("InteractWebView", e.toString());
        }
    }

    public void c() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        xj((SSWebView) this);
        if (this.f != null) {
            Context context = this.kd;
            j jVar = this.y;
            ws wsVar = this.f;
            setWebViewClient(new xj(context, jVar, wsVar, wsVar.ho()));
        } else {
            setWebViewClient(new SSWebView.xj());
        }
        com.bytedance.sdk.component.adexpress.kd.kd.xj().xj(this, this.y);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.y));
    }

    public am getUGenContext() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.g.w
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setUGenContext(am amVar) {
        this.d = amVar;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.c = map;
    }

    public void y() {
        Map<String, Object> map = this.c;
        if (map == null || map.size() <= 0 || !this.c.containsKey("key_material")) {
            return;
        }
        Object obj = this.c.get("key_material");
        if (obj instanceof ws) {
            this.f = (ws) obj;
            this.y = (j) this.c.get("key_js_object");
            if (this.c.containsKey("key_data_list") && (this.c.get("key_data_list") instanceof List)) {
                this.y.hf((List<JSONObject>) this.c.get("key_data_list"));
            }
            this.y.hf(this).xj(this.f).xj(wo.hf(this.f)).hf(this.f.ho()).u(this.f.jf()).kd(wo.zg(this.f)).xj((SSWebView) this);
        }
    }

    public static class xj extends com.bytedance.sdk.openadsdk.core.widget.xj.u {
        private ws xj;

        public xj(Context context, j jVar, ws wsVar, String str) {
            super(context, jVar, str);
            this.xj = wsVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.xj.hf.xj xj = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj.xj(webView, this.xj, str, new xj.InterfaceC0174xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.InteractWebView.xj.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj.InterfaceC0174xj
                    public boolean xj() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj.InterfaceC0174xj
                    public com.bytedance.sdk.component.adexpress.xj.hf.xj xj(String str2, tf.xj xjVar, String str3) {
                        com.bytedance.sdk.component.adexpress.xj.hf.xj xjVar2 = new com.bytedance.sdk.component.adexpress.xj.hf.xj();
                        xjVar2.xj(5);
                        xjVar2.xj(com.bytedance.sdk.openadsdk.core.ugeno.kd.xj.hf().xj(webView, xjVar, str2));
                        return xjVar2;
                    }
                });
                if (xj != null && xj.xj() != null) {
                    return xj.xj();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.w("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }
}
