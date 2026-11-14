package ms.bz.bd.c.Pgl;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class b0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) pblv.f14062A4TApA.f14063A2egSU.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60965a", new byte[]{36, 61, 68, com.sigmob.sdk.archives.tar.e.P, 15, 117, 33, 24, 126, 111, com.sigmob.sdk.archives.tar.e.K, 43}));
                activeNetwork = connectivityManager.getActiveNetwork();
                return (String) (connectivityManager.getNetworkCapabilities(activeNetwork).hasTransport(4) ? com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e8a67e", new byte[]{37}) : com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "743fad", new byte[]{118}));
            } catch (Throwable unused) {
            }
        }
        return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d3b33", new byte[]{119});
    }
}
