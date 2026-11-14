package com.bytedance.sdk.openadsdk.core.kd.kd.xj;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.core.kd.kd.kd;
import com.bytedance.sdk.openadsdk.core.ra.f;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends hf implements Runnable {
    private final AtomicBoolean xj = new AtomicBoolean(false);
    private final AtomicBoolean hf = new AtomicBoolean(false);
    private final AtomicBoolean w = new AtomicBoolean(false);
    private final AtomicBoolean u = new AtomicBoolean(false);

    /* renamed from: pl, reason: collision with root package name */
    private final AtomicBoolean f10370pl = new AtomicBoolean(false);

    public u(f.hf hfVar) {
        this.kd = hfVar;
    }

    private long u() {
        f.hf hfVar = this.kd;
        return (hfVar == null || hfVar.y() <= 0) ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : this.kd.y();
    }

    public void hf() {
        if (!this.f10370pl.get()) {
            if (this.xj.get() && this.u.get()) {
                com.bytedance.sdk.openadsdk.core.kd.kd.w wVar = this.c;
                xj(wVar, wVar != null ? 2 : 3);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.utils.f.hf().removeCallbacks(this);
        com.bytedance.sdk.openadsdk.core.kd.kd.w wVar2 = this.y;
        if (wVar2 != null) {
            xj(wVar2, 1);
            return;
        }
        if (this.u.get()) {
            com.bytedance.sdk.openadsdk.core.kd.kd.w wVar3 = this.c;
            if (wVar3 != null) {
                xj(wVar3, 2);
            } else {
                xj(null, 3);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.xj.set(true);
        hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void w() {
        this.f10370pl.set(true);
        hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void xj(kd kdVar, int i, String str) {
        this.f = kdVar;
        this.d = i;
        this.tf = str;
        this.w.set(true);
        this.f10370pl.set(true);
        hf();
    }

    public void xj() {
        com.bytedance.sdk.component.utils.f.hf().postDelayed(this, u());
    }

    private void xj(com.bytedance.sdk.openadsdk.core.kd.kd.w wVar, int i) {
        com.bytedance.sdk.openadsdk.core.kd.kd.w wVar2;
        com.bytedance.sdk.openadsdk.core.kd.kd.w wVar3;
        if (this.hf.compareAndSet(false, true)) {
            this.p = i;
            if (i == 3) {
                kd kdVar = this.f;
                if (kdVar != null) {
                    kdVar.xj(this.d, this.tf);
                }
            } else if (wVar != null) {
                wVar.xj();
            }
            if (i == 1 && (wVar3 = this.c) != null) {
                wVar3.w();
            }
            if (i != 2 || (wVar2 = this.y) == null) {
                return;
            }
            wVar2.w();
            return;
        }
        if (i == this.p || wVar == null) {
            return;
        }
        wVar.w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void xj(boolean z) {
        this.u.set(true);
        hf();
    }
}
