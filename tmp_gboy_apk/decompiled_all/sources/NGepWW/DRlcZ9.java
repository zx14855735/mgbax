package NGepWW;

import android.os.Looper;
import android.util.Pair;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class DRlcZ9 extends NSK3xo.AlLFFp {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final DAk1zC f5722AlLFFp = new DAk1zC(0);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DG07BK f5723A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final WeakReference f5724A4TApA;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ECyGFg f5727ARc23Z;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public NSK3xo.AmA8tU f5729AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public volatile boolean f5730AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public boolean f5731AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean f5732AaHO0E;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f5725A5SV6n = new Object();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final CountDownLatch f5726ADYaiT = new CountDownLatch(1);
    public final ArrayList AMqCpz = new ArrayList();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final AtomicReference f5728ASJ6gh = new AtomicReference();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f5733AcNBzu = false;

    static {
        mrJQ();
    }

    public DRlcZ9(NSK3xo.AcNBzu acNBzu) {
        this.f5723A2egSU = new DG07BK(acNBzu != null ? acNBzu.AMqCpz() : Looper.getMainLooper());
        this.f5724A4TApA = new WeakReference(acNBzu);
    }

    private static /* synthetic */ void mrJQ() {
        char[] charArray = ">20s:<08s?2$s.5811s\u001734\u001f/49:8".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ']');
        }
        String str = new String(charArray);
        char[] charArray2 = ">1434)".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ']');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(NSK3xo.AmA8tU amA8tU) {
        synchronized (this.f5725A5SV6n) {
            if (!this.f5732AaHO0E && !this.f5731AZkASS) {
                ARc23Z();
                NUY5pn.AYUAbz.AMqCpz(!ARc23Z(), "Results have already been set");
                NUY5pn.AYUAbz.AMqCpz(!this.f5730AZOQYO, "Result has already been consumed");
                ADYaiT(amA8tU);
            }
        }
    }

    public abstract NSK3xo.A4TApA A4TApA(NSK3xo.A4TApA a4TApA);

    public final NSK3xo.AmA8tU A5SV6n() {
        NSK3xo.AmA8tU amA8tU;
        synchronized (this.f5725A5SV6n) {
            NUY5pn.AYUAbz.AMqCpz(!this.f5730AZOQYO, "Result has already been consumed.");
            NUY5pn.AYUAbz.AMqCpz(ARc23Z(), "Result is not ready.");
            amA8tU = this.f5729AYUAbz;
            this.f5729AYUAbz = null;
            this.f5727ARc23Z = null;
            this.f5730AZOQYO = true;
        }
        AMqCpz aMqCpz = (AMqCpz) this.f5728ASJ6gh.getAndSet(null);
        if (aMqCpz != null) {
            aMqCpz.f5678A2egSU.f5681A2egSU.remove(this);
        }
        return amA8tU;
    }

    public final void ADYaiT(NSK3xo.AmA8tU amA8tU) {
        this.f5729AYUAbz = amA8tU;
        this.f5726ADYaiT.countDown();
        this.f5729AYUAbz.a();
        if (this.f5731AZkASS) {
            this.f5727ARc23Z = null;
        } else if (this.f5727ARc23Z != null) {
            DG07BK dg07bk = this.f5723A2egSU;
            dg07bk.removeMessages(2);
            dg07bk.sendMessage(dg07bk.obtainMessage(1, new Pair(this.f5727ARc23Z, A5SV6n())));
        }
        ArrayList arrayList = this.AMqCpz;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            ((DXnQ0V) it.next()).getClass();
            throw null;
        }
        arrayList.clear();
    }

    public final void AMqCpz(NSK3xo.A4TApA a4TApA) {
        synchronized (this.f5725A5SV6n) {
            try {
                if (!ARc23Z()) {
                    A2egSU(A4TApA(a4TApA));
                    this.f5732AaHO0E = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean ARc23Z() {
        return this.f5726ADYaiT.getCount() == 0;
    }

    public final void ASJ6gh() {
        synchronized (this.f5725A5SV6n) {
            if (!this.f5731AZkASS && !this.f5730AZOQYO) {
                this.f5731AZkASS = true;
                ADYaiT(A4TApA(NSK3xo.A4TApA.f5924B4ZgIw));
            }
        }
    }

    public final boolean AYUAbz() {
        boolean z;
        synchronized (this.f5725A5SV6n) {
            z = this.f5731AZkASS;
        }
        return z;
    }

    public final void AZOQYO() {
        this.f5733AcNBzu = this.f5733AcNBzu || ((Boolean) f5722AlLFFp.get()).booleanValue();
    }
}
