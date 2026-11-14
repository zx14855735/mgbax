package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.msdk.api.u.zg;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends hf implements com.bytedance.msdk.xj.hf.kd {
    private com.bytedance.msdk.api.u.xj.d.w e;
    private boolean hf;
    private com.bytedance.msdk.api.u.xj.d.u v;
    private boolean xj;
    private com.bytedance.msdk.api.u.xj.d.hf yo;
    private View zg;

    public g(Context context) {
        super(context);
        this.xj = false;
        this.hf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        List<com.bytedance.msdk.core.kd.hf.c> xj;
        com.bytedance.msdk.hf.w wVar;
        com.bytedance.msdk.kd.y.xj(this.y);
        List<com.bytedance.msdk.core.tf.tf> list = null;
        if (this.f10153pl) {
            com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.y, 0);
            w(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
            return;
        }
        int hf = hf.hf(this.kd);
        if (hf != 0) {
            com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.y, hf);
            w(new com.bytedance.msdk.api.xj(hf, com.bytedance.msdk.api.xj.xj(hf)));
            return;
        }
        List<com.bytedance.msdk.hf.w> jk = this.w.jk();
        if (viewGroup == null) {
            com.bytedance.msdk.kd.y.xj(jk, this.y, 0);
            w(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
            return;
        }
        try {
            list = hf();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        if (list != null && list.size() > 0) {
            HashMap<String, com.bytedance.msdk.hf.w> hf2 = hf(jk);
            for (com.bytedance.msdk.core.tf.tf tfVar : list) {
                if (tfVar != null) {
                    String yo = tfVar.yo();
                    com.bytedance.msdk.hf.w wVar2 = hf2.get(yo);
                    if (wVar2 != null && wVar2.ff(this.kd) && !wVar2.tu()) {
                        xj(wVar2, viewGroup);
                    } else if (tfVar.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, yo, v()) && com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, this.y, false) == 3 && (xj = com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, this.y, v())) != null && xj.size() > 0 && (wVar = xj.get(0).xj) != null && wVar.ff(this.kd) && !wVar.tu()) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd, "show") + "adSlotId：" + wVar.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar.gj()) + ",isReady()：" + wVar.ff(this.kd));
                        hf(wVar);
                        xj(wVar, viewGroup);
                    }
                    z = true;
                    z2 = true;
                    break;
                }
            }
        }
        z = false;
        z2 = false;
        if (!z && jk != null && jk.size() > 0) {
            Iterator<com.bytedance.msdk.hf.w> it = jk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.msdk.hf.w next = it.next();
                if (next != null && next.ff(this.kd) && !next.tu()) {
                    xj(next, viewGroup);
                    z2 = true;
                    break;
                }
            }
        }
        if (!z2) {
            com.bytedance.msdk.kd.y.xj(jk, this.y, 0);
            w(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
            return;
        }
        this.f10153pl = true;
        if (this.u != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.u);
            xj(arrayList);
        }
        com.bytedance.msdk.kd.y.xj(this.u, this.y, false, 0);
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void c() {
        com.bytedance.msdk.api.u.xj.d.w wVar = this.e;
        if (wVar != null) {
            wVar.xj();
        }
    }

    public void dk() {
        this.hf = true;
    }

    @Override // com.bytedance.msdk.xj.hf.kd
    public Activity getActivity() {
        com.bytedance.msdk.api.u.xj.d.u uVar = this.v;
        if (uVar != null) {
            return uVar.getActivity();
        }
        return null;
    }

    public View ht() {
        SoftReference<Context> softReference = this.f;
        Context context = softReference != null ? softReference.get() : null;
        if (this.zg == null && context != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            hf(frameLayout);
            this.zg = frameLayout;
            xj(this.u);
        }
        return this.zg;
    }

    @Override // com.bytedance.msdk.xj.hf.kd
    public void k_() {
        com.bytedance.msdk.api.u.xj.d.u uVar = this.v;
        if (uVar != null) {
            uVar.xj();
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.d.hf
    public void kd() {
        String str;
        long j;
        com.bytedance.msdk.api.u.xj.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.kd();
        }
        com.bytedance.msdk.core.f.g.xj().c(this.kd);
        if (this.u != null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd, "show_listen") + "adSlotId：" + this.u.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(this.u.gj()));
            com.bytedance.msdk.core.f.p.xj().hf(this.kd, this.u.cy());
        }
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            com.bytedance.msdk.core.w.w.xj(wVar.gh(), this.kd, this.u.cy());
        }
        ra();
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.u)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        com.bytedance.msdk.kd.y.xj(this.u, this.y, 0, str, j, false);
        com.bytedance.msdk.core.hf.xj.c(this.y.ra());
        com.bytedance.msdk.core.hf.xj.w(this.y.ra());
        com.bytedance.msdk.core.d.u.xj(1, this.y.ra(), this.u.ci(), this.u.da());
        com.bytedance.msdk.core.c.w.xj(this.kd, this.u);
    }

    @Override // com.bytedance.msdk.xj.hf.kd
    public void l_() {
        com.bytedance.msdk.api.u.xj.d.u uVar = this.v;
        if (uVar != null) {
            uVar.hf();
        }
    }

    public boolean pz() {
        List<com.bytedance.msdk.core.tf.tf> list;
        try {
            list = hf();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            list = null;
        }
        return am.xj(this.w.c(), this.w.tf(), this.w.f(), this.y, this.f10153pl, this.kd, this.y.kd(), list);
    }

    public void ra() {
        if (this.u.my() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, this.u.cy(), v())) {
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(this.u.cy(), this.y, this.w.q(), true, this.w.z(), this.w.ff(), this.f.get());
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.d.hf
    public void u() {
        String str;
        long j;
        com.bytedance.msdk.api.u.xj.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.u();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.u)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        String str2 = str;
        long j2 = j;
        com.bytedance.msdk.core.hf.xj.kd(this.y.ra());
        com.bytedance.msdk.hf.w wVar = this.u;
        com.bytedance.msdk.kd.y.hf(wVar, this.y, 0, str2, j2, wVar.en());
    }

    @Override // com.bytedance.msdk.xj.hf.kd
    public void w() {
        com.bytedance.msdk.api.u.xj.d.u uVar = this.v;
        if (uVar != null) {
            uVar.w();
        }
    }

    public View y() {
        return null;
    }

    private void w(final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.g.3
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.yo != null) {
                    g.this.yo.xj(xjVar);
                }
            }
        });
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.p pVar, com.bytedance.msdk.api.u.xj.d.w wVar) {
        xj(hfVar);
        this.w.xj(pVar);
        this.e = wVar;
        this.d = this;
        this.w.q().put("ad_load_timeout", Integer.valueOf(hfVar.e()));
        if (com.bytedance.msdk.core.hf.hf().ai()) {
            com.bytedance.msdk.api.u.tf.xj(new zg() { // from class: com.bytedance.msdk.w.u.g.1
                @Override // com.bytedance.msdk.api.u.zg
                public void xj() {
                    g.this.d();
                }
            });
        } else {
            d();
        }
    }

    public void xj(com.bytedance.msdk.api.u.xj.d.hf hfVar) {
        this.yo = hfVar;
    }

    public void xj(com.bytedance.msdk.api.u.xj.d.u uVar) {
        this.v = uVar;
    }

    public void xj(final ViewGroup viewGroup) {
        final String[] strArr = new String[1];
        final boolean j = com.bytedance.msdk.core.hf.hf().j();
        if (j) {
            strArr[0] = v.xj();
        }
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.hf(viewGroup);
                if (j) {
                    g gVar = g.this;
                    com.bytedance.msdk.kd.y.xj(gVar.u, gVar.y, strArr[0], 2);
                }
            }
        });
    }

    private void xj(com.bytedance.msdk.hf.w wVar, ViewGroup viewGroup) {
        this.u = wVar;
        if (this.hf) {
            wVar.wx();
        }
        com.bytedance.msdk.api.u.xj.hf hfVar = this.g;
        if (hfVar != null) {
            this.u.xj(hfVar);
        }
        com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar2 = this.am;
        if (hfVar2 != null) {
            this.u.xj(hfVar2);
        }
        this.w.xj(this.u);
        this.u.kd(true);
        this.u.xj(this.d);
        if (this.u.my() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, this.u.cy(), v())) {
            com.bytedance.msdk.hf.w wVar2 = this.u;
            com.bytedance.msdk.w.f.y.xj(wVar2, this.kd, wVar2.cy());
        }
        com.bytedance.msdk.core.kd.xj.xj.xj().xj(this.w.jk(), this.kd, this.y, v(), this.u);
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd, "show") + "展示的广告类型：" + com.bytedance.msdk.hf.xj.xj(this.u.gj()) + ",slotId：" + this.u.cy() + ",slotType:" + this.u.qi());
        com.bytedance.msdk.core.f.g xj = com.bytedance.msdk.core.f.g.xj();
        StringBuilder sb = new StringBuilder();
        sb.append(this.kd);
        xj.hf(sb.toString());
        com.bytedance.msdk.core.f.pl.xj().hf(this.kd, this.u.cy());
        this.u.xj(viewGroup);
    }

    @Override // com.bytedance.msdk.w.u.hf
    public void xj() {
        if (this.u == null) {
            com.bytedance.msdk.core.kd.xj.xj xj = com.bytedance.msdk.core.kd.xj.xj.xj();
            List<com.bytedance.msdk.hf.w> jk = this.w.jk();
            String str = this.kd;
            com.bytedance.msdk.api.xj.hf hfVar = this.y;
            xj.xj(jk, str, hfVar, hfVar.kd(), this.u);
        }
        super.xj();
    }

    @Override // com.bytedance.msdk.api.u.xj.d.hf
    public void xj(com.bytedance.msdk.api.xj xjVar) {
        String str;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.u)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        com.bytedance.msdk.kd.y.xj(this.u, this.y, xjVar, 1, 0, str, j);
        w(xjVar);
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.api.u.xj.d.w wVar = this.e;
        if (wVar != null) {
            wVar.xj(xjVar);
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.d.hf
    public void xj(int i) {
        com.bytedance.msdk.api.u.xj.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.xj(1);
        }
        com.bytedance.msdk.core.kd.hf.u.xj().xj(this.f.get(), this.kd, v());
    }

    @Override // com.bytedance.msdk.api.u.xj.d.hf
    public void hf(int i) {
        com.bytedance.msdk.api.u.xj.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.hf(i);
        }
        com.bytedance.msdk.core.kd.hf.u.xj().xj(this.f.get(), this.kd, v());
    }

    public void xj(ViewGroup viewGroup, Activity activity) {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.xj(viewGroup, activity);
        }
    }
}
