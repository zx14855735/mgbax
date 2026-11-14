package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends Drawable {
    private int hf;
    private Paint xj;

    public w(int i) {
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
        float f = ((this.hf / 2.0f) * 3.0f) / 4.0f;
        float f2 = centerX - f;
        float f3 = centerY - f;
        float f4 = centerX + f;
        float f5 = centerY + f;
        canvas.drawLine(f2, f3, f4, f5, this.xj);
        canvas.drawLine(f4, f3, f2, f5, this.xj);
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
    }
}
