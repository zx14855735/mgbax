package ms.bz.bd.c.Pgl;

import android.content.Intent;
import android.content.IntentFilter;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class n extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        int i = 1;
        l1 A5SV6n2 = l1.A5SV6n(pblv.f14062A4TApA.f14063A2egSU);
        A5SV6n2.getClass();
        Intent registerReceiver = A5SV6n2.f14017A2egSU.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "809a2d", new byte[]{40, 60, 78, 7, 2, 122, 63, 95, 97, 63, 61, com.sigmob.sdk.archives.tar.e.O, 68, 1, 67, 114, 56, 5, 97, 62, 39, 124, 104, com.sigmob.sdk.archives.tar.e.L, 57, 71, 30, 35, 81, 14, 10, 26, 107, 59, 42, 86, 31})));
        if (registerReceiver == null) {
            i = -1;
        } else {
            int intExtra = registerReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "88c189", new byte[]{58, 46, 17, 81, 18, 61}), -1);
            if (intExtra != 2 && intExtra != 5) {
                i = 0;
            }
        }
        return Integer.valueOf(i);
    }
}
