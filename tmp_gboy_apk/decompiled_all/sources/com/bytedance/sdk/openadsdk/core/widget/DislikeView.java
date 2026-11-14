package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DislikeView extends View {
    private Paint c;
    private int f;
    private int hf;
    private Paint kd;
    private Paint u;
    private RectF w;
    private int xj;
    private int y;

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.w;
        int i = this.y;
        canvas.drawRoundRect(rectF, i, i, this.kd);
        RectF rectF2 = this.w;
        int i2 = this.y;
        canvas.drawRoundRect(rectF2, i2, i2, this.u);
        int i3 = this.xj;
        int i4 = this.hf;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.c);
        int i5 = this.xj;
        int i6 = this.hf;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.xj = i;
        this.hf = i2;
        int i5 = this.f;
        this.w = new RectF(i5, i5, this.xj - i5, this.hf - i5);
    }

    public void setBgColor(int i) {
        this.kd.setStyle(Paint.Style.FILL);
        this.kd.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.c.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.c.setStrokeWidth(i);
    }

    public void setRadius(int i) {
        this.y = i;
    }

    public void setStrokeColor(int i) {
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.u.setStrokeWidth(i);
        this.f = i;
    }
}
