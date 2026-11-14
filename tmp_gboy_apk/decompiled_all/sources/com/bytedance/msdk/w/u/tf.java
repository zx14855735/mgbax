package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.f.am;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class tf extends hf {
    protected boolean e;
    protected com.bytedance.msdk.xj.hf.y v;
    private Object xj;
    protected boolean yo;

    public interface xj {
        void xj();
    }

    public tf(Context context) {
        super(context);
        this.e = false;
        this.yo = false;
        this.xj = null;
    }

    private boolean hf(com.bytedance.msdk.hf.w wVar, Activity activity, Object obj, String str) {
        if (!wVar.ff(this.kd) || wVar.tu()) {
            return false;
        }
        if (!pz()) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(this.kd, wVar.cy()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar.gj()) + ",isReady()：" + wVar.ff(this.kd));
            xj(wVar, activity, obj, str);
            return true;
        }
        if (!u(wVar) || com.bytedance.msdk.core.admanager.xj.xj(wVar.lw(), wVar.ci(), wVar.tj())) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(this.kd, wVar.cy()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar.gj()) + ",isReady()：" + wVar.ff(this.kd));
        xj(wVar, activity, obj, str);
        return true;
    }

    private boolean u(com.bytedance.msdk.hf.w wVar) {
        return !wVar.sv() || wVar.dk() == 1;
    }

    public boolean et() {
        return this.e;
    }

    public void io() {
        com.bytedance.msdk.hf.w wVar;
        if (this.y.dq() || (wVar = this.u) == null || wVar.gj() == 4) {
            return;
        }
        com.bytedance.msdk.core.kd.hf.u.xj().xj(this.f.get(), this.kd, this.y.kd());
    }

    public boolean pz() {
        return false;
    }

    public void w(final com.bytedance.msdk.hf.w wVar) {
        if (this.y.dq()) {
            return;
        }
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.tf.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.hf.w wVar2 = wVar;
                if (wVar2 == null || !wVar2.ew() || !wVar.qf() || (tf.this.u instanceof com.bytedance.msdk.api.u.xj.hf.hf)) {
                    return;
                }
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(tf.this.kd, wVar.cy()) + "在show时触发了预加载【" + wVar.lw() + "】, loadSort: " + wVar.zd() + ", showSort: " + wVar.kc());
                tf.this.yo = true;
                com.bytedance.msdk.core.kd.hf.u xj2 = com.bytedance.msdk.core.kd.hf.u.xj();
                Context context = tf.this.f.get();
                tf tfVar = tf.this;
                xj2.hf(context, tfVar.kd, tfVar.y.kd());
            }
        });
    }

    public boolean x() {
        List<com.bytedance.msdk.core.tf.tf> list;
        try {
            list = hf();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            list = null;
        }
        return am.xj(this.w.c(), this.w.tf(), this.w.f(), this.y, this.f10153pl, this.kd, this.y.kd(), list);
    }

    public void xj(boolean z) {
        this.e = z;
    }

    private boolean w(com.bytedance.msdk.hf.w wVar, Activity activity, Object obj, String str) {
        if (!wVar.ff(this.kd) || wVar.tu()) {
            return false;
        }
        if (pz()) {
            if (u(wVar) && !com.bytedance.msdk.core.admanager.xj.xj(wVar.lw(), wVar.ci(), wVar.tj())) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(this.kd, wVar.cy()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar.gj()) + ",isReady()：" + wVar.ff(this.kd));
                hf(wVar);
                xj(wVar, activity, obj, str);
                return true;
            }
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==--- cache 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(this.kd, wVar.cy()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar.gj()) + ",isReady()：" + wVar.ff(this.kd));
        hf(wVar);
        xj(wVar, activity, obj, str);
        return true;
    }

    public void xj(com.bytedance.msdk.w.y.xj.hf hfVar) {
        boolean z;
        com.bytedance.msdk.core.tf.hf hfVar2;
        if (this.u.ci() == 10 || this.u.ci() == 8 || this.u.ci() == 7) {
            boolean z2 = (this.u.ew() && this.u.qf() && com.bytedance.msdk.core.kd.hf.u.xj().w(this.kd, this.y.kd())) ? false : true;
            com.bytedance.msdk.api.xj.hf hfVar3 = this.y;
            z = this.u.gj() == 4 ? false : (hfVar3 == null || !(hfVar3.ht() == 10 || this.y.ht() == 8) || (hfVar2 = this.c) == null || hfVar2.am() == 0) ? z2 : true;
        } else {
            z = true;
        }
        if (this.u.my() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, this.u.cy(), this.y.kd())) {
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(this.u.cy(), this.y, hfVar != null ? hfVar.q() : null, z, hfVar != null ? hfVar.z() : null, (com.bytedance.msdk.core.tf.d) null, this.f.get());
        }
    }

    @Override // com.bytedance.msdk.w.u.hf
    public void xj() {
        super.xj();
        this.v = null;
    }

    public void xj(Activity activity, Object obj, String str, xj xjVar) {
        tf tfVar;
        Activity activity2;
        Object obj2;
        String str2;
        List<com.bytedance.msdk.core.tf.tf> list = null;
        if (!pz()) {
            com.bytedance.msdk.kd.y.xj(this.y);
            if (this.f10153pl) {
                com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.y, 0);
                if (xjVar != null) {
                    xjVar.xj();
                    return;
                }
                return;
            }
        }
        int hf = hf.hf(this.kd);
        if (hf != 0) {
            com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.y, hf);
            if (xjVar != null) {
                xjVar.xj();
                return;
            }
            return;
        }
        boolean g = g();
        List<com.bytedance.msdk.hf.w> jk = this.w.jk();
        try {
            list = hf();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        List<com.bytedance.msdk.core.tf.tf> list2 = list;
        if (list2 == null || list2.size() <= 0) {
            tfVar = this;
            activity2 = activity;
            obj2 = obj;
            str2 = str;
        } else {
            tfVar = this;
            activity2 = activity;
            obj2 = obj;
            str2 = str;
            if (tfVar.xj(list2, jk, g, activity2, obj2, str2)) {
                return;
            }
        }
        if (jk != null && jk.size() > 0) {
            for (com.bytedance.msdk.hf.w wVar : jk) {
                if (wVar != null && (!g || wVar.qf())) {
                    if (hf(wVar, activity2, obj2, str2)) {
                        return;
                    }
                }
            }
            if (g && tfVar.u == null) {
                for (com.bytedance.msdk.hf.w wVar2 : jk) {
                    if (wVar2 != null && hf(wVar2, activity2, obj2, str2)) {
                        return;
                    }
                }
            }
        }
        com.bytedance.msdk.kd.y.xj(jk, tfVar.y, 0);
        if (xjVar != null) {
            xjVar.xj();
        }
    }

    public void xj(com.bytedance.msdk.hf.w wVar, final Activity activity, final Object obj, final String str) {
        this.u = wVar;
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.tf.2
            @Override // java.lang.Runnable
            public void run() {
                tf tfVar = tf.this;
                if (tfVar.u != null) {
                    if (tfVar.xj != null) {
                        tf tfVar2 = tf.this;
                        tfVar2.u.xj(tfVar2.xj);
                    }
                    tf tfVar3 = tf.this;
                    com.bytedance.msdk.api.u.xj.hf hfVar = tfVar3.g;
                    if (hfVar != null) {
                        tfVar3.u.xj(hfVar);
                    }
                    tf tfVar4 = tf.this;
                    com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar2 = tfVar4.am;
                    if (hfVar2 != null) {
                        tfVar4.u.xj(hfVar2);
                    }
                    tf tfVar5 = tf.this;
                    tfVar5.w.xj(tfVar5.u);
                    tf.this.u.kd(true);
                    tf tfVar6 = tf.this;
                    tfVar6.u.xj(tfVar6.d);
                    tf tfVar7 = tf.this;
                    tfVar7.u.hf(tfVar7.v);
                    if (tf.this.u.my()) {
                        com.bytedance.msdk.core.kd.xj.xj xj2 = com.bytedance.msdk.core.kd.xj.xj.xj();
                        tf tfVar8 = tf.this;
                        if (xj2.u(tfVar8.kd, tfVar8.u.cy(), tf.this.v())) {
                            tf tfVar9 = tf.this;
                            com.bytedance.msdk.hf.w wVar2 = tfVar9.u;
                            com.bytedance.msdk.w.f.y.xj(wVar2, tfVar9.kd, wVar2.cy());
                        }
                    }
                    List<com.bytedance.msdk.hf.w> jk = tf.this.w.jk();
                    com.bytedance.msdk.core.kd.xj.xj xj3 = com.bytedance.msdk.core.kd.xj.xj.xj();
                    tf tfVar10 = tf.this;
                    String str2 = tfVar10.kd;
                    com.bytedance.msdk.api.xj.hf hfVar3 = tfVar10.y;
                    xj3.xj(jk, str2, hfVar3, hfVar3.kd(), tf.this.u);
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.bytedance.msdk.xj.kd.kd.xj(tf.this.kd, "show"));
                    sb.append("展示的广告类型：");
                    sb.append(com.bytedance.msdk.hf.xj.xj(tf.this.u.gj()));
                    sb.append(",slotId：");
                    sb.append(tf.this.u.cy());
                    sb.append(",slotType:");
                    sb.append(tf.this.u.qi());
                    sb.append(",isReady()：");
                    tf tfVar11 = tf.this;
                    sb.append(tfVar11.u.ff(tfVar11.kd));
                    sb.append("，是否为缓存广告:");
                    sb.append(tf.this.u.qf());
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, sb.toString());
                    tf.this.u.xj(activity, obj, str);
                    com.bytedance.msdk.core.f.g.xj().hf(tf.this.kd);
                    com.bytedance.msdk.core.f.pl xj4 = com.bytedance.msdk.core.f.pl.xj();
                    tf tfVar12 = tf.this;
                    xj4.hf(tfVar12.kd, tfVar12.u.cy());
                    tf.this.f10153pl = true;
                    if (tf.this.u != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(tf.this.u);
                        if (tf.this.y.ht() == 7 || tf.this.y.ht() == 10) {
                            com.bytedance.msdk.w.kd.xj xj5 = com.bytedance.msdk.w.kd.xj.xj();
                            com.bytedance.msdk.api.xj.hf hfVar4 = tf.this.y;
                            xj5.xj(hfVar4, com.bytedance.msdk.w.kd.xj.xj(hfVar4, arrayList, jk));
                        }
                        tf.this.xj((List<com.bytedance.msdk.hf.w>) arrayList);
                    }
                    tf tfVar13 = tf.this;
                    com.bytedance.msdk.kd.y.xj(tfVar13.u, tfVar13.y, false, tfVar13.pz() ? 1 : 0);
                }
            }
        });
    }

    private boolean xj(List<com.bytedance.msdk.core.tf.tf> list, List<com.bytedance.msdk.hf.w> list2, boolean z, Activity activity, Object obj, String str) {
        com.bytedance.msdk.hf.w wVar;
        com.bytedance.msdk.hf.w wVar2;
        HashMap<String, com.bytedance.msdk.hf.w> hf = hf(list2);
        for (com.bytedance.msdk.core.tf.tf tfVar : list) {
            if (tfVar != null) {
                String yo = tfVar.yo();
                com.bytedance.msdk.hf.w wVar3 = hf.get(yo);
                if (wVar3 != null) {
                    if (z) {
                        if (wVar3.qf() && hf(wVar3, activity, obj, str)) {
                            return true;
                        }
                    } else if (hf(wVar3, activity, obj, str)) {
                        return true;
                    }
                }
                if (tfVar.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, yo, this.y.kd()) && com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, this.y, false) == 3) {
                    com.bytedance.msdk.core.kd.xj.xj xj2 = com.bytedance.msdk.core.kd.xj.xj.xj();
                    com.bytedance.msdk.api.xj.hf hfVar = this.y;
                    List<com.bytedance.msdk.core.kd.hf.c> xj3 = xj2.xj(yo, hfVar, hfVar.kd());
                    if (xj3 != null && xj3.size() > 0 && (wVar2 = xj3.get(0).xj) != null) {
                        if (z) {
                            if (wVar2.qf() && w(wVar2, activity, obj, str)) {
                                return true;
                            }
                        } else if (w(wVar2, activity, obj, str)) {
                            return true;
                        }
                    }
                }
            }
        }
        if (z && this.u == null) {
            for (com.bytedance.msdk.core.tf.tf tfVar2 : list) {
                if (tfVar2 != null) {
                    String yo2 = tfVar2.yo();
                    com.bytedance.msdk.hf.w wVar4 = hf.get(yo2);
                    if (wVar4 != null && hf(wVar4, activity, obj, str)) {
                        return true;
                    }
                    if (tfVar2.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, yo2, this.y.kd()) && com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo2, this.y, false) == 3) {
                        com.bytedance.msdk.core.kd.xj.xj xj4 = com.bytedance.msdk.core.kd.xj.xj.xj();
                        com.bytedance.msdk.api.xj.hf hfVar2 = this.y;
                        List<com.bytedance.msdk.core.kd.hf.c> xj5 = xj4.xj(yo2, hfVar2, hfVar2.kd());
                        if (xj5 != null && xj5.size() > 0 && (wVar = xj5.get(0).xj) != null && w(wVar, activity, obj, str)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void xj(Object obj) {
        this.xj = obj;
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.xj(obj);
        }
    }
}
