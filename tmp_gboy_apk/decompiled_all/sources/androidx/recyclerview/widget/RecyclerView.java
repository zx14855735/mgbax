package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.R$styleable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RecyclerView extends ViewGroup implements COJEAR.B9tovu {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled;
    static final De4eam sDefaultEdgeEffectFactory;
    static final Interpolator sQuinticInterpolator;
    static boolean sVerboseLoggingEnabled;
    DvK7DB mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    A2egSU mAdapter;
    androidx.recyclerview.widget.A4TApA mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private D6DOie mChildDrawingOrderCallback;
    androidx.recyclerview.widget.ARc23Z mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private A5SV6n mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    BTvldC mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private DUi7mC mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ADYaiT mItemAnimator;
    private D6yqiO mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<AMqCpz> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    ARc23Z mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final DaOi9o mObserver;
    private List<DRlcZ9> mOnChildAttachStateListeners;
    private ASJ6gh mOnFlingListener;
    private final ArrayList<DUi7mC> mOnItemTouchListeners;
    final List<Dphsd2> mPendingAccessibilityImportanceChange;
    DcUJf1 mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    BNL6CD mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final DXnQ0V mRecycler;
    DXuj49 mRecyclerListener;
    final List<DXuj49> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private AYUAbz mScrollListener;
    private List<AYUAbz> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private COJEAR.BChYOn mScrollingChildHelper;
    final AaHO0E mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final DjONCG mViewFlinger;
    private final ExjC7D mViewInfoProcessCallback;
    final F1loUV mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));

    public static abstract class A4TApA {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    public static class A5SV6n {
        public EdgeEffect A2egSU(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ADYaiT {

        /* renamed from: A2egSU, reason: collision with root package name */
        public D6yqiO f9426A2egSU = null;

        /* renamed from: A4TApA, reason: collision with root package name */
        public final ArrayList f9427A4TApA = new ArrayList();

        /* renamed from: A5SV6n, reason: collision with root package name */
        public long f9428A5SV6n = 120;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public long f9429ADYaiT = 120;
        public long AMqCpz = 250;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public long f9430ARc23Z = 250;

        public static class A2egSU {

            /* renamed from: A2egSU, reason: collision with root package name */
            public int f9431A2egSU;

            /* renamed from: A4TApA, reason: collision with root package name */
            public int f9432A4TApA;
        }

        public static int AMqCpz(Dphsd2 dphsd2) {
            int i = dphsd2.mFlags;
            int i2 = i & 14;
            if (dphsd2.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = dphsd2.getOldPosition();
                int absoluteAdapterPosition = dphsd2.getAbsoluteAdapterPosition();
                if (oldPosition != -1 && absoluteAdapterPosition != -1 && oldPosition != absoluteAdapterPosition) {
                    return i2 | 2048;
                }
            }
            return i2;
        }

        public abstract boolean A2egSU(Dphsd2 dphsd2, A2egSU a2egSU, A2egSU a2egSU2);

        public abstract boolean A4TApA(Dphsd2 dphsd2, Dphsd2 dphsd22, A2egSU a2egSU, A2egSU a2egSU2);

        public abstract boolean A5SV6n(Dphsd2 dphsd2, A2egSU a2egSU, A2egSU a2egSU2);

        public abstract boolean ADYaiT(Dphsd2 dphsd2, A2egSU a2egSU, A2egSU a2egSU2);

        public boolean ARc23Z(Dphsd2 dphsd2) {
            return true;
        }

        public boolean ASJ6gh(Dphsd2 dphsd2, List list) {
            return ARc23Z(dphsd2);
        }

        public final void AYUAbz(Dphsd2 dphsd2) {
            D6yqiO d6yqiO = this.f9426A2egSU;
            if (d6yqiO != null) {
                D8MqeW d8MqeW = (D8MqeW) d6yqiO;
                d8MqeW.getClass();
                dphsd2.setIsRecyclable(true);
                if (dphsd2.mShadowedHolder != null && dphsd2.mShadowingHolder == null) {
                    dphsd2.mShadowedHolder = null;
                }
                dphsd2.mShadowingHolder = null;
                if (dphsd2.shouldBeKeptAsChild()) {
                    return;
                }
                View view = dphsd2.itemView;
                RecyclerView recyclerView = d8MqeW.f9340A2egSU;
                if (recyclerView.removeAnimatingView(view) || !dphsd2.isTmpDetached()) {
                    return;
                }
                recyclerView.removeDetachedView(dphsd2.itemView, false);
            }
        }

        public abstract void AZOQYO(Dphsd2 dphsd2);

        public abstract void AZkASS();

        public abstract boolean AaHO0E();

        public abstract void AcNBzu();
    }

    public static abstract class AMqCpz {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, AaHO0E aaHO0E) {
            getItemOffsets(rect, ((DG07BK) view.getLayoutParams()).f9343A2egSU.getLayoutPosition(), recyclerView);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, AaHO0E aaHO0E) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, AaHO0E aaHO0E) {
            onDrawOver(canvas, recyclerView);
        }
    }

    public static abstract class ARc23Z {
        boolean mAutoMeasure;
        androidx.recyclerview.widget.ARc23Z mChildHelper;
        private int mHeight;
        private int mHeightMode;
        EsrwYR mHorizontalBoundCheck;
        private final ErKPGd mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;
        AZkASS mSmoothScroller;
        EsrwYR mVerticalBoundCheck;
        private final ErKPGd mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public static class A2egSU {

            /* renamed from: A2egSU, reason: collision with root package name */
            public int f9433A2egSU;

            /* renamed from: A4TApA, reason: collision with root package name */
            public int f9434A4TApA;

            /* renamed from: A5SV6n, reason: collision with root package name */
            public boolean f9435A5SV6n;

            /* renamed from: ADYaiT, reason: collision with root package name */
            public boolean f9436ADYaiT;
        }

        public ARc23Z() {
            D8cQ8b d8cQ8b = new D8cQ8b(this);
            this.mHorizontalBoundCheckCallback = d8cQ8b;
            D9tr6l d9tr6l = new D9tr6l(this);
            this.mVerticalBoundCheckCallback = d9tr6l;
            this.mHorizontalBoundCheck = new EsrwYR(d8cQ8b);
            this.mVerticalBoundCheck = new EsrwYR(d9tr6l);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        public static boolean A4TApA(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            if (r3 >= 0) goto L5;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L11
                if (r3 < 0) goto Lf
            Lc:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L21
            Lf:
                r3 = 0
                goto L21
            L11:
                if (r3 < 0) goto L14
                goto Lc
            L14:
                r4 = -1
                if (r3 != r4) goto L1b
                r2 = 1073741824(0x40000000, float:2.0)
            L19:
                r3 = r1
                goto L21
            L1b:
                r4 = -2
                if (r3 != r4) goto Lf
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L19
            L21:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.ARc23Z.getChildMeasureSpec(int, int, int, boolean):int");
        }

        public static A2egSU getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            A2egSU a2egSU = new A2egSU();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f9159A2egSU, i, i2);
            a2egSU.f9433A2egSU = obtainStyledAttributes.getInt(0, 1);
            a2egSU.f9434A4TApA = obtainStyledAttributes.getInt(10, 1);
            a2egSU.f9435A5SV6n = obtainStyledAttributes.getBoolean(9, false);
            a2egSU.f9436ADYaiT = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
            return a2egSU;
        }

        public final void A2egSU(View view, int i, boolean z) {
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                B25kr6.AzWtSf azWtSf = this.mRecyclerView.mViewInfoStore.f9406A2egSU;
                EwN40Z ewN40Z = (EwN40Z) azWtSf.get(childViewHolderInt);
                if (ewN40Z == null) {
                    ewN40Z = EwN40Z.A2egSU();
                    azWtSf.put(childViewHolderInt, ewN40Z);
                }
                ewN40Z.f9403A2egSU |= 1;
            } else {
                this.mRecyclerView.mViewInfoStore.A5SV6n(childViewHolderInt);
            }
            DG07BK dg07bk = (DG07BK) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.A4TApA(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int AZkASS2 = this.mChildHelper.AZkASS(view);
                if (i == -1) {
                    i = this.mChildHelper.AMqCpz();
                }
                if (AZkASS2 == -1) {
                    StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.mRecyclerView.indexOfChild(view));
                    throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this.mRecyclerView, sb));
                }
                if (AZkASS2 != i) {
                    this.mRecyclerView.mLayout.moveView(AZkASS2, i);
                }
            } else {
                this.mChildHelper.A2egSU(view, i, false);
                dg07bk.f9345A5SV6n = true;
                AZkASS aZkASS = this.mSmoothScroller;
                if (aZkASS != null && aZkASS.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (dg07bk.f9346ADYaiT) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Objects.toString(dg07bk.f9343A2egSU);
                }
                childViewHolderInt.itemView.invalidate();
                dg07bk.f9346ADYaiT = false;
            }
        }

        public final void A5SV6n(DXnQ0V dXnQ0V, int i, View view) {
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    childViewHolderInt.toString();
                }
            } else if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                dXnQ0V.AaHO0E(childViewHolderInt);
            } else {
                detachViewAt(i);
                dXnQ0V.AcNBzu(view);
                this.mRecyclerView.mViewInfoStore.A5SV6n(childViewHolderInt);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i, DG07BK dg07bk) {
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                B25kr6.AzWtSf azWtSf = this.mRecyclerView.mViewInfoStore.f9406A2egSU;
                EwN40Z ewN40Z = (EwN40Z) azWtSf.get(childViewHolderInt);
                if (ewN40Z == null) {
                    ewN40Z = EwN40Z.A2egSU();
                    azWtSf.put(childViewHolderInt, ewN40Z);
                }
                ewN40Z.f9403A2egSU |= 1;
            } else {
                this.mRecyclerView.mViewInfoStore.A5SV6n(childViewHolderInt);
            }
            this.mChildHelper.A4TApA(view, i, dg07bk, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(DG07BK dg07bk) {
            return dg07bk != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, AaHO0E aaHO0E, DAk1zC dAk1zC) {
        }

        public void collectInitialPrefetchPositions(int i, DAk1zC dAk1zC) {
        }

        public int computeHorizontalScrollExtent(AaHO0E aaHO0E) {
            return 0;
        }

        public int computeHorizontalScrollOffset(AaHO0E aaHO0E) {
            return 0;
        }

        public int computeHorizontalScrollRange(AaHO0E aaHO0E) {
            return 0;
        }

        public int computeVerticalScrollExtent(AaHO0E aaHO0E) {
            return 0;
        }

        public int computeVerticalScrollOffset(AaHO0E aaHO0E) {
            return 0;
        }

        public int computeVerticalScrollRange(AaHO0E aaHO0E) {
            return 0;
        }

        public void detachAndScrapAttachedViews(DXnQ0V dXnQ0V) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                A5SV6n(dXnQ0V, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, DXnQ0V dXnQ0V) {
            A5SV6n(dXnQ0V, this.mChildHelper.AZkASS(view), view);
        }

        public void detachAndScrapViewAt(int i, DXnQ0V dXnQ0V) {
            A5SV6n(dXnQ0V, i, getChildAt(i));
        }

        public void detachView(View view) {
            int AZkASS2 = this.mChildHelper.AZkASS(view);
            if (AZkASS2 >= 0) {
                this.mChildHelper.A5SV6n(AZkASS2);
            }
        }

        public void detachViewAt(int i) {
            getChildAt(i);
            this.mChildHelper.A5SV6n(i);
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, DXnQ0V dXnQ0V) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, dXnQ0V);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            ADYaiT aDYaiT = this.mRecyclerView.mItemAnimator;
            if (aDYaiT != null) {
                aDYaiT.AZOQYO(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.f9178A5SV6n.contains(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.f9445ASJ6gh || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract DG07BK generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public DG07BK generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof DG07BK ? new DG07BK((DG07BK) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new DG07BK((ViewGroup.MarginLayoutParams) layoutParams) : new DG07BK(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((DG07BK) view.getLayoutParams()).f9344A4TApA.bottom;
        }

        public View getChildAt(int i) {
            androidx.recyclerview.widget.ARc23Z aRc23Z = this.mChildHelper;
            if (aRc23Z != null) {
                return aRc23Z.ADYaiT(i);
            }
            return null;
        }

        public int getChildCount() {
            androidx.recyclerview.widget.ARc23Z aRc23Z = this.mChildHelper;
            if (aRc23Z != null) {
                return aRc23Z.AMqCpz();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((DG07BK) view.getLayoutParams()).f9344A4TApA;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((DG07BK) view.getLayoutParams()).f9344A4TApA;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.f9178A5SV6n.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            A2egSU adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            return recyclerView.getLayoutDirection();
        }

        public int getLeftDecorationWidth(View view) {
            return ((DG07BK) view.getLayoutParams()).f9344A4TApA.left;
        }

        public int getMinimumHeight() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            return recyclerView.getMinimumHeight();
        }

        public int getMinimumWidth() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            return recyclerView.getMinimumWidth();
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return 0;
            }
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            return recyclerView.getPaddingEnd();
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return 0;
            }
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            return recyclerView.getPaddingStart();
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((DG07BK) view.getLayoutParams()).f9343A2egSU.getLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((DG07BK) view.getLayoutParams()).f9344A4TApA.right;
        }

        public int getRowCountForAccessibility(DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
            return -1;
        }

        public int getSelectionModeForAccessibility(DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((DG07BK) view.getLayoutParams()).f9344A4TApA.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((DG07BK) view.getLayoutParams()).f9344A4TApA;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(this.mRecyclerView, new StringBuilder("View should be fully attached to be ignored")));
            }
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(r.b.d);
            this.mRecyclerView.mViewInfoStore.ADYaiT(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            AZkASS aZkASS = this.mSmoothScroller;
            return aZkASS != null && aZkASS.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.A4TApA(view) && this.mVerticalBoundCheck.A4TApA(view);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((DG07BK) view.getLayoutParams()).f9344A4TApA;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            DG07BK dg07bk = (DG07BK) view.getLayoutParams();
            Rect rect = dg07bk.f9344A4TApA;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) dg07bk).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            DG07BK dg07bk = (DG07BK) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i3, ((ViewGroup.MarginLayoutParams) dg07bk).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i4, ((ViewGroup.MarginLayoutParams) dg07bk).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, dg07bk)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            DG07BK dg07bk = (DG07BK) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin + i3, ((ViewGroup.MarginLayoutParams) dg07bk).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) dg07bk).topMargin + ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) dg07bk).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, dg07bk)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(A2egSU a2egSU, A2egSU a2egSU2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i, DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(CQhlFr.AYUAbz aYUAbz) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, aYUAbz);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, CQhlFr.AYUAbz aYUAbz) {
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved()) {
                return;
            }
            androidx.recyclerview.widget.ARc23Z aRc23Z = this.mChildHelper;
            if (aRc23Z.f9178A5SV6n.contains(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, aYUAbz);
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onLayoutChildren(DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
        }

        public void onLayoutCompleted(AaHO0E aaHO0E) {
        }

        public void onMeasure(DXnQ0V dXnQ0V, AaHO0E aaHO0E, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public void onSmoothScrollerStopped(AZkASS aZkASS) {
            if (this.mSmoothScroller == aZkASS) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityActionForItem(DXnQ0V dXnQ0V, AaHO0E aaHO0E, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                recyclerView.postOnAnimation(runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.AaHO0E(childCount);
            }
        }

        public void removeAndRecycleAllViews(DXnQ0V dXnQ0V) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, dXnQ0V);
                }
            }
        }

        public void removeAndRecycleScrapInt(DXnQ0V dXnQ0V) {
            ArrayList arrayList;
            int size = dXnQ0V.f9351A2egSU.size();
            int i = size - 1;
            while (true) {
                arrayList = dXnQ0V.f9351A2egSU;
                if (i < 0) {
                    break;
                }
                View view = ((Dphsd2) arrayList.get(i)).itemView;
                Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    ADYaiT aDYaiT = this.mRecyclerView.mItemAnimator;
                    if (aDYaiT != null) {
                        aDYaiT.AZOQYO(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    Dphsd2 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    dXnQ0V.AaHO0E(childViewHolderInt2);
                }
                i--;
            }
            arrayList.clear();
            ArrayList arrayList2 = dXnQ0V.f9352A4TApA;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, DXnQ0V dXnQ0V) {
            removeView(view);
            dXnQ0V.AZkASS(view);
        }

        public void removeAndRecycleViewAt(int i, DXnQ0V dXnQ0V) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            dXnQ0V.AZkASS(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            androidx.recyclerview.widget.ARc23Z aRc23Z = this.mChildHelper;
            CSDoyG cSDoyG = aRc23Z.f9176A2egSU;
            int i = aRc23Z.f9179ADYaiT;
            if (i == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                aRc23Z.f9179ADYaiT = 1;
                aRc23Z.AMqCpz = view;
                int indexOfChild = ((RecyclerView) cSDoyG.f9324A2egSU).indexOfChild(view);
                if (indexOfChild >= 0) {
                    if (aRc23Z.f9177A4TApA.AMqCpz(indexOfChild)) {
                        aRc23Z.AcNBzu(view);
                    }
                    cSDoyG.A2egSU(indexOfChild);
                }
                aRc23Z.f9179ADYaiT = 0;
                aRc23Z.AMqCpz = null;
            } catch (Throwable th) {
                aRc23Z.f9179ADYaiT = 0;
                aRc23Z.AMqCpz = null;
                throw th;
            }
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.AaHO0E(i);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x00b3, code lost:
        
            if ((r5.bottom - r10) > r2) goto L28;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
            /*
                r8 = this;
                int r0 = r8.getPaddingLeft()
                int r1 = r8.getPaddingTop()
                int r2 = r8.getWidth()
                int r3 = r8.getPaddingRight()
                int r2 = r2 - r3
                int r3 = r8.getHeight()
                int r4 = r8.getPaddingBottom()
                int r3 = r3 - r4
                int r4 = r10.getLeft()
                int r5 = r11.left
                int r4 = r4 + r5
                int r5 = r10.getScrollX()
                int r4 = r4 - r5
                int r5 = r10.getTop()
                int r6 = r11.top
                int r5 = r5 + r6
                int r10 = r10.getScrollY()
                int r5 = r5 - r10
                int r10 = r11.width()
                int r10 = r10 + r4
                int r11 = r11.height()
                int r11 = r11 + r5
                int r4 = r4 - r0
                r0 = 0
                int r6 = java.lang.Math.min(r0, r4)
                int r5 = r5 - r1
                int r1 = java.lang.Math.min(r0, r5)
                int r10 = r10 - r2
                int r2 = java.lang.Math.max(r0, r10)
                int r11 = r11 - r3
                int r11 = java.lang.Math.max(r0, r11)
                int r3 = r8.getLayoutDirection()
                r7 = 1
                if (r3 != r7) goto L60
                if (r2 == 0) goto L5b
                goto L68
            L5b:
                int r2 = java.lang.Math.max(r6, r10)
                goto L68
            L60:
                if (r6 == 0) goto L63
                goto L67
            L63:
                int r6 = java.lang.Math.min(r4, r2)
            L67:
                r2 = r6
            L68:
                if (r1 == 0) goto L6b
                goto L6f
            L6b:
                int r1 = java.lang.Math.min(r5, r11)
            L6f:
                int[] r10 = new int[]{r2, r1}
                r11 = r10[r0]
                r10 = r10[r7]
                if (r13 == 0) goto Lb6
                android.view.View r13 = r9.getFocusedChild()
                if (r13 != 0) goto L80
                goto Lbb
            L80:
                int r1 = r8.getPaddingLeft()
                int r2 = r8.getPaddingTop()
                int r3 = r8.getWidth()
                int r4 = r8.getPaddingRight()
                int r3 = r3 - r4
                int r4 = r8.getHeight()
                int r5 = r8.getPaddingBottom()
                int r4 = r4 - r5
                androidx.recyclerview.widget.RecyclerView r5 = r8.mRecyclerView
                android.graphics.Rect r5 = r5.mTempRect
                r8.getDecoratedBoundsWithMargins(r13, r5)
                int r13 = r5.left
                int r13 = r13 - r11
                if (r13 >= r3) goto Lbb
                int r13 = r5.right
                int r13 = r13 - r11
                if (r13 <= r1) goto Lbb
                int r13 = r5.top
                int r13 = r13 - r10
                if (r13 >= r4) goto Lbb
                int r13 = r5.bottom
                int r13 = r13 - r10
                if (r13 > r2) goto Lb6
                goto Lbb
            Lb6:
                if (r11 != 0) goto Lbc
                if (r10 == 0) goto Lbb
                goto Lbc
            Lbb:
                return r0
            Lbc:
                if (r12 == 0) goto Lc2
                r9.scrollBy(r11, r10)
                goto Lc5
            Lc2:
                r9.smoothScrollBy(r11, r10)
            Lc5:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.ARc23Z.requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
            return 0;
        }

        public void scrollToPosition(int i) {
            int i2 = RecyclerView.HORIZONTAL;
        }

        public int scrollVerticallyBy(int i, DXnQ0V dXnQ0V, AaHO0E aaHO0E) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.AzWtSf();
                }
            }
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i, int i2, DG07BK dg07bk) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && A4TApA(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) dg07bk).width) && A4TApA(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) dg07bk).height)) ? false : true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i, int i2, DG07BK dg07bk) {
            return (this.mMeasurementCacheEnabled && A4TApA(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) dg07bk).width) && A4TApA(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) dg07bk).height)) ? false : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, AaHO0E aaHO0E, int i) {
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(AZkASS aZkASS) {
            AZkASS aZkASS2 = this.mSmoothScroller;
            if (aZkASS2 != null && aZkASS != aZkASS2 && aZkASS2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = aZkASS;
            aZkASS.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            Dphsd2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            AZkASS aZkASS = this.mSmoothScroller;
            if (aZkASS != null) {
                aZkASS.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i) {
            A2egSU(view, i, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i) {
            A2egSU(view, i, false);
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, DXnQ0V dXnQ0V) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(DXnQ0V dXnQ0V, AaHO0E aaHO0E, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            A2egSU a2egSU = this.mRecyclerView.mAdapter;
            if (a2egSU != null) {
                accessibilityEvent.setItemCount(a2egSU.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(DXnQ0V dXnQ0V, AaHO0E aaHO0E, CQhlFr.AYUAbz aYUAbz) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                aYUAbz.A2egSU(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                aYUAbz.AlLFFp(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                aYUAbz.A2egSU(f.a.c);
                aYUAbz.AlLFFp(true);
            }
            AZkASS.ARc23Z BJ7GGh2 = AZkASS.ARc23Z.BJ7GGh(getRowCountForAccessibility(dXnQ0V, aaHO0E), getColumnCountForAccessibility(dXnQ0V, aaHO0E), getSelectionModeForAccessibility(dXnQ0V, aaHO0E), isLayoutHierarchical(dXnQ0V, aaHO0E));
            aYUAbz.getClass();
            aYUAbz.f1773A2egSU.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) BJ7GGh2.f451AlLFFp);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, AaHO0E aaHO0E, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(DXnQ0V dXnQ0V, AaHO0E aaHO0E, int i, Bundle bundle) {
            int paddingTop;
            int paddingLeft;
            int i2;
            int i3;
            if (this.mRecyclerView == null) {
                return false;
            }
            int height = getHeight();
            int width = getWidth();
            Rect rect = new Rect();
            if (this.mRecyclerView.getMatrix().isIdentity() && this.mRecyclerView.getGlobalVisibleRect(rect)) {
                height = rect.height();
                width = rect.width();
            }
            if (i == 4096) {
                paddingTop = this.mRecyclerView.canScrollVertically(1) ? (height - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
                    i2 = paddingTop;
                    i3 = paddingLeft;
                }
                i2 = paddingTop;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                paddingTop = this.mRecyclerView.canScrollVertically(-1) ? -((height - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    paddingLeft = -((width - getPaddingLeft()) - getPaddingRight());
                    i2 = paddingTop;
                    i3 = paddingLeft;
                }
                i2 = paddingTop;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1e
                if (r7 < 0) goto L13
            L10:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L13:
                if (r7 != r1) goto L1b
                if (r5 == r2) goto L23
                if (r5 == 0) goto L1b
                if (r5 == r3) goto L23
            L1b:
                r5 = 0
                r7 = 0
                goto L31
            L1e:
                if (r7 < 0) goto L21
                goto L10
            L21:
                if (r7 != r1) goto L25
            L23:
                r7 = r4
                goto L31
            L25:
                if (r7 != r0) goto L1b
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2c
                goto L2e
            L2c:
                r5 = 0
                goto L23
            L2e:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L23
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.ARc23Z.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        @SuppressLint({"UnknownNullness"})
        public DG07BK generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new DG07BK(context, attributeSet);
        }

        public void onInitializeAccessibilityNodeInfoForItem(DXnQ0V dXnQ0V, AaHO0E aaHO0E, View view, CQhlFr.AYUAbz aYUAbz) {
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(View view, int i) {
            attachView(view, i, (DG07BK) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }
    }

    public static abstract class ASJ6gh {
        public abstract boolean onFling(int i, int i2);
    }

    public static abstract class AYUAbz {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class AZOQYO {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final SparseArray f9437A2egSU = new SparseArray();

        /* renamed from: A4TApA, reason: collision with root package name */
        public int f9438A4TApA = 0;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public final Set f9439A5SV6n = Collections.newSetFromMap(new IdentityHashMap());

        public final DV2E8K A2egSU(int i) {
            SparseArray sparseArray = this.f9437A2egSU;
            DV2E8K dv2e8k = (DV2E8K) sparseArray.get(i);
            if (dv2e8k != null) {
                return dv2e8k;
            }
            DV2E8K dv2e8k2 = new DV2E8K();
            sparseArray.put(i, dv2e8k2);
            return dv2e8k2;
        }
    }

    public static abstract class AZkASS {
        private ARc23Z mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final DdagTj mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        public AZkASS() {
            DdagTj ddagTj = new DdagTj();
            ddagTj.f9364ADYaiT = -1;
            ddagTj.f9365ARc23Z = false;
            ddagTj.f9361A2egSU = 0;
            ddagTj.f9362A4TApA = 0;
            ddagTj.f9363A5SV6n = Integer.MIN_VALUE;
            ddagTj.AMqCpz = null;
            this.mRecyclingAction = ddagTj;
        }

        public PointF computeScrollVectorForPosition(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof Ddcejp) {
                return ((Ddcejp) layoutManager).computeScrollVectorForPosition(i);
            }
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public ARc23Z getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f = computeScrollVectorForPosition.x;
                if (f != 0.0f || computeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.A2egSU(recyclerView);
                    stop();
                } else {
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                DdagTj ddagTj = this.mRecyclingAction;
                boolean z = ddagTj.f9364ADYaiT >= 0;
                ddagTj.A2egSU(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.A4TApA();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
                int i = RecyclerView.HORIZONTAL;
            }
        }

        public abstract void onSeekTargetStep(int i, int i2, AaHO0E aaHO0E, DdagTj ddagTj);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, AaHO0E aaHO0E, DdagTj ddagTj);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public void start(RecyclerView recyclerView, ARc23Z aRc23Z) {
            DjONCG djONCG = recyclerView.mViewFlinger;
            djONCG.f9372B3GDIM.removeCallbacks(djONCG);
            djONCG.f9368AmA8tU.abortAnimation();
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = aRc23Z;
            int i = this.mTargetPosition;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f9440A2egSU = i;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.A4TApA();
            this.mStarted = true;
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f9440A2egSU = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    public static class AaHO0E {

        /* renamed from: A2egSU, reason: collision with root package name */
        public int f9440A2egSU = -1;

        /* renamed from: A4TApA, reason: collision with root package name */
        public int f9441A4TApA = 0;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public int f9442A5SV6n = 0;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public int f9443ADYaiT = 1;
        public int AMqCpz = 0;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public boolean f9444ARc23Z = false;

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public boolean f9445ASJ6gh = false;

        /* renamed from: AYUAbz, reason: collision with root package name */
        public boolean f9446AYUAbz = false;

        /* renamed from: AZOQYO, reason: collision with root package name */
        public boolean f9447AZOQYO = false;

        /* renamed from: AZkASS, reason: collision with root package name */
        public boolean f9448AZkASS = false;

        /* renamed from: AaHO0E, reason: collision with root package name */
        public boolean f9449AaHO0E = false;

        /* renamed from: AcNBzu, reason: collision with root package name */
        public int f9450AcNBzu;

        /* renamed from: AlLFFp, reason: collision with root package name */
        public long f9451AlLFFp;

        /* renamed from: AmA8tU, reason: collision with root package name */
        public int f9452AmA8tU;

        public final void A2egSU(int i) {
            if ((this.f9443ADYaiT & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f9443ADYaiT));
        }

        public final int A4TApA() {
            return this.f9445ASJ6gh ? this.f9441A4TApA - this.f9442A5SV6n : this.AMqCpz;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.f9440A2egSU + ", mData=null, mItemCount=" + this.AMqCpz + ", mIsMeasuring=" + this.f9447AZOQYO + ", mPreviousLayoutItemCount=" + this.f9441A4TApA + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f9442A5SV6n + ", mStructureChanged=" + this.f9444ARc23Z + ", mInPreLayout=" + this.f9445ASJ6gh + ", mRunSimpleAnimations=" + this.f9448AZkASS + ", mRunPredictiveAnimations=" + this.f9449AaHO0E + '}';
        }
    }

    public static abstract class AcNBzu {
        public abstract View A2egSU();
    }

    static {
        int i = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = i >= 23;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new CqNSpT.ADYaiT(1);
        sDefaultEdgeEffectFactory = new De4eam();
        GAzcydY();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130969790);
    }

    public static int A4TApA(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && com.bumptech.glide.A5SV6n.BChYOn(edgeEffect) != 0.0f) {
            int round = Math.round(com.bumptech.glide.A5SV6n.CqNSpT(edgeEffect, ((-i) * FLING_DESTRETCH_FACTOR) / i2, 0.5f) * ((-i2) / FLING_DESTRETCH_FACTOR));
            if (round != i) {
                edgeEffect.finish();
            }
            return i - round;
        }
        if (i >= 0 || edgeEffect2 == null || com.bumptech.glide.A5SV6n.BChYOn(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i2;
        int round2 = Math.round(com.bumptech.glide.A5SV6n.CqNSpT(edgeEffect2, (i * FLING_DESTRETCH_FACTOR) / f, 0.5f) * (f / FLING_DESTRETCH_FACTOR));
        if (round2 != i) {
            edgeEffect2.finish();
        }
        return i - round2;
    }

    private static /* synthetic */ void GAzcydY() {
        char[] charArray = "FJH\u000bBDH@\u000bGJ\\\u000bVM@II\u000boKLgWLAB@".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '%');
        }
        String str = new String(charArray);
        char[] charArray2 = "FILKLQ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '%');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void clearNestedRecyclerViewIfNotNested(Dphsd2 dphsd2) {
        WeakReference<RecyclerView> weakReference = dphsd2.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == dphsd2.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            dphsd2.mNestedRecyclerView = null;
        }
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    public static Dphsd2 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((DG07BK) view.getLayoutParams()).f9343A2egSU;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        Rect rect2 = dg07bk.f9344A4TApA;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) dg07bk).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) dg07bk).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) dg07bk).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) dg07bk).bottomMargin);
    }

    private COJEAR.BChYOn getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new COJEAR.BChYOn(this);
        }
        return this.mScrollingChildHelper;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        sDebugAssertionsEnabled = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        sVerboseLoggingEnabled = z;
    }

    public final void A2egSU(Dphsd2 dphsd2) {
        View view = dphsd2.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.AmA8tU(getChildViewHolder(view));
        if (dphsd2.isTmpDetached()) {
            this.mChildHelper.A4TApA(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.mChildHelper.A2egSU(view, -1, true);
            return;
        }
        androidx.recyclerview.widget.ARc23Z aRc23Z = this.mChildHelper;
        int indexOfChild = ((RecyclerView) aRc23Z.f9176A2egSU.f9324A2egSU).indexOfChild(view);
        if (indexOfChild >= 0) {
            aRc23Z.f9177A4TApA.ASJ6gh(indexOfChild);
            aRc23Z.AZOQYO(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void ADYaiT() {
        EwN40Z ewN40Z;
        this.mState.A2egSU(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f9447AZOQYO = false;
        startInterceptRequestLayout();
        F1loUV f1loUV = this.mViewInfoStore;
        f1loUV.f9406A2egSU.clear();
        f1loUV.f9407A4TApA.A4TApA();
        onEnterLayoutOrScroll();
        AZkASS();
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        Dphsd2 findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            AaHO0E aaHO0E = this.mState;
            aaHO0E.f9451AlLFFp = -1L;
            aaHO0E.f9450AcNBzu = -1;
            aaHO0E.f9452AmA8tU = -1;
        } else {
            this.mState.f9451AlLFFp = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
            this.mState.f9450AcNBzu = this.mDataSetHasChangedAfterLayout ? -1 : findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAbsoluteAdapterPosition();
            AaHO0E aaHO0E2 = this.mState;
            View view = findContainingViewHolder.itemView;
            int id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    id = view.getId();
                }
            }
            aaHO0E2.f9452AmA8tU = id;
        }
        AaHO0E aaHO0E3 = this.mState;
        aaHO0E3.f9446AYUAbz = aaHO0E3.f9448AZkASS && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        aaHO0E3.f9445ASJ6gh = aaHO0E3.f9449AaHO0E;
        aaHO0E3.AMqCpz = this.mAdapter.getItemCount();
        ASJ6gh(this.mMinMaxLayoutPositions);
        if (this.mState.f9448AZkASS) {
            int AMqCpz2 = this.mChildHelper.AMqCpz();
            for (int i = 0; i < AMqCpz2; i++) {
                Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ADYaiT(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    ADYaiT aDYaiT = this.mItemAnimator;
                    ADYaiT.AMqCpz(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    aDYaiT.getClass();
                    ADYaiT.A2egSU a2egSU = new ADYaiT.A2egSU();
                    View view2 = childViewHolderInt.itemView;
                    a2egSU.f9431A2egSU = view2.getLeft();
                    a2egSU.f9432A4TApA = view2.getTop();
                    view2.getRight();
                    view2.getBottom();
                    B25kr6.AzWtSf azWtSf = this.mViewInfoStore.f9406A2egSU;
                    EwN40Z ewN40Z2 = (EwN40Z) azWtSf.get(childViewHolderInt);
                    if (ewN40Z2 == null) {
                        ewN40Z2 = EwN40Z.A2egSU();
                        azWtSf.put(childViewHolderInt, ewN40Z2);
                    }
                    ewN40Z2.f9404A4TApA = a2egSU;
                    ewN40Z2.f9403A2egSU |= 4;
                    if (this.mState.f9446AYUAbz && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.f9407A4TApA.AYUAbz(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f9449AaHO0E) {
            saveOldPositions();
            AaHO0E aaHO0E4 = this.mState;
            boolean z = aaHO0E4.f9444ARc23Z;
            aaHO0E4.f9444ARc23Z = false;
            this.mLayout.onLayoutChildren(this.mRecycler, aaHO0E4);
            this.mState.f9444ARc23Z = z;
            for (int i2 = 0; i2 < this.mChildHelper.AMqCpz(); i2++) {
                Dphsd2 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.ADYaiT(i2));
                if (!childViewHolderInt2.shouldIgnore() && ((ewN40Z = (EwN40Z) this.mViewInfoStore.f9406A2egSU.get(childViewHolderInt2)) == null || (ewN40Z.f9403A2egSU & 4) == 0)) {
                    ADYaiT.AMqCpz(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                    ADYaiT aDYaiT2 = this.mItemAnimator;
                    childViewHolderInt2.getUnmodifiedPayloads();
                    aDYaiT2.getClass();
                    ADYaiT.A2egSU a2egSU2 = new ADYaiT.A2egSU();
                    View view3 = childViewHolderInt2.itemView;
                    a2egSU2.f9431A2egSU = view3.getLeft();
                    a2egSU2.f9432A4TApA = view3.getTop();
                    view3.getRight();
                    view3.getBottom();
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, a2egSU2);
                    } else {
                        B25kr6.AzWtSf azWtSf2 = this.mViewInfoStore.f9406A2egSU;
                        EwN40Z ewN40Z3 = (EwN40Z) azWtSf2.get(childViewHolderInt2);
                        if (ewN40Z3 == null) {
                            ewN40Z3 = EwN40Z.A2egSU();
                            azWtSf2.put(childViewHolderInt2, ewN40Z3);
                        }
                        ewN40Z3.f9403A2egSU |= 2;
                        ewN40Z3.f9404A4TApA = a2egSU2;
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f9443ADYaiT = 2;
    }

    public final void AMqCpz() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.A2egSU(6);
        this.mAdapterHelper.A5SV6n();
        this.mState.AMqCpz = this.mAdapter.getItemCount();
        this.mState.f9442A5SV6n = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.f9360AcNBzu;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        AaHO0E aaHO0E = this.mState;
        aaHO0E.f9445ASJ6gh = false;
        this.mLayout.onLayoutChildren(this.mRecycler, aaHO0E);
        AaHO0E aaHO0E2 = this.mState;
        aaHO0E2.f9444ARc23Z = false;
        aaHO0E2.f9448AZkASS = aaHO0E2.f9448AZkASS && this.mItemAnimator != null;
        aaHO0E2.f9443ADYaiT = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ARc23Z(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList<androidx.recyclerview.widget.DUi7mC> r1 = r11.mOnItemTouchListeners
            int r1 = r1.size()
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L69
            java.util.ArrayList<androidx.recyclerview.widget.DUi7mC> r4 = r11.mOnItemTouchListeners
            java.lang.Object r4 = r4.get(r3)
            androidx.recyclerview.widget.DUi7mC r4 = (androidx.recyclerview.widget.DUi7mC) r4
            r5 = r4
            androidx.recyclerview.widget.BJ7GGh r5 = (androidx.recyclerview.widget.BJ7GGh) r5
            int r6 = r5.f9270BChYOn
            r7 = 1
            r8 = 2
            if (r6 != r7) goto L5e
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.A4TApA(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.A2egSU(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L66
            if (r6 != 0) goto L41
            if (r9 == 0) goto L66
        L41:
            if (r9 == 0) goto L4e
            r5.f9271BI9f7h = r7
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f9264B25kr6 = r6
            goto L5a
        L4e:
            if (r6 == 0) goto L5a
            r5.f9271BI9f7h = r8
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f9261AlLFFp = r6
        L5a:
            r5.ADYaiT(r8)
            goto L60
        L5e:
            if (r6 != r8) goto L66
        L60:
            r5 = 3
            if (r0 == r5) goto L66
            r11.mInterceptingOnItemTouchListener = r4
            return r7
        L66:
            int r3 = r3 + 1
            goto Lc
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.ARc23Z(android.view.MotionEvent):boolean");
    }

    public final void ASJ6gh(int[] iArr) {
        int AMqCpz2 = this.mChildHelper.AMqCpz();
        if (AMqCpz2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < AMqCpz2; i3++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ADYaiT(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public final void AYUAbz(int i, int i2, MotionEvent motionEvent) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z == null || this.mLayoutSuppressed) {
            return;
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean canScrollHorizontally = aRc23Z.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        int i3 = canScrollVertically ? (canScrollHorizontally ? 1 : 0) | 2 : canScrollHorizontally ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int AaHO0E2 = i - AaHO0E(height, i);
        int AcNBzu2 = i2 - AcNBzu(width, i2);
        startNestedScroll(i3, 1);
        if (dispatchNestedPreScroll(canScrollHorizontally ? AaHO0E2 : 0, canScrollVertically ? AcNBzu2 : 0, this.mReusableIntPair, this.mScrollOffset, 1)) {
            int[] iArr2 = this.mReusableIntPair;
            AaHO0E2 -= iArr2[0];
            AcNBzu2 -= iArr2[1];
        }
        scrollByInternal(canScrollHorizontally ? AaHO0E2 : 0, canScrollVertically ? AcNBzu2 : 0, motionEvent, 1);
        BTvldC bTvldC = this.mGapWorker;
        if (bTvldC != null && (AaHO0E2 != 0 || AcNBzu2 != 0)) {
            bTvldC.A2egSU(this, AaHO0E2, AcNBzu2);
        }
        stopNestedScroll(1);
    }

    public final void AZOQYO(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    public final void AZkASS() {
        boolean z;
        boolean z2 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            androidx.recyclerview.widget.A4TApA a4TApA = this.mAdapterHelper;
            a4TApA.AaHO0E(a4TApA.f9165A4TApA);
            a4TApA.AaHO0E(a4TApA.f9166A5SV6n);
            a4TApA.f9168ARc23Z = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) {
            this.mAdapterHelper.A5SV6n();
        } else {
            this.mAdapterHelper.AZkASS();
        }
        boolean z3 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f9448AZkASS = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z = this.mDataSetHasChangedAfterLayout) || z3 || this.mLayout.mRequestedSimpleAnimations) && (!z || this.mAdapter.hasStableIds());
        AaHO0E aaHO0E = this.mState;
        if (aaHO0E.f9448AZkASS && z3 && !this.mDataSetHasChangedAfterLayout && this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            z2 = true;
        }
        aaHO0E.f9449AaHO0E = z2;
    }

    public final int AaHO0E(float f, int i) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f2 = 0.0f;
        if (edgeEffect == null || com.bumptech.glide.A5SV6n.BChYOn(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (edgeEffect2 != null && com.bumptech.glide.A5SV6n.BChYOn(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float CqNSpT2 = com.bumptech.glide.A5SV6n.CqNSpT(this.mRightGlow, width, height);
                    if (com.bumptech.glide.A5SV6n.BChYOn(this.mRightGlow) == 0.0f) {
                        this.mRightGlow.onRelease();
                    }
                    f2 = CqNSpT2;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f3 = -com.bumptech.glide.A5SV6n.CqNSpT(this.mLeftGlow, -width, 1.0f - height);
                if (com.bumptech.glide.A5SV6n.BChYOn(this.mLeftGlow) == 0.0f) {
                    this.mLeftGlow.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getWidth());
    }

    public final int AcNBzu(float f, int i) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.mTopGlow;
        float f2 = 0.0f;
        if (edgeEffect == null || com.bumptech.glide.A5SV6n.BChYOn(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (edgeEffect2 != null && com.bumptech.glide.A5SV6n.BChYOn(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float CqNSpT2 = com.bumptech.glide.A5SV6n.CqNSpT(this.mBottomGlow, height, 1.0f - width);
                    if (com.bumptech.glide.A5SV6n.BChYOn(this.mBottomGlow) == 0.0f) {
                        this.mBottomGlow.onRelease();
                    }
                    f2 = CqNSpT2;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f3 = -com.bumptech.glide.A5SV6n.CqNSpT(this.mTopGlow, -height, width);
                if (com.bumptech.glide.A5SV6n.BChYOn(this.mTopGlow) == 0.0f) {
                    this.mTopGlow.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getHeight());
    }

    public final void AlLFFp(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof DG07BK) {
            DG07BK dg07bk = (DG07BK) layoutParams;
            if (!dg07bk.f9345A5SV6n) {
                Rect rect = this.mTempRect;
                int i = rect.left;
                Rect rect2 = dg07bk.f9344A4TApA;
                rect.left = i - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public final void AmA8tU() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            postInvalidateOnAnimation();
        }
    }

    public final void AzWtSf(A2egSU a2egSU, boolean z, boolean z2) {
        A2egSU a2egSU2 = this.mAdapter;
        if (a2egSU2 != null) {
            a2egSU2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        androidx.recyclerview.widget.A4TApA a4TApA = this.mAdapterHelper;
        a4TApA.AaHO0E(a4TApA.f9165A4TApA);
        a4TApA.AaHO0E(a4TApA.f9166A5SV6n);
        int i = 0;
        a4TApA.f9168ARc23Z = 0;
        A2egSU a2egSU3 = this.mAdapter;
        this.mAdapter = a2egSU;
        if (a2egSU != null) {
            a2egSU.registerAdapterDataObserver(this.mObserver);
            a2egSU.onAttachedToRecyclerView(this);
        }
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.onAdapterChanged(a2egSU3, this.mAdapter);
        }
        DXnQ0V dXnQ0V = this.mRecycler;
        A2egSU a2egSU4 = this.mAdapter;
        dXnQ0V.f9351A2egSU.clear();
        dXnQ0V.AYUAbz();
        dXnQ0V.ASJ6gh(a2egSU3, true);
        AZOQYO A5SV6n2 = dXnQ0V.A5SV6n();
        if (a2egSU3 != null) {
            A5SV6n2.f9438A4TApA--;
        }
        if (!z && A5SV6n2.f9438A4TApA == 0) {
            while (true) {
                SparseArray sparseArray = A5SV6n2.f9437A2egSU;
                if (i >= sparseArray.size()) {
                    break;
                }
                DV2E8K dv2e8k = (DV2E8K) sparseArray.valueAt(i);
                Iterator it = dv2e8k.f9347A2egSU.iterator();
                while (it.hasNext()) {
                    NOd7IU.AlLFFp.B7CMnp(((Dphsd2) it.next()).itemView);
                }
                dv2e8k.f9347A2egSU.clear();
                i++;
            }
        }
        if (a2egSU4 != null) {
            A5SV6n2.f9438A4TApA++;
        } else {
            A5SV6n2.getClass();
        }
        dXnQ0V.ARc23Z();
        this.mState.f9444ARc23Z = true;
    }

    public final boolean B25kr6(EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        float BChYOn2 = com.bumptech.glide.A5SV6n.BChYOn(edgeEffect) * i2;
        double log = Math.log((Math.abs(-i) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        double d = DECELERATION_RATE;
        return ((float) (Math.exp((d / (d - 1.0d)) * log) * ((double) (this.mPhysicalCoef * SCROLL_FRICTION)))) < BChYOn2;
    }

    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z == null || !aRc23Z.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(AMqCpz aMqCpz, int i) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(aMqCpz);
        } else {
            this.mItemDecorations.add(i, aMqCpz);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(DRlcZ9 dRlcZ9) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(dRlcZ9);
    }

    public void addOnItemTouchListener(DUi7mC dUi7mC) {
        this.mOnItemTouchListeners.add(dUi7mC);
    }

    public void addOnScrollListener(AYUAbz aYUAbz) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(aYUAbz);
    }

    public void addRecyclerListener(DXuj49 dXuj49) {
        JrXYwF.A4TApA.B2KMhB(dXuj49 != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(dXuj49);
    }

    public void animateAppearance(Dphsd2 dphsd2, ADYaiT.A2egSU a2egSU, ADYaiT.A2egSU a2egSU2) {
        dphsd2.setIsRecyclable(false);
        if (this.mItemAnimator.A2egSU(dphsd2, a2egSU, a2egSU2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(Dphsd2 dphsd2, ADYaiT.A2egSU a2egSU, ADYaiT.A2egSU a2egSU2) {
        A2egSU(dphsd2);
        dphsd2.setIsRecyclable(false);
        if (this.mItemAnimator.A5SV6n(dphsd2, a2egSU, a2egSU2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str != null) {
            throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, B4ZgIw.AYUAbz.A4TApA(str)));
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.mDispatchScrollCounter > 0) {
            new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("")));
        }
    }

    public boolean canReuseUpdatedViewHolder(Dphsd2 dphsd2) {
        ADYaiT aDYaiT = this.mItemAnimator;
        return aDYaiT == null || aDYaiT.ASJ6gh(dphsd2, dphsd2.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof DG07BK) && this.mLayout.checkLayoutParams((DG07BK) layoutParams);
    }

    public void clearOldPositions() {
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        for (int i = 0; i < AYUAbz2; i++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        DXnQ0V dXnQ0V = this.mRecycler;
        ArrayList arrayList = dXnQ0V.f9353A5SV6n;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Dphsd2) arrayList.get(i2)).clearOldPosition();
        }
        ArrayList arrayList2 = dXnQ0V.f9351A2egSU;
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((Dphsd2) arrayList2.get(i3)).clearOldPosition();
        }
        ArrayList arrayList3 = dXnQ0V.f9352A4TApA;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((Dphsd2) dXnQ0V.f9352A4TApA.get(i4)).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<DRlcZ9> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<AYUAbz> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null && aRc23Z.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null && aRc23Z.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null && aRc23Z.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null && aRc23Z.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null && aRc23Z.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null && aRc23Z.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            postInvalidateOnAnimation();
        }
    }

    public int consumeFlingInHorizontalStretch(int i) {
        return A4TApA(i, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    public int consumeFlingInVerticalStretch(int i) {
        return A4TApA(i, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            int i = C2rE4F.AcNBzu.f1543A2egSU;
            Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            Trace.endSection();
            return;
        }
        if (this.mAdapterHelper.ASJ6gh()) {
            androidx.recyclerview.widget.A4TApA a4TApA = this.mAdapterHelper;
            int i2 = a4TApA.f9168ARc23Z;
            if ((i2 & 4) == 0 || (i2 & 11) != 0) {
                if (a4TApA.ASJ6gh()) {
                    int i3 = C2rE4F.AcNBzu.f1543A2egSU;
                    Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    Trace.endSection();
                    return;
                }
                return;
            }
            int i4 = C2rE4F.AcNBzu.f1543A2egSU;
            Trace.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.AZkASS();
            if (!this.mLayoutWasDefered) {
                int AMqCpz2 = this.mChildHelper.AMqCpz();
                int i5 = 0;
                while (true) {
                    if (i5 < AMqCpz2) {
                        Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ADYaiT(i5));
                        if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                            dispatchLayout();
                            break;
                        }
                        i5++;
                    } else {
                        this.mAdapterHelper.A4TApA();
                        break;
                    }
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            Trace.endSection();
        }
    }

    public void defaultOnMeasure(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        setMeasuredDimension(ARc23Z.chooseSize(i, paddingRight, getMinimumWidth()), ARc23Z.chooseSize(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildAttached(View view) {
        Dphsd2 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        A2egSU a2egSU = this.mAdapter;
        if (a2egSU != null && childViewHolderInt != null) {
            a2egSU.onViewAttachedToWindow(childViewHolderInt);
        }
        List<DRlcZ9> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        Dphsd2 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        A2egSU a2egSU = this.mAdapter;
        if (a2egSU != null && childViewHolderInt != null) {
            a2egSU.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<DRlcZ9> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x034a, code lost:
    
        if (r15.mChildHelper.f9178A5SV6n.contains(r0) == false) goto L203;
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dispatchLayout() {
        /*
            Method dump skipped, instructions count: 1005
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.dispatchLayout():void");
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().A2egSU(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().A4TApA(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().A5SV6n(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().ADYaiT(i, i2, i3, i4, iArr, 0, null);
    }

    public void dispatchOnScrollStateChanged(int i) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        AYUAbz aYUAbz = this.mScrollListener;
        if (aYUAbz != null) {
            aYUAbz.onScrollStateChanged(this, i);
        }
        List<AYUAbz> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        AYUAbz aYUAbz = this.mScrollListener;
        if (aYUAbz != null) {
            aYUAbz.onScrolled(this, i, i2);
        }
        List<AYUAbz> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            Dphsd2 dphsd2 = this.mPendingAccessibilityImportanceChange.get(size);
            if (dphsd2.itemView.getParent() == this && !dphsd2.shouldIgnore() && (i = dphsd2.mPendingAccessibilityState) != -1) {
                View view = dphsd2.itemView;
                WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                view.setImportantForAccessibility(i);
                dphsd2.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if ((z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.AaHO0E()) ? z : true) {
            WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect A2egSU2 = this.mEdgeEffectFactory.A2egSU(this);
        this.mBottomGlow = A2egSU2;
        if (this.mClipToPadding) {
            A2egSU2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            A2egSU2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect A2egSU2 = this.mEdgeEffectFactory.A2egSU(this);
        this.mLeftGlow = A2egSU2;
        if (this.mClipToPadding) {
            A2egSU2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            A2egSU2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect A2egSU2 = this.mEdgeEffectFactory.A2egSU(this);
        this.mRightGlow = A2egSU2;
        if (this.mClipToPadding) {
            A2egSU2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            A2egSU2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect A2egSU2 = this.mEdgeEffectFactory.A2egSU(this);
        this.mTopGlow = A2egSU2;
        if (this.mClipToPadding) {
            A2egSU2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            A2egSU2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(AaHO0E aaHO0E) {
        if (getScrollState() != 2) {
            aaHO0E.getClass();
            return;
        }
        OverScroller overScroller = this.mViewFlinger.f9368AmA8tU;
        overScroller.getFinalX();
        overScroller.getCurrX();
        aaHO0E.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public View findChildViewUnder(float f, float f2) {
        for (int AMqCpz2 = this.mChildHelper.AMqCpz() - 1; AMqCpz2 >= 0; AMqCpz2--) {
            View ADYaiT2 = this.mChildHelper.ADYaiT(AMqCpz2);
            float translationX = ADYaiT2.getTranslationX();
            float translationY = ADYaiT2.getTranslationY();
            if (f >= ADYaiT2.getLeft() + translationX && f <= ADYaiT2.getRight() + translationX && f2 >= ADYaiT2.getTop() + translationY && f2 <= ADYaiT2.getBottom() + translationY) {
                return ADYaiT2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            return r3
        L17:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public Dphsd2 findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public Dphsd2 findViewHolderForAdapterPosition(int i) {
        Dphsd2 dphsd2 = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        for (int i2 = 0; i2 < AYUAbz2; i2++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i) {
                androidx.recyclerview.widget.ARc23Z aRc23Z = this.mChildHelper;
                if (!aRc23Z.f9178A5SV6n.contains(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                dphsd2 = childViewHolderInt;
            }
        }
        return dphsd2;
    }

    public Dphsd2 findViewHolderForItemId(long j) {
        A2egSU a2egSU = this.mAdapter;
        Dphsd2 dphsd2 = null;
        if (a2egSU != null && a2egSU.hasStableIds()) {
            int AYUAbz2 = this.mChildHelper.AYUAbz();
            for (int i = 0; i < AYUAbz2; i++) {
                Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    androidx.recyclerview.widget.ARc23Z aRc23Z = this.mChildHelper;
                    if (!aRc23Z.f9178A5SV6n.contains(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    dphsd2 = childViewHolderInt;
                }
            }
        }
        return dphsd2;
    }

    public Dphsd2 findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Deprecated
    public Dphsd2 findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean fling(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0197, code lost:
    
        if (r5 > 0) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x019a, code lost:
    
        if (r16 < 0) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x019d, code lost:
    
        if (r5 < 0) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01a6, code lost:
    
        if ((r5 * r6) <= 0) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01af, code lost:
    
        if ((r5 * r6) >= 0) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0180, code lost:
    
        if (r16 > 0) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0172  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View focusSearch(android.view.View r18, int r19) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            return aRc23Z.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            return aRc23Z.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public A2egSU getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(Dphsd2 dphsd2) {
        if (dphsd2.hasAnyOfTheFlags(524) || !dphsd2.isBound()) {
            return -1;
        }
        androidx.recyclerview.widget.A4TApA a4TApA = this.mAdapterHelper;
        int i = dphsd2.mPosition;
        ArrayList arrayList = a4TApA.f9165A4TApA;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.recyclerview.widget.A2egSU a2egSU = (androidx.recyclerview.widget.A2egSU) arrayList.get(i2);
            int i3 = a2egSU.f9160A2egSU;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = a2egSU.f9161A4TApA;
                    if (i4 <= i) {
                        int i5 = a2egSU.f9163ADYaiT;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = a2egSU.f9161A4TApA;
                    if (i6 == i) {
                        i = a2egSU.f9163ADYaiT;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (a2egSU.f9163ADYaiT <= i) {
                            i++;
                        }
                    }
                }
            } else if (a2egSU.f9161A4TApA <= i) {
                i += a2egSU.f9163ADYaiT;
            }
        }
        return i;
    }

    @Override // android.view.View
    public int getBaseline() {
        ARc23Z aRc23Z = this.mLayout;
        return aRc23Z != null ? aRc23Z.getBaseline() : super.getBaseline();
    }

    public long getChangedHolderKey(Dphsd2 dphsd2) {
        return this.mAdapter.hasStableIds() ? dphsd2.getItemId() : dphsd2.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        Dphsd2 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    public long getChildItemId(View view) {
        Dphsd2 childViewHolderInt;
        A2egSU a2egSU = this.mAdapter;
        if (a2egSU == null || !a2egSU.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        Dphsd2 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public Dphsd2 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public DvK7DB getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public A5SV6n getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ADYaiT getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        DG07BK dg07bk = (DG07BK) view.getLayoutParams();
        boolean z = dg07bk.f9345A5SV6n;
        Rect rect = dg07bk.f9344A4TApA;
        if (!z || (this.mState.f9445ASJ6gh && (dg07bk.f9343A2egSU.isUpdated() || dg07bk.f9343A2egSU.isInvalid()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i2 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        dg07bk.f9345A5SV6n = false;
        return rect;
    }

    public AMqCpz getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public ARc23Z getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public ASJ6gh getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public AZOQYO getRecycledViewPool() {
        return this.mRecycler.A5SV6n();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().ARc23Z(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.ASJ6gh();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.A4TApA(new CtFAbx(this));
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new BJ7GGh(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(2131165341), resources.getDimensionPixelSize(2131165343), resources.getDimensionPixelOffset(2131165342));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        ADYaiT aDYaiT = this.mItemAnimator;
        return aDYaiT != null && aDYaiT.AaHO0E();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f1647ADYaiT;
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        for (int i = 0; i < AYUAbz2; i++) {
            ((DG07BK) this.mChildHelper.ASJ6gh(i).getLayoutParams()).f9345A5SV6n = true;
        }
        ArrayList arrayList = this.mRecycler.f9353A5SV6n;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            DG07BK dg07bk = (DG07BK) ((Dphsd2) arrayList.get(i2)).itemView.getLayoutParams();
            if (dg07bk != null) {
                dg07bk.f9345A5SV6n = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        for (int i = 0; i < AYUAbz2; i++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        DXnQ0V dXnQ0V = this.mRecycler;
        ArrayList arrayList = dXnQ0V.f9353A5SV6n;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Dphsd2 dphsd2 = (Dphsd2) arrayList.get(i2);
            if (dphsd2 != null) {
                dphsd2.addFlags(6);
                dphsd2.addChangePayload(null);
            }
        }
        A2egSU a2egSU = dXnQ0V.f9358AZOQYO.mAdapter;
        if (a2egSU == null || !a2egSU.hasStableIds()) {
            dXnQ0V.AYUAbz();
        }
    }

    public void nestedScrollBy(int i, int i2) {
        AYUAbz(i, i2, null);
    }

    public void offsetChildrenHorizontal(int i) {
        int AMqCpz2 = this.mChildHelper.AMqCpz();
        for (int i2 = 0; i2 < AMqCpz2; i2++) {
            this.mChildHelper.ADYaiT(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int AMqCpz2 = this.mChildHelper.AMqCpz();
        for (int i2 = 0; i2 < AMqCpz2; i2++) {
            this.mChildHelper.ADYaiT(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetPositionRecordsForInsert(int i, int i2) {
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        for (int i3 = 0; i3 < AYUAbz2; i3++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                if (sVerboseLoggingEnabled) {
                    childViewHolderInt.toString();
                }
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f9444ARc23Z = true;
            }
        }
        ArrayList arrayList = this.mRecycler.f9353A5SV6n;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Dphsd2 dphsd2 = (Dphsd2) arrayList.get(i4);
            if (dphsd2 != null && dphsd2.mPosition >= i) {
                if (sVerboseLoggingEnabled) {
                    dphsd2.toString();
                }
                dphsd2.offsetPosition(i2, false);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        int i10 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i11 = 0; i11 < AYUAbz2; i11++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i11));
            if (childViewHolderInt != null && (i9 = childViewHolderInt.mPosition) >= i4 && i9 <= i3) {
                if (sVerboseLoggingEnabled) {
                    childViewHolderInt.toString();
                }
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i5, false);
                }
                this.mState.f9444ARc23Z = true;
            }
        }
        DXnQ0V dXnQ0V = this.mRecycler;
        dXnQ0V.getClass();
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        ArrayList arrayList = dXnQ0V.f9353A5SV6n;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            Dphsd2 dphsd2 = (Dphsd2) arrayList.get(i12);
            if (dphsd2 != null && (i8 = dphsd2.mPosition) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    dphsd2.offsetPosition(i2 - i, false);
                } else {
                    dphsd2.offsetPosition(i10, false);
                }
                if (sVerboseLoggingEnabled) {
                    dphsd2.toString();
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        for (int i4 = 0; i4 < AYUAbz2; i4++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i5 = childViewHolderInt.mPosition;
                if (i5 >= i3) {
                    if (sVerboseLoggingEnabled) {
                        childViewHolderInt.toString();
                    }
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f9444ARc23Z = true;
                } else if (i5 >= i) {
                    if (sVerboseLoggingEnabled) {
                        childViewHolderInt.toString();
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.f9444ARc23Z = true;
                }
            }
        }
        DXnQ0V dXnQ0V = this.mRecycler;
        ArrayList arrayList = dXnQ0V.f9353A5SV6n;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Dphsd2 dphsd2 = (Dphsd2) arrayList.get(size);
            if (dphsd2 != null) {
                int i6 = dphsd2.mPosition;
                if (i6 >= i3) {
                    if (sVerboseLoggingEnabled) {
                        dphsd2.toString();
                    }
                    dphsd2.offsetPosition(-i2, z);
                } else if (i6 >= i) {
                    dphsd2.addFlags(8);
                    dXnQ0V.AZOQYO(size);
                }
            }
        }
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.DXnQ0V r1 = r5.mRecycler
            r1.ARc23Z()
            androidx.recyclerview.widget.RecyclerView$ARc23Z r1 = r5.mLayout
            if (r1 == 0) goto L23
            r1.dispatchAttachedToWindow(r5)
        L23:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L8e
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.BTvldC.f9285B25kr6
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.BTvldC r1 = (androidx.recyclerview.widget.BTvldC) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L71
            androidx.recyclerview.widget.BTvldC r1 = new androidx.recyclerview.widget.BTvldC
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f9287AcNBzu = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f9290AzWtSf = r2
            r5.mGapWorker = r1
            java.util.WeakHashMap r1 = COJEAR.DG07BK.f1680A2egSU
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L63
            if (r1 == 0) goto L63
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L63
            goto L65
        L63:
            r1 = 1114636288(0x42700000, float:60.0)
        L65:
            androidx.recyclerview.widget.BTvldC r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f9289AmA8tU = r3
            r0.set(r2)
        L71:
            androidx.recyclerview.widget.BTvldC r0 = r5.mGapWorker
            r0.getClass()
            boolean r1 = androidx.recyclerview.widget.RecyclerView.sDebugAssertionsEnabled
            java.util.ArrayList r0 = r0.f9287AcNBzu
            if (r1 == 0) goto L8b
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L83
            goto L8b
        L83:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L8b:
            r0.add(r5)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        BTvldC bTvldC;
        super.onDetachedFromWindow();
        ADYaiT aDYaiT = this.mItemAnimator;
        if (aDYaiT != null) {
            aDYaiT.AZkASS();
        }
        stopScroll();
        int i = 0;
        this.mIsAttached = false;
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        while (EwN40Z.f9402ADYaiT.A2egSU() != null) {
        }
        DXnQ0V dXnQ0V = this.mRecycler;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = dXnQ0V.f9353A5SV6n;
            if (i2 >= arrayList.size()) {
                break;
            }
            NOd7IU.AlLFFp.B7CMnp(((Dphsd2) arrayList.get(i2)).itemView);
            i2++;
        }
        dXnQ0V.ASJ6gh(dXnQ0V.f9358AZOQYO.mAdapter, false);
        while (i < getChildCount()) {
            int i3 = i + 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            CkXcdM.A2egSU a2egSU = (CkXcdM.A2egSU) childAt.getTag(2131297763);
            if (a2egSU == null) {
                a2egSU = new CkXcdM.A2egSU();
                childAt.setTag(2131297763, a2egSU);
            }
            ArrayList arrayList2 = a2egSU.f1817A2egSU;
            int ADYaiT2 = RD2OKB.AaHO0E.ADYaiT(arrayList2);
            if (-1 < ADYaiT2) {
                arrayList2.get(ADYaiT2).getClass();
                throw new ClassCastException();
            }
            i = i3;
        }
        if (!ALLOW_THREAD_GAP_WORK || (bTvldC = this.mGapWorker) == null) {
            return;
        }
        boolean remove = bTvldC.f9287AcNBzu.remove(this);
        if (sDebugAssertionsEnabled && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$ARc23Z r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L7
            goto L7b
        L7:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Ld
            goto L7b
        Ld:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L7b
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L40
            androidx.recyclerview.widget.RecyclerView$ARc23Z r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2e
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2f
        L2e:
            r0 = 0
        L2f:
            androidx.recyclerview.widget.RecyclerView$ARc23Z r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L3e
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L66
        L3e:
            r3 = 0
            goto L66
        L40:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L64
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$ARc23Z r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L59
            float r0 = -r0
            goto L3e
        L59:
            androidx.recyclerview.widget.RecyclerView$ARc23Z r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L64
            r3 = r0
            r0 = 0
            goto L66
        L64:
            r0 = 0
            goto L3e
        L66:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6e
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L7b
        L6e:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.AYUAbz(r2, r0, r6)
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (!this.mLayoutSuppressed) {
            this.mInterceptingOnItemTouchListener = null;
            if (ARc23Z(motionEvent)) {
                AmA8tU();
                setScrollState(0);
                return true;
            }
            ARc23Z aRc23Z = this.mLayout;
            if (aRc23Z != null) {
                boolean canScrollHorizontally = aRc23Z.canScrollHorizontally();
                boolean canScrollVertically = this.mLayout.canScrollVertically();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = false;
                    }
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = x;
                    this.mInitialTouchX = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = y;
                    this.mInitialTouchY = y;
                    EdgeEffect edgeEffect = this.mLeftGlow;
                    if (edgeEffect == null || com.bumptech.glide.A5SV6n.BChYOn(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z = false;
                    } else {
                        com.bumptech.glide.A5SV6n.CqNSpT(this.mLeftGlow, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z = true;
                    }
                    EdgeEffect edgeEffect2 = this.mRightGlow;
                    if (edgeEffect2 != null && com.bumptech.glide.A5SV6n.BChYOn(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                        com.bumptech.glide.A5SV6n.CqNSpT(this.mRightGlow, 0.0f, motionEvent.getY() / getHeight());
                        z = true;
                    }
                    EdgeEffect edgeEffect3 = this.mTopGlow;
                    if (edgeEffect3 != null && com.bumptech.glide.A5SV6n.BChYOn(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                        com.bumptech.glide.A5SV6n.CqNSpT(this.mTopGlow, 0.0f, motionEvent.getX() / getWidth());
                        z = true;
                    }
                    EdgeEffect edgeEffect4 = this.mBottomGlow;
                    if (edgeEffect4 != null && com.bumptech.glide.A5SV6n.BChYOn(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                        com.bumptech.glide.A5SV6n.CqNSpT(this.mBottomGlow, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z = true;
                    }
                    if (z || this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        stopNestedScroll(1);
                    }
                    int[] iArr = this.mNestedOffsets;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i = canScrollHorizontally;
                    if (canScrollVertically) {
                        i = (canScrollHorizontally ? 1 : 0) | 2;
                    }
                    startNestedScroll(i, 0);
                } else if (actionMasked == 1) {
                    this.mVelocityTracker.clear();
                    stopNestedScroll(0);
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        if (this.mScrollState != 1) {
                            int i2 = x2 - this.mInitialTouchX;
                            int i3 = y2 - this.mInitialTouchY;
                            if (canScrollHorizontally == 0 || Math.abs(i2) <= this.mTouchSlop) {
                                z2 = false;
                            } else {
                                this.mLastTouchX = x2;
                                z2 = true;
                            }
                            if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                                this.mLastTouchY = y2;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                    }
                } else if (actionMasked == 3) {
                    AmA8tU();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = x3;
                    this.mInitialTouchX = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.mLastTouchY = y3;
                    this.mInitialTouchY = y3;
                } else if (actionMasked == 6) {
                    AZOQYO(motionEvent);
                }
                if (this.mScrollState == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = C2rE4F.AcNBzu.f1543A2egSU;
        Trace.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (aRc23Z.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z;
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.f9443ADYaiT == 1) {
                ADYaiT();
            }
            this.mLayout.setMeasureSpecs(i, i2);
            this.mState.f9447AZOQYO = true;
            AMqCpz();
            this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f9447AZOQYO = true;
                AMqCpz();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            AZkASS();
            onExitLayoutOrScroll();
            AaHO0E aaHO0E = this.mState;
            if (aaHO0E.f9449AaHO0E) {
                aaHO0E.f9445ASJ6gh = true;
            } else {
                this.mAdapterHelper.A5SV6n();
                this.mState.f9445ASJ6gh = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f9449AaHO0E) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        A2egSU a2egSU = this.mAdapter;
        if (a2egSU != null) {
            this.mState.AMqCpz = a2egSU.getItemCount();
        } else {
            this.mState.AMqCpz = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        stopInterceptRequestLayout(false);
        this.mState.f9445ASJ6gh = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof DcUJf1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        DcUJf1 dcUJf1 = (DcUJf1) parcelable;
        this.mPendingSavedState = dcUJf1;
        super.onRestoreInstanceState(dcUJf1.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        DcUJf1 dcUJf1 = new DcUJf1(super.onSaveInstanceState());
        DcUJf1 dcUJf12 = this.mPendingSavedState;
        if (dcUJf12 != null) {
            dcUJf1.f9360AcNBzu = dcUJf12.f9360AcNBzu;
            return dcUJf1;
        }
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            dcUJf1.f9360AcNBzu = aRc23Z.onSaveInstanceState();
            return dcUJf1;
        }
        dcUJf1.f9360AcNBzu = null;
        return dcUJf1;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01fb  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        Runnable runnable = this.mItemAnimatorRunner;
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        postOnAnimation(runnable);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(Dphsd2 dphsd2, ADYaiT.A2egSU a2egSU) {
        dphsd2.setFlags(0, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        if (this.mState.f9446AYUAbz && dphsd2.isUpdated() && !dphsd2.isRemoved() && !dphsd2.shouldIgnore()) {
            this.mViewInfoStore.f9407A4TApA.AYUAbz(getChangedHolderKey(dphsd2), dphsd2);
        }
        B25kr6.AzWtSf azWtSf = this.mViewInfoStore.f9406A2egSU;
        EwN40Z ewN40Z = (EwN40Z) azWtSf.get(dphsd2);
        if (ewN40Z == null) {
            ewN40Z = EwN40Z.A2egSU();
            azWtSf.put(dphsd2, ewN40Z);
        }
        ewN40Z.f9404A4TApA = a2egSU;
        ewN40Z.f9403A2egSU |= 4;
    }

    public void removeAndRecycleViews() {
        ADYaiT aDYaiT = this.mItemAnimator;
        if (aDYaiT != null) {
            aDYaiT.AZkASS();
        }
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        DXnQ0V dXnQ0V = this.mRecycler;
        dXnQ0V.f9351A2egSU.clear();
        dXnQ0V.AYUAbz();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean removeAnimatingView(android.view.View r8) {
        /*
            r7 = this;
            r7.startInterceptRequestLayout()
            androidx.recyclerview.widget.ARc23Z r0 = r7.mChildHelper
            androidx.recyclerview.widget.AMqCpz r1 = r0.f9177A4TApA
            androidx.recyclerview.widget.CSDoyG r2 = r0.f9176A2egSU
            int r3 = r0.f9179ADYaiT
            r4 = 1
            r5 = 0
            if (r3 != r4) goto L1d
            android.view.View r0 = r0.AMqCpz
            if (r0 != r8) goto L15
        L13:
            r4 = 0
            goto L48
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
            r8.<init>(r0)
            throw r8
        L1d:
            r6 = 2
            if (r3 == r6) goto L6b
            r0.f9179ADYaiT = r6     // Catch: java.lang.Throwable -> L33
            java.lang.Object r3 = r2.f9324A2egSU     // Catch: java.lang.Throwable -> L33
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3     // Catch: java.lang.Throwable -> L33
            int r3 = r3.indexOfChild(r8)     // Catch: java.lang.Throwable -> L33
            r6 = -1
            if (r3 != r6) goto L35
            r0.AcNBzu(r8)     // Catch: java.lang.Throwable -> L33
        L30:
            r0.f9179ADYaiT = r5
            goto L48
        L33:
            r8 = move-exception
            goto L68
        L35:
            boolean r6 = r1.ADYaiT(r3)     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L45
            r1.AMqCpz(r3)     // Catch: java.lang.Throwable -> L33
            r0.AcNBzu(r8)     // Catch: java.lang.Throwable -> L33
            r2.A2egSU(r3)     // Catch: java.lang.Throwable -> L33
            goto L30
        L45:
            r0.f9179ADYaiT = r5
            goto L13
        L48:
            if (r4 == 0) goto L62
            androidx.recyclerview.widget.Dphsd2 r0 = getChildViewHolderInt(r8)
            androidx.recyclerview.widget.DXnQ0V r1 = r7.mRecycler
            r1.AmA8tU(r0)
            androidx.recyclerview.widget.DXnQ0V r1 = r7.mRecycler
            r1.AaHO0E(r0)
            boolean r0 = androidx.recyclerview.widget.RecyclerView.sVerboseLoggingEnabled
            if (r0 == 0) goto L62
            java.util.Objects.toString(r8)
            r7.toString()
        L62:
            r8 = r4 ^ 1
            r7.stopInterceptRequestLayout(r8)
            return r4
        L68:
            r0.f9179ADYaiT = r5
            throw r8
        L6b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeViewIfHidden"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.removeAnimatingView(android.view.View):boolean");
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        Dphsd2 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(this, sb));
            }
        } else if (sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(this, sb2));
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(AMqCpz aMqCpz) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(aMqCpz);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(DRlcZ9 dRlcZ9) {
        List<DRlcZ9> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(dRlcZ9);
    }

    public void removeOnItemTouchListener(DUi7mC dUi7mC) {
        this.mOnItemTouchListeners.remove(dUi7mC);
        if (this.mInterceptingOnItemTouchListener == dUi7mC) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(AYUAbz aYUAbz) {
        List<AYUAbz> list = this.mScrollListeners;
        if (list != null) {
            list.remove(aYUAbz);
        }
    }

    public void removeRecyclerListener(DXuj49 dXuj49) {
        this.mRecyclerListeners.remove(dXuj49);
    }

    public void repositionShadowingViews() {
        Dphsd2 dphsd2;
        int AMqCpz2 = this.mChildHelper.AMqCpz();
        for (int i = 0; i < AMqCpz2; i++) {
            View ADYaiT2 = this.mChildHelper.ADYaiT(i);
            Dphsd2 childViewHolder = getChildViewHolder(ADYaiT2);
            if (childViewHolder != null && (dphsd2 = childViewHolder.mShadowingHolder) != null) {
                View view = dphsd2.itemView;
                int left = ADYaiT2.getLeft();
                int top = ADYaiT2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            AlLFFp(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        for (int i = 0; i < AYUAbz2; i++) {
            Dphsd2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.ASJ6gh(i));
            if (sDebugAssertionsEnabled && childViewHolderInt.mPosition == -1 && !childViewHolderInt.isRemoved()) {
                throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
            }
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z == null || this.mLayoutSuppressed) {
            return;
        }
        boolean canScrollHorizontally = aRc23Z.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i = 0;
            }
            if (!canScrollVertically) {
                i2 = 0;
            }
            scrollByInternal(i, i2, null, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scrollByInternal(int r19, int r20, android.view.MotionEvent r21, int r22) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.scrollByInternal(int, int, android.view.MotionEvent, int):boolean");
    }

    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        int i3 = C2rE4F.AcNBzu.f1543A2egSU;
        Trace.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        Trace.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
    }

    public void scrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z == null) {
            return;
        }
        aRc23Z.scrollToPosition(i);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(DvK7DB dvK7DB) {
        this.mAccessibilityDelegate = dvK7DB;
        COJEAR.DG07BK.B4ZgIw(this, dvK7DB);
    }

    public void setAdapter(A2egSU a2egSU) {
        setLayoutFrozen(false);
        AzWtSf(a2egSU, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(D6DOie d6DOie) {
        if (d6DOie == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    public boolean setChildImportantForAccessibilityInternal(Dphsd2 dphsd2, int i) {
        if (isComputingLayout()) {
            dphsd2.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(dphsd2);
            return false;
        }
        View view = dphsd2.itemView;
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        view.setImportantForAccessibility(i);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(A5SV6n a5SV6n) {
        a5SV6n.getClass();
        this.mEdgeEffectFactory = a5SV6n;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(ADYaiT aDYaiT) {
        ADYaiT aDYaiT2 = this.mItemAnimator;
        if (aDYaiT2 != null) {
            aDYaiT2.AZkASS();
            this.mItemAnimator.f9426A2egSU = null;
        }
        this.mItemAnimator = aDYaiT;
        if (aDYaiT != null) {
            aDYaiT.f9426A2egSU = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i) {
        DXnQ0V dXnQ0V = this.mRecycler;
        dXnQ0V.AMqCpz = i;
        dXnQ0V.AzWtSf();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(ARc23Z aRc23Z) {
        RecyclerView recyclerView;
        if (aRc23Z == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            ADYaiT aDYaiT = this.mItemAnimator;
            if (aDYaiT != null) {
                aDYaiT.AZkASS();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            DXnQ0V dXnQ0V = this.mRecycler;
            dXnQ0V.f9351A2egSU.clear();
            dXnQ0V.AYUAbz();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            DXnQ0V dXnQ0V2 = this.mRecycler;
            dXnQ0V2.f9351A2egSU.clear();
            dXnQ0V2.AYUAbz();
        }
        androidx.recyclerview.widget.ARc23Z aRc23Z2 = this.mChildHelper;
        aRc23Z2.f9177A4TApA.ARc23Z();
        ArrayList arrayList = aRc23Z2.f9178A5SV6n;
        int size = arrayList.size();
        while (true) {
            size--;
            recyclerView = (RecyclerView) aRc23Z2.f9176A2egSU.f9324A2egSU;
            if (size < 0) {
                break;
            }
            Dphsd2 childViewHolderInt = getChildViewHolderInt((View) arrayList.get(size));
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(recyclerView);
            }
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.mLayout = aRc23Z;
        if (aRc23Z != null) {
            if (aRc23Z.mRecyclerView != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(aRc23Z);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(J3FDQU.A2egSU.AmA8tU(aRc23Z.mRecyclerView, sb));
            }
            aRc23Z.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.AzWtSf();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().ASJ6gh(z);
    }

    public void setOnFlingListener(ASJ6gh aSJ6gh) {
        this.mOnFlingListener = aSJ6gh;
    }

    @Deprecated
    public void setOnScrollListener(AYUAbz aYUAbz) {
        this.mScrollListener = aYUAbz;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(AZOQYO azoqyo) {
        DXnQ0V dXnQ0V = this.mRecycler;
        RecyclerView recyclerView = dXnQ0V.f9358AZOQYO;
        dXnQ0V.ASJ6gh(recyclerView.mAdapter, false);
        if (dXnQ0V.f9356ASJ6gh != null) {
            r2.f9438A4TApA--;
        }
        dXnQ0V.f9356ASJ6gh = azoqyo;
        if (azoqyo != null && recyclerView.getAdapter() != null) {
            dXnQ0V.f9356ASJ6gh.f9438A4TApA++;
        }
        dXnQ0V.ARc23Z();
    }

    @Deprecated
    public void setRecyclerListener(DXuj49 dXuj49) {
    }

    public void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        if (sVerboseLoggingEnabled) {
            new Exception();
        }
        this.mScrollState = i;
        if (i != 2) {
            DjONCG djONCG = this.mViewFlinger;
            djONCG.f9372B3GDIM.removeCallbacks(djONCG);
            djONCG.f9368AmA8tU.abortAnimation();
            ARc23Z aRc23Z = this.mLayout;
            if (aRc23Z != null) {
                aRc23Z.stopSmoothScroller();
            }
        }
        dispatchOnScrollStateChanged(i);
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 1) {
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else {
            this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
    }

    public void setViewCacheExtension(AcNBzu acNBzu) {
        this.mRecycler.f9357AYUAbz = acNBzu;
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
        this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        return true;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollToPosition(int i) {
        ARc23Z aRc23Z;
        if (this.mLayoutSuppressed || (aRc23Z = this.mLayout) == null) {
            return;
        }
        aRc23Z.smoothScrollToPosition(this, this.mState, i);
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().AYUAbz(i, 0);
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (sDebugAssertionsEnabled) {
                throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().AZOQYO(0);
    }

    public void stopScroll() {
        setScrollState(0);
        DjONCG djONCG = this.mViewFlinger;
        djONCG.f9372B3GDIM.removeCallbacks(djONCG);
        djONCG.f9368AmA8tU.abortAnimation();
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            aRc23Z.stopSmoothScroller();
        }
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(A2egSU a2egSU, boolean z) {
        setLayoutFrozen(false);
        AzWtSf(a2egSU, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i, int i2, Object obj) {
        int i3;
        int i4;
        int AYUAbz2 = this.mChildHelper.AYUAbz();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < AYUAbz2; i6++) {
            View ASJ6gh2 = this.mChildHelper.ASJ6gh(i6);
            Dphsd2 childViewHolderInt = getChildViewHolderInt(ASJ6gh2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i && i4 < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((DG07BK) ASJ6gh2.getLayoutParams()).f9345A5SV6n = true;
            }
        }
        DXnQ0V dXnQ0V = this.mRecycler;
        ArrayList arrayList = dXnQ0V.f9353A5SV6n;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Dphsd2 dphsd2 = (Dphsd2) arrayList.get(size);
            if (dphsd2 != null && (i3 = dphsd2.mPosition) >= i && i3 < i5) {
                dphsd2.addFlags(2);
                dXnQ0V.AZOQYO(size);
            }
        }
    }

    public static abstract class A2egSU {
        private final D07BeM mObservable = new D07BeM();
        private boolean mHasStableIds = false;
        private CtxOCS mStateRestorationPolicy = CtxOCS.f9336AcNBzu;

        public final void bindViewHolder(Dphsd2 dphsd2, int i) {
            boolean z = dphsd2.mBindingAdapter == null;
            if (z) {
                dphsd2.mPosition = i;
                if (hasStableIds()) {
                    dphsd2.mItemId = getItemId(i);
                }
                dphsd2.setFlags(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
                int i2 = C2rE4F.AcNBzu.f1543A2egSU;
                Trace.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            dphsd2.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled) {
                if (dphsd2.itemView.getParent() == null) {
                    View view = dphsd2.itemView;
                    WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                    if (view.isAttachedToWindow() != dphsd2.isTmpDetached()) {
                        throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + dphsd2.isTmpDetached() + ", attached to window: " + dphsd2.itemView.isAttachedToWindow() + ", holder: " + dphsd2);
                    }
                }
                if (dphsd2.itemView.getParent() == null) {
                    View view2 = dphsd2.itemView;
                    WeakHashMap weakHashMap2 = COJEAR.DG07BK.f1680A2egSU;
                    if (view2.isAttachedToWindow()) {
                        throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + dphsd2);
                    }
                }
            }
            onBindViewHolder(dphsd2, i, dphsd2.getUnmodifiedPayloads());
            if (z) {
                dphsd2.clearPayload();
                ViewGroup.LayoutParams layoutParams = dphsd2.itemView.getLayoutParams();
                if (layoutParams instanceof DG07BK) {
                    ((DG07BK) layoutParams).f9345A5SV6n = true;
                }
                int i3 = C2rE4F.AcNBzu.f1543A2egSU;
                Trace.endSection();
            }
        }

        public boolean canRestoreState() {
            int ordinal = this.mStateRestorationPolicy.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return false;
                }
            } else if (getItemCount() <= 0) {
                return false;
            }
            return true;
        }

        public final Dphsd2 createViewHolder(ViewGroup viewGroup, int i) {
            try {
                int i2 = C2rE4F.AcNBzu.f1543A2egSU;
                Trace.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                Dphsd2 onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                onCreateViewHolder.mItemViewType = i;
                Trace.endSection();
                return onCreateViewHolder;
            } catch (Throwable th) {
                int i3 = C2rE4F.AcNBzu.f1543A2egSU;
                Trace.endSection();
                throw th;
            }
        }

        public int findRelativeAdapterPositionIn(A2egSU a2egSU, Dphsd2 dphsd2, int i) {
            if (a2egSU == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final CtxOCS getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.A2egSU();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.A4TApA();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.ADYaiT(i, 1, null);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.AMqCpz(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.A5SV6n(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.ADYaiT(i, i2, null);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.AMqCpz(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.ARc23Z(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.ARc23Z(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(Dphsd2 dphsd2, int i);

        public void onBindViewHolder(Dphsd2 dphsd2, int i, List<Object> list) {
            onBindViewHolder(dphsd2, i);
        }

        public abstract Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(Dphsd2 dphsd2) {
            return false;
        }

        public void onViewAttachedToWindow(Dphsd2 dphsd2) {
        }

        public void onViewDetachedFromWindow(Dphsd2 dphsd2) {
        }

        public void onViewRecycled(Dphsd2 dphsd2) {
        }

        public void registerAdapterDataObserver(A4TApA a4TApA) {
            this.mObservable.registerObserver(a4TApA);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void setStateRestorationPolicy(CtxOCS ctxOCS) {
            this.mStateRestorationPolicy = ctxOCS;
            this.mObservable.ASJ6gh();
        }

        public void unregisterAdapterDataObserver(A4TApA a4TApA) {
            this.mObservable.unregisterObserver(a4TApA);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.ADYaiT(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.ADYaiT(i, i2, obj);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float A2egSU2;
        Constructor constructor;
        this.mObserver = new DaOi9o(this);
        this.mRecycler = new DXnQ0V(this);
        this.mViewInfoStore = new F1loUV();
        this.mUpdateChildViewsRunnable = new CmUvjW(0, this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        this.mItemAnimator = new AzWtSf();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new DjONCG(this);
        Object[] objArr = null;
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new BNL6CD() : null;
        this.mState = new AaHO0E();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new D8MqeW(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new CqNSpT(this);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new CrfGsy(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            Method method = COJEAR.DXnQ0V.f1686A2egSU;
            A2egSU2 = COJEAR.DRlcZ9.A2egSU(viewConfiguration);
        } else {
            A2egSU2 = COJEAR.DXnQ0V.A2egSU(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = A2egSU2;
        this.mScaledVerticalScrollFactor = i2 >= 26 ? COJEAR.DRlcZ9.A4TApA(viewConfiguration) : COJEAR.DXnQ0V.A2egSU(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f9426A2egSU = this.mItemAnimatorListener;
        initAdapterManager();
        this.mChildHelper = new androidx.recyclerview.widget.ARc23Z(new CSDoyG(this));
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        if ((i2 >= 26 ? COJEAR.CtFAbx.A5SV6n(this) : 0) == 0 && i2 >= 26) {
            COJEAR.CtFAbx.AlLFFp(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new DvK7DB(this));
        int[] iArr = R$styleable.f9159A2egSU;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        COJEAR.DG07BK.B3GDIM(this, context, iArr, attributeSet, obtainStyledAttributes, i);
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(1, true);
        boolean z = obtainStyledAttributes.getBoolean(3, false);
        this.mEnableFastScroller = z;
        if (z) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(6), obtainStyledAttributes.getDrawable(7), (StateListDrawable) obtainStyledAttributes.getDrawable(4), obtainStyledAttributes.getDrawable(5));
        }
        obtainStyledAttributes.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                try {
                    Class<? extends U> asSubclass = Class.forName(trim, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(ARc23Z.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), 0};
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + trim, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((ARc23Z) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + trim, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + trim, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + trim, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e7);
                }
            }
        }
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        COJEAR.DG07BK.B3GDIM(this, context, iArr2, attributeSet, obtainStyledAttributes2, i);
        boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
        setTag(2131296743, Boolean.TRUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.Dphsd2 findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.ARc23Z r0 = r5.mChildHelper
            int r0 = r0.AYUAbz()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3c
            androidx.recyclerview.widget.ARc23Z r3 = r5.mChildHelper
            android.view.View r3 = r3.ASJ6gh(r2)
            androidx.recyclerview.widget.Dphsd2 r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L39
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L39
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L39
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L39
        L2a:
            androidx.recyclerview.widget.ARc23Z r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            java.util.ArrayList r1 = r1.f9178A5SV6n
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L38
            r1 = r3
            goto L39
        L38:
            return r3
        L39:
            int r2 = r2 + 1
            goto L8
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.Dphsd2");
    }

    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            if (sDebugAssertionsEnabled && i < 0) {
                throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                int i2 = this.mEatenAccessibilityChangeFlags;
                this.mEatenAccessibilityChangeFlags = 0;
                if (i2 != 0 && isAccessibilityEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    obtain.setContentChangeTypes(i2);
                    sendAccessibilityEventUnchecked(obtain);
                }
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().A5SV6n(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().ADYaiT(i, i2, i3, i4, iArr, i5, null);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().ARc23Z(i);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().AYUAbz(i, i2);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().AZOQYO(i);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z == null || this.mLayoutSuppressed) {
            return;
        }
        if (!aRc23Z.canScrollHorizontally()) {
            i = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (i3 != Integer.MIN_VALUE && i3 <= 0) {
            scrollBy(i, i2);
            return;
        }
        if (z) {
            int i4 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i4 |= 2;
            }
            startNestedScroll(i4, 1);
        }
        this.mViewFlinger.A5SV6n(i, i2, i3, interpolator);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().ADYaiT(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public void addItemDecoration(AMqCpz aMqCpz) {
        addItemDecoration(aMqCpz, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ARc23Z aRc23Z = this.mLayout;
        if (aRc23Z != null) {
            return aRc23Z.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(J3FDQU.A2egSU.AmA8tU(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
