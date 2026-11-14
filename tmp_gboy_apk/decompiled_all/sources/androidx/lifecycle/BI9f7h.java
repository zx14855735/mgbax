package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h extends AzWtSf {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final WeakReference f8989ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f8990ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f8991ASJ6gh;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final boolean f8986A2egSU = true;

    /* renamed from: A4TApA, reason: collision with root package name */
    public AlLFFp.A2egSU f8987A4TApA = new AlLFFp.A2egSU();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public AmA8tU f8988A5SV6n = AmA8tU.f8978AlLFFp;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ArrayList f8992AYUAbz = new ArrayList();

    public BI9f7h(B9tovu b9tovu) {
        this.f8989ADYaiT = new WeakReference(b9tovu);
    }

    @Override // androidx.lifecycle.AzWtSf
    public final void A2egSU(B7CMnp b7CMnp) {
        B4ZgIw reflectiveGenericLifecycleObserver;
        Object obj;
        B9tovu b9tovu;
        ArrayList arrayList = this.f8992AYUAbz;
        AMqCpz("addObserver");
        AmA8tU amA8tU = this.f8988A5SV6n;
        AmA8tU amA8tU2 = AmA8tU.f8977AcNBzu;
        if (amA8tU != amA8tU2) {
            amA8tU2 = AmA8tU.f8978AlLFFp;
        }
        BChYOn bChYOn = new BChYOn();
        HashMap hashMap = BIYEnU.f8993A2egSU;
        boolean z = b7CMnp instanceof B4ZgIw;
        boolean z2 = b7CMnp instanceof AMqCpz;
        if (z && z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((AMqCpz) b7CMnp, (B4ZgIw) b7CMnp);
        } else if (z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((AMqCpz) b7CMnp, null);
        } else if (z) {
            reflectiveGenericLifecycleObserver = (B4ZgIw) b7CMnp;
        } else {
            Class<?> cls = b7CMnp.getClass();
            if (BIYEnU.A5SV6n(cls) == 2) {
                Object obj2 = BIYEnU.f8994A4TApA.get(cls);
                RXb0Sz.ARc23Z.A4TApA(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    BIYEnU.A2egSU((Constructor) list.get(0), b7CMnp);
                    throw null;
                }
                int size = list.size();
                AYUAbz[] aYUAbzArr = new AYUAbz[size];
                if (size > 0) {
                    BIYEnU.A2egSU((Constructor) list.get(0), b7CMnp);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(aYUAbzArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(b7CMnp);
            }
        }
        bChYOn.f8985A4TApA = reflectiveGenericLifecycleObserver;
        bChYOn.f8984A2egSU = amA8tU2;
        AlLFFp.A2egSU a2egSU = this.f8987A4TApA;
        AlLFFp.A5SV6n A2egSU2 = a2egSU.A2egSU(b7CMnp);
        if (A2egSU2 != null) {
            obj = A2egSU2.f945AlLFFp;
        } else {
            HashMap hashMap2 = a2egSU.f942B25kr6;
            AlLFFp.A5SV6n a5SV6n = new AlLFFp.A5SV6n(b7CMnp, bChYOn);
            a2egSU.f956AzWtSf++;
            AlLFFp.A5SV6n a5SV6n2 = a2egSU.f954AlLFFp;
            if (a5SV6n2 == null) {
                a2egSU.f953AcNBzu = a5SV6n;
                a2egSU.f954AlLFFp = a5SV6n;
            } else {
                a5SV6n2.f946AmA8tU = a5SV6n;
                a5SV6n.f947AzWtSf = a5SV6n2;
                a2egSU.f954AlLFFp = a5SV6n;
            }
            hashMap2.put(b7CMnp, a5SV6n);
            obj = null;
        }
        if (((BChYOn) obj) == null && (b9tovu = (B9tovu) this.f8989ADYaiT.get()) != null) {
            boolean z3 = this.AMqCpz != 0 || this.f8990ARc23Z;
            AmA8tU ADYaiT2 = ADYaiT(b7CMnp);
            this.AMqCpz++;
            while (bChYOn.f8984A2egSU.compareTo(ADYaiT2) < 0 && this.f8987A4TApA.f942B25kr6.containsKey(b7CMnp)) {
                arrayList.add(bChYOn.f8984A2egSU);
                AaHO0E aaHO0E = AlLFFp.Companion;
                AmA8tU amA8tU3 = bChYOn.f8984A2egSU;
                aaHO0E.getClass();
                RXb0Sz.ARc23Z.AMqCpz(amA8tU3, "state");
                int ordinal = amA8tU3.ordinal();
                AlLFFp alLFFp = ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? null : AlLFFp.ON_RESUME : AlLFFp.ON_START : AlLFFp.ON_CREATE;
                if (alLFFp == null) {
                    throw new IllegalStateException("no event up from " + bChYOn.f8984A2egSU);
                }
                bChYOn.A2egSU(b9tovu, alLFFp);
                arrayList.remove(arrayList.size() - 1);
                ADYaiT2 = ADYaiT(b7CMnp);
            }
            if (!z3) {
                AZOQYO();
            }
            this.AMqCpz--;
        }
    }

    @Override // androidx.lifecycle.AzWtSf
    public final AmA8tU A4TApA() {
        return this.f8988A5SV6n;
    }

    @Override // androidx.lifecycle.AzWtSf
    public final void A5SV6n(B7CMnp b7CMnp) {
        RXb0Sz.ARc23Z.AMqCpz(b7CMnp, "observer");
        AMqCpz("removeObserver");
        this.f8987A4TApA.A4TApA(b7CMnp);
    }

    public final AmA8tU ADYaiT(B7CMnp b7CMnp) {
        BChYOn bChYOn;
        HashMap hashMap = this.f8987A4TApA.f942B25kr6;
        AlLFFp.A5SV6n a5SV6n = hashMap.containsKey(b7CMnp) ? ((AlLFFp.A5SV6n) hashMap.get(b7CMnp)).f947AzWtSf : null;
        AmA8tU amA8tU = (a5SV6n == null || (bChYOn = (BChYOn) a5SV6n.f945AlLFFp) == null) ? null : bChYOn.f8984A2egSU;
        ArrayList arrayList = this.f8992AYUAbz;
        AmA8tU amA8tU2 = arrayList.isEmpty() ? null : (AmA8tU) ADYaiT.CtFAbx.ADYaiT(arrayList, 1);
        AmA8tU amA8tU3 = this.f8988A5SV6n;
        RXb0Sz.ARc23Z.AMqCpz(amA8tU3, "state1");
        if (amA8tU == null || amA8tU.compareTo(amA8tU3) >= 0) {
            amA8tU = amA8tU3;
        }
        return (amA8tU2 == null || amA8tU2.compareTo(amA8tU) >= 0) ? amA8tU : amA8tU2;
    }

    public final void AMqCpz(String str) {
        if (this.f8986A2egSU) {
            AcNBzu.A2egSU.A2egSU().f937A2egSU.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(ADYaiT.CtFAbx.BI9f7h("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void ARc23Z(AlLFFp alLFFp) {
        RXb0Sz.ARc23Z.AMqCpz(alLFFp, "event");
        AMqCpz("handleLifecycleEvent");
        ASJ6gh(alLFFp.A2egSU());
    }

    public final void ASJ6gh(AmA8tU amA8tU) {
        AmA8tU amA8tU2 = this.f8988A5SV6n;
        if (amA8tU2 == amA8tU) {
            return;
        }
        AmA8tU amA8tU3 = AmA8tU.f8978AlLFFp;
        AmA8tU amA8tU4 = AmA8tU.f8977AcNBzu;
        if (amA8tU2 == amA8tU3 && amA8tU == amA8tU4) {
            throw new IllegalStateException(("no event down from " + this.f8988A5SV6n + " in component " + this.f8989ADYaiT.get()).toString());
        }
        this.f8988A5SV6n = amA8tU;
        if (this.f8990ARc23Z || this.AMqCpz != 0) {
            this.f8991ASJ6gh = true;
            return;
        }
        this.f8990ARc23Z = true;
        AZOQYO();
        this.f8990ARc23Z = false;
        if (this.f8988A5SV6n == amA8tU4) {
            this.f8987A4TApA = new AlLFFp.A2egSU();
        }
    }

    public final void AYUAbz() {
        AmA8tU amA8tU = AmA8tU.f8979AmA8tU;
        AMqCpz("setCurrentState");
        ASJ6gh(amA8tU);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        r12.f8991ASJ6gh = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZOQYO() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.BI9f7h.AZOQYO():void");
    }
}
