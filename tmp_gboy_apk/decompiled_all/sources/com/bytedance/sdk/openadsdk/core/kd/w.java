package com.bytedance.sdk.openadsdk.core.kd;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.kd.xj;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.kd.hf;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ht;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ra;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.nb;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.bytedance.sdk.openadsdk.x.d;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends hf<List<am>> {
    List<Long> hf;
    private final int w;

    public w(com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar, int i) {
        super(hfVar);
        this.hf = new CopyOnWriteArrayList();
        this.w = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, hf.xj<List<am>> xjVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<ws> it = list.iterator();
        while (it.hasNext()) {
            am xj = xj(hfVar, it.next());
            if (xj != null) {
                arrayList.add(xj);
            }
        }
        if (xjVar != null) {
            xjVar.xj(arrayList);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf
    public /* bridge */ /* synthetic */ void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List list, List<am> list2) {
        xj2(hfVar, (List<ws>) list, list2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, hf.xj<List<am>> xjVar) {
        final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2;
        final List<ws> list2;
        final hf.xj<List<am>> xjVar2;
        if (list != null && !list.isEmpty()) {
            final long currentTimeMillis = System.currentTimeMillis();
            this.hf.add(Long.valueOf(currentTimeMillis));
            int[] iArr = {0};
            final int[] iArr2 = {list.size()};
            if (pz.hf().ka() > 0) {
                hfVar2 = hfVar;
                list2 = list;
                xjVar2 = xjVar;
                f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kd.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (this) {
                            try {
                                if (w.this.hf.contains(Long.valueOf(currentTimeMillis))) {
                                    w.this.hf.remove(Long.valueOf(currentTimeMillis));
                                    w.this.hf(hfVar2, list2, xjVar2);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }, pz.hf().ka());
            } else {
                hfVar2 = hfVar;
                list2 = list;
                xjVar2 = xjVar;
            }
            for (ws wsVar : list2) {
                final hf.xj<List<am>> xjVar3 = xjVar2;
                final List<ws> list3 = list2;
                final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar3 = hfVar2;
                final long j = currentTimeMillis;
                final int[] iArr3 = iArr;
                com.bytedance.sdk.openadsdk.core.ugeno.w wVar = new com.bytedance.sdk.openadsdk.core.ugeno.w() { // from class: com.bytedance.sdk.openadsdk.core.kd.w.2
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
                    public void xj(String str) {
                        synchronized (this) {
                            int[] iArr4 = iArr3;
                            int i = iArr4[0] + 1;
                            iArr4[0] = i;
                            w.this.xj(j, hfVar3, (List<ws>) list3, (hf.xj<List<am>>) xjVar3, i, iArr2[0]);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
                    public void xj() {
                        synchronized (this) {
                            int[] iArr4 = iArr2;
                            int i = iArr4[0] - 1;
                            iArr4[0] = i;
                            w.this.xj(j, hfVar3, (List<ws>) list3, (hf.xj<List<am>>) xjVar3, iArr3[0], i);
                        }
                    }
                };
                currentTimeMillis = j;
                hfVar2 = hfVar3;
                list2 = list3;
                xjVar2 = xjVar3;
                xj(wsVar, wVar);
                iArr = iArr3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, hf.xj<List<am>> xjVar, int i, int i2) {
        if (this.hf.contains(Long.valueOf(j))) {
            if (pz.hf().rx() != 1 || i == i2) {
                this.hf.remove(Long.valueOf(j));
                hf(hfVar, list, xjVar);
            }
        }
    }

    private void xj(ws wsVar, com.bytedance.sdk.openadsdk.core.ugeno.w wVar) {
        if (hl.p(wsVar)) {
            com.bytedance.sdk.openadsdk.core.g.xj.xj(wsVar, wVar);
            return;
        }
        if (hl.tf(wsVar)) {
            nb y = hl.y(wsVar);
            if (y != null) {
                tf.xj(y.d(), y.tf(), wVar);
                return;
            }
            return;
        }
        wVar.xj(null);
    }

    /* renamed from: xj, reason: avoid collision after fix types in other method */
    public void xj2(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, List<am> list2) {
        for (int i = 0; i < list2.size(); i++) {
            am amVar = list2.get(i);
            ws wsVar = list.get(i);
            com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar2 = this.xj;
            if (hfVar2 != null) {
                hfVar2.xj().xj(hfVar, wsVar, amVar, false);
            }
        }
    }

    private am xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar) {
        boolean z = h.am(wsVar) != null;
        int i = this.w;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.w(pz.getContext(), wsVar, hfVar);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.hf(pz.getContext(), wsVar, hfVar);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new ht(pz.getContext(), wsVar, hfVar);
        }
        if (z) {
            return new ra(pz.getContext(), wsVar, hfVar);
        }
        return new com.bytedance.sdk.openadsdk.core.nativeexpress.pz(pz.getContext(), wsVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf, com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(int i, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar) {
        int i2;
        if (wsVar == null) {
            return;
        }
        String kd = (hfVar == null || !((i2 = this.w) == 3 || i2 == 4)) ? null : d.kd();
        com.bytedance.sdk.openadsdk.core.video.w.xj.hf(wsVar);
        if (wsVar.ap() && wsVar.lx() != null && !wsVar.lx().isEmpty()) {
            for (z zVar : wsVar.lx()) {
                if (!TextUtils.isEmpty(zVar.xj())) {
                    com.bytedance.sdk.openadsdk.core.et.kd.xj().w().xj(new com.bytedance.sdk.openadsdk.g.hf(zVar.xj(), zVar.c()), com.bytedance.sdk.openadsdk.core.et.xj.xj.hf(), zVar.hf(), zVar.w(), kd);
                }
            }
        }
        if (TextUtils.isEmpty(h.xj(wsVar))) {
            return;
        }
        if (pz.hf().u(String.valueOf(wo.d(wsVar))) && pz.hf().o()) {
            com.bykv.vk.openvk.component.video.api.w.u xj = h.xj(4, wsVar);
            xj.xj("material_meta", wsVar);
            xj.xj("ad_slot", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.video.u.hf.xj(xj, (xj.InterfaceC0012xj) null);
        }
    }
}
