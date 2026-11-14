package com.bytedance.sdk.openadsdk.core.xj;

import com.bytedance.sdk.openadsdk.core.dk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements dk.hf {
    private int hf;
    private dk.hf xj;

    public xj(dk.hf hfVar) {
        this.xj = hfVar;
    }

    public void xj(int i) {
        this.hf = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk.hf
    public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
        dk.hf hfVar2 = this.xj;
        if (hfVar2 != null) {
            hfVar2.xj(i, str, hfVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk.hf
    public void xj(final com.bytedance.sdk.openadsdk.core.ra.xj xjVar, final com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
        int i = this.hf;
        boolean z = i == 3 || i == 4;
        if (z && (com.bytedance.sdk.openadsdk.core.w.kd.xj().pl() & 1) == 1) {
            dk.hf hfVar2 = this.xj;
            if (hfVar2 != null) {
                hfVar2.xj(xjVar, hfVar);
                return;
            }
            return;
        }
        if (this.xj != null) {
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xj.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.xj.xj(xjVar, hfVar);
                }
            };
            if (z) {
                com.bytedance.sdk.openadsdk.x.c.xj(runnable);
            } else {
                com.bytedance.sdk.openadsdk.x.c.hf(runnable);
            }
        }
    }
}
