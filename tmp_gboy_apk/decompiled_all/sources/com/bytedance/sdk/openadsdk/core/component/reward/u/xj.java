package com.bytedance.sdk.openadsdk.core.component.reward.u;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.ai;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.CommonEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj extends hf {
    protected boolean am;
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf d;
    com.bytedance.sdk.openadsdk.core.component.reward.hf.xj dk;
    protected boolean e;
    protected com.bytedance.sdk.openadsdk.core.hf.kd f;
    protected boolean g;
    protected ws hf;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.kd ht;
    protected com.bytedance.sdk.openadsdk.core.component.reward.hf.hf jk;
    protected int kd;
    protected AbstractEndCardFrameLayout p;

    /* renamed from: pl, reason: collision with root package name */
    protected String f10322pl;
    protected com.bytedance.sdk.openadsdk.core.component.reward.hf.u pz;
    protected com.bytedance.sdk.openadsdk.core.component.reward.kd.w q;
    protected boolean qt;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.u ra;
    protected com.bytedance.sdk.openadsdk.core.component.reward.layout.kd tf;
    protected float u;
    protected com.bytedance.sdk.openadsdk.core.component.reward.hf.y v;
    protected int w;
    protected final TTBaseVideoActivity xj;
    protected int y;
    protected com.bytedance.sdk.openadsdk.core.component.reward.hf.kd yo;
    protected boolean zg;
    protected int c = -1;
    protected int et = -5;

    /* renamed from: io, reason: collision with root package name */
    protected boolean f10321io = false;
    protected boolean x = false;
    protected int ai = Integer.MIN_VALUE;
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.tf z = new com.bytedance.sdk.openadsdk.core.nativeexpress.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.xj.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void c() {
            am.xj().w(xj.this.hf, "stats_reward_full_click_express_close");
            xj.this.yo.xj();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void d() {
            xj.this.xj.qd();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void f() {
            am.xj().w(xj.this.hf, "stats_reward_full_click_express_close");
            xj.this.xj.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public long getActualPlayDuration() {
            return xj.this.v.en().yy();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public int hf() {
            if (xj.this.tf.hf()) {
                return 4;
            }
            if (xj.this.tf.w()) {
                return 5;
            }
            if (xj.this.v.u()) {
                return 1;
            }
            if (xj.this.v.hf()) {
                return 2;
            }
            xj.this.v.w();
            return 3;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void kd() {
            xj.this.f10321io = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void p() {
            xj.this.xj.f(3);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void setPauseFromExpressView(boolean z) {
            xj.this.xj.qt(1);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void tf() {
            xj.this.yo.w();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void u() {
            xj.this.f10321io = true;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public int w() {
            return xj.this.et();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void xj(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void y() {
            xj xjVar = xj.this;
            xjVar.x = true;
            xjVar.xj.bl();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void w(int i) {
            xj.this.xj.w(i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void xj(boolean z) {
            xj xjVar = xj.this;
            if (xjVar.g != z) {
                xjVar.g = z;
                xjVar.yo.hf();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void xj(int i) {
            if (i != 1) {
                if (i == 2) {
                    xj.this.v.io();
                    return;
                }
                if (i == 3) {
                    xj.this.v.x();
                    return;
                } else if (i == 4) {
                    xj.this.v.c();
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (xj.this.v.hf() || xj.this.v.w() || xj.this.v.ws()) {
                return;
            }
            xj.this.xj.hf(0L, false);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void hf(int i) {
            if (aq.kd(xj.this.hf)) {
                xj.this.xj.u(1);
            } else {
                xj.this.xj.xj(i, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public long xj() {
            xj xjVar = xj.this;
            xjVar.hf(xjVar.y(true));
            return xj.this.q.xj();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void xj(float f, float f2, float f3, float f4, int i) {
            xj.this.xj.xj(f, f2, f3, f4, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
        public void xj(float f) {
            com.bytedance.sdk.openadsdk.core.component.reward.kd.w wVar = xj.this.q;
            if (wVar != null) {
                wVar.w((int) (1000.0f / f));
            }
            xj.this.xj.dc().xj(f);
        }
    };

    public xj(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        this.xj = tTBaseVideoActivity;
        this.hf = wsVar;
        this.w = wsVar.rs();
        this.u = wsVar.yq();
    }

    private void nb() {
        this.yo.xj(false);
        this.d.y(8);
        this.d.kd(8);
        this.d.w(8);
        gh();
    }

    private int ss() {
        long max = Math.max(((long) (this.v.ai() * 1000.0d)) - this.v.z(), 0L);
        return Math.max((((int) (max / 1000)) + (((int) (max % 1000)) > 500 ? 1 : 0)) - yy(), 0);
    }

    public int a() {
        if (bl() && this.jk.r()) {
            return this.et;
        }
        if (!lw() || !aq.e(this.hf)) {
            return wo();
        }
        return (int) Math.max((ws() * (this.hf.tq() / 100.0f)) - et(), 0.0f);
    }

    public void ai() {
        this.qt = true;
    }

    public void am() {
    }

    public void aq() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.tf;
        if (kdVar != null) {
            kdVar.xj(this.q);
        }
        if (bl() && this.jk.r()) {
            x();
        } else {
            wa();
        }
    }

    public int b() {
        return (int) (this.v.z() / 1000);
    }

    public boolean c() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar;
        return y() && (kdVar = this.tf) != null && kdVar.y();
    }

    public View d() {
        int wa = this.hf.wa();
        return wa != 1 ? wa != 3 ? com.bytedance.sdk.openadsdk.res.kd.xj(this.xj) : com.bytedance.sdk.openadsdk.res.kd.u(this.xj) : com.bytedance.sdk.openadsdk.res.kd.w(this.xj);
    }

    public void dc() {
    }

    public void dk() {
        wn();
    }

    public boolean e() {
        return false;
    }

    public void en() {
    }

    public int et() {
        return this.q.hf() + this.q.kd();
    }

    public void eu() {
        if (this.e || Build.VERSION.SDK_INT == 26) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.xj;
        tTBaseVideoActivity.setTheme(jk.f(tTBaseVideoActivity, "tt_full_screen_interaction"));
        r.c((Activity) this.xj);
        this.e = true;
    }

    public void f() {
        if ((this.am || !aq.ra(this.hf)) && !(this instanceof p)) {
            return;
        }
        eu();
    }

    public int ff() {
        if (lw() && aq.e(this.hf)) {
            return et();
        }
        return yy() + b();
    }

    public AbstractEndCardFrameLayout g() {
        return this.p;
    }

    public void hf(Map<String, Object> map) {
    }

    public int hl() {
        return this.q.w();
    }

    public void ht() {
    }

    public int io() {
        return this.q.y();
    }

    public boolean j() {
        return true;
    }

    public void jk() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.tf;
        if (kdVar != null) {
            kdVar.xj(this.q);
        }
        if (this.am) {
            this.d.hf((int) (this.v.z() / 1000));
        }
    }

    public void kd() {
        this.xj.c(0);
        this.yo.xj(qd());
        float f = this.kd;
        float f2 = this.y;
        float[] fArr = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArr = v();
        }
        this.tf.xj(this.hf, ai.xj(this.xj.io() ? 7 : 8, String.valueOf(wo.d(this.hf)), fArr[0], fArr[1]), this.f10322pl, this.g, this.xj.xj());
        this.d.w(false);
        this.tf.w(true);
        this.tf.xj(this.z);
        this.tf.xj(new com.bytedance.sdk.openadsdk.core.nativeexpress.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.xj.4
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void hf(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, String str, int i) {
                if (xj.this.jk.l()) {
                    return;
                }
                xj.this.jk.xj();
                xj.this.xj.jk();
                xj.this.xj.c(8);
                xj.this.yo.xj(true);
                com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.xj.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.xj.v();
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xj
            public void xj(View view, float f3, float f4) {
                if (xj.this.jk.l()) {
                    return;
                }
                xj.this.jk.xj();
                xj.this.xj.jk();
                xj.this.xj.c(8);
                xj xjVar = xj.this;
                xjVar.c = xjVar.tf.d();
                xj xjVar2 = xj.this;
                if (xjVar2.c == 0) {
                    aq.hf(xjVar2.hf, true);
                }
                xj.this.w();
            }
        });
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.ht.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.xj.tj());
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.ra.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.xj.tj());
        this.xj.xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) this.ht.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        this.xj.xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) this.ra.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
        this.tf.xj(this.ht, this.ra);
        this.tf.f();
    }

    public com.bytedance.sdk.openadsdk.core.video.hf.hf l() {
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.nativeexpress.tf n() {
        return this.z;
    }

    public View p() {
        return com.bytedance.sdk.openadsdk.res.kd.kd(this.xj);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.kd pl() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.kd(this.xj);
        this.tf = kdVar;
        return kdVar;
    }

    public void pz() {
    }

    public int q() {
        return 0;
    }

    public void qt() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.p;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.hf();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.tf;
        if (kdVar != null) {
            kdVar.u();
        }
        if (s() || this.jk.l()) {
            return;
        }
        this.jk.ht();
    }

    public int r() {
        int i = this.ai;
        return i == Integer.MIN_VALUE ? y(true) : i;
    }

    public final int ra() {
        return this.c;
    }

    public View tf() {
        if (this.p == null) {
            this.p = new CommonEndCardFrameLayout(this.xj, this.hf);
        }
        return this.p;
    }

    public boolean tj() {
        return !this.am && aq.ra(this.hf) && this.w == 1;
    }

    public void u() {
        boolean y = this.tf.y();
        if (!this.jk.l() && !y) {
            zg();
        }
        this.jk.xj(this.tf.p());
        if (y) {
            this.tf.xj().setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        }
        this.d.w(!y);
        this.tf.w(y);
        this.yo.xj(qd() || !y);
        this.xj.y();
    }

    public float[] v() {
        TTBaseVideoActivity tTBaseVideoActivity = this.xj;
        int u = r.u(tTBaseVideoActivity, r.p((Context) tTBaseVideoActivity));
        float f = this.y;
        float f2 = this.kd;
        int i = this.w;
        if ((i == 1) != (f > f2)) {
            float f3 = f + f2;
            f2 = f3 - f2;
            f = f3 - f2;
        }
        if (i == 1) {
            f -= u;
        } else {
            f2 -= u;
        }
        return new float[]{f2, f};
    }

    public boolean vm() {
        return this.x;
    }

    public void w(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean wn() {
        return aq.e(this.hf) || this.jk.r();
    }

    public int wo() {
        return f(true);
    }

    public int ws() {
        return ht.w(this.hf) ? ht.kd(this.hf) : aq.qt(this.hf);
    }

    public void x() {
        if (this.et < 0) {
            this.et = this.jk.b();
        }
        int i = this.et;
        if (i > 0) {
            this.et = i - 1;
            this.yo.xj(false, CtFAbx.AZkASS("s", this.et, new StringBuilder()), null, true, true);
            return;
        }
        if (i == 0) {
            this.xj.u(0);
            this.yo.xj(false, "奖励已领取", null, true, true);
        }
    }

    public void xj(int i) {
    }

    public boolean y() {
        return hl.xj(this.hf) == 2;
    }

    public FrameLayout yo() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar;
        return v.u(this.hf) ? this.p.getVideoArea() : (y() && (kdVar = this.tf) != null && kdVar.y()) ? this.tf.xj() : this.d.pl();
    }

    public int yy() {
        return this.q.hf();
    }

    public boolean z() {
        return false;
    }

    public void zg() {
        this.d.zg();
    }

    public int c(boolean z) {
        return z ? f(false) : ss();
    }

    public void hf() {
        nb();
        op();
        if (lw()) {
            aq.xj(this.hf, true);
        }
        if (tu()) {
            this.jk.xj();
        }
        if (y()) {
            kd();
        } else {
            this.xj.jk();
            w();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void w() {
        u();
    }

    public void xj(int i, int i2, Intent intent) {
    }

    public int y(boolean z) {
        return (bl() && this.jk.r()) ? this.et : (lw() && aq.e(this.hf)) ? Math.max(ws() - et(), 0) : c(z);
    }

    private int f(boolean z) {
        long z2 = this.v.z();
        if (z) {
            return (int) Math.max(((int) (r1 / 1000)) + (((int) (Math.max(Math.min(aq.xj(), (long) ((this.v.ai() * 1000.0d) * (this.hf.tq() / 100.0f))) - ((yy() * 1000) + z2), 0L) % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long min = Math.min(aq.xj(), (long) (this.v.ai() * 1000.0d));
        long yy = yy() * 1000;
        long ai = (long) ((this.v.ai() % 1.0d) * 1000.0d);
        if (ai > 0) {
            z2 -= 1000 - ai;
        }
        return Math.round((min - (z2 + yy)) / 1000.0f);
    }

    public void w(int i) {
        this.q.xj(i);
    }

    public void xj(View view) {
    }

    public void xj(Map<String, Object> map) {
    }

    public void xj(JSONObject jSONObject) {
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.y yVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.u uVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.xj xjVar) {
        this.yo = kdVar;
        this.v = yVar;
        this.jk = hfVar;
        this.pz = uVar;
        this.dk = xjVar;
    }

    public void u(boolean z) {
        if (z) {
            if (this.w == 1) {
                this.d.u(0);
            }
            if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.hf)) {
                this.d.y(0);
                return;
            }
            return;
        }
        if (this.w == 1) {
            this.d.u(8);
        }
    }

    public void xj(String str, boolean z, boolean z2, com.bytedance.sdk.openadsdk.core.component.reward.kd.w wVar) {
        this.f10322pl = str;
        this.g = z;
        this.am = z2;
        this.q = wVar;
    }

    public void hf(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.tf;
        if (kdVar != null) {
            kdVar.kd();
        }
    }

    public void hf(int i) {
        this.ai = i;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.hf.kd xj() {
        return this.yo;
    }

    public final void xj(com.bytedance.sdk.openadsdk.core.hf.kd kdVar) {
        this.f = kdVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.xj;
        ws wsVar = this.hf;
        String str = this.f10322pl;
        this.ht = new com.bytedance.sdk.openadsdk.core.nativeexpress.kd(tTBaseVideoActivity, wsVar, str, wo.hf(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.kd, com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
                if (ws.kd(this.xj)) {
                    return;
                }
                super.xj(view, tfVar);
                xj.this.xj.xj(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.xj;
        ws wsVar2 = this.hf;
        String str2 = this.f10322pl;
        this.ra = new com.bytedance.sdk.openadsdk.core.nativeexpress.u(tTBaseVideoActivity2, wsVar2, str2, wo.hf(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.xj.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u, com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
            public void xj(View view, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
                if (ws.kd(this.xj)) {
                    return;
                }
                super.xj(view, tfVar);
                com.bytedance.sdk.openadsdk.core.hf.xj.hf hfVar = (com.bytedance.sdk.openadsdk.core.hf.xj.hf) this.f.xj(com.bytedance.sdk.openadsdk.core.hf.xj.hf.class);
                if (hfVar == null || !hfVar.hf(view)) {
                    return;
                }
                xj.this.xj.xj(2);
            }
        };
        this.p.setClickListener(this.f);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.w wVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.w(this.xj, this.hf, z);
        this.d = wVar;
        return wVar;
    }

    public void xj(int i, int i2) {
        this.kd = i;
        this.y = i2;
    }

    public void kd(boolean z) {
        this.g = z;
        this.v.w(z);
    }

    public hf.xj xj(ws wsVar, final com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.w.w wVar = new com.bytedance.sdk.openadsdk.core.component.reward.w.w(this.xj, wsVar);
        wVar.xj(r());
        wVar.hf(ff());
        wVar.w(this.xj.j());
        wVar.u(this.xj.en());
        wVar.w(this.f10321io);
        wVar.u(aq.io(wsVar) && !this.xj.c.get());
        this.xj.ws();
        return wVar.hf(new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.xj.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void w() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj();
                }
                xj.this.xj.eu();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj(int i) {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj(i);
                }
            }
        });
    }
}
