package com.bytedance.sdk.openadsdk.core.component.reward.u;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.w;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.sdk.openadsdk.core.component.reward.u.xj {

    /* renamed from: a, reason: collision with root package name */
    private int f10320a;
    private final AtomicBoolean b;
    private int en;
    private final AtomicBoolean eu;
    private int ff;
    private com.bytedance.sdk.openadsdk.core.ugeno.tf.xj hl;
    private int j;
    private int l;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.kd n;
    private final AtomicBoolean r;
    private final AtomicBoolean tj;
    private int wo;
    private final AtomicBoolean ws;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.xj yy;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.draw.hf> z;

    public interface xj {
        void hf();

        void u();

        Map<String, Object> w();

        void xj();

        void xj(int i);

        void xj(long j, long j2);
    }

    public w(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
        this.z = new ArrayList();
        this.j = 0;
        this.en = 0;
        this.l = 0;
        this.ff = 0;
        this.f10320a = 0;
        this.wo = 0;
        this.r = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.ws = new AtomicBoolean(true);
        this.eu = new AtomicBoolean(false);
        this.tj = new AtomicBoolean(true);
    }

    private void cy() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar = this.n;
        if (kdVar == null || !kdVar.wo()) {
            int u = this.z.get(this.ff).u();
            if (u > 0) {
                this.j += u;
            }
            if (vm.w(this.hf) <= this.en && !this.r.get()) {
                this.xj.u(0);
                this.xj.pl();
                this.r.set(true);
            }
            int i = this.en;
            if (i < this.j) {
                this.en = i + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.u gj() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.u) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.u) hfVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.bykv.vk.openvk.component.video.api.w.u uVar;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar = this.n;
        ws wsVar = null;
        com.bykv.vk.openvk.component.video.api.u.w a2 = kdVar != null ? kdVar.a() : null;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.hf hfVar = this.z.get(this.ff);
        if (hfVar != null) {
            wsVar = hfVar.xj();
            uVar = hfVar.tf();
        } else {
            uVar = null;
        }
        this.v.xj(wsVar, a2, uVar);
        this.v.hf(this.xj.f());
    }

    public static int hf(ws wsVar) {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne() {
        if (this.ff < this.z.size() - 1) {
            this.z.get(this.ff + 1).pl();
            this.z.get(this.ff + 1).xj(this.kd, this.y);
        }
    }

    private void vl() {
        String str;
        String B25kr62;
        if (vm.f(this.hf)) {
            int i = this.ff;
            int i2 = i + 1;
            int size = this.z.size();
            boolean z = this.ff + 1 >= this.z.size();
            boolean z2 = this.ff == 0;
            int nb = nb();
            boolean z3 = this.q.kd() - this.l < vm.qt(this.hf);
            if (this.ws.get()) {
                if (!z3) {
                    i2 = Math.min(i + 2, size);
                }
                int i3 = i2;
                String str2 = i3 + "/" + size;
                if (z3) {
                    B25kr62 = CtFAbx.B25kr6(new StringBuilder(), z2 ? CtFAbx.ASJ6gh(size, "可看", "个视频,当前 ") : "正在播放 ", str2);
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (z) {
                        str = "";
                    } else {
                        str = nb + "秒后播放 ";
                    }
                    B25kr62 = CtFAbx.B25kr6(sb, str, str2);
                }
                this.yo.xj(B25kr62, this.eu.get() ? "取消" : null, this.eu.get());
                com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar = this.hl;
                if (xjVar != null) {
                    xjVar.xj(nb, z, i3, size, true, z3, this.eu.get());
                }
            } else {
                this.yo.xj((String) null, (String) null, false);
                com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar2 = this.hl;
                if (xjVar2 != null) {
                    xjVar2.xj(0, z, 0, 0, false, false, false);
                }
            }
            if (nb == 0 && !ss()) {
                f(false);
            }
        }
        if (this.q.kd() <= vm.d(this.hf) || this.b.get() || gj() == null) {
            return;
        }
        gj().kd();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xv() {
        /*
            r9 = this;
            int r0 = r9.et()
            com.bytedance.sdk.openadsdk.core.component.reward.kd.w r1 = r9.q
            int r1 = r1.w()
            int r1 = r1 - r0
            r0 = 0
            int r1 = java.lang.Math.max(r0, r1)
            r2 = 1
            if (r1 != 0) goto L15
            r8 = 1
            goto L16
        L15:
            r8 = 0
        L16:
            com.bytedance.sdk.openadsdk.core.ra.ws r1 = r9.hf
            int r1 = com.bytedance.sdk.openadsdk.core.ra.vm.u(r1)
            com.bytedance.sdk.openadsdk.core.ra.ws r3 = r9.hf
            int r3 = com.bytedance.sdk.openadsdk.core.ra.vm.kd(r3)
            int r4 = r9.y(r0)
            com.bytedance.sdk.openadsdk.core.ra.ws r5 = r9.hf
            boolean r5 = com.bytedance.sdk.openadsdk.core.ra.vm.f(r5)
            java.lang.String r6 = "s"
            if (r5 == 0) goto L47
            if (r4 <= 0) goto L42
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            goto L44
        L42:
            java.lang.String r1 = "奖励已领取"
        L44:
            r5 = r1
            r4 = 0
            goto L77
        L47:
            java.lang.String r5 = "领取成功"
            if (r1 != 0) goto L63
            if (r4 <= 0) goto L5f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r4 = "s后可领取奖励"
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            goto L60
        L5f:
            r1 = r5
        L60:
            r5 = r1
            r4 = 1
            goto L77
        L63:
            if (r4 <= 0) goto L75
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            goto L44
        L75:
            r1 = r5
            goto L44
        L77:
            int r1 = r9.y(r2)
            r9.hf(r1)
            if (r8 == 0) goto L84
            if (r3 != 0) goto L84
            r7 = 1
            goto L85
        L84:
            r7 = 0
        L85:
            if (r8 == 0) goto L8d
            if (r3 != r2) goto L8d
            java.lang.String r1 = "跳过"
        L8b:
            r6 = r1
            goto L8f
        L8d:
            r1 = 0
            goto L8b
        L8f:
            com.bytedance.sdk.openadsdk.core.component.reward.hf.kd r3 = r9.yo
            r3.xj(r4, r5, r6, r7, r8)
            com.bytedance.sdk.openadsdk.core.ugeno.tf.xj r1 = r9.hl
            if (r1 == 0) goto Lb5
            com.bytedance.sdk.openadsdk.core.component.reward.kd.w r2 = r9.q
            long r2 = r2.xj()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            int r3 = (int) r2
            com.bytedance.sdk.openadsdk.core.component.reward.kd.w r2 = r9.q
            int r2 = r2.kd()
            com.bytedance.sdk.openadsdk.core.component.reward.kd.w r4 = r9.q
            int r4 = r4.hf()
            int r0 = r9.y(r0)
            r1.xj(r3, r2, r4, r0)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.u.w.xv():void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int b() {
        return this.en;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void dc() {
        this.ws.set(false);
        this.tj.set(false);
        wa();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void dk() {
        super.dk();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        this.jk.xj(jSONObject);
        if (!wn()) {
            pz();
        }
        this.ws.set(false);
        this.yo.xj((String) null, (String) null, false);
        com.bytedance.sdk.openadsdk.core.ugeno.tf.xj xjVar = this.hl;
        if (xjVar != null) {
            xjVar.xj(0, true, 0, 0, false, false, false);
            this.hl.xj((int) (this.q.xj() / 1000), this.q.kd(), this.q.hf(), y(false));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.yo.xj(true);
        this.yo.hf(this.hf.oz());
        this.yo.w(true);
        this.yo.kd(true);
        if (!TextUtils.isEmpty(vm.p(this.hf))) {
            this.yo.xj(false);
            com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.xj xjVar = new com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.xj(this.hf);
            this.yy = xjVar;
            xjVar.xj(new com.bytedance.sdk.component.adexpress.hf.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.w.1
                boolean xj = false;

                @Override // com.bytedance.sdk.component.adexpress.hf.c
                public void xj(final View view, final am amVar) {
                    if (this.xj) {
                        return;
                    }
                    w.this.xj.l().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.w.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w.this.xj.l().getTopFrameContainer().removeAllViews();
                            w.this.xj.l().getTopFrameContainer().addView(view);
                            w.this.yo.xj(true);
                            am amVar2 = amVar;
                            if (amVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.w) {
                                w.this.hl = ((com.bytedance.sdk.openadsdk.core.ugeno.express.w) amVar2).yo();
                                w.this.hl.xj((int) (w.this.q.xj() / 1000), w.this.q.kd(), w.this.q.hf(), w.this.y(false));
                                w.this.wa();
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.adexpress.hf.c
                public void xj(int i, String str) {
                    this.xj = true;
                    w.this.yo.xj(true);
                }
            });
            this.yy.xj(new com.bytedance.sdk.component.adexpress.hf.f() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.w.2
                @Override // com.bytedance.sdk.component.adexpress.hf.f
                public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
                }

                @Override // com.bytedance.sdk.component.adexpress.hf.f
                public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                    if (i == 3) {
                        w.this.n().tf();
                    } else if (i == 5) {
                        w.this.n().xj(!w.this.g);
                    } else {
                        if (i != 6) {
                            return;
                        }
                        w.this.n().c();
                    }
                }
            });
            this.yy.xj(new com.bytedance.sdk.openadsdk.core.ugeno.express.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.w.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.xj.hf
                public void xj() {
                    w.this.dc();
                }
            });
            this.yy.xj(vm.p(this.hf), vm.pl(this.hf), this.kd, 0, vm.g(this.hf));
        }
        wa();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean gy() {
        if (vm.zg(this.hf)) {
            return this.zg;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void ht() {
        if (this.jk.l()) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.kd) gj().hf().w(this.f10320a);
            if (kdVar != null) {
                kdVar.ai();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.w("cubic  resume exception:" + e.getMessage());
        }
    }

    public int nb() {
        return Math.max(0, (((ss() ? 1 : 0) + ((int) Math.min(Math.round(h.y(this.z.get(this.ff).xj())), vm.hf(r0)))) + this.l) - this.q.kd());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void pz() {
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.kd) gj().hf().w(this.f10320a);
            if (kdVar != null) {
                kdVar.x();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.w("cubic pause exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void qt() {
        super.qt();
        List<com.bytedance.sdk.openadsdk.core.component.reward.draw.hf> list = this.z;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.hf> it = list.iterator();
            while (it.hasNext()) {
                it.next().f();
            }
        }
        if (gj() != null) {
            gj().w().u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return this.hf.rh() == 2 || this.hf.rh() == 3 || this.hf.rh() == 7;
    }

    public boolean ss() {
        ws xj2 = this.z.get(this.ff).xj();
        return Math.round(h.y(xj2)) <= ((long) vm.hf(xj2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void wa() {
        xv();
        cy();
        vl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj, com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean wn() {
        return vm.f(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int wo() {
        return vm.w(this.hf) - this.en;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean y() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int c(boolean z) {
        return z ? wo() : vm.c(this.hf) - this.en;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        return com.bytedance.sdk.openadsdk.res.kd.tf(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void f() {
        super.f();
        this.z.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.hf(this.xj, this.hf, this.f10322pl, s(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.hf.mi());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.z.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.hf(this.xj, com.bytedance.sdk.openadsdk.core.xj.xj(jSONArray.getJSONObject(i)), this.f10322pl, s(), false));
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.hf> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().xj(this.g);
        }
        this.eu.set(vm.am(this.hf));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void kd(boolean z) {
        super.kd(z);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar = this.n;
        if (kdVar != null) {
            kdVar.w(z);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.hf> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().xj(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj, com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void w() {
        this.d.w(true);
        if (gj() != null) {
            gj().w().xj(this.z);
            gj().u().xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.w.4
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.w.xj
                public void xj() {
                    w wVar = w.this;
                    wVar.zg = true;
                    wVar.ff = 0;
                    xj((com.bytedance.sdk.openadsdk.core.component.reward.draw.kd) w.this.gj().hf().w(0));
                    w.this.h();
                    w.this.ne();
                    w.this.xj.hf(false, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.w.xj
                public void xj(boolean z, int i, boolean z2) {
                    int i2 = w.this.f10320a;
                    if (w.this.n != null) {
                        w.this.xj.wn().xj(z, i2 + 1, w.this.n.j());
                    }
                    w.this.f10320a = i;
                    w wVar = w.this;
                    wVar.wo = Math.max(wVar.wo, i + 1);
                    w wVar2 = w.this;
                    wVar2.ff = i % wVar2.z.size();
                    xj((com.bytedance.sdk.openadsdk.core.component.reward.draw.kd) w.this.gj().hf().w(i));
                    w.this.gj().y();
                    w.this.b.set(true);
                    w.this.eu.set(vm.am(w.this.hf) && w.this.ff + 1 < w.this.z.size());
                    w.this.wa();
                    w.this.ne();
                    w wVar3 = w.this;
                    wVar3.yo.xj(((com.bytedance.sdk.openadsdk.core.component.reward.draw.hf) wVar3.z.get(w.this.ff)).xj());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.w.xj
                public void xj(boolean z, int i) {
                    com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.kd) w.this.gj().hf().w(i);
                    if (kdVar != null) {
                        kdVar.hf(false);
                    }
                }

                private void xj(com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar) {
                    if (kdVar != null) {
                        w.this.n = kdVar;
                        w.this.n.hf(true);
                        w.this.n.xj(new xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.w.4.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.w.xj
                            public void hf() {
                                w wVar = w.this;
                                wVar.zg = false;
                                wVar.gj().xj(true);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.w.xj
                            public void u() {
                                if (w.this.ff + 1 >= w.this.z.size() || !w.this.ws.get()) {
                                    w.this.xj.y(1);
                                } else if (w.this.ss()) {
                                    w.this.f(false);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.w.xj
                            public Map<String, Object> w() {
                                return w.this.xj.f();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.w.xj
                            public void xj() {
                                w wVar = w.this;
                                wVar.zg = true;
                                wVar.gj().xj(false);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.w.xj
                            public void xj(int i) {
                                w.this.j += i;
                                w.this.en += i;
                                w.this.xj.p(i);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.w.xj
                            public void xj(long j, long j2) {
                                w.this.zg = false;
                            }
                        });
                        w.this.zg = kdVar.wo();
                        w.this.gj().xj(!kdVar.r());
                    } else {
                        w.this.zg = false;
                    }
                    w.this.h();
                }
            });
        }
    }

    public static boolean xj(ws wsVar) {
        return (wsVar == null || !vm.xj(wsVar) || TextUtils.isEmpty(wsVar.mi())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.u(this.xj, this.hf, z);
        float f = this.kd;
        float f2 = this.y;
        float[] fArr = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArr = v();
        }
        uVar.xj(fArr);
        this.d = uVar;
        return uVar;
    }

    public void f(boolean z) {
        if (!this.jk.l() && this.ff + 1 < this.z.size()) {
            this.l = this.q.kd();
            if ((z || this.tj.get() || vm.y(this.hf)) && gj() != null) {
                gj().hf().hf(this.f10320a + 1);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public hf.xj xj(ws wsVar, final com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        this.xj.ws();
        com.bytedance.sdk.openadsdk.core.component.reward.w.xj wVar = vm.f(wsVar) ? new com.bytedance.sdk.openadsdk.core.component.reward.w.w(this.xj, wsVar) : new com.bytedance.sdk.openadsdk.core.component.reward.w.kd(this.xj, wsVar);
        wVar.xj(r());
        return wVar.hf(new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.w.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void w() {
                super.w();
                w.this.xj.eu();
                w.this.f(true);
                w.this.xj.wn().xj("reward_retain_dialog_next", 0, "");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj() {
                super.xj();
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj();
                }
                w.this.xj.eu();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(Map<String, Object> map) {
        super.xj(map);
        map.put("group_pos", Integer.valueOf(this.f10320a + 1));
        com.bytedance.sdk.openadsdk.core.component.reward.draw.kd kdVar = this.n;
        if (kdVar != null) {
            map.put(MediationConstant.EXTRA_DURATION, Long.valueOf(kdVar.j()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
        try {
            jSONObject.put("group_pos", this.ff + 1);
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.n.j());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(View view) {
        super.xj(view);
        this.n.xj(view);
    }
}
