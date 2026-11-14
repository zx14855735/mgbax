package NGepWW;

import AaHO0E.HHoABE;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DuwtYk implements EPdU4G {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final EUIRHA f5753AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ReentrantLock f5754AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final RevocationBoundService f5755AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final NOd7IU.AYUAbz f5756AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public NOd7IU.A2egSU f5757B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f5758B2KMhB;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f5760B4ZgIw;

    /* renamed from: BChYOn, reason: collision with root package name */
    public BpkvW3 f5763BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f5764BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f5765BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f5766BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public NUY5pn.C4FrIb f5767BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f5768BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f5769BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final HHoABE f5770BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final QkAq4X.A4TApA f5771BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final N8uUiS.A2egSU f5772BniPrB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f5759B3GDIM = 0;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Bundle f5761B7CMnp = new Bundle();

    /* renamed from: B9tovu, reason: collision with root package name */
    public final HashSet f5762B9tovu = new HashSet();
    public final ArrayList BpkvW3 = new ArrayList();

    public DuwtYk(EUIRHA euirha, HHoABE hHoABE, QkAq4X.A4TApA a4TApA, NOd7IU.AYUAbz aYUAbz, N8uUiS.A2egSU a2egSU, ReentrantLock reentrantLock, RevocationBoundService revocationBoundService) {
        this.f5753AcNBzu = euirha;
        this.f5770BV3sI0 = hHoABE;
        this.f5771BmvVmW = a4TApA;
        this.f5756AzWtSf = aYUAbz;
        this.f5772BniPrB = a2egSU;
        this.f5754AlLFFp = reentrantLock;
        this.f5755AmA8tU = revocationBoundService;
    }

    @Override // NGepWW.EPdU4G
    public final void A2egSU(Bundle bundle) {
        if (ARc23Z(1)) {
            if (bundle != null) {
                this.f5761B7CMnp.putAll(bundle);
            }
            if (AYUAbz()) {
                AZkASS();
            }
        }
    }

    public final void A4TApA(boolean z) {
        BpkvW3 bpkvW3 = this.f5763BChYOn;
        if (bpkvW3 != null) {
            if (bpkvW3.AZOQYO() && z) {
                BpkvW3 bpkvW32 = this.f5763BChYOn;
                bpkvW32.getClass();
                try {
                    BniPrB bniPrB = (BniPrB) bpkvW32.AcNBzu();
                    int intValue = bpkvW32.f5706BPw6Q8.intValue();
                    BV3sI0 bV3sI0 = (BV3sI0) bniPrB;
                    bV3sI0.getClass();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                        obtain.writeInt(intValue);
                        bV3sI0.f5701A2egSU.transact(7, obtain, obtain2, 0);
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (RemoteException unused) {
                }
            }
            this.f5763BChYOn.AYUAbz();
            this.f5767BNL6CD = null;
        }
    }

    @Override // NGepWW.EPdU4G
    public final NCeV4Q.ASJ6gh A5SV6n(NCeV4Q.ASJ6gh aSJ6gh) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // NGepWW.EPdU4G
    public final void ADYaiT(NOd7IU.A2egSU a2egSU, NSK3xo.AYUAbz aYUAbz) {
        if (ARc23Z(1)) {
            AMqCpz(a2egSU, aYUAbz, 0);
            if (AYUAbz()) {
                AZkASS();
            }
        }
    }

    public final void AMqCpz(NOd7IU.A2egSU a2egSU, NSK3xo.AYUAbz aYUAbz, int i) {
        if (i != 2) {
            aYUAbz.f5929A2egSU.getClass();
            if ((i != 1 || a2egSU.A4TApA() || this.f5756AzWtSf.A5SV6n(a2egSU.f5854AlLFFp) != null) && (this.f5757B25kr6 == null || Integer.MAX_VALUE < this.f5758B2KMhB)) {
                this.f5757B25kr6 = a2egSU;
                this.f5758B2KMhB = Integer.MAX_VALUE;
            }
        }
        this.f5753AcNBzu.f5805A4TApA.put(aYUAbz.A2egSU(), a2egSU);
    }

    public final boolean ARc23Z(int i) {
        if (this.f5759B3GDIM == i) {
            return true;
        }
        EH1KK8 eh1kk8 = this.f5753AcNBzu.f5809ASJ6gh;
        eh1kk8.getClass();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.append((CharSequence) "").append((CharSequence) "mContext=").println(eh1kk8.f5794BJ7GGh);
        printWriter.append((CharSequence) "").append((CharSequence) "mResuming=").print(eh1kk8.f5796BPw6Q8);
        printWriter.append((CharSequence) " mWorkQueue.size()=").print(eh1kk8.f5782AlLFFp.size());
        ARc23Z aRc23Z = eh1kk8.f5789B7CMnp;
        aRc23Z.getClass();
        printWriter.append((CharSequence) " mUnconsumedApiCalls.size()=").println(aRc23Z.f5681A2egSU.size());
        EwN40Z ewN40Z = eh1kk8.f5792BI9f7h;
        if (ewN40Z != null) {
            ewN40Z.AMqCpz("", null, printWriter, null);
        }
        stringWriter.toString();
        new StringBuilder(String.valueOf(this).length() + 23);
        int i2 = this.f5759B3GDIM;
        String str = i2 != 0 ? i2 != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
        String str2 = i != 0 ? i != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
        Log.wtf("GoogleApiClientConnecting", com.bykv.vk.component.ttvideo.player.A2egSU.AzWtSf(new StringBuilder(str2.length() + str.length() + 70), "GoogleApiClient connecting is in step ", str, " but received callback for step ", str2), new Exception());
        ASJ6gh(new NOd7IU.A2egSU(8, null));
        return false;
    }

    public final void ASJ6gh(NOd7IU.A2egSU a2egSU) {
        ArrayList arrayList = this.BpkvW3;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        arrayList.clear();
        A4TApA(!a2egSU.A4TApA());
        EUIRHA euirha = this.f5753AcNBzu;
        euirha.ARc23Z(a2egSU);
        euirha.f5810AYUAbz.A4TApA(a2egSU);
    }

    public final boolean AYUAbz() {
        NOd7IU.A2egSU a2egSU;
        int i = this.f5760B4ZgIw - 1;
        this.f5760B4ZgIw = i;
        if (i > 0) {
            return false;
        }
        EUIRHA euirha = this.f5753AcNBzu;
        if (i < 0) {
            EH1KK8 eh1kk8 = euirha.f5809ASJ6gh;
            eh1kk8.getClass();
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.append((CharSequence) "").append((CharSequence) "mContext=").println(eh1kk8.f5794BJ7GGh);
            printWriter.append((CharSequence) "").append((CharSequence) "mResuming=").print(eh1kk8.f5796BPw6Q8);
            printWriter.append((CharSequence) " mWorkQueue.size()=").print(eh1kk8.f5782AlLFFp.size());
            ARc23Z aRc23Z = eh1kk8.f5789B7CMnp;
            aRc23Z.getClass();
            printWriter.append((CharSequence) " mUnconsumedApiCalls.size()=").println(aRc23Z.f5681A2egSU.size());
            EwN40Z ewN40Z = eh1kk8.f5792BI9f7h;
            if (ewN40Z != null) {
                ewN40Z.AMqCpz("", null, printWriter, null);
            }
            stringWriter.toString();
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            a2egSU = new NOd7IU.A2egSU(8, null);
        } else {
            a2egSU = this.f5757B25kr6;
            if (a2egSU == null) {
                return true;
            }
            euirha.f5808ARc23Z = this.f5758B2KMhB;
        }
        ASJ6gh(a2egSU);
        return false;
    }

    public final void AZOQYO() {
        if (this.f5760B4ZgIw != 0) {
            return;
        }
        if (!this.f5765BIYEnU || this.f5766BJ7GGh) {
            ArrayList arrayList = new ArrayList();
            this.f5759B3GDIM = 1;
            EUIRHA euirha = this.f5753AcNBzu;
            QkAq4X.A4TApA a4TApA = euirha.f5804A2egSU;
            this.f5760B4ZgIw = a4TApA.f7752AmA8tU;
            for (NSK3xo.ADYaiT aDYaiT : a4TApA.keySet()) {
                if (!euirha.f5805A4TApA.containsKey(aDYaiT)) {
                    arrayList.add((NSK3xo.ARc23Z) a4TApA.get(aDYaiT));
                } else if (AYUAbz()) {
                    AZkASS();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.BpkvW3.add(EY4UKY.f5818A2egSU.submit(new De4eam(this, arrayList, 1)));
        }
    }

    public final void AZkASS() {
        EUIRHA euirha = this.f5753AcNBzu;
        euirha.f5811AZOQYO.lock();
        try {
            euirha.f5809ASJ6gh.AmA8tU();
            euirha.f5816AmA8tU = new DcUJf1(euirha);
            euirha.f5816AmA8tU.a();
            euirha.f5812AZkASS.signalAll();
            euirha.f5811AZOQYO.unlock();
            EY4UKY.f5818A2egSU.execute(new LLYwnm.AMqCpz(19, this));
            BpkvW3 bpkvW3 = this.f5763BChYOn;
            if (bpkvW3 != null) {
                if (this.f5768BPw6Q8) {
                    try {
                        ((BV3sI0) ((BniPrB) bpkvW3.AcNBzu())).A4TApA(this.f5767BNL6CD, bpkvW3.f5706BPw6Q8.intValue(), this.f5769BTvldC);
                    } catch (RemoteException unused) {
                    }
                }
                A4TApA(false);
            }
            Iterator it = this.f5753AcNBzu.f5805A4TApA.keySet().iterator();
            while (it.hasNext()) {
                ((NUY5pn.BJ7GGh) ((NSK3xo.ARc23Z) this.f5753AcNBzu.f5804A2egSU.get((NSK3xo.ADYaiT) it.next()))).AYUAbz();
            }
            this.f5753AcNBzu.f5810AYUAbz.A2egSU(this.f5761B7CMnp.isEmpty() ? null : this.f5761B7CMnp);
        } catch (Throwable th) {
            euirha.f5811AZOQYO.unlock();
            throw th;
        }
    }

    public final void AaHO0E() {
        this.f5765BIYEnU = false;
        EUIRHA euirha = this.f5753AcNBzu;
        euirha.f5809ASJ6gh.f5785B25kr6 = Collections.EMPTY_SET;
        Iterator it = this.f5762B9tovu.iterator();
        while (it.hasNext()) {
            NSK3xo.ADYaiT aDYaiT = (NSK3xo.ADYaiT) it.next();
            HashMap hashMap = euirha.f5805A4TApA;
            if (!hashMap.containsKey(aDYaiT)) {
                hashMap.put(aDYaiT, new NOd7IU.A2egSU(17, null));
            }
        }
    }

    @Override // NGepWW.EPdU4G
    public final void a() {
        QkAq4X.A4TApA a4TApA;
        EUIRHA euirha = this.f5753AcNBzu;
        euirha.f5805A4TApA.clear();
        this.f5765BIYEnU = false;
        this.f5757B25kr6 = null;
        this.f5759B3GDIM = 0;
        this.f5764BI9f7h = 2;
        this.f5766BJ7GGh = false;
        this.f5768BPw6Q8 = false;
        HashMap hashMap = new HashMap();
        QkAq4X.A4TApA a4TApA2 = this.f5771BmvVmW;
        Iterator it = a4TApA2.keySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            a4TApA = euirha.f5804A2egSU;
            if (!hasNext) {
                break;
            }
            NSK3xo.AYUAbz aYUAbz = (NSK3xo.AYUAbz) it.next();
            NSK3xo.ARc23Z aRc23Z = (NSK3xo.ARc23Z) a4TApA.get(aYUAbz.A2egSU());
            int intValue = ((Integer) a4TApA2.get(aYUAbz)).intValue();
            aYUAbz.f5929A2egSU.getClass();
            if (aRc23Z.i()) {
                this.f5765BIYEnU = true;
                if (intValue < this.f5764BI9f7h) {
                    this.f5764BI9f7h = intValue;
                }
                if (intValue != 0) {
                    this.f5762B9tovu.add(aYUAbz.A2egSU());
                }
            }
            hashMap.put(aRc23Z, new DdagTj(this, aYUAbz, intValue));
        }
        if (this.f5765BIYEnU) {
            EH1KK8 eh1kk8 = euirha.f5809ASJ6gh;
            eh1kk8.getClass();
            Integer valueOf = Integer.valueOf(System.identityHashCode(eh1kk8));
            HHoABE hHoABE = this.f5770BV3sI0;
            hHoABE.f931ASJ6gh = valueOf;
            Dphsd2 dphsd2 = new Dphsd2(this);
            this.f5763BChYOn = (BpkvW3) this.f5772BniPrB.A4TApA(this.f5755AmA8tU, eh1kk8.f5795BNL6CD, hHoABE, (BI9f7h) hHoABE.f930ARc23Z, dphsd2, dphsd2);
        }
        this.f5760B4ZgIw = a4TApA.f7752AmA8tU;
        this.BpkvW3.add(EY4UKY.f5818A2egSU.submit(new De4eam(this, hashMap, 0)));
    }

    @Override // NGepWW.EPdU4G
    public final boolean b() {
        ArrayList arrayList = this.BpkvW3;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        arrayList.clear();
        A4TApA(true);
        this.f5753AcNBzu.ARc23Z(null);
        return true;
    }

    @Override // NGepWW.EPdU4G
    public final void c() {
    }

    @Override // NGepWW.EPdU4G
    public final void a(int i) {
        ASJ6gh(new NOd7IU.A2egSU(8, null));
    }
}
