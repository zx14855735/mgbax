package com.bytedance.adsdk.lottie.model.xj;

import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d implements g<PointF, PointF> {
    private final hf hf;
    private final hf xj;

    public d(hf hfVar, hf hfVar2) {
        this.xj = hfVar;
        this.hf = hfVar2;
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public boolean hf() {
        return this.xj.hf() && this.hf.hf();
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public List<com.bytedance.adsdk.lottie.y.xj<PointF>> w() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj() {
        return new com.bytedance.adsdk.lottie.xj.hf.am(this.xj.xj(), this.hf.xj());
    }
}
