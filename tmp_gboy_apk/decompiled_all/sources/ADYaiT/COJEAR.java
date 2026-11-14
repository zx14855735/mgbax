package ADYaiT;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class COJEAR {
    public static OnBackInvokedDispatcher A2egSU(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    public static OnBackInvokedCallback A4TApA(Object obj, CkXcdM ckXcdM) {
        Objects.requireNonNull(ckXcdM);
        CNPG0E cnpg0e = new CNPG0E(0, ckXcdM);
        CASmeH.ASJ6gh(obj).registerOnBackInvokedCallback(1000000, cnpg0e);
        return cnpg0e;
    }

    public static void A5SV6n(Object obj, Object obj2) {
        CASmeH.ASJ6gh(obj).unregisterOnBackInvokedCallback(CASmeH.A5SV6n(obj2));
    }
}
