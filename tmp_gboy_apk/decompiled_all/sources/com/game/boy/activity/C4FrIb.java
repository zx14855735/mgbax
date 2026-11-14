package com.game.boy.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.sigmob.sdk.base.blurkit.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class C4FrIb extends Drawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Bitmap f10938A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f10939A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Paint f10940A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Paint f10941ADYaiT;
    public final RectF AMqCpz = new RectF();

    public C4FrIb(Bitmap bitmap, int i) {
        this.f10938A2egSU = bitmap;
        this.f10939A4TApA = i;
        Paint paint = new Paint();
        this.f10940A5SV6n = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Paint paint2 = new Paint();
        this.f10941ADYaiT = paint2;
        paint2.setColor(d.f13043a);
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint = this.f10941ADYaiT;
        Bitmap bitmap = this.f10938A2egSU;
        if (bitmap == null || bitmap.isRecycled()) {
            canvas.drawRect(getBounds(), paint);
            return;
        }
        int width = getBounds().width();
        int height = getBounds().height();
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        float f = width;
        float f2 = height;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(this.f10939A4TApA);
        Paint paint2 = this.f10940A5SV6n;
        RectF rectF = this.AMqCpz;
        if (ADYaiT2 == 0) {
            float f3 = width2;
            float f4 = height2;
            float max = Math.max(f / f3, f2 / f4);
            float f5 = f3 * max;
            float f6 = f4 * max;
            float f7 = (f - f5) / 2.0f;
            float f8 = (f2 - f6) / 2.0f;
            rectF.set(f7, f8, f5 + f7, f6 + f8);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
            return;
        }
        if (ADYaiT2 != 1) {
            if (ADYaiT2 == 2) {
                rectF.set(0.0f, 0.0f, f, f2);
                canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
                return;
            } else {
                if (ADYaiT2 != 3) {
                    return;
                }
                canvas.drawBitmap(bitmap, (width - width2) / 2.0f, (height - height2) / 2.0f, paint2);
                return;
            }
        }
        float f9 = width2;
        float f10 = height2;
        float min = Math.min(f / f9, f2 / f10);
        float f11 = f9 * min;
        float f12 = f10 * min;
        float f13 = (f - f11) / 2.0f;
        float f14 = (f2 - f12) / 2.0f;
        rectF.set(f13, f14, f11 + f13, f12 + f14);
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Bitmap bitmap = this.f10938A2egSU;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Bitmap bitmap = this.f10938A2egSU;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f10940A5SV6n.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f10940A5SV6n.setColorFilter(colorFilter);
    }
}
