package MdiDtx;

import ADYaiT.DUi7mC;
import com.sigmob.sdk.base.views.r;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final long f5310A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public long f5311A4TApA = 0;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public long f5312A5SV6n = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public long f5313ADYaiT = 0;
    public long AMqCpz = 0;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public long f5314ARc23Z = 0;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public long f5315ASJ6gh = 32;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public long f5316AYUAbz = 32;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public long f5317AZOQYO = 32;

    /* renamed from: AZkASS, reason: collision with root package name */
    public long f5318AZkASS = 0;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public long f5319AaHO0E = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public long f5320AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public long f5321AlLFFp = 1400;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f5322AmA8tU = 1376;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public byte[] f5323AzWtSf = new byte[((int) 1424) * 3];

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f5324B25kr6 = new ArrayList(r.b.d);

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ArrayList f5325B2KMhB = new ArrayList(r.b.d);

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ArrayList f5326B3GDIM = new ArrayList(r.b.d);

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ArrayList f5327B4ZgIw = new ArrayList(r.b.d);

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final ArrayList f5328B7CMnp = new ArrayList(r.b.d);

    /* renamed from: B9tovu, reason: collision with root package name */
    public long f5329B9tovu = 0;

    /* renamed from: BChYOn, reason: collision with root package name */
    public long f5330BChYOn = 0;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public long f5331BI9f7h = 200;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public long f5332BIYEnU = 100;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public long f5333BJ7GGh = 0;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public long f5334BNL6CD = 100;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public long f5335BPw6Q8 = 100;

    /* renamed from: BTvldC, reason: collision with root package name */
    public long f5336BTvldC = 0;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public long f5337BV3sI0 = 0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public long f5338BmvVmW = 2;

    /* renamed from: BniPrB, reason: collision with root package name */
    public long f5339BniPrB = 0;
    public long BpkvW3 = 0;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final /* synthetic */ A5SV6n f5340C2rE4F;

    public A4TApA(A5SV6n a5SV6n, long j, DUi7mC dUi7mC) {
        this.f5340C2rE4F = a5SV6n;
        this.f5310A2egSU = 0L;
        this.f5310A2egSU = j;
    }

    public static long ASJ6gh(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static void AYUAbz(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (j >> 24);
        bArr[i + 1] = (byte) (j >> 16);
        bArr[i + 2] = (byte) (j >> 8);
        bArr[i + 3] = (byte) j;
    }

    public static void AZkASS(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = i2 - i;
            if (i3 < i4) {
                arrayList.set(i3, arrayList.get(i3 + i));
            } else {
                arrayList.remove(i4);
            }
        }
    }

    public final long A2egSU(long j) {
        long j2 = this.f5335BPw6Q8;
        if (0 != this.f5337BV3sI0) {
            int i = (int) (j - j2);
            if (i >= 10000 || i < -10000) {
                j2 = j;
            }
            if (((int) (j - j2)) < 0) {
                long j3 = (int) (j2 - j);
                Iterator it = this.f5325B2KMhB.iterator();
                long j4 = 2147483647L;
                while (it.hasNext()) {
                    int i2 = (int) (((A2egSU) it.next()).f5305AYUAbz - j);
                    if (i2 > 0) {
                        long j5 = i2;
                        if (j5 < j4) {
                            j4 = j5;
                        }
                    }
                }
                if (j4 < j3) {
                    j3 = j4;
                }
                long j6 = this.f5334BNL6CD;
                if (j3 >= j6) {
                    j3 = j6;
                }
                return j + j3;
            }
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0249, code lost:
    
        r9 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A4TApA(byte[] r30) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: MdiDtx.A4TApA.A4TApA(byte[]):int");
    }

    public final int A5SV6n() {
        ArrayList arrayList = this.f5326B3GDIM;
        if (arrayList.size() == 0) {
            return -1;
        }
        int i = 0;
        A2egSU a2egSU = (A2egSU) arrayList.get(0);
        if (0 == a2egSU.f5301A5SV6n) {
            return a2egSU.f5309AcNBzu.length;
        }
        if (arrayList.size() < a2egSU.f5301A5SV6n + 1) {
            return -1;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            A2egSU a2egSU2 = (A2egSU) it.next();
            i += a2egSU2.f5309AcNBzu.length;
            if (0 == a2egSU2.f5301A5SV6n) {
                break;
            }
        }
        return i;
    }

    public final int ADYaiT(byte[] bArr) {
        ArrayList arrayList = this.f5326B3GDIM;
        if (arrayList.size() == 0) {
            return -1;
        }
        int A5SV6n2 = A5SV6n();
        if (A5SV6n2 < 0) {
            return -2;
        }
        if (A5SV6n2 > bArr.length) {
            return -3;
        }
        int i = 0;
        boolean z = ((long) arrayList.size()) >= this.f5316AYUAbz;
        Iterator it = arrayList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            A2egSU a2egSU = (A2egSU) it.next();
            byte[] bArr2 = a2egSU.f5309AcNBzu;
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += a2egSU.f5309AcNBzu.length;
            i3++;
            if (0 == a2egSU.f5301A5SV6n) {
                break;
            }
        }
        if (i3 > 0) {
            AZkASS(arrayList, i3, arrayList.size());
        }
        ArrayList arrayList2 = this.f5324B25kr6;
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            A2egSU a2egSU2 = (A2egSU) it2.next();
            if (a2egSU2.f5303ARc23Z != this.f5313ADYaiT || arrayList.size() >= this.f5316AYUAbz) {
                break;
            }
            arrayList.add(a2egSU2);
            this.f5313ADYaiT++;
            i++;
        }
        if (i > 0) {
            AZkASS(arrayList2, i, arrayList2.size());
        }
        if (arrayList.size() < this.f5316AYUAbz && z) {
            this.f5320AcNBzu |= 2;
        }
        return i2;
    }

    public final int AMqCpz(byte[] bArr) {
        if (bArr.length == 0) {
            return -1;
        }
        long length = bArr.length;
        long j = this.f5322AmA8tU;
        int length2 = length < j ? 1 : ((int) ((bArr.length + j) - 1)) / ((int) j);
        if (255 < length2) {
            return -2;
        }
        if (length2 == 0) {
            length2 = 1;
        }
        int length3 = bArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length2; i2++) {
            long j2 = length3;
            long j3 = this.f5322AmA8tU;
            if (j2 > j3) {
                j2 = j3;
            }
            int i3 = (int) j2;
            A2egSU a2egSU = new A2egSU(i3);
            System.arraycopy(bArr, i, a2egSU.f5309AcNBzu, 0, i3);
            i += i3;
            a2egSU.f5301A5SV6n = (length2 - i2) - 1;
            this.f5327B4ZgIw.add(a2egSU);
            length3 -= i3;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ARc23Z(long r28) {
        /*
            Method dump skipped, instructions count: 737
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: MdiDtx.A4TApA.ARc23Z(long):void");
    }

    public final void AZOQYO(byte[] bArr, int i) {
        try {
            this.f5340C2rE4F.f5342A4TApA.send(new DatagramPacket(bArr, i, this.f5340C2rE4F.f5343A5SV6n));
        } catch (IOException unused) {
        }
    }
}
