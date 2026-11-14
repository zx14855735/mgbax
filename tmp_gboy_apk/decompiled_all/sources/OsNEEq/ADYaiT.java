package OsNEEq;

import OpB85q.ARc23Z;
import OpB85q.AZkASS;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends AZkASS {
    public int DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public int f6819DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public final FrameLayout.LayoutParams f6820DcUJf1;

    public ADYaiT(Context context) {
        super(context);
        this.DXuj49 = -1;
        this.f6819DaOi9o = 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f6820DcUJf1 = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    @Override // OpB85q.AZkASS
    public final ARc23Z ARc23Z(Context context) {
        return new A5SV6n(context);
    }

    public final int AYUAbz(int i, int i2, int i3, View view) {
        int makeMeasureSpec;
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 0);
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (!(childAt instanceof ARc23Z)) {
                childAt.measure(i, makeMeasureSpec2);
                int measuredHeight = childAt.getVisibility() != 8 ? childAt.getMeasuredHeight() : 0;
                i2 -= measuredHeight;
                i4 += measuredHeight;
            }
        }
        int max = Math.max(i2, 0);
        if (view == null) {
            int max2 = max / Math.max(1, i3);
            int i6 = this.DXuj49;
            if (i6 == -1) {
                i6 = View.MeasureSpec.getSize(i);
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i6, max2), 0);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = getChildAt(i8);
            if (childAt2.getVisibility() == 0) {
                i7++;
            }
            if ((childAt2 instanceof ARc23Z) && childAt2 != view) {
                childAt2.measure(i, makeMeasureSpec);
                i4 = (childAt2.getVisibility() != 8 ? childAt2.getMeasuredHeight() : 0) + i4;
            }
        }
        return (Math.max(0, i7 - 1) * this.f6819DaOi9o) + i4;
    }

    public int getItemMinimumHeight() {
        return this.DXuj49;
    }

    public int getItemSpacing() {
        return this.f6819DaOi9o;
    }

    public int getMenuGravity() {
        return this.f6820DcUJf1.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                i7 += childAt.getMeasuredHeight();
                i6++;
            }
        }
        int max = i6 <= 1 ? 0 : Math.max(0, Math.min((getMeasuredHeight() - i7) / (i6 - 1), this.f6819DaOi9o));
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8) {
                int measuredHeight = childAt2.getMeasuredHeight();
                childAt2.layout(0, i9, i5, measuredHeight + i9);
                i9 += measuredHeight + max;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int AYUAbz2;
        int i3;
        int size = View.MeasureSpec.getSize(i2);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        if (currentVisibleContentItemCount <= 1 || !AZkASS.ASJ6gh(getLabelVisibilityMode(), currentVisibleContentItemCount)) {
            AYUAbz2 = AYUAbz(i, size, currentVisibleContentItemCount, null);
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            if (childAt != null) {
                int max = size / Math.max(1, currentVisibleContentItemCount);
                int i4 = this.DXuj49;
                if (i4 == -1) {
                    i4 = View.MeasureSpec.getSize(i);
                }
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(Math.min(i4, max), 0));
                i3 = childAt.getVisibility() != 8 ? childAt.getMeasuredHeight() : 0;
                size -= i3;
                currentVisibleContentItemCount--;
            } else {
                i3 = 0;
            }
            AYUAbz2 = AYUAbz(i, size, currentVisibleContentItemCount, childAt) + i3;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.resolveSizeAndState(AYUAbz2, i2, 0));
    }

    public void setItemMinimumHeight(int i) {
        if (this.DXuj49 != i) {
            this.DXuj49 = i;
            requestLayout();
        }
    }

    public void setItemSpacing(int i) {
        if (this.f6819DaOi9o != i) {
            this.f6819DaOi9o = i;
            requestLayout();
        }
    }

    public void setMenuGravity(int i) {
        FrameLayout.LayoutParams layoutParams = this.f6820DcUJf1;
        if (layoutParams.gravity != i) {
            layoutParams.gravity = i;
            setLayoutParams(layoutParams);
        }
    }
}
