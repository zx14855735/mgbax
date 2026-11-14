package HXc4pW;

import ADYaiT.DUi7mC;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw implements Ixu71n.A4TApA {

    /* renamed from: C4FrIb, reason: collision with root package name */
    public static final ADYaiT.BmvVmW f3574C4FrIb = new ADYaiT.BmvVmW(26);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B3GDIM f3575AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Ixu71n.ADYaiT f3576AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AzWtSf f3577AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final DUi7mC f3578AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ADYaiT.BmvVmW f3579B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final AzWtSf f3580B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final HieBYM.A5SV6n f3581B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final HieBYM.A5SV6n f3582B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final HieBYM.A5SV6n f3583B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final AtomicInteger f3584B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public B7CMnp f3585BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f3586BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f3587BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public BTvldC f3588BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f3589BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f3590BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public BI9f7h f3591BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f3592BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public B9tovu f3593BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public AZkASS f3594BniPrB;
    public volatile boolean BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f3595C2rE4F;

    static {
        VQNeL();
    }

    public B4ZgIw(HieBYM.A5SV6n a5SV6n, HieBYM.A5SV6n a5SV6n2, HieBYM.A5SV6n a5SV6n3, HieBYM.A5SV6n a5SV6n4, AzWtSf azWtSf, AzWtSf azWtSf2, DUi7mC dUi7mC) {
        ADYaiT.BmvVmW bmvVmW = f3574C4FrIb;
        this.f3575AcNBzu = new B3GDIM(new ArrayList(2));
        this.f3576AlLFFp = new Ixu71n.ADYaiT();
        this.f3584B9tovu = new AtomicInteger();
        this.f3581B3GDIM = a5SV6n;
        this.f3582B4ZgIw = a5SV6n2;
        this.f3583B7CMnp = a5SV6n4;
        this.f3580B2KMhB = azWtSf;
        this.f3577AmA8tU = azWtSf2;
        this.f3578AzWtSf = dUi7mC;
        this.f3579B25kr6 = bmvVmW;
    }

    private static /* synthetic */ void VQNeL() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized void A2egSU(IhMMDv.ASJ6gh aSJ6gh, Executor executor) {
        try {
            this.f3576AlLFFp.A2egSU();
            B3GDIM b3gdim = this.f3575AcNBzu;
            b3gdim.getClass();
            b3gdim.f3573AcNBzu.add(new B2KMhB(aSJ6gh, executor));
            if (this.f3590BPw6Q8) {
                AMqCpz(1);
                executor.execute(new B25kr6(this, aSJ6gh, 1));
            } else if (this.f3592BV3sI0) {
                AMqCpz(1);
                executor.execute(new B25kr6(this, aSJ6gh, 0));
            } else {
                ItGa5w.ARc23Z.A2egSU(!this.BpkvW3, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void A4TApA() {
        if (ARc23Z()) {
            return;
        }
        this.BpkvW3 = true;
        AZkASS aZkASS = this.f3594BniPrB;
        aZkASS.f3546COJEAR = true;
        ASJ6gh aSJ6gh = aZkASS.f3544CASmeH;
        if (aSJ6gh != null) {
            aSJ6gh.cancel();
        }
        AzWtSf azWtSf = this.f3580B2KMhB;
        B7CMnp b7CMnp = this.f3585BChYOn;
        synchronized (azWtSf) {
            BJ7GGh bJ7GGh = azWtSf.f3562A2egSU;
            bJ7GGh.getClass();
            HashMap hashMap = bJ7GGh.f3619A2egSU;
            if (equals(hashMap.get(b7CMnp))) {
                hashMap.remove(b7CMnp);
            }
        }
    }

    public final void A5SV6n() {
        B9tovu b9tovu;
        synchronized (this) {
            try {
                this.f3576AlLFFp.A2egSU();
                ItGa5w.ARc23Z.A2egSU(ARc23Z(), "Not yet complete!");
                int decrementAndGet = this.f3584B9tovu.decrementAndGet();
                ItGa5w.ARc23Z.A2egSU(decrementAndGet >= 0, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    b9tovu = this.f3593BmvVmW;
                    AZOQYO();
                } else {
                    b9tovu = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (b9tovu != null) {
            b9tovu.ADYaiT();
        }
    }

    @Override // Ixu71n.A4TApA
    public final Ixu71n.ADYaiT ADYaiT() {
        return this.f3576AlLFFp;
    }

    public final synchronized void AMqCpz(int i) {
        B9tovu b9tovu;
        ItGa5w.ARc23Z.A2egSU(ARc23Z(), "Not yet complete!");
        if (this.f3584B9tovu.getAndAdd(i) == 0 && (b9tovu = this.f3593BmvVmW) != null) {
            b9tovu.A5SV6n();
        }
    }

    public final boolean ARc23Z() {
        return this.f3592BV3sI0 || this.f3590BPw6Q8 || this.BpkvW3;
    }

    public final void ASJ6gh() {
        synchronized (this) {
            try {
                this.f3576AlLFFp.A2egSU();
                if (this.BpkvW3) {
                    AZOQYO();
                    return;
                }
                if (this.f3575AcNBzu.f3573AcNBzu.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f3592BV3sI0) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f3592BV3sI0 = true;
                B7CMnp b7CMnp = this.f3585BChYOn;
                B3GDIM b3gdim = this.f3575AcNBzu;
                b3gdim.getClass();
                ArrayList arrayList = new ArrayList(b3gdim.f3573AcNBzu);
                AMqCpz(arrayList.size() + 1);
                this.f3580B2KMhB.ADYaiT(this, b7CMnp, null);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    B2KMhB b2KMhB = (B2KMhB) it.next();
                    b2KMhB.f3572A4TApA.execute(new B25kr6(this, b2KMhB.f3571A2egSU, 0));
                }
                A5SV6n();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AYUAbz() {
        synchronized (this) {
            try {
                this.f3576AlLFFp.A2egSU();
                if (this.BpkvW3) {
                    this.f3588BJ7GGh.A2egSU();
                    AZOQYO();
                    return;
                }
                if (this.f3575AcNBzu.f3573AcNBzu.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f3590BPw6Q8) {
                    throw new IllegalStateException("Already have resource");
                }
                ADYaiT.BmvVmW bmvVmW = this.f3579B25kr6;
                BTvldC bTvldC = this.f3588BJ7GGh;
                boolean z = this.f3586BI9f7h;
                B7CMnp b7CMnp = this.f3585BChYOn;
                AzWtSf azWtSf = this.f3577AmA8tU;
                bmvVmW.getClass();
                this.f3593BmvVmW = new B9tovu(bTvldC, z, true, b7CMnp, azWtSf);
                this.f3590BPw6Q8 = true;
                B3GDIM b3gdim = this.f3575AcNBzu;
                b3gdim.getClass();
                ArrayList arrayList = new ArrayList(b3gdim.f3573AcNBzu);
                AMqCpz(arrayList.size() + 1);
                this.f3580B2KMhB.ADYaiT(this, this.f3585BChYOn, this.f3593BmvVmW);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    B2KMhB b2KMhB = (B2KMhB) it.next();
                    b2KMhB.f3572A4TApA.execute(new B25kr6(this, b2KMhB.f3571A2egSU, 1));
                }
                A5SV6n();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void AZOQYO() {
        if (this.f3585BChYOn == null) {
            throw new IllegalArgumentException();
        }
        this.f3575AcNBzu.f3573AcNBzu.clear();
        this.f3585BChYOn = null;
        this.f3593BmvVmW = null;
        this.f3588BJ7GGh = null;
        this.f3592BV3sI0 = false;
        this.BpkvW3 = false;
        this.f3590BPw6Q8 = false;
        this.f3595C2rE4F = false;
        this.f3594BniPrB.AcNBzu();
        this.f3594BniPrB = null;
        this.f3591BTvldC = null;
        this.f3589BNL6CD = 0;
        this.f3578AzWtSf.B7CMnp(this);
    }

    public final synchronized void AZkASS(IhMMDv.ASJ6gh aSJ6gh) {
        try {
            this.f3576AlLFFp.A2egSU();
            B3GDIM b3gdim = this.f3575AcNBzu;
            b3gdim.f3573AcNBzu.remove(new B2KMhB(aSJ6gh, ItGa5w.ARc23Z.f4080A4TApA));
            if (this.f3575AcNBzu.f3573AcNBzu.isEmpty()) {
                A4TApA();
                if (!this.f3590BPw6Q8) {
                    if (this.f3592BV3sI0) {
                    }
                }
                if (this.f3584B9tovu.get() == 0) {
                    AZOQYO();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void AaHO0E(AZkASS aZkASS) {
        HieBYM.A5SV6n a5SV6n;
        this.f3594BniPrB = aZkASS;
        int AYUAbz2 = aZkASS.AYUAbz(1);
        if (AYUAbz2 != 2 && AYUAbz2 != 3) {
            a5SV6n = this.f3587BIYEnU ? this.f3583B7CMnp : this.f3582B4ZgIw;
            a5SV6n.execute(aZkASS);
        }
        a5SV6n = this.f3581B3GDIM;
        a5SV6n.execute(aZkASS);
    }
}
