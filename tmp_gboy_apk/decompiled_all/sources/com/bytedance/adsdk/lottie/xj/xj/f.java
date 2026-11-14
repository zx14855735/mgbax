package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f implements xj.InterfaceC0024xj, kd, p {
    private final com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> am;
    private final Path c;
    private final RectF d;
    private com.bytedance.adsdk.lottie.xj.hf.e e;
    private final Paint f;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> g;
    private final String hf;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> jk;
    private final com.bytedance.adsdk.lottie.model.hf.c p;

    /* renamed from: pl, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.u, com.bytedance.adsdk.lottie.model.hf.u> f10061pl;
    private com.bytedance.adsdk.lottie.xj.hf.w pz;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> qt;
    private final List<g> tf;
    private final com.bytedance.adsdk.lottie.model.layer.w u;
    private final int v;
    private final boolean w;
    float xj;
    private final com.bytedance.adsdk.lottie.f yo;
    private com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> zg;
    private final LongSparseArray<LinearGradient> kd = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> y = new LongSparseArray<>();

    public f(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.kd kdVar) {
        Path path = new Path();
        this.c = path;
        this.f = new com.bytedance.adsdk.lottie.xj.xj(1);
        this.d = new RectF();
        this.tf = new ArrayList();
        this.xj = 0.0f;
        this.u = wVar;
        this.hf = kdVar.xj();
        this.w = kdVar.f();
        this.yo = fVar;
        this.p = kdVar.hf();
        path.setFillType(kdVar.w());
        this.v = (int) (yVar.kd() / 32.0f);
        com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.u, com.bytedance.adsdk.lottie.model.hf.u> xj = kdVar.u().xj();
        this.f10061pl = xj;
        xj.xj(this);
        wVar.xj(xj);
        com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xj2 = kdVar.kd().xj();
        this.g = xj2;
        xj2.xj(this);
        wVar.xj(xj2);
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj3 = kdVar.y().xj();
        this.am = xj3;
        xj3.xj(this);
        wVar.xj(xj3);
        com.bytedance.adsdk.lottie.xj.hf.xj<PointF, PointF> xj4 = kdVar.c().xj();
        this.qt = xj4;
        xj4.xj(this);
        wVar.xj(xj4);
        if (wVar.pl() != null) {
            com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj5 = wVar.pl().xj().xj();
            this.jk = xj5;
            xj5.xj(this);
            wVar.xj(this.jk);
        }
        if (wVar.g() != null) {
            this.pz = new com.bytedance.adsdk.lottie.xj.hf.w(this, wVar, wVar.g());
        }
    }

    private LinearGradient hf() {
        long u = u();
        LinearGradient linearGradient = this.kd.get(u);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF c = this.am.c();
        PointF c2 = this.qt.c();
        com.bytedance.adsdk.lottie.model.hf.u c3 = this.f10061pl.c();
        LinearGradient linearGradient2 = new LinearGradient(c.x, c.y, c2.x, c2.y, xj(c3.hf()), c3.xj(), Shader.TileMode.CLAMP);
        this.kd.put(u, linearGradient2);
        return linearGradient2;
    }

    private int u() {
        int round = Math.round(this.am.f() * this.v);
        int round2 = Math.round(this.qt.f() * this.v);
        int round3 = Math.round(this.f10061pl.f() * this.v);
        int i = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private RadialGradient w() {
        long u = u();
        RadialGradient radialGradient = this.y.get(u);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF c = this.am.c();
        PointF c2 = this.qt.c();
        com.bytedance.adsdk.lottie.model.hf.u c3 = this.f10061pl.c();
        int[] xj = xj(c3.hf());
        float[] xj2 = c3.xj();
        float f = c.x;
        float f2 = c.y;
        float hypot = (float) Math.hypot(c2.x - f, c2.y - f2);
        RadialGradient radialGradient2 = new RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, xj, xj2, Shader.TileMode.CLAMP);
        this.y.put(u, radialGradient2);
        return radialGradient2;
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        this.yo.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        for (int i = 0; i < list2.size(); i++) {
            w wVar = list2.get(i);
            if (wVar instanceof g) {
                this.tf.add((g) wVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(Canvas canvas, Matrix matrix, int i) {
        Shader w;
        if (this.w) {
            return;
        }
        com.bytedance.adsdk.lottie.kd.xj("GradientFillContent#draw");
        this.c.reset();
        for (int i2 = 0; i2 < this.tf.size(); i2++) {
            this.c.addPath(this.tf.get(i2).u(), matrix);
        }
        this.c.computeBounds(this.d, false);
        if (this.p == com.bytedance.adsdk.lottie.model.hf.c.LINEAR) {
            w = hf();
        } else {
            w = w();
        }
        w.setLocalMatrix(matrix);
        this.f.setShader(w);
        com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> xjVar = this.zg;
        if (xjVar != null) {
            this.f.setColorFilter(xjVar.c());
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xjVar2 = this.jk;
        if (xjVar2 != null) {
            float floatValue = xjVar2.c().floatValue();
            if (floatValue == 0.0f) {
                this.f.setMaskFilter(null);
            } else if (floatValue != this.xj) {
                this.f.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.xj = floatValue;
        }
        com.bytedance.adsdk.lottie.xj.hf.w wVar = this.pz;
        if (wVar != null) {
            wVar.xj(this.f);
        }
        this.f.setAlpha(com.bytedance.adsdk.lottie.kd.f.xj((int) ((((i / 255.0f) * this.g.c().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.c, this.f);
        com.bytedance.adsdk.lottie.kd.hf("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        this.c.reset();
        for (int i = 0; i < this.tf.size(); i++) {
            this.c.addPath(this.tf.get(i).u(), matrix);
        }
        this.c.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private int[] xj(int[] iArr) {
        com.bytedance.adsdk.lottie.xj.hf.e eVar = this.e;
        if (eVar != null) {
            Integer[] numArr = (Integer[]) eVar.c();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }
}
