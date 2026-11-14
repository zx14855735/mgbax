package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends AlertDialog {
    protected static volatile AtomicInteger w = new AtomicInteger(0);
    private Button c;
    private xj d;
    private Button f;
    protected String hf;
    private Context kd;
    private SSWebView u;
    protected String xj;
    private ImageView y;

    public interface xj {
        void hf(Dialog dialog);

        void w(Dialog dialog);

        void xj(Dialog dialog);
    }

    static {
        feIAN();
    }

    public kd(Context context, String str, String str2, String str3) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.kd = context;
        this.xj = str;
        this.hf = str3;
        if (TextUtils.isEmpty(str) || !(this.xj.startsWith("https") || this.xj.startsWith(Constants.HTTP))) {
            this.xj = str2;
        }
    }

    private static /* synthetic */ void feIAN() {
        char[] charArray = "¥©«è¡§«£è¤©¿èµ®£ªªè\u008c¨¯\u0084´¯¢¡£".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 198);
        }
        String str = new String(charArray);
        char[] charArray2 = "¥ª¯¨¯²".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 198);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        w.set(0);
        xj xjVar = this.d;
        if (xjVar != null) {
            xjVar.hf(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kd == null) {
            this.kd = pz.getContext();
        }
        xj();
    }

    private View xj(int i) {
        LinearLayout linearLayout = new LinearLayout(this.kd);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.kd);
        LinearLayout.LayoutParams layoutParams2 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.kd);
        LinearLayout.LayoutParams layoutParams3 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(r.w(this.kd, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.kd);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.kd);
        this.y = imageView;
        imageView.setMaxHeight(r.w(this.kd, 46.0f));
        this.y.setMaxWidth(r.w(this.kd, 46.0f));
        this.y.setMinimumHeight(r.w(this.kd, 46.0f));
        this.y.setMinimumWidth(r.w(this.kd, 46.0f));
        this.y.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.w wVar = new com.bytedance.sdk.openadsdk.res.w(r.w(this.kd, 14.0f));
        wVar.xj(com.sigmob.sdk.base.blurkit.d.f13043a);
        wVar.xj(r.w(this.kd, 2.0f));
        this.y.setImageDrawable(wVar);
        relativeLayout.addView(this.y);
        TextView textView = new TextView(this.kd);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.hf);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.kd);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.kd, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.u = new SSWebView(this.kd);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.u.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.u);
        View view3 = new View(this.kd);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.kd, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.kd);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int w2 = r.w(this.kd, 16.0f);
        linearLayout3.setPadding(w2, w2, w2, w2);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.f = new Button(this.kd);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int w3 = r.w(this.kd, 7.0f);
        layoutParams7.leftMargin = w3;
        layoutParams7.rightMargin = w3;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(r.w(this.kd, 3.0f));
        gradientDrawable2.setStroke(r.w(this.kd, 0.5f), Color.parseColor("#E0161823"));
        this.f.setBackground(gradientDrawable2);
        int w4 = r.w(this.kd, 12.0f);
        this.f.setText("上一步");
        this.f.setPadding(0, w4, 0, w4);
        this.f.setTextColor(Color.parseColor("#A8161823"));
        this.f.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.f);
        this.c = new Button(this.kd);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = w3;
        layoutParams8.rightMargin = w3;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(r.w(this.kd, 3.0f));
        this.c.setBackground(gradientDrawable3);
        this.c.setText("立即下载");
        this.c.setPadding(0, w4, 0, w4);
        this.c.setTextColor(-1);
        this.c.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.c);
        if (i == 0) {
            return linearLayout;
        }
        View view4 = new View(this.kd);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.kd, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void xj() {
        if (this.kd.getResources().getConfiguration().orientation == 1) {
            setContentView(xj(1));
        } else {
            setContentView(xj(0));
        }
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.kd.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kd.w.set(0);
                if (kd.this.d != null) {
                    kd.this.d.hf(kd.this);
                }
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.kd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kd.w.set(0);
                if (kd.this.d != null) {
                    kd.this.d.w(kd.this);
                }
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.kd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kd.w.set(0);
                if (kd.this.d != null) {
                    kd.this.d.xj(kd.this);
                }
            }
        });
        this.u.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.kd, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.kd.4
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
                    String lowerCase = scheme.toLowerCase(Locale.ROOT);
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
                this.f = kd.w;
                return super.xj(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, String str) {
                this.f = kd.w;
                return super.xj(webView, str);
            }
        });
        this.u.setJavaScriptEnabled(true);
        this.u.setDisplayZoomControls(false);
        this.u.setCacheMode(2);
        this.u.loadUrl(this.xj);
    }

    public kd xj(xj xjVar) {
        this.d = xjVar;
        return this;
    }
}
