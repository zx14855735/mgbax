package com.kwad.components.core.page.widget.halfContainer;

import ADYaiT.CtFAbx;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import CmUvjW.A4TApA;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.AMqCpz;
import com.kwad.components.core.page.widget.halfContainer.h;
import com.kwad.sdk.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ContainerBottomSheetBehavior<V extends View> extends CoordinatorLayout.A2egSU {
    private VelocityTracker WN;
    private WeakReference<V> YA;
    protected WeakReference<View> YB;
    private a YC;
    private int YD;
    protected int YE;
    private boolean YF;
    private Map<View, Integer> YG;
    protected boolean YL;
    private ContainerBottomSheetBehavior<V>.c YM;
    private float Yj;
    private int Yk;
    private boolean Yl;
    private int Ym;
    protected int Yn;
    private int Yo;
    private int Yp;
    protected int Yq;
    private float Yr;
    private boolean Ys;
    private boolean Yt;
    protected h Yu;
    private boolean Yv;
    private boolean Yw;
    private int Yx;
    private boolean Yy;
    private int Yz;
    private boolean Yi = true;
    private int mState = 4;
    protected float YH = 1.0f;
    protected float YI = 1.0f;
    protected float YJ = 0.5f;
    protected float YK = 0.5f;
    private final h.a YN = new h.a() { // from class: com.kwad.components.core.page.widget.halfContainer.ContainerBottomSheetBehavior.2
        @Override // com.kwad.components.core.page.widget.halfContainer.h.a
        public final int D(View view) {
            return view.getLeft();
        }

        @Override // com.kwad.components.core.page.widget.halfContainer.h.a
        public final void bb(int i) {
            ContainerBottomSheetBehavior.this.ba(i);
        }

        @Override // com.kwad.components.core.page.widget.halfContainer.h.a
        public final int bc(int i) {
            return AMqCpz.B3GDIM(i, ContainerBottomSheetBehavior.this.tg(), ContainerBottomSheetBehavior.this.Ys ? ContainerBottomSheetBehavior.this.Yz : ContainerBottomSheetBehavior.this.Yq);
        }

        @Override // com.kwad.components.core.page.widget.halfContainer.h.a
        public final void onViewDragStateChanged(int i) {
            if (i == 1) {
                ContainerBottomSheetBehavior.this.aY(1);
            }
        }

        @Override // com.kwad.components.core.page.widget.halfContainer.h.a
        public final void onViewReleased(View view, float f, float f2) {
            int i = 0;
            int i2 = 6;
            if (f2 < 0.0f) {
                if (ContainerBottomSheetBehavior.this.Yi) {
                    if (ContainerBottomSheetBehavior.this.c(view, f2)) {
                        i = ContainerBottomSheetBehavior.this.Yo;
                    } else {
                        i = ContainerBottomSheetBehavior.this.Yq;
                        i2 = 4;
                    }
                } else if (view.getTop() > ContainerBottomSheetBehavior.this.Yp) {
                    i = ContainerBottomSheetBehavior.this.Yp;
                }
                i2 = 3;
            } else if (ContainerBottomSheetBehavior.this.Ys && ContainerBottomSheetBehavior.this.b(view, f2) && (view.getTop() > ContainerBottomSheetBehavior.this.Yq || Math.abs(f) < Math.abs(f2))) {
                i = ContainerBottomSheetBehavior.this.Yz;
                i2 = 5;
            } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                int top = view.getTop();
                if (ContainerBottomSheetBehavior.this.Yi) {
                    if (ContainerBottomSheetBehavior.this.c(view, f2)) {
                        i = ContainerBottomSheetBehavior.this.Yo;
                        i2 = 3;
                    } else {
                        i = ContainerBottomSheetBehavior.this.Yq;
                        i2 = 4;
                    }
                } else if (top < ContainerBottomSheetBehavior.this.Yp) {
                    if (top >= Math.abs(top - ContainerBottomSheetBehavior.this.Yq)) {
                        i = ContainerBottomSheetBehavior.this.Yp;
                    }
                    i2 = 3;
                } else if (Math.abs(top - ContainerBottomSheetBehavior.this.Yp) < Math.abs(top - ContainerBottomSheetBehavior.this.Yq)) {
                    i = ContainerBottomSheetBehavior.this.Yp;
                } else {
                    i = ContainerBottomSheetBehavior.this.Yq;
                    i2 = 4;
                }
            } else if (ContainerBottomSheetBehavior.this.c(view, f2)) {
                i = ContainerBottomSheetBehavior.this.tg();
                i2 = 3;
            } else {
                i = ContainerBottomSheetBehavior.this.Yq;
                i2 = 4;
            }
            if (!ContainerBottomSheetBehavior.this.Yu.settleCapturedViewAt(view.getLeft(), i)) {
                ContainerBottomSheetBehavior.this.aY(i2);
                return;
            }
            ContainerBottomSheetBehavior.this.aY(2);
            ContainerBottomSheetBehavior containerBottomSheetBehavior = ContainerBottomSheetBehavior.this;
            containerBottomSheetBehavior.YM = new c(view, i2);
            c cVar = ContainerBottomSheetBehavior.this.YM;
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            view.postOnAnimation(cVar);
        }

        @Override // com.kwad.components.core.page.widget.halfContainer.h.a
        public final int th() {
            return ContainerBottomSheetBehavior.this.Ys ? ContainerBottomSheetBehavior.this.Yz : ContainerBottomSheetBehavior.this.Yq;
        }

        @Override // com.kwad.components.core.page.widget.halfContainer.h.a
        public final boolean tryCaptureView(View view, int i) {
            View view2;
            if (ContainerBottomSheetBehavior.this.mState == 1 || ContainerBottomSheetBehavior.this.YF) {
                return false;
            }
            return ((ContainerBottomSheetBehavior.this.mState == 3 && ContainerBottomSheetBehavior.this.YD == i && (view2 = ContainerBottomSheetBehavior.this.YB.get()) != null && view2.canScrollVertically(-1)) || ContainerBottomSheetBehavior.this.YA == null || ContainerBottomSheetBehavior.this.YA.get() != view) ? false : true;
        }
    };

    public interface a {
        void aV(int i);

        void g(float f);
    }

    public class c implements Runnable {
        private final int YR;
        private final View mView;

        public c(View view, int i) {
            this.mView = view;
            this.YR = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h hVar = ContainerBottomSheetBehavior.this.Yu;
            if (hVar != null && hVar.continueSettling(true)) {
                View view = this.mView;
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                view.postOnAnimation(this);
            } else {
                ContainerBottomSheetBehavior.this.aY(this.YR);
                if (ContainerBottomSheetBehavior.this.YM == this) {
                    ContainerBottomSheetBehavior.this.YM = null;
                }
            }
        }
    }

    public ContainerBottomSheetBehavior() {
    }

    private View C(View view) {
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (CmUvjW.B25kr6(view)) {
            if (view.getVisibility() == 0) {
                return view;
            }
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View C = C(viewGroup.getChildAt(i));
                if (C != null) {
                    return C;
                }
            }
        }
        return null;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private void aO(boolean z) {
        WeakReference<V> weakReference = this.YA;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.YG != null) {
                    return;
                } else {
                    this.YG = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.YA.get()) {
                    if (z) {
                        this.YG.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                        childAt.setImportantForAccessibility(4);
                    } else {
                        Map<View, Integer> map = this.YG;
                        if (map != null && map.containsKey(childAt)) {
                            int intValue = this.YG.get(childAt).intValue();
                            WeakHashMap weakHashMap2 = DG07BK.f1680A2egSU;
                            childAt.setImportantForAccessibility(intValue);
                        }
                    }
                }
            }
            if (z) {
                return;
            }
            this.YG = null;
        }
    }

    private void aZ(int i) {
        if (i == 3) {
            this.YL = true;
        } else if (i == 4 || i == 5 || i == 6) {
            this.YL = false;
        }
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.WN;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.Yj);
        return this.WN.getYVelocity(this.YD);
    }

    private void reset() {
        this.YD = -1;
        VelocityTracker velocityTracker = this.WN;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.WN = null;
        }
    }

    private void setFitToContents(boolean z) {
        if (this.Yi == z) {
            return;
        }
        this.Yi = z;
        if (this.YA != null) {
            tf();
        }
        aY((this.Yi && this.mState == 6) ? 3 : this.mState);
    }

    private void setSkipCollapsed(boolean z) {
        this.Yt = z;
    }

    private void tf() {
        if (this.Yi) {
            this.Yq = Math.max(this.Yz - this.Yn, this.Yo);
        } else {
            this.Yq = this.Yz - this.Yn;
        }
    }

    public final void aY(int i) {
        a aVar;
        if (this.mState == i) {
            return;
        }
        this.mState = i;
        aZ(i);
        if (i == 6 || i == 3) {
            aO(true);
        } else if (i == 5 || i == 4) {
            aO(false);
        }
        if (this.YA.get() == null || (aVar = this.YC) == null) {
            return;
        }
        aVar.aV(i);
    }

    public final void ba(int i) {
        if (this.YA.get() == null || this.YC == null) {
            return;
        }
        int i2 = this.Yq;
        int tg = i > i2 ? this.Yz - i2 : i2 - tg();
        if (tg != 0) {
            this.Yr = (this.Yq - i) / tg;
        }
        this.YC.g(this.Yr);
    }

    public final void k(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.Yq;
        } else if (i == 6) {
            i2 = this.Yp;
            if (this.Yi && i2 <= (i3 = this.Yo)) {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = tg();
        } else {
            if (!this.Ys || i != 5) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Illegal mState argument: "));
            }
            i2 = this.Yz;
        }
        if (!this.Yu.smoothSlideViewTo(view, view.getLeft(), i2)) {
            aY(i);
            return;
        }
        aY(2);
        c cVar = new c(view, i);
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        view.postOnAnimation(cVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        h hVar;
        if (!v.isShown()) {
            this.Yv = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.WN == null) {
            this.WN = VelocityTracker.obtain();
        }
        this.WN.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.YE = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.YB;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.AYUAbz(view, x, this.YE)) {
                this.YD = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.YF = true;
            }
            this.Yv = (this.Yw || this.YD != -1 || coordinatorLayout.AYUAbz(v, x, this.YE)) ? false : true;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.YF = false;
            this.YD = -1;
            if (this.Yv) {
                this.Yv = false;
                return false;
            }
        }
        if (!this.Yv && (hVar = this.Yu) != null && hVar.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.YB;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.Yv || this.mState == 1 || coordinatorLayout.AYUAbz(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.Yu == null || Math.abs(((float) this.YE) - motionEvent.getY()) <= ((float) this.Yu.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.AZkASS(i, v);
        this.Yz = coordinatorLayout.getHeight();
        if (this.Yl) {
            if (this.Ym == 0) {
                this.Ym = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            this.Yn = Math.max(this.Ym, this.Yz - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.Yn = this.Yk;
        }
        this.Yo = Math.max(0, this.Yz - v.getHeight());
        this.Yp = this.Yz / 2;
        tf();
        v.getTop();
        int i2 = this.mState;
        if (i2 == 3) {
            DG07BK.AlLFFp(tg(), v);
        } else if (i2 == 6) {
            DG07BK.AlLFFp(this.Yp, v);
        } else if (this.Ys && i2 == 5) {
            DG07BK.AlLFFp(this.Yz, v);
        } else if (i2 == 4) {
            DG07BK.AlLFFp(this.Yq, v);
        } else if (i2 == 1 || i2 == 2) {
            DG07BK.AlLFFp(top - v.getTop(), v);
        }
        if (this.Yu == null) {
            this.Yu = h.a(coordinatorLayout, this.YN);
        }
        this.YA = new WeakReference<>(v);
        this.YB = new WeakReference<>(C(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.YB.get() && this.mState != 3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1 && view == this.YB.get()) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < tg()) {
                    int tg = top - tg();
                    iArr[1] = tg;
                    DG07BK.AlLFFp(-tg, v);
                    aY(3);
                } else {
                    iArr[1] = i2;
                    DG07BK.AlLFFp(-i2, v);
                    aY(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i5 = this.Yq;
                if (i4 <= i5 || this.Ys) {
                    iArr[1] = i2;
                    DG07BK.AlLFFp(-i2, v);
                    aY(1);
                } else {
                    int i6 = top - i5;
                    iArr[1] = i6;
                    DG07BK.AlLFFp(-i6, v);
                    aY(4);
                }
            }
            ba(v.getTop());
            this.Yx = i2;
            this.Yy = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        b bVar = (b) parcelable;
        bVar.getSuperState();
        int i = bVar.mState;
        if (i == 1 || i == 2) {
            this.mState = 4;
        } else {
            this.mState = i;
        }
        aZ(this.mState);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new b(View.BaseSavedState.EMPTY_STATE, this.mState);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.Yx = 0;
        this.Yy = false;
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3 = 3;
        if (v.getTop() == tg()) {
            aY(3);
            return;
        }
        if (this.YC != null) {
            this.YB.get();
        }
        if (view == this.YB.get() && this.Yy) {
            if (this.Yx > 0) {
                if (c(v, getYVelocity())) {
                    i2 = tg();
                } else {
                    i2 = this.Yq;
                    i3 = 4;
                }
            } else if (this.Ys && b(v, getYVelocity())) {
                i2 = this.Yz;
                i3 = 5;
            } else if (this.Yx == 0) {
                int top = v.getTop();
                if (!this.Yi) {
                    int i4 = this.Yp;
                    if (top < i4) {
                        if (top < Math.abs(top - this.Yq)) {
                            i2 = 0;
                        } else {
                            i2 = this.Yp;
                        }
                    } else if (Math.abs(top - i4) < Math.abs(top - this.Yq)) {
                        i2 = this.Yp;
                    } else {
                        i2 = this.Yq;
                        i3 = 4;
                    }
                    i3 = 6;
                } else if (c(v, getYVelocity())) {
                    i2 = this.Yo;
                } else {
                    i2 = this.Yq;
                    i3 = 4;
                }
            } else if (c(v, getYVelocity())) {
                i2 = tg();
            } else {
                i2 = this.Yq;
                i3 = 4;
            }
            if (this.Yu.smoothSlideViewTo(v, v.getLeft(), i2)) {
                aY(2);
                c cVar = new c(v, i3);
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                v.postOnAnimation(cVar);
            } else {
                aY(i3);
            }
            this.Yy = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        h hVar = this.Yu;
        if (hVar != null) {
            hVar.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.WN == null) {
            this.WN = VelocityTracker.obtain();
        }
        this.WN.addMovement(motionEvent);
        if (actionMasked == 2 && !this.Yv && this.Yu != null && Math.abs(this.YE - motionEvent.getY()) > this.Yu.getTouchSlop()) {
            this.Yu.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.Yv;
    }

    public final void setHideable(boolean z) {
        this.Ys = z;
    }

    public final void setPeekHeight(int i) {
        WeakReference<V> weakReference;
        V v;
        if (i == -1) {
            if (this.Yl) {
                return;
            } else {
                this.Yl = true;
            }
        } else {
            if (!this.Yl && this.Yk == i) {
                return;
            }
            this.Yl = false;
            this.Yk = Math.max(0, i);
            this.Yq = this.Yz - i;
        }
        if (this.mState != 4 || (weakReference = this.YA) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public final void setState(final int i) {
        if (i == this.mState) {
            return;
        }
        WeakReference<V> weakReference = this.YA;
        if (weakReference == null) {
            if (i == 4 || i == 3 || i == 6 || (this.Ys && i == 5)) {
                this.mState = i;
                aZ(i);
                return;
            }
            return;
        }
        final V v = weakReference.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            if (v.isAttachedToWindow()) {
                v.post(new Runnable() { // from class: com.kwad.components.core.page.widget.halfContainer.ContainerBottomSheetBehavior.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContainerBottomSheetBehavior.this.k(v, i);
                    }
                });
                return;
            }
        }
        k(v, i);
    }

    public final int tg() {
        if (this.Yi) {
            return this.Yo;
        }
        return 0;
    }

    public static class b extends A4TApA {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() { // from class: com.kwad.components.core.page.widget.halfContainer.ContainerBottomSheetBehavior.b.1
            private static b a(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            private static b[] bd(int i) {
                return new b[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return bd(i);
            }

            private static b a(Parcel parcel) {
                return new b(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return a(parcel, classLoader);
            }
        };
        final int mState;

        static {
            QwFAwtk();
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mState = parcel.readInt();
        }

        private static /* synthetic */ void QwFAwtk() {
            char[] charArray = "\u0011\u001d\u001f\\\u0015\u0013\u001f\u0017\\\u0010\u001d\u000b\\\u0001\u001a\u0017\u001e\u001e\\8\u001c\u001b0\u0000\u001b\u0016\u0015\u0017".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'r');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0011\u001e\u001b\u001c\u001b\u0006".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'r');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // CmUvjW.A4TApA, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mState);
        }

        public b(Parcelable parcelable, int i) {
            super(parcelable);
            this.mState = i;
        }
    }

    public final boolean b(View view, float f) {
        if (this.Yt) {
            return true;
        }
        if (view.getTop() < this.Yq) {
            return false;
        }
        return Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.Yq)) / ((float) this.Yk) > this.YK;
    }

    public final boolean c(View view, float f) {
        if (view.getTop() > this.Yq) {
            return false;
        }
        int tg = tg();
        float f2 = tg;
        float max = Math.max(f2, (f * (this.YL ? this.YI : this.YH)) + view.getTop());
        if (max == f2) {
            return true;
        }
        int i = this.Yq;
        int i2 = i - tg;
        if (!this.YL) {
            f2 = i;
        }
        float abs = Math.abs(max - f2) / i2;
        return this.YL ? abs <= this.YK : abs >= this.YJ;
    }

    public final void i(float f) {
        this.YK = 0.8f;
    }

    public final void a(a aVar) {
        this.YC = aVar;
    }

    public ContainerBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue != null && (i = peekValue.data) == -1) {
            setPeekHeight(i);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.Yj = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        aZ(this.mState);
    }
}
