package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final CSDoyG f9176A2egSU;
    public View AMqCpz;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9179ADYaiT = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AMqCpz f9177A4TApA = new AMqCpz();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f9178A5SV6n = new ArrayList();

    public ARc23Z(CSDoyG cSDoyG) {
        this.f9176A2egSU = cSDoyG;
    }

    public final void A2egSU(View view, int i, boolean z) {
        RecyclerView recyclerView = (RecyclerView) this.f9176A2egSU.f9324A2egSU;
        int childCount = i < 0 ? recyclerView.getChildCount() : ARc23Z(i);
        this.f9177A4TApA.insert(childCount, z);
        if (z) {
            AZOQYO(view);
        }
        recyclerView.addView(view, childCount);
        recyclerView.dispatchChildAttached(view);
    }

    public final void A4TApA(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = (RecyclerView) this.f9176A2egSU.f9324A2egSU;
        int childCount = i < 0 ? recyclerView.getChildCount() : ARc23Z(i);
        this.f9177A4TApA.insert(childCount, z);
        if (z) {
            AZOQYO(view);
        }
        Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(recyclerView, sb));
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                childViewHolderInt.toString();
            }
            childViewHolderInt.clearTmpDetachFlag();
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public final void A5SV6n(int i) {
        int ARc23Z2 = ARc23Z(i);
        this.f9177A4TApA.AMqCpz(ARc23Z2);
        RecyclerView recyclerView = (RecyclerView) this.f9176A2egSU.f9324A2egSU;
        View childAt = recyclerView.getChildAt(ARc23Z2);
        if (childAt != null) {
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(recyclerView, sb));
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    childViewHolderInt.toString();
                }
                childViewHolderInt.addFlags(256);
            }
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(ARc23Z2);
            throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(ARc23Z2);
    }

    public final View ADYaiT(int i) {
        return ((RecyclerView) this.f9176A2egSU.f9324A2egSU).getChildAt(ARc23Z(i));
    }

    public final int AMqCpz() {
        return ((RecyclerView) this.f9176A2egSU.f9324A2egSU).getChildCount() - this.f9178A5SV6n.size();
    }

    public final int ARc23Z(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = ((RecyclerView) this.f9176A2egSU.f9324A2egSU).getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            AMqCpz aMqCpz = this.f9177A4TApA;
            int A4TApA2 = i - (i2 - aMqCpz.A4TApA(i2));
            if (A4TApA2 == 0) {
                while (aMqCpz.ADYaiT(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += A4TApA2;
        }
        return -1;
    }

    public final View ASJ6gh(int i) {
        return ((RecyclerView) this.f9176A2egSU.f9324A2egSU).getChildAt(i);
    }

    public final int AYUAbz() {
        return ((RecyclerView) this.f9176A2egSU.f9324A2egSU).getChildCount();
    }

    public final void AZOQYO(View view) {
        this.f9178A5SV6n.add(view);
        CSDoyG cSDoyG = this.f9176A2egSU;
        Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState((RecyclerView) cSDoyG.f9324A2egSU);
        }
    }

    public final int AZkASS(View view) {
        int indexOfChild = ((RecyclerView) this.f9176A2egSU.f9324A2egSU).indexOfChild(view);
        if (indexOfChild == -1) {
            return -1;
        }
        AMqCpz aMqCpz = this.f9177A4TApA;
        if (aMqCpz.ADYaiT(indexOfChild)) {
            return -1;
        }
        return indexOfChild - aMqCpz.A4TApA(indexOfChild);
    }

    public final void AaHO0E(int i) {
        CSDoyG cSDoyG = this.f9176A2egSU;
        int i2 = this.f9179ADYaiT;
        if (i2 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i2 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            int ARc23Z2 = ARc23Z(i);
            View childAt = ((RecyclerView) cSDoyG.f9324A2egSU).getChildAt(ARc23Z2);
            if (childAt != null) {
                this.f9179ADYaiT = 1;
                this.AMqCpz = childAt;
                if (this.f9177A4TApA.AMqCpz(ARc23Z2)) {
                    AcNBzu(childAt);
                }
                cSDoyG.A2egSU(ARc23Z2);
            }
            this.f9179ADYaiT = 0;
            this.AMqCpz = null;
        } catch (Throwable th) {
            this.f9179ADYaiT = 0;
            this.AMqCpz = null;
            throw th;
        }
    }

    public final void AcNBzu(View view) {
        if (this.f9178A5SV6n.remove(view)) {
            CSDoyG cSDoyG = this.f9176A2egSU;
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState((RecyclerView) cSDoyG.f9324A2egSU);
            }
        }
    }

    public final String toString() {
        return this.f9177A4TApA.toString() + ", hidden list:" + this.f9178A5SV6n.size();
    }
}
