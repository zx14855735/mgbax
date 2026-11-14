package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.adexpress.hf.tf;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.p.xj.hf;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.hf.u;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.ra.dq;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.ugeno.express.hf;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NativeExpressView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.u, com.bytedance.sdk.component.adexpress.hf.f, com.bytedance.sdk.component.adexpress.hf.qt, com.bytedance.sdk.component.adexpress.theme.xj, tf {
    public static int v = 500;

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f10376a;
    private com.bytedance.sdk.openadsdk.y.xj ai;
    protected FrameLayout am;
    private com.bytedance.sdk.component.adexpress.hf.d aq;
    private ThemeStatusBroadcastReceiver b;
    private jk bl;
    protected String c;
    private View cy;
    protected ws d;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.kd dc;
    private final AtomicBoolean dk;
    private qt dq;
    protected com.bytedance.sdk.component.adexpress.hf.w e;
    private FrameLayout en;
    private String et;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.y eu;
    protected com.bytedance.sdk.openadsdk.zg.w.w.hf f;
    private final ViewTreeObserver.OnScrollChangedListener ff;
    protected w.InterfaceC0013w g;
    private SparseArray<u.xj> gh;
    private long gj;
    private float gy;
    private int hf;
    private com.bytedance.sdk.component.adexpress.hf.hf hl;
    private com.bytedance.sdk.openadsdk.core.hf.xj ht;

    /* renamed from: io, reason: collision with root package name */
    private float f10377io;
    private com.bytedance.sdk.openadsdk.core.ugeno.tf.xj j;
    protected boolean jk;
    private xj kd;
    private FrameLayout l;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.w lw;
    private List<com.bytedance.sdk.component.adexpress.hf.tf> n;
    private float nb;
    private float op;
    protected ExpressVideoView p;

    /* renamed from: pl, reason: collision with root package name */
    protected w.u f10378pl;
    protected FrameLayout pz;
    private boolean q;
    private boolean qd;
    protected boolean qt;
    private final Runnable r;
    private com.bytedance.sdk.openadsdk.core.hf.hf ra;
    private com.bytedance.sdk.component.adexpress.hf.g s;
    private float ss;
    protected String tf;
    private tf.xj tj;
    private com.bytedance.sdk.component.adexpress.hf.u<? extends View> tu;
    private Dialog u;
    private com.bytedance.sdk.component.adexpress.hf.y vm;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xj w;
    private boolean wa;
    private volatile com.bytedance.sdk.component.adexpress.hf.am wn;
    private final Runnable wo;
    private dk ws;
    private float x;
    private boolean xj;
    protected final Context y;
    protected boolean yo;
    private com.bytedance.sdk.component.adexpress.hf.zg yy;
    private dq z;
    protected boolean zg;

    public NativeExpressView(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str) {
        super(context);
        this.xj = true;
        this.hf = 0;
        this.c = "embeded_ad";
        this.dk = new AtomicBoolean(false);
        this.et = null;
        this.zg = false;
        this.yo = false;
        this.jk = false;
        this.q = false;
        this.ff = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.f10376a);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.f10376a, 500L);
            }
        };
        this.f10376a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!l.hf(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.kd(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.kd(nativeExpressView.getVisibility());
                }
            }
        };
        this.wo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(0);
            }
        };
        this.r = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(8);
            }
        };
        this.gh = new SparseArray<>();
        this.op = -1.0f;
        this.gy = -1.0f;
        this.nb = -1.0f;
        this.ss = -1.0f;
        this.gj = 0L;
        this.c = str;
        this.y = context;
        this.d = wsVar;
        this.f = hfVar;
        pl();
    }

    private boolean a() {
        ws wsVar = this.d;
        return wsVar != null && wsVar.dq() == 1 && ws.hf(this.d);
    }

    private boolean ai() {
        if (TextUtils.equals(this.c, "rewarded_video") || TextUtils.equals(this.c, "fullscreen_interstitial_ad")) {
            return this.d.oz();
        }
        return true;
    }

    private void am() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.b = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.xj(this);
    }

    private void dk() {
        try {
            if (this.b == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            this.y.registerReceiver(this.b, intentFilter, wo.io(), null);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private void en() {
        if (qt()) {
            return;
        }
        dk();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v17, types: [com.bytedance.sdk.component.adexpress.hf.g$xj] */
    private void et() {
        hf.xj xjVar;
        List<z> lx;
        z zVar;
        boolean f = hl.f(this.d);
        JSONObject jSONObject = null;
        if (!qt()) {
            if (f) {
                jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.d, com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.f10377io, this.x, this.zg), com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.d), false, this.tf);
            } else if (!hl.tf(this.d)) {
                jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(this.f10377io, this.x, this.zg, this.d);
            } else if (hl.y(this.d) != null && !TextUtils.isEmpty(hl.y(this.d).d())) {
                jSONObject = com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(hl.y(this.d).d(), hl.y(this.d).tf(), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
            }
            if (hl.y(this.d) != null) {
                com.bytedance.sdk.openadsdk.core.u.xj().xj(hl.y(this.d).hf());
            }
            if (hl.c(this.d) != null) {
                com.bytedance.sdk.openadsdk.core.u.xj().xj(hl.c(this.d).xj());
            }
        }
        this.ai = q();
        if (qt()) {
            this.aq = new yo();
        } else {
            this.aq = new d(this.ai, this.c, this.d, this.et);
        }
        boolean ai = ai();
        if (hl.tf(this.d) || hl.pl(this.d) || com.bytedance.sdk.openadsdk.core.ugeno.xj.xj.hf(this.d) || io()) {
            hf.xj xjVar2 = new hf.xj();
            xjVar2.kd(com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(this.d, (View) this, false));
            xjVar2.xj((com.bytedance.adsdk.ugeno.w.ht) this.aq);
            xjVar2.xj(this.f10377io);
            xjVar2.hf(this.x);
            xjVar2.u(io());
            xjVar = xjVar2;
        } else {
            xjVar = new g.xj();
        }
        xjVar.w(f);
        if (TextUtils.equals(this.c, "splash_ad")) {
            xjVar.y(com.bytedance.sdk.openadsdk.x.d.kd());
        }
        if (hl.hf(this.d) == 3 && com.bytedance.sdk.openadsdk.kd.xj.u(this.d) && (lx = this.d.lx()) != null && !lx.isEmpty() && (zVar = lx.get(0)) != null) {
            xjVar.d(zVar.xj());
            xjVar.xj(new UpieImageView(this.y, com.bytedance.sdk.openadsdk.kd.xj.d(this.d), com.bytedance.sdk.openadsdk.kd.xj.tf(this.d)));
        }
        this.s = xjVar.xj(this.c).hf(this.d.ho()).w(wo.zg(this.d)).u(this.d.jf()).xj(jSONObject).xj(this.aq).xj(com.bytedance.sdk.openadsdk.core.pz.hf().xj(this.c, hl.hf(this.d))).hf(ai).hf(this.d.bl()).w(this.d.vw()).kd(com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.u(this.d)).xj(com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.kd(this.d)).u(getRenderThread()).kd(this.d.ee()).y(this.d.pw()).c(this.d.ky()).hf(this.d.ki()).w(this.d.ya()).u(this.d.eg()).d(this.d.oa()).f(this.d.le()).c(this.d.nn()).f("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").xj(com.bytedance.sdk.openadsdk.core.f.zg().kd()).tf(this.d.kd()).xj();
    }

    private void ff() {
        Dialog dialog = this.u;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj();
        } else {
            TTDelegateActivity.xj(getContext(), this.d);
        }
    }

    private int getRenderThread() {
        if (x() || (com.bytedance.sdk.openadsdk.core.w.kd.xj().pl() & 2) == 2) {
            return 1;
        }
        return hl.u(this.d);
    }

    private boolean io() {
        com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar = this.f;
        return hfVar != null && ai.w >= 5900 && hfVar.io();
    }

    private void j() {
        NativeExpressView nativeExpressView;
        this.hf = hl.hf(this.d);
        if (z() && hl.xj(this.d) == 1) {
            this.hf = 1000;
        }
        com.bytedance.sdk.openadsdk.core.g.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.g.xj.xj(this.d, new WeakReference(this));
        int i = this.hf;
        if (i != 3) {
            if (i == 7) {
                com.bytedance.sdk.openadsdk.core.ugeno.express.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.u(this.y, this.d, (com.bytedance.sdk.openadsdk.core.ugeno.express.hf) this.s, this);
                this.q = uVar.d();
                com.bytedance.sdk.openadsdk.core.ugeno.express.kd kdVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.kd(this.y, uVar, this, this.s);
                this.dc = kdVar;
                this.n.add(kdVar);
            } else if (i == 10) {
                com.bytedance.sdk.openadsdk.core.ugeno.express.y yVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.y(this.y, this.d, (com.bytedance.sdk.openadsdk.core.ugeno.express.hf) this.s, this);
                this.eu = yVar;
                this.q = yVar.d();
                com.bytedance.sdk.openadsdk.core.ugeno.express.kd kdVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.express.kd(this.y, this.eu, this, this.s);
                this.dc = kdVar2;
                this.n.add(kdVar2);
            } else if (i != 1000) {
                dk dkVar = new dk(this.y, this.s, this.b, this.ai, this.d, this.aq);
                this.ws = dkVar;
                com.bytedance.sdk.component.adexpress.hf.zg zgVar = new com.bytedance.sdk.component.adexpress.hf.zg(this.y, this.s, dkVar, this);
                this.yy = zgVar;
                this.n.add(zgVar);
            }
            nativeExpressView = this;
        } else {
            nativeExpressView = this;
            com.bytedance.sdk.component.adexpress.hf.hf hfVar = new com.bytedance.sdk.component.adexpress.hf.hf(this.y, this.s, this.b, this.jk, new com.bytedance.sdk.component.adexpress.dynamic.u.c(), nativeExpressView, xjVar);
            nativeExpressView.hl = hfVar;
            nativeExpressView.n.add(hfVar);
            nativeExpressView.hl.xj(com.bytedance.sdk.openadsdk.core.pz.hf().qa());
        }
        int w = hl.w(nativeExpressView.d);
        if (w > 0 && io() && TextUtils.equals(nativeExpressView.c, "embeded_ad")) {
            nativeExpressView.n.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.kd(nativeExpressView.y, new com.bytedance.sdk.openadsdk.core.ugeno.xj.w(nativeExpressView.y, nativeExpressView.d, (com.bytedance.sdk.openadsdk.core.ugeno.express.hf) nativeExpressView.s, this), this, nativeExpressView.s));
        } else {
            boolean z = w == 1;
            nativeExpressView.xj = z;
            if (z || nativeExpressView.hf == 1000) {
                com.bytedance.sdk.component.adexpress.hf.y yVar2 = new com.bytedance.sdk.component.adexpress.hf.y(nativeExpressView.y, nativeExpressView.s, new e(this, nativeExpressView.b, nativeExpressView.s));
                nativeExpressView.vm = yVar2;
                nativeExpressView.n.add(yVar2);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.xj.xj.hf(nativeExpressView.d)) {
                nativeExpressView.n.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.kd(nativeExpressView.y, new com.bytedance.sdk.openadsdk.core.ugeno.xj.w(nativeExpressView.y, nativeExpressView.d, (com.bytedance.sdk.openadsdk.core.ugeno.express.hf) nativeExpressView.s, this), this, nativeExpressView.s));
            }
        }
        nativeExpressView.tj = new com.bytedance.sdk.component.adexpress.hf.pl(nativeExpressView.n, nativeExpressView.aq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.bytedance.sdk.openadsdk.y.xj xjVar = this.ai;
        if (xjVar instanceof com.bytedance.sdk.openadsdk.core.am.d) {
            ((com.bytedance.sdk.openadsdk.core.am.d) xjVar).hf(this.s.f());
        }
        this.ai.xj();
        this.tj.xj(this);
        this.tj.xj();
    }

    private com.bytedance.sdk.openadsdk.y.xj q() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.am.d dVar = new com.bytedance.sdk.openadsdk.core.am.d(this.c, this.d, jSONObject);
        dVar.xj(jSONObject, "webview_source", (Object) 1);
        return dVar;
    }

    private boolean qt() {
        return z() && hl.xj(this.d) == 1;
    }

    private void ra() {
        com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar;
        if (TextUtils.equals(this.c, "splash_ad") && (hfVar = this.f) != null && this.x == hfVar.c() && this.f10377io == this.f.y()) {
            this.x = r.u(this.y, this.x);
            int u = r.u(this.y);
            if (this.f10377io < u) {
                this.f10377io = r.u(this.y, r0);
            } else {
                this.f10377io = r.u(this.y, r1);
            }
        }
    }

    private boolean x() {
        return com.bytedance.sdk.openadsdk.core.pz.hf().d(wo.d(this.d)) == 4 && z();
    }

    private boolean z() {
        return TextUtils.equals(this.c, "splash_ad") || TextUtils.equals(this.c, "cache_splash_ad");
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.qt
    public void a_(final int i) {
        this.wa = true;
        if (!this.xj) {
            this.aq.p();
        }
        this.aq.pl();
        com.bytedance.sdk.component.adexpress.hf.d dVar = this.aq;
        if (dVar instanceof d) {
            ((d) dVar).am();
        }
        if (this.kd != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.kd.xj(this, com.bytedance.sdk.openadsdk.core.c.xj(i), i);
            } else {
                com.bytedance.sdk.openadsdk.core.v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.kd != null) {
                            NativeExpressView.this.kd.xj(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.c.xj(i), i);
                        }
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.xj
    public void b_(int i) {
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (uVar == null || !(uVar instanceof g)) {
            return;
        }
        ((g) uVar).b_(i);
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.w wVar = this.lw;
        if (wVar != null) {
            wVar.xj();
        }
    }

    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.ht;
        if (xjVar != null) {
            xjVar.w(motionEvent.getDeviceId());
            this.ht.hf(motionEvent.getSource());
            this.ht.u(motionEvent.getToolType(0));
        }
        com.bytedance.sdk.openadsdk.core.hf.hf hfVar = this.ra;
        if (hfVar != null) {
            hfVar.w(motionEvent.getDeviceId());
            this.ra.hf(motionEvent.getSource());
            this.ra.u(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.op = motionEvent.getRawX();
            this.gy = motionEvent.getRawY();
            this.gj = System.currentTimeMillis();
            i = 0;
        } else if (actionMasked == 1) {
            i = 3;
        } else if (actionMasked != 2) {
            i = actionMasked != 3 ? -1 : 4;
        } else {
            this.nb = Math.abs(motionEvent.getX() - this.op) + this.nb;
            this.ss = Math.abs(motionEvent.getY() - this.gy) + this.ss;
            this.op = motionEvent.getX();
            this.gy = motionEvent.getY();
            i = (System.currentTimeMillis() - this.gj <= 200 || (this.nb <= 8.0f && this.ss <= 8.0f)) ? 2 : 1;
        }
        SparseArray<u.xj> sparseArray = this.gh;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new u.xj(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        if (!com.bytedance.sdk.openadsdk.core.pz.hf().jq() || !this.wa) {
            if (com.bytedance.sdk.openadsdk.core.pz.hf().qa() && com.bytedance.sdk.openadsdk.x.c.xj()) {
                com.bytedance.sdk.component.utils.f.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeExpressView.this.l();
                    }
                });
                return;
            } else {
                l();
                return;
            }
        }
        if (this.kd != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.kd.xj(this, com.bytedance.sdk.openadsdk.core.c.xj(-16), -16);
            } else {
                com.bytedance.sdk.openadsdk.core.v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.kd != null) {
                            NativeExpressView.this.kd.xj(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.c.xj(-16), -16);
                        }
                    }
                });
            }
        }
    }

    public void f() {
        if (io() && TextUtils.equals(this.c, "embeded_ad")) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar = new com.bytedance.sdk.openadsdk.core.dislike.w.hf(this.d.ac(), com.bytedance.sdk.openadsdk.core.dislike.u.xj());
            hfVar.hf(PointCategory.DISLIKE);
            com.bytedance.sdk.openadsdk.core.dislike.xj.xj.xj().xj(this.y, hfVar, "close_success");
        }
    }

    public void g() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.bytedance.sdk.component.adexpress.hf.tf> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().xj();
            }
            this.w = null;
            this.u = null;
            this.f = null;
            this.d = null;
            this.ht = null;
            this.e = null;
            this.ra = null;
            this.f10378pl = null;
            this.g = null;
            this.kd = null;
            Context context = this.y;
            if (context != null && (themeStatusBroadcastReceiver = this.b) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.p;
            if (expressVideoView != null) {
                expressVideoView.v();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.w("NativeExpressView", "detach error", th);
        }
    }

    public long getActualPlayDuration() {
        return 0L;
    }

    public com.bytedance.sdk.openadsdk.core.hf.xj getClickCreativeListener() {
        return this.ht;
    }

    public com.bytedance.sdk.openadsdk.core.hf.hf getClickListener() {
        return this.ra;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (uVar != null) {
            return uVar.w();
        }
        return 0;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.l;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.x).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.f10377io).intValue();
    }

    public xj getExpressInteractionListener() {
        return this.kd;
    }

    public j getJsObject() {
        dk dkVar = this.ws;
        if (dkVar != null) {
            return dkVar.D_();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        y qt;
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (!(uVar instanceof dk) || (qt = ((dk) uVar).qt()) == null) {
            return 0;
        }
        return qt.xj();
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.express.y getUGenV3Render() {
        return this.eu;
    }

    public ViewGroup getVideoContainer() {
        return this.am;
    }

    public com.bykv.vk.openvk.component.video.api.u.w getVideoController() {
        return null;
    }

    public SSWebView getWebView() {
        dk dkVar = this.ws;
        if (dkVar == null) {
            return null;
        }
        return dkVar.xj();
    }

    public int hf() {
        return 0;
    }

    public void ht() {
        jk jkVar = this.bl;
        if (jkVar != null) {
            jkVar.u();
        }
    }

    public void jk() {
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (!(uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) || (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.y)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.ugeno.express.u) uVar).hf();
    }

    public void kd() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.component.utils.pl.u("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.ff);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.sdk.openadsdk.y.xj xjVar = this.ai;
            if (xjVar != null) {
                xjVar.hf(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.ff);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.pl.u("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.pl.u("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        qt qtVar;
        return (!io() || (qtVar = this.dq) == null) ? super.onInterceptTouchEvent(motionEvent) : qtVar.xj(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.pl.u("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        qt qtVar;
        return (!io() || (qtVar = this.dq) == null) ? super.onTouchEvent(motionEvent) : qtVar.hf(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.r);
        removeCallbacks(this.wo);
        if (i == 0) {
            postDelayed(this.wo, 50L);
        } else {
            postDelayed(this.r, 50L);
        }
    }

    public void p() {
    }

    public void pl() {
        this.pz = new FrameLayout(this.y);
        this.en = new FrameLayout(this.y);
        this.l = new FrameLayout(this.y);
        addView(this.pz);
        addView(this.en);
        addView(this.l);
        this.n = new ArrayList();
        com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar = this.f;
        if (hfVar != null) {
            this.f10377io = hfVar.f();
            this.x = this.f.d();
            ra();
            this.et = this.f.u();
        }
        if (!qt()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            am();
        }
        et();
        j();
        com.bytedance.sdk.component.adexpress.hf.zg zgVar = this.yy;
        if (zgVar != null) {
            this.ws = (dk) zgVar.hf();
        }
        if (io()) {
            this.dq = new qt(this);
        }
    }

    public boolean pz() {
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        return uVar != null && uVar.w() == 1;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.hf.w wVar) {
        this.e = wVar;
        com.bytedance.sdk.component.adexpress.hf.y yVar = this.vm;
        if (yVar != null) {
            yVar.xj(wVar);
        }
    }

    public void setClickCreativeListener(com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        this.ht = xjVar;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        this.ra = hfVar;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (uVar != null && (uVar instanceof e) && (backupView = (BackupView) uVar.c()) != null) {
            backupView.setDislikeInner(xjVar);
        }
        this.w = xjVar;
    }

    public void setDynamicSkipListener(com.bytedance.sdk.openadsdk.core.component.splash.countdown.w wVar) {
        this.lw = wVar;
    }

    public void setEasyPlayableSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c cVar) {
        ExpressVideoView expressVideoView = this.p;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(cVar);
    }

    public void setExpressInteractionListener(xj xjVar) {
        this.kd = xjVar;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (uVar != null && (uVar instanceof e) && (backupView = (BackupView) uVar.c()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.u = dialog;
    }

    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u
    public void setSoundMute(boolean z) {
        this.jk = z;
        com.bytedance.sdk.component.adexpress.hf.hf hfVar = this.hl;
        if (hfVar != null && hfVar.hf() != null) {
            this.hl.hf().setSoundMute(z);
        }
        if (this.tu.w() == 7) {
            com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
            if (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) {
                ((com.bytedance.sdk.component.adexpress.dynamic.u) uVar).setSoundMute(z);
            }
        }
    }

    public void setTimeUpdate(int i) {
    }

    public void setVideoAdInteractionListener(w.InterfaceC0013w interfaceC0013w) {
        this.g = interfaceC0013w;
    }

    public void setVideoAdListener(w.u uVar) {
        this.f10378pl = uVar;
    }

    public void tf() {
    }

    public void u() {
    }

    public void v() {
        try {
            FrameLayout frameLayout = this.am;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.am);
        } catch (Throwable unused) {
        }
    }

    public int w() {
        return 0;
    }

    public long xj() {
        return 0L;
    }

    public void y() {
    }

    public void yo() {
        dk dkVar = this.ws;
        if (dkVar == null || dkVar.c() == null) {
            return;
        }
        this.ws.kd();
    }

    public void zg() {
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (uVar instanceof g) {
            ((g) uVar).f();
        }
        en();
    }

    public void hf(int i) {
    }

    public void kd(int i) {
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (uVar == null || !(uVar instanceof g)) {
            return;
        }
        ((g) uVar).hf(i);
    }

    public void w(int i) {
    }

    public void xj(float f) {
    }

    public void y(int i) {
        this.s.xj(i);
    }

    public void xj(float f, float f2, float f3, float f4, int i) {
    }

    private void hf(View view, com.bytedance.sdk.openadsdk.core.ra.ra raVar, com.bytedance.sdk.openadsdk.core.ra.tf tfVar, int i, String str, int i2) {
        if (ws.kd(this.d)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hf.hf hfVar = this.ra;
        if (hfVar != null) {
            hfVar.xj(raVar);
            com.bytedance.sdk.openadsdk.core.hf.xj.w.xj xjVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.ra.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class);
            xj(xjVar);
            xjVar.hf(str);
            this.ra.xj(tfVar);
            Map<String, Object> xj = com.bytedance.sdk.component.p.kd.xj.xj().xj(this.d.hashCode() + this.d.zf());
            xj.put("convert_tag", raVar.e);
            xj(raVar, xj);
            this.ra.xj(view, tfVar);
        }
        xj xjVar2 = this.kd;
        if (xjVar2 != null) {
            xjVar2.xj(this, i2);
        }
    }

    private void w(ws wsVar, Context context, String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.xj(context, wsVar, str);
    }

    public void xj(int i) {
    }

    public void xj(int i, String str) {
    }

    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, dq dqVar) {
        this.z = dqVar;
        xj(view, i, wVar);
        this.z = null;
    }

    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
        com.bytedance.sdk.openadsdk.core.ra.tf tfVar;
        com.bytedance.sdk.openadsdk.core.hf.xj.w.xj xjVar;
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar2;
        com.bytedance.sdk.openadsdk.core.hf.hf hfVar;
        if (i == -1 || wVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ra.ra raVar = (com.bytedance.sdk.openadsdk.core.ra.ra) wVar;
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar3 = this.ht;
        if (xjVar3 != null) {
            xjVar3.kd(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.hf.hf hfVar2 = this.ra;
        if (hfVar2 != null) {
            hfVar2.kd(getDynamicShowType());
        }
        if (i != 1 || (hfVar = this.ra) == null) {
            tfVar = null;
            xjVar = null;
        } else {
            tfVar = hfVar.hf();
            xjVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.ra.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class);
            xjVar.xj(xjVar.kd());
        }
        if (i == 2 && (xjVar2 = this.ht) != null) {
            tfVar = xjVar2.hf();
            xjVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.ht.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class);
            xjVar.xj(xjVar.kd());
        }
        try {
            Object obj = raVar.xj().get("click_extra_map");
            if (xjVar != null && (obj instanceof Map)) {
                xjVar.xj((Map<String, Object>) obj);
            }
        } catch (JSONException unused) {
        }
        if (tfVar == null) {
            tfVar = new com.bytedance.sdk.openadsdk.core.ra.tf();
        }
        com.bytedance.sdk.openadsdk.core.ra.tf tfVar2 = tfVar;
        if (this.z != null) {
            tfVar2.hf(this);
        }
        tfVar2.xj(raVar.xj);
        tfVar2.hf(raVar.hf);
        tfVar2.w(raVar.w);
        tfVar2.u(raVar.u);
        tfVar2.xj(raVar.qt);
        tfVar2.c(raVar.yo);
        tfVar2.xj(com.bytedance.sdk.openadsdk.core.ra.ht.u(this.d, raVar.e));
        tfVar2.hf(raVar.e);
        SparseArray<u.xj> sparseArray = raVar.zg;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.gh;
        }
        tfVar2.xj(sparseArray);
        JSONObject xj = raVar.xj();
        tfVar2.w(xj.optBoolean("is_compliant_download"));
        String optString = xj.optString("uchain_event_name");
        tfVar2.w(optString);
        int optInt = xj.optInt("convertActionType", Integer.MIN_VALUE);
        if (optInt == 1) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar4 = this.ht;
                if (xjVar4 != null) {
                    xjVar4.w();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.hf.hf hfVar3 = this.ra;
                if (hfVar3 != null) {
                    hfVar3.w();
                }
            }
        } else if (optInt == 2) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar5 = this.ht;
                if (xjVar5 != null) {
                    xjVar5.u();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.hf.hf hfVar4 = this.ra;
                if (hfVar4 != null) {
                    hfVar4.u();
                }
            }
        }
        View view2 = view == null ? this : view;
        String str = raVar.p;
        ws wsVar = this.d;
        int vw = wsVar != null ? wsVar.vw() : 0;
        switch (i) {
            case 1:
                View view3 = view2;
                int i2 = vw;
                FrameLayout frameLayout = this.am;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                hf(view3, raVar, tfVar2, 0, str, i2);
                break;
            case 2:
                xj(view2, raVar, tfVar2, 0, str, vw);
                break;
            case 3:
                ff();
                break;
            case 4:
                FrameLayout frameLayout2 = this.am;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                wo.pz(this.d);
                if ("embeded_ad".equals(this.c) && a() && !this.qt && wo.pz(this.d)) {
                    xj(view2, raVar, tfVar2, 0, str, vw);
                    break;
                } else {
                    hf(view2, raVar, tfVar2, 0, str, vw);
                    break;
                }
                break;
            case 5:
                xj(!this.jk);
                break;
            case 6:
                c();
                break;
            case 7:
                if (!xj(optString)) {
                    com.bytedance.sdk.openadsdk.core.a.y.xj(this.y, this.d);
                    break;
                }
                break;
            case 8:
                f();
                break;
            case 9:
                hf(this.d, this.y, this.c);
                break;
            case 10:
                xj(this.d, this.y, this.c);
                break;
            case 12:
                w(this.d, this.y, this.c);
                break;
            case 13:
                String optString2 = xj.optString("openCommonWebUrl", "");
                String optString3 = xj.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(optString2)) {
                    TTDelegateActivity.u(this.y, optString2, optString3);
                    break;
                }
                break;
        }
    }

    private void hf(View view, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar, com.bytedance.sdk.openadsdk.core.ra.tf tfVar, int i2) {
        if (ws.kd(this.d)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.ht;
        if (xjVar != null) {
            xj(((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(), i);
            this.ht.xj(raVar);
            this.ht.xj(tfVar);
            this.ht.xj(view, tfVar);
        }
        xj xjVar2 = this.kd;
        if (xjVar2 != null) {
            xjVar2.xj(this, i2);
        }
    }

    public NativeExpressView(boolean z, Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, boolean z2) {
        super(context);
        this.xj = true;
        this.hf = 0;
        this.c = "embeded_ad";
        this.dk = new AtomicBoolean(false);
        this.et = null;
        this.zg = false;
        this.yo = false;
        this.jk = false;
        this.q = false;
        this.ff = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.f10376a);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.f10376a, 500L);
            }
        };
        this.f10376a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!l.hf(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.kd(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.kd(nativeExpressView.getVisibility());
                }
            }
        };
        this.wo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(0);
            }
        };
        this.r = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(8);
            }
        };
        this.gh = new SparseArray<>();
        this.op = -1.0f;
        this.gy = -1.0f;
        this.nb = -1.0f;
        this.ss = -1.0f;
        this.gj = 0L;
        this.c = str;
        this.y = context;
        this.d = wsVar;
        this.f = hfVar;
        this.zg = z;
        this.jk = z2;
        pl();
    }

    public void hf(com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar, com.bytedance.sdk.component.adexpress.hf.am amVar) {
        try {
            this.tu = uVar;
            this.wn = amVar;
            if (uVar.w() != 1) {
                View c = uVar.c();
                this.cy = c;
                if (c.getParent() != null) {
                    ((ViewGroup) this.cy.getParent()).removeView(this.cy);
                }
                this.en.addView(this.cy);
                ViewGroup.LayoutParams layoutParams = this.cy.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                if (this.bl != null && (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) && !(uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.y)) {
                    this.bl.xj(((com.bytedance.sdk.openadsdk.core.ugeno.express.u) uVar).f());
                    this.bl.xj(this);
                }
            }
            com.bytedance.sdk.component.adexpress.hf.d dVar = this.aq;
            if (dVar instanceof d) {
                ((d) dVar).am();
            }
            if (this.ai != null && uVar.w() != 0) {
                this.ai.xj(uVar.w(), amVar.p(), amVar.tf());
            }
            com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar2 = this.tu;
            if ((uVar2 instanceof am) && ((am) uVar2).D_() != null) {
                ((am) this.tu).D_().xj((tf) this);
            }
            if (amVar.hf() == 10 && (amVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.w)) {
                this.j = ((com.bytedance.sdk.openadsdk.core.ugeno.express.w) amVar).yo();
            }
            xj xjVar = this.kd;
            if (xjVar != null) {
                xjVar.xj(this, (float) amVar.u(), (float) amVar.kd());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public NativeExpressView(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, boolean z) {
        super(context);
        this.xj = true;
        this.hf = 0;
        this.c = "embeded_ad";
        this.dk = new AtomicBoolean(false);
        this.et = null;
        this.zg = false;
        this.yo = false;
        this.jk = false;
        this.q = false;
        this.ff = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.f10376a);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.f10376a, 500L);
            }
        };
        this.f10376a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!l.hf(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.kd(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.kd(nativeExpressView.getVisibility());
                }
            }
        };
        this.wo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(0);
            }
        };
        this.r = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(8);
            }
        };
        this.gh = new SparseArray<>();
        this.op = -1.0f;
        this.gy = -1.0f;
        this.nb = -1.0f;
        this.ss = -1.0f;
        this.gj = 0L;
        this.c = str;
        this.y = context;
        this.d = wsVar;
        this.f = hfVar;
        this.jk = z;
        if (hfVar.jk() == 9) {
            this.zg = hfVar.qt() == 2;
        }
        pl();
    }

    private void hf(ws wsVar, Context context, String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.hf(wsVar, context, str);
    }

    public void hf(int i, String str) {
        j D_;
        com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
        if (uVar == null || !(uVar instanceof dk) || (D_ = ((dk) uVar).D_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            D_.xj("onVideoPaused", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public void hf(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar = this.j;
        if (xjVar != null) {
            xjVar.xj(i, i2);
        }
    }

    private void xj(View view, com.bytedance.sdk.openadsdk.core.ra.ra raVar, com.bytedance.sdk.openadsdk.core.ra.tf tfVar, int i, String str, int i2) {
        if (ws.kd(this.d)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.ht;
        if (xjVar != null) {
            xjVar.xj(raVar);
            com.bytedance.sdk.openadsdk.core.hf.xj.w.xj xjVar2 = (com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.ht.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class);
            xj(xjVar2);
            xjVar2.hf(str);
            this.ht.xj(tfVar);
            Map<String, Object> xj = com.bytedance.sdk.component.p.kd.xj.xj().xj(this.d.hashCode() + this.d.zf());
            xj.put("convert_tag", raVar.e);
            xj(raVar, xj);
            this.ht.xj(view, tfVar);
        }
        xj xjVar3 = this.kd;
        if (xjVar3 != null) {
            xjVar3.xj(this, i2);
        }
    }

    public NativeExpressView(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, boolean z, String str2) {
        super(context);
        this.xj = true;
        this.hf = 0;
        this.c = "embeded_ad";
        this.dk = new AtomicBoolean(false);
        this.et = null;
        this.zg = false;
        this.yo = false;
        this.jk = false;
        this.q = false;
        this.ff = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.f10376a);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.f10376a, 500L);
            }
        };
        this.f10376a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!l.hf(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.kd(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.kd(nativeExpressView.getVisibility());
                }
            }
        };
        this.wo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(0);
            }
        };
        this.r = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.kd(8);
            }
        };
        this.gh = new SparseArray<>();
        this.op = -1.0f;
        this.gy = -1.0f;
        this.nb = -1.0f;
        this.ss = -1.0f;
        this.gj = 0L;
        this.c = str;
        this.y = context;
        this.d = wsVar;
        this.tf = str2;
        this.f = hfVar;
        this.jk = z;
        if (hfVar.jk() == 9) {
            this.zg = hfVar.qt() == 2;
        }
        pl();
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ra.ra raVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(raVar.xj().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception unused) {
        }
    }

    private void xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj xjVar) {
        dq dqVar = this.z;
        if (dqVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("custom_express_gesture", 1);
            hashMap.put("express_gesture_type", Integer.valueOf(dqVar.hf()));
            hashMap.put("express_slide_direction", Integer.valueOf(dqVar.u()));
            hashMap.put("express_slide_threshold", Double.valueOf(dqVar.w()));
            xjVar.xj(hashMap);
        }
    }

    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
        if (i == -1 || wVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ra.ra raVar = (com.bytedance.sdk.openadsdk.core.ra.ra) wVar;
        com.bytedance.sdk.openadsdk.core.ra.tf tfVar = new com.bytedance.sdk.openadsdk.core.ra.tf();
        tfVar.xj(raVar.zg);
        tfVar.xj(raVar.xj);
        tfVar.hf(raVar.hf);
        tfVar.w(raVar.w);
        tfVar.u(raVar.u);
        tfVar.xj(raVar.qt);
        JSONObject xj = raVar.xj();
        int optInt = xj.optInt("convertActionType", Integer.MIN_VALUE);
        tfVar.w(xj.optBoolean("is_compliant_download"));
        if (optInt == 1) {
            if (i == 2) {
                this.ht.w();
            } else {
                this.ra.w();
            }
        } else if (optInt == 2) {
            if (i == 2) {
                this.ht.u();
            } else {
                this.ra.u();
            }
        }
        View view2 = view == null ? this : view;
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.ht;
        if (xjVar != null) {
            xjVar.kd(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.hf.hf hfVar = this.ra;
        if (hfVar != null) {
            hfVar.kd(getDynamicShowType());
        }
        ws wsVar = this.d;
        int vw = wsVar != null ? wsVar.vw() : 0;
        switch (i) {
            case 1:
                View view3 = view2;
                int i3 = vw;
                FrameLayout frameLayout = this.am;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                xj(view3, i2, raVar, tfVar, i3);
                break;
            case 2:
                hf(view2, i2, raVar, tfVar, vw);
                break;
            case 3:
                ff();
                break;
            case 4:
                FrameLayout frameLayout2 = this.am;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                wo.pz(this.d);
                if ("embeded_ad".equals(this.c) && a() && !this.qt && wo.pz(this.d)) {
                    hf(view2, i2, raVar, tfVar, vw);
                    break;
                } else {
                    xj(view2, i2, raVar, tfVar, vw);
                    break;
                }
                break;
            case 5:
                xj(!this.jk);
                break;
            case 6:
                c();
                break;
            case 8:
                f();
                break;
        }
    }

    private boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        wo.x();
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.d);
        hashMap.put("context", this.y);
        new hf.xj(str).xj(this.d.ac()).xj(hashMap).xj().xj();
        return true;
    }

    private void xj(View view, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar, com.bytedance.sdk.openadsdk.core.ra.tf tfVar, int i2) {
        if (ws.kd(this.d)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hf.hf hfVar = this.ra;
        if (hfVar != null) {
            xj(((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(), i);
            this.ra.xj(raVar);
            this.ra.xj(tfVar);
            this.ra.xj(view, tfVar);
        }
        xj xjVar = this.kd;
        if (xjVar != null) {
            xjVar.xj(this, i2);
        }
    }

    private void xj(com.bytedance.sdk.openadsdk.core.pl.hf.w wVar, int i) {
        if (wVar != null && (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd)) {
            com.bytedance.sdk.openadsdk.core.pl.w.w.w f = ((com.bytedance.sdk.openadsdk.core.pl.w.kd) wVar).f();
            f.hf(true);
            f.xj(i);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.qt
    public void xj(final com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar, final com.bytedance.sdk.component.adexpress.hf.am amVar) {
        this.wa = true;
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.hf(uVar, amVar);
            }
        });
    }

    public void xj(MotionEvent motionEvent) {
        View view = this.cy;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.u
    public void xj(CharSequence charSequence, int i, int i2, boolean z) {
        xj(Integer.parseInt(String.valueOf(charSequence)), i, z);
    }

    public void xj(int i, int i2, boolean z) {
        int kd;
        if (TextUtils.equals(this.c, "fullscreen_interstitial_ad")) {
            kd = (!x.xj(this.d) || x.hf(this.d) <= 0) ? com.bytedance.sdk.openadsdk.core.pz.hf().y(Integer.parseInt(this.et)) : 0;
        } else if (!TextUtils.equals(this.c, "rewarded_video")) {
            return;
        } else {
            kd = com.bytedance.sdk.openadsdk.core.pz.hf().kd(Integer.parseInt(this.et));
        }
        int i3 = (i2 >= kd || z) ? 1 : 0;
        int i4 = i2 <= kd ? kd - i2 : 0;
        com.bytedance.sdk.component.adexpress.hf.hf hfVar = this.hl;
        if (hfVar != null && hfVar.hf() != null) {
            this.hl.hf().xj(String.valueOf(i), i3, i4, z);
        }
        if (this.tu.w() == 7 || this.tu.w() == 10) {
            com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
            if (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) {
                ((com.bytedance.sdk.component.adexpress.dynamic.u) uVar).xj(String.valueOf(i), i3, i4, z);
            }
        }
    }

    private void xj(ws wsVar, Context context, String str) {
        if (wsVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.y.w(wsVar, context, str);
    }

    public void xj(boolean z) {
        if (this.tu.w() == 7) {
            com.bytedance.sdk.component.adexpress.hf.u<? extends View> uVar = this.tu;
            if (uVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.u) {
                ((com.bytedance.sdk.component.adexpress.dynamic.u) uVar).setSoundMute(z);
            }
        }
    }

    public void xj(JSONObject jSONObject) {
        boolean g = com.bytedance.sdk.openadsdk.core.pz.hf().g();
        this.qd = g;
        if (g && wo.u(this.d)) {
            this.bl = new jk(this.d, jSONObject, this);
        }
    }
}
