package com.google.android.material.imageview;

import BPw6Q8.ASJ6gh;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PCV8se.B4ZgIw;
import PCV8se.B7CMnp;
import PCV8se.BPw6Q8;
import PXXBzr.A2egSU;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ShapeableImageView extends AppCompatImageView implements BPw6Q8 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f11667AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final RectF f11668AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final RectF f11669AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Paint f11670AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Paint f11671B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Path f11672B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ColorStateList f11673B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public AaHO0E f11674B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public B2KMhB f11675B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public float f11676B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final Path f11677BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final int f11678BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final int f11679BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final int f11680BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final int f11681BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final int f11682BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final int f11683BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f11684BV3sI0;

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 0, 2131952899), attributeSet, 0);
        this.f11667AcNBzu = B4ZgIw.f7105A2egSU;
        this.f11672B2KMhB = new Path();
        this.f11684BV3sI0 = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f11671B25kr6 = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f11668AlLFFp = new RectF();
        this.f11669AmA8tU = new RectF();
        this.f11677BChYOn = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.f11256CrfGsy, 0, 2131952899);
        setLayerType(2, null);
        this.f11673B3GDIM = AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 9);
        this.f11676B9tovu = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f11678BI9f7h = dimensionPixelSize;
        this.f11679BIYEnU = dimensionPixelSize;
        this.f11680BJ7GGh = dimensionPixelSize;
        this.f11681BNL6CD = dimensionPixelSize;
        this.f11678BI9f7h = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.f11679BIYEnU = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        this.f11680BJ7GGh = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.f11681BNL6CD = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.f11682BPw6Q8 = obtainStyledAttributes.getDimensionPixelSize(5, Integer.MIN_VALUE);
        this.f11683BTvldC = obtainStyledAttributes.getDimensionPixelSize(2, Integer.MIN_VALUE);
        obtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f11670AzWtSf = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f11675B7CMnp = B2KMhB.A5SV6n(context2, attributeSet, 0, 2131952899).A2egSU();
        setOutlineProvider(new OWRe4G.A2egSU(this));
    }

    public final boolean A2egSU() {
        return getLayoutDirection() == 1;
    }

    public final void ADYaiT(int i, int i2) {
        RectF rectF = this.f11668AlLFFp;
        rectF.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
        B2KMhB b2KMhB = this.f11675B7CMnp;
        Path path = this.f11672B2KMhB;
        this.f11667AcNBzu.A2egSU(b2KMhB, null, 1.0f, rectF, null, path);
        Path path2 = this.f11677BChYOn;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.f11669AmA8tU;
        rectF2.set(0.0f, 0.0f, i, i2);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f11681BNL6CD;
    }

    public final int getContentPaddingEnd() {
        int i = this.f11683BTvldC;
        return i != Integer.MIN_VALUE ? i : A2egSU() ? this.f11678BI9f7h : this.f11680BJ7GGh;
    }

    public int getContentPaddingLeft() {
        int i;
        int i2;
        if (this.f11682BPw6Q8 != Integer.MIN_VALUE || this.f11683BTvldC != Integer.MIN_VALUE) {
            if (A2egSU() && (i2 = this.f11683BTvldC) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!A2egSU() && (i = this.f11682BPw6Q8) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.f11678BI9f7h;
    }

    public int getContentPaddingRight() {
        int i;
        int i2;
        if (this.f11682BPw6Q8 != Integer.MIN_VALUE || this.f11683BTvldC != Integer.MIN_VALUE) {
            if (A2egSU() && (i2 = this.f11682BPw6Q8) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!A2egSU() && (i = this.f11683BTvldC) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.f11680BJ7GGh;
    }

    public final int getContentPaddingStart() {
        int i = this.f11682BPw6Q8;
        return i != Integer.MIN_VALUE ? i : A2egSU() ? this.f11680BJ7GGh : this.f11678BI9f7h;
    }

    public int getContentPaddingTop() {
        return this.f11679BIYEnU;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public B2KMhB getShapeAppearanceModel() {
        return this.f11675B7CMnp;
    }

    public ColorStateList getStrokeColor() {
        return this.f11673B3GDIM;
    }

    public float getStrokeWidth() {
        return this.f11676B9tovu;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f11677BChYOn, this.f11671B25kr6);
        if (this.f11673B3GDIM == null) {
            return;
        }
        Paint paint = this.f11670AzWtSf;
        paint.setStrokeWidth(this.f11676B9tovu);
        int colorForState = this.f11673B3GDIM.getColorForState(getDrawableState(), this.f11673B3GDIM.getDefaultColor());
        if (this.f11676B9tovu <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.f11672B2KMhB, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.f11684BV3sI0 && isLayoutDirectionResolved()) {
            this.f11684BV3sI0 = true;
            if (!isPaddingRelative() && this.f11682BPw6Q8 == Integer.MIN_VALUE && this.f11683BTvldC == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ADYaiT(i, i2);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(getContentPaddingLeft() + i, getContentPaddingTop() + i2, getContentPaddingRight() + i3, getContentPaddingBottom() + i4);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(getContentPaddingStart() + i, getContentPaddingTop() + i2, getContentPaddingEnd() + i3, getContentPaddingBottom() + i4);
    }

    @Override // PCV8se.BPw6Q8
    public void setShapeAppearanceModel(B2KMhB b2KMhB) {
        this.f11675B7CMnp = b2KMhB;
        AaHO0E aaHO0E = this.f11674B4ZgIw;
        if (aaHO0E != null) {
            aaHO0E.setShapeAppearanceModel(b2KMhB);
        }
        ADYaiT(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f11673B3GDIM = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(ASJ6gh.A5SV6n(getContext(), i));
    }

    public void setStrokeWidth(float f) {
        if (this.f11676B9tovu != f) {
            this.f11676B9tovu = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }
}
