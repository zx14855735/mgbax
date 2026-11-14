package com.bytedance.sdk.openadsdk.core.nativeexpress;

import J3FDQU.A2egSU;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.am.f;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class dk extends com.bytedance.sdk.component.adexpress.kd.xj implements am, g {
    private int am;
    private Context c;
    private ws d;
    private y e;
    private String f;
    private j g;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.am.kd f10379pl;
    private com.bytedance.sdk.openadsdk.core.a.xj qt;
    private com.bytedance.sdk.openadsdk.y.xj tf;
    private long v;
    private final Map<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> y;
    private com.bytedance.sdk.component.adexpress.hf.d yo;
    private com.bytedance.sdk.openadsdk.am.f zg;

    public dk(Context context, com.bytedance.sdk.component.adexpress.hf.g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.y.xj xjVar, ws wsVar, com.bytedance.sdk.component.adexpress.hf.d dVar) {
        super(context, gVar, themeStatusBroadcastReceiver);
        this.y = A2egSU.BIYEnU();
        this.am = 8;
        this.v = -1L;
        this.c = context;
        this.f = gVar.y();
        this.d = wsVar;
        this.tf = xjVar;
        this.xj = gVar.kd();
        String xj = xj(wsVar);
        this.p = xj;
        this.yo = dVar;
        xj(a.hf(xj));
        themeStatusBroadcastReceiver.xj(this);
        pl();
        g();
        am();
    }

    private void e() {
        if (this.g == null || ((ViewGroup) this.w.getParent()) == null) {
            return;
        }
        j jVar = this.g;
        jVar.xj(new et(this.w, jVar, this.d));
    }

    private boolean zg() {
        return !TextUtils.isEmpty(this.f) && this.f.equals("splash_ad");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.am
    public j D_() {
        return this.g;
    }

    public void am() {
        if (this.w == null || this.zg != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pz.w wVar = new com.bytedance.sdk.openadsdk.core.pz.w();
        com.bytedance.sdk.openadsdk.core.pz.u uVar = new com.bytedance.sdk.openadsdk.core.pz.u();
        com.bytedance.sdk.openadsdk.core.pz.kd kdVar = new com.bytedance.sdk.openadsdk.core.pz.kd(this.g);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.d.ho());
            jSONObject.put("log_extra", this.d.jf());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        hashSet.add("sendReward");
        this.zg = wVar.xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), this.w, kdVar, uVar, hashSet, "embeded_ad".equals(this.f) ? f.xj.FEED : f.xj.OTHER).kd(this.p).u(com.bytedance.sdk.openadsdk.core.f.xj.c()).xj(com.bytedance.sdk.openadsdk.core.f.xj.xj()).kd(jSONObject).xj("sdkEdition", com.bytedance.sdk.openadsdk.core.f.xj.w()).hf(com.bytedance.sdk.openadsdk.core.f.xj.kd()).w(com.bytedance.sdk.openadsdk.core.f.xj.u()).w(false);
        y yVar = new y(this.c, this.g, this.d, this.f10379pl, zg(), this.zg, p());
        this.e = yVar;
        this.w.setWebViewClient(yVar);
        com.bytedance.sdk.component.adexpress.hf.d dVar = this.yo;
        if (dVar instanceof d) {
            ((d) dVar).xj(this.zg);
        }
        Set<String> tf = this.zg.tf();
        if (this.g == null || tf == null || tf.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.zg);
        Iterator<String> it = tf.iterator();
        while (it.hasNext()) {
            this.g.y().xj(it.next(), (com.bytedance.sdk.component.xj.kd<?, ?>) new com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.dk.2
                @Override // com.bytedance.sdk.component.xj.kd
                public JSONObject xj(JSONObject jSONObject2, com.bytedance.sdk.component.xj.y yVar2) {
                    try {
                        com.bytedance.sdk.openadsdk.am.f fVar = (com.bytedance.sdk.openadsdk.am.f) weakReference.get();
                        if (fVar == null) {
                            return null;
                        }
                        return fVar.u(xj(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.xj
    public void b_(int i) {
        if (this.g == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        this.g.xj("themeChange", jSONObject);
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public void d() {
        com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        this.qt = u;
        u.xj(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj, com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f() {
        super.f();
        if (this.g == null) {
            return;
        }
        e();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.g.xj("expressShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void g() {
        SSWebView sSWebView = this.w;
        if (sSWebView == null) {
            return;
        }
        sSWebView.setMaterialMeta(ff.xj(this.d));
        try {
            this.w.setBackgroundColor(0);
            this.w.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        xj(this.w);
        if (xj() != null) {
            this.f10379pl = new com.bytedance.sdk.openadsdk.core.am.kd(this.d, xj()).hf(false);
        }
        this.f10379pl.xj(this.tf);
        this.w.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.g, this.f10379pl));
        this.w.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.dk.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (!dk.this.y.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.pl.hf.w xj = com.bytedance.sdk.openadsdk.core.pl.f.xj(dk.this.c, str, dk.this.d, dk.this.f);
                    dk.this.y.put(str, xj);
                    xj.xj(wo.v(dk.this.d), false);
                } else {
                    com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = (com.bytedance.sdk.openadsdk.core.pl.hf.w) dk.this.y.get(str);
                    if (wVar != null) {
                        wVar.xj(wo.v(dk.this.d), false);
                    }
                }
            }
        });
        if ("rewarded_video".equals(this.f) || "fullscreen_interstitial_ad".equals(this.f)) {
            r.xj((com.bytedance.sdk.component.g.w) this.w);
        }
        com.bytedance.sdk.component.adexpress.kd.kd.xj().xj(this.w, this.g);
    }

    public void pl() {
        if (this.w == null) {
            return;
        }
        j jVar = new j(this.c);
        this.g = jVar;
        jVar.hf(this.w).xj(this.d).hf(this.d.ho()).u(this.d.jf()).xj(this.f).w(wo.hf(this.f)).kd(wo.zg(this.d)).xj(this).kd(this.xj).xj(this.w).xj(this.tf);
    }

    public y qt() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public void tf() {
        super.tf();
        com.bytedance.sdk.openadsdk.core.a.xj xjVar = this.qt;
        if (xjVar != null) {
            xjVar.hf(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public void y() {
        j jVar = this.g;
        if (jVar == null) {
            return;
        }
        jVar.xj("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public void kd() {
        if (xj() == null) {
            return;
        }
        try {
            xj().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public void u() {
        if (this.kd.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.am.kd kdVar = this.f10379pl;
        if (kdVar != null) {
            kdVar.y();
        }
        SSWebView sSWebView = this.w;
        if (sSWebView != null) {
            sSWebView.I_();
            this.w.setOnShakeListener(null);
        }
        j jVar = this.g;
        if (jVar != null) {
            jVar.kd();
        }
        super.u();
        this.y.clear();
        this.g = null;
        com.bytedance.sdk.openadsdk.am.f fVar = this.zg;
        if (fVar == null) {
            return;
        }
        fVar.l();
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj, com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void hf(final int i) {
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.dk.3
            @Override // java.lang.Runnable
            public void run() {
                dk.this.w(i);
                dk.this.u(i);
                if (i == dk.this.am) {
                    return;
                }
                dk.this.am = i;
                dk.this.hf(i == 0);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj, com.bytedance.sdk.component.adexpress.hf.u
    public int w() {
        return hl.hf(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(boolean z) {
        if (this.g == null || this.w == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.g.xj("expressAdShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i) {
        com.bytedance.sdk.openadsdk.am.f fVar = this.zg;
        if (fVar == null) {
            return;
        }
        if (i == 0) {
            fVar.hf(true);
            this.zg.xj(false);
        } else {
            fVar.hf(false);
            this.zg.xj(true);
        }
    }

    public static String xj(ws wsVar) {
        return com.bytedance.sdk.component.adexpress.xj.hf.hf.hf(hl.f(wsVar) ? "v3" : null);
    }

    public static void xj(Map<String, Object> map, ws wsVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (hl.y(wsVar) != null && !TextUtils.isEmpty(hl.y(wsVar).p())) {
                map.put("engine_version", hl.y(wsVar).p());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void xj(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.c).xj(false).xj(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            com.bytedance.sdk.openadsdk.core.a.pz.xj(sSWebView, ai.w, ws.u(this.d));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("WebViewRender", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i) {
        try {
            if (ai.xj() && i == 0) {
                long no = com.bytedance.sdk.openadsdk.core.pz.hf().no();
                if (this.v != -1 && System.currentTimeMillis() - this.v > no) {
                    SSWebView xj = xj();
                    WebView webView = xj.getWebView();
                    xj.removeView(webView);
                    xj.addView(webView);
                }
                this.v = -1L;
                return;
            }
            this.v = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public SSWebView xj() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public void xj(boolean z, int i) {
        super.xj(z, i);
        com.bytedance.sdk.openadsdk.y.xj xjVar = this.tf;
        if (xjVar != null) {
            xjVar.xj(z, i);
            this.tf.hf(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.kd.xj
    public void xj(float f, float f2) {
        float f3 = this.c.getResources().getDisplayMetrics().density;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        super.xj(r.hf(f3, r.xj(f4, f)), r.hf(f3, r.xj(f4, f2)));
    }
}
