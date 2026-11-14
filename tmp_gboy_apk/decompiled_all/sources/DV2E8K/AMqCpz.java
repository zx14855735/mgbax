package DV2E8K;

import android.os.Bundle;
import androidx.lifecycle.AlLFFp;
import androidx.lifecycle.AmA8tU;
import androidx.lifecycle.AzWtSf;
import androidx.lifecycle.B4ZgIw;
import androidx.lifecycle.B9tovu;
import androidx.savedstate.Recreator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ARc23Z f2196A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ADYaiT f2197A4TApA = new ADYaiT();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f2198A5SV6n;

    public AMqCpz(ARc23Z aRc23Z) {
        this.f2196A2egSU = aRc23Z;
    }

    public final void A2egSU() {
        ARc23Z aRc23Z = this.f2196A2egSU;
        AzWtSf lifecycle = aRc23Z.getLifecycle();
        if (lifecycle.A4TApA() != AmA8tU.f8978AlLFFp) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.A2egSU(new Recreator(aRc23Z));
        final ADYaiT aDYaiT = this.f2197A4TApA;
        aDYaiT.getClass();
        if (aDYaiT.f2192A4TApA) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.A2egSU(new B4ZgIw() { // from class: DV2E8K.A2egSU
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
                ADYaiT aDYaiT2 = ADYaiT.this;
                RXb0Sz.ARc23Z.AMqCpz(aDYaiT2, "this$0");
                if (alLFFp == AlLFFp.ON_START) {
                    aDYaiT2.f2195ARc23Z = true;
                } else if (alLFFp == AlLFFp.ON_STOP) {
                    aDYaiT2.f2195ARc23Z = false;
                }
            }
        });
        aDYaiT.f2192A4TApA = true;
        this.f2198A5SV6n = true;
    }

    public final void A4TApA(Bundle bundle) {
        if (!this.f2198A5SV6n) {
            A2egSU();
        }
        AzWtSf lifecycle = this.f2196A2egSU.getLifecycle();
        if (lifecycle.A4TApA().compareTo(AmA8tU.f8980AzWtSf) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.A4TApA()).toString());
        }
        ADYaiT aDYaiT = this.f2197A4TApA;
        if (!aDYaiT.f2192A4TApA) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (aDYaiT.f2194ADYaiT) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        aDYaiT.f2193A5SV6n = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        aDYaiT.f2194ADYaiT = true;
    }

    public final void A5SV6n(Bundle bundle) {
        ADYaiT aDYaiT = this.f2197A4TApA;
        aDYaiT.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = aDYaiT.f2193A5SV6n;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        AlLFFp.ARc23Z aRc23Z = aDYaiT.f2191A2egSU;
        aRc23Z.getClass();
        AlLFFp.ADYaiT aDYaiT2 = new AlLFFp.ADYaiT(aRc23Z);
        aRc23Z.f955AmA8tU.put(aDYaiT2, Boolean.FALSE);
        while (aDYaiT2.hasNext()) {
            Map.Entry entry = (Map.Entry) aDYaiT2.next();
            bundle2.putBundle((String) entry.getKey(), ((A5SV6n) entry.getValue()).saveState());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
