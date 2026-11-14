package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class x extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        String str2;
        try {
            WifiInfo connectionInfo = ((WifiManager) pblv.f14062A4TApA.f14063A2egSU.getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4cf430", new byte[]{com.sigmob.sdk.archives.tar.e.J, 104, 19, 73}))).getConnectionInfo();
            Method declaredMethod = connectionInfo.getClass().getDeclaredMethod(new String(pbla.A2egSU((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3c8e59", new byte[]{116, com.sigmob.sdk.archives.tar.e.N, 29, 68, 93, 122, 100, 27, 62, 101, 118, com.sigmob.sdk.archives.tar.e.H, 29, 69, 92, 122, com.sigmob.sdk.archives.tar.e.T, 16, 63, 96, 117, com.sigmob.sdk.archives.tar.e.J, 28, 66}))), new Class[0]);
            declaredMethod.setAccessible(true);
            str2 = Integer.toString(((Integer) declaredMethod.invoke(connectionInfo, new Object[0])).intValue());
        } catch (Throwable unused) {
            str2 = null;
        }
        return TextUtils.isEmpty(str2) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "646eb2", new byte[]{119}) : str2.trim();
    }
}
