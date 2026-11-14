package HXc4pW;

import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS implements ARc23Z, Runnable, Comparable, Ixu71n.A4TApA {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AmA8tU f3525AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final DUi7mC f3526B25kr6;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public com.bumptech.glide.ARc23Z f3529B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public HSHyT0.AZkASS f3530B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public com.bumptech.glide.AZOQYO f3531B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public B7CMnp f3532BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f3533BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public int f3534BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public AlLFFp f3535BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public HSHyT0.AmA8tU f3536BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public B4ZgIw f3537BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f3538BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public Object f3539BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public Thread f3540BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public HSHyT0.AZkASS f3541BniPrB;
    public HSHyT0.AZkASS BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public Object f3542C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public com.bumptech.glide.load.data.AMqCpz f3543C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public volatile ASJ6gh f3544CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public volatile boolean f3545CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public volatile boolean f3546COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public boolean f3547CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f3548CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f3549CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f3550CcAIMM;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AYUAbz f3522AcNBzu = new AYUAbz();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f3523AlLFFp = new ArrayList();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Ixu71n.ADYaiT f3524AmA8tU = new Ixu71n.ADYaiT();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final DUi7mC f3527B2KMhB = new DUi7mC(10);

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final AZOQYO f3528B3GDIM = new AZOQYO();

    public AZkASS(AmA8tU amA8tU, DUi7mC dUi7mC) {
        this.f3525AzWtSf = amA8tU;
        this.f3526B25kr6 = dUi7mC;
    }

    public final BTvldC A2egSU(com.bumptech.glide.load.data.AMqCpz aMqCpz, Object obj, int i) {
        if (obj == null) {
            aMqCpz.AMqCpz();
            return null;
        }
        try {
            int i2 = ItGa5w.ASJ6gh.f4081A2egSU;
            SystemClock.elapsedRealtimeNanos();
            BTvldC AMqCpz = AMqCpz(i, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                AMqCpz.toString();
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(this.f3532BChYOn);
                Thread.currentThread().getName();
            }
            return AMqCpz;
        } finally {
            aMqCpz.AMqCpz();
        }
    }

    @Override // HXc4pW.ARc23Z
    public final void A4TApA(HSHyT0.AZkASS aZkASS, Exception exc, com.bumptech.glide.load.data.AMqCpz aMqCpz, int i) {
        aMqCpz.AMqCpz();
        BI9f7h bI9f7h = new BI9f7h("Fetching data failed", Collections.singletonList(exc));
        Class A2egSU2 = aMqCpz.A2egSU();
        bI9f7h.f3615AlLFFp = aZkASS;
        bI9f7h.f3616AmA8tU = i;
        bI9f7h.f3617AzWtSf = A2egSU2;
        this.f3523AlLFFp.add(bI9f7h);
        if (Thread.currentThread() == this.f3540BmvVmW) {
            AzWtSf();
            return;
        }
        this.f3549CTkVKb = 2;
        B4ZgIw b4ZgIw = this.f3537BPw6Q8;
        (b4ZgIw.f3587BIYEnU ? b4ZgIw.f3583B7CMnp : b4ZgIw.f3582B4ZgIw).execute(this);
    }

    @Override // HXc4pW.ARc23Z
    public final void A5SV6n(HSHyT0.AZkASS aZkASS, Object obj, com.bumptech.glide.load.data.AMqCpz aMqCpz, int i, HSHyT0.AZkASS aZkASS2) {
        this.f3541BniPrB = aZkASS;
        this.f3542C2rE4F = obj;
        this.f3543C4FrIb = aMqCpz;
        this.f3550CcAIMM = i;
        this.BpkvW3 = aZkASS2;
        this.f3547CQhlFr = aZkASS != this.f3522AcNBzu.A2egSU().get(0);
        if (Thread.currentThread() == this.f3540BmvVmW) {
            ARc23Z();
            return;
        }
        this.f3549CTkVKb = 3;
        B4ZgIw b4ZgIw = this.f3537BPw6Q8;
        (b4ZgIw.f3587BIYEnU ? b4ZgIw.f3583B7CMnp : b4ZgIw.f3582B4ZgIw).execute(this);
    }

    @Override // Ixu71n.A4TApA
    public final Ixu71n.ADYaiT ADYaiT() {
        return this.f3524AmA8tU;
    }

    public final BTvldC AMqCpz(int i, Object obj) {
        com.bumptech.glide.load.data.ASJ6gh A4TApA2;
        BNL6CD A5SV6n2 = this.f3522AcNBzu.A5SV6n(obj.getClass());
        HSHyT0.AmA8tU amA8tU = this.f3536BNL6CD;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = i == 4 || this.f3522AcNBzu.f3518B3GDIM;
            HSHyT0.AlLFFp alLFFp = I3HV03.B4ZgIw.f3835AZOQYO;
            Boolean bool = (Boolean) amA8tU.A5SV6n(alLFFp);
            if (bool == null || (bool.booleanValue() && !z)) {
                amA8tU = new HSHyT0.AmA8tU();
                amA8tU.f3470A4TApA.ASJ6gh(this.f3536BNL6CD.f3470A4TApA);
                amA8tU.f3470A4TApA.put(alLFFp, Boolean.valueOf(z));
            }
        }
        HSHyT0.AmA8tU amA8tU2 = amA8tU;
        com.bumptech.glide.load.data.AZOQYO azoqyo = this.f3529B4ZgIw.f9920A4TApA.AMqCpz;
        synchronized (azoqyo) {
            try {
                com.bumptech.glide.load.data.ARc23Z aRc23Z = (com.bumptech.glide.load.data.ARc23Z) azoqyo.f9984A2egSU.get(obj.getClass());
                if (aRc23Z == null) {
                    Iterator it = azoqyo.f9984A2egSU.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bumptech.glide.load.data.ARc23Z aRc23Z2 = (com.bumptech.glide.load.data.ARc23Z) it.next();
                        if (aRc23Z2.A2egSU().isAssignableFrom(obj.getClass())) {
                            aRc23Z = aRc23Z2;
                            break;
                        }
                    }
                }
                if (aRc23Z == null) {
                    aRc23Z = com.bumptech.glide.load.data.AZOQYO.f9983A4TApA;
                }
                A4TApA2 = aRc23Z.A4TApA(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            return A5SV6n2.A2egSU(this.f3533BI9f7h, this.f3534BIYEnU, new C4FrIb.AmA8tU(i, this), amA8tU2, A4TApA2);
        } finally {
            A4TApA2.AMqCpz();
        }
    }

    public final void ARc23Z() {
        BTvldC bTvldC;
        if (Log.isLoggable("DecodeJob", 2)) {
            String str = "data: " + this.f3542C2rE4F + ", cache key: " + this.f3541BniPrB + ", fetcher: " + this.f3543C4FrIb;
            int i = ItGa5w.ASJ6gh.f4081A2egSU;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(this.f3532BChYOn);
            if (str != null) {
                ", ".concat(str);
            }
            Thread.currentThread().getName();
        }
        BPw6Q8 bPw6Q8 = null;
        try {
            bTvldC = A2egSU(this.f3543C4FrIb, this.f3542C2rE4F, this.f3550CcAIMM);
        } catch (BI9f7h e) {
            HSHyT0.AZkASS aZkASS = this.BpkvW3;
            int i2 = this.f3550CcAIMM;
            e.f3615AlLFFp = aZkASS;
            e.f3616AmA8tU = i2;
            e.f3617AzWtSf = null;
            this.f3523AlLFFp.add(e);
            bTvldC = null;
        }
        if (bTvldC == null) {
            AzWtSf();
            return;
        }
        int i3 = this.f3550CcAIMM;
        boolean z = this.f3547CQhlFr;
        if (bTvldC instanceof BIYEnU) {
            ((BIYEnU) bTvldC).initialize();
        }
        boolean z2 = true;
        if (((BPw6Q8) this.f3527B2KMhB.f241AzWtSf) != null) {
            bPw6Q8 = (BPw6Q8) BPw6Q8.f3623B25kr6.AYUAbz();
            bPw6Q8.f3627AzWtSf = false;
            bPw6Q8.f3626AmA8tU = true;
            bPw6Q8.f3625AlLFFp = bTvldC;
            bTvldC = bPw6Q8;
        }
        B2KMhB();
        B4ZgIw b4ZgIw = this.f3537BPw6Q8;
        synchronized (b4ZgIw) {
            b4ZgIw.f3588BJ7GGh = bTvldC;
            b4ZgIw.f3589BNL6CD = i3;
            b4ZgIw.f3595C2rE4F = z;
        }
        b4ZgIw.AYUAbz();
        this.f3548CSDoyG = 5;
        try {
            DUi7mC dUi7mC = this.f3527B2KMhB;
            if (((BPw6Q8) dUi7mC.f241AzWtSf) == null) {
                z2 = false;
            }
            if (z2) {
                AmA8tU amA8tU = this.f3525AzWtSf;
                HSHyT0.AmA8tU amA8tU2 = this.f3536BNL6CD;
                dUi7mC.getClass();
                try {
                    amA8tU.A2egSU().A2egSU((HSHyT0.AZkASS) dUi7mC.f239AlLFFp, new DUi7mC(9, (HSHyT0.B2KMhB) dUi7mC.f240AmA8tU, (BPw6Q8) dUi7mC.f241AzWtSf, amA8tU2));
                    ((BPw6Q8) dUi7mC.f241AzWtSf).A5SV6n();
                } catch (Throwable th) {
                    ((BPw6Q8) dUi7mC.f241AzWtSf).A5SV6n();
                    throw th;
                }
            }
            AZkASS();
        } finally {
            if (bPw6Q8 != null) {
                bPw6Q8.A5SV6n();
            }
        }
    }

    public final ASJ6gh ASJ6gh() {
        int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(this.f3548CSDoyG);
        AYUAbz aYUAbz = this.f3522AcNBzu;
        if (ADYaiT2 == 1) {
            return new BV3sI0(aYUAbz, this);
        }
        if (ADYaiT2 == 2) {
            return new ADYaiT(aYUAbz.A2egSU(), aYUAbz, this);
        }
        if (ADYaiT2 == 3) {
            return new BpkvW3(aYUAbz, this);
        }
        if (ADYaiT2 == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(CtFAbx.BIYEnU(this.f3548CSDoyG)));
    }

    public final int AYUAbz(int i) {
        int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(i);
        if (ADYaiT2 == 0) {
            if (this.f3535BJ7GGh.A4TApA()) {
                return 2;
            }
            return AYUAbz(2);
        }
        if (ADYaiT2 == 1) {
            if (this.f3535BJ7GGh.A2egSU()) {
                return 3;
            }
            return AYUAbz(3);
        }
        if (ADYaiT2 == 2) {
            return 4;
        }
        if (ADYaiT2 == 3 || ADYaiT2 == 5) {
            return 6;
        }
        throw new IllegalArgumentException("Unrecognized stage: ".concat(CtFAbx.BIYEnU(i)));
    }

    public final void AZOQYO() {
        B2KMhB();
        BI9f7h bI9f7h = new BI9f7h("Failed to load resource", new ArrayList(this.f3523AlLFFp));
        B4ZgIw b4ZgIw = this.f3537BPw6Q8;
        synchronized (b4ZgIw) {
            b4ZgIw.f3591BTvldC = bI9f7h;
        }
        b4ZgIw.ASJ6gh();
        AaHO0E();
    }

    public final void AZkASS() {
        boolean A2egSU2;
        AZOQYO azoqyo = this.f3528B3GDIM;
        synchronized (azoqyo) {
            azoqyo.f3520A4TApA = true;
            A2egSU2 = azoqyo.A2egSU();
        }
        if (A2egSU2) {
            AlLFFp();
        }
    }

    public final void AaHO0E() {
        boolean A2egSU2;
        AZOQYO azoqyo = this.f3528B3GDIM;
        synchronized (azoqyo) {
            azoqyo.f3521A5SV6n = true;
            A2egSU2 = azoqyo.A2egSU();
        }
        if (A2egSU2) {
            AlLFFp();
        }
    }

    public final void AcNBzu() {
        boolean A2egSU2;
        AZOQYO azoqyo = this.f3528B3GDIM;
        synchronized (azoqyo) {
            azoqyo.f3519A2egSU = true;
            A2egSU2 = azoqyo.A2egSU();
        }
        if (A2egSU2) {
            AlLFFp();
        }
    }

    public final void AlLFFp() {
        AZOQYO azoqyo = this.f3528B3GDIM;
        synchronized (azoqyo) {
            azoqyo.f3520A4TApA = false;
            azoqyo.f3519A2egSU = false;
            azoqyo.f3521A5SV6n = false;
        }
        DUi7mC dUi7mC = this.f3527B2KMhB;
        dUi7mC.f239AlLFFp = null;
        dUi7mC.f240AmA8tU = null;
        dUi7mC.f241AzWtSf = null;
        AYUAbz aYUAbz = this.f3522AcNBzu;
        aYUAbz.f3504A5SV6n = null;
        aYUAbz.f3505ADYaiT = null;
        aYUAbz.f3514AmA8tU = null;
        aYUAbz.f3507ASJ6gh = null;
        aYUAbz.f3511AaHO0E = null;
        aYUAbz.f3509AZOQYO = null;
        aYUAbz.f3515AzWtSf = null;
        aYUAbz.f3510AZkASS = null;
        aYUAbz.f3516B25kr6 = null;
        aYUAbz.f3502A2egSU.clear();
        aYUAbz.f3512AcNBzu = false;
        aYUAbz.f3503A4TApA.clear();
        aYUAbz.f3513AlLFFp = false;
        this.f3545CNPG0E = false;
        this.f3529B4ZgIw = null;
        this.f3530B7CMnp = null;
        this.f3536BNL6CD = null;
        this.f3531B9tovu = null;
        this.f3532BChYOn = null;
        this.f3537BPw6Q8 = null;
        this.f3548CSDoyG = 0;
        this.f3544CASmeH = null;
        this.f3540BmvVmW = null;
        this.f3541BniPrB = null;
        this.f3542C2rE4F = null;
        this.f3550CcAIMM = 0;
        this.f3543C4FrIb = null;
        this.f3546COJEAR = false;
        this.f3539BV3sI0 = null;
        this.f3523AlLFFp.clear();
        this.f3526B25kr6.B7CMnp(this);
    }

    public final void AmA8tU() {
        this.f3549CTkVKb = 2;
        B4ZgIw b4ZgIw = this.f3537BPw6Q8;
        (b4ZgIw.f3587BIYEnU ? b4ZgIw.f3583B7CMnp : b4ZgIw.f3582B4ZgIw).execute(this);
    }

    public final void AzWtSf() {
        this.f3540BmvVmW = Thread.currentThread();
        int i = ItGa5w.ASJ6gh.f4081A2egSU;
        SystemClock.elapsedRealtimeNanos();
        boolean z = false;
        while (!this.f3546COJEAR && this.f3544CASmeH != null && !(z = this.f3544CASmeH.A2egSU())) {
            this.f3548CSDoyG = AYUAbz(this.f3548CSDoyG);
            this.f3544CASmeH = ASJ6gh();
            if (this.f3548CSDoyG == 4) {
                AmA8tU();
                return;
            }
        }
        if ((this.f3548CSDoyG == 6 || this.f3546COJEAR) && !z) {
            AZOQYO();
        }
    }

    public final void B25kr6() {
        int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(this.f3549CTkVKb);
        if (ADYaiT2 == 0) {
            this.f3548CSDoyG = AYUAbz(1);
            this.f3544CASmeH = ASJ6gh();
            AzWtSf();
        } else if (ADYaiT2 == 1) {
            AzWtSf();
        } else if (ADYaiT2 == 2) {
            ARc23Z();
        } else {
            int i = this.f3549CTkVKb;
            throw new IllegalStateException("Unrecognized run reason: ".concat(i != 1 ? i != 2 ? i != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    public final void B2KMhB() {
        this.f3524AmA8tU.A2egSU();
        if (this.f3545CNPG0E) {
            throw new IllegalStateException("Already notified", this.f3523AlLFFp.isEmpty() ? null : (Throwable) CtFAbx.ADYaiT(this.f3523AlLFFp, 1));
        }
        this.f3545CNPG0E = true;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        AZkASS aZkASS = (AZkASS) obj;
        int ordinal = this.f3531B9tovu.ordinal() - aZkASS.f3531B9tovu.ordinal();
        return ordinal == 0 ? this.f3538BTvldC - aZkASS.f3538BTvldC : ordinal;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.AMqCpz aMqCpz = this.f3543C4FrIb;
        try {
            try {
                try {
                    if (this.f3546COJEAR) {
                        AZOQYO();
                        if (aMqCpz != null) {
                            aMqCpz.AMqCpz();
                            return;
                        }
                        return;
                    }
                    B25kr6();
                    if (aMqCpz != null) {
                        aMqCpz.AMqCpz();
                    }
                } catch (A5SV6n e) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.isLoggable("DecodeJob", 3);
                if (this.f3548CSDoyG != 5) {
                    this.f3523AlLFFp.add(th);
                    AZOQYO();
                }
                if (!this.f3546COJEAR) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (aMqCpz != null) {
                aMqCpz.AMqCpz();
            }
            throw th2;
        }
    }
}
