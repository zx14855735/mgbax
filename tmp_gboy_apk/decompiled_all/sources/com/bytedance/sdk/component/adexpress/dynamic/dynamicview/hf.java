package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends GradientDrawable {
    private final Paint hf;
    protected Path xj;

    public hf() {
        this.xj = new Path();
        Paint paint = new Paint(1);
        this.hf = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.xj;
        if (path == null || path.isEmpty()) {
            xj(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.hf, 31);
        xj(canvas);
        this.hf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.xj, this.hf);
        this.hf.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.xj.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }

    public void xj(Canvas canvas) {
        super.draw(canvas);
    }

    public hf(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        super(orientation, iArr);
        this.xj = new Path();
        Paint paint = new Paint(1);
        this.hf = paint;
        paint.setColor(-1);
    }
}
