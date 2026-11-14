package com.octopus.ad.internal.utilities;

import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.octopus.ad.internal.q;
import com.octopus.ad.model.g;
import com.octopus.ad.utils.OctUtil;
import com.octopus.ad.utils.b.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UserEnvInfoUtil {
    public static boolean hasGetIsp;

    private static g.d getNetworkClass(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
        if (networkInfo != null && networkInfo.isConnected()) {
            return g.d.NET_WIFI;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            if (ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.c) == 0) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return g.d.NET_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return g.d.NET_3G;
                    case 13:
                        return g.d.NET_4G;
                    default:
                        return g.d.NET_OTHER;
                }
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
        return g.d.NET_UNKNOWN;
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isUsingWifi(Context context) {
        return ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void retrieveUserEnvInfo(Context context) {
        int i;
        int i2;
        if (context == null || hasGetIsp) {
            return;
        }
        hasGetIsp = true;
        UserEnvInfo userEnvInfo = UserEnvInfo.getInstance();
        try {
            char c = 65535;
            if (q.a().f12512a > 1) {
                i = SPUtils.getInt(context, TKDownloadReason.KSAD_TK_NET, -1);
                i2 = SPUtils.getInt(context, "isp", -1);
            } else {
                i = -1;
                i2 = -1;
            }
            if (i == -1) {
                g.d networkClass = getNetworkClass(context);
                userEnvInfo.net = networkClass;
                SPUtils.put(context, TKDownloadReason.KSAD_TK_NET, Integer.valueOf(networkClass.a()));
            } else {
                userEnvInfo.net = g.d.a(i);
            }
            if (i2 == -1) {
                String info = OctUtil.a().getInfo(context, 1001);
                if (TextUtils.isEmpty(info)) {
                    userEnvInfo.isp = g.c.ISP_UNKNOWN;
                } else {
                    int hashCode = info.hashCode();
                    if (hashCode != 49679477) {
                        switch (hashCode) {
                            case 49679470:
                                if (info.equals("46000")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 49679471:
                                if (info.equals("46001")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 49679472:
                                if (info.equals("46002")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 49679473:
                                if (info.equals("46003")) {
                                    c = 4;
                                    break;
                                }
                                break;
                        }
                    } else if (info.equals("46007")) {
                        c = 2;
                    }
                    if (c == 0 || c == 1 || c == 2) {
                        userEnvInfo.isp = g.c.ISP_CN_MOBILE;
                    } else if (c == 3) {
                        userEnvInfo.isp = g.c.ISP_CN_UNICOM;
                    } else if (c != 4) {
                        userEnvInfo.isp = g.c.ISP_OTHER;
                    } else {
                        userEnvInfo.isp = g.c.ISP_CN_TEL;
                    }
                }
                SPUtils.put(context, "isp", Integer.valueOf(userEnvInfo.isp.a()));
            } else {
                userEnvInfo.isp = g.c.a(i2);
            }
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
        userEnvInfo.ip = "0.0.0.0";
    }
}
