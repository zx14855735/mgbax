package MdiDtx;

import ADYaiT.DUi7mC;
import com.sigmob.sdk.base.views.r;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A4TApA f5341A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile DatagramSocket f5342A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile InetSocketAddress f5343A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public long f5344ADYaiT;
    public final Object AMqCpz = new Object();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final DUi7mC f5345ARc23Z;

    public A5SV6n(int i, DatagramSocket datagramSocket, InetSocketAddress inetSocketAddress, DUi7mC dUi7mC) {
        this.f5344ADYaiT = 0L;
        this.f5342A4TApA = datagramSocket;
        this.f5343A5SV6n = inetSocketAddress;
        this.f5345ARc23Z = dUi7mC;
        this.f5344ADYaiT = 0L;
        A4TApA a4TApA = new A4TApA(this, i, dUi7mC);
        this.f5341A2egSU = a4TApA;
        long j = 1;
        a4TApA.f5336BTvldC = j;
        a4TApA.f5332BIYEnU = 30L;
        a4TApA.f5334BNL6CD = 10;
        a4TApA.f5339BniPrB = 2;
        a4TApA.BpkvW3 = j;
        long j2 = r.b.d;
        a4TApA.f5315ASJ6gh = j2;
        a4TApA.f5316AYUAbz = j2;
        long j3 = 512;
        a4TApA.f5321AlLFFp = j3;
        a4TApA.f5322AmA8tU = j3 - 24;
        a4TApA.f5323AzWtSf = new byte[1608];
    }

    public final void A2egSU(long j) {
        synchronized (this.AMqCpz) {
            this.f5341A2egSU.ARc23Z(j);
            this.f5344ADYaiT = this.f5341A2egSU.A2egSU(j);
        }
    }

    public final void A4TApA(byte[] bArr) {
        synchronized (this.AMqCpz) {
            try {
                int A4TApA2 = this.f5341A2egSU.A4TApA(bArr);
                if (A4TApA2 < 0 && A4TApA2 != -1) {
                    new Exception("KCP input error: " + A4TApA2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A5SV6n() {
        synchronized (this.AMqCpz) {
            try {
                int A5SV6n2 = this.f5341A2egSU.A5SV6n();
                while (A5SV6n2 > 0) {
                    byte[] bArr = new byte[A5SV6n2];
                    int ADYaiT2 = this.f5341A2egSU.ADYaiT(bArr);
                    if (ADYaiT2 > 0) {
                        byte[] bArr2 = new byte[ADYaiT2];
                        System.arraycopy(bArr, 0, bArr2, 0, ADYaiT2);
                        this.f5345ARc23Z.B4ZgIw(bArr2);
                    }
                    A5SV6n2 = this.f5341A2egSU.A5SV6n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ADYaiT(byte[] bArr) {
        synchronized (this.AMqCpz) {
            try {
                int AMqCpz = this.f5341A2egSU.AMqCpz(bArr);
                if (AMqCpz < 0) {
                    new Exception("KCP send error: " + AMqCpz);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void update(long j) {
        synchronized (this.AMqCpz) {
            try {
                if (j >= this.f5344ADYaiT) {
                    this.f5341A2egSU.ARc23Z(j);
                    this.f5344ADYaiT = this.f5341A2egSU.A2egSU(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
