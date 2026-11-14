package com.fl.saas.common.widget.h5;

import ADYaiT.AZOQYO;
import ADYaiT.AlLFFp;
import DaOi9o.AYUAbz;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.bykv.vk.component.ttvideo.player.C;
import com.fl.saas.base.widget.YdCommonDialog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SignUrlWebView extends WebView {
    private boolean enableQuickApp;
    public LinearLayout layout;
    private WebViewStatus mStatus;
    private ProgressBar progressbar;
    private YdCommonDialog ydCommonDialog;

    public class HsWebChromeClient extends WebChromeClient {
        public HsWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            AlLFFp alLFFp = new AlLFFp(SignUrlWebView.this.getContext());
            AZOQYO azoqyo = alLFFp.f81AcNBzu;
            azoqyo.f28ASJ6gh = str2;
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.fl.saas.common.widget.h5.SignUrlWebView.HsWebChromeClient.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            };
            azoqyo.f29AYUAbz = azoqyo.f23A2egSU.getText(R.string.ok);
            azoqyo.f30AZOQYO = onClickListener;
            azoqyo.f35AmA8tU = false;
            alLFFp.A2egSU().show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            AlLFFp alLFFp = new AlLFFp(SignUrlWebView.this.getContext());
            AZOQYO azoqyo = alLFFp.f81AcNBzu;
            azoqyo.f28ASJ6gh = str2;
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.fl.saas.common.widget.h5.SignUrlWebView.HsWebChromeClient.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            };
            azoqyo.f29AYUAbz = azoqyo.f23A2egSU.getText(R.string.ok);
            azoqyo.f30AZOQYO = onClickListener;
            DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.fl.saas.common.widget.h5.SignUrlWebView.HsWebChromeClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            };
            azoqyo.f31AZkASS = azoqyo.f23A2egSU.getText(R.string.cancel);
            azoqyo.f32AaHO0E = onClickListener2;
            alLFFp.A2egSU().show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            ProgressBar progressBar;
            int i2;
            if (i != 100) {
                if (SignUrlWebView.this.progressbar.getVisibility() != 0) {
                    progressBar = SignUrlWebView.this.progressbar;
                    i2 = 0;
                }
                super.onProgressChanged(webView, i);
            }
            progressBar = SignUrlWebView.this.progressbar;
            i2 = 8;
            progressBar.setVisibility(i2);
            super.onProgressChanged(webView, i);
        }
    }

    public class HsWebViewClient extends WebViewClient {
        public HsWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            SignUrlWebView.this.progressbar.setVisibility(8);
            if (SignUrlWebView.this.mStatus != null) {
                String title = webView.getTitle();
                if (title == null || (webView.getUrl() != null && webView.getUrl().contains(title))) {
                    title = "";
                }
                SignUrlWebView.this.mStatus.onTitle(title);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SignUrlWebView.this.progressbar.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (SignUrlWebView.this.urlCanLoad(webResourceRequest.getUrl().toString().toLowerCase())) {
                return false;
            }
            SignUrlWebView.this.startThirdPartyApp(webResourceRequest.getUrl());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (SignUrlWebView.this.urlCanLoad(str.toLowerCase())) {
                return false;
            }
            SignUrlWebView.this.startThirdPartyApp(Uri.parse(str));
            return true;
        }
    }

    public interface WebViewStatus {
        void onTitle(String str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public SignUrlWebView(Context context) {
        super(context);
        initConfig(context);
    }

    private boolean isInstall(Intent intent) {
        return getContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startThirdPartyApp$0(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        if (isInstall(intent)) {
            getContext().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startThirdPartyApp(Uri uri) {
        if (uri != null) {
            try {
                String uri2 = uri.toString();
                QuickAppHelper.getInstance().reportUrl(uri2);
                if (!(!this.enableQuickApp ? QuickAppHelper.getInstance().urlIntercept(uri2) : false)) {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                    if (isInstall(intent)) {
                        getContext().startActivity(intent);
                        return;
                    }
                    return;
                }
                if (QuickAppHelper.getInstance().getQuickAppInterceptionType() == 1) {
                    if (this.ydCommonDialog == null) {
                        this.ydCommonDialog = new YdCommonDialog(getContext()).setTitle("跳转提示").setContent("想要打开“快应用”\n是否允许").setCanDismiss(false).setCancelName("拒绝").setSubmitName("允许");
                    }
                    if (this.ydCommonDialog.isShowing()) {
                        return;
                    }
                    this.ydCommonDialog.setOnSubmitListener(new AYUAbz(this, 5, uri)).show();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean urlCanLoad(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://") || str.startsWith("file://");
    }

    public ProgressBar getProgressbar() {
        return this.progressbar;
    }

    public void initConfig(Context context) {
        WebView.setWebContentsDebuggingEnabled(false);
        setLayerType(0, null);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDefaultTextEncodingName("UTF-8");
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccess(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setUseWideViewPort(true);
        getSettings().setMixedContentMode(0);
        this.layout = new LinearLayout(context);
        this.layout.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        this.layout.setGravity(17);
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyle);
        this.progressbar = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.layout.addView(this.progressbar);
        addView(this.layout);
        setWebChromeClient(new HsWebChromeClient());
        setWebViewClient(new HsWebViewClient());
    }

    public void setEnableQuickApp(boolean z) {
        this.enableQuickApp = z;
    }

    public void setProgressbar(ProgressBar progressBar) {
        this.progressbar = progressBar;
    }

    public void setStatusListener(WebViewStatus webViewStatus) {
        this.mStatus = webViewStatus;
    }

    public SignUrlWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initConfig(context);
    }
}
