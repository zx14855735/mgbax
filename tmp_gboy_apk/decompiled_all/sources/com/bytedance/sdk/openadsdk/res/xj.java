package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends Drawable {
    private int hf;
    private float w;
    private Paint xj;

    public xj(int i) {
        this.hf = i;
        Paint paint = new Paint();
        this.xj = paint;
        paint.setAntiAlias(true);
        this.xj.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float centerX = getBounds().centerX();
        float centerY = getBounds().centerY();
        float f = this.hf / 2.0f;
        float f2 = centerX - ((3.0f * f) / 4.0f);
        float f3 = (f / 4.0f) + centerX;
        float f4 = f3 - f2;
        canvas.drawLine(f2, (this.w / 4.0f) + centerY, f3, centerY - f4, this.xj);
        canvas.drawLine(f2, centerY - (this.w / 4.0f), f3, f4 + centerY, this.xj);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (this.hf * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (this.hf * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.xj.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.xj.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.xj.setColorFilter(colorFilter);
    }

    public void xj(int i) {
        this.xj.setColor(i);
    }

    public void xj(float f) {
        this.xj.setStrokeWidth(f);
        this.w = f;
    }
}
