package com.google.android.material.divider;

import BPw6Q8.ASJ6gh;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PXXBzr.A2egSU;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialDivider extends View {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f11662AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f11663AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f11664AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f11665AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f11666B25kr6;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130969562, 2131952887), attributeSet, 2130969562);
        Context context2 = getContext();
        this.f11662AcNBzu = new AaHO0E();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11239BV3sI0, 2130969562, 2131952887, new int[0]);
        this.f11663AlLFFp = AmA8tU2.getDimensionPixelSize(3, getResources().getDimensionPixelSize(2131166246));
        this.f11665AzWtSf = AmA8tU2.getDimensionPixelOffset(2, 0);
        this.f11666B25kr6 = AmA8tU2.getDimensionPixelOffset(1, 0);
        setDividerColor(AMqCpz.BPw6Q8(context2, AmA8tU2, 0).getDefaultColor());
        AmA8tU2.recycle();
    }

    public int getDividerColor() {
        return this.f11664AmA8tU;
    }

    public int getDividerInsetEnd() {
        return this.f11666B25kr6;
    }

    public int getDividerInsetStart() {
        return this.f11665AzWtSf;
    }

    public int getDividerThickness() {
        return this.f11663AlLFFp;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i;
        super.onDraw(canvas);
        boolean z = getLayoutDirection() == 1;
        int i2 = z ? this.f11666B25kr6 : this.f11665AzWtSf;
        if (z) {
            width = getWidth();
            i = this.f11665AzWtSf;
        } else {
            width = getWidth();
            i = this.f11666B25kr6;
        }
        int i3 = width - i;
        AaHO0E aaHO0E = this.f11662AcNBzu;
        aaHO0E.setBounds(i2, 0, i3, getBottom() - getTop());
        aaHO0E.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.f11663AlLFFp;
            if (i3 > 0 && measuredHeight != i3) {
                measuredHeight = i3;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i) {
        if (this.f11664AmA8tU != i) {
            this.f11664AmA8tU = i;
            this.f11662AcNBzu.B3GDIM(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    public void setDividerColorResource(int i) {
        setDividerColor(ASJ6gh.A4TApA(getContext(), i));
    }

    public void setDividerInsetEnd(int i) {
        this.f11666B25kr6 = i;
    }

    public void setDividerInsetEndResource(int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerInsetStart(int i) {
        this.f11665AzWtSf = i;
    }

    public void setDividerInsetStartResource(int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerThickness(int i) {
        if (this.f11663AlLFFp != i) {
            this.f11663AlLFFp = i;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }
}
