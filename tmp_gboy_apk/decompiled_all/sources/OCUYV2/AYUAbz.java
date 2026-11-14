package OCUYV2;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.Ddcejp;
import androidx.recyclerview.widget.EPdU4G;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AYUAbz extends EPdU4G {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final boolean f6236A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public RecyclerView f6237A4TApA;

    public AYUAbz() {
        this(true);
    }

    public static int[] A2egSU(RecyclerView.ARc23Z aRc23Z, View view, boolean z) {
        if (!(aRc23Z instanceof CarouselLayoutManager)) {
            return new int[]{0, 0};
        }
        CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) aRc23Z;
        int AlLFFp2 = carouselLayoutManager.AlLFFp(carouselLayoutManager.getPosition(view), z);
        return ((CarouselLayoutManager) aRc23Z).B2KMhB() ? new int[]{AlLFFp2, 0} : aRc23Z.canScrollVertically() ? new int[]{0, AlLFFp2} : new int[]{0, 0};
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public final void attachToRecyclerView(RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        this.f6237A4TApA = recyclerView;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public final int[] calculateDistanceToFinalSnap(RecyclerView.ARc23Z aRc23Z, View view) {
        return A2egSU(aRc23Z, view, false);
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public final RecyclerView.AZkASS createScroller(RecyclerView.ARc23Z aRc23Z) {
        if (aRc23Z instanceof Ddcejp) {
            return new ASJ6gh(this, this.f6237A4TApA.getContext(), aRc23Z);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public final View findSnapView(RecyclerView.ARc23Z aRc23Z) {
        int childCount = aRc23Z.getChildCount();
        View view = null;
        if (childCount != 0 && (aRc23Z instanceof CarouselLayoutManager)) {
            CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) aRc23Z;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = aRc23Z.getChildAt(i2);
                int abs = Math.abs(carouselLayoutManager.AlLFFp(aRc23Z.getPosition(childAt), false));
                if (abs < i) {
                    view = childAt;
                    i = abs;
                }
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.EPdU4G
    public final int findTargetSnapPosition(RecyclerView.ARc23Z aRc23Z, int i, int i2) {
        int itemCount;
        PointF computeScrollVectorForPosition;
        if (this.f6236A2egSU && (itemCount = aRc23Z.getItemCount()) != 0) {
            int childCount = aRc23Z.getChildCount();
            View view = null;
            boolean z = false;
            View view2 = null;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = aRc23Z.getChildAt(i5);
                if (childAt != null) {
                    CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) aRc23Z;
                    int AlLFFp2 = carouselLayoutManager.AlLFFp(carouselLayoutManager.getPosition(childAt), false);
                    if (AlLFFp2 <= 0 && AlLFFp2 > i3) {
                        view2 = childAt;
                        i3 = AlLFFp2;
                    }
                    if (AlLFFp2 >= 0 && AlLFFp2 < i4) {
                        view = childAt;
                        i4 = AlLFFp2;
                    }
                }
            }
            boolean z2 = !aRc23Z.canScrollHorizontally() ? i2 <= 0 : i <= 0;
            if (z2 && view != null) {
                return aRc23Z.getPosition(view);
            }
            if (!z2 && view2 != null) {
                return aRc23Z.getPosition(view2);
            }
            if (z2) {
                view = view2;
            }
            if (view != null) {
                int position = aRc23Z.getPosition(view);
                int itemCount2 = aRc23Z.getItemCount();
                if ((aRc23Z instanceof Ddcejp) && (computeScrollVectorForPosition = ((Ddcejp) aRc23Z).computeScrollVectorForPosition(itemCount2 - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
                    z = true;
                }
                int i6 = position + (z == z2 ? -1 : 1);
                if (i6 >= 0 && i6 < itemCount) {
                    return i6;
                }
            }
        }
        return -1;
    }

    public AYUAbz(boolean z) {
        this.f6236A2egSU = z;
    }
}
