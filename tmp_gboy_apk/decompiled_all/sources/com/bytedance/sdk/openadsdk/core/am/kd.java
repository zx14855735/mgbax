package com.bytedance.sdk.openadsdk.core.am;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.eu;
import com.bytedance.sdk.openadsdk.core.e.xj;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private Runnable ai;
    private WeakReference<hf> en;
    private JSONObject ht;
    private com.bytedance.sdk.component.g.w jk;
    private String kd;
    private com.bytedance.sdk.openadsdk.y.xj ra;
    private String u;
    private long x;
    private final ws y;
    private String z;
    private int xj = 0;
    private volatile boolean hf = false;
    private int w = -1;
    private String c = "landingpage";
    private long f = 0;
    private long d = 0;
    private long tf = 0;
    private long p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private long f10292pl = 0;
    private boolean g = false;
    private long am = 0;
    private long qt = 0;
    private long zg = 0;
    private long e = -1;
    private boolean yo = false;
    private AtomicInteger v = new AtomicInteger(0);
    private boolean pz = false;
    private AtomicBoolean dk = new AtomicBoolean(false);
    private boolean et = false;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10291io = true;
    private final AtomicBoolean q = new AtomicBoolean(false);
    private final Map<String, eu.xj> j = new ConcurrentHashMap();

    public interface hf {
        void xj(String str);
    }

    public static class xj {
        private final WeakReference<hf> hf;
        private final AtomicInteger xj;

        public xj(AtomicInteger atomicInteger, WeakReference<hf> weakReference) {
            this.xj = atomicInteger;
            this.hf = weakReference;
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable unused) {
            }
            AtomicInteger atomicInteger = this.xj;
            if (atomicInteger != null) {
                atomicInteger.set(i);
            }
            WeakReference<hf> weakReference = this.hf;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.hf.get().xj(str);
        }
    }

    public kd(ws wsVar, com.bytedance.sdk.component.g.w wVar) {
        this.y = wsVar;
        this.jk = wVar;
        if (wVar != null) {
            wVar.addJavascriptInterface(new xj(this.v, this.en), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.x = System.currentTimeMillis();
        this.z = String.valueOf(SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.e.xj.xj) && this.y != null) {
                StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.e.xj.xj);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("cid", this.y.ho());
                jSONObject.putOpt(MediationConstant.EXTRA_ADID, this.y.jq());
                jSONObject.put("log_extra", this.y.jf());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.zg);
                jSONObject2.put("click_time", this.qt);
                jSONObject2.put("web_url", this.y.ol());
                jSONObject.put("client_info", jSONObject2);
                com.bytedance.sdk.openadsdk.core.e.xj.xj(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String sb2 = sb.toString();
                if (TextUtils.isEmpty(sb2)) {
                    return;
                }
                String concat = "javascript:".concat(String.valueOf(sb2));
                com.bytedance.sdk.component.g.w wVar = this.jk;
                if (wVar != null) {
                    p.xj(wVar, concat);
                }
            }
        } catch (Throwable th) {
            pl.w(th.getMessage());
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.e.xj.xj dq;
        com.bytedance.sdk.component.g.w wVar;
        if (this.xj != 2 || !this.g || (dq = pz.hf().dq()) == null || (wVar = this.jk) == null) {
            return;
        }
        dq.xj(wVar.getWebView(), this.y);
    }

    public Map<String, eu.xj> f() {
        return this.j;
    }

    public void kd() {
        if (this.f10291io) {
            this.f10291io = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.x);
                jSONObject.put(PointCategory.END, System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, this.y);
            } catch (JSONException e) {
                pl.xj(e);
            }
            u.xj(this.y, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.kd.1
                @Override // com.bytedance.sdk.openadsdk.y.xj.xj
                public void xj(JSONObject jSONObject2) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
        if (this.xj == 2) {
            if (this.tf > 0 || !hf()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.d = currentTimeMillis;
                long max = currentTimeMillis - Math.max(this.f, this.tf);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.xj);
                    jSONObject2.put("max_scroll_percent", this.v.get());
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                xj("stay_page", jSONObject2, Math.min(max, 600000L));
                com.bytedance.sdk.openadsdk.core.qt.w.kd().xj("landingPause", this.y, this.z);
            }
        }
    }

    public kd u(long j) {
        this.e = j;
        return this;
    }

    public void y() {
        com.bytedance.sdk.component.g.w wVar = this.jk;
        if (wVar != null) {
            wVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.jk = null;
        if (!this.dk.get() && this.hf) {
            u.w(this.y, this.c, System.currentTimeMillis() - this.am);
        }
        if ("landingpage".equals(this.c) || "landingpage_endcard".equals(this.c)) {
            com.bytedance.sdk.openadsdk.core.qt.w.kd().xj("landingFinish", this.y, this.z);
        }
        this.ai = null;
        if (this.j.isEmpty()) {
            return;
        }
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.kd.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("web_cache_hit_report");
                if (kd.this.y != null) {
                    xj2.y(kd.this.y.zf());
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (eu.xj xjVar : kd.this.j.values()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", xjVar.w());
                        jSONObject2.put("hit", xjVar.u());
                        jSONObject2.put("miss", xjVar.kd());
                        jSONArray.put(jSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    jSONObject.put("hit_records", jSONArray);
                } catch (JSONException unused2) {
                }
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "web_cache_hit_report");
    }

    public boolean hf() {
        return this.et;
    }

    public void u() {
        this.f = System.currentTimeMillis();
        if (this.am == 0) {
            this.am = System.currentTimeMillis();
        }
        if ("landingpage".equals(this.c) || "landingpage_endcard".equals(this.c)) {
            if (this.q.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.core.qt.w.kd().xj("landingStart", this.y, this.z);
            } else {
                com.bytedance.sdk.openadsdk.core.qt.w.kd().xj("landingContinue", this.y, this.z);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.y.xj w() {
        return this.ra;
    }

    public void xj(hf hfVar) {
        this.en = new WeakReference<>(hfVar);
    }

    public kd hf(boolean z) {
        this.pz = z;
        return this;
    }

    public kd w(long j) {
        this.zg = j;
        return this;
    }

    public void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c = str;
    }

    public kd hf(long j) {
        this.qt = j;
        return this;
    }

    public void hf(String str) {
        if (this.pz) {
            if ("load_finish".equals(str) && "landingpage".equals(this.c)) {
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.am.kd.3
                    @Override // java.lang.Runnable
                    public void run() {
                        kd.this.d();
                    }
                };
                this.ai = runnable;
                com.bytedance.sdk.openadsdk.core.e.xj.xj(new xj.RunnableC0161xj(runnable));
            }
            long j = this.f10292pl - this.p;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.w);
                jSONObject.put("error_msg", this.u);
                jSONObject.put("error_url", this.kd);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                long j2 = this.qt;
                if (j2 > 0) {
                    jSONObject.put("exp_duration", this.f10292pl - j2);
                }
                long j3 = this.zg;
                if (j3 > 0) {
                    jSONObject.put("web_duration", this.f10292pl - j3);
                }
                long j4 = this.e;
                if (j4 >= 0) {
                    jSONObject.put("webview_duration", j4);
                }
            } catch (Exception unused) {
            }
            xj(str, jSONObject, Math.min(j, 600000L));
        }
    }

    public String xj() {
        return this.c;
    }

    public void xj(long j) {
        this.tf = j;
    }

    public void xj(boolean z) {
        this.et = z;
    }

    public void xj(com.bytedance.sdk.openadsdk.y.xj xjVar) {
        this.ra = xjVar;
    }

    public void xj(JSONObject jSONObject) {
        this.ht = jSONObject;
    }

    public void xj(WebView webView, int i) {
        if (this.p == 0 && i > 0) {
            this.xj = 1;
            this.p = System.currentTimeMillis();
        } else {
            if (i != 100 || this.g) {
                return;
            }
            this.g = true;
            this.f10292pl = System.currentTimeMillis();
            if (!"landingpage".equals(this.c) || this.xj == 3) {
                return;
            }
            hf("landingpage_load_hundred");
        }
    }

    public void xj(WebView webView, String str, Bitmap bitmap) {
        com.bytedance.sdk.openadsdk.y.xj xjVar = this.ra;
        if (xjVar != null) {
            xjVar.y();
        }
        if (this.hf) {
            return;
        }
        this.am = System.currentTimeMillis();
        this.hf = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        xj("load_start", jSONObject);
    }

    public void xj(WebView webView) {
        com.bytedance.sdk.openadsdk.y.xj xjVar = this.ra;
        if (xjVar != null) {
            xjVar.c();
        }
        if (this.f10292pl <= 0) {
            this.f10292pl = System.currentTimeMillis();
        }
        if (webView != null && !this.yo && this.pz) {
            this.yo = true;
            p.xj(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.dk.get()) {
            return;
        }
        if (this.xj != 3) {
            this.xj = 2;
        }
        this.dk.set(true);
        this.f = System.currentTimeMillis();
        if (this.xj == 2) {
            hf("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", this.w);
            jSONObject.put("error_msg", this.u);
            jSONObject.put("error_url", this.kd);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        xj("load_fail", jSONObject);
    }

    public void xj(int i, String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.y.xj xjVar = this.ra;
        if (xjVar != null) {
            xjVar.f();
        }
        if ((str3 == null || !str3.startsWith("image")) && this.xj != 2) {
            this.xj = 3;
        }
        this.w = i;
        this.u = str;
        this.kd = str2;
    }

    private void xj(String str, JSONObject jSONObject) {
        xj(str, jSONObject, -1L);
    }

    private void xj(String str, JSONObject jSONObject, long j) {
        if (!this.pz || this.y == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put(MediationConstant.EXTRA_DURATION, j);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        u.w(this.y, this.c, str, jSONObject2);
    }
}
