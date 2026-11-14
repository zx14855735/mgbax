package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.q;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.hf.xj.w.w;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hf;
import com.bytedance.sdk.openadsdk.core.pl.hf.xj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pz extends hf {
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj c;
    private EmptyView et;
    protected final Context hf;
    private final FrameLayout ht;

    /* renamed from: io, reason: collision with root package name */
    private boolean f10381io;
    private u jk;
    protected WeakReference<pl> kd;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w p;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u ra;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xj tf;
    private kd v;
    protected ws w;
    protected NativeExpressView xj;
    private xj y;
    protected String u = "embeded_ad";

    /* renamed from: pl, reason: collision with root package name */
    private long f10382pl = 0;
    private Double g = null;
    private boolean am = false;
    private boolean qt = false;
    private AtomicBoolean zg = new AtomicBoolean(false);
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean yo = new AtomicBoolean(false);
    private volatile boolean pz = false;
    private final ViewGroup dk = new FrameLayout(com.bytedance.sdk.openadsdk.core.pz.getContext());
    private final xj x = new xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pz.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
        public void hf(View view, int i) {
            boolean db = com.bytedance.sdk.openadsdk.core.pz.hf().db();
            if (pz.this.y != null && (!pz.this.yo.getAndSet(true) || db)) {
                pz.this.y.hf(pz.this.dk, i);
            }
            if (pz.this.ra == null || pz.this.ra.xj() == null) {
                return;
            }
            pz.this.ra.xj().u();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
        public void xj(View view, int i) {
            if (pz.this.y != null) {
                pz.this.y.xj(pz.this.dk, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
        public void xj(View view, String str, int i) {
            if (pz.this.y != null) {
                pz.this.y.xj(pz.this.dk, str, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
        public void xj(View view, float f, float f2) {
            pz pzVar = pz.this;
            if (pzVar.xj != null && pzVar.ra != null) {
                pz pzVar2 = pz.this;
                pzVar2.xj.setEasyPlayableSender(pzVar2.ra.xj());
                pz.this.ra.xj(pz.this.xj.getEasyPlayableLayout(), pz.this.xj.getVideoContainer());
            }
            pz.this.dk.removeAllViews();
            pz.this.dk.addView(view);
            pz.this.dk.addView(pz.this.ht, new FrameLayout.LayoutParams((int) f, (int) f2));
            if (pz.this.y != null) {
                pz.this.y.xj(pz.this.dk, f, f2);
            }
        }
    };

    public pz(Context context, final ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.f10381io = false;
        this.hf = context;
        this.w = wsVar;
        this.f10381io = com.bytedance.sdk.openadsdk.core.pz.hf().ee() || com.bytedance.sdk.openadsdk.core.pz.hf().ap();
        xj(context, wsVar, hfVar);
        this.ht = new FrameLayout(context);
        this.ra = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u(wsVar, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pz.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long getActualPlayDuration() {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    return nativeExpressView.getActualPlayDuration();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int hf() {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    return nativeExpressView.hf();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void kd() {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.kd();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void setPauseFromExpressView(boolean z) {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.setPauseFromExpressView(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void u() {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void w(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void y() {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.y();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int w() {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    return nativeExpressView.w();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i) {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.xj(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void hf(int i) {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.hf(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long xj() {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    return nativeExpressView.xj();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void hf(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.xj(view, i, wVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i, String str) {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.xj(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(float f) {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.xj(f);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(View view) {
                pz.this.x.xj(view, wsVar.vw());
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                NativeExpressView nativeExpressView = pz.this.xj;
                if (nativeExpressView != null) {
                    nativeExpressView.xj(view, i, wVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> am() {
        HashMap hashMap = new HashMap();
        dk.xj(hashMap, this.w, this.xj);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.pz) {
            this.pz = true;
            if (this.w.vw() == 4) {
                com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("native_register_download") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        pz pzVar = pz.this;
                        pzVar.p = com.bytedance.sdk.openadsdk.core.pl.f.xj(pzVar.hf, pzVar.w, pzVar.u, false);
                        if (pz.this.v != null) {
                            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) pz.this.v.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(pz.this.p);
                        }
                        if (pz.this.jk != null) {
                            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) pz.this.jk.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(pz.this.p);
                        }
                        pz pzVar2 = pz.this;
                        if (pzVar2.hf instanceof Activity) {
                            pzVar2.p.xj((Activity) pz.this.hf);
                        }
                        pz pzVar3 = pz.this;
                        pzVar3.xj(pzVar3.p, pz.this.xj);
                        pz.this.p.xj(false);
                        pz.this.p.xj(pz.this.f);
                    }
                });
                return;
            }
            return;
        }
        if (this.p != null) {
            kd kdVar = this.v;
            if (kdVar != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.p);
            }
            u uVar = this.jk;
            if (uVar != null) {
                ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.p);
            }
            try {
                xj(this.p, this.xj);
                this.p.xj(false);
                this.p.xj(this.f);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void c() {
        NativeExpressView nativeExpressView = this.xj;
        if (nativeExpressView != null) {
            nativeExpressView.ht();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd d() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public Map<String, Object> f() {
        ws wsVar = this.w;
        if (wsVar != null) {
            return wsVar.pu();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int hf() {
        ws wsVar = this.w;
        if (wsVar == null) {
            return -1;
        }
        return wsVar.rx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void kd() {
        super.kd();
        NativeExpressView nativeExpressView = this.xj;
        if (nativeExpressView != null) {
            nativeExpressView.g();
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.p;
        if (wVar != null) {
            wVar.hf();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u uVar = this.ra;
        if (uVar != null) {
            uVar.hf();
        }
        ws wsVar = this.w;
        ff.hf(wsVar != null ? wsVar.kd() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf
    public ws tf() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void u() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.tf;
        if (xjVar != null) {
            xjVar.xj(this.xj);
        }
        this.xj.e();
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int w() {
        ws wsVar = this.w;
        if (wsVar == null) {
            return -1;
        }
        return wsVar.vw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.zg.w.hf.u y() {
        ws wsVar = this.w;
        if (wsVar == null || wsVar.xl() == null) {
            return null;
        }
        this.w.xl().hf(this.u);
        return new com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.w.xl());
    }

    private void hf(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        if (this.tf == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(activity, this.w.xl(), this.u, false);
            this.tf = xjVar2;
            com.bytedance.sdk.openadsdk.core.dislike.w.xj(activity, this.w, xjVar2);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar3 = this.tf;
        if (xjVar3 != null) {
            xjVar3.xj(this.xj);
        }
        this.tf.xj(xjVar);
        NativeExpressView nativeExpressView = this.xj;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.tf);
        }
    }

    public void xj(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, wsVar, hfVar, this.u);
        this.xj = nativeExpressView;
        this.dk.addView(nativeExpressView);
        xj(this.xj, this.w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public View xj() {
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.w);
        return this.dk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar) {
        this.y = xj.xj(hfVar);
        this.xj.setExpressInteractionListener(this.x);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
        this.g = d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj xjVar) {
        this.y = xj.xj(xjVar);
        this.xj.setExpressInteractionListener(this.x);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        com.bytedance.sdk.openadsdk.core.pl.hf.xj xj = xj.C0177xj.xj(wVar);
        this.c = xj;
        hf.xj xjVar = this.f;
        if (xjVar != null) {
            xjVar.xj(xj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        if (xjVar == null || activity == null) {
            return;
        }
        hf(activity, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(String str) {
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf
    public void xj(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.pl.w("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.xj;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        if (this.tf == null) {
            hf(activity, null);
        }
        return this.tf;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.xj;
        if (nativeExpressView != null) {
            nativeExpressView.xj(jSONObject);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void xj(NativeExpressView nativeExpressView, final ws wsVar) {
        this.w = wsVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.hf.w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pz.4
            @Override // com.bytedance.sdk.component.adexpress.hf.w
            public boolean xj(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).v();
                    pl plVar = new pl(viewGroup.getContext());
                    com.bytedance.sdk.openadsdk.core.video.u.xj.xj(Integer.valueOf(wsVar.hashCode()), pz.this);
                    pz pzVar = pz.this;
                    plVar.xj(pzVar.w, (NativeExpressView) viewGroup, pzVar.p);
                    plVar.setDislikeInner(pz.this.tf);
                    plVar.setDislikeOuter(pz.this.d);
                    pz pzVar2 = pz.this;
                    ws wsVar2 = pzVar2.w;
                    if (wsVar2 != null) {
                        pzVar2.xj(wsVar2.xl());
                    }
                    pz.this.kd = new WeakReference<>(plVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar);
        EmptyView xj = xj(nativeExpressView);
        this.et = xj;
        if (xj == null) {
            EmptyView emptyView = new EmptyView(this.hf, nativeExpressView, wsVar != null ? wsVar.cm() : 1000);
            this.et = emptyView;
            emptyView.xj(this.w, this.u);
            nativeExpressView.addView(this.et);
        }
        this.et.setCallback(new EmptyView.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pz.5
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void hf() {
                if (pz.this.p != null) {
                    pz.this.p.hf();
                }
                pz pzVar = pz.this;
                pzVar.f10382pl = com.bytedance.sdk.openadsdk.core.am.u.xj(pzVar.f10382pl, wsVar, pz.this.u, 22);
                pz.this.zg.set(false);
                pz.this.e.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(boolean z) {
                if (pz.this.p != null) {
                    if (z) {
                        pz.this.p.xj();
                    } else {
                        com.bytedance.sdk.openadsdk.core.pl.hf.w unused = pz.this.p;
                    }
                }
                pz pzVar = pz.this;
                pzVar.f10382pl = com.bytedance.sdk.openadsdk.core.am.u.xj(pzVar.f10382pl, z, wsVar, pz.this.u, 2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj() {
                pz.this.g();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(View view, Map<String, Object> map) {
                pz.this.g();
                pz.this.f10382pl = System.currentTimeMillis();
                Map am = pz.this.am();
                am.put("is_repeat", Boolean.valueOf(pz.this.yo.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    am.put("show_send_type", map.get("show_send_type"));
                }
                am.put("is_repeat", Boolean.valueOf(pz.this.yo.get()));
                pz.this.zg.set(true);
                if (!pz.this.e.get()) {
                    pz.this.e.set(true);
                    ws wsVar2 = wsVar;
                    pz pzVar = pz.this;
                    com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar2, pzVar.u, (Map<String, Object>) am, pzVar.g);
                    com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
                    ws wsVar3 = wsVar;
                    ff.xj(wsVar3 != null ? wsVar3.kd() : 0);
                }
                pz.this.x.hf(view, wsVar.vw());
                NativeExpressView nativeExpressView2 = pz.this.xj;
                if (nativeExpressView2 != null) {
                    nativeExpressView2.yo();
                    pz.this.xj.zg();
                }
            }
        });
        Context context = this.hf;
        String str = this.u;
        kd kdVar = new kd(context, wsVar, str, wo.hf(str));
        this.v = kdVar;
        xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        this.v.xj(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.v.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this);
        this.xj.setClickListener(this.v);
        Context context2 = this.hf;
        String str2 = this.u;
        u uVar = new u(context2, wsVar, str2, wo.hf(str2));
        this.jk = uVar;
        xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        this.jk.xj(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.jk.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this);
        this.xj.setClickCreativeListener(this.jk);
        if (this.f10381io) {
            return;
        }
        this.et.setNeedCheckingShow(true);
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar) {
        wVar.xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.pz.6
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.w.xj
            public boolean xj() {
                wVar.xj(pz.this.et);
                wVar.xj(pz.this.am());
                wVar.xj(pz.this.u);
                wVar.xj(pz.this.g);
                return pz.this.zg.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.w wVar, NativeExpressView nativeExpressView) {
        String str;
        if (wVar == null || nativeExpressView == null) {
            return;
        }
        ws wsVar = this.w;
        if (wsVar != null) {
            str = wsVar.ho();
        } else {
            str = "";
        }
        hf.xj xjVar = new hf.xj(this.c, str);
        this.f = xjVar;
        wVar.xj(xjVar);
    }

    private EmptyView xj(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
        if (this.am) {
            return;
        }
        q.xj(this.w, d);
        this.am = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
        if (this.qt) {
            return;
        }
        q.xj(this.w, d, str, str2);
        this.qt = true;
    }
}
