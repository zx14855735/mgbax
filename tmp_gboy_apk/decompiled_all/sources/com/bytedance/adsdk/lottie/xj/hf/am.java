package com.bytedance.adsdk.lottie.xj.hf;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am extends xj<PointF, PointF> {
    private final PointF c;
    private final xj<Float, Float> d;
    private final xj<Float, Float> f;
    protected com.bytedance.adsdk.lottie.y.w<Float> kd;
    protected com.bytedance.adsdk.lottie.y.w<Float> u;
    private final PointF y;

    public am(xj<Float, Float> xjVar, xj<Float, Float> xjVar2) {
        super(Collections.EMPTY_LIST);
        this.y = new PointF();
        this.c = new PointF();
        this.f = xjVar;
        this.d = xjVar2;
        xj(f());
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public PointF c() {
        return xj(null, 0.0f);
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public PointF xj(com.bytedance.adsdk.lottie.y.xj<PointF> xjVar, float f) {
        float f2;
        Float f3;
        com.bytedance.adsdk.lottie.y.xj<Float> w;
        com.bytedance.adsdk.lottie.y.xj<Float> w2;
        Float f4 = null;
        if (this.u == null || (w2 = this.f.w()) == null) {
            f2 = f;
            f3 = null;
        } else {
            float kd = this.f.kd();
            Float f5 = w2.c;
            com.bytedance.adsdk.lottie.y.w<Float> wVar = this.u;
            float f6 = w2.y;
            f2 = f;
            f3 = wVar.xj(f6, f5 == null ? f6 : f5.floatValue(), w2.xj, w2.hf, f, f, kd);
        }
        if (this.kd != null && (w = this.d.w()) != null) {
            float kd2 = this.d.kd();
            Float f7 = w.c;
            com.bytedance.adsdk.lottie.y.w<Float> wVar2 = this.kd;
            float f8 = w.y;
            f4 = wVar2.xj(f8, f7 == null ? f8 : f7.floatValue(), w.xj, w.hf, f2, f2, kd2);
        }
        if (f3 == null) {
            this.c.set(this.y.x, 0.0f);
        } else {
            this.c.set(f3.floatValue(), 0.0f);
        }
        if (f4 == null) {
            PointF pointF = this.c;
            pointF.set(pointF.x, this.y.y);
        } else {
            PointF pointF2 = this.c;
            pointF2.set(pointF2.x, f4.floatValue());
        }
        return this.c;
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    public void xj(float f) {
        this.f.xj(f);
        this.d.xj(f);
        this.y.set(this.f.c().floatValue(), this.d.c().floatValue());
        for (int i = 0; i < this.xj.size(); i++) {
            this.xj.get(i).xj();
        }
    }
}
