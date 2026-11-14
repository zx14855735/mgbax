package com.bytedance.sdk.gromore.xj.xj.c.u;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.u.xj.c.f;
import com.bytedance.msdk.core.f.g;
import com.bytedance.msdk.core.f.p;
import com.bytedance.msdk.f.e;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.w.u.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.gromore.xj.xj.u.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends am {
    private com.bytedance.sdk.openadsdk.zg.w.xj.w c;
    private com.bytedance.sdk.openadsdk.zg.w.xj.hf d;
    private com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.hf f;
    private com.bytedance.msdk.hf.w hf;
    private com.bytedance.sdk.openadsdk.et.xj.hf.xj.w kd;
    private View u;
    private com.bytedance.msdk.api.xj.hf w;
    private d xj;
    private com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf y;

    public u(d dVar, com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.hf hfVar2) {
        this.xj = dVar;
        this.f = hfVar2;
        this.hf = wVar;
        if (wVar != null && wVar.tj() == 3) {
            this.hf.c(true);
        }
        this.w = hfVar;
        tf();
    }

    private void am() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        if (wVar.gy()) {
            this.hf.xj((com.bytedance.msdk.api.u.xj.c.hf) new com.bytedance.msdk.api.u.xj.c.y() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.7
                @Override // com.bytedance.msdk.api.u.xj.c.y
                public void xj(View view, String str, int i) {
                    if (u.this.y != null) {
                        u.this.y.xj(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.y
                public void xj(float f, float f2) {
                    if (u.this.y != null) {
                        u.this.y.xj((View) null, f, f2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj(View view) {
                    if (u.this.y != null) {
                        u.this.y.xj(view, 0);
                    }
                    u.this.qt();
                }

                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj() {
                    u.this.xj((View) null);
                }
            });
        } else {
            this.hf.xj((com.bytedance.msdk.api.u.xj.c.hf) new com.bytedance.msdk.api.u.xj.c.w() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.8
                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj(View view) {
                    if (u.this.y != null) {
                        u.this.y.xj(view, 0);
                    }
                    u.this.qt();
                }

                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj() {
                    u.this.xj((View) null);
                }
            });
        }
    }

    private void g() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        if (wVar.gy()) {
            this.hf.xj((com.bytedance.msdk.api.u.xj.w.xj) new com.bytedance.msdk.api.u.xj.w.u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.5
                @Override // com.bytedance.msdk.api.u.xj.w.u
                public void xj(View view, String str, int i) {
                    if (u.this.y != null) {
                        u.this.y.xj(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w.u
                public void xj(float f, float f2) {
                    if (u.this.y != null) {
                        u.this.y.xj((View) null, f, f2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj(View view) {
                    if (u.this.y != null) {
                        u.this.y.xj(view, 0);
                    }
                    u.this.qt();
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj() {
                    u.this.xj((View) null);
                }
            });
        } else {
            this.hf.xj(new com.bytedance.msdk.api.u.xj.w.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.6
                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj(View view) {
                    if (u.this.y != null) {
                        u.this.y.xj(view, 0);
                    }
                    u.this.qt();
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj() {
                    u.this.xj((View) null);
                }
            });
        }
    }

    private void p() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        wVar.xj((com.bytedance.msdk.xj.hf.y) new com.bytedance.msdk.xj.hf.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.4
            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void f_() {
                if (u.this.hf.v() != null) {
                    u.this.hf.v().xj(0, "banner ad closed", false);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void hf(View view) {
                u.this.xj(view);
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void xj(View view) {
                if (u.this.y != null) {
                    u.this.y.xj(view, 0);
                }
                u.this.qt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        String str;
        long j;
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
        com.bytedance.msdk.hf.w wVar = this.hf;
        com.bytedance.msdk.kd.y.hf(wVar, this.w, 0, str2, j2, wVar.en());
    }

    private void tf() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        wVar.xj(new f() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.1
            @Override // com.bytedance.msdk.api.u.xj.c.f
            public void hf() {
                if (u.this.kd != null) {
                    u.this.kd.hf();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.c.f
            public void kd() {
                if (u.this.kd != null) {
                    u.this.kd.kd();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.c.f
            public void u() {
                if (u.this.kd != null) {
                    u.this.kd.u();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.c.f
            public void w() {
                if (u.this.kd != null) {
                    u.this.kd.w();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.c.f
            public void xj() {
                if (u.this.kd != null) {
                    u.this.kd.xj();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.c.f
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                String str;
                long j;
                long currentTimeMillis = System.currentTimeMillis();
                if (v.xj(u.this.hf)) {
                    str = v.hf();
                    j = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str = null;
                    j = -1;
                }
                com.bytedance.msdk.kd.y.xj(u.this.hf, u.this.w, (com.bytedance.msdk.api.xj) null, 2, 0, str, j);
                if (xjVar == null || u.this.kd == null) {
                    return;
                }
                u.this.kd.xj(xjVar.xj, -1);
            }

            @Override // com.bytedance.msdk.api.u.xj.c.f
            public void xj(long j, long j2) {
                if (u.this.kd != null) {
                    u.this.kd.xj(j, j2);
                }
            }
        });
        this.hf.xj(new com.bytedance.msdk.api.u.xj.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.2
            @Override // com.bytedance.msdk.api.u.xj.hf
            public void hf() {
            }

            @Override // com.bytedance.msdk.api.u.xj.hf
            public void xj() {
                if (u.this.c != null) {
                    u.this.c.xj();
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.hf
            public void hf(long j, long j2, String str, String str2) {
                if (u.this.c != null) {
                    u.this.c.w(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.hf
            public void xj(long j, long j2, int i, int i2, String str, String str2) {
                if (u.this.c != null) {
                    u.this.c.xj(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.hf
            public void xj(long j, long j2, String str, String str2) {
                if (u.this.c != null) {
                    u.this.c.hf(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.hf
            public void xj(long j, String str, String str2) {
                if (u.this.c != null) {
                    u.this.c.xj(j, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.hf
            public void xj(String str, String str2) {
                if (u.this.c != null) {
                    u.this.c.xj(str, str2);
                }
            }
        });
    }

    private void zg() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        int tj = wVar.tj();
        if (tj != 4) {
            if (tj == 5) {
                g();
                return;
            } else if (tj == 3) {
                p();
                return;
            }
        }
        am();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd d() {
        return new tf(new w(this.xj, this.hf, this.w));
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public Map<String, Object> f() {
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
            String xj = e.xj(com.bytedance.msdk.f.am.xj(this.w, this.hf, true));
            if (!TextUtils.isEmpty(xj)) {
                q.put("get_show_ecpm_info", xj);
            }
        }
        return com.bytedance.sdk.gromore.xj.hf.hf.xj(q, this.hf.dc());
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void kd() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            try {
                wVar.yo();
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void u() {
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar;
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            if (wVar.gy()) {
                zg();
                this.hf.p();
                xj(this.hf);
                if (this.hf.tj() != 3 || (hfVar = this.y) == null) {
                    return;
                }
                hfVar.xj((View) null, -1.0f, -2.0f);
                return;
            }
            com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.hf hfVar2 = this.f;
            if (hfVar2 == null) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 自渲染信息流转模板，开发者未提供MediationNativeToBannerListener，将无法展示该广告");
                return;
            }
            try {
                View xj = hfVar2.xj(new com.bytedance.sdk.gromore.xj.xj.u.d(this.hf) { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.3
                    @Override // com.bytedance.sdk.gromore.xj.xj.u.d, com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.hf.xj
                    public void xj(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.u uVar) {
                        u.this.xj(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.u.3.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                if (u.this.hf == null) {
                                    return false;
                                }
                                u.this.hf.xj(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.u.xj.c.tf.xj(uVar), null);
                                return false;
                            }
                        });
                    }
                });
                this.u = xj;
                if (xj != null) {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar3 = this.y;
                    if (hfVar3 != null) {
                        hfVar3.xj(xj, 0.0f, 0.0f);
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()返回null，将无法展示该广告");
                com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar4 = this.y;
                if (hfVar4 != null) {
                    hfVar4.xj((View) null, "渲染失败", -99999);
                }
            } catch (Throwable th) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                pl.xj(th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int w() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.nb();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.zg.w.hf.u y() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.uj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int hf() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.ss();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public View xj() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            if (wVar.gy()) {
                com.bytedance.msdk.kd.y.xj(this.w);
                if (this.hf.uh() != null) {
                    this.hf.uh().xj();
                }
                com.bytedance.msdk.hf.w wVar2 = this.hf;
                com.bytedance.msdk.kd.y.xj(wVar2, this.w, wVar2.z(), 0);
                View d = this.hf.d();
                this.u = d;
                return d;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.hf);
            com.bytedance.msdk.kd.y.xj(arrayList, this.w, 0);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar) {
        this.y = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj xjVar) {
        this.y = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        this.c = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public c xj(Activity activity) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.xj(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null || activity == null) {
            return;
        }
        wVar.xj(activity, xjVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(String str) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.a(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(int i) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.ra(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        this.kd = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(boolean z) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.tf(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        this.d = hfVar;
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(hfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(View view) {
        com.bytedance.msdk.hf.w wVar;
        String str;
        long j;
        if (this.w == null || (wVar = this.hf) == null) {
            return;
        }
        wVar.y(true);
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar = this.y;
        if (hfVar != null) {
            hfVar.hf(view, 0);
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.w.ra(), "show_listen") + "adSlotId：" + this.hf.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(this.hf.gj()));
        g xj = g.xj();
        StringBuilder sb = new StringBuilder();
        sb.append(this.w.ra());
        xj.c(sb.toString());
        g.xj().hf(this.w.ra());
        p.xj().hf(this.w.ra(), this.hf.cy());
        com.bytedance.msdk.core.f.pl.xj().hf(this.w.ra(), this.hf.cy());
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
        com.bytedance.msdk.kd.y.xj(this.hf, this.w, 0, str2, j2, j3);
        com.bytedance.msdk.core.c.w.xj(this.w.ra(), this.hf);
    }

    private void xj(com.bytedance.msdk.hf.w wVar) {
        if (com.bytedance.msdk.core.hf.hf().j()) {
            com.bytedance.msdk.kd.y.xj(wVar, this.w, v.xj(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z, Handler.Callback callback) {
        com.bytedance.msdk.kd.y.xj(this.w);
        if (this.hf != null) {
            zg();
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
            com.bytedance.msdk.kd.y.xj(wVar, this.w, wVar.z(), 0, hashMap);
            return;
        }
        com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.w, 0);
    }
}
