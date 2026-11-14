package com.google.android.material.tabs;

import AaHO0E.F32kj0;
import OLy1FW.AzWtSf;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.AlLFFp;
import com.google.android.material.R$styleable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

@androidx.viewpager.widget.A4TApA
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public static final CNPG0E.A5SV6n f11841DXnQ0V = new CNPG0E.A5SV6n(16);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f11842AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f11843AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public A2egSU f11844AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final PWIgQJ.A5SV6n f11845AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f11846B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f11847B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f11848B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final int f11849B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final int f11850B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final int f11851B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int f11852BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ColorStateList f11853BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public ColorStateList f11854BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public ColorStateList f11855BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public Drawable f11856BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f11857BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final PorterDuff.Mode f11858BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final float f11859BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final float f11860BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final float f11861BniPrB;
    public final int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f11862C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final int f11863C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final int f11864CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final int f11865CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final int f11866COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public int f11867CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final int f11868CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f11869CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f11870CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public boolean f11871Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public boolean f11872CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public int f11873CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public int f11874CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public boolean f11875CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public AzWtSf f11876CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public final TimeInterpolator f11877CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public com.google.android.material.tabs.A2egSU f11878CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public final ArrayList f11879D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public AMqCpz f11880D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public ValueAnimator f11881D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public AlLFFp f11882D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public androidx.viewpager.widget.A2egSU f11883D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public F32kj0 f11884D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public A5SV6n f11885DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public PWIgQJ.A4TApA f11886DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public boolean f11887DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public int f11888DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public final B4ZgIw.AMqCpz f11889DV2E8K;

    public static class A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        public Drawable f11890A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public CharSequence f11891A4TApA;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public CharSequence f11892A5SV6n;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public int f11893ADYaiT = -1;
        public View AMqCpz;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public TabLayout f11894ARc23Z;

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public ADYaiT f11895ASJ6gh;

        public final void A2egSU(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f11892A5SV6n) && !TextUtils.isEmpty(charSequence)) {
                this.f11895ASJ6gh.setContentDescription(charSequence);
            }
            this.f11891A4TApA = charSequence;
            ADYaiT aDYaiT = this.f11895ASJ6gh;
            if (aDYaiT != null) {
                aDYaiT.update();
            }
        }
    }

    static {
        zNqRcZ();
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130969987, 2131952606), attributeSet, 2130969987);
        this.f11842AcNBzu = -1;
        this.f11843AlLFFp = new ArrayList();
        this.f11852BChYOn = -1;
        this.f11857BPw6Q8 = 0;
        this.f11862C2rE4F = Integer.MAX_VALUE;
        this.f11873CkXcdM = -1;
        this.f11879D07BeM = new ArrayList();
        this.f11889DV2E8K = new B4ZgIw.AMqCpz(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        PWIgQJ.A5SV6n a5SV6n = new PWIgQJ.A5SV6n(this, context2);
        this.f11845AzWtSf = a5SV6n;
        super.addView(a5SV6n, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11262D8MqeW, 2130969987, 2131952606, 24);
        ColorStateList C2rE4F2 = JrXYwF.A4TApA.C2rE4F(getBackground());
        if (C2rE4F2 != null) {
            AaHO0E aaHO0E = new AaHO0E();
            aaHO0E.B3GDIM(C2rE4F2);
            aaHO0E.AmA8tU(context2);
            aaHO0E.B2KMhB(getElevation());
            setBackground(aaHO0E);
        }
        setSelectedTabIndicator(com.bumptech.glide.AMqCpz.BV3sI0(context2, AmA8tU2, 5));
        setSelectedTabIndicatorColor(AmA8tU2.getColor(8, 0));
        a5SV6n.A4TApA(AmA8tU2.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(AmA8tU2.getInt(10, 0));
        setTabIndicatorAnimationMode(AmA8tU2.getInt(7, 0));
        setTabIndicatorFullWidth(AmA8tU2.getBoolean(9, true));
        int dimensionPixelSize = AmA8tU2.getDimensionPixelSize(16, 0);
        this.f11849B4ZgIw = dimensionPixelSize;
        this.f11848B3GDIM = dimensionPixelSize;
        this.f11847B2KMhB = dimensionPixelSize;
        this.f11846B25kr6 = dimensionPixelSize;
        this.f11846B25kr6 = AmA8tU2.getDimensionPixelSize(19, dimensionPixelSize);
        this.f11847B2KMhB = AmA8tU2.getDimensionPixelSize(20, dimensionPixelSize);
        this.f11848B3GDIM = AmA8tU2.getDimensionPixelSize(18, dimensionPixelSize);
        this.f11849B4ZgIw = AmA8tU2.getDimensionPixelSize(17, dimensionPixelSize);
        if (P3rngT.A4TApA.A4TApA(context2, 2130969267, false)) {
            this.f11850B7CMnp = 2130970046;
        } else {
            this.f11850B7CMnp = 2130970004;
        }
        int resourceId = AmA8tU2.getResourceId(24, 2131952201);
        this.f11851B9tovu = resourceId;
        int[] iArr = androidx.appcompat.R$styleable.f8036BIYEnU;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr);
        try {
            this.f11859BV3sI0 = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f11853BI9f7h = com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 3);
            obtainStyledAttributes.recycle();
            if (AmA8tU2.hasValue(22)) {
                this.f11852BChYOn = AmA8tU2.getResourceId(22, resourceId);
            }
            int i = this.f11852BChYOn;
            int[] iArr2 = HorizontalScrollView.EMPTY_STATE_SET;
            int[] iArr3 = HorizontalScrollView.SELECTED_STATE_SET;
            if (i != -1) {
                obtainStyledAttributes = context2.obtainStyledAttributes(i, iArr);
                try {
                    this.f11860BmvVmW = obtainStyledAttributes.getDimensionPixelSize(0, (int) r7);
                    ColorStateList BPw6Q82 = com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 3);
                    if (BPw6Q82 != null) {
                        this.f11853BI9f7h = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{BPw6Q82.getColorForState(new int[]{R.attr.state_selected}, BPw6Q82.getDefaultColor()), this.f11853BI9f7h.getDefaultColor()});
                    }
                } finally {
                }
            }
            if (AmA8tU2.hasValue(25)) {
                this.f11853BI9f7h = com.bumptech.glide.AMqCpz.BPw6Q8(context2, AmA8tU2, 25);
            }
            if (AmA8tU2.hasValue(23)) {
                this.f11853BI9f7h = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{AmA8tU2.getColor(23, 0), this.f11853BI9f7h.getDefaultColor()});
            }
            this.f11854BIYEnU = com.bumptech.glide.AMqCpz.BPw6Q8(context2, AmA8tU2, 3);
            this.f11858BTvldC = C4FrIb.B25kr6(AmA8tU2.getInt(4, -1), null);
            this.f11855BJ7GGh = com.bumptech.glide.AMqCpz.BPw6Q8(context2, AmA8tU2, 21);
            this.f11868CSDoyG = AmA8tU2.getInt(6, 300);
            this.f11877CtFAbx = com.bumptech.glide.A5SV6n.D6DOie(context2, 2130969633, NdEzCJ.A2egSU.f6037A4TApA);
            this.f11863C4FrIb = AmA8tU2.getDimensionPixelSize(14, -1);
            this.f11864CASmeH = AmA8tU2.getDimensionPixelSize(13, -1);
            this.BpkvW3 = AmA8tU2.getResourceId(0, 0);
            this.f11866COJEAR = AmA8tU2.getDimensionPixelSize(1, 0);
            this.f11870CcAIMM = AmA8tU2.getInt(15, 1);
            this.f11867CQhlFr = AmA8tU2.getInt(2, 0);
            this.f11871Cd8JRx = AmA8tU2.getBoolean(12, false);
            this.f11875CqNSpT = AmA8tU2.getBoolean(26, false);
            AmA8tU2.recycle();
            Resources resources = getResources();
            this.f11861BniPrB = resources.getDimensionPixelSize(2131165331);
            this.f11865CNPG0E = resources.getDimensionPixelSize(2131165329);
            ARc23Z();
        } finally {
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.f11843AlLFFp;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            A2egSU a2egSU = (A2egSU) arrayList.get(i);
            if (a2egSU != null && a2egSU.f11890A2egSU != null && !TextUtils.isEmpty(a2egSU.f11891A4TApA)) {
                return !this.f11871Cd8JRx ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.f11863C4FrIb;
        if (i != -1) {
            return i;
        }
        int i2 = this.f11870CcAIMM;
        if (i2 == 0 || i2 == 2) {
            return this.f11865CNPG0E;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f11845AzWtSf.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
        int childCount = a5SV6n.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = a5SV6n.getChildAt(i2);
                if ((i2 != i || childAt.isSelected()) && (i2 == i || !childAt.isSelected())) {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                } else {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                    if (childAt instanceof ADYaiT) {
                        ((ADYaiT) childAt).AMqCpz();
                    }
                }
                i2++;
            }
        }
    }

    private static /* synthetic */ void zNqRcZ() {
        char[] charArray = "ÿóñ²ûýñù²þóå²ïôùðð²ÖòõÞîõøûù".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 156);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÿðõòõè".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 156);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(com.google.android.material.tabs.A2egSU a2egSU) {
        ArrayList arrayList = this.f11879D07BeM;
        if (arrayList.contains(a2egSU)) {
            return;
        }
        arrayList.add(a2egSU);
    }

    public final void A4TApA(A2egSU a2egSU) {
        ArrayList arrayList = this.f11843AlLFFp;
        A5SV6n(a2egSU, arrayList.size(), arrayList.isEmpty());
    }

    public final void A5SV6n(A2egSU a2egSU, int i, boolean z) {
        if (a2egSU.f11894ARc23Z != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        a2egSU.f11893ADYaiT = i;
        ArrayList arrayList = this.f11843AlLFFp;
        arrayList.add(i, a2egSU);
        int size = arrayList.size();
        int i2 = -1;
        for (int i3 = i + 1; i3 < size; i3++) {
            if (((A2egSU) arrayList.get(i3)).f11893ADYaiT == this.f11842AcNBzu) {
                i2 = i3;
            }
            ((A2egSU) arrayList.get(i3)).f11893ADYaiT = i3;
        }
        this.f11842AcNBzu = i2;
        ADYaiT aDYaiT = a2egSU.f11895ASJ6gh;
        aDYaiT.setSelected(false);
        aDYaiT.setActivated(false);
        int i4 = a2egSU.f11893ADYaiT;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.f11870CcAIMM == 1 && this.f11867CQhlFr == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.f11845AzWtSf.addView(aDYaiT, i4, layoutParams);
        if (z) {
            TabLayout tabLayout = a2egSU.f11894ARc23Z;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.AzWtSf(a2egSU, true);
        }
    }

    public final void ADYaiT(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        A2egSU AZkASS2 = AZkASS();
        CharSequence charSequence = tabItem.f11838AcNBzu;
        if (charSequence != null) {
            AZkASS2.A2egSU(charSequence);
        }
        Drawable drawable = tabItem.f11839AlLFFp;
        if (drawable != null) {
            AZkASS2.f11890A2egSU = drawable;
            TabLayout tabLayout = AZkASS2.f11894ARc23Z;
            if (tabLayout.f11867CQhlFr == 1 || tabLayout.f11870CcAIMM == 2) {
                tabLayout.B4ZgIw(true);
            }
            ADYaiT aDYaiT = AZkASS2.f11895ASJ6gh;
            if (aDYaiT != null) {
                aDYaiT.update();
            }
        }
        int i = tabItem.f11840AmA8tU;
        if (i != 0) {
            AZkASS2.AMqCpz = LayoutInflater.from(AZkASS2.f11895ASJ6gh.getContext()).inflate(i, (ViewGroup) AZkASS2.f11895ASJ6gh, false);
            ADYaiT aDYaiT2 = AZkASS2.f11895ASJ6gh;
            if (aDYaiT2 != null) {
                aDYaiT2.update();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            AZkASS2.f11892A5SV6n = tabItem.getContentDescription();
            ADYaiT aDYaiT3 = AZkASS2.f11895ASJ6gh;
            if (aDYaiT3 != null) {
                aDYaiT3.update();
            }
        }
        A4TApA(AZkASS2);
    }

    public final void AMqCpz(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && isLaidOut()) {
            PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
            int childCount = a5SV6n.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a5SV6n.getChildAt(i2).getWidth() > 0) {
                }
            }
            int scrollX = getScrollX();
            int ASJ6gh2 = ASJ6gh(0.0f, i);
            if (scrollX != ASJ6gh2) {
                AYUAbz();
                this.f11881D6yqiO.setIntValues(scrollX, ASJ6gh2);
                this.f11881D6yqiO.start();
            }
            ValueAnimator valueAnimator = a5SV6n.f7284AcNBzu;
            if (valueAnimator != null && valueAnimator.isRunning() && a5SV6n.f7286AmA8tU.f11842AcNBzu != i) {
                a5SV6n.f7284AcNBzu.cancel();
            }
            a5SV6n.ADYaiT(i, this.f11868CSDoyG, true);
            return;
        }
        B2KMhB(true, 0.0f, i, true, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r0 != 2) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ARc23Z() {
        /*
            r4 = this;
            int r0 = r4.f11870CcAIMM
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r0 = 0
            goto L14
        Lb:
            int r0 = r4.f11866COJEAR
            int r3 = r4.f11846B25kr6
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L14:
            PWIgQJ.A5SV6n r3 = r4.f11845AzWtSf
            r3.setPaddingRelative(r0, r2, r2, r2)
            int r0 = r4.f11870CcAIMM
            r2 = 1
            if (r0 == 0) goto L27
            if (r0 == r2) goto L23
            if (r0 == r1) goto L23
            goto L3a
        L23:
            r3.setGravity(r2)
            goto L3a
        L27:
            int r0 = r4.f11867CQhlFr
            if (r0 == 0) goto L34
            if (r0 == r2) goto L30
            if (r0 == r1) goto L34
            goto L3a
        L30:
            r3.setGravity(r2)
            goto L3a
        L34:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r0)
        L3a:
            r4.B4ZgIw(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.ARc23Z():void");
    }

    public final int ASJ6gh(float f, int i) {
        PWIgQJ.A5SV6n a5SV6n;
        View childAt;
        int i2 = this.f11870CcAIMM;
        if ((i2 != 0 && i2 != 2) || (childAt = (a5SV6n = this.f11845AzWtSf).getChildAt(i)) == null) {
            return 0;
        }
        int i3 = i + 1;
        View childAt2 = i3 < a5SV6n.getChildCount() ? a5SV6n.getChildAt(i3) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f);
        return getLayoutDirection() == 0 ? left + i4 : left - i4;
    }

    public final void AYUAbz() {
        if (this.f11881D6yqiO == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f11881D6yqiO = valueAnimator;
            valueAnimator.setInterpolator(this.f11877CtFAbx);
            this.f11881D6yqiO.setDuration(this.f11868CSDoyG);
            this.f11881D6yqiO.addUpdateListener(new O1Vn2F.A2egSU(2, this));
        }
    }

    public final A2egSU AZOQYO(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return (A2egSU) this.f11843AlLFFp.get(i);
    }

    public final A2egSU AZkASS() {
        A2egSU a2egSU = (A2egSU) f11841DXnQ0V.A2egSU();
        if (a2egSU == null) {
            a2egSU = new A2egSU();
        }
        a2egSU.f11894ARc23Z = this;
        B4ZgIw.AMqCpz aMqCpz = this.f11889DV2E8K;
        ADYaiT aDYaiT = aMqCpz != null ? (ADYaiT) aMqCpz.A2egSU() : null;
        if (aDYaiT == null) {
            aDYaiT = new ADYaiT(this, getContext());
        }
        aDYaiT.setTab(a2egSU);
        aDYaiT.setFocusable(true);
        aDYaiT.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(a2egSU.f11892A5SV6n)) {
            aDYaiT.setContentDescription(a2egSU.f11891A4TApA);
        } else {
            aDYaiT.setContentDescription(a2egSU.f11892A5SV6n);
        }
        a2egSU.f11895ASJ6gh = aDYaiT;
        return a2egSU;
    }

    public final void AaHO0E() {
        int currentItem;
        AcNBzu();
        androidx.viewpager.widget.A2egSU a2egSU = this.f11883D8cQ8b;
        if (a2egSU != null) {
            int count = a2egSU.getCount();
            for (int i = 0; i < count; i++) {
                A2egSU AZkASS2 = AZkASS();
                AZkASS2.A2egSU(this.f11883D8cQ8b.getPageTitle(i));
                A5SV6n(AZkASS2, this.f11843AlLFFp.size(), false);
            }
            AlLFFp alLFFp = this.f11882D8MqeW;
            if (alLFFp == null || count <= 0 || (currentItem = alLFFp.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            AzWtSf(AZOQYO(currentItem), true);
        }
    }

    public final void AcNBzu() {
        for (int childCount = this.f11845AzWtSf.getChildCount() - 1; childCount >= 0; childCount--) {
            AmA8tU(childCount);
        }
        Iterator it = this.f11843AlLFFp.iterator();
        while (it.hasNext()) {
            A2egSU a2egSU = (A2egSU) it.next();
            it.remove();
            a2egSU.f11894ARc23Z = null;
            a2egSU.f11895ASJ6gh = null;
            a2egSU.f11890A2egSU = null;
            a2egSU.f11891A4TApA = null;
            a2egSU.f11892A5SV6n = null;
            a2egSU.f11893ADYaiT = -1;
            a2egSU.AMqCpz = null;
            f11841DXnQ0V.A5SV6n(a2egSU);
        }
        this.f11844AmA8tU = null;
    }

    public final void AlLFFp() {
        A2egSU a2egSU = this.f11844AmA8tU;
        int i = a2egSU != null ? a2egSU.f11893ADYaiT : 0;
        AmA8tU(0);
        ArrayList arrayList = this.f11843AlLFFp;
        A2egSU a2egSU2 = (A2egSU) arrayList.remove(0);
        if (a2egSU2 != null) {
            a2egSU2.f11894ARc23Z = null;
            a2egSU2.f11895ASJ6gh = null;
            a2egSU2.f11890A2egSU = null;
            a2egSU2.f11891A4TApA = null;
            a2egSU2.f11892A5SV6n = null;
            a2egSU2.f11893ADYaiT = -1;
            a2egSU2.AMqCpz = null;
            f11841DXnQ0V.A5SV6n(a2egSU2);
        }
        int size = arrayList.size();
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            if (((A2egSU) arrayList.get(i3)).f11893ADYaiT == this.f11842AcNBzu) {
                i2 = i3;
            }
            ((A2egSU) arrayList.get(i3)).f11893ADYaiT = i3;
        }
        this.f11842AcNBzu = i2;
        if (i == 0) {
            AzWtSf(arrayList.isEmpty() ? null : (A2egSU) arrayList.get(Math.max(0, -1)), true);
        }
    }

    public final void AmA8tU(int i) {
        PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
        ADYaiT aDYaiT = (ADYaiT) a5SV6n.getChildAt(i);
        a5SV6n.removeViewAt(i);
        if (aDYaiT != null) {
            aDYaiT.setTab(null);
            aDYaiT.setSelected(false);
            this.f11889DV2E8K.A5SV6n(aDYaiT);
        }
        requestLayout();
    }

    public final void AzWtSf(A2egSU a2egSU, boolean z) {
        TabLayout tabLayout;
        A2egSU a2egSU2 = this.f11844AmA8tU;
        ArrayList arrayList = this.f11879D07BeM;
        if (a2egSU2 == a2egSU) {
            if (a2egSU2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((com.google.android.material.tabs.A2egSU) arrayList.get(size)).getClass();
                }
                AMqCpz(a2egSU.f11893ADYaiT);
                return;
            }
            return;
        }
        int i = a2egSU != null ? a2egSU.f11893ADYaiT : -1;
        if (z) {
            if ((a2egSU2 == null || a2egSU2.f11893ADYaiT == -1) && i != -1) {
                tabLayout = this;
                tabLayout.B2KMhB(true, 0.0f, i, true, true);
            } else {
                tabLayout = this;
                AMqCpz(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        } else {
            tabLayout = this;
        }
        tabLayout.f11844AmA8tU = a2egSU;
        if (a2egSU2 != null && a2egSU2.f11894ARc23Z != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((com.google.android.material.tabs.A2egSU) arrayList.get(size2)).getClass();
            }
        }
        if (a2egSU != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((com.google.android.material.tabs.A2egSU) arrayList.get(size3)).A2egSU(a2egSU);
            }
        }
    }

    public final void B25kr6(androidx.viewpager.widget.A2egSU a2egSU, boolean z) {
        F32kj0 f32kj0;
        androidx.viewpager.widget.A2egSU a2egSU2 = this.f11883D8cQ8b;
        if (a2egSU2 != null && (f32kj0 = this.f11884D9tr6l) != null) {
            a2egSU2.unregisterDataSetObserver(f32kj0);
        }
        this.f11883D8cQ8b = a2egSU;
        if (z && a2egSU != null) {
            if (this.f11884D9tr6l == null) {
                this.f11884D9tr6l = new F32kj0(1, this);
            }
            a2egSU.registerDataSetObserver(this.f11884D9tr6l);
        }
        AaHO0E();
    }

    public final void B2KMhB(boolean z, float f, int i, boolean z2, boolean z3) {
        float f2 = i + f;
        int round = Math.round(f2);
        if (round >= 0) {
            PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
            if (round >= a5SV6n.getChildCount()) {
                return;
            }
            if (z2) {
                a5SV6n.f7286AmA8tU.f11842AcNBzu = Math.round(f2);
                ValueAnimator valueAnimator = a5SV6n.f7284AcNBzu;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    a5SV6n.f7284AcNBzu.cancel();
                }
                a5SV6n.A5SV6n(a5SV6n.getChildAt(i), a5SV6n.getChildAt(i + 1), f);
            }
            ValueAnimator valueAnimator2 = this.f11881D6yqiO;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f11881D6yqiO.cancel();
            }
            int ASJ6gh2 = ASJ6gh(f, i);
            int scrollX = getScrollX();
            boolean z4 = (i < getSelectedTabPosition() && ASJ6gh2 >= scrollX) || (i > getSelectedTabPosition() && ASJ6gh2 <= scrollX) || i == getSelectedTabPosition();
            if (getLayoutDirection() == 1) {
                z4 = (i < getSelectedTabPosition() && ASJ6gh2 <= scrollX) || (i > getSelectedTabPosition() && ASJ6gh2 >= scrollX) || i == getSelectedTabPosition();
            }
            if (z4 || this.f11888DUi7mC == 1 || z3) {
                if (i < 0) {
                    ASJ6gh2 = 0;
                }
                scrollTo(ASJ6gh2, 0);
            }
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public final void B3GDIM(AlLFFp alLFFp, boolean z) {
        TabLayout tabLayout;
        AlLFFp alLFFp2 = this.f11882D8MqeW;
        if (alLFFp2 != null) {
            A5SV6n a5SV6n = this.f11885DAk1zC;
            if (a5SV6n != null) {
                alLFFp2.removeOnPageChangeListener(a5SV6n);
            }
            PWIgQJ.A4TApA a4TApA = this.f11886DG07BK;
            if (a4TApA != null) {
                this.f11882D8MqeW.removeOnAdapterChangeListener(a4TApA);
            }
        }
        AMqCpz aMqCpz = this.f11880D6DOie;
        if (aMqCpz != null) {
            this.f11879D07BeM.remove(aMqCpz);
            this.f11880D6DOie = null;
        }
        if (alLFFp != null) {
            this.f11882D8MqeW = alLFFp;
            if (this.f11885DAk1zC == null) {
                this.f11885DAk1zC = new A5SV6n(this);
            }
            A5SV6n a5SV6n2 = this.f11885DAk1zC;
            a5SV6n2.f11816A5SV6n = 0;
            a5SV6n2.f11815A4TApA = 0;
            alLFFp.addOnPageChangeListener(a5SV6n2);
            AMqCpz aMqCpz2 = new AMqCpz(alLFFp);
            this.f11880D6DOie = aMqCpz2;
            A2egSU(aMqCpz2);
            androidx.viewpager.widget.A2egSU adapter = alLFFp.getAdapter();
            if (adapter != null) {
                B25kr6(adapter, true);
            }
            if (this.f11886DG07BK == null) {
                this.f11886DG07BK = new PWIgQJ.A4TApA(this);
            }
            PWIgQJ.A4TApA a4TApA2 = this.f11886DG07BK;
            a4TApA2.f7281A2egSU = true;
            alLFFp.addOnAdapterChangeListener(a4TApA2);
            tabLayout = this;
            tabLayout.B2KMhB(true, 0.0f, alLFFp.getCurrentItem(), true, true);
        } else {
            tabLayout = this;
            tabLayout.f11882D8MqeW = null;
            B25kr6(null, false);
        }
        tabLayout.f11887DRlcZ9 = z;
    }

    public final void B4ZgIw(boolean z) {
        int i = 0;
        while (true) {
            PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
            if (i >= a5SV6n.getChildCount()) {
                return;
            }
            View childAt = a5SV6n.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.f11870CcAIMM == 1 && this.f11867CQhlFr == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        ADYaiT(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        A2egSU a2egSU = this.f11844AmA8tU;
        if (a2egSU != null) {
            return a2egSU.f11893ADYaiT;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f11843AlLFFp.size();
    }

    public int getTabGravity() {
        return this.f11867CQhlFr;
    }

    public ColorStateList getTabIconTint() {
        return this.f11854BIYEnU;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f11874CmUvjW;
    }

    public int getTabIndicatorGravity() {
        return this.f11869CTkVKb;
    }

    public int getTabMaxWidth() {
        return this.f11862C2rE4F;
    }

    public int getTabMode() {
        return this.f11870CcAIMM;
    }

    public ColorStateList getTabRippleColor() {
        return this.f11855BJ7GGh;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f11856BNL6CD;
    }

    public ColorStateList getTabTextColors() {
        return this.f11853BI9f7h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        NOd7IU.AlLFFp.D07BeM(this);
        if (this.f11882D8MqeW == null) {
            ViewParent parent = getParent();
            if (parent instanceof AlLFFp) {
                B3GDIM((AlLFFp) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f11887DRlcZ9) {
            setupWithViewPager(null);
            this.f11887DRlcZ9 = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        ADYaiT aDYaiT;
        Drawable drawable;
        int i = 0;
        while (true) {
            PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
            if (i >= a5SV6n.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = a5SV6n.getChildAt(i);
            if ((childAt instanceof ADYaiT) && (drawable = (aDYaiT = (ADYaiT) childAt).f11826B7CMnp) != null) {
                drawable.setBounds(aDYaiT.getLeft(), aDYaiT.getTop(), aDYaiT.getRight(), aDYaiT.getBottom());
                aDYaiT.f11826B7CMnp.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) AZkASS.ARc23Z.BJ7GGh(1, getTabCount(), 1, false).f451AlLFFp);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int round = Math.round(C4FrIb.AYUAbz(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + round, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i2) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int i3 = this.f11864CASmeH;
            if (i3 <= 0) {
                i3 = (int) (size - C4FrIb.AYUAbz(getContext(), 56));
            }
            this.f11862C2rE4F = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i4 = this.f11870CcAIMM;
            if (i4 != 0) {
                if (i4 == 1) {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                }
                if (i4 != 2) {
                    return;
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        NOd7IU.AlLFFp.CtFAbx(this, f);
    }

    public void setInlineLabel(boolean z) {
        if (this.f11871Cd8JRx == z) {
            return;
        }
        this.f11871Cd8JRx = z;
        int i = 0;
        while (true) {
            PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
            if (i >= a5SV6n.getChildCount()) {
                ARc23Z();
                return;
            }
            View childAt = a5SV6n.getChildAt(i);
            if (childAt instanceof ADYaiT) {
                ADYaiT aDYaiT = (ADYaiT) childAt;
                aDYaiT.setOrientation(!aDYaiT.f11828BChYOn.f11871Cd8JRx ? 1 : 0);
                TextView textView = aDYaiT.f11824B3GDIM;
                if (textView == null && aDYaiT.f11825B4ZgIw == null) {
                    aDYaiT.ARc23Z(aDYaiT.f11819AlLFFp, aDYaiT.f11820AmA8tU, true);
                } else {
                    aDYaiT.ARc23Z(textView, aDYaiT.f11825B4ZgIw, false);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(A4TApA a4TApA) {
        setOnTabSelectedListener((com.google.android.material.tabs.A2egSU) a4TApA);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        AYUAbz();
        this.f11881D6yqiO.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(drawable).mutate();
        this.f11856BNL6CD = mutate;
        JrXYwF.A4TApA.DUi7mC(mutate, this.f11857BPw6Q8);
        int i = this.f11873CkXcdM;
        if (i == -1) {
            i = this.f11856BNL6CD.getIntrinsicHeight();
        }
        this.f11845AzWtSf.A4TApA(i);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f11857BPw6Q8 = i;
        JrXYwF.A4TApA.DUi7mC(this.f11856BNL6CD, i);
        B4ZgIw(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.f11869CTkVKb != i) {
            this.f11869CTkVKb = i;
            this.f11845AzWtSf.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.f11873CkXcdM = i;
        this.f11845AzWtSf.A4TApA(i);
    }

    public void setTabGravity(int i) {
        if (this.f11867CQhlFr != i) {
            this.f11867CQhlFr = i;
            ARc23Z();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f11854BIYEnU != colorStateList) {
            this.f11854BIYEnU = colorStateList;
            ArrayList arrayList = this.f11843AlLFFp;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ADYaiT aDYaiT = ((A2egSU) arrayList.get(i)).f11895ASJ6gh;
                if (aDYaiT != null) {
                    aDYaiT.update();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(BPw6Q8.ASJ6gh.A5SV6n(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.f11874CmUvjW = i;
        if (i == 0) {
            this.f11876CrfGsy = new AzWtSf(6, (byte) 0);
            return;
        }
        if (i == 1) {
            this.f11876CrfGsy = new PWIgQJ.A2egSU(0);
        } else {
            if (i == 2) {
                this.f11876CrfGsy = new PWIgQJ.A2egSU(1);
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.f11872CikNvS = z;
        int i = PWIgQJ.A5SV6n.f7283AzWtSf;
        PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
        a5SV6n.A2egSU(a5SV6n.f7286AmA8tU.getSelectedTabPosition());
        a5SV6n.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.f11870CcAIMM) {
            this.f11870CcAIMM = i;
            ARc23Z();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f11855BJ7GGh == colorStateList) {
            return;
        }
        this.f11855BJ7GGh = colorStateList;
        int i = 0;
        while (true) {
            PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
            if (i >= a5SV6n.getChildCount()) {
                return;
            }
            View childAt = a5SV6n.getChildAt(i);
            if (childAt instanceof ADYaiT) {
                Context context = getContext();
                int i2 = ADYaiT.f11817BI9f7h;
                ((ADYaiT) childAt).ADYaiT(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(BPw6Q8.ASJ6gh.A5SV6n(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f11853BI9f7h != colorStateList) {
            this.f11853BI9f7h = colorStateList;
            ArrayList arrayList = this.f11843AlLFFp;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ADYaiT aDYaiT = ((A2egSU) arrayList.get(i)).f11895ASJ6gh;
                if (aDYaiT != null) {
                    aDYaiT.update();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.A2egSU a2egSU) {
        B25kr6(a2egSU, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.f11875CqNSpT == z) {
            return;
        }
        this.f11875CqNSpT = z;
        int i = 0;
        while (true) {
            PWIgQJ.A5SV6n a5SV6n = this.f11845AzWtSf;
            if (i >= a5SV6n.getChildCount()) {
                return;
            }
            View childAt = a5SV6n.getChildAt(i);
            if (childAt instanceof ADYaiT) {
                Context context = getContext();
                int i2 = ADYaiT.f11817BI9f7h;
                ((ADYaiT) childAt).ADYaiT(context);
            }
            i++;
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(AlLFFp alLFFp) {
        B3GDIM(alLFFp, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        ADYaiT(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(com.google.android.material.tabs.A2egSU a2egSU) {
        com.google.android.material.tabs.A2egSU a2egSU2 = this.f11878CtxOCS;
        if (a2egSU2 != null) {
            this.f11879D07BeM.remove(a2egSU2);
        }
        this.f11878CtxOCS = a2egSU;
        if (a2egSU != null) {
            A2egSU(a2egSU);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        ADYaiT(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ADYaiT(view);
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(NOd7IU.AlLFFp.CQhlFr(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
