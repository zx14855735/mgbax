package AzWtSf;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends Drawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public float f957A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Paint f958A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final RectF f959A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Rect f960ADYaiT;
    public float AMqCpz;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ColorStateList f963AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public PorterDuffColorFilter f964AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public ColorStateList f965AZkASS;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f961ARc23Z = false;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f962ASJ6gh = true;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public PorterDuff.Mode f966AaHO0E = PorterDuff.Mode.SRC_IN;

    public A2egSU(ColorStateList colorStateList, float f) {
        this.f957A2egSU = f;
        Paint paint = new Paint(5);
        this.f958A4TApA = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f963AYUAbz = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f963AYUAbz.getDefaultColor()));
        this.f959A5SV6n = new RectF();
        this.f960ADYaiT = new Rect();
    }

    public final PorterDuffColorFilter A2egSU(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void A4TApA(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f959A5SV6n;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f960ADYaiT;
        rect2.set(rect);
        if (this.f961ARc23Z) {
            rect2.inset((int) Math.ceil(A4TApA.A2egSU(this.AMqCpz, this.f957A2egSU, this.f962ASJ6gh)), (int) Math.ceil(A4TApA.A4TApA(this.AMqCpz, this.f957A2egSU, this.f962ASJ6gh)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f958A4TApA;
        if (this.f964AZOQYO == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f964AZOQYO);
            z = true;
        }
        RectF rectF = this.f959A5SV6n;
        float f = this.f957A2egSU;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f960ADYaiT, this.f957A2egSU);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f965AZkASS;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f963AYUAbz;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        A4TApA(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f963AYUAbz;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f958A4TApA;
        boolean z = colorForState != paint.getColor();
        if (z) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f965AZkASS;
        if (colorStateList2 == null || (mode = this.f966AaHO0E) == null) {
            return z;
        }
        this.f964AZOQYO = A2egSU(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f958A4TApA.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f958A4TApA.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f965AZkASS = colorStateList;
        this.f964AZOQYO = A2egSU(colorStateList, this.f966AaHO0E);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f966AaHO0E = mode;
        this.f964AZOQYO = A2egSU(this.f965AZkASS, mode);
        invalidateSelf();
    }
}
