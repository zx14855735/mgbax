package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.hf.v;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj implements xj.InterfaceC0024xj, kd, p {
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> am;
    private com.bytedance.adsdk.lottie.xj.hf.w e;
    private final com.bytedance.adsdk.lottie.f f;
    private final List<com.bytedance.adsdk.lottie.xj.hf.xj<?, Float>> g;
    final Paint hf;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> p;

    /* renamed from: pl, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xj.hf.xj<?, Integer> f10062pl;
    private com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> qt;
    private final float[] tf;
    float w;
    protected final com.bytedance.adsdk.lottie.model.layer.w xj;
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> zg;
    private final PathMeasure u = new PathMeasure();
    private final Path kd = new Path();
    private final Path y = new Path();
    private final RectF c = new RectF();
    private final List<C0025xj> d = new ArrayList();

    /* renamed from: com.bytedance.adsdk.lottie.xj.xj.xj$xj, reason: collision with other inner class name */
    public static final class C0025xj {
        private final pz hf;
        private final List<g> xj;

        private C0025xj(pz pzVar) {
            this.xj = new ArrayList();
            this.hf = pzVar;
        }
    }

    public xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.lottie.model.xj.u uVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar, List<com.bytedance.adsdk.lottie.model.xj.hf> list, com.bytedance.adsdk.lottie.model.xj.hf hfVar2) {
        com.bytedance.adsdk.lottie.xj.xj xjVar = new com.bytedance.adsdk.lottie.xj.xj(1);
        this.hf = xjVar;
        this.w = 0.0f;
        this.f = fVar;
        this.xj = wVar;
        xjVar.setStyle(Paint.Style.STROKE);
        xjVar.setStrokeCap(cap);
        xjVar.setStrokeJoin(join);
        xjVar.setStrokeMiter(f);
        this.f10062pl = uVar.xj();
        this.p = hfVar.xj();
        if (hfVar2 == null) {
            this.am = null;
        } else {
            this.am = hfVar2.xj();
        }
        this.g = new ArrayList(list.size());
        this.tf = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.g.add(list.get(i).xj());
        }
        wVar.xj(this.f10062pl);
        wVar.xj(this.p);
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            wVar.xj(this.g.get(i2));
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> xjVar2 = this.am;
        if (xjVar2 != null) {
            wVar.xj(xjVar2);
        }
        this.f10062pl.xj(this);
        this.p.xj(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.g.get(i3).xj(this);
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> xjVar3 = this.am;
        if (xjVar3 != null) {
            xjVar3.xj(this);
        }
        if (wVar.pl() != null) {
            com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj = wVar.pl().xj().xj();
            this.zg = xj;
            xj.xj(this);
            wVar.xj(this.zg);
        }
        if (wVar.g() != null) {
            this.e = new com.bytedance.adsdk.lottie.xj.hf.w(this, wVar, wVar.g());
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        this.f.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        pz pzVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            w wVar = list.get(size);
            if (wVar instanceof pz) {
                pz pzVar2 = (pz) wVar;
                if (pzVar2.getType() == v.xj.INDIVIDUALLY) {
                    pzVar = pzVar2;
                }
            }
        }
        if (pzVar != null) {
            pzVar.xj(this);
        }
        C0025xj c0025xj = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            w wVar2 = list2.get(size2);
            if (wVar2 instanceof pz) {
                pz pzVar3 = (pz) wVar2;
                if (pzVar3.getType() == v.xj.INDIVIDUALLY) {
                    if (c0025xj != null) {
                        this.d.add(c0025xj);
                    }
                    c0025xj = new C0025xj(pzVar3);
                    pzVar3.xj(this);
                }
            }
            if (wVar2 instanceof g) {
                if (c0025xj == null) {
                    c0025xj = new C0025xj(pzVar);
                }
                c0025xj.xj.add((g) wVar2);
            }
        }
        if (c0025xj != null) {
            this.d.add(c0025xj);
        }
    }

    public void xj(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.lottie.kd.xj("StrokeContent#draw");
        if (com.bytedance.adsdk.lottie.kd.d.hf(matrix)) {
            com.bytedance.adsdk.lottie.kd.hf("StrokeContent#draw");
            return;
        }
        this.hf.setAlpha(com.bytedance.adsdk.lottie.kd.f.xj((int) ((((i / 255.0f) * ((com.bytedance.adsdk.lottie.xj.hf.y) this.f10062pl).d()) / 100.0f) * 255.0f), 0, 255));
        this.hf.setStrokeWidth(com.bytedance.adsdk.lottie.kd.d.xj(matrix) * ((com.bytedance.adsdk.lottie.xj.hf.u) this.p).d());
        if (this.hf.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.lottie.kd.hf("StrokeContent#draw");
            return;
        }
        xj(matrix);
        com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> xjVar = this.qt;
        if (xjVar != null) {
            this.hf.setColorFilter(xjVar.c());
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xjVar2 = this.zg;
        if (xjVar2 != null) {
            float floatValue = xjVar2.c().floatValue();
            if (floatValue == 0.0f) {
                this.hf.setMaskFilter(null);
            } else if (floatValue != this.w) {
                this.hf.setMaskFilter(this.xj.hf(floatValue));
            }
            this.w = floatValue;
        }
        com.bytedance.adsdk.lottie.xj.hf.w wVar = this.e;
        if (wVar != null) {
            wVar.xj(this.hf);
        }
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            C0025xj c0025xj = this.d.get(i2);
            if (c0025xj.hf != null) {
                xj(canvas, c0025xj, matrix);
            } else {
                com.bytedance.adsdk.lottie.kd.xj("StrokeContent#buildPath");
                this.kd.reset();
                for (int size = c0025xj.xj.size() - 1; size >= 0; size--) {
                    this.kd.addPath(((g) c0025xj.xj.get(size)).u(), matrix);
                }
                com.bytedance.adsdk.lottie.kd.hf("StrokeContent#buildPath");
                com.bytedance.adsdk.lottie.kd.xj("StrokeContent#drawPath");
                canvas.drawPath(this.kd, this.hf);
                com.bytedance.adsdk.lottie.kd.hf("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.lottie.kd.hf("StrokeContent#draw");
    }

    private void xj(Canvas canvas, C0025xj c0025xj, Matrix matrix) {
        float f;
        float f2;
        com.bytedance.adsdk.lottie.kd.xj("StrokeContent#applyTrimPath");
        if (c0025xj.hf == null) {
            com.bytedance.adsdk.lottie.kd.hf("StrokeContent#applyTrimPath");
            return;
        }
        this.kd.reset();
        for (int size = c0025xj.xj.size() - 1; size >= 0; size--) {
            this.kd.addPath(((g) c0025xj.xj.get(size)).u(), matrix);
        }
        float floatValue = c0025xj.hf.hf().c().floatValue() / 100.0f;
        float floatValue2 = c0025xj.hf.w().c().floatValue() / 100.0f;
        float floatValue3 = c0025xj.hf.u().c().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.kd, this.hf);
            com.bytedance.adsdk.lottie.kd.hf("StrokeContent#applyTrimPath");
            return;
        }
        this.u.setPath(this.kd, false);
        float length = this.u.getLength();
        while (this.u.nextContour()) {
            length += this.u.getLength();
        }
        float f3 = floatValue3 * length;
        float f4 = (floatValue * length) + f3;
        float min = Math.min((floatValue2 * length) + f3, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = c0025xj.xj.size() - 1; size2 >= 0; size2--) {
            this.y.set(((g) c0025xj.xj.get(size2)).u());
            this.y.transform(matrix);
            this.u.setPath(this.y, false);
            float length2 = this.u.getLength();
            if (min > length) {
                float f6 = min - length;
                if (f6 < f5 + length2 && f5 < f6) {
                    f = f4 > length ? (f4 - length) / length2 : 0.0f;
                    f2 = Math.min(f6 / length2, 1.0f);
                    com.bytedance.adsdk.lottie.kd.d.xj(this.y, f, f2, 0.0f);
                    canvas.drawPath(this.y, this.hf);
                    f5 += length2;
                }
            }
            float f7 = f5 + length2;
            if (f7 >= f4 && f5 <= min) {
                if (f7 <= min && f4 < f5) {
                    canvas.drawPath(this.y, this.hf);
                } else {
                    f = f4 < f5 ? 0.0f : (f4 - f5) / length2;
                    f2 = min > f7 ? 1.0f : (min - f5) / length2;
                    com.bytedance.adsdk.lottie.kd.d.xj(this.y, f, f2, 0.0f);
                    canvas.drawPath(this.y, this.hf);
                }
            }
            f5 += length2;
        }
        com.bytedance.adsdk.lottie.kd.hf("StrokeContent#applyTrimPath");
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.lottie.kd.xj("StrokeContent#getBounds");
        this.kd.reset();
        for (int i = 0; i < this.d.size(); i++) {
            C0025xj c0025xj = this.d.get(i);
            for (int i2 = 0; i2 < c0025xj.xj.size(); i2++) {
                this.kd.addPath(((g) c0025xj.xj.get(i2)).u(), matrix);
            }
        }
        this.kd.computeBounds(this.c, false);
        float d = ((com.bytedance.adsdk.lottie.xj.hf.u) this.p).d();
        RectF rectF2 = this.c;
        float f = d / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.c);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.lottie.kd.hf("StrokeContent#getBounds");
    }

    private void xj(Matrix matrix) {
        com.bytedance.adsdk.lottie.kd.xj("StrokeContent#applyDashPattern");
        if (this.g.isEmpty()) {
            com.bytedance.adsdk.lottie.kd.hf("StrokeContent#applyDashPattern");
            return;
        }
        float xj = com.bytedance.adsdk.lottie.kd.d.xj(matrix);
        for (int i = 0; i < this.g.size(); i++) {
            this.tf[i] = this.g.get(i).c().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.tf;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.tf;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.tf;
            fArr3[i] = fArr3[i] * xj;
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<?, Float> xjVar = this.am;
        this.hf.setPathEffect(new DashPathEffect(this.tf, xjVar == null ? 0.0f : xj * xjVar.c().floatValue()));
        com.bytedance.adsdk.lottie.kd.hf("StrokeContent#applyDashPattern");
    }
}
