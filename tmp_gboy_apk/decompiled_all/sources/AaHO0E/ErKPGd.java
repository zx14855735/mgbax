package AaHO0E;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import com.qq.e.comm.adevent.AdEventType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ErKPGd extends ViewGroup {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f794AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f795AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f796AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f797AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f798B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f799B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public float f800B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f801B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int[] f802B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int[] f803B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public Drawable f804BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f805BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f806BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f807BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f808BNL6CD;

    public ErKPGd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f794AcNBzu = true;
        this.f795AlLFFp = -1;
        this.f796AmA8tU = 0;
        this.f798B25kr6 = 8388659;
        int[] iArr = R$styleable.f8027AzWtSf;
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(context, attributeSet, iArr, 0);
        COJEAR.DG07BK.B3GDIM(this, context, iArr, attributeSet, ARc23Z2.f884A4TApA, 0);
        TypedArray typedArray = ARc23Z2.f884A4TApA;
        int i = typedArray.getInt(1, -1);
        if (i >= 0) {
            setOrientation(i);
        }
        int i2 = typedArray.getInt(0, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f800B3GDIM = typedArray.getFloat(4, -1.0f);
        this.f795AlLFFp = typedArray.getInt(3, -1);
        this.f801B4ZgIw = typedArray.getBoolean(7, false);
        setDividerDrawable(ARc23Z2.A4TApA(5));
        this.f807BJ7GGh = typedArray.getInt(8, 0);
        this.f808BNL6CD = typedArray.getDimensionPixelSize(6, 0);
        ARc23Z2.ASJ6gh();
    }

    public final void ADYaiT(Canvas canvas, int i) {
        this.f804BChYOn.setBounds(getPaddingLeft() + this.f808BNL6CD, i, (getWidth() - getPaddingRight()) - this.f808BNL6CD, this.f806BIYEnU + i);
        this.f804BChYOn.draw(canvas);
    }

    public final void AMqCpz(Canvas canvas, int i) {
        this.f804BChYOn.setBounds(i, getPaddingTop() + this.f808BNL6CD, this.f805BI9f7h + i, (getHeight() - getPaddingBottom()) - this.f808BNL6CD);
        this.f804BChYOn.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: ARc23Z, reason: merged with bridge method [inline-methods] */
    public EmJGcg generateDefaultLayoutParams() {
        int i = this.f797AzWtSf;
        if (i == 0) {
            return new EmJGcg(-2, -2);
        }
        if (i == 1) {
            return new EmJGcg(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: ASJ6gh, reason: merged with bridge method [inline-methods] */
    public EmJGcg generateLayoutParams(AttributeSet attributeSet) {
        return new EmJGcg(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: AYUAbz, reason: merged with bridge method [inline-methods] */
    public EmJGcg generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof EmJGcg ? new EmJGcg((EmJGcg) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new EmJGcg((ViewGroup.MarginLayoutParams) layoutParams) : new EmJGcg(layoutParams);
    }

    public final boolean AZOQYO(int i) {
        if (i == 0) {
            return (this.f807BJ7GGh & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f807BJ7GGh & 4) != 0;
        }
        if ((this.f807BJ7GGh & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof EmJGcg;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f795AlLFFp < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f795AlLFFp;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f795AlLFFp == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i3 = this.f796AmA8tU;
        if (this.f797AzWtSf == 1 && (i = this.f798B25kr6 & AdEventType.AD_TICK) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f799B2KMhB) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f799B2KMhB;
            }
        }
        return i3 + ((LinearLayout.LayoutParams) ((EmJGcg) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f795AlLFFp;
    }

    public Drawable getDividerDrawable() {
        return this.f804BChYOn;
    }

    public int getDividerPadding() {
        return this.f808BNL6CD;
    }

    public int getDividerWidth() {
        return this.f805BI9f7h;
    }

    public int getGravity() {
        return this.f798B25kr6;
    }

    public int getOrientation() {
        return this.f797AzWtSf;
    }

    public int getShowDividers() {
        return this.f807BJ7GGh;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f800B3GDIM;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.f804BChYOn == null) {
            return;
        }
        int i2 = 0;
        if (this.f797AzWtSf == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i2 < virtualChildCount) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8 && AZOQYO(i2)) {
                    ADYaiT(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((EmJGcg) childAt.getLayoutParams())).topMargin) - this.f806BIYEnU);
                }
                i2++;
            }
            if (AZOQYO(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                ADYaiT(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f806BIYEnU : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((EmJGcg) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z = HSHyT0.f933A2egSU;
        boolean z2 = getLayoutDirection() == 1;
        while (i2 < virtualChildCount2) {
            View childAt3 = getChildAt(i2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && AZOQYO(i2)) {
                EmJGcg emJGcg = (EmJGcg) childAt3.getLayoutParams();
                AMqCpz(canvas, z2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) emJGcg).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) emJGcg).leftMargin) - this.f805BI9f7h);
            }
            i2++;
        }
        if (AZOQYO(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                EmJGcg emJGcg2 = (EmJGcg) childAt4.getLayoutParams();
                if (z2) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) emJGcg2).leftMargin;
                    i = this.f805BI9f7h;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) emJGcg2).rightMargin;
                }
            } else if (z2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.f805BI9f7h;
                right = left - i;
            }
            AMqCpz(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.ErKPGd.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0145  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2143
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.ErKPGd.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.f794AcNBzu = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f795AlLFFp = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f804BChYOn) {
            return;
        }
        this.f804BChYOn = drawable;
        if (drawable != null) {
            this.f805BI9f7h = drawable.getIntrinsicWidth();
            this.f806BIYEnU = drawable.getIntrinsicHeight();
        } else {
            this.f805BI9f7h = 0;
            this.f806BIYEnU = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f808BNL6CD = i;
    }

    public void setGravity(int i) {
        if (this.f798B25kr6 != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & AdEventType.AD_TICK) == 0) {
                i |= 48;
            }
            this.f798B25kr6 = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.f798B25kr6;
        if ((8388615 & i3) != i2) {
            this.f798B25kr6 = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f801B4ZgIw = z;
    }

    public void setOrientation(int i) {
        if (this.f797AzWtSf != i) {
            this.f797AzWtSf = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f807BJ7GGh) {
            requestLayout();
        }
        this.f807BJ7GGh = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & AdEventType.AD_TICK;
        int i3 = this.f798B25kr6;
        if ((i3 & AdEventType.AD_TICK) != i2) {
            this.f798B25kr6 = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f800B3GDIM = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
