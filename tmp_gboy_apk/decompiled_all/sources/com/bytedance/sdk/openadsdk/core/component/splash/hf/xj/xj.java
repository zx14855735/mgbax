package com.bytedance.sdk.openadsdk.core.component.splash.hf.xj;

import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y;
import com.bytedance.sdk.openadsdk.core.component.splash.xj.kd;
import com.bytedance.sdk.openadsdk.core.component.splash.xj.xj;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private kd c;
    private String hf;
    private boolean kd;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf w;
    private com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xj;
    private c u = new c();
    private com.bytedance.sdk.openadsdk.core.kd.hf.xj y = new com.bytedance.sdk.openadsdk.core.kd.hf.xj(4);

    public xj(com.bytedance.sdk.openadsdk.core.component.splash.xj.xj xjVar) {
        this.xj = xjVar;
        xjVar.hf();
        this.kd = pz.hf().wa();
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.kd kdVar, com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf<y, c> hfVar) {
        if (kdVar == null || hfVar == null) {
            return;
        }
        this.u.hf(true);
        this.w = kdVar.u();
        this.hf = kdVar.y();
        this.c = kdVar.c();
        if (com.bytedance.sdk.openadsdk.core.component.splash.w.w.kd.xj(this.w, kdVar.kd())) {
            this.u.hf(1);
            this.u.xj("no cache");
            hfVar.xj(this.u);
            return;
        }
        xj(this.hf, hfVar);
    }

    private void xj(final String str, final com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf<y, c> hfVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.xj.xj(this.u, str, new xj.InterfaceC0156xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.xj.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.InterfaceC0156xj
            public void xj(final y yVar) {
                com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "缓存读取总耗时： " + (System.currentTimeMillis() - currentTimeMillis));
                if (hfVar == null) {
                    return;
                }
                if (yVar == null || yVar.hf() == null) {
                    if (yVar == null) {
                        xj.this.u.hf(1);
                        xj.this.u.xj("no ad model cache");
                        hfVar.xj(xj.this.u);
                        return;
                    } else if (yVar.hf() == null) {
                        xj.this.u.hf(1);
                        xj.this.u.xj("no splash material");
                        hfVar.xj(xj.this.u);
                        return;
                    }
                }
                ws hf = yVar.hf();
                xj.this.y.xj(currentTimeMillis);
                xj.this.y.hf(System.currentTimeMillis());
                ArrayList arrayList = new ArrayList();
                arrayList.add(hf);
                xj.this.y.xj(arrayList, new com.bytedance.sdk.openadsdk.core.kd.hf.kd() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.xj.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.kd.hf.kd
                    public void hf(List<ws> list) {
                        if (list != null && !list.isEmpty()) {
                            hfVar.hf(yVar);
                            return;
                        }
                        xj.this.u.hf(22);
                        xj.this.u.xj("check server cache unavailable");
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        hfVar.xj(xj.this.u);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kd.hf.kd
                    public void w(List<ws> list) {
                        Iterator<ws> it = list.iterator();
                        while (it.hasNext()) {
                            xj.this.xj.xj(str, it.next());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kd.hf.kd
                    public void xj(List<ws> list) {
                        if (!xj.this.kd) {
                            hfVar.hf(yVar);
                        } else {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            xj.this.xj(yVar, (com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf<y, c>) hfVar);
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.InterfaceC0156xj
            public void xj() {
                com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "缓存读取失败");
                com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf hfVar2 = hfVar;
                if (hfVar2 == null) {
                    return;
                }
                hfVar2.xj(xj.this.u);
            }
        }, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final y yVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.w.hf<y, c> hfVar) {
        if (hfVar == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ws hf = yVar.hf();
        pz.xj().xj(hf.ho(), hf.jf(), new dk.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.hf.xj.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.dk.xj
            public void xj(boolean z, long j, long j2) {
                am.xj(xj.this.w, j, j2, System.currentTimeMillis() - currentTimeMillis, 4, 1, z ? 1 : 0);
                if (z) {
                    hfVar.hf(yVar);
                    return;
                }
                xj.this.u.hf(22);
                xj.this.u.xj("check server cache unavailable");
                xj.this.u.xj(j);
                hfVar.xj(xj.this.u);
            }
        });
    }
}
