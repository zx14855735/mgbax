package com.google.android.material.navigationrail;

import AaHO0E.GYpKKt;
import DaOi9o.AMqCpz;
import DaOi9o.ASJ6gh;
import DaOi9o.BJ7GGh;
import DaOi9o.BPw6Q8;
import IQ76hF.AmA8tU;
import NdEzCJ.A2egSU;
import Oay4Bh.C4FrIb;
import OpB85q.A5SV6n;
import OpB85q.ARc23Z;
import OpB85q.AZOQYO;
import OpB85q.AZkASS;
import OpB85q.B2KMhB;
import OsNEEq.A4TApA;
import OsNEEq.ADYaiT;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.google.android.material.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NavigationRailView extends B2KMhB {

    /* renamed from: CASmeH, reason: collision with root package name */
    public static final PathInterpolator f11720CASmeH = new PathInterpolator(0.38f, 1.21f, 0.22f, 1.0f);

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f11721B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f11722B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f11723B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final View f11724B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final Boolean f11725BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final Boolean f11726BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Boolean f11727BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f11728BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f11729BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f11730BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f11731BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f11732BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f11733BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f11734BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f11735C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final A4TApA f11736C4FrIb;

    static {
        yKmKe();
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969668, 2131952888);
        this.f11725BChYOn = null;
        this.f11726BI9f7h = null;
        this.f11727BIYEnU = null;
        this.f11728BJ7GGh = false;
        this.f11730BPw6Q8 = -1;
        this.f11731BTvldC = 0;
        this.f11732BV3sI0 = 49;
        Context context2 = getContext();
        this.f11735C2rE4F = getContext().getResources().getDimensionPixelSize(2131166107);
        this.BpkvW3 = 8388627;
        this.f11734BniPrB = 1;
        GYpKKt AzWtSf2 = C4FrIb.AzWtSf(context2, attributeSet, R$styleable.f11248CSDoyG, 2130969668, 2131952888, new int[0]);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131166475);
        TypedArray typedArray = AzWtSf2.f884A4TApA;
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(1, dimensionPixelSize);
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(7, getResources().getDimensionPixelSize(2131166475));
        boolean z = typedArray.getBoolean(14, false);
        setSubmenuDividersEnabled(typedArray.getBoolean(17, false));
        View view = (View) getMenuView();
        A4TApA a4TApA = new A4TApA(getContext());
        a4TApA.f6817AcNBzu = 0;
        a4TApA.f6818AlLFFp = false;
        this.f11736C4FrIb = a4TApA;
        a4TApA.setPaddingTop(dimensionPixelSize2);
        this.f11736C4FrIb.setScrollingEnabled(z);
        this.f11736C4FrIb.setClipChildren(false);
        this.f11736C4FrIb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f11736C4FrIb.addView(view);
        if (z) {
            ScrollView scrollView = new ScrollView(getContext());
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.addView(this.f11736C4FrIb);
            scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(scrollView);
        } else {
            addView(this.f11736C4FrIb);
        }
        int resourceId = typedArray.getResourceId(6, 0);
        if (resourceId != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
            View view2 = this.f11724B9tovu;
            if (view2 != null) {
                this.f11736C4FrIb.removeView(view2);
                this.f11724B9tovu = null;
            }
            this.f11724B9tovu = inflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.bottomMargin = dimensionPixelSize3;
            this.f11736C4FrIb.addView(inflate, 0, layoutParams);
        }
        setMenuGravity(typedArray.getInt(10, 49));
        int dimensionPixelSize4 = typedArray.getDimensionPixelSize(8, -1);
        int dimensionPixelSize5 = typedArray.getDimensionPixelSize(8, -1);
        dimensionPixelSize4 = typedArray.hasValue(0) ? typedArray.getDimensionPixelSize(0, -1) : dimensionPixelSize4;
        dimensionPixelSize5 = typedArray.hasValue(3) ? typedArray.getDimensionPixelSize(3, -1) : dimensionPixelSize5;
        setCollapsedItemMinimumHeight(dimensionPixelSize4);
        setExpandedItemMinimumHeight(dimensionPixelSize5);
        this.f11721B3GDIM = typedArray.getDimensionPixelSize(5, context2.getResources().getDimensionPixelSize(2131166122));
        this.f11722B4ZgIw = typedArray.getDimensionPixelSize(4, context2.getResources().getDimensionPixelSize(2131166121));
        if (typedArray.hasValue(13)) {
            this.f11725BChYOn = Boolean.valueOf(typedArray.getBoolean(13, false));
        }
        if (typedArray.hasValue(11)) {
            this.f11726BI9f7h = Boolean.valueOf(typedArray.getBoolean(11, false));
        }
        if (typedArray.hasValue(12)) {
            this.f11727BIYEnU = Boolean.valueOf(typedArray.getBoolean(12, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131166119);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(2131166117);
        float A4TApA2 = A2egSU.A4TApA(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f);
        float A5SV6n2 = A2egSU.A5SV6n(A4TApA2, getItemPaddingTop(), dimensionPixelOffset);
        float A5SV6n3 = A2egSU.A5SV6n(A4TApA2, getItemPaddingBottom(), dimensionPixelOffset2);
        setItemPaddingTop(Math.round(A5SV6n2));
        setItemPaddingBottom(Math.round(A5SV6n3));
        setCollapsedItemSpacing(typedArray.getDimensionPixelSize(9, 0));
        setExpanded(typedArray.getBoolean(2, false));
        AzWtSf2.ASJ6gh();
        C4FrIb.ASJ6gh(this, new AmA8tU(25, this));
    }

    private int getMaxChildWidth() {
        int childCount = getNavigationRailMenuView().getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getNavigationRailMenuView().getChildAt(i2);
            if (childAt.getVisibility() != 8 && !(childAt instanceof A5SV6n)) {
                i = Math.max(i, childAt.getMeasuredWidth());
            }
        }
        return i;
    }

    private ADYaiT getNavigationRailMenuView() {
        return (ADYaiT) getMenuView();
    }

    private void setExpanded(boolean z) {
        if (this.f11728BJ7GGh == z) {
            return;
        }
        if (isLaidOut()) {
            AMqCpz aMqCpz = new AMqCpz();
            aMqCpz.f2240AmA8tU = 500L;
            aMqCpz.f2241AzWtSf = f11720CASmeH;
            ASJ6gh aSJ6gh = new ASJ6gh();
            aSJ6gh.f2240AmA8tU = 100L;
            ASJ6gh aSJ6gh2 = new ASJ6gh();
            aSJ6gh2.f2240AmA8tU = 100L;
            OsNEEq.A2egSU a2egSU = new OsNEEq.A2egSU();
            ASJ6gh aSJ6gh3 = new ASJ6gh();
            aSJ6gh3.f2240AmA8tU = 100L;
            int childCount = getNavigationRailMenuView().getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getNavigationRailMenuView().getChildAt(i);
                if (childAt instanceof ARc23Z) {
                    ARc23Z aRc23Z = (ARc23Z) childAt;
                    aMqCpz.AmA8tU(aRc23Z.getLabelGroup());
                    aMqCpz.AmA8tU(aRc23Z.getExpandedLabelGroup());
                    if (this.f11728BJ7GGh) {
                        aSJ6gh2.A4TApA(aRc23Z.getExpandedLabelGroup());
                        aSJ6gh.A4TApA(aRc23Z.getLabelGroup());
                    } else {
                        aSJ6gh2.A4TApA(aRc23Z.getLabelGroup());
                        aSJ6gh.A4TApA(aRc23Z.getExpandedLabelGroup());
                    }
                    a2egSU.A4TApA(aRc23Z.getExpandedLabelGroup());
                }
                aSJ6gh3.A4TApA(childAt);
            }
            BPw6Q8 bPw6Q8 = new BPw6Q8();
            bPw6Q8.CTkVKb(0);
            bPw6Q8.COJEAR(aMqCpz);
            bPw6Q8.COJEAR(aSJ6gh);
            bPw6Q8.COJEAR(a2egSU);
            if (!this.f11728BJ7GGh) {
                bPw6Q8.COJEAR(aSJ6gh3);
            }
            BPw6Q8 bPw6Q82 = new BPw6Q8();
            bPw6Q82.CTkVKb(0);
            bPw6Q82.COJEAR(aSJ6gh2);
            if (this.f11728BJ7GGh) {
                bPw6Q82.COJEAR(aSJ6gh3);
            }
            BPw6Q8 bPw6Q83 = new BPw6Q8();
            bPw6Q83.CTkVKb(1);
            bPw6Q83.COJEAR(bPw6Q82);
            bPw6Q83.COJEAR(bPw6Q8);
            BJ7GGh.A2egSU((ViewGroup) getParent(), bPw6Q83);
        }
        this.f11728BJ7GGh = z;
        int i2 = this.f11731BTvldC;
        int i3 = this.f11729BNL6CD;
        int i4 = this.f11730BPw6Q8;
        int i5 = this.f11732BV3sI0;
        if (z) {
            i2 = this.f11734BniPrB;
            i3 = this.f11735C2rE4F;
            i4 = this.f11733BmvVmW;
            i5 = this.BpkvW3;
        }
        getNavigationRailMenuView().setItemGravity(i5);
        super.setItemIconGravity(i2);
        getNavigationRailMenuView().setItemSpacing(i3);
        getNavigationRailMenuView().setItemMinimumHeight(i4);
        getNavigationRailMenuView().setExpanded(z);
    }

    private static /* synthetic */ void yKmKe() {
        char[] charArray = "R^\\\u001fVP\\T\u001fS^H\u001fBYT]]\u001f{_XsCXUVT".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '1');
        }
        String str = new String(charArray);
        char[] charArray2 = "R]X_XE".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '1');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // OpB85q.B2KMhB
    public final AZkASS A2egSU(Context context) {
        return new ADYaiT(context);
    }

    public int getCollapsedItemMinimumHeight() {
        return this.f11730BPw6Q8;
    }

    @Override // OpB85q.B2KMhB
    public int getCollapsedMaxItemCount() {
        return 7;
    }

    public int getExpandedItemMinimumHeight() {
        return this.f11733BmvVmW;
    }

    public View getHeaderView() {
        return this.f11724B9tovu;
    }

    @Override // OpB85q.B2KMhB
    public int getItemGravity() {
        return getNavigationRailMenuView().getItemGravity();
    }

    @Override // OpB85q.B2KMhB
    public int getItemIconGravity() {
        return getNavigationRailMenuView().getItemIconGravity();
    }

    public int getItemMinimumHeight() {
        return getNavigationRailMenuView().getItemMinimumHeight();
    }

    public int getItemSpacing() {
        return getNavigationRailMenuView().getItemSpacing();
    }

    @Override // OpB85q.B2KMhB
    public int getMaxItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public boolean getSubmenuDividersEnabled() {
        return this.f11723B7CMnp;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int makeMeasureSpec = (View.MeasureSpec.getMode(i) == 1073741824 || suggestedMinimumWidth <= 0) ? i : View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        if (this.f11728BJ7GGh) {
            measureChild(getNavigationRailMenuView(), i, i2);
            View view = this.f11724B9tovu;
            if (view != null) {
                measureChild(view, i, i2);
            }
            int maxChildWidth = getMaxChildWidth();
            int min = Math.min(this.f11721B3GDIM, View.MeasureSpec.getSize(i));
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                int max = Math.max(maxChildWidth, min);
                View view2 = this.f11724B9tovu;
                if (view2 != null) {
                    max = Math.max(max, view2.getMeasuredWidth());
                }
                i = View.MeasureSpec.makeMeasureSpec(Math.max(getSuggestedMinimumWidth(), Math.min(max, this.f11722B4ZgIw)), 1073741824);
            }
            if (getItemActiveIndicatorExpandedWidth() == -1) {
                ADYaiT navigationRailMenuView = getNavigationRailMenuView();
                int size = View.MeasureSpec.getSize(i);
                AZOQYO[] azoqyoArr = navigationRailMenuView.f6738B3GDIM;
                if (azoqyoArr != null) {
                    for (AZOQYO azoqyo : azoqyoArr) {
                        if (azoqyo instanceof ARc23Z) {
                            ((ARc23Z) azoqyo).AZkASS(size);
                        }
                    }
                }
            }
            makeMeasureSpec = i;
        }
        super.onMeasure(makeMeasureSpec, i2);
        if (this.f11736C4FrIb.getMeasuredHeight() < getMeasuredHeight()) {
            measureChild(this.f11736C4FrIb, makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCollapsedItemMinimumHeight(int i) {
        this.f11730BPw6Q8 = i;
        if (this.f11728BJ7GGh) {
            return;
        }
        ((ADYaiT) getMenuView()).setItemMinimumHeight(i);
    }

    public void setCollapsedItemSpacing(int i) {
        this.f11729BNL6CD = i;
        if (this.f11728BJ7GGh) {
            return;
        }
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setExpandedItemMinimumHeight(int i) {
        this.f11733BmvVmW = i;
        if (this.f11728BJ7GGh) {
            ((ADYaiT) getMenuView()).setItemMinimumHeight(i);
        }
    }

    @Override // OpB85q.B2KMhB
    public void setItemGravity(int i) {
        this.f11732BV3sI0 = i;
        this.BpkvW3 = i;
        super.setItemGravity(i);
    }

    @Override // OpB85q.B2KMhB
    public void setItemIconGravity(int i) {
        this.f11731BTvldC = i;
        this.f11734BniPrB = i;
        super.setItemIconGravity(i);
    }

    public void setItemMinimumHeight(int i) {
        this.f11730BPw6Q8 = i;
        this.f11733BmvVmW = i;
        ((ADYaiT) getMenuView()).setItemMinimumHeight(i);
    }

    public void setItemSpacing(int i) {
        this.f11729BNL6CD = i;
        this.f11735C2rE4F = i;
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }

    public void setSubmenuDividersEnabled(boolean z) {
        if (this.f11723B7CMnp == z) {
            return;
        }
        this.f11723B7CMnp = z;
        getNavigationRailMenuView().setSubmenuDividersEnabled(z);
    }
}
