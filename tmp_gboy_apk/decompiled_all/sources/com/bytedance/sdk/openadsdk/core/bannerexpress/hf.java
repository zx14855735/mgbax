package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.a.q;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.hf.xj.w.w;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hf;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kd;
import com.bytedance.sdk.openadsdk.core.nativeexpress.u;
import com.bytedance.sdk.openadsdk.core.pl.f;
import com.bytedance.sdk.openadsdk.core.pl.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.x.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends com.bytedance.sdk.openadsdk.core.nativeexpress.hf implements ai.xj {
    private com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj am;
    protected WeakReference<BannerExpressBackupView> c;
    private kd dk;
    private u et;
    private int g;
    protected final Context hf;

    /* renamed from: io, reason: collision with root package name */
    private NativeExpressView f10295io;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.xj kd;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private ai f10296pl;
    private volatile View ra;
    private com.bytedance.sdk.openadsdk.core.pl.hf.w tf;
    protected com.bytedance.sdk.openadsdk.zg.w.w.hf u;
    protected ws w;
    private boolean x;
    protected xj xj;
    protected com.bytedance.sdk.openadsdk.core.pl.hf.xj y;
    private String qt = "banner_ad";
    private final Queue<Long> zg = new LinkedList();
    private Double e = null;
    private boolean yo = false;
    private boolean v = false;
    private AtomicBoolean jk = new AtomicBoolean(false);
    private AtomicBoolean pz = new AtomicBoolean(false);
    private AtomicBoolean ht = new AtomicBoolean(false);

    public hf(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.x = false;
        this.hf = context;
        this.w = wsVar;
        this.u = hfVar;
        this.x = pz.hf().ee() || pz.hf().ap();
        xj(context, wsVar, hfVar);
        xj(this.xj.getCurView(), this.w, false);
    }

    private void zg() {
        tj tjVar = new tj();
        tjVar.y = 2;
        pz.xj().xj(this.u, tjVar, 1, new com.bytedance.sdk.openadsdk.core.xj.xj(new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.hf.6
            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
                hf.this.am();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
            public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(xjVar.hf());
                if (copyOnWriteArrayList.isEmpty()) {
                    hf.this.am();
                    return;
                }
                ws wsVar = (ws) copyOnWriteArrayList.get(0);
                hf hfVar2 = hf.this;
                hfVar2.xj.xj(wsVar, hfVar2.u);
                hf.this.xj(wsVar);
                hf.this.xj.w();
            }
        }));
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        ai aiVar;
        if (this.ra == null || !this.ra.isShown() || (aiVar = this.f10296pl) == null) {
            return;
        }
        aiVar.removeCallbacksAndMessages(null);
        this.f10296pl.sendEmptyMessageDelayed(112201, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.w.vw() == 4) {
            c.xj(new d("banner_express_register_download") { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    if (hf.this.w.vw() == 4) {
                        hf hfVar = hf.this;
                        hfVar.tf = f.xj(hfVar.hf, hfVar.w, hfVar.qt, false);
                        hf.this.tf.xj();
                        hf hfVar2 = hf.this;
                        if (hfVar2.hf instanceof Activity) {
                            hfVar2.tf.xj((Activity) hf.this.hf);
                        }
                        if (hf.this.dk != null) {
                            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) hf.this.dk.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(hf.this.tf);
                        }
                        if (hf.this.et != null) {
                            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) hf.this.et.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(hf.this.tf);
                        }
                        hf hfVar3 = hf.this;
                        hfVar3.xj(hfVar3.tf, hf.this.f10295io);
                        hf.this.tf.xj(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        ai aiVar = this.f10296pl;
        if (aiVar != null) {
            aiVar.removeCallbacksAndMessages(null);
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
    public void kd() {
        super.kd();
        xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.u();
        }
        ai aiVar = this.f10296pl;
        if (aiVar != null) {
            aiVar.removeCallbacksAndMessages(null);
            this.f10296pl = null;
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
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.p;
        if (xjVar != null) {
            xjVar.xj(this.xj);
        }
        this.xj.kd();
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.w).xj(1);
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
        this.w.xl().hf(this.qt);
        return new com.bytedance.sdk.openadsdk.core.dislike.w.xj(this.w.xl());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int hf() {
        ws wsVar = this.w;
        if (wsVar == null) {
            return -1;
        }
        return wsVar.rx();
    }

    private void hf(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        if (this.p == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.xj(activity, this.w.xl(), this.qt, false);
            this.p = xjVar2;
            com.bytedance.sdk.openadsdk.core.dislike.w.xj(activity, this.w, xjVar2);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar3 = this.p;
        if (xjVar3 != null) {
            xjVar3.xj(this.xj);
        }
        this.p.xj(xjVar);
        xj xjVar4 = this.xj;
        if (xjVar4 == null || xjVar4.getCurView() == null) {
            return;
        }
        this.xj.getCurView().setDislike(this.p);
    }

    public void xj(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (context == null) {
            return;
        }
        this.xj = new xj(context, wsVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public View xj() {
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.w).xj(1);
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.xj xj = com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj(hfVar);
        this.kd = xj;
        this.xj.setExpressInteractionListener(xj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(ws wsVar) {
        Queue<Long> queue = this.zg;
        if (queue == null || queue.size() <= 0 || wsVar == null) {
            return;
        }
        try {
            long longValue = this.zg.poll().longValue();
            if (longValue > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis() - longValue);
                com.bytedance.sdk.openadsdk.core.am.u.xj(sb.toString(), wsVar, this.qt, 21);
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.xj xj = com.bytedance.sdk.openadsdk.core.nativeexpress.xj.xj(xjVar);
        this.kd = xj;
        this.xj.setExpressInteractionListener(xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        com.bytedance.sdk.openadsdk.core.pl.hf.xj xj = xj.C0177xj.xj(wVar);
        this.y = xj;
        hf.xj xjVar = this.f;
        if (xjVar != null) {
            xjVar.xj(xj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
        this.e = d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        if (xjVar == null || activity == null) {
            return;
        }
        this.am = xjVar;
        hf(activity, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(String str) {
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf
    public void xj(Dialog dialog) {
        if (dialog == null) {
            pl.w("dialog is null, please check");
            return;
        }
        xj xjVar = this.xj;
        if (xjVar == null || xjVar.getCurView() == null) {
            return;
        }
        this.xj.getCurView().setOuterDislike(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        if (this.p == null) {
            hf(activity, (com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj) null);
        }
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ws wsVar) {
        if (this.xj.getNextView() == null || !this.xj.hf()) {
            return;
        }
        xj(this.xj.getNextView(), wsVar.xl());
        this.ht.set(false);
        xj(this.xj.getNextView(), wsVar, true);
    }

    private void xj(NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        if (this.am != null) {
            this.p.xj(hfVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.p);
            }
        }
        if (this.d != null) {
            xj(hfVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.d);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void xj(final NativeExpressView nativeExpressView, final ws wsVar, boolean z) {
        final EmptyView emptyView;
        if (nativeExpressView == null || wsVar == null) {
            return;
        }
        this.f10295io = nativeExpressView;
        ws wsVar2 = this.w;
        if (wsVar2 != null) {
            ff.hf(wsVar2.kd());
        }
        this.w = wsVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.hf.w() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.hf.2
            @Override // com.bytedance.sdk.component.adexpress.hf.w
            public boolean xj(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).v();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    hf hfVar = hf.this;
                    bannerExpressBackupView.xj(hfVar.w, (NativeExpressView) viewGroup, hfVar.tf);
                    bannerExpressBackupView.setDislikeInner(hf.this.p);
                    bannerExpressBackupView.setDislikeOuter(((com.bytedance.sdk.openadsdk.core.nativeexpress.hf) hf.this).d);
                    hf hfVar2 = hf.this;
                    if (hfVar2.w != null) {
                        hfVar2.xj(wsVar.xl());
                    }
                    hf.this.c = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar);
        EmptyView xj = xj(nativeExpressView);
        if (xj == null) {
            EmptyView emptyView2 = new EmptyView(this.hf, nativeExpressView, wsVar.cm());
            emptyView2.xj(this.w, this.qt);
            nativeExpressView.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = xj;
        }
        this.ra = emptyView;
        emptyView.setCallback(new EmptyView.xj() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.hf.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void hf() {
                if (hf.this.tf != null) {
                    hf.this.tf.hf();
                }
                hf.this.hf(wsVar);
                hf.this.jk.set(false);
                hf.this.pz.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(boolean z2) {
                String unused = hf.this.qt;
                if (hf.this.tf != null) {
                    if (z2) {
                        hf.this.tf.xj();
                    } else {
                        com.bytedance.sdk.openadsdk.core.pl.hf.w unused2 = hf.this.tf;
                    }
                }
                if (z2) {
                    hf.this.am();
                } else {
                    hf.this.qt();
                }
                hf.this.xj(z2, wsVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj() {
                hf.this.g();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(View view, Map<String, Object> map) {
                if (hf.this.zg != null) {
                    hf.this.zg.offer(Long.valueOf(System.currentTimeMillis()));
                }
                Map xj2 = hf.this.xj(nativeExpressView, wsVar);
                if (map != null && map.containsKey("show_send_type")) {
                    xj2.put("show_send_type", map.get("show_send_type"));
                }
                xj2.put("is_repeat", Boolean.valueOf(hf.this.ht.get()));
                hf.this.jk.set(true);
                if (!hf.this.pz.get()) {
                    hf.this.pz.set(true);
                    com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, hf.this.qt, (Map<String, Object>) xj2, hf.this.e);
                    com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
                    ws wsVar3 = wsVar;
                    ff.xj(wsVar3 != null ? wsVar3.kd() : 0);
                }
                boolean db = pz.hf().db();
                hf hfVar = hf.this;
                if (hfVar.kd != null && (!hfVar.ht.getAndSet(true) || db)) {
                    hf.this.kd.hf(view, wsVar.vw());
                }
                hf.this.am();
                xj xjVar = hf.this.xj;
                if (xjVar == null || xjVar.getCurView() == null) {
                    return;
                }
                hf.this.xj.getCurView().yo();
                hf.this.xj.getCurView().zg();
            }
        });
        kd kdVar = new kd(this.hf, wsVar, this.qt, 2);
        this.dk = kdVar;
        final com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w.w) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class);
        wVar.xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.hf.4
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.w.xj
            public boolean xj() {
                wVar.xj(emptyView);
                wVar.xj(hf.this.xj(nativeExpressView, wsVar));
                wVar.xj(hf.this.qt);
                wVar.xj(hf.this.e);
                return hf.this.jk.get();
            }
        });
        this.dk.xj(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.dk.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this);
        nativeExpressView.setClickListener(this.dk);
        u uVar = new u(this.hf, wsVar, this.qt, 2);
        this.et = uVar;
        final com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar2 = (com.bytedance.sdk.openadsdk.core.hf.xj.w.w) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class);
        wVar2.xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.hf.5
            @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.w.xj
            public boolean xj() {
                wVar2.xj(emptyView);
                wVar2.xj(hf.this.xj(nativeExpressView, wsVar));
                wVar2.xj(hf.this.qt);
                wVar2.xj(hf.this.e);
                return hf.this.jk.get();
            }
        });
        this.et.xj(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) this.et.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this);
        nativeExpressView.setClickCreativeListener(this.et);
        if (!this.x) {
            emptyView.setNeedCheckingShow(true);
        }
        if (z) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> xj(NativeExpressView nativeExpressView, ws wsVar) {
        HashMap hashMap = new HashMap();
        com.bytedance.sdk.openadsdk.core.nativeexpress.dk.xj(hashMap, this.w, nativeExpressView);
        return hashMap;
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
        hf.xj xjVar = new hf.xj(this.y, str);
        this.f = xjVar;
        wVar.xj(xjVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z, ws wsVar) {
        Queue<Long> queue = this.zg;
        if (queue == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(System.currentTimeMillis()));
            } else if (queue.size() > 0) {
                long longValue = this.zg.poll().longValue();
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis() - longValue);
                com.bytedance.sdk.openadsdk.core.am.u.xj(sb.toString(), wsVar, this.qt, 1);
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private EmptyView xj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(int i) {
        if (i <= 0) {
            return;
        }
        this.qt = "slide_banner_ad";
        xj(this.xj.getCurView(), this.w, false);
        this.xj.setDuration(1000);
        if (i < 30000) {
            i = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        } else if (i > 120000) {
            i = 120000;
        }
        this.g = i;
        this.f10296pl = new ai(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what == 112201 && this.ra != null && this.ra.isShown()) {
            zg();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
        if (this.yo) {
            return;
        }
        q.xj(this.w, d);
        this.yo = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
        if (this.v) {
            return;
        }
        q.xj(this.w, d, str, str2);
        this.v = true;
    }
}
