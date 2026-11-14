package com.bytedance.sdk.gromore.xj.xj.c.u;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.u.xj.c.f;
import com.bytedance.msdk.core.f.p;
import com.bytedance.msdk.f.am;
import com.bytedance.msdk.f.e;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.w.u.d;
import com.bytedance.sdk.gromore.xj.xj.u.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import com.bytedance.sdk.openadsdk.zg.w.hf.pl;
import com.bytedance.sdk.openadsdk.zg.w.hf.tf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends tf {
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj c;
    private com.bytedance.sdk.openadsdk.zg.w.xj.w d;
    private com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w f;
    private com.bytedance.msdk.hf.w hf;
    private com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf kd;
    private com.bytedance.sdk.openadsdk.zg.w.xj.hf tf;
    private com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj u;
    private com.bytedance.msdk.api.xj.hf w;
    private d xj;
    private View y;

    public hf(d dVar, com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.api.xj.hf hfVar) {
        this.xj = dVar;
        this.hf = wVar;
        if (wVar != null && wVar.tj() == 3) {
            this.hf.c(true);
        }
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

    private void en() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        if (wVar.gy()) {
            this.hf.xj((com.bytedance.msdk.api.u.xj.w.xj) new com.bytedance.msdk.api.u.xj.w.u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.8
                @Override // com.bytedance.msdk.api.u.xj.w.u
                public void xj(View view, String str, int i) {
                    if (hf.this.f instanceof com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) hf.this.f).xj(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w.u
                public void xj(float f, float f2) {
                    if (hf.this.f != null) {
                        hf.this.f.xj(hf.this.y, f, f2, true);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj(View view) {
                    hf.this.xj(view);
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj() {
                    hf.this.hf((View) null);
                }
            });
        } else {
            this.hf.xj(new com.bytedance.msdk.api.u.xj.w.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.9
                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj(View view) {
                    hf.this.xj(view);
                }

                @Override // com.bytedance.msdk.api.u.xj.w.xj
                public void xj() {
                    hf.this.hf((View) null);
                }
            });
        }
    }

    private void ff() {
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

    private void io() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(new f() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.1
                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void hf() {
                    if (hf.this.u != null) {
                        hf.this.u.hf(hf.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void kd() {
                    if (hf.this.u != null) {
                        hf.this.u.kd(hf.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void u() {
                    if (hf.this.u != null) {
                        hf.this.u.u(hf.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void w() {
                    if (hf.this.u != null) {
                        hf.this.u.w(hf.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void xj() {
                    if (hf.this.u != null) {
                        hf.this.u.xj(hf.this);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void xj(com.bytedance.msdk.api.xj xjVar) {
                    String str;
                    long j;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (v.xj(hf.this.hf)) {
                        str = v.hf();
                        j = System.currentTimeMillis() - currentTimeMillis;
                    } else {
                        str = null;
                        j = -1;
                    }
                    com.bytedance.msdk.kd.y.xj(hf.this.hf, hf.this.w, (com.bytedance.msdk.api.xj) null, 2, 0, str, j);
                    if (xjVar == null || hf.this.u == null) {
                        return;
                    }
                    hf.this.u.xj(xjVar.xj, -1);
                }

                @Override // com.bytedance.msdk.api.u.xj.c.f
                public void xj(long j, long j2) {
                    if (hf.this.u != null) {
                        hf.this.u.xj(j, j2);
                    }
                }
            });
            this.hf.xj(new com.bytedance.msdk.api.u.xj.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.3
                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf() {
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj() {
                    if (hf.this.d != null) {
                        hf.this.d.xj();
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void hf(long j, long j2, String str, String str2) {
                    if (hf.this.d != null) {
                        hf.this.d.w(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, long j2, int i, int i2, String str, String str2) {
                    if (hf.this.d != null) {
                        hf.this.d.xj(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, long j2, String str, String str2) {
                    if (hf.this.d != null) {
                        hf.this.d.hf(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(long j, String str, String str2) {
                    if (hf.this.d != null) {
                        hf.this.d.xj(j, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.hf
                public void xj(String str, String str2) {
                    if (hf.this.d != null) {
                        hf.this.d.xj(str, str2);
                    }
                }
            });
            this.hf.xj(new com.bytedance.msdk.api.u.xj.c.d() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.4
                @Override // com.bytedance.msdk.api.u.xj.c.d
                public void xj(int i) {
                    if (hf.this.kd != null) {
                        hf.this.kd.xj(i);
                    }
                }
            });
        }
    }

    private void j() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        wVar.xj((com.bytedance.msdk.xj.hf.y) new com.bytedance.msdk.xj.hf.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.7
            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void f_() {
                if (hf.this.hf.v() != null) {
                    hf.this.hf.v().xj(0, "banner ad closed", false);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void hf(View view) {
                hf.this.hf(view);
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void xj(com.bytedance.msdk.api.xj xjVar) {
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.xj
            public void xj(View view) {
                hf.this.xj(view);
            }
        });
    }

    private void l() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null) {
            return;
        }
        if (wVar.gy()) {
            this.hf.xj((com.bytedance.msdk.api.u.xj.c.hf) new com.bytedance.msdk.api.u.xj.c.y() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.10
                @Override // com.bytedance.msdk.api.u.xj.c.y
                public void xj(View view, String str, int i) {
                    if (hf.this.f instanceof com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) {
                        ((com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) hf.this.f).xj(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.y
                public void xj(float f, float f2) {
                    if (hf.this.f != null) {
                        hf.this.f.xj(hf.this.y, f, f2, true);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj(View view) {
                    hf.this.xj(view);
                }

                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj() {
                    hf.this.hf((View) null);
                }
            });
        } else {
            this.hf.xj((com.bytedance.msdk.api.u.xj.c.hf) new com.bytedance.msdk.api.u.xj.c.w() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.2
                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj(View view) {
                    hf.this.xj(view);
                }

                @Override // com.bytedance.msdk.api.u.xj.c.hf
                public void xj() {
                    hf.this.hf((View) null);
                }
            });
        }
    }

    private void q() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar == null || wVar.gy()) {
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "当前广告为自渲染广告，不能使用模版接口进行渲染，请使用registerViewForInteraction进行渲染");
    }

    private void z() {
        int tj = this.hf.tj();
        if (tj != 4) {
            if (tj == 5) {
                en();
                return;
            } else if (tj == 3) {
                j();
                return;
            }
        }
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public pl am() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        return new g(wVar != null ? wVar.ut() : null);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public String d() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        return wVar != null ? wVar.nt() : "";
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
        return new com.bytedance.sdk.gromore.xj.xj.u.tf(new w(this.xj, this.hf, this.w));
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
        return new com.bytedance.sdk.gromore.xj.xj.u.u(this.hf);
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
        com.bytedance.msdk.kd.y.xj(this.w);
        if (this.hf.uh() != null) {
            this.hf.uh().xj();
        }
        com.bytedance.msdk.hf.w wVar2 = this.hf;
        com.bytedance.msdk.kd.y.xj(wVar2, this.w, wVar2.z(), 0);
        View d = this.hf.d();
        this.y = d;
        return d;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public List<pl> qt() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.hf.w wVar = this.hf;
        List<String> mg = wVar != null ? wVar.mg() : null;
        com.bytedance.msdk.hf.w wVar2 = this.hf;
        String he = wVar2 != null ? wVar2.he() : null;
        if (mg != null) {
            if (mg.size() != 0) {
                Iterator<String> it = mg.iterator();
                while (it.hasNext()) {
                    arrayList.add(new g(it.next()));
                }
            } else if (!TextUtils.isEmpty(he)) {
                com.bytedance.msdk.hf.w wVar3 = this.hf;
                int zm = wVar3 != null ? wVar3.zm() : 0;
                com.bytedance.msdk.hf.w wVar4 = this.hf;
                arrayList.add(new g(he, zm, wVar4 != null ? wVar4.ey() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void ra() {
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar;
        q();
        if (this.hf != null) {
            z();
            this.hf.p();
            xj(this.hf);
            if (this.hf.tj() != 3 || (wVar = this.f) == null) {
                return;
            }
            wVar.xj(this.y, -1.0f, -2.0f, true);
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
        return new com.bytedance.sdk.gromore.xj.xj.u.hf(this.hf);
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
    public String c() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.vw();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public pl kd() {
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
                View view = this.y;
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
                View view = this.y;
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

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public Bitmap y() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.ho();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public com.bytedance.sdk.openadsdk.ht.xj.hf.hf.xj hf() {
        return new com.bytedance.sdk.gromore.xj.xj.u.w(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void hf(Activity activity) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.hf(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.xj xjVar) {
        this.u = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void hf(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public void xj(com.bytedance.sdk.openadsdk.ht.xj.hf.xj.hf hfVar) {
        this.kd = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.tf
    public double xj() {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.bh();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(View view) {
        com.bytedance.msdk.hf.w wVar;
        String str;
        long j;
        if (this.w == null || (wVar = this.hf) == null) {
            return;
        }
        wVar.y(true);
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar2 = this.f;
        if (wVar2 instanceof com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) {
            ((com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) wVar2).hf();
        }
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar = this.c;
        if (xjVar != null) {
            xjVar.xj(this);
        }
        com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.w.ra(), "show_listen") + "adSlotId：" + this.hf.cy() + "，广告类型：" + com.bytedance.msdk.hf.xj.xj(this.hf.gj()));
        com.bytedance.msdk.core.f.g xj = com.bytedance.msdk.core.f.g.xj();
        StringBuilder sb = new StringBuilder();
        sb.append(this.w.ra());
        xj.c(sb.toString());
        com.bytedance.msdk.core.f.g.xj().hf(this.w.ra());
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
        com.bytedance.msdk.api.xj.hf hfVar = this.w;
        com.bytedance.msdk.core.c.w.xj(hfVar != null ? hfVar.ra() : "", this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public c xj(Activity activity) {
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            return wVar.xj(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public c xj(Dialog dialog, Integer[] numArr) {
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
            xj(false, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.5
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (TextUtils.equals(hf.this.hf.lw(), MediationConstant.ADN_PANGLE)) {
                        hf.this.hf.xj(viewGroup, list, list2, list3, list4, view);
                        return false;
                    }
                    hf.this.hf.xj(null, viewGroup, list2, list3, list4, null, list);
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
            xj(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.hf.6
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    hf.this.hf.xj(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.u.xj.c.tf.xj(uVar), null);
                    return false;
                }
            });
        }
    }

    private void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar) {
        this.c = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        this.d = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.g
    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar) {
        this.f = wVar;
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
        this.tf = hfVar;
        com.bytedance.msdk.hf.w wVar = this.hf;
        if (wVar != null) {
            wVar.xj(hfVar);
        }
    }

    private void xj(boolean z, Handler.Callback callback) {
        com.bytedance.msdk.kd.y.xj(this.w);
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
            com.bytedance.msdk.kd.y.xj(wVar, this.w, wVar.z(), 0, hashMap);
            return;
        }
        com.bytedance.msdk.kd.y.xj((List<com.bytedance.msdk.hf.w>) null, this.w, 0);
    }

    private void xj(com.bytedance.msdk.hf.w wVar) {
        if (com.bytedance.msdk.core.hf.hf().j()) {
            com.bytedance.msdk.kd.y.xj(wVar, this.w, v.xj(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(View view) {
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.w wVar = this.f;
        if (wVar instanceof com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) {
            ((com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.kd) wVar).xj();
        }
        com.bytedance.sdk.openadsdk.dk.xj.hf.xj.xj xjVar = this.c;
        if (xjVar != null) {
            xjVar.xj(view, this);
        }
        ff();
    }
}
