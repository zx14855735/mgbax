package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.am.d;
import com.bytedance.sdk.openadsdk.core.am.kd;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.jk.y;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {
    protected SSWebView c;
    protected d d;
    protected j f;
    protected ws hf;
    protected int jk;
    protected com.bytedance.sdk.openadsdk.core.widget.xj.u p;

    /* renamed from: pl, reason: collision with root package name */
    kd f10308pl;
    protected int pz;
    protected String tf;
    protected boolean u;
    protected int v;
    protected String w;
    protected TTBaseVideoActivity xj;
    protected AtomicInteger yo;
    int kd = 0;
    int y = 0;
    int g = 0;
    String am = "";
    protected boolean qt = false;
    protected boolean zg = false;
    protected final AtomicBoolean e = new AtomicBoolean(true);
    protected AtomicBoolean ht = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.jk.xj ra = new com.bytedance.sdk.openadsdk.core.jk.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj.1
        @Override // com.bytedance.sdk.openadsdk.core.jk.xj
        public int hf() {
            SSWebView sSWebView = xj.this.c;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            pl.xj("TTAndroidObject", "mWebView>>>>width=".concat(String.valueOf(measuredWidth)));
            return measuredWidth <= 0 ? r.u((Context) xj.this.xj) : measuredWidth;
        }

        @Override // com.bytedance.sdk.openadsdk.core.jk.xj
        public int xj() {
            SSWebView sSWebView = xj.this.c;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            pl.xj("TTAndroidObject", "mWebView>>>>height=".concat(String.valueOf(measuredHeight)));
            return measuredHeight <= 0 ? r.kd((Context) xj.this.xj) : measuredHeight;
        }
    };
    protected y dk = new y() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj.2
        @Override // com.bytedance.sdk.openadsdk.core.jk.y
        public void hf() {
            SSWebView sSWebView = xj.this.c;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }

        @Override // com.bytedance.sdk.openadsdk.core.jk.y
        public void xj() {
            SSWebView sSWebView = xj.this.c;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }
    };

    public xj(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, String str, int i, int i2, boolean z) {
        this.xj = tTBaseVideoActivity;
        this.hf = wsVar;
        this.w = str;
        this.v = wsVar.rs();
        if (pz.hf().fa()) {
            float f = this.xj.getResources().getDisplayMetrics().density;
            float f2 = Resources.getSystem().getDisplayMetrics().density;
            this.jk = r.hf(f2, r.xj(f, i));
            this.pz = r.hf(f2, r.xj(f, i2));
        } else {
            this.jk = i;
            this.pz = i2;
        }
        this.u = z;
    }

    private void ai() {
        if (this.ht.getAndSet(true)) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, r.kd((Context) this.xj));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                r.xj((View) xj.this.c, 8);
                xj.this.ht.set(false);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(int i, int i2) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, i);
            jSONObject.put(MediaFormat.KEY_HEIGHT, i2);
            this.f.xj("resize", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private void x() {
        if (this.ht.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationY", r.kd((Context) this.xj), 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    xj.this.ht.set(false);
                }
            });
            ofFloat.start();
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public void am() {
        kd kdVar = this.f10308pl;
        if (kdVar != null) {
            kdVar.kd();
        }
    }

    public boolean c() {
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void d() {
        this.d = null;
    }

    public abstract String dk();

    public void e() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void et() {
    }

    public void f() {
        SSWebView sSWebView = this.c;
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return;
        }
        this.c.goBack();
    }

    public void g() {
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        j jVar = this.f;
        if (jVar != null) {
            jVar.ai();
            this.f.y(false);
            xj(false);
            xj(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = this.p;
        if (uVar != null) {
            uVar.w();
        }
    }

    public boolean ht() {
        return xj(this.tf);
    }

    public void io() {
        j jVar = this.f;
        if (jVar == null) {
            return;
        }
        jVar.xj(new SSWebView.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj.6
            @Override // com.bytedance.sdk.component.widget.SSWebView.hf
            public void xj(int i) {
                j jVar2 = xj.this.f;
                if (jVar2 != null) {
                    jVar2.xj(i);
                }
            }
        });
    }

    public void jk() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.w();
            this.d.u();
        }
    }

    public void kd() {
        kd kdVar = this.f10308pl;
        if (kdVar != null) {
            kdVar.xj(System.currentTimeMillis());
        }
    }

    public String p() {
        return this.am;
    }

    public void pl() {
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        j jVar = this.f;
        if (jVar != null) {
            jVar.x();
            SSWebView sSWebView2 = this.c;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.f.y(true);
                    xj(true);
                    xj(false, true);
                } else {
                    this.f.y(false);
                    xj(false);
                    xj(true, false);
                }
            }
        }
        kd kdVar = this.f10308pl;
        if (kdVar != null) {
            kdVar.u();
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.u uVar = this.p;
        if (uVar != null) {
            uVar.hf(false);
        }
    }

    public boolean pz() {
        j jVar = this.f;
        if (jVar == null) {
            return false;
        }
        return jVar.pz();
    }

    public void qt() {
        j jVar = this.f;
        if (jVar != null) {
            jVar.q();
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.xj(true);
            this.d.zg();
        }
        kd kdVar = this.f10308pl;
        if (kdVar != null) {
            kdVar.y();
        }
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            a.xj(this.xj, sSWebView);
            a.xj(this.c);
            this.c.destroy();
        }
        this.c = null;
    }

    public void ra() {
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            sSWebView.loadUrl("about:blank");
        }
    }

    public int tf() {
        return this.g;
    }

    public void u(boolean z) {
    }

    public void v() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.pl();
        }
    }

    public void w(boolean z) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            this.f.y(z);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public abstract void xj(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.hf.hf hfVar);

    public abstract void xj(boolean z, Map<String, Object> map, View view);

    public void y() {
        if (this.xj.aq() instanceof com.bytedance.sdk.openadsdk.core.component.reward.u.d) {
            ai();
        } else {
            r.xj((View) this.c, 8);
        }
    }

    public void yo() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.p();
        }
    }

    public void zg() {
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.c.resumeTimers();
            r.xj((View) this.c, 1.0f);
            io();
        }
    }

    public boolean u() {
        return this.qt;
    }

    public void xj() {
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SSWebView sSWebView2 = xj.this.c;
                    if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                        return;
                    }
                    xj.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = xj.this.c.getMeasuredWidth();
                    int measuredHeight = xj.this.c.getMeasuredHeight();
                    if (xj.this.c.getVisibility() == 0) {
                        xj.this.hf(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    public boolean w() {
        if (!ht()) {
            return false;
        }
        AtomicInteger atomicInteger = this.yo;
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return this.e.get();
        }
        return true;
    }

    public void xj(boolean z) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.f.xj("viewableChange", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void hf(boolean z) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.f.xj("volumeChange", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void xj(boolean z, boolean z2) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.f.xj("endcard_control_event", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public boolean hf() {
        return this.zg;
    }

    public void xj(int i, int i2) {
        if (this.f == null || this.xj.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i);
            jSONObject.put("downloadProcessRate", i2);
            this.f.hf("showDownloadStatus", jSONObject);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void xj(long j, long j2, int i) {
        if (j2 > 0) {
            xj(i, (int) ((j * 100) / j2));
        }
    }

    public void xj(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.xj.hf.xj(this.xj).xj(false).hf(false).xj(sSWebView);
        com.bytedance.sdk.openadsdk.core.a.pz.xj(sSWebView, ai.w, ws.u(this.hf));
        r.xj((com.bytedance.sdk.component.g.w) sSWebView);
        int i = Build.VERSION.SDK_INT;
        sSWebView.setMixedContentMode(0);
        if (i < 24) {
            this.c.setLayerType(0, null);
        }
    }

    public void xj(int i) {
        r.xj((View) this.c, 0);
        if (i == 1) {
            r.xj((View) this.c, 0.0f);
        }
        if (i == 2) {
            x();
        }
        j jVar = this.f;
        if (jVar != null) {
            jVar.xj(wo.zg(this.hf), false);
        }
    }

    public void xj(Map<String, Object> map) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.tf();
        }
    }

    public void xj(boolean z, int i, String str) {
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        if (z) {
            dVar.hf();
        } else {
            dVar.xj(i, str);
        }
    }

    private boolean xj(String str) {
        try {
            new URL(str);
            if (URLUtil.isValidUrl(str)) {
                if (Patterns.WEB_URL.matcher(str).matches()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void xj(JSONObject jSONObject) {
        j jVar = this.f;
        if (jVar == null) {
            pl.u("BaseEndCard", "mJsObject is null!");
        } else {
            jVar.xj("showPlayAgainEntrance", jSONObject);
        }
    }

    public void xj(ws wsVar) {
        this.hf = wsVar;
        this.qt = false;
    }
}
