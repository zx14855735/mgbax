package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.g.hf;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BaseWebView extends WebView {
    protected Boolean ai;
    protected Integer am;
    protected Boolean c;
    protected Boolean d;
    protected Boolean dk;
    protected Boolean e;
    protected Integer et;
    protected Boolean f;
    protected Boolean g;
    protected com.bytedance.sdk.component.widget.hf hf;
    protected Boolean ht;

    /* renamed from: io, reason: collision with root package name */
    protected Boolean f10254io;
    protected Boolean jk;
    protected Integer kd;
    protected Boolean p;

    /* renamed from: pl, reason: collision with root package name */
    protected Boolean f10255pl;
    protected Boolean pz;
    protected hf.xj q;
    protected Integer qt;
    protected Boolean ra;
    protected Boolean tf;
    protected DownloadListener u;
    protected Boolean v;
    protected WebChromeClient w;
    protected Boolean x;
    protected Map<String, xj> xj;
    protected View.OnScrollChangeListener y;
    protected WebSettings.LayoutAlgorithm yo;
    protected String zg;

    public BaseWebView(Context context) {
        super(context);
        this.y = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        hf();
        super.destroy();
    }

    public Boolean getAllowFileAccess() {
        return this.f10255pl;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.tf;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.d;
    }

    public Boolean getAppCacheEnabled() {
        return this.dk;
    }

    public Integer getBackgroundColor() {
        return this.kd;
    }

    public Boolean getBlockNetworkImage() {
        return this.p;
    }

    public Boolean getBuiltInZoomControls() {
        return this.v;
    }

    public Integer getCacheMode() {
        return this.et;
    }

    public WebChromeClient getChromeClient() {
        return this.w;
    }

    public com.bytedance.sdk.component.widget.hf getClient() {
        return this.hf;
    }

    public Boolean getDatabaseEnabled() {
        return this.g;
    }

    public Integer getDefaultFontSize() {
        return this.qt;
    }

    public String getDefaultTextEncodingName() {
        return this.zg;
    }

    public Boolean getDisplayZoomControls() {
        return this.f10254io;
    }

    public Boolean getDomStorageEnabled() {
        return this.jk;
    }

    public DownloadListener getDownloadListener() {
        return this.u;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.pz;
    }

    public Boolean getJavaScriptEnabled() {
        return this.x;
    }

    public Map<String, xj> getJavascriptInterfaces() {
        return this.xj;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.yo;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.e;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.c;
    }

    public Integer getMixedContentMode() {
        return this.am;
    }

    public Boolean getNetworkAvailable() {
        return this.ai;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.y;
    }

    public hf.xj getOnTouchEventListener() {
        return this.q;
    }

    public Boolean getSavePassword() {
        return this.f;
    }

    public Boolean getSupportZoom() {
        return this.ht;
    }

    public Boolean getUseWideViewPort() {
        return this.ra;
    }

    public void hf() {
        this.xj = null;
        this.hf = null;
        this.w = null;
        this.u = null;
        this.y = null;
        this.kd = null;
        this.c = null;
        this.f = null;
        this.d = null;
        this.tf = null;
        this.p = null;
        this.f10255pl = null;
        this.g = null;
        this.am = null;
        this.qt = null;
        this.zg = null;
        this.e = null;
        this.yo = null;
        this.v = null;
        this.jk = null;
        this.pz = null;
        this.ht = null;
        this.ra = null;
        this.dk = null;
        this.et = null;
        this.f10254io = null;
        this.x = null;
        this.ai = null;
        this.q = null;
    }

    public void xj(Runnable runnable) {
        if (xj()) {
            runnable.run();
        } else {
            f.hf().post(runnable);
        }
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = null;
    }

    public boolean xj() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = null;
    }

    public void xj(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "callback");
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            xj(str, jSONObject2);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void xj(String str, JSONObject jSONObject) {
        evaluateJavascript("javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")", null);
    }

    public void hf(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "event");
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            xj(str, jSONObject2);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }
}
