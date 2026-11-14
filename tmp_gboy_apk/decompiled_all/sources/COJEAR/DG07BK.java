package COJEAR;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.baidu.mobads.sdk.internal.a.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class DG07BK {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static WeakHashMap f1680A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static Field f1681A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static boolean f1682A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static ThreadLocal f1683ADYaiT;
    public static final int[] AMqCpz = {2131296283, 2131296284, 2131296295, 2131296306, 2131296309, 2131296310, 2131296311, 2131296312, 2131296313, 2131296314, 2131296285, 2131296286, 2131296287, 2131296288, 2131296289, 2131296290, 2131296291, 2131296292, 2131296293, 2131296294, 2131296296, 2131296297, 2131296298, 2131296299, 2131296300, 2131296301, 2131296302, 2131296303, 2131296304, 2131296305, 2131296307, 2131296308};

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final CTkVKb f1684ARc23Z = new CTkVKb();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final Cd8JRx f1685ASJ6gh = new Cd8JRx();

    public static De4eam A2egSU(View view) {
        if (f1680A2egSU == null) {
            f1680A2egSU = new WeakHashMap();
        }
        De4eam de4eam = (De4eam) f1680A2egSU.get(view);
        if (de4eam != null) {
            return de4eam;
        }
        De4eam de4eam2 = new De4eam(view);
        f1680A2egSU.put(view, de4eam2);
        return de4eam2;
    }

    public static FG7pZc A4TApA(View view, FG7pZc fG7pZc) {
        WindowInsets ARc23Z2 = fG7pZc.ARc23Z();
        if (ARc23Z2 != null) {
            WindowInsets A2egSU2 = CikNvS.A2egSU(view, ARc23Z2);
            if (!A2egSU2.equals(ARc23Z2)) {
                return FG7pZc.ASJ6gh(view, A2egSU2);
            }
        }
        return fG7pZc;
    }

    public static boolean A5SV6n(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = DAk1zC.f1676ADYaiT;
        DAk1zC dAk1zC = (DAk1zC) view.getTag(2131298066);
        if (dAk1zC == null) {
            dAk1zC = new DAk1zC();
            dAk1zC.f1677A2egSU = null;
            dAk1zC.f1678A4TApA = null;
            dAk1zC.f1679A5SV6n = null;
            view.setTag(2131298066, dAk1zC);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = dAk1zC.f1677A2egSU;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = DAk1zC.f1676ADYaiT;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (dAk1zC.f1677A2egSU == null) {
                            dAk1zC.f1677A2egSU = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = DAk1zC.f1676ADYaiT;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                dAk1zC.f1677A2egSU.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    dAk1zC.f1677A2egSU.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View A2egSU2 = dAk1zC.A2egSU(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (A2egSU2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (dAk1zC.f1678A4TApA == null) {
                    dAk1zC.f1678A4TApA = new SparseArray();
                }
                dAk1zC.f1678A4TApA.put(keyCode, new WeakReference(A2egSU2));
            }
        }
        return A2egSU2 != null;
    }

    public static View.AccessibilityDelegate ADYaiT(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return D6DOie.A2egSU(view);
        }
        if (f1682A5SV6n) {
            return null;
        }
        if (f1681A4TApA == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1681A4TApA = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1682A5SV6n = true;
                return null;
            }
        }
        try {
            Object obj = f1681A4TApA.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1682A5SV6n = true;
            return null;
        }
    }

    public static CharSequence AMqCpz(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = D07BeM.A4TApA(view);
        } else {
            tag = view.getTag(2131298059);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList ARc23Z(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(2131298056);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(2131298056, arrayList2);
        return arrayList2;
    }

    public static Rect ASJ6gh() {
        if (f1683ADYaiT == null) {
            f1683ADYaiT = new ThreadLocal();
        }
        Rect rect = (Rect) f1683ADYaiT.get();
        if (rect == null) {
            rect = new Rect();
            f1683ADYaiT.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static String[] AYUAbz(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? D8MqeW.A2egSU(appCompatEditText) : (String[]) appCompatEditText.getTag(2131298062);
    }

    public static FG7pZc AZOQYO(View view) {
        return Build.VERSION.SDK_INT >= 23 ? CqNSpT.A2egSU(view) : CmUvjW.AZkASS(view);
    }

    public static Ff5QvW AZkASS(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return D6yqiO.A5SV6n(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return new Ff5QvW(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void AaHO0E(int i, View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = AMqCpz(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(AMqCpz(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError unused) {
                        view.getParent().getClass();
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(obtain2);
            obtain2.setEventType(32);
            obtain2.setContentChangeTypes(i);
            obtain2.setSource(view);
            view.onPopulateAccessibilityEvent(obtain2);
            obtain2.getText().add(AMqCpz(view));
            accessibilityManager.sendAccessibilityEvent(obtain2);
        }
    }

    public static void AcNBzu(int i, View view) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        Rect ASJ6gh2 = ASJ6gh();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            ASJ6gh2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !ASJ6gh2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            BChYOn(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                BChYOn((View) parent2);
            }
        }
        if (z && ASJ6gh2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(ASJ6gh2);
        }
    }

    public static void AlLFFp(int i, View view) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        Rect ASJ6gh2 = ASJ6gh();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            ASJ6gh2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !ASJ6gh2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z = false;
        }
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            BChYOn(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                BChYOn((View) parent2);
            }
        }
        if (z && ASJ6gh2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(ASJ6gh2);
        }
    }

    public static FG7pZc AmA8tU(View view, FG7pZc fG7pZc) {
        WindowInsets ARc23Z2 = fG7pZc.ARc23Z();
        if (ARc23Z2 != null) {
            WindowInsets A4TApA2 = CikNvS.A4TApA(view, ARc23Z2);
            if (!A4TApA2.equals(ARc23Z2)) {
                return FG7pZc.ASJ6gh(view, A4TApA2);
            }
        }
        return fG7pZc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AYUAbz AzWtSf(View view, AYUAbz aYUAbz) {
        if (Log.isLoggable(c.d, 3)) {
            Objects.toString(aYUAbz);
            view.getClass();
            view.getId();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return D8MqeW.A4TApA(view, aYUAbz);
        }
        BPw6Q8 bPw6Q8 = (BPw6Q8) view.getTag(2131298061);
        BTvldC bTvldC = f1684ARc23Z;
        if (bPw6Q8 == null) {
            if (view instanceof BTvldC) {
                bTvldC = (BTvldC) view;
            }
            return bTvldC.A2egSU(aYUAbz);
        }
        AYUAbz A2egSU2 = ((CikNvS.B4ZgIw) bPw6Q8).A2egSU(view, aYUAbz);
        if (A2egSU2 == null) {
            return null;
        }
        if (view instanceof BTvldC) {
            bTvldC = (BTvldC) view;
        }
        return bTvldC.A2egSU(A2egSU2);
    }

    public static void B25kr6(int i, View view) {
        ArrayList ARc23Z2 = ARc23Z(view);
        for (int i2 = 0; i2 < ARc23Z2.size(); i2++) {
            if (((CQhlFr.A5SV6n) ARc23Z2.get(i2)).A2egSU() == i) {
                ARc23Z2.remove(i2);
                return;
            }
        }
    }

    public static void B2KMhB(View view, CQhlFr.A5SV6n a5SV6n, String str, CQhlFr.B7CMnp b7CMnp) {
        if (b7CMnp == null && str == null) {
            B25kr6(a5SV6n.A2egSU(), view);
            AaHO0E(0, view);
            return;
        }
        CQhlFr.A5SV6n a5SV6n2 = new CQhlFr.A5SV6n(null, a5SV6n.f1768A4TApA, str, b7CMnp, a5SV6n.f1769A5SV6n);
        View.AccessibilityDelegate ADYaiT2 = ADYaiT(view);
        A4TApA a4TApA = ADYaiT2 == null ? null : ADYaiT2 instanceof A2egSU ? ((A2egSU) ADYaiT2).f1613A2egSU : new A4TApA(ADYaiT2);
        if (a4TApA == null) {
            a4TApA = new A4TApA();
        }
        B4ZgIw(view, a4TApA);
        B25kr6(a5SV6n2.A2egSU(), view);
        ARc23Z(view).add(a5SV6n2);
        AaHO0E(0, view);
    }

    public static void B3GDIM(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            D6DOie.ADYaiT(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void B4ZgIw(View view, A4TApA a4TApA) {
        if (a4TApA == null && (ADYaiT(view) instanceof A2egSU)) {
            a4TApA = new A4TApA();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(a4TApA == null ? null : a4TApA.f1616A4TApA);
    }

    public static void B7CMnp(View view, CharSequence charSequence) {
        new CcAIMM(2131298059, CharSequence.class, 8, 28, 1).A2egSU(view, charSequence);
        Cd8JRx cd8JRx = f1685ASJ6gh;
        if (charSequence == null) {
            cd8JRx.f1671AcNBzu.remove(view);
            view.removeOnAttachStateChangeListener(cd8JRx);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(cd8JRx);
        } else {
            cd8JRx.f1671AcNBzu.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(cd8JRx);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(cd8JRx);
            }
        }
    }

    public static void B9tovu(View view, ColorStateList colorStateList) {
        int i = Build.VERSION.SDK_INT;
        CmUvjW.B2KMhB(view, colorStateList);
        if (i == 21) {
            Drawable background = view.getBackground();
            boolean z = (CmUvjW.ASJ6gh(view) == null && CmUvjW.AYUAbz(view) == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void BChYOn(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
