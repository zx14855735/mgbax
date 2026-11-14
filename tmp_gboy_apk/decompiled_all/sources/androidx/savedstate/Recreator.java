package androidx.savedstate;

import ADYaiT.CtFAbx;
import DV2E8K.A4TApA;
import DV2E8K.ADYaiT;
import DV2E8K.ARc23Z;
import android.os.Bundle;
import androidx.lifecycle.AlLFFp;
import androidx.lifecycle.B4ZgIw;
import androidx.lifecycle.B9tovu;
import androidx.lifecycle.CQhlFr;
import androidx.lifecycle.CikNvS;
import androidx.lifecycle.CtxOCS;
import androidx.lifecycle.D07BeM;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Recreator implements B4ZgIw {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ARc23Z f9484AcNBzu;

    public Recreator(ARc23Z aRc23Z) {
        this.f9484AcNBzu = aRc23Z;
    }

    @Override // androidx.lifecycle.B4ZgIw
    public final void onStateChanged(B9tovu b9tovu, AlLFFp alLFFp) {
        if (alLFFp != AlLFFp.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        b9tovu.getLifecycle().A5SV6n(this);
        ARc23Z aRc23Z = this.f9484AcNBzu;
        Bundle A2egSU2 = aRc23Z.getSavedStateRegistry().A2egSU("androidx.savedstate.Restarter");
        if (A2egSU2 == null) {
            return;
        }
        ArrayList<String> stringArrayList = A2egSU2.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(A4TApA.class);
                RXb0Sz.ARc23Z.ADYaiT(asSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object newInstance = declaredConstructor.newInstance(new Object[0]);
                        RXb0Sz.ARc23Z.ADYaiT(newInstance, "{\n                constr…wInstance()\n            }");
                        if (!(aRc23Z instanceof D07BeM)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                        }
                        CtxOCS viewModelStore = ((D07BeM) aRc23Z).getViewModelStore();
                        ADYaiT savedStateRegistry = aRc23Z.getSavedStateRegistry();
                        viewModelStore.getClass();
                        LinkedHashMap linkedHashMap = viewModelStore.f9039A2egSU;
                        Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            RXb0Sz.ARc23Z.AMqCpz(str2, "key");
                            CikNvS cikNvS = (CikNvS) linkedHashMap.get(str2);
                            RXb0Sz.ARc23Z.A4TApA(cikNvS);
                            CQhlFr.A2egSU(cikNvS, savedStateRegistry, aRc23Z.getLifecycle());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            savedStateRegistry.ADYaiT();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(CtFAbx.BChYOn("Failed to instantiate ", str), e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                }
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException(CtFAbx.BI9f7h("Class ", str, " wasn't found"), e3);
            }
        }
    }
}
