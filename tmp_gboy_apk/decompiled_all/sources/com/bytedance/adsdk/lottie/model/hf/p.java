package com.bytedance.adsdk.lottie.model.hf;

import android.graphics.PointF;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p implements w {
    private final com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> hf;
    private final boolean kd;
    private final com.bytedance.adsdk.lottie.model.xj.hf u;
    private final com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> w;
    private final String xj;

    public p(String str, com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> gVar, com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> gVar2, com.bytedance.adsdk.lottie.model.xj.hf hfVar, boolean z) {
        this.xj = str;
        this.hf = gVar;
        this.w = gVar2;
        this.u = hfVar;
        this.kd = z;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf hf() {
        return this.u;
    }

    public boolean kd() {
        return this.kd;
    }

    public String toString() {
        return "RectangleShape{position=" + this.hf + ", size=" + this.w + '}';
    }

    public com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> u() {
        return this.hf;
    }

    public com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.qt(fVar, wVar, this);
    }
}
