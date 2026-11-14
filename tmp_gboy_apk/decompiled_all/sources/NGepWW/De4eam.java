package NGepWW;

import AaHO0E.HHoABE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class De4eam implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final DuwtYk f5747AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f5748AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final DuwtYk f5749AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Object f5750AzWtSf;

    public De4eam(DuwtYk duwtYk, Object obj, int i) {
        this.f5748AlLFFp = i;
        this.f5749AmA8tU = duwtYk;
        this.f5747AcNBzu = duwtYk;
        this.f5750AzWtSf = obj;
    }

    public final void A2egSU() {
        Set set;
        switch (this.f5748AlLFFp) {
            case 0:
                HashMap hashMap = (HashMap) this.f5750AzWtSf;
                Iterator it = hashMap.keySet().iterator();
                boolean z = false;
                while (true) {
                    if (it.hasNext()) {
                        NSK3xo.ARc23Z aRc23Z = (NSK3xo.ARc23Z) it.next();
                        aRc23Z.getClass();
                        if (((DdagTj) hashMap.get(aRc23Z)).f5743A5SV6n == 0) {
                            z = true;
                        } else {
                            z = true;
                        }
                    }
                }
                DuwtYk duwtYk = this.f5749AmA8tU;
                int A2egSU2 = z ? duwtYk.f5756AzWtSf.A2egSU(duwtYk.f5755AmA8tU) : 0;
                if (A2egSU2 != 0) {
                    NOd7IU.A2egSU a2egSU = new NOd7IU.A2egSU(A2egSU2, null);
                    EUIRHA euirha = duwtYk.f5753AcNBzu;
                    Ddcejp ddcejp = new Ddcejp(this, duwtYk, a2egSU);
                    DG07BK.A2egSU a2egSU2 = euirha.f5815AlLFFp;
                    a2egSU2.sendMessage(a2egSU2.obtainMessage(1, ddcejp));
                    return;
                }
                if (duwtYk.f5765BIYEnU) {
                    BpkvW3 bpkvW3 = duwtYk.f5763BChYOn;
                    bpkvW3.getClass();
                    bpkvW3.f5985A4TApA = new NUY5pn.B2KMhB(bpkvW3);
                    bpkvW3.A4TApA(2, null);
                }
                for (NSK3xo.ARc23Z aRc23Z2 : hashMap.keySet()) {
                    NUY5pn.AmA8tU amA8tU = (NUY5pn.AmA8tU) hashMap.get(aRc23Z2);
                    aRc23Z2.getClass();
                    if (A2egSU2 != 0) {
                        DaOi9o daOi9o = new DaOi9o(duwtYk, amA8tU);
                        DG07BK.A2egSU a2egSU3 = duwtYk.f5753AcNBzu.f5815AlLFFp;
                        a2egSU3.sendMessage(a2egSU3.obtainMessage(1, daOi9o));
                    } else {
                        NUY5pn.BJ7GGh bJ7GGh = (NUY5pn.BJ7GGh) aRc23Z2;
                        NUY5pn.AYUAbz.A5SV6n(amA8tU, "Connection progress callbacks cannot be null.");
                        bJ7GGh.f5985A4TApA = amA8tU;
                        bJ7GGh.A4TApA(2, null);
                    }
                }
                return;
            default:
                DuwtYk duwtYk2 = this.f5749AmA8tU;
                EH1KK8 eh1kk8 = duwtYk2.f5753AcNBzu.f5809ASJ6gh;
                EUIRHA euirha2 = duwtYk2.f5753AcNBzu;
                HHoABE hHoABE = duwtYk2.f5770BV3sI0;
                if (hHoABE == null) {
                    set = Collections.EMPTY_SET;
                } else {
                    HashSet hashSet = new HashSet((Set) hHoABE.f926A2egSU);
                    Map map = (Map) hHoABE.f928A5SV6n;
                    for (NSK3xo.AYUAbz aYUAbz : map.keySet()) {
                        if (!euirha2.f5805A4TApA.containsKey(aYUAbz.A2egSU())) {
                            map.get(aYUAbz).getClass();
                            throw new ClassCastException();
                        }
                    }
                    set = hashSet;
                }
                eh1kk8.f5785B25kr6 = set;
                Iterator it2 = ((ArrayList) this.f5750AzWtSf).iterator();
                while (it2.hasNext()) {
                    ((NUY5pn.BJ7GGh) ((NSK3xo.ARc23Z) it2.next())).A5SV6n(duwtYk2.f5767BNL6CD, euirha2.f5809ASJ6gh.f5785B25kr6);
                }
                return;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        DuwtYk duwtYk = this.f5747AcNBzu;
        ReentrantLock reentrantLock = duwtYk.f5754AlLFFp;
        ReentrantLock reentrantLock2 = duwtYk.f5754AlLFFp;
        reentrantLock.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            A2egSU();
        } catch (RuntimeException e) {
            DG07BK.A2egSU a2egSU = duwtYk.f5753AcNBzu.f5815AlLFFp;
            a2egSU.sendMessage(a2egSU.obtainMessage(2, e));
        } finally {
            reentrantLock2.unlock();
        }
    }
}
