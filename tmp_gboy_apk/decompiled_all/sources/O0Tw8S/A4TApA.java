package O0Tw8S;

import OpB85q.ARc23Z;
import OpB85q.AZkASS;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends AZkASS {
    public final int DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public final int f6144DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public final int f6145DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public final int f6146DdagTj;
    public boolean Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public final ArrayList f6147De4eam;

    public A4TApA(Context context) {
        super(context);
        this.f6147De4eam = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.DXuj49 = resources.getDimensionPixelSize(2131165292);
        this.f6144DaOi9o = resources.getDimensionPixelSize(2131165293);
        this.f6145DcUJf1 = resources.getDimensionPixelSize(2131165286);
        this.f6146DdagTj = resources.getDimensionPixelSize(2131165287);
    }

    @Override // OpB85q.AZkASS
    public final ARc23Z ARc23Z(Context context) {
        return new A2egSU(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (getLayoutDirection() == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int size = View.MeasureSpec.getSize(i);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        int childCount = getChildCount();
        ArrayList arrayList = this.f6147De4eam;
        arrayList.clear();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE);
        int i7 = 0;
        if (getItemIconGravity() == 0) {
            boolean ASJ6gh2 = AZkASS.ASJ6gh(getLabelVisibilityMode(), currentVisibleContentItemCount);
            int i8 = this.f6145DcUJf1;
            if (ASJ6gh2 && this.Ddcejp) {
                View childAt = getChildAt(getSelectedItemPosition());
                int visibility = childAt.getVisibility();
                int i9 = this.f6146DdagTj;
                if (visibility != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE), makeMeasureSpec);
                    i9 = Math.max(i9, childAt.getMeasuredWidth());
                }
                int i10 = currentVisibleContentItemCount - (childAt.getVisibility() != 8 ? 1 : 0);
                int min = Math.min(size - (this.f6144DaOi9o * i10), Math.min(i9, i8));
                int i11 = size - min;
                int min2 = Math.min(i11 / (i10 != 0 ? i10 : 1), this.DXuj49);
                int i12 = i11 - (i10 * min2);
                int i13 = 0;
                while (i13 < childCount) {
                    if (getChildAt(i13).getVisibility() != 8) {
                        i6 = i13 == getSelectedItemPosition() ? min : min2;
                        if (i12 > 0) {
                            i6++;
                            i12--;
                        }
                    } else {
                        i6 = 0;
                    }
                    arrayList.add(Integer.valueOf(i6));
                    i13++;
                }
            } else {
                int min3 = Math.min(size / (currentVisibleContentItemCount != 0 ? currentVisibleContentItemCount : 1), i8);
                int i14 = size - (currentVisibleContentItemCount * min3);
                for (int i15 = 0; i15 < childCount; i15++) {
                    if (getChildAt(i15).getVisibility() == 8) {
                        i5 = 0;
                    } else if (i14 > 0) {
                        i5 = min3 + 1;
                        i14--;
                    } else {
                        i5 = min3;
                    }
                    arrayList.add(Integer.valueOf(i5));
                }
            }
            i3 = 0;
            i4 = 0;
            while (i7 < childCount) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) arrayList.get(i7)).intValue(), 1073741824), makeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    int measuredWidth = childAt2.getMeasuredWidth() + i3;
                    i4 = Math.max(i4, childAt2.getMeasuredHeight());
                    i3 = measuredWidth;
                }
                i7++;
            }
        } else {
            if (currentVisibleContentItemCount == 0) {
                currentVisibleContentItemCount = 1;
            }
            float f = size;
            float min4 = Math.min((currentVisibleContentItemCount + 3) / 10.0f, 0.9f) * f;
            float f2 = currentVisibleContentItemCount;
            int round = Math.round(min4 / f2);
            int round2 = Math.round(f / f2);
            int i16 = 0;
            int i17 = 0;
            while (i7 < childCount) {
                View childAt3 = getChildAt(i7);
                if (childAt3.getVisibility() != 8) {
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(round2, Integer.MIN_VALUE), makeMeasureSpec);
                    if (childAt3.getMeasuredWidth() < round) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(round, 1073741824), makeMeasureSpec);
                    }
                    int measuredWidth2 = childAt3.getMeasuredWidth() + i16;
                    i17 = Math.max(i17, childAt3.getMeasuredHeight());
                    i16 = measuredWidth2;
                }
                i7++;
            }
            i3 = i16;
            i4 = i17;
        }
        setMeasuredDimension(i3, Math.max(i4, getSuggestedMinimumHeight()));
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.Ddcejp = z;
    }
}
