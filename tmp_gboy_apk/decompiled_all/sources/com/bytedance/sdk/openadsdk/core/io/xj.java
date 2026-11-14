package com.bytedance.sdk.openadsdk.core.io;

import com.bytedance.sdk.openadsdk.core.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    Boolean xj = null;
    Boolean hf = null;
    Boolean w = null;

    public boolean hf() {
        if (this.hf == null) {
            com.bytedance.sdk.openadsdk.zg.w.w.u e = f.zg().e();
            this.hf = Boolean.valueOf(e == null || e.u());
        }
        return this.hf.booleanValue();
    }

    public boolean w() {
        if (this.w == null) {
            com.bytedance.sdk.openadsdk.zg.w.w.u e = f.zg().e();
            this.w = Boolean.valueOf(e == null || e.xj());
        }
        return this.w.booleanValue();
    }

    public boolean xj() {
        if (this.xj == null) {
            com.bytedance.sdk.openadsdk.zg.w.w.u e = f.zg().e();
            this.xj = Boolean.valueOf(e == null || e.w());
        }
        return this.xj.booleanValue();
    }
}
