package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w {
    private final com.bytedance.sdk.openadsdk.core.kd.kd.u hf;
    protected Context xj;

    public w(Context context) {
        this.xj = context == null ? pz.getContext() : context.getApplicationContext();
        this.hf = new com.bytedance.sdk.openadsdk.core.kd.kd.u(hf());
    }

    public abstract int hf();

    public void xj(final String str) {
        com.bytedance.sdk.openadsdk.x.c.xj(new d("rewardFull preloadOnDestroy") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.w.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.zg.w.w.hf xj = com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj().xj(str);
                if (xj == null || TextUtils.isEmpty(xj.u())) {
                    return;
                }
                ws xj2 = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(w.this.hf()).xj(xj.u(), false, 0L);
                if (pz.hf().hf(xj.u()) && xj2 != null) {
                    if (xj2.a() + xj2.ra() < System.currentTimeMillis()) {
                        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(w.this.hf()).xj(xj.u());
                    }
                }
                if (xj2 == null) {
                    w.this.xj(xj);
                }
            }
        });
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (this.hf != null) {
            this.hf.xj(hfVar, xj(true, System.currentTimeMillis(), (com.bytedance.sdk.openadsdk.core.component.reward.business.hf.w) null));
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, u uVar) {
        if (hfVar != null) {
            hfVar.u();
        }
        xj(hfVar, uVar, (com.bytedance.sdk.openadsdk.core.component.reward.business.hf.w) null);
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final u uVar, com.bytedance.sdk.openadsdk.core.component.reward.business.hf.w wVar) {
        boolean z = (wVar == null || !wVar.w()) && com.bytedance.sdk.openadsdk.core.live.kd.u.xj(hfVar.ht());
        tj xj = xj(false, uVar != null ? uVar.xj() : System.currentTimeMillis(), wVar);
        com.bytedance.sdk.openadsdk.core.kd.kd.u uVar2 = this.hf;
        if (uVar2 != null) {
            uVar2.xj(hfVar, xj, z ? -1 : 0, new com.bytedance.sdk.openadsdk.core.kd.kd.kd() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.w.2
                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void hf(Object obj) {
                    hfVar.u();
                    u uVar3 = uVar;
                    if (uVar3 != null) {
                        uVar3.hf(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void xj(Object obj) {
                    hfVar.u();
                    u uVar3 = uVar;
                    if (uVar3 != null) {
                        uVar3.xj(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void xj(int i, String str) {
                    hfVar.u();
                    u uVar3 = uVar;
                    if (uVar3 != null) {
                        uVar3.xj(i, str);
                    }
                }
            });
        }
    }

    private tj xj(boolean z, long j, com.bytedance.sdk.openadsdk.core.component.reward.business.hf.w wVar) {
        boolean z2;
        tj tjVar = new tj();
        tjVar.f = j;
        if (z) {
            tjVar.xj = 2;
        }
        tjVar.y = 2;
        if (wVar == null || !wVar.w()) {
            z2 = false;
        } else {
            tjVar.hf = wVar.xj();
            tjVar.w = wVar.hf();
            z2 = true;
            tjVar.u = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", z2);
        bundle.putBoolean("is_preload", z);
        bundle.putLong("start_time", tjVar.f);
        tjVar.qt = bundle;
        return tjVar;
    }
}
