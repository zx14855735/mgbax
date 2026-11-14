package COJEAR;

import android.view.View;
import android.view.WindowInsetsController;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class D6yqiO {
    public static int A2egSU(View view) {
        return view.getImportantForContentCapture();
    }

    public static CharSequence A4TApA(View view) {
        return view.getStateDescription();
    }

    public static Ff5QvW A5SV6n(View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return new Ff5QvW(windowInsetsController);
        }
        return null;
    }

    public static boolean ADYaiT(View view) {
        return view.isImportantForContentCapture();
    }

    public static void AMqCpz(View view, int i) {
        view.setImportantForContentCapture(i);
    }

    public static void ARc23Z(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
