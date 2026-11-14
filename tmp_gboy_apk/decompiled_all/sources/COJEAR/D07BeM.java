package COJEAR;

import android.view.View;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class D07BeM {
    public static void A2egSU(View view, D9tr6l d9tr6l) {
        B25kr6.AzWtSf azWtSf = (B25kr6.AzWtSf) view.getTag(2131298067);
        if (azWtSf == null) {
            azWtSf = new B25kr6.AzWtSf();
            view.setTag(2131298067, azWtSf);
        }
        Objects.requireNonNull(d9tr6l);
        View.OnUnhandledKeyEventListener ctxOCS = new CtxOCS();
        azWtSf.put(d9tr6l, ctxOCS);
        view.addOnUnhandledKeyEventListener(ctxOCS);
    }

    public static CharSequence A4TApA(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean A5SV6n(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean ADYaiT(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void AMqCpz(View view, D9tr6l d9tr6l) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        B25kr6.AzWtSf azWtSf = (B25kr6.AzWtSf) view.getTag(2131298067);
        if (azWtSf == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) azWtSf.get(d9tr6l)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T ARc23Z(View view, int i) {
        return (T) view.requireViewById(i);
    }

    public static void ASJ6gh(View view, boolean z) {
        view.setAccessibilityHeading(z);
    }

    public static void AYUAbz(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void AZOQYO(View view, CTkVKb.A2egSU a2egSU) {
        view.setAutofillId(null);
    }

    public static void AZkASS(View view, boolean z) {
        view.setScreenReaderFocusable(z);
    }
}
