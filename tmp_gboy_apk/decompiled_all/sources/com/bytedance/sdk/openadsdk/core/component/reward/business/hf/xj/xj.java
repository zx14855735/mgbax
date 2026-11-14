package com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj extends com.bytedance.sdk.openadsdk.core.component.reward.w.hf {
    protected String xj;

    public xj(Activity activity, ws wsVar) {
        super(activity, wsVar);
    }

    public void xj(String str) {
        this.xj = str;
    }

    public xj(Activity activity, ws wsVar, xv xvVar) {
        super(activity, wsVar, xvVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj xj(tf tfVar) {
        u uVar = new u(this.f, this.c);
        uVar.u(this.p);
        uVar.w(this.f10325pl);
        uVar.hf(this.qt);
        uVar.xj(this.xj);
        return uVar.xj(tfVar);
    }
}
