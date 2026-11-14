package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class TTRoundRectImageView extends ImageView {
    private int hf;
    private Matrix u;
    private int w;
    private Paint xj;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap xj(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap xj = xj(drawable);
        if (xj == null) {
            super.onDraw(canvas);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(xj, tileMode, tileMode);
        float max = (xj.getWidth() == getWidth() && xj.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / xj.getWidth(), (getHeight() * 1.0f) / xj.getHeight());
        this.u.setScale(max, max);
        bitmapShader.setLocalMatrix(this.u);
        this.xj.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.hf, this.w, this.xj);
    }

    public void setXRound(int i) {
        this.hf = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.w = i;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hf = 25;
        this.w = 25;
        Paint paint = new Paint();
        this.xj = paint;
        paint.setAntiAlias(true);
        this.xj.setFilterBitmap(true);
        this.u = new Matrix();
    }
}
