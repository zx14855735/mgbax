package com.google.android.material.bottomappbar;

import AaHO0E.D8MqeW;
import AaHO0E.GnQT2j;
import NOd7IU.AlLFFp;
import NuExGq.A4TApA;
import NuExGq.ADYaiT;
import Oay4Bh.C4FrIb;
import Oay4Bh.CASmeH;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.A5SV6n;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BottomAppBar extends Toolbar implements androidx.coordinatorlayout.widget.A2egSU {

    /* renamed from: EUIRHA, reason: collision with root package name */
    public static final /* synthetic */ int f11351EUIRHA = 0;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public Integer f11352DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final AaHO0E f11353DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public AnimatorSet f11354DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public AnimatorSet f11355DXnQ0V;
    public int DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public int f11356DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public int f11357DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public final int f11358DdagTj;
    public int Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public int f11359De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public boolean f11360DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public final boolean f11361Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public final boolean f11362DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public final boolean f11363DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public boolean f11364DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public boolean f11365ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public Behavior f11366EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public int f11367EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public int f11368EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public int f11369EQurEW;

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130968713, 2131952822), attributeSet, 2130968713);
        AaHO0E aaHO0E = new AaHO0E();
        this.f11353DUi7mC = aaHO0E;
        this.f11364DyaChj = false;
        this.f11365ECyGFg = true;
        new NuExGq.A2egSU(this, 0);
        Context context2 = getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.AMqCpz, 2130968713, 2131952822, new int[0]);
        ColorStateList BPw6Q82 = AMqCpz.BPw6Q8(context2, AmA8tU2, 1);
        if (AmA8tU2.hasValue(12)) {
            setNavigationIconTint(AmA8tU2.getColor(12, -1));
        }
        int dimensionPixelSize = AmA8tU2.getDimensionPixelSize(2, 0);
        float dimensionPixelOffset = AmA8tU2.getDimensionPixelOffset(7, 0);
        float dimensionPixelOffset2 = AmA8tU2.getDimensionPixelOffset(8, 0);
        float dimensionPixelOffset3 = AmA8tU2.getDimensionPixelOffset(9, 0);
        this.DXuj49 = AmA8tU2.getInt(3, 0);
        this.f11356DaOi9o = AmA8tU2.getInt(6, 0);
        this.f11357DcUJf1 = AmA8tU2.getInt(5, 1);
        AmA8tU2.getBoolean(16, true);
        this.f11359De4eam = AmA8tU2.getInt(11, 0);
        this.f11360DjONCG = AmA8tU2.getBoolean(10, false);
        this.f11361Dphsd2 = AmA8tU2.getBoolean(13, false);
        this.f11362DuwtYk = AmA8tU2.getBoolean(14, false);
        this.f11363DvK7DB = AmA8tU2.getBoolean(15, false);
        this.Ddcejp = AmA8tU2.getDimensionPixelOffset(4, -1);
        boolean z = AmA8tU2.getBoolean(0, true);
        AmA8tU2.recycle();
        this.f11358DdagTj = getResources().getDimensionPixelOffset(2131166350);
        ADYaiT aDYaiT = new ADYaiT();
        aDYaiT.f6143AzWtSf = -1.0f;
        aDYaiT.f6141AlLFFp = dimensionPixelOffset;
        aDYaiT.f6140AcNBzu = dimensionPixelOffset2;
        if (dimensionPixelOffset3 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        aDYaiT.f6142AmA8tU = dimensionPixelOffset3;
        B2KMhB.A2egSU a2egSU = new B2KMhB.A2egSU();
        a2egSU.f7101AZOQYO = aDYaiT;
        aaHO0E.setShapeAppearanceModel(a2egSU.A2egSU());
        if (z) {
            aaHO0E.BChYOn(2);
        } else {
            aaHO0E.BChYOn(1);
            if (Build.VERSION.SDK_INT >= 28) {
                setOutlineAmbientShadowColor(0);
                setOutlineSpotShadowColor(0);
            }
        }
        Paint.Style style = Paint.Style.FILL;
        aaHO0E.B7CMnp();
        aaHO0E.AmA8tU(context2);
        aaHO0E.setTintList(BPw6Q82);
        setElevation(dimensionPixelSize);
        setBackground(aaHO0E);
        NGepWW.A2egSU a2egSU2 = new NGepWW.A2egSU(4, this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f11227B2KMhB, 2130968713, 2131952822);
        boolean z2 = obtainStyledAttributes.getBoolean(4, false);
        boolean z3 = obtainStyledAttributes.getBoolean(5, false);
        boolean z4 = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
        C4FrIb.ASJ6gh(this, new CASmeH(z2, z3, z4, a2egSU2));
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return this.f11367EH1KK8;
    }

    private int getFabAlignmentAnimationDuration() {
        return A5SV6n.D07BeM(getContext(), 2130969617, 300);
    }

    private float getFabTranslationX() {
        return BNL6CD(this.DXuj49);
    }

    private float getFabTranslationY() {
        if (this.f11357DcUJf1 == 1) {
            return -getTopEdgeTreatment().f6142AmA8tU;
        }
        BIYEnU();
        return 0;
    }

    private int getLeftInset() {
        return this.f11369EQurEW;
    }

    private int getRightInset() {
        return this.f11368EPdU4G;
    }

    private ADYaiT getTopEdgeTreatment() {
        return (ADYaiT) this.f11353DUi7mC.f7042AlLFFp.f7021A2egSU.f7090AZOQYO;
    }

    public final void BIYEnU() {
        if (getParent() instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getParent();
            List list = (List) coordinatorLayout.f8449AlLFFp.f1427A4TApA.get(this);
            ArrayList arrayList = coordinatorLayout.f8451AzWtSf;
            arrayList.clear();
            if (list != null) {
                arrayList.addAll(list);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
            }
        }
    }

    public final int BJ7GGh(ActionMenuView actionMenuView, int i) {
        int i2 = 0;
        if (this.f11359De4eam != 1) {
            return 0;
        }
        boolean z = getLayoutDirection() == 1;
        int measuredWidth = z ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof GnQT2j) && (((GnQT2j) childAt.getLayoutParams()).f891A2egSU & 8388615) == 8388611) {
                measuredWidth = z ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = z ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i4 = z ? this.f11368EPdU4G : -this.f11369EQurEW;
        if (getNavigationIcon() == null) {
            i2 = getResources().getDimensionPixelOffset(2131165658);
            if (!z) {
                i2 = -i2;
            }
        }
        return measuredWidth - ((right + i4) + i2);
    }

    public final float BNL6CD(int i) {
        boolean z = getLayoutDirection() == 1;
        if (i != 1) {
            return 0.0f;
        }
        BIYEnU();
        return ((getMeasuredWidth() / 2) - ((z ? this.f11369EQurEW : this.f11368EPdU4G) + this.f11358DdagTj)) * (z ? -1 : 1);
    }

    public final void BPw6Q8() {
        if (!isLaidOut()) {
            this.f11364DyaChj = false;
            return;
        }
        AnimatorSet animatorSet = this.f11355DXnQ0V;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ArrayList arrayList = new ArrayList();
        BIYEnU();
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            ofFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
            if (Math.abs(actionMenuView.getTranslationX() - BJ7GGh(actionMenuView, 0)) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                ofFloat2.addListener(new A4TApA(this, actionMenuView));
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playSequentially(ofFloat2, ofFloat);
                arrayList.add(animatorSet2);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(ofFloat);
            }
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(arrayList);
        this.f11355DXnQ0V = animatorSet3;
        animatorSet3.addListener(new NuExGq.A2egSU(this, 2));
        this.f11355DXnQ0V.start();
    }

    public final void BTvldC() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f11355DXnQ0V != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        BIYEnU();
        BmvVmW(actionMenuView, 0, false);
    }

    public final void BV3sI0() {
        ADYaiT topEdgeTreatment = getTopEdgeTreatment();
        getFabTranslationX();
        topEdgeTreatment.getClass();
        AaHO0E aaHO0E = this.f11353DUi7mC;
        if (this.f11365ECyGFg) {
            BIYEnU();
        }
        aaHO0E.B4ZgIw(0.0f);
        BIYEnU();
    }

    public final void BmvVmW(ActionMenuView actionMenuView, int i, boolean z) {
        D8MqeW d8MqeW = new D8MqeW(this, actionMenuView, i, 3, false);
        if (z) {
            actionMenuView.post(d8MqeW);
        } else {
            d8MqeW.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.f11353DUi7mC.f7042AlLFFp.f7025ARc23Z;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f6142AmA8tU;
    }

    public int getFabAlignmentMode() {
        return this.DXuj49;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.Ddcejp;
    }

    public int getFabAnchorMode() {
        return this.f11357DcUJf1;
    }

    public int getFabAnimationMode() {
        return this.f11356DaOi9o;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f6141AlLFFp;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f6140AcNBzu;
    }

    public boolean getHideOnScroll() {
        return this.f11360DjONCG;
    }

    public int getMenuAlignmentMode() {
        return this.f11359De4eam;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AlLFFp.CtxOCS(this, this.f11353DUi7mC);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            AnimatorSet animatorSet = this.f11355DXnQ0V;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f11354DV2E8K;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            BV3sI0();
            BIYEnU();
        }
        BTvldC();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof NuExGq.A5SV6n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        NuExGq.A5SV6n a5SV6n = (NuExGq.A5SV6n) parcelable;
        super.onRestoreInstanceState(a5SV6n.getSuperState());
        this.DXuj49 = a5SV6n.f6138AcNBzu;
        this.f11365ECyGFg = a5SV6n.f6139AlLFFp;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        NuExGq.A5SV6n a5SV6n = new NuExGq.A5SV6n(super.onSaveInstanceState());
        a5SV6n.f6138AcNBzu = this.DXuj49;
        a5SV6n.f6139AlLFFp = this.f11365ECyGFg;
        return a5SV6n;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        this.f11353DUi7mC.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            ADYaiT topEdgeTreatment = getTopEdgeTreatment();
            if (f < 0.0f) {
                topEdgeTreatment.getClass();
                throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
            }
            topEdgeTreatment.f6142AmA8tU = f;
            this.f11353DUi7mC.invalidateSelf();
            BV3sI0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        AaHO0E aaHO0E = this.f11353DUi7mC;
        aaHO0E.B2KMhB(f);
        int AZkASS2 = aaHO0E.f7042AlLFFp.f7035B25kr6 - aaHO0E.AZkASS();
        Behavior behavior = getBehavior();
        behavior.f11328BChYOn = AZkASS2;
        if (behavior.f11327B9tovu == 1) {
            setTranslationY(behavior.f11323B2KMhB + AZkASS2);
        }
    }

    public void setFabAlignmentMode(int i) {
        this.f11364DyaChj = true;
        BPw6Q8();
        if (this.DXuj49 != i && isLaidOut()) {
            AnimatorSet animatorSet = this.f11354DV2E8K;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f11356DaOi9o == 1) {
                BIYEnU();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, "translationX", BNL6CD(i));
                ofFloat.setDuration(getFabAlignmentAnimationDuration());
                arrayList.add(ofFloat);
            } else {
                BIYEnU();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            animatorSet2.setInterpolator(A5SV6n.D6DOie(getContext(), 2130969633, NdEzCJ.A2egSU.f6036A2egSU));
            this.f11354DV2E8K = animatorSet2;
            animatorSet2.addListener(new NuExGq.A2egSU(this, 1));
            this.f11354DV2E8K.start();
        }
        this.DXuj49 = i;
    }

    public void setFabAlignmentModeEndMargin(int i) {
        if (this.Ddcejp != i) {
            this.Ddcejp = i;
            BV3sI0();
        }
    }

    public void setFabAnchorMode(int i) {
        this.f11357DcUJf1 = i;
        BV3sI0();
        BIYEnU();
    }

    public void setFabAnimationMode(int i) {
        this.f11356DaOi9o = i;
    }

    public void setFabCornerSize(float f) {
        if (f != getTopEdgeTreatment().f6143AzWtSf) {
            getTopEdgeTreatment().f6143AzWtSf = f;
            this.f11353DUi7mC.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().f6141AlLFFp = f;
            this.f11353DUi7mC.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f6140AcNBzu = f;
            this.f11353DUi7mC.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.f11360DjONCG = z;
    }

    public void setMenuAlignmentMode(int i) {
        if (this.f11359De4eam != i) {
            this.f11359De4eam = i;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                int i2 = this.DXuj49;
                BIYEnU();
                BmvVmW(actionMenuView, i2, false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f11352DRlcZ9 != null) {
            drawable = A5SV6n.DvK7DB(drawable.mutate());
            drawable.setTint(this.f11352DRlcZ9.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.f11352DRlcZ9 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.coordinatorlayout.widget.A2egSU
    public Behavior getBehavior() {
        if (this.f11366EGM26s == null) {
            this.f11366EGM26s = new Behavior();
        }
        return this.f11366EGM26s;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: BIYEnU, reason: collision with root package name */
        public WeakReference f11370BIYEnU;

        public Behavior() {
            new A2egSU(this);
            new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f11370BIYEnU = new WeakReference(bottomAppBar);
            int i2 = BottomAppBar.f11351EUIRHA;
            bottomAppBar.BIYEnU();
            coordinatorLayout.AZkASS(i, bottomAppBar);
            super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view2, view3, i, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            new A2egSU(this);
            new Rect();
        }
    }
}
