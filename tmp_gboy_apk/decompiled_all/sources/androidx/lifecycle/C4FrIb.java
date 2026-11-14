package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import androidx.lifecycle.CNPG0E;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class C4FrIb {
    /* JADX WARN: Multi-variable type inference failed */
    public static void A2egSU(Activity activity, AlLFFp alLFFp) {
        RXb0Sz.ARc23Z.AMqCpz(alLFFp, "event");
        if (activity instanceof B9tovu) {
            AzWtSf lifecycle = ((B9tovu) activity).getLifecycle();
            if (lifecycle instanceof BI9f7h) {
                ((BI9f7h) lifecycle).ARc23Z(alLFFp);
            }
        }
    }

    public static void A4TApA(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            CNPG0E.A2egSU.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new CNPG0E.A2egSU());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new CNPG0E(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
