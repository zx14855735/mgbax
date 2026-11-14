package NUY5pn;

import AaHO0E.HHoABE;
import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BJ7GGh implements NSK3xo.ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DG07BK.A2egSU f5984A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public AmA8tU f5985A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AtomicInteger f5986A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f5987ADYaiT;
    public long AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public long f5988ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f5989ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public long f5990AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final Context f5991AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final BniPrB f5992AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final Object f5993AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Object f5994AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ASJ6gh f5995AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public IInterface f5996AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f5997AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public B25kr6 f5998B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f5999B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final NGepWW.A2egSU f6000B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final IQ76hF.AmA8tU f6001B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final int f6002B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final String f6003B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final HHoABE f6004BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final Set f6005BI9f7h;

    public BJ7GGh(Context context, Looper looper, int i, HHoABE hHoABE, NSK3xo.AZkASS aZkASS, NSK3xo.AaHO0E aaHO0E) {
        synchronized (BPw6Q8.f6015AcNBzu) {
            try {
                if (BPw6Q8.f6016AlLFFp == null) {
                    BPw6Q8.f6016AlLFFp = new BniPrB(context.getApplicationContext());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        BniPrB bniPrB = BPw6Q8.f6016AlLFFp;
        NOd7IU.ADYaiT aDYaiT = NOd7IU.ADYaiT.f5861A4TApA;
        AYUAbz.A4TApA(aZkASS);
        AYUAbz.A4TApA(aaHO0E);
        NGepWW.A2egSU a2egSU = new NGepWW.A2egSU(2, aZkASS);
        IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(19, aaHO0E);
        String str = (String) hHoABE.AMqCpz;
        this.f5993AaHO0E = new Object();
        this.f5994AcNBzu = new Object();
        this.f5997AzWtSf = new ArrayList();
        this.f5999B2KMhB = 1;
        this.f5986A5SV6n = new AtomicInteger(0);
        AYUAbz.A5SV6n(context, "Context must not be null");
        this.f5991AZOQYO = context;
        AYUAbz.A5SV6n(looper, "Looper must not be null");
        AYUAbz.A5SV6n(bniPrB, "Supervisor must not be null");
        this.f5992AZkASS = bniPrB;
        this.f5984A2egSU = new DG07BK.A2egSU(this, looper, 11);
        this.f6002B7CMnp = i;
        this.f6000B3GDIM = a2egSU;
        this.f6001B4ZgIw = amA8tU;
        this.f6003B9tovu = str;
        this.f6004BChYOn = hHoABE;
        Set set = (Set) hHoABE.f927A4TApA;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((NSK3xo.A2egSU) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f6005BI9f7h = set;
    }

    public static boolean ADYaiT(BJ7GGh bJ7GGh, int i, int i2, IInterface iInterface) {
        synchronized (bJ7GGh.f5993AaHO0E) {
            try {
                if (bJ7GGh.f5999B2KMhB != i) {
                    return false;
                }
                bJ7GGh.A4TApA(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract String A2egSU();

    public final void A4TApA(int i, IInterface iInterface) {
        if ((i == 3) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f5993AaHO0E) {
            try {
                this.f5999B2KMhB = i;
                this.f5996AmA8tU = iInterface;
                if (i != 1) {
                    if (i == 2) {
                        ASJ6gh();
                    } else if (i == 3) {
                        this.f5988ARc23Z = System.currentTimeMillis();
                    }
                } else if (this.f5998B25kr6 != null) {
                    String A2egSU2 = A2egSU();
                    B25kr6 b25kr6 = this.f5998B25kr6;
                    if (this.f6003B9tovu == null) {
                        this.f5991AZOQYO.getClass();
                    }
                    this.f5992AZkASS.A2egSU(A2egSU2, b25kr6);
                    this.f5998B25kr6 = null;
                }
            } finally {
            }
        }
    }

    public final void A5SV6n(C4FrIb c4FrIb, Set set) {
        Bundle AaHO0E2 = AaHO0E();
        BI9f7h bI9f7h = new BI9f7h(this.f6002B7CMnp);
        bI9f7h.f5978AzWtSf = this.f5991AZOQYO.getPackageName();
        bI9f7h.f5981B3GDIM = AaHO0E2;
        if (set != null) {
            bI9f7h.f5980B2KMhB = (NSK3xo.A2egSU[]) set.toArray(new NSK3xo.A2egSU[set.size()]);
        }
        if (i()) {
            bI9f7h.f5982B4ZgIw = new Account("<<default account>>", "com.google");
            if (c4FrIb != null) {
                bI9f7h.f5979B25kr6 = ((C2rE4F) c4FrIb).f6033A2egSU;
            }
        }
        try {
            synchronized (this.f5994AcNBzu) {
                try {
                    ASJ6gh aSJ6gh = this.f5995AlLFFp;
                    if (aSJ6gh != null) {
                        ((AMqCpz) aSJ6gh).A2egSU(new AzWtSf(this, this.f5986A5SV6n.get()), bI9f7h);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException unused) {
            DG07BK.A2egSU a2egSU = this.f5984A2egSU;
            a2egSU.sendMessage(a2egSU.obtainMessage(4, this.f5986A5SV6n.get(), 1));
        } catch (RemoteException unused2) {
        } catch (SecurityException e) {
            throw e;
        } catch (RuntimeException unused3) {
            NOd7IU.A2egSU a2egSU2 = new NOd7IU.A2egSU(1, 8, null, "IGmsServiceBroker.getService failed.");
            int i = this.f5986A5SV6n.get();
            PendingIntent pendingIntent = a2egSU2.f5855AmA8tU;
            DG07BK.A2egSU a2egSU3 = this.f5984A2egSU;
            a2egSU3.sendMessage(a2egSU3.obtainMessage(3, i, a2egSU2.f5854AlLFFp, pendingIntent));
        }
    }

    public abstract IInterface AMqCpz(IBinder iBinder);

    public abstract String ARc23Z();

    public final void ASJ6gh() {
        boolean z;
        B25kr6 b25kr6 = this.f5998B25kr6;
        BniPrB bniPrB = this.f5992AZkASS;
        AtomicInteger atomicInteger = this.f5986A5SV6n;
        if (b25kr6 != null) {
            new StringBuilder(A2egSU().length() + 92);
            String A2egSU2 = A2egSU();
            B25kr6 b25kr62 = this.f5998B25kr6;
            if (this.f6003B9tovu == null) {
                this.f5991AZOQYO.getClass();
            }
            bniPrB.A2egSU(A2egSU2, b25kr62);
            atomicInteger.incrementAndGet();
        }
        this.f5998B25kr6 = new B25kr6(this, atomicInteger.get());
        String A2egSU3 = A2egSU();
        B25kr6 b25kr63 = this.f5998B25kr6;
        if (this.f6003B9tovu == null) {
            this.f5991AZOQYO.getClass();
        }
        bniPrB.getClass();
        BTvldC bTvldC = new BTvldC(A2egSU3);
        AYUAbz.A5SV6n(b25kr63, "ServiceConnection must not be null");
        synchronized (bniPrB.f6027AmA8tU) {
            try {
                BmvVmW bmvVmW = (BmvVmW) bniPrB.f6027AmA8tU.get(bTvldC);
                if (bmvVmW == null) {
                    bmvVmW = new BmvVmW(bniPrB, bTvldC);
                    NRGvz2.A2egSU a2egSU = bniPrB.f6030B2KMhB;
                    String str = bTvldC.f6017A2egSU;
                    if (str != null) {
                        new Intent(str).setPackage(bTvldC.f6018A4TApA);
                    } else {
                        new Intent().setComponent(null);
                    }
                    a2egSU.getClass();
                    bmvVmW.f6022A5SV6n.add(b25kr63);
                    bmvVmW.A2egSU();
                    bniPrB.f6027AmA8tU.put(bTvldC, bmvVmW);
                } else {
                    bniPrB.f6029B25kr6.removeMessages(0, bTvldC);
                    if (bmvVmW.f6022A5SV6n.contains(b25kr63)) {
                        String valueOf = String.valueOf(bTvldC);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(valueOf);
                        throw new IllegalStateException(sb.toString());
                    }
                    NRGvz2.A2egSU a2egSU2 = bmvVmW.f6020A2egSU.f6030B2KMhB;
                    BTvldC bTvldC2 = bmvVmW.f6025ASJ6gh;
                    String str2 = bTvldC2.f6017A2egSU;
                    if (str2 != null) {
                        new Intent(str2).setPackage(bTvldC2.f6018A4TApA);
                    } else {
                        new Intent().setComponent(null);
                    }
                    a2egSU2.getClass();
                    bmvVmW.f6022A5SV6n.add(b25kr63);
                    int i = bmvVmW.f6023ADYaiT;
                    if (i == 1) {
                        b25kr63.onServiceConnected(bmvVmW.f6026AYUAbz, bmvVmW.f6024ARc23Z);
                    } else if (i == 2) {
                        bmvVmW.A2egSU();
                    }
                }
                z = bmvVmW.AMqCpz;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            return;
        }
        new StringBuilder(A2egSU().length() + 56);
        int i2 = atomicInteger.get();
        B4ZgIw b4ZgIw = new B4ZgIw(this, 16);
        DG07BK.A2egSU a2egSU3 = this.f5984A2egSU;
        a2egSU3.sendMessage(a2egSU3.obtainMessage(5, i2, -1, b4ZgIw));
    }

    public final void AYUAbz() {
        this.f5986A5SV6n.incrementAndGet();
        synchronized (this.f5997AzWtSf) {
            try {
                int size = this.f5997AzWtSf.size();
                for (int i = 0; i < size; i++) {
                    ((AlLFFp) this.f5997AzWtSf.get(i)).ADYaiT();
                }
                this.f5997AzWtSf.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f5994AcNBzu) {
            this.f5995AlLFFp = null;
        }
        A4TApA(1, null);
    }

    public final boolean AZOQYO() {
        boolean z;
        synchronized (this.f5993AaHO0E) {
            z = this.f5999B2KMhB == 3;
        }
        return z;
    }

    public final boolean AZkASS() {
        boolean z;
        synchronized (this.f5993AaHO0E) {
            z = this.f5999B2KMhB == 2;
        }
        return z;
    }

    public Bundle AaHO0E() {
        return new Bundle();
    }

    public final IInterface AcNBzu() {
        IInterface iInterface;
        synchronized (this.f5993AaHO0E) {
            try {
                if (this.f5999B2KMhB == 4) {
                    throw new DeadObjectException();
                }
                if (!AZOQYO()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                AYUAbz.AMqCpz(this.f5996AmA8tU != null, "Client is connected but service is null");
                iInterface = this.f5996AmA8tU;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    @Override // NSK3xo.ARc23Z
    public Intent d() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @Override // NSK3xo.ARc23Z
    public boolean i() {
        return false;
    }
}
