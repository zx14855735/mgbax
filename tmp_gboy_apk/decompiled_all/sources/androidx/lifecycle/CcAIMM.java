package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CcAIMM extends CtFAbx implements CqNSpT {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Application f9023AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final CmUvjW f9024AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Bundle f9025AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AzWtSf f9026AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final DV2E8K.ADYaiT f9027B25kr6;

    public CcAIMM() {
        this.f9024AlLFFp = new CmUvjW();
    }

    @Override // androidx.lifecycle.CtFAbx
    public final void A2egSU(CikNvS cikNvS) {
        AzWtSf azWtSf = this.f9026AzWtSf;
        if (azWtSf != null) {
            DV2E8K.ADYaiT aDYaiT = this.f9027B25kr6;
            RXb0Sz.ARc23Z.A4TApA(aDYaiT);
            CQhlFr.A2egSU(cikNvS, aDYaiT, azWtSf);
        }
    }

    @Override // androidx.lifecycle.CqNSpT
    public final CikNvS A4TApA(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return A5SV6n(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CikNvS A5SV6n(String str, Class cls) {
        Object obj;
        Application application;
        AzWtSf azWtSf = this.f9026AzWtSf;
        if (azWtSf == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean isAssignableFrom = A2egSU.class.isAssignableFrom(cls);
        Constructor A2egSU2 = (!isAssignableFrom || this.f9023AcNBzu == null) ? Cd8JRx.A2egSU(Cd8JRx.f9029A4TApA, cls) : Cd8JRx.A2egSU(Cd8JRx.f9028A2egSU, cls);
        if (A2egSU2 == null) {
            if (this.f9023AcNBzu != null) {
                return this.f9024AlLFFp.A4TApA(cls);
            }
            if (CrfGsy.f9038AcNBzu == null) {
                CrfGsy.f9038AcNBzu = new CrfGsy();
            }
            CrfGsy crfGsy = CrfGsy.f9038AcNBzu;
            RXb0Sz.ARc23Z.A4TApA(crfGsy);
            return crfGsy.A4TApA(cls);
        }
        DV2E8K.ADYaiT aDYaiT = this.f9027B25kr6;
        RXb0Sz.ARc23Z.A4TApA(aDYaiT);
        Bundle bundle = this.f9025AmA8tU;
        Bundle A2egSU3 = aDYaiT.A2egSU(str);
        Class[] clsArr = COJEAR.f9010ARc23Z;
        COJEAR A4TApA2 = CQhlFr.A4TApA(A2egSU3, bundle);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, A4TApA2);
        savedStateHandleController.A2egSU(aDYaiT, azWtSf);
        AmA8tU A4TApA3 = azWtSf.A4TApA();
        if (A4TApA3 == AmA8tU.f8978AlLFFp || A4TApA3.compareTo(AmA8tU.f8980AzWtSf) >= 0) {
            aDYaiT.ADYaiT();
        } else {
            azWtSf.A2egSU(new LegacySavedStateHandleController$tryToAddRecreator$1(aDYaiT, azWtSf));
        }
        CikNvS A4TApA4 = (!isAssignableFrom || (application = this.f9023AcNBzu) == null) ? Cd8JRx.A4TApA(cls, A2egSU2, A4TApA2) : Cd8JRx.A4TApA(cls, A2egSU2, application, A4TApA2);
        synchronized (A4TApA4.f9030A2egSU) {
            try {
                obj = A4TApA4.f9030A2egSU.get("androidx.lifecycle.savedstate.vm.tag");
                if (obj == 0) {
                    A4TApA4.f9030A2egSU.put("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != 0) {
            savedStateHandleController = obj;
        }
        if (A4TApA4.f9032A5SV6n) {
            CikNvS.A2egSU(savedStateHandleController);
        }
        return A4TApA4;
    }

    @Override // androidx.lifecycle.CqNSpT
    public final CikNvS AzWtSf(Class cls, D9tr6l.ADYaiT aDYaiT) {
        CkXcdM ckXcdM = CkXcdM.f9034A4TApA;
        LinkedHashMap linkedHashMap = aDYaiT.f2052A2egSU;
        String str = (String) linkedHashMap.get(ckXcdM);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(CQhlFr.f9015A2egSU) == null || linkedHashMap.get(CQhlFr.f9016A4TApA) == null) {
            if (this.f9026AzWtSf != null) {
                return A5SV6n(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(CkXcdM.f9033A2egSU);
        boolean isAssignableFrom = A2egSU.class.isAssignableFrom(cls);
        Constructor A2egSU2 = (!isAssignableFrom || application == null) ? Cd8JRx.A2egSU(Cd8JRx.f9029A4TApA, cls) : Cd8JRx.A2egSU(Cd8JRx.f9028A2egSU, cls);
        return A2egSU2 == null ? this.f9024AlLFFp.AzWtSf(cls, aDYaiT) : (!isAssignableFrom || application == null) ? Cd8JRx.A4TApA(cls, A2egSU2, CQhlFr.A5SV6n(aDYaiT)) : Cd8JRx.A4TApA(cls, A2egSU2, application, CQhlFr.A5SV6n(aDYaiT));
    }

    public CcAIMM(Application application, DV2E8K.ARc23Z aRc23Z, Bundle bundle) {
        CmUvjW cmUvjW;
        this.f9027B25kr6 = aRc23Z.getSavedStateRegistry();
        this.f9026AzWtSf = aRc23Z.getLifecycle();
        this.f9025AmA8tU = bundle;
        this.f9023AcNBzu = application;
        if (application != null) {
            if (CmUvjW.f9035AmA8tU == null) {
                CmUvjW.f9035AmA8tU = new CmUvjW(application);
            }
            cmUvjW = CmUvjW.f9035AmA8tU;
            RXb0Sz.ARc23Z.A4TApA(cmUvjW);
        } else {
            cmUvjW = new CmUvjW();
        }
        this.f9024AlLFFp = cmUvjW;
    }
}
