package com.bytedance.adsdk.lottie.xj.hf;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends c<Float> {
    public u(List<com.bytedance.adsdk.lottie.y.xj<Float>> list) {
        super(list);
    }

    public float d() {
        return w(w(), kd());
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public Float xj(com.bytedance.adsdk.lottie.y.xj<Float> xjVar, float f) {
        return Float.valueOf(w(xjVar, f));
    }

    public float w(com.bytedance.adsdk.lottie.y.xj<Float> xjVar, float f) {
        float f2;
        if (xjVar.xj == null || xjVar.hf == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.y.w<A> wVar = this.w;
        if (wVar != 0) {
            f2 = f;
            Float f3 = (Float) wVar.xj(xjVar.y, xjVar.c.floatValue(), xjVar.xj, xjVar.hf, f2, u(), f());
            if (f3 != null) {
                return f3.floatValue();
            }
        } else {
            f2 = f;
        }
        return com.bytedance.adsdk.lottie.kd.f.xj(xjVar.y(), xjVar.c(), f2);
    }
}
