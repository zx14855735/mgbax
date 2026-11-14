package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class jk extends xj {
    private final com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> c;
    private com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> f;
    private final String kd;
    private final com.bytedance.adsdk.lottie.model.layer.w u;
    private final boolean y;

    public jk(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.yo yoVar) {
        super(fVar, wVar, yoVar.c().xj(), yoVar.f().xj(), yoVar.d(), yoVar.w(), yoVar.u(), yoVar.kd(), yoVar.y());
        this.u = wVar;
        this.kd = yoVar.xj();
        this.y = yoVar.tf();
        com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xj = yoVar.hf().xj();
        this.c = xj;
        xj.xj(this);
        wVar.xj(xj);
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.xj, com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(Canvas canvas, Matrix matrix, int i) {
        if (this.y) {
            return;
        }
        this.hf.setColor(((com.bytedance.adsdk.lottie.xj.hf.hf) this.c).d());
        com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> xjVar = this.f;
        if (xjVar != null) {
            this.hf.setColorFilter(xjVar.c());
        }
        super.xj(canvas, matrix, i);
    }
}
