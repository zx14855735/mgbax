package com.bytedance.sdk.openadsdk.core.activity.base;

import J3FDQU.A2egSU;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.et;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.a.ai;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.dislike.ui.xj;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.playable.hf.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.l;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.yo.u;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTVideoWebPageActivity extends BaseLandingPageActivity implements w.InterfaceC0013w, u {

    /* renamed from: a, reason: collision with root package name */
    private TTProgressBar f10284a;
    private RelativeLayout ai;
    private TextView am;
    protected NativeVideoTsView c;
    private SSWebView d;
    private com.bytedance.sdk.openadsdk.pl.u dc;
    private hf dq;
    private TextView e;
    private TextView en;
    protected w f;
    private Button ff;
    private TextView g;
    private xj hl;
    private FrameLayout ht;
    private TextView j;
    private j jk;
    private TTViewStub l;
    private ImageView p;

    /* renamed from: pl, reason: collision with root package name */
    private TextView f10286pl;
    private RelativeLayout pz;
    private TextView q;
    private TextView qt;
    private long ra;
    private boolean s;
    private ImageView tf;
    private Activity tu;
    private Context v;
    private kd vm;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w wo;
    com.bytedance.sdk.openadsdk.core.dislike.ui.xj y;
    private LinearLayout yo;
    private int yy;
    private RoundImageView z;
    private TextView zg;
    private int dk = 0;
    private int et = 0;

    /* renamed from: io, reason: collision with root package name */
    private int f10285io = 0;
    private int x = 0;
    private final Map<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> r = A2egSU.BIYEnU();
    private boolean b = false;
    private boolean ws = false;
    private boolean eu = true;
    private boolean tj = false;
    private String n = null;
    private AtomicBoolean wn = new AtomicBoolean(true);
    private JSONArray aq = null;
    private int qd = 0;
    private String bl = "立即下载";
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj lw = new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.16
        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void hf(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.hf("暂停");
            if (j > 0) {
                xj.C0198xj.xj(TTVideoWebPageActivity.this.xj, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void w(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.hf("下载失败");
            if (j > 0) {
                xj.C0198xj.xj(TTVideoWebPageActivity.this.xj, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.hf(tTVideoWebPageActivity.am());
            xj.C0198xj.xj(TTVideoWebPageActivity.this.xj, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.hf("下载中...");
            if (j > 0) {
                xj.C0198xj.xj(TTVideoWebPageActivity.this.xj, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, String str, String str2) {
            TTVideoWebPageActivity.this.hf("点击安装");
            xj.C0198xj.xj(TTVideoWebPageActivity.this.xj, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(String str, String str2) {
            TTVideoWebPageActivity.this.hf("点击打开");
            xj.C0198xj.xj(TTVideoWebPageActivity.this.xj, 6, 100);
        }
    };
    private com.bytedance.sdk.openadsdk.core.hf.xj wa = null;
    private final w.hf gh = new w.hf() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.5
        @Override // com.bykv.vk.openvk.component.video.api.u.w.hf
        public void xj(boolean z) {
            TTVideoWebPageActivity.this.b = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (!z) {
                r.xj((View) TTVideoWebPageActivity.this.d, 0);
                r.xj((View) TTVideoWebPageActivity.this.pz, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.ht.getLayoutParams();
                marginLayoutParams.width = TTVideoWebPageActivity.this.f10285io;
                marginLayoutParams.height = TTVideoWebPageActivity.this.x;
                marginLayoutParams.leftMargin = TTVideoWebPageActivity.this.et;
                marginLayoutParams.topMargin = TTVideoWebPageActivity.this.dk;
                TTVideoWebPageActivity.this.ht.setLayoutParams(marginLayoutParams);
                return;
            }
            r.xj((View) TTVideoWebPageActivity.this.d, 8);
            r.xj((View) TTVideoWebPageActivity.this.pz, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.ht.getLayoutParams();
            TTVideoWebPageActivity.this.et = marginLayoutParams2.leftMargin;
            TTVideoWebPageActivity.this.dk = marginLayoutParams2.topMargin;
            TTVideoWebPageActivity.this.f10285io = marginLayoutParams2.width;
            TTVideoWebPageActivity.this.x = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            TTVideoWebPageActivity.this.ht.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean op = false;
    private final et.xj gy = new et.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7
        @Override // com.bytedance.sdk.component.utils.et.xj
        public void xj(Context context, Intent intent, boolean z, int i) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.yy == 0 && i != 0 && TTVideoWebPageActivity.this.d != null && TTVideoWebPageActivity.this.n != null) {
                    f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.d != null) {
                                TTVideoWebPageActivity.this.d.loadUrl(TTVideoWebPageActivity.this.n);
                            }
                        }
                    });
                }
                NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.c;
                if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !TTVideoWebPageActivity.this.et() && TTVideoWebPageActivity.this.yy != i) {
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) TTVideoWebPageActivity.this.c.getNativeVideoController()).xj(context, i);
                }
                TTVideoWebPageActivity.this.yy = i;
            }
        }
    };

    private void dk() {
        if (this.kd == null) {
            return;
        }
        JSONArray w = w(this.n);
        int d = wo.d(this.kd);
        int f = wo.f(this.kd);
        dk<com.bytedance.sdk.openadsdk.core.am.xj> xj = pz.xj();
        if (w == null || xj == null || d <= 0 || f <= 0) {
            return;
        }
        tj tjVar = new tj();
        tjVar.kd = w;
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh = this.kd.gh();
        if (gh == null) {
            return;
        }
        xj.xj(ai.hf(gh).w(6).xj(), tjVar, f, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
                TTVideoWebPageActivity.this.xj(0);
                hfVar.xj(i);
                com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
                if (xjVar != null) {
                    try {
                        TTVideoWebPageActivity.this.wn.set(false);
                        TTVideoWebPageActivity.this.jk.xj(xjVar.w());
                    } catch (Exception unused) {
                        TTVideoWebPageActivity.this.xj(0);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean et() {
        NativeVideoTsView nativeVideoTsView = this.c;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.c.getNativeVideoController().jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void ht() {
        int yo = jk.yo(this.kd);
        ws wsVar = this.kd;
        if (wsVar != null) {
            if (wsVar.vw() == 4 || yo != 0) {
                com.bytedance.sdk.openadsdk.core.pl.hf.w xj = com.bytedance.sdk.openadsdk.core.pl.f.xj((Context) this.tu, this.kd, this.w, false);
                this.wo = xj;
                xj.xj(this.tu);
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.wo;
                if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                    ((com.bytedance.sdk.openadsdk.core.pl.w.kd) wVar).y(true);
                    ((com.bytedance.sdk.openadsdk.core.pl.w.kd) this.wo).f().xj(false);
                }
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.tu, this.kd, "embeded_ad_landingpage", this.u);
                this.wa = xjVar;
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.wa.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
                this.wo.xj(this.kd, false);
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.wa.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.wo);
            }
        }
    }

    private boolean io() {
        ws wsVar = this.kd;
        if (wsVar == null) {
            return false;
        }
        int qd = wsVar.qd();
        return this.u == 1 && "embeded_ad_landingpage".equals(this.w) && (qd == 1 || qd == 2);
    }

    private void jk() {
        ws wsVar = this.kd;
        if (wsVar == null || wsVar.vw() != 4) {
            return;
        }
        r.xj((View) this.ai, 0);
        String kr = !TextUtils.isEmpty(this.kd.kr()) ? this.kd.kr() : !TextUtils.isEmpty(this.kd.uj()) ? this.kd.uj() : !TextUtils.isEmpty(this.kd.ci()) ? this.kd.ci() : "";
        z uf = this.kd.uf();
        if (uf != null && uf.xj() != null) {
            r.xj((View) this.z, 0);
            r.xj((View) this.q, 4);
            com.bytedance.sdk.openadsdk.f.hf.xj(uf).to(this.z);
        } else if (!TextUtils.isEmpty(kr)) {
            r.xj((View) this.z, 4);
            r.xj((View) this.q, 0);
            this.q.setText(kr.substring(0, 1));
        }
        if (this.j != null && !TextUtils.isEmpty(kr)) {
            this.j.setText(kr);
        }
        if (!TextUtils.isEmpty(this.kd.bh())) {
            this.en.setText(this.kd.bh());
        }
        r.xj((View) this.j, 0);
        if (io()) {
            r.xj((View) this.en, 8);
        } else {
            r.xj((View) this.en, 0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void pz() {
        ws wsVar = this.kd;
        if (wsVar == null || wsVar.vw() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.w xj = com.bytedance.sdk.openadsdk.core.pl.f.xj((Context) this.tu, this.kd, this.w, false);
        this.wo = xj;
        xj.xj(this.tu);
        this.wo.xj(tf.xj(this.kd));
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.wo;
        if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
            ((com.bytedance.sdk.openadsdk.core.pl.w.kd) wVar).y(true);
        }
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.tu, this.kd, "embeded_ad_landingpage", this.u);
        this.wa = xjVar;
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.wa.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
        this.en.setOnClickListener(this.wa);
        this.en.setOnTouchListener(this.wa);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.wa.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.wo);
    }

    private void ra() {
        if (this.d == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.kd);
        j jVar = new j(this.tu);
        this.jk = jVar;
        jVar.u(this.s);
        this.jk.hf(this.d).xj(this.kd).w(arrayList).hf(this.xj).xj(this.w).u(this.hf).hf(tf.xj(this.kd)).w(this.u).xj(this.d).xj(true).kd(wo.zg(this.kd));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hf hfVar = this.dq;
        if (hfVar != null) {
            hfVar.xj(this.tu, this.kd);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if ((ws.w(this.kd) || l.xj(this.kd)) && r.xj(this.d)) {
            return;
        }
        if (this.b && (nativeVideoTsView = this.c) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.u.xj) this.c.getNativeVideoController()).kd(null, null);
            this.b = false;
            return;
        }
        hf hfVar = this.dq;
        if (hfVar == null || !hfVar.hf(this.tu, this.kd)) {
            xj("detail_back");
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kd == null) {
            return;
        }
        this.tu = this;
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            pz.xj(this.tu);
        } catch (Throwable unused2) {
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.yy = am.w(getApplicationContext());
        setContentView(com.bytedance.sdk.openadsdk.res.kd.xj(this.tu, this.kd));
        this.v = this.tu;
        Intent intent = getIntent();
        this.s = intent.getBooleanExtra("is_outer_click", false);
        this.qd = intent.getIntExtra("get_phone_num_status", 0);
        String stringExtra = intent.getStringExtra("title");
        this.tj = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.ra = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_data");
        if (stringExtra2 != null) {
            try {
                this.hl = com.bytedance.sdk.openadsdk.core.multipro.hf.xj.xj(new JSONObject(stringExtra2));
            } catch (Exception unused3) {
            }
            com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = this.hl;
            if (xjVar != null) {
                this.ra = xjVar.c;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.kd == null) {
                try {
                    this.kd = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(string));
                } catch (Throwable unused4) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.ra = j;
            }
        }
        String stringExtra3 = intent.getStringExtra("url");
        this.n = stringExtra3;
        this.n = wo.hf(this.kd, stringExtra3);
        qt();
        xj(this.kd);
        pz();
        ra();
        xj(4);
        SSWebView sSWebView = this.d;
        if (sSWebView != null) {
            Context applicationContext = getApplicationContext();
            ws wsVar = this.kd;
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.l.hf.xj(sSWebView, applicationContext, wsVar != null ? wsVar.w() : this.qd, this.kd), "CCWifiJSBridge");
            com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.v).xj(true).hf(false).xj(this.d);
            this.vm = new kd(this.kd, this.d).hf(true).hf(currentTimeMillis).u(this.d.getCreateDuration());
            pl();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.xj);
            jSONObject.put("url", this.n);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.hf.w());
            jSONObject.put("event_tag", this.w);
        } catch (JSONException unused5) {
        }
        this.vm.xj(jSONObject);
        this.d.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.v, this.jk, this.xj, this.vm, this.dc) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoWebPageActivity.this.f10284a == null || TTVideoWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTVideoWebPageActivity.this.f10284a.setVisibility(8);
                } catch (Throwable unused6) {
                }
            }
        });
        SSWebView sSWebView2 = this.d;
        if (sSWebView2 != null) {
            com.bytedance.sdk.openadsdk.core.a.pz.xj(sSWebView2, com.bytedance.sdk.openadsdk.core.ai.w, ws.u(this.kd));
            this.d.setMixedContentMode(0);
        }
        this.d.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.jk, this.vm) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.w, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoWebPageActivity.this.f10284a == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i == 100 && TTVideoWebPageActivity.this.f10284a.isShown()) {
                    TTVideoWebPageActivity.this.f10284a.setVisibility(8);
                } else {
                    TTVideoWebPageActivity.this.f10284a.setProgress(i);
                }
            }
        });
        this.d.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.11
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTVideoWebPageActivity.this.r.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = (com.bytedance.sdk.openadsdk.core.pl.hf.w) TTVideoWebPageActivity.this.r.get(str);
                    if (wVar != null) {
                        wVar.xj(wo.v(TTVideoWebPageActivity.this.kd), false);
                        return;
                    }
                    return;
                }
                Activity activity = TTVideoWebPageActivity.this.tu;
                TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                com.bytedance.sdk.openadsdk.core.pl.hf.w xj = com.bytedance.sdk.openadsdk.core.pl.f.xj(activity, str, tTVideoWebPageActivity.kd, tTVideoWebPageActivity.w);
                xj.xj(tf.xj(TTVideoWebPageActivity.this.kd));
                TTVideoWebPageActivity.this.r.put(str, xj);
                xj.xj(wo.v(TTVideoWebPageActivity.this.kd), false);
            }
        });
        TextView textView = this.f10286pl;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = com.bytedance.sdk.component.utils.jk.xj(this.tu, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        TextView textView2 = this.zg;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.hf(tTVideoWebPageActivity.kd);
                }
            });
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.w(tTVideoWebPageActivity.kd);
                }
            });
        }
        kd();
        e();
        g();
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, getClass().getName());
        this.d.setVisibility(0);
        this.vm.w(System.currentTimeMillis());
        this.d.loadUrl(this.n);
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.kd);
        this.dq = new hf(this.vm.xj());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        y();
        kd kdVar = this.vm;
        if (kdVar != null) {
            kdVar.c();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.d;
        if (sSWebView != null) {
            a.xj(this.v, sSWebView);
            a.xj(this.d);
        }
        this.d = null;
        com.bytedance.sdk.openadsdk.pl.u uVar = this.dc;
        if (uVar != null) {
            uVar.u();
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.wo;
        if (wVar != null) {
            wVar.hf();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> map = this.r;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().hf();
                }
            }
            this.r.clear();
        }
        j jVar = this.jk;
        if (jVar != null) {
            jVar.q();
        }
        NativeVideoTsView nativeVideoTsView = this.c;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.c.getNativeVideoController().tf();
        }
        NativeVideoTsView nativeVideoTsView2 = this.c;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.v();
            this.c = null;
        }
        this.kd = null;
        kd kdVar2 = this.vm;
        if (kdVar2 != null) {
            kdVar2.y();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        hf hfVar = this.dq;
        if (hfVar != null) {
            hfVar.xj(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.ws && !p()) {
                this.ws = true;
                this.f.y();
            }
        } catch (Throwable th) {
            pl.u("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        j jVar = this.jk;
        if (jVar != null) {
            jVar.ai();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> map = this.r;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        if (et() || ((nativeVideoTsView2 = this.c) != null && nativeVideoTsView2.getNativeVideoController() != null && this.c.getNativeVideoController().jk())) {
            com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.a.j.xj("sp_multi_native_video_data");
            xj.put("key_video_is_update_flag", true);
            xj.put("key_native_video_complete", true);
            xj.put("key_video_isfromvideodetailpage", true);
        }
        if (et() || (nativeVideoTsView = this.c) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        xj(this.c.getNativeVideoController());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eu = false;
        if (this.ws && tf() && !p()) {
            this.ws = false;
            this.f.f();
        }
        j jVar = this.jk;
        if (jVar != null) {
            jVar.x();
            this.jk.xj(new SSWebView.hf() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.6
                @Override // com.bytedance.sdk.component.widget.SSWebView.hf
                public void xj(int i) {
                    TTVideoWebPageActivity.this.jk.xj(i);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.wo;
        if (wVar != null) {
            wVar.xj();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> map = this.r;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().xj();
                }
            }
        }
        kd kdVar = this.vm;
        if (kdVar != null) {
            kdVar.u();
        }
        dk();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        ws wsVar = this.kd;
        bundle.putString("material_meta", wsVar != null ? wsVar.ac().toString() : null);
        bundle.putLong("video_play_position", this.ra);
        bundle.putBoolean("is_complete", et());
        long j = this.ra;
        NativeVideoTsView nativeVideoTsView = this.c;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            j = this.c.getNativeVideoController().p();
        }
        bundle.putLong("video_play_position", j);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        kd kdVar = this.vm;
        if (kdVar != null) {
            kdVar.kd();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void s_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void t_() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String am() {
        ws wsVar = this.kd;
        if (wsVar != null && !TextUtils.isEmpty(wsVar.bh())) {
            this.bl = this.kd.bh();
        }
        return this.bl;
    }

    private void e() {
        if (ws.hf(this.kd)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.c = new NativeVideoTsView(this.v, this.kd, true, true);
                } else {
                    this.c = new NativeVideoTsView(this.v, this.kd, true, false);
                }
                if (this.c.getNativeVideoController() != null) {
                    this.c.getNativeVideoController().xj(false);
                    if (this.hl != null) {
                        this.c.getNativeVideoController().w(this.hl.xj);
                    }
                }
                this.c.setVideoAdInteractionListener(this);
                if (!this.tj) {
                    this.ra = 0L;
                }
                if (this.hl != null && this.c.getNativeVideoController() != null) {
                    this.c.getNativeVideoController().w(this.hl.c);
                    this.c.getNativeVideoController().u(this.hl.kd);
                }
                if (this.c.getNativeVideoController() != null) {
                    this.c.getNativeVideoController().xj(false);
                    this.c.getNativeVideoController().xj(this.gh);
                    this.c.setIsQuiet(pz.hf().u(wo.d(this.kd)));
                }
                if (this.c.xj(this.ra, this.eu, et())) {
                    this.ht.setVisibility(0);
                    this.ht.removeAllViews();
                    this.ht.addView(this.c);
                }
                if (et()) {
                    this.c.u(true);
                }
                this.f = this.c.getNativeVideoController();
            } catch (Exception e) {
                pl.xj(e);
            }
            if (am.w(this.tu.getApplicationContext()) == 0) {
                try {
                    Activity activity = this.tu;
                    x.xj(activity, com.bytedance.sdk.component.utils.jk.xj(activity, "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void g() {
        ws wsVar = this.kd;
        if (wsVar == null || wsVar.vw() != 4) {
            return;
        }
        this.l.setVisibility(0);
        Button button = (Button) findViewById(2114387729);
        this.ff = button;
        if (button != null) {
            hf(am());
            com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.wo;
            if (wVar != null) {
                wVar.xj(this.lw, false);
            }
            this.ff.setOnClickListener(this.wa);
            this.ff.setOnTouchListener(this.wa);
        }
    }

    private void pl() {
        ws wsVar = this.kd;
        if (wsVar == null) {
            return;
        }
        this.dc = com.bytedance.sdk.openadsdk.pl.u.xj(this.v, wsVar, this.n);
    }

    private void qt() {
        this.f10284a = (TTProgressBar) findViewById(2114387922);
        this.l = (TTViewStub) findViewById(2114387956);
        this.d = (SSWebView) findViewById(2114387733);
        this.tf = (ImageView) findViewById(2114387705);
        ws wsVar = this.kd;
        if (wsVar != null && wsVar.xl() != null) {
            this.kd.xl().xj("landing_page");
        }
        ImageView imageView = this.tf;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.xj(TTVideoWebPageActivity.this.d)) {
                        return;
                    }
                    if (TTVideoWebPageActivity.this.dq != null) {
                        TTVideoWebPageActivity.this.dq.xj(0);
                    }
                    TTVideoWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.p = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.xj("detail_skip");
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387627);
        this.g = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c();
                }
            });
        }
        this.f10286pl = (TextView) findViewById(2114387952);
        this.am = (TextView) findViewById(2114387886);
        this.qt = (TextView) findViewById(2114387745);
        this.zg = (TextView) findViewById(2114387647);
        this.e = (TextView) findViewById(2114387612);
        this.yo = (LinearLayout) findViewById(2114387890);
        this.ht = (FrameLayout) findViewById(2114387708);
        this.pz = (RelativeLayout) findViewById(2114387943);
        this.ai = (RelativeLayout) findViewById(2114387655);
        this.q = (TextView) findViewById(2114387957);
        this.j = (TextView) findViewById(2114387764);
        this.en = (TextView) findViewById(2114387686);
        this.z = (RoundImageView) findViewById(2114387664);
        jk();
        zg();
    }

    private int v() {
        NativeVideoTsView nativeVideoTsView = this.c;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.c.getNativeVideoController().qt();
    }

    private long yo() {
        NativeVideoTsView nativeVideoTsView = this.c;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.c.getNativeVideoController().am();
    }

    private void zg() {
        ws wsVar = this.kd;
        if (wsVar == null || this.pz == null || !wsVar.p()) {
            return;
        }
        this.pz.setVisibility(8);
    }

    public void c() {
        if (isFinishing() || this.kd == null) {
            return;
        }
        if (this.y == null) {
            f();
        }
        this.y.xj();
    }

    public boolean d() {
        w wVar = this.f;
        return (wVar == null || wVar.e() == null || !this.f.e().g()) ? false : true;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(this.tu, this.kd.xl(), this.w, true);
        this.y = xjVar;
        com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.tu, this.kd, xjVar);
        this.y.xj(new xj.InterfaceC0158xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void hf() {
                if (TTVideoWebPageActivity.this.tf()) {
                    TTVideoWebPageActivity.this.f.f();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void xj() {
                if (TTVideoWebPageActivity.this.d()) {
                    TTVideoWebPageActivity.this.f.y();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
            public void xj(int i, String str, boolean z) {
                if (TTVideoWebPageActivity.this.tf()) {
                    TTVideoWebPageActivity.this.f.f();
                }
            }
        });
    }

    public boolean p() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.y;
        if (xjVar != null) {
            return xjVar.w();
        }
        return false;
    }

    public boolean tf() {
        w wVar = this.f;
        return (wVar == null || wVar.e() == null || !this.f.e().am()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        y.xj(this.v, wsVar.ho(), new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.ht();
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
            }
        }, wsVar.he());
    }

    public void kd() {
        et.xj(this.gy, this.v);
    }

    public void y() {
        try {
            et.xj(this.gy);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        y.xj(this.v, wsVar.ho(), wsVar.he(), new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.ht();
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
            }
        });
    }

    private JSONArray w(String str) {
        int i;
        JSONArray jSONArray = this.aq;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.aq;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf("&");
        if (indexOf == -1 || indexOf2 == -1 || (i = indexOf + 4) >= indexOf2) {
            return null;
        }
        String substring = str.substring(i, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(substring);
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.ff) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.17
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoWebPageActivity.this.ff == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.ff.setText(str);
            }
        });
    }

    private void xj(ws wsVar) {
        LinearLayout linearLayout = this.yo;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (wsVar == null) {
            return;
        }
        String he = wsVar.he();
        if (TextUtils.isEmpty(he)) {
            LinearLayout linearLayout2 = this.yo;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(he)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(new JSONObject(he));
            if (kd == null) {
                LinearLayout linearLayout3 = this.yo;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(kd.g())) {
                LinearLayout linearLayout4 = this.yo;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout5 = this.yo;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            String kd2 = kd.kd();
            String c = kd.c();
            String am = kd.am();
            if (TextUtils.isEmpty(am)) {
                am = tf.hf(wsVar);
            }
            if (this.am != null) {
                this.am.setText(String.format(com.bytedance.sdk.component.utils.jk.xj(this.v, "tt_open_app_detail_developer"), c));
            }
            if (this.qt != null) {
                this.qt.setText(String.format(com.bytedance.sdk.component.utils.jk.xj(this.v, "tt_open_landing_page_app_name"), am, kd2));
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(String str) {
        NativeVideoTsView nativeVideoTsView = this.c;
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, "embeded_ad", str, yo(), v(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : wo.xj(this.kd, this.c.getNativeVideoController().pl(), this.c.getNativeVideoController().e()));
    }

    private void xj(w wVar) {
        pl.u("mutilproces", "initFeedNaitiveControllerData-isComplete=" + wVar.jk() + ",position=" + wVar.p() + ",totalPlayDuration=" + (wVar.pl() + wVar.am()) + ",duration=" + wVar.am());
        com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.a.j.xj("sp_multi_native_video_data");
        xj.put("key_video_is_update_flag", true);
        xj.put("key_video_isfromvideodetailpage", true);
        xj.put("key_native_video_complete", wVar.jk());
        xj.put("key_video_current_play_position", wVar.p());
        xj.put("key_video_total_play_duration", wVar.pl() + wVar.am());
        xj.put("key_video_duration", wVar.am());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        if (ws.w(this.kd)) {
            r.xj((View) this.p, 4);
        } else if (ws.w(this.kd)) {
            r.xj((View) this.p, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.u
    public void xj(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.aq = jSONArray;
        dk();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void xj(long j, long j2) {
        if (io()) {
            com.bytedance.sdk.openadsdk.core.f.zg().xj(j);
        }
    }
}
