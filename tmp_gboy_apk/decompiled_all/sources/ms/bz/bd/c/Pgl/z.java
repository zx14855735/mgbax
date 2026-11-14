package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class z extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        Boolean bool = Boolean.FALSE;
        try {
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            if (context != null) {
                return Boolean.valueOf((context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return bool;
        }
    }
}
