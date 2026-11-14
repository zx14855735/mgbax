package com.octopus.ad.internal.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.R;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.StringUtil;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.utils.b.f;
import java.lang.reflect.Method;
import java.util.LinkedList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BrowserAdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static LinkedList<WebView> f12404a = new LinkedList<>();
    private int b;
    private WebView c;
    private TextView d;

    static {
        tavksM();
    }

    private static /* synthetic */ void tavksM() {
        char[] charArray = "\u0011\u001d\u001f\\\u0015\u0013\u001f\u0017\\\u0010\u001d\u000b\\\u0001\u001a\u0017\u001e\u001e\\8\u001c\u001b0\u0000\u001b\u0016\u0015\u0017".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'r');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0011\u001e\u001b\u001c\u001b\u0006".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        f.a("OctopusAd", "...........................backPressed...........................");
        if (!this.c.canGoBack()) {
            a();
        } else {
            this.c.goBack();
            f.a("OctopusAd", " mWebView.goBack()");
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.oct_activity_in_app_browser);
        WebView poll = f12404a.poll();
        this.c = poll;
        if (poll == null) {
            a();
            return;
        }
        poll.getSettings();
        this.b = getIntent().getIntExtra("REPEAT_NUM", 0);
        this.d = (TextView) findViewById(R.id.tv_title);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setSavePassword(false);
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        int indexOfChild = viewGroup.indexOfChild(webView);
        viewGroup.removeView(webView);
        ViewUtil.removeChildFromParent(this.c);
        this.c.setLayoutParams(layoutParams);
        this.c.getSettings().setUseWideViewPort(true);
        this.c.getSettings().setLoadWithOverviewMode(true);
        WebView.setWebContentsDebuggingEnabled(false);
        viewGroup.addView(this.c, indexOfChild);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.c.setDownloadListener(new DownloadListener() { // from class: com.octopus.ad.internal.activity.BrowserAdActivity.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    BrowserAdActivity.this.c.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    BrowserAdActivity.this.a();
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        });
        this.c.setWebViewClient(new WebViewClient() { // from class: com.octopus.ad.internal.activity.BrowserAdActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                HaoboLog.v(HaoboLog.browserLogTag, HaoboLog.getString(R.string.opening_url, str));
                if (str.startsWith(Constants.HTTP)) {
                    return false;
                }
                BrowserAdActivity.this.a(str);
                return true;
            }
        });
        this.c.setWebChromeClient(new WebChromeClient() { // from class: com.octopus.ad.internal.activity.BrowserAdActivity.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                if (i < 100 && progressBar.getVisibility() == 8) {
                    progressBar.setVisibility(0);
                }
                progressBar.setProgress(i);
                if (i == 100) {
                    progressBar.setVisibility(8);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str) {
                super.onReceivedTitle(webView2, str);
                if (BrowserAdActivity.this.d == null || TextUtils.isEmpty(str) || str.startsWith(Constants.HTTP)) {
                    return;
                }
                BrowserAdActivity.this.d.setText(str);
            }
        });
        ((ImageView) findViewById(R.id.close_iv)).setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.BrowserAdActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrowserAdActivity.this.a();
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        q.a().g.remove("dpForbid");
        ViewUtil.removeChildFromParent(this.c);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Uri parse = StringUtil.isEmpty(str) ? null : Uri.parse(str);
        if (parse == null) {
            HaoboLog.w(HaoboLog.browserLogTag, HaoboLog.getString(R.string.opening_url_failed, str));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        try {
            startActivity(intent);
            if (this.b == 0) {
                a();
            }
            this.b--;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b != 100) {
            finish();
        }
    }
}
