package COJEAR;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CqNSpT {
    public static FG7pZc A2egSU(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(null, rootWindowInsets);
        F32kj0 f32kj0 = ASJ6gh2.f1747A2egSU;
        f32kj0.B25kr6(ASJ6gh2);
        f32kj0.ADYaiT(view.getRootView());
        return ASJ6gh2;
    }

    public static int A4TApA(View view) {
        return view.getScrollIndicators();
    }

    public static void A5SV6n(View view, int i) {
        view.setScrollIndicators(i);
    }

    public static void ADYaiT(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
