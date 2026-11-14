package COJEAR;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CikNvS {
    public static WindowInsets A2egSU(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    public static WindowInsets A4TApA(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    public static void A5SV6n(View view) {
        view.requestApplyInsets();
    }
}
