package com.bytedance.sdk.openadsdk.core.kd.kd.xj;

import com.bytedance.sdk.openadsdk.core.kd.kd.kd;
import com.bytedance.sdk.openadsdk.core.ra.f;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj extends hf {
    private final AtomicBoolean xj = new AtomicBoolean(false);
    private final AtomicBoolean hf = new AtomicBoolean(false);
    private final AtomicBoolean w = new AtomicBoolean(false);
    private final AtomicBoolean u = new AtomicBoolean(false);

    public xj(f.hf hfVar) {
        this.kd = hfVar;
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.core.kd.kd.w wVar;
        if (this.w.get() && (wVar = this.c) != null) {
            xj(wVar, 2);
            return;
        }
        if (this.u.get()) {
            com.bytedance.sdk.openadsdk.core.kd.kd.w wVar2 = this.y;
            if (wVar2 != null) {
                xj(wVar2, 1);
            } else {
                xj(null, 3);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void w() {
        this.u.set(true);
        hf();
    }

    public abstract void xj();

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void xj(kd kdVar, int i, String str) {
        this.f = kdVar;
        this.d = i;
        this.tf = str;
        this.u.set(true);
        hf();
    }

    private void xj(com.bytedance.sdk.openadsdk.core.kd.kd.w wVar, int i) {
        if (this.xj.compareAndSet(false, true)) {
            if (i != 3) {
                if (wVar != null) {
                    wVar.xj();
                }
            } else {
                kd kdVar = this.f;
                if (kdVar != null) {
                    kdVar.xj(this.d, this.tf);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void xj(boolean z) {
        if (z) {
            this.w.set(true);
            hf();
        } else {
            this.hf.set(true);
            xj();
        }
    }
}
