package com.czhj.sdk.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.BatteryManager;
import android.os.Build;
import android.os.IBinder;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.pangle.wrapper.A5SV6n;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DeviceUtils {
    private static String A = null;
    private static Display B = null;
    private static final int b = 31457280;
    private static final String c = "getSimState";
    private static final String d = "getImei";
    private static final String e = "getLine1Number";
    private static final int f = 31457280;
    private static final int g = 104857600;
    private static final int h = -1;
    private static String i;
    private static String k;
    private static String l;
    private static String m;
    private static String n;
    private static boolean p;
    private static long q;
    private static long r;
    private static long s;
    private static long t;
    private static Network v;
    private static long w;
    private static String x;
    private static String y;
    private static String z;

    /* renamed from: a, reason: collision with root package name */
    static final String[] f10591a = {"/system/lib/libdroid4x.so", "/system/bin/mount.vboxsf", "/system/lib/vboxguest.ko", "/etc/mumu-configs", "/system/lib/vboxsf.ko", "/system/lib/vboxvideo.ko", "/data/.bluestacks.prop", "/system/bin/microvirt-vbox-sf", "/system/lib/tboxsf.ko", "/system/bin/androVM-vbox-sf", "/system/bin/microvirtd", "/system/bin/windroyed", "/system/lib/libdroid4x.so"};
    private static int j = 0;
    private static NetworkType o = NetworkType.UNKNOWN;
    private static ArrayList<Network> u = new ArrayList<>();

    public static class NetBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                DeviceUtils.updateNetworkType(context);
            }
        }
    }

    public enum NetworkType {
        UNKNOWN(0),
        ETHERNET(101),
        WIFI(100),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4),
        MOBILE_5G(5);

        private final int mId;

        static {
            TyGE();
        }

        NetworkType(int i) {
            this.mId = i;
        }

        private static /* synthetic */ void TyGE() {
            char[] charArray = "üðò±øþòú±ýðæ±ì÷úóó±ÕñöÝíöûøú".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 159);
            }
            String str = new String(charArray);
            char[] charArray2 = "üóöñöë".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 159);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static NetworkType b(Context context, int i) {
            if (i != 0) {
                if (i == 1) {
                    return WIFI;
                }
                if (i != 2 && i != 3 && i != 4 && i != 5) {
                    return i != 9 ? UNKNOWN : ETHERNET;
                }
            }
            return DeviceUtils.getDataNetworkType(context);
        }

        public int getId() {
            return this.mId;
        }

        @Override // java.lang.Enum
        public String toString() {
            return Integer.toString(this.mId);
        }
    }

    static {
        naNTve();
    }

    public static long diskCacheSizeBytes(File file, long j2) {
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j2 = (statFs.getBlockCount() * statFs.getBlockSize()) / 50;
        } catch (IllegalArgumentException unused) {
            SigmobLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
        }
        return Math.max(Math.min(j2, 104857600L), 31457280L);
    }

    public static NetworkType getActiveNetworkType() {
        return o;
    }

    public static String getAndroidId(Context context) {
        if (m == null && context != null) {
            try {
                SigmobLog.d("private : AndroidId");
                m = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                m = "";
                SigmobLog.e(th.getMessage());
                m = "";
            }
        }
        return m;
    }

    public static String getApkSha1OrMd5(Context context, String str) {
        Signature[] signatureArr;
        Signature signature;
        String str2;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("SHA1") && (str3 = x) != null) {
            return str3;
        }
        if (str.equals("MD5") && (str2 = y) != null) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                byte[] byteArray = signature.toByteArray();
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                        sb.append(":");
                    }
                    str4 = sb.substring(0, sb.length() - 1);
                    if (str.equals("SHA1")) {
                        x = str4;
                        return str4;
                    }
                    if (str.equals("MD5")) {
                        y = str4;
                    }
                }
            }
            return str4;
        } catch (Exception e2) {
            SigmobLog.e(e2.getMessage());
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static int getAppLaunchCount(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            SigmobLog.d("getAppLaunchCount==" + str);
            if (launchIntentForPackage == null) {
                return 0;
            }
            ComponentName component = launchIntentForPackage.getComponent();
            SigmobLog.d("getAppLaunchCount==" + str);
            Object invoke = Class.forName("com.android.internal.app.IUsageStats$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "usagestats"));
            if (invoke == null) {
                return 0;
            }
            Object invoke2 = invoke.getClass().getMethod("getPkgUsageStats", ComponentName.class).invoke(invoke, component);
            SigmobLog.d("getAppLaunchCount==" + str);
            if (invoke2 == null) {
                return 0;
            }
            Class<?> cls = Class.forName("com.android.internal.os.PkgUsageStats");
            SigmobLog.d("getAppLaunchCount==" + str);
            return cls.getDeclaredField("launchCount").getInt(invoke2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static float getBatteryLevel(Context context) {
        if (((BatteryManager) context.getSystemService("batterymanager")) == null) {
            return 0.0f;
        }
        return r1.getIntProperty(4) / 100.0f;
    }

    public static boolean getBatterySaveEnable(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        return batteryManager != null && batteryManager.getIntProperty(4) < 16;
    }

    public static int getBatteryState(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return 0;
        }
        int intProperty = i2 >= 26 ? batteryManager.getIntProperty(6) : 0;
        if (intProperty == 2) {
            return 2;
        }
        if (intProperty == 3 || intProperty == 4) {
            return 1;
        }
        return intProperty != 5 ? 0 : 3;
    }

    public static String getBlueToothName(Context context) {
        if (TextUtils.isEmpty(n)) {
            try {
                n = Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
        return n;
    }

    public static long getBootSystemTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String getCPUInfo() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static String getCell_ip() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "0.0.0.0";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "0.0.0.0";
        }
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (context != null) {
            return (ConnectivityManager) context.getSystemService("connectivity");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.czhj.sdk.common.utils.DeviceUtils.NetworkType getDataNetworkType(android.content.Context r4) {
        /*
            java.lang.String r0 = "getDataNetworkType "
            com.czhj.sdk.logger.SigmobLog.d(r0)
            android.telephony.TelephonyManager r1 = getTelephonyManager(r4)
            if (r1 == 0) goto L1b
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L16
            int r1 = com.bytedance.pangle.wrapper.A5SV6n.A5SV6n(r1)
            goto L1c
        L16:
            int r1 = r1.getNetworkType()     // Catch: java.lang.Exception -> L1b
            goto L1c
        L1b:
            r1 = 0
        L1c:
            android.net.ConnectivityManager r4 = getConnectivityManager(r4)
            if (r1 != 0) goto L2e
            if (r4 == 0) goto L2e
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()
            if (r4 == 0) goto L2e
            int r1 = r4.getSubtype()
        L2e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.czhj.sdk.logger.SigmobLog.d(r4)
            r4 = 20
            if (r1 == r4) goto L50
            switch(r1) {
                case 1: goto L4d;
                case 2: goto L4d;
                case 3: goto L4a;
                case 4: goto L4d;
                case 5: goto L4a;
                case 6: goto L4a;
                case 7: goto L4d;
                case 8: goto L4a;
                case 9: goto L4a;
                case 10: goto L4a;
                case 11: goto L4d;
                case 12: goto L4a;
                case 13: goto L47;
                case 14: goto L4a;
                case 15: goto L4a;
                default: goto L44;
            }
        L44:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE
            return r4
        L47:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_4G
            return r4
        L4a:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_3G
            return r4
        L4d:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_2G
            return r4
        L50:
            com.czhj.sdk.common.utils.DeviceUtils$NetworkType r4 = com.czhj.sdk.common.utils.DeviceUtils.NetworkType.MOBILE_5G
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.utils.DeviceUtils.getDataNetworkType(android.content.Context):com.czhj.sdk.common.utils.DeviceUtils$NetworkType");
    }

    public static float getDensityDpi(Context context) {
        try {
            return getRealMetrics(context).densityDpi;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return 0.0f;
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceDispaly() {
        return Build.DISPLAY;
    }

    public static Locale getDeviceLocale(Context context) {
        try {
            return context.getResources().getConfiguration().locale;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceName(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static int getDeviceOSLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getDeviceScreenHeightDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.screenHeightAsIntDips(context);
    }

    public static int getDeviceScreenRealHeightDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.pixelsToIntDips(getRealMetrics(context).heightPixels, context);
    }

    public static int getDeviceScreenRealWidthDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.pixelsToIntDips(getRealMetrics(context).widthPixels, context);
    }

    public static int getDeviceScreenWidthDip(Context context) {
        return Dips.screenWidthAsIntDips(context);
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getDeviceType(Context context) {
        return isTablet(context) ? "pad" : "phone";
    }

    public static Display getDisplay(Context context) {
        if (B == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return null;
            }
            B = windowManager.getDefaultDisplay();
        }
        return B;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static String getNetworkOperator(Context context) {
        String str = A;
        if (str != null) {
            return str;
        }
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager != null) {
            A = (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) ? telephonyManager.getSimOperator() : telephonyManager.getNetworkOperator();
            if (A == null) {
                A = "";
            }
        }
        return A;
    }

    public static String getNetworkOperatorForUrl(Context context) {
        return getNetworkOperator(context);
    }

    public static String getNetworkOperatorName(Context context) {
        String str = z;
        if (str != null) {
            return str;
        }
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager != null) {
            z = (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) ? telephonyManager.getSimOperatorName() : telephonyManager.getNetworkOperatorName();
            if (z == null) {
                z = "";
            }
        }
        return z;
    }

    public static int getOrientationInt(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static String getProperty(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static DisplayMetrics getRealMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = getDisplay(context);
        if (display == null) {
            return context.getResources().getDisplayMetrics();
        }
        display.getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String getRotation(Context context) {
        Display display = getDisplay(context);
        if (display == null) {
            return Constants.FAIL;
        }
        int rotation = display.getRotation();
        return rotation != 1 ? rotation != 2 ? rotation != 3 ? Constants.FAIL : "270" : "180" : "90";
    }

    public static String getSDCardPath(Context context) {
        List storageVolumes;
        boolean isRemovable;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (Build.VERSION.SDK_INT >= 24) {
            storageVolumes = storageManager.getStorageVolumes();
            Iterator it = storageVolumes.iterator();
            while (it.hasNext()) {
                StorageVolume ASJ6gh2 = A5SV6n.ASJ6gh(it.next());
                isRemovable = ASJ6gh2.isRemovable();
                if (isRemovable) {
                    try {
                        return (String) ASJ6gh2.getClass().getMethod("getPath", new Class[0]).invoke(ASJ6gh2, new Object[0]);
                    } catch (Exception e2) {
                        SigmobLog.e(e2.getMessage());
                    }
                }
            }
            return null;
        }
        try {
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    Object obj = Array.get(invoke, i2);
                    Object invoke2 = method3.invoke(obj, new Object[0]);
                    if ((invoke2 instanceof Boolean) && ((Boolean) invoke2).booleanValue()) {
                        Object invoke3 = method2.invoke(obj, new Object[0]);
                        if (invoke3 instanceof String) {
                            return (String) invoke3;
                        }
                        continue;
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static long getSysteTotalMemorySize(Context context) {
        long j2 = w;
        if (j2 > 0) {
            return j2;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                long j3 = memoryInfo.totalMem;
                w = j3;
                return j3;
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        return 0L;
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!isCanUsePhoneState(context)) {
                return null;
            }
        } catch (Throwable unused) {
        }
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static WindowManager getWindowManger(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static boolean isCanRetryIMEI() {
        boolean z2 = System.currentTimeMillis() - q > 30000;
        if (z2) {
            q = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryIMEI status " + z2);
        return z2;
    }

    public static boolean isCanRetryLocation() {
        boolean z2 = System.currentTimeMillis() - s > 36000;
        if (z2) {
            s = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryLocation status " + z2);
        return z2;
    }

    public static boolean isCanRetryWIFI() {
        boolean z2 = System.currentTimeMillis() - t > 30000;
        if (z2) {
            t = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryWIFI status " + z2);
        return z2;
    }

    public static boolean isCanUseLocation(Context context) {
        boolean z2 = context.checkCallingOrSelfPermission(g.h) == 0 || context.checkCallingOrSelfPermission(g.g) == 0;
        SigmobLog.d("isCanUseLocation status " + z2);
        return z2;
    }

    public static boolean isCanUsePhoneState(Context context) {
        return context.checkCallingOrSelfPermission(g.c) == 0;
    }

    public static boolean isCanUseWriteExternal(Context context) {
        boolean z2 = context.checkCallingOrSelfPermission(g.j) == 0;
        SigmobLog.d("isCanUseWriteExternal status " + z2);
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x0050, B:19:0x005e, B:20:0x0078, B:22:0x0084, B:24:0x008f, B:26:0x0097, B:28:0x00a2, B:30:0x00aa, B:31:0x00d2, B:33:0x00d8, B:35:0x00e5, B:45:0x00b0, B:47:0x00bc, B:48:0x00be, B:49:0x00c3, B:51:0x00cf, B:52:0x009d, B:53:0x008a, B:54:0x0064, B:56:0x006a, B:58:0x0072, B:59:0x003a, B:61:0x0042, B:63:0x004a, B:64:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[Catch: all -> 0x0020, TRY_ENTER, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x0050, B:19:0x005e, B:20:0x0078, B:22:0x0084, B:24:0x008f, B:26:0x0097, B:28:0x00a2, B:30:0x00aa, B:31:0x00d2, B:33:0x00d8, B:35:0x00e5, B:45:0x00b0, B:47:0x00bc, B:48:0x00be, B:49:0x00c3, B:51:0x00cf, B:52:0x009d, B:53:0x008a, B:54:0x0064, B:56:0x006a, B:58:0x0072, B:59:0x003a, B:61:0x0042, B:63:0x004a, B:64:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x0050, B:19:0x005e, B:20:0x0078, B:22:0x0084, B:24:0x008f, B:26:0x0097, B:28:0x00a2, B:30:0x00aa, B:31:0x00d2, B:33:0x00d8, B:35:0x00e5, B:45:0x00b0, B:47:0x00bc, B:48:0x00be, B:49:0x00c3, B:51:0x00cf, B:52:0x009d, B:53:0x008a, B:54:0x0064, B:56:0x006a, B:58:0x0072, B:59:0x003a, B:61:0x0042, B:63:0x004a, B:64:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x0050, B:19:0x005e, B:20:0x0078, B:22:0x0084, B:24:0x008f, B:26:0x0097, B:28:0x00a2, B:30:0x00aa, B:31:0x00d2, B:33:0x00d8, B:35:0x00e5, B:45:0x00b0, B:47:0x00bc, B:48:0x00be, B:49:0x00c3, B:51:0x00cf, B:52:0x009d, B:53:0x008a, B:54:0x0064, B:56:0x006a, B:58:0x0072, B:59:0x003a, B:61:0x0042, B:63:0x004a, B:64:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x0050, B:19:0x005e, B:20:0x0078, B:22:0x0084, B:24:0x008f, B:26:0x0097, B:28:0x00a2, B:30:0x00aa, B:31:0x00d2, B:33:0x00d8, B:35:0x00e5, B:45:0x00b0, B:47:0x00bc, B:48:0x00be, B:49:0x00c3, B:51:0x00cf, B:52:0x009d, B:53:0x008a, B:54:0x0064, B:56:0x006a, B:58:0x0072, B:59:0x003a, B:61:0x0042, B:63:0x004a, B:64:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0064 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x0050, B:19:0x005e, B:20:0x0078, B:22:0x0084, B:24:0x008f, B:26:0x0097, B:28:0x00a2, B:30:0x00aa, B:31:0x00d2, B:33:0x00d8, B:35:0x00e5, B:45:0x00b0, B:47:0x00bc, B:48:0x00be, B:49:0x00c3, B:51:0x00cf, B:52:0x009d, B:53:0x008a, B:54:0x0064, B:56:0x006a, B:58:0x0072, B:59:0x003a, B:61:0x0042, B:63:0x004a, B:64:0x0023), top: B:7:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x003a A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:8:0x000b, B:10:0x0017, B:13:0x0028, B:15:0x0034, B:16:0x0050, B:19:0x005e, B:20:0x0078, B:22:0x0084, B:24:0x008f, B:26:0x0097, B:28:0x00a2, B:30:0x00aa, B:31:0x00d2, B:33:0x00d8, B:35:0x00e5, B:45:0x00b0, B:47:0x00bc, B:48:0x00be, B:49:0x00c3, B:51:0x00cf, B:52:0x009d, B:53:0x008a, B:54:0x0064, B:56:0x006a, B:58:0x0072, B:59:0x003a, B:61:0x0042, B:63:0x004a, B:64:0x0023), top: B:7:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isEmulator() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.utils.DeviceUtils.isEmulator():boolean");
    }

    public static boolean isNetworkConnected() {
        return p;
    }

    public static boolean isNetworkValid(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4) || (Build.VERSION.SDK_INT >= 23 ? networkCapabilities.hasCapability(16) : false);
    }

    public static boolean isRoot() {
        if (A2egSU.BPw6Q8("/system/bin/su") && a("/system/bin/su")) {
            return true;
        }
        return A2egSU.BPw6Q8("/system/xbin/su") && a("/system/xbin/su");
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int memoryCacheSizeBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return 0;
        }
        long memoryClass = activityManager.getMemoryClass();
        try {
            if (a(context.getApplicationInfo().flags, ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null))) {
                memoryClass = ((Integer) new ReflectionUtil.MethodBuilder(activityManager, "getLargeMemoryClass").execute()).intValue();
            }
        } catch (Throwable unused) {
            SigmobLog.d("Unable to reflectively determine large heap size.");
        }
        return (int) Math.min(31457280L, (memoryClass / 8) * BaseConstants.MB_VALUE);
    }

    private static /* synthetic */ void naNTve() {
        char[] charArray = "§«©ê£¥©¡ê¦«½ê·¬¡¨¨ê\u008eª\u00ad\u0086¶\u00ad £¡".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 196);
        }
        String str = new String(charArray);
        char[] charArray2 = "§¨\u00adª\u00ad°".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 196);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @SuppressLint({"MissingPermission"})
    public static void registerNetworkChange(final Context context) {
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).addTransportType(1).build();
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.czhj.sdk.common.utils.DeviceUtils.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                SigmobLog.d("updateNetworkType registerNetworkCallback  onAvailable " + network.hashCode());
                super.onAvailable(network);
                DeviceUtils.u.add(network);
                DeviceUtils.updateNetworkType(context);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
                DeviceUtils.updateNetworkType(context);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                SigmobLog.d("updateNetworkType registerNetworkCallback onLost" + network.hashCode());
                super.onLost(network);
                NetworkType unused = DeviceUtils.o = NetworkType.UNKNOWN;
                boolean unused2 = DeviceUtils.p = false;
                try {
                    Network unused3 = DeviceUtils.v = network;
                    DeviceUtils.u.remove(network);
                    DeviceUtils.updateNetworkType(context);
                } catch (Throwable unused4) {
                }
            }
        });
    }

    public static void resetRetryIMEI() {
        q = 0L;
    }

    @SuppressLint({"MissingPermission"})
    public static void updateNetworkType(Context context) {
        NetworkType b2;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            if (a(context)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    activeNetwork = getConnectivityManager(context).getActiveNetwork();
                    if (activeNetwork == null || activeNetwork == v) {
                        NetworkCapabilities networkCapabilities2 = null;
                        for (int size = u.size() - 1; size >= 0; size--) {
                            networkCapabilities2 = getConnectivityManager(context).getNetworkCapabilities(u.get(size));
                            if (networkCapabilities2 != null) {
                                break;
                            }
                        }
                        networkCapabilities = networkCapabilities2;
                    } else {
                        networkCapabilities = getConnectivityManager(context).getNetworkCapabilities(activeNetwork);
                    }
                    if (networkCapabilities == null) {
                        return;
                    }
                    p = isNetworkValid(networkCapabilities);
                    b2 = (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(1)) ? NetworkType.WIFI : (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(0)) ? getDataNetworkType(context) : NetworkType.UNKNOWN;
                } else {
                    NetworkInfo activeNetworkInfo = getConnectivityManager(context).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        p = activeNetworkInfo.isAvailable();
                    }
                    b2 = NetworkType.b(context, activeNetworkInfo != null ? activeNetworkInfo.getType() : -1);
                }
                o = b2;
            }
        } catch (Exception unused) {
        }
    }

    private static boolean a(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private static boolean a(Context context) {
        return context.checkCallingOrSelfPermission(g.f12282a) == 0;
    }

    private static boolean a(String str) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ls -l " + str);
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (readLine != null && readLine.length() >= 4) {
                char charAt = readLine.charAt(3);
                if (charAt == 's' || charAt == 'x') {
                    process.destroy();
                    return true;
                }
            }
        } catch (Throwable unused) {
            if (process == null) {
                return false;
            }
        }
        process.destroy();
        return false;
    }
}
