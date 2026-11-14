package com.bytedance.adsdk.lottie.xj.hf;

import ADYaiT.CtFAbx;
import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p extends c<PointF> {
    private final PointF u;

    public p(List<com.bytedance.adsdk.lottie.y.xj<PointF>> list) {
        super(list);
        this.u = new PointF();
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public PointF xj(com.bytedance.adsdk.lottie.y.xj<PointF> xjVar, float f) {
        return xj(xjVar, f, f, f);
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public PointF xj(com.bytedance.adsdk.lottie.y.xj<PointF> xjVar, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = xjVar.xj;
        if (pointF3 == null || (pointF = xjVar.hf) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.bytedance.adsdk.lottie.y.w<A> wVar = this.w;
        if (wVar != 0 && (pointF2 = (PointF) wVar.xj(xjVar.y, xjVar.c.floatValue(), pointF4, pointF5, f, u(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.u;
        float f4 = pointF4.x;
        float A4TApA2 = CtFAbx.A4TApA(pointF5.x, f4, f2, f4);
        float f5 = pointF4.y;
        pointF6.set(A4TApA2, CtFAbx.A4TApA(pointF5.y, f5, f3, f5));
        return this.u;
    }
}
