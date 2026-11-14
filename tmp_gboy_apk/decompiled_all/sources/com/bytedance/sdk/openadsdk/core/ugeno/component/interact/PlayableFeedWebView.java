package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.adexpress.u.tf;
import com.bytedance.sdk.component.g.hf;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.am.f;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.et;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.qt;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PlayableFeedWebView extends SSWebView implements hf.xj, com.bytedance.sdk.openadsdk.core.dk.w, d {
    private int am;
    private final ws c;
    private qt d;
    private com.bytedance.sdk.openadsdk.am.f e;
    private com.bytedance.sdk.openadsdk.core.dk.hf f;
    private boolean g;
    private qt jk;
    private final Context kd;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj f10432pl;
    private double pz;
    private final Runnable qt;
    private final ViewGroup tf;
    private qt v;
    private j y;
    private com.bytedance.sdk.component.adexpress.hf.p yo;
    private final Runnable zg;

    public PlayableFeedWebView(com.bytedance.sdk.openadsdk.core.dk.hf hfVar, ViewGroup viewGroup) {
        super(hfVar.getContext());
        this.p = false;
        this.g = false;
        this.am = 8;
        this.qt = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.hf(0);
            }
        };
        this.zg = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.hf(8);
            }
        };
        this.yo = new com.bytedance.sdk.component.adexpress.hf.p() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.3
            @Override // com.bytedance.sdk.component.adexpress.hf.p
            public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
            }

            @Override // com.bytedance.sdk.component.adexpress.hf.p
            public void xj(am amVar) {
            }

            @Override // com.bytedance.sdk.component.adexpress.hf.p
            public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                PlayableFeedWebView.this.f10432pl.hf(view, i, wVar);
            }
        };
        this.f = hfVar;
        this.kd = hfVar.getContext();
        this.c = hfVar.xj();
        this.tf = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    private void d() {
        com.bytedance.sdk.openadsdk.core.pz.w wVar = new com.bytedance.sdk.openadsdk.core.pz.w();
        com.bytedance.sdk.openadsdk.core.pz.kd kdVar = new com.bytedance.sdk.openadsdk.core.pz.kd(this.y);
        com.bytedance.sdk.openadsdk.core.pz.u uVar = new com.bytedance.sdk.openadsdk.core.pz.u();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.bytedance.sdk.openadsdk.am.f w = wVar.xj(pz.getContext(), this, kdVar, uVar, hashSet, f.xj.OTHER).kd(getUrl()).u(com.bytedance.sdk.openadsdk.core.f.xj.c()).xj(com.bytedance.sdk.openadsdk.core.f.xj.xj()).xj("sdkEdition", com.bytedance.sdk.openadsdk.core.f.xj.w()).hf(com.bytedance.sdk.openadsdk.core.f.xj.kd()).w(com.bytedance.sdk.openadsdk.core.f.xj.u()).w(false);
        this.e = w;
        Set<String> tf = w.tf();
        if (this.y == null || tf == null || tf.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.e);
        Iterator<String> it = tf.iterator();
        while (it.hasNext()) {
            this.y.y().xj(it.next(), (com.bytedance.sdk.component.xj.kd<?, ?>) new com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.4
                @Override // com.bytedance.sdk.component.xj.kd
                public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
                    try {
                        com.bytedance.sdk.openadsdk.am.f fVar = (com.bytedance.sdk.openadsdk.am.f) weakReference.get();
                        if (fVar == null) {
                            return null;
                        }
                        return fVar.u(xj(), jSONObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        }
    }

    private void p() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        xj((SSWebView) this);
        if (this.c != null) {
            Context context = this.kd;
            j jVar = this.y;
            ws wsVar = this.c;
            setWebViewClient(new xj(context, jVar, wsVar, wsVar.ho()));
        }
        com.bytedance.sdk.component.adexpress.kd.kd.xj().xj(this, this.y);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.xj.w(this.y));
    }

    private void tf() {
        j jVar = new j(this.kd);
        this.y = jVar;
        jVar.hf(this).xj(this.c).hf(this.c.ho()).u(this.c.jf()).xj(wo.hf(this.c)).kd(wo.zg(this.c)).xj((d) this).kd(com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(0.0f, 0.0f, false, this.c)).xj(this.yo).xj((SSWebView) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        xj(Integer.MIN_VALUE, Integer.MIN_VALUE, this.tf.getWidth(), this.tf.getHeight());
        tf();
        d();
        p();
        loadUrl(io.kd(this.c).xj(this.tf.getWidth() <= this.tf.getHeight()));
        setExpressVideoListener(this.f10432pl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public boolean E_() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public void F_() {
        if (this.y == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new et(this, this.y, this.c));
        if (this.f != null) {
            this.f.xj(true, getMaxRectJson());
        }
        hf(getVisibility());
    }

    public void c() {
        if (this.p) {
            return;
        }
        this.p = true;
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.5
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.update();
            }
        }, 100L);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.g.w
    public void destroy() {
        this.f10432pl = null;
        I_();
        setOnShakeListener(null);
        j jVar = this.y;
        if (jVar != null) {
            jVar.kd();
            this.y.xj((SSWebView.hf) null);
        }
        this.y = null;
        super.destroy();
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void f() {
        xj(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk.w
    public JSONObject getActualRectJson() {
        return qt.xj(this.jk);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.tf.getLeft();
            int top = this.tf.getTop();
            jSONArray.put(0, r.u(getContext(), left));
            jSONArray.put(1, r.u(getContext(), top));
            jSONObject.put(SQLiteMTAHelper.TABLE_POINT, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.tf.getMeasuredWidth();
            int measuredHeight = this.tf.getMeasuredHeight();
            jSONArray2.put(0, r.u(getContext(), measuredWidth));
            jSONArray2.put(1, r.u(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("xeasy", e.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.bytedance.sdk.openadsdk.core.dk.hf hfVar = this.f;
        if (hfVar != null) {
            return hfVar.hf();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk.w
    public double getExceedAreaRate() {
        return this.pz;
    }

    public j getJsObject() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk.w
    public JSONObject getMaxRectJson() {
        return qt.xj(this.v);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.g.w
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        xj(i == 0);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        xj(z);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.zg);
        removeCallbacks(this.qt);
        if (i == 0) {
            postDelayed(this.qt, 50L);
        } else {
            postDelayed(this.zg, 50L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public void setEasyPlayInteractionAreaInfo(qt qtVar) {
        this.jk = qtVar;
    }

    public void setEasyPlayableListener(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj xjVar) {
        this.f10432pl = xjVar;
    }

    public void setExpressVideoListener(com.bytedance.sdk.openadsdk.core.nativeexpress.tf tfVar) {
        j jVar = this.y;
        if (jVar != null) {
            jVar.xj(tfVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public void u() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj xjVar = this.f10432pl;
        if (xjVar != null) {
            xjVar.xj((View) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public void w() {
        if (this.f != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.hf("xeasy", e.getMessage());
            }
            this.f.xj(false, jSONObject);
        }
    }

    public void y() {
        this.g = true;
        j jVar = this.y;
        if (jVar != null) {
            jVar.en();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public void hf() {
        com.bytedance.sdk.openadsdk.core.dk.hf hfVar = this.f;
        if (hfVar != null) {
            hfVar.w();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public void xj(qt qtVar, double d) {
        this.v = qtVar;
        this.pz = d;
        this.d = qtVar;
    }

    public static class xj extends com.bytedance.sdk.openadsdk.core.widget.xj.u {
        private ws xj;

        public xj(Context context, j jVar, ws wsVar, String str) {
            super(context, jVar, str);
            this.xj = wsVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.xj.hf.xj xj = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj.xj(webView, this.xj, str, new xj.InterfaceC0174xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.xj.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj.InterfaceC0174xj
                    public boolean xj() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf.xj.InterfaceC0174xj
                    public com.bytedance.sdk.component.adexpress.xj.hf.xj xj(String str2, tf.xj xjVar, String str3) {
                        com.bytedance.sdk.component.adexpress.xj.hf.xj xjVar2 = new com.bytedance.sdk.component.adexpress.xj.hf.xj();
                        xjVar2.xj(5);
                        xjVar2.xj(com.bytedance.sdk.openadsdk.core.ugeno.kd.xj.hf().xj(webView, xjVar, str2));
                        return xjVar2;
                    }
                });
                if (xj != null && xj.xj() != null) {
                    return xj.xj();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.xj.u, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.w("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    public void hf(int i) {
        if (i == this.am) {
            return;
        }
        this.am = i;
        if (this.y == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", i == 0);
            this.y.xj("expressAdShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d
    public void xj(final int i, final int i2, final int i3, final int i4) {
        com.bytedance.sdk.openadsdk.x.c.xj((Runnable) new com.bytedance.sdk.component.tf.d("changeFrame") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.6
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
                int i5 = i;
                if (i5 == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
                    layoutParams.gravity = 17;
                }
                if (i5 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationX(i5);
                }
                int i6 = i2;
                if (i6 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationY(i6);
                }
                PlayableFeedWebView.this.setLayoutParams(layoutParams);
            }
        });
    }

    private void xj(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.kd).xj(false).xj(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            com.bytedance.sdk.openadsdk.core.a.pz.xj(sSWebView, ai.w, ws.u(this.c));
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
            com.bytedance.sdk.component.utils.pl.u("xeasy", e.toString());
        }
    }

    public void xj(boolean z) {
        j jVar = this.y;
        if (jVar != null) {
            jVar.p(z);
        }
    }

    @Override // com.bytedance.sdk.component.g.hf.xj
    public Pair<Boolean, Boolean> xj(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int u = r.u(getContext(), x);
        int u2 = r.u(getContext(), y);
        qt qtVar = this.d;
        if (qtVar == null || qtVar.xj(u, u2)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.dk.hf.xj(this.c, u, u2, 2);
        return new Pair<>(Boolean.TRUE, Boolean.FALSE);
    }
}
