package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends hf {
    private final Rect hf = new Rect();
    private final Paint u = new Paint(1);
    private final Bitmap w;

    public xj(Bitmap bitmap, hf hfVar) {
        this.w = bitmap;
        if (hfVar != null) {
            this.xj = hfVar.xj;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        int width = rect.width();
        int width2 = this.w.getWidth();
        int height2 = this.w.getHeight();
        this.hf.set(0, 0, width2, height2);
        if (height2 >= height && width2 >= width) {
            if (width2 > width) {
                Rect rect2 = this.hf;
                int i = (width2 - width) / 2;
                rect2.left = i;
                rect2.right = i + width;
            }
            if (height2 > height) {
                Rect rect3 = this.hf;
                int i2 = (height2 - height) / 2;
                rect3.top = i2;
                rect3.bottom = i2 + height;
                return;
            }
            return;
        }
        float f = height;
        float f2 = f * 1.0f;
        float f3 = height2;
        float f4 = f2 / f3;
        float f5 = width;
        float f6 = 1.0f * f5;
        float f7 = width2;
        if (Math.max(f4, f6 / f7) > f4) {
            int i3 = (int) ((f2 / f5) * f7);
            Rect rect4 = this.hf;
            int i4 = (height2 - i3) / 2;
            rect4.top = i4;
            rect4.bottom = i4 + i3;
            return;
        }
        int i5 = (int) ((f6 / f) * f3);
        Rect rect5 = this.hf;
        int i6 = (width2 - i5) / 2;
        rect5.left = i6;
        rect5.right = i6 + i5;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hf
    public void xj(Canvas canvas) {
        canvas.drawBitmap(this.w, this.hf, getBounds(), this.u);
    }
}
