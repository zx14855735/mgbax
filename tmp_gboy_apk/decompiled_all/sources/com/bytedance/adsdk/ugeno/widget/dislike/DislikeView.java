package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.ugeno.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DislikeView extends View {
    private float c;
    private int d;
    private Paint f;
    private int hf;
    private Paint kd;
    private RectF u;
    private int w;
    private w xj;
    private Paint y;

    public DislikeView(Context context) {
        super(context);
        xj();
    }

    private void xj() {
        Paint paint = new Paint();
        this.kd = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.y = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.u;
        float f = this.c;
        canvas.drawRoundRect(rectF, f, f, this.y);
        RectF rectF2 = this.u;
        float f2 = this.c;
        canvas.drawRoundRect(rectF2, f2, f2, this.kd);
        int i = this.hf;
        int i2 = this.w;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.f);
        int i3 = this.hf;
        int i4 = this.w;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.f);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        w wVar = this.xj;
        if (wVar != null) {
            int[] xj = wVar.xj(i, i2);
            super.onMeasure(xj[0], xj[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.hf = i;
        this.w = i2;
        int i5 = this.d;
        this.u = new RectF(i5, i5, this.hf - i5, this.w - i5);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    public void setBgColor(int i) {
        this.y.setStyle(Paint.Style.FILL);
        this.y.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.f.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.f.setStrokeWidth(i);
    }

    public void setRadius(float f) {
        this.c = f;
    }

    public void setStrokeColor(int i) {
        this.kd.setStyle(Paint.Style.STROKE);
        this.kd.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.kd.setStrokeWidth(i);
        this.d = i;
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.xj = wVar;
    }
}
