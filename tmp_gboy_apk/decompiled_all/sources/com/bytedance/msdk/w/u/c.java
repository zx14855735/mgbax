package com.bytedance.msdk.w.u;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.hf.w;
import com.bytedance.msdk.w.w.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends hf {
    private com.bytedance.msdk.api.u.xj.w hf;
    private com.bytedance.msdk.api.u.xj.w.hf xj;
    private xj.InterfaceC0086xj zg;

    public c(Context context) {
        super(context);
    }

    private void w(List<com.bytedance.msdk.hf.w> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.hf.w wVar = (com.bytedance.msdk.hf.w) it.next();
            if (wVar != null && !wVar.tu() && wVar.ff(this.kd)) {
                list.add(wVar);
            }
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void c() {
        List<com.bytedance.msdk.hf.w> xj;
        if (this.xj == null || (xj = xj(this.w.jk(), this.y.x())) == null || xj.size() <= 0) {
            return;
        }
        if (com.bytedance.msdk.xj.kd.w.hf()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "返回给外部开发者的广告数量：sumList.size=" + xj.size());
        }
        CopyOnWriteArrayList<com.bytedance.msdk.hf.w> copyOnWriteArrayList = new CopyOnWriteArrayList<>(this.w.jk());
        for (com.bytedance.msdk.hf.w wVar : xj) {
            if (wVar != null) {
                wVar.kd(true);
                if (wVar.my() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, wVar.cy(), this.y.kd())) {
                    com.bytedance.msdk.w.f.y.xj(wVar, this.kd, wVar.cy());
                    xj(copyOnWriteArrayList, wVar);
                }
                xj(this.w.c(), wVar);
                xj(this.w.f(), wVar);
                xj(this.w.d(), wVar);
                xj(this.w.tf(), wVar);
            }
        }
        com.bytedance.msdk.core.kd.xj.xj xj2 = com.bytedance.msdk.core.kd.xj.xj.xj();
        String str = this.kd;
        com.bytedance.msdk.api.xj.hf hfVar = this.y;
        xj2.xj(copyOnWriteArrayList, str, hfVar, hfVar.kd(), null);
        this.xj.xj(xj);
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
        com.bytedance.msdk.api.u.xj.w wVar;
        com.bytedance.msdk.api.u.xj.w.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(xjVar);
            if (this.p != 0 || (wVar = this.hf) == null) {
                return;
            }
            this.p = 2;
            wVar.xj(xjVar);
        }
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.w.hf hfVar2) {
        xj(hfVar);
        this.xj = hfVar2;
        d();
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.api.xj xjVar) {
        super.xj(list, xjVar);
        if (!(this.xj instanceof com.bytedance.msdk.api.u.xj.w.kd) || q.xj(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.hf.w wVar : list) {
            wVar.xj(new w.xj() { // from class: com.bytedance.msdk.w.u.c.1
                @Override // com.bytedance.msdk.hf.w.xj
                public void xj() {
                    c.this.f10153pl = true;
                }

                @Override // com.bytedance.msdk.hf.w.xj
                public void xj(com.bytedance.msdk.hf.w wVar2) {
                    c.this.xj(wVar2, -1);
                }
            });
            arrayList.add(wVar);
        }
    }

    private boolean hf(String str, List<com.bytedance.msdk.hf.w> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.bytedance.msdk.hf.w wVar : list) {
            if (wVar != null && TextUtils.equals(str, wVar.cy())) {
                return true;
            }
        }
        return false;
    }

    private void w() {
        try {
            List<com.bytedance.msdk.core.tf.tf> hf = hf();
            if (hf == null || hf.size() <= 0) {
                return;
            }
            for (com.bytedance.msdk.core.tf.tf tfVar : hf) {
                if (tfVar != null) {
                    String yo = tfVar.yo();
                    if (com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, yo, this.y.kd())) {
                        if (tfVar.v() == 100) {
                            xj(yo, this.w.c());
                        } else if (tfVar.v() == 0) {
                            xj(yo, this.w.f());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void xj(String str) {
        com.bytedance.msdk.api.u.xj.w wVar;
        if (this.p != 0 || (wVar = this.hf) == null) {
            return;
        }
        this.p = 1;
        wVar.xj(str);
    }

    public void xj(String str, com.bytedance.msdk.api.u.xj.w.hf hfVar) {
        if (this.p != 1) {
            if (hfVar != null) {
                hfVar.xj(new com.bytedance.msdk.api.xj(10015, com.bytedance.msdk.api.xj.xj(10015)));
            }
        } else if (this.tf) {
            if (hfVar != null) {
                hfVar.xj(new com.bytedance.msdk.api.xj(40047, com.bytedance.msdk.api.xj.xj(40047)));
            }
        } else {
            this.tf = true;
            this.xj = hfVar;
            xj.InterfaceC0086xj interfaceC0086xj = this.zg;
            if (interfaceC0086xj != null) {
                interfaceC0086xj.xj(str);
            }
        }
    }

    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.u.xj.w wVar) {
        xj(hfVar);
        this.hf = wVar;
        if (this.w.pl() != null && this.w.pl().g()) {
            this.zg = d();
        } else if (wVar != null) {
            wVar.xj(new com.bytedance.msdk.api.xj(10014, com.bytedance.msdk.api.xj.xj(10014)));
        }
    }

    @Override // com.bytedance.msdk.w.u.hf
    public void xj() {
        super.xj();
        this.xj = null;
    }

    private List<com.bytedance.msdk.hf.w> xj(List<com.bytedance.msdk.hf.w> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        w(list);
        w();
        final ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.msdk.hf.w> it = list.iterator();
        while (it.hasNext() && arrayList.size() < i) {
            com.bytedance.msdk.hf.w next = it.next();
            next.xj(new w.xj() { // from class: com.bytedance.msdk.w.u.c.2
                @Override // com.bytedance.msdk.hf.w.xj
                public void xj() {
                    c.this.f10153pl = true;
                }

                @Override // com.bytedance.msdk.hf.w.xj
                public void xj(com.bytedance.msdk.hf.w wVar) {
                    int i2 = 0;
                    while (i2 < arrayList.size() && wVar != arrayList.get(i2)) {
                        i2++;
                    }
                    c.this.xj(wVar, i2);
                }
            });
            arrayList.add(next);
            if (com.bytedance.msdk.xj.kd.w.hf()) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "");
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd, "show") + "返回给开发者最终广告：slotId=" + next.cy() + ",slotType:" + next.qi() + ",cpm=" + next.da() + ",广告类型：" + com.bytedance.msdk.hf.xj.xj(next.gj()) + ",ImageMode=" + next.ss() + ",showSort=" + next.kc() + ",isExpressAd=" + next.gy());
            }
            it.remove();
        }
        xj(arrayList);
        return arrayList;
    }

    public void xj(com.bytedance.msdk.hf.w wVar, int i) {
        if (wVar != null && wVar.my() && com.bytedance.msdk.core.kd.xj.xj.xj().u(this.kd, wVar.cy(), this.y.kd())) {
            com.bytedance.msdk.core.kd.xj.xj.xj().xj(wVar.cy(), this.y, this.w.q(), i == 0, this.w.z(), this.w.ff(), this.f.get());
        }
    }

    private void xj(CopyOnWriteArrayList<com.bytedance.msdk.hf.w> copyOnWriteArrayList, com.bytedance.msdk.hf.w wVar) {
        Iterator<com.bytedance.msdk.hf.w> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.hf.w next = it.next();
            if (next == wVar && next != null) {
                copyOnWriteArrayList.remove(next);
            }
        }
    }

    private void xj(String str, List<com.bytedance.msdk.hf.w> list) {
        com.bytedance.msdk.hf.w wVar;
        if (hf(str, list) || com.bytedance.msdk.core.kd.xj.xj.xj().xj(str, this.y, false) != 3) {
            return;
        }
        com.bytedance.msdk.core.kd.xj.xj xj = com.bytedance.msdk.core.kd.xj.xj.xj();
        com.bytedance.msdk.api.xj.hf hfVar = this.y;
        List<com.bytedance.msdk.core.kd.hf.c> xj2 = xj.xj(str, hfVar, hfVar.kd());
        if (xj2 == null || xj2.size() <= 0) {
            return;
        }
        for (com.bytedance.msdk.core.kd.hf.c cVar : xj2) {
            if (cVar != null && (wVar = cVar.xj) != null && !wVar.tu() && cVar.xj.ff(this.kd)) {
                list.add(cVar.xj);
                hf(cVar.xj);
            }
        }
    }
}
