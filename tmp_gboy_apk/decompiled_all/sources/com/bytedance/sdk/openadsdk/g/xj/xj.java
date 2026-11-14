package com.bytedance.sdk.openadsdk.g.xj;

import com.bytedance.sdk.component.y.f;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.et.xj.xj;
import com.bytedance.sdk.openadsdk.core.ra.gh;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.openadsdk.core.et.xj.xj {
    private gh xj;

    private void kd() {
        if (u()) {
            long currentTimeMillis = System.currentTimeMillis();
            gh ghVar = this.xj;
            ghVar.f(currentTimeMillis - ghVar.v());
            this.xj.g(currentTimeMillis);
        }
    }

    private boolean u() {
        gh ghVar = this.xj;
        return ghVar != null && ghVar.ht();
    }

    private void xj(zg zgVar) {
        f httpTime = zgVar.getHttpTime();
        if (httpTime == null || !u()) {
            return;
        }
        xj(httpTime.getStartRequestTime(), httpTime.getFirstFrameTime());
    }

    public gh w() {
        return this.xj;
    }

    private void xj(long j, long j2) {
        this.xj.am(j2);
        gh ghVar = this.xj;
        ghVar.d(j2 - ghVar.pz());
        this.xj.v(j2 - j);
    }

    public void xj(gh ghVar) {
        this.xj = ghVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.et.xj.xj
    public void xj(zg zgVar, xj.hf hfVar) {
        xj(zgVar);
        super.xj(zgVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.et.xj.xj
    public void xj() {
        kd();
    }
}
