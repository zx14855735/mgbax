package com.bytedance.sdk.openadsdk.core.component.reward.kd;

import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.hf.y;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private final com.bytedance.sdk.openadsdk.core.component.reward.u.xj c;
    private int kd;
    private final int u;
    private final y y;
    protected int xj = 0;
    protected int hf = 0;
    protected int w = 1000;

    public w(boolean z, ws wsVar, y yVar, com.bytedance.sdk.openadsdk.core.component.reward.u.xj xjVar) {
        this.y = yVar;
        this.c = xjVar;
        this.u = z ? pz.hf().kd(wo.d(wsVar)) : pz.hf().y(wo.d(wsVar));
    }

    public void c() {
        this.xj++;
    }

    public int d() {
        return this.w;
    }

    public void f() {
        this.hf++;
    }

    public int hf() {
        return this.kd;
    }

    public int kd() {
        return this.xj;
    }

    public int u() {
        return this.c.a();
    }

    public int w() {
        return this.u;
    }

    public long xj() {
        return this.y.z();
    }

    public int y() {
        return this.hf;
    }

    public void hf(int i) {
        this.hf = i;
    }

    public void w(int i) {
        this.w = i;
    }

    public void xj(int i) {
        this.kd += i;
    }
}
