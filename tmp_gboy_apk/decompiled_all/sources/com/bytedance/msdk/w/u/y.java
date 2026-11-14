package com.bytedance.msdk.w.u;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends hf implements com.bytedance.msdk.xj.hf.xj {
    private com.bytedance.msdk.api.u.xj.xj.u e;
    private com.bytedance.msdk.api.u.xj.xj.hf hf;
    private com.bytedance.msdk.api.u.xj.xj.xj xj;
    private boolean zg;

    public y(Context context) {
        super(context);
        this.zg = false;
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void c() {
        com.bytedance.msdk.api.u.xj.xj.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    @Override // com.bytedance.msdk.api.u.xj.xj.xj
    public void f_() {
        com.bytedance.msdk.api.u.xj.xj.xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.f_();
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.api.u.xj.xj.hf hfVar = this.hf;
        if (hfVar != null) {
            hfVar.xj(xjVar);
        }
    }

    public void kd() {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.e();
        }
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.u pz() {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            return wVar.uj();
        }
        return null;
    }

    @Override // com.bytedance.msdk.w.u.hf
    public com.bytedance.msdk.api.w qt() {
        if (this.zg) {
            return super.qt();
        }
        return null;
    }

    public int u() {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            return wVar.ss();
        }
        return 0;
    }

    public boolean w() {
        List<com.bytedance.msdk.core.tf.tf> list;
        try {
            list = hf();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            list = null;
        }
        return am.xj(this.w.c(), this.w.tf(), this.w.f(), this.y, this.f10153pl, this.kd, this.y.kd(), list);
    }

    public void y() {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.zg();
        }
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.xj.hf hfVar2) {
        xj(hfVar);
        this.d = this;
        this.hf = hfVar2;
        d();
    }

    @Override // com.bytedance.msdk.api.u.xj.xj.xj
    public void hf(View view) {
        String str;
        long j;
        this.zg = true;
        if (this.xj != null) {
            com.bytedance.msdk.core.f.g.xj().c(this.kd);
            com.bytedance.msdk.core.f.g.xj().hf(this.kd);
            this.xj.hf(view);
        }
        if (this.u != null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd, "show_listen") + "adSlotId：" + this.u.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(this.u.gj()));
            com.bytedance.msdk.core.f.p.xj().hf(this.kd, this.u.cy());
            com.bytedance.msdk.core.f.pl.xj().hf(this.kd, this.u.cy());
        }
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            com.bytedance.msdk.core.w.w.xj(wVar.gh(), this.kd, this.u.cy());
        }
        xj(true);
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

    public void u(String str) {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.a(str);
        }
    }

    private void w(final com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.xj.kd.y.w(new Runnable() { // from class: com.bytedance.msdk.w.u.y.2
            @Override // java.lang.Runnable
            public void run() {
                if (y.this.xj != null) {
                    y.this.xj.xj(xjVar);
                }
            }
        });
    }

    public void xj(com.bytedance.msdk.api.u.xj.xj.u uVar) {
        this.e = uVar;
    }

    private com.bytedance.msdk.api.u.xj.xj.w w(final com.bytedance.msdk.hf.w wVar) {
        return new com.bytedance.msdk.api.u.xj.xj.w() { // from class: com.bytedance.msdk.w.u.y.3
            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public String c() {
                return wVar.jw();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public int d() {
                return wVar.nb();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public int f() {
                return wVar.ss();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public String hf() {
                return wVar.ut();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public double kd() {
                return wVar.ol();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public boolean p() {
                return wVar.jk();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public com.bytedance.sdk.openadsdk.zg.w.hf.u pl() {
                com.bytedance.msdk.hf.w wVar2 = wVar;
                if (wVar2 != null) {
                    return wVar2.uj();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public com.bytedance.msdk.api.u.xj.c.xj tf() {
                if (!wVar.xv()) {
                    return null;
                }
                com.bytedance.msdk.api.u.xj.c.xj xjVar = new com.bytedance.msdk.api.u.xj.c.xj();
                xjVar.u(wVar.vl());
                xjVar.kd(wVar.h());
                xjVar.xj(wVar.ne());
                xjVar.y(wVar.se());
                xjVar.c(wVar.ft());
                xjVar.f(wVar.rg());
                xjVar.xj(wVar.t());
                xjVar.hf(wVar.k());
                xjVar.w(wVar.vm());
                xjVar.xj(wVar.yy());
                xjVar.hf(wVar.hl());
                return xjVar;
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public String u() {
                return wVar.nt();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public String w() {
                return wVar.he();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public String xj() {
                return wVar.vw();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public List<String> y() {
                return wVar.mg();
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public com.bytedance.sdk.openadsdk.zg.w.hf.c hf(Activity activity) {
                com.bytedance.msdk.hf.w wVar2 = wVar;
                if (wVar2 != null) {
                    return wVar2.xj(activity);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.u.xj.c.tf tfVar) {
                wVar.xj(activity, viewGroup, list, list2, list3, tfVar, null);
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public com.bytedance.msdk.api.u.hf xj(Activity activity) {
                return xj(activity, (Map<String, Object>) null);
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public com.bytedance.sdk.openadsdk.zg.w.hf.c hf(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.hf.w wVar2 = wVar;
                if (wVar2 != null) {
                    return wVar2.hf(dialog, numArr);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public com.bytedance.msdk.api.u.hf xj(Activity activity, Map<String, Object> map) {
                final com.bytedance.sdk.openadsdk.zg.w.hf.c xj = wVar.xj(activity);
                return new com.bytedance.msdk.api.u.hf() { // from class: com.bytedance.msdk.w.u.y.3.1
                    @Override // com.bytedance.msdk.api.u.hf
                    public void xj() {
                        com.bytedance.sdk.openadsdk.zg.w.hf.c cVar = xj;
                        if (cVar != null) {
                            cVar.xj();
                        }
                    }

                    @Override // com.bytedance.msdk.api.u.hf
                    public void xj(final com.bytedance.msdk.api.u.c cVar) {
                        com.bytedance.sdk.openadsdk.zg.w.hf.c cVar2 = xj;
                        if (cVar2 != null) {
                            cVar2.xj(new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.u.y.3.1.1
                                @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                                public void hf() {
                                    com.bytedance.msdk.api.u.c cVar3 = cVar;
                                    if (cVar3 != null) {
                                        cVar3.xj();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                                public void xj() {
                                    com.bytedance.msdk.api.u.c cVar3 = cVar;
                                    if (cVar3 != null) {
                                        cVar3.hf();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                                public void xj(int i, String str, boolean z) {
                                    com.bytedance.msdk.api.u.c cVar3 = cVar;
                                    if (cVar3 != null) {
                                        cVar3.xj(i, str);
                                    }
                                }
                            });
                        }
                    }
                };
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
                com.bytedance.msdk.hf.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.xj(activity, xjVar);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.w
            public void xj(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.hf.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.xj(dialog, numArr);
                }
            }
        };
    }

    public void xj(com.bytedance.msdk.api.u.xj.xj.xj xjVar) {
        this.xj = xjVar;
    }

    private View xj(Context context, com.bytedance.msdk.hf.w wVar) {
        this.u = wVar;
        this.w.xj(wVar);
        this.u.kd(true);
        this.u.xj(this.d);
        if (this.u.my() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, this.u.cy(), this.y.kd())) {
            com.bytedance.msdk.hf.w wVar2 = this.u;
            com.bytedance.msdk.w.f.y.xj(wVar2, this.kd, wVar2.cy());
        }
        xj(false);
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd, "show") + "展示的广告类型：" + com.bytedance.msdk.hf.xj.xj(this.u.gj()) + ",slotId：" + this.u.cy() + ",slotType:" + this.u.qi());
        final View d = this.u.d();
        if (!this.u.sv() && this.u.tj() == 4 && this.u.n() == 2 && !this.u.gy()) {
            com.bytedance.msdk.api.u.xj.xj.u uVar = this.e;
            if (uVar == null) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- banner混出自渲染信息流，但未提供GMNativeToBannerListener，将无法展示该广告");
            } else {
                try {
                    d = uVar.xj(w(this.u));
                    if (d == null) {
                        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()返回null，将无法展示该广告");
                    }
                } catch (Throwable th) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
        }
        if (this.u.jk() && context != null) {
            this.u.xj((Activity) context, new com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj(null) { // from class: com.bytedance.msdk.w.u.y.1
                @Override // com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj
                public void xj(int i, String str, boolean z) {
                    View view = d;
                    if (view != null) {
                        View view2 = (View) view.getParent();
                        if (view2 instanceof ViewGroup) {
                            ((ViewGroup) view2).removeViewInLayout(d);
                        }
                    }
                }
            });
        }
        return d;
    }

    public void hf(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.xj(hfVar);
        }
    }

    public synchronized View xj(Context context) {
        List<com.bytedance.msdk.core.tf.tf> list;
        View view;
        com.bytedance.msdk.hf.w wVar;
        com.bytedance.msdk.hf.w next;
        com.bytedance.msdk.hf.w wVar2;
        com.bytedance.msdk.kd.y.xj(this.y);
        if (this.f10153pl) {
            com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.y, 0);
            w(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
            return null;
        }
        int hf = hf.hf(this.kd);
        if (hf != 0) {
            com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.y, hf);
            w(new com.bytedance.msdk.api.xj(hf, com.bytedance.msdk.api.xj.xj(hf)));
            return null;
        }
        List<com.bytedance.msdk.hf.w> jk = this.w.jk();
        try {
            list = hf();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            list = null;
        }
        if (list != null && list.size() > 0) {
            HashMap<String, com.bytedance.msdk.hf.w> hf2 = hf(jk);
            view = null;
            for (com.bytedance.msdk.core.tf.tf tfVar : list) {
                if (tfVar != null) {
                    String yo = tfVar.yo();
                    com.bytedance.msdk.hf.w wVar3 = hf2.get(yo);
                    if (wVar3 != null && wVar3.ff(this.kd) && !wVar3.tu() && (view = xj(context, wVar3)) != null) {
                        break;
                    }
                    if (tfVar.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, yo, this.y.kd()) && com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, this.y, false) == 3) {
                        com.bytedance.msdk.core.kd.xj.xj xj = com.bytedance.msdk.core.kd.xj.xj.xj();
                        com.bytedance.msdk.api.xj.hf hfVar = this.y;
                        List<com.bytedance.msdk.core.kd.hf.c> xj2 = xj.xj(yo, hfVar, hfVar.kd());
                        if (xj2 != null && xj2.size() > 0 && (wVar2 = xj2.get(0).xj) != null && wVar2.ff(this.kd) && !wVar2.tu()) {
                            hf(wVar2);
                            view = xj(context, wVar2);
                            if (view != null) {
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            view = null;
        }
        if (view == null && jk != null && jk.size() > 0) {
            Iterator<com.bytedance.msdk.hf.w> it = jk.iterator();
            while (it.hasNext() && ((next = it.next()) == null || !next.ff(this.kd) || next.tu() || (view = xj(context, next)) == null)) {
            }
        }
        if (view != null) {
            this.f10153pl = true;
            List<com.bytedance.msdk.hf.w> jk2 = this.w.jk();
            com.bytedance.msdk.core.kd.xj.xj xj3 = com.bytedance.msdk.core.kd.xj.xj.xj();
            String str = this.kd;
            com.bytedance.msdk.api.xj.hf hfVar2 = this.y;
            xj3.xj(jk2, str, hfVar2, hfVar2.kd(), this.u);
            if (this.u != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.u);
                com.bytedance.msdk.w.kd.xj xj4 = com.bytedance.msdk.w.kd.xj.xj();
                com.bytedance.msdk.api.xj.hf hfVar3 = this.y;
                xj4.xj(hfVar3, com.bytedance.msdk.w.kd.xj.xj(hfVar3, arrayList, jk2));
                xj(arrayList);
            }
            com.bytedance.msdk.kd.y.xj(this.u, this.y, false, 0);
            if (this.xj != null && (wVar = this.u) != null && wVar.gj() == 2) {
                com.bytedance.msdk.xj.kd.w.xj("ADMOB_EVENT", com.bytedance.msdk.xj.kd.kd.hf(this.kd, this.u.cy()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                com.bytedance.msdk.core.f.g.xj().c(this.kd);
                com.bytedance.msdk.core.f.g.xj().hf(this.kd);
                this.xj.hf(null);
                if (this.u != null) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd, "show_listen") + "adSlotId：" + this.u.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(this.u.gj()));
                    com.bytedance.msdk.core.f.p.xj().hf(this.kd, this.u.cy());
                    com.bytedance.msdk.core.f.pl.xj().hf(this.kd, this.u.cy());
                }
                com.bytedance.msdk.hf.w wVar4 = this.u;
                if (wVar4 != null) {
                    com.bytedance.msdk.core.w.w.xj(wVar4.gh(), this.kd, this.u.cy());
                }
                xj(true);
                com.bytedance.msdk.kd.y.xj(this.u, this.y, 0, (String) null, 0L, false);
                com.bytedance.msdk.core.c.w.xj(this.kd, this.u);
            }
            return view;
        }
        com.bytedance.msdk.kd.y.xj(jk, this.y, 0);
        w(new com.bytedance.msdk.api.xj(40052, com.bytedance.msdk.api.xj.xj(40052)));
        return null;
    }

    private void xj(boolean z) {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null && wVar.my() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, this.u.cy(), this.y.kd())) {
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(this.u.cy(), this.y, this.w.q(), z, this.w.z(), this.w.ff(), this.f.get());
        }
    }

    @Override // com.bytedance.msdk.w.u.hf
    public void xj() {
        if (!this.f10153pl) {
            com.bytedance.msdk.core.kd.xj.xj xj = com.bytedance.msdk.core.kd.xj.xj.xj();
            List<com.bytedance.msdk.hf.w> jk = this.w.jk();
            String str = this.kd;
            com.bytedance.msdk.api.xj.hf hfVar = this.y;
            xj.xj(jk, str, hfVar, hfVar.kd(), this.u);
        }
        super.xj();
        this.xj = null;
        this.hf = null;
    }

    @Override // com.bytedance.msdk.api.u.xj.xj.xj
    public void xj(View view) {
        String str;
        long j;
        com.bytedance.msdk.api.u.xj.xj.xj xjVar = this.xj;
        if (xjVar != null) {
            xjVar.xj(view);
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

    @Override // com.bytedance.msdk.api.u.xj.xj.xj
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

    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.xj(activity, xjVar);
        }
    }

    public void xj(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            wVar.xj(dialog, numArr);
        }
    }

    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        com.bytedance.msdk.hf.w wVar = this.u;
        if (wVar != null) {
            return wVar.xj(activity);
        }
        return null;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        com.bytedance.msdk.hf.w wVar2 = this.u;
        if (wVar2 != null) {
            wVar2.xj(wVar);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        com.bytedance.msdk.hf.w wVar2 = this.u;
        if (wVar2 != null) {
            wVar2.xj(wVar);
        }
    }
}
