package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD implements DAk1zC {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f9277A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9278A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int[] f9279A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9280ADYaiT;

    public final void A2egSU(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i3 = this.f9280ADYaiT;
        int i4 = i3 * 2;
        int[] iArr = this.f9279A5SV6n;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f9279A5SV6n = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int[] iArr3 = new int[i3 * 4];
            this.f9279A5SV6n = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f9279A5SV6n;
        iArr4[i4] = i;
        iArr4[i4 + 1] = i2;
        this.f9280ADYaiT++;
    }

    public final void A4TApA(RecyclerView recyclerView, boolean z) {
        this.f9280ADYaiT = 0;
        int[] iArr = this.f9279A5SV6n;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        RecyclerView.ARc23Z aRc23Z = recyclerView.mLayout;
        if (recyclerView.mAdapter == null || aRc23Z == null || !aRc23Z.isItemPrefetchEnabled()) {
            return;
        }
        if (z) {
            if (!recyclerView.mAdapterHelper.ASJ6gh()) {
                aRc23Z.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
            }
        } else if (!recyclerView.hasPendingAdapterUpdates()) {
            aRc23Z.collectAdjacentPrefetchPositions(this.f9277A2egSU, this.f9278A4TApA, recyclerView.mState, this);
        }
        int i = this.f9280ADYaiT;
        if (i > aRc23Z.mPrefetchMaxCountObserved) {
            aRc23Z.mPrefetchMaxCountObserved = i;
            aRc23Z.mPrefetchMaxObservedInInitialPrefetch = z;
            recyclerView.mRecycler.AzWtSf();
        }
    }
}
