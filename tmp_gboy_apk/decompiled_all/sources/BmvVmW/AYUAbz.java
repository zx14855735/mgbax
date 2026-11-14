package BmvVmW;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AYUAbz extends Drawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Bitmap f1508A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f1509A4TApA;
    public final BitmapShader AMqCpz;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f1513ASJ6gh;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final int f1517AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f1518AcNBzu;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f1510A5SV6n = 119;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Paint f1511ADYaiT = new Paint(3);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Matrix f1512ARc23Z = new Matrix();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final Rect f1514AYUAbz = new Rect();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final RectF f1515AZOQYO = new RectF();

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f1516AZkASS = true;

    public AYUAbz(Resources resources, Bitmap bitmap) {
        this.f1509A4TApA = 160;
        if (resources != null) {
            this.f1509A4TApA = resources.getDisplayMetrics().densityDpi;
        }
        this.f1508A2egSU = bitmap;
        if (bitmap == null) {
            this.f1518AcNBzu = -1;
            this.f1517AaHO0E = -1;
            this.AMqCpz = null;
        } else {
            int i = this.f1509A4TApA;
            this.f1517AaHO0E = bitmap.getScaledWidth(i);
            this.f1518AcNBzu = bitmap.getScaledHeight(i);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.AMqCpz = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    public abstract void A2egSU(int i, int i2, int i3, Rect rect, Rect rect2);

    public final void A4TApA() {
        if (this.f1516AZkASS) {
            A2egSU(this.f1510A5SV6n, this.f1517AaHO0E, this.f1518AcNBzu, getBounds(), this.f1514AYUAbz);
            RectF rectF = this.f1515AZOQYO;
            rectF.set(this.f1514AYUAbz);
            BitmapShader bitmapShader = this.AMqCpz;
            if (bitmapShader != null) {
                Matrix matrix = this.f1512ARc23Z;
                matrix.setTranslate(rectF.left, rectF.top);
                float width = rectF.width();
                Bitmap bitmap = this.f1508A2egSU;
                matrix.preScale(width / bitmap.getWidth(), rectF.height() / bitmap.getHeight());
                bitmapShader.setLocalMatrix(matrix);
                this.f1511ADYaiT.setShader(bitmapShader);
            }
            this.f1516AZkASS = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.f1508A2egSU;
        if (bitmap == null) {
            return;
        }
        A4TApA();
        Paint paint = this.f1511ADYaiT;
        if (paint.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f1514AYUAbz, paint);
            return;
        }
        RectF rectF = this.f1515AZOQYO;
        float f = this.f1513ASJ6gh;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f1511ADYaiT.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f1511ADYaiT.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f1518AcNBzu;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f1517AaHO0E;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Bitmap bitmap;
        return (this.f1510A5SV6n != 119 || (bitmap = this.f1508A2egSU) == null || bitmap.hasAlpha() || this.f1511ADYaiT.getAlpha() < 255 || this.f1513ASJ6gh > 0.05f) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1516AZkASS = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Paint paint = this.f1511ADYaiT;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1511ADYaiT.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.f1511ADYaiT.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.f1511ADYaiT.setFilterBitmap(z);
        invalidateSelf();
    }
}
