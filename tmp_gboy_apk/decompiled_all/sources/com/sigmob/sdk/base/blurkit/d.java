package com.sigmob.sdk.base.blurkit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13043a = -16777216;
    public static final int b = 0;
    private float c;
    private final RectF d;
    private final PorterDuffXfermode e;

    public d(Context context) {
        super(context, null);
        this.c = 0.0f;
        this.d = new RectF();
        this.e = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public float getCornerRadius() {
        return this.c;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable) || this.c <= 0.0f) {
            super.onDraw(canvas);
            return;
        }
        this.d.set(drawable.getBounds());
        int saveLayer = canvas.saveLayer(this.d, null, 31);
        getImageMatrix().mapRect(this.d);
        Paint paint = ((BitmapDrawable) drawable).getPaint();
        paint.setAntiAlias(true);
        paint.setColor(f13043a);
        Xfermode xfermode = paint.getXfermode();
        canvas.drawARGB(0, 0, 0, 0);
        RectF rectF = this.d;
        float f = this.c;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(this.e);
        super.onDraw(canvas);
        paint.setXfermode(xfermode);
        canvas.restoreToCount(saveLayer);
    }

    public void setCornerRadius(float f) {
        this.c = f;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0.0f;
        this.d = new RectF();
        this.e = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
}
