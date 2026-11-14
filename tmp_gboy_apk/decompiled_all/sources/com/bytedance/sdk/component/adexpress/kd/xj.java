package com.bytedance.sdk.component.adexpress.kd;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.component.adexpress.hf.c;
import com.bytedance.sdk.component.adexpress.hf.f;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.adexpress.hf.p;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj implements p, com.bytedance.sdk.component.adexpress.hf.u<SSWebView>, com.bytedance.sdk.component.adexpress.theme.xj, com.bytedance.sdk.component.adexpress.xj {
    private int am;
    private String c;
    private volatile c d;
    private String f;
    private boolean g;
    protected boolean hf;
    private f p;

    /* renamed from: pl, reason: collision with root package name */
    private g f10193pl;
    private boolean tf;
    protected SSWebView w;
    protected JSONObject xj;
    private Context y;
    protected int u = 8;
    protected AtomicBoolean kd = new AtomicBoolean(false);
    private boolean qt = false;

    public xj(Context context, g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.tf = false;
        this.y = context;
        this.f10193pl = gVar;
        this.c = gVar.y();
        themeStatusBroadcastReceiver.xj(this);
        if (com.bytedance.sdk.component.adexpress.u.xj()) {
            pl();
            return;
        }
        SSWebView g = g();
        this.w = g;
        if (g != null) {
            this.tf = true;
        } else if (com.bytedance.sdk.component.adexpress.u.getContext() != null) {
            this.w = new SSWebView(com.bytedance.sdk.component.adexpress.u.getContext());
        }
    }

    private void am() {
        if (this.f10193pl.io()) {
            kd.xj().hf(this.w);
        } else {
            kd.xj().w(this.w);
        }
    }

    private SSWebView g() {
        return this.f10193pl.io() ? kd.xj().xj(this.y, this.c) : kd.xj().hf(this.y, this.c);
    }

    private void pl() {
        if (this.y == null && com.bytedance.sdk.component.adexpress.u.getContext() != null) {
            this.y = com.bytedance.sdk.component.adexpress.u.getContext();
        }
        if (this.y != null) {
            SSWebView g = g();
            this.w = g;
            if (g == null) {
                this.w = new SSWebView(new MutableContextWrapper(this.y.getApplicationContext()));
            } else {
                this.tf = true;
            }
        }
    }

    public void d() {
    }

    public void f() {
        d();
        Activity xj = com.bytedance.sdk.component.utils.hf.xj(this.w);
        if (xj != null) {
            this.am = hf(xj);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public SSWebView c() {
        return xj();
    }

    public abstract void hf(int i);

    public void kd() {
        if (xj() == null) {
            return;
        }
        try {
            xj().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public g p() {
        return this.f10193pl;
    }

    public void tf() {
    }

    public void u() {
        if (this.kd.get()) {
            return;
        }
        this.kd.set(true);
        y();
        if (this.w.getParent() != null) {
            ((ViewGroup) this.w.getParent()).removeView(this.w);
        }
        if (this.hf) {
            am();
        } else {
            kd.xj().kd(this.w);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public int w() {
        return 0;
    }

    public void xj(boolean z, int i) {
    }

    public abstract void y();

    private int hf(Activity activity) {
        return activity.hashCode();
    }

    public void xj(String str) {
        this.f = str;
    }

    public SSWebView xj() {
        return this.w;
    }

    public void xj(f fVar) {
        this.p = fVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public void xj(c cVar) {
        this.d = cVar;
        if (xj() != null && xj().getWebView() != null) {
            if (TextUtils.isEmpty(this.f)) {
                this.d.xj(102, "url is empty");
                return;
            }
            if (!this.f10193pl.io()) {
                if (!this.qt && !com.bytedance.sdk.component.adexpress.xj.hf.hf.xj(this.xj)) {
                    c cVar2 = this.d;
                    StringBuilder sb = new StringBuilder("data null is ");
                    sb.append(this.xj == null);
                    cVar2.xj(103, sb.toString());
                    return;
                }
                if (this.qt && !com.bytedance.sdk.component.adexpress.xj.hf.hf.w(this.xj)) {
                    c cVar3 = this.d;
                    StringBuilder sb2 = new StringBuilder("choice ad data null is ");
                    sb2.append(this.xj == null);
                    cVar3.xj(103, sb2.toString());
                    return;
                }
            } else if (w() == 9 && !com.bytedance.sdk.component.adexpress.xj.hf.hf.hf(this.xj)) {
                c cVar4 = this.d;
                StringBuilder sb3 = new StringBuilder("data null is ");
                sb3.append(this.xj == null);
                cVar4.xj(103, sb3.toString());
                return;
            }
            this.f10193pl.c().hf(this.tf);
            if (this.tf) {
                try {
                    this.w.clearView();
                    this.f10193pl.c().c();
                    com.bytedance.sdk.component.utils.p.xj(this.w.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                    return;
                } catch (Exception e) {
                    kd.xj().kd(this.w);
                    this.d.xj(102, "load exception is " + e.getMessage());
                    return;
                }
            }
            SSWebView xj = xj();
            xj.clearView();
            this.f10193pl.c().c();
            xj.loadUrl(this.f);
            return;
        }
        c cVar5 = this.d;
        StringBuilder sb4 = new StringBuilder("SSWebview null is ");
        sb4.append(xj() == null);
        sb4.append(" or Webview is null");
        cVar5.xj(102, sb4.toString());
    }

    public void xj(boolean z) {
        this.g = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.p
    public void xj(final am amVar) {
        if (amVar == null) {
            if (this.d != null) {
                this.d.xj(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean w = amVar.w();
        final float u = (float) amVar.u();
        final float kd = (float) amVar.kd();
        if (w() == 0 && (u <= 0.0f || kd <= 0.0f)) {
            if (this.d != null) {
                this.d.xj(105, "width is " + u + "height is " + kd);
                return;
            }
            return;
        }
        this.hf = w;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xj(amVar, u, kd);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.kd.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.xj(amVar, u, kd);
                }
            });
        }
    }

    public void xj(am amVar, float f, float f2) {
        xj(this.hf, amVar.p());
        boolean z = this.hf;
        if (z && !this.g) {
            xj(f, f2);
            hf(this.u);
            if (this.d != null) {
                this.d.xj(xj(), amVar);
                return;
            }
            return;
        }
        if (!z) {
            kd.xj().kd(this.w);
        }
        xj(amVar.p(), amVar.tf());
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.p
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
        f fVar = this.p;
        if (fVar != null) {
            fVar.xj(view, i, wVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.p
    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
        f fVar = this.p;
        if (fVar != null) {
            fVar.xj(view, i, wVar, i2);
        }
    }

    @UiThread
    public void xj(float f, float f2) {
        this.f10193pl.c().f();
        if (com.bytedance.sdk.component.adexpress.u.xj() && w() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) xj().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            xj().setLayoutParams(layoutParams);
            return;
        }
        int xj = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.y, f);
        int xj2 = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.y, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) xj().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(xj, xj2);
        }
        layoutParams2.width = xj;
        layoutParams2.height = xj2;
        xj().setLayoutParams(layoutParams2);
    }

    private void xj(int i, String str) {
        if (this.d != null) {
            this.d.xj(i, str);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xj
    public void xj(Activity activity) {
        if (this.am == 0 || activity == null || activity.hashCode() != this.am) {
            return;
        }
        u();
        tf();
    }
}
