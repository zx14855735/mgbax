package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.net.InetAddress;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ao {
    private static int beS = 0;
    private static boolean beT = false;
    private static String beU = "";

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo dn(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: do, reason: not valid java name */
    public static String m18do(Context context) {
        try {
            NetworkInfo dn = dn(context);
            if (dn == null || !dn.isConnected()) {
                return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
            }
            int type = dn.getType();
            if (type != 0) {
                return type != 1 ? MediationConfigUserInfoForSegment.GENDER_UNKNOWN : dn.getTypeName();
            }
            String subtypeName = dn.getSubtypeName();
            return TextUtils.isEmpty(subtypeName) ? dn.getTypeName() : subtypeName;
        } catch (Exception unused) {
            return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        }
    }

    public static int dp(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.c)) {
            try {
                NetworkInfo dn = dn(context);
                if (dn != null && dn.isConnected()) {
                    if (1 == dn.getType()) {
                        return 100;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                    if (telephonyManager != null) {
                        int n = n(context, telephonyManager.getNetworkType());
                        if (n == 20) {
                            return 5;
                        }
                        switch (n) {
                        }
                        return 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6 A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9 A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af A[Catch: Exception -> 0x004b, TryCatch #0 {Exception -> 0x004b, blocks: (B:9:0x001a, B:11:0x002c, B:13:0x0039, B:14:0x003c, B:17:0x00a3, B:18:0x00a6, B:19:0x00a9, B:20:0x00ac, B:21:0x00af, B:22:0x0041, B:25:0x004e, B:28:0x0058, B:31:0x0062, B:34:0x006c, B:37:0x0077, B:40:0x007f, B:43:0x0087, B:46:0x008f, B:49:0x0097, B:52:0x00b4, B:54:0x00b8, B:56:0x00be, B:58:0x00c4, B:61:0x00cb, B:63:0x00d1, B:64:0x00d4, B:66:0x00da, B:67:0x00dd, B:74:0x00b2), top: B:7:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ao.e(android.content.Context, java.lang.String, boolean):int");
    }

    public static String f(Context context, boolean z) {
        if (z) {
            return "";
        }
        if (!TextUtils.isEmpty(beU)) {
            return beU;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                beU = telephonyManager.getSimOperator();
            } catch (Exception unused) {
            }
        }
        return beU;
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo dn = dn(context);
            if (dn == null) {
                return -1;
            }
            return dn.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        int defaultDataSubscriptionId;
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        return defaultDataSubscriptionId;
    }

    private static boolean hs(String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    public static boolean ht(String str) {
        return t(str, 3000);
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo dn = dn(context);
            if (dn != null && dn.isConnected()) {
                if (dn.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo dn = dn(context);
            if (dn != null) {
                if (dn.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo dn = dn(context);
            if (dn != null && dn.isConnected()) {
                return 1 == dn.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private static int n(Context context, int i) {
        ServiceState serviceState;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 || !SystemUtil.b(context, com.kuaishou.weapon.p0.g.b)) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                int subId = getSubId();
                if (subId == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else if (context.getApplicationInfo().targetSdkVersion < 29 || i2 < 29) {
                    try {
                        serviceState = (ServiceState) z.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                    } catch (Throwable unused) {
                        serviceState = telephonyManager.getServiceState();
                    }
                } else {
                    serviceState = telephonyManager.getServiceState();
                }
                if (serviceState != null) {
                    if (bb.Ta()) {
                        Integer num = (Integer) z.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                        return num != null ? num.intValue() : i;
                    }
                    if (hs(serviceState.toString())) {
                        return 20;
                    }
                    return i;
                }
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    private static boolean t(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
