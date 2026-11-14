package ms.bz.bd.c.Pgl;

import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class l extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        int i;
        int A2egSU2;
        int A4TApA2;
        l1 A5SV6n2 = l1.A5SV6n(pblv.f14062A4TApA.f14063A2egSU);
        A5SV6n2.getClass();
        try {
            if (pble.A4TApA() != null) {
                try {
                    synchronized (A5SV6n2) {
                        A2egSU2 = A5SV6n2.A2egSU();
                        A4TApA2 = A5SV6n2.A4TApA();
                    }
                    i = (A2egSU2 * 10000) + A4TApA2;
                } catch (Exception unused) {
                    i = -10001;
                }
                A5SV6n2.f14018A4TApA.add(Integer.valueOf(i));
                try {
                    int size = A5SV6n2.f14018A4TApA.size();
                    if (size <= 20) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList(A5SV6n2.f14018A4TApA.subList(size - 10, size));
                    A5SV6n2.f14018A4TApA.clear();
                    A5SV6n2.f14018A4TApA = arrayList;
                    return null;
                } catch (Throwable unused2) {
                    return null;
                }
            }
        } catch (Throwable unused3) {
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bc673e", new byte[]{112, 105, 64, 64, 7, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.T, 71, 115, 100, 123, 67, 68, 87, 24, 119, 115, 91, 84, 115, 114, 117, 80, 80, 63, 102, 115, 75, 105, 96, com.sigmob.sdk.archives.tar.e.K, 104, 75, 3, 14, 115, 98, 73, 96, 117, 124, 116, 75, 71});
        return null;
    }
}
