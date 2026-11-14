package androidx.drawerlayout.widget;

import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import CikNvS.AYUAbz;
import CqNSpT.ARc23Z;
import CrfGsy.A4TApA;
import CrfGsy.A5SV6n;
import CrfGsy.ADYaiT;
import CrfGsy.AMqCpz;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.drawerlayout.R$styleable;
import com.sigmob.sdk.base.utils.n;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: CcAIMM, reason: collision with root package name */
    public static final int[] f8614CcAIMM = {R.attr.colorPrimaryDark};

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final int[] f8615Cd8JRx = {R.attr.layout_gravity};

    /* renamed from: CikNvS, reason: collision with root package name */
    public static final boolean f8616CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public static final boolean f8617CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public static final boolean f8618CmUvjW;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AYUAbz f8619AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f8620AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f8621AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f8622AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f8623B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Paint f8624B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ARc23Z f8625B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ARc23Z f8626B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final CrfGsy.ARc23Z f8627B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final CrfGsy.ARc23Z f8628B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f8629BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f8630BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f8631BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f8632BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f8633BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f8634BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f8635BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f8636BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public A5SV6n f8637BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public ArrayList f8638BniPrB;
    public float BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public float f8639C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public Drawable f8640C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public WindowInsets f8641CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f8642CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final ArrayList f8643COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public Rect f8644CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public Matrix f8645CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public final KCxDWD.A5SV6n f8646CTkVKb;

    public static abstract class A2egSU implements A5SV6n {
        @Override // CrfGsy.A5SV6n
        public void A2egSU(View view) {
        }

        @Override // CrfGsy.A5SV6n
        public void A4TApA(View view) {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f8616CikNvS = true;
        f8617CkXcdM = true;
        f8618CmUvjW = i >= 29;
        WlAb();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969041);
        this.f8619AcNBzu = new AYUAbz(1);
        this.f8622AzWtSf = n.f13223a;
        this.f8624B2KMhB = new Paint();
        this.f8631BIYEnU = true;
        this.f8632BJ7GGh = 3;
        this.f8633BNL6CD = 3;
        this.f8634BPw6Q8 = 3;
        this.f8635BTvldC = 3;
        this.f8646CTkVKb = new KCxDWD.A5SV6n(11, this);
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f8621AmA8tU = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        CrfGsy.ARc23Z aRc23Z = new CrfGsy.ARc23Z(this, 3);
        this.f8627B7CMnp = aRc23Z;
        CrfGsy.ARc23Z aRc23Z2 = new CrfGsy.ARc23Z(this, 5);
        this.f8628B9tovu = aRc23Z2;
        ARc23Z aRc23Z3 = new ARc23Z(getContext(), this, aRc23Z);
        aRc23Z3.f1838A4TApA = (int) (aRc23Z3.f1838A4TApA * 1.0f);
        this.f8625B3GDIM = aRc23Z3;
        aRc23Z3.f1852B2KMhB = 1;
        aRc23Z3.f1849AmA8tU = f2;
        aRc23Z.f1871A4TApA = aRc23Z3;
        ARc23Z aRc23Z4 = new ARc23Z(getContext(), this, aRc23Z2);
        aRc23Z4.f1838A4TApA = (int) (1.0f * aRc23Z4.f1838A4TApA);
        this.f8626B4ZgIw = aRc23Z4;
        aRc23Z4.f1852B2KMhB = 2;
        aRc23Z4.f1849AmA8tU = f2;
        aRc23Z2.f1871A4TApA = aRc23Z4;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        setImportantForAccessibility(1);
        DG07BK.B4ZgIw(this, new A4TApA(this));
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new CrfGsy.A2egSU(0));
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f8614CcAIMM);
            try {
                this.f8640C4FrIb = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.f8613A2egSU, 2130969041, 0);
        try {
            if (obtainStyledAttributes2.hasValue(0)) {
                this.f8620AlLFFp = obtainStyledAttributes2.getDimension(0, 0.0f);
            } else {
                this.f8620AlLFFp = getResources().getDimension(2131165282);
            }
            obtainStyledAttributes2.recycle();
            this.f8643COJEAR = new ArrayList();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public static boolean AZkASS(View view) {
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        return (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) ? false : true;
    }

    public static boolean AaHO0E(View view) {
        return ((ADYaiT) view.getLayoutParams()).f1861A2egSU == 0;
    }

    public static boolean AcNBzu(View view) {
        if (AlLFFp(view)) {
            return (((ADYaiT) view.getLayoutParams()).f1864ADYaiT & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean AlLFFp(View view) {
        int i = ((ADYaiT) view.getLayoutParams()).f1861A2egSU;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    private static /* synthetic */ void WlAb() {
        char[] charArray = "ÞÒÐ\u0093ÚÜÐØ\u0093ßÒÄ\u0093ÎÕØÑÑ\u0093÷ÓÔÿÏÔÙÚØ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 189);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÞÑÔÓÔÉ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 189);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(A5SV6n a5SV6n) {
        if (a5SV6n == null) {
            return;
        }
        if (this.f8638BniPrB == null) {
            this.f8638BniPrB = new ArrayList();
        }
        this.f8638BniPrB.add(a5SV6n);
    }

    public final boolean A4TApA(int i, View view) {
        return (AZOQYO(view) & i) == i;
    }

    public final void A5SV6n(View view, boolean z) {
        if (!AlLFFp(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        ADYaiT aDYaiT = (ADYaiT) view.getLayoutParams();
        if (this.f8631BIYEnU) {
            aDYaiT.f1862A4TApA = 0.0f;
            aDYaiT.f1864ADYaiT = 0;
        } else if (z) {
            aDYaiT.f1864ADYaiT |= 4;
            if (A4TApA(3, view)) {
                this.f8625B3GDIM.B3GDIM(view, -view.getWidth(), view.getTop());
            } else {
                this.f8626B4ZgIw.B3GDIM(view, getWidth(), view.getTop());
            }
        } else {
            float f = ((ADYaiT) view.getLayoutParams()).f1862A4TApA;
            float width = view.getWidth();
            int i = ((int) (width * 0.0f)) - ((int) (f * width));
            if (!A4TApA(3, view)) {
                i = -i;
            }
            view.offsetLeftAndRight(i);
            B25kr6(view, 0.0f);
            B4ZgIw(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public final void ADYaiT(boolean z) {
        boolean B3GDIM2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ADYaiT aDYaiT = (ADYaiT) childAt.getLayoutParams();
            if (AlLFFp(childAt) && (!z || aDYaiT.f1863A5SV6n)) {
                int width = childAt.getWidth();
                if (A4TApA(3, childAt)) {
                    int top = childAt.getTop();
                    B3GDIM2 = this.f8625B3GDIM.B3GDIM(childAt, -width, top);
                } else {
                    B3GDIM2 = this.f8626B4ZgIw.B3GDIM(childAt, getWidth(), childAt.getTop());
                }
                z2 |= B3GDIM2;
                aDYaiT.f1863A5SV6n = false;
            }
        }
        CrfGsy.ARc23Z aRc23Z = this.f8627B7CMnp;
        aRc23Z.f1873ADYaiT.removeCallbacks(aRc23Z.f1872A5SV6n);
        CrfGsy.ARc23Z aRc23Z2 = this.f8628B9tovu;
        aRc23Z2.f1873ADYaiT.removeCallbacks(aRc23Z2.f1872A5SV6n);
        if (z2) {
            invalidate();
        }
    }

    public final View AMqCpz(int i) {
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((AZOQYO(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public final View ARc23Z() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((ADYaiT) childAt.getLayoutParams()).f1864ADYaiT & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View ASJ6gh() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (AlLFFp(childAt)) {
                if (!AlLFFp(childAt)) {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                if (((ADYaiT) childAt.getLayoutParams()).f1862A4TApA > 0.0f) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public final int AYUAbz(View view) {
        if (!AlLFFp(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        int i = ((ADYaiT) view.getLayoutParams()).f1861A2egSU;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        int layoutDirection = getLayoutDirection();
        if (i == 3) {
            int i2 = this.f8632BJ7GGh;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.f8634BPw6Q8 : this.f8635BTvldC;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.f8633BNL6CD;
            if (i4 != 3) {
                return i4;
            }
            int i5 = layoutDirection == 0 ? this.f8635BTvldC : this.f8634BPw6Q8;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.f8634BPw6Q8;
            if (i6 != 3) {
                return i6;
            }
            int i7 = layoutDirection == 0 ? this.f8632BJ7GGh : this.f8633BNL6CD;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.f8635BTvldC;
        if (i8 != 3) {
            return i8;
        }
        int i9 = layoutDirection == 0 ? this.f8633BNL6CD : this.f8632BJ7GGh;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    public final int AZOQYO(View view) {
        int i = ((ADYaiT) view.getLayoutParams()).f1861A2egSU;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        return Gravity.getAbsoluteGravity(i, getLayoutDirection());
    }

    public final void AmA8tU(View view) {
        if (!AlLFFp(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        ADYaiT aDYaiT = (ADYaiT) view.getLayoutParams();
        if (this.f8631BIYEnU) {
            aDYaiT.f1862A4TApA = 1.0f;
            aDYaiT.f1864ADYaiT = 1;
            B3GDIM(view, true);
            B2KMhB(view);
        } else {
            aDYaiT.f1864ADYaiT |= 2;
            if (A4TApA(3, view)) {
                this.f8625B3GDIM.B3GDIM(view, 0, view.getTop());
            } else {
                this.f8626B4ZgIw.B3GDIM(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void AzWtSf(int i, int i2) {
        View AMqCpz;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        if (i2 == 3) {
            this.f8632BJ7GGh = i;
        } else if (i2 == 5) {
            this.f8633BNL6CD = i;
        } else if (i2 == 8388611) {
            this.f8634BPw6Q8 = i;
        } else if (i2 == 8388613) {
            this.f8635BTvldC = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f8625B3GDIM : this.f8626B4ZgIw).A2egSU();
        }
        if (i != 1) {
            if (i == 2 && (AMqCpz = AMqCpz(absoluteGravity)) != null) {
                AmA8tU(AMqCpz);
                return;
            }
            return;
        }
        View AMqCpz2 = AMqCpz(absoluteGravity);
        if (AMqCpz2 != null) {
            A5SV6n(AMqCpz2, true);
        }
    }

    public final void B25kr6(View view, float f) {
        ADYaiT aDYaiT = (ADYaiT) view.getLayoutParams();
        if (f == aDYaiT.f1862A4TApA) {
            return;
        }
        aDYaiT.f1862A4TApA = f;
        ArrayList arrayList = this.f8638BniPrB;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((A5SV6n) this.f8638BniPrB.get(size)).getClass();
            }
        }
    }

    public final void B2KMhB(View view) {
        CQhlFr.A5SV6n a5SV6n = CQhlFr.A5SV6n.f1763AcNBzu;
        DG07BK.B25kr6(a5SV6n.A2egSU(), view);
        DG07BK.AaHO0E(0, view);
        if (!AcNBzu(view) || AYUAbz(view) == 2) {
            return;
        }
        DG07BK.B2KMhB(view, a5SV6n, null, this.f8646CTkVKb);
    }

    public final void B3GDIM(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || AlLFFp(childAt)) && !(z && childAt == view)) {
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                childAt.setImportantForAccessibility(4);
            } else {
                WeakHashMap weakHashMap2 = DG07BK.f1680A2egSU;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    public final void B4ZgIw(int i, View view) {
        int i2;
        View rootView;
        int i3 = this.f8625B3GDIM.f1837A2egSU;
        int i4 = this.f8626B4ZgIw.f1837A2egSU;
        if (i3 == 1 || i4 == 1) {
            i2 = 1;
        } else {
            i2 = 2;
            if (i3 != 2 && i4 != 2) {
                i2 = 0;
            }
        }
        if (view != null && i == 0) {
            float f = ((ADYaiT) view.getLayoutParams()).f1862A4TApA;
            if (f == 0.0f) {
                ADYaiT aDYaiT = (ADYaiT) view.getLayoutParams();
                if ((aDYaiT.f1864ADYaiT & 1) == 1) {
                    aDYaiT.f1864ADYaiT = 0;
                    ArrayList arrayList = this.f8638BniPrB;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((A5SV6n) this.f8638BniPrB.get(size)).A4TApA(view);
                        }
                    }
                    B3GDIM(view, false);
                    B2KMhB(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f == 1.0f) {
                ADYaiT aDYaiT2 = (ADYaiT) view.getLayoutParams();
                if ((aDYaiT2.f1864ADYaiT & 1) == 0) {
                    aDYaiT2.f1864ADYaiT = 1;
                    ArrayList arrayList2 = this.f8638BniPrB;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ((A5SV6n) this.f8638BniPrB.get(size2)).A2egSU(view);
                        }
                    }
                    B3GDIM(view, true);
                    B2KMhB(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i2 != this.f8629BChYOn) {
            this.f8629BChYOn = i2;
            ArrayList arrayList3 = this.f8638BniPrB;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((A5SV6n) this.f8638BniPrB.get(size3)).getClass();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        boolean z = false;
        while (true) {
            arrayList2 = this.f8643COJEAR;
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (!AlLFFp(childAt)) {
                arrayList2.add(childAt);
            } else if (AcNBzu(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
            i3++;
        }
        if (!z) {
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) arrayList2.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (ARc23Z() != null || AlLFFp(view)) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            view.setImportantForAccessibility(4);
        } else {
            WeakHashMap weakHashMap2 = DG07BK.f1680A2egSU;
            view.setImportantForAccessibility(1);
        }
        if (f8616CikNvS) {
            return;
        }
        DG07BK.B4ZgIw(view, this.f8619AcNBzu);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ADYaiT) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((ADYaiT) getChildAt(i).getLayoutParams()).f1862A4TApA);
        }
        this.f8623B25kr6 = f;
        boolean ASJ6gh2 = this.f8625B3GDIM.ASJ6gh();
        boolean ASJ6gh3 = this.f8626B4ZgIw.ASJ6gh();
        if (ASJ6gh2 || ASJ6gh3) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean dispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f8623B25kr6 <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (this.f8644CQhlFr == null) {
                this.f8644CQhlFr = new Rect();
            }
            childAt.getHitRect(this.f8644CQhlFr);
            if (this.f8644CQhlFr.contains((int) x, (int) y) && !AaHO0E(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.f8645CSDoyG == null) {
                            this.f8645CSDoyG = new Matrix();
                        }
                        matrix.invert(this.f8645CSDoyG);
                        obtain.transform(this.f8645CSDoyG);
                    }
                    dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(obtain);
                    obtain.recycle();
                }
                if (dispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        Drawable background;
        int height = getHeight();
        boolean AaHO0E2 = AaHO0E(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (AaHO0E2) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && AlLFFp(childAt) && childAt.getHeight() >= height) {
                    if (A4TApA(3, childAt)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.f8623B25kr6;
        if (f > 0.0f && AaHO0E2) {
            int i4 = this.f8622AzWtSf;
            Paint paint = this.f8624B2KMhB;
            paint.setColor((((int) ((((-16777216) & i4) >>> 24) * f)) << 24) | (i4 & 16777215));
            canvas.drawRect(i, 0.0f, width, getHeight(), paint);
        }
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ADYaiT aDYaiT = new ADYaiT(-1, -1);
        aDYaiT.f1861A2egSU = 0;
        return aDYaiT;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ADYaiT) {
            ADYaiT aDYaiT = (ADYaiT) layoutParams;
            ADYaiT aDYaiT2 = new ADYaiT(aDYaiT);
            aDYaiT2.f1861A2egSU = 0;
            aDYaiT2.f1861A2egSU = aDYaiT.f1861A2egSU;
            return aDYaiT2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ADYaiT aDYaiT3 = new ADYaiT((ViewGroup.MarginLayoutParams) layoutParams);
            aDYaiT3.f1861A2egSU = 0;
            return aDYaiT3;
        }
        ADYaiT aDYaiT4 = new ADYaiT(layoutParams);
        aDYaiT4.f1861A2egSU = 0;
        return aDYaiT4;
    }

    public float getDrawerElevation() {
        if (f8617CkXcdM) {
            return this.f8620AlLFFp;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f8640C4FrIb;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8631BIYEnU = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8631BIYEnU = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f8642CNPG0E || this.f8640C4FrIb == null) {
            return;
        }
        WindowInsets windowInsets = this.f8641CASmeH;
        int systemWindowInsetTop = windowInsets != null ? windowInsets.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f8640C4FrIb.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f8640C4FrIb.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            CqNSpT.ARc23Z r1 = r8.f8625B3GDIM
            boolean r2 = r1.B2KMhB(r9)
            CqNSpT.ARc23Z r3 = r8.f8626B4ZgIw
            boolean r3 = r3.B2KMhB(r9)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L68
            if (r0 == r3) goto L61
            r9 = 2
            if (r0 == r9) goto L1e
            r9 = 3
            if (r0 == r9) goto L61
            goto L66
        L1e:
            float[] r9 = r1.f1840ADYaiT
            int r9 = r9.length
            r0 = 0
        L22:
            if (r0 >= r9) goto L66
            int r5 = r1.f1846AaHO0E
            int r6 = r3 << r0
            r5 = r5 & r6
            if (r5 == 0) goto L5e
            float[] r5 = r1.f1841ARc23Z
            r5 = r5[r0]
            float[] r6 = r1.f1840ADYaiT
            r6 = r6[r0]
            float r5 = r5 - r6
            float[] r6 = r1.f1842ASJ6gh
            r6 = r6[r0]
            float[] r7 = r1.AMqCpz
            r7 = r7[r0]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r1.f1838A4TApA
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5e
            CrfGsy.ARc23Z r9 = r8.f8627B7CMnp
            androidx.drawerlayout.widget.DrawerLayout r0 = r9.f1873ADYaiT
            ADYaiT.D8MqeW r9 = r9.f1872A5SV6n
            r0.removeCallbacks(r9)
            CrfGsy.ARc23Z r9 = r8.f8628B9tovu
            androidx.drawerlayout.widget.DrawerLayout r0 = r9.f1873ADYaiT
            ADYaiT.D8MqeW r9 = r9.f1872A5SV6n
            r0.removeCallbacks(r9)
            goto L66
        L5e:
            int r0 = r0 + 1
            goto L22
        L61:
            r8.ADYaiT(r3)
            r8.f8636BV3sI0 = r4
        L66:
            r9 = 0
            goto L8e
        L68:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.BpkvW3 = r0
            r8.f8639C2rE4F = r9
            float r5 = r8.f8623B25kr6
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L8b
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r1.AYUAbz(r0, r9)
            if (r9 == 0) goto L8b
            boolean r9 = AaHO0E(r9)
            if (r9 == 0) goto L8b
            r9 = 1
            goto L8c
        L8b:
            r9 = 0
        L8c:
            r8.f8636BV3sI0 = r4
        L8e:
            if (r2 != 0) goto Lb1
            if (r9 != 0) goto Lb1
            int r9 = r8.getChildCount()
            r0 = 0
        L97:
            if (r0 >= r9) goto Lab
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            CrfGsy.ADYaiT r1 = (CrfGsy.ADYaiT) r1
            boolean r1 = r1.f1863A5SV6n
            if (r1 == 0) goto La8
            goto Lb1
        La8:
            int r0 = r0 + 1
            goto L97
        Lab:
            boolean r9 = r8.f8636BV3sI0
            if (r9 == 0) goto Lb0
            goto Lb1
        Lb0:
            return r4
        Lb1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || ASJ6gh() == null) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View ASJ6gh2 = ASJ6gh();
        if (ASJ6gh2 != null && AYUAbz(ASJ6gh2) == 0) {
            ADYaiT(false);
        }
        return ASJ6gh2 != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d2, code lost:
    
        r1 = getRootWindowInsets();
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r20, int r21) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View AMqCpz;
        if (!(parcelable instanceof AMqCpz)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        AMqCpz aMqCpz = (AMqCpz) parcelable;
        super.onRestoreInstanceState(aMqCpz.getSuperState());
        int i = aMqCpz.f1865AcNBzu;
        if (i != 0 && (AMqCpz = AMqCpz(i)) != null) {
            AmA8tU(AMqCpz);
        }
        int i2 = aMqCpz.f1866AlLFFp;
        if (i2 != 3) {
            AzWtSf(i2, 3);
        }
        int i3 = aMqCpz.f1867AmA8tU;
        if (i3 != 3) {
            AzWtSf(i3, 5);
        }
        int i4 = aMqCpz.f1868AzWtSf;
        if (i4 != 3) {
            AzWtSf(i4, 8388611);
        }
        int i5 = aMqCpz.f1869B25kr6;
        if (i5 != 3) {
            AzWtSf(i5, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        if (f8617CkXcdM) {
            return;
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        getLayoutDirection();
        getLayoutDirection();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        AMqCpz aMqCpz = new AMqCpz(super.onSaveInstanceState());
        aMqCpz.f1865AcNBzu = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ADYaiT aDYaiT = (ADYaiT) getChildAt(i).getLayoutParams();
            int i2 = aDYaiT.f1864ADYaiT;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                aMqCpz.f1865AcNBzu = aDYaiT.f1861A2egSU;
                break;
            }
        }
        aMqCpz.f1866AlLFFp = this.f8632BJ7GGh;
        aMqCpz.f1867AmA8tU = this.f8633BNL6CD;
        aMqCpz.f1868AzWtSf = this.f8634BPw6Q8;
        aMqCpz.f1869B25kr6 = this.f8635BTvldC;
        return aMqCpz;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (AYUAbz(r7) != 2) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            CqNSpT.ARc23Z r0 = r6.f8625B3GDIM
            r0.AZkASS(r7)
            CqNSpT.ARc23Z r1 = r6.f8626B4ZgIw
            r1.AZkASS(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L5c
            if (r1 == r3) goto L20
            r7 = 3
            if (r1 == r7) goto L1a
            return r3
        L1a:
            r6.ADYaiT(r3)
            r6.f8636BV3sI0 = r2
            return r3
        L20:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.AYUAbz(r4, r5)
            if (r4 == 0) goto L57
            boolean r4 = AaHO0E(r4)
            if (r4 == 0) goto L57
            float r4 = r6.BpkvW3
            float r1 = r1 - r4
            float r4 = r6.f8639C2rE4F
            float r7 = r7 - r4
            int r0 = r0.f1838A4TApA
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L57
            android.view.View r7 = r6.ARc23Z()
            if (r7 == 0) goto L57
            int r7 = r6.AYUAbz(r7)
            r0 = 2
            if (r7 != r0) goto L58
        L57:
            r2 = 1
        L58:
            r6.ADYaiT(r2)
            return r3
        L5c:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.BpkvW3 = r0
            r6.f8639C2rE4F = r7
            r6.f8636BV3sI0 = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            ADYaiT(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f8630BI9f7h) {
            return;
        }
        super.requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f8620AlLFFp = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (AlLFFp(childAt)) {
                float f2 = this.f8620AlLFFp;
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                CmUvjW.B4ZgIw(childAt, f2);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(A5SV6n a5SV6n) {
        ArrayList arrayList;
        A5SV6n a5SV6n2 = this.f8637BmvVmW;
        if (a5SV6n2 != null && (arrayList = this.f8638BniPrB) != null) {
            arrayList.remove(a5SV6n2);
        }
        if (a5SV6n != null) {
            A2egSU(a5SV6n);
        }
        this.f8637BmvVmW = a5SV6n;
    }

    public void setDrawerLockMode(int i) {
        AzWtSf(i, 3);
        AzWtSf(i, 5);
    }

    public void setScrimColor(int i) {
        this.f8622AzWtSf = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f8640C4FrIb = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f8640C4FrIb = new ColorDrawable(i);
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.f8640C4FrIb = i != 0 ? BPw6Q8.A2egSU.A4TApA(getContext(), i) : null;
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ADYaiT aDYaiT = new ADYaiT(context, attributeSet);
        aDYaiT.f1861A2egSU = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8615Cd8JRx);
        aDYaiT.f1861A2egSU = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        return aDYaiT;
    }
}
