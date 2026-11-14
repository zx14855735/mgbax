package COJEAR;

import android.view.View;
import android.view.autofill.AutofillId;
import java.util.Collection;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CtFAbx {
    public static void A2egSU(View view, Collection<View> collection, int i) {
        view.addKeyboardNavigationClusters(collection, i);
    }

    public static AutofillId A4TApA(View view) {
        return view.getAutofillId();
    }

    public static int A5SV6n(View view) {
        return view.getImportantForAutofill();
    }

    public static int ADYaiT(View view) {
        return view.getNextClusterForwardId();
    }

    public static boolean AMqCpz(View view) {
        return view.hasExplicitFocusable();
    }

    public static boolean ARc23Z(View view) {
        return view.isFocusedByDefault();
    }

    public static boolean ASJ6gh(View view) {
        return view.isImportantForAutofill();
    }

    public static boolean AYUAbz(View view) {
        return view.isKeyboardNavigationCluster();
    }

    public static View AZOQYO(View view, View view2, int i) {
        return view.keyboardNavigationClusterSearch(view2, i);
    }

    public static boolean AZkASS(View view) {
        return view.restoreDefaultFocus();
    }

    public static void AaHO0E(View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    public static void AcNBzu(View view, boolean z) {
        view.setFocusedByDefault(z);
    }

    public static void AlLFFp(View view, int i) {
        view.setImportantForAutofill(i);
    }

    public static void AmA8tU(View view, boolean z) {
        view.setKeyboardNavigationCluster(z);
    }

    public static void AzWtSf(View view, int i) {
        view.setNextClusterForwardId(i);
    }

    public static void B25kr6(View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
