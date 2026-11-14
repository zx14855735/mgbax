package com.alliance.ssp.ad.activity;

import DjONCG.A4TApA;
import Dphsd2.AzWtSf;
import Dphsd2.B25kr6;
import Dphsd2.B2KMhB;
import Dphsd2.B3GDIM;
import EY4UKY.ADYaiT;
import G58fqA.A2egSU;
import GYpKKt.AZOQYO;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SAAllianceWebViewActivity extends Activity {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final /* synthetic */ int f9687BI9f7h = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ImageView f9688AcNBzu = null;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ImageView f9689AlLFFp = null;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public SurfaceView f9690AmA8tU = null;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public WebView f9691AzWtSf = null;

    /* renamed from: B25kr6, reason: collision with root package name */
    public SAAllianceAdData f9692B25kr6 = null;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public String f9693B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f9694B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f9695B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f9696B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final AzWtSf f9697B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final B25kr6 f9698BChYOn;

    public SAAllianceWebViewActivity() {
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f9693B2KMhB = "";
        this.f9694B3GDIM = 0;
        this.f9695B4ZgIw = 0;
        this.f9696B7CMnp = 0;
        this.f9697B9tovu = new AzWtSf();
        this.f9698BChYOn = new B25kr6();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Material material;
        super.onCreate(bundle);
        setContentView(2131493195);
        this.f9688AcNBzu = (ImageView) findViewById(2131296780);
        this.f9689AlLFFp = (ImageView) findViewById(2131296781);
        this.f9690AmA8tU = (SurfaceView) findViewById(2131298038);
        this.f9691AzWtSf = (WebView) findViewById(2131298329);
        if (getIntent() == null) {
            return;
        }
        SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) getIntent().getParcelableExtra("extra_name_land_page_ad_data");
        this.f9692B25kr6 = sAAllianceAdData;
        if (sAAllianceAdData == null || (material = sAAllianceAdData.getMaterial()) == null) {
            return;
        }
        String ldp = material.getLdp();
        if (TextUtils.isEmpty(ldp)) {
            return;
        }
        this.f9694B3GDIM = this.f9692B25kr6.getWebViewReplaceTagCode();
        this.f9695B4ZgIw = this.f9692B25kr6.getWebViewCloseAccess();
        this.f9696B7CMnp = this.f9692B25kr6.getWebViewCloseCache();
        TextUtils.isEmpty(material.getVideourl());
        this.f9690AmA8tU.setVisibility(8);
        this.f9688AcNBzu.setOnClickListener(new B2KMhB(this, 0));
        this.f9689AlLFFp.setOnClickListener(new B2KMhB(this, 1));
        WebView webView = this.f9691AzWtSf;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.setWebViewClient(this.f9697B9tovu);
        webView.setWebChromeClient(this.f9698BChYOn);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        AZOQYO.A2egSU(this.f9691AzWtSf, this.f9695B4ZgIw, this.f9696B7CMnp);
        WebSettings settings = this.f9691AzWtSf.getSettings();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.densityDpi;
        if (i == 120) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        } else if (i == 160) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else if (i == 240) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        }
        this.f9693B2KMhB = this.f9692B25kr6.getTagCode();
        WebView webView2 = this.f9691AzWtSf;
        SAAllianceAdData sAAllianceAdData2 = this.f9692B25kr6;
        A4TApA a4TApA = new A4TApA();
        a4TApA.f2422A2egSU = this;
        a4TApA.f2423A4TApA = sAAllianceAdData2;
        webView2.setDownloadListener(a4TApA);
        this.f9691AzWtSf.setWebViewClient(new B3GDIM(this));
        String str = this.f9693B2KMhB;
        if (str == null || str.isEmpty() || this.f9694B3GDIM != 0) {
            this.f9691AzWtSf.loadUrl(ldp);
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("X-Requested-With", URLEncoder.encode(this.f9693B2KMhB, "UTF-8"));
            this.f9691AzWtSf.loadUrl(ldp, hashMap);
        } catch (UnsupportedEncodingException e) {
            this.f9691AzWtSf.loadUrl(ldp);
            ADYaiT aDYaiT = new ADYaiT();
            StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("SAAllianceWebViewActivity 004: ");
            AMqCpz.append(e.getMessage());
            aDYaiT.AmA8tU("004", AMqCpz.toString(), e);
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        A2egSU.A5SV6n(this, "SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }
}
