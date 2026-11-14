package ms.bz.bd.c.Pgl;

import B4ZgIw.AYUAbz;
import java.util.TimeZone;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class k0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        String str2;
        int i;
        TimeZone timeZone;
        try {
            timeZone = TimeZone.getDefault();
            str2 = timeZone.getID();
        } catch (Throwable unused) {
            str2 = null;
        }
        try {
            i = ((timeZone.getRawOffset() / 60) / 60) / 1000;
        } catch (Throwable unused2) {
            i = 0;
            StringBuilder A4TApA2 = AYUAbz.A4TApA(str2);
            A4TApA2.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11a32f", new byte[]{108}));
            A4TApA2.append(i);
            return A4TApA2.toString();
        }
        StringBuilder A4TApA22 = AYUAbz.A4TApA(str2);
        A4TApA22.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11a32f", new byte[]{108}));
        A4TApA22.append(i);
        return A4TApA22.toString();
    }
}
