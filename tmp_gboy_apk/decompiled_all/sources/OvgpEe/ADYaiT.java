package OvgpEe;

import Oay4Bh.C4FrIb;
import android.R;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ADYaiT extends ProgressBar {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B25kr6 f6825AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f6826AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f6827AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f6828AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public A2egSU f6829B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f6830B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f6831B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f6832B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final A4TApA f6833B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final A4TApA f6834B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final A5SV6n f6835BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final A5SV6n f6836BI9f7h;

    public ADYaiT(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130969499, 2131952898), attributeSet, 2130969499);
        this.f6830B2KMhB = false;
        this.f6831B3GDIM = 4;
        this.f6833B7CMnp = new A4TApA(this, 0);
        this.f6834B9tovu = new A4TApA(this, 1);
        this.f6835BChYOn = new A5SV6n(this, 0);
        this.f6836BI9f7h = new A5SV6n(this, 1);
        Context context2 = getContext();
        B25kr6 b25kr6 = new B25kr6();
        b25kr6.AMqCpz = new int[0];
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(2131166491);
        int[] iArr = R$styleable.f11215ADYaiT;
        C4FrIb.ADYaiT(context2, attributeSet, 2130969499, 2131952861);
        C4FrIb.AMqCpz(context2, attributeSet, iArr, 2130969499, 2131952861, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 2130969499, 2131952861);
        b25kr6.f6908A2egSU = com.bumptech.glide.AMqCpz.BTvldC(context2, obtainStyledAttributes, 10, dimensionPixelSize);
        TypedValue peekValue = obtainStyledAttributes.peekValue(9);
        if (peekValue != null) {
            int i = peekValue.type;
            if (i == 5) {
                b25kr6.f6909A4TApA = Math.min(TypedValue.complexToDimensionPixelSize(peekValue.data, obtainStyledAttributes.getResources().getDisplayMetrics()), b25kr6.f6908A2egSU / 2);
                b25kr6.f6911ADYaiT = false;
            } else if (i == 6) {
                b25kr6.f6910A5SV6n = Math.min(peekValue.getFraction(1.0f, 1.0f), 0.5f);
                b25kr6.f6911ADYaiT = true;
            }
        }
        b25kr6.f6913ASJ6gh = obtainStyledAttributes.getInt(6, 0);
        b25kr6.f6914AYUAbz = obtainStyledAttributes.getInt(1, 0);
        b25kr6.f6915AZOQYO = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        int abs = Math.abs(obtainStyledAttributes.getDimensionPixelSize(13, 0));
        b25kr6.f6916AZkASS = Math.abs(obtainStyledAttributes.getDimensionPixelSize(14, abs));
        b25kr6.f6917AaHO0E = Math.abs(obtainStyledAttributes.getDimensionPixelSize(15, abs));
        b25kr6.f6918AcNBzu = Math.abs(obtainStyledAttributes.getDimensionPixelSize(11, 0));
        b25kr6.f6919AlLFFp = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        b25kr6.f6920AmA8tU = obtainStyledAttributes.getFloat(2, 1.0f);
        if (!obtainStyledAttributes.hasValue(3)) {
            b25kr6.AMqCpz = new int[]{OLy1FW.AYUAbz.AYUAbz(context2, 2130968881, -1)};
        } else if (obtainStyledAttributes.peekValue(3).type != 1) {
            b25kr6.AMqCpz = new int[]{obtainStyledAttributes.getColor(3, -1)};
        } else {
            int[] intArray = context2.getResources().getIntArray(obtainStyledAttributes.getResourceId(3, -1));
            b25kr6.AMqCpz = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        if (obtainStyledAttributes.hasValue(8)) {
            b25kr6.f6912ARc23Z = obtainStyledAttributes.getColor(8, -1);
        } else {
            b25kr6.f6912ARc23Z = b25kr6.AMqCpz[0];
            TypedArray obtainStyledAttributes2 = context2.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
            float f = obtainStyledAttributes2.getFloat(0, 0.2f);
            obtainStyledAttributes2.recycle();
            b25kr6.f6912ARc23Z = OLy1FW.AYUAbz.ADYaiT(b25kr6.f6912ARc23Z, (int) (f * 255.0f));
        }
        obtainStyledAttributes.recycle();
        int[] iArr2 = R$styleable.f11228B3GDIM;
        C4FrIb.ADYaiT(context2, attributeSet, 2130969499, 2131952861);
        C4FrIb.AMqCpz(context2, attributeSet, iArr2, 2130969499, 2131952861, new int[0]);
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr2, 2130969499, 2131952861);
        b25kr6.f6921AzWtSf = obtainStyledAttributes3.getInt(0, 1);
        b25kr6.f6922B25kr6 = obtainStyledAttributes3.getInt(1, 0);
        b25kr6.f6924B3GDIM = Math.min(obtainStyledAttributes3.getDimensionPixelSize(4, 0), b25kr6.f6908A2egSU);
        if (obtainStyledAttributes3.hasValue(3)) {
            b25kr6.f6925B4ZgIw = Integer.valueOf(obtainStyledAttributes3.getDimensionPixelSize(3, 0));
        }
        TypedValue peekValue2 = obtainStyledAttributes3.peekValue(2);
        if (peekValue2 != null) {
            int i2 = peekValue2.type;
            if (i2 == 5) {
                b25kr6.f6926B7CMnp = Math.min(TypedValue.complexToDimensionPixelSize(peekValue2.data, obtainStyledAttributes3.getResources().getDisplayMetrics()), b25kr6.f6908A2egSU / 2);
                b25kr6.f6928BChYOn = false;
                b25kr6.f6929BI9f7h = true;
            } else if (i2 == 6) {
                b25kr6.f6927B9tovu = Math.min(peekValue2.getFraction(1.0f, 1.0f), 0.5f);
                b25kr6.f6928BChYOn = true;
                b25kr6.f6929BI9f7h = true;
            }
        }
        obtainStyledAttributes3.recycle();
        b25kr6.ADYaiT();
        b25kr6.f6923B2KMhB = b25kr6.f6922B25kr6 == 1;
        this.f6825AcNBzu = b25kr6;
        C4FrIb.ADYaiT(context2, attributeSet, 2130969499, 2131952861);
        C4FrIb.AMqCpz(context2, attributeSet, iArr, 2130969499, 2131952861, new int[0]);
        TypedArray obtainStyledAttributes4 = context2.obtainStyledAttributes(attributeSet, iArr, 2130969499, 2131952861);
        obtainStyledAttributes4.getInt(7, -1);
        this.f6828AzWtSf = Math.min(obtainStyledAttributes4.getInt(5, -1), 1000);
        obtainStyledAttributes4.recycle();
        this.f6829B25kr6 = new A2egSU();
        this.f6827AmA8tU = true;
    }

    private AZkASS getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f6876BJ7GGh;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().f6838BJ7GGh;
    }

    public void A2egSU(int i) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() != null) {
                getProgressDrawable().jumpToCurrentState();
                return;
            }
            return;
        }
        if (getProgressDrawable() != null) {
            this.f6826AlLFFp = i;
            this.f6830B2KMhB = true;
            if (getIndeterminateDrawable().isVisible()) {
                A2egSU a2egSU = this.f6829B25kr6;
                ContentResolver contentResolver = getContext().getContentResolver();
                a2egSU.getClass();
                if (A2egSU.A2egSU(contentResolver) != 0.0f) {
                    getIndeterminateDrawable().f6877BNL6CD.AcNBzu();
                    return;
                }
            }
            this.f6835BChYOn.A2egSU(getIndeterminateDrawable());
        }
    }

    public final boolean A4TApA() {
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f6825AcNBzu.f6914AYUAbz;
    }

    public int[] getIndicatorColor() {
        return this.f6825AcNBzu.AMqCpz;
    }

    public int getIndicatorTrackGapSize() {
        return this.f6825AcNBzu.f6915AZOQYO;
    }

    public int getShowAnimationBehavior() {
        return this.f6825AcNBzu.f6913ASJ6gh;
    }

    public int getTrackColor() {
        return this.f6825AcNBzu.f6912ARc23Z;
    }

    public int getTrackCornerRadius() {
        return this.f6825AcNBzu.f6909A4TApA;
    }

    public float getTrackCornerRadiusFraction() {
        return this.f6825AcNBzu.f6910A5SV6n;
    }

    public int getTrackThickness() {
        return this.f6825AcNBzu.f6908A2egSU;
    }

    public int getWaveAmplitude() {
        return this.f6825AcNBzu.f6918AcNBzu;
    }

    public int getWaveSpeed() {
        return this.f6825AcNBzu.f6919AlLFFp;
    }

    public int getWavelengthDeterminate() {
        return this.f6825AcNBzu.f6916AZkASS;
    }

    public int getWavelengthIndeterminate() {
        return this.f6825AcNBzu.f6917AaHO0E;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f6877BNL6CD.AaHO0E(this.f6835BChYOn);
        }
        AMqCpz progressDrawable = getProgressDrawable();
        A5SV6n a5SV6n = this.f6836BI9f7h;
        if (progressDrawable != null) {
            AMqCpz progressDrawable2 = getProgressDrawable();
            if (progressDrawable2.f6857B3GDIM == null) {
                progressDrawable2.f6857B3GDIM = new ArrayList();
            }
            if (!progressDrawable2.f6857B3GDIM.contains(a5SV6n)) {
                progressDrawable2.f6857B3GDIM.add(a5SV6n);
            }
        }
        if (getIndeterminateDrawable() != null) {
            AaHO0E indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable.f6857B3GDIM == null) {
                indeterminateDrawable.f6857B3GDIM = new ArrayList();
            }
            if (!indeterminateDrawable.f6857B3GDIM.contains(a5SV6n)) {
                indeterminateDrawable.f6857B3GDIM.add(a5SV6n);
            }
        }
        if (A4TApA()) {
            if (this.f6828AzWtSf > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f6834B9tovu);
        removeCallbacks(this.f6833B7CMnp);
        ((ASJ6gh) getCurrentDrawable()).ADYaiT(false, false, false);
        AaHO0E indeterminateDrawable = getIndeterminateDrawable();
        A5SV6n a5SV6n = this.f6836BI9f7h;
        if (indeterminateDrawable != null) {
            getIndeterminateDrawable().ARc23Z(a5SV6n);
            getIndeterminateDrawable().f6877BNL6CD.AzWtSf();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().ARc23Z(a5SV6n);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (getPaddingRight() == 0 || getPaddingBottom() != 0) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getPaddingRight() == 0) {
            }
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getCurrentDrawingDelegate().A4TApA();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        try {
            AZkASS currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), currentDrawingDelegate.A2egSU() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i2) : currentDrawingDelegate.A2egSU() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        if (this.f6827AmA8tU) {
            ((ASJ6gh) getCurrentDrawable()).ADYaiT(A4TApA(), false, z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f6827AmA8tU) {
            ((ASJ6gh) getCurrentDrawable()).ADYaiT(A4TApA(), false, false);
        }
    }

    public void setAnimatorDurationScaleProvider(A2egSU a2egSU) {
        this.f6829B25kr6 = a2egSU;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f6853AmA8tU = a2egSU;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f6853AmA8tU = a2egSU;
        }
    }

    public void setHideAnimationBehavior(int i) {
        this.f6825AcNBzu.f6914AYUAbz = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            ASJ6gh aSJ6gh = (ASJ6gh) getCurrentDrawable();
            if (aSJ6gh != null) {
                aSJ6gh.ADYaiT(false, false, false);
            }
            super.setIndeterminate(z);
            ASJ6gh aSJ6gh2 = (ASJ6gh) getCurrentDrawable();
            if (aSJ6gh2 != null) {
                aSJ6gh2.ADYaiT(A4TApA(), false, false);
            }
            if ((aSJ6gh2 instanceof AaHO0E) && A4TApA()) {
                ((AaHO0E) aSJ6gh2).f6877BNL6CD.AmA8tU();
            }
            this.f6830B2KMhB = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndeterminateAnimatorDurationScale(float f) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6920AmA8tU != f) {
            b25kr6.f6920AmA8tU = f;
            getIndeterminateDrawable().f6877BNL6CD.AZOQYO();
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof AaHO0E) {
            ((ASJ6gh) drawable).ADYaiT(false, false, false);
            super.setIndeterminateDrawable(drawable);
        } else {
            if (this.f6832B4ZgIw) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{OLy1FW.AYUAbz.AYUAbz(getContext(), 2130968881, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f6825AcNBzu.AMqCpz = iArr;
        getIndeterminateDrawable().f6877BNL6CD.AZOQYO();
        invalidate();
    }

    public void setIndicatorTrackGapSize(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6915AZOQYO != i) {
            b25kr6.f6915AZOQYO = i;
            b25kr6.ADYaiT();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        A2egSU(i);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (!(drawable instanceof AMqCpz)) {
            if (this.f6832B4ZgIw) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            super.setProgressDrawable(drawable);
        } else {
            AMqCpz aMqCpz = (AMqCpz) drawable;
            aMqCpz.ADYaiT(false, false, false);
            super.setProgressDrawable(aMqCpz);
            aMqCpz.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
        }
    }

    public void setShowAnimationBehavior(int i) {
        this.f6825AcNBzu.f6913ASJ6gh = i;
        invalidate();
    }

    public void setTrackColor(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6912ARc23Z != i) {
            b25kr6.f6912ARc23Z = i;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6909A4TApA != i) {
            b25kr6.f6909A4TApA = Math.min(i, b25kr6.f6908A2egSU / 2);
            b25kr6.f6911ADYaiT = false;
            invalidate();
        }
    }

    public void setTrackCornerRadiusFraction(float f) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6910A5SV6n != f) {
            b25kr6.f6910A5SV6n = Math.min(f, 0.5f);
            b25kr6.f6911ADYaiT = true;
            invalidate();
        }
    }

    public void setTrackThickness(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6908A2egSU != i) {
            b25kr6.f6908A2egSU = i;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i != 0 && i != 4 && i != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f6831B3GDIM = i;
    }

    public void setWaveAmplitude(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6918AcNBzu != i) {
            b25kr6.f6918AcNBzu = Math.abs(i);
            requestLayout();
        }
    }

    public void setWaveSpeed(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        b25kr6.f6919AlLFFp = i;
        AMqCpz progressDrawable = getProgressDrawable();
        boolean z = b25kr6.f6919AlLFFp != 0;
        ValueAnimator valueAnimator = progressDrawable.f6844BniPrB;
        if (z && !valueAnimator.isRunning()) {
            valueAnimator.start();
        } else {
            if (z || !valueAnimator.isRunning()) {
                return;
            }
            valueAnimator.cancel();
        }
    }

    public void setWavelength(int i) {
        setWavelengthDeterminate(i);
        setWavelengthIndeterminate(i);
    }

    public void setWavelengthDeterminate(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6916AZkASS != i) {
            b25kr6.f6916AZkASS = Math.abs(i);
            if (isIndeterminate()) {
                return;
            }
            requestLayout();
        }
    }

    public void setWavelengthIndeterminate(int i) {
        B25kr6 b25kr6 = this.f6825AcNBzu;
        if (b25kr6.f6917AaHO0E != i) {
            b25kr6.f6917AaHO0E = Math.abs(i);
            if (isIndeterminate()) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public AaHO0E getIndeterminateDrawable() {
        return (AaHO0E) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public AMqCpz getProgressDrawable() {
        return (AMqCpz) super.getProgressDrawable();
    }
}
