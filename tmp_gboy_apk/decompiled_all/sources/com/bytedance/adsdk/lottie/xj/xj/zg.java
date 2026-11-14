package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg implements xj.InterfaceC0024xj, g, kd, p, tf {
    private final com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> c;
    private final com.bytedance.adsdk.lottie.xj.hf.zg d;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> f;
    private final String kd;
    private u tf;
    private final com.bytedance.adsdk.lottie.model.layer.w u;
    private final com.bytedance.adsdk.lottie.f w;
    private final boolean y;
    private final Matrix xj = new Matrix();
    private final Path hf = new Path();

    public zg(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.pl plVar) {
        this.w = fVar;
        this.u = wVar;
        this.kd = plVar.xj();
        this.y = plVar.kd();
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj = plVar.hf().xj();
        this.c = xj;
        wVar.xj(xj);
        xj.xj(this);
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj2 = plVar.w().xj();
        this.f = xj2;
        wVar.xj(xj2);
        xj2.xj(this);
        com.bytedance.adsdk.lottie.xj.hf.zg tf = plVar.u().tf();
        this.d = tf;
        tf.xj(wVar);
        tf.xj(this);
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.g
    public Path u() {
        Path u = this.tf.u();
        this.hf.reset();
        float floatValue = this.c.c().floatValue();
        float floatValue2 = this.f.c().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.xj.set(this.d.hf(i + floatValue2));
            this.hf.addPath(u, this.xj);
        }
        return this.hf;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.tf
    public void xj(ListIterator<w> listIterator) {
        if (this.tf != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.tf = new u(this.w, this.u, "Repeater", this.y, arrayList, null);
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        this.tf.xj(list, list2);
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.c.c().floatValue();
        float floatValue2 = this.f.c().floatValue();
        float floatValue3 = this.d.hf().c().floatValue() / 100.0f;
        float floatValue4 = this.d.w().c().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.xj.set(matrix);
            float f = i2;
            this.xj.preConcat(this.d.hf(f + floatValue2));
            this.tf.xj(canvas, this.xj, (int) (com.bytedance.adsdk.lottie.kd.f.xj(floatValue3, floatValue4, f / floatValue) * i));
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        this.tf.xj(rectF, matrix, z);
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        this.w.invalidateSelf();
    }
}
