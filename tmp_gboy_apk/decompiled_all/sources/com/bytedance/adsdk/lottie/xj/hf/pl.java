package com.bytedance.adsdk.lottie.xj.hf;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl extends c<com.bytedance.adsdk.lottie.y.u> {
    private final com.bytedance.adsdk.lottie.y.u u;

    public pl(List<com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.y.u>> list) {
        super(list);
        this.u = new com.bytedance.adsdk.lottie.y.u();
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.y.u xj(com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.y.u> xjVar, float f) {
        com.bytedance.adsdk.lottie.y.u uVar;
        float f2;
        com.bytedance.adsdk.lottie.y.u uVar2 = xjVar.xj;
        if (uVar2 == null || (uVar = xjVar.hf) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.y.u uVar3 = uVar2;
        com.bytedance.adsdk.lottie.y.u uVar4 = uVar;
        com.bytedance.adsdk.lottie.y.w<A> wVar = this.w;
        if (wVar != 0) {
            f2 = f;
            com.bytedance.adsdk.lottie.y.u uVar5 = (com.bytedance.adsdk.lottie.y.u) wVar.xj(xjVar.y, xjVar.c.floatValue(), uVar3, uVar4, f2, u(), f());
            if (uVar5 != null) {
                return uVar5;
            }
        } else {
            f2 = f;
        }
        this.u.xj(com.bytedance.adsdk.lottie.kd.f.xj(uVar3.xj(), uVar4.xj(), f2), com.bytedance.adsdk.lottie.kd.f.xj(uVar3.hf(), uVar4.hf(), f2));
        return this.u;
    }
}
