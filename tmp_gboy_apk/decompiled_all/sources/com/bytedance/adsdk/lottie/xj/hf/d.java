package com.bytedance.adsdk.lottie.xj.hf;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends com.bytedance.adsdk.lottie.y.xj<PointF> {
    private final com.bytedance.adsdk.lottie.y.xj<PointF> p;
    private Path tf;

    public d(com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.y.xj<PointF> xjVar) {
        super(yVar, xjVar.xj, xjVar.hf, xjVar.w, xjVar.u, xjVar.kd, xjVar.y, xjVar.c);
        this.p = xjVar;
        xj();
    }

    public Path hf() {
        return this.tf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void xj() {
        T t;
        T t2;
        T t3 = this.hf;
        boolean z = (t3 == 0 || (t2 = this.xj) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.xj;
        if (t4 == 0 || (t = this.hf) == 0 || z) {
            return;
        }
        com.bytedance.adsdk.lottie.y.xj<PointF> xjVar = this.p;
        this.tf = com.bytedance.adsdk.lottie.kd.d.xj((PointF) t4, (PointF) t, xjVar.f, xjVar.d);
    }
}
