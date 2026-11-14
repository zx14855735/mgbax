package com.bytedance.sdk.openadsdk.core.component.splash.presentation;

import IzHBwY.AYUAbz;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.q;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.f;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y;
import com.bytedance.sdk.openadsdk.core.hf.xj.w.w;
import com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.pl.w.kd;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.bl;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.op;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.wa;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.u;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationSplashManagerDefault;
import com.bytedance.sdk.openadsdk.zg.w.xj.w;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.openadsdk.zg.w.hf.hf implements ai.xj, TsView.xj {
    protected com.bytedance.sdk.openadsdk.core.et.xj.hf ai;
    private Context b;
    private boolean bl;
    protected hf c;
    private com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf dq;
    protected y e;
    protected c et;
    private float eu;
    protected com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj f;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf gh;
    private com.bytedance.sdk.openadsdk.core.component.splash.xj.xj gy;
    protected ws hf;
    protected boolean ht;
    protected u j;
    protected com.bytedance.sdk.openadsdk.core.hf.xj kd;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<d, c> op;
    protected boolean pz;
    protected boolean q;
    private Activity qd;
    private float tj;
    protected SoftReference<w> u;
    protected com.bytedance.sdk.openadsdk.core.pl.hf.w w;
    private f wa;
    private boolean wn;
    private String ws;
    protected TsView xj;
    protected View.OnTouchListener y;
    protected com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f yo;
    protected AtomicBoolean d = new AtomicBoolean(false);
    protected final Map<String, Object> tf = new HashMap();
    private Double n = null;
    private boolean yy = false;
    private boolean hl = false;
    protected boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    protected int f10337pl = 3;
    protected int g = -1;
    private final ai vm = new ai(Looper.getMainLooper(), this);
    protected boolean am = false;
    protected boolean qt = false;
    protected long zg = 0;
    protected Map<String, Object> v = new HashMap();
    protected AtomicBoolean jk = new AtomicBoolean(false);
    protected boolean ra = true;
    protected boolean dk = false;
    private com.bytedance.sdk.openadsdk.core.component.splash.xj dc = new com.bytedance.sdk.openadsdk.core.component.splash.xj();
    private boolean aq = false;
    private long tu = 0;
    private long s = 5;

    /* renamed from: io, reason: collision with root package name */
    protected AtomicBoolean f10336io = new AtomicBoolean(false);
    protected AtomicBoolean x = new AtomicBoolean(false);
    protected AtomicBoolean z = new AtomicBoolean(false);
    private boolean lw = true;
    protected AtomicBoolean en = new AtomicBoolean(false);
    protected int l = -1;
    protected int ff = -1;

    /* renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f10335a = new AtomicBoolean(false);
    private final AtomicBoolean nb = new AtomicBoolean(false);
    protected final AtomicInteger wo = new AtomicInteger(0);
    protected com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf r = null;
    private boolean ss = false;
    private int gj = 0;

    public interface hf {
        void w_();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj$xj, reason: collision with other inner class name */
    public static class C0154xj implements xj.hf {
        ws xj;

        public C0154xj(ws wsVar) {
            this.xj = wsVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
        public void hf() {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, "splash_ad", "splash_enter_background", System.currentTimeMillis());
        }

        @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
        public void xj() {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, "splash_ad", "splash_enter_foreground", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk() {
        if (!this.wn) {
            this.ra = false;
            return;
        }
        if (this.aq) {
            return;
        }
        this.aq = true;
        com.bytedance.sdk.openadsdk.core.component.splash.xj xjVar = this.dc;
        if (xjVar != null) {
            xjVar.xj();
            this.dc = null;
        }
        u uVar = this.j;
        if (uVar != null) {
            uVar.tf();
        }
        this.f = null;
        this.w = null;
        this.qd = null;
    }

    private void e() {
        if (!this.q || this.xj == null) {
            return;
        }
        ws wsVar = this.hf;
        if (wsVar != null && wsVar.xf() != null && this.hf.xf().hf() == 0) {
            this.xj.setVideoViewVisibility(8);
        } else {
            this.xj.setVideoViewVisibility(0);
            this.xj.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    xj.this.xj.setVoiceViewImageDrawable(xj.this.lw ? jk.w(xj.this.b, "tt_splash_unmute") : jk.w(xj.this.b, "tt_splash_mute"));
                    xj.this.lw = !r2.lw;
                    xj xjVar = xj.this;
                    u uVar = xjVar.j;
                    if (uVar != null) {
                        uVar.hf(xjVar.lw);
                    }
                }
            });
        }
    }

    private boolean ht() {
        return (!bl.xj(this.hf) || this.am || this.qt || this.pz) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        TsView tsView = this.xj;
        if (tsView != null && tsView.getChildCount() > 0) {
            for (int i = 0; i < this.xj.getChildCount(); i++) {
                View childAt = this.xj.getChildAt(i);
                if (childAt != null && (childAt instanceof EmptyView)) {
                    this.xj.removeView(childAt);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pz() {
        TsView tsView = this.xj;
        if (tsView != null) {
            tsView.xj(this.hf.xv(), this.kd);
            if (hl.xj(this.hf) == 1) {
                pl();
            }
        }
    }

    private void ra() {
        this.bl = false;
        f fVar = new f();
        this.wa = fVar;
        fVar.xj(this.b, this.hf);
        if (this.dc.w() || !ht()) {
            return;
        }
        SoftReference<w> softReference = this.u;
        if (softReference == null) {
            this.wa.xj(this.ws, this.g, this.dc, null);
        } else {
            this.wa.xj(this.ws, this.g, this.dc, softReference.get());
        }
        this.ht = true;
        this.wa.xj(2);
        com.bytedance.sdk.openadsdk.core.component.splash.xj xjVar = this.dc;
        if (xjVar != null) {
            xjVar.xj(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.bytedance.sdk.openadsdk.core.f.zg().u().hf(new C0154xj(this.hf));
    }

    private void yo() {
        EmptyView emptyView = new EmptyView(this.b, this.xj, this.hf.cm());
        emptyView.xj(this.hf, this.ws);
        emptyView.setAdType(3);
        this.xj.addView(emptyView);
        emptyView.setCallback(new EmptyView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.4
            private volatile boolean hf = false;

            private void w() {
                boolean z = true;
                if (!this.hf) {
                    this.hf = true;
                    if (xj.this.hf.vw() == 4) {
                        com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("splash_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TsView tsView;
                                Context context;
                                xj xjVar = xj.this;
                                xjVar.kd(hl.xj(xjVar.hf) != 1);
                                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = xj.this.w;
                                if (wVar != null) {
                                    wVar.xj(false);
                                }
                                xj xjVar2 = xj.this;
                                if (xjVar2.w == null || (tsView = xjVar2.xj) == null || tsView.getParent() == null) {
                                    return;
                                }
                                try {
                                    context = ((View) xj.this.xj.getParent()).getContext();
                                } catch (Exception unused) {
                                    context = null;
                                }
                                if (context instanceof Activity) {
                                    xj.this.w.xj((Activity) context);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = xj.this.w;
                if (wVar != null) {
                    try {
                        wVar.xj(false);
                        xj xjVar = xj.this;
                        if (hl.xj(xjVar.hf) == 1) {
                            z = false;
                        }
                        xjVar.y(z);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void hf() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(boolean z) {
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = xj.this.w;
                if (wVar == null || !z) {
                    return;
                }
                wVar.xj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj() {
                w();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(View view, Map<String, Object> map) {
                y yVar;
                w();
                xj.this.zg = System.currentTimeMillis();
                hf hfVar = xj.this.c;
                if (hfVar != null) {
                    hfVar.w_();
                }
                xj xjVar = xj.this;
                ws wsVar = xjVar.hf;
                if (wsVar != null && (yVar = xjVar.e) != null) {
                    wsVar.f(yVar.kd());
                    xj.this.v.put("cache_type", Integer.valueOf(pz.hf().d(wo.d(xj.this.hf))));
                    xj xjVar2 = xj.this;
                    xjVar2.v.put("splash_show_time_type", Integer.valueOf(xjVar2.ff));
                }
                if (map != null && map.containsKey("show_send_type")) {
                    xj.this.v.put("show_send_type", map.get("show_send_type"));
                }
                xj xjVar3 = xj.this;
                xjVar3.v.put("is_repeat", Boolean.valueOf(xjVar3.jk.get()));
                xj.this.f10335a.set(true);
                if (!xj.this.nb.get()) {
                    xj.this.nb.set(true);
                    xj xjVar4 = xj.this;
                    ws wsVar2 = xjVar4.hf;
                    String str = xjVar4.ws;
                    xj xjVar5 = xj.this;
                    com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar2, str, xjVar5.v, xjVar5.n);
                    com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
                    ws wsVar3 = xj.this.hf;
                    ff.xj(wsVar3 != null ? wsVar3.kd() : 0);
                    com.bytedance.sdk.openadsdk.core.component.splash.hf.xj(xj.this.gh);
                }
                xj.this.pz();
                if (!xj.this.ss) {
                    xj.this.jk();
                }
                xj xjVar6 = xj.this;
                xjVar6.u(xjVar6.d.get());
                boolean db = pz.hf().db();
                xj xjVar7 = xj.this;
                if (xjVar7.f != null && (!xjVar7.jk.getAndSet(true) || db)) {
                    xj xjVar8 = xj.this;
                    xjVar8.f.xj(xjVar8);
                }
                xj.this.v();
                xj.this.z.set(true);
                TsView tsView = xj.this.xj;
                if (tsView != null) {
                    tsView.setIsShowSuccess(true);
                }
                xj.this.w(true);
            }
        });
        if (!this.ss) {
            emptyView.setNeedCheckingShow(true);
        }
        this.tf.put("splash_show_type", Integer.valueOf(this.g));
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.b, this.hf, this.ws, 4) { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.5
            @Override // com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view, tf tfVar) {
                if ((view instanceof SplashClickBarBtn) && xj.this.p) {
                    return;
                }
                super.xj(view, tfVar);
            }
        };
        this.kd = xjVar;
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.kd.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.tf);
        xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) this.kd.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class), emptyView);
        this.kd.hf(this.xj.getDislikeView());
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.kd.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(new xj.InterfaceC0169xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.6
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.InterfaceC0169xj
            public void xj(View view, int i) {
                xj xjVar2 = xj.this;
                com.bytedance.sdk.openadsdk.core.am.u.hf(xjVar2.zg, xjVar2.hf);
                xj xjVar3 = xj.this;
                com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar4 = xjVar3.f;
                if (xjVar4 != null) {
                    xjVar4.hf(xjVar3);
                }
                xj.this.p();
                xj.this.qt();
            }
        });
        this.xj.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xj.this.tf();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public View hf() {
        return null;
    }

    public void qt() {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(ViewGroup viewGroup) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        this.w = com.bytedance.sdk.openadsdk.core.pl.f.xj(this.b, this.hf, this.ws, false);
        y(z);
        com.bytedance.sdk.openadsdk.core.hf.xj xjVar = this.kd;
        if (xjVar != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final boolean z) {
        final String ho = this.hf.ho();
        this.w.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void hf(long j, long j2, String str, String str2) {
                long j3;
                long j4;
                SoftReference<w> softReference = xj.this.u;
                if (softReference == null || softReference.get() == null) {
                    j3 = j;
                    j4 = j2;
                } else {
                    j3 = j;
                    j4 = j2;
                    xj.this.u.get().hf(j3, j4, str, str2);
                }
                if (!z || j3 <= 0) {
                    return;
                }
                xj.C0198xj.xj(ho, 2, (int) ((j4 * 100) / j3));
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void w(long j, long j2, String str, String str2) {
                long j3;
                long j4;
                SoftReference<w> softReference = xj.this.u;
                if (softReference == null || softReference.get() == null) {
                    j3 = j;
                    j4 = j2;
                } else {
                    j3 = j;
                    j4 = j2;
                    xj.this.u.get().w(j3, j4, str, str2);
                }
                if (!z || j3 <= 0) {
                    return;
                }
                xj.C0198xj.xj(ho, 4, (int) ((j4 * 100) / j3));
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj() {
                SoftReference<w> softReference = xj.this.u;
                if (softReference != null && softReference.get() != null) {
                    xj.this.u.get().xj();
                }
                if (z) {
                    xj.C0198xj.xj(ho, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, long j2, String str, String str2) {
                long j3;
                long j4;
                SoftReference<w> softReference = xj.this.u;
                if (softReference == null || softReference.get() == null) {
                    j3 = j;
                    j4 = j2;
                } else {
                    j3 = j;
                    j4 = j2;
                    xj.this.u.get().xj(j3, j4, str, str2);
                }
                if (!z || j3 <= 0) {
                    return;
                }
                xj.C0198xj.xj(ho, 3, (int) ((j4 * 100) / j3));
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, String str, String str2) {
                SoftReference<w> softReference = xj.this.u;
                if (softReference != null && softReference.get() != null) {
                    xj.this.u.get().xj(j, str, str2);
                }
                if (z) {
                    xj.C0198xj.xj(ho, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(String str, String str2) {
                SoftReference<w> softReference = xj.this.u;
                if (softReference != null && softReference.get() != null) {
                    xj.this.u.get().xj(str, str2);
                }
                if (z) {
                    xj.C0198xj.xj(ho, 6, 100);
                }
            }
        });
    }

    private void zg() {
        if (this.hf == null) {
            return;
        }
        try {
            this.p = false;
            TsView tsView = new TsView(this.b, this.ws, this.hf);
            this.xj = tsView;
            tsView.setAttachedToWindowListener(this);
            e();
            this.xj.setCountDownViewPosition(this.hf);
            if (this.hf.lw() == 0) {
                TsView tsView2 = this.xj;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView3 = this.xj;
                if (tsView3 != null) {
                    tsView3.setAdlogoViewVisibility(0);
                }
            }
            if (this.hf.it() <= 0) {
                hf(3);
            } else {
                int it = this.hf.it();
                this.f10337pl = it;
                hf(it);
            }
            xj(this.hf);
            yo();
        } catch (ArrayIndexOutOfBoundsException e) {
            pl.u("sbr", e.getMessage());
        }
    }

    public void am() {
        com.bytedance.sdk.openadsdk.core.f.zg().f(true);
        com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        if (u == null) {
            return;
        }
        u.hf((xj.hf) null);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.c c() {
        return new MediationSplashManagerDefault();
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.w;
        if (wVar != null) {
            wVar.hf();
        }
        ws wsVar = this.hf;
        if (wsVar != null) {
            ht.xj(wsVar.ke());
        }
        ws wsVar2 = this.hf;
        ff.hf(wsVar2 != null ? wsVar2.kd() : 0);
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf hfVar = this.r;
        if (hfVar != null) {
            hfVar.xj();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.y.xj(1, this.hf, this.ws, this.gj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.xj
    public void f() {
        AtomicBoolean atomicBoolean = this.z;
        if (atomicBoolean != null && atomicBoolean.get()) {
            pl.w("开屏view重复展示");
            TsView tsView = this.xj;
            if (tsView != null && tsView.getCountDownView() != null && this.xj.getCountDownView().getView() != null) {
                this.xj.getCountDownView().getView().setVisibility(0);
            }
            u(this.d.get());
        }
        this.gj = 1;
    }

    public void g() {
        ra();
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.zg, this.hf);
        com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar = this.f;
        if (xjVar != null && !this.p) {
            this.p = true;
            xjVar.xj(this, 2);
            w(false);
        }
        am();
    }

    public void p() {
        this.vm.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.9
            @Override // java.lang.Runnable
            public void run() {
                xj.this.am = true;
                if (!com.bytedance.sdk.openadsdk.core.pl.w.w.y.xj) {
                    if (xj.this.wa != null) {
                        xj.this.wa.hf();
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.pl.w.w.y.xj = false;
                    com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = xj.this.w;
                    if (wVar instanceof kd) {
                        ((kd) wVar).f().xj(new com.bytedance.sdk.openadsdk.core.pl.w.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.9.1
                            @Override // com.bytedance.sdk.openadsdk.core.pl.w.xj.xj
                            public void xj() {
                                if (xj.this.wa != null) {
                                    xj.this.wa.hf();
                                }
                            }
                        });
                    }
                }
            }
        }, 100L);
    }

    public void pl() {
        wa mg;
        ws wsVar = this.hf;
        if (wsVar == null || (mg = wsVar.mg()) == null || mg.d() != 5) {
            return;
        }
        final int qt = mg.qt();
        final wa.xj am = mg.am();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                xj xjVar;
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar2;
                TsView tsView;
                int u = r.u(xj.this.b, view.getWidth());
                int u2 = r.u(xj.this.b, view.getHeight());
                int u3 = r.u(xj.this.b, motionEvent.getX());
                int u4 = r.u(xj.this.b, motionEvent.getY());
                boolean z = u3 >= am.xj() && u4 >= am.w() && u - u3 >= am.hf() && u2 - u4 >= am.u();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            xj.this.tj = motionEvent.getY();
                        }
                    } else {
                        if (!z) {
                            return false;
                        }
                        xj.this.tj = motionEvent.getY();
                        int u5 = r.u(xj.this.b, Math.abs(xj.this.tj - xj.this.eu));
                        if (xj.this.tj - xj.this.eu < 0.0f && u5 > qt && (xjVar2 = (xjVar = xj.this).kd) != null && (tsView = xjVar.xj) != null) {
                            xjVar2.onClick(tsView);
                        }
                    }
                } else {
                    if (!z) {
                        return false;
                    }
                    xj.this.eu = motionEvent.getY();
                }
                return true;
            }
        };
        this.y = onTouchListener;
        TsView tsView = this.xj;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    public void tf() {
        if (!this.qt) {
            this.qt = true;
            this.p = true;
            if (!TextUtils.isEmpty(this.hf.jf())) {
                com.bytedance.sdk.openadsdk.core.am.u.xj(this.zg > 0 ? System.currentTimeMillis() - this.zg : 0L, this.hf);
            }
            ra();
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.zg, this.hf);
            w(false);
            am();
        }
        com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar = this.f;
        if (xjVar != null) {
            xjVar.xj(this, 1);
        }
    }

    public void u(boolean z) {
        if (z || this.xj == null) {
            return;
        }
        if (this.wo.get() == 2 && op.xj(this.hf)) {
            com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf hfVar = this.r;
            if (hfVar != null) {
                hfVar.hf();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.u countDownView = this.xj.getCountDownView();
        if (countDownView != null) {
            countDownView.setCountdownListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.11
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.xj
                public void xj() {
                    xj.this.g();
                }
            });
            countDownView.xj(false);
            countDownView.xj();
        }
    }

    public void w(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar = this.gy;
        if (xjVar != null) {
            xjVar.xj(this.op, this.hf, this.gh, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void y() {
        if (!this.d.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.component.splash.y.xj(2, this.hf, this.ws, 0);
        }
        TsView tsView = this.xj;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public View w() {
        f fVar;
        if (this.ht && (fVar = this.wa) != null) {
            return fVar.xj();
        }
        return null;
    }

    public void hf(boolean z) {
        this.q = z;
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public Map<String, Object> kd() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return null;
        }
        z zVar = wsVar.lx().get(0);
        if (zVar == null) {
            return this.hf.pu();
        }
        if (!zVar.y()) {
            return this.hf.pu();
        }
        String xj = zVar.xj();
        Map<String, Object> pu = this.hf.pu();
        pu.put("image_url", xj);
        return pu;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<d, c> uVar, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar) {
        if (wVar == null || uVar == null) {
            return;
        }
        this.gy = xjVar;
        this.en.set(wVar.d());
        this.op = uVar;
        c cVar = new c();
        this.et = cVar;
        cVar.hf(wVar.d());
        this.et.xj(wVar.hf());
        this.et.xj(this);
        this.b = wVar.getContext();
        this.ws = wVar.y();
        this.e = wVar.u();
        boolean z = true;
        xj(wVar.kd(), true);
        this.gh = wVar.c();
        y yVar = this.e;
        if (yVar == null) {
            this.et.hf(3);
            this.et.xj("render splash ad model is null");
            uVar.xj(this.et);
        } else {
            if (this.yo == null) {
                this.et.hf(3);
                this.et.xj("render splash material is null");
                uVar.xj(this.et);
                return;
            }
            this.hf = yVar.hf();
            boolean ap = pz.hf().ap();
            if (!pz.hf().ee() && !ap) {
                z = false;
            }
            this.ss = z;
            zg();
        }
    }

    private void hf(int i) {
        TsView tsView = this.xj;
        if (tsView != null) {
            tsView.setCountDownTime(i);
        }
    }

    private void hf(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.ht || (tsView = this.xj) == null || this.hf == null || this.wa == null || this.wn) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.wn = true;
        ViewGroup xj = this.wa.xj();
        if (xj == null) {
            return;
        }
        u uVar = this.j;
        if (uVar != null) {
            uVar.y();
        }
        if (xj.getParent() != null) {
            ((ViewGroup) xj.getParent()).removeView(xj);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(xj);
            r.f(this.xj);
            this.xj.removeAllViews();
            this.xj = null;
        }
        xj.setOnClickListener(null);
        xj.setOnTouchListener(null);
        if (this.dk) {
            u uVar2 = this.j;
            if (uVar2 != null) {
                uVar2.tf();
            }
            this.j = null;
        }
        this.wa.xj(this.j, new f.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.f.xj
            public Context getActivity() {
                return xj.this.qd;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.f.xj
            public void hf() {
                xj.this.bl = true;
                xj.this.dk();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.f.xj
            public void xj(long j) {
                xj.this.vm.removeMessages(1);
                if (j < 0) {
                    xj.this.vm.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    if (j == 0) {
                        xj.this.vm.sendEmptyMessage(2);
                        return;
                    }
                    xj.this.s = j;
                    xj.this.tu = 0L;
                    xj.this.vm.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.f.xj
            public void xj() {
                xj.this.vm.removeMessages(1);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public int u() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return -1;
        }
        return wsVar.vw();
    }

    public synchronized void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.f fVar, boolean z) {
        if (this.yo == null || !z) {
            this.yo = fVar;
            if (fVar != null) {
                hf(fVar.kd());
                this.ai = fVar.u();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
        this.n = d;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public PluginValueSet xj() {
        AYUAbz A5SV6n2 = AYUAbz.A5SV6n(super.xj());
        A5SV6n2.AMqCpz(1, com.bytedance.sdk.openadsdk.core.ai.w);
        return A5SV6n2.A2egSU();
    }

    public void xj(hf hfVar) {
        this.c = hfVar;
    }

    private void xj(ws wsVar) {
        TsView tsView;
        if (wsVar == null || (tsView = this.xj) == null) {
            return;
        }
        tsView.xj(wsVar);
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar, final EmptyView emptyView) {
        wVar.xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.presentation.xj.8
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.w.xj
            public boolean xj() {
                wVar.xj(emptyView);
                wVar.xj(xj.this.v);
                wVar.xj(xj.this.ws);
                wVar.xj(xj.this.n);
                return xj.this.f10335a.get();
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = message.what;
        if (i == 1) {
            long j = this.tu + 1;
            this.tu = j;
            if (j >= this.s) {
                this.vm.sendEmptyMessage(2);
                return;
            } else {
                this.vm.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (!this.bl && bl.xj(this.hf)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 0);
                com.bytedance.sdk.openadsdk.core.am.u.hf(this.hf, "splash_ad", "splash_card_close", jSONObject);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        dk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.xj
    public void xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.hf hfVar = this.r;
        if (hfVar != null) {
            hfVar.xj(z);
        }
        this.gj++;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        if (wVar == null) {
            return;
        }
        this.u = new SoftReference<>(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(com.bytedance.sdk.openadsdk.u.xj.hf.xj.xj xjVar) {
        this.f = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(com.bytedance.sdk.openadsdk.u.xj.hf.xj.hf hfVar) {
        this.dq = hfVar;
        com.bytedance.sdk.openadsdk.core.component.splash.xj xjVar = this.dc;
        if (xjVar != null) {
            xjVar.xj(hfVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.hf
    public void xj(ViewGroup viewGroup, Activity activity) {
        this.qd = activity;
        hf(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
        if (this.yy) {
            return;
        }
        q.xj(this.hf, d);
        this.yy = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
        if (this.hl) {
            return;
        }
        q.xj(this.hf, d, str, str2);
        this.hl = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        ws wsVar = this.hf;
        if (wsVar != null) {
            ht.xj(wsVar.ke(), hfVar, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
        }
    }

    public void xj(int i) {
        this.l = i;
    }
}
