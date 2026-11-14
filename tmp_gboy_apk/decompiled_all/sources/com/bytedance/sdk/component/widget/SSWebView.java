package com.bytedance.sdk.component.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.web.BizWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SSWebView extends BizWebView {
    private JSONObject ai;
    private boolean am;
    private JSONObject c;
    private float d;
    private AtomicBoolean dk;
    private float e;
    private AtomicInteger et;
    private boolean f;
    private long g;
    private AtomicBoolean ht;

    /* renamed from: io, reason: collision with root package name */
    private JSONObject f10244io;
    private hf jk;
    private com.bytedance.sdk.component.widget.hf.xj kd;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private long f10245pl;
    private ht pz;
    private w q;
    private float qt;
    private AtomicBoolean ra;
    private float tf;
    private int v;
    private JSONObject x;
    private String y;
    private int yo;
    private float zg;

    public interface hf {
        void xj(int i);
    }

    public interface w {
        void xj(boolean z);
    }

    public static class xj extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }

    public SSWebView(Context context) {
        super(context);
        this.d = 0.0f;
        this.tf = 0.0f;
        this.p = 0L;
        this.f10245pl = 0L;
        this.g = 0L;
        this.am = false;
        this.qt = 20.0f;
        this.e = 50.0f;
        this.ht = new AtomicBoolean();
        this.ra = new AtomicBoolean();
        this.dk = new AtomicBoolean(true);
        this.et = new AtomicInteger();
    }

    private static boolean hf(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            pl.xj(th2);
            return false;
        }
    }

    private boolean w(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            pl.xj(th2);
            return false;
        }
    }

    private void y() {
        this.pz = null;
        this.jk = null;
        setTouchStateListener(null);
        I_();
        this.kd = null;
        this.c = null;
        this.f = false;
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        y();
        super.G_();
    }

    public boolean H_() {
        ht htVar = this.pz;
        if (htVar == null) {
            return false;
        }
        return htVar.xj();
    }

    public void I_() {
        this.ra.set(false);
        ht htVar = this.pz;
        if (htVar != null) {
            com.bytedance.sdk.component.widget.hf.xj xjVar = this.kd;
            htVar.u(xjVar != null ? xjVar.xj() : 0);
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.g.w
    public void destroy() {
        super.destroy();
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        w wVar = this.q;
        if (wVar != null) {
            wVar.xj(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.sdk.component.widget.hf.xj getMaterialMeta() {
        return this.kd;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ht.set(true);
        if (this.ra.get()) {
            hf(this.et.get(), this.dk.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ht.set(false);
        ht htVar = this.pz;
        if (htVar != null) {
            com.bytedance.sdk.component.widget.hf.xj xjVar = this.kd;
            htVar.hf(xjVar != null ? xjVar.xj() : 0);
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent xj2;
        try {
            xj(motionEvent);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.am && (xj2 = xj((View) this)) != null) {
                xj2.requestDisallowInterceptTouchEvent(true);
            }
            return onInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.g.w
    public void onPause() {
        super.onPause();
        w wVar = this.q;
        if (wVar != null) {
            wVar.xj(false);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ht htVar = this.pz;
        if (htVar != null) {
            if (z) {
                com.bytedance.sdk.component.widget.hf.xj xjVar = this.kd;
                htVar.xj(xjVar != null ? xjVar.xj() : 0);
            } else {
                com.bytedance.sdk.component.widget.hf.xj xjVar2 = this.kd;
                htVar.hf(xjVar2 != null ? xjVar2.xj() : 0);
            }
        }
    }

    public void setCalculationMethod(int i) {
        this.yo = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.v = i;
    }

    public void setDeepShakeValue(float f) {
        this.zg = f;
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.am = z;
    }

    public void setLandingPage(boolean z) {
        this.f = z;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.hf.xj xjVar) {
        this.kd = xjVar;
    }

    public void setOnShakeListener(hf hfVar) {
        this.jk = hfVar;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.x = jSONObject;
    }

    public void setShakeValue(float f) {
        this.qt = f;
    }

    public void setTag(String str) {
        this.y = str;
    }

    public void setTouchStateListener(w wVar) {
        this.q = wVar;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.f10244io = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.ai = jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.g.w
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof w) {
            setTouchStateListener((w) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new xj();
        }
        super.setWebViewClient(webViewClient);
    }

    public void setWriggleValue(float f) {
        this.e = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent xj(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (hf(view2) || w(view2)) ? parent : xj(view2);
    }

    @Override // android.view.View
    public String getTag() {
        return this.y;
    }

    public void xj(int i, boolean z) {
        this.dk.set(z);
        this.et.set(i);
        this.ra.set(true);
        if (this.ht.get()) {
            hf(i, z);
        }
    }

    private void hf(int i, boolean z) {
        ht htVar = this.pz;
        if (htVar == null) {
            this.pz = new ht(getContext(), i, z);
        } else {
            htVar.xj(z);
        }
        this.pz.xj(this.qt);
        this.pz.w(this.zg);
        this.pz.hf(this.e);
        this.pz.xj(this.f10244io);
        this.pz.w(this.x);
        this.pz.hf(this.ai);
        this.pz.kd(this.yo);
        this.pz.y(this.v);
        this.pz.xj(new ht.xj() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.ht.xj
            public void xj(int i2) {
                if (i2 == 1) {
                    SSWebView.this.xj(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.xj(2);
                }
            }
        });
        ht htVar2 = this.pz;
        com.bytedance.sdk.component.widget.hf.xj xjVar = this.kd;
        htVar2.w(xjVar != null ? xjVar.xj() : 0);
    }

    public void xj(int i) {
        hf hfVar = this.jk;
        if (hfVar != null) {
            hfVar.xj(i);
        }
    }

    private void xj(MotionEvent motionEvent) {
        if (!this.f || this.kd == null) {
            return;
        }
        if ((this.y == null && this.c == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.d = motionEvent.getRawX();
                this.tf = motionEvent.getRawY();
                this.p = System.currentTimeMillis();
                this.c = new JSONObject();
                if (this.hf != null) {
                    this.hf.setTag(2064056319, Long.valueOf(this.p));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.c.put("start_x", String.valueOf(this.d));
                this.c.put("start_y", String.valueOf(this.tf));
                this.c.put("offset_x", String.valueOf(motionEvent.getRawX() - this.d));
                this.c.put("offset_y", String.valueOf(motionEvent.getRawY() - this.tf));
                this.c.put("url", String.valueOf(getUrl()));
                this.c.put("tag", "");
                this.f10245pl = System.currentTimeMillis();
                if (this.hf != null) {
                    this.hf.setTag(2064056318, Long.valueOf(this.f10245pl));
                }
                this.c.put("down_time", this.p);
                this.c.put("up_time", this.f10245pl);
                if (com.bytedance.sdk.component.widget.xj.xj.xj().hf() != null) {
                    long j = this.g;
                    long j2 = this.p;
                    if (j != j2) {
                        this.g = j2;
                        com.bytedance.sdk.component.widget.xj.xj.xj();
                    }
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }
}
