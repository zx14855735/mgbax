package com.bytedance.adsdk.lottie.xj.hf;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends c<Integer> {
    public hf(List<com.bytedance.adsdk.lottie.y.xj<Integer>> list) {
        super(list);
    }

    public int d() {
        return w(w(), kd());
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public Integer xj(com.bytedance.adsdk.lottie.y.xj<Integer> xjVar, float f) {
        return Integer.valueOf(w(xjVar, f));
    }

    public int w(com.bytedance.adsdk.lottie.y.xj<Integer> xjVar, float f) {
        float f2;
        if (xjVar.xj == null || xjVar.hf == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.y.w<A> wVar = this.w;
        if (wVar != 0) {
            f2 = f;
            Integer num = (Integer) wVar.xj(xjVar.y, xjVar.c.floatValue(), xjVar.xj, xjVar.hf, f2, u(), f());
            if (num != null) {
                return num.intValue();
            }
        } else {
            f2 = f;
        }
        return com.bytedance.adsdk.lottie.kd.w.xj(com.bytedance.adsdk.lottie.kd.f.hf(f2, 0.0f, 1.0f), xjVar.xj.intValue(), xjVar.hf.intValue());
    }
}
