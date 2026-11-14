package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DXnQ0V {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f9351A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ArrayList f9352A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f9353A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final List f9354ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f9355ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public RecyclerView.AZOQYO f9356ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public RecyclerView.AcNBzu f9357AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f9358AZOQYO;

    public DXnQ0V(RecyclerView recyclerView) {
        this.f9358AZOQYO = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f9351A2egSU = arrayList;
        this.f9352A4TApA = null;
        this.f9353A5SV6n = new ArrayList();
        this.f9354ADYaiT = Collections.unmodifiableList(arrayList);
        this.AMqCpz = 2;
        this.f9355ARc23Z = 2;
    }

    public static void AMqCpz(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                AMqCpz((ViewGroup) childAt, true);
            }
        }
        if (z) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
    }

    public final void A2egSU(Dphsd2 dphsd2, boolean z) {
        RecyclerView.clearNestedRecyclerViewIfNotNested(dphsd2);
        View view = dphsd2.itemView;
        RecyclerView recyclerView = this.f9358AZOQYO;
        DvK7DB dvK7DB = recyclerView.mAccessibilityDelegate;
        if (dvK7DB != null) {
            COJEAR.A4TApA AZkASS2 = dvK7DB.AZkASS();
            COJEAR.DG07BK.B4ZgIw(view, AZkASS2 instanceof DuwtYk ? (COJEAR.A4TApA) ((DuwtYk) AZkASS2).AMqCpz.remove(view) : null);
        }
        if (z) {
            if (recyclerView.mRecyclerListeners.size() > 0) {
                recyclerView.mRecyclerListeners.get(0).getClass();
                throw new ClassCastException();
            }
            RecyclerView.A2egSU a2egSU = recyclerView.mAdapter;
            if (a2egSU != null) {
                a2egSU.onViewRecycled(dphsd2);
            }
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.ADYaiT(dphsd2);
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Objects.toString(dphsd2);
            }
        }
        dphsd2.mBindingAdapter = null;
        dphsd2.mOwnerRecyclerView = null;
        RecyclerView.AZOQYO A5SV6n2 = A5SV6n();
        A5SV6n2.getClass();
        int itemViewType = dphsd2.getItemViewType();
        ArrayList arrayList = A5SV6n2.A2egSU(itemViewType).f9347A2egSU;
        if (((DV2E8K) A5SV6n2.f9437A2egSU.get(itemViewType)).f9348A4TApA <= arrayList.size()) {
            NOd7IU.AlLFFp.B7CMnp(dphsd2.itemView);
        } else {
            if (RecyclerView.sDebugAssertionsEnabled && arrayList.contains(dphsd2)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            dphsd2.resetInternal();
            arrayList.add(dphsd2);
        }
    }

    public final int A4TApA(int i) {
        RecyclerView recyclerView = this.f9358AZOQYO;
        if (i >= 0 && i < recyclerView.mState.A4TApA()) {
            return !recyclerView.mState.f9445ASJ6gh ? i : recyclerView.mAdapterHelper.ARc23Z(i, 0);
        }
        StringBuilder B9tovu2 = J3FDQU.A2egSU.B9tovu(i, "invalid position ", ". State item count is ");
        B9tovu2.append(recyclerView.mState.A4TApA());
        B9tovu2.append(recyclerView.exceptionLabel());
        throw new IndexOutOfBoundsException(B9tovu2.toString());
    }

    public final RecyclerView.AZOQYO A5SV6n() {
        if (this.f9356ASJ6gh == null) {
            this.f9356ASJ6gh = new RecyclerView.AZOQYO();
            ARc23Z();
        }
        return this.f9356ASJ6gh;
    }

    public final View ADYaiT(int i) {
        return AlLFFp(i, Long.MAX_VALUE).itemView;
    }

    public final void ARc23Z() {
        if (this.f9356ASJ6gh != null) {
            RecyclerView recyclerView = this.f9358AZOQYO;
            if (recyclerView.mAdapter == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            RecyclerView.AZOQYO azoqyo = this.f9356ASJ6gh;
            azoqyo.f9439A5SV6n.add(recyclerView.mAdapter);
        }
    }

    public final void ASJ6gh(RecyclerView.A2egSU a2egSU, boolean z) {
        RecyclerView.AZOQYO azoqyo = this.f9356ASJ6gh;
        if (azoqyo == null) {
            return;
        }
        Set set = azoqyo.f9439A5SV6n;
        set.remove(a2egSU);
        if (set.size() != 0 || z) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = azoqyo.f9437A2egSU;
            if (i >= sparseArray.size()) {
                return;
            }
            ArrayList arrayList = ((DV2E8K) sparseArray.get(sparseArray.keyAt(i))).f9347A2egSU;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                NOd7IU.AlLFFp.B7CMnp(((Dphsd2) arrayList.get(i2)).itemView);
            }
            i++;
        }
    }

    public final void AYUAbz() {
        ArrayList arrayList = this.f9353A5SV6n;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AZOQYO(size);
        }
        arrayList.clear();
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            BNL6CD bnl6cd = this.f9358AZOQYO.mPrefetchRegistry;
            int[] iArr = bnl6cd.f9279A5SV6n;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            bnl6cd.f9280ADYaiT = 0;
        }
    }

    public final void AZOQYO(int i) {
        int i2 = RecyclerView.HORIZONTAL;
        ArrayList arrayList = this.f9353A5SV6n;
        Dphsd2 dphsd2 = (Dphsd2) arrayList.get(i);
        if (RecyclerView.sVerboseLoggingEnabled) {
            Objects.toString(dphsd2);
        }
        A2egSU(dphsd2, true);
        arrayList.remove(i);
    }

    public final void AZkASS(View view) {
        Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean isTmpDetached = childViewHolderInt.isTmpDetached();
        RecyclerView recyclerView = this.f9358AZOQYO;
        if (isTmpDetached) {
            recyclerView.removeDetachedView(view, false);
        }
        if (childViewHolderInt.isScrap()) {
            childViewHolderInt.unScrap();
        } else if (childViewHolderInt.wasReturnedFromScrap()) {
            childViewHolderInt.clearReturnedFromScrapFlag();
        }
        AaHO0E(childViewHolderInt);
        if (recyclerView.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
            return;
        }
        recyclerView.mItemAnimator.AZOQYO(childViewHolderInt);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c0, code lost:
    
        r4 = r4 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AaHO0E(androidx.recyclerview.widget.Dphsd2 r12) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DXnQ0V.AaHO0E(androidx.recyclerview.widget.Dphsd2):void");
    }

    public final void AcNBzu(View view) {
        Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean hasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(12);
        RecyclerView recyclerView = this.f9358AZOQYO;
        if (!hasAnyOfTheFlags && childViewHolderInt.isUpdated() && !recyclerView.canReuseUpdatedViewHolder(childViewHolderInt)) {
            if (this.f9352A4TApA == null) {
                this.f9352A4TApA = new ArrayList();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.f9352A4TApA.add(childViewHolderInt);
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !recyclerView.mAdapter.hasStableIds()) {
            throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        childViewHolderInt.setScrapContainer(this, false);
        this.f9351A2egSU.add(childViewHolderInt);
    }

    /* JADX WARN: Code restructure failed: missing block: B:199:0x04ab, code lost:
    
        if ((r11 + r8) >= r31) goto L249;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0571 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.Dphsd2 AlLFFp(int r30, long r31) {
        /*
            Method dump skipped, instructions count: 1436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DXnQ0V.AlLFFp(int, long):androidx.recyclerview.widget.Dphsd2");
    }

    public final void AmA8tU(Dphsd2 dphsd2) {
        if (dphsd2.mInChangeScrap) {
            this.f9352A4TApA.remove(dphsd2);
        } else {
            this.f9351A2egSU.remove(dphsd2);
        }
        dphsd2.mScrapContainer = null;
        dphsd2.mInChangeScrap = false;
        dphsd2.clearReturnedFromScrapFlag();
    }

    public final void AzWtSf() {
        RecyclerView.ARc23Z aRc23Z = this.f9358AZOQYO.mLayout;
        this.f9355ARc23Z = this.AMqCpz + (aRc23Z != null ? aRc23Z.mPrefetchMaxCountObserved : 0);
        ArrayList arrayList = this.f9353A5SV6n;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f9355ARc23Z; size--) {
            AZOQYO(size);
        }
    }
}
