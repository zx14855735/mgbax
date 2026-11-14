package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LinearLayoutManager extends RecyclerView.ARc23Z implements Ddcejp {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final BniPrB mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final BpkvW3 mLayoutChunkResult;
    private C2rE4F mLayoutState;
    int mOrientation;
    Cd8JRx mOrientationHelper;
    A2egSU mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class A2egSU implements Parcelable {
        public static final Parcelable.Creator<A2egSU> CREATOR = new C4FrIb();

        /* renamed from: AcNBzu, reason: collision with root package name */
        public int f9423AcNBzu;

        /* renamed from: AlLFFp, reason: collision with root package name */
        public int f9424AlLFFp;

        /* renamed from: AmA8tU, reason: collision with root package name */
        public boolean f9425AmA8tU;

        static {
            VWBV();
        }

        private static /* synthetic */ void VWBV() {
            char[] charArray = "\u000b\u0007\u0005F\u000f\t\u0005\rF\n\u0007\u0011F\u001b\u0000\r\u0004\u0004F\"\u0006\u0001*\u001a\u0001\f\u000f\r".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'h');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u000b\u0004\u0001\u0006\u0001\u001c".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'h');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f9423AcNBzu);
            parcel.writeInt(this.f9424AlLFFp);
            parcel.writeInt(this.f9425AmA8tU ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new BniPrB();
        this.mLayoutChunkResult = new BpkvW3();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(false);
    }

    public final int ADYaiT(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return DyaChj.A2egSU(aaHO0E, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public final int AMqCpz(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return DyaChj.A4TApA(aaHO0E, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int ARc23Z(RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return DyaChj.A5SV6n(aaHO0E, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public final int ASJ6gh(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, boolean z) {
        int ASJ6gh2;
        int ASJ6gh3 = this.mOrientationHelper.ASJ6gh() - i;
        if (ASJ6gh3 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-ASJ6gh3, dXnQ0V, aaHO0E);
        int i3 = i + i2;
        if (!z || (ASJ6gh2 = this.mOrientationHelper.ASJ6gh() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.AzWtSf(ASJ6gh2);
        return ASJ6gh2 + i2;
    }

    public final int AYUAbz(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, boolean z) {
        int AaHO0E2;
        int AaHO0E3 = i - this.mOrientationHelper.AaHO0E();
        if (AaHO0E3 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(AaHO0E3, dXnQ0V, aaHO0E);
        int i3 = i + i2;
        if (!z || (AaHO0E2 = i3 - this.mOrientationHelper.AaHO0E()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.AzWtSf(-AaHO0E2);
        return i2 - AaHO0E2;
    }

    public final View AZOQYO() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    public final View AZkASS() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    public final void AaHO0E() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            getPosition(childAt);
            this.mOrientationHelper.AMqCpz(childAt);
        }
    }

    public final void AcNBzu(DXnQ0V dXnQ0V, C2rE4F c2rE4F) {
        if (!c2rE4F.f9308A2egSU || c2rE4F.f9318AcNBzu) {
            return;
        }
        int i = c2rE4F.f9313ASJ6gh;
        int i2 = c2rE4F.f9315AZOQYO;
        if (c2rE4F.f9312ARc23Z == -1) {
            int childCount = getChildCount();
            if (i < 0) {
                return;
            }
            int ARc23Z2 = (this.mOrientationHelper.ARc23Z() - i) + i2;
            if (this.mShouldReverseLayout) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (this.mOrientationHelper.AMqCpz(childAt) < ARc23Z2 || this.mOrientationHelper.AmA8tU(childAt) < ARc23Z2) {
                        AlLFFp(dXnQ0V, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (this.mOrientationHelper.AMqCpz(childAt2) < ARc23Z2 || this.mOrientationHelper.AmA8tU(childAt2) < ARc23Z2) {
                    AlLFFp(dXnQ0V, i4, i5);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i6 = i - i2;
        int childCount2 = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt3 = getChildAt(i7);
                if (this.mOrientationHelper.A4TApA(childAt3) > i6 || this.mOrientationHelper.AlLFFp(childAt3) > i6) {
                    AlLFFp(dXnQ0V, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = childCount2 - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View childAt4 = getChildAt(i9);
            if (this.mOrientationHelper.A4TApA(childAt4) > i6 || this.mOrientationHelper.AlLFFp(childAt4) > i6) {
                AlLFFp(dXnQ0V, i8, i9);
                return;
            }
        }
    }

    public final void AlLFFp(DXnQ0V dXnQ0V, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, dXnQ0V);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, dXnQ0V);
            }
        }
    }

    public final void AmA8tU() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public final void AzWtSf(int i, int i2, boolean z, RecyclerView.AaHO0E aaHO0E) {
        int AaHO0E2;
        this.mLayoutState.f9318AcNBzu = resolveIsInfinite();
        this.mLayoutState.f9312ARc23Z = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(aaHO0E, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i == 1;
        C2rE4F c2rE4F = this.mLayoutState;
        int i3 = z2 ? max2 : max;
        c2rE4F.f9314AYUAbz = i3;
        if (!z2) {
            max = max2;
        }
        c2rE4F.f9315AZOQYO = max;
        if (z2) {
            c2rE4F.f9314AYUAbz = this.mOrientationHelper.AYUAbz() + i3;
            View AZOQYO2 = AZOQYO();
            C2rE4F c2rE4F2 = this.mLayoutState;
            c2rE4F2.AMqCpz = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(AZOQYO2);
            C2rE4F c2rE4F3 = this.mLayoutState;
            c2rE4F2.f9311ADYaiT = position + c2rE4F3.AMqCpz;
            c2rE4F3.f9309A4TApA = this.mOrientationHelper.A4TApA(AZOQYO2);
            AaHO0E2 = this.mOrientationHelper.A4TApA(AZOQYO2) - this.mOrientationHelper.ASJ6gh();
        } else {
            View AZkASS2 = AZkASS();
            C2rE4F c2rE4F4 = this.mLayoutState;
            c2rE4F4.f9314AYUAbz = this.mOrientationHelper.AaHO0E() + c2rE4F4.f9314AYUAbz;
            C2rE4F c2rE4F5 = this.mLayoutState;
            c2rE4F5.AMqCpz = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(AZkASS2);
            C2rE4F c2rE4F6 = this.mLayoutState;
            c2rE4F5.f9311ADYaiT = position2 + c2rE4F6.AMqCpz;
            c2rE4F6.f9309A4TApA = this.mOrientationHelper.AMqCpz(AZkASS2);
            AaHO0E2 = (-this.mOrientationHelper.AMqCpz(AZkASS2)) + this.mOrientationHelper.AaHO0E();
        }
        C2rE4F c2rE4F7 = this.mLayoutState;
        c2rE4F7.f9310A5SV6n = i2;
        if (z) {
            c2rE4F7.f9310A5SV6n = i2 - AaHO0E2;
        }
        c2rE4F7.f9313ASJ6gh = AaHO0E2;
    }

    public final void B25kr6(int i, int i2) {
        this.mLayoutState.f9310A5SV6n = this.mOrientationHelper.ASJ6gh() - i2;
        C2rE4F c2rE4F = this.mLayoutState;
        c2rE4F.AMqCpz = this.mShouldReverseLayout ? -1 : 1;
        c2rE4F.f9311ADYaiT = i;
        c2rE4F.f9312ARc23Z = 1;
        c2rE4F.f9309A4TApA = i2;
        c2rE4F.f9313ASJ6gh = Integer.MIN_VALUE;
    }

    public final void B2KMhB(int i, int i2) {
        this.mLayoutState.f9310A5SV6n = i2 - this.mOrientationHelper.AaHO0E();
        C2rE4F c2rE4F = this.mLayoutState;
        c2rE4F.f9311ADYaiT = i;
        c2rE4F.AMqCpz = this.mShouldReverseLayout ? 1 : -1;
        c2rE4F.f9312ARc23Z = -1;
        c2rE4F.f9309A4TApA = i2;
        c2rE4F.f9313ASJ6gh = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.AaHO0E aaHO0E, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(aaHO0E);
        if (this.mLayoutState.f9312ARc23Z == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.AaHO0E aaHO0E, DAk1zC dAk1zC) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        AzWtSf(i > 0 ? 1 : -1, Math.abs(i), true, aaHO0E);
        collectPrefetchPositionsForLayoutState(aaHO0E, this.mLayoutState, dAk1zC);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i, DAk1zC dAk1zC) {
        boolean z;
        int i2;
        A2egSU a2egSU = this.mPendingSavedState;
        if (a2egSU == null || (i2 = a2egSU.f9423AcNBzu) < 0) {
            AmA8tU();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = a2egSU.f9425AmA8tU;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            ((BNL6CD) dAk1zC).A2egSU(i2, 0);
            i2 += i3;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.AaHO0E aaHO0E, C2rE4F c2rE4F, DAk1zC dAk1zC) {
        int i = c2rE4F.f9311ADYaiT;
        if (i < 0 || i >= aaHO0E.A4TApA()) {
            return;
        }
        ((BNL6CD) dAk1zC).A2egSU(i, Math.max(0, c2rE4F.f9313ASJ6gh));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.AaHO0E aaHO0E) {
        return ADYaiT(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.AaHO0E aaHO0E) {
        return AMqCpz(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.AaHO0E aaHO0E) {
        return ARc23Z(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.Ddcejp
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.AaHO0E aaHO0E) {
        return ADYaiT(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.AaHO0E aaHO0E) {
        return AMqCpz(aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.AaHO0E aaHO0E) {
        return ARc23Z(aaHO0E);
    }

    public int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public C2rE4F createLayoutState() {
        C2rE4F c2rE4F = new C2rE4F();
        c2rE4F.f9308A2egSU = true;
        c2rE4F.f9314AYUAbz = 0;
        c2rE4F.f9315AZOQYO = 0;
        c2rE4F.f9317AaHO0E = null;
        return c2rE4F;
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(DXnQ0V dXnQ0V, C2rE4F c2rE4F, RecyclerView.AaHO0E aaHO0E, boolean z) {
        int i;
        int i2 = c2rE4F.f9310A5SV6n;
        int i3 = c2rE4F.f9313ASJ6gh;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                c2rE4F.f9313ASJ6gh = i3 + i2;
            }
            AcNBzu(dXnQ0V, c2rE4F);
        }
        int i4 = c2rE4F.f9310A5SV6n + c2rE4F.f9314AYUAbz;
        BpkvW3 bpkvW3 = this.mLayoutChunkResult;
        while (true) {
            if ((!c2rE4F.f9318AcNBzu && i4 <= 0) || (i = c2rE4F.f9311ADYaiT) < 0 || i >= aaHO0E.A4TApA()) {
                break;
            }
            bpkvW3.f9304A2egSU = 0;
            bpkvW3.f9305A4TApA = false;
            bpkvW3.f9306A5SV6n = false;
            bpkvW3.f9307ADYaiT = false;
            layoutChunk(dXnQ0V, aaHO0E, c2rE4F, bpkvW3);
            if (!bpkvW3.f9305A4TApA) {
                int i5 = c2rE4F.f9309A4TApA;
                int i6 = bpkvW3.f9304A2egSU;
                c2rE4F.f9309A4TApA = (c2rE4F.f9312ARc23Z * i6) + i5;
                if (!bpkvW3.f9306A5SV6n || c2rE4F.f9317AaHO0E != null || !aaHO0E.f9445ASJ6gh) {
                    c2rE4F.f9310A5SV6n -= i6;
                    i4 -= i6;
                }
                int i7 = c2rE4F.f9313ASJ6gh;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    c2rE4F.f9313ASJ6gh = i8;
                    int i9 = c2rE4F.f9310A5SV6n;
                    if (i9 < 0) {
                        c2rE4F.f9313ASJ6gh = i8 + i9;
                    }
                    AcNBzu(dXnQ0V, c2rE4F);
                }
                if (z && bpkvW3.f9307ADYaiT) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - c2rE4F.f9310A5SV6n;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z, z2) : findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z, z2) : findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if (i2 <= i && i2 >= i) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.AMqCpz(getChildAt(i)) < this.mOrientationHelper.AaHO0E()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.A2egSU(i, i2, i3, i4) : this.mVerticalBoundCheck.A2egSU(i, i2, i3, i4);
    }

    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        int i4 = z ? 24579 : MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        if (!z2) {
            i3 = 0;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.A2egSU(i, i2, i4, i3) : this.mVerticalBoundCheck.A2egSU(i, i2, i4, i3);
    }

    public View findReferenceChild(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
            i3 = 1;
        }
        int A4TApA2 = aaHO0E.A4TApA();
        int AaHO0E2 = this.mOrientationHelper.AaHO0E();
        int ASJ6gh2 = this.mOrientationHelper.ASJ6gh();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            int AMqCpz = this.mOrientationHelper.AMqCpz(childAt);
            int A4TApA3 = this.mOrientationHelper.A4TApA(childAt);
            if (position >= 0 && position < A4TApA2) {
                if (!((DG07BK) childAt.getLayoutParams()).f9343A2egSU.isRemoved()) {
                    boolean z3 = A4TApA3 <= AaHO0E2 && AMqCpz < AaHO0E2;
                    boolean z4 = AMqCpz >= ASJ6gh2 && A4TApA3 > ASJ6gh2;
                    if (!z3 && !z4) {
                        return childAt;
                    }
                    if (z) {
                        if (!z4) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    } else {
                        if (!z3) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i2 += i3;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public DG07BK generateDefaultLayoutParams() {
        return new DG07BK(-2, -2);
    }

    public int getExtraLayoutSpace(RecyclerView.AaHO0E aaHO0E) {
        if (aaHO0E.f9440A2egSU != -1) {
            return this.mOrientationHelper.AcNBzu();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, C2rE4F c2rE4F, BpkvW3 bpkvW3) {
        int i;
        int i2;
        int i3;
        int i4;
        int paddingLeft;
        int ADYaiT2;
        int i5;
        int i6;
        View A4TApA2 = c2rE4F.A4TApA(dXnQ0V);
        if (A4TApA2 == null) {
            bpkvW3.f9305A4TApA = true;
            return;
        }
        DG07BK dg07bk = (DG07BK) A4TApA2.getLayoutParams();
        if (c2rE4F.f9317AaHO0E == null) {
            if (this.mShouldReverseLayout == (c2rE4F.f9312ARc23Z == -1)) {
                addView(A4TApA2);
            } else {
                addView(A4TApA2, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (c2rE4F.f9312ARc23Z == -1)) {
                addDisappearingView(A4TApA2);
            } else {
                addDisappearingView(A4TApA2, 0);
            }
        }
        measureChildWithMargins(A4TApA2, 0, 0);
        bpkvW3.f9304A2egSU = this.mOrientationHelper.A5SV6n(A4TApA2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                ADYaiT2 = getWidth() - getPaddingRight();
                paddingLeft = ADYaiT2 - this.mOrientationHelper.ADYaiT(A4TApA2);
            } else {
                paddingLeft = getPaddingLeft();
                ADYaiT2 = this.mOrientationHelper.ADYaiT(A4TApA2) + paddingLeft;
            }
            if (c2rE4F.f9312ARc23Z == -1) {
                i6 = c2rE4F.f9309A4TApA;
                i5 = i6 - bpkvW3.f9304A2egSU;
            } else {
                i5 = c2rE4F.f9309A4TApA;
                i6 = bpkvW3.f9304A2egSU + i5;
            }
            int i7 = paddingLeft;
            i4 = i5;
            i3 = i7;
            i2 = i6;
            i = ADYaiT2;
        } else {
            int paddingTop = getPaddingTop();
            int ADYaiT3 = this.mOrientationHelper.ADYaiT(A4TApA2) + paddingTop;
            if (c2rE4F.f9312ARc23Z == -1) {
                int i8 = c2rE4F.f9309A4TApA;
                i3 = i8 - bpkvW3.f9304A2egSU;
                i = i8;
                i2 = ADYaiT3;
            } else {
                int i9 = c2rE4F.f9309A4TApA;
                i = bpkvW3.f9304A2egSU + i9;
                i2 = ADYaiT3;
                i3 = i9;
            }
            i4 = paddingTop;
        }
        layoutDecoratedWithMargins(A4TApA2, i3, i4, i, i2);
        if (dg07bk.f9343A2egSU.isRemoved() || dg07bk.f9343A2egSU.isUpdated()) {
            bpkvW3.f9306A5SV6n = true;
        }
        bpkvW3.f9307ADYaiT = A4TApA2.hasFocusable();
    }

    public void onAnchorReady(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, BniPrB bniPrB, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, DXnQ0V dXnQ0V) {
        onDetachedFromWindow(recyclerView);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(dXnQ0V);
            dXnQ0V.f9351A2egSU.clear();
            dXnQ0V.AYUAbz();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        int convertFocusDirectionToLayoutDirection;
        AmA8tU();
        if (getChildCount() != 0 && (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) != Integer.MIN_VALUE) {
            ensureLayoutState();
            AzWtSf(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.AcNBzu() * MAX_SCROLL_FACTOR), false, aaHO0E);
            C2rE4F c2rE4F = this.mLayoutState;
            c2rE4F.f9313ASJ6gh = Integer.MIN_VALUE;
            c2rE4F.f9308A2egSU = false;
            fill(dXnQ0V, c2rE4F, aaHO0E, true);
            View findOnePartiallyOrCompletelyInvisibleChild = convertFocusDirectionToLayoutDirection == -1 ? this.mShouldReverseLayout ? findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1) : findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount()) : this.mShouldReverseLayout ? findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount()) : findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
            View AZkASS2 = convertFocusDirectionToLayoutDirection == -1 ? AZkASS() : AZOQYO();
            if (!AZkASS2.hasFocusable()) {
                return findOnePartiallyOrCompletelyInvisibleChild;
            }
            if (findOnePartiallyOrCompletelyInvisibleChild != null) {
                return AZkASS2;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        View findReferenceChild;
        int i;
        int AMqCpz;
        int i2;
        int i3;
        int i4;
        int i5;
        int ASJ6gh2;
        int i6;
        View findViewByPosition;
        int AMqCpz2;
        int i7;
        int i8;
        int i9 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && aaHO0E.A4TApA() == 0) {
            removeAndRecycleAllViews(dXnQ0V);
            return;
        }
        A2egSU a2egSU = this.mPendingSavedState;
        if (a2egSU != null && (i8 = a2egSU.f9423AcNBzu) >= 0) {
            this.mPendingScrollPosition = i8;
        }
        ensureLayoutState();
        this.mLayoutState.f9308A2egSU = false;
        AmA8tU();
        View focusedChild = getFocusedChild();
        BniPrB bniPrB = this.mAnchorInfo;
        if (!bniPrB.AMqCpz || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            bniPrB.ADYaiT();
            BniPrB bniPrB2 = this.mAnchorInfo;
            bniPrB2.f9303ADYaiT = this.mShouldReverseLayout ^ this.mStackFromEnd;
            if (!aaHO0E.f9445ASJ6gh && (i = this.mPendingScrollPosition) != -1) {
                if (i < 0 || i >= aaHO0E.A4TApA()) {
                    this.mPendingScrollPosition = -1;
                    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                } else {
                    int i10 = this.mPendingScrollPosition;
                    bniPrB2.f9301A4TApA = i10;
                    A2egSU a2egSU2 = this.mPendingSavedState;
                    if (a2egSU2 != null && a2egSU2.f9423AcNBzu >= 0) {
                        boolean z = a2egSU2.f9425AmA8tU;
                        bniPrB2.f9303ADYaiT = z;
                        if (z) {
                            bniPrB2.f9302A5SV6n = this.mOrientationHelper.ASJ6gh() - this.mPendingSavedState.f9424AlLFFp;
                        } else {
                            bniPrB2.f9302A5SV6n = this.mOrientationHelper.AaHO0E() + this.mPendingSavedState.f9424AlLFFp;
                        }
                    } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                        View findViewByPosition2 = findViewByPosition(i10);
                        if (findViewByPosition2 == null) {
                            if (getChildCount() > 0) {
                                bniPrB2.f9303ADYaiT = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                            }
                            bniPrB2.A2egSU();
                        } else if (this.mOrientationHelper.A5SV6n(findViewByPosition2) > this.mOrientationHelper.AcNBzu()) {
                            bniPrB2.A2egSU();
                        } else if (this.mOrientationHelper.AMqCpz(findViewByPosition2) - this.mOrientationHelper.AaHO0E() < 0) {
                            bniPrB2.f9302A5SV6n = this.mOrientationHelper.AaHO0E();
                            bniPrB2.f9303ADYaiT = false;
                        } else if (this.mOrientationHelper.ASJ6gh() - this.mOrientationHelper.A4TApA(findViewByPosition2) < 0) {
                            bniPrB2.f9302A5SV6n = this.mOrientationHelper.ASJ6gh();
                            bniPrB2.f9303ADYaiT = true;
                        } else {
                            if (bniPrB2.f9303ADYaiT) {
                                int A4TApA2 = this.mOrientationHelper.A4TApA(findViewByPosition2);
                                Cd8JRx cd8JRx = this.mOrientationHelper;
                                AMqCpz = (Integer.MIN_VALUE == cd8JRx.f9326A4TApA ? 0 : cd8JRx.AcNBzu() - cd8JRx.f9326A4TApA) + A4TApA2;
                            } else {
                                AMqCpz = this.mOrientationHelper.AMqCpz(findViewByPosition2);
                            }
                            bniPrB2.f9302A5SV6n = AMqCpz;
                        }
                    } else {
                        boolean z2 = this.mShouldReverseLayout;
                        bniPrB2.f9303ADYaiT = z2;
                        if (z2) {
                            bniPrB2.f9302A5SV6n = this.mOrientationHelper.ASJ6gh() - this.mPendingScrollPositionOffset;
                        } else {
                            bniPrB2.f9302A5SV6n = this.mOrientationHelper.AaHO0E() + this.mPendingScrollPositionOffset;
                        }
                    }
                    this.mAnchorInfo.AMqCpz = true;
                }
            }
            if (getChildCount() != 0) {
                View focusedChild2 = getFocusedChild();
                if (focusedChild2 != null) {
                    DG07BK dg07bk = (DG07BK) focusedChild2.getLayoutParams();
                    if (!dg07bk.f9343A2egSU.isRemoved() && dg07bk.f9343A2egSU.getLayoutPosition() >= 0 && dg07bk.f9343A2egSU.getLayoutPosition() < aaHO0E.A4TApA()) {
                        bniPrB2.A5SV6n(getPosition(focusedChild2), focusedChild2);
                        this.mAnchorInfo.AMqCpz = true;
                    }
                }
                boolean z3 = this.mLastStackFromEnd;
                boolean z4 = this.mStackFromEnd;
                if (z3 == z4 && (findReferenceChild = findReferenceChild(dXnQ0V, aaHO0E, bniPrB2.f9303ADYaiT, z4)) != null) {
                    bniPrB2.A4TApA(getPosition(findReferenceChild), findReferenceChild);
                    if (!aaHO0E.f9445ASJ6gh && supportsPredictiveItemAnimations()) {
                        int AMqCpz3 = this.mOrientationHelper.AMqCpz(findReferenceChild);
                        int A4TApA3 = this.mOrientationHelper.A4TApA(findReferenceChild);
                        int AaHO0E2 = this.mOrientationHelper.AaHO0E();
                        int ASJ6gh3 = this.mOrientationHelper.ASJ6gh();
                        boolean z5 = A4TApA3 <= AaHO0E2 && AMqCpz3 < AaHO0E2;
                        boolean z6 = AMqCpz3 >= ASJ6gh3 && A4TApA3 > ASJ6gh3;
                        if (z5 || z6) {
                            if (bniPrB2.f9303ADYaiT) {
                                AaHO0E2 = ASJ6gh3;
                            }
                            bniPrB2.f9302A5SV6n = AaHO0E2;
                        }
                    }
                    this.mAnchorInfo.AMqCpz = true;
                }
            }
            bniPrB2.A2egSU();
            bniPrB2.f9301A4TApA = this.mStackFromEnd ? aaHO0E.A4TApA() - 1 : 0;
            this.mAnchorInfo.AMqCpz = true;
        } else if (focusedChild != null && (this.mOrientationHelper.AMqCpz(focusedChild) >= this.mOrientationHelper.ASJ6gh() || this.mOrientationHelper.A4TApA(focusedChild) <= this.mOrientationHelper.AaHO0E())) {
            this.mAnchorInfo.A5SV6n(getPosition(focusedChild), focusedChild);
        }
        C2rE4F c2rE4F = this.mLayoutState;
        c2rE4F.f9312ARc23Z = c2rE4F.f9316AZkASS >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(aaHO0E, iArr);
        int AaHO0E3 = this.mOrientationHelper.AaHO0E() + Math.max(0, this.mReusableIntPair[0]);
        int AYUAbz2 = this.mOrientationHelper.AYUAbz() + Math.max(0, this.mReusableIntPair[1]);
        if (aaHO0E.f9445ASJ6gh && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.ASJ6gh() - this.mOrientationHelper.A4TApA(findViewByPosition);
                AMqCpz2 = this.mPendingScrollPositionOffset;
            } else {
                AMqCpz2 = this.mOrientationHelper.AMqCpz(findViewByPosition) - this.mOrientationHelper.AaHO0E();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i11 = i7 - AMqCpz2;
            if (i11 > 0) {
                AaHO0E3 += i11;
            } else {
                AYUAbz2 -= i11;
            }
        }
        BniPrB bniPrB3 = this.mAnchorInfo;
        if (!bniPrB3.f9303ADYaiT ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i9 = 1;
        }
        onAnchorReady(dXnQ0V, aaHO0E, bniPrB3, i9);
        detachAndScrapAttachedViews(dXnQ0V);
        this.mLayoutState.f9318AcNBzu = resolveIsInfinite();
        this.mLayoutState.getClass();
        this.mLayoutState.f9315AZOQYO = 0;
        BniPrB bniPrB4 = this.mAnchorInfo;
        if (bniPrB4.f9303ADYaiT) {
            B2KMhB(bniPrB4.f9301A4TApA, bniPrB4.f9302A5SV6n);
            C2rE4F c2rE4F2 = this.mLayoutState;
            c2rE4F2.f9314AYUAbz = AaHO0E3;
            fill(dXnQ0V, c2rE4F2, aaHO0E, false);
            C2rE4F c2rE4F3 = this.mLayoutState;
            i3 = c2rE4F3.f9309A4TApA;
            int i12 = c2rE4F3.f9311ADYaiT;
            int i13 = c2rE4F3.f9310A5SV6n;
            if (i13 > 0) {
                AYUAbz2 += i13;
            }
            BniPrB bniPrB5 = this.mAnchorInfo;
            B25kr6(bniPrB5.f9301A4TApA, bniPrB5.f9302A5SV6n);
            C2rE4F c2rE4F4 = this.mLayoutState;
            c2rE4F4.f9314AYUAbz = AYUAbz2;
            c2rE4F4.f9311ADYaiT += c2rE4F4.AMqCpz;
            fill(dXnQ0V, c2rE4F4, aaHO0E, false);
            C2rE4F c2rE4F5 = this.mLayoutState;
            i2 = c2rE4F5.f9309A4TApA;
            int i14 = c2rE4F5.f9310A5SV6n;
            if (i14 > 0) {
                B2KMhB(i12, i3);
                C2rE4F c2rE4F6 = this.mLayoutState;
                c2rE4F6.f9314AYUAbz = i14;
                fill(dXnQ0V, c2rE4F6, aaHO0E, false);
                i3 = this.mLayoutState.f9309A4TApA;
            }
        } else {
            B25kr6(bniPrB4.f9301A4TApA, bniPrB4.f9302A5SV6n);
            C2rE4F c2rE4F7 = this.mLayoutState;
            c2rE4F7.f9314AYUAbz = AYUAbz2;
            fill(dXnQ0V, c2rE4F7, aaHO0E, false);
            C2rE4F c2rE4F8 = this.mLayoutState;
            i2 = c2rE4F8.f9309A4TApA;
            int i15 = c2rE4F8.f9311ADYaiT;
            int i16 = c2rE4F8.f9310A5SV6n;
            if (i16 > 0) {
                AaHO0E3 += i16;
            }
            BniPrB bniPrB6 = this.mAnchorInfo;
            B2KMhB(bniPrB6.f9301A4TApA, bniPrB6.f9302A5SV6n);
            C2rE4F c2rE4F9 = this.mLayoutState;
            c2rE4F9.f9314AYUAbz = AaHO0E3;
            c2rE4F9.f9311ADYaiT += c2rE4F9.AMqCpz;
            fill(dXnQ0V, c2rE4F9, aaHO0E, false);
            C2rE4F c2rE4F10 = this.mLayoutState;
            int i17 = c2rE4F10.f9309A4TApA;
            int i18 = c2rE4F10.f9310A5SV6n;
            if (i18 > 0) {
                B25kr6(i15, i2);
                C2rE4F c2rE4F11 = this.mLayoutState;
                c2rE4F11.f9314AYUAbz = i18;
                fill(dXnQ0V, c2rE4F11, aaHO0E, false);
                i2 = this.mLayoutState.f9309A4TApA;
            }
            i3 = i17;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int ASJ6gh4 = ASJ6gh(i2, dXnQ0V, aaHO0E, true);
                i4 = i3 + ASJ6gh4;
                i5 = i2 + ASJ6gh4;
                ASJ6gh2 = AYUAbz(i4, dXnQ0V, aaHO0E, false);
            } else {
                int AYUAbz3 = AYUAbz(i3, dXnQ0V, aaHO0E, true);
                i4 = i3 + AYUAbz3;
                i5 = i2 + AYUAbz3;
                ASJ6gh2 = ASJ6gh(i5, dXnQ0V, aaHO0E, false);
            }
            i3 = i4 + ASJ6gh2;
            i2 = i5 + ASJ6gh2;
        }
        if (aaHO0E.f9449AaHO0E && getChildCount() != 0 && !aaHO0E.f9445ASJ6gh && supportsPredictiveItemAnimations()) {
            List list = dXnQ0V.f9354ADYaiT;
            int size = list.size();
            int position = getPosition(getChildAt(0));
            int i19 = 0;
            int i20 = 0;
            for (int i21 = 0; i21 < size; i21++) {
                Dphsd2 dphsd2 = (Dphsd2) list.get(i21);
                if (!dphsd2.isRemoved()) {
                    if ((dphsd2.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                        i19 += this.mOrientationHelper.A5SV6n(dphsd2.itemView);
                    } else {
                        i20 += this.mOrientationHelper.A5SV6n(dphsd2.itemView);
                    }
                }
            }
            this.mLayoutState.f9317AaHO0E = list;
            if (i19 > 0) {
                B2KMhB(getPosition(AZkASS()), i3);
                C2rE4F c2rE4F12 = this.mLayoutState;
                c2rE4F12.f9314AYUAbz = i19;
                c2rE4F12.f9310A5SV6n = 0;
                c2rE4F12.A2egSU(null);
                fill(dXnQ0V, this.mLayoutState, aaHO0E, false);
            }
            if (i20 > 0) {
                B25kr6(getPosition(AZOQYO()), i2);
                C2rE4F c2rE4F13 = this.mLayoutState;
                c2rE4F13.f9314AYUAbz = i20;
                c2rE4F13.f9310A5SV6n = 0;
                c2rE4F13.A2egSU(null);
                fill(dXnQ0V, this.mLayoutState, aaHO0E, false);
            }
            this.mLayoutState.f9317AaHO0E = null;
        }
        if (aaHO0E.f9445ASJ6gh) {
            this.mAnchorInfo.ADYaiT();
        } else {
            Cd8JRx cd8JRx2 = this.mOrientationHelper;
            cd8JRx2.f9326A4TApA = cd8JRx2.AcNBzu();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.AaHO0E aaHO0E) {
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.ADYaiT();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof A2egSU) {
            A2egSU a2egSU = (A2egSU) parcelable;
            this.mPendingSavedState = a2egSU;
            if (this.mPendingScrollPosition != -1) {
                a2egSU.f9423AcNBzu = -1;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        A2egSU a2egSU = this.mPendingSavedState;
        if (a2egSU != null) {
            A2egSU a2egSU2 = new A2egSU();
            a2egSU2.f9423AcNBzu = a2egSU.f9423AcNBzu;
            a2egSU2.f9424AlLFFp = a2egSU.f9424AlLFFp;
            a2egSU2.f9425AmA8tU = a2egSU.f9425AmA8tU;
            return a2egSU2;
        }
        A2egSU a2egSU3 = new A2egSU();
        if (getChildCount() <= 0) {
            a2egSU3.f9423AcNBzu = -1;
            return a2egSU3;
        }
        ensureLayoutState();
        boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        a2egSU3.f9425AmA8tU = z;
        if (z) {
            View AZOQYO2 = AZOQYO();
            a2egSU3.f9424AlLFFp = this.mOrientationHelper.ASJ6gh() - this.mOrientationHelper.A4TApA(AZOQYO2);
            a2egSU3.f9423AcNBzu = getPosition(AZOQYO2);
            return a2egSU3;
        }
        View AZkASS2 = AZkASS();
        a2egSU3.f9423AcNBzu = getPosition(AZkASS2);
        a2egSU3.f9424AlLFFp = this.mOrientationHelper.AMqCpz(AZkASS2) - this.mOrientationHelper.AaHO0E();
        return a2egSU3;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        AmA8tU();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.ASJ6gh() - (this.mOrientationHelper.A5SV6n(view) + this.mOrientationHelper.AMqCpz(view2)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.ASJ6gh() - this.mOrientationHelper.A4TApA(view2));
                return;
            }
        }
        if (c == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.AMqCpz(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.A4TApA(view2) - this.mOrientationHelper.A5SV6n(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.AZOQYO() == 0 && this.mOrientationHelper.ARc23Z() == 0;
    }

    public int scrollBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f9308A2egSU = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        AzWtSf(i2, abs, true, aaHO0E);
        C2rE4F c2rE4F = this.mLayoutState;
        int fill = fill(dXnQ0V, c2rE4F, aaHO0E, false) + c2rE4F.f9313ASJ6gh;
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.AzWtSf(-i);
        this.mLayoutState.f9316AZkASS = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, dXnQ0V, aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        A2egSU a2egSU = this.mPendingSavedState;
        if (a2egSU != null) {
            a2egSU.f9423AcNBzu = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        A2egSU a2egSU = this.mPendingSavedState;
        if (a2egSU != null) {
            a2egSU.f9423AcNBzu = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, dXnQ0V, aaHO0E);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(i, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            Cd8JRx A2egSU2 = Cd8JRx.A2egSU(this, i);
            this.mOrientationHelper = A2egSU2;
            this.mAnchorInfo.f9300A2egSU = A2egSU2;
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E, int i) {
        CASmeH cASmeH = new CASmeH(recyclerView.getContext());
        cASmeH.setTargetPosition(i);
        startSmoothScroll(cASmeH);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        getChildCount();
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int AMqCpz = this.mOrientationHelper.AMqCpz(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int AMqCpz2 = this.mOrientationHelper.AMqCpz(childAt);
                if (position2 < position) {
                    AaHO0E();
                    StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                    sb.append(AMqCpz2 < AMqCpz);
                    throw new RuntimeException(sb.toString());
                }
                if (AMqCpz2 > AMqCpz) {
                    AaHO0E();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int AMqCpz3 = this.mOrientationHelper.AMqCpz(childAt2);
            if (position3 < position) {
                AaHO0E();
                StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                sb2.append(AMqCpz3 < AMqCpz);
                throw new RuntimeException(sb2.toString());
            }
            if (AMqCpz3 < AMqCpz) {
                AaHO0E();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new BniPrB();
        this.mLayoutChunkResult = new BpkvW3();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.ARc23Z.A2egSU properties = RecyclerView.ARc23Z.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f9433A2egSU);
        setReverseLayout(properties.f9435A5SV6n);
        setStackFromEnd(properties.f9436ADYaiT);
    }
}
