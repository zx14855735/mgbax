package com.bytedance.sdk.openadsdk.core.kd.kd.xj;

import com.bytedance.sdk.openadsdk.core.kd.kd.kd;
import com.bytedance.sdk.openadsdk.core.ra.f;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends hf {
    private final AtomicBoolean xj = new AtomicBoolean(false);
    private final AtomicBoolean hf = new AtomicBoolean(false);
    private final AtomicBoolean w = new AtomicBoolean(false);
    private final AtomicBoolean u = new AtomicBoolean(false);

    /* renamed from: pl, reason: collision with root package name */
    private final AtomicBoolean f10371pl = new AtomicBoolean(false);

    public w(f.hf hfVar) {
        this.kd = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void w() {
        this.f10371pl.set(true);
        xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void xj(kd kdVar, int i, String str) {
        this.f = kdVar;
        this.d = i;
        this.tf = str;
        this.hf.set(true);
        this.f10371pl.set(true);
        xj();
    }

    public void xj() {
        com.bytedance.sdk.openadsdk.core.kd.kd.w wVar;
        if (this.u.get() && this.p != 2 && (wVar = this.c) != null) {
            xj(wVar, 2);
            return;
        }
        if (this.f10371pl.get()) {
            com.bytedance.sdk.openadsdk.core.kd.kd.w wVar2 = this.y;
            if (wVar2 != null) {
                xj(wVar2, 1);
            } else if (this.w.get()) {
                xj(null, 3);
            }
        }
    }

    private void xj(com.bytedance.sdk.openadsdk.core.kd.kd.w wVar, int i) {
        if (!this.xj.compareAndSet(false, true)) {
            if (wVar != null) {
                wVar.w();
                return;
            }
            return;
        }
        this.p = i;
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

    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.xj.hf
    public void xj(boolean z) {
        if (z) {
            this.u.set(true);
            xj();
        } else {
            this.w.set(true);
            xj();
        }
    }
}
