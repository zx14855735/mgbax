package ms.bz.bd.c.Pgl;

import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class f extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        m1 A5SV6n2 = m1.A5SV6n(pblv.f14062A4TApA.f14063A2egSU);
        synchronized (A5SV6n2) {
            JSONArray ADYaiT2 = A5SV6n2.ADYaiT();
            if (ADYaiT2 != null) {
                A5SV6n2.f14027B25kr6.add(ADYaiT2);
                try {
                    int size = A5SV6n2.f14027B25kr6.size();
                    if (size > 100) {
                        ArrayList arrayList = new ArrayList(A5SV6n2.f14027B25kr6.subList(size - 50, size));
                        A5SV6n2.f14027B25kr6.clear();
                        A5SV6n2.f14027B25kr6 = arrayList;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
