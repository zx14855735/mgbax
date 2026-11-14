package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Cd8JRx {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final CopyOnWriteArrayList f8820A2egSU = new CopyOnWriteArrayList();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final CtxOCS f8821A4TApA;

    public Cd8JRx(CtxOCS ctxOCS) {
        this.f8821A4TApA = ctxOCS;
    }

    public final void A2egSU(Fragment fragment, Bundle bundle, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.A2egSU(fragment, bundle, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentActivityCreated(ctxOCS, fragment, bundle);
            }
        }
    }

    public final void A4TApA(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Context context = ctxOCS.f8847B7CMnp.getContext();
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.A4TApA(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentAttached(ctxOCS, fragment, context);
            }
        }
    }

    public final void A5SV6n(Fragment fragment, Bundle bundle, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.A5SV6n(fragment, bundle, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentCreated(ctxOCS, fragment, bundle);
            }
        }
    }

    public final void ADYaiT(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.ADYaiT(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentDestroyed(ctxOCS, fragment);
            }
        }
    }

    public final void AMqCpz(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AMqCpz(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentDetached(ctxOCS, fragment);
            }
        }
    }

    public final void ARc23Z(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.ARc23Z(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentPaused(ctxOCS, fragment);
            }
        }
    }

    public final void ASJ6gh(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Context context = ctxOCS.f8847B7CMnp.getContext();
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.ASJ6gh(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentPreAttached(ctxOCS, fragment, context);
            }
        }
    }

    public final void AYUAbz(Fragment fragment, Bundle bundle, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AYUAbz(fragment, bundle, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentPreCreated(ctxOCS, fragment, bundle);
            }
        }
    }

    public final void AZOQYO(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AZOQYO(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentResumed(ctxOCS, fragment);
            }
        }
    }

    public final void AZkASS(Fragment fragment, Bundle bundle, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AZkASS(fragment, bundle, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentSaveInstanceState(ctxOCS, fragment, bundle);
            }
        }
    }

    public final void AaHO0E(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AaHO0E(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentStarted(ctxOCS, fragment);
            }
        }
    }

    public final void AcNBzu(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AcNBzu(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentStopped(ctxOCS, fragment);
            }
        }
    }

    public final void AlLFFp(Fragment fragment, View view, Bundle bundle, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AlLFFp(fragment, view, bundle, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentViewCreated(ctxOCS, fragment, view, bundle);
            }
        }
    }

    public final void AmA8tU(Fragment fragment, boolean z) {
        CtxOCS ctxOCS = this.f8821A4TApA;
        Fragment fragment2 = ctxOCS.f8849BChYOn;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f8839AcNBzu.AmA8tU(fragment, true);
        }
        Iterator it = this.f8820A2egSU.iterator();
        while (it.hasNext()) {
            CcAIMM ccAIMM = (CcAIMM) it.next();
            if (!z || ccAIMM.f8819A4TApA) {
                ccAIMM.f8818A2egSU.onFragmentViewDestroyed(ctxOCS, fragment);
            }
        }
    }
}
