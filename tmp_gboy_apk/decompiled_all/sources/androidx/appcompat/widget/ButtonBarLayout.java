package androidx.appcompat.widget;

import COJEAR.DG07BK;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import com.sigmob.sdk.base.blurkit.d;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f8161AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f8162AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f8163AmA8tU;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8163AmA8tU = -1;
        int[] iArr = R$styleable.f8023AaHO0E;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        DG07BK.B3GDIM(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        this.f8161AcNBzu = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f8161AcNBzu);
        }
    }

    private void setStacked(boolean z) {
        if (this.f8162AlLFFp != z) {
            if (!z || this.f8161AcNBzu) {
                this.f8162AlLFFp = z;
                setOrientation(z ? 1 : 0);
                setGravity(z ? 8388613 : 80);
                View findViewById = findViewById(2131298001);
                if (findViewById != null) {
                    findViewById.setVisibility(z ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int i5 = 0;
        if (this.f8161AcNBzu) {
            if (size > this.f8163AmA8tU && this.f8162AlLFFp) {
                setStacked(false);
            }
            this.f8163AmA8tU = size;
        }
        if (this.f8162AlLFFp || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f8161AcNBzu && !this.f8162AlLFFp && (getMeasuredWidthAndState() & d.f13043a) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            i4 = -1;
            if (i6 >= childCount) {
                i6 = -1;
                break;
            } else if (getChildAt(i6).getVisibility() == 0) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            View childAt = getChildAt(i6);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f8162AlLFFp) {
                int i7 = i6 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i7 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i7).getVisibility() == 0) {
                        i4 = i7;
                        break;
                    }
                    i7++;
                }
                i5 = i4 >= 0 ? getChildAt(i4).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                i5 = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (getMinimumHeight() != i5) {
            setMinimumHeight(i5);
            if (i2 == 0) {
                super.onMeasure(i, i2);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f8161AcNBzu != z) {
            this.f8161AcNBzu = z;
            if (!z && this.f8162AlLFFp) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
