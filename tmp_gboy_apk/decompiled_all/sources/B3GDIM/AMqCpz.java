package B3GDIM;

import NOd7IU.AlLFFp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends AlLFFp {
    @Override // NOd7IU.AlLFFp
    public final boolean B9tovu(ASJ6gh aSJ6gh, A5SV6n a5SV6n) {
        A5SV6n a5SV6n2 = A5SV6n.f1022A4TApA;
        synchronized (aSJ6gh) {
            try {
                if (aSJ6gh.f1037AlLFFp != a5SV6n) {
                    return false;
                }
                aSJ6gh.f1037AlLFFp = a5SV6n2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // NOd7IU.AlLFFp
    public final boolean BChYOn(ASJ6gh aSJ6gh, Object obj, Object obj2) {
        synchronized (aSJ6gh) {
            try {
                if (aSJ6gh.f1036AcNBzu != obj) {
                    return false;
                }
                aSJ6gh.f1036AcNBzu = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // NOd7IU.AlLFFp
    public final boolean BI9f7h(ASJ6gh aSJ6gh, ARc23Z aRc23Z, ARc23Z aRc23Z2) {
        synchronized (aSJ6gh) {
            try {
                if (aSJ6gh.f1038AmA8tU != aRc23Z) {
                    return false;
                }
                aSJ6gh.f1038AmA8tU = aRc23Z2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // NOd7IU.AlLFFp
    public final void CqNSpT(ARc23Z aRc23Z, ARc23Z aRc23Z2) {
        aRc23Z.f1031A4TApA = aRc23Z2;
    }

    @Override // NOd7IU.AlLFFp
    public final void CrfGsy(ARc23Z aRc23Z, Thread thread) {
        aRc23Z.f1030A2egSU = thread;
    }
}
