package ms.bz.bd.c.Pgl;

import java.util.ArrayList;
import java.util.List;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class m extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        l1 A5SV6n2 = l1.A5SV6n(pblv.f14062A4TApA.f14063A2egSU);
        synchronized (A5SV6n2) {
            int size = A5SV6n2.f14018A4TApA.size();
            if (size <= 0) {
                return new int[0];
            }
            if (size == 1) {
                return new int[]{((Integer) A5SV6n2.f14018A4TApA.get(0)).intValue()};
            }
            try {
                ArrayList arrayList = A5SV6n2.f14018A4TApA;
                int i = size - 10;
                if (i <= 0) {
                    i = 0;
                }
                List subList = arrayList.subList(i, size);
                int[] iArr = new int[subList.size()];
                for (int i2 = 0; i2 < subList.size(); i2++) {
                    iArr[i2] = ((Integer) subList.get(i2)).intValue();
                }
                return iArr;
            } catch (Throwable unused) {
                return new int[0];
            }
        }
    }
}
