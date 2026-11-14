package com.bytedance.adsdk.lottie.model.hf;

import J3FDQU.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e implements w {
    private final int hf;
    private final boolean u;
    private final com.bytedance.adsdk.lottie.model.xj.f w;
    private final String xj;

    public e(String str, int i, com.bytedance.adsdk.lottie.model.xj.f fVar, boolean z) {
        this.xj = str;
        this.hf = i;
        this.w = fVar;
        this.u = z;
    }

    public com.bytedance.adsdk.lottie.model.xj.f hf() {
        return this.w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ShapePath{name=");
        sb.append(this.xj);
        sb.append(", index=");
        return A2egSU.B2KMhB(sb, this.hf, '}');
    }

    public boolean w() {
        return this.u;
    }

    public String xj() {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.yo(fVar, wVar, this);
    }
}
