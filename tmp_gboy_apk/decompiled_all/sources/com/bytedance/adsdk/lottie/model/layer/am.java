package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.lottie.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am extends c {
    private int d;
    private Path f;
    private int tf;

    public am(com.bytedance.adsdk.lottie.f fVar, f fVar2, Context context) {
        super(fVar, fVar2);
        this.f = null;
        this.d = -1;
        this.tf = -1;
        if (((c) this).c != null) {
            float xj = com.bytedance.adsdk.lottie.kd.d.xj();
            this.d = (int) (((c) this).c.xj() * xj);
            this.tf = (int) (((c) this).c.hf() * xj);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.d, this.tf);
            Path path = new Path();
            this.f = path;
            float f = xj * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    private static void xj(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.c, com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        pz xj = this.hf.xj();
        View xj2 = xj != null ? xj.xj("videoview:", null) : null;
        if (this.d <= 0 || xj2 == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        xj(i);
        float f = f();
        xj(xj2, this.d, this.tf);
        xj2.setAlpha(f);
        canvas.clipPath(this.f);
        xj2.draw(canvas);
        canvas.restore();
    }
}
