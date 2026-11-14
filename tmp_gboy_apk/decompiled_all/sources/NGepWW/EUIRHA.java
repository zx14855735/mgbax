package NGepWW;

import AaHO0E.HHoABE;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class EUIRHA implements DV2E8K, EwN40Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final QkAq4X.A4TApA f5804A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HHoABE f5806A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final QkAq4X.A4TApA f5807ADYaiT;
    public final N8uUiS.A2egSU AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f5808ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final EH1KK8 f5809ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final EsrwYR f5810AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ReentrantLock f5811AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Condition f5812AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final RevocationBoundService f5813AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final NOd7IU.AYUAbz f5814AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DG07BK.A2egSU f5815AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public volatile EPdU4G f5816AmA8tU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f5805A4TApA = new HashMap();

    /* renamed from: AzWtSf, reason: collision with root package name */
    public NOd7IU.A2egSU f5817AzWtSf = null;

    public EUIRHA(RevocationBoundService revocationBoundService, EH1KK8 eh1kk8, ReentrantLock reentrantLock, Looper looper, NOd7IU.AYUAbz aYUAbz, QkAq4X.A4TApA a4TApA, HHoABE hHoABE, QkAq4X.A4TApA a4TApA2, N8uUiS.A2egSU a2egSU, ArrayList arrayList, EsrwYR esrwYR) {
        this.f5813AaHO0E = revocationBoundService;
        this.f5811AZOQYO = reentrantLock;
        this.f5814AcNBzu = aYUAbz;
        this.f5804A2egSU = a4TApA;
        this.f5806A5SV6n = hHoABE;
        this.f5807ADYaiT = a4TApA2;
        this.AMqCpz = a2egSU;
        this.f5809ASJ6gh = eh1kk8;
        this.f5810AYUAbz = esrwYR;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((DUi7mC) it.next()).f5735A4TApA = this;
        }
        this.f5815AlLFFp = new DG07BK.A2egSU(this, looper, 10);
        this.f5812AZkASS = reentrantLock.newCondition();
        this.f5816AmA8tU = new A2egSU(1, this);
    }

    @Override // NSK3xo.AZkASS
    public final void A2egSU(Bundle bundle) {
        this.f5811AZOQYO.lock();
        try {
            this.f5816AmA8tU.A2egSU(bundle);
        } finally {
            this.f5811AZOQYO.unlock();
        }
    }

    @Override // NGepWW.EwN40Z
    public final boolean A4TApA(NCeV4Q.A5SV6n a5SV6n) {
        return false;
    }

    @Override // NGepWW.EwN40Z
    public final NCeV4Q.ASJ6gh A5SV6n(NCeV4Q.ASJ6gh aSJ6gh) {
        aSJ6gh.AZOQYO();
        return this.f5816AmA8tU.A5SV6n(aSJ6gh);
    }

    @Override // NGepWW.DV2E8K
    public final void ADYaiT(NOd7IU.A2egSU a2egSU, NSK3xo.AYUAbz aYUAbz) {
        this.f5811AZOQYO.lock();
        try {
            this.f5816AmA8tU.ADYaiT(a2egSU, aYUAbz);
        } finally {
            this.f5811AZOQYO.unlock();
        }
    }

    @Override // NGepWW.EwN40Z
    public final void AMqCpz(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        long j;
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f5816AmA8tU);
        for (NSK3xo.AYUAbz aYUAbz : this.f5807ADYaiT.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) aYUAbz.f5931A5SV6n).println(":");
            NUY5pn.BJ7GGh bJ7GGh = (NUY5pn.BJ7GGh) ((NSK3xo.ARc23Z) this.f5804A2egSU.get(aYUAbz.A2egSU()));
            synchronized (bJ7GGh.f5993AaHO0E) {
                i = bJ7GGh.f5999B2KMhB;
                iInterface = bJ7GGh.f5996AmA8tU;
            }
            printWriter.append((CharSequence) concat).append("mConnectState=");
            printWriter.print(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "CONNECTING" : "DISCONNECTED");
            printWriter.append(" mService=");
            if (iInterface == null) {
                printWriter.println("null");
            } else {
                printWriter.append((CharSequence) bJ7GGh.ARc23Z()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
            if (bJ7GGh.f5988ARc23Z > 0) {
                PrintWriter append = printWriter.append((CharSequence) concat).append("lastConnectedTime=");
                long j2 = bJ7GGh.f5988ARc23Z;
                j = 0;
                String valueOf = String.valueOf(simpleDateFormat.format(new Date(bJ7GGh.f5988ARc23Z)));
                StringBuilder sb = new StringBuilder(valueOf.length() + 21);
                sb.append(j2);
                sb.append(" ");
                sb.append(valueOf);
                append.println(sb.toString());
            } else {
                j = 0;
            }
            if (bJ7GGh.AMqCpz > j) {
                printWriter.append((CharSequence) concat).append("lastSuspendedCause=");
                int i2 = bJ7GGh.f5987ADYaiT;
                printWriter.append((CharSequence) (i2 != 1 ? i2 != 2 ? String.valueOf(i2) : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
                PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
                long j3 = bJ7GGh.AMqCpz;
                String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(bJ7GGh.AMqCpz)));
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 21);
                sb2.append(j3);
                sb2.append(" ");
                sb2.append(valueOf2);
                append2.println(sb2.toString());
            }
            if (bJ7GGh.f5990AYUAbz > j) {
                printWriter.append((CharSequence) concat).append("lastFailedStatus=").append((CharSequence) com.bumptech.glide.A5SV6n.A5SV6n(bJ7GGh.f5989ASJ6gh));
                PrintWriter append3 = printWriter.append(" lastFailedTime=");
                long j4 = bJ7GGh.f5990AYUAbz;
                String valueOf3 = String.valueOf(simpleDateFormat.format(new Date(bJ7GGh.f5990AYUAbz)));
                StringBuilder sb3 = new StringBuilder(valueOf3.length() + 21);
                sb3.append(j4);
                sb3.append(" ");
                sb3.append(valueOf3);
                append3.println(sb3.toString());
            }
        }
    }

    public final void ARc23Z(NOd7IU.A2egSU a2egSU) {
        this.f5811AZOQYO.lock();
        try {
            this.f5817AzWtSf = a2egSU;
            this.f5816AmA8tU = new A2egSU(1, this);
            this.f5816AmA8tU.a();
            this.f5812AZkASS.signalAll();
        } finally {
            this.f5811AZOQYO.unlock();
        }
    }

    @Override // NGepWW.EwN40Z
    public final void a() {
        this.f5816AmA8tU.c();
    }

    @Override // NGepWW.EwN40Z
    public final NOd7IU.A2egSU b() {
        a();
        while (this.f5816AmA8tU instanceof DuwtYk) {
            try {
                this.f5812AZkASS.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new NOd7IU.A2egSU(15, null);
            }
        }
        if (this.f5816AmA8tU instanceof DcUJf1) {
            return NOd7IU.A2egSU.f5852B25kr6;
        }
        NOd7IU.A2egSU a2egSU = this.f5817AzWtSf;
        return a2egSU != null ? a2egSU : new NOd7IU.A2egSU(13, null);
    }

    @Override // NGepWW.EwN40Z
    public final void c() {
        if (this.f5816AmA8tU.b()) {
            this.f5805A4TApA.clear();
        }
    }

    @Override // NGepWW.EwN40Z
    public final boolean d() {
        return this.f5816AmA8tU instanceof DcUJf1;
    }

    @Override // NGepWW.EwN40Z
    public final void g() {
    }

    @Override // NSK3xo.AZkASS
    public final void a(int i) {
        this.f5811AZOQYO.lock();
        try {
            this.f5816AmA8tU.a(i);
        } finally {
            this.f5811AZOQYO.unlock();
        }
    }
}
