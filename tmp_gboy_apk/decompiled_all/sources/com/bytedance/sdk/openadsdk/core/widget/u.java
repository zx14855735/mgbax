package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.widget.SSWebView;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends AlertDialog {
    protected static volatile AtomicInteger y = new AtomicInteger(0);
    private String c;
    protected Context hf;
    protected xj kd;
    protected String u;
    protected TextView w;
    protected SSWebView xj;

    public interface xj {
        void xj(Dialog dialog);
    }

    static {
        IeKeY();
    }

    public u(Context context, String str, String str2) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.hf = context;
        this.c = str2;
        this.u = str;
    }

    private static /* synthetic */ void IeKeY() {
        char[] charArray = "ÓßÝ\u009e×ÑÝÕ\u009eÒßÉ\u009eÃØÕÜÜ\u009eúÞÙòÂÙÔ×Õ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 176);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÓÜÙÞÙÄ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 176);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        y.set(0);
        xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.xj(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.kd.tu(getContext()));
        xj();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void xj() {
        this.xj = (SSWebView) findViewById(2114387839);
        this.w = (TextView) findViewById(2114387912);
        ((TextView) findViewById(2114387696)).setText(this.c);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.y.set(0);
                u uVar = u.this;
                xj xjVar = uVar.kd;
                if (xjVar != null) {
                    xjVar.xj(uVar);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.xj.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.hf, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.u.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains(Constants.HTTP) && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, WebResourceRequest webResourceRequest) {
                this.f = u.y;
                return super.xj(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, String str) {
                this.f = u.y;
                return super.xj(webView, str);
            }
        });
        this.xj.setJavaScriptEnabled(true);
        this.xj.setDisplayZoomControls(false);
        this.xj.setCacheMode(2);
        this.xj.loadUrl(this.u);
    }

    public u xj(xj xjVar) {
        this.kd = xjVar;
        return this;
    }
}
