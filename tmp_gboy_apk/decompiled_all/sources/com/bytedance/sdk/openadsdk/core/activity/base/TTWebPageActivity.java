package com.bytedance.sdk.openadsdk.core.activity.base;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.dislike.ui.xj;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.pl.f;
import com.bytedance.sdk.openadsdk.core.pl.hf.w;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.playable.hf.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.l;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.yo.u;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements ai.xj, u {
    private static final String f = "TTWebPageActivity";

    /* renamed from: a, reason: collision with root package name */
    private w f10287a;
    private j ai;
    private TextView am;
    private boolean b;
    kd c;
    private SSWebView d;
    private TTViewStub dk;
    private TextView e;
    private Button et;
    private int eu;
    private com.bytedance.sdk.openadsdk.pl.u ff;
    private TextView g;
    private TTViewStub ht;

    /* renamed from: io, reason: collision with root package name */
    private TTProgressBar f10288io;
    private Context jk;
    private Activity l;
    private ImageView p;

    /* renamed from: pl, reason: collision with root package name */
    private TextView f10289pl;
    private TTViewStub pz;
    private boolean q;
    private TextView qt;
    private com.bytedance.sdk.openadsdk.core.widget.xj.u r;
    private TTViewStub ra;
    private ImageView tf;
    private int tj;
    private ImageView v;
    private boolean ws;
    private LinearLayout x;
    com.bytedance.sdk.openadsdk.core.dislike.ui.xj y;
    private LinearLayout yo;
    private hf yy;
    private String z;
    private TextView zg;
    private AtomicBoolean j = new AtomicBoolean(true);
    private JSONArray en = null;
    private final Map<String, w> wo = A2egSU.BIYEnU();
    private final ai n = new ai(Looper.getMainLooper(), this);
    private int hl = 0;
    private String vm = "立即下载";
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj dc = new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.12
        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void hf(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.xj("暂停");
            if (j > 0) {
                xj.C0198xj.xj(TTWebPageActivity.this.xj, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void w(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.xj("下载失败");
            if (j > 0) {
                xj.C0198xj.xj(TTWebPageActivity.this.xj, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.xj(tTWebPageActivity.c());
            xj.C0198xj.xj(TTWebPageActivity.this.xj, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.xj("下载中...");
            String unused = TTWebPageActivity.f;
            if (j > 0) {
                xj.C0198xj.xj(TTWebPageActivity.this.xj, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, String str, String str2) {
            TTWebPageActivity.this.xj("点击安装");
            xj.C0198xj.xj(TTWebPageActivity.this.xj, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(String str, String str2) {
            TTWebPageActivity.this.xj("点击打开");
            xj.C0198xj.xj(TTWebPageActivity.this.xj, 6, 100);
        }
    };

    public static class xj implements DownloadListener {
        private ws hf;
        private String u;
        private Context w;
        private Map<String, w> xj;

        public xj(Map<String, w> map, ws wsVar, Context context, String str) {
            this.xj = map;
            this.hf = wsVar;
            this.w = context;
            this.u = str;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Map<String, w> map = this.xj;
            if (map == null || !map.containsKey(str)) {
                w xj = f.xj(this.w, str, this.hf, this.u);
                xj.xj(tf.xj(this.hf));
                this.xj.put(str, xj);
                xj.xj(wo.v(this.hf), false);
                return;
            }
            w wVar = this.xj.get(str);
            if (wVar != null) {
                wVar.xj(wo.v(this.hf), false);
            }
        }
    }

    private boolean am() {
        return this.b || this.ws;
    }

    private void g() {
        this.eu = 0;
        if (this.b) {
            this.eu = com.bytedance.sdk.openadsdk.core.f.u.xj;
        } else if (this.ws && !com.bytedance.sdk.openadsdk.core.f.u.u) {
            this.eu = aq.am(this.kd);
        }
        hf(this.eu);
        if (this.eu > 0 && !this.n.hasMessages(10)) {
            if (this.b) {
                this.n.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.ws) {
                this.n.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private void p() {
        if (this.kd == null) {
            return;
        }
        JSONArray hf = hf(this.z);
        int d = wo.d(this.kd);
        int f2 = wo.f(this.kd);
        dk<com.bytedance.sdk.openadsdk.core.am.xj> xj2 = pz.xj();
        if (hf == null || xj2 == null || d <= 0 || f2 <= 0) {
            return;
        }
        tj tjVar = new tj();
        tjVar.kd = hf;
        com.bytedance.sdk.openadsdk.zg.w.w.hf gh = this.kd.gh();
        if (gh == null) {
            return;
        }
        xj2.xj(com.bytedance.sdk.openadsdk.core.a.ai.hf(gh).w(6).xj(), tjVar, f2, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
                TTWebPageActivity.this.xj(0);
                hfVar.xj(i);
                com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
                if (xjVar != null) {
                    try {
                        TTWebPageActivity.this.j.set(false);
                        TTWebPageActivity.this.ai.xj(xjVar.w());
                    } catch (Exception unused) {
                        TTWebPageActivity.this.xj(0);
                    }
                }
            }
        });
    }

    private void pl() {
        this.ws = aq.v(this.kd);
        boolean z = aq.yo(this.kd) && !com.bytedance.sdk.openadsdk.core.f.u.w;
        this.b = z;
        if (this.ws) {
            if (!com.bytedance.sdk.openadsdk.core.f.u.u) {
                this.b = false;
            } else if (z) {
                this.ws = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        if (am()) {
            this.n.removeMessages(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg() {
        if (!am() || this.n.hasMessages(10)) {
            return;
        }
        this.n.sendEmptyMessageDelayed(10, 1000L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hf hfVar = this.yy;
        if (hfVar != null) {
            hfVar.xj(this.l, this.kd);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if ((ws.w(this.kd) || l.xj(this.kd)) && r.xj(this.d)) {
                return;
            }
            hf hfVar = this.yy;
            if (hfVar == null || !hfVar.hf(this.l, this.kd)) {
                super.onBackPressed();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kd == null) {
            return;
        }
        this.l = this;
        this.jk = this;
        try {
            pz.xj(this);
        } catch (Throwable unused) {
        }
        long currentTimeMillis = System.currentTimeMillis();
        setContentView(f());
        Intent intent = getIntent();
        com.bytedance.sdk.openadsdk.core.playable.hf.xj().xj(this.kd);
        pl();
        d();
        if (this.d != null) {
            com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.jk).xj(false).hf(false).xj(this.d);
        }
        this.q = intent.getBooleanExtra("is_outer_click", false);
        String stringExtra = intent.getStringExtra("url");
        this.z = stringExtra;
        this.z = wo.hf(this.kd, stringExtra);
        String stringExtra2 = intent.getStringExtra("title");
        ws wsVar = this.kd;
        if (wsVar != null && wsVar.xl() != null) {
            this.kd.xl().xj("landing_page");
        }
        this.hl = intent.getIntExtra("get_phone_num_status", 0);
        w(this.kd);
        SSWebView sSWebView = this.d;
        if (sSWebView != null) {
            Context applicationContext = getApplicationContext();
            ws wsVar2 = this.kd;
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.l.hf.xj(sSWebView, applicationContext, wsVar2 != null ? wsVar2.w() : this.hl, this.kd), "CCWifiJSBridge");
            this.c = new kd(this.kd, this.d).hf(true).hf(currentTimeMillis).u(this.d.getCreateDuration());
            u();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.xj);
            jSONObject.put("url", stringExtra);
            jSONObject.put("web_title", stringExtra2);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.hf.w());
            jSONObject.put("event_tag", this.w);
        } catch (JSONException unused2) {
        }
        this.c.xj(jSONObject);
        tf();
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = new com.bytedance.sdk.openadsdk.core.widget.xj.u(this.jk, this.ai, this.xj, this.c, this.ff) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTWebPageActivity.this.f10288io == null || TTWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTWebPageActivity.this.f10288io.setVisibility(8);
                } catch (Throwable unused3) {
                }
            }
        };
        this.r = uVar;
        this.d.setWebViewClient(uVar);
        SSWebView sSWebView2 = this.d;
        if (sSWebView2 != null) {
            com.bytedance.sdk.openadsdk.core.a.pz.xj(sSWebView2, com.bytedance.sdk.openadsdk.core.ai.w, ws.u(this.kd));
        }
        this.d.setMixedContentMode(0);
        this.d.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.ai, this.c) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.xj.w, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTWebPageActivity.this.f10288io == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i == 100 && TTWebPageActivity.this.f10288io.isShown()) {
                    TTWebPageActivity.this.f10288io.setVisibility(8);
                } else {
                    TTWebPageActivity.this.f10288io.setProgress(i);
                }
            }
        });
        this.d.setDownloadListener(new xj(this.wo, this.kd, this.jk, this.w));
        TextView textView = this.f10289pl;
        if (textView != null && !this.b && !this.ws) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = jk.xj(this.l, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        TextView textView2 = this.zg;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.xj(tTWebPageActivity.kd);
                }
            });
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.hf(tTWebPageActivity.kd);
                }
            });
        }
        y();
        xj(4);
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, getClass().getName());
        this.d.setVisibility(0);
        this.c.w(System.currentTimeMillis());
        this.d.loadUrl(this.z);
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.kd);
        if (this.b || this.ws) {
            g();
        }
        this.yy = new hf(this.c.xj());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        kd kdVar = this.c;
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
            a.xj(this.jk, sSWebView);
            a.xj(this.d);
        }
        this.d = null;
        com.bytedance.sdk.openadsdk.pl.u uVar = this.ff;
        if (uVar != null) {
            uVar.u();
        }
        j jVar = this.ai;
        if (jVar != null) {
            jVar.q();
        }
        w wVar = this.f10287a;
        if (wVar != null) {
            wVar.hf();
        }
        Map<String, w> map = this.wo;
        if (map != null) {
            for (Map.Entry<String, w> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().hf();
                }
            }
            this.wo.clear();
        }
        kd kdVar2 = this.c;
        if (kdVar2 != null) {
            kdVar2.y();
        }
        com.bytedance.sdk.openadsdk.core.playable.hf.xj().hf(this.kd);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        hf hfVar = this.yy;
        if (hfVar != null) {
            hfVar.xj(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        j jVar = this.ai;
        if (jVar != null) {
            jVar.ai();
        }
        Map<String, w> map = this.wo;
        if (map != null) {
            for (Map.Entry<String, w> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = this.r;
        if (uVar != null) {
            uVar.w();
        }
        qt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        j jVar = this.ai;
        if (jVar != null) {
            jVar.x();
            this.ai.xj(new SSWebView.hf() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.4
                @Override // com.bytedance.sdk.component.widget.SSWebView.hf
                public void xj(int i) {
                    TTWebPageActivity.this.ai.xj(i);
                }
            });
        }
        w wVar = this.f10287a;
        if (wVar != null) {
            wVar.xj();
        }
        Map<String, w> map = this.wo;
        if (map != null) {
            for (Map.Entry<String, w> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().xj();
                }
            }
        }
        kd kdVar = this.c;
        if (kdVar != null) {
            kdVar.u();
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = this.r;
        if (uVar != null) {
            uVar.hf(true);
        }
        p();
        zg();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        kd kdVar = this.c;
        if (kdVar != null) {
            kdVar.kd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        ws wsVar = this.kd;
        if (wsVar != null && !TextUtils.isEmpty(wsVar.bh())) {
            this.vm = this.kd.bh();
        }
        return this.vm;
    }

    private void d() {
        TTViewStub tTViewStub;
        if (this.b || this.ws) {
            TTViewStub tTViewStub2 = this.ra;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.v = (ImageView) findViewById(2114387843);
        } else {
            ws wsVar = this.kd;
            if (wsVar == null || !wsVar.p()) {
                int ai = com.bytedance.sdk.openadsdk.core.f.zg().ai();
                if (ai == 0) {
                    TTViewStub tTViewStub3 = this.pz;
                    if (tTViewStub3 != null) {
                        tTViewStub3.setVisibility(0);
                    }
                } else if (ai == 1 && (tTViewStub = this.ht) != null) {
                    tTViewStub.setVisibility(0);
                }
            } else {
                TTViewStub tTViewStub4 = this.pz;
                if (tTViewStub4 != null) {
                    tTViewStub4.setVisibility(8);
                }
                TTViewStub tTViewStub5 = this.ht;
                if (tTViewStub5 != null) {
                    tTViewStub5.setVisibility(8);
                }
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.tf = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (r.xj(TTWebPageActivity.this.d)) {
                        return;
                    }
                    if (TTWebPageActivity.this.yy != null) {
                        TTWebPageActivity.this.yy.xj(0);
                    }
                    TTWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.p = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.f10289pl = (TextView) findViewById(2114387952);
        this.g = (TextView) findViewById(2114387627);
        this.am = (TextView) findViewById(2114387610);
        this.qt = (TextView) findViewById(2114387701);
        this.zg = (TextView) findViewById(2114387598);
        this.e = (TextView) findViewById(2114387700);
        this.yo = (LinearLayout) findViewById(2114387676);
        TextView textView = this.g;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.xj();
                }
            });
        }
    }

    private View f() {
        Activity activity = this.l;
        if (activity == null) {
            return null;
        }
        Resources resources = activity.getResources();
        this.x = new LinearLayout(this.l);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.x.setOrientation(1);
        this.x.setLayoutParams(layoutParams);
        TTViewStub tTViewStub = new TTViewStub(this.jk, new com.bytedance.sdk.openadsdk.res.layout.xj.hf());
        this.pz = tTViewStub;
        tTViewStub.setId(2114387770);
        this.x.addView(this.pz, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub2 = new TTViewStub(this.jk, new com.bytedance.sdk.openadsdk.res.layout.xj.w());
        this.ht = tTViewStub2;
        tTViewStub2.setId(2114387792);
        this.x.addView(this.ht, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub3 = new TTViewStub(this.jk, new com.bytedance.sdk.openadsdk.res.layout.xj.u());
        this.ra = tTViewStub3;
        tTViewStub3.setId(2114387933);
        this.x.addView(this.ra, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.l);
        this.x.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        SSWebView sSWebView = new SSWebView(this.l);
        this.d = sSWebView;
        sSWebView.setMaterialMeta(ff.xj(this.kd));
        this.d.setId(2114387733);
        this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.d);
        TTViewStub tTViewStub4 = new TTViewStub(this.jk, new com.bytedance.sdk.openadsdk.res.layout.xj.xj());
        this.dk = tTViewStub4;
        tTViewStub4.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.dk, layoutParams2);
        TTProgressBar tTProgressBar = new TTProgressBar(this.l, null, R.style.Widget.ProgressBar.Horizontal);
        this.f10288io = tTProgressBar;
        tTProgressBar.setId(2114387922);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.f10288io.setLayoutParams(layoutParams3);
        this.f10288io.setProgress(1);
        this.f10288io.setProgressDrawable(jk.w(this.l, "tt_browser_progress_style"));
        frameLayout.addView(this.f10288io);
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void kd() {
        int yo = com.bytedance.sdk.openadsdk.core.ra.jk.yo(this.kd);
        ws wsVar = this.kd;
        if (wsVar != null) {
            if (wsVar.vw() == 4 || yo != 0) {
                if (this.f10287a == null) {
                    w xj2 = f.xj((Context) this.l, this.kd, TextUtils.isEmpty(this.w) ? wo.xj(this.u) : this.w, false);
                    this.f10287a = xj2;
                    xj2.xj(tf.xj(this.kd));
                    this.f10287a.xj(this.dc, false);
                }
                this.f10287a.xj(this.l);
                w wVar = this.f10287a;
                if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                    ((com.bytedance.sdk.openadsdk.core.pl.w.kd) wVar).y(true);
                    ((com.bytedance.sdk.openadsdk.core.pl.w.kd) this.f10287a).f().xj(false);
                }
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.l, this.kd, "embeded_ad_landingpage", this.u);
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
                this.f10287a.xj(this.kd, false);
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.f10287a);
            }
        }
    }

    private void tf() {
        if (this.d == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.kd);
        j jVar = new j(this.l);
        this.ai = jVar;
        jVar.u(this.q);
        this.ai.hf(this.d).xj(this.kd).w(arrayList).hf(this.xj).u(this.hf).w(this.u).xj(this.w).kd(wo.zg(this.kd)).xj(this.d).xj(true).hf(tf.xj(this.kd)).xj(this);
    }

    private void u() {
        ws wsVar = this.kd;
        if (wsVar == null) {
            return;
        }
        this.ff = com.bytedance.sdk.openadsdk.pl.u.xj(this.jk, wsVar, this.z);
    }

    private void y() {
        ws wsVar = this.kd;
        if (wsVar == null || wsVar.vw() != 4) {
            return;
        }
        TTViewStub tTViewStub = this.dk;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387729);
        this.et = button;
        if (button != null) {
            xj(c());
            if (this.f10287a == null) {
                w xj2 = f.xj((Context) this.l, this.kd, TextUtils.isEmpty(this.w) ? wo.xj(this.u) : this.w, false);
                this.f10287a = xj2;
                xj2.xj(tf.xj(this.kd));
                this.f10287a.xj(this.dc, false);
            }
            this.f10287a.xj(this.l);
            w wVar = this.f10287a;
            if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                ((com.bytedance.sdk.openadsdk.core.pl.w.kd) wVar).y(true);
            }
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.l, this.kd, "embeded_ad_landingpage", this.u);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
            this.et.setOnClickListener(xjVar);
            this.et.setOnTouchListener(xjVar);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.f10287a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        String he = wsVar.he();
        qt();
        y.xj(this.jk, wsVar.ho(), new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.11
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                TTWebPageActivity.this.zg();
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                TTWebPageActivity.this.zg();
                TTWebPageActivity.this.kd();
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                TTWebPageActivity.this.zg();
            }
        }, he);
    }

    private void w(ws wsVar) {
        LinearLayout linearLayout = this.yo;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (this.kd == null) {
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
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
                this.am.setText(String.format(jk.xj(this.jk, "tt_open_app_detail_developer"), c));
            }
            if (this.qt != null) {
                this.qt.setText(String.format(jk.xj(this.jk, "tt_open_landing_page_app_name"), am, kd2));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        String he = wsVar.he();
        qt();
        y.xj(this.jk, wsVar.ho(), he, new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                TTWebPageActivity.this.zg();
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                TTWebPageActivity.this.zg();
                TTWebPageActivity.this.kd();
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                TTWebPageActivity.this.zg();
            }
        });
    }

    private JSONArray hf(String str) {
        int i;
        JSONArray jSONArray = this.en;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.en;
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
    public void xj(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.et) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (TTWebPageActivity.this.et == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.et.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i) {
        if (ws.w(this.kd)) {
            r.xj((View) this.p, 4);
        } else if (ws.w(this.kd)) {
            r.xj((View) this.p, i);
        }
    }

    public void hf() {
        try {
            com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(this.l, this.kd.xl(), this.w, true);
            this.y = xjVar;
            com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.l, this.kd, xjVar);
            this.y.xj(new xj.InterfaceC0158xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                public void hf() {
                    TTWebPageActivity.this.zg();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                public void xj() {
                    TTWebPageActivity.this.qt();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.xj.InterfaceC0158xj
                public void xj(int i, String str, boolean z) {
                    TTWebPageActivity.this.zg();
                }
            });
        } catch (Exception e) {
            pl.w(e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yo.u
    public void xj(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.en = jSONArray;
        p();
    }

    public void xj() {
        if (this.kd == null || isFinishing()) {
            return;
        }
        if (this.y == null) {
            hf();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.y;
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    private void hf(int i) {
        if (i > 0) {
            if (this.b) {
                r.xj(this.f10289pl, i + "s后可领取奖励");
                return;
            }
            if (this.ws) {
                SpannableString spannableString = new SpannableString(CtFAbx.ASJ6gh(i, "浏览 ", "秒 获得更多福利"));
                spannableString.setSpan(new ForegroundColorSpan(-65536), spannableString.length() - 4, spannableString.length(), 17);
                r.xj(this.f10289pl, spannableString);
                return;
            }
            return;
        }
        if (this.b) {
            r.xj(this.f10289pl, "领取成功");
        } else if (this.ws) {
            r.xj((View) this.v, 8);
            r.xj(this.f10289pl, "恭喜你！福利已领取");
        }
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what == 10 && am()) {
            int i = this.tj + 1;
            this.tj = i;
            if (this.b) {
                com.bytedance.sdk.openadsdk.core.f.u.hf = i;
            }
            int max = Math.max(0, this.eu - i);
            hf(max);
            if (max <= 0 && this.ws) {
                com.bytedance.sdk.openadsdk.core.f.u.u = true;
            }
            this.n.sendEmptyMessageDelayed(10, 1000L);
        }
    }
}
