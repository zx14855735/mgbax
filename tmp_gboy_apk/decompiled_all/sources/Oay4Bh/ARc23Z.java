package Oay4Bh;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends Drawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Drawable f6519A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Drawable f6520A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final float[] f6521A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f6522ADYaiT;

    public ARc23Z(Drawable drawable, Drawable drawable2) {
        Drawable mutate = drawable != null ? drawable.getConstantState().newDrawable().mutate() : new Mm8v1u.AYUAbz(2);
        this.f6519A2egSU = mutate;
        Drawable mutate2 = drawable2 != null ? drawable2.getConstantState().newDrawable().mutate() : new Mm8v1u.AYUAbz(2);
        this.f6520A4TApA = mutate2;
        int BPw6Q82 = drawable != null ? com.bumptech.glide.A5SV6n.BPw6Q8(drawable) : 3;
        int BPw6Q83 = drawable2 != null ? com.bumptech.glide.A5SV6n.BPw6Q8(drawable2) : 3;
        com.bumptech.glide.A5SV6n.D8cQ8b(mutate, BPw6Q82);
        com.bumptech.glide.A5SV6n.D8cQ8b(mutate2, BPw6Q83);
        mutate2.setAlpha(0);
        this.f6521A5SV6n = new float[2];
    }

    public final void A2egSU(float f) {
        if (this.f6522ADYaiT != f) {
            this.f6522ADYaiT = f;
            float[] fArr = this.f6521A5SV6n;
            C4FrIb.A4TApA(f, fArr);
            this.f6519A2egSU.setAlpha((int) (fArr[0] * 255.0f));
            this.f6520A4TApA.setAlpha((int) (fArr[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f6519A2egSU.draw(canvas);
        this.f6520A4TApA.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f6519A2egSU.getIntrinsicHeight(), this.f6520A4TApA.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f6519A2egSU.getIntrinsicWidth(), this.f6520A4TApA.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return Math.max(this.f6519A2egSU.getMinimumHeight(), this.f6520A4TApA.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return Math.max(this.f6519A2egSU.getMinimumWidth(), this.f6520A4TApA.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f6519A2egSU.isStateful() || this.f6520A4TApA.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        float f = this.f6522ADYaiT;
        Drawable drawable = this.f6520A4TApA;
        Drawable drawable2 = this.f6519A2egSU;
        if (f <= 0.5f) {
            drawable2.setAlpha(i);
            drawable.setAlpha(0);
        } else {
            drawable2.setAlpha(0);
            drawable.setAlpha(i);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f6519A2egSU.setBounds(i, i2, i3, i4);
        this.f6520A4TApA.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6519A2egSU.setColorFilter(colorFilter);
        this.f6520A4TApA.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        return this.f6519A2egSU.setState(iArr) || this.f6520A4TApA.setState(iArr);
    }
}
