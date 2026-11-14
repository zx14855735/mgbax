package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DaOi9o extends RecyclerView.A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f9359A2egSU;

    public DaOi9o(RecyclerView recyclerView) {
        this.f9359A2egSU = recyclerView;
    }

    public final void A2egSU() {
        boolean z = RecyclerView.POST_UPDATES_ON_ANIMATION;
        RecyclerView recyclerView = this.f9359A2egSU;
        if (!z || !recyclerView.mHasFixedSize || !recyclerView.mIsAttached) {
            recyclerView.mAdapterUpdateDuringMeasure = true;
            recyclerView.requestLayout();
        } else {
            Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            recyclerView.postOnAnimation(runnable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onChanged() {
        RecyclerView recyclerView = this.f9359A2egSU;
        recyclerView.assertNotInLayoutOrScroll(null);
        recyclerView.mState.f9444ARc23Z = true;
        recyclerView.processDataSetCompletelyChanged(true);
        if (recyclerView.mAdapterHelper.ASJ6gh()) {
            return;
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeChanged(int i, int i2, Object obj) {
        RecyclerView recyclerView = this.f9359A2egSU;
        recyclerView.assertNotInLayoutOrScroll(null);
        A4TApA a4TApA = recyclerView.mAdapterHelper;
        if (i2 < 1) {
            a4TApA.getClass();
            return;
        }
        ArrayList arrayList = a4TApA.f9165A4TApA;
        arrayList.add(a4TApA.AYUAbz(4, i, i2, obj));
        a4TApA.f9168ARc23Z |= 4;
        if (arrayList.size() == 1) {
            A2egSU();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeInserted(int i, int i2) {
        RecyclerView recyclerView = this.f9359A2egSU;
        recyclerView.assertNotInLayoutOrScroll(null);
        A4TApA a4TApA = recyclerView.mAdapterHelper;
        if (i2 < 1) {
            a4TApA.getClass();
            return;
        }
        ArrayList arrayList = a4TApA.f9165A4TApA;
        arrayList.add(a4TApA.AYUAbz(1, i, i2, null));
        a4TApA.f9168ARc23Z |= 1;
        if (arrayList.size() == 1) {
            A2egSU();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeMoved(int i, int i2, int i3) {
        RecyclerView recyclerView = this.f9359A2egSU;
        recyclerView.assertNotInLayoutOrScroll(null);
        A4TApA a4TApA = recyclerView.mAdapterHelper;
        a4TApA.getClass();
        if (i == i2) {
            return;
        }
        ArrayList arrayList = a4TApA.f9165A4TApA;
        arrayList.add(a4TApA.AYUAbz(8, i, i2, null));
        a4TApA.f9168ARc23Z |= 8;
        if (arrayList.size() == 1) {
            A2egSU();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeRemoved(int i, int i2) {
        RecyclerView recyclerView = this.f9359A2egSU;
        recyclerView.assertNotInLayoutOrScroll(null);
        A4TApA a4TApA = recyclerView.mAdapterHelper;
        if (i2 < 1) {
            a4TApA.getClass();
            return;
        }
        ArrayList arrayList = a4TApA.f9165A4TApA;
        arrayList.add(a4TApA.AYUAbz(2, i, i2, null));
        a4TApA.f9168ARc23Z |= 2;
        if (arrayList.size() == 1) {
            A2egSU();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onStateRestorationPolicyChanged() {
        RecyclerView.A2egSU a2egSU;
        RecyclerView recyclerView = this.f9359A2egSU;
        if (recyclerView.mPendingSavedState == null || (a2egSU = recyclerView.mAdapter) == null || !a2egSU.canRestoreState()) {
            return;
        }
        recyclerView.requestLayout();
    }
}
