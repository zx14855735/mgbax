package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends AlertDialog {
    protected static volatile AtomicInteger hf = new AtomicInteger(0);
    private SSWebView c;
    private xj d;
    private String f;
    private boolean g;
    private ImageView kd;
    private HashMap<String, String> p;

    /* renamed from: pl, reason: collision with root package name */
    private List<w> f10461pl;
    private String tf;
    private Button u;
    private Button w;
    protected Context xj;
    private ListView y;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.hf$hf, reason: collision with other inner class name */
    public class C0197hf extends ArrayAdapter<w> {

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.hf$hf$xj */
        public class xj {
            private TextView hf;
            private ImageView u;
            private TextView w;

            public xj() {
            }
        }

        public C0197hf(Context context, int i, List<w> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            xj xjVar;
            View view2;
            w wVar = (w) getItem(i);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(hf.this.xj);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, r.w(hf.this.xj, 17.0f));
                TextView textView = new TextView(hf.this.xj);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int w = r.w(hf.this.xj, 16.0f);
                layoutParams.leftMargin = w;
                layoutParams.rightMargin = w;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, r.w(hf.this.xj, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(hf.this.xj);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(w, w);
                layoutParams2.topMargin = r.w(hf.this.xj, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                jk.xj(hf.this.xj, "tt_open_app_detail_list_item", (View) imageView);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(hf.this.xj);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = r.w(hf.this.xj, 8.0f);
                layoutParams3.topMargin = r.w(hf.this.xj, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                xjVar = new xj();
                xjVar.hf = textView;
                xjVar.w = textView2;
                xjVar.u = imageView;
                relativeLayout.setTag(xjVar);
                view2 = relativeLayout;
            } else {
                xjVar = (xj) view.getTag();
                view2 = view;
            }
            xjVar.u.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(wVar.xj())) {
                xjVar.u.setVisibility(4);
            }
            xjVar.hf.setText(wVar.xj());
            xjVar.w.setText(wVar.hf());
            return view2;
        }
    }

    public class w {
        private String hf;
        private String w;

        public w(String str, String str2) {
            this.hf = str;
            this.w = str2;
        }

        public String hf() {
            return this.w;
        }

        public String xj() {
            return this.hf;
        }
    }

    public interface xj {
        void hf(Dialog dialog);

        void w(Dialog dialog);

        void xj(Dialog dialog);
    }

    static {
        fUIev();
    }

    public hf(Context context, String str) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.f10461pl = new ArrayList();
        this.g = false;
        this.xj = context;
        this.tf = str;
    }

    private static /* synthetic */ void fUIev() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private LinearLayout hf(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.xj);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.xj, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private void kd() {
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        if (this.xj.getResources().getConfiguration().orientation == 1) {
            setContentView(hf(1));
        } else {
            setContentView(hf(0));
        }
    }

    private void u() {
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        if (this.xj.getResources().getConfiguration().orientation == 1) {
            setContentView(xj(1));
        } else {
            setContentView(xj(0));
        }
    }

    private LinearLayout w(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int w2 = r.w(this.xj, 16.0f);
        linearLayout2.setPadding(w2, w2, w2, w2);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.u = new Button(this.xj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int w3 = r.w(this.xj, 7.0f);
        layoutParams2.leftMargin = w3;
        layoutParams2.rightMargin = w3;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(r.w(this.xj, 3.0f));
        gradientDrawable.setStroke(r.w(this.xj, 0.5f), Color.parseColor("#E0161823"));
        this.u.setBackground(gradientDrawable);
        int w4 = r.w(this.xj, 12.0f);
        this.u.setText("上一步");
        this.u.setPadding(0, w4, 0, w4);
        this.u.setTextColor(Color.parseColor("#A8161823"));
        this.u.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.u);
        return xj(i, linearLayout, relativeLayout, linearLayout2, w3, w4);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        hf.set(0);
        xj xjVar = this.d;
        if (xjVar != null) {
            xjVar.hf(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hf();
        if (this.g) {
            kd();
        } else {
            u();
        }
        w();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    private View xj(int i) {
        LinearLayout linearLayout = new LinearLayout(this.xj);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.xj);
        LinearLayout.LayoutParams layoutParams2 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.xj);
        LinearLayout.LayoutParams layoutParams3 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(r.w(this.xj, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.xj);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return xj(i, linearLayout, linearLayout2, relativeLayout);
    }

    private View hf(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.xj);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.xj);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.xj);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(r.w(this.xj, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return xj(i, linearLayout, relativeLayout);
    }

    private LinearLayout u(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.xj);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.xj, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    public void w() {
        if (this.g) {
            xj();
        } else {
            SSWebView sSWebView = this.c;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.xj());
            }
        }
        this.w.setVisibility(0);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.hf.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hf.hf.set(0);
                if (hf.this.d != null) {
                    hf.this.d.xj(hf.this);
                }
            }
        });
        this.kd.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.hf.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hf.hf.set(0);
                if (hf.this.d != null) {
                    hf.this.d.hf(hf.this);
                }
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.hf.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hf.hf.set(0);
                if (hf.this.d != null) {
                    hf.this.d.w(hf.this);
                }
            }
        });
        List<w> list = this.f10461pl;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.y.setAdapter((ListAdapter) new C0197hf(this.xj, 0, this.f10461pl));
    }

    private LinearLayout hf(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.xj);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.xj, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.c = new SSWebView(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.c.setLayoutParams(layoutParams);
        relativeLayout.addView(this.c);
        View view2 = new View(this.xj);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.xj, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return w(i, linearLayout, relativeLayout);
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.xj);
        this.kd = imageView;
        imageView.setMaxHeight(r.w(this.xj, 46.0f));
        this.kd.setMaxWidth(r.w(this.xj, 46.0f));
        this.kd.setMinimumHeight(r.w(this.xj, 46.0f));
        this.kd.setMinimumWidth(r.w(this.xj, 46.0f));
        this.kd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.w wVar = new com.bytedance.sdk.openadsdk.res.w(r.w(this.xj, 14.0f));
        wVar.xj(com.sigmob.sdk.base.blurkit.d.f13043a);
        wVar.xj(r.w(this.xj, 2.0f));
        this.kd.setImageDrawable(wVar);
        relativeLayout.addView(this.kd);
        TextView textView = new TextView(this.xj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view = new View(this.xj);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, r.w(this.xj, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return xj(i, linearLayout, xj(linearLayout2, view));
    }

    public void hf() {
        if (TextUtils.isEmpty(this.tf)) {
            xj(this.p);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(new JSONObject(this.tf));
            if (kd != null) {
                HashMap<String, String> xj2 = kd.xj();
                this.p = xj2;
                if (!xj2.isEmpty()) {
                    this.g = false;
                    xj(this.p);
                } else if (!TextUtils.isEmpty(kd.hf())) {
                    this.f = kd.hf();
                    this.g = true;
                } else {
                    xj(this.p);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private LinearLayout xj(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.xj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.y = new ListView(this.xj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = r.w(this.xj, 20.0f);
        int w2 = r.w(this.xj, 16.0f);
        this.y.setPadding(w2, 0, w2, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(r.w(this.xj, 1.0f), Color.parseColor("#F0F0F0"));
        this.y.setDivider(gradientDrawable);
        this.y.setDividerHeight(r.w(this.xj, 24.0f));
        this.y.setSelector(new ColorDrawable(0));
        this.y.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.y);
        View view2 = new View(this.xj);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, r.w(this.xj, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int w2 = r.w(this.xj, 16.0f);
        linearLayout3.setPadding(w2, w2, w2, w2);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.u = new Button(this.xj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int w3 = r.w(this.xj, 7.0f);
        layoutParams2.leftMargin = w3;
        layoutParams2.rightMargin = w3;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(r.w(this.xj, 3.0f));
        gradientDrawable.setStroke(r.w(this.xj, 0.5f), Color.parseColor("#E0161823"));
        this.u.setBackground(gradientDrawable);
        int w4 = r.w(this.xj, 12.0f);
        this.u.setText("上一步");
        this.u.setPadding(0, w4, 0, w4);
        this.u.setTextColor(Color.parseColor("#A8161823"));
        this.u.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.u);
        return xj(w3, w4, linearLayout3, hf(i, linearLayout, linearLayout2));
    }

    private LinearLayout xj(int i, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.w = new Button(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(r.w(this.xj, 3.0f));
        this.w.setBackground(gradientDrawable);
        this.w.setText("立即下载");
        this.w.setPadding(0, i2, 0, i2);
        this.w.setTextColor(-1);
        this.w.setLayoutParams(layoutParams);
        linearLayout.addView(this.w);
        return linearLayout2;
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.xj);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.xj);
        this.kd = imageView;
        imageView.setMaxHeight(r.w(this.xj, 46.0f));
        this.kd.setMaxWidth(r.w(this.xj, 46.0f));
        this.kd.setMinimumHeight(r.w(this.xj, 46.0f));
        this.kd.setMinimumWidth(r.w(this.xj, 46.0f));
        this.kd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.w wVar = new com.bytedance.sdk.openadsdk.res.w(r.w(this.xj, 14.0f));
        wVar.xj(com.sigmob.sdk.base.blurkit.d.f13043a);
        wVar.xj(r.w(this.xj, 2.0f));
        this.kd.setImageDrawable(wVar);
        relativeLayout2.addView(this.kd);
        TextView textView = new TextView(this.xj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2);
        return hf(i, linearLayout, relativeLayout);
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i2, int i3) {
        return xj(i2, i3, linearLayout2, u(i, linearLayout, relativeLayout));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void xj() {
        this.c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.xj, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.hf.1
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
                this.f = hf.hf;
                return super.xj(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u
            public boolean xj(WebView webView, String str) {
                this.f = hf.hf;
                return super.xj(webView, str);
            }
        });
        this.c.setJavaScriptEnabled(true);
        this.c.setDisplayZoomControls(false);
        this.c.setCacheMode(2);
        this.c.loadUrl(this.f);
    }

    private void xj(HashMap<String, String> hashMap) {
        List<w> list = this.f10461pl;
        if (list != null && list.size() > 0) {
            this.f10461pl.clear();
        }
        if (this.f10461pl == null) {
            this.f10461pl = new ArrayList();
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                this.f10461pl.add(new w(str, hashMap.get(str)));
            }
            return;
        }
        this.f10461pl.add(new w("补充中，可于应用官网查看", ""));
    }

    public hf xj(xj xjVar) {
        this.d = xjVar;
        return this;
    }
}
