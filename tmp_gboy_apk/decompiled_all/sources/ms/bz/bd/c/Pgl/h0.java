package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class h0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        double d;
        Context context = pblv.f14062A4TApA.f14063A2egSU;
        try {
            Class<?> cls = Class.forName(new String(pbla.A2egSU((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7c04c8", new byte[]{112, com.sigmob.sdk.archives.tar.e.J, 21, 70, 10, 43, 102, 71, com.sigmob.sdk.archives.tar.e.O, com.sigmob.sdk.archives.tar.e.M, 112, 100, 21, 20, 11, 125, 98, 68, com.sigmob.sdk.archives.tar.e.O, 61, 112, com.sigmob.sdk.archives.tar.e.M, 17, 69, 10, 118, 98, 71, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.H, 112, com.sigmob.sdk.archives.tar.e.L, 20, 18, 10, 42, 98, 19, com.sigmob.sdk.archives.tar.e.O, com.sigmob.sdk.archives.tar.e.T, 116, 100, 21, 70, 11, 124, 102, 71, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.L, 112, com.sigmob.sdk.archives.tar.e.T, 20, 23, 10, 122, 99, 16, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.L, 113, com.sigmob.sdk.archives.tar.e.K, 21, 70, 10, 121, 98, 27, com.sigmob.sdk.archives.tar.e.O, com.sigmob.sdk.archives.tar.e.T, 112, com.sigmob.sdk.archives.tar.e.L}))));
            Object newInstance = cls.getConstructor(Context.class).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod(new String(pbla.A2egSU((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0ed66d", new byte[]{119, com.sigmob.sdk.archives.tar.e.H, 65, 23, 94, 39, com.sigmob.sdk.archives.tar.e.T, 21, 98, com.sigmob.sdk.archives.tar.e.H, 119, com.sigmob.sdk.archives.tar.e.J, 64, 16, 95, 34, 101, 19, 99, com.sigmob.sdk.archives.tar.e.K, 116, com.sigmob.sdk.archives.tar.e.O, 65, 68, 94, 36, 101, 17, 98, com.sigmob.sdk.archives.tar.e.L}))), String.class);
            declaredMethod.setAccessible(true);
            d = ((Double) declaredMethod.invoke(newInstance, new String(pbla.A2egSU((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6ca0de", new byte[]{113, com.sigmob.sdk.archives.tar.e.K, 68, 21, 12, 38, 98, 22, 102, com.sigmob.sdk.archives.tar.e.M, 112, com.sigmob.sdk.archives.tar.e.K, 69, 29, 9, 119, 99, 17, 102, com.sigmob.sdk.archives.tar.e.I, 112, com.sigmob.sdk.archives.tar.e.I, 68, 21, 13, 33, 99, 27, com.sigmob.sdk.archives.tar.e.T, com.sigmob.sdk.archives.tar.e.L, 112, 56}))))).doubleValue();
        } catch (Throwable unused) {
            d = 0.0d;
        }
        return Integer.toString((int) d);
    }
}
