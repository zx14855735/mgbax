package com.google.android.material.bottomsheet;

import ADYaiT.CtFAbx;
import ADYaiT.D9tr6l;
import AaHO0E.D8MqeW;
import C4FrIb.AmA8tU;
import COJEAR.DG07BK;
import COJEAR.ECyGFg;
import COJEAR.EGM26s;
import COJEAR.EH1KK8;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.A2egSU implements Ogw3zR.A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f11389AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f11390AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final float f11391AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f11392AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f11393B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f11394B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f11395B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f11396B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final AaHO0E f11397B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ColorStateList f11398B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int f11399BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f11400BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f11401BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final boolean f11402BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final boolean f11403BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final boolean f11404BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final boolean f11405BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final boolean f11406BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final boolean f11407BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final boolean f11408BniPrB;
    public final boolean BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f11409C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public int f11410C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final boolean f11411CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final B2KMhB f11412CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public boolean f11413COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final IzHBwY.A4TApA f11414CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final ValueAnimator f11415CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public final int f11416CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f11417CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public int f11418Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final float f11419CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public int f11420CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public final float f11421CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public boolean f11422CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public boolean f11423CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public boolean f11424CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public final boolean f11425CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public boolean f11426D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public int f11427D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public CqNSpT.ARc23Z f11428D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public boolean f11429D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public int f11430D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public boolean f11431D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public final float f11432DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f11433DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public int f11434DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public int f11435DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public WeakReference f11436DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public WeakReference f11437DXnQ0V;
    public WeakReference DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public WeakReference f11438DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public final ArrayList f11439DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public VelocityTracker f11440DdagTj;
    public Ogw3zR.ARc23Z Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public int f11441De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public int f11442DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public boolean f11443Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public HashMap f11444DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public final SparseIntArray f11445DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public final O1Vn2F.A4TApA f11446DyaChj;

    public static abstract class A2egSU {
        public void A2egSU(View view) {
        }

        public abstract void A4TApA(View view);

        public abstract void A5SV6n(int i, View view);
    }

    public BottomSheetBehavior() {
        this.f11389AcNBzu = 0;
        this.f11390AlLFFp = true;
        this.f11399BChYOn = -1;
        this.f11400BI9f7h = -1;
        this.f11414CQhlFr = new IzHBwY.A4TApA(this);
        this.f11419CikNvS = 0.5f;
        this.f11421CmUvjW = -1.0f;
        this.f11424CtFAbx = true;
        this.f11425CtxOCS = true;
        this.f11427D6DOie = 4;
        this.f11432DAk1zC = 0.1f;
        this.f11439DcUJf1 = new ArrayList();
        this.f11442DjONCG = -1;
        this.f11445DvK7DB = new SparseIntArray();
        this.f11446DyaChj = new O1Vn2F.A4TApA(this, 0);
    }

    public static View AZkASS(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View AZkASS2 = AZkASS(viewGroup.getChildAt(i));
            if (AZkASS2 != null) {
                return AZkASS2;
            }
        }
        return null;
    }

    public static BottomSheetBehavior AaHO0E(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof androidx.coordinatorlayout.widget.A5SV6n)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.A2egSU a2egSU = ((androidx.coordinatorlayout.widget.A5SV6n) layoutParams).f8427A2egSU;
        if (a2egSU instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) a2egSU;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public static int AcNBzu(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    @Override // Ogw3zR.A4TApA
    public final void A2egSU(androidx.activity.A4TApA a4TApA) {
        Ogw3zR.ARc23Z aRc23Z = this.Ddcejp;
        if (aRc23Z == null) {
            return;
        }
        aRc23Z.f6641ARc23Z = a4TApA;
    }

    @Override // Ogw3zR.A4TApA
    public final void A4TApA(androidx.activity.A4TApA a4TApA) {
        Ogw3zR.ARc23Z aRc23Z = this.Ddcejp;
        if (aRc23Z == null) {
            return;
        }
        androidx.activity.A4TApA a4TApA2 = aRc23Z.f6641ARc23Z;
        aRc23Z.f6641ARc23Z = a4TApA;
        if (a4TApA2 == null) {
            return;
        }
        aRc23Z.A4TApA(a4TApA.f7937A5SV6n);
    }

    @Override // Ogw3zR.A4TApA
    public final void A5SV6n() {
        Ogw3zR.ARc23Z aRc23Z = this.Ddcejp;
        if (aRc23Z == null) {
            return;
        }
        androidx.activity.A4TApA a4TApA = aRc23Z.f6641ARc23Z;
        aRc23Z.f6641ARc23Z = null;
        if (a4TApA == null || Build.VERSION.SDK_INT < 34) {
            setState(this.f11422CqNSpT ? 5 : 4);
            return;
        }
        boolean z = this.f11422CqNSpT;
        int i = aRc23Z.f6640ADYaiT;
        int i2 = aRc23Z.f6639A5SV6n;
        float f = a4TApA.f7937A5SV6n;
        if (!z) {
            AnimatorSet A2egSU2 = aRc23Z.A2egSU();
            A2egSU2.setDuration(NdEzCJ.A2egSU.A5SV6n(f, i2, i));
            A2egSU2.start();
            setState(4);
            return;
        }
        AaHO0E.A5SV6n a5SV6n = new AaHO0E.A5SV6n(7, this);
        View view = aRc23Z.f6638A4TApA;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getScaleY() * view.getHeight());
        ofFloat.setInterpolator(new D8cQ8b.A4TApA());
        ofFloat.setDuration(NdEzCJ.A2egSU.A5SV6n(f, i2, i));
        ofFloat.addListener(new AaHO0E.A5SV6n(9, aRc23Z));
        ofFloat.addListener(a5SV6n);
        ofFloat.start();
    }

    @Override // Ogw3zR.A4TApA
    public final void ADYaiT() {
        Ogw3zR.ARc23Z aRc23Z = this.Ddcejp;
        if (aRc23Z == null) {
            return;
        }
        androidx.activity.A4TApA a4TApA = aRc23Z.f6641ARc23Z;
        aRc23Z.f6641ARc23Z = null;
        if (a4TApA == null) {
            return;
        }
        AnimatorSet A2egSU2 = aRc23Z.A2egSU();
        A2egSU2.setDuration(aRc23Z.AMqCpz);
        A2egSU2.start();
    }

    public final void AMqCpz() {
        int ASJ6gh2 = ASJ6gh();
        if (this.f11390AlLFFp) {
            this.f11420CkXcdM = Math.max(this.f11435DUi7mC - ASJ6gh2, this.f11417CcAIMM);
        } else {
            this.f11420CkXcdM = this.f11435DUi7mC - ASJ6gh2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        r0 = r0.getRootWindowInsets();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float ARc23Z() {
        /*
            r5 = this;
            PCV8se.AaHO0E r0 = r5.f11397B7CMnp
            r1 = 0
            if (r0 == 0) goto L77
            java.lang.ref.WeakReference r0 = r5.f11436DV2E8K
            if (r0 == 0) goto L77
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L77
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L77
            java.lang.ref.WeakReference r0 = r5.f11436DV2E8K
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.AzWtSf()
            if (r2 == 0) goto L77
            android.view.WindowInsets r0 = com.bytedance.pangle.wrapper.AMqCpz.AaHO0E(r0)
            if (r0 == 0) goto L77
            PCV8se.AaHO0E r2 = r5.f11397B7CMnp
            float r2 = r2.AcNBzu()
            android.view.RoundedCorner r3 = COJEAR.ADYaiT.AYUAbz(r0)
            if (r3 == 0) goto L44
            int r3 = COJEAR.ADYaiT.A5SV6n(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            float r3 = r3 / r2
            goto L45
        L44:
            r3 = 0
        L45:
            PCV8se.AaHO0E r2 = r5.f11397B7CMnp
            float[] r4 = r2.f7068CTkVKb
            if (r4 == 0) goto L4f
            r2 = 0
            r2 = r4[r2]
            goto L5d
        L4f:
            PCV8se.AZOQYO r4 = r2.f7042AlLFFp
            PCV8se.B2KMhB r4 = r4.f7021A2egSU
            PCV8se.ADYaiT r4 = r4.f7087ARc23Z
            android.graphics.RectF r2 = r2.AYUAbz()
            float r2 = r4.A2egSU(r2)
        L5d:
            android.view.RoundedCorner r0 = COJEAR.ADYaiT.AmA8tU(r0)
            if (r0 == 0) goto L72
            int r0 = COJEAR.ADYaiT.A5SV6n(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L72
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L72
            float r1 = r0 / r2
        L72:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.ARc23Z():float");
    }

    public final int ASJ6gh() {
        int i;
        return this.f11394B2KMhB ? Math.min(Math.max(this.f11395B3GDIM, this.f11435DUi7mC - ((this.f11434DRlcZ9 * 9) / 16)), this.f11433DG07BK) + this.f11409C2rE4F : (this.f11402BJ7GGh || this.f11403BNL6CD || (i = this.f11401BIYEnU) <= 0) ? this.f11393B25kr6 + this.f11409C2rE4F : Math.max(this.f11393B25kr6, i + this.f11396B4ZgIw);
    }

    public final void AYUAbz(int i, View view) {
        if (view == null) {
            return;
        }
        DG07BK.B25kr6(524288, view);
        DG07BK.AaHO0E(0, view);
        DG07BK.B25kr6(262144, view);
        DG07BK.AaHO0E(0, view);
        DG07BK.B25kr6(1048576, view);
        DG07BK.AaHO0E(0, view);
        SparseIntArray sparseIntArray = this.f11445DvK7DB;
        int i2 = sparseIntArray.get(i, -1);
        if (i2 != -1) {
            DG07BK.B25kr6(i2, view);
            DG07BK.AaHO0E(0, view);
            sparseIntArray.delete(i);
        }
    }

    public final void AZOQYO(int i) {
        View view = (View) this.f11436DV2E8K.get();
        if (view != null) {
            ArrayList arrayList = this.f11439DcUJf1;
            if (arrayList.isEmpty()) {
                return;
            }
            int i2 = this.f11420CkXcdM;
            if (i <= i2 && i2 != AlLFFp()) {
                AlLFFp();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((A2egSU) arrayList.get(i3)).A4TApA(view);
            }
        }
    }

    public final int AlLFFp() {
        if (this.f11390AlLFFp) {
            return this.f11417CcAIMM;
        }
        return Math.max(this.f11416CTkVKb, this.f11406BV3sI0 ? 0 : this.f11410C4FrIb);
    }

    public final int AmA8tU(int i) {
        if (i == 3) {
            return AlLFFp();
        }
        if (i == 4) {
            return this.f11420CkXcdM;
        }
        if (i == 5) {
            return this.f11435DUi7mC;
        }
        if (i == 6) {
            return this.f11418Cd8JRx;
        }
        throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "Invalid state to get top offset: "));
    }

    public final boolean AzWtSf() {
        WeakReference weakReference = this.f11436DV2E8K;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.f11436DV2E8K.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void B25kr6(BottomSheetDragHandleView bottomSheetDragHandleView) {
        WeakReference weakReference;
        if (bottomSheetDragHandleView != null || (weakReference = this.f11437DXnQ0V) == null) {
            this.f11437DXnQ0V = new WeakReference(bottomSheetDragHandleView);
            B9tovu(1, bottomSheetDragHandleView);
        } else {
            AYUAbz(1, (View) weakReference.get());
            this.f11437DXnQ0V = null;
        }
    }

    public final void B2KMhB(int i) {
        View view;
        if (this.f11427D6DOie == i) {
            return;
        }
        this.f11427D6DOie = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z = this.f11422CqNSpT;
        }
        WeakReference weakReference = this.f11436DV2E8K;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = 0;
        if (i == 3) {
            BI9f7h(true);
        } else if (i == 6 || i == 5 || i == 4) {
            BI9f7h(false);
        }
        BChYOn(i, true);
        while (true) {
            ArrayList arrayList = this.f11439DcUJf1;
            if (i2 >= arrayList.size()) {
                B7CMnp();
                return;
            } else {
                ((A2egSU) arrayList.get(i2)).A5SV6n(i, view);
                i2++;
            }
        }
    }

    public final boolean B3GDIM(View view, float f) {
        if (this.f11423CrfGsy) {
            return true;
        }
        if (view.getTop() < this.f11420CkXcdM) {
            return false;
        }
        return Math.abs(((f * this.f11432DAk1zC) + ((float) view.getTop())) - ((float) this.f11420CkXcdM)) / ((float) ASJ6gh()) > 0.5f;
    }

    public final void B4ZgIw(View view, int i, boolean z) {
        int AmA8tU2 = AmA8tU(i);
        CqNSpT.ARc23Z aRc23Z = this.f11428D6yqiO;
        if (aRc23Z == null || (!z ? aRc23Z.B3GDIM(view, view.getLeft(), AmA8tU2) : aRc23Z.B25kr6(view.getLeft(), AmA8tU2))) {
            B2KMhB(i);
            return;
        }
        B2KMhB(2);
        BChYOn(i, true);
        this.f11414CQhlFr.A2egSU(i);
    }

    public final void B7CMnp() {
        WeakReference weakReference = this.f11436DV2E8K;
        if (weakReference != null) {
            B9tovu(0, (View) weakReference.get());
        }
        WeakReference weakReference2 = this.f11437DXnQ0V;
        if (weakReference2 != null) {
            B9tovu(1, (View) weakReference2.get());
        }
    }

    public final void B9tovu(int i, View view) {
        int i2;
        int i3;
        if (view == null) {
            return;
        }
        AYUAbz(i, view);
        if (!this.f11390AlLFFp && this.f11427D6DOie != 6) {
            String string = view.getResources().getString(2131886150);
            AmA8tU amA8tU = new AmA8tU(r4, this);
            ArrayList ARc23Z2 = DG07BK.ARc23Z(view);
            int i4 = 0;
            while (true) {
                if (i4 >= ARc23Z2.size()) {
                    int i5 = -1;
                    for (int i6 = 0; i6 < 32 && i5 == -1; i6++) {
                        int i7 = DG07BK.AMqCpz[i6];
                        boolean z = true;
                        for (int i8 = 0; i8 < ARc23Z2.size(); i8++) {
                            z &= ((CQhlFr.A5SV6n) ARc23Z2.get(i8)).A2egSU() != i7;
                        }
                        if (z) {
                            i5 = i7;
                        }
                    }
                    i2 = i5;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((CQhlFr.A5SV6n) ARc23Z2.get(i4)).f1767A2egSU).getLabel())) {
                        i2 = ((CQhlFr.A5SV6n) ARc23Z2.get(i4)).A2egSU();
                        break;
                    }
                    i4++;
                }
            }
            if (i2 != -1) {
                i3 = i2;
                CQhlFr.A5SV6n a5SV6n = new CQhlFr.A5SV6n(null, i3, string, amA8tU, null);
                View.AccessibilityDelegate ADYaiT2 = DG07BK.ADYaiT(view);
                COJEAR.A4TApA a4TApA = ADYaiT2 == null ? null : ADYaiT2 instanceof COJEAR.A2egSU ? ((COJEAR.A2egSU) ADYaiT2).f1613A2egSU : new COJEAR.A4TApA(ADYaiT2);
                if (a4TApA == null) {
                    a4TApA = new COJEAR.A4TApA();
                }
                DG07BK.B4ZgIw(view, a4TApA);
                DG07BK.B25kr6(a5SV6n.A2egSU(), view);
                DG07BK.ARc23Z(view).add(a5SV6n);
                DG07BK.AaHO0E(0, view);
            } else {
                i3 = i2;
            }
            this.f11445DvK7DB.put(i, i3);
        }
        if (this.f11422CqNSpT) {
            int i9 = 5;
            if (this.f11427D6DOie != 5) {
                DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1763AcNBzu, null, new AmA8tU(i9, this));
            }
        }
        int i10 = this.f11427D6DOie;
        int i11 = 4;
        int i12 = 3;
        if (i10 == 3) {
            DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1762AaHO0E, null, new AmA8tU(this.f11390AlLFFp ? 4 : 6, this));
            return;
        }
        if (i10 == 4) {
            DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1761AZkASS, null, new AmA8tU(this.f11390AlLFFp ? 3 : 6, this));
        } else {
            if (i10 != 6) {
                return;
            }
            DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1762AaHO0E, null, new AmA8tU(i11, this));
            DG07BK.B2KMhB(view, CQhlFr.A5SV6n.f1761AZkASS, null, new AmA8tU(i12, this));
        }
    }

    public final void BChYOn(int i, boolean z) {
        AaHO0E aaHO0E = this.f11397B7CMnp;
        ValueAnimator valueAnimator = this.f11415CSDoyG;
        if (i == 2) {
            return;
        }
        boolean z2 = this.f11427D6DOie == 3 && (this.f11411CASmeH || AzWtSf());
        if (this.f11413COJEAR == z2 || aaHO0E == null) {
            return;
        }
        this.f11413COJEAR = z2;
        if (!z || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            aaHO0E.B4ZgIw(this.f11413COJEAR ? ARc23Z() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(aaHO0E.f7042AlLFFp.f7029AZkASS, z2 ? ARc23Z() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void BI9f7h(boolean z) {
        WeakReference weakReference = this.f11436DV2E8K;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.f11444DuwtYk != null) {
                    return;
                } else {
                    this.f11444DuwtYk = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f11436DV2E8K.get() && z) {
                    this.f11444DuwtYk.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.f11444DuwtYk = null;
        }
    }

    public final void BIYEnU() {
        View view;
        if (this.f11436DV2E8K != null) {
            AMqCpz();
            if (this.f11427D6DOie != 4 || (view = (View) this.f11436DV2E8K.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onAttachedToLayoutParams(androidx.coordinatorlayout.widget.A5SV6n a5SV6n) {
        super.onAttachedToLayoutParams(a5SV6n);
        this.f11436DV2E8K = null;
        this.f11428D6yqiO = null;
        this.Ddcejp = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f11436DV2E8K = null;
        this.f11428D6yqiO = null;
        this.Ddcejp = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        CqNSpT.ARc23Z aRc23Z;
        if (!view.isShown() || !this.f11424CtFAbx) {
            this.f11429D8MqeW = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f11441De4eam = -1;
            this.f11442DjONCG = -1;
            VelocityTracker velocityTracker = this.f11440DdagTj;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f11440DdagTj = null;
            }
        }
        if (this.f11440DdagTj == null) {
            this.f11440DdagTj = VelocityTracker.obtain();
        }
        this.f11440DdagTj.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.f11442DjONCG = y;
            if (this.f11427D6DOie != 2) {
                WeakReference weakReference = this.f11438DaOi9o;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.AYUAbz(view2, x, y)) {
                    this.f11441De4eam = motionEvent.getPointerId(motionEvent.getActionIndex());
                    int i2 = this.f11442DjONCG;
                    WeakReference weakReference2 = this.DXuj49;
                    View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
                    if (view3 == null || !coordinatorLayout.AYUAbz(view3, x, i2)) {
                        this.f11443Dphsd2 = true;
                    }
                }
            }
            this.f11429D8MqeW = this.f11441De4eam == -1 && !coordinatorLayout.AYUAbz(view, x, this.f11442DjONCG);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f11443Dphsd2 = false;
            this.f11441De4eam = -1;
            if (this.f11429D8MqeW) {
                this.f11429D8MqeW = false;
                return false;
            }
        }
        if (this.f11429D8MqeW || (aRc23Z = this.f11428D6yqiO) == null || !aRc23Z.B2KMhB(motionEvent)) {
            WeakReference weakReference3 = this.f11438DaOi9o;
            View view4 = weakReference3 != null ? (View) weakReference3.get() : null;
            if (actionMasked != 2 || view4 == null || this.f11429D8MqeW || this.f11427D6DOie == 1 || coordinatorLayout.AYUAbz(view4, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f11428D6yqiO == null || (i = this.f11442DjONCG) == -1 || Math.abs(i - motionEvent.getY()) <= this.f11428D6yqiO.f1838A4TApA) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        AaHO0E aaHO0E = this.f11397B7CMnp;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int i2 = 0;
        if (this.f11436DV2E8K == null) {
            this.f11395B3GDIM = coordinatorLayout.getResources().getDimensionPixelSize(2131165300);
            int i3 = Build.VERSION.SDK_INT;
            boolean z = (i3 < 29 || this.f11402BJ7GGh || this.f11394B2KMhB) ? false : true;
            if (this.f11403BNL6CD || this.f11404BPw6Q8 || this.f11405BTvldC || this.f11407BmvVmW || this.f11408BniPrB || this.BpkvW3 || z) {
                C4FrIb.ASJ6gh(view, new D9tr6l(this, z));
            }
            COJEAR.ARc23Z aRc23Z = new COJEAR.ARc23Z(view);
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            if (i3 >= 30) {
                view.setWindowInsetsAnimationCallback(new EH1KK8(aRc23Z));
            } else {
                PathInterpolator pathInterpolator = EGM26s.AMqCpz;
                Object tag = view.getTag(2131298060);
                View.OnApplyWindowInsetsListener eCyGFg = new ECyGFg(view, aRc23Z);
                view.setTag(2131298068, eCyGFg);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(eCyGFg);
                }
            }
            this.f11436DV2E8K = new WeakReference(view);
            this.Ddcejp = new Ogw3zR.ARc23Z(view);
            if (aaHO0E != null) {
                view.setBackground(aaHO0E);
                float f = this.f11421CmUvjW;
                if (f == -1.0f) {
                    f = view.getElevation();
                }
                aaHO0E.B2KMhB(f);
            } else {
                ColorStateList colorStateList = this.f11398B9tovu;
                if (colorStateList != null) {
                    DG07BK.B9tovu(view, colorStateList);
                }
            }
            B7CMnp();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.f11428D6yqiO == null) {
            this.f11428D6yqiO = new CqNSpT.ARc23Z(coordinatorLayout.getContext(), coordinatorLayout, this.f11446DyaChj);
        }
        int top = view.getTop();
        coordinatorLayout.AZkASS(i, view);
        this.f11434DRlcZ9 = coordinatorLayout.getWidth();
        this.f11435DUi7mC = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.f11433DG07BK = height;
        int i4 = this.f11435DUi7mC;
        int i5 = i4 - height;
        int i6 = this.f11410C4FrIb;
        if (i5 < i6) {
            if (this.f11406BV3sI0) {
                int i7 = this.f11400BI9f7h;
                if (i7 != -1) {
                    i4 = Math.min(i4, i7);
                }
                this.f11433DG07BK = i4;
            } else {
                int i8 = i4 - i6;
                int i9 = this.f11400BI9f7h;
                if (i9 != -1) {
                    i8 = Math.min(i8, i9);
                }
                this.f11433DG07BK = i8;
            }
        }
        this.f11417CcAIMM = Math.max(0, this.f11435DUi7mC - this.f11433DG07BK);
        this.f11418Cd8JRx = (int) ((1.0f - this.f11419CikNvS) * this.f11435DUi7mC);
        AMqCpz();
        int i10 = this.f11427D6DOie;
        if (i10 == 3) {
            DG07BK.AlLFFp(AlLFFp(), view);
        } else if (i10 == 6) {
            DG07BK.AlLFFp(this.f11418Cd8JRx, view);
        } else if (this.f11422CqNSpT && i10 == 5) {
            DG07BK.AlLFFp(this.f11435DUi7mC, view);
        } else if (i10 == 4) {
            DG07BK.AlLFFp(this.f11420CkXcdM, view);
        } else if (i10 == 1 || i10 == 2) {
            DG07BK.AlLFFp(top - view.getTop(), view);
        }
        BChYOn(this.f11427D6DOie, false);
        this.f11438DaOi9o = new WeakReference(AZkASS(view));
        while (true) {
            ArrayList arrayList = this.f11439DcUJf1;
            if (i2 >= arrayList.size()) {
                return true;
            }
            ((A2egSU) arrayList.get(i2)).A2egSU(view);
            i2++;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(AcNBzu(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.f11399BChYOn, marginLayoutParams.width), AcNBzu(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, this.f11400BI9f7h, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
        WeakReference weakReference = this.f11438DaOi9o;
        return (weakReference == null || view2 != weakReference.get() || this.f11427D6DOie == 3 || this.f11426D07BeM) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.f11438DaOi9o;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (!this.f11431D9tr6l && !this.f11425CtxOCS && view2 == view3 && view2.canScrollVertically(1)) {
                this.f11426D07BeM = true;
                return;
            }
            if (i4 < AlLFFp()) {
                int AlLFFp2 = top - AlLFFp();
                iArr[1] = AlLFFp2;
                DG07BK.AlLFFp(-AlLFFp2, view);
                B2KMhB(3);
            } else {
                if (!this.f11424CtFAbx) {
                    return;
                }
                iArr[1] = i2;
                DG07BK.AlLFFp(-i2, view);
                B2KMhB(1);
            }
        } else if (i2 < 0) {
            boolean canScrollVertically = view2.canScrollVertically(-1);
            if (!this.f11431D9tr6l && !this.f11425CtxOCS && view2 == view3 && canScrollVertically) {
                this.f11426D07BeM = true;
                return;
            }
            if (!canScrollVertically) {
                int i5 = this.f11420CkXcdM;
                if (i4 > i5 && !this.f11422CqNSpT) {
                    int i6 = top - i5;
                    iArr[1] = i6;
                    DG07BK.AlLFFp(-i6, view);
                    B2KMhB(4);
                } else {
                    if (!this.f11424CtFAbx) {
                        return;
                    }
                    iArr[1] = i2;
                    DG07BK.AlLFFp(-i2, view);
                    B2KMhB(1);
                }
            }
        }
        AZOQYO(view.getTop());
        this.f11430D8cQ8b = i2;
        this.f11431D9tr6l = true;
        this.f11426D07BeM = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        O1Vn2F.A5SV6n a5SV6n = (O1Vn2F.A5SV6n) parcelable;
        a5SV6n.getSuperState();
        int i = this.f11389AcNBzu;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.f11393B25kr6 = a5SV6n.f6153AlLFFp;
            }
            if (i == -1 || (i & 2) == 2) {
                this.f11390AlLFFp = a5SV6n.f6154AmA8tU;
            }
            if (i == -1 || (i & 4) == 4) {
                this.f11422CqNSpT = a5SV6n.f6155AzWtSf;
            }
            if (i == -1 || (i & 8) == 8) {
                this.f11423CrfGsy = a5SV6n.f6156B25kr6;
            }
        }
        int i2 = a5SV6n.f6152AcNBzu;
        if (i2 == 1 || i2 == 2) {
            this.f11427D6DOie = 4;
        } else {
            this.f11427D6DOie = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new O1Vn2F.A5SV6n(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.f11430D8cQ8b = 0;
        this.f11431D9tr6l = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r4.getTop() <= r2.f11418Cd8JRx) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        if (java.lang.Math.abs(r3 - r2.f11417CcAIMM) < java.lang.Math.abs(r3 - r2.f11420CkXcdM)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        if (r3 < java.lang.Math.abs(r3 - r2.f11420CkXcdM)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.f11420CkXcdM)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
    
        if (java.lang.Math.abs(r3 - r2.f11418Cd8JRx) < java.lang.Math.abs(r3 - r2.f11420CkXcdM)) goto L50;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.AlLFFp()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.B2KMhB(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.f11438DaOi9o
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.f11431D9tr6l
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.f11430D8cQ8b
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f11390AlLFFp
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.f11418Cd8JRx
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.f11422CqNSpT
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.f11440DdagTj
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f11391AmA8tU
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.f11440DdagTj
            int r6 = r2.f11441De4eam
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.B3GDIM(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.f11430D8cQ8b
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f11390AlLFFp
            if (r1 == 0) goto L74
            int r5 = r2.f11417CcAIMM
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f11420CkXcdM
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.f11418Cd8JRx
            if (r3 >= r1) goto L83
            int r6 = r2.f11420CkXcdM
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f11420CkXcdM
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f11390AlLFFp
            if (r3 == 0) goto L99
        L97:
            r0 = 4
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.f11418Cd8JRx
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f11420CkXcdM
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = 6
        Laf:
            r3 = 0
            r2.B4ZgIw(r4, r0, r3)
            r2.f11431D9tr6l = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.f11427D6DOie;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        CqNSpT.ARc23Z aRc23Z = this.f11428D6yqiO;
        if (aRc23Z != null && (this.f11424CtFAbx || i == 1)) {
            aRc23Z.AZkASS(motionEvent);
        }
        if (actionMasked == 0) {
            this.f11441De4eam = -1;
            this.f11442DjONCG = -1;
            VelocityTracker velocityTracker = this.f11440DdagTj;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f11440DdagTj = null;
            }
        }
        if (this.f11440DdagTj == null) {
            this.f11440DdagTj = VelocityTracker.obtain();
        }
        this.f11440DdagTj.addMovement(motionEvent);
        if (this.f11428D6yqiO != null && ((this.f11424CtFAbx || this.f11427D6DOie == 1) && actionMasked == 2 && !this.f11429D8MqeW)) {
            float abs = Math.abs(this.f11442DjONCG - motionEvent.getY());
            CqNSpT.ARc23Z aRc23Z2 = this.f11428D6yqiO;
            if (abs > aRc23Z2.f1838A4TApA) {
                aRc23Z2.A4TApA(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f11429D8MqeW;
    }

    public final void setHideable(boolean z) {
        if (this.f11422CqNSpT != z) {
            this.f11422CqNSpT = z;
            if (!z && this.f11427D6DOie == 5) {
                setState(4);
            }
            B7CMnp();
        }
    }

    public final void setPeekHeight(int i) {
        if (i == -1) {
            if (this.f11394B2KMhB) {
                return;
            } else {
                this.f11394B2KMhB = true;
            }
        } else {
            if (!this.f11394B2KMhB && this.f11393B25kr6 == i) {
                return;
            }
            this.f11394B2KMhB = false;
            this.f11393B25kr6 = Math.max(0, i);
        }
        BIYEnU();
    }

    public final void setState(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(CtFAbx.B25kr6(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (this.f11422CqNSpT || i != 5) {
            int i2 = (i == 6 && this.f11390AlLFFp && AmA8tU(i) <= this.f11417CcAIMM) ? 3 : i;
            WeakReference weakReference = this.f11436DV2E8K;
            if (weakReference == null || weakReference.get() == null) {
                B2KMhB(i);
                return;
            }
            View view = (View) this.f11436DV2E8K.get();
            D8MqeW d8MqeW = new D8MqeW(this, view, i2, 4, false);
            ViewParent parent = view.getParent();
            if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
                view.post(d8MqeW);
            } else {
                d8MqeW.run();
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        int i2 = 0;
        this.f11389AcNBzu = 0;
        this.f11390AlLFFp = true;
        this.f11399BChYOn = -1;
        this.f11400BI9f7h = -1;
        this.f11414CQhlFr = new IzHBwY.A4TApA(this);
        this.f11419CikNvS = 0.5f;
        this.f11421CmUvjW = -1.0f;
        this.f11424CtFAbx = true;
        this.f11425CtxOCS = true;
        this.f11427D6DOie = 4;
        this.f11432DAk1zC = 0.1f;
        this.f11439DcUJf1 = new ArrayList();
        this.f11442DjONCG = -1;
        this.f11445DvK7DB = new SparseIntArray();
        this.f11446DyaChj = new O1Vn2F.A4TApA(this, i2);
        this.f11396B4ZgIw = context.getResources().getDimensionPixelSize(2131166460);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11217ASJ6gh);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f11398B9tovu = com.bumptech.glide.AMqCpz.BPw6Q8(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(22)) {
            this.f11412CNPG0E = B2KMhB.A5SV6n(context, attributeSet, 2130968718, 2131952600).A2egSU();
        }
        B2KMhB b2KMhB = this.f11412CNPG0E;
        if (b2KMhB != null) {
            AaHO0E aaHO0E = new AaHO0E(b2KMhB);
            this.f11397B7CMnp = aaHO0E;
            aaHO0E.AmA8tU(context);
            ColorStateList colorStateList = this.f11398B9tovu;
            if (colorStateList != null) {
                this.f11397B7CMnp.B3GDIM(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.f11397B7CMnp.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(ARc23Z(), 1.0f);
        this.f11415CSDoyG = ofFloat;
        ofFloat.setDuration(500L);
        this.f11415CSDoyG.addUpdateListener(new O1Vn2F.A2egSU(i2, this));
        this.f11421CmUvjW = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f11399BChYOn = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f11400BI9f7h = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(10);
        if (peekValue != null && (i = peekValue.data) == -1) {
            setPeekHeight(i);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(10, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(9, false));
        this.f11402BJ7GGh = obtainStyledAttributes.getBoolean(14, false);
        boolean z = obtainStyledAttributes.getBoolean(7, true);
        if (this.f11390AlLFFp != z) {
            this.f11390AlLFFp = z;
            if (this.f11436DV2E8K != null) {
                AMqCpz();
            }
            B2KMhB((this.f11390AlLFFp && this.f11427D6DOie == 6) ? 3 : this.f11427D6DOie);
            BChYOn(this.f11427D6DOie, true);
            B7CMnp();
        }
        this.f11423CrfGsy = obtainStyledAttributes.getBoolean(13, false);
        this.f11424CtFAbx = obtainStyledAttributes.getBoolean(4, true);
        this.f11425CtxOCS = obtainStyledAttributes.getBoolean(5, true);
        this.f11389AcNBzu = obtainStyledAttributes.getInt(11, 0);
        float f = obtainStyledAttributes.getFloat(8, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.f11419CikNvS = f;
            if (this.f11436DV2E8K != null) {
                this.f11418Cd8JRx = (int) ((1.0f - f) * this.f11435DUi7mC);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
            if (peekValue2 != null && peekValue2.type == 16) {
                int i3 = peekValue2.data;
                if (i3 >= 0) {
                    this.f11416CTkVKb = i3;
                    BChYOn(this.f11427D6DOie, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
                if (dimensionPixelOffset >= 0) {
                    this.f11416CTkVKb = dimensionPixelOffset;
                    BChYOn(this.f11427D6DOie, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f11392AzWtSf = obtainStyledAttributes.getInt(12, 500);
            this.f11403BNL6CD = obtainStyledAttributes.getBoolean(18, false);
            this.f11404BPw6Q8 = obtainStyledAttributes.getBoolean(19, false);
            this.f11405BTvldC = obtainStyledAttributes.getBoolean(20, false);
            this.f11406BV3sI0 = obtainStyledAttributes.getBoolean(21, true);
            this.f11407BmvVmW = obtainStyledAttributes.getBoolean(15, false);
            this.f11408BniPrB = obtainStyledAttributes.getBoolean(16, false);
            this.BpkvW3 = obtainStyledAttributes.getBoolean(17, false);
            this.f11411CASmeH = obtainStyledAttributes.getBoolean(24, true);
            obtainStyledAttributes.recycle();
            this.f11391AmA8tU = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
