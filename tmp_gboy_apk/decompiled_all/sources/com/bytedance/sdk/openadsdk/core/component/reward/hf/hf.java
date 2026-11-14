package com.bytedance.sdk.openadsdk.core.component.reward.hf;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.u.d;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj am;
    private AbstractEndCardFrameLayout c;
    private com.bytedance.sdk.openadsdk.core.component.reward.hf.xj d;
    private kd f;
    private final com.bytedance.sdk.openadsdk.core.component.reward.view.xj g;
    private ws hf;
    private boolean ht;
    private int kd;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.w f10310pl;
    private boolean qt;
    private com.bytedance.sdk.openadsdk.core.hf.hf tf;
    private boolean u;
    private String w;
    private final TTBaseVideoActivity xj;
    private int y;
    private int zg = -1;
    private boolean e = false;
    private final AtomicBoolean yo = new AtomicBoolean(false);
    private final AtomicBoolean v = new AtomicBoolean(false);
    private int pz = 0;
    private boolean jk = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf$hf, reason: collision with other inner class name */
    public interface InterfaceC0144hf {
        void hf();

        kd w();

        void xj();
    }

    public interface xj {
        void xj();
    }

    public hf(TTBaseVideoActivity tTBaseVideoActivity) {
        this.xj = tTBaseVideoActivity;
        this.g = new com.bytedance.sdk.openadsdk.core.component.reward.view.xj(tTBaseVideoActivity);
    }

    private void eu() {
        try {
            if (!x.xj(this.hf) || this.ht) {
                return;
            }
            float[] xj2 = com.bytedance.sdk.openadsdk.core.component.reward.kd.hf.xj(this.xj.getApplicationContext(), this.hf.yq(), this.hf.rs());
            float f = xj2[0];
            float f2 = xj2[1];
            if (this.hf.yq() == 100.0f) {
                this.kd = (int) f;
                this.y = (int) f2;
                return;
            }
            int[] xj3 = com.bytedance.sdk.openadsdk.core.component.reward.kd.hf.xj(this.xj.getApplicationContext(), this.hf.yq(), this.hf.eq(), this.hf.rs());
            int i = xj3[0];
            int i2 = xj3[1];
            int i3 = xj3[2];
            int i4 = xj3[3];
            float f3 = i;
            float f4 = i3;
            this.kd = (int) ((f - f3) - f4);
            float f5 = i2;
            float f6 = i4;
            this.y = (int) ((f2 - f5) - f6);
            this.xj.getWindow().getDecorView().setPadding(r.w(this.xj, f3), r.w(this.xj, f5), r.w(this.xj, f4), r.w(this.xj, f6));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        if (this.xj.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.xj);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.xj);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(r.w(this.xj, 20.0f), r.w(this.xj, 12.0f), r.w(this.xj, 20.0f), r.w(this.xj, 12.0f));
        TextView textView = new TextView(this.xj);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.xj.wo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.5
            @Override // java.lang.Runnable
            public void run() {
                hf.this.ws();
            }
        }, 6000L);
    }

    public String a() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        return xjVar != null ? xjVar.dk() : "endcard";
    }

    public boolean ai() {
        return this.am instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.w;
    }

    public boolean am() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            return xjVar.c();
        }
        return false;
    }

    public int b() {
        return this.pz;
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.zg();
        }
    }

    public int d() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            return xjVar.tf();
        }
        return 0;
    }

    public void dk() {
        w(true);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar == null || !wVar.w()) {
            kd(false);
        } else {
            this.f10310pl.xj(this.xj.aq() instanceof d ? 2 : 0);
        }
        if (this.p != null) {
            this.am = this.f10310pl;
        }
    }

    public boolean e() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            return xjVar.hf();
        }
        return false;
    }

    public boolean en() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            return wVar.en();
        }
        return false;
    }

    public boolean et() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        return wVar != null && wVar.w();
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.io();
        }
    }

    public void ff() {
        this.g.w();
    }

    public void g() {
        if (!this.xj.aq().wn()) {
            ra();
        }
        this.f.w(false);
        this.f.y(false);
        this.f.hf(this.hf.oz());
        this.f.c(false);
        this.f.kd(!(this.am instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf));
        eu();
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.kd();
            this.am.xj(1);
        }
    }

    public void ht() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar != null) {
            hfVar.d();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.d();
        }
    }

    public j io() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    public void j() {
        xj(1000L);
    }

    public boolean jk() {
        if (this.e) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        return xjVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.w ? this.f10310pl.z() : xjVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf;
    }

    public boolean l() {
        return this.yo.get();
    }

    public void p() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.e();
        }
    }

    public void pl() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.v();
        }
    }

    public void pz() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar != null) {
            this.am = hfVar;
        }
    }

    public boolean q() {
        return this.qt;
    }

    public void qt() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.f();
        }
    }

    public boolean r() {
        return l() && this.v.get();
    }

    public void ra() {
        if (ht.w(this.hf) || r()) {
            return;
        }
        this.zg = Math.max(xj(this.hf), 0);
        xj(0L);
    }

    public String tf() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        return xjVar != null ? xjVar.p() : "";
    }

    public boolean v() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            return xjVar.u();
        }
        return false;
    }

    public void wo() {
        this.pz = aq.hf(this.hf, this.xj.aq().a());
        this.v.set(aq.pz(this.hf));
        com.bytedance.sdk.openadsdk.core.f.u.w = true;
    }

    public void x() {
        w(false);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.y();
        }
        if (this.e) {
            ff();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar != null) {
            this.am = hfVar;
        }
    }

    public boolean yo() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            return xjVar.w();
        }
        return false;
    }

    public boolean z() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar == null) {
            return false;
        }
        return hfVar.pz();
    }

    public boolean zg() {
        boolean e = h.tf(this.hf) ? e() : yo();
        if (v()) {
            return e || ht.hf(this.hf);
        }
        return false;
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.pl();
        }
    }

    public void kd() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.yo();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar2 = this.am;
        if (xjVar2 != null) {
            xjVar2.am();
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.g();
        }
    }

    public void w() {
        if (r()) {
            return;
        }
        int i = this.zg;
        if (i >= 0) {
            this.xj.hf(i);
            xj(0L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.et();
        }
    }

    public void xj(kd kdVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.xj xjVar, boolean z, String str, int i, int i2) {
        this.u = z;
        this.f = kdVar;
        this.d = xjVar;
        this.w = str;
        this.kd = i;
        this.y = i2;
    }

    public void y() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar != null) {
            hfVar.qt();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.qt();
        }
    }

    public void hf(boolean z) {
        if (this.zg >= 0) {
            this.xj.qt();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.u(z);
        }
    }

    public void u(boolean z) {
        this.yo.set(z);
    }

    public void kd(boolean z) {
        if (l() || q()) {
            this.e = true;
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
            if (xjVar != null) {
                xjVar.jk();
                this.am.y();
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
            if (wVar != null) {
                wVar.ra();
            }
            kd kdVar = this.f;
            if (kdVar != null) {
                kdVar.c();
            }
            if (this.f != null && this.hf.g()) {
                r.xj(this.f.u(), 0);
            }
            am.xj().y(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.3
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    com.bytedance.sdk.openadsdk.core.ht.xj.hf y = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(hf.this.u ? 7 : 8).w(String.valueOf(wo.d(hf.this.hf))).y(wo.g(hf.this.hf));
                    y.hf(hf.this.d()).c(hf.this.tf());
                    y.f(hf.this.hf.jf()).u(hf.this.hf.ho());
                    return y;
                }
            });
            this.g.xj();
            if (v.xj(this.hf)) {
                this.xj.pl(8);
            }
            this.f.xj(true);
            this.f.c(false);
            this.xj.wo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.4
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.f.xj(true);
                    if (hf.this.f.kd()) {
                        return;
                    }
                    hf.this.f.xj(false, null, null, true, true);
                    if (hf.this.en() && hf.this.u) {
                        hf.this.ws();
                    }
                }
            }, 500L);
            if (z) {
                if (!aq.e(this.hf)) {
                    this.f.xj(false, null, null, true, true);
                }
                this.f.kd(false);
                this.f.hf(this.hf.oz());
            }
        }
    }

    public void y(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.kd(z);
        }
    }

    public void hf(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.hf(i, i2);
        }
    }

    public void w(boolean z) {
        this.qt = z;
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.y(z);
        }
    }

    public void xj(ws wsVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.jk) {
            return;
        }
        this.jk = true;
        this.hf = wsVar;
        this.tf = hfVar;
        this.g.xj(wsVar);
        this.c = abstractEndCardFrameLayout;
        xj(abstractEndCardFrameLayout);
        xj(xjVar);
        this.ht = com.bytedance.sdk.openadsdk.core.zg.u.xj(String.valueOf(wo.d(this.hf)));
    }

    public void xj(AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.hf.io() == 1) {
            return;
        }
        if (ht.hf(this.hf)) {
            this.f10310pl = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.w(this.xj, this.hf, this.w, this.kd, this.y, this.u, this.c);
        }
        if (!TextUtils.isEmpty(h.xj(this.hf))) {
            this.p = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf(this.xj, this.hf, this.w, this.kd, this.y, this.u, this.c);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.f10310pl;
        if (xjVar == null) {
            xjVar = this.p;
        }
        this.am = xjVar;
    }

    public void xj(long j, long j2, int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.xj(j, j2, i);
        }
    }

    public void xj(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.xj(i, i2);
        }
    }

    public void xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.hf(z);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar) {
        Map<String, Object> tj = this.xj.tj();
        this.g.xj(this.tf);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.xj(xjVar);
            this.f10310pl.xj(this.u, tj, this.f.u());
            this.f10310pl.xj(this.d.c(), this.tf);
            this.f10310pl.xj(new xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.xj
                public void xj() {
                    hf.this.kd(false);
                }
            });
            this.f10310pl.xj(new InterfaceC0144hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.InterfaceC0144hf
                public void hf() {
                    hf.this.xj.pl();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.InterfaceC0144hf
                public kd w() {
                    return hf.this.f;
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.InterfaceC0144hf
                public void xj() {
                    hf.this.xj.hf(true, true);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar != null) {
            hfVar.xj(this.u, tj, this.f.u());
            this.p.xj(this.d.c(), this.tf);
        }
    }

    public void xj() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
        if (wVar != null) {
            wVar.x();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar != null) {
            hfVar.ai();
        }
    }

    public void xj(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.xj(map);
        }
    }

    public void xj(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.xj(z, i, str);
        }
    }

    private int xj(ws wsVar) {
        return wsVar.uo();
    }

    private void xj(long j) {
        int i = this.zg / 1000;
        if (!aq.e(this.hf)) {
            if (i > 0) {
                this.f.xj(false, i + "s", null, false, false);
            } else {
                this.f.xj(false, null, null, true, true);
            }
        }
        if (i > 0) {
            this.zg = (int) (this.zg - j);
            this.xj.xj(j);
        }
    }

    public void xj(ws wsVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        this.hf = wsVar;
        this.tf = hfVar;
        this.g.xj(wsVar);
        this.g.xj(this.tf);
        if (ht.hf(wsVar)) {
            if (this.f10310pl == null) {
                this.f10310pl = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.w(this.xj, wsVar, this.w, this.kd, this.y, this.u, this.c);
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.w wVar = this.f10310pl;
            this.am = wVar;
            wVar.xj(new xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.xj
                public void xj() {
                    hf.this.kd(false);
                }
            });
            this.f10310pl.xj(new InterfaceC0144hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.7
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.InterfaceC0144hf
                public void hf() {
                    hf.this.xj.pl();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.InterfaceC0144hf
                public kd w() {
                    return hf.this.f;
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.InterfaceC0144hf
                public void xj() {
                    hf.this.xj.hf(true, true);
                }
            });
        } else {
            this.am = this.p;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
            if (xjVar != null) {
                xjVar.xj(this.hf);
                this.am.xj(this.u, this.xj.tj(), this.f.u());
                this.am.xj(this.d.c(), this.tf);
                xj();
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(final String str) {
        this.xj.wo().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.hf.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                hf.this.g.xj(str);
            }
        });
    }

    public void xj(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xj xjVar = this.am;
        if (xjVar != null) {
            xjVar.xj(jSONObject);
        }
    }

    public void xj(com.bytedance.sdk.component.adexpress.hf.am amVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.hf hfVar = this.p;
        if (hfVar == null) {
            return;
        }
        hfVar.xj(amVar);
    }
}
