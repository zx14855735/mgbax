package com.baidu.mobads.sdk.internal.widget;

import CQhlFr.A5SV6n;
import CQhlFr.AYUAbz;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.DG07BK;
import androidx.recyclerview.widget.DRlcZ9;
import androidx.recyclerview.widget.DXnQ0V;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ViewPager2 extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9860a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = -1;
    static boolean g = true;
    private boolean A;
    private int B;
    int h;
    boolean i;
    RecyclerView j;
    ScrollEventAdapter k;
    AccessibilityProvider l;
    private final Rect m;
    private final Rect n;
    private final int[] o;
    private CompositeOnPageChangeCallback p;
    private RecyclerView.A4TApA q;
    private LinearLayoutManager r;
    private int s;
    private Parcelable t;
    private PagerSnapHelper u;
    private CompositeOnPageChangeCallback v;
    private FakeDrag w;
    private PageTransformerAdapter x;
    private RecyclerView.ADYaiT y;
    private boolean z;

    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public void a(AccessibilityEvent accessibilityEvent) {
        }

        public void b(RecyclerView.A2egSU a2egSU) {
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public boolean handlesLmPerformAccessibilityAction(int i) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onLmInitializeAccessibilityNodeInfo(AYUAbz aYUAbz) {
        }

        public boolean onLmPerformAccessibilityAction(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public String b() {
            throw new IllegalStateException("Not implemented.");
        }

        public void a(RecyclerView.A2egSU a2egSU) {
        }

        public boolean b(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void a(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int i, Bundle bundle) {
            return false;
        }
    }

    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(AYUAbz aYUAbz) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            aYUAbz.AYUAbz(A5SV6n.f1760AZOQYO);
            aYUAbz.AYUAbz(A5SV6n.f1759AYUAbz);
            aYUAbz.AlLFFp(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i) {
            if (handlesLmPerformAccessibilityAction(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.A4TApA {
        @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(1);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(RecyclerView.AaHO0E aaHO0E) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            return offscreenPageLimit == -1 ? super.getExtraLayoutSpace(aaHO0E) : ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
        public void onInitializeAccessibilityNodeInfo(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, AYUAbz aYUAbz) {
            super.onInitializeAccessibilityNodeInfo(dXnQ0V, aaHO0E, aYUAbz);
            ViewPager2.this.l.onLmInitializeAccessibilityNodeInfo(aYUAbz);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
        public boolean performAccessibilityAction(DXnQ0V dXnQ0V, RecyclerView.AaHO0E aaHO0E, int i, Bundle bundle) {
            return ViewPager2.this.l.handlesLmPerformAccessibilityAction(i) ? ViewPager2.this.l.onLmPerformAccessibilityAction(i) : super.performAccessibilityAction(dXnQ0V, aaHO0E, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ARc23Z
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.EPdU4G
        public View findSnapView(RecyclerView.ARc23Z aRc23Z) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(aRc23Z);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
            ViewPager2.this.o[1] = ViewPager2.this.o[0];
            if (1 == ViewPager2.this.getOrientation()) {
                ViewPager2.this.o[0] = i4;
            } else {
                ViewPager2.this.o[0] = i3;
            }
            return super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.l.handlesRvGetAccessibilityClassName() ? ViewPager2.this.l.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.h);
            accessibilityEvent.setToIndex(ViewPager2.this.h);
            ViewPager2.this.l.a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final int f9871a;
        private final RecyclerView b;

        public SmoothScrollToPosition(int i, RecyclerView recyclerView) {
            this.f9871a = i;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollToPosition(this.f9871a);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.A4TApA
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.i = true;
                viewPager2.k.a();
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, (AttributeSet) null);
    }

    private void b(RecyclerView.A2egSU a2egSU) {
        if (a2egSU != null) {
            a2egSU.unregisterAdapterDataObserver(this.q);
        }
    }

    private DRlcZ9 e() {
        return new DRlcZ9() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.DRlcZ9
            public void onChildViewAttachedToWindow(View view) {
                DG07BK dg07bk = (DG07BK) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) dg07bk).width != -1 || ((ViewGroup.MarginLayoutParams) dg07bk).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.DRlcZ9
            public void onChildViewDetachedFromWindow(View view) {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        RecyclerView.A2egSU adapter;
        if (this.s == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.t;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.t = null;
        }
        int max = Math.max(0, Math.min(this.s, adapter.getItemCount() - 1));
        this.h = max;
        this.s = -1;
        this.j.scrollToPosition(max);
        this.l.c();
    }

    public void addItemDecoration(RecyclerView.AMqCpz aMqCpz) {
        this.j.addItemDecoration(aMqCpz);
    }

    public boolean beginFakeDrag() {
        return this.w.b();
    }

    public boolean c() {
        return this.r.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.j.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.j.canScrollVertically(i);
    }

    public void d() {
        View findSnapView = this.u.findSnapView(this.r);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.u.calculateDistanceToFinalSnap(this.r, findSnapView);
        int i = calculateDistanceToFinalSnap[0];
        if (i == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.j.smoothScrollBy(i, calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).f9870a;
            sparseArray.put(this.j.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.w.c();
    }

    public boolean fakeDragBy(@SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.w.a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.l.a() ? this.l.b() : super.getAccessibilityClassName();
    }

    public RecyclerView.A2egSU getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.h;
    }

    public RecyclerView.AMqCpz getItemDecorationAt(int i) {
        return this.j.getItemDecorationAt(i);
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getOrientation() {
        return this.r.getOrientation();
    }

    public int getOverScrolledDirection() {
        int[] iArr = this.o;
        int i = iArr[0];
        return i == 0 ? iArr[1] : i;
    }

    public int getScrollState() {
        return this.k.d();
    }

    public void invalidateItemDecorations() {
        this.j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.w.a();
    }

    public boolean isUserInputEnabled() {
        return this.A;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        this.m.left = getPaddingLeft();
        this.m.right = (i3 - i) - getPaddingRight();
        this.m.top = getPaddingTop();
        this.m.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.m, this.n);
        RecyclerView recyclerView = this.j;
        Rect rect = this.n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.i) {
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChild(this.j, i, i2);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.s = savedState.b;
        this.t = savedState.c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f9870a = this.j.getId();
        int i = this.s;
        if (i == -1) {
            i = this.h;
        }
        savedState.b = i;
        Parcelable parcelable = this.t;
        if (parcelable != null) {
            savedState.c = parcelable;
            return savedState;
        }
        Object adapter = this.j.getAdapter();
        if (adapter instanceof StatefulAdapter) {
            savedState.c = ((StatefulAdapter) adapter).saveState();
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName().concat(" does not support direct child views"));
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return this.l.a(i, bundle) ? this.l.b(i, bundle) : super.performAccessibilityAction(i, bundle);
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.p.a(onPageChangeCallback);
    }

    public void removeItemDecoration(RecyclerView.AMqCpz aMqCpz) {
        this.j.removeItemDecoration(aMqCpz);
    }

    public void removeItemDecorationAt(int i) {
        this.j.removeItemDecorationAt(i);
    }

    public void requestTransform() {
        if (this.x.a() == null) {
            return;
        }
        double h = this.k.h();
        int i = (int) h;
        float f2 = (float) (h - i);
        this.x.onPageScrolled(i, f2, Math.round(b() * f2));
    }

    public void setAdapter(RecyclerView.A2egSU a2egSU) {
        RecyclerView.A2egSU adapter = this.j.getAdapter();
        this.l.b(adapter);
        b(adapter);
        this.j.setAdapter(a2egSU);
        this.h = 0;
        f();
        this.l.a(a2egSU);
        a(a2egSU);
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.l.g();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.B = i;
        this.j.requestLayout();
    }

    public void setOnOverScrollListener(final OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5

            /* renamed from: a, reason: collision with root package name */
            boolean f9865a = false;
            boolean b = false;
            boolean c = false;

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                if (i != 0) {
                    if (i == 1) {
                        this.c = true;
                        return;
                    } else {
                        if (i != 2) {
                            return;
                        }
                        this.f9865a = false;
                        this.b = false;
                        return;
                    }
                }
                RecyclerView.A2egSU adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 0 || !this.c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (!ViewPager2.this.canScrollVertically(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollVertically(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (!ViewPager2.this.canScrollHorizontally(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollHorizontally(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                }
                this.c = false;
            }
        });
    }

    public void setOrientation(int i) {
        this.r.setOrientation(i);
        this.l.d();
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.z) {
                this.y = this.j.getItemAnimator();
                this.z = true;
            }
            this.j.setItemAnimator(null);
        } else if (this.z) {
            this.j.setItemAnimator(this.y);
            this.y = null;
            this.z = false;
        }
        if (pageTransformer == this.x.a()) {
            return;
        }
        this.x.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.A = z;
        this.l.f();
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.p.b(onPageChangeCallback);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f9870a;
        int b;
        Parcelable c;

        static {
            wmSOWTI();
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f9870a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
        }

        private static /* synthetic */ void wmSOWTI() {
            char[] charArray = "öúø»òôøð»÷úì»æýðùù»ßûü×çüñòð".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 149);
            }
            String str = new String(charArray);
            char[] charArray2 = "öùüûüá".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 149);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f9870a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
        this.j.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.r = linearLayoutManagerImpl;
        this.j.setLayoutManager(linearLayoutManagerImpl);
        this.j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.k = scrollEventAdapter;
        this.w = new FakeDrag(this, scrollEventAdapter, this.j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.u = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.j);
        this.j.addOnScrollListener(this.k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.v = compositeOnPageChangeCallback;
        this.k.a(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.h != i) {
                    viewPager2.h = i;
                    viewPager2.l.e();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.j.requestFocus(2);
                }
            }
        };
        this.v.a(onPageChangeCallback);
        this.v.a(onPageChangeCallback2);
        this.l.a(this.v, this.j);
        this.v.a(this.p);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.r);
        this.x = pageTransformerAdapter;
        this.v.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public void addItemDecoration(RecyclerView.AMqCpz aMqCpz, int i) {
        this.j.addItemDecoration(aMqCpz, i);
    }

    public int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i, boolean z) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        a(i, z);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.A4TApA
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.i = true;
                viewPager2.k.a();
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.A4TApA
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.i = true;
                viewPager2.k.a();
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    private void a(RecyclerView.A2egSU a2egSU) {
        if (a2egSU != null) {
            a2egSU.registerAdapterDataObserver(this.q);
        }
    }

    public void a() {
        PagerSnapHelper pagerSnapHelper = this.u;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.r);
            if (findSnapView == null) {
                return;
            }
            int position = this.r.getPosition(findSnapView);
            if (position != this.h && getScrollState() == 0) {
                this.v.onPageSelected(position);
            }
            this.i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void a(int i, boolean z) {
        RecyclerView.A2egSU adapter = getAdapter();
        if (adapter == null) {
            if (this.s != -1) {
                this.s = Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
        if (min == this.h && this.k.e()) {
            return;
        }
        int i2 = this.h;
        if (min == i2 && z) {
            return;
        }
        double d2 = i2;
        this.h = min;
        this.l.e();
        if (!this.k.e()) {
            d2 = this.k.h();
        }
        this.k.a(min, z);
        if (!z) {
            this.j.scrollToPosition(min);
            return;
        }
        double d3 = min;
        if (Math.abs(d3 - d2) > 3.0d) {
            this.j.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
            RecyclerView recyclerView = this.j;
            recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
            return;
        }
        this.j.smoothScrollToPosition(min);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.m = new Rect();
        this.n = new Rect();
        this.o = new int[2];
        this.p = new CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.A4TApA
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.i = true;
                viewPager2.k.a();
            }
        };
        this.s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }
}
