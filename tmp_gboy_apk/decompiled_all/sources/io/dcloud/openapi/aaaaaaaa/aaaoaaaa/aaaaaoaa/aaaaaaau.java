package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import io.dcloud.openapi.poly.base.utils.PrivacyManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaau {
    private static boolean aaaaaaa0 = false;
    private static String aaaaaaaa = "";

    public static String aaaaaaaa(Context context) {
        if (context == null) {
            return aaaaaaaa;
        }
        if (!PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaaa;
        }
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context)) {
            return aaaaaaaa;
        }
        if (aaaaaaa0) {
            return aaaaaaaa;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        String aaaaaaaa2 = connectivityManager.getNetworkInfo(0).isConnected() ? aaaaaaaa() : connectivityManager.getNetworkInfo(1).isConnected() ? aaaaaaaa(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress()) : null;
        aaaaaaaa = aaaaaaaa2;
        aaaaaaa0 = true;
        return aaaaaaaa2;
    }

    public static String aaaaaaaa() {
        try {
            ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
            int size = list.size();
            int i = 0;
            while (i < size) {
                Object obj = list.get(i);
                i++;
                ArrayList list2 = Collections.list(((NetworkInterface) obj).getInetAddresses());
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = list2.get(i2);
                    i2++;
                    InetAddress inetAddress = (InetAddress) obj2;
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String aaaaaaaa(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }
}
