package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.czhj.sdk.common.Constants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends AlertDialog {
    protected static volatile AtomicInteger u = new AtomicInteger(0);
    private TTViewStub am;
    private ImageView c;
    private TextView d;
    private int e;
    private TextView f;
    private com.bytedance.sdk.openadsdk.core.dislike.w.hf g;
    protected Context hf;
    private LinearLayout kd;
    private Intent p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10460pl;
    private TTViewStub qt;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xj tf;
    protected xj w;
    protected SSWebView xj;
    private ImageView y;
    private FrameLayout zg;

    public interface xj {
        void xj(Dialog dialog);
    }

    static {
        nnGdcJ();
    }

    public d(Context context, Intent intent) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.e = 0;
        this.hf = context;
        this.p = intent;
    }

    public static /* synthetic */ int hf(d dVar) {
        int i = dVar.e;
        dVar.e = i - 1;
        return i;
    }

    private static /* synthetic */ void nnGdcJ() {
        char[] charArray = "úöô·þøôü·ûöà·êñüõõ·Ó÷ðÛëðýþü".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 153);
        }
        String str = new String(charArray);
        char[] charArray2 = "úõð÷ðí".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 153);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static /* synthetic */ int w(d dVar) {
        int i = dVar.e;
        dVar.e = i + 1;
        return i;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        u.set(0);
        xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        ws wsVar;
        super.onCreate(bundle);
        getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.hf);
        this.kd = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.kd.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.kd.setOrientation(1);
        this.xj = new SSWebView(this.hf);
        if (this.p != null && (wsVar = TTDelegateActivity.xj) != null) {
            this.g = wsVar.xl();
            this.f10460pl = this.p.getStringExtra("event_tag");
        }
        setContentView(com.bytedance.sdk.openadsdk.res.kd.wo(this.hf));
        hf();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        getWindow().getAttributes().height = r.kd(this.hf) - r.w(this.hf, 50.0f);
    }

    private void w() {
        TTViewStub tTViewStub;
        this.zg = (FrameLayout) findViewById(2114387634);
        this.am = (TTViewStub) findViewById(2114387770);
        this.qt = (TTViewStub) findViewById(2114387792);
        this.zg.addView(this.xj, new LinearLayout.LayoutParams(-1, -1));
        int ai = com.bytedance.sdk.openadsdk.core.f.zg().ai();
        if (ai == 0) {
            TTViewStub tTViewStub2 = this.am;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (ai == 1 && (tTViewStub = this.qt) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.y = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.u.set(0);
                    SSWebView sSWebView = d.this.xj;
                    if (sSWebView != null && sSWebView.canGoBack() && d.this.e > 1) {
                        d.this.xj.goBack();
                        d.hf(d.this);
                        return;
                    }
                    d.this.dismiss();
                    d dVar = d.this;
                    xj xjVar = dVar.w;
                    if (xjVar != null) {
                        xjVar.xj(dVar);
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.c = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.u.set(0);
                    d.this.dismiss();
                    d dVar = d.this;
                    xj xjVar = dVar.w;
                    if (xjVar != null) {
                        xjVar.xj(dVar);
                    }
                }
            });
        }
        this.f = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.d = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.xj();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void hf() {
        ws wsVar;
        w();
        if (this.f != null && (wsVar = TTDelegateActivity.xj) != null && !TextUtils.isEmpty(wsVar.kr())) {
            this.f.setText(TTDelegateActivity.xj.kr());
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.hf).xj(false).hf(false).xj(this.xj);
        this.xj.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.hf, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.d.4
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
                    d.w(d.this);
                    return true;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, WebResourceRequest webResourceRequest) {
                this.f = d.u;
                return super.xj(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, String str) {
                this.f = d.u;
                return super.xj(webView, str);
            }
        });
        this.xj.setJavaScriptEnabled(true);
        this.xj.setDisplayZoomControls(false);
        this.xj.setCacheMode(2);
        this.xj.loadUrl("https://phoniex.toutiao.com");
    }

    public void xj() {
        com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar;
        Context context = this.hf;
        if (context == null || (hfVar = this.g) == null) {
            return;
        }
        if (this.tf == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(context, hfVar, this.f10460pl, true);
            this.tf = xjVar;
            com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.hf, TTDelegateActivity.xj, xjVar);
        }
        this.tf.xj();
    }

    public d xj(xj xjVar) {
        this.w = xjVar;
        return this;
    }
}
