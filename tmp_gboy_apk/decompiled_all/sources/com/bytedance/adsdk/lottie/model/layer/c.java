package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends w {
    protected final com.bytedance.adsdk.lottie.d c;
    private final Rect d;
    private final Paint f;
    private com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.xj.hf.xj<Bitmap, Bitmap> f10045pl;
    private final Rect tf;

    public c(com.bytedance.adsdk.lottie.f fVar, f fVar2) {
        super(fVar, fVar2);
        this.f = new com.bytedance.adsdk.lottie.xj.xj(3);
        this.d = new Rect();
        this.tf = new Rect();
        this.c = fVar.y(fVar2.c());
    }

    private Bitmap am() {
        Bitmap c;
        com.bytedance.adsdk.lottie.xj.hf.xj<Bitmap, Bitmap> xjVar = this.f10045pl;
        if (xjVar != null && (c = xjVar.c()) != null) {
            return c;
        }
        Bitmap kd = this.hf.kd(this.w.c());
        if (kd != null) {
            return kd;
        }
        com.bytedance.adsdk.lottie.d dVar = this.c;
        if (dVar != null) {
            return dVar.am();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        super.hf(canvas, matrix, i);
        Bitmap am = am();
        if (am == null || am.isRecycled() || this.c == null) {
            return;
        }
        float xj = com.bytedance.adsdk.lottie.kd.d.xj();
        this.f.setAlpha(i);
        com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> xjVar = this.p;
        if (xjVar != null) {
            this.f.setColorFilter(xjVar.c());
        }
        canvas.save();
        canvas.concat(matrix);
        this.d.set(0, 0, am.getWidth(), am.getHeight());
        if (this.hf.y()) {
            this.tf.set(0, 0, (int) (this.c.xj() * xj), (int) (this.c.hf() * xj));
        } else {
            this.tf.set(0, 0, (int) (am.getWidth() * xj), (int) (am.getHeight() * xj));
        }
        canvas.drawBitmap(am, this.d, this.tf, this.f);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w, com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        super.xj(rectF, matrix, z);
        if (this.c != null) {
            float xj = com.bytedance.adsdk.lottie.kd.d.xj();
            rectF.set(0.0f, 0.0f, this.c.xj() * xj, this.c.hf() * xj);
            this.xj.mapRect(rectF);
        }
    }
}
