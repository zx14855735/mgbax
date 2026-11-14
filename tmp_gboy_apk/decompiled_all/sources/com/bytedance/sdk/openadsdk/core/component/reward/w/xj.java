package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj extends hf {
    protected int hf;
    protected boolean kd;
    protected boolean u;
    protected boolean w;
    protected int xj;
    protected boolean y;

    public xj(Activity activity, ws wsVar) {
        super(activity, wsVar);
    }

    public void hf(int i) {
        this.hf = i;
    }

    public void u(boolean z) {
        this.kd = z;
    }

    public void w(boolean z) {
        this.y = z;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public xj(Activity activity, ws wsVar, xv xvVar) {
        super(activity, wsVar, xvVar);
    }

    public void hf(boolean z) {
        this.u = z;
    }

    public void xj(boolean z) {
        this.w = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(tf tfVar) {
        g gVar = new g(this.f, this.c);
        gVar.hf(this.u);
        gVar.xj(this.w);
        gVar.xj(this.xj);
        gVar.hf(this.hf);
        gVar.u(this.p);
        gVar.w(this.f10325pl);
        gVar.xj(this.zg);
        gVar.hf(this.qt);
        gVar.w(this.y);
        gVar.u(this.kd);
        return gVar.hf(tfVar);
    }
}
