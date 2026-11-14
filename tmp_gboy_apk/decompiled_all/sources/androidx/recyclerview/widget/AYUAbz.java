package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements COJEAR {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ASJ6gh f9181A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f9183A5SV6n = new ArrayList();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final IdentityHashMap f9184ADYaiT = new IdentityHashMap();
    public final ArrayList AMqCpz = new ArrayList();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AaHO0E.A2egSU f9185ARc23Z = new AaHO0E.A2egSU();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final F508T2 f9182A4TApA = new F508T2();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final int f9186ASJ6gh = 1;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final EQurEW f9187AYUAbz = new EQurEW();

    public AYUAbz(ASJ6gh aSJ6gh) {
        this.f9181A2egSU = aSJ6gh;
    }

    public final void A2egSU() {
        CtxOCS ctxOCS;
        Iterator it = this.AMqCpz.iterator();
        while (true) {
            if (!it.hasNext()) {
                ctxOCS = CtxOCS.f9336AcNBzu;
                break;
            }
            CQhlFr cQhlFr = (CQhlFr) it.next();
            CtxOCS stateRestorationPolicy = cQhlFr.f9322A5SV6n.getStateRestorationPolicy();
            ctxOCS = CtxOCS.f9338AmA8tU;
            if (stateRestorationPolicy == ctxOCS || (stateRestorationPolicy == CtxOCS.f9337AlLFFp && cQhlFr.AMqCpz == 0)) {
                break;
            }
        }
        ASJ6gh aSJ6gh = this.f9181A2egSU;
        if (ctxOCS != aSJ6gh.getStateRestorationPolicy()) {
            aSJ6gh.A2egSU(ctxOCS);
        }
    }

    public final int A4TApA(CQhlFr cQhlFr) {
        CQhlFr cQhlFr2;
        Iterator it = this.AMqCpz.iterator();
        int i = 0;
        while (it.hasNext() && (cQhlFr2 = (CQhlFr) it.next()) != cQhlFr) {
            i += cQhlFr2.AMqCpz;
        }
        return i;
    }

    public final AaHO0E.A2egSU A5SV6n(int i) {
        AaHO0E.A2egSU a2egSU = this.f9185ARc23Z;
        if (a2egSU.f594A4TApA) {
            a2egSU = new AaHO0E.A2egSU();
        } else {
            a2egSU.f594A4TApA = true;
        }
        Iterator it = this.AMqCpz.iterator();
        int i2 = i;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CQhlFr cQhlFr = (CQhlFr) it.next();
            int i3 = cQhlFr.AMqCpz;
            if (i3 > i2) {
                a2egSU.f595A5SV6n = cQhlFr;
                a2egSU.f593A2egSU = i2;
                break;
            }
            i2 -= i3;
        }
        if (((CQhlFr) a2egSU.f595A5SV6n) != null) {
            return a2egSU;
        }
        throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(i, "Cannot find wrapper for "));
    }

    public final CQhlFr ADYaiT(Dphsd2 dphsd2) {
        CQhlFr cQhlFr = (CQhlFr) this.f9184ADYaiT.get(dphsd2);
        if (cQhlFr != null) {
            return cQhlFr;
        }
        throw new IllegalStateException("Cannot find wrapper for " + dphsd2 + ", seems like it is not bound by this adapter: " + this);
    }
}
