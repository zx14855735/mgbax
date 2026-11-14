package COJEAR;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EGM26s extends EQurEW {
    public static final PathInterpolator AMqCpz = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final D8cQ8b.A2egSU f1706ARc23Z = new D8cQ8b.A2egSU();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final DecelerateInterpolator f1707ASJ6gh = new DecelerateInterpolator();

    static {
        PYhSbsN();
    }

    public static void AMqCpz(View view) {
        ARc23Z AZkASS2 = AZkASS(view);
        if (AZkASS2 != null) {
            ((View) AZkASS2.f1622B25kr6).setTranslationY(0.0f);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                AMqCpz(viewGroup.getChildAt(i));
            }
        }
    }

    public static void ARc23Z(View view, WindowInsets windowInsets, boolean z) {
        ARc23Z AZkASS2 = AZkASS(view);
        if (AZkASS2 != null) {
            AZkASS2.f1619AlLFFp = windowInsets;
            if (!z) {
                View view2 = (View) AZkASS2.f1622B25kr6;
                int[] iArr = (int[]) AZkASS2.f1623B2KMhB;
                view2.getLocationOnScreen(iArr);
                z = true;
                AZkASS2.f1620AmA8tU = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                ARc23Z(viewGroup.getChildAt(i), windowInsets, z);
            }
        }
    }

    public static void ASJ6gh(View view, FG7pZc fG7pZc, List list) {
        ARc23Z AZkASS2 = AZkASS(view);
        if (AZkASS2 != null) {
            AZkASS2.A2egSU(fG7pZc, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                ASJ6gh(viewGroup.getChildAt(i), fG7pZc, list);
            }
        }
    }

    public static void AYUAbz(View view, K1Z3yj.A2egSU a2egSU) {
        ARc23Z AZkASS2 = AZkASS(view);
        if (AZkASS2 != null) {
            View view2 = (View) AZkASS2.f1622B25kr6;
            int[] iArr = (int[]) AZkASS2.f1623B2KMhB;
            view2.getLocationOnScreen(iArr);
            int i = AZkASS2.f1620AmA8tU - iArr[1];
            AZkASS2.f1621AzWtSf = i;
            view2.setTranslationY(i);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                AYUAbz(viewGroup.getChildAt(i2), a2egSU);
            }
        }
    }

    public static WindowInsets AZOQYO(View view, WindowInsets windowInsets) {
        return view.getTag(2131298060) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static ARc23Z AZkASS(View view) {
        Object tag = view.getTag(2131298068);
        if (tag instanceof ECyGFg) {
            return ((ECyGFg) tag).f1704A2egSU;
        }
        return null;
    }

    private static /* synthetic */ void PYhSbsN() {
        char[] charArray = "ÊÆÄ\u0087ÎÈÄÌ\u0087ËÆÐ\u0087ÚÁÌÅÅ\u0087ãÇÀëÛÀÍÎÌ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 169);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÊÅÀÇÀÝ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 169);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
