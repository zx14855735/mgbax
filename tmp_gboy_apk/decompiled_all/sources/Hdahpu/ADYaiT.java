package Hdahpu;

import ADYaiT.DUi7mC;
import HSHyT0.AmA8tU;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements A2egSU {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final File f3687A4TApA;
    public HMGPfW.AMqCpz AMqCpz;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final K1Z3yj.A2egSU f3689ADYaiT = new K1Z3yj.A2egSU(29);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final long f3688A5SV6n = 262144000;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AaHO0E f3686A2egSU = new AaHO0E();

    public ADYaiT(File file) {
        this.f3687A4TApA = file;
    }

    @Override // Hdahpu.A2egSU
    public final void A2egSU(HSHyT0.AZkASS aZkASS, DUi7mC dUi7mC) {
        A5SV6n a5SV6n;
        HMGPfW.AMqCpz A5SV6n2;
        boolean z;
        String A4TApA2 = this.f3686A2egSU.A4TApA(aZkASS);
        K1Z3yj.A2egSU a2egSU = this.f3689ADYaiT;
        synchronized (a2egSU) {
            try {
                a5SV6n = (A5SV6n) ((HashMap) a2egSU.f4174AlLFFp).get(A4TApA2);
                if (a5SV6n == null) {
                    a5SV6n = ((KCxDWD.A5SV6n) a2egSU.f4175AmA8tU).AzWtSf();
                    ((HashMap) a2egSU.f4174AlLFFp).put(A4TApA2, a5SV6n);
                }
                a5SV6n.f3685A4TApA++;
            } catch (Throwable th) {
                throw th;
            }
        }
        a5SV6n.f3684A2egSU.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Objects.toString(aZkASS);
            }
            try {
                A5SV6n2 = A5SV6n();
            } catch (IOException unused) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
            if (A5SV6n2.ARc23Z(A4TApA2) != null) {
                return;
            }
            HMGPfW.A5SV6n ADYaiT2 = A5SV6n2.ADYaiT(A4TApA2);
            if (ADYaiT2 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: ".concat(A4TApA2));
            }
            try {
                if (((HSHyT0.A4TApA) dUi7mC.f239AlLFFp).ASJ6gh(dUi7mC.f240AmA8tU, ADYaiT2.A4TApA(), (AmA8tU) dUi7mC.f241AzWtSf)) {
                    HMGPfW.AMqCpz.A2egSU((HMGPfW.AMqCpz) ADYaiT2.f3386AzWtSf, ADYaiT2, true);
                    ADYaiT2.f3383AcNBzu = true;
                }
                if (!z) {
                    try {
                        ADYaiT2.A2egSU();
                    } catch (IOException unused2) {
                    }
                }
            } finally {
                if (!ADYaiT2.f3383AcNBzu) {
                    try {
                        ADYaiT2.A2egSU();
                    } catch (IOException unused3) {
                    }
                }
            }
        } finally {
            this.f3689ADYaiT.B3GDIM(A4TApA2);
        }
    }

    @Override // Hdahpu.A2egSU
    public final File A4TApA(HSHyT0.AZkASS aZkASS) {
        String A4TApA2 = this.f3686A2egSU.A4TApA(aZkASS);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Objects.toString(aZkASS);
        }
        try {
            KCxDWD.A5SV6n ARc23Z2 = A5SV6n().ARc23Z(A4TApA2);
            if (ARc23Z2 != null) {
                return ((File[]) ARc23Z2.f4241AlLFFp)[0];
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized HMGPfW.AMqCpz A5SV6n() {
        try {
            if (this.AMqCpz == null) {
                this.AMqCpz = HMGPfW.AMqCpz.AYUAbz(this.f3687A4TApA, this.f3688A5SV6n);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.AMqCpz;
    }

    @Override // Hdahpu.A2egSU
    public void delete(HSHyT0.AZkASS aZkASS) {
        try {
            A5SV6n().AlLFFp(this.f3686A2egSU.A4TApA(aZkASS));
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        }
    }
}
