package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.component.sdk.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BrushMaskView extends View {
    private static final String xj = "BrushMaskView";
    private Paint c;
    private Paint f;
    private Paint hf;
    private Paint kd;
    private Canvas u;
    private Bitmap w;
    private BitmapDrawable y;

    private void xj(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.w = createBitmap;
            Canvas canvas = this.u;
            if (canvas == null) {
                this.u = new Canvas(this.w);
            } else {
                canvas.setBitmap(createBitmap);
            }
            this.u.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.hf);
            if (this.y != null) {
                this.y.setBounds(new Rect(0, 0, i, i2));
                this.y.draw(this.u);
            }
        } catch (Exception e) {
            pl.u(xj, e.getMessage());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.w;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.kd);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(xj(i), xj(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        xj(i, i2);
    }

    public void setEraserSize(float f) {
        this.c.setStrokeWidth(f);
        this.f.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.hf.setColor(i);
    }

    @RequiresApi(api = 21)
    public void setWatermark(int i) {
        if (i == -1) {
            this.y = null;
        } else {
            this.y = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    private int xj(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }
}
