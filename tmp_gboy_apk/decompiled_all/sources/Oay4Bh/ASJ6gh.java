package Oay4Bh;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class ASJ6gh extends ViewGroup {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6523AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f6524AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f6525AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f6526AzWtSf;

    public int getItemSpacing() {
        return this.f6524AlLFFp;
    }

    public int getLineSpacing() {
        return this.f6523AcNBzu;
    }

    public int getRowCount() {
        return this.f6526AzWtSf;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            this.f6526AzWtSf = 0;
            return;
        }
        this.f6526AzWtSf = 1;
        boolean z2 = getLayoutDirection() == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i7 = paddingRight;
        int i8 = paddingTop;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(2131297842, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = marginLayoutParams.getMarginStart();
                    i5 = marginLayoutParams.getMarginEnd();
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i7 + i6;
                int i10 = i3 - i;
                int i11 = i10 - paddingLeft;
                if (!this.f6525AmA8tU && measuredWidth > i11) {
                    measuredWidth = childAt.getMeasuredWidth() + paddingRight + i6;
                    i8 = paddingTop + this.f6523AcNBzu;
                    this.f6526AzWtSf++;
                    i7 = paddingRight;
                }
                childAt.setTag(2131297842, Integer.valueOf(this.f6526AzWtSf - 1));
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (z2) {
                    childAt.layout(i10 - measuredWidth, i8, (i10 - i7) - i6, measuredHeight);
                } else {
                    childAt.layout(i7 + i6, i8, measuredWidth, measuredHeight);
                }
                i7 += childAt.getMeasuredWidth() + i6 + i5 + this.f6524AlLFFp;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i7 = paddingTop;
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin;
                    i4 = marginLayoutParams.rightMargin;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                int i10 = i4;
                if (childAt.getMeasuredWidth() + paddingLeft + i5 > paddingRight && !((ChipGroup) this).f6525AmA8tU) {
                    paddingLeft = getPaddingLeft();
                    i7 = paddingTop + this.f6523AcNBzu;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i5;
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                if (measuredWidth > i8) {
                    i8 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i5 + i10 + this.f6524AlLFFp + paddingLeft;
                if (i9 == getChildCount() - 1) {
                    i8 += i10;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i8;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode != Integer.MIN_VALUE) {
            i3 = 1073741824;
            if (mode != 1073741824) {
                size = paddingRight2;
            }
        } else {
            i3 = 1073741824;
            size = Math.min(paddingRight2, size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != i3) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i) {
        this.f6524AlLFFp = i;
    }

    public void setLineSpacing(int i) {
        this.f6523AcNBzu = i;
    }

    public void setSingleLine(boolean z) {
        this.f6525AmA8tU = z;
    }
}
