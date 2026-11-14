package COJEAR;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CmUvjW {
    public static void A2egSU(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(2131298068);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static FG7pZc A4TApA(View view, FG7pZc fG7pZc, Rect rect) {
        WindowInsets ARc23Z2 = fG7pZc.ARc23Z();
        if (ARc23Z2 != null) {
            return FG7pZc.ASJ6gh(view, view.computeSystemWindowInsets(ARc23Z2, rect));
        }
        rect.setEmpty();
        return fG7pZc;
    }

    public static boolean A5SV6n(View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    public static boolean ADYaiT(View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    public static boolean AMqCpz(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public static boolean ARc23Z(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public static ColorStateList ASJ6gh(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode AYUAbz(View view) {
        return view.getBackgroundTintMode();
    }

    public static float AZOQYO(View view) {
        return view.getElevation();
    }

    public static FG7pZc AZkASS(View view) {
        if (!EY4UKY.f1720ADYaiT || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = EY4UKY.f1717A2egSU.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) EY4UKY.f1718A4TApA.get(obj);
            Rect rect2 = (Rect) EY4UKY.f1719A5SV6n.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            EmJGcg emJGcg = new EdQ5bb().f1721A2egSU;
            emJGcg.AMqCpz(BV3sI0.A5SV6n.A4TApA(rect.left, rect.top, rect.right, rect.bottom));
            emJGcg.ASJ6gh(BV3sI0.A5SV6n.A4TApA(rect2.left, rect2.top, rect2.right, rect2.bottom));
            FG7pZc A4TApA2 = emJGcg.A4TApA();
            A4TApA2.f1747A2egSU.B25kr6(A4TApA2);
            A4TApA2.f1747A2egSU.ADYaiT(view.getRootView());
            return A4TApA2;
        } catch (IllegalAccessException e) {
            e.getMessage();
            return null;
        }
    }

    public static String AaHO0E(View view) {
        return view.getTransitionName();
    }

    public static float AcNBzu(View view) {
        return view.getTranslationZ();
    }

    public static float AlLFFp(View view) {
        return view.getZ();
    }

    public static boolean AmA8tU(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean AzWtSf(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean B25kr6(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void B2KMhB(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void B3GDIM(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void B4ZgIw(View view, float f) {
        view.setElevation(f);
    }

    public static void B7CMnp(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void B9tovu(View view, BNL6CD bnl6cd) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(2131298060, bnl6cd);
        }
        if (bnl6cd == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(2131298068));
        } else {
            view.setOnApplyWindowInsetsListener(new CkXcdM(view, bnl6cd));
        }
    }

    public static void BChYOn(View view, String str) {
        view.setTransitionName(str);
    }

    public static void BI9f7h(View view, float f) {
        view.setTranslationZ(f);
    }

    public static void BIYEnU(View view, float f) {
        view.setZ(f);
    }

    public static boolean BJ7GGh(View view, int i) {
        return view.startNestedScroll(i);
    }

    public static void BNL6CD(View view) {
        view.stopNestedScroll();
    }
}
