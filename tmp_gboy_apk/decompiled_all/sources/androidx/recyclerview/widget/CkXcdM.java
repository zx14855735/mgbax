package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CkXcdM extends EPdU4G {

    /* renamed from: A2egSU, reason: collision with root package name */
    public CcAIMM f9329A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public CTkVKb f9330A4TApA;

    public static int A2egSU(View view, Cd8JRx cd8JRx) {
        return ((cd8JRx.A5SV6n(view) / 2) + cd8JRx.AMqCpz(view)) - ((cd8JRx.AcNBzu() / 2) + cd8JRx.AaHO0E());
    }

    public static View A4TApA(RecyclerView.ARc23Z aRc23Z, Cd8JRx cd8JRx) {
        int childCount = aRc23Z.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int AcNBzu2 = (cd8JRx.AcNBzu() / 2) + cd8JRx.AaHO0E();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = aRc23Z.getChildAt(i2);
            int abs = Math.abs(((cd8JRx.A5SV6n(childAt) / 2) + cd8JRx.AMqCpz(childAt)) - AcNBzu2);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    public final Cd8JRx A5SV6n(RecyclerView.ARc23Z aRc23Z) {
        CTkVKb cTkVKb = this.f9330A4TApA;
        if (cTkVKb == null || cTkVKb.f9325A2egSU != aRc23Z) {
            this.f9330A4TApA = new CTkVKb(aRc23Z);
        }
        return this.f9330A4TApA;
    }

    public final Cd8JRx ADYaiT(RecyclerView.ARc23Z aRc23Z) {
        CcAIMM ccAIMM = this.f9329A2egSU;
        if (ccAIMM == null || ccAIMM.f9325A2egSU != aRc23Z) {
            this.f9329A2egSU = new CcAIMM(aRc23Z);
        }
        return this.f9329A2egSU;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public final int[] calculateDistanceToFinalSnap(RecyclerView.ARc23Z aRc23Z, View view) {
        int[] iArr = new int[2];
        if (aRc23Z.canScrollHorizontally()) {
            iArr[0] = A2egSU(view, A5SV6n(aRc23Z));
        } else {
            iArr[0] = 0;
        }
        if (aRc23Z.canScrollVertically()) {
            iArr[1] = A2egSU(view, ADYaiT(aRc23Z));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public final RecyclerView.AZkASS createScroller(RecyclerView.ARc23Z aRc23Z) {
        if (aRc23Z instanceof Ddcejp) {
            return new CikNvS(this, this.mRecyclerView.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.EPdU4G
    public View findSnapView(RecyclerView.ARc23Z aRc23Z) {
        if (aRc23Z.canScrollVertically()) {
            return A4TApA(aRc23Z, ADYaiT(aRc23Z));
        }
        if (aRc23Z.canScrollHorizontally()) {
            return A4TApA(aRc23Z, A5SV6n(aRc23Z));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.EPdU4G
    public final int findTargetSnapPosition(RecyclerView.ARc23Z aRc23Z, int i, int i2) {
        PointF computeScrollVectorForPosition;
        int itemCount = aRc23Z.getItemCount();
        if (itemCount != 0) {
            View view = null;
            Cd8JRx ADYaiT2 = aRc23Z.canScrollVertically() ? ADYaiT(aRc23Z) : aRc23Z.canScrollHorizontally() ? A5SV6n(aRc23Z) : null;
            if (ADYaiT2 != null) {
                int childCount = aRc23Z.getChildCount();
                boolean z = false;
                View view2 = null;
                int i3 = Integer.MIN_VALUE;
                int i4 = Integer.MAX_VALUE;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = aRc23Z.getChildAt(i5);
                    if (childAt != null) {
                        int A2egSU2 = A2egSU(childAt, ADYaiT2);
                        if (A2egSU2 <= 0 && A2egSU2 > i3) {
                            view2 = childAt;
                            i3 = A2egSU2;
                        }
                        if (A2egSU2 >= 0 && A2egSU2 < i4) {
                            view = childAt;
                            i4 = A2egSU2;
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
        }
        return -1;
    }
}
