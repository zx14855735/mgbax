package com.bytedance.sdk.openadsdk.core.kd;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.kd.xj;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.kd.kd.c;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.f;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.tf;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf<V> extends com.bytedance.sdk.openadsdk.core.kd.xj.xj<V> {
    protected com.bytedance.sdk.openadsdk.core.kd.kd.hf xj;

    public interface xj<V> {
        void xj(V v);
    }

    public hf(com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar) {
        this.xj = hfVar;
    }

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, xj<V> xjVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, V v);

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
        hfVar2.xj(i);
        com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(int i, com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar, tj tjVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2, com.bytedance.sdk.openadsdk.core.kd.kd.kd<V> kdVar, c cVar) {
        if (xjVar.hf() == null || xjVar.hf().isEmpty()) {
            if (cVar != null) {
                cVar.xj(-3);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (xjVar.hf().size() > 1) {
            if (f.xj(i).xj("mix_ad", hfVar2, xjVar.hf().get(0))) {
                com.bytedance.sdk.openadsdk.core.xj.xj(xjVar.hf());
                arrayList.add(xjVar.hf().get(0));
            } else {
                arrayList.addAll(xjVar.hf());
            }
        } else {
            arrayList.addAll(xjVar.hf());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ws wsVar = (ws) it.next();
            if (wsVar.ap()) {
                if (wsVar.o() <= 0) {
                    wsVar.kd((System.currentTimeMillis() + 10500000) / 1000);
                }
                xj(i, hfVar2, wsVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (cVar != null) {
                cVar.xj(-4);
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("start_time", tjVar.f);
            xj(i, arrayList, hfVar2, kdVar, bundle, cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(final int i, final List<ws> list, final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.core.kd.kd.kd<V> kdVar, final Bundle bundle, final c cVar) {
        xj(hfVar, list, (xj) new xj<V>() { // from class: com.bytedance.sdk.openadsdk.core.kd.hf.1
            @Override // com.bytedance.sdk.openadsdk.core.kd.hf.xj
            public void xj(V v) {
                com.bytedance.sdk.openadsdk.core.kd.kd.w xj2 = hf.this.xj(i, hfVar, (com.bytedance.sdk.openadsdk.zg.w.w.hf) v, (List<ws>) list, bundle, (com.bytedance.sdk.openadsdk.core.kd.kd.kd<com.bytedance.sdk.openadsdk.zg.w.w.hf>) kdVar);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.xj(xj2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.kd.kd.w xj(final int i, final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final V v, final List<ws> list, Bundle bundle, final com.bytedance.sdk.openadsdk.core.kd.kd.kd<V> kdVar) {
        final long j = bundle.getLong("start_time");
        final boolean z = bundle.getBoolean(PointParamKey.IS_CACHE);
        Iterator<ws> it = list.iterator();
        while (it.hasNext()) {
            it.next().rz().hf();
        }
        final ws wsVar = list.get(0);
        return new com.bytedance.sdk.openadsdk.core.kd.kd.w() { // from class: com.bytedance.sdk.openadsdk.core.kd.hf.2
            private final AtomicBoolean tf = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.w
            public void hf() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.w
            public void w() {
                if (this.tf.compareAndSet(false, true)) {
                    hf.this.xj(z, hfVar, list);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.openadsdk.core.kd.kd.w
            public void xj() {
                hf.this.xj(hfVar, (List<ws>) list, (List) v);
                com.bytedance.sdk.openadsdk.core.am.u.hf(wsVar, wo.hf(i), j);
                com.bytedance.sdk.openadsdk.core.kd.kd.kd kdVar2 = kdVar;
                if (kdVar2 != null) {
                    kdVar2.xj(v);
                }
            }
        };
    }

    public void xj(boolean z, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar2 = this.xj;
            if (hfVar2 != null) {
                hfVar2.xj().hf(hfVar, list);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar3 = this.xj;
        if (hfVar3 != null) {
            hfVar3.xj().xj(hfVar, list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(int i, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar) {
        if ((!ws.xj(wsVar) || tf.xj(wsVar)) && !TextUtils.isEmpty(h.xj(wsVar))) {
            if (pz.hf().u(String.valueOf(wo.d(wsVar))) && pz.hf().o()) {
                if (h.am(wsVar) != null) {
                    h.am(wsVar).kd(1);
                }
                if (h.qt(wsVar) != null) {
                    h.qt(wsVar).kd(1);
                }
                com.bykv.vk.openvk.component.video.api.w.u xj2 = h.xj(4, wsVar);
                xj2.xj("material_meta", wsVar);
                xj2.xj("ad_slot", Integer.valueOf(i));
                com.bytedance.sdk.openadsdk.core.video.u.hf.xj(xj2, (xj.InterfaceC0012xj) null);
            }
        }
    }
}
