package com.bytedance.msdk.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class dk {
    private static final AtomicInteger xj = new AtomicInteger(0);

    static {
        cwyq();
    }

    public static String ai() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getMacAddress(null) : "";
    }

    public static String am() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getOsVersion() : "";
    }

    public static String c() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getDeviceModel() : "";
    }

    private static /* synthetic */ void cwyq() {
        char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'y');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String d() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getLanguage() : "";
    }

    public static String dk() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getImsi(null) : "";
    }

    public static String e() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getVendor() : "";
    }

    public static int en() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        if (xjVar != null) {
            return xjVar.getTimeZoneInt();
        }
        return 0;
    }

    public static String et() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getSSID(null) : "";
    }

    public static String f() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getDeviceName() : "";
    }

    private static boolean ff() {
        return com.bytedance.msdk.core.xj.p().ra().w() && u(com.bytedance.msdk.core.hf.getContext());
    }

    public static int g() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        if (xjVar != null) {
            return xjVar.getOs();
        }
        return 0;
    }

    public static String hf() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getOAID(false) : "";
    }

    public static String ht() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getIP() : "";
    }

    public static String io() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getWifiMac(null) : "";
    }

    public static String j() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getRom() : "";
    }

    public static String jk() {
        com.bytedance.sdk.component.u.xj.xj xjVar;
        return (ff() && (xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info")) != null) ? xjVar.getCarrierName() : "";
    }

    public static int kd() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        int i = 0;
        if (com.bytedance.msdk.core.xj.p().ra().w() && xjVar != null) {
            i = xjVar.getConnType();
        }
        return xj(i);
    }

    public static String l() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getDisplayDensity() : "";
    }

    public static String p() {
        com.bytedance.sdk.component.u.xj.xj xjVar;
        return (ff() && (xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info")) != null) ? xjVar.getMcc() : "";
    }

    public static String pl() {
        com.bytedance.sdk.component.u.xj.xj xjVar;
        return (ff() && (xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info")) != null) ? xjVar.getMnc() : "";
    }

    public static String pz() {
        AtomicInteger atomicInteger = xj;
        if (atomicInteger.intValue() > 5) {
            return null;
        }
        atomicInteger.incrementAndGet();
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        if (xjVar != null) {
            return xjVar.getImei(null);
        }
        return null;
    }

    public static int q() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        if (xjVar != null) {
            return xjVar.getDeviceType(false);
        }
        return 1;
    }

    public static String qt() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getTotalMem() : "";
    }

    public static String ra() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getUUId() : "";
    }

    public static String tf() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getLocalLanguage() : "";
    }

    public static String u() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getAndroidId() : "";
    }

    public static String v() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getBoot() : "";
    }

    public static String w() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getCompilingTime() : "";
    }

    public static String x() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getBuildSerial() : "";
    }

    private static int xj(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                if (i == 4) {
                    return 1;
                }
                if (i == 5) {
                    return 4;
                }
                if (i != 6) {
                    return i;
                }
                return 5;
            }
        }
        return i2;
    }

    public static String y() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        int i = 0;
        if (com.bytedance.msdk.core.xj.p().ra().w() && xjVar != null) {
            i = xjVar.getConnType();
        }
        return hf(i);
    }

    public static String yo() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getTimeZone() : "";
    }

    public static String z() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getUserAgent() : "";
    }

    public static String zg() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getTotalSpace() : "";
    }

    public static String xj() {
        com.bytedance.sdk.component.u.xj.xj xjVar = (com.bytedance.sdk.component.u.xj.xj) com.bytedance.sdk.openadsdk.ats.w.xj("device_info");
        return xjVar != null ? xjVar.getAppLogDid() : "";
    }

    private static String hf(int i) {
        if (i == 0) {
            return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        }
        if (i == 2) {
            return "2g";
        }
        if (i == 3) {
            return "3g";
        }
        if (i == 4) {
            return "wifi";
        }
        if (i == 5) {
            return "4g";
        }
        if (i != 6) {
            return "mobile";
        }
        return "5g";
    }

    private static boolean u(Context context) {
        return com.bytedance.msdk.core.pl.w.xj(context, com.kuaishou.weapon.p0.g.c) == 0;
    }

    public static boolean w(Context context) {
        return com.bytedance.sdk.component.utils.am.w(context) == 2;
    }

    public static boolean xj(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean hf(Context context) {
        return com.bytedance.sdk.component.utils.am.w(context) == 3;
    }
}
