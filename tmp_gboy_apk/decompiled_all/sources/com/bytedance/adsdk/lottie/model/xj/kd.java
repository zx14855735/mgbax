package com.bytedance.adsdk.lottie.model.xj;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements g<PointF, PointF> {
    private final List<com.bytedance.adsdk.lottie.y.xj<PointF>> xj;

    public kd(List<com.bytedance.adsdk.lottie.y.xj<PointF>> list) {
        this.xj = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public boolean hf() {
        return this.xj.size() == 1 && this.xj.get(0).kd();
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public List<com.bytedance.adsdk.lottie.y.xj<PointF>> w() {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj() {
        return this.xj.get(0).kd() ? new com.bytedance.adsdk.lottie.xj.hf.p(this.xj) : new com.bytedance.adsdk.lottie.xj.hf.tf(this.xj);
    }
}
