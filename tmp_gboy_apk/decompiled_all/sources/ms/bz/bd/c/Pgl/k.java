package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class k extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) pblv.f14062A4TApA.f14063A2egSU.getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "082ff5", new byte[]{com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, 78, 28, 92}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }
}
