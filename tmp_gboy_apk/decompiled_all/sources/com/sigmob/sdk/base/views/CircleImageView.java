package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CircleImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    protected float f13238a;
    protected boolean b;
    private float c;
    private float d;
    private final Paint e;
    private final Matrix f;
    private RectF g;

    public CircleImageView(Context context) {
        this(context, null);
    }

    private BitmapShader a() {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return null;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        float max = Math.max(this.c / bitmap.getWidth(), this.c / bitmap.getHeight());
        this.f.setScale(max, max);
        bitmapShader.setLocalMatrix(this.f);
        return bitmapShader;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        BitmapShader a2 = a();
        if (a2 == null) {
            super.onDraw(canvas);
            return;
        }
        this.e.setShader(a2);
        if (this.b) {
            float f = this.c;
            canvas.drawCircle(f / 2.0f, f / 2.0f, f / 2.0f, this.e);
        } else {
            RectF rectF = this.g;
            float f2 = this.f13238a;
            canvas.drawRoundRect(rectF, f2, f2, this.e);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.d = measuredHeight;
        this.c = Math.min(this.c, measuredHeight);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = new RectF(0.0f, 0.0f, getHeight(), getHeight());
    }

    public void setCircle(boolean z) {
        this.b = z;
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.f = new Matrix();
        this.f13238a = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
    }
}
