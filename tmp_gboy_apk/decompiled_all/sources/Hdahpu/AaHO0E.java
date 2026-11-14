package Hdahpu;

import ADYaiT.DUi7mC;
import ItGa5w.AlLFFp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ItGa5w.AZOQYO f3702A2egSU = new ItGa5w.AZOQYO(1000);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final DUi7mC f3703A4TApA = Ixu71n.A5SV6n.A2egSU(10, new AZOQYO(0));

    public final String A2egSU(HSHyT0.AZkASS aZkASS) {
        String str;
        AZkASS aZkASS2 = (AZkASS) this.f3703A4TApA.AYUAbz();
        try {
            aZkASS.A2egSU(aZkASS2.f3700AcNBzu);
            byte[] digest = aZkASS2.f3700AcNBzu.digest();
            char[] cArr = AlLFFp.f4093A4TApA;
            synchronized (cArr) {
                for (int i = 0; i < digest.length; i++) {
                    byte b = digest[i];
                    int i2 = i * 2;
                    char[] cArr2 = AlLFFp.f4092A2egSU;
                    cArr[i2] = cArr2[(b & 255) >>> 4];
                    cArr[i2 + 1] = cArr2[b & 15];
                }
                str = new String(cArr);
            }
            return str;
        } finally {
            this.f3703A4TApA.B7CMnp(aZkASS2);
        }
    }

    public final String A4TApA(HSHyT0.AZkASS aZkASS) {
        String str;
        synchronized (this.f3702A2egSU) {
            str = (String) this.f3702A2egSU.A2egSU(aZkASS);
        }
        if (str == null) {
            str = A2egSU(aZkASS);
        }
        synchronized (this.f3702A2egSU) {
            this.f3702A2egSU.ADYaiT(aZkASS, str);
        }
        return str;
    }
}
