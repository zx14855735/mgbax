package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p extends w {
    private final RectF c;
    private final float[] d;
    private final Paint f;
    private final f p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> f10049pl;
    private final Path tf;

    public p(com.bytedance.adsdk.lottie.f fVar, f fVar2) {
        super(fVar, fVar2);
        this.c = new RectF();
        com.bytedance.adsdk.lottie.xj.xj xjVar = new com.bytedance.adsdk.lottie.xj.xj();
        this.f = xjVar;
        this.d = new float[8];
        this.tf = new Path();
        this.p = fVar2;
        xjVar.setAlpha(0);
        xjVar.setStyle(Paint.Style.FILL);
        xjVar.setColor(fVar2.zg());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        super.hf(canvas, matrix, i);
        int alpha = Color.alpha(this.p.zg());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((((alpha / 255.0f) * (this.u.xj() == null ? 100 : this.u.xj().c().intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        this.f.setAlpha(intValue);
        com.bytedance.adsdk.lottie.xj.hf.xj<ColorFilter, ColorFilter> xjVar = this.f10049pl;
        if (xjVar != null) {
            this.f.setColorFilter(xjVar.c());
        }
        if (intValue > 0) {
            float[] fArr = this.d;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.p.yo();
            float[] fArr2 = this.d;
            fArr2[3] = 0.0f;
            fArr2[4] = this.p.yo();
            this.d[5] = this.p.e();
            float[] fArr3 = this.d;
            fArr3[6] = 0.0f;
            fArr3[7] = this.p.e();
            matrix.mapPoints(this.d);
            this.tf.reset();
            Path path = this.tf;
            float[] fArr4 = this.d;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.tf;
            float[] fArr5 = this.d;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.tf;
            float[] fArr6 = this.d;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.tf;
            float[] fArr7 = this.d;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.tf;
            float[] fArr8 = this.d;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.tf.close();
            canvas.drawPath(this.tf, this.f);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.w, com.bytedance.adsdk.lottie.xj.xj.kd
    public void xj(RectF rectF, Matrix matrix, boolean z) {
        super.xj(rectF, matrix, z);
        this.c.set(0.0f, 0.0f, this.p.yo(), this.p.e());
        this.xj.mapRect(this.c);
        rectF.set(this.c);
    }
}
