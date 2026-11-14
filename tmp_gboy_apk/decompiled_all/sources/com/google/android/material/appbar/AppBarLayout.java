package com.google.android.material.appbar;

import COJEAR.B9tovu;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import COJEAR.FG7pZc;
import NOd7IU.AlLFFp;
import Nm94Z2.ARc23Z;
import Nm94Z2.ASJ6gh;
import OLy1FW.AYUAbz;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AppBarLayout extends LinearLayout implements androidx.coordinatorlayout.widget.A2egSU {

    /* renamed from: CQhlFr, reason: collision with root package name */
    public static final /* synthetic */ int f11280CQhlFr = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f11281AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f11282AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f11283AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f11284AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f11285B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f11286B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public FG7pZc f11287B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f11288B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f11289B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f11290B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f11291BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ColorStateList f11292BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f11293BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public WeakReference f11294BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public ValueAnimator f11295BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f11296BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final ArrayList f11297BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final LinkedHashSet f11298BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final long f11299BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final TimeInterpolator f11300BniPrB;
    public int[] BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f11301C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public Drawable f11302C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public Integer f11303CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final float f11304CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public Behavior f11305COJEAR;

    public static abstract class A2egSU {
    }

    public static class A4TApA extends A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final Rect f11306A2egSU = new Rect();

        /* renamed from: A4TApA, reason: collision with root package name */
        public final Rect f11307A4TApA = new Rect();
    }

    public static abstract class A5SV6n {
        public abstract void A2egSU(float f);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends Nm94Z2.ADYaiT {
        public ScrollingViewBehavior() {
        }

        @Override // Nm94Z2.ADYaiT
        public final AppBarLayout AYUAbz(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // Nm94Z2.ADYaiT
        public final float AZOQYO(View view) {
            int i;
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.A2egSU a2egSU = ((androidx.coordinatorlayout.widget.A5SV6n) appBarLayout.getLayoutParams()).f8427A2egSU;
            int ARc23Z2 = a2egSU instanceof BaseBehavior ? ((BaseBehavior) a2egSU).ARc23Z() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + ARc23Z2 > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                return (ARc23Z2 / i) + 1.0f;
            }
            return 0.0f;
        }

        @Override // Nm94Z2.ADYaiT
        public final int AZkASS(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : view.getMeasuredHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int B3GDIM2;
            CoordinatorLayout.A2egSU a2egSU = ((androidx.coordinatorlayout.widget.A5SV6n) view2.getLayoutParams()).f8427A2egSU;
            if (a2egSU instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) a2egSU).f11308B9tovu + this.f6063B25kr6;
                if (this.f6064B2KMhB == 0) {
                    B3GDIM2 = 0;
                } else {
                    float AZOQYO2 = AZOQYO(view2);
                    int i = this.f6064B2KMhB;
                    B3GDIM2 = com.bumptech.glide.AMqCpz.B3GDIM((int) (AZOQYO2 * i), 0, i);
                }
                DG07BK.AlLFFp(bottom - B3GDIM2, view);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f11291BChYOn) {
                    appBarLayout.AMqCpz(appBarLayout.ARc23Z(view));
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                DG07BK.B4ZgIw(coordinatorLayout, null);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayout;
            ArrayList ADYaiT2 = coordinatorLayout.ADYaiT(view);
            int size = ADYaiT2.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    appBarLayout = null;
                    break;
                }
                View view2 = (View) ADYaiT2.get(i);
                if (view2 instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) view2;
                    break;
                }
                i++;
            }
            if (appBarLayout != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f6061AmA8tU;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayout.ADYaiT(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11252CikNvS);
            this.f6064B2KMhB = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130968638, 2131952598), attributeSet, 2130968638);
        int i = 3;
        this.f11282AlLFFp = -1;
        this.f11283AmA8tU = -1;
        this.f11284AzWtSf = -1;
        this.f11286B2KMhB = 0;
        this.f11297BTvldC = new ArrayList();
        this.f11298BV3sI0 = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context3, attributeSet, ASJ6gh.f6071A2egSU, 2130968638, 2131952598, new int[0]);
        try {
            if (AmA8tU2.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, AmA8tU2.getResourceId(0, 0)));
            }
            AmA8tU2.recycle();
            TypedArray AmA8tU3 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11212A2egSU, 2130968638, 2131952598, new int[0]);
            this.f11292BI9f7h = com.bumptech.glide.AMqCpz.BPw6Q8(context2, AmA8tU3, 6);
            this.f11299BmvVmW = com.bumptech.glide.A5SV6n.D07BeM(context2, 2130969621, getResources().getInteger(2131361794));
            this.f11300BniPrB = com.bumptech.glide.A5SV6n.D6DOie(context2, 2130969639, NdEzCJ.A2egSU.f6036A2egSU);
            if (AmA8tU3.hasValue(4)) {
                ADYaiT(AmA8tU3.getBoolean(4, false), false, false);
            }
            if (AmA8tU3.hasValue(3)) {
                ASJ6gh.A2egSU(this, AmA8tU3.getDimensionPixelSize(3, 0));
            }
            setBackground(AmA8tU3.getDrawable(0));
            if (Build.VERSION.SDK_INT >= 26) {
                if (AmA8tU3.hasValue(2)) {
                    setKeyboardNavigationCluster(AmA8tU3.getBoolean(2, false));
                }
                if (AmA8tU3.hasValue(1)) {
                    setTouchscreenBlocksFocus(AmA8tU3.getBoolean(1, false));
                }
            }
            this.f11304CNPG0E = getResources().getDimension(2131165285);
            this.f11291BChYOn = AmA8tU3.getBoolean(5, false);
            this.f11293BIYEnU = AmA8tU3.getResourceId(7, -1);
            setStatusBarForeground(AmA8tU3.getDrawable(8));
            AmA8tU3.recycle();
            NGepWW.A2egSU a2egSU = new NGepWW.A2egSU(i, this);
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            CmUvjW.B9tovu(this, a2egSU);
        } catch (Throwable th) {
            AmA8tU2.recycle();
            throw th;
        }
    }

    public static AMqCpz A4TApA(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            AMqCpz aMqCpz = new AMqCpz((LinearLayout.LayoutParams) layoutParams);
            aMqCpz.f11277A2egSU = 1;
            return aMqCpz;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            AMqCpz aMqCpz2 = new AMqCpz((ViewGroup.MarginLayoutParams) layoutParams);
            aMqCpz2.f11277A2egSU = 1;
            return aMqCpz2;
        }
        AMqCpz aMqCpz3 = new AMqCpz(layoutParams);
        aMqCpz3.f11277A2egSU = 1;
        return aMqCpz3;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: A2egSU, reason: merged with bridge method [inline-methods] */
    public final AMqCpz generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        AMqCpz aMqCpz = new AMqCpz(context, attributeSet);
        aMqCpz.f11277A2egSU = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11213A4TApA);
        aMqCpz.f11277A2egSU = obtainStyledAttributes.getInt(1, 0);
        aMqCpz.f11278A4TApA = obtainStyledAttributes.getInt(0, 0) != 1 ? null : new A4TApA();
        if (obtainStyledAttributes.hasValue(2)) {
            aMqCpz.f11279A5SV6n = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(2, 0));
        }
        obtainStyledAttributes.recycle();
        return aMqCpz;
    }

    public final void A5SV6n() {
        Behavior behavior = this.f11305COJEAR;
        ADYaiT B3GDIM2 = (behavior == null || this.f11282AlLFFp == -1 || this.f11286B2KMhB != 0) ? null : behavior.B3GDIM(CmUvjW.A4TApA.EMPTY_STATE, this);
        this.f11282AlLFFp = -1;
        this.f11283AmA8tU = -1;
        this.f11284AzWtSf = -1;
        if (B3GDIM2 != null) {
            Behavior behavior2 = this.f11305COJEAR;
            if (behavior2.f11311BIYEnU != null) {
                return;
            }
            behavior2.f11311BIYEnU = B3GDIM2;
        }
    }

    public final void ADYaiT(boolean z, boolean z2, boolean z3) {
        this.f11286B2KMhB = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    public final boolean AMqCpz(boolean z) {
        if (this.f11288B4ZgIw || this.f11290B9tovu == z) {
            return false;
        }
        this.f11290B9tovu = z;
        refreshDrawableState();
        if (!(getBackground() instanceof AaHO0E)) {
            return true;
        }
        if (this.f11292BI9f7h != null) {
            ASJ6gh(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f11291BChYOn) {
            return true;
        }
        float f = this.f11304CNPG0E;
        ASJ6gh(z ? 0.0f : f, z ? f : 0.0f);
        return true;
    }

    public final boolean ARc23Z(View view) {
        int i;
        if (this.f11294BJ7GGh == null && (i = this.f11293BIYEnU) != -1) {
            View findViewById = view != null ? view.findViewById(i) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f11293BIYEnU);
            }
            if (findViewById != null) {
                this.f11294BJ7GGh = new WeakReference(findViewById);
            }
        }
        WeakReference weakReference = this.f11294BJ7GGh;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void ASJ6gh(float f, float f2) {
        ValueAnimator valueAnimator = this.f11295BNL6CD;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        this.f11295BNL6CD = ofFloat;
        ofFloat.setDuration(this.f11299BmvVmW);
        this.f11295BNL6CD.setInterpolator(this.f11300BniPrB);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f11296BPw6Q8;
        if (animatorUpdateListener != null) {
            this.f11295BNL6CD.addUpdateListener(animatorUpdateListener);
        }
        this.f11295BNL6CD.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof AMqCpz;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f11302C4FrIb == null || getTopInset() <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(0.0f, -this.f11281AcNBzu);
        this.f11302C4FrIb.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f11302C4FrIb;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AMqCpz aMqCpz = new AMqCpz(-1, -2);
        aMqCpz.f11277A2egSU = 1;
        return aMqCpz;
    }

    @Override // androidx.coordinatorlayout.widget.A2egSU
    public CoordinatorLayout.A2egSU getBehavior() {
        Behavior behavior = new Behavior();
        this.f11305COJEAR = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int i;
        int minimumHeight;
        int i2 = this.f11283AmA8tU;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                AMqCpz aMqCpz = (AMqCpz) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = aMqCpz.f11277A2egSU;
                if ((i4 & 5) != 5) {
                    if (i3 > 0) {
                        break;
                    }
                } else {
                    int i5 = ((LinearLayout.LayoutParams) aMqCpz).topMargin + ((LinearLayout.LayoutParams) aMqCpz).bottomMargin;
                    if ((i4 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i4 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        i = i5 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            i = Math.min(i, measuredHeight - getTopInset());
                        }
                        i3 += i;
                    }
                    i = minimumHeight + i5;
                    if (childCount == 0) {
                        i = Math.min(i, measuredHeight - getTopInset());
                    }
                    i3 += i;
                }
            }
        }
        int max = Math.max(0, i3);
        this.f11283AmA8tU = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.f11284AzWtSf;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                AMqCpz aMqCpz = (AMqCpz) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) aMqCpz).topMargin + ((LinearLayout.LayoutParams) aMqCpz).bottomMargin + childAt.getMeasuredHeight();
                int i4 = aMqCpz.f11277A2egSU;
                if ((i4 & 1) == 0) {
                    break;
                }
                i3 += measuredHeight;
                if ((i4 & 2) != 0) {
                    i3 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.f11284AzWtSf = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f11293BIYEnU;
    }

    public AaHO0E getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof AaHO0E) {
            return (AaHO0E) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i = (minimumHeight * 2) + topInset;
            return i < getHeight() ? i : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i2 = (minimumHeight2 * 2) + topInset;
        return i2 < getHeight() ? i2 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.f11286B2KMhB;
    }

    public Drawable getStatusBarForeground() {
        return this.f11302C4FrIb;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        FG7pZc fG7pZc = this.f11287B3GDIM;
        if (fG7pZc != null) {
            return fG7pZc.ADYaiT();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f11282AlLFFp;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                AMqCpz aMqCpz = (AMqCpz) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = aMqCpz.f11277A2egSU;
                if ((i4 & 1) == 0) {
                    break;
                }
                int i5 = measuredHeight + ((LinearLayout.LayoutParams) aMqCpz).topMargin + ((LinearLayout.LayoutParams) aMqCpz).bottomMargin + i3;
                if (i2 == 0 && childAt.getFitsSystemWindows()) {
                    i5 -= getTopInset();
                }
                i3 = i5;
                if ((i4 & 2) != 0) {
                    i3 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.f11282AlLFFp = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AlLFFp.D07BeM(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.BpkvW3 == null) {
            this.BpkvW3 = new int[4];
        }
        int[] iArr = this.BpkvW3;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.f11289B7CMnp;
        iArr[0] = z ? 2130969922 : -2130969922;
        iArr[1] = (z && this.f11290B9tovu) ? 2130969923 : -2130969923;
        iArr[2] = z ? 2130969918 : -2130969918;
        iArr[3] = (z && this.f11290B9tovu) ? 2130969917 : -2130969917;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f11294BJ7GGh;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f11294BJ7GGh = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            super.onLayout(r3, r4, r5, r6, r7)
            r3 = r2
            boolean r4 = r2.getFitsSystemWindows()
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L39
            int r4 = r2.getChildCount()
            if (r4 <= 0) goto L39
            android.view.View r4 = r2.getChildAt(r5)
            int r7 = r4.getVisibility()
            r0 = 8
            if (r7 == r0) goto L39
            boolean r4 = r4.getFitsSystemWindows()
            if (r4 != 0) goto L39
            int r4 = r2.getTopInset()
            int r7 = r2.getChildCount()
            int r7 = r7 - r6
        L2d:
            if (r7 < 0) goto L39
            android.view.View r0 = r2.getChildAt(r7)
            COJEAR.DG07BK.AlLFFp(r4, r0)
            int r7 = r7 + (-1)
            goto L2d
        L39:
            r2.A5SV6n()
            r3.f11285B25kr6 = r5
            int r4 = r2.getChildCount()
            r7 = 0
        L43:
            if (r7 >= r4) goto L59
            android.view.View r0 = r2.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            com.google.android.material.appbar.AMqCpz r0 = (com.google.android.material.appbar.AMqCpz) r0
            android.view.animation.Interpolator r0 = r0.f11279A5SV6n
            if (r0 == 0) goto L56
            r3.f11285B25kr6 = r6
            goto L59
        L56:
            int r7 = r7 + 1
            goto L43
        L59:
            android.graphics.drawable.Drawable r4 = r3.f11302C4FrIb
            if (r4 == 0) goto L68
            int r7 = r2.getWidth()
            int r0 = r2.getTopInset()
            r4.setBounds(r5, r5, r7, r0)
        L68:
            boolean r4 = r3.f11288B4ZgIw
            if (r4 != 0) goto L99
            boolean r4 = r3.f11291BChYOn
            if (r4 != 0) goto L8f
            int r4 = r2.getChildCount()
            r7 = 0
        L75:
            if (r7 >= r4) goto L90
            android.view.View r0 = r2.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            com.google.android.material.appbar.AMqCpz r0 = (com.google.android.material.appbar.AMqCpz) r0
            int r0 = r0.f11277A2egSU
            r1 = r0 & 1
            if (r1 != r6) goto L8c
            r0 = r0 & 10
            if (r0 == 0) goto L8c
            goto L8f
        L8c:
            int r7 = r7 + 1
            goto L75
        L8f:
            r5 = 1
        L90:
            boolean r4 = r3.f11289B7CMnp
            if (r4 == r5) goto L99
            r3.f11289B7CMnp = r5
            r2.refreshDrawableState()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = com.bumptech.glide.AMqCpz.B3GDIM(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        A5SV6n();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        final AaHO0E aaHO0E;
        ColorStateList colorStateList;
        Context context = getContext();
        final Integer num = null;
        if (drawable instanceof AaHO0E) {
            aaHO0E = (AaHO0E) drawable;
        } else {
            ColorStateList C2rE4F2 = JrXYwF.A4TApA.C2rE4F(drawable);
            if (C2rE4F2 == null) {
                aaHO0E = null;
            } else {
                AaHO0E aaHO0E2 = new AaHO0E();
                aaHO0E2.B3GDIM(C2rE4F2);
                aaHO0E = aaHO0E2;
            }
        }
        if (aaHO0E != null && (colorStateList = aaHO0E.f7042AlLFFp.f7024ADYaiT) != null) {
            this.f11301C2rE4F = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.f11292BI9f7h;
            if (colorStateList2 != null) {
                Context context2 = getContext();
                TypedValue A2egSU2 = P3rngT.A4TApA.A2egSU(context2, 2130968895);
                if (A2egSU2 != null) {
                    int i = A2egSU2.resourceId;
                    num = Integer.valueOf(i != 0 ? BPw6Q8.ASJ6gh.A4TApA(context2, i) : A2egSU2.data);
                }
                this.f11296BPw6Q8 = new ValueAnimator.AnimatorUpdateListener() { // from class: Nm94Z2.A2egSU
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num2;
                        int i2 = AppBarLayout.f11280CQhlFr;
                        AppBarLayout appBarLayout = AppBarLayout.this;
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        int AaHO0E2 = AYUAbz.AaHO0E(floatValue, appBarLayout.f11301C2rE4F, colorStateList2.getDefaultColor());
                        ColorStateList valueOf = ColorStateList.valueOf(AaHO0E2);
                        AaHO0E aaHO0E3 = aaHO0E;
                        aaHO0E3.B3GDIM(valueOf);
                        if (appBarLayout.f11302C4FrIb != null && (num2 = appBarLayout.f11303CASmeH) != null && num2.equals(num)) {
                            appBarLayout.f11302C4FrIb.setTint(AaHO0E2);
                        }
                        ArrayList arrayList = appBarLayout.f11297BTvldC;
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (it.next() != null) {
                                    throw new ClassCastException();
                                }
                                if (aaHO0E3.f7042AlLFFp.f7024ADYaiT != null) {
                                    throw null;
                                }
                            }
                        }
                        LinkedHashSet linkedHashSet = appBarLayout.f11298BV3sI0;
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator it2 = linkedHashSet.iterator();
                        while (it2.hasNext()) {
                            ((AppBarLayout.A5SV6n) it2.next()).A2egSU(floatValue);
                        }
                    }
                };
            } else {
                aaHO0E.AmA8tU(context);
                this.f11296BPw6Q8 = new Nm94Z2.A4TApA(this, 0, aaHO0E);
            }
            drawable = aaHO0E;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        AlLFFp.CtFAbx(this, f);
    }

    public void setExpanded(boolean z) {
        ADYaiT(z, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.f11291BChYOn = z;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.f11292BI9f7h != colorStateList) {
            this.f11292BI9f7h = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f11293BIYEnU = -1;
        if (view != null) {
            this.f11294BJ7GGh = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.f11294BJ7GGh;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f11294BJ7GGh = null;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.f11293BIYEnU = i;
        WeakReference weakReference = this.f11294BJ7GGh;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f11294BJ7GGh = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.f11288B4ZgIw = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setPendingAction(int i) {
        this.f11286B2KMhB = i;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f11302C4FrIb;
        if (drawable2 != drawable) {
            Integer num = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f11302C4FrIb = mutate;
            if (mutate instanceof AaHO0E) {
                num = Integer.valueOf(((AaHO0E) mutate).f7061C2rE4F);
            } else {
                ColorStateList C2rE4F2 = JrXYwF.A4TApA.C2rE4F(mutate);
                if (C2rE4F2 != null) {
                    num = Integer.valueOf(C2rE4F2.getDefaultColor());
                }
            }
            this.f11303CASmeH = num;
            Drawable drawable3 = this.f11302C4FrIb;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f11302C4FrIb.setState(getDrawableState());
                }
                com.bumptech.glide.A5SV6n.D8cQ8b(this.f11302C4FrIb, getLayoutDirection());
                this.f11302C4FrIb.setVisible(getVisibility() == 0, false);
                this.f11302C4FrIb.setCallback(this);
            }
            if (this.f11302C4FrIb != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(!z);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(AlLFFp.CQhlFr(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        ASJ6gh.A2egSU(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f11302C4FrIb;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11302C4FrIb;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return A4TApA(layoutParams);
    }

    public static class BaseBehavior<T extends AppBarLayout> extends Nm94Z2.A5SV6n {

        /* renamed from: B9tovu, reason: collision with root package name */
        public int f11308B9tovu;

        /* renamed from: BChYOn, reason: collision with root package name */
        public int f11309BChYOn;

        /* renamed from: BI9f7h, reason: collision with root package name */
        public ValueAnimator f11310BI9f7h;

        /* renamed from: BIYEnU, reason: collision with root package name */
        public ADYaiT f11311BIYEnU;

        /* renamed from: BJ7GGh, reason: collision with root package name */
        public WeakReference f11312BJ7GGh;

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.f6057B2KMhB = -1;
            this.f6059B4ZgIw = -1;
        }

        public static View AmA8tU(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            baseBehavior.getClass();
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((androidx.coordinatorlayout.widget.A5SV6n) childAt.getLayoutParams()).f8427A2egSU instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View B25kr6(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof B9tovu) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public static void B7CMnp(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View view;
            boolean z2;
            Drawable foreground;
            Drawable foreground2;
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    view = null;
                    break;
                }
                view = appBarLayout.getChildAt(i3);
                if (abs >= view.getTop() && abs <= view.getBottom()) {
                    break;
                } else {
                    i3++;
                }
            }
            if (view != null) {
                int i4 = ((AMqCpz) view.getLayoutParams()).f11277A2egSU;
                if ((i4 & 1) != 0) {
                    int minimumHeight = view.getMinimumHeight();
                    z2 = true;
                    if (i2 > 0) {
                    }
                }
            }
            z2 = false;
            if (appBarLayout.f11291BChYOn) {
                z2 = appBarLayout.ARc23Z(B25kr6(coordinatorLayout));
            }
            boolean AMqCpz = appBarLayout.AMqCpz(z2);
            if (!z) {
                if (AMqCpz) {
                    List list = (List) coordinatorLayout.f8449AlLFFp.f1427A4TApA.get(appBarLayout);
                    ArrayList arrayList = coordinatorLayout.f8451AzWtSf;
                    arrayList.clear();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    int size = arrayList.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        CoordinatorLayout.A2egSU a2egSU = ((androidx.coordinatorlayout.widget.A5SV6n) ((View) arrayList.get(i5)).getLayoutParams()).f8427A2egSU;
                        if (a2egSU instanceof ScrollingViewBehavior) {
                            if (((ScrollingViewBehavior) a2egSU).f6064B2KMhB == 0) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (appBarLayout.getBackground() != null) {
                appBarLayout.getBackground().jumpToCurrentState();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                foreground = appBarLayout.getForeground();
                if (foreground != null) {
                    foreground2 = appBarLayout.getForeground();
                    foreground2.jumpToCurrentState();
                }
            }
            if (appBarLayout.getStateListAnimator() != null) {
                appBarLayout.getStateListAnimator().jumpToCurrentState();
            }
        }

        @Override // Nm94Z2.AMqCpz
        public final int ARc23Z() {
            return AMqCpz() + this.f11308B9tovu;
        }

        @Override // Nm94Z2.A5SV6n
        public final boolean AYUAbz(View view) {
            WeakReference weakReference = this.f11312BJ7GGh;
            if (weakReference == null) {
                return true;
            }
            View view2 = (View) weakReference.get();
            return (view2 == null || !view2.isShown() || view2.canScrollVertically(-1)) ? false : true;
        }

        @Override // Nm94Z2.A5SV6n
        public final int AZOQYO(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            return appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange());
        }

        @Override // Nm94Z2.A5SV6n
        public final int AZkASS(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override // Nm94Z2.A5SV6n
        public final void AaHO0E(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            B4ZgIw(coordinatorLayout, appBarLayout);
            if (appBarLayout.f11291BChYOn) {
                appBarLayout.AMqCpz(appBarLayout.ARc23Z(B25kr6(coordinatorLayout)));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x018a  */
        @Override // Nm94Z2.A5SV6n
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int AcNBzu(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
            /*
                Method dump skipped, instructions count: 418
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.AcNBzu(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void AzWtSf(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(ARc23Z() - i);
            float abs2 = Math.abs(0.0f);
            int round = abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int ARc23Z2 = ARc23Z();
            if (ARc23Z2 == i) {
                ValueAnimator valueAnimator = this.f11310BI9f7h;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f11310BI9f7h.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f11310BI9f7h;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f11310BI9f7h = valueAnimator3;
                valueAnimator3.setInterpolator(NdEzCJ.A2egSU.AMqCpz);
                this.f11310BI9f7h.addUpdateListener(new com.google.android.material.appbar.A2egSU(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f11310BI9f7h.setDuration(Math.min(round, 600));
            this.f11310BI9f7h.setIntValues(ARc23Z2, i);
            this.f11310BI9f7h.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void B2KMhB(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2c
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
                r7 = r1
            Lf:
                r6 = r0
                goto L19
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                r7 = 0
                goto Lf
            L19:
                if (r6 == r7) goto L2c
                int r0 = r8.ARc23Z()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r9 = r2.AcNBzu(r3, r4, r5, r6, r7)
                r10 = 1
                r13[r10] = r9
                goto L2d
            L2c:
                r4 = r10
            L2d:
                boolean r9 = r4.f11291BChYOn
                if (r9 == 0) goto L38
                boolean r9 = r4.ARc23Z(r11)
                r4.AMqCpz(r9)
            L38:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.B2KMhB(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        public final ADYaiT B3GDIM(Parcelable parcelable, AppBarLayout appBarLayout) {
            int AMqCpz = AMqCpz();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + AMqCpz;
                if (childAt.getTop() + AMqCpz <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = CmUvjW.A4TApA.EMPTY_STATE;
                    }
                    ADYaiT aDYaiT = new ADYaiT(parcelable);
                    boolean z = AMqCpz == 0;
                    aDYaiT.f11273AlLFFp = z;
                    aDYaiT.f11272AcNBzu = !z && (-AMqCpz) >= appBarLayout.getTotalScrollRange();
                    aDYaiT.f11274AmA8tU = i;
                    aDYaiT.f11276B25kr6 = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    aDYaiT.f11275AzWtSf = bottom / childAt.getHeight();
                    return aDYaiT;
                }
            }
            return null;
        }

        public final void B4ZgIw(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int ARc23Z2 = ARc23Z() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                AMqCpz aMqCpz = (AMqCpz) childAt.getLayoutParams();
                if ((aMqCpz.f11277A2egSU & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) aMqCpz).topMargin;
                    bottom += ((LinearLayout.LayoutParams) aMqCpz).bottomMargin;
                }
                int i2 = -ARc23Z2;
                if (top <= i2 && bottom >= i2) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                AMqCpz aMqCpz2 = (AMqCpz) childAt2.getLayoutParams();
                int i3 = aMqCpz2.f11277A2egSU;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int i5 = -childAt2.getBottom();
                    if (i == 0 && appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                        i4 -= appBarLayout.getTopInset();
                    }
                    if ((i3 & 2) == 2) {
                        i5 += childAt2.getMinimumHeight();
                    } else if ((i3 & 5) == 5) {
                        int minimumHeight = childAt2.getMinimumHeight() + i5;
                        if (ARc23Z2 < minimumHeight) {
                            i4 = minimumHeight;
                        } else {
                            i5 = minimumHeight;
                        }
                    }
                    if ((i3 & 32) == 32) {
                        i4 += ((LinearLayout.LayoutParams) aMqCpz2).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) aMqCpz2).bottomMargin;
                    }
                    if (ARc23Z2 < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    AzWtSf(coordinatorLayout, appBarLayout, com.bumptech.glide.AMqCpz.B3GDIM(i4 + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // Nm94Z2.AMqCpz, androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            ADYaiT aDYaiT = this.f11311BIYEnU;
            if (aDYaiT == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i2 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            AzWtSf(coordinatorLayout, appBarLayout, i2);
                        } else {
                            AlLFFp(coordinatorLayout, appBarLayout, i2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            AzWtSf(coordinatorLayout, appBarLayout, 0);
                        } else {
                            AlLFFp(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (aDYaiT.f11272AcNBzu) {
                AlLFFp(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (aDYaiT.f11273AlLFFp) {
                AlLFFp(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(aDYaiT.f11274AmA8tU);
                int i3 = -childAt.getBottom();
                AlLFFp(coordinatorLayout, appBarLayout, this.f11311BIYEnU.f11276B25kr6 ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i3 : Math.round(childAt.getHeight() * this.f11311BIYEnU.f11275AzWtSf) + i3);
            }
            appBarLayout.f11286B2KMhB = 0;
            this.f11311BIYEnU = null;
            int B3GDIM2 = com.bumptech.glide.AMqCpz.B3GDIM(AMqCpz(), -appBarLayout.getTotalScrollRange(), 0);
            ARc23Z aRc23Z = this.f6065AcNBzu;
            if (aRc23Z == null) {
                this.f6066AlLFFp = B3GDIM2;
            } else if (aRc23Z.f6070ADYaiT != B3GDIM2) {
                aRc23Z.f6070ADYaiT = B3GDIM2;
                aRc23Z.A2egSU();
            }
            B7CMnp(coordinatorLayout, appBarLayout, AMqCpz(), 0, true);
            appBarLayout.f11281AcNBzu = AMqCpz();
            if (!appBarLayout.willNotDraw()) {
                appBarLayout.postInvalidateOnAnimation();
            }
            if (DG07BK.ADYaiT(coordinatorLayout) != null) {
                return true;
            }
            DG07BK.B4ZgIw(coordinatorLayout, new com.google.android.material.appbar.A4TApA(coordinatorLayout, this, appBarLayout));
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((androidx.coordinatorlayout.widget.A5SV6n) appBarLayout.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.AaHO0E(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            B2KMhB(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i4 < 0) {
                int i6 = -appBarLayout.getDownNestedScrollRange();
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = AcNBzu(coordinatorLayout2, appBarLayout, ARc23Z() - i4, i6, 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i4 == 0 && DG07BK.ADYaiT(coordinatorLayout2) == null) {
                DG07BK.B4ZgIw(coordinatorLayout2, new com.google.android.material.appbar.A4TApA(coordinatorLayout2, this, appBarLayout));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            if (!(parcelable instanceof ADYaiT)) {
                this.f11311BIYEnU = null;
                return;
            }
            ADYaiT aDYaiT = (ADYaiT) parcelable;
            this.f11311BIYEnU = aDYaiT;
            aDYaiT.getSuperState();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            ADYaiT B3GDIM2 = B3GDIM(absSavedState, (AppBarLayout) view);
            return B3GDIM2 == null ? absSavedState : B3GDIM2;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && (appBarLayout.f11291BChYOn || appBarLayout.f11290B9tovu || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z && (valueAnimator = this.f11310BI9f7h) != null) {
                valueAnimator.cancel();
            }
            this.f11312BJ7GGh = null;
            this.f11309BChYOn = i2;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f11309BChYOn == 0 || i == 1) {
                B4ZgIw(coordinatorLayout, appBarLayout);
                if (appBarLayout.f11291BChYOn) {
                    appBarLayout.AMqCpz(appBarLayout.ARc23Z(view2));
                }
            }
            this.f11312BJ7GGh = new WeakReference(view2);
        }

        public BaseBehavior() {
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        AMqCpz aMqCpz = new AMqCpz(-1, -2);
        aMqCpz.f11277A2egSU = 1;
        return aMqCpz;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return A4TApA(layoutParams);
    }
}
