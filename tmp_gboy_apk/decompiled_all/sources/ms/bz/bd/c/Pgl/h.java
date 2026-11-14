package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class h extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name) && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address) && name.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b89079", new byte[]{97, com.sigmob.sdk.archives.tar.e.O, 68, 65, 28}))) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "59fc1b", new byte[]{45, com.sigmob.sdk.archives.tar.e.M, 16, 3, 47, 113, com.sigmob.sdk.archives.tar.e.J, 10, com.sigmob.sdk.archives.tar.e.J, 32, com.sigmob.sdk.archives.tar.e.O, 123, 27, 22, 3, 112, 108});
                        nextElement.getName();
                        return nextElement.getName();
                    }
                }
            }
            return "";
        } catch (SocketException unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aa0a2b", new byte[]{119, 102, 87, 85, 36, 101, 67, 68, 101, 35, 117, 112, 80, 85, 11, 116, 107, com.sigmob.sdk.archives.tar.e.P, 59});
            return "";
        }
    }
}
