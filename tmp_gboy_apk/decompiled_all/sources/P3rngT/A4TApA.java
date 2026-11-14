package P3rngT;

import android.content.Context;
import android.util.TypedValue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A4TApA {
    public static TypedValue A2egSU(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean A4TApA(Context context, int i, boolean z) {
        TypedValue A2egSU2 = A2egSU(context, i);
        return (A2egSU2 == null || A2egSU2.type != 18) ? z : A2egSU2.data != 0;
    }

    public static int A5SV6n(Context context) {
        TypedValue A2egSU2 = A2egSU(context, 2130969603);
        return (int) ((A2egSU2 == null || A2egSU2.type != 5) ? context.getResources().getDimension(2131166460) : A2egSU2.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static TypedValue ADYaiT(Context context, int i, String str) {
        TypedValue A2egSU2 = A2egSU(context, i);
        if (A2egSU2 != null) {
            return A2egSU2;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }
}
