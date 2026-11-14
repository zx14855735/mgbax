package com.fl.saas.common.widget.h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.C;
import com.fl.saas.common.widget.h5.SignUrlWebView;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdH5Activity extends Activity {
    private boolean enableQuickApp;
    private String html;
    private ImageView ivBack;
    private ImageView ivRefresh;
    private TextView titleView;
    private String url;
    private SignUrlWebView webView;

    public class MyWebViewDownLoadListener implements DownloadListener {
        public MyWebViewDownLoadListener() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            YdH5Activity.this.downloadByBrowser(str);
        }
    }

    private void bindDownloaderListener() {
        this.webView.setDownloadListener(new MyWebViewDownLoadListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadByBrowser(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    private void initChildView(RelativeLayout relativeLayout) {
        this.ivBack = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DeviceUtil.dip2px(30.0f), DeviceUtil.dip2px(20.0f));
        layoutParams.addRule(15);
        layoutParams.setMargins(DeviceUtil.dip2px(10.0f), 0, 0, 0);
        this.ivBack.setLayoutParams(layoutParams);
        this.ivRefresh = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DeviceUtil.dip2px(20.0f), DeviceUtil.dip2px(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, DeviceUtil.dip2px(20.0f), 0);
        this.ivRefresh.setLayoutParams(layoutParams2);
        this.ivBack.setImageResource(R.mipmap.yd_saas_icon_back);
        this.ivRefresh.setImageResource(R.mipmap.yd_saas_icon_refresh);
        TextView textView = new TextView(this);
        this.titleView = textView;
        textView.setTextColor(-12303292);
        this.titleView.setSingleLine();
        this.titleView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.titleView.setTextSize(18.0f);
        this.titleView.setGravity(17);
        relativeLayout.addView(this.titleView, J3FDQU.A2egSU.ASJ6gh(DeviceUtil.getMobileWidth() - DeviceUtil.dip2px(100.0f), -2, 13));
        relativeLayout.addView(this.ivBack);
        relativeLayout.addView(this.ivRefresh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getIntent().getStringExtra("title");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
        }
        this.titleView.setText(str);
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra("url", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        context.startActivity(intent);
    }

    public static void launchWithEnableQuickApp(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra("url", str);
        intent.putExtra("enableQuickApp", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        context.startActivity(intent);
    }

    private void operateClick() {
        this.ivRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.common.widget.h5.YdH5Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (YdH5Activity.this.webView != null) {
                    YdH5Activity.this.webView.reload();
                }
            }
        });
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.common.widget.h5.YdH5Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!YdH5Activity.this.webView.canGoBack() || YdH5Activity.this.webView.getUrl().equals(YdH5Activity.this.url)) {
                    YdH5Activity.this.onBackPressed();
                } else {
                    YdH5Activity.this.webView.goBack();
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, DeviceUtil.dip2px(40.0f)));
        initChildView(relativeLayout);
        operateClick();
        try {
            this.url = getIntent().getStringExtra("url");
            this.html = getIntent().getStringExtra("htmlSnippet");
            this.enableQuickApp = getIntent().getBooleanExtra("enableQuickApp", false);
            String stringExtra = getIntent().getStringExtra("title");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.titleView.setText(stringExtra);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        SignUrlWebView signUrlWebView = new SignUrlWebView(this);
        this.webView = signUrlWebView;
        signUrlWebView.setEnableQuickApp(this.enableQuickApp);
        this.webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        if (LogcatUtil.isDebug) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.webView.setStatusListener(new SignUrlWebView.WebViewStatus() { // from class: com.fl.saas.common.widget.h5.A2egSU
            @Override // com.fl.saas.common.widget.h5.SignUrlWebView.WebViewStatus
            public final void onTitle(String str) {
                YdH5Activity.this.lambda$onCreate$0(str);
            }
        });
        linearLayout.removeAllViews();
        linearLayout.addView(relativeLayout);
        linearLayout.addView(this.webView);
        setContentView(linearLayout);
        LogcatUtil.d("YdSDK-YdH5Activity", "url: " + this.url);
        if (!TextUtils.isEmpty(this.url)) {
            this.webView.loadUrl(this.url);
        } else if (!TextUtils.isEmpty(this.html)) {
            this.webView.loadDataWithBaseURL(null, this.html, "text/html", "UTF-8", null);
        }
        bindDownloaderListener();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QuickAppHelper.getInstance().clearHistory();
    }

    public static void launch(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra(z ? "htmlSnippet" : "url", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        context.startActivity(intent);
    }
}
