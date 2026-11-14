package com.czhj.sdk.common;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import com.czhj.devicehelper.DeviceHelper;
import com.czhj.devicehelper.cnoaid.c;
import com.czhj.devicehelper.msaoaId.a;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.Database.SQLiteTrackHelper;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.mta.BuriedPointManager;
import com.czhj.sdk.common.network.SigmobRequestUtil;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.AdvertisingId;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.common.utils.IdentifierManager;
import com.czhj.sdk.common.utils.SharedPreferencesUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.downloader.f;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ClientMetadata implements IdentifierManager.AdvertisingIdChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f10536a = new AtomicInteger(1);
    private static String b = "-1";
    private static String c;
    private static volatile ClientMetadata d;
    private static String g;
    private int A;
    private boolean B;
    private long C;
    private Location e;
    private IdentifierManager f;
    private int h;
    private String j;
    private String k;
    private String l;
    private String m;
    private Context n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private long u;
    private int v;
    private int w;
    private Display x;
    private RepeatingHandlerRunnable y;
    private boolean i = true;
    private boolean z = false;

    public enum a {
        FORCE_PORTRAIT("portrait"),
        FORCE_LANDSCAPE("landscape"),
        DEVICE_ORIENTATION("device"),
        UNDEFINED("");

        private final String mKey;

        static {
            nxyXC();
        }

        a(String str) {
            this.mKey = str;
        }

        private static /* synthetic */ void nxyXC() {
            char[] charArray = "\u0093\u009f\u009dÞ\u0097\u0091\u009d\u0095Þ\u0092\u009f\u0089Þ\u0083\u0098\u0095\u009c\u009cÞº\u009e\u0099²\u0082\u0099\u0094\u0097\u0095".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 240);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0093\u009c\u0099\u009e\u0099\u0084".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 240);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        uDyXYNN();
    }

    private String c() {
        try {
            if (Build.VERSION.SDK_INT > 28 && !Config.sharedInstance().getOaidApiDisable()) {
                if (!TextUtils.isEmpty(this.s)) {
                    return this.s;
                }
                if (this.A <= 10 && !this.B && System.currentTimeMillis() - this.C >= 1000) {
                    this.C = System.currentTimeMillis();
                    this.B = true;
                    this.A++;
                    com.czhj.devicehelper.cnoaid.a.a(this.n, new c() { // from class: com.czhj.sdk.common.ClientMetadata.2
                        @Override // com.czhj.devicehelper.cnoaid.c
                        public void a(Exception exc) {
                            ClientMetadata.this.B = false;
                        }

                        @Override // com.czhj.devicehelper.cnoaid.c
                        public void a(String str) {
                            ClientMetadata.this.B = false;
                            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(ClientMetadata.this.s)) {
                                return;
                            }
                            ClientMetadata.this.s = str;
                            if (str.equalsIgnoreCase(ClientMetadata.this.p)) {
                                return;
                            }
                            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(ClientMetadata.this.n).edit();
                            edit.putString("oaid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
                            edit.apply();
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private boolean d() {
        return !this.n.getPackageManager().queryIntentActivities(new Intent("android.settings.USAGE_ACCESS_SETTINGS"), 65536).isEmpty();
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = f10536a;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static Long getBootSystemTime() {
        return Long.valueOf(DeviceUtils.getBootSystemTime());
    }

    public static String getCPUInfo() {
        try {
            return DeviceUtils.getCPUInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getCPUModel() {
        return Build.BOARD;
    }

    public static String getCell_ip() {
        return DeviceUtils.getCell_ip();
    }

    public static String getDeviceBrand() {
        return DeviceUtils.getDeviceBrand();
    }

    public static String getDeviceManufacturer() {
        return DeviceUtils.getDeviceManufacturer();
    }

    public static String getDeviceModel() {
        return DeviceUtils.getDeviceModel();
    }

    public static Integer getDeviceOSLevel() {
        return Integer.valueOf(DeviceUtils.getDeviceOSLevel());
    }

    public static String getDeviceOsVersion() {
        return DeviceUtils.getDeviceOsVersion();
    }

    public static ClientMetadata getInstance() {
        if (d == null) {
            synchronized (ClientMetadata.class) {
                try {
                    if (d == null) {
                        d = new ClientMetadata();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public static String getMacAddress() {
        try {
            return DeviceHelper.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static PackageInfo getPackageInfoWithUri(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, String> getQueryParamMap(Uri uri) {
        HashMap hashMap = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            hashMap.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
        }
        return hashMap;
    }

    public static String getUid() {
        return g;
    }

    public static String getUserId() {
        return TextUtils.isEmpty(b) ? "-1" : b;
    }

    public static String getVAID() {
        try {
            return DeviceHelper.getVAID();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isEmulator() {
        try {
            return DeviceUtils.isEmulator();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context == null) {
            return false;
        }
        checkSelfPermission = context.checkSelfPermission(str);
        return checkSelfPermission == 0;
    }

    public static boolean isRoot() {
        try {
            return DeviceUtils.isRoot();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setOAIDCertPem(String str) {
        try {
            com.czhj.devicehelper.msaoaId.a.a(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setOaidCertFileName(String str) {
        try {
            com.czhj.devicehelper.msaoaId.a.b(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = str;
    }

    private static /* synthetic */ void uDyXYNN() {
        char[] charArray = "ÈÄÆ\u0085ÌÊÆÎ\u0085ÉÄÒ\u0085ØÃÎÇÇ\u0085áÅÂéÙÂÏÌÎ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 171);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÈÇÂÅÂß".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 171);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public DownloadManager a() {
        return (DownloadManager) this.n.getSystemService("download");
    }

    public int getActiveNetworkType() {
        try {
            return DeviceUtils.getActiveNetworkType().getId();
        } catch (Throwable unused) {
            return DeviceUtils.NetworkType.UNKNOWN.getId();
        }
    }

    public String getAdvertisingId() {
        return null;
    }

    public String getAndroidId() {
        try {
            return DeviceUtils.getAndroidId(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApkMd5() {
        try {
            return DeviceUtils.getApkSha1OrMd5(this.n, "MD5");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApkSha1() {
        try {
            return DeviceUtils.getApkSha1OrMd5(this.n, "SHA1");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getAppName() {
        return AppPackageUtil.getAppName(this.n);
    }

    public String getAppPackageName() {
        try {
            return AppPackageUtil.getAppPackageName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getAppVersion() {
        try {
            return AppPackageUtil.getAppVersionFromContext(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Float getBatteryLevel() {
        try {
            return Float.valueOf(DeviceUtils.getBatteryLevel(this.n));
        } catch (Throwable unused) {
            return Float.valueOf(0.0f);
        }
    }

    public Boolean getBatterySaveEnable() {
        try {
            return Boolean.valueOf(DeviceUtils.getBatterySaveEnable(this.n));
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    public Integer getBatteryState() {
        try {
            return Integer.valueOf(DeviceUtils.getBatteryState(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getBlueToothName() {
        try {
            return DeviceUtils.getBlueToothName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getBootId() {
        try {
        } catch (Throwable th) {
            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("getBootId: error = "));
        }
        if (Config.sharedInstance().isDisableBootMark()) {
            return "";
        }
        if (TextUtils.isEmpty(c)) {
            return c;
        }
        String replaceAll = c.replaceAll("\\s*|\t|\r|\n", "");
        c = replaceAll;
        if (replaceAll.length() > 36) {
            c = c.substring(0, 36);
        }
        SigmobLog.i("getBootId: bootId = " + c);
        return c;
    }

    public Context getContext() {
        return this.n;
    }

    public int getDensityDpi() {
        try {
            return (int) DeviceUtils.getDensityDpi(this.n);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getDeviceId() {
        try {
            return getDeviceId(-1);
        } catch (Throwable th) {
            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("getDeviceId:"));
            return null;
        }
    }

    public Locale getDeviceLocale() {
        try {
            return DeviceUtils.getDeviceLocale(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getDeviceName() {
        try {
            return DeviceUtils.getDeviceName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenHeightDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenHeightDip(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public Integer getDeviceScreenRealHeightDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenRealHeightDip(this.n));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenRealWidthDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenRealWidthDip(this.n));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenWidthDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenWidthDip(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getDeviceSerial() {
        try {
            return DeviceUtils.getDeviceSerial();
        } catch (Throwable unused) {
            return null;
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        try {
            return DeviceUtils.getDisplayMetrics(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getIMSI() {
        try {
            return DeviceHelper.getIMSI(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getInsetBottom() {
        return this.h;
    }

    public long getInstallTime() {
        return this.u;
    }

    public boolean getLimitAdTrackingEnabled() {
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public Location getLocation() {
        if (!this.o) {
            return null;
        }
        Location location = this.e;
        if (location != null) {
            return location;
        }
        LocationManager locationManager = getLocationManager();
        if (locationManager != null && DeviceUtils.isCanRetryLocation()) {
            SigmobLog.d("private :use_location ");
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation != null) {
                this.e = lastKnownLocation;
            }
        }
        return this.e;
    }

    public LocationManager getLocationManager() {
        try {
            if (DeviceUtils.isCanUseLocation(this.n)) {
                return (LocationManager) this.n.getSystemService("location");
            }
            return null;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public String getNetworkOperatorForUrl() {
        try {
            return DeviceUtils.getNetworkOperatorForUrl(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getNetworkOperatorName() {
        try {
            return DeviceUtils.getNetworkOperatorName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getOAID() {
        int disable_up_OAid = Config.sharedInstance().getDisable_up_OAid();
        boolean oaidApiDisable = Config.sharedInstance().getOaidApiDisable();
        if ((disable_up_OAid < 0 || disable_up_OAid > 1) && oaidApiDisable) {
            return null;
        }
        String oaid_sdk = getOAID_SDK();
        if (TextUtils.isEmpty(oaid_sdk) && this.z) {
            oaid_sdk = c();
        }
        if (TextUtils.isEmpty(oaid_sdk) || oaid_sdk.equalsIgnoreCase(this.p)) {
            return this.p;
        }
        this.p = oaid_sdk;
        return oaid_sdk;
    }

    public String getOAID_API() {
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    public String getOAID_SDK() {
        boolean z = 1;
        z = 1;
        z = 1;
        z = 1;
        try {
            int disable_up_OAid = Config.sharedInstance().getDisable_up_OAid();
            if (disable_up_OAid == 0 ? Build.VERSION.SDK_INT > 28 : !(disable_up_OAid != 1 || Build.VERSION.SDK_INT < 23)) {
                z = b();
                return z;
            }
        } catch (Throwable unused) {
        }
        this.B = z;
        return null;
    }

    public Integer getOrientationInt() {
        try {
            return Integer.valueOf(DeviceUtils.getOrientationInt(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getPermission(Context context) {
        StringBuilder sb;
        String str = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            String[] strArr = packageManager.getPackageInfo(packageName, f.a.c).requestedPermissions;
            for (int i = 0; i < strArr.length; i++) {
                if (packageManager.checkPermission(strArr[i], packageName) == 0) {
                    if (i == strArr.length - 1) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append(strArr[i]);
                    } else {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append(strArr[i]);
                        sb.append(",");
                    }
                    str = sb.toString();
                }
            }
            SigmobLog.d("permissionReq:" + str);
            return !TextUtils.isEmpty(str) ? Base64.encodeToString(str.getBytes(), 2) : str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public DisplayMetrics getRealMetrics() {
        try {
            return DeviceUtils.getRealMetrics(this.n);
        } catch (Throwable unused) {
            return DeviceUtils.getDisplayMetrics(this.n);
        }
    }

    public String getRotation() {
        try {
            return DeviceUtils.getRotation(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getSDCardPath() {
        try {
            return DeviceUtils.getSDCardPath(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getScreenOrientation(Context context) {
        Display display = DeviceUtils.getDisplay(context);
        if (display == null) {
            return 0;
        }
        return display.getRotation();
    }

    public String getStringResources(String str, String str2) {
        Resources resources;
        int identifier;
        Context context = this.n;
        return (context == null || (resources = context.getResources()) == null || (identifier = resources.getIdentifier(str, "string", this.n.getPackageName())) == 0) ? str2 : resources.getString(identifier);
    }

    public int getStyleResources(String str) {
        Resources resources;
        Context context = this.n;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getIdentifier(str, "style", this.n.getPackageName());
    }

    public Long getSystemTotalMemorySize() {
        try {
            return Long.valueOf(DeviceUtils.getSysteTotalMemorySize(this.n));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getTargetSdkVersion() {
        try {
            if (!TextUtils.isEmpty(this.t)) {
                return this.t;
            }
            String valueOf = String.valueOf(this.n.getApplicationInfo().targetSdkVersion);
            this.t = valueOf;
            return valueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUDID() {
        String str = this.r;
        if (str != null) {
            return str;
        }
        this.r = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
        edit.putString("sig_UDID", this.r);
        edit.apply();
        return this.r;
    }

    public String getUpdateId() {
        try {
            if (Config.sharedInstance().isDisableBootMark()) {
                return "";
            }
        } catch (Throwable th) {
            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("getUpdateId: error = "));
        }
        return this.m;
    }

    public String getWifiName() {
        try {
            return DeviceHelper.getWifiName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getWifimac() {
        try {
            return DeviceHelper.getWifimac(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void initialize(Context context) {
        try {
            if (this.n == null) {
                Context applicationContext = context.getApplicationContext();
                this.n = applicationContext;
                long j = SharedPreferencesUtil.getSharedPreferences(applicationContext).getLong("install_time", 0L);
                this.u = j;
                if (j == 0) {
                    PackageInfo packageInfo = AppPackageUtil.getPackageInfo(context);
                    this.u = packageInfo == null ? System.currentTimeMillis() / 1000 : packageInfo.firstInstallTime / 1000;
                    SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
                    edit.putLong("install_time", this.u);
                    edit.apply();
                }
                this.r = SharedPreferencesUtil.getSharedPreferences(this.n).getString("sig_UDID", null);
                String string = SharedPreferencesUtil.getSharedPreferences(this.n).getString("uid_aes_gcm", null);
                if (string != null) {
                    g = AESUtil.DecryptString(string, Constants.AESKEY);
                } else {
                    String string2 = SharedPreferencesUtil.getSharedPreferences(this.n).getString("uid", null);
                    g = string2;
                    if (string2 != null) {
                        SharedPreferences.Editor edit2 = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
                        edit2.remove("uid");
                        edit2.putString("uid_aes_gcm", AESUtil.EncryptString(g, Constants.AESKEY));
                        edit2.apply();
                    }
                }
                String string3 = SharedPreferencesUtil.getSharedPreferences(this.n).getString("oaid_aes_gcm", null);
                if (string3 != null) {
                    this.p = AESUtil.DecryptString(string3, Constants.AESKEY);
                } else {
                    String string4 = SharedPreferencesUtil.getSharedPreferences(this.n).getString("oaid", null);
                    this.p = string4;
                    if (string4 != null) {
                        SharedPreferences.Editor edit3 = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
                        edit3.remove("oaid");
                        edit3.putString("oaid_aes_gcm", AESUtil.EncryptString(this.p, Constants.AESKEY));
                        edit3.apply();
                    }
                }
                this.f = new IdentifierManager(this.n, this);
                SQLiteMTAHelper.initialize(this.n);
                SQLiteTrackHelper.initialize(this.n);
                BuriedPointManager.getInstance().start();
                DeviceUtils.registerNetworkChange(this.n);
                TrackManager.getInstance().startRetryTracking();
                ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new A2egSU(0));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean isNetworkConnected(String str) {
        try {
            return SigmobRequestUtil.isConnection(new URL(str).getHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isRetryAble() {
        return this.i;
    }

    public boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public boolean isTablet() {
        try {
            return DeviceUtils.isTablet(this.n);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.czhj.sdk.common.utils.IdentifierManager.AdvertisingIdChangeListener
    public void onIdChanged(AdvertisingId advertisingId, AdvertisingId advertisingId2) {
    }

    public void setEnableLocation(boolean z) {
        this.o = z;
    }

    public void setLocation(Location location) {
        this.e = location;
    }

    public void setRetryAble(boolean z) {
        this.i = z;
    }

    public void setUid(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(g) && str.equalsIgnoreCase(g)) {
                return;
            }
            g = str;
            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
            edit.putString("uid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
            edit.apply();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public void setWindInsets(WindowInsets windowInsets) {
        if (windowInsets == null || !windowInsets.isRound()) {
            return;
        }
        this.h = windowInsets.getSystemWindowInsetBottom();
    }

    private String b() {
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        try {
            DeviceHelper.getOAID(this.n, new a.InterfaceC0217a() { // from class: com.czhj.sdk.common.ClientMetadata.1
                @Override // com.czhj.devicehelper.msaoaId.a.InterfaceC0217a
                public void a(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        ClientMetadata.this.q = str;
                        if (!str.equalsIgnoreCase(ClientMetadata.this.p)) {
                            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(ClientMetadata.this.n).edit();
                            edit.putString("oaid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
                            edit.apply();
                        }
                    }
                    ClientMetadata.this.z = true;
                }
            });
        } catch (Throwable unused) {
        }
        return this.q;
    }

    public String getStringResources(String str, String str2, Object... objArr) {
        Resources resources;
        Context context = this.n;
        if (context == null || (resources = context.getResources()) == null) {
            return str2;
        }
        int identifier = resources.getIdentifier(str, "string", this.n.getPackageName());
        if (identifier == 0) {
            return String.format(str2, objArr);
        }
        SigmobLog.d("getStringResources resid" + identifier);
        return resources.getString(identifier, objArr);
    }

    public synchronized String getDeviceId(int i) {
        try {
            if (TextUtils.isEmpty(this.j) && Build.VERSION.SDK_INT < 29) {
                if (DeviceUtils.isCanUsePhoneState(this.n) && DeviceUtils.isCanRetryIMEI()) {
                    this.j = DeviceHelper.getIMEI(this.n);
                    this.k = DeviceHelper.getIMEI(this.n, 0);
                    this.l = DeviceHelper.getIMEI(this.n, 1);
                }
                return null;
            }
            if (i == -1) {
                return this.j;
            }
            if (i == 0) {
                return this.k;
            }
            return this.l;
        } catch (Throwable th) {
            SigmobLog.e("getDeviceId:" + th.getMessage());
            return null;
        }
    }
}
