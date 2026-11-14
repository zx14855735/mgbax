package com.bytedance.sdk.openadsdk.core.kd.w;

import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.c;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements xj {
    private int xj;

    public hf(int i) {
        this.xj = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(ws wsVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void hf(String str) {
        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).hf(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar, Object obj, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public boolean xj(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final ws wsVar) {
        if (wsVar.o() <= 0) {
            wsVar.kd((System.currentTimeMillis() + 10500000) / 1000);
        }
        c.u(new d("PreloadStrategyLoadDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.hf.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(hf.this.xj).xj(hfVar, wsVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public ws xj(String str, long j) {
        ws xj = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, false, j);
        if (xj != null) {
            com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, xj.qa());
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public List<ws> xj(String str, long j, int i) {
        List<ws> xj = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, false, j, i);
        Iterator<ws> it = xj.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, it.next().qa());
        }
        xj.size();
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(String str, ws wsVar) {
        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, wsVar.qa());
    }
}
