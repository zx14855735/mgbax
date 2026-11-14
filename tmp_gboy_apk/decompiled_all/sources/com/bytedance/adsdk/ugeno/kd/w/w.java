package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends hf implements com.bytedance.adsdk.ugeno.kd.xj.u {
    private com.bytedance.adsdk.ugeno.kd.xj.w p;

    public w(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.kd.w.hf
    public boolean xj(Object... objArr) {
        com.bytedance.adsdk.ugeno.kd.xj.xj b = this.hf.b();
        if (b == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.kd.xj.w xj = b.xj(this.y);
        this.p = xj;
        if (xj != null) {
            xj.xj(this);
            return false;
        }
        b.xj(this.y, new com.bytedance.adsdk.ugeno.kd.xj.hf());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.kd.xj.u
    public void xj(String str) {
        this.xj.xj(this.hf, this.y, this.w.hf());
    }
}
