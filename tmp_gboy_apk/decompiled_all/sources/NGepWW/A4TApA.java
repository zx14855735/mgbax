package NGepWW;

import AaHO0E.HHoABE;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements EwN40Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final RevocationBoundService f5659A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final EH1KK8 f5660A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Looper f5661A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final EUIRHA f5662ADYaiT;
    public final EUIRHA AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Map f5663ARc23Z;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final NSK3xo.ARc23Z f5665AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public Bundle f5666AZOQYO;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ReentrantLock f5670AlLFFp;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Set f5664ASJ6gh = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: AZkASS, reason: collision with root package name */
    public NOd7IU.A2egSU f5667AZkASS = null;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public NOd7IU.A2egSU f5668AaHO0E = null;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f5669AcNBzu = false;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f5671AmA8tU = 0;

    public A4TApA(RevocationBoundService revocationBoundService, EH1KK8 eh1kk8, ReentrantLock reentrantLock, Looper looper, NOd7IU.AYUAbz aYUAbz, QkAq4X.A4TApA a4TApA, QkAq4X.A4TApA a4TApA2, HHoABE hHoABE, N8uUiS.A2egSU a2egSU, NSK3xo.ARc23Z aRc23Z, ArrayList arrayList, ArrayList arrayList2, QkAq4X.A4TApA a4TApA3, QkAq4X.A4TApA a4TApA4) {
        this.f5659A2egSU = revocationBoundService;
        this.f5660A4TApA = eh1kk8;
        this.f5670AlLFFp = reentrantLock;
        this.f5661A5SV6n = looper;
        this.f5665AYUAbz = aRc23Z;
        this.f5662ADYaiT = new EUIRHA(revocationBoundService, eh1kk8, reentrantLock, looper, aYUAbz, a4TApA2, null, a4TApA4, null, arrayList2, new IQ76hF.AmA8tU(17, this));
        this.AMqCpz = new EUIRHA(revocationBoundService, eh1kk8, reentrantLock, looper, aYUAbz, a4TApA, hHoABE, a4TApA3, a2egSU, arrayList, new A2egSU(0, this));
        QkAq4X.A4TApA a4TApA5 = new QkAq4X.A4TApA();
        Iterator it = ((QkAq4X.ASJ6gh) a4TApA2.keySet()).iterator();
        while (it.hasNext()) {
            a4TApA5.put((NSK3xo.ADYaiT) it.next(), this.f5662ADYaiT);
        }
        Iterator it2 = ((QkAq4X.ASJ6gh) a4TApA.keySet()).iterator();
        while (it2.hasNext()) {
            a4TApA5.put((NSK3xo.ADYaiT) it2.next(), this.AMqCpz);
        }
        this.f5663ARc23Z = Collections.unmodifiableMap(a4TApA5);
    }

    public static void A2egSU(A4TApA a4TApA, int i) {
        a4TApA.f5660A4TApA.a(i);
        a4TApA.f5668AaHO0E = null;
        a4TApA.f5667AZkASS = null;
    }

    public static void ARc23Z(A4TApA a4TApA) {
        NOd7IU.A2egSU a2egSU;
        NOd7IU.A2egSU a2egSU2;
        NOd7IU.A2egSU a2egSU3;
        NOd7IU.A2egSU a2egSU4 = a4TApA.f5667AZkASS;
        boolean z = a2egSU4 != null && a2egSU4.A5SV6n();
        EUIRHA euirha = a4TApA.f5662ADYaiT;
        if (!z) {
            NOd7IU.A2egSU a2egSU5 = a4TApA.f5667AZkASS;
            EUIRHA euirha2 = a4TApA.AMqCpz;
            if (a2egSU5 != null && (a2egSU2 = a4TApA.f5668AaHO0E) != null && a2egSU2.A5SV6n()) {
                euirha2.c();
                a4TApA.ADYaiT(a4TApA.f5667AZkASS);
                return;
            }
            NOd7IU.A2egSU a2egSU6 = a4TApA.f5667AZkASS;
            if (a2egSU6 == null || (a2egSU = a4TApA.f5668AaHO0E) == null) {
                return;
            }
            if (euirha2.f5808ARc23Z < euirha.f5808ARc23Z) {
                a2egSU6 = a2egSU;
            }
            a4TApA.ADYaiT(a2egSU6);
            return;
        }
        NOd7IU.A2egSU a2egSU7 = a4TApA.f5668AaHO0E;
        if (!(a2egSU7 != null && a2egSU7.A5SV6n()) && ((a2egSU3 = a4TApA.f5668AaHO0E) == null || a2egSU3.f5854AlLFFp != 4)) {
            if (a2egSU3 != null) {
                if (a4TApA.f5671AmA8tU == 1) {
                    a4TApA.ASJ6gh();
                    return;
                } else {
                    a4TApA.ADYaiT(a2egSU3);
                    euirha.c();
                    return;
                }
            }
            return;
        }
        int i = a4TApA.f5671AmA8tU;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                a4TApA.f5671AmA8tU = 0;
            }
            a4TApA.f5660A4TApA.A2egSU(a4TApA.f5666AZOQYO);
        }
        a4TApA.ASJ6gh();
        a4TApA.f5671AmA8tU = 0;
    }

    @Override // NGepWW.EwN40Z
    public final boolean A4TApA(NCeV4Q.A5SV6n a5SV6n) {
        this.f5670AlLFFp.lock();
        try {
            ReentrantLock reentrantLock = this.f5670AlLFFp;
            reentrantLock.lock();
            try {
                boolean z = this.f5671AmA8tU == 2;
                reentrantLock.unlock();
                if (!z) {
                    if (d()) {
                    }
                    return false;
                }
                if (!(this.AMqCpz.f5816AmA8tU instanceof DcUJf1)) {
                    this.f5664ASJ6gh.add(a5SV6n);
                    if (this.f5671AmA8tU == 0) {
                        this.f5671AmA8tU = 1;
                    }
                    this.f5668AaHO0E = null;
                    this.AMqCpz.a();
                    return true;
                }
                return false;
            } finally {
                reentrantLock.unlock();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // NGepWW.EwN40Z
    public final NCeV4Q.ASJ6gh A5SV6n(NCeV4Q.ASJ6gh aSJ6gh) {
        EUIRHA euirha;
        PendingIntent activity;
        NSK3xo.ASJ6gh aSJ6gh2 = aSJ6gh.f5645AmA8tU;
        Map map = this.f5663ARc23Z;
        NUY5pn.AYUAbz.ASJ6gh(map.containsKey(aSJ6gh2), "GoogleApiClient is not configured to use the API required for this call.");
        if (((EUIRHA) map.get(aSJ6gh2)).equals(this.AMqCpz)) {
            NOd7IU.A2egSU a2egSU = this.f5668AaHO0E;
            if (a2egSU != null && a2egSU.f5854AlLFFp == 4) {
                NSK3xo.ARc23Z aRc23Z = this.f5665AYUAbz;
                if (aRc23Z == null) {
                    activity = null;
                } else {
                    EH1KK8 eh1kk8 = this.f5660A4TApA;
                    eh1kk8.getClass();
                    activity = PendingIntent.getActivity(this.f5659A2egSU, System.identityHashCode(eh1kk8), aRc23Z.d(), 134217728);
                }
                aSJ6gh.AaHO0E(new NSK3xo.A4TApA(1, 4, activity, null));
                return aSJ6gh;
            }
            euirha = this.AMqCpz;
        } else {
            euirha = this.f5662ADYaiT;
        }
        euirha.getClass();
        aSJ6gh.AZOQYO();
        return euirha.f5816AmA8tU.A5SV6n(aSJ6gh);
    }

    public final void ADYaiT(NOd7IU.A2egSU a2egSU) {
        int i = this.f5671AmA8tU;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.f5671AmA8tU = 0;
            }
            this.f5660A4TApA.A4TApA(a2egSU);
        }
        ASJ6gh();
        this.f5671AmA8tU = 0;
    }

    @Override // NGepWW.EwN40Z
    public final void AMqCpz(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.AMqCpz.AMqCpz(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f5662ADYaiT.AMqCpz(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final void ASJ6gh() {
        Set set = this.f5664ASJ6gh;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((NCeV4Q.A5SV6n) it.next()).f5641AZOQYO.release();
        }
        set.clear();
    }

    @Override // NGepWW.EwN40Z
    public final void a() {
        this.f5671AmA8tU = 2;
        this.f5669AcNBzu = false;
        this.f5668AaHO0E = null;
        this.f5667AZkASS = null;
        this.f5662ADYaiT.a();
        this.AMqCpz.a();
    }

    @Override // NGepWW.EwN40Z
    public final NOd7IU.A2egSU b() {
        throw new UnsupportedOperationException();
    }

    @Override // NGepWW.EwN40Z
    public final void c() {
        this.f5668AaHO0E = null;
        this.f5667AZkASS = null;
        this.f5671AmA8tU = 0;
        this.f5662ADYaiT.c();
        this.AMqCpz.c();
        ASJ6gh();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r4.f5671AmA8tU == 1) goto L19;
     */
    @Override // NGepWW.EwN40Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d() {
        /*
            r4 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r4.f5670AlLFFp
            r0.lock()
            NGepWW.EUIRHA r0 = r4.f5662ADYaiT     // Catch: java.lang.Throwable -> L2a
            NGepWW.EPdU4G r0 = r0.f5816AmA8tU     // Catch: java.lang.Throwable -> L2a
            boolean r0 = r0 instanceof NGepWW.DcUJf1     // Catch: java.lang.Throwable -> L2a
            r1 = 0
            if (r0 == 0) goto L2d
            NGepWW.EUIRHA r0 = r4.AMqCpz     // Catch: java.lang.Throwable -> L2a
            NGepWW.EPdU4G r0 = r0.f5816AmA8tU     // Catch: java.lang.Throwable -> L2a
            boolean r0 = r0 instanceof NGepWW.DcUJf1     // Catch: java.lang.Throwable -> L2a
            r2 = 1
            if (r0 != 0) goto L2c
            NOd7IU.A2egSU r0 = r4.f5668AaHO0E     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L22
            int r0 = r0.f5854AlLFFp     // Catch: java.lang.Throwable -> L2a
            r3 = 4
            if (r0 != r3) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 != 0) goto L2c
            int r0 = r4.f5671AmA8tU     // Catch: java.lang.Throwable -> L2a
            if (r0 != r2) goto L2d
            goto L2c
        L2a:
            r0 = move-exception
            goto L33
        L2c:
            r1 = 1
        L2d:
            java.util.concurrent.locks.ReentrantLock r0 = r4.f5670AlLFFp
            r0.unlock()
            return r1
        L33:
            java.util.concurrent.locks.ReentrantLock r1 = r4.f5670AlLFFp
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: NGepWW.A4TApA.d():boolean");
    }

    @Override // NGepWW.EwN40Z
    public final void g() {
        ReentrantLock reentrantLock = this.f5670AlLFFp;
        reentrantLock.lock();
        try {
            reentrantLock.lock();
            try {
                boolean z = this.f5671AmA8tU == 2;
                reentrantLock.unlock();
                this.AMqCpz.c();
                this.f5668AaHO0E = new NOd7IU.A2egSU(4);
                if (z) {
                    new Handler(this.f5661A5SV6n).post(new LLYwnm.AMqCpz(18, this));
                } else {
                    ASJ6gh();
                }
            } finally {
                reentrantLock.unlock();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
