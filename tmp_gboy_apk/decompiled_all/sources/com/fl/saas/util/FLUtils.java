package com.fl.saas.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.ProxyInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FLUtils {

    public static class TypeBean {
        private String reason;
        private int type;

        public TypeBean(int i, String str) {
            this.type = i;
            this.reason = str;
        }

        public String getReason() {
            return this.reason;
        }

        public int getType() {
            return this.type;
        }
    }

    public static TypeBean getType(Context context, double d) {
        if (context == null) {
            return new TypeBean(1, "contextIsNull");
        }
        boolean isDeveloperOptionsEnabled = isDeveloperOptionsEnabled(context);
        boolean isNetworkProxyEnabled = isNetworkProxyEnabled(context);
        boolean isVPNConnected = isVPNConnected(context);
        if (isDeveloperOptionsEnabled || isNetworkProxyEnabled || isVPNConnected) {
            return new TypeBean(1, "developer");
        }
        double d2 = 0.0d;
        if (d > 0.0d && d < 100.0d) {
            d2 = new Random().nextDouble() * 100.0d;
            if (d2 >= d) {
                return new TypeBean(0, "");
            }
        }
        return new TypeBean(1, d2 + "_" + d);
    }

    public static boolean isDeveloperOptionsEnabled(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isNetworkProxyEnabled(Context context) {
        ProxyInfo proxyInfo;
        Network activeNetwork;
        if (Build.VERSION.SDK_INT < 23) {
            return (TextUtils.isEmpty(System.getProperty("http.proxyHost")) || TextUtils.isEmpty(System.getProperty("http.proxyPort"))) ? false : true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                proxyInfo = connectivityManager.getDefaultProxy();
                return (proxyInfo == null || proxyInfo.getHost() == null) ? false : true;
            }
        }
        proxyInfo = null;
        if (proxyInfo == null) {
            return false;
        }
    }

    public static boolean isVPNConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 23) {
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                    return true;
                }
            }
        } else {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(17);
            if (networkInfo != null) {
                return networkInfo.isConnected();
            }
        }
        return false;
    }
}
