package com.bytedance.adsdk.lottie.model.hf;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg implements w {
    private final List<w> hf;
    private final boolean w;
    private final String xj;

    public zg(String str, List<w> list, boolean z) {
        this.xj = str;
        this.hf = list;
        this.w = z;
    }

    public List<w> hf() {
        return this.hf;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.xj + "' Shapes: " + Arrays.toString(this.hf.toArray()) + '}';
    }

    public boolean w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.u(fVar, wVar, this, yVar);
    }
}
