package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import java.util.Iterator;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class a0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        boolean z = n0.f14028A2egSU;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "03a485", new byte[]{46, 63, 32, 69, 23, 45, 33, 6, 22, 109, 47, 56, 1, 72, 71, com.sigmob.sdk.archives.tar.e.N, 60, 25, com.sigmob.sdk.archives.tar.e.M, 106, 97, 124, 95, 13, 71});
        Iterator it = n0.f14030A5SV6n.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
        return null;
    }
}
