package com.bytedance.adsdk.lottie.model.hf;

import android.graphics.Path;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt implements w {
    private final Path.FillType hf;
    private final com.bytedance.adsdk.lottie.model.xj.u kd;
    private final com.bytedance.adsdk.lottie.model.xj.xj u;
    private final String w;
    private final boolean xj;
    private final boolean y;

    public qt(String str, boolean z, Path.FillType fillType, com.bytedance.adsdk.lottie.model.xj.xj xjVar, com.bytedance.adsdk.lottie.model.xj.u uVar, boolean z2) {
        this.w = str;
        this.xj = z;
        this.hf = fillType;
        this.u = xjVar;
        this.kd = uVar;
        this.y = z2;
    }

    public com.bytedance.adsdk.lottie.model.xj.xj hf() {
        return this.u;
    }

    public boolean kd() {
        return this.y;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.xj + '}';
    }

    public Path.FillType u() {
        return this.hf;
    }

    public com.bytedance.adsdk.lottie.model.xj.u w() {
        return this.kd;
    }

    public String xj() {
        return this.w;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.c(fVar, wVar, this);
    }
}
