package HXc4pW;

import ADYaiT.D9tr6l;
import ADYaiT.DUi7mC;
import AaHO0E.HHoABE;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf {

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final boolean f3561AYUAbz = Log.isLoggable("Engine", 2);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BJ7GGh f3562A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ADYaiT.BmvVmW f3563A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Hdahpu.AMqCpz f3564A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HHoABE f3565ADYaiT;
    public final D9tr6l AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final BTvldC.ADYaiT f3566ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final AZOQYO.ARc23Z f3567ASJ6gh;

    static {
        qXbiNg();
    }

    public AzWtSf(Hdahpu.AMqCpz aMqCpz, KCxDWD.A5SV6n a5SV6n, HieBYM.A5SV6n a5SV6n2, HieBYM.A5SV6n a5SV6n3, HieBYM.A5SV6n a5SV6n4, HieBYM.A5SV6n a5SV6n5) {
        this.f3564A5SV6n = aMqCpz;
        AmA8tU amA8tU = new AmA8tU(a5SV6n);
        AZOQYO.ARc23Z aRc23Z = new AZOQYO.ARc23Z(4);
        this.f3567ASJ6gh = aRc23Z;
        synchronized (this) {
            try {
                try {
                    synchronized (aRc23Z) {
                        try {
                            aRc23Z.f366AzWtSf = this;
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    }
                    this.f3563A4TApA = new ADYaiT.BmvVmW(27);
                    this.f3562A2egSU = new BJ7GGh(0);
                    this.f3565ADYaiT = new HHoABE(a5SV6n2, a5SV6n3, a5SV6n4, a5SV6n5, this, this);
                    this.f3566ARc23Z = new BTvldC.ADYaiT(amA8tU);
                    this.AMqCpz = new D9tr6l(2);
                    aMqCpz.f3690ADYaiT = this;
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    public static void ARc23Z(BTvldC bTvldC) {
        if (!(bTvldC instanceof B9tovu)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((B9tovu) bTvldC).ADYaiT();
    }

    private static /* synthetic */ void qXbiNg() {
        char[] charArray = "ØÔÖ\u0095ÜÚÖÞ\u0095ÙÔÂ\u0095ÈÓÞ××\u0095ñÕÒùÉÒßÜÞ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 187);
        }
        String str = new String(charArray);
        char[] charArray2 = "Ø×ÒÕÒÏ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 187);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final DUi7mC A2egSU(com.bumptech.glide.ARc23Z aRc23Z, Object obj, HSHyT0.AZkASS aZkASS, int i, int i2, Class cls, Class cls2, com.bumptech.glide.AZOQYO azoqyo, AlLFFp alLFFp, ItGa5w.A5SV6n a5SV6n, boolean z, boolean z2, HSHyT0.AmA8tU amA8tU, boolean z3, boolean z4, IhMMDv.ASJ6gh aSJ6gh, Executor executor) {
        long j;
        if (f3561AYUAbz) {
            int i3 = ItGa5w.ASJ6gh.f4081A2egSU;
            j = SystemClock.elapsedRealtimeNanos();
        } else {
            j = 0;
        }
        this.f3563A4TApA.getClass();
        B7CMnp b7CMnp = new B7CMnp(obj, aZkASS, i, i2, a5SV6n, cls, cls2, amA8tU);
        synchronized (this) {
            try {
                B9tovu A5SV6n2 = A5SV6n(b7CMnp, z3, j);
                if (A5SV6n2 == null) {
                    return ASJ6gh(aRc23Z, obj, aZkASS, i, i2, cls, cls2, azoqyo, alLFFp, a5SV6n, z, z2, amA8tU, z3, z4, aSJ6gh, executor, b7CMnp, j);
                }
                aSJ6gh.ASJ6gh(A5SV6n2, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final HXc4pW.B9tovu A4TApA(HXc4pW.B7CMnp r10) {
        /*
            r9 = this;
            Hdahpu.AMqCpz r1 = r9.f3564A5SV6n
            monitor-enter(r1)
            java.util.LinkedHashMap r0 = r1.f4084A2egSU     // Catch: java.lang.Throwable -> L41
            java.lang.Object r0 = r0.remove(r10)     // Catch: java.lang.Throwable -> L41
            ItGa5w.AYUAbz r0 = (ItGa5w.AYUAbz) r0     // Catch: java.lang.Throwable -> L41
            r2 = 0
            if (r0 != 0) goto L11
            monitor-exit(r1)
            r0 = r2
            goto L1c
        L11:
            long r3 = r1.f4086A5SV6n     // Catch: java.lang.Throwable -> L41
            int r5 = r0.f4083A4TApA     // Catch: java.lang.Throwable -> L41
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L41
            long r3 = r3 - r5
            r1.f4086A5SV6n = r3     // Catch: java.lang.Throwable -> L41
            java.lang.Object r0 = r0.f4082A2egSU     // Catch: java.lang.Throwable -> L41
            monitor-exit(r1)
        L1c:
            r4 = r0
            HXc4pW.BTvldC r4 = (HXc4pW.BTvldC) r4
            if (r4 != 0) goto L24
        L21:
            r8 = r9
            r7 = r10
            goto L36
        L24:
            boolean r0 = r4 instanceof HXc4pW.B9tovu
            if (r0 == 0) goto L2c
            r2 = r4
            HXc4pW.B9tovu r2 = (HXc4pW.B9tovu) r2
            goto L21
        L2c:
            HXc4pW.B9tovu r3 = new HXc4pW.B9tovu
            r5 = 1
            r6 = 1
            r8 = r9
            r7 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = r3
        L36:
            if (r2 == 0) goto L40
            r2.A5SV6n()
            AZOQYO.ARc23Z r10 = r8.f3567ASJ6gh
            r10.A2egSU(r7, r2)
        L40:
            return r2
        L41:
            r0 = move-exception
            r8 = r9
        L43:
            r10 = r0
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L46
            throw r10
        L46:
            r0 = move-exception
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: HXc4pW.AzWtSf.A4TApA(HXc4pW.B7CMnp):HXc4pW.B9tovu");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final B9tovu A5SV6n(B7CMnp b7CMnp, boolean z, long j) {
        B9tovu b9tovu;
        if (z) {
            AZOQYO.ARc23Z aRc23Z = this.f3567ASJ6gh;
            synchronized (aRc23Z) {
                A4TApA a4TApA = (A4TApA) ((HashMap) aRc23Z.f364AlLFFp).get(b7CMnp);
                if (a4TApA == null) {
                    b9tovu = null;
                } else {
                    b9tovu = (B9tovu) a4TApA.get();
                    if (b9tovu == null) {
                        aRc23Z.A4TApA(a4TApA);
                    }
                }
            }
            if (b9tovu != null) {
                b9tovu.A5SV6n();
            }
            if (b9tovu != null) {
                if (f3561AYUAbz) {
                    int i = ItGa5w.ASJ6gh.f4081A2egSU;
                    SystemClock.elapsedRealtimeNanos();
                    Objects.toString(b7CMnp);
                }
                return b9tovu;
            }
            B9tovu A4TApA2 = A4TApA(b7CMnp);
            if (A4TApA2 != null) {
                if (f3561AYUAbz) {
                    int i2 = ItGa5w.ASJ6gh.f4081A2egSU;
                    SystemClock.elapsedRealtimeNanos();
                    Objects.toString(b7CMnp);
                }
                return A4TApA2;
            }
        }
        return null;
    }

    public final synchronized void ADYaiT(B4ZgIw b4ZgIw, B7CMnp b7CMnp, B9tovu b9tovu) {
        if (b9tovu != null) {
            try {
                if (b9tovu.f3604AcNBzu) {
                    this.f3567ASJ6gh.A2egSU(b7CMnp, b9tovu);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        BJ7GGh bJ7GGh = this.f3562A2egSU;
        bJ7GGh.getClass();
        b4ZgIw.getClass();
        HashMap hashMap = bJ7GGh.f3619A2egSU;
        if (b4ZgIw.equals(hashMap.get(b7CMnp))) {
            hashMap.remove(b7CMnp);
        }
    }

    public final void AMqCpz(B7CMnp b7CMnp, B9tovu b9tovu) {
        AZOQYO.ARc23Z aRc23Z = this.f3567ASJ6gh;
        synchronized (aRc23Z) {
            A4TApA a4TApA = (A4TApA) ((HashMap) aRc23Z.f364AlLFFp).remove(b7CMnp);
            if (a4TApA != null) {
                a4TApA.f3490A5SV6n = null;
                a4TApA.clear();
            }
        }
        if (b9tovu.f3604AcNBzu) {
        } else {
            this.AMqCpz.ARc23Z(b9tovu, false);
        }
    }

    public final DUi7mC ASJ6gh(com.bumptech.glide.ARc23Z aRc23Z, Object obj, HSHyT0.AZkASS aZkASS, int i, int i2, Class cls, Class cls2, com.bumptech.glide.AZOQYO azoqyo, AlLFFp alLFFp, ItGa5w.A5SV6n a5SV6n, boolean z, boolean z2, HSHyT0.AmA8tU amA8tU, boolean z3, boolean z4, IhMMDv.ASJ6gh aSJ6gh, Executor executor, B7CMnp b7CMnp, long j) {
        B4ZgIw b4ZgIw = (B4ZgIw) this.f3562A2egSU.f3619A2egSU.get(b7CMnp);
        if (b4ZgIw != null) {
            b4ZgIw.A2egSU(aSJ6gh, executor);
            if (f3561AYUAbz) {
                int i3 = ItGa5w.ASJ6gh.f4081A2egSU;
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(b7CMnp);
            }
            return new DUi7mC(this, aSJ6gh, b4ZgIw);
        }
        B4ZgIw b4ZgIw2 = (B4ZgIw) ((DUi7mC) this.f3565ADYaiT.f931ASJ6gh).AYUAbz();
        synchronized (b4ZgIw2) {
            b4ZgIw2.f3585BChYOn = b7CMnp;
            b4ZgIw2.f3586BI9f7h = z3;
            b4ZgIw2.f3587BIYEnU = z4;
        }
        BTvldC.ADYaiT aDYaiT = this.f3566ARc23Z;
        AZkASS aZkASS2 = (AZkASS) ((DUi7mC) aDYaiT.f1449AmA8tU).AYUAbz();
        int i4 = aDYaiT.f1447AcNBzu;
        aDYaiT.f1447AcNBzu = i4 + 1;
        AYUAbz aYUAbz = aZkASS2.f3522AcNBzu;
        aYUAbz.f3504A5SV6n = aRc23Z;
        aYUAbz.f3505ADYaiT = obj;
        aYUAbz.f3514AmA8tU = aZkASS;
        aYUAbz.AMqCpz = i;
        aYUAbz.f3506ARc23Z = i2;
        aYUAbz.f3516B25kr6 = alLFFp;
        aYUAbz.f3507ASJ6gh = cls;
        aYUAbz.f3508AYUAbz = aZkASS2.f3525AzWtSf;
        aYUAbz.f3511AaHO0E = cls2;
        aYUAbz.f3515AzWtSf = azoqyo;
        aYUAbz.f3509AZOQYO = amA8tU;
        aYUAbz.f3510AZkASS = a5SV6n;
        aYUAbz.f3517B2KMhB = z;
        aYUAbz.f3518B3GDIM = z2;
        aZkASS2.f3529B4ZgIw = aRc23Z;
        aZkASS2.f3530B7CMnp = aZkASS;
        aZkASS2.f3531B9tovu = azoqyo;
        aZkASS2.f3532BChYOn = b7CMnp;
        aZkASS2.f3533BI9f7h = i;
        aZkASS2.f3534BIYEnU = i2;
        aZkASS2.f3535BJ7GGh = alLFFp;
        aZkASS2.f3536BNL6CD = amA8tU;
        aZkASS2.f3537BPw6Q8 = b4ZgIw2;
        aZkASS2.f3538BTvldC = i4;
        aZkASS2.f3549CTkVKb = 1;
        aZkASS2.f3539BV3sI0 = obj;
        BJ7GGh bJ7GGh = this.f3562A2egSU;
        bJ7GGh.getClass();
        bJ7GGh.f3619A2egSU.put(b7CMnp, b4ZgIw2);
        b4ZgIw2.A2egSU(aSJ6gh, executor);
        b4ZgIw2.AaHO0E(aZkASS2);
        if (f3561AYUAbz) {
            int i5 = ItGa5w.ASJ6gh.f4081A2egSU;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(b7CMnp);
        }
        return new DUi7mC(this, aSJ6gh, b4ZgIw2);
    }
}
