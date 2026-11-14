package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.hf.zg;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends w {
    private final com.bytedance.adsdk.lottie.xj.xj.u c;
    private final u f;

    public tf(com.bytedance.adsdk.lottie.f fVar, f fVar2, u uVar, com.bytedance.adsdk.lottie.y yVar) {
        super(fVar, fVar2);
        this.f = uVar;
        com.bytedance.adsdk.lottie.xj.xj.u uVar2 = new com.bytedance.adsdk.lottie.xj.xj.u(fVar, this, new zg("__container", fVar2.am(), false), yVar);
        this.c = uVar2;
        List<com.bytedance.adsdk.lottie.xj.xj.w> list = Collections.EMPTY_LIST;
        uVar2.xj(list, list);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public com.bytedance.adsdk.lottie.u.tf g() {
        com.bytedance.adsdk.lottie.u.tf g = super.g();
        return g != null ? g : this.f.g();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        super.hf(canvas, matrix, i);
        this.c.xj(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public com.bytedance.adsdk.lottie.model.hf.xj pl() {
        com.bytedance.adsdk.lottie.model.hf.xj pl2 = super.pl();
        return pl2 != null ? pl2 : this.f.pl();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w, com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        super.xj(rectF, matrix, z);
        this.c.xj(rectF, this.xj, z);
    }
}
