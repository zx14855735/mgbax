package com.bytedance.adsdk.lottie.model.hf;

import android.graphics.PointF;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements w {
    private final com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> hf;
    private final boolean kd;
    private final boolean u;
    private final com.bytedance.adsdk.lottie.model.xj.y w;
    private final String xj;

    public hf(String str, com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> gVar, com.bytedance.adsdk.lottie.model.xj.y yVar, boolean z, boolean z2) {
        this.xj = str;
        this.hf = gVar;
        this.w = yVar;
        this.u = z;
        this.kd = z2;
    }

    public com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> hf() {
        return this.hf;
    }

    public boolean kd() {
        return this.kd;
    }

    public boolean u() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.xj.y w() {
        return this.w;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.y(fVar, wVar, this);
    }

    public String xj() {
        return this.xj;
    }
}
