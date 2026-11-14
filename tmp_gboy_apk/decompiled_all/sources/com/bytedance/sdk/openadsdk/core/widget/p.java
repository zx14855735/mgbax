package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.pz;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p extends AlertDialog {
    protected static volatile AtomicInteger xj = new AtomicInteger(0);
    private String c;
    private RelativeLayout d;
    private RelativeLayout f;
    private SSWebView hf;
    private String kd;
    private ImageView p;
    private ImageView tf;
    private TextView u;
    private Context w;
    private xj y;

    public interface xj {
        void xj(Dialog dialog);
    }

    static {
        UlWLvF();
    }

    public p(Context context, String str) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.c = str;
        this.w = context;
    }

    private static /* synthetic */ void UlWLvF() {
        char[] charArray = ":64w>84<w;6 w*1<55w\u001370\u001b+0=><".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Y');
        }
        String str = new String(charArray);
        char[] charArray2 = ":5070-".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        xj.set(0);
        xj xjVar = this.y;
        if (xjVar != null) {
            xjVar.xj(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.kd.ws(this.w));
        hf();
        xj();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hf() {
        this.hf = (SSWebView) findViewById(2114387763);
        TextView textView = (TextView) findViewById(2114387652);
        this.u = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.y != null) {
                    p.this.y.xj(p.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.hf.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.w, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.p.2
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
                    String lowerCase = scheme.toLowerCase(Locale.US);
                    if (!lowerCase.contains(Constants.HTTP) && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, WebResourceRequest webResourceRequest) {
                this.f = p.xj;
                return super.xj(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, String str) {
                this.f = p.xj;
                return super.xj(webView, str);
            }
        });
        this.hf.setJavaScriptEnabled(true);
        this.hf.setDisplayZoomControls(false);
        this.hf.setCacheMode(2);
        this.hf.loadUrl(this.kd);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387883);
        this.f = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387894);
        this.d = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.u.setVisibility(8);
        this.tf = (ImageView) findViewById(2114387813);
        this.p = (ImageView) findViewById(2114387836);
        this.tf.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.y != null) {
                    p.this.y.xj(p.this);
                    p.xj.set(0);
                }
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) p.this.w.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, p.this.kd));
                    x.xj(p.this.w, "链接复制成功", 1);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                    x.xj(p.this.w, "链接复制失败", 1);
                }
            }
        });
    }

    public void xj() {
        String he = pz.hf().he();
        if (TextUtils.isEmpty(he)) {
            this.kd = "https://www.pangle.cn/privacy/partner";
        } else {
            this.kd = he;
        }
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        if (this.kd.contains("?")) {
            this.kd += "&ad_info=" + this.c;
            return;
        }
        this.kd += "?ad_info=" + this.c;
    }

    public p xj(xj xjVar) {
        this.y = xjVar;
        return this;
    }
}
