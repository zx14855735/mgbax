package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.sigmob.sdk.base.blurkit.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends Drawable {
    private int hf;
    private RectF u;
    private int w;
    private Paint xj;

    public w(int i, int i2) {
        this.w = i;
        this.hf = i2;
        Paint paint = new Paint();
        this.xj = paint;
        paint.setColor(0);
        this.xj.setAntiAlias(true);
        this.xj.setShadowLayer(i2, 0.0f, 0.0f, d.f13043a);
        this.xj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.u;
        int i = this.w;
        canvas.drawRoundRect(rectF, i, i, this.xj);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.xj.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.hf;
        this.u = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.xj.setColorFilter(colorFilter);
    }
}
