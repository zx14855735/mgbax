package com.kwad.sdk.utils;

import BPw6Q8.AMqCpz;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityManager;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class br {
    private static String bfZ = null;
    private static String bga = "";
    private static boolean bgb = false;
    private static String bgc = "";
    private static String bgd = "";
    private static int bge;
    private static boolean bgf;
    private static int bgg;
    private static boolean bgh;
    private static String bgm;
    private static String bgn;
    private static int bgv;
    private static long bgw;
    private static final String[] bgi = {"", ""};
    private static String bgj = "";
    private static String bgk = "";
    private static String bgl = "";
    private static int bgo = -1;
    private static boolean bgp = false;
    private static boolean bgq = false;
    private static boolean bgr = false;
    private static boolean bgs = false;
    private static boolean bgt = false;
    private static boolean bgu = false;
    private static String bgx = "";
    private static String bgy = "";
    public static String bgz = "";
    private static final List<String> bgA = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    static {
        yKFyYB();
    }

    private static long TE() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long TG() {
        return com.kwad.sdk.crash.utils.h.L(Environment.getDataDirectory());
    }

    public static long TH() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long TI() {
        long freeMemory;
        try {
            freeMemory = Runtime.getRuntime().freeMemory();
        } catch (Throwable unused) {
        }
        if (freeMemory > 0) {
            return freeMemory;
        }
        return 0L;
    }

    public static int TJ() {
        int i = bgv;
        if (i > 0) {
            return i;
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        bgv = availableProcessors;
        return availableProcessors;
    }

    public static String TK() {
        return Build.MODEL;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0013, B:12:0x0021, B:14:0x0027, B:16:0x002d, B:17:0x0030, B:19:0x0036, B:21:0x0040, B:22:0x0043, B:24:0x0049, B:26:0x0053, B:27:0x0056, B:29:0x005c, B:31:0x0066, B:32:0x0069, B:34:0x006f), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized long TL() {
        /*
            java.lang.Class<com.kwad.sdk.utils.br> r0 = com.kwad.sdk.utils.br.class
            monitor-enter(r0)
            boolean r1 = com.kwad.sdk.utils.bc.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            java.lang.String r1 = com.kwad.sdk.utils.bc.getDevImei()     // Catch: java.lang.Throwable -> L1a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1c
            java.lang.String[] r1 = com.kwad.sdk.utils.bc.getDevImeis()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1f
            goto L1c
        L1a:
            r1 = move-exception
            goto L7a
        L1c:
            r1 = 1
            goto L21
        L1f:
            r1 = 0
        L21:
            boolean r3 = com.kwad.sdk.utils.bc.readLocationDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            com.kwad.sdk.internal.api.a r3 = com.kwad.sdk.utils.bc.Tf()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L30
            r3 = 64
            long r1 = r1 | r3
        L30:
            boolean r3 = com.kwad.sdk.utils.bc.usePhoneStateDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L43
            java.lang.String r3 = com.kwad.sdk.utils.bc.getDevAndroidId()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L43
            r3 = 2
            long r1 = r1 | r3
        L43:
            boolean r3 = com.kwad.sdk.utils.bc.useMacAddressDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L56
            java.lang.String r3 = com.kwad.sdk.utils.bc.getDevMacAddress()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L56
            r3 = 4
            long r1 = r1 | r3
        L56:
            boolean r3 = com.kwad.sdk.utils.bc.useOaidDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L69
            java.lang.String r3 = com.kwad.sdk.utils.bc.getDevOaid()     // Catch: java.lang.Throwable -> L1a
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L69
            r3 = 2048(0x800, double:1.0118E-320)
            long r1 = r1 | r3
        L69:
            boolean r3 = com.kwad.sdk.utils.bc.readInstalledPackagesDisable()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            java.util.List r3 = com.kwad.sdk.utils.bc.getDevInstalledPackages()     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L78
            r3 = 16
            long r1 = r1 | r3
        L78:
            monitor-exit(r0)
            return r1
        L7a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.br.TL():long");
    }

    public static String TM() {
        return Build.BRAND;
    }

    public static String TN() {
        return Build.CPU_ABI;
    }

    public static synchronized long TO() {
        long elapsedRealtime;
        synchronized (br.class) {
            elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        }
        return elapsedRealtime;
    }

    public static synchronized long TP() {
        long j;
        synchronized (br.class) {
            j = Build.TIME;
        }
        return j;
    }

    public static synchronized String TQ() {
        String str;
        synchronized (br.class) {
            str = Build.FINGERPRINT;
        }
        return str;
    }

    public static synchronized String TR() {
        synchronized (br.class) {
            if (!TextUtils.isEmpty(bfZ)) {
                return bfZ;
            }
            String radioVersion = Build.getRadioVersion();
            bfZ = radioVersion;
            return radioVersion;
        }
    }

    public static synchronized String TS() {
        String name;
        synchronized (br.class) {
            name = bb.getName();
        }
        return name;
    }

    public static synchronized String TT() {
        String version;
        synchronized (br.class) {
            version = bb.getVersion();
        }
        return version;
    }

    public static String TU() {
        return Build.MANUFACTURER;
    }

    public static int TV() {
        if (bgo == -1) {
            bgo = em(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return bgo;
    }

    public static String TW() {
        if (TextUtils.isEmpty(bgn)) {
            try {
                bgn = System.getProperty("os.arch");
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return bgn;
    }

    public static int TX() {
        return Build.VERSION.SDK_INT;
    }

    public static String TY() {
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(bgz)) {
            return bgz;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        bgz = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String TZ() {
        String h = ag.h("ksadsdk_pref", "random_android_id", "");
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        String Ua = Ua();
        if (TextUtils.isEmpty(Ua)) {
            return "";
        }
        hP(Ua);
        ag.a("ksadsdk_pref", "random_android_id", Ua, true);
        return Ua;
    }

    private static String Ua() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String Ub() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String h = ag.h("ksadsdk_pref", "android_id", (String) null);
        ag.i(h, "ksadsdk_pref", "android_id");
        return h;
    }

    private static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (str.length() + sb.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static int checkSelfPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static String cr(boolean z) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String appOAID = com.kwad.sdk.core.e.a.getAppOAID(context);
        return (TextUtils.isEmpty(appOAID) && !z && TextUtils.isEmpty(ef(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dj() : appOAID;
    }

    @SuppressLint({"HardwareIds"})
    public static String dB(Context context) {
        if (!TextUtils.isEmpty(bgl) || context == null || bgs) {
            return bgl;
        }
        if (bc.usePhoneStateDisable()) {
            return bc.getDevAndroidId();
        }
        if (!s.RH()) {
            return bgl;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            bgl = string;
            if (!hO(string)) {
                bgl = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(bgl)) {
            bgs = true;
        }
        return bgl;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String dF(Context context) {
        synchronized (br.class) {
            if (context != null) {
                if (!bgq && TextUtils.isEmpty(bgj) && SystemUtil.dZ(context) && !bc.usePhoneStateDisable() && s.RO()) {
                    try {
                        bgj = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                    } catch (Exception unused) {
                    }
                    bgq = TextUtils.isEmpty(bgj);
                    return bgj;
                }
            }
            return bgj;
        }
    }

    public static long ea(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int ed(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long ee(Context context) {
        long j = bgw;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            if (j2 <= 0) {
                j2 = TE();
            }
            bgw = j2;
            return j2;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String ef(Context context) {
        boolean z;
        synchronized (br.class) {
            if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
                return bc.getDevImei();
            }
            if (bgp) {
                return bgc;
            }
            if (TextUtils.isEmpty(bgc) && context != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return bgc;
                }
                if (bc.usePhoneStateDisable()) {
                    return bgc;
                }
                if (!s.RN()) {
                    return bgc;
                }
                try {
                    z = SystemUtil.dZ(context);
                    if (z) {
                        try {
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            bgc = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                bgp = true;
                            }
                        } catch (Exception e) {
                            e = e;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            if (z) {
                                bgp = true;
                            }
                            return bgc;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                }
                return bgc;
            }
            return bgc;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String eg(Context context) {
        boolean z;
        String meid;
        synchronized (br.class) {
            if (bgu) {
                return bgd;
            }
            if (TextUtils.isEmpty(bgd) && context != null) {
                if (bc.usePhoneStateDisable()) {
                    return bgd;
                }
                if (!s.RM()) {
                    return bgl;
                }
                try {
                    z = SystemUtil.dZ(context);
                    if (z) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    meid = telephonyManager.getMeid();
                                    bgd = meid;
                                    if (TextUtils.isEmpty(meid)) {
                                        bgu = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 2) {
                                    String deviceId = telephonyManager.getDeviceId();
                                    bgd = deviceId;
                                    if (TextUtils.isEmpty(deviceId)) {
                                        bgu = true;
                                    }
                                } else {
                                    bgd = null;
                                    bgu = true;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            if (z) {
                                bgu = true;
                            }
                            return bgd;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                }
                return bgd;
            }
            return bgd;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String[] eh(Context context) {
        String deviceId;
        String imei;
        synchronized (br.class) {
            if (bc.usePhoneStateDisable() && bc.getDevImeis() != null) {
                return bc.getDevImeis();
            }
            if (bgt) {
                return bgi;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return bgi;
            }
            String[] strArr = bgi;
            boolean z = false;
            if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
                if (bc.usePhoneStateDisable()) {
                    return strArr;
                }
                if (!s.RN()) {
                    return strArr;
                }
                try {
                    boolean dZ = SystemUtil.dZ(context);
                    if (dZ) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (i >= 26) {
                                    int min = Math.min(ei(context), 2);
                                    for (int i2 = 0; i2 < min; i2++) {
                                        String[] strArr2 = bgi;
                                        imei = telephonyManager.getImei(i2);
                                        strArr2[i2] = imei;
                                    }
                                    String[] strArr3 = bgi;
                                    if (TextUtils.isEmpty(strArr3[0]) && TextUtils.isEmpty(strArr3[1])) {
                                        bgt = true;
                                    }
                                } else if (telephonyManager.getPhoneType() == 1) {
                                    if (i >= 23) {
                                        int min2 = Math.min(ei(context), 2);
                                        for (int i3 = 0; i3 < min2; i3++) {
                                            String[] strArr4 = bgi;
                                            deviceId = telephonyManager.getDeviceId(i3);
                                            strArr4[i3] = deviceId;
                                        }
                                    } else {
                                        strArr[0] = telephonyManager.getDeviceId();
                                        strArr[1] = null;
                                    }
                                    String[] strArr5 = bgi;
                                    if (TextUtils.isEmpty(strArr5[0]) && TextUtils.isEmpty(strArr5[1])) {
                                        bgt = true;
                                    }
                                } else {
                                    strArr[0] = null;
                                    strArr[1] = null;
                                    bgt = true;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            z = dZ;
                            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            if (z) {
                                bgt = true;
                            }
                            return bgi;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                return bgi;
            }
            return strArr;
        }
    }

    public static synchronized int ei(Context context) {
        int phoneCount;
        synchronized (br.class) {
            if (bgf || bge > 0 || Build.VERSION.SDK_INT < 23 || context == null || bc.usePhoneStateDisable()) {
                return bge;
            }
            try {
                phoneCount = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                bge = phoneCount;
            } catch (Exception unused) {
            }
            int i = bge;
            bgf = i == 0;
            return i;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int ej(Context context) {
        int activeSubscriptionInfoCount;
        if (context == null || bgg > 0 || bgh || Build.VERSION.SDK_INT < 22 || !SystemUtil.dZ(context) || bc.usePhoneStateDisable()) {
            return bgg;
        }
        try {
            activeSubscriptionInfoCount = AMqCpz.ASJ6gh(context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            bgg = activeSubscriptionInfoCount;
        } catch (Throwable unused) {
        }
        int i = bgg;
        bgh = i != 0;
        return i;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String ek(Context context) {
        if (!TextUtils.isEmpty(bgk) || context == null) {
            return bgk;
        }
        if (bgr) {
            return bgk;
        }
        if (bc.usePhoneStateDisable()) {
            return bgk;
        }
        if (!s.RP()) {
            return bgk;
        }
        try {
            if (SystemUtil.dZ(context)) {
                bgk = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            bgk = null;
        }
        if (TextUtils.isEmpty(bgk)) {
            bgr = true;
        }
        String str = TextUtils.isEmpty(bgk) ? "" : bgk;
        bgk = str;
        return str;
    }

    public static synchronized int el(Context context) {
        int ringerMode;
        synchronized (br.class) {
            try {
                ringerMode = ((AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO)).getRingerMode();
            } catch (Exception unused) {
                return -1;
            }
        }
        return ringerMode;
    }

    private static boolean em(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String en(Context context) {
        synchronized (br.class) {
            if (TextUtils.isEmpty(bga) && context != null && !bgb) {
                if (bc.useMacAddressDisable()) {
                    String devMacAddress = bc.getDevMacAddress();
                    bga = devMacAddress;
                    return devMacAddress;
                }
                if (!s.RI()) {
                    return bga;
                }
                try {
                    WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        bga = connectionInfo.getMacAddress();
                    }
                    if (hM(bga)) {
                        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            NetworkInterface networkInterface = (NetworkInterface) it.next();
                            if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                if (hardwareAddress != null && hardwareAddress.length != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    for (byte b : hardwareAddress) {
                                        sb.append(String.format("%02X:", Byte.valueOf(b)));
                                    }
                                    if (sb.length() > 0) {
                                        sb.deleteCharAt(sb.length() - 1);
                                    }
                                    bga = sb.toString();
                                }
                            }
                        }
                    }
                    if (hM(bga)) {
                        bga = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                    }
                    if (!hM(bga)) {
                        bga = bga.toUpperCase(Locale.US);
                    }
                } catch (Exception unused) {
                    bgb = true;
                }
                bgb = hM(bga);
                return bga;
            }
            return bga;
        }
    }

    public static List<String> eo(Context context) {
        String[] list;
        if (d.cA(context)) {
            return new ArrayList();
        }
        if (!ep(context)) {
            return new ArrayList();
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static boolean ep(Context context) {
        if (context.getApplicationInfo().targetSdkVersion < 30 || Build.VERSION.SDK_INT < 30) {
            return context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.j) == 0;
        }
        return false;
    }

    public static Pair<Boolean, Boolean> eq(Context context) {
        boolean z;
        AccessibilityManager accessibilityManager;
        boolean isEnabled;
        boolean z2 = false;
        try {
            accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            accessibilityManager.getEnabledAccessibilityServiceList(16);
            isEnabled = accessibilityManager.isEnabled();
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean z3 = !accessibilityManager.getEnabledAccessibilityServiceList(16).isEmpty();
            try {
                return new Pair<>(Boolean.valueOf(isEnabled), Boolean.valueOf(z3));
            } catch (Throwable th2) {
                th = th2;
                z = z3;
                z2 = isEnabled;
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return new Pair<>(Boolean.valueOf(z2), Boolean.valueOf(z));
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = isEnabled;
            z = false;
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return new Pair<>(Boolean.valueOf(z2), Boolean.valueOf(z));
        }
    }

    public static String getDeviceId() {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(bgm)) {
            return bgm;
        }
        String Ub = Ub();
        if (!TextUtils.isEmpty(Ub)) {
            String str = "ANDROID_" + Ub;
            bgm = str;
            return str;
        }
        String dB = dB(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (!TextUtils.isEmpty(dB) && !hN(dB) && hO(dB)) {
            String str2 = "ANDROID_" + dB;
            bgm = str2;
            return str2;
        }
        String TZ = TZ();
        if (!TextUtils.isEmpty(TZ)) {
            String str3 = "ANDROID_" + TZ;
            bgm = str3;
            return str3;
        }
        return "ANDROID_";
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale;
        LocaleList localeList;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i;
        int i2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int height = bounds.height();
            i = insets.top;
            i2 = insets.bottom;
            return (height - i) - i2;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowInsets windowInsets;
        int systemBars;
        Insets insets;
        int i;
        int i2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            windowInsets = currentWindowMetrics.getWindowInsets();
            systemBars = WindowInsets.Type.systemBars();
            insets = windowInsets.getInsets(systemBars);
            int width = bounds.width();
            i = insets.left;
            i2 = insets.right;
            return (width - i) - i2;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean hM(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean hN(String str) {
        return bgA.contains(str.toLowerCase(Locale.US));
    }

    private static boolean hO(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void hP(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        ag.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String hQ(String str) {
        StructStat stat;
        StructTimespec structTimespec;
        StructTimespec structTimespec2;
        long j;
        StructTimespec structTimespec3;
        long j2;
        String valueOf;
        if (!TextUtils.isEmpty(bgy) || TextUtils.isEmpty(str)) {
            return bgy;
        }
        int i = Build.VERSION.SDK_INT;
        try {
            stat = Os.stat(str);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (stat == null) {
            return bgy;
        }
        String str2 = "";
        if (i >= 27) {
            structTimespec = stat.st_atim;
            if (structTimespec == null) {
                valueOf = "";
            } else {
                structTimespec2 = stat.st_atim;
                j = structTimespec2.tv_sec;
                str2 = String.valueOf(j);
                structTimespec3 = stat.st_atim;
                j2 = structTimespec3.tv_nsec;
                valueOf = String.valueOf(j2);
            }
            bgy = str2 + "." + valueOf;
        } else {
            long j3 = stat.st_atime;
            if (j3 != 0) {
                str2 = String.valueOf(j3);
            }
            bgy = str2;
        }
        return bgy;
    }

    private static /* synthetic */ void yKFyYB() {
        char[] charArray = "fjh+bdh`+gj|+vm`ii+OklGwlab`".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 5);
        }
        String str = new String(charArray);
        char[] charArray2 = "filklq".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 5);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String z(Context context, boolean z) {
        if (bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei())) {
            return bc.getDevImei();
        }
        String ef = ef(context);
        return (TextUtils.isEmpty(ef) && !z && TextUtils.isEmpty(com.kwad.sdk.core.e.a.getAppOAID(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Di() : ef;
    }
}
