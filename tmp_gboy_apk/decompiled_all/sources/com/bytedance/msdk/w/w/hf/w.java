package com.bytedance.msdk.w.w.hf;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.core.f.am;
import com.bytedance.msdk.core.tf.d;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.f.v;
import com.bytedance.msdk.f.z;
import com.bytedance.msdk.w.w.hf.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements xj, com.bytedance.msdk.w.xj.hf {
    private long c;
    private com.bytedance.msdk.w.y.xj.hf hf;
    private com.bytedance.msdk.api.xj.hf w;
    private com.bytedance.msdk.w.y.hf.hf xj;
    private long y;
    private com.bytedance.msdk.w.xj.xj u = null;
    private volatile long kd = -1;

    private List<com.bytedance.msdk.hf.w> hf(List<com.bytedance.msdk.hf.w> list) {
        List<com.bytedance.msdk.hf.w> list2;
        String str;
        long j;
        ArrayList arrayList = new ArrayList();
        if (q.xj(list)) {
            list2 = list;
        } else {
            list2 = list;
            arrayList.addAll(list2);
        }
        if (this.xj != null && !q.hf(list2) && (this.xj.xj() || this.xj.dk())) {
            for (com.bytedance.msdk.hf.w wVar : list2) {
                z.xj(wVar, this.xj.f(), this.w, true);
                double hl = this.w.hl();
                if (hl > 0.0d && hl > wVar.da()) {
                    arrayList.remove(wVar);
                    String valueOf = String.valueOf(wVar.da());
                    String aq = wVar.aq();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (v.xj(this.xj.f())) {
                        str = v.hf();
                        j = System.currentTimeMillis() - currentTimeMillis;
                    } else {
                        str = null;
                        j = -1;
                    }
                    com.bytedance.msdk.kd.y.xj(new com.bytedance.msdk.api.xj(50100, com.bytedance.msdk.api.xj.xj(50100)), this.w, this.xj.f(), this.xj.w(), this.xj.c(), this.xj.y(), xj(this.xj.g()), this.y, valueOf, aq, str, j);
                }
            }
        }
        return arrayList;
    }

    private void w(List<com.bytedance.msdk.hf.w> list) {
        com.bytedance.msdk.w.y.hf.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(list, hfVar.f());
        }
        xj(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.w.2
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.xj != null) {
                    com.bytedance.msdk.core.w.w.w(w.this.xj.g(), w.this.xj.hf(), w.this.xj.pl());
                }
            }
        });
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(List<com.bytedance.msdk.hf.w> list) {
        w wVar;
        String str;
        if (list == null) {
            return;
        }
        long j = -1;
        if (this.kd == -1) {
            this.kd = SystemClock.elapsedRealtime();
        }
        this.y = System.currentTimeMillis() - this.c;
        Iterator<com.bytedance.msdk.hf.w> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.msdk.hf.w next = it.next();
            com.bytedance.msdk.api.xj.hf hfVar = this.w;
            com.bytedance.msdk.w.y.hf.hf hfVar2 = this.xj;
            com.bytedance.msdk.w.y.xj.hf hfVar3 = this.hf;
            d ff = hfVar3 != null ? hfVar3.ff() : null;
            com.bytedance.msdk.w.y.hf.hf hfVar4 = this.xj;
            com.bytedance.msdk.w.f.w.xj(next, hfVar, hfVar2, ff, hfVar4 != null ? xj(hfVar4.g()) : "");
        }
        List<com.bytedance.msdk.hf.w> hf = hf(list);
        if (hf.size() == 0) {
            xj(new com.bytedance.msdk.api.xj(50100, com.bytedance.msdk.api.xj.xj(50100)), false);
            return;
        }
        if (this.xj != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (v.xj(this.xj.f())) {
                String hf2 = v.hf();
                j = System.currentTimeMillis() - currentTimeMillis;
                str = hf2;
            } else {
                str = null;
            }
            long j2 = j;
            int i = list.size() > 0 ? 20000 : 820001;
            if (this.xj.xj() || this.xj.dk()) {
                for (com.bytedance.msdk.hf.w wVar2 : list) {
                    if (wVar2 != null) {
                        xj(i, wVar2, 1, str, j2);
                    }
                }
                wVar = this;
            } else {
                wVar = this;
                wVar.xj(i, hf.get(0), hf.size(), str, j2);
            }
            if (wVar.xj.ra() && !q.hf(list)) {
                com.bytedance.msdk.kd.y.xj(list.get(0), wVar.w, wVar.xj.f(), wVar.y);
            }
        } else {
            wVar = this;
        }
        w(hf);
        if (wVar.xj.f() != null && wVar.xj.f().g() == 10 && wVar.xj.f().y() == 1) {
            xj(hf, (com.bytedance.msdk.api.xj) null);
        }
    }

    private void hf(com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.w.y.hf.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(xjVar, hfVar.f());
        }
    }

    private void hf() {
        com.bytedance.msdk.w.y.hf.hf hfVar;
        com.bytedance.msdk.w.y.hf.hf hfVar2 = this.xj;
        hfVar2.xj(com.bytedance.msdk.w.f.w.xj(this.w, hfVar2));
        this.xj.hf(this.hf.pl().ff());
        if (!this.xj.tf()) {
            if (this.xj.p()) {
                this.u = com.bytedance.msdk.w.w.hf.xj.u.xj(this.xj, this);
            } else if (com.bytedance.msdk.core.c.w.xj(this.xj.f())) {
                this.u = new com.bytedance.msdk.w.w.hf.xj.w(this);
            }
        } else {
            Context context = com.bytedance.msdk.core.hf.getContext();
            com.bytedance.msdk.w.y.hf.hf hfVar3 = this.xj;
            com.bytedance.msdk.y.hf.xj(context, hfVar3 != null ? hfVar3.g() : "");
            if (com.bytedance.msdk.y.hf.xj.xj(this.xj.g()) == null) {
                com.bytedance.msdk.kd.y.xj("", this.hf.p(), this.w, this.xj.f(), new com.bytedance.msdk.api.xj(49014, "创建自定义广告对象 configuration is null"));
            } else {
                com.bytedance.msdk.core.tf.xj xj = com.bytedance.msdk.c.xj.hf.xj().xj(this.xj.g());
                if (xj == null) {
                    com.bytedance.msdk.kd.y.xj("", (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, "创建自定义广告对象 adNetworkConfValue is null"));
                } else if (xj.u() == null) {
                    com.bytedance.msdk.kd.y.xj("", (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, "创建自定义广告对象 getGMCustomConfig is null"));
                } else {
                    com.bytedance.msdk.api.u.xj.hf.w.xj xj2 = xj.u().xj(this.xj.io(), this.xj.qt());
                    if (xj2 == null) {
                        com.bytedance.msdk.kd.y.xj("", (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, "创建自定义广告对象 adConfig is null"));
                    } else if (com.bytedance.msdk.w.f.w.xj(xj2)) {
                        this.u = com.bytedance.msdk.w.w.hf.xj.u.xj(xj2.xj(), this.xj, this);
                    } else {
                        com.bytedance.msdk.kd.y.xj("", (com.bytedance.msdk.hf.w) null, (com.bytedance.msdk.api.xj.hf) null, (tf) null, new com.bytedance.msdk.api.xj(49013, "创建自定义广告对象 check className false className is " + xj2.xj()));
                    }
                }
            }
        }
        com.bytedance.msdk.w.xj.xj xjVar = this.u;
        if (xjVar != null) {
            String xj3 = xjVar.xj(this.xj.g());
            if (!TextUtils.isEmpty(xj3) && (hfVar = this.xj) != null && !TextUtils.isEmpty(hfVar.pl()) && !this.xj.tf()) {
                com.bytedance.msdk.core.kd.xj.xj.xj().u(this.xj.pl(), xj3);
            }
            xj(this.xj, this.hf, null, xj3);
            com.bytedance.msdk.w.xj.xj xjVar2 = this.u;
            Context context2 = this.hf.getContext();
            com.bytedance.msdk.w.y.hf.hf hfVar4 = this.xj;
            com.bytedance.msdk.api.xj.hf hfVar5 = this.w;
            xjVar2.xj(context2, hfVar4, hfVar5, com.bytedance.msdk.w.f.w.xj(hfVar4, hfVar5, this.hf.q()));
            if (this.xj.tf()) {
                return;
            }
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(this.xj.hf(), this.xj.pl(), this.xj.f(), this.xj.w());
            return;
        }
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "**********【重要】" + this.xj.g() + "创建失败，请检查adapter是否接入 **********");
        com.bytedance.msdk.kd.y.xj(this.xj.f(), this.w, this.xj.c(), this.xj.y());
        xj(this.xj, this.hf, new com.bytedance.msdk.api.xj("create adn loader fail"), "");
        xj(new com.bytedance.msdk.api.xj("create adn loader fail"));
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(com.bytedance.msdk.api.xj xjVar) {
        xj(xjVar, true);
    }

    private void xj(com.bytedance.msdk.api.xj xjVar, boolean z) {
        long j;
        String str;
        com.bytedance.msdk.api.xj xjVar2;
        this.y = System.currentTimeMillis() - this.c;
        com.bytedance.msdk.w.y.hf.hf hfVar = this.xj;
        if (hfVar != null && hfVar.f() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (v.xj(this.xj.f())) {
                String hf = v.hf();
                j = System.currentTimeMillis() - currentTimeMillis;
                str = hf;
            } else {
                j = -1;
                str = null;
            }
            long j2 = j;
            if (!this.xj.ra() && z) {
                xjVar2 = xjVar;
                com.bytedance.msdk.kd.y.xj(xjVar2, this.w, this.xj.f(), this.xj.w(), this.xj.c(), this.xj.y(), xj(this.xj.g()), this.y, (String) null, (String) null, str, j2);
            } else {
                xjVar2 = xjVar;
                com.bytedance.msdk.kd.y.xj(xjVar2, this.w, this.xj.f(), this.xj.w(), this.xj.c(), this.xj.y(), xj(this.xj.g()), this.y);
            }
            tf f = this.xj.f();
            if (xjVar2 != null) {
                if (this.w != null) {
                    if (com.bytedance.msdk.hf.hf.hf) {
                        StringBuilder sb = new StringBuilder();
                        com.bytedance.msdk.api.xj.hf hfVar2 = this.w;
                        sb.append(com.bytedance.msdk.xj.kd.kd.xj(hfVar2 != null ? hfVar2.ra() : "", "fill_fail"));
                        sb.append("AdNetWorkName[");
                        sb.append(f.qt());
                        sb.append("] AdUnitId[");
                        sb.append(f.yo());
                        sb.append("] AdType[");
                        sb.append(com.bytedance.msdk.hf.xj.xj(this.w.ht(), f.y(), f));
                        sb.append("] 请求失败 (loadSort=");
                        sb.append(f.dk());
                        sb.append(",showSort=");
                        sb.append(f.et());
                        sb.append("),error=");
                        sb.append(xjVar2.w);
                        sb.append(",msg=");
                        sb.append(xjVar2.u);
                        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        com.bytedance.msdk.api.xj.hf hfVar3 = this.w;
                        sb2.append(com.bytedance.msdk.xj.kd.kd.xj(hfVar3 != null ? hfVar3.ra() : "", "fill_fail"));
                        sb2.append("AdNetWorkName[");
                        sb2.append(f.qt());
                        sb2.append("] AdType[");
                        sb2.append(com.bytedance.msdk.hf.xj.xj(this.w.ht(), f.y(), f));
                        sb2.append("] 请求失败 error=");
                        sb2.append(xjVar2.w);
                        sb2.append(",msg=");
                        sb2.append(xjVar2.u);
                        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, sb2.toString());
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(xjVar2.w);
                String sb4 = sb3.toString();
                String xj = com.bytedance.msdk.xj.xj.xj(this.xj.f().qt(), xjVar2.u);
                am xj2 = am.xj();
                com.bytedance.msdk.api.xj.hf hfVar4 = this.w;
                if (xj2.xj(hfVar4 == null ? null : hfVar4.ra(), this.xj.f().e())) {
                    am xj3 = am.xj();
                    com.bytedance.msdk.api.xj.hf hfVar5 = this.w;
                    xj3.xj(hfVar5 != null ? hfVar5.ra() : null, this.xj.f().qt(), this.xj.f().yo(), com.bytedance.msdk.xj.xj.xj(this.xj.f().qt(), sb4, xj));
                } else {
                    com.bytedance.msdk.core.f.w.xj().xj(this.xj.f().qt(), this.xj.f().yo(), com.bytedance.msdk.xj.xj.xj(this.xj.f().qt(), sb4, xj));
                }
            }
        }
        hf(xjVar);
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(final List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.api.xj xjVar) {
        if (list != null) {
            for (com.bytedance.msdk.hf.w wVar : list) {
                if (wVar != null) {
                    wVar.d(true);
                    com.bytedance.msdk.api.xj.hf hfVar = this.w;
                    com.bytedance.msdk.w.y.hf.hf hfVar2 = this.xj;
                    com.bytedance.msdk.w.y.xj.hf hfVar3 = this.hf;
                    d ff = hfVar3 == null ? null : hfVar3.ff();
                    com.bytedance.msdk.w.y.hf.hf hfVar4 = this.xj;
                    com.bytedance.msdk.w.f.w.xj(wVar, hfVar, hfVar2, ff, hfVar4 != null ? xj(hfVar4.g()) : "");
                    xj(wVar);
                }
            }
        }
        if (xjVar != null && xjVar.xj == 30010 && com.bytedance.msdk.xj.xj.xj()) {
            com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.w.1
                @Override // java.lang.Runnable
                public void run() {
                    if (w.this.xj != null && w.this.xj.ra()) {
                        com.bytedance.msdk.kd.y.xj(!q.hf(list) ? (com.bytedance.msdk.hf.w) list.get(0) : null, w.this.w, w.this.xj.f());
                    }
                    w.this.xj();
                }
            }, 1000L);
            return;
        }
        com.bytedance.msdk.w.y.hf.hf hfVar5 = this.xj;
        if (hfVar5 != null && hfVar5.ra()) {
            com.bytedance.msdk.kd.y.xj(q.hf(list) ? null : list.get(0), this.w, this.xj.f());
        }
        xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        com.bytedance.msdk.w.y.hf.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.d();
        }
    }

    private void xj(Runnable runnable) {
        com.bytedance.msdk.xj.kd.y.xj(runnable);
    }

    @Override // com.bytedance.msdk.w.xj.hf
    public void xj(com.bytedance.msdk.hf.w wVar, String str) {
        if (wVar == null || wVar.ci() != 5) {
            return;
        }
        com.bytedance.msdk.kd.y.xj(wVar, this.w, str);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj
    public void xj(xj.InterfaceC0081xj interfaceC0081xj) {
        if (interfaceC0081xj == null) {
            return;
        }
        this.c = System.currentTimeMillis();
        this.xj = interfaceC0081xj.xj();
        com.bytedance.msdk.w.y.xj.hf hf = interfaceC0081xj.hf();
        this.hf = hf;
        this.w = hf.v();
        if (this.hf.getContext() == null) {
            com.bytedance.msdk.api.xj xjVar = new com.bytedance.msdk.api.xj("request adn context is null");
            xj(this.xj, this.hf, xjVar, "");
            xj(xjVar);
        } else {
            if (this.xj != null) {
                hf();
                return;
            }
            com.bytedance.msdk.api.xj xjVar2 = new com.bytedance.msdk.api.xj("request adn waterfall request is null");
            xj(this.xj, this.hf, xjVar2, "");
            xj(xjVar2);
        }
    }

    private void xj(com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.w.y.xj.hf hfVar2, com.bytedance.msdk.api.xj xjVar, String str) {
        if (hfVar == null || hfVar2 == null || hfVar.f() == null) {
            return;
        }
        tf f = hfVar.f();
        String xj = TextUtils.isEmpty(str) ? com.bytedance.msdk.core.kd.xj.xj.xj().xj(f.yo()) : str;
        if (!f.z()) {
            com.bytedance.msdk.kd.y.xj(f, this.w, xj, hfVar.kd(), hfVar.c() == 4 ? 3 : 0, hfVar.w(), hfVar.c(), hfVar.y(), xjVar, hfVar.u(), hfVar2.ff().kd, false);
        } else if (f.ai() != null) {
            com.bytedance.msdk.kd.y.xj(f, this.w, xj);
        }
    }

    private void xj(com.bytedance.msdk.hf.w wVar) {
        com.bytedance.msdk.w.y.hf.hf hfVar;
        if (this.hf == null || this.w == null || (hfVar = this.xj) == null || hfVar.f() == null) {
            return;
        }
        tf f = this.xj.f();
        if (!this.xj.ra() && wVar != null) {
            com.bytedance.msdk.kd.y.xj(this.w, wVar, this.xj.f());
        }
        if (com.bytedance.msdk.hf.hf.hf) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.w.ra(), "fill") + "AdNetWorkName[" + f.qt() + "] AdUnitId[" + f.yo() + "] AdType[" + com.bytedance.msdk.hf.xj.xj(this.w.ht(), f.y(), f) + "] 视频缓存成功 (loadSort=" + f.dk() + ",showSort=" + f.et() + ")");
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.w.ra(), "fill") + "AdNetWorkName[" + f.qt() + "] AdType[" + com.bytedance.msdk.hf.xj.xj(this.w.ht(), f.y(), f) + "] 视频缓存成功 ");
    }

    private void xj(int i, com.bytedance.msdk.hf.w wVar, int i2, String str, long j) {
        com.bytedance.msdk.w.y.hf.hf hfVar;
        if (this.hf == null || this.w == null || (hfVar = this.xj) == null || hfVar.f() == null) {
            return;
        }
        tf f = this.xj.f();
        String str2 = i == 20000 ? "load success" : "请求成功，但无广告可用";
        boolean z = this.hf.ff().y;
        if (!this.xj.ra() && wVar != null) {
            com.bytedance.msdk.kd.y.xj(wVar, i, str2, this.y, this.w, this.xj.w(), i2, z ? 1 : 0, str, j, this.kd != -1 ? SystemClock.elapsedRealtime() - this.kd : -1L);
        }
        if (com.bytedance.msdk.hf.hf.hf) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.w.ra(), "fill") + "AdNetWorkName[" + f.qt() + "] AdUnitId[" + f.yo() + "] AdType[" + com.bytedance.msdk.hf.xj.xj(this.w.ht(), f.y(), f) + "] 请求成功 (loadSort=" + f.dk() + ",showSort=" + f.et() + ")");
            return;
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.w.ra(), "fill") + "AdNetWorkName[" + f.qt() + "] AdType[" + com.bytedance.msdk.hf.xj.xj(this.w.ht(), f.y(), f) + "] 请求成功");
    }

    private String xj(String str) {
        com.bytedance.msdk.xj.xj.u xj = com.bytedance.msdk.y.hf.hf.xj().xj(str);
        if (xj != null) {
            return xj.hf();
        }
        return null;
    }
}
