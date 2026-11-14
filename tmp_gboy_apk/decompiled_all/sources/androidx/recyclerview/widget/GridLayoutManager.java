package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f9414A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9415A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int[] f9416A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public View[] f9417ADYaiT;
    public final SparseIntArray AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final SparseIntArray f9418ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public A4TApA f9419ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final Rect f9420AYUAbz;

    public static final class A2egSU extends A4TApA {
        @Override // androidx.recyclerview.widget.GridLayoutManager.A4TApA
        public final int A4TApA(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.A4TApA
        public final int A5SV6n(int i) {
            return 1;
        }
    }

    public static abstract class A4TApA {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final SparseIntArray f9421A2egSU = new SparseIntArray();

        /* renamed from: A4TApA, reason: collision with root package name */
        public final SparseIntArray f9422A4TApA = new SparseIntArray();

        public final int A2egSU(int i, int i2) {
            int A5SV6n2 = A5SV6n(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int A5SV6n3 = A5SV6n(i5);
                i3 += A5SV6n3;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = A5SV6n3;
                }
            }
            return i3 + A5SV6n2 > i2 ? i4 + 1 : i4;
        }

        public int A4TApA(int i, int i2) {
            int A5SV6n2 = A5SV6n(i);
            if (A5SV6n2 == i2) {
                return 0;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                int A5SV6n3 = A5SV6n(i4);
                i3 += A5SV6n3;
                if (i3 == i2) {
                    i3 = 0;
                } else if (i3 > i2) {
                    i3 = A5SV6n3;
                }
            }
            if (A5SV6n2 + i3 <= i2) {
                return i3;
            }
            return 0;
        }

        public abstract int A5SV6n(int i);

        public final void ADYaiT() {
            this.f9421A2egSU.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9414A2egSU = false;
        this.f9415A4TApA = -1;
        this.AMqCpz = new SparseIntArray();
        this.f9418ARc23Z = new SparseIntArray();
        this.f9419ASJ6gh = new A2egSU();
        this.f9420AYUAbz = new Rect();
        BJ7GGh(RecyclerView.ARc23Z.getProperties(context, attributeSet, i, i2).f9434A4TApA);
    }

    public final void B3GDIM(int i) {
        int i2;
        int[] iArr = this.f9416A5SV6n;
        int i3 = this.f9415A4TApA;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.f9416A5SV6n = iArr;
    }

    public final void B4ZgIw() {
        View[] viewArr = this.f9417ADYaiT;
        if (viewArr == null || viewArr.length != this.f9415A4TApA) {
            this.f9417ADYaiT = new View[this.f9415A4TApA];
        }
    }

    public final int B7CMnp(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f9416A5SV6n;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f9416A5SV6n;
        int i3 = this.f9415A4TApA;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int B9tovu(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (!aaHO0E.f9445ASJ6gh) {
            return this.f9419ASJ6gh.A2egSU(i, this.f9415A4TApA);
        }
        int A4TApA2 = dXnQ0V.A4TApA(i);
        if (A4TApA2 == -1) {
            return 0;
        }
        return this.f9419ASJ6gh.A2egSU(A4TApA2, this.f9415A4TApA);
    }

    public final int BChYOn(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (!aaHO0E.f9445ASJ6gh) {
            return this.f9419ASJ6gh.A4TApA(i, this.f9415A4TApA);
        }
        int i2 = this.f9418ARc23Z.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int A4TApA2 = dXnQ0V.A4TApA(i);
        if (A4TApA2 == -1) {
            return 0;
        }
        return this.f9419ASJ6gh.A4TApA(A4TApA2, this.f9415A4TApA);
    }

    public final int BI9f7h(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (!aaHO0E.f9445ASJ6gh) {
            return this.f9419ASJ6gh.A5SV6n(i);
        }
        int i2 = this.AMqCpz.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int A4TApA2 = dXnQ0V.A4TApA(i);
        if (A4TApA2 == -1) {
            return 1;
        }
        return this.f9419ASJ6gh.A5SV6n(A4TApA2);
    }

    public final void BIYEnU(View view, int i, boolean z) {
        int i2;
        int i3;
        BV3sI0 bV3sI0 = (BV3sI0) view.getLayoutParams();
        Rect rect = bV3sI0.f9344A4TApA;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bV3sI0).topMargin + ((ViewGroup.MarginLayoutParams) bV3sI0).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bV3sI0).leftMargin + ((ViewGroup.MarginLayoutParams) bV3sI0).rightMargin;
        int B7CMnp2 = B7CMnp(bV3sI0.AMqCpz, bV3sI0.f9291ARc23Z);
        if (this.mOrientation == 1) {
            i3 = RecyclerView.ARc23Z.getChildMeasureSpec(B7CMnp2, i, i5, ((ViewGroup.MarginLayoutParams) bV3sI0).width, false);
            i2 = RecyclerView.ARc23Z.getChildMeasureSpec(this.mOrientationHelper.AcNBzu(), getHeightMode(), i4, ((ViewGroup.MarginLayoutParams) bV3sI0).height, true);
        } else {
            int childMeasureSpec = RecyclerView.ARc23Z.getChildMeasureSpec(B7CMnp2, i, i4, ((ViewGroup.MarginLayoutParams) bV3sI0).height, false);
            int childMeasureSpec2 = RecyclerView.ARc23Z.getChildMeasureSpec(this.mOrientationHelper.AcNBzu(), getWidthMode(), i5, ((ViewGroup.MarginLayoutParams) bV3sI0).width, true);
            i2 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i3, i2, dg07bk) : shouldMeasureChild(view, i3, i2, dg07bk)) {
            view.measure(i3, i2);
        }
    }

    public final void BJ7GGh(int i) {
        if (i == this.f9415A4TApA) {
            return;
        }
        this.f9414A2egSU = true;
        if (i < 1) {
            throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(i, "Span count should be at least 1. Provided "));
        }
        this.f9415A4TApA = i;
        this.f9419ASJ6gh.ADYaiT();
        requestLayout();
    }

    public final void BNL6CD() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        B3GDIM(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean checkLayoutParams(DG07BK dg07bk) {
        return dg07bk instanceof BV3sI0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void collectPrefetchPositionsForLayoutState(RecyclerView.AaHO0E aaHO0E, C2rE4F c2rE4F, DAk1zC dAk1zC) {
        int i;
        int i2 = this.f9415A4TApA;
        for (int i3 = 0; i3 < this.f9415A4TApA && (i = c2rE4F.f9311ADYaiT) >= 0 && i < aaHO0E.A4TApA() && i2 > 0; i3++) {
            int i4 = c2rE4F.f9311ADYaiT;
            ((BNL6CD) dAk1zC).A2egSU(i4, Math.max(0, c2rE4F.f9313ASJ6gh));
            i2 -= this.f9419ASJ6gh.A5SV6n(i4);
            c2rE4F.f9311ADYaiT += c2rE4F.AMqCpz;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View findReferenceChild(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, boolean z, boolean z2) {
        int i;
        int i2;
        int childCount = getChildCount();
        int i3 = 1;
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
        }
        int A4TApA2 = aaHO0E.A4TApA();
        ensureLayoutState();
        int AaHO0E2 = this.mOrientationHelper.AaHO0E();
        int ASJ6gh2 = this.mOrientationHelper.ASJ6gh();
        View view = null;
        View view2 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < A4TApA2 && BChYOn(position, dXnQ0V, aaHO0E) == 0) {
                if (((DG07BK) childAt.getLayoutParams()).f9343A2egSU.isRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.AMqCpz(childAt) < ASJ6gh2 && this.mOrientationHelper.A4TApA(childAt) >= AaHO0E2) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i3;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final DG07BK generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new BV3sI0(-2, -1) : new BV3sI0(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final DG07BK generateLayoutParams(Context context, AttributeSet attributeSet) {
        BV3sI0 bV3sI0 = new BV3sI0(context, attributeSet);
        bV3sI0.AMqCpz = -1;
        bV3sI0.f9291ARc23Z = 0;
        return bV3sI0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int getColumnCountForAccessibility(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (this.mOrientation == 1) {
            return this.f9415A4TApA;
        }
        if (aaHO0E.A4TApA() < 1) {
            return 0;
        }
        return B9tovu(aaHO0E.A4TApA() - 1, dXnQ0V, aaHO0E) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int getRowCountForAccessibility(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        if (this.mOrientation == 0) {
            return this.f9415A4TApA;
        }
        if (aaHO0E.A4TApA() < 1) {
            return 0;
        }
        return B9tovu(aaHO0E.A4TApA() - 1, dXnQ0V, aaHO0E) + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        r21.f9305A4TApA = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void layoutChunk(androidx.recyclerview.widget.DXnQ0V r18, androidx.recyclerview.widget.RecyclerView.AaHO0E r19, androidx.recyclerview.widget.C2rE4F r20, androidx.recyclerview.widget.BpkvW3 r21) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.DXnQ0V, androidx.recyclerview.widget.RecyclerView$AaHO0E, androidx.recyclerview.widget.C2rE4F, androidx.recyclerview.widget.BpkvW3):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void onAnchorReady(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, BniPrB bniPrB, int i) {
        super.onAnchorReady(dXnQ0V, aaHO0E, bniPrB, i);
        BNL6CD();
        if (aaHO0E.A4TApA() > 0 && !aaHO0E.f9445ASJ6gh) {
            boolean z = i == 1;
            int BChYOn2 = BChYOn(bniPrB.f9301A4TApA, dXnQ0V, aaHO0E);
            if (z) {
                while (BChYOn2 > 0) {
                    int i2 = bniPrB.f9301A4TApA;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    bniPrB.f9301A4TApA = i3;
                    BChYOn2 = BChYOn(i3, dXnQ0V, aaHO0E);
                }
            } else {
                int A4TApA2 = aaHO0E.A4TApA() - 1;
                int i4 = bniPrB.f9301A4TApA;
                while (i4 < A4TApA2) {
                    int i5 = i4 + 1;
                    int BChYOn3 = BChYOn(i5, dXnQ0V, aaHO0E);
                    if (BChYOn3 <= BChYOn2) {
                        break;
                    }
                    i4 = i5;
                    BChYOn2 = BChYOn3;
                }
                bniPrB.f9301A4TApA = i4;
            }
        }
        B4ZgIw();
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d3, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f3, code lost:
    
        if (r13 == (r2 > r4)) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0111  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.DXnQ0V r26, androidx.recyclerview.widget.RecyclerView.AaHO0E r27) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.DXnQ0V, androidx.recyclerview.widget.RecyclerView$AaHO0E):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onInitializeAccessibilityNodeInfo(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, CQhlFr.AYUAbz aYUAbz) {
        super.onInitializeAccessibilityNodeInfo(dXnQ0V, aaHO0E, aYUAbz);
        aYUAbz.AZkASS(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onInitializeAccessibilityNodeInfoForItem(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, View view, CQhlFr.AYUAbz aYUAbz) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof BV3sI0)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, aYUAbz);
            return;
        }
        BV3sI0 bV3sI0 = (BV3sI0) layoutParams;
        int B9tovu2 = B9tovu(bV3sI0.f9343A2egSU.getLayoutPosition(), dXnQ0V, aaHO0E);
        if (this.mOrientation == 0) {
            aYUAbz.AaHO0E(CQhlFr.ASJ6gh.A2egSU(bV3sI0.AMqCpz, bV3sI0.f9291ARc23Z, B9tovu2, 1, false, false));
        } else {
            aYUAbz.AaHO0E(CQhlFr.ASJ6gh.A2egSU(B9tovu2, 1, bV3sI0.AMqCpz, bV3sI0.f9291ARc23Z, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f9419ASJ6gh.ADYaiT();
        this.f9419ASJ6gh.f9422A4TApA.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.f9419ASJ6gh.ADYaiT();
        this.f9419ASJ6gh.f9422A4TApA.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f9419ASJ6gh.ADYaiT();
        this.f9419ASJ6gh.f9422A4TApA.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f9419ASJ6gh.ADYaiT();
        this.f9419ASJ6gh.f9422A4TApA.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f9419ASJ6gh.ADYaiT();
        this.f9419ASJ6gh.f9422A4TApA.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onLayoutChildren(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        boolean z = aaHO0E.f9445ASJ6gh;
        SparseIntArray sparseIntArray = this.f9418ARc23Z;
        SparseIntArray sparseIntArray2 = this.AMqCpz;
        if (z) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                BV3sI0 bV3sI0 = (BV3sI0) getChildAt(i).getLayoutParams();
                int layoutPosition = bV3sI0.f9343A2egSU.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, bV3sI0.f9291ARc23Z);
                sparseIntArray.put(layoutPosition, bV3sI0.AMqCpz);
            }
        }
        super.onLayoutChildren(dXnQ0V, aaHO0E);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void onLayoutCompleted(RecyclerView.AaHO0E aaHO0E) {
        super.onLayoutCompleted(aaHO0E);
        this.f9414A2egSU = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int scrollHorizontallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        BNL6CD();
        B4ZgIw();
        return super.scrollHorizontallyBy(i, dXnQ0V, aaHO0E);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final int scrollVerticallyBy(int i, DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E) {
        BNL6CD();
        B4ZgIw();
        return super.scrollVerticallyBy(i, dXnQ0V, aaHO0E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.f9416A5SV6n == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.ARc23Z.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.f9416A5SV6n;
            chooseSize = RecyclerView.ARc23Z.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.ARc23Z.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.f9416A5SV6n;
            chooseSize2 = RecyclerView.ARc23Z.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f9414A2egSU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final DG07BK generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            BV3sI0 bV3sI0 = new BV3sI0((ViewGroup.MarginLayoutParams) layoutParams);
            bV3sI0.AMqCpz = -1;
            bV3sI0.f9291ARc23Z = 0;
            return bV3sI0;
        }
        BV3sI0 bV3sI02 = new BV3sI0(layoutParams);
        bV3sI02.AMqCpz = -1;
        bV3sI02.f9291ARc23Z = 0;
        return bV3sI02;
    }

    public GridLayoutManager(int i, int i2) {
        super(1);
        this.f9414A2egSU = false;
        this.f9415A4TApA = -1;
        this.AMqCpz = new SparseIntArray();
        this.f9418ARc23Z = new SparseIntArray();
        this.f9419ASJ6gh = new A2egSU();
        this.f9420AYUAbz = new Rect();
        BJ7GGh(i);
    }

    public GridLayoutManager(int i) {
        super(1);
        this.f9414A2egSU = false;
        this.f9415A4TApA = -1;
        this.AMqCpz = new SparseIntArray();
        this.f9418ARc23Z = new SparseIntArray();
        this.f9419ASJ6gh = new A2egSU();
        this.f9420AYUAbz = new Rect();
        BJ7GGh(i);
    }
}
