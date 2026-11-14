package com.bytedance.sdk.gromore.xj.xj.c.hf;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.u.xj.c.f;
import com.bytedance.msdk.core.f.g;
import com.bytedance.msdk.core.f.p;
import com.bytedance.msdk.core.f.pl;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.e;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.kd.y;
import com.bytedance.msdk.w.u.c;
import com.bytedance.sdk.gromore.xj.xj.u.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd;
import com.bytedance.sdk.openadsdk.zg.w.hf.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends d {
    private com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj c;
    private com.bytedance.sdk.openadsdk.zg.w.xj.hf f;
    private com.bytedance.msdk.hf.w hf;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w kd;
    private View u;
    private com.bytedance.msdk.api.xj.hf w;
    private c xj;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj y;

    public xj(c cVar, com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar) {
        this.xj = cVar;
        this.hf = wVar;
        this.w = hfVar;
        io();
    }

    private void ai() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null || !wVar.gy()) {
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "当前广告为模版广告，不能使用自渲染接口进行渲染，请使用render进行渲染");
    }

    private void io() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(new f() { // from class: com.bytedance.sdk.gromore.xj.xj.c.hf.xj.1
                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void hf() {
                    if (xj.this.c != null) {
                        xj.this.c.hf(xj.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void kd() {
                    if (xj.this.c != null) {
                        xj.this.c.kd(xj.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void u() {
                    if (xj.this.c != null) {
                        xj.this.c.u(xj.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void w() {
                    if (xj.this.c != null) {
                        xj.this.c.w(xj.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void xj() {
                    if (xj.this.c != null) {
                        xj.this.c.xj(xj.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void xj(com.bytedance.msdk.api.xj xjVar) {
                    String str;
                    long j;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (v.xj(xj.this.hf)) {
                        str = v.hf();
                        j = System.currentTimeMillis() - currentTimeMillis;
                    } else {
                        str = null;
                        j = -1;
                    }
                    y.xj(xj.this.hf, xj.this.w, (com.bytedance.msdk.api.xj) null, 2, 0, str, j);
                    if (xjVar == null || xj.this.c == null) {
                        return;
                    }
                    xj.this.c.xj(xjVar.xj, -1);
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void xj(long j, long j2) {
                    if (xj.this.c != null) {
                        xj.this.c.xj(j, j2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.bytedance.msdk.hf.w wVar;
        String str;
        long j;
        if (this.w == null || (wVar = this.hf) == null) {
            return;
        }
        wVar.y(true);
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar2 = this.kd;
        if (wVar2 instanceof kd) {
            ((kd) wVar2).hf();
        }
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar = this.y;
        if (xjVar != null) {
            xjVar.xj(this);
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.w.ra(), "show_listen") + "adSlotId：" + this.hf.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(this.hf.gj()));
        g xj = g.xj();
        StringBuilder sb = new StringBuilder();
        sb.append(this.w.ra());
        xj.c(sb.toString());
        g.xj().hf(this.w.ra());
        p.xj().hf(this.w.ra(), this.hf.cy());
        pl.xj().hf(this.w.ra(), this.hf.cy());
        com.bytedance.msdk.core.w.w.xj(this.hf.gh(), this.w.ra(), this.hf.cy());
        if (this.hf.uh() != null) {
            this.hf.uh().xj(this.hf);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.hf)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        String str2 = str;
        long j2 = j;
        boolean j3 = this.hf.j();
        if (!j3) {
            com.bytedance.msdk.core.hf.xj.c(this.w.ra());
            com.bytedance.msdk.core.hf.xj.w(this.w.ra());
            com.bytedance.msdk.core.d.u.xj(1, this.w.ra(), this.hf.ci(), this.hf.da());
        }
        y.xj(this.hf, this.w, 0, str2, j2, j3);
        com.bytedance.msdk.api.xj.hf hfVar = this.w;
        com.bytedance.msdk.core.c.w.xj(hfVar != null ? hfVar.ra() : "", this.hf);
    }

    private void q() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null || wVar.gy()) {
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "当前广告为自渲染广告，不能使用模版接口进行渲染，请使用registerViewForInteraction进行渲染");
    }

    private void z() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        if (wVar.gy()) {
            this.hf.xj((com.bytedance.msdk.api.u.xj.w.xj) new com.bytedance.msdk.api.u.xj.w.u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.hf.xj.4
                @Override // com.bytedance.msdk.api.u.xj.w.u
                public void xj(View view, String str, int i) {
                    if (xj.this.kd instanceof kd) {
                        ((kd) xj.this.kd).xj(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w.u
                public void xj(float f, float f2) {
                    if (xj.this.kd != null) {
                        xj.this.kd.xj(xj.this.u, f, f2, true);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj(View view) {
                    xj.this.xj(view);
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj() {
                    xj.this.j();
                }
            });
        } else {
            this.hf.xj(new com.bytedance.msdk.api.u.xj.w.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.hf.xj.5
                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj(View view) {
                    xj.this.xj(view);
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj() {
                    xj.this.j();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.pl am() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        return new com.bytedance.sdk.gromore.xj.xj.u.g(wVar != null ? wVar.ut() : "");
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String c() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.vw();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String d() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.nt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void dk() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            try {
                wVar.yo();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int e() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.ss();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd et() {
        return new tf(new hf(this.xj, this.hf, this.w));
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String f() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.uf();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String g() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.jw();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public Map<String, Object> ht() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return null;
        }
        Map<String, Object> q = wVar.q();
        if (q == null) {
            com.bytedance.msdk.api.xj.hf hfVar = this.w;
            q = com.bytedance.msdk.w.u.hf.w(hfVar != null ? hfVar.ra() : "");
        }
        if (this.hf.s() && e.xj()) {
            String xj = e.xj(am.xj(this.w, this.hf, true));
            if (!TextUtils.isEmpty(xj)) {
                q.put("get_show_ecpm_info", xj);
            }
        }
        return com.bytedance.sdk.gromore.xj.hf.hf.xj(q, this.hf.dc());
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.kd jk() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.jf();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int p() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.yt();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int pl() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.ic();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public View pz() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return null;
        }
        if (!wVar.gy()) {
            return this.hf.tf();
        }
        y.xj(this.w);
        if (this.hf.uh() != null) {
            this.hf.uh().xj();
        }
        com.bytedance.msdk.hf.w wVar2 = this.hf;
        y.xj(wVar2, this.w, wVar2.z(), 0);
        View d = this.hf.d();
        this.u = d;
        return d;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public List<com.bytedance.sdk.openadsdk.zg.w.hf.pl> qt() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.hf.w wVar = this.hf;
        List<String> mg = wVar != null ? wVar.mg() : null;
        com.bytedance.msdk.hf.w wVar2 = this.hf;
        String he = wVar2 != null ? wVar2.he() : null;
        if (mg != null) {
            if (mg.size() != 0) {
                Iterator<String> it = mg.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.bytedance.sdk.gromore.xj.xj.u.g(it.next()));
                }
            } else if (!TextUtils.isEmpty(he)) {
                com.bytedance.msdk.hf.w wVar3 = this.hf;
                int zm = wVar3 != null ? wVar3.zm() : 0;
                com.bytedance.msdk.hf.w wVar4 = this.hf;
                arrayList.add(new com.bytedance.sdk.gromore.xj.xj.u.g(he, zm, wVar4 != null ? wVar4.ey() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void ra() {
        q();
        if (this.hf != null) {
            z();
            this.hf.p();
            xj(this.hf);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int tf() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return (int) wVar.ol();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.w v() {
        return new com.bytedance.sdk.gromore.xj.xj.hf.xj(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.u yo() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.uj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public int zg() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.nb();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.pl kd() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.vh();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public int u() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            if (wVar.gy()) {
                View view = this.u;
                if (view != null) {
                    return view.getHeight();
                }
                return 0;
            }
            com.bytedance.msdk.hf.w wVar2 = this.hf;
            if (wVar2 != null) {
                return wVar2.ah();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public int w() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            if (wVar.gy()) {
                View view = this.u;
                if (view != null) {
                    return view.getWidth();
                }
                return 0;
            }
            com.bytedance.msdk.hf.w wVar2 = this.hf;
            if (wVar2 != null) {
                return wVar2.lx();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf hfVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public Bitmap y() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.ho();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj hf() {
        return new com.bytedance.sdk.gromore.xj.xj.hf.hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void hf(Activity activity) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.hf(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void hf(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.d
    public void xj(boolean z) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.tf(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.d
    public void xj(Bitmap bitmap, int i) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(bitmap, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.d
    public void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(xjVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar) {
        this.c = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public double xj() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.bh();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.xj(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.hf(dialog, numArr);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        xj(viewGroup, (List<View>) null, arrayList, (List<View>) null, (List<View>) null, (View) null, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        xj(viewGroup, (List<View>) null, list, list2, (List<View>) null, (View) null, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        xj(viewGroup, (List<View>) null, list, list2, (List<View>) null, view, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        xj(viewGroup, list, list2, list3, (List<View>) null, view, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4, final View view, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        ai();
        if (this.hf != null) {
            xj(xjVar);
            xj(false, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.xj.xj.c.hf.xj.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (TextUtils.equals(xj.this.hf.lw(), MediationConstant.ADN_PANGLE)) {
                        xj.this.hf.xj(viewGroup, list, list2, list3, list4, view);
                        return false;
                    }
                    xj.this.hf.xj(null, viewGroup, list2, list3, list4, null, list);
                    return false;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar, final com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar) {
        ai();
        if (this.hf != null) {
            xj(xjVar);
            xj(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.xj.xj.c.hf.xj.3
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    xj.this.hf.xj(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.u.xj.c.tf.xj(uVar), null);
                    return false;
                }
            });
        }
    }

    private void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        this.y = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        com.bytedance.msdk.hf.w wVar2 = this.hf;
        if (wVar2 != null) {
            wVar2.xj(wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar) {
        this.kd = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null || activity == null) {
            return;
        }
        wVar.xj(activity, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(String str) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.a(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        this.f = hfVar;
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(hfVar);
        }
    }

    private void xj(boolean z, Handler.Callback callback) {
        y.xj(this.w);
        if (this.hf != null) {
            z();
            if (callback != null) {
                callback.handleMessage(null);
            }
            if (this.hf.uh() != null) {
                this.hf.uh().xj();
            }
            xj(this.hf);
            HashMap hashMap = new HashMap();
            hashMap.put("has_view_binder", Boolean.valueOf(z));
            com.bytedance.msdk.hf.w wVar = this.hf;
            y.xj(wVar, this.w, wVar.z(), 0, hashMap);
            return;
        }
        y.xj((List<com.bytedance.msdk.hf.w>) null, this.w, 0);
    }

    private void xj(com.bytedance.msdk.hf.w wVar) {
        if (com.bytedance.msdk.core.hf.hf().j()) {
            y.xj(wVar, this.w, v.xj(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(View view) {
        String str;
        long j;
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar = this.kd;
        if (wVar instanceof kd) {
            ((kd) wVar).xj();
        }
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar = this.y;
        if (xjVar != null) {
            xjVar.xj(view, this);
        }
        if (this.hf == null || this.w == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (v.xj(this.hf)) {
            str = v.hf();
            j = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j = -1;
        }
        String str2 = str;
        long j2 = j;
        com.bytedance.msdk.core.hf.xj.kd(this.w.ra());
        com.bytedance.msdk.hf.w wVar2 = this.hf;
        y.hf(wVar2, this.w, 0, str2, j2, wVar2.en());
    }
}
