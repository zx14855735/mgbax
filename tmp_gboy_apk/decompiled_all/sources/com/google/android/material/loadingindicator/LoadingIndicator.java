package com.google.android.material.loadingindicator;

import DcUJf1.B3GDIM;
import LqstKO.AMqCpz;
import LqstKO.ARc23Z;
import OLy1FW.AYUAbz;
import Oay4Bh.C4FrIb;
import OdANhw.A4TApA;
import OdANhw.A5SV6n;
import PXXBzr.A2egSU;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.R$styleable;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class LoadingIndicator extends View implements Drawable.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A4TApA f11706AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AMqCpz f11707AlLFFp;

    public LoadingIndicator(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130969515, 2131952720), attributeSet, 2130969515);
        Context context2 = getContext();
        AMqCpz aMqCpz = new AMqCpz();
        aMqCpz.f4937B25kr6 = new int[0];
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(2131166084);
        int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(2131166083);
        int[] iArr = R$styleable.f11229B4ZgIw;
        C4FrIb.ADYaiT(context2, attributeSet, 2130969515, 2131952720);
        C4FrIb.AMqCpz(context2, attributeSet, iArr, 2130969515, 2131952720, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 2130969515, 2131952720);
        aMqCpz.f4933AcNBzu = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        aMqCpz.f4934AlLFFp = obtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize2);
        aMqCpz.f4935AmA8tU = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize2);
        if (!obtainStyledAttributes.hasValue(3)) {
            aMqCpz.f4937B25kr6 = new int[]{AYUAbz.AYUAbz(context2, 2130968881, -1)};
        } else if (obtainStyledAttributes.peekValue(3).type != 1) {
            aMqCpz.f4937B25kr6 = new int[]{obtainStyledAttributes.getColor(3, -1)};
        } else {
            int[] intArray = context2.getResources().getIntArray(obtainStyledAttributes.getResourceId(3, -1));
            aMqCpz.f4937B25kr6 = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        aMqCpz.f4936AzWtSf = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        A5SV6n a5SV6n = new A5SV6n(aMqCpz);
        OdANhw.A2egSU a2egSU = new OdANhw.A2egSU();
        a2egSU.f6622ARc23Z = aMqCpz;
        a2egSU.f6624AYUAbz = new ARc23Z();
        A4TApA a4TApA = new A4TApA(context2, aMqCpz, a5SV6n, a2egSU);
        a4TApA.f6632B4ZgIw = B3GDIM.A2egSU(context2.getResources(), 2131231030, null);
        this.f11706AcNBzu = a4TApA;
        a4TApA.setCallback(this);
        this.f11707AlLFFp = a4TApA.f6628AzWtSf.f6634A2egSU;
        setAnimatorDurationScaleProvider(new OvgpEe.A2egSU());
    }

    public final boolean A2egSU() {
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

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    public int getContainerColor() {
        return this.f11707AlLFFp.f4936AzWtSf;
    }

    public int getContainerHeight() {
        return this.f11707AlLFFp.f4935AmA8tU;
    }

    public int getContainerWidth() {
        return this.f11707AlLFFp.f4934AlLFFp;
    }

    public A4TApA getDrawable() {
        return this.f11706AcNBzu;
    }

    public int[] getIndicatorColor() {
        return (int[]) this.f11707AlLFFp.f4937B25kr6;
    }

    public int getIndicatorSize() {
        return this.f11707AlLFFp.f4933AcNBzu;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingRight() + getPaddingLeft()), getHeight() - (getPaddingBottom() + getPaddingTop()));
        }
        this.f11706AcNBzu.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        A5SV6n a5SV6n = this.f11706AcNBzu.f6628AzWtSf;
        AMqCpz aMqCpz = a5SV6n.f6634A2egSU;
        int paddingRight = getPaddingRight() + getPaddingLeft() + Math.max(aMqCpz.f4935AmA8tU, aMqCpz.f4933AcNBzu);
        AMqCpz aMqCpz2 = a5SV6n.f6634A2egSU;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + Math.max(aMqCpz2.f4934AlLFFp, aMqCpz2.f4933AcNBzu);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(size, paddingRight), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(paddingRight, 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size2, paddingBottom), 1073741824);
        } else if (mode2 == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11706AcNBzu.setBounds(0, 0, i, i2);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.f11706AcNBzu.A2egSU(A2egSU(), false, i == 0);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f11706AcNBzu.A2egSU(A2egSU(), false, i == 0);
    }

    public void setAnimatorDurationScaleProvider(OvgpEe.A2egSU a2egSU) {
        this.f11706AcNBzu.f6625AcNBzu = a2egSU;
    }

    public void setContainerColor(int i) {
        AMqCpz aMqCpz = this.f11707AlLFFp;
        if (aMqCpz.f4936AzWtSf != i) {
            aMqCpz.f4936AzWtSf = i;
            invalidate();
        }
    }

    public void setContainerHeight(int i) {
        AMqCpz aMqCpz = this.f11707AlLFFp;
        if (aMqCpz.f4935AmA8tU != i) {
            aMqCpz.f4935AmA8tU = i;
            requestLayout();
            invalidate();
        }
    }

    public void setContainerWidth(int i) {
        AMqCpz aMqCpz = this.f11707AlLFFp;
        if (aMqCpz.f4934AlLFFp != i) {
            aMqCpz.f4934AlLFFp = i;
            requestLayout();
            invalidate();
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{AYUAbz.AYUAbz(getContext(), 2130968881, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f11707AlLFFp.f4937B25kr6 = iArr;
        OdANhw.A2egSU a2egSU = this.f11706AcNBzu.f6629B25kr6;
        a2egSU.f6618A2egSU = 1;
        a2egSU.A2egSU(0.0f);
        a2egSU.f6624AYUAbz.f4938A2egSU = ((int[]) a2egSU.f6622ARc23Z.f4937B25kr6)[0];
        invalidate();
    }

    public void setIndicatorSize(int i) {
        AMqCpz aMqCpz = this.f11707AlLFFp;
        if (aMqCpz.f4933AcNBzu != i) {
            aMqCpz.f4933AcNBzu = i;
            requestLayout();
            invalidate();
        }
    }
}
