package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.component.adexpress.xj.hf.c;
import com.bytedance.sdk.component.adexpress.xj.w.u;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static void xj(ws wsVar, final w wVar) {
        final u d;
        if (wsVar == null || hl.f(wsVar) || (d = hl.d(wsVar)) == null) {
            return;
        }
        c.xj(new d("saveTemplate") { // from class: com.bytedance.sdk.openadsdk.core.g.xj.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.adexpress.xj.hf.c.xj().xj(d, new c.xj() { // from class: com.bytedance.sdk.openadsdk.core.g.xj.1.1
                    @Override // com.bytedance.sdk.component.adexpress.xj.hf.c.xj
                    public void hf() {
                        w wVar2 = wVar;
                        if (wVar2 != null) {
                            wVar2.xj();
                        }
                    }

                    @Override // com.bytedance.sdk.component.adexpress.xj.hf.c.xj
                    public void xj() {
                        w wVar2 = wVar;
                        if (wVar2 != null) {
                            wVar2.xj(null);
                        }
                    }
                });
            }
        }, 10);
    }
}
