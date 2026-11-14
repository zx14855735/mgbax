package com.bytedance.adsdk.lottie.model.hf;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am {
    private PointF hf;
    private boolean w;
    private final List<com.bytedance.adsdk.lottie.model.xj> xj;

    public am(PointF pointF, boolean z, List<com.bytedance.adsdk.lottie.model.xj> list) {
        this.hf = pointF;
        this.w = z;
        this.xj = new ArrayList(list);
    }

    public boolean hf() {
        return this.w;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.xj.size() + "closed=" + this.w + '}';
    }

    public List<com.bytedance.adsdk.lottie.model.xj> w() {
        return this.xj;
    }

    public void xj(float f, float f2) {
        if (this.hf == null) {
            this.hf = new PointF();
        }
        this.hf.set(f, f2);
    }

    public PointF xj() {
        return this.hf;
    }

    public am() {
        this.xj = new ArrayList();
    }

    public void xj(boolean z) {
        this.w = z;
    }

    public void xj(am amVar, am amVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.hf == null) {
            this.hf = new PointF();
        }
        this.w = amVar.hf() || amVar2.hf();
        if (amVar.w().size() != amVar2.w().size()) {
            com.bytedance.adsdk.lottie.kd.kd.hf("Curves must have the same number of control points. Shape 1: " + amVar.w().size() + "\tShape 2: " + amVar2.w().size());
        }
        int min = Math.min(amVar.w().size(), amVar2.w().size());
        if (this.xj.size() < min) {
            for (int size = this.xj.size(); size < min; size++) {
                this.xj.add(new com.bytedance.adsdk.lottie.model.xj());
            }
        } else if (this.xj.size() > min) {
            for (int size2 = this.xj.size() - 1; size2 >= min; size2--) {
                List<com.bytedance.adsdk.lottie.model.xj> list = this.xj;
                list.remove(list.size() - 1);
            }
        }
        PointF xj = amVar.xj();
        PointF xj2 = amVar2.xj();
        xj(com.bytedance.adsdk.lottie.kd.f.xj(xj.x, xj2.x, f), com.bytedance.adsdk.lottie.kd.f.xj(xj.y, xj2.y, f));
        for (int size3 = this.xj.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.model.xj xjVar = amVar.w().get(size3);
            com.bytedance.adsdk.lottie.model.xj xjVar2 = amVar2.w().get(size3);
            PointF xj3 = xjVar.xj();
            PointF hf = xjVar.hf();
            PointF w = xjVar.w();
            PointF xj4 = xjVar2.xj();
            PointF hf2 = xjVar2.hf();
            PointF w2 = xjVar2.w();
            this.xj.get(size3).xj(com.bytedance.adsdk.lottie.kd.f.xj(xj3.x, xj4.x, f), com.bytedance.adsdk.lottie.kd.f.xj(xj3.y, xj4.y, f));
            this.xj.get(size3).hf(com.bytedance.adsdk.lottie.kd.f.xj(hf.x, hf2.x, f), com.bytedance.adsdk.lottie.kd.f.xj(hf.y, hf2.y, f));
            this.xj.get(size3).w(com.bytedance.adsdk.lottie.kd.f.xj(w.x, w2.x, f), com.bytedance.adsdk.lottie.kd.f.xj(w.y, w2.y, f));
        }
    }
}
