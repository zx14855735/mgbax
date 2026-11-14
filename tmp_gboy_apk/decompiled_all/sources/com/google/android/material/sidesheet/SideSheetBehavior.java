package com.google.android.material.sidesheet;

import ADYaiT.CtFAbx;
import BTvldC.B25kr6;
import COJEAR.DG07BK;
import CQhlFr.B7CMnp;
import CqNSpT.ARc23Z;
import Ogw3zR.A4TApA;
import Ogw3zR.AZkASS;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PMC23c.A2egSU;
import PMC23c.ADYaiT;
import PMC23c.AMqCpz;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.A5SV6n;
import com.google.android.material.R$styleable;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.A2egSU implements A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A5SV6n f11788AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AaHO0E f11789AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ColorStateList f11790AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final B2KMhB f11791AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final IzHBwY.A4TApA f11792B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final float f11793B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final boolean f11794B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f11795B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public ARc23Z f11796B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f11797B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final float f11798BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f11799BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f11800BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f11801BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f11802BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public WeakReference f11803BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public WeakReference f11804BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final int f11805BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public VelocityTracker f11806BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public AZkASS f11807BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final LinkedHashSet f11808C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final O1Vn2F.A4TApA f11809C4FrIb;

    public SideSheetBehavior() {
        this.f11792B25kr6 = new IzHBwY.A4TApA(this);
        this.f11794B3GDIM = true;
        this.f11795B4ZgIw = 5;
        this.f11798BChYOn = 0.1f;
        this.f11805BV3sI0 = -1;
        this.f11808C2rE4F = new LinkedHashSet();
        this.f11809C4FrIb = new O1Vn2F.A4TApA(this, 1);
    }

    @Override // Ogw3zR.A4TApA
    public final void A2egSU(androidx.activity.A4TApA a4TApA) {
        AZkASS aZkASS = this.f11807BniPrB;
        if (aZkASS == null) {
            return;
        }
        aZkASS.f6641ARc23Z = a4TApA;
    }

    @Override // Ogw3zR.A4TApA
    public final void A4TApA(androidx.activity.A4TApA a4TApA) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        AZkASS aZkASS = this.f11807BniPrB;
        if (aZkASS == null) {
            return;
        }
        A5SV6n a5SV6n = this.f11788AcNBzu;
        int i = (a5SV6n == null || a5SV6n.C2rE4F() == 0) ? 5 : 3;
        androidx.activity.A4TApA a4TApA2 = aZkASS.f6641ARc23Z;
        aZkASS.f6641ARc23Z = a4TApA;
        if (a4TApA2 != null) {
            aZkASS.A5SV6n(a4TApA.f7937A5SV6n, a4TApA.f7938ADYaiT == 0, i);
        }
        WeakReference weakReference = this.f11803BPw6Q8;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.f11803BPw6Q8.get();
        WeakReference weakReference2 = this.f11804BTvldC;
        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
        if (view2 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) == null) {
            return;
        }
        this.f11788AcNBzu.Ddcejp(marginLayoutParams, (int) ((view.getScaleX() * this.f11799BI9f7h) + this.f11802BNL6CD));
        view2.requestLayout();
    }

    @Override // Ogw3zR.A4TApA
    public final void A5SV6n() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        AZkASS aZkASS = this.f11807BniPrB;
        if (aZkASS == null) {
            return;
        }
        androidx.activity.A4TApA a4TApA = aZkASS.f6641ARc23Z;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        aZkASS.f6641ARc23Z = null;
        int i = 5;
        if (a4TApA == null || Build.VERSION.SDK_INT < 34) {
            setState(5);
            return;
        }
        A5SV6n a5SV6n = this.f11788AcNBzu;
        if (a5SV6n != null && a5SV6n.C2rE4F() != 0) {
            i = 3;
        }
        AaHO0E.A5SV6n a5SV6n2 = new AaHO0E.A5SV6n(12, this);
        WeakReference weakReference = this.f11804BTvldC;
        final View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            final int B9tovu2 = this.f11788AcNBzu.B9tovu(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: PMC23c.A5SV6n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SideSheetBehavior.this.f11788AcNBzu.Ddcejp(marginLayoutParams, NdEzCJ.A2egSU.A5SV6n(valueAnimator.getAnimatedFraction(), B9tovu2, 0));
                    view.requestLayout();
                }
            };
        }
        aZkASS.A4TApA(a4TApA, i, a5SV6n2, animatorUpdateListener);
    }

    @Override // Ogw3zR.A4TApA
    public final void ADYaiT() {
        AZkASS aZkASS = this.f11807BniPrB;
        if (aZkASS == null) {
            return;
        }
        aZkASS.A2egSU();
    }

    public final void AMqCpz(int i) {
        View view;
        if (this.f11795B4ZgIw == i) {
            return;
        }
        this.f11795B4ZgIw = i;
        WeakReference weakReference = this.f11803BPw6Q8;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = this.f11795B4ZgIw == 5 ? 4 : 0;
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        Iterator it = this.f11808C2rE4F.iterator();
        while (it.hasNext()) {
            ((AMqCpz) it.next()).A4TApA();
        }
        AYUAbz();
    }

    public final boolean ARc23Z() {
        if (this.f11796B7CMnp != null) {
            return this.f11794B3GDIM || this.f11795B4ZgIw == 1;
        }
        return false;
    }

    public final void ASJ6gh(View view, int i, boolean z) {
        int BIYEnU2;
        if (i == 3) {
            BIYEnU2 = this.f11788AcNBzu.BIYEnU();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Invalid state to get outer edge offset: "));
            }
            BIYEnU2 = this.f11788AcNBzu.BJ7GGh();
        }
        ARc23Z aRc23Z = this.f11796B7CMnp;
        if (aRc23Z == null || (!z ? aRc23Z.B3GDIM(view, BIYEnU2, view.getTop()) : aRc23Z.B25kr6(BIYEnU2, view.getTop()))) {
            AMqCpz(i);
        } else {
            AMqCpz(2);
            this.f11792B25kr6.A2egSU(i);
        }
    }

    public final void AYUAbz() {
        View view;
        WeakReference weakReference = this.f11803BPw6Q8;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        DG07BK.B25kr6(262144, view);
        DG07BK.AaHO0E(0, view);
        DG07BK.B25kr6(1048576, view);
        DG07BK.AaHO0E(0, view);
        final int i = 5;
        if (this.f11795B4ZgIw != 5) {
            DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1763AcNBzu, null, new B7CMnp() { // from class: PMC23c.A4TApA
                @Override // CQhlFr.B7CMnp
                public final boolean ADYaiT(View view2) {
                    SideSheetBehavior.this.setState(i);
                    return true;
                }
            });
        }
        final int i2 = 3;
        if (this.f11795B4ZgIw != 3) {
            DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1761AZkASS, null, new B7CMnp() { // from class: PMC23c.A4TApA
                @Override // CQhlFr.B7CMnp
                public final boolean ADYaiT(View view2) {
                    SideSheetBehavior.this.setState(i2);
                    return true;
                }
            });
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onAttachedToLayoutParams(androidx.coordinatorlayout.widget.A5SV6n a5SV6n) {
        super.onAttachedToLayoutParams(a5SV6n);
        this.f11803BPw6Q8 = null;
        this.f11796B7CMnp = null;
        this.f11807BniPrB = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f11803BPw6Q8 = null;
        this.f11796B7CMnp = null;
        this.f11807BniPrB = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ARc23Z aRc23Z;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && DG07BK.AMqCpz(view) == null) || !this.f11794B3GDIM) {
            this.f11797B9tovu = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f11806BmvVmW) != null) {
            velocityTracker.recycle();
            this.f11806BmvVmW = null;
        }
        if (this.f11806BmvVmW == null) {
            this.f11806BmvVmW = VelocityTracker.obtain();
        }
        this.f11806BmvVmW.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.BpkvW3 = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f11797B9tovu) {
            this.f11797B9tovu = false;
            return false;
        }
        return (this.f11797B9tovu || (aRc23Z = this.f11796B7CMnp) == null || !aRc23Z.B2KMhB(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        View view2;
        View view3;
        int i2;
        View findViewById;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int i3 = 0;
        if (this.f11803BPw6Q8 == null) {
            this.f11803BPw6Q8 = new WeakReference(view);
            this.f11807BniPrB = new AZkASS(view);
            AaHO0E aaHO0E = this.f11789AlLFFp;
            if (aaHO0E != null) {
                view.setBackground(aaHO0E);
                AaHO0E aaHO0E2 = this.f11789AlLFFp;
                float f = this.f11793B2KMhB;
                if (f == -1.0f) {
                    f = view.getElevation();
                }
                aaHO0E2.B2KMhB(f);
            } else {
                ColorStateList colorStateList = this.f11790AmA8tU;
                if (colorStateList != null) {
                    DG07BK.B9tovu(view, colorStateList);
                }
            }
            int i4 = this.f11795B4ZgIw == 5 ? 4 : 0;
            if (view.getVisibility() != i4) {
                view.setVisibility(i4);
            }
            AYUAbz();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (DG07BK.AMqCpz(view) == null) {
                DG07BK.B7CMnp(view, view.getResources().getString(2131886784));
            }
        }
        int i5 = Gravity.getAbsoluteGravity(((androidx.coordinatorlayout.widget.A5SV6n) view.getLayoutParams()).f8429A5SV6n, i) == 3 ? 1 : 0;
        A5SV6n a5SV6n = this.f11788AcNBzu;
        if (a5SV6n == null || a5SV6n.C2rE4F() != i5) {
            B2KMhB b2KMhB = this.f11791AzWtSf;
            androidx.coordinatorlayout.widget.A5SV6n a5SV6n2 = null;
            if (i5 == 0) {
                this.f11788AcNBzu = new A2egSU(this, 1);
                if (b2KMhB != null) {
                    WeakReference weakReference = this.f11803BPw6Q8;
                    if (weakReference != null && (view3 = (View) weakReference.get()) != null && (view3.getLayoutParams() instanceof androidx.coordinatorlayout.widget.A5SV6n)) {
                        a5SV6n2 = (androidx.coordinatorlayout.widget.A5SV6n) view3.getLayoutParams();
                    }
                    if (a5SV6n2 == null || ((ViewGroup.MarginLayoutParams) a5SV6n2).rightMargin <= 0) {
                        B2KMhB.A2egSU ASJ6gh2 = b2KMhB.ASJ6gh();
                        ASJ6gh2.ASJ6gh(0.0f);
                        ASJ6gh2.AMqCpz(0.0f);
                        B2KMhB A2egSU2 = ASJ6gh2.A2egSU();
                        AaHO0E aaHO0E3 = this.f11789AlLFFp;
                        if (aaHO0E3 != null) {
                            aaHO0E3.setShapeAppearanceModel(A2egSU2);
                        }
                    }
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalArgumentException(CtFAbx.ASJ6gh(i5, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f11788AcNBzu = new A2egSU(this, 0);
                if (b2KMhB != null) {
                    WeakReference weakReference2 = this.f11803BPw6Q8;
                    if (weakReference2 != null && (view2 = (View) weakReference2.get()) != null && (view2.getLayoutParams() instanceof androidx.coordinatorlayout.widget.A5SV6n)) {
                        a5SV6n2 = (androidx.coordinatorlayout.widget.A5SV6n) view2.getLayoutParams();
                    }
                    if (a5SV6n2 == null || ((ViewGroup.MarginLayoutParams) a5SV6n2).leftMargin <= 0) {
                        B2KMhB.A2egSU ASJ6gh3 = b2KMhB.ASJ6gh();
                        ASJ6gh3.ARc23Z(0.0f);
                        ASJ6gh3.ADYaiT(0.0f);
                        B2KMhB A2egSU3 = ASJ6gh3.A2egSU();
                        AaHO0E aaHO0E4 = this.f11789AlLFFp;
                        if (aaHO0E4 != null) {
                            aaHO0E4.setShapeAppearanceModel(A2egSU3);
                        }
                    }
                }
            }
        }
        if (this.f11796B7CMnp == null) {
            this.f11796B7CMnp = new ARc23Z(coordinatorLayout.getContext(), coordinatorLayout, this.f11809C4FrIb);
        }
        int BniPrB2 = this.f11788AcNBzu.BniPrB(view);
        coordinatorLayout.AZkASS(i, view);
        this.f11800BIYEnU = coordinatorLayout.getWidth();
        this.f11801BJ7GGh = this.f11788AcNBzu.BpkvW3(coordinatorLayout);
        this.f11799BI9f7h = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f11802BNL6CD = marginLayoutParams != null ? this.f11788AcNBzu.AzWtSf(marginLayoutParams) : 0;
        int i6 = this.f11795B4ZgIw;
        if (i6 == 1 || i6 == 2) {
            i3 = BniPrB2 - this.f11788AcNBzu.BniPrB(view);
        } else if (i6 != 3) {
            if (i6 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f11795B4ZgIw);
            }
            i3 = this.f11788AcNBzu.BJ7GGh();
        }
        DG07BK.AcNBzu(i3, view);
        if (this.f11804BTvldC == null && (i2 = this.f11805BV3sI0) != -1 && (findViewById = coordinatorLayout.findViewById(i2)) != null) {
            this.f11804BTvldC = new WeakReference(findViewById);
        }
        for (AMqCpz aMqCpz : this.f11808C2rE4F) {
            if (aMqCpz != null) {
                aMqCpz.getClass();
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        ADYaiT aDYaiT = (ADYaiT) parcelable;
        if (aDYaiT.getSuperState() != null) {
            aDYaiT.getSuperState();
        }
        int i = aDYaiT.f7171AcNBzu;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.f11795B4ZgIw = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new ADYaiT(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11795B4ZgIw == 1 && actionMasked == 0) {
            return true;
        }
        if (ARc23Z()) {
            this.f11796B7CMnp.AZkASS(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f11806BmvVmW) != null) {
            velocityTracker.recycle();
            this.f11806BmvVmW = null;
        }
        if (this.f11806BmvVmW == null) {
            this.f11806BmvVmW = VelocityTracker.obtain();
        }
        this.f11806BmvVmW.addMovement(motionEvent);
        if (ARc23Z() && actionMasked == 2 && !this.f11797B9tovu && ARc23Z()) {
            float abs = Math.abs(this.BpkvW3 - motionEvent.getX());
            ARc23Z aRc23Z = this.f11796B7CMnp;
            if (abs > aRc23Z.f1838A4TApA) {
                aRc23Z.A4TApA(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f11797B9tovu;
    }

    public final void setState(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(CtFAbx.B25kr6(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = this.f11803BPw6Q8;
        if (weakReference == null || weakReference.get() == null) {
            AMqCpz(i);
            return;
        }
        View view = (View) this.f11803BPw6Q8.get();
        B25kr6 b25kr6 = new B25kr6(i, 2, this);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(b25kr6);
        } else {
            b25kr6.run();
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.f11792B25kr6 = new IzHBwY.A4TApA(this);
        this.f11794B3GDIM = true;
        this.f11795B4ZgIw = 5;
        this.f11798BChYOn = 0.1f;
        this.f11805BV3sI0 = -1;
        this.f11808C2rE4F = new LinkedHashSet();
        this.f11809C4FrIb = new O1Vn2F.A4TApA(this, 1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11257CtFAbx);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f11790AmA8tU = com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f11791AzWtSf = B2KMhB.A5SV6n(context, attributeSet, 0, 2131952775).A2egSU();
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.f11805BV3sI0 = resourceId;
            WeakReference weakReference = this.f11804BTvldC;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f11804BTvldC = null;
            WeakReference weakReference2 = this.f11803BPw6Q8;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        B2KMhB b2KMhB = this.f11791AzWtSf;
        if (b2KMhB != null) {
            AaHO0E aaHO0E = new AaHO0E(b2KMhB);
            this.f11789AlLFFp = aaHO0E;
            aaHO0E.AmA8tU(context);
            ColorStateList colorStateList = this.f11790AmA8tU;
            if (colorStateList != null) {
                this.f11789AlLFFp.B3GDIM(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.f11789AlLFFp.setTint(typedValue.data);
            }
        }
        this.f11793B2KMhB = obtainStyledAttributes.getDimension(2, -1.0f);
        this.f11794B3GDIM = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
