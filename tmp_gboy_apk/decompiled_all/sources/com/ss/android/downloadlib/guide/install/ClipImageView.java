package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ClipImageView extends ImageView {
    private Path hf;
    private float[] kd;
    private Paint u;
    private RectF w;
    private boolean xj;

    public ClipImageView(Context context) {
        super(context);
        this.xj = true;
        xj(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.xj) {
            this.hf.reset();
            this.w.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.kd;
            if (fArr != null) {
                this.hf.addRoundRect(this.w, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.hf);
            Paint paint = this.u;
            if (paint != null) {
                canvas.drawPath(this.hf, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.u = paint;
        paint.setStyle(Paint.Style.FILL);
        this.u.setColor(i);
    }

    public void setClip(boolean z) {
        this.xj = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.kd = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public void xj(Context context) {
        this.hf = new Path();
        this.w = new RectF();
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xj = true;
        xj(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xj = true;
        xj(context);
    }
}
