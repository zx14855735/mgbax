package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements xj.InterfaceC0024xj, kd, p {
    private final List<g> c;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> d;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> f;
    private com.bytedance.adsdk.lottie.xj.hf.w g;
    private final Path hf;
    private final String kd;
    private final com.bytedance.adsdk.lottie.f p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> f10059pl;
    private com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> tf;
    private final com.bytedance.adsdk.lottie.model.layer.w u;
    private final Paint w;
    float xj;
    private final boolean y;

    public c(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.qt qtVar) {
        Path path = new Path();
        this.hf = path;
        this.w = new com.bytedance.adsdk.lottie.xj.xj(1);
        this.c = new ArrayList();
        this.u = wVar;
        this.kd = qtVar.xj();
        this.y = qtVar.kd();
        this.p = fVar;
        if (wVar.pl() != null) {
            com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj = wVar.pl().xj().xj();
            this.f10059pl = xj;
            xj.xj(this);
            wVar.xj(this.f10059pl);
        }
        if (wVar.g() != null) {
            this.g = new com.bytedance.adsdk.lottie.xj.hf.w(this, wVar, wVar.g());
        }
        if (qtVar.hf() == null || qtVar.w() == null) {
            this.f = null;
            this.d = null;
            return;
        }
        path.setFillType(qtVar.u());
        com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xj2 = qtVar.hf().xj();
        this.f = xj2;
        xj2.xj(this);
        wVar.xj(xj2);
        com.bytedance.adsdk.lottie.xj.hf.xj<Integer, Integer> xj3 = qtVar.w().xj();
        this.d = xj3;
        xj3.xj(this);
        wVar.xj(xj3);
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        this.p.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        for (int i = 0; i < list2.size(); i++) {
            w wVar = list2.get(i);
            if (wVar instanceof g) {
                this.c.add((g) wVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(Canvas canvas, Matrix matrix, int i) {
        if (this.y) {
            return;
        }
        com.bytedance.adsdk.lottie.kd.xj("FillContent#draw");
        this.w.setColor((com.bytedance.adsdk.lottie.kd.f.xj((int) ((((i / 255.0f) * this.d.c().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.lottie.xj.hf.hf) this.f).d() & 16777215));
        com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> xjVar = this.tf;
        if (xjVar != null) {
            this.w.setColorFilter(xjVar.c());
        }
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xjVar2 = this.f10059pl;
        if (xjVar2 != null) {
            float floatValue = xjVar2.c().floatValue();
            if (floatValue == 0.0f) {
                this.w.setMaskFilter(null);
            } else if (floatValue != this.xj) {
                this.w.setMaskFilter(this.u.hf(floatValue));
            }
            this.xj = floatValue;
        }
        com.bytedance.adsdk.lottie.xj.hf.w wVar = this.g;
        if (wVar != null) {
            wVar.xj(this.w);
        }
        this.hf.reset();
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.hf.addPath(this.c.get(i2).u(), matrix);
        }
        canvas.drawPath(this.hf, this.w);
        com.bytedance.adsdk.lottie.kd.hf("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        this.hf.reset();
        for (int i = 0; i < this.c.size(); i++) {
            this.hf.addPath(this.c.get(i).u(), matrix);
        }
        this.hf.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
