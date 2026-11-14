package AaHO0E;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class GcSJYy {
    public static OnBackInvokedDispatcher A2egSU(View view) {
        return view.findOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback A4TApA(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new ADYaiT.CNPG0E(1, runnable);
    }

    public static void A5SV6n(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
    }

    public static void ADYaiT(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
