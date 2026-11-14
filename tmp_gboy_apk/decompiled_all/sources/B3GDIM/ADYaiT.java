package B3GDIM;

import NOd7IU.AlLFFp;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends AlLFFp {

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1024CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1025CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1026CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1027Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1028CikNvS;

    public ADYaiT(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f1024CSDoyG = atomicReferenceFieldUpdater;
        this.f1025CTkVKb = atomicReferenceFieldUpdater2;
        this.f1026CcAIMM = atomicReferenceFieldUpdater3;
        this.f1027Cd8JRx = atomicReferenceFieldUpdater4;
        this.f1028CikNvS = atomicReferenceFieldUpdater5;
    }

    @Override // NOd7IU.AlLFFp
    public final boolean B9tovu(ASJ6gh aSJ6gh, A5SV6n a5SV6n) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        A5SV6n a5SV6n2 = A5SV6n.f1022A4TApA;
        do {
            atomicReferenceFieldUpdater = this.f1027Cd8JRx;
            if (atomicReferenceFieldUpdater.compareAndSet(aSJ6gh, a5SV6n, a5SV6n2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(aSJ6gh) == a5SV6n);
        return false;
    }

    @Override // NOd7IU.AlLFFp
    public final boolean BChYOn(ASJ6gh aSJ6gh, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f1028CikNvS;
            if (atomicReferenceFieldUpdater.compareAndSet(aSJ6gh, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(aSJ6gh) == obj);
        return false;
    }

    @Override // NOd7IU.AlLFFp
    public final boolean BI9f7h(ASJ6gh aSJ6gh, ARc23Z aRc23Z, ARc23Z aRc23Z2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f1026CcAIMM;
            if (atomicReferenceFieldUpdater.compareAndSet(aSJ6gh, aRc23Z, aRc23Z2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(aSJ6gh) == aRc23Z);
        return false;
    }

    @Override // NOd7IU.AlLFFp
    public final void CqNSpT(ARc23Z aRc23Z, ARc23Z aRc23Z2) {
        this.f1025CTkVKb.lazySet(aRc23Z, aRc23Z2);
    }

    @Override // NOd7IU.AlLFFp
    public final void CrfGsy(ARc23Z aRc23Z, Thread thread) {
        this.f1024CSDoyG.lazySet(aRc23Z, thread);
    }
}
