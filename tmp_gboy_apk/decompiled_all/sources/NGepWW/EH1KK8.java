package NGepWW;

import AaHO0E.HHoABE;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class EH1KK8 extends NSK3xo.AcNBzu implements EsrwYR {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ErKPGd f5783AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final QkAq4X.A4TApA f5784AzWtSf;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final HHoABE f5786B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final QkAq4X.A4TApA f5787B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final N8uUiS.A2egSU f5788B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final ARc23Z f5789B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ReentrantLock f5790B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final NUY5pn.BNL6CD f5791BChYOn;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final int f5793BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final RevocationBoundService f5794BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final Looper f5795BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public volatile boolean f5796BPw6Q8;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final DG07BK.A2egSU f5799BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final NOd7IU.ADYaiT f5800BniPrB;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final ArrayList f5801C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public Integer f5802C4FrIb;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public EwN40Z f5792BI9f7h = null;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final LinkedList f5782AlLFFp = new LinkedList();

    /* renamed from: BTvldC, reason: collision with root package name */
    public final long f5797BTvldC = 120000;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final long f5798BV3sI0 = PushUIConfig.dismissTime;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Set f5785B25kr6 = new HashSet();
    public final ExjC7D BpkvW3 = new ExjC7D();

    public EH1KK8(RevocationBoundService revocationBoundService, ReentrantLock reentrantLock, Looper looper, HHoABE hHoABE, NOd7IU.ADYaiT aDYaiT, N8uUiS.A2egSU a2egSU, QkAq4X.A4TApA a4TApA, ArrayList arrayList, ArrayList arrayList2, QkAq4X.A4TApA a4TApA2, int i, int i2, ArrayList arrayList3) {
        this.f5802C4FrIb = null;
        IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(18, this);
        this.f5794BJ7GGh = revocationBoundService;
        this.f5790B9tovu = reentrantLock;
        this.f5791BChYOn = new NUY5pn.BNL6CD(looper, amA8tU);
        this.f5795BNL6CD = looper;
        this.f5799BmvVmW = new DG07BK.A2egSU(this, looper, 9);
        this.f5800BniPrB = aDYaiT;
        this.f5793BIYEnU = i;
        if (i >= 0) {
            this.f5802C4FrIb = Integer.valueOf(i2);
        }
        this.f5787B3GDIM = a4TApA;
        this.f5784AzWtSf = a4TApA2;
        this.f5801C2rE4F = arrayList3;
        this.f5789B7CMnp = new ARc23Z(a4TApA2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            NSK3xo.AZkASS aZkASS = (NSK3xo.AZkASS) it.next();
            NUY5pn.BNL6CD bnl6cd = this.f5791BChYOn;
            bnl6cd.getClass();
            NUY5pn.AYUAbz.A4TApA(aZkASS);
            synchronized (bnl6cd.f6014B7CMnp) {
                try {
                    if (bnl6cd.f6008AmA8tU.contains(aZkASS)) {
                        new StringBuilder(String.valueOf(aZkASS).length() + 62);
                    } else {
                        bnl6cd.f6008AmA8tU.add(aZkASS);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bnl6cd.f6007AlLFFp.B25kr6()) {
                Handler handler = bnl6cd.f6013B4ZgIw;
                handler.sendMessage(handler.obtainMessage(1, aZkASS));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.f5791BChYOn.A2egSU((NSK3xo.AaHO0E) it2.next());
        }
        this.f5786B2KMhB = hHoABE;
        this.f5788B4ZgIw = a2egSU;
    }

    public static int AYUAbz(Collection collection, boolean z) {
        Iterator it = collection.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            NSK3xo.ARc23Z aRc23Z = (NSK3xo.ARc23Z) it.next();
            if (aRc23Z.i()) {
                z2 = true;
            }
            if (((NUY5pn.BJ7GGh) aRc23Z) instanceof NCeV4Q.AMqCpz) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }

    public static void AZOQYO(EH1KK8 eh1kk8) {
        eh1kk8.f5790B9tovu.lock();
        try {
            if (eh1kk8.f5796BPw6Q8) {
                eh1kk8.f5791BChYOn.f6010B25kr6 = true;
                eh1kk8.f5792BI9f7h.a();
            }
        } finally {
            eh1kk8.f5790B9tovu.unlock();
        }
    }

    @Override // NGepWW.EsrwYR
    public final void A2egSU(Bundle bundle) {
        while (!this.f5782AlLFFp.isEmpty()) {
            A5SV6n((NCeV4Q.ASJ6gh) this.f5782AlLFFp.remove());
        }
        NUY5pn.BNL6CD bnl6cd = this.f5791BChYOn;
        bnl6cd.getClass();
        NUY5pn.AYUAbz.AMqCpz(Looper.myLooper() == bnl6cd.f6013B4ZgIw.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (bnl6cd.f6014B7CMnp) {
            try {
                if (bnl6cd.f6012B3GDIM) {
                    throw new IllegalStateException();
                }
                bnl6cd.f6013B4ZgIw.removeMessages(1);
                bnl6cd.f6012B3GDIM = true;
                if (bnl6cd.f6006AcNBzu.size() != 0) {
                    throw new IllegalStateException();
                }
                ArrayList arrayList = new ArrayList(bnl6cd.f6008AmA8tU);
                int i = bnl6cd.f6011B2KMhB.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    NSK3xo.AZkASS aZkASS = (NSK3xo.AZkASS) it.next();
                    if (!bnl6cd.f6010B25kr6 || !bnl6cd.f6007AlLFFp.B25kr6() || bnl6cd.f6011B2KMhB.get() != i) {
                        break;
                    } else if (!bnl6cd.f6006AcNBzu.contains(aZkASS)) {
                        aZkASS.A2egSU(bundle);
                    }
                }
                bnl6cd.f6006AcNBzu.clear();
                bnl6cd.f6012B3GDIM = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // NGepWW.EsrwYR
    public final void A4TApA(NOd7IU.A2egSU a2egSU) {
        NOd7IU.ADYaiT aDYaiT = this.f5800BniPrB;
        RevocationBoundService revocationBoundService = this.f5794BJ7GGh;
        int i = a2egSU.f5854AlLFFp;
        aDYaiT.getClass();
        int i2 = NOd7IU.AMqCpz.AMqCpz;
        if (!(i == 18 ? true : i == 1 ? NOd7IU.AMqCpz.A2egSU(revocationBoundService) : false)) {
            AmA8tU();
        }
        if (this.f5796BPw6Q8) {
            return;
        }
        NUY5pn.BNL6CD bnl6cd = this.f5791BChYOn;
        bnl6cd.getClass();
        NUY5pn.AYUAbz.AMqCpz(Looper.myLooper() == bnl6cd.f6013B4ZgIw.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        bnl6cd.f6013B4ZgIw.removeMessages(1);
        synchronized (bnl6cd.f6014B7CMnp) {
            try {
                ArrayList arrayList = new ArrayList(bnl6cd.f6009AzWtSf);
                int i3 = bnl6cd.f6011B2KMhB.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    NSK3xo.AaHO0E aaHO0E = (NSK3xo.AaHO0E) it.next();
                    if (!bnl6cd.f6010B25kr6 || bnl6cd.f6011B2KMhB.get() != i3) {
                        break;
                    } else if (bnl6cd.f6009AzWtSf.contains(aaHO0E)) {
                        aaHO0E.A4TApA(a2egSU);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        NUY5pn.BNL6CD bnl6cd2 = this.f5791BChYOn;
        bnl6cd2.f6010B25kr6 = false;
        bnl6cd2.f6011B2KMhB.incrementAndGet();
    }

    @Override // NSK3xo.AcNBzu
    public final NCeV4Q.ASJ6gh A5SV6n(NCeV4Q.ASJ6gh aSJ6gh) {
        NUY5pn.AYUAbz.ASJ6gh(aSJ6gh.f5645AmA8tU != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f5784AzWtSf.containsKey(aSJ6gh.f5645AmA8tU);
        NSK3xo.AYUAbz aYUAbz = aSJ6gh.f5646AzWtSf;
        String str = aYUAbz != null ? aYUAbz.f5931A5SV6n : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        NUY5pn.AYUAbz.ASJ6gh(containsKey, sb.toString());
        this.f5790B9tovu.lock();
        try {
            if (this.f5792BI9f7h == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.f5796BPw6Q8) {
                this.f5782AlLFFp.add(aSJ6gh);
                while (!this.f5782AlLFFp.isEmpty()) {
                    NCeV4Q.ASJ6gh aSJ6gh2 = (NCeV4Q.ASJ6gh) this.f5782AlLFFp.remove();
                    ARc23Z aRc23Z = this.f5789B7CMnp;
                    aRc23Z.f5681A2egSU.add(aSJ6gh2);
                    aSJ6gh2.f5728ASJ6gh.set(aRc23Z.f5682A4TApA);
                    aSJ6gh2.AaHO0E(NSK3xo.A4TApA.f5922B2KMhB);
                }
            } else {
                aSJ6gh = this.f5792BI9f7h.A5SV6n(aSJ6gh);
            }
            return aSJ6gh;
        } finally {
            this.f5790B9tovu.unlock();
        }
    }

    @Override // NSK3xo.AcNBzu
    public final boolean ADYaiT(NCeV4Q.A5SV6n a5SV6n) {
        EwN40Z ewN40Z = this.f5792BI9f7h;
        return ewN40Z != null && ewN40Z.A4TApA(a5SV6n);
    }

    @Override // NSK3xo.AcNBzu
    public final Looper AMqCpz() {
        return this.f5795BNL6CD;
    }

    @Override // NSK3xo.AcNBzu
    public final void ARc23Z() {
        EwN40Z ewN40Z = this.f5792BI9f7h;
        if (ewN40Z != null) {
            ewN40Z.g();
        }
    }

    @Override // NSK3xo.AcNBzu
    public final void ASJ6gh() {
        ReentrantLock reentrantLock = this.f5790B9tovu;
        reentrantLock.lock();
        try {
            this.f5789B7CMnp.A2egSU();
            EwN40Z ewN40Z = this.f5792BI9f7h;
            if (ewN40Z != null) {
                ewN40Z.c();
            }
            Set set = this.BpkvW3.f5847A2egSU;
            Iterator it = set.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                throw null;
            }
            set.clear();
            LinkedList<NCeV4Q.ASJ6gh> linkedList = this.f5782AlLFFp;
            for (NCeV4Q.ASJ6gh aSJ6gh : linkedList) {
                aSJ6gh.f5728ASJ6gh.set(null);
                aSJ6gh.ASJ6gh();
            }
            linkedList.clear();
            if (this.f5792BI9f7h == null) {
                reentrantLock.unlock();
                return;
            }
            AmA8tU();
            NUY5pn.BNL6CD bnl6cd = this.f5791BChYOn;
            bnl6cd.f6010B25kr6 = false;
            bnl6cd.f6011B2KMhB.incrementAndGet();
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void AZkASS(int i) {
        ReentrantLock reentrantLock;
        Integer num = this.f5802C4FrIb;
        if (num == null) {
            this.f5802C4FrIb = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String str = i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
            int intValue = this.f5802C4FrIb.intValue();
            String str2 = intValue != 1 ? intValue != 2 ? intValue != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
            throw new IllegalStateException(com.bykv.vk.component.ttvideo.player.A2egSU.AzWtSf(new StringBuilder(str2.length() + str.length() + 51), "Cannot use sign-in mode: ", str, ". Mode was already set to ", str2));
        }
        if (this.f5792BI9f7h != null) {
            return;
        }
        QkAq4X.A4TApA a4TApA = this.f5784AzWtSf;
        boolean z = false;
        boolean z2 = false;
        for (NSK3xo.ARc23Z aRc23Z : a4TApA.values()) {
            if (aRc23Z.i()) {
                z = true;
            }
            if (((NUY5pn.BJ7GGh) aRc23Z) instanceof NCeV4Q.AMqCpz) {
                z2 = true;
            }
        }
        int intValue2 = this.f5802C4FrIb.intValue();
        ReentrantLock reentrantLock2 = this.f5790B9tovu;
        ArrayList arrayList = this.f5801C2rE4F;
        QkAq4X.A4TApA a4TApA2 = this.f5787B3GDIM;
        if (intValue2 == 1) {
            reentrantLock = reentrantLock2;
            if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a4TApA = a4TApA;
        } else {
            if (intValue2 == 2 && z) {
                QkAq4X.A4TApA a4TApA3 = new QkAq4X.A4TApA();
                QkAq4X.A4TApA a4TApA4 = new QkAq4X.A4TApA();
                NSK3xo.ARc23Z aRc23Z2 = null;
                for (Map.Entry entry : a4TApA.entrySet()) {
                    NSK3xo.ARc23Z aRc23Z3 = (NSK3xo.ARc23Z) entry.getValue();
                    NUY5pn.BJ7GGh bJ7GGh = (NUY5pn.BJ7GGh) aRc23Z3;
                    bJ7GGh.getClass();
                    if (bJ7GGh instanceof NCeV4Q.AMqCpz) {
                        aRc23Z2 = aRc23Z3;
                    }
                    boolean i2 = aRc23Z3.i();
                    NSK3xo.ADYaiT aDYaiT = (NSK3xo.ADYaiT) entry.getKey();
                    if (i2) {
                        a4TApA3.put(aDYaiT, aRc23Z3);
                    } else {
                        a4TApA4.put(aDYaiT, aRc23Z3);
                    }
                }
                NUY5pn.AYUAbz.AMqCpz(!a4TApA3.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
                QkAq4X.A4TApA a4TApA5 = new QkAq4X.A4TApA();
                QkAq4X.A4TApA a4TApA6 = new QkAq4X.A4TApA();
                for (NSK3xo.AYUAbz aYUAbz : a4TApA2.keySet()) {
                    NSK3xo.ASJ6gh A2egSU2 = aYUAbz.A2egSU();
                    if (a4TApA3.containsKey(A2egSU2)) {
                        a4TApA5.put(aYUAbz, (Integer) a4TApA2.get(aYUAbz));
                    } else {
                        if (!a4TApA4.containsKey(A2egSU2)) {
                            throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
                        }
                        a4TApA6.put(aYUAbz, (Integer) a4TApA2.get(aYUAbz));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DUi7mC dUi7mC = (DUi7mC) it.next();
                    if (a4TApA5.containsKey(dUi7mC.f5734A2egSU)) {
                        arrayList2.add(dUi7mC);
                    } else {
                        if (!a4TApA6.containsKey(dUi7mC.f5734A2egSU)) {
                            throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
                        }
                        arrayList3.add(dUi7mC);
                    }
                }
                this.f5792BI9f7h = new A4TApA(this.f5794BJ7GGh, this, reentrantLock2, this.f5795BNL6CD, this.f5800BniPrB, a4TApA3, a4TApA4, this.f5786B2KMhB, this.f5788B4ZgIw, aRc23Z2, arrayList2, arrayList3, a4TApA5, a4TApA6);
                return;
            }
            reentrantLock = reentrantLock2;
        }
        this.f5792BI9f7h = new EUIRHA(this.f5794BJ7GGh, this, reentrantLock, this.f5795BNL6CD, this.f5800BniPrB, a4TApA, this.f5786B2KMhB, a4TApA2, this.f5788B4ZgIw, arrayList, this);
    }

    public final void AaHO0E() {
        ReentrantLock reentrantLock = this.f5790B9tovu;
        reentrantLock.lock();
        try {
            if (this.f5793BIYEnU >= 0) {
                NUY5pn.AYUAbz.AMqCpz(this.f5802C4FrIb != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f5802C4FrIb;
                if (num == null) {
                    this.f5802C4FrIb = Integer.valueOf(AYUAbz(this.f5784AzWtSf.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = this.f5802C4FrIb.intValue();
            reentrantLock.lock();
            boolean z = intValue == 3 || intValue == 1 || intValue == 2;
            try {
                StringBuilder sb = new StringBuilder(33);
                sb.append("Illegal sign-in mode: ");
                sb.append(intValue);
                NUY5pn.AYUAbz.ASJ6gh(z, sb.toString());
                AZkASS(intValue);
                this.f5791BChYOn.f6010B25kr6 = true;
                this.f5792BI9f7h.a();
                reentrantLock.unlock();
            } finally {
                reentrantLock.unlock();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final NOd7IU.A2egSU AcNBzu() {
        NUY5pn.AYUAbz.AMqCpz(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f5790B9tovu.lock();
        try {
            if (this.f5793BIYEnU >= 0) {
                NUY5pn.AYUAbz.AMqCpz(this.f5802C4FrIb != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f5802C4FrIb;
                if (num == null) {
                    this.f5802C4FrIb = Integer.valueOf(AYUAbz(this.f5784AzWtSf.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            AZkASS(this.f5802C4FrIb.intValue());
            this.f5791BChYOn.f6010B25kr6 = true;
            NOd7IU.A2egSU b = this.f5792BI9f7h.b();
            this.f5790B9tovu.unlock();
            return b;
        } catch (Throwable th) {
            this.f5790B9tovu.unlock();
            throw th;
        }
    }

    public final NSK3xo.AlLFFp AlLFFp() {
        EwN40Z ewN40Z = this.f5792BI9f7h;
        NUY5pn.AYUAbz.AMqCpz(ewN40Z != null && ewN40Z.d(), "GoogleApiClient is not connected yet.");
        NUY5pn.AYUAbz.AMqCpz(this.f5802C4FrIb.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        ADYaiT aDYaiT = new ADYaiT(this);
        if (this.f5784AzWtSf.containsKey(AZOQYO.f5684A2egSU)) {
            AZOQYO.f5686A5SV6n.getClass();
            NCeV4Q.ASJ6gh A5SV6n2 = A5SV6n(new NCeV4Q.ASJ6gh(AZOQYO.f5685A4TApA, this, 1));
            ECyGFg eCyGFg = new ECyGFg(this, aDYaiT, false, this);
            synchronized (A5SV6n2.f5725A5SV6n) {
                try {
                    NUY5pn.AYUAbz.AMqCpz(!A5SV6n2.f5730AZOQYO, "Result has already been consumed.");
                    if (!A5SV6n2.AYUAbz()) {
                        if (A5SV6n2.ARc23Z()) {
                            DG07BK dg07bk = A5SV6n2.f5723A2egSU;
                            NSK3xo.AmA8tU A5SV6n3 = A5SV6n2.A5SV6n();
                            dg07bk.getClass();
                            dg07bk.sendMessage(dg07bk.obtainMessage(1, new Pair(eCyGFg, A5SV6n3)));
                        } else {
                            A5SV6n2.f5727ARc23Z = eCyGFg;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aDYaiT;
        }
        AtomicReference atomicReference = new AtomicReference();
        DvK7DB dvK7DB = new DvK7DB(this, atomicReference, aDYaiT);
        DyaChj dyaChj = new DyaChj(aDYaiT);
        NSK3xo.AZOQYO azoqyo = new NSK3xo.AZOQYO(this.f5794BJ7GGh);
        NSK3xo.AYUAbz aYUAbz = AZOQYO.f5685A4TApA;
        NUY5pn.AYUAbz.A5SV6n(aYUAbz, "Api must not be null");
        azoqyo.f5937ASJ6gh.put(aYUAbz, null);
        List A2egSU2 = aYUAbz.f5929A2egSU.A2egSU(null);
        azoqyo.f5933A4TApA.addAll(A2egSU2);
        azoqyo.f5932A2egSU.addAll(A2egSU2);
        azoqyo.f5942AcNBzu.add(dvK7DB);
        azoqyo.f5943AlLFFp.add(dyaChj);
        DG07BK.A2egSU a2egSU = this.f5799BmvVmW;
        NUY5pn.AYUAbz.A5SV6n(a2egSU, "Handler must not be null");
        azoqyo.f5939AZOQYO = a2egSU.getLooper();
        EH1KK8 A2egSU3 = azoqyo.A2egSU();
        atomicReference.set(A2egSU3);
        A2egSU3.AaHO0E();
        return aDYaiT;
    }

    public final boolean AmA8tU() {
        if (!this.f5796BPw6Q8) {
            return false;
        }
        this.f5796BPw6Q8 = false;
        this.f5799BmvVmW.removeMessages(2);
        this.f5799BmvVmW.removeMessages(1);
        ErKPGd erKPGd = this.f5783AmA8tU;
        if (erKPGd != null) {
            erKPGd.A2egSU();
            this.f5783AmA8tU = null;
        }
        return true;
    }

    @Override // NGepWW.EsrwYR
    public final void a(int i) {
        if (i == 1 && !this.f5796BPw6Q8) {
            this.f5796BPw6Q8 = true;
            if (this.f5783AmA8tU == null) {
                NOd7IU.ADYaiT aDYaiT = this.f5800BniPrB;
                Context applicationContext = this.f5794BJ7GGh.getApplicationContext();
                EGM26s eGM26s = new EGM26s();
                eGM26s.f5781A2egSU = new WeakReference(this);
                aDYaiT.getClass();
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                ErKPGd erKPGd = new ErKPGd(eGM26s);
                applicationContext.registerReceiver(erKPGd, intentFilter);
                erKPGd.f5845A2egSU = applicationContext;
                if (!NOd7IU.AMqCpz.A2egSU(applicationContext)) {
                    eGM26s.A2egSU();
                    erKPGd.A2egSU();
                    erKPGd = null;
                }
                this.f5783AmA8tU = erKPGd;
            }
            DG07BK.A2egSU a2egSU = this.f5799BmvVmW;
            a2egSU.sendMessageDelayed(a2egSU.obtainMessage(1), this.f5797BTvldC);
            DG07BK.A2egSU a2egSU2 = this.f5799BmvVmW;
            a2egSU2.sendMessageDelayed(a2egSU2.obtainMessage(2), this.f5798BV3sI0);
        }
        for (DRlcZ9 dRlcZ9 : (DRlcZ9[]) this.f5789B7CMnp.f5681A2egSU.toArray(ARc23Z.f5680ADYaiT)) {
            dRlcZ9.AMqCpz(ARc23Z.f5679A5SV6n);
        }
        NUY5pn.BNL6CD bnl6cd = this.f5791BChYOn;
        bnl6cd.getClass();
        NUY5pn.AYUAbz.AMqCpz(Looper.myLooper() == bnl6cd.f6013B4ZgIw.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        bnl6cd.f6013B4ZgIw.removeMessages(1);
        synchronized (bnl6cd.f6014B7CMnp) {
            try {
                bnl6cd.f6012B3GDIM = true;
                ArrayList arrayList = new ArrayList(bnl6cd.f6008AmA8tU);
                int i2 = bnl6cd.f6011B2KMhB.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    NSK3xo.AZkASS aZkASS = (NSK3xo.AZkASS) it.next();
                    if (!bnl6cd.f6010B25kr6 || bnl6cd.f6011B2KMhB.get() != i2) {
                        break;
                    } else if (bnl6cd.f6008AmA8tU.contains(aZkASS)) {
                        aZkASS.a(i);
                    }
                }
                bnl6cd.f6006AcNBzu.clear();
                bnl6cd.f6012B3GDIM = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        NUY5pn.BNL6CD bnl6cd2 = this.f5791BChYOn;
        bnl6cd2.f6010B25kr6 = false;
        bnl6cd2.f6011B2KMhB.incrementAndGet();
        if (i == 2) {
            this.f5791BChYOn.f6010B25kr6 = true;
            this.f5792BI9f7h.a();
        }
    }
}
