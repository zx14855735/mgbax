package io.dcloud.openapi.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.sdk.internal.an;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.czhj.sdk.common.Constants;
import io.dcloud.base.R;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaae;
import io.dcloud.openapi.core.util.ReflectUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WebViewActivity extends Activity implements View.OnClickListener {
    public static final /* synthetic */ int aeaaaaaa = 0;
    private TextView aaaaaaa0;
    private TextView aaaaaaaa;
    private TextView aaaaaaac;
    private FrameLayout aaaaaaae;
    private aaaaaaau aaaaaaan;
    private TextView aaaaaaao;
    private TextView aaaaaaau;
    private WebView aaaaaaav;
    private boolean aaaaaaeo;
    private String aaaeaaaa = null;
    public ArrayList aaaaeaaa = new ArrayList();
    private boolean aaaaaeaa = false;
    private boolean aaaaaaea = false;
    public Map eaaaaaaa = new aaaaaaaa();

    public class aaaaaaa0 extends WebChromeClient {
        public aaaaaaa0() {
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            super.onGeolocationPermissionsShowPrompt(str, callback);
            if (WebViewActivity.this.aaaaaaea) {
                callback.invoke(str, false, false);
            } else {
                callback.invoke(str, true, false);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (WebViewActivity.this.aaaaaeaa) {
                return;
            }
            if (WebViewActivity.this.aaaaaaan.getParent() == null) {
                WebViewActivity.this.aaaaaaae.addView(WebViewActivity.this.aaaaaaan);
                WebViewActivity.this.aaaaaaan.aaaaaaao();
            } else if (WebViewActivity.this.aaaaaaeo) {
                WebViewActivity.this.aaaaaaeo = false;
                WebViewActivity.this.aaaaaaan.aaaaaaao();
            }
            WebViewActivity.this.aaaaaaan.setVisibility(0);
            if (WebViewActivity.this.aaaaaaan.aaaaaaa0() <= i) {
                WebViewActivity.this.aaaaaaan.aaaaaaaa(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (WebViewActivity.this.aaaaaaao == null || TextUtils.isEmpty(str) || str.startsWith(Constants.HTTP) || str.startsWith("https")) {
                return;
            }
            WebViewActivity.this.aaaaaaao.setText(str);
        }
    }

    public class aaaaaaaa extends HashMap {
        public aaaaaaaa() {
            put("X-Requested-With", "");
        }
    }

    public class aaaaaaac implements aaaaaaaa.aaaaaaa0 {
        public aaaaaaac() {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa.aaaaaaa0
        public void aaaaaaa0(int i) {
            if (i == 1) {
                if (WebViewActivity.this.aaaaaaav != null) {
                    WebViewActivity.this.aaaaaaeo = true;
                    WebViewActivity.this.aaaaaaav.reload();
                    return;
                }
                return;
            }
            if (i == 2) {
                WebViewActivity.this.aaaaaaa0();
            } else if (i == 3) {
                WebViewActivity.this.aaaaaaac();
            } else {
                if (i != 4) {
                    return;
                }
                WebViewActivity.this.aaaaaaau();
            }
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa(int i, TextView textView, String str) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa.aaaaaaa0
        public void aaaaaaaa(TextView textView) {
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa.aaaaaaa0
        public boolean aaaaaaaa(int i) {
            return false;
        }
    }

    public class aaaaaaao extends WebViewClient {

        public class aaaaaaaa implements DialogInterface.OnClickListener {
            final /* synthetic */ Intent aaaaaaaa;

            public aaaaaaaa(Intent intent) {
                this.aaaaaaaa = intent;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                WebViewActivity.this.startActivity(this.aaaaaaaa);
            }
        }

        public aaaaaaao() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebViewActivity.this.aaaaaaa0.setVisibility(webView.canGoBack() ? 0 : 4);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslErrorHandler != null) {
                WebViewActivity.this.aaaaaaaa(sslErrorHandler, "proceed", new Class[0], new Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intent intent;
            String lowerCase = !TextUtils.isEmpty(str) ? str.toLowerCase(Locale.ENGLISH) : "";
            if (TextUtils.isEmpty(lowerCase) || str.startsWith("streamapp://") || lowerCase.startsWith("http://") || lowerCase.startsWith("https://") || lowerCase.contains("streamapp://")) {
                webView.loadUrl(str, WebViewActivity.this.eaaaaaaa);
                WebViewActivity.this.aaaaaaeo = true;
                return true;
            }
            if (!TextUtils.isEmpty(lowerCase)) {
                ArrayList arrayList = WebViewActivity.this.aaaaeaaa;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (lowerCase.startsWith(((String) obj) + ":")) {
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent2.setSelector(null);
                            intent2.setComponent(null);
                            intent2.addCategory("android.intent.category.BROWSABLE");
                            WebViewActivity.this.startActivity(intent2);
                        } catch (Exception unused) {
                        }
                        return true;
                    }
                }
            }
            try {
                if (lowerCase.startsWith("intent://")) {
                    intent = Intent.parseUri(str, 1);
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setComponent(null);
                    intent.setSelector(null);
                } else {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                }
                PackageManager packageManager = WebViewActivity.this.getPackageManager();
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                    String str2 = "即将打开\"Android system\"应用, \n立即打开?";
                    CharSequence loadLabel = 1 == queryIntentActivities.size() ? queryIntentActivities.get(0).loadLabel(packageManager) : "";
                    if (!TextUtils.isEmpty(loadLabel)) {
                        str2 = "即将打开\"" + ((Object) loadLabel) + "\"应用, \n立即打开?";
                    }
                    new AlertDialog.Builder(WebViewActivity.this).setMessage(str2).setPositiveButton("打开", new aaaaaaaa(intent)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create().show();
                }
            } catch (Exception unused2) {
            }
            return true;
        }
    }

    public static class aaaaaaau extends View {
        float aaaaaaa0;
        int aaaaaaaa;
        Paint aaaaaaac;
        int aaaaaaae;
        int aaaaaaan;
        int aaaaaaao;
        int aaaaaaau;
        int aaaaaaav;

        public class aaaaaaa0 implements Runnable {
            public aaaaaaa0() {
            }

            @Override // java.lang.Runnable
            public void run() {
                aaaaaaau aaaaaaauVar = aaaaaaau.this;
                int i = aaaaaaauVar.aaaaaaan;
                int i2 = aaaaaaauVar.aaaaaaau;
                int i3 = 10;
                int i4 = (i - i2) / 10;
                if (i4 <= 10) {
                    i3 = 1;
                    if (i4 >= 1) {
                        i3 = i4;
                    }
                }
                int i5 = i2 + i3;
                aaaaaaauVar.aaaaaaau = i5;
                if (i > i5) {
                    aaaaaaauVar.postDelayed(this, 5L);
                } else if (i >= aaaaaaauVar.aaaaaaaa) {
                    aaaaaaauVar.aaaaaaaa();
                }
                aaaaaaau.this.invalidate();
            }
        }

        public class aaaaaaaa implements Runnable {
            public aaaaaaaa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                aaaaaaau aaaaaaauVar = aaaaaaau.this;
                int i = aaaaaaauVar.aaaaaaae - 5;
                aaaaaaauVar.aaaaaaae = i;
                if (i > 0) {
                    aaaaaaauVar.postDelayed(this, 5L);
                } else {
                    ViewGroup viewGroup = (ViewGroup) aaaaaaauVar.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(aaaaaaau.this);
                    }
                }
                aaaaaaau.this.invalidate();
            }
        }

        public aaaaaaau(Context context) {
            super(context);
            this.aaaaaaao = 0;
            this.aaaaaaac = new Paint();
            this.aaaaaaau = 0;
            this.aaaaaaan = 0;
            this.aaaaaaae = 255;
            this.aaaaaaaa = context.getResources().getDisplayMetrics().widthPixels;
            this.aaaaaaa0 = WebViewActivity.aaaaaaaa(2.0f, getResources().getDisplayMetrics());
        }

        public int aaaaaaa0() {
            return this.aaaaaaav;
        }

        public void aaaaaaaa() {
            postDelayed(new aaaaaaaa(), 50L);
        }

        public void aaaaaaao() {
            this.aaaaaaae = 255;
            this.aaaaaaau = 0;
            this.aaaaaaan = 0;
            this.aaaaaaav = 0;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.aaaaaaac.setColor(Color.argb(this.aaaaaaae, 0, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 68));
            float f = this.aaaaaaao;
            canvas.drawRect(0.0f, f, this.aaaaaaau, f + this.aaaaaaa0, this.aaaaaaac);
        }

        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.aaaaaaaa, this.aaaaaaao + ((int) this.aaaaaaa0));
        }

        public void aaaaaaaa(int i) {
            this.aaaaaaav = i;
            int i2 = (this.aaaaaaaa * i) / 100;
            if (this.aaaaaaau >= this.aaaaaaan) {
                postDelayed(new aaaaaaa0(), 5L);
            }
            this.aaaaaaan = i2;
        }
    }

    private void aaaaaaav() {
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        getIntent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aaaaaaaa) {
            if (aaaaaaaa()) {
                return;
            }
            finish();
        } else if (view == this.aaaaaaa0) {
            finish();
        } else if (view == this.aaaaaaac) {
            aaaaaaao();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.dcloud_ad_activity_webview);
        aaaaaaan();
        aaaaaaae();
        if (TextUtils.isEmpty(this.aaaeaaaa)) {
            return;
        }
        this.aaaaaaav.loadUrl(this.aaaeaaaa, this.eaaaaaaa);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            WebView webView = this.aaaaaaav;
            if (webView != null) {
                if (webView.getParent() != null) {
                    ((ViewGroup) this.aaaaaaav.getParent()).removeView(this.aaaaaaav);
                }
                this.aaaaaaav.clearHistory();
                this.aaaaaaav.clearCache(true);
                this.aaaaaaav.destroy();
            }
            this.aaaaaaav = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean aaaaaaaa2 = aaaaaaaa();
        return !aaaaaaaa2 ? super.onKeyDown(i, keyEvent) : aaaaaaaa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaa0() {
        ((ClipboardManager) getSystemService("clipboard")).setText(this.aaaaaaav.getUrl());
        Toast.makeText(this, "拷贝到剪切板" + this.aaaaaaav.getUrl(), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaac() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.aaaaaaav.getUrl()));
            startActivity(Intent.createChooser(intent, "打开网页"));
        } catch (Exception unused) {
        }
    }

    private void aaaaaaae() {
        Typeface createFromAsset;
        this.aaaaaaaa = (TextView) findViewById(R.id.back);
        this.aaaaaaa0 = (TextView) findViewById(R.id.close);
        this.aaaaaaao = (TextView) findViewById(R.id.title);
        this.aaaaaaau = (TextView) findViewById(R.id.refresh);
        this.aaaaaaac = (TextView) findViewById(R.id.menu);
        this.aaaaaaae = (FrameLayout) findViewById(R.id.content);
        aaaaaaau aaaaaaauVar = new aaaaaaau(this);
        this.aaaaaaan = aaaaaaauVar;
        if (this.aaaaaeaa) {
            aaaaaaauVar.setVisibility(8);
            this.aaaaaaac.setVisibility(4);
        }
        WebView webView = (WebView) findViewById(R.id.webview);
        this.aaaaaaav = webView;
        aaaaaaaa(webView);
        int aaaaaaaa2 = aaaaaaaa(23.0f, getResources().getDisplayMetrics());
        try {
            createFromAsset = Typeface.createFromAsset(getAssets(), "dcloud_uni_ad/dcloud_iconfont.ttf");
        } catch (Exception unused) {
            createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/dcloud_iconfont.ttf");
        }
        this.aaaaaaaa.setText("\ue601");
        this.aaaaaaaa.setTypeface(createFromAsset);
        float f = aaaaaaaa2;
        this.aaaaaaaa.getPaint().setTextSize(f);
        this.aaaaaaa0.setText("\ue650");
        this.aaaaaaa0.setTypeface(createFromAsset);
        this.aaaaaaa0.getPaint().setTextSize(f);
        this.aaaaaaa0.setVisibility(4);
        this.aaaaaaau.setText("\ue606");
        this.aaaaaaau.setTypeface(createFromAsset);
        this.aaaaaaau.getPaint().setTextSize(f);
        this.aaaaaaac.setText("\ue606");
        this.aaaaaaac.setTypeface(createFromAsset);
        this.aaaaaaac.getPaint().setTextSize(f);
        this.aaaaaaaa.setOnClickListener(this);
        this.aaaaaaa0.setOnClickListener(this);
        this.aaaaaaac.setOnClickListener(this);
    }

    private void aaaaaaan() {
        if (getIntent() != null) {
            if (getIntent().hasExtra("url")) {
                this.aaaeaaaa = getIntent().getStringExtra("url");
            }
            if (getIntent().hasExtra("isLocalHtml")) {
                this.aaaaaeaa = getIntent().getBooleanExtra("isLocalHtml", false);
            }
            if (getIntent().hasExtra("isNoPermissionAllowParam")) {
                this.aaaaaaea = getIntent().getBooleanExtra("isNoPermissionAllowParam", false);
            }
        }
        this.aaaaeaaa.add("weixin");
        this.aaaaeaaa.add("alipay");
        this.aaaaeaaa.add("alipays");
        this.aaaaeaaa.add("alipayqr");
    }

    private void aaaaaaao() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa(this);
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", "刷新");
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", "复制链接");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("title", "使用浏览器打开");
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("title", "分享页面");
            jSONArray.put(jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aaaaaaaaVar.aaaaaaaa("取消");
        aaaaaaaaVar.aaaaaaaa(jSONArray);
        aaaaaaaaVar.aaaaaaaa(new aaaaaaac());
        aaaaaaaaVar.aaaaaaaa(true);
        aaaaaaaaVar.aaaaaaeo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaaaaaau() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(an.e);
            intent.putExtra("android.intent.extra.SUBJECT", this.aaaaaaav.getTitle());
            intent.putExtra("android.intent.extra.TEXT", this.aaaaaaav.getUrl());
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            startActivity(Intent.createChooser(intent, "分享"));
        } catch (Exception unused) {
        }
    }

    private void aaaaaaaa(WebView webView) {
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            settings.setDomStorageEnabled(true);
            Class[] clsArr = {Boolean.TYPE};
            Object[] objArr = {Boolean.TRUE};
            settings.setAllowFileAccess(false);
            ReflectUtil.invokeMethod(settings, aaaaaaae.aaaaaaao("e218SWRkZ39OYWRtSWtrbXt7"), clsArr, objArr);
            settings.setSavePassword(false);
            settings.setJavaScriptEnabled(true);
            webView.setFocusable(true);
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.removeJavascriptInterface("accessibility");
            webView.setWebChromeClient(new aaaaaaa0());
            webView.setWebViewClient(new aaaaaaao());
        }
        aaaaaaav();
    }

    private boolean aaaaaaaa() {
        WebView webView = this.aaaaaaav;
        if (webView == null) {
            return false;
        }
        if (webView.canGoBack()) {
            this.aaaaaaeo = true;
            this.aaaaaaav.goBack();
            this.aaaaaaao.setText(this.aaaaaaav.getTitle());
            return true;
        }
        if (this.aaaaaaav.canGoBack()) {
            return false;
        }
        finish();
        return true;
    }

    public Object aaaaaaaa(Object obj, String str, Class[] clsArr, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int aaaaaaaa(float f, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(1, f, displayMetrics));
    }
}
