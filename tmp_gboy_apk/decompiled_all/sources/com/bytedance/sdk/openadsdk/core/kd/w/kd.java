package com.bytedance.sdk.openadsdk.core.kd.w;

import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.c;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements xj {
    private final int xj;

    public kd(int i) {
        this.xj = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar, Object obj, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void hf(String str) {
        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).hf(str);
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
        c.u(new d("PreloadStrategyShowDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.kd.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(kd.this.xj).xj(hfVar, wsVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public ws xj(String str, long j) {
        return com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, false, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public List<ws> xj(String str, long j, int i) {
        List<ws> xj = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, false, j, i);
        xj.size();
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(String str, ws wsVar) {
        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.xj).xj(str, wsVar.qa());
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(final ws wsVar) {
        final int d = wo.d(wsVar);
        c.xj(new d("PreloadStrategyShowDelete-onShow") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.kd.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.kd.u.kd xj = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(kd.this.xj);
                StringBuilder sb = new StringBuilder();
                sb.append(d);
                xj.xj(sb.toString(), wsVar.qa());
            }
        });
    }
}
