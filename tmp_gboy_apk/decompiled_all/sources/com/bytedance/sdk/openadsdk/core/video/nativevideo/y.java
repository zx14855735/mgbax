package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import J3FDQU.A2egSU;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.u.hf;
import com.bykv.vk.openvk.component.video.xj.kd.hf;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.jk;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.pl.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.am;
import com.bytedance.sdk.openadsdk.core.widget.qt;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.upie.video.lottie.TTLottieVideoContainer;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements com.bykv.vk.openvk.component.video.api.renderview.xj, com.bykv.vk.openvk.component.video.api.u.hf<ws>, ai.xj, am.xj, qt.hf {

    /* renamed from: a, reason: collision with root package name */
    boolean f10449a;
    hf ai;
    TextView am;
    private TextView aq;
    private TextView b;
    private com.bytedance.sdk.openadsdk.core.hf.xj bl;
    protected TTViewStub c;
    ImageView d;
    private RelativeLayout dc;
    EnumSet<hf.xj> dk;
    private int dq;
    int e;
    com.bytedance.sdk.openadsdk.core.hf.xj en;
    ws et;
    private RelativeLayout eu;
    View f;
    com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj ff;
    TextView g;
    private final int gh;
    private final int gy;
    com.bykv.vk.openvk.component.video.api.renderview.hf hf;
    private TTViewStub hl;
    volatile boolean ht;

    /* renamed from: io, reason: collision with root package name */
    Context f10450io;
    com.bykv.vk.openvk.component.video.api.u.w j;
    int jk;
    View kd;
    com.bytedance.sdk.openadsdk.core.hf.xj l;
    private xj.InterfaceC0173xj lw;
    private TextView n;
    private AtomicBoolean nb;
    private final int op;
    RoundImageView p;

    /* renamed from: pl, reason: collision with root package name */
    TextView f10451pl;
    boolean pz;
    boolean q;
    private boolean qd;
    TTProgressBar qt;
    private TextView r;
    int ra;
    private String s;
    View tf;
    private RoundImageView tj;
    private TextView tu;
    View u;
    int v;
    private View vm;
    ImageView w;
    private c wa;
    private RoundImageView wn;
    private View wo;
    private NativeVideoTsView.xj ws;
    qt x;
    View xj;
    ImageView y;
    int yo;
    private RelativeLayout yy;
    com.bytedance.sdk.openadsdk.core.pl.hf.w z;
    protected TTViewStub zg;

    public y(Context context, View view, boolean z, EnumSet<hf.xj> enumSet, ws wsVar, com.bykv.vk.openvk.component.video.api.u.w wVar, boolean z2, com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        this.pz = true;
        this.q = true;
        this.f10449a = true;
        this.gh = 1;
        this.op = 2;
        this.gy = 3;
        this.nb = new AtomicBoolean(false);
        if (this instanceof kd) {
            return;
        }
        this.f10450io = pz.getContext().getApplicationContext();
        u(z2);
        this.xj = view;
        this.pz = z;
        this.dk = enumSet == null ? EnumSet.noneOf(hf.xj.class) : enumSet;
        this.j = wVar;
        this.bl = xjVar;
        this.et = wsVar;
        q();
        u(8);
        xj(context, this.xj, wsVar);
        u();
        zg();
    }

    private boolean a() {
        return TextUtils.equals(this.s, "splash_ad") || TextUtils.equals(this.s, "cache_splash_ad");
    }

    private boolean b() {
        ws wsVar;
        return this.q && this.tf != null && (wsVar = this.et) != null && wsVar.ws() == 1;
    }

    private void en() {
        if (this.f10450io == null || this.xj == null) {
            return;
        }
        View view = new View(this.f10450io) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.8
            private final AtomicBoolean hf = new AtomicBoolean(true);

            private void hf() {
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar;
                if (this.hf.getAndSet(true) || (wVar = y.this.z) == null) {
                    return;
                }
                wVar.hf();
            }

            private void xj() {
                if (y.this.et == null) {
                    return;
                }
                if (this.hf.getAndSet(false) && (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(y.this.et) || y.this.et.vw() == 4)) {
                    y.this.z();
                }
                ht.xj(y.this.et.ko(), y.this.wa, c.class);
            }

            @Override // android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                y.this.nb.set(false);
                xj();
            }

            @Override // android.view.View
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                y.this.nb.set(true);
                hf();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                xj();
            }

            @Override // android.view.View
            public void onMeasure(int i, int i2) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                hf();
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = y.this.z;
                if (wVar == null || !z) {
                    return;
                }
                wVar.xj();
            }
        };
        View view2 = this.xj;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    private void ff() {
        final long currentTimeMillis = System.currentTimeMillis();
        ws wsVar = this.et;
        if (wsVar != null && com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            String d = wo.d(this.et);
            if (!TextUtils.isEmpty(d)) {
                com.bytedance.sdk.openadsdk.f.hf.xj(d).to(this.tj);
            }
            String w = wo.w(this.et);
            String f = wo.f(this.et);
            if (!TextUtils.isEmpty(w)) {
                r.xj(this.n, w);
            }
            if (this.eu == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.f.hf.xj(f).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.10
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                    y yVar = y.this;
                    com.bytedance.sdk.openadsdk.core.am.u.xj(yVar.et, yVar.s, i, str);
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(y.this.f10450io, zgVar.getResult(), 25);
                    if (xj == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(y.this.eu.getResources(), xj);
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (y.this.eu != null) {
                                y.this.eu.setBackground(bitmapDrawable);
                            }
                        }
                    });
                    y yVar = y.this;
                    com.bytedance.sdk.openadsdk.core.am.u.u(yVar.et, yVar.s, System.currentTimeMillis() - currentTimeMillis);
                }
            }, 4);
        }
    }

    private boolean j() {
        ws wsVar = this.et;
        return wsVar != null && hl.y(wsVar) == null && hl.c(this.et) == null && this.et.dq() == 1 && ws.hf(this.et);
    }

    private boolean l() {
        if (this.et == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.s) || "rewarded_video".equals(this.s)) {
            int rs = this.et.rs();
            float yq = this.et.yq();
            if (rs == 1 && yq == 100.0f) {
                return true;
            }
        }
        return false;
    }

    private void q() {
        this.dq = 1;
        String hf = com.bytedance.sdk.openadsdk.core.a.wo.hf(this.et);
        String str = "embeded_ad_landingpage";
        if (hf == null) {
            hf = this.q ? "embeded_ad" : "embeded_ad_landingpage";
        }
        this.dq = com.bytedance.sdk.openadsdk.core.a.wo.hf(hf);
        if (!this.q && hf.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.q || !hf.equals("embeded_ad")) {
            str = hf;
        }
        this.s = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.tf;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.xj;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.xj.getMeasuredHeight();
            int w = r.w(this.f10450io, 200.0f);
            int w2 = r.w(this.f10450io, 331.0f);
            int w3 = r.w(this.f10450io, 110.0f);
            int w4 = r.w(this.f10450io, 100.0f);
            if (measuredWidth >= w && measuredHeight >= w2) {
                y(1);
                return;
            }
            if (measuredWidth > w3 && measuredHeight > w4) {
                y(3);
                return;
            }
            y(2);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private void wo() {
        if (a()) {
            r.xj((View) this.w, 8);
            if (!pz.hf().kc()) {
                r.xj(this.u, 8);
                r.xj(this.kd, 8);
                r.xj((View) this.y, 8);
                return;
            }
        }
        r.xj(this.u, 0);
        r.xj((View) this.eu, 8);
        r.y(this.u);
        if (a() && pz.hf().kc()) {
            r.xj(this.kd, 8);
        } else {
            r.y(this.kd);
        }
        if (this.y == null || TextUtils.isEmpty(h.hf(this.et))) {
            return;
        }
        r.y(this.y);
        com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.et)).to(this.y);
        xj(this.y, h.hf(this.et));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.bytedance.sdk.openadsdk.x.c.xj(new d("native_video_layout_download_listener") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.1
            @Override // java.lang.Runnable
            public void run() {
                y yVar = y.this;
                if (yVar.z == null) {
                    yVar.z = f.xj(yVar.f10450io, yVar.et, yVar.s, false);
                }
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar = y.this.en;
                if (xjVar != null) {
                    ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(y.this.z);
                }
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar2 = y.this.l;
                if (xjVar2 != null) {
                    ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(y.this.z);
                }
                if (y.this.lw != null) {
                    y yVar2 = y.this;
                    yVar2.z.xj(yVar2.lw);
                }
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = y.this.z;
                if (wVar != null) {
                    wVar.xj(false);
                }
            }
        });
    }

    public boolean ai() {
        return !this.dk.contains(hf.xj.alwayShowMediaView) || this.pz;
    }

    public void am() {
    }

    @TargetApi(14)
    public void dk() {
        r.xj(this.xj, 0);
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.hf;
        if (hfVar != null) {
            View view = hfVar.getView();
            r.xj(view, 8);
            r.xj(view, 0);
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.hf e() {
        return this.hf;
    }

    public void et() {
        r.xj(this.f, 8);
        r.xj((View) this.d, 8);
        r.xj(this.tf, 8);
        r.xj((View) this.p, 8);
        r.xj((View) this.f10451pl, 8);
        r.xj((View) this.g, 8);
        r.xj((View) this.am, 8);
        r.xj(this.vm, 8);
        r.xj((View) this.dc, 8);
    }

    public boolean g() {
        return this.ht;
    }

    public void hf(ViewGroup viewGroup) {
    }

    public void ht() {
        r.xj(this.u, 8);
        r.xj((View) this.eu, 0);
        ff();
    }

    public void io() {
        ws wsVar = this.et;
        if (wsVar == null) {
            return;
        }
        if (this.et.rh() != 5 ? wsVar.rh() == 1 && aq.e(this.et) : true) {
            xj(false, this.pz);
            xj(this.xj, pz.getContext());
            if (this.d == null || TextUtils.isEmpty(h.hf(this.et))) {
                return;
            }
            r.xj(this.f, 0);
            r.xj((View) this.d, 0);
            r.xj(this.tf, 8);
            com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.et)).to(this.d);
            xj(this.d, h.hf(this.et));
        }
    }

    public void jk() {
        qt qtVar = this.x;
        if (qtVar != null) {
            qtVar.xj(false);
        }
    }

    public void kd() {
    }

    public boolean p() {
        return this.pz;
    }

    public void pl() {
        xj(true, false);
    }

    public boolean pz() {
        if (this.ai != null) {
            return true;
        }
        pl.u("NewLiveViewLayout", "callback is null");
        return false;
    }

    public boolean qt() {
        qt qtVar = this.x;
        return qtVar != null && qtVar.xj();
    }

    public void ra() {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.et)) {
            ht();
        } else {
            r.xj((View) this.eu, 8);
            r.y(this.u);
            r.y(this.kd);
        }
        ImageView imageView = this.w;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        r.xj((View) this.w, 8);
    }

    public boolean tf() {
        return false;
    }

    public void v() {
        if (this.ai == null || this.x != null) {
            return;
        }
        System.currentTimeMillis();
        qt qtVar = new qt();
        this.x = qtVar;
        qtVar.xj(this.f10450io, this.xj);
        this.x.xj(this.ai, this);
        System.currentTimeMillis();
    }

    public void w(boolean z) {
    }

    public void x() {
        if (a()) {
            r.xj((View) this.w, 8);
            r.kd(this.u);
            r.kd(this.kd);
            ImageView imageView = this.y;
            if (imageView != null) {
                r.kd(imageView);
            }
        }
    }

    public void xj(long j) {
    }

    public void y() {
    }

    public void yo() {
        if (this.et == null) {
            return;
        }
        if (this.qd) {
            r.xj((View) this.tu, 8);
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.et)) {
            String d = wo.d(this.et);
            String w = wo.w(this.et);
            String f = wo.f(this.et);
            r.xj(this.vm, 0);
            r.xj((View) this.dc, 0);
            if (!TextUtils.isEmpty(d)) {
                com.bytedance.sdk.openadsdk.f.hf.xj(d).to(this.wn);
            }
            if (!TextUtils.isEmpty(w)) {
                r.xj(this.aq, w);
            }
            if (this.dc == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.f.hf.xj(f).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.9
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(y.this.f10450io, zgVar.getResult(), 25);
                    if (xj == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(y.this.dc.getResources(), xj);
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (y.this.dc != null) {
                                y.this.dc.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    public void zg() {
        View view;
        q();
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.et)) {
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.bl;
            if (xjVar != null) {
                this.en = xjVar;
            } else {
                this.en = new com.bytedance.sdk.openadsdk.core.hf.xj(this.f10450io, this.et, this.s, this.dq);
            }
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.en.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(new xj.InterfaceC0169xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.5
                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.InterfaceC0169xj
                public void xj(View view2, int i) {
                    if (y.this.ws != null) {
                        y.this.ws.xj(view2, i);
                    }
                }
            });
            if (this.bl == null && (view = this.xj) != null) {
                view.setOnClickListener(this.en);
                this.xj.setOnTouchListener(this.en);
            }
            if (r.u(this.yy)) {
                this.yy.setOnClickListener(this.en);
                this.yy.setOnTouchListener(this.en);
                return;
            }
            return;
        }
        en();
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar2 = new com.bytedance.sdk.openadsdk.core.hf.xj(this.f10450io, this.et, this.s, this.dq);
        this.en = xjVar2;
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).hf(true);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.en.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(new xj.InterfaceC0169xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.6
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.InterfaceC0169xj
            public void xj(View view2, int i) {
                if (y.this.ws != null) {
                    y.this.ws.xj(view2, i);
                }
            }
        });
        hf(this.en);
        if (this.q) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.en.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
        } else {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.en.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(false);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.en.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
        }
        if (j()) {
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar3 = new com.bytedance.sdk.openadsdk.core.hf.xj(this.f10450io, this.et, this.s, this.dq);
            this.l = xjVar3;
            hf(xjVar3);
            this.wa = new c(this);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.l.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).hf(true);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.l.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(new xj.InterfaceC0169xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.7
                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.InterfaceC0169xj
                public void xj(View view2, int i) {
                    if (y.this.ws != null) {
                        y.this.ws.xj(view2, i);
                    }
                }
            });
            if (this.q) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.l.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
            } else {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.l.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(false);
            }
            xj(this.l);
            View view2 = this.xj;
            if (view2 != null) {
                view2.setOnClickListener(this.l);
                this.xj.setOnTouchListener(this.l);
            }
        }
    }

    private int c(int i) {
        if (this.v <= 0 || this.jk <= 0) {
            return 0;
        }
        int w = r.w(this.f10450io, 228.0f);
        int w2 = r.w(this.f10450io, 160.0f);
        int i2 = (int) (this.jk * ((i * 1.0f) / this.v));
        return i2 > w ? w : i2 < w2 ? w2 : i2;
    }

    private void f(int i) {
        r.xj(this.tf, i);
        r.xj(this.wo, i);
    }

    public void d() {
        TTProgressBar tTProgressBar = this.qt;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.qt.setSecondaryProgress(0);
        }
        u(8);
        if (ai()) {
            this.hf.setVisibility(8);
        }
        ImageView imageView = this.y;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.y.setBackground(null);
        }
        ImageView imageView2 = this.d;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.d.setBackground(null);
        }
        u(8);
        r.xj(this.f, 8);
        r.xj((View) this.d, 8);
        r.xj(this.tf, 8);
        r.xj((View) this.p, 8);
        r.xj((View) this.f10451pl, 8);
        r.xj((View) this.g, 8);
        r.xj(this.vm, 8);
        r.xj((View) this.dc, 8);
        qt qtVar = this.x;
        if (qtVar != null) {
            qtVar.xj(true);
        }
    }

    public void hf(boolean z) {
    }

    public void u() {
        this.hf.xj(this);
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (y.this.pz()) {
                        TextView textView = y.this.am;
                        if (textView == null || textView.getVisibility() != 0) {
                            y yVar = y.this;
                            yVar.ai.xj(yVar, view);
                        }
                    }
                }
            });
        }
    }

    public boolean w(int i) {
        return false;
    }

    public void xj(long j, long j2) {
    }

    public void kd(int i) {
        r.xj(this.xj, 0);
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.setVisibility(i);
        }
    }

    public void xj(Message message) {
    }

    public void y(int i) {
        ws wsVar;
        if (this.p == null || (wsVar = this.et) == null || wsVar.uf() == null || this.et.uf().xj() == null) {
            return;
        }
        if (i == 1) {
            int w = r.w(this.f10450io, 71.0f);
            RelativeLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(w, w, 14);
            this.p.setLayoutParams(ASJ6gh2);
            this.f10451pl.setLayoutParams(ASJ6gh2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = r.w(this.f10450io, 16.0f);
            layoutParams.topMargin = r.w(this.f10450io, 8.0f);
            layoutParams.leftMargin = r.w(this.f10450io, 16.0f);
            layoutParams.rightMargin = r.w(this.f10450io, 16.0f);
            layoutParams.addRule(3, this.p.getId());
            layoutParams.addRule(14);
            this.g.setLayoutParams(layoutParams);
            this.g.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, r.w(this.f10450io, 32.0f));
            layoutParams2.addRule(14);
            layoutParams2.addRule(3, this.g.getId());
            layoutParams2.leftMargin = r.w(this.f10450io, 20.0f);
            layoutParams2.rightMargin = r.w(this.f10450io, 20.0f);
            this.am.setPadding(r.w(this.f10450io, 36.0f), r.w(this.f10450io, 7.0f), r.w(this.f10450io, 36.0f), r.w(this.f10450io, 8.0f));
            this.am.setLayoutParams(layoutParams2);
            this.am.setEllipsize(TextUtils.TruncateAt.END);
            this.am.setSingleLine(true);
            this.am.setTextSize(14.0f);
            return;
        }
        if (i == 2) {
            int w2 = r.w(this.f10450io, 40.0f);
            RelativeLayout.LayoutParams ASJ6gh3 = A2egSU.ASJ6gh(w2, w2, 14);
            this.p.setLayoutParams(ASJ6gh3);
            this.f10451pl.setLayoutParams(ASJ6gh3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.bottomMargin = r.w(this.f10450io, 8.0f);
            layoutParams3.topMargin = r.w(this.f10450io, 8.0f);
            layoutParams3.addRule(3, this.p.getId());
            layoutParams3.addRule(14);
            this.g.setLayoutParams(layoutParams3);
            this.g.setTextSize(10.0f);
            r.xj((View) this.am, 8);
            return;
        }
        int w3 = r.w(this.f10450io, 49.0f);
        RelativeLayout.LayoutParams ASJ6gh4 = A2egSU.ASJ6gh(w3, w3, 14);
        this.p.setLayoutParams(ASJ6gh4);
        this.f10451pl.setLayoutParams(ASJ6gh4);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.bottomMargin = r.w(this.f10450io, 8.0f);
        layoutParams4.topMargin = r.w(this.f10450io, 8.0f);
        layoutParams4.addRule(3, this.p.getId());
        layoutParams4.addRule(14);
        this.g.setLayoutParams(layoutParams4);
        this.g.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, r.w(this.f10450io, 28.0f));
        layoutParams5.addRule(13);
        layoutParams5.addRule(3, this.g.getId());
        int w4 = r.w(this.f10450io, 20.0f);
        int w5 = r.w(this.f10450io, 25.0f);
        int w6 = r.w(this.f10450io, 6.0f);
        TextPaint paint = this.am.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.am.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String charSequence = text.toString();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        this.am.setTextSize(13.0f);
        if (this.am.getWidth() > rect.width() + (w5 * 2)) {
            if (this.am.getHeight() > rect.height() + (w6 * 2)) {
                layoutParams5.leftMargin = w4;
                layoutParams5.rightMargin = w4;
                this.am.setPadding(w5, r.w(this.f10450io, 5.0f), w5, w6);
            }
        }
        this.am.setEllipsize(TextUtils.TruncateAt.END);
        this.am.setSingleLine(true);
        this.am.setLayoutParams(layoutParams5);
    }

    private void hf(com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        ws wsVar;
        if (xjVar == null || (wsVar = this.et) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.zg.w.hf.am xj = com.bytedance.sdk.openadsdk.core.video.u.xj.xj(Integer.valueOf(wsVar.hashCode()));
        if (xj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.pz) {
            ((com.bytedance.sdk.openadsdk.core.nativeexpress.pz) xj).xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        }
    }

    public void f() {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.et)) {
            r.xj((View) this.eu, 8);
        } else {
            r.kd(this.u);
        }
    }

    public void w(int i, int i2) {
        this.v = i;
        this.jk = i2;
    }

    public void xj(View view, boolean z) {
    }

    public void u(boolean z) {
        this.q = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.en;
            if (xjVar != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
            }
            com.bytedance.sdk.openadsdk.core.hf.xj xjVar2 = this.l;
            if (xjVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar3 = this.en;
        if (xjVar3 != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar3.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.en.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
        }
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar4 = this.l;
        if (xjVar4 != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar4.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).w(true);
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.l.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(true);
        }
    }

    public void xj(ViewGroup viewGroup) {
    }

    public void kd(boolean z) {
        this.qd = z;
    }

    public void w(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.xj.getParent() == null) {
            viewGroup.addView(this.xj);
        }
        u(0);
    }

    public void xj(String str) {
    }

    public void c() {
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.et)) {
            ht();
        } else {
            wo();
        }
        ImageView imageView = this.w;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        r.xj((View) this.w, 8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void xj(Object obj, WeakReference weakReference, boolean z) {
        xj((ws) obj, (WeakReference<Context>) weakReference, z);
    }

    private void hf(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387888);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387688);
        if (l()) {
            r.xj((View) relativeLayout, 0);
            r.xj((View) relativeLayout2, 8);
            this.eu = relativeLayout;
        } else {
            r.xj((View) relativeLayout2, 0);
            r.xj((View) relativeLayout, 8);
            this.eu = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.eu;
        if (relativeLayout3 == null) {
            return;
        }
        this.tj = (RoundImageView) relativeLayout3.findViewById(2114387831);
        this.n = (TextView) this.eu.findViewById(2114387742);
        this.yy = (RelativeLayout) this.eu.findViewById(2114387693);
    }

    private void xj(com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        ws wsVar;
        if (xjVar == null || (wsVar = this.et) == null || !com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(A2egSU.BI9f7h("click_live_element", "click_live_feed"));
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.hf
    public View w() {
        return this.xj;
    }

    public void u(int i) {
        this.ra = i;
        r.xj(this.xj, i);
    }

    public void xj(NativeVideoTsView.xj xjVar) {
        this.ws = xjVar;
    }

    public void xj(g gVar) {
        xj(gVar, this.en);
        xj(gVar, this.l);
    }

    private void xj(g gVar, com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        jk u;
        if (xjVar == null) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(gVar);
        com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w.w) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class);
        if ((gVar instanceof com.bytedance.sdk.openadsdk.core.dk.u) && (u = ((com.bytedance.sdk.openadsdk.core.dk.u) gVar).u()) != null) {
            u.xj(wVar);
        }
    }

    private void hf(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.zg) == null || tTViewStub.getParent() == null || this.wo != null) {
            return;
        }
        this.zg.xj();
        this.wo = view.findViewById(2114387674);
        this.r = (TextView) view.findViewById(2114387868);
        this.b = (TextView) view.findViewById(2114387842);
    }

    public y(Context context, View view, boolean z, EnumSet<hf.xj> enumSet, ws wsVar, com.bykv.vk.openvk.component.video.api.u.w wVar, com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        this(context, view, z, enumSet, wsVar, wVar, true, xjVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.bytedance.sdk.openadsdk.upie.video.lottie.TTLottieVideoContainer] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView] */
    public void xj(Context context, View view, ws wsVar) {
        SSRenderTextureView sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.bytedance.sdk.openadsdk.kd.xj.hf(wsVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.f10450io);
        } else if (com.bytedance.sdk.openadsdk.kd.xj.w(wsVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.bytedance.sdk.openadsdk.kd.xj.d(wsVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.f10450io);
        }
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, A2egSU.ASJ6gh(-2, -2, 13));
            if (a()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
            }
        }
        r.xj((View) sSRenderTextureView, 8);
        this.hf = sSRenderTextureView;
        this.w = (ImageView) view.findViewById(2114387626);
        this.qt = (TTProgressBar) view.findViewById(2114387653);
        this.u = view.findViewById(2114387900);
        this.kd = view.findViewById(2114387631);
        this.y = (ImageView) view.findViewById(2114387651);
        this.c = (TTViewStub) view.findViewById(2114387744);
        this.hl = (TTViewStub) view.findViewById(2114387666);
        this.zg = (TTViewStub) view.findViewById(2114387828);
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            hf(context, view);
        }
        System.currentTimeMillis();
    }

    public void hf(boolean z, boolean z2) {
        ImageView imageView = this.w;
        if (imageView != null) {
            if (z) {
                com.bytedance.sdk.component.utils.jk.xj(this.f10450io, "tt_play_movebar_textpage", imageView);
            } else {
                com.bytedance.sdk.component.utils.jk.xj(this.f10450io, "tt_stop_movebar_textpage", imageView);
            }
        }
    }

    public void hf(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.xj;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.xj.setLayoutParams(layoutParams);
    }

    public void hf(int i) {
        pl.xj("Progress", "setSeekProgress-percent=".concat(String.valueOf(i)));
        r.xj((View) this.qt, 0);
        TTProgressBar tTProgressBar = this.qt;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.hf
    public void hf() {
        if (a()) {
            r.xj(this.u, 8);
            r.xj(this.kd, 8);
            r.xj((View) this.y, 8);
            r.xj((View) this.w, 8);
            return;
        }
        r.xj((View) this.eu, 8);
        r.kd(this.u);
        r.kd(this.kd);
        ImageView imageView = this.y;
        if (imageView != null) {
            r.kd(imageView);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xj
    public void hf(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.hf.getHolder()) {
            return;
        }
        this.ht = false;
        if (pz()) {
            this.ai.hf(this, surfaceHolder);
        }
    }

    public void xj(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.hl) == null || tTViewStub.getParent() == null || this.vm != null) {
            return;
        }
        this.vm = this.hl.xj();
        this.dc = (RelativeLayout) view.findViewById(2114387953);
        this.wn = (RoundImageView) view.findViewById(2114387958);
        this.aq = (TextView) view.findViewById(2114387926);
        this.tu = (TextView) view.findViewById(2114387877);
    }

    public void xj(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.c) == null || tTViewStub.getParent() == null || this.f != null) {
            return;
        }
        this.f = this.c.xj();
        this.c.setVisibility(0);
        this.d = (ImageView) view.findViewById(2114387804);
        this.tf = view.findViewById(2114387961);
        this.p = (RoundImageView) view.findViewById(2114387664);
        this.f10451pl = (TextView) view.findViewById(2114387957);
        this.g = (TextView) view.findViewById(2114387764);
        this.am = (TextView) view.findViewById(2114387686);
    }

    public boolean xj(int i, com.bykv.vk.openvk.component.video.api.w.w wVar, boolean z) {
        qt qtVar = this.x;
        return qtVar == null || qtVar.xj(i, wVar, z);
    }

    public void xj(com.bykv.vk.openvk.component.video.api.u.xj xjVar) {
        if (xjVar instanceof hf) {
            this.ai = (hf) xjVar;
            v();
        }
    }

    public void xj(int i, int i2) {
        if (i == -1) {
            i = r.u(this.f10450io);
        }
        if (i <= 0) {
            return;
        }
        this.e = i;
        if (!p() && !tf() && !this.dk.contains(hf.xj.fixedSize)) {
            this.yo = c(i);
        } else {
            this.yo = i2;
        }
        hf(this.e, this.yo);
    }

    public void xj() {
        xj(false, this.pz);
        et();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.hf
    public void xj(boolean z) {
        this.f10449a = z;
    }

    public void xj(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.kd.xj.xj(this.et) || com.bytedance.sdk.openadsdk.kd.xj.c(this.et)) {
            return;
        }
        com.bytedance.sdk.openadsdk.f.hf.xj(str).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.12
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg<Bitmap> zgVar) {
                Bitmap result;
                if (zgVar == null || (result = zgVar.getResult()) == null) {
                    return;
                }
                final Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(y.this.f10450io, result, 25);
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xj != null) {
                            imageView.setBackground(new BitmapDrawable(xj));
                        }
                    }
                });
            }
        }, 4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void xj(ws wsVar, WeakReference<Context> weakReference, boolean z) {
        String str;
        ws wsVar2;
        if (wsVar == null || a()) {
            return;
        }
        xj(false, this.pz);
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            xj(pz.getContext(), this.xj);
            yo();
            return;
        }
        xj(this.xj, pz.getContext());
        View view = this.f;
        if (view != null) {
            r.xj(view, 0);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            r.xj((View) imageView, 0);
        }
        if (com.bytedance.sdk.openadsdk.core.a.wo.w(this.et)) {
            hf(this.xj, pz.getContext());
            r.xj(this.tf, 8);
            r.xj((View) this.d, 0);
            r.xj(this.wo, 0);
            r.xj((View) this.r, 0);
            r.xj((View) this.b, 0);
            if (this.b != null && com.bytedance.sdk.component.utils.am.w(pz.getContext()) == 0) {
                r.xj((View) this.b, 8);
            }
            View view2 = this.f;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        com.bykv.vk.openvk.component.video.api.u.w wVar = y.this.j;
                        if (wVar != null) {
                            ((com.bykv.vk.openvk.component.video.api.u.xj) wVar).xj();
                            com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar = y.this.ff;
                            if (xjVar != null) {
                                xjVar.xj();
                            }
                        }
                    }
                });
            }
            if (this.d != null && !TextUtils.isEmpty(h.hf(this.et))) {
                if (com.bytedance.sdk.openadsdk.kd.xj.hf(wsVar)) {
                    com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.et)).to(this.d);
                    xj(this.d, h.hf(this.et));
                } else {
                    com.bykv.vk.openvk.component.video.xj.kd.hf.xj(2147483647L, h.xj(this.et), new hf.InterfaceC0019hf() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.3
                        @Override // com.bykv.vk.openvk.component.video.xj.kd.hf.InterfaceC0019hf
                        public void xj(Bitmap bitmap) {
                            if (bitmap == null) {
                                com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(y.this.et)).to(y.this.d);
                                return;
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) y.this.d.getLayoutParams();
                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                float u = (r.u(pz.getContext()) * bitmap.getHeight()) / bitmap.getWidth();
                                layoutParams.width = r.u(pz.getContext());
                                layoutParams.height = (int) u;
                                layoutParams.addRule(13);
                                y.this.d.setLayoutParams(layoutParams);
                            }
                            y.this.d.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        } else {
            r.xj(this.tf, 0);
            if (this.d != null && !TextUtils.isEmpty(h.hf(this.et))) {
                com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.et)).to(this.d);
                xj(this.d, h.hf(this.et));
            }
            if (b()) {
                this.tf.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.y.4
                    @Override // java.lang.Runnable
                    public void run() {
                        y.this.r();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(wsVar.ci())) {
            str = wsVar.ci();
        } else if (!TextUtils.isEmpty(wsVar.kr())) {
            str = wsVar.kr();
        } else if (!TextUtils.isEmpty(wsVar.uj())) {
            str = wsVar.uj();
        } else {
            str = "";
        }
        if (this.p != null && (wsVar2 = this.et) != null && wsVar2.uf() != null && this.et.uf().xj() != null) {
            r.xj((View) this.p, 0);
            r.xj((View) this.f10451pl, 4);
            com.bytedance.sdk.openadsdk.f.hf.xj(this.et.uf()).to(this.p);
            if (j()) {
                this.p.setOnClickListener(this.l);
                this.p.setOnTouchListener(this.l);
            } else {
                this.p.setOnClickListener(this.en);
                this.p.setOnTouchListener(this.en);
            }
        } else if (!TextUtils.isEmpty(str)) {
            r.xj((View) this.p, 4);
            r.xj((View) this.f10451pl, 0);
            TextView textView = this.f10451pl;
            if (textView != null) {
                textView.setText(str.substring(0, 1));
                if (j()) {
                    this.f10451pl.setOnClickListener(this.l);
                    this.f10451pl.setOnTouchListener(this.l);
                } else {
                    this.f10451pl.setOnClickListener(this.en);
                    this.f10451pl.setOnTouchListener(this.en);
                }
            }
        }
        if (this.g != null && !TextUtils.isEmpty(str)) {
            this.g.setText(str);
        }
        r.xj((View) this.g, 0);
        r.xj((View) this.am, 0);
        String bh = wsVar.bh();
        if (TextUtils.isEmpty(bh)) {
            int vw = wsVar.vw();
            if (vw == 4) {
                bh = "立即下载";
            } else if (vw != 5) {
                bh = "查看详情";
            } else {
                bh = "立即拨打";
            }
        }
        TextView textView2 = this.am;
        if (textView2 != null) {
            textView2.setText(bh);
            this.am.setOnClickListener(this.en);
            this.am.setOnTouchListener(this.en);
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setText(bh);
            this.r.setOnClickListener(this.en);
            this.r.setOnTouchListener(this.en);
        }
        if (this.f10449a) {
            return;
        }
        f(4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xj
    public void xj(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.hf.getHolder()) {
            return;
        }
        this.ht = true;
        if (pz()) {
            this.ai.xj(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xj
    public void xj(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder != this.hf.getHolder()) {
            return;
        }
        pz();
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xj
    public void xj(SurfaceTexture surfaceTexture, int i, int i2) {
        this.ht = true;
        if (pz()) {
            this.ai.xj(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xj
    public boolean xj(SurfaceTexture surfaceTexture) {
        this.ht = false;
        if (!pz()) {
            return true;
        }
        this.ai.hf(this, surfaceTexture);
        return true;
    }

    public void xj(boolean z, boolean z2, boolean z3) {
        r.xj((View) this.qt, 0);
        r.xj((View) this.w, (z && (r.u(this.u) && r.u(this.eu))) ? 0 : 8);
    }

    public void xj(boolean z, boolean z2) {
        r.xj((View) this.qt, z ? 0 : 8);
        r.xj((View) this.w, 8);
    }

    public void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
        this.ff = xjVar;
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar2 = this.en;
        if (xjVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(xjVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.hf
    public void xj(Drawable drawable) {
        View view = this.xj;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.hf
    public void xj(int i) {
        r.xj((View) this.yy, i);
    }

    public void xj(xj.InterfaceC0173xj interfaceC0173xj) {
        this.lw = interfaceC0173xj;
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.z;
        if (wVar != null) {
            wVar.xj(interfaceC0173xj);
        }
    }
}
