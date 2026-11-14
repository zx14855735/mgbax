package com.bytedance.sdk.component.panglearmor.hf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.panglearmor.y;
import com.kwad.components.core.s.t;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj xj;
    private volatile int hf;
    private TelephonyManager kd;
    private volatile int u = -1;
    private ConnectivityManager w;

    public xj() {
        this.w = null;
        this.kd = null;
        Context u = y.u();
        if (u != null) {
            this.w = (ConnectivityManager) u.getSystemService("connectivity");
            this.kd = (TelephonyManager) u.getSystemService("phone");
        }
        xj((int) (((kd.xj().w() / 1000) / 60) / 60));
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private int y() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.w;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT < 23) {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        return xj(this.w) ? 3 : 1;
                    }
                    if (type != 0) {
                        return 0;
                    }
                }
                activeNetwork = this.w.getActiveNetwork();
                if (activeNetwork == null || (networkCapabilities = this.w.getNetworkCapabilities(activeNetwork)) == null) {
                    return 0;
                }
                boolean hasTransport = networkCapabilities.hasTransport(0);
                boolean hasTransport2 = networkCapabilities.hasTransport(1);
                if (xj(this.w) && hasTransport2) {
                    return 3;
                }
                if (!hasTransport2) {
                    return hasTransport ? 2 : 0;
                }
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int[] hf() {
        int[] iArr = new int[this.hf];
        LinkedList<JSONObject> xj2 = hf.xj().xj("sp_net");
        if (xj2 != null && xj2.size() > 0) {
            int optLong = (int) (((xj2.getLast().optLong(t.TAG, 0L) / 1000) / 60) / 60);
            Iterator<JSONObject> it = xj2.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong2 = next.optLong(t.TAG, 0L);
                int optInt = next.optInt("val", 0);
                int i = optLong - ((int) (((optLong2 / 1000) / 60) / 60));
                if (i >= 0 && i < this.hf) {
                    iArr[i] = optInt;
                }
            }
        }
        return iArr;
    }

    public int kd() {
        TelephonyManager telephonyManager = this.kd;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }

    public int u() {
        this.u = y();
        return this.u;
    }

    public int[] w() {
        int[] iArr = new int[this.hf];
        LinkedList<JSONObject> xj2 = hf.xj().xj("sp_screen");
        if (xj2 != null && xj2.size() > 0) {
            int currentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            Iterator<JSONObject> it = xj2.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong = next.optLong(t.TAG, 0L);
                int optInt = next.optInt("val", 0);
                int i = currentTimeMillis - ((int) (((optLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.hf) {
                    iArr[i] = optInt;
                }
            }
        }
        return iArr;
    }

    private static boolean xj(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void xj(int i) {
        if (i <= 0) {
            this.hf = 1;
        } else if (i > 168) {
            this.hf = 168;
        } else {
            this.hf = i;
        }
    }
}
