package com.bytedance.adsdk.lottie.xj.hf;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends c<PointF> {
    private d c;
    private final float[] kd;
    private final PointF u;
    private final PathMeasure y;

    public tf(List<? extends com.bytedance.adsdk.lottie.y.xj<PointF>> list) {
        super(list);
        this.u = new PointF();
        this.kd = new float[2];
        this.y = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.adsdk.lottie.xj.hf.xj
    /* renamed from: hf, reason: merged with bridge method [inline-methods] */
    public PointF xj(com.bytedance.adsdk.lottie.y.xj<PointF> xjVar, float f) {
        float f2;
        d dVar = (d) xjVar;
        Path hf = dVar.hf();
        if (hf == null) {
            return xjVar.xj;
        }
        com.bytedance.adsdk.lottie.y.w<A> wVar = this.w;
        if (wVar != 0) {
            f2 = f;
            PointF pointF = (PointF) wVar.xj(dVar.y, dVar.c.floatValue(), dVar.xj, dVar.hf, u(), f2, f());
            if (pointF != null) {
                return pointF;
            }
        } else {
            f2 = f;
        }
        if (this.c != dVar) {
            this.y.setPath(hf, false);
            this.c = dVar;
        }
        PathMeasure pathMeasure = this.y;
        pathMeasure.getPosTan(pathMeasure.getLength() * f2, this.kd, null);
        PointF pointF2 = this.u;
        float[] fArr = this.kd;
        pointF2.set(fArr[0], fArr[1]);
        return this.u;
    }
}
