package androidx.coordinatorlayout.widget;

import B25kr6.AzWtSf;
import B4ZgIw.ARc23Z;
import COJEAR.BI9f7h;
import COJEAR.BIYEnU;
import COJEAR.BJ7GGh;
import COJEAR.CikNvS;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import COJEAR.FG7pZc;
import IlwJBd.ADYaiT;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.R$styleable;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.blurkit.d;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CoordinatorLayout extends ViewGroup implements BI9f7h, BIYEnU {
    public static final String BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public static final Class[] f8444C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public static final ThreadLocal f8445C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public static final ARc23Z f8446CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public static final CNPG0E.A5SV6n f8447CNPG0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f8448AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final BNL6CD.A5SV6n f8449AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f8450AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f8451AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Paint f8452B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int[] f8453B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int[] f8454B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f8455B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f8456B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final int[] f8457B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public View f8458BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public View f8459BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public ADYaiT f8460BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f8461BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public FG7pZc f8462BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f8463BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public Drawable f8464BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f8465BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public AZkASS.ARc23Z f8466BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final BJ7GGh f8467BniPrB;

    public static abstract class A2egSU {
        public static Object getTag(View view) {
            return ((A5SV6n) view.getLayoutParams()).f8443B3GDIM;
        }

        public static void setTag(View view, Object obj) {
            ((A5SV6n) view.getLayoutParams()).f8443B3GDIM = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
            return getScrimOpacity(coordinatorLayout, view) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, View view) {
            return d.f13043a;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public FG7pZc onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, FG7pZc fG7pZc) {
            return fG7pZc;
        }

        public void onAttachedToLayoutParams(A5SV6n a5SV6n) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, view, view2, i, i2, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, view, view2, i, i2, i3, i4);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, view, view2, view3, i);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (i2 == 0) {
                return onStartNestedScroll(coordinatorLayout, view, view2, view3, i);
            }
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, view, view2);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            onNestedScroll(coordinatorLayout, view, view2, i, i2, i3, i4, i5);
        }
    }

    static {
        int i = 1;
        Package r1 = CoordinatorLayout.class.getPackage();
        BpkvW3 = r1 != null ? r1.getName() : null;
        f8446CASmeH = new ARc23Z(i);
        f8444C2rE4F = new Class[]{Context.class, AttributeSet.class};
        f8445C4FrIb = new ThreadLocal();
        f8447CNPG0E = new CNPG0E.A5SV6n(12);
        LcRnTzq();
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968955);
        this.f8448AcNBzu = new ArrayList();
        this.f8449AlLFFp = new BNL6CD.A5SV6n();
        this.f8450AmA8tU = new ArrayList();
        this.f8451AzWtSf = new ArrayList();
        this.f8453B2KMhB = new int[2];
        this.f8454B3GDIM = new int[2];
        this.f8467BniPrB = new BJ7GGh();
        int[] iArr = R$styleable.f8425A2egSU;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 2130968955, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 2130968955, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f8457B9tovu = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                this.f8457B9tovu[i] = (int) (r2[i] * f);
            }
        }
        this.f8464BTvldC = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        B2KMhB();
        super.setOnHierarchyChangeListener(new BNL6CD.A2egSU(this));
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect A2egSU() {
        Rect rect = (Rect) f8447CNPG0E.A2egSU();
        return rect == null ? new Rect() : rect;
    }

    public static void ARc23Z(int i, Rect rect, Rect rect2, A5SV6n a5SV6n, int i2, int i3) {
        int i4 = a5SV6n.f8429A5SV6n;
        if (i4 == 0) {
            i4 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = a5SV6n.f8430ADYaiT;
        if ((i5 & 7) == 0) {
            i5 |= 8388611;
        }
        if ((i5 & AdEventType.AD_TICK) == 0) {
            i5 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i5, i);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & AdEventType.AD_TICK;
        int i8 = absoluteGravity2 & 7;
        int i9 = absoluteGravity2 & AdEventType.AD_TICK;
        int width = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            width -= i2 / 2;
        } else if (i6 != 5) {
            width -= i2;
        }
        if (i7 == 16) {
            height -= i3 / 2;
        } else if (i7 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static A5SV6n ASJ6gh(View view) {
        A5SV6n a5SV6n = (A5SV6n) view.getLayoutParams();
        if (!a5SV6n.f8428A4TApA) {
            if (view instanceof androidx.coordinatorlayout.widget.A2egSU) {
                a5SV6n.A4TApA(((androidx.coordinatorlayout.widget.A2egSU) view).getBehavior());
                a5SV6n.f8428A4TApA = true;
                return a5SV6n;
            }
            A4TApA a4TApA = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                a4TApA = (A4TApA) cls.getAnnotation(A4TApA.class);
                if (a4TApA != null) {
                    break;
                }
            }
            if (a4TApA != null) {
                try {
                    a5SV6n.A4TApA((A2egSU) a4TApA.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    a4TApA.value().getClass();
                }
            }
            a5SV6n.f8428A4TApA = true;
        }
        return a5SV6n;
    }

    public static void AzWtSf(int i, View view) {
        A5SV6n a5SV6n = (A5SV6n) view.getLayoutParams();
        int i2 = a5SV6n.f8434AZOQYO;
        if (i2 != i) {
            DG07BK.AcNBzu(i - i2, view);
            a5SV6n.f8434AZOQYO = i;
        }
    }

    public static void B25kr6(int i, View view) {
        A5SV6n a5SV6n = (A5SV6n) view.getLayoutParams();
        int i2 = a5SV6n.f8435AZkASS;
        if (i2 != i) {
            DG07BK.AlLFFp(i - i2, view);
            a5SV6n.f8435AZkASS = i;
        }
    }

    private static /* synthetic */ void LcRnTzq() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A4TApA(A5SV6n a5SV6n, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) a5SV6n).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) a5SV6n).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) a5SV6n).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) a5SV6n).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    public final void A5SV6n(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            AMqCpz(rect, view);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList ADYaiT(View view) {
        AzWtSf azWtSf = this.f8449AlLFFp.f1427A4TApA;
        int i = azWtSf.f1011AmA8tU;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) azWtSf.AZkASS(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(azWtSf.ARc23Z(i2));
            }
        }
        ArrayList arrayList3 = this.f8451AzWtSf;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void AMqCpz(Rect rect, View view) {
        ThreadLocal threadLocal = BNL6CD.ADYaiT.f1430A2egSU;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = BNL6CD.ADYaiT.f1430A2egSU;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        BNL6CD.ADYaiT.A2egSU(this, view, matrix);
        ThreadLocal threadLocal3 = BNL6CD.ADYaiT.f1431A4TApA;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final boolean AYUAbz(View view, int i, int i2) {
        CNPG0E.A5SV6n a5SV6n = f8447CNPG0E;
        Rect A2egSU2 = A2egSU();
        AMqCpz(A2egSU2, view);
        try {
            return A2egSU2.contains(i, i2);
        } finally {
            A2egSU2.setEmpty();
            a5SV6n.A5SV6n(A2egSU2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x028c A[EDGE_INSN: B:133:0x028c->B:105:0x028c BREAK  A[LOOP:2: B:110:0x02a4->B:121:0x02e0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZOQYO(int r26) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.AZOQYO(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZkASS(int r13, android.view.View r14) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.AZkASS(int, android.view.View):void");
    }

    public final void AaHO0E(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public final boolean AcNBzu(MotionEvent motionEvent, int i) {
        boolean blocksInteractionBelow;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f8450AmA8tU;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            arrayList.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        ARc23Z aRc23Z = f8446CASmeH;
        if (aRc23Z != null) {
            Collections.sort(arrayList, aRc23Z);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            A5SV6n a5SV6n = (A5SV6n) view.getLayoutParams();
            A2egSU a2egSU = a5SV6n.f8427A2egSU;
            if (!(z || z2) || actionMasked == 0) {
                if (!z && a2egSU != null) {
                    if (i == 0) {
                        z = a2egSU.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i == 1) {
                        z = a2egSU.onTouchEvent(this, view, motionEvent);
                    }
                    if (z) {
                        this.f8458BChYOn = view;
                    }
                }
                A2egSU a2egSU2 = a5SV6n.f8427A2egSU;
                if (a2egSU2 == null) {
                    a5SV6n.f8438AlLFFp = false;
                }
                boolean z3 = a5SV6n.f8438AlLFFp;
                if (z3) {
                    blocksInteractionBelow = true;
                } else {
                    blocksInteractionBelow = (a2egSU2 != null ? a2egSU2.blocksInteractionBelow(this, view) : false) | z3;
                    a5SV6n.f8438AlLFFp = blocksInteractionBelow;
                }
                boolean z4 = blocksInteractionBelow && !z3;
                if (blocksInteractionBelow && !z4) {
                    break;
                }
                z2 = z4;
            } else if (a2egSU != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i == 0) {
                    a2egSU.onInterceptTouchEvent(this, view, motionEvent2);
                } else if (i == 1) {
                    a2egSU.onTouchEvent(this, view, motionEvent2);
                }
            }
        }
        arrayList.clear();
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f3, code lost:
    
        if ((android.view.Gravity.getAbsoluteGravity(r8.f8433AYUAbz, r12) & r13) == r13) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0140, code lost:
    
        throw new java.lang.IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AlLFFp() {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.AlLFFp():void");
    }

    public final void AmA8tU(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            A2egSU a2egSU = ((A5SV6n) childAt.getLayoutParams()).f8427A2egSU;
            if (a2egSU != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    a2egSU.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    a2egSU.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((A5SV6n) getChildAt(i2).getLayoutParams()).f8438AlLFFp = false;
        }
        this.f8458BChYOn = null;
        this.f8455B4ZgIw = false;
    }

    public final void B2KMhB() {
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        if (!getFitsSystemWindows()) {
            CmUvjW.B9tovu(this, null);
            return;
        }
        if (this.f8466BmvVmW == null) {
            this.f8466BmvVmW = new AZkASS.ARc23Z(4, this);
        }
        CmUvjW.B9tovu(this, this.f8466BmvVmW);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof A5SV6n) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        A5SV6n a5SV6n = (A5SV6n) view.getLayoutParams();
        A2egSU a2egSU = a5SV6n.f8427A2egSU;
        if (a2egSU != null) {
            float scrimOpacity = a2egSU.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.f8452B25kr6 == null) {
                    this.f8452B25kr6 = new Paint();
                }
                this.f8452B25kr6.setColor(a5SV6n.f8427A2egSU.getScrimColor(this, view));
                Paint paint = this.f8452B25kr6;
                int round = Math.round(scrimOpacity * 255.0f);
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                paint.setAlpha(round);
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f8452B25kr6);
                canvas.restoreToCount(save);
                return super.drawChild(canvas, view, j);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f8464BTvldC;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new A5SV6n();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new A5SV6n(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        AlLFFp();
        return Collections.unmodifiableList(this.f8448AcNBzu);
    }

    public final FG7pZc getLastWindowInsets() {
        return this.f8462BNL6CD;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        BJ7GGh bJ7GGh = this.f8467BniPrB;
        return bJ7GGh.f1649A4TApA | bJ7GGh.f1648A2egSU;
    }

    public Drawable getStatusBarBackground() {
        return this.f8464BTvldC;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AmA8tU(false);
        if (this.f8461BJ7GGh) {
            if (this.f8460BIYEnU == null) {
                this.f8460BIYEnU = new ADYaiT(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f8460BIYEnU);
        }
        if (this.f8462BNL6CD == null) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            if (getFitsSystemWindows()) {
                CikNvS.A5SV6n(this);
            }
        }
        this.f8456B7CMnp = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AmA8tU(false);
        if (this.f8461BJ7GGh && this.f8460BIYEnU != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f8460BIYEnU);
        }
        View view = this.f8459BI9f7h;
        if (view != null) {
            onStopNestedScroll(view, 0);
        }
        this.f8456B7CMnp = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f8463BPw6Q8 || this.f8464BTvldC == null) {
            return;
        }
        FG7pZc fG7pZc = this.f8462BNL6CD;
        int ADYaiT2 = fG7pZc != null ? fG7pZc.ADYaiT() : 0;
        if (ADYaiT2 > 0) {
            this.f8464BTvldC.setBounds(0, 0, getWidth(), ADYaiT2);
            this.f8464BTvldC.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            AmA8tU(true);
        }
        boolean AcNBzu2 = AcNBzu(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return AcNBzu2;
        }
        AmA8tU(true);
        return AcNBzu2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        A2egSU a2egSU;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f8448AcNBzu;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            if (view.getVisibility() != 8 && ((a2egSU = ((A5SV6n) view.getLayoutParams()).f8427A2egSU) == null || !a2egSU.onLayoutChild(this, view, layoutDirection))) {
                AZkASS(layoutDirection, view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        A2egSU a2egSU;
        View view2;
        float f3;
        float f4;
        boolean z2;
        int childCount = getChildCount();
        int i = 0;
        boolean z3 = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                A5SV6n a5SV6n = (A5SV6n) childAt.getLayoutParams();
                if (a5SV6n.A2egSU(0) && (a2egSU = a5SV6n.f8427A2egSU) != null) {
                    view2 = view;
                    f3 = f;
                    f4 = f2;
                    z2 = z;
                    z3 |= a2egSU.onNestedFling(this, childAt, view2, f3, f4, z2);
                    i++;
                    view = view2;
                    f = f3;
                    f2 = f4;
                    z = z2;
                }
            }
            view2 = view;
            f3 = f;
            f4 = f2;
            z2 = z;
            i++;
            view = view2;
            f = f3;
            f2 = f4;
            z = z2;
        }
        if (z3) {
            AZOQYO(1);
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        A2egSU a2egSU;
        View view2;
        float f3;
        float f4;
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                A5SV6n a5SV6n = (A5SV6n) childAt.getLayoutParams();
                if (a5SV6n.A2egSU(0) && (a2egSU = a5SV6n.f8427A2egSU) != null) {
                    view2 = view;
                    f3 = f;
                    f4 = f2;
                    z |= a2egSU.onNestedPreFling(this, childAt, view2, f3, f4);
                    i++;
                    view = view2;
                    f = f3;
                    f2 = f4;
                }
            }
            view2 = view;
            f3 = f;
            f4 = f2;
            i++;
            view = view2;
            f = f3;
            f2 = f4;
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        A2egSU a2egSU;
        View view3;
        View view4;
        int i3;
        int i4;
        BJ7GGh bJ7GGh = this.f8467BniPrB;
        if (i2 == 1) {
            bJ7GGh.f1649A4TApA = i;
        } else {
            bJ7GGh.f1648A2egSU = i;
        }
        this.f8459BI9f7h = view2;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            A5SV6n a5SV6n = (A5SV6n) childAt.getLayoutParams();
            if (a5SV6n.A2egSU(i2) && (a2egSU = a5SV6n.f8427A2egSU) != null) {
                view3 = view;
                view4 = view2;
                i3 = i;
                i4 = i2;
                a2egSU.onNestedScrollAccepted(this, childAt, view3, view4, i3, i4);
            } else {
                view3 = view;
                view4 = view2;
                i3 = i;
                i4 = i2;
            }
            i5++;
            view = view3;
            view2 = view4;
            i = i3;
            i2 = i4;
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof BNL6CD.A4TApA)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        BNL6CD.A4TApA a4TApA = (BNL6CD.A4TApA) parcelable;
        super.onRestoreInstanceState(a4TApA.getSuperState());
        SparseArray sparseArray = a4TApA.f1425AcNBzu;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            A2egSU a2egSU = ASJ6gh(childAt).f8427A2egSU;
            if (id != -1 && a2egSU != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                a2egSU.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        BNL6CD.A4TApA a4TApA = new BNL6CD.A4TApA(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            A2egSU a2egSU = ((A5SV6n) childAt.getLayoutParams()).f8427A2egSU;
            if (id != -1 && a2egSU != null && (onSaveInstanceState = a2egSU.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        a4TApA.f1425AcNBzu = sparseArray;
        return a4TApA;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // COJEAR.BI9f7h
    public final void onStopNestedScroll(View view, int i) {
        BJ7GGh bJ7GGh = this.f8467BniPrB;
        if (i == 1) {
            bJ7GGh.f1649A4TApA = 0;
        } else {
            bJ7GGh.f1648A2egSU = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            A5SV6n a5SV6n = (A5SV6n) childAt.getLayoutParams();
            if (a5SV6n.A2egSU(i)) {
                A2egSU a2egSU = a5SV6n.f8427A2egSU;
                if (a2egSU != null) {
                    a2egSU.onStopNestedScroll(this, childAt, view, i);
                }
                if (i == 0) {
                    a5SV6n.f8439AmA8tU = false;
                } else if (i == 1) {
                    a5SV6n.f8440AzWtSf = false;
                }
                a5SV6n.f8441B25kr6 = false;
            }
        }
        this.f8459BI9f7h = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f8458BChYOn
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.AcNBzu(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2a
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.f8458BChYOn
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.A5SV6n r6 = (androidx.coordinatorlayout.widget.A5SV6n) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$A2egSU r6 = r6.f8427A2egSU
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f8458BChYOn
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.f8458BChYOn
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.AmA8tU(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        A2egSU a2egSU = ((A5SV6n) view.getLayoutParams()).f8427A2egSU;
        if (a2egSU == null || !a2egSU.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f8455B4ZgIw) {
            return;
        }
        AmA8tU(false);
        this.f8455B4ZgIw = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        B2KMhB();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f8465BV3sI0 = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f8464BTvldC;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f8464BTvldC = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f8464BTvldC.setState(getDrawableState());
                }
                Drawable drawable3 = this.f8464BTvldC;
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                com.bumptech.glide.A5SV6n.D8cQ8b(drawable3, getLayoutDirection());
                this.f8464BTvldC.setVisible(getVisibility() == 0, false);
                this.f8464BTvldC.setCallback(this);
            }
            WeakHashMap weakHashMap2 = DG07BK.f1680A2egSU;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? BPw6Q8.A2egSU.A4TApA(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f8464BTvldC;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.f8464BTvldC.setVisible(z, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8464BTvldC;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof A5SV6n ? new A5SV6n((A5SV6n) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new A5SV6n((ViewGroup.MarginLayoutParams) layoutParams) : new A5SV6n(layoutParams);
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        A2egSU a2egSU;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                A5SV6n a5SV6n = (A5SV6n) childAt.getLayoutParams();
                if (a5SV6n.A2egSU(i3) && (a2egSU = a5SV6n.f8427A2egSU) != null) {
                    int[] iArr2 = this.f8453B2KMhB;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    a2egSU.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    i4 = i > 0 ? Math.max(i4, iArr2[0]) : Math.min(i4, iArr2[0]);
                    i5 = i2 > 0 ? Math.max(i5, iArr2[1]) : Math.min(i5, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            AZOQYO(1);
        }
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.f8454B3GDIM);
    }

    @Override // COJEAR.BI9f7h
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                A5SV6n a5SV6n = (A5SV6n) childAt.getLayoutParams();
                A2egSU a2egSU = a5SV6n.f8427A2egSU;
                if (a2egSU != null) {
                    boolean onStartNestedScroll = a2egSU.onStartNestedScroll(this, childAt, view, view2, i, i2);
                    z |= onStartNestedScroll;
                    if (i2 == 0) {
                        a5SV6n.f8439AmA8tU = onStartNestedScroll;
                    } else if (i2 == 1) {
                        a5SV6n.f8440AzWtSf = onStartNestedScroll;
                    }
                } else if (i2 == 0) {
                    a5SV6n.f8439AmA8tU = false;
                } else if (i2 == 1) {
                    a5SV6n.f8440AzWtSf = false;
                }
            }
        }
        return z;
    }

    @Override // COJEAR.BIYEnU
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        A2egSU a2egSU;
        int min;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                A5SV6n a5SV6n = (A5SV6n) childAt.getLayoutParams();
                if (a5SV6n.A2egSU(i5) && (a2egSU = a5SV6n.f8427A2egSU) != null) {
                    int[] iArr2 = this.f8453B2KMhB;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    a2egSU.onNestedScroll(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    int[] iArr3 = this.f8453B2KMhB;
                    i6 = i3 > 0 ? Math.max(i6, iArr3[0]) : Math.min(i6, iArr3[0]);
                    if (i4 > 0) {
                        min = Math.max(i7, iArr3[1]);
                    } else {
                        min = Math.min(i7, iArr3[1]);
                    }
                    i7 = min;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            AZOQYO(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }
}
