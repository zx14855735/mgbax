package com.bytedance.adsdk.lottie.xj.hf;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends c<com.bytedance.adsdk.lottie.model.hf.u> {
    private final com.bytedance.adsdk.lottie.model.hf.u u;

    public kd(List<com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.u>> list) {
        super(list);
        com.bytedance.adsdk.lottie.model.hf.u uVar = list.get(0).xj;
        int w = uVar != null ? uVar.w() : 0;
        this.u = new com.bytedance.adsdk.lottie.model.hf.u(new float[w], new int[w]);
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.hf.u xj(com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.u> xjVar, float f) {
        this.u.xj(xjVar.xj, xjVar.hf, f);
        return this.u;
    }
}
