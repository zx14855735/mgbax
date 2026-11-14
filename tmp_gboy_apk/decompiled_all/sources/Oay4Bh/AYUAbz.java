package Oay4Bh;

import AaHO0E.ErKPGd;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import com.google.android.material.R$styleable;
import com.qq.e.comm.adevent.AdEventType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AYUAbz extends ErKPGd {

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public Drawable f6527BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final Rect f6528BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final Rect f6529BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f6530BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final boolean f6531BniPrB;
    public boolean BpkvW3;

    public AYUAbz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6528BTvldC = new Rect();
        this.f6529BV3sI0 = new Rect();
        this.f6530BmvVmW = 119;
        this.f6531BniPrB = true;
        this.BpkvW3 = false;
        int[] iArr = R$styleable.f11226B25kr6;
        C4FrIb.ADYaiT(context, attributeSet, 0, 0);
        C4FrIb.AMqCpz(context, attributeSet, iArr, 0, 0, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        this.f6530BmvVmW = obtainStyledAttributes.getInt(1, this.f6530BmvVmW);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f6531BniPrB = obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f6527BPw6Q8;
        if (drawable != null) {
            if (this.BpkvW3) {
                this.BpkvW3 = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z = this.f6531BniPrB;
                Rect rect = this.f6528BTvldC;
                if (z) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i = this.f6530BmvVmW;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.f6529BV3sI0;
                Gravity.apply(i, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f6527BPw6Q8;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6527BPw6Q8;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f6527BPw6Q8.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f6527BPw6Q8;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f6530BmvVmW;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6527BPw6Q8;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // AaHO0E.ErKPGd, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.BpkvW3 = z | this.BpkvW3;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.BpkvW3 = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f6527BPw6Q8;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f6527BPw6Q8);
            }
            this.f6527BPw6Q8 = drawable;
            this.BpkvW3 = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f6530BmvVmW == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.f6530BmvVmW != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & AdEventType.AD_TICK) == 0) {
                i |= 48;
            }
            this.f6530BmvVmW = i;
            if (i == 119 && this.f6527BPw6Q8 != null) {
                this.f6527BPw6Q8.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6527BPw6Q8;
    }
}
