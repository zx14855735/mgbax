package ms.bz.bd.c.Pgl;

import java.util.Locale;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class g extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        String str2;
        try {
            Locale locale = pblv.f14062A4TApA.f14063A2egSU.getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a5166", new byte[]{29})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return q1.A2egSU(str2);
    }
}
