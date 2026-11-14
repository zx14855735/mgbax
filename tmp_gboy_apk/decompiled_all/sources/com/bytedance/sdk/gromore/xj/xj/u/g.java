package com.bytedance.sdk.gromore.xj.xj.u;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g extends com.bytedance.sdk.openadsdk.zg.w.hf.pl {
    private int hf;
    private int w;
    private String xj;

    public g(String str) {
        this.xj = str;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
    public int hf() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
    public boolean kd() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
    public double u() {
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
    public String w() {
        return !TextUtils.isEmpty(this.xj) ? this.xj : "";
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
    public int xj() {
        return this.w;
    }

    public g(String str, int i, int i2) {
        this.xj = str;
        this.hf = i;
        this.w = i2;
    }
}
