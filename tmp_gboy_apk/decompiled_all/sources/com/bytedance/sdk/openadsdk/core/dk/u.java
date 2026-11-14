package com.bytedance.sdk.openadsdk.core.dk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.zg;
import com.bytedance.sdk.openadsdk.core.a.q;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ht;
import com.bytedance.sdk.openadsdk.core.jk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.pl.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import com.bytedance.sdk.openadsdk.zg.w.hf.kd;
import com.bytedance.sdk.openadsdk.zg.w.hf.pl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends g {
    private int c;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf d;
    private final boolean dk;
    private int f;
    private final ws hf;

    /* renamed from: io, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u f10350io;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj jk;
    private c kd;
    private volatile ViewGroup p;

    /* renamed from: pl, reason: collision with root package name */
    private View f10351pl;
    private TextView pz;
    private float qt;
    private am tf;
    private Dialog u;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w v;
    private final Context w;
    private UGenVideoOrImgPanelView x;
    private final jk xj;
    private kd y;
    private float zg;
    private boolean g = false;
    private boolean am = true;
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean yo = new AtomicBoolean(false);
    private boolean ht = false;
    private boolean ra = false;
    private volatile WeakReference<NativeVideoTsView> et = null;
    private final com.bytedance.sdk.openadsdk.core.video.nativevideo.xj ai = new com.bytedance.sdk.openadsdk.core.video.nativevideo.xj() { // from class: com.bytedance.sdk.openadsdk.core.dk.u.1
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xj
        public void xj() {
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dk.u.1.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.q();
                    u.this.j();
                }
            }, pz.hf().m());
        }
    };
    private volatile boolean q = false;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj z = null;

    public u(Context context, final ws wsVar, int i, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z) {
        zg.xj(wsVar, "materialMeta不能为null");
        this.dk = z;
        this.hf = wsVar;
        if (context == null) {
            this.w = pz.getContext();
        } else {
            this.w = context;
        }
        this.c = i;
        this.d = hfVar;
        jk jkVar = new jk(this.w, this, wsVar, xj(i));
        this.xj = jkVar;
        jkVar.xj(i);
        this.tf = xj(wsVar);
        this.f10350io = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u(wsVar, true, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj() { // from class: com.bytedance.sdk.openadsdk.core.dk.u.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long getActualPlayDuration() {
                return xj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void hf(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void kd() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void setPauseFromExpressView(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int w() {
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(float f) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void y() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public int hf() {
                NativeVideoTsView nativeVideoTsView;
                if (u.this.et == null || (nativeVideoTsView = (NativeVideoTsView) u.this.et.get()) == null) {
                    return 0;
                }
                com.bykv.vk.openvk.component.video.api.u.w nativeVideoController = nativeVideoTsView.getNativeVideoController();
                if (nativeVideoController == null) {
                    return 4;
                }
                if (nativeVideoController.jk()) {
                    return 5;
                }
                if (nativeVideoController.ht()) {
                    return 1;
                }
                return ((nativeVideoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.u) && ((com.bytedance.sdk.openadsdk.core.video.nativevideo.u) nativeVideoController).yy()) ? 2 : 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void w(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public void xj(int i2, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
            public long xj() {
                NativeVideoTsView nativeVideoTsView;
                com.bykv.vk.openvk.component.video.api.u.w nativeVideoController;
                if (u.this.et == null || (nativeVideoTsView = (NativeVideoTsView) u.this.et.get()) == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
                    return 0L;
                }
                return ((int) nativeVideoController.p()) / 1000;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void hf(View view, int i2, com.bytedance.sdk.component.adexpress.w wVar) {
                tf tfVar;
                if ((i2 == 1 || i2 == 2) && (wVar instanceof ra)) {
                    ra raVar = (ra) wVar;
                    tfVar = new tf();
                    tfVar.xj(raVar.xj);
                    tfVar.hf(raVar.hf);
                    tfVar.w(raVar.w);
                    tfVar.u(raVar.u);
                    tfVar.xj(raVar.kd);
                    tfVar.hf(raVar.y);
                    tfVar.xj(raVar.qt);
                } else {
                    tfVar = null;
                }
                if (i2 == 2) {
                    u.this.xj.xj(view, tfVar);
                }
                if (i2 == 1) {
                    u.this.xj.hf(view, tfVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(View view) {
                if (u.this.jk != null) {
                    u.this.jk.xj(view, u.this);
                }
                ws wsVar2 = wsVar;
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(wsVar2, true, io.w(wsVar2), 2, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj
            public void xj(View view, int i2, com.bytedance.sdk.component.adexpress.w wVar) {
                tf tfVar;
                if (wVar instanceof ra) {
                    ra raVar = (ra) wVar;
                    tfVar = new tf();
                    tfVar.xj(raVar.xj);
                    tfVar.hf(raVar.hf);
                    tfVar.w(raVar.w);
                    tfVar.u(raVar.u);
                    tfVar.xj(raVar.kd);
                    tfVar.hf(raVar.y);
                    tfVar.xj(raVar.qt);
                } else {
                    tfVar = null;
                }
                if (i2 == 3) {
                    u.this.a();
                } else {
                    u.this.xj.xj(view, tfVar);
                }
                boolean xj = com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(u.this.et == null ? null : (NativeVideoTsView) u.this.et.get(), wVar);
                ws wsVar2 = wsVar;
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.tf.xj(wsVar2, xj, io.w(wsVar2), 1, (JSONObject) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Dialog dialog = this.u;
        if (dialog != null) {
            dialog.show();
            return;
        }
        c cVar = this.kd;
        if (cVar != null) {
            cVar.xj();
        } else {
            TTDelegateActivity.xj(getContext(), this.hf);
        }
    }

    private boolean en() {
        ws wsVar = this.hf;
        if (wsVar == null || wsVar.vw() == 5) {
            return false;
        }
        if (this.f == 0) {
            this.f = wo.d(this.hf);
        }
        return pz.hf().f(this.f) == 1;
    }

    private void ff() {
        if (this.p == null || this.tf == null || this.f10351pl == null) {
            return;
        }
        this.p.removeAllViews();
        if (this.f10351pl.getParent() != null) {
            ((ViewGroup) this.f10351pl.getParent()).removeAllViews();
        }
        this.p.addView(this.f10351pl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        NativeVideoTsView nativeVideoTsView;
        jk jkVar = this.xj;
        if (jkVar != null) {
            jkVar.xj(this.f10350io.xj());
        }
        if (!ws.hf(this.hf)) {
            this.f10350io.xj(this.p, hf(this.p));
            return;
        }
        if (this.et == null || this.et.get() == null) {
            nativeVideoTsView = null;
        } else {
            nativeVideoTsView = this.et.get();
            nativeVideoTsView.setEasyPlayableEventSender(this.f10350io.xj());
        }
        this.f10350io.xj(this.p, nativeVideoTsView);
    }

    private void l() {
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar;
        if (this.tf == null) {
            com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar2 = this.v;
            if (wVar2 != null) {
                wVar2.xj(this.p, this.d.f(), this.d.d(), false);
                return;
            }
            return;
        }
        if (this.e.get() && (wVar = this.v) != null) {
            wVar.xj(this.f10351pl, this.qt, this.zg, this.yo.get());
        } else {
            this.tf.xj(new com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf(null) { // from class: com.bytedance.sdk.openadsdk.core.dk.u.6
                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void hf(View view, int i) {
                    if (u.this.jk != null) {
                        u.this.jk.xj(u.this);
                    }
                    if (u.this.f10350io == null || u.this.f10350io.xj() == null) {
                        return;
                    }
                    u.this.f10350io.xj().u();
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, int i) {
                    if (u.this.jk != null) {
                        u.this.jk.xj(view, u.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, String str, int i) {
                    u.this.e.set(true);
                    u uVar = u.this;
                    uVar.f10351pl = uVar.p;
                    u uVar2 = u.this;
                    uVar2.qt = uVar2.d.f();
                    u uVar3 = u.this;
                    uVar3.zg = uVar3.d.d();
                    if (u.this.v != null) {
                        u.this.v.xj(u.this.p, u.this.d.f(), u.this.d.d(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf
                public void xj(View view, float f, float f2) {
                    u.this.e.set(true);
                    u.this.yo.set(true);
                    u.this.f10351pl = view;
                    u.this.qt = f;
                    u.this.zg = f2;
                    if (u.this.v != null) {
                        u.this.v.xj(view, f, f2, true);
                    }
                }
            });
            this.tf.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.x;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.g();
        }
        if (UGenVideoOrImgPanelView.xj(this.hf) || !pz.hf().az().u) {
            if (ws.hf(this.hf)) {
                xj();
            } else {
                z();
            }
            jk jkVar = this.xj;
            if (jkVar != null) {
                jkVar.xj((NativeExpressView) this.x);
            }
            UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = this.x;
            if (uGenVideoOrImgPanelView2 != null) {
                uGenVideoOrImgPanelView2.setAdSlot(this.d);
            }
        }
    }

    private void z() {
        View hf;
        if (ws.hf(this.hf) || (hf = hf(this.p)) == null) {
            return;
        }
        this.x = new UGenVideoOrImgPanelView(this.w, this.hf, null, hf, this.p, wo.hf(this.c), true);
    }

    public boolean ai() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void dk() {
        this.q = true;
        am amVar = this.tf;
        if (amVar != null) {
            amVar.kd();
        }
        ws wsVar = this.hf;
        if (wsVar != null) {
            ht.xj(wsVar.ke());
        }
        jk jkVar = this.xj;
        if (jkVar != null) {
            jkVar.hf();
        }
        this.f10350io.hf();
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.x;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int e() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return -1;
        }
        List<z> lx = wsVar.lx();
        return (lx == null || lx.isEmpty() || lx.get(0) == null || !lx.get(0).kd() || !com.bytedance.sdk.openadsdk.kd.xj.f(this.hf)) ? this.hf.rx() : lx.get(0).hf() >= lx.get(0).w() ? 5 : 15;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd et() {
        return new MediationNativeManagerDefault();
    }

    public void finalize() {
        super.finalize();
        if (this.q) {
            return;
        }
        dk();
    }

    public Context getContext() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public Map<String, Object> ht() {
        ws wsVar = this.hf;
        if (wsVar != null) {
            return wsVar.pu();
        }
        return null;
    }

    public ws io() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public kd jk() {
        if (this.tf != null && this.e.get()) {
            return null;
        }
        ws wsVar = this.hf;
        boolean z = wsVar != null && wsVar.vw() == 4;
        if (this.y == null && this.xj != null && z) {
            this.y = new kd() { // from class: com.bytedance.sdk.openadsdk.core.dk.u.4
                @Override // com.bytedance.sdk.openadsdk.zg.w.hf.kd
                public void hf() {
                    com.bytedance.sdk.openadsdk.core.pl.hf.w xj;
                    if (u.this.z == null || (xj = u.this.xj.xj()) == null) {
                        return;
                    }
                    xj.u();
                }

                @Override // com.bytedance.sdk.openadsdk.zg.w.hf.kd
                public void xj() {
                    int pl2;
                    if (u.this.z != null) {
                        com.bytedance.sdk.openadsdk.core.pl.hf.w xj = u.this.xj.xj();
                        if ((xj instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) && (1 == (pl2 = ((com.bytedance.sdk.openadsdk.core.pl.w.kd) xj).pl()) || 4 == pl2 || 6 == pl2 || 7 == pl2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("downloadstatuscontroller_type", 1);
                            u uVar = u.this;
                            String xj2 = uVar.xj(uVar.c);
                            d.xj xjVar = new d.xj();
                            float y = r.y(u.this.w);
                            com.bytedance.sdk.openadsdk.core.am.u.xj("click", u.this.hf, xjVar.xj(y).xj(r.f(u.this.w)).hf(r.c(u.this.w)).xj(), xj2, true, hashMap, 1, false);
                        }
                        if (xj != null) {
                            xj.u(true);
                            xj.xj(wo.v(u.this.hf), false);
                        }
                    }
                }
            };
        }
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public View pz() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void ra() {
        l();
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.hf).xj(this.c).hf(this.f);
    }

    public boolean x() {
        return this.am;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.u yo() {
        ws wsVar = this.hf;
        if (wsVar == null || wsVar.xl() == null) {
            return null;
        }
        this.hf.xl().hf(xj(this.c));
        return new com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.hf.xl());
    }

    private NativeVideoTsView w(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public pl am() {
        return com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.hf) ? TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ra.wo.d(this.hf)) ? z.xj(0, 0, "", 0.0d) : z.xj(com.bytedance.sdk.openadsdk.core.ra.wo.p(this.hf), com.bytedance.sdk.openadsdk.core.ra.wo.tf(this.hf), com.bytedance.sdk.openadsdk.core.ra.wo.d(this.hf), 0.0d) : this.hf.uf() == null ? z.xj(0, 0, "", 0.0d) : z.xj(this.hf.uf());
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String c() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ra.wo.w(this.hf))) {
            return com.bytedance.sdk.openadsdk.core.ra.wo.w(this.hf);
        }
        if (pz.hf().qi()) {
            if (!TextUtils.isEmpty(this.hf.kr())) {
                return this.hf.kr();
            }
            if (this.hf.vh() != null && !TextUtils.isEmpty(this.hf.vh().w())) {
                return this.hf.vh().w();
            }
            if (!TextUtils.isEmpty(g())) {
                return g();
            }
        } else {
            if (this.hf.vh() != null && !TextUtils.isEmpty(this.hf.vh().w())) {
                return this.hf.vh().w();
            }
            if (!TextUtils.isEmpty(g())) {
                return g();
            }
            if (!TextUtils.isEmpty(this.hf.kr())) {
                return this.hf.kr();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String d() {
        return this.hf.bh();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String f() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ra.wo.y(this.hf))) {
            return com.bytedance.sdk.openadsdk.core.ra.wo.y(this.hf);
        }
        if (pz.hf().qi()) {
            if (!TextUtils.isEmpty(this.hf.uj())) {
                return this.hf.uj();
            }
            if (!TextUtils.isEmpty(this.hf.kr())) {
                return this.hf.kr();
            }
        } else {
            if (!TextUtils.isEmpty(this.hf.kr())) {
                return this.hf.kr();
            }
            if (!TextUtils.isEmpty(this.hf.uj())) {
                return this.hf.uj();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String g() {
        return this.hf.ci();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public pl kd() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return z.xj(0, 0, "", 0.0d);
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ra.wo.f(this.hf)) ? z.xj(0, 0, "", 0.0d) : z.xj(com.bytedance.sdk.openadsdk.core.ra.wo.g(this.hf), com.bytedance.sdk.openadsdk.core.ra.wo.pl(this.hf), com.bytedance.sdk.openadsdk.core.ra.wo.f(this.hf), 0.0d);
        }
        if (h.am(this.hf) != null) {
            return z.xj(h.w(this.hf), h.u(this.hf), h.hf(this.hf), 0.0d);
        }
        List<z> lx = this.hf.lx();
        if (lx == null || lx.isEmpty() || lx.get(0) == null || !lx.get(0).kd() || !com.bytedance.sdk.openadsdk.kd.xj.f(this.hf)) {
            return z.xj(0, 0, "", 0.0d);
        }
        return z.xj(lx.get(0).w(), lx.get(0).hf(), lx.get(0).xj(), 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int p() {
        if (this.hf.vh() != null) {
            return this.hf.vh().y();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int pl() {
        if (this.hf.vh() != null) {
            return this.hf.vh().c();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public List<pl> qt() {
        ArrayList arrayList = new ArrayList();
        if (this.hf.lx() != null && !this.hf.lx().isEmpty()) {
            Iterator<z> it = this.hf.lx().iterator();
            while (it.hasNext()) {
                pl xj = z.xj(it.next());
                if (xj != null) {
                    arrayList.add(xj);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int tf() {
        if (this.hf.vh() != null) {
            return this.hf.vh().kd();
        }
        return 0;
    }

    public jk u() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public Bitmap y() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return BitmapFactory.decodeResource(this.w.getResources(), com.bytedance.sdk.component.utils.jk.kd(pz.getContext(), "tt_ad_logo_new"));
        }
        String nn = wsVar.nn();
        if (TextUtils.isEmpty(nn)) {
            return BitmapFactory.decodeResource(this.w.getResources(), com.bytedance.sdk.component.utils.jk.kd(pz.getContext(), "tt_ad_logo_new"));
        }
        if (this.pz == null) {
            this.pz = new TextView(pz.getContext());
            this.pz.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        r.xj(this.pz, nn, pz.getContext());
        return r.c(this.pz);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int zg() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return -1;
        }
        return wsVar.vw();
    }

    private View hf(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            xj(viewGroup, arrayList, upieImageViewArr);
            UpieImageView upieImageView = upieImageViewArr[0];
            if (upieImageView != null) {
                return upieImageView;
            }
            if (!arrayList.isEmpty()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ImageView imageView2 = (ImageView) arrayList.get(i);
                    if (imageView == null || (imageView2.getWidth() > imageView.getWidth() && imageView2.getHeight() > imageView.getHeight())) {
                        imageView = imageView2;
                    }
                }
            }
        }
        return imageView;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        zg.xj(viewGroup != null || this.yo.get(), "container不能为null");
        zg.xj(view != null || this.yo.get(), "clickView不能为null");
        this.p = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        xj(viewGroup, arrayList, null, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.openadsdk.core.ra.pl v() {
        ws wsVar = this.hf;
        if (wsVar == null || wsVar.vw() != 4) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.ra.pl(this.hf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context] */
    private void w(Activity activity) {
        Context context = this.w;
        Activity activity2 = activity;
        if (context instanceof Activity) {
            activity2 = activity;
            if (!((Activity) context).isFinishing()) {
                activity2 = this.w;
            }
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(activity2, this.hf.xl(), xj(this.c), false);
        this.kd = xjVar;
        com.bytedance.sdk.openadsdk.core.dislike.w.xj(activity2, this.hf, xjVar);
    }

    public void hf() {
        if (this.et == null || this.et.get() == null) {
            return;
        }
        this.et.get().setEasyPlayableEventSender(this.f10350io.xj());
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        zg.xj(viewGroup != null || this.yo.get(), "container不能为null");
        zg.xj(list != null || this.yo.get(), "clickView不能为null");
        zg.xj(list != null && list.size() > 0, "clickViews数量必须大于等于1");
        this.p = viewGroup;
        xj(viewGroup, list, list2, null, xjVar);
    }

    private void w(boolean z) {
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(this.c, this.hf, z);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void hf(Activity activity) {
        if (activity != null) {
            this.xj.xj(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void hf(final Dialog dialog, final Integer[] numArr) {
        am amVar = this.tf;
        if (amVar != null) {
            amVar.xj(dialog, numArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.dk.u.5
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.bytedance.sdk.openadsdk.core.dislike.w.hf xl = u.this.hf != null ? u.this.hf.xl() : null;
                    if (xl != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.xj.hf.xj(xl, dialog, numArr);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        xj(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        zg.xj(viewGroup != null || this.yo.get(), "container不能为null");
        zg.xj(list != null || this.yo.get(), "clickView不能为null");
        zg.xj(list != null && list.size() > 0, "clickViews数量必须大于等于1");
        this.p = viewGroup;
        xj(viewGroup, null, list, list2, view, xjVar);
    }

    public void hf(boolean z) {
        this.g = z;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
        jk jkVar = this.xj;
        if (jkVar != null) {
            jkVar.xj(d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        zg.xj(viewGroup != null || this.yo.get(), "container不能为null");
        zg.xj(list2 != null || this.yo.get(), "clickView不能为null");
        zg.xj(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.p = viewGroup;
        xj(viewGroup, list, list2, list3, (List<View>) null, view, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        int i;
        boolean z = false;
        zg.xj(viewGroup != null || this.yo.get(), "container不能为null");
        zg.xj(list2 != null || this.yo.get(), "clickView不能为null");
        zg.xj(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.p = viewGroup;
        this.jk = xjVar;
        if (list3 != null && list3.size() > 0) {
            z = true;
        }
        w(z);
        List<View> xj = en() ? xj(list2, list3) : list3;
        if (this.yo.get() && ((i = this.c) == 5 || i == 1 || i == 9)) {
            ff();
        }
        if (!this.yo.get()) {
            jk jkVar = this.xj;
            if (jkVar != null) {
                jkVar.xj(this.ai);
                this.xj.xj(viewGroup, list, list2, xj, list4, view, xjVar, this.z);
            }
            xj(viewGroup);
        }
        c cVar = this.kd;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.xj) {
            ((com.bytedance.sdk.openadsdk.core.dislike.ui.xj) cVar).xj(this.p);
        }
    }

    private void xj(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    xj((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    private List<View> xj(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    public void xj(WeakReference<NativeVideoTsView> weakReference) {
        this.et = weakReference;
        jk jkVar = this.xj;
        if (jkVar != null) {
            jkVar.xj(weakReference);
        }
    }

    public void xj() {
        NativeVideoTsView nativeVideoTsView;
        if (this.et == null || (nativeVideoTsView = this.et.get()) == null || nativeVideoTsView.zg()) {
            return;
        }
        this.x = new UGenVideoOrImgPanelView(this.w, this.hf, nativeVideoTsView, null, this.p, wo.hf(this.c), true);
    }

    public void xj(ViewGroup viewGroup) {
        if (viewGroup != null && this.dk && com.bytedance.sdk.openadsdk.x.tf.xj(this.hf)) {
            NativeVideoTsView w = w(viewGroup);
            if (w != null) {
                if (5 == this.c) {
                    w.setIsAutoPlay(this.g ? this.d.kd() : this.am);
                    return;
                } else {
                    w.setIsAutoPlay(this.am);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.w, this.hf, false, false, wo.hf(this.c), false, false);
            if (5 == this.c) {
                nativeVideoTsView.setIsAutoPlay(this.g ? this.d.kd() : this.am);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.am);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        zg.xj(wVar, "downloadListener不能为null");
        this.xj.xj(xj.C0177xj.xj(wVar, this.hf));
        am amVar = this.tf;
        if (amVar != null) {
            amVar.xj(wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public c xj(Activity activity) {
        if (this.tf != null && this.yo.get()) {
            return this.tf.xj(activity);
        }
        if (this.kd == null) {
            w(activity);
        }
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public c xj(final Dialog dialog, Integer[] numArr) {
        if (dialog != null) {
            com.bytedance.sdk.openadsdk.core.dislike.xj.hf.xj(this.hf.xl(), dialog, numArr);
            return new c() { // from class: com.bytedance.sdk.openadsdk.core.dk.u.3
                @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
                public void hf() {
                }

                @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
                public boolean w() {
                    return false;
                }

                @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
                public void xj(com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
                public void xj(String str) {
                }

                @Override // com.bytedance.sdk.openadsdk.zg.w.hf.c
                public void xj() {
                    if (!(dialog.getContext() instanceof Activity) || ((Activity) dialog.getContext()).isFinishing()) {
                        return;
                    }
                    dialog.show();
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar) {
        this.v = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
        this.f10350io.xj(hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        am amVar;
        if (xjVar == null || activity == null || (amVar = this.tf) == null) {
            return;
        }
        amVar.xj(activity, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(String str) {
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.hf, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xj(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i == 2) {
            return "interaction";
        }
        if (i == 5) {
            return "embeded_ad";
        }
        if (i == 6) {
            return "stream";
        }
        if (i != 9) {
            return "embeded_ad";
        }
        return "draw_ad";
    }

    private am xj(ws wsVar) {
        ws wsVar2 = this.hf;
        if (wsVar2 == null || hl.xj(wsVar2) != 2) {
            return null;
        }
        boolean z = h.am(wsVar) != null;
        int i = this.c;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.w(this.w, wsVar, this.d);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.hf(this.w, wsVar, this.d);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.ht(this.w, wsVar, this.d);
        }
        if (z) {
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.ra(this.w, wsVar, this.d);
        }
        return new com.bytedance.sdk.openadsdk.core.nativeexpress.pz(this.w, wsVar, this.d);
    }

    private void xj(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.pl.w("dialog is null, please check");
        } else {
            this.u = dialog;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
        if (this.ht) {
            return;
        }
        q.xj(this.hf, d);
        this.ht = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
        if (this.ra) {
            return;
        }
        q.xj(this.hf, d, str, str2);
        this.ra = true;
    }

    public void xj(boolean z) {
        this.am = z;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        ws wsVar = this.hf;
        if (wsVar != null) {
            ht.xj(wsVar.ke(), hfVar, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        this.z = xjVar;
    }
}
