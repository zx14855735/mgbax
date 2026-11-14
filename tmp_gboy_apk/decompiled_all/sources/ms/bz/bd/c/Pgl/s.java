package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class s extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        Context context = pblv.f14062A4TApA.f14063A2egSU;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f067d0", new byte[]{116, 61, 75, 77, 94, 36, 113, 24, 113, 110, 99, 43}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6c5def", new byte[]{32, 100, 82, com.sigmob.sdk.archives.tar.e.I, 89, 101, 60, 84, 97, 26, 34, 117, 81, 31, 72, 122, 28, com.sigmob.sdk.archives.tar.e.P, 98, 59}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "20fc26", new byte[]{42, 33, com.sigmob.sdk.archives.tar.e.L, 1, 12, 40, 61, 16, com.sigmob.sdk.archives.tar.e.M, 63, 38}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    Boolean bool = (Boolean) declaredMethod2.invoke(networkInfo, new Object[0]);
                    bool.getClass();
                    return bool;
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}
