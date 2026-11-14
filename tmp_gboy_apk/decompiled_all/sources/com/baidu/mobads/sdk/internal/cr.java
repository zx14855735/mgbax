package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile cr f9803a;

    private cr() {
    }

    public static cr a() {
        if (f9803a == null) {
            synchronized (cr.class) {
                try {
                    if (f9803a == null) {
                        f9803a = new cr();
                    }
                } finally {
                }
            }
        }
        return f9803a;
    }

    private NetworkCapabilities c(Context context) {
        Network activeNetwork;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.b) != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            return connectivityManager.getNetworkCapabilities(activeNetwork);
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.b) == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z = false;
            if (bn.a(context).a() < 29) {
                NetworkInfo b = b(context);
                if (b != null && b.isConnected() && b.getType() == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            NetworkCapabilities c = c(context);
            if (c != null && c.hasCapability(12) && c.hasCapability(16) && c.hasTransport(1)) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
