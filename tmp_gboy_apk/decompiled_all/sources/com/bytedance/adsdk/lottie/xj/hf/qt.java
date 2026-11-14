package com.bytedance.adsdk.lottie.xj.hf;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class qt extends c<com.bytedance.adsdk.lottie.model.hf> {
    public qt(List<com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf>> list) {
        super(list);
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.hf xj(com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf> xjVar, float f) {
        com.bytedance.adsdk.lottie.model.hf hfVar;
        com.bytedance.adsdk.lottie.y.w<A> wVar = this.w;
        if (wVar == 0) {
            return (f != 1.0f || (hfVar = xjVar.hf) == null) ? xjVar.xj : hfVar;
        }
        float f2 = xjVar.y;
        Float f3 = xjVar.c;
        float floatValue = f3 == null ? Float.MAX_VALUE : f3.floatValue();
        com.bytedance.adsdk.lottie.model.hf hfVar2 = xjVar.xj;
        com.bytedance.adsdk.lottie.model.hf hfVar3 = xjVar.hf;
        return (com.bytedance.adsdk.lottie.model.hf) wVar.xj(f2, floatValue, hfVar2, hfVar3 == null ? hfVar2 : hfVar3, f, kd(), f());
    }
}
