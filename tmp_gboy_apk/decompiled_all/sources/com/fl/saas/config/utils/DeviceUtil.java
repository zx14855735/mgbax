package com.fl.saas.config.utils;

import B4ZgIw.AYUAbz;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.general.media.gif.FrameSequence;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.czhj.sdk.common.A2egSU;
import com.czhj.sdk.common.Constants;
import com.fl.saas.base.bean.CustomLocation;
import com.fl.saas.base.manager.loader.ADYaiT;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.octopus.ad.ADBidEvent;
import com.sigmob.sdk.base.views.r;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import com.sigmob.sdk.downloader.f;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DeviceUtil {
    private static String HmsVersionCode = null;
    private static final Map<String, String[]> MARKETS;
    private static String MARKET_CODE = null;
    public static String appId = "";
    public static String channelId = "";
    public static CustomLocation customLocation = null;
    private static String customizeId = null;
    private static List<String> materialAdvList = null;
    private static Context sContext = null;
    public static ImageView.ScaleType scaleType = null;
    private static int[] screenPx = null;
    public static String subChannel = "";
    public static String userExt = "";
    public static ConcurrentHashMap customMap = new ConcurrentHashMap();
    public static boolean isCanUseBootID = true;
    public static boolean isCanUseSSID = true;
    public static boolean isCanUseAndroid = true;
    public static boolean isCanUseMac = true;
    public static boolean isCanUseIMEI = true;
    public static boolean isCanUseIMSI = true;
    public static boolean isCanUseLocation = true;
    public static boolean personalizedState = true;
    public static boolean enableCollectAppInstallStatus = true;
    public static boolean isInitializeGDT = true;
    public static boolean isInitializeKS = true;
    public static boolean isInitializeBD = true;
    public static boolean isInitializeCSJ = true;
    public static boolean isInitializeQTT = true;
    public static boolean isGetImei = false;
    public static String deviceImei = "";
    public static boolean isGetAndroidID = false;
    public static String deviceAndroidID = "";
    public static boolean isGetMac = false;
    public static boolean deviceHasAccelerometerSensor = false;
    public static boolean isCanUseSensor = false;
    public static String deviceMac = "";
    public static JSONArray appList = null;
    public static long totalRAM = 0;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static String imsi = "";
    private static boolean hasGetImsi = false;
    private static boolean isLoadOperators = false;
    private static String operatorId = Constants.FAIL;
    public static String userAgent = "";
    private static Long autoNum = 0L;

    static {
        HashMap hashMap = new HashMap();
        MARKETS = hashMap;
        String[] strArr = {"com.heytap.market", "com.oppo.market"};
        hashMap.put("OPPO", strArr);
        hashMap.put("OnePlus", strArr);
        hashMap.put("realme", strArr);
        hashMap.put("Xiaomi", new String[]{"com.xiaomi.market"});
        hashMap.put("Meizu", new String[]{"com.meizu.mstore"});
        hashMap.put("vivo", new String[]{"com.bbk.appstore"});
        hashMap.put(ADBidEvent.HUAWEI, new String[]{"com.huawei.appmarket"});
        hashMap.put("HONOR", new String[]{"com.huawei.appmarket", "com.hihonor.appmarket"});
        hashMap.put("SAM_SUNG", new String[]{"com.sec.android.app.samsungapps"});
        hashMap.put("lenovo", new String[]{"com.lenovo.leos.appstore"});
        hashMap.put("LE_TV", new String[]{"com.letv.app.appstore"});
        MARKET_CODE = null;
        HmsVersionCode = null;
        FnBI();
    }

    private static /* synthetic */ void FnBI() {
        char[] charArray = "\u008b\u0087\u0085Æ\u008f\u0089\u0085\u008dÆ\u008a\u0087\u0091Æ\u009b\u0080\u008d\u0084\u0084Æ¢\u0086\u0081ª\u009a\u0081\u008c\u008f\u008d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 232);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008b\u0084\u0081\u0086\u0081\u009c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 232);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean checkAccelerometerSensor(Context context) {
        if (context == null) {
            return true;
        }
        try {
            Iterator<Sensor> it = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1).iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkApkExist(String str) {
        if (sContext != null && str != null && !"".equals(str)) {
            try {
                PackageManager packageManager = sContext.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                packageManager.getApplicationInfo(str, ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean deviceCanHandleIntent(Intent intent) {
        try {
            return !sContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static int dip2px(float f) {
        Context context = sContext;
        if (context == null || f == 0.0f) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String directGetAgVersionCode() {
        String str = MARKET_CODE;
        if (str != null) {
            return str;
        }
        String str2 = "";
        MARKET_CODE = "";
        if (sContext == null) {
            return "";
        }
        try {
            String deviceMANUFACTURER = getDeviceMANUFACTURER();
            for (Map.Entry<String, String[]> entry : MARKETS.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(deviceMANUFACTURER)) {
                    String[] value = entry.getValue();
                    for (String str3 : value) {
                        String versionCode = getVersionCode(sContext, str3);
                        MARKET_CODE = versionCode;
                        if (!TextUtils.isEmpty(versionCode)) {
                            break;
                        }
                    }
                    String str4 = MARKET_CODE;
                    if (str4 != null) {
                        str2 = str4;
                    }
                    MARKET_CODE = str2;
                    return str2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MARKET_CODE;
    }

    public static String directGetHmsVersionCode() {
        Context context = sContext;
        if (context == null) {
            return "";
        }
        String str = HmsVersionCode;
        if (str != null) {
            return str;
        }
        try {
            HmsVersionCode = getVersionCode(context, "com.huawei.hwid");
        } catch (Exception unused) {
            HmsVersionCode = "";
        }
        if (HmsVersionCode == null) {
            HmsVersionCode = "";
        }
        return HmsVersionCode;
    }

    public static ArrayList<View> getAllChildren(View view) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                arrayList.add(childAt);
                arrayList.addAll(getAllChildren(childAt));
            }
        }
        return arrayList;
    }

    public static String getAndroidID() {
        Context context = sContext;
        if (context == null) {
            return "";
        }
        if (isGetAndroidID) {
            return deviceAndroidID;
        }
        if (!isCanUseAndroid) {
            return "";
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        deviceAndroidID = string;
        isGetAndroidID = true;
        return string;
    }

    public static JSONObject getAppInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f.f13353a, appId);
            jSONObject.putOpt("channel", channelId);
            jSONObject.putOpt("sub_channel", subChannel);
            jSONObject.putOpt("name", getAppName());
            jSONObject.putOpt("bundle", getMyPackageName());
            jSONObject.putOpt("version", getVersionName());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String getAppName() {
        PackageInfo packageInfo;
        return (sContext == null || (packageInfo = getPackageInfo()) == null) ? "" : sContext.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString();
    }

    public static Application getApplication() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, null);
            declaredField.setAccessible(true);
            return (Application) declaredField.get(invoke);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Long getAutoNum() {
        Long l = autoNum;
        autoNum = Long.valueOf(l.longValue() + 1);
        return l;
    }

    public static String getBootId() {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            str = bufferedReader.readLine();
            bufferedReader.close();
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String getBootMark() {
        return isCanUseBootID ? getBootId() : "";
    }

    public static long getBootTime() {
        try {
            return SystemClock.elapsedRealtime();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getCustomizeId() {
        StringBuilder sb;
        if (TextUtils.isEmpty(customizeId)) {
            String string = SPUtil.getInstance().getString("customizeId", "");
            customizeId = string;
            if (TextUtils.isEmpty(string)) {
                String androidID = getAndroidID();
                if (TextUtils.isEmpty(androidID)) {
                    sb = new StringBuilder();
                    sb.append(UUID.randomUUID().toString());
                } else {
                    sb = AYUAbz.A4TApA(androidID);
                }
                sb.append(getUpdateMark());
                customizeId = sb.toString();
                SPUtil.getInstance().putString("customizeId", customizeId);
            }
        }
        return customizeId;
    }

    public static String getDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static JSONObject getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ua", getUserAgent());
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("osv", getDeviceSystemVersion());
            jSONObject.putOpt("devicetype", Integer.valueOf(isTablet() ? 1 : 0));
            jSONObject.putOpt("connectiontype", getNetworkType());
            jSONObject.putOpt("carrier", getOperators());
            jSONObject.putOpt("orientation", Integer.valueOf(getOrientation()));
            jSONObject.putOpt("sw", Integer.valueOf(getMobileWidth()));
            jSONObject.putOpt("sh", Integer.valueOf(getMobileHeight()));
            jSONObject.putOpt(bn.j, getDeviceBrand());
            jSONObject.putOpt(bn.i, getDeviceModel());
            jSONObject.putOpt("density", Float.valueOf(getScreenDensity()));
            jSONObject.putOpt("densityDpi", Integer.valueOf(getDpi()));
            jSONObject.putOpt("imei", getImei());
            jSONObject.putOpt("oaid", OaidUtils.getOaid());
            jSONObject.putOpt("androidid", getAndroidID());
            jSONObject.putOpt("mac", getMacAddress());
            jSONObject.putOpt("mark", getDeviceMANUFACTURER());
            jSONObject.putOpt("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("oaidmd5", MD5Utils.getMD5(OaidUtils.getOaid()));
            jSONObject.putOpt("imeimd5", MD5Utils.getMD5(getImei()));
            jSONObject.putOpt("androididmd5", MD5Utils.getMD5(getAndroidID()));
            jSONObject.putOpt("macmd5", MD5Utils.getMD5(getMacAddress()));
            try {
                jSONObject.putOpt("boot_mark", getBootMark());
                jSONObject.putOpt("update_mark", getUpdateMark());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            jSONObject.putOpt("physical_memory_byte", Long.valueOf(getMemoryByte()));
            jSONObject.putOpt("verCodeOfHms", directGetHmsVersionCode());
            try {
                jSONObject.putOpt("verCodeOfAG", directGetAgVersionCode());
            } catch (Throwable unused) {
            }
            jSONObject.putOpt("customizeId", getCustomizeId());
            if (customLocation != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("lon", Double.valueOf(customLocation.getLng()));
                jSONObject2.putOpt("lat", Double.valueOf(customLocation.getLat()));
                jSONObject.putOpt("geo", jSONObject2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    public static String getDeviceMANUFACTURER() {
        String str = Build.MANUFACTURER;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getDpi() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getIMSI() {
        if (sContext == null || !isCanUseIMSI) {
            return "";
        }
        if (TextUtils.isEmpty(imsi) && !hasGetImsi) {
            try {
                hasGetImsi = true;
                TelephonyManager telephonyManager = (TelephonyManager) sContext.getSystemService("phone");
                if (telephonyManager == null) {
                    return "";
                }
                imsi = telephonyManager.getSubscriberId();
            } catch (Exception unused) {
            }
        }
        return imsi;
    }

    @SuppressLint({"MissingPermission"})
    public static String getImei() {
        String deviceId;
        Context context = sContext;
        if (context == null) {
            return "";
        }
        if (isGetImei) {
            return deviceImei;
        }
        if (!isCanUseIMEI) {
            return "";
        }
        isGetImei = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && (deviceId = telephonyManager.getDeviceId()) != null) {
                deviceImei = deviceId;
                return deviceId;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String getMacAddress() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        Context context = sContext;
        if (context == null) {
            return "";
        }
        if (isGetMac) {
            return deviceMac;
        }
        if (!isCanUseMac || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        deviceMac = macAddress;
        isGetMac = true;
        return macAddress;
    }

    public static long getMemoryByte() {
        try {
            long j = totalRAM;
            if (j > 0) {
                return j;
            }
            ActivityManager activityManager = (ActivityManager) getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            totalRAM = j2;
            return j2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static int getMobileHeight() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getMobileWidth() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static String getMyPackageName() {
        Context context = sContext;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager == null ? "" : packageManager.getPackageInfo(sContext.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getNetworkType() {
        Context context = sContext;
        if (context == null) {
            return "";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "1";
            }
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 20) {
                    return "5";
                }
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3";
                    case 13:
                        return "4";
                    default:
                        return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000") || subtypeName.equalsIgnoreCase("LTE")) ? "4" : subtypeName.equalsIgnoreCase("NR") ? "5" : Constants.FAIL;
                }
            }
        }
        return Constants.FAIL;
    }

    public static String getOSLevel() {
        return Build.VERSION.SDK;
    }

    public static String getOperators() {
        if (isCanUseIMSI && !isLoadOperators) {
            try {
                operatorId = (String) Optional.ofNullable(sContext).map(new ADYaiT(16)).map(new ADYaiT(17)).map(new ADYaiT(18)).orElseGet(new ADYaiT(19));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return operatorId;
    }

    public static int getOrientation() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        int i = context.getResources().getConfiguration().orientation;
        if (i == 2) {
            return 2;
        }
        return i == 1 ? 1 : 0;
    }

    private static PackageInfo getPackageInfo() {
        Context context = sContext;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getPackageInfo(sContext.getPackageName(), f.a.d);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getReqID(String str) {
        try {
            return MD5Utils.getMD5(getAutoNum() + str + System.currentTimeMillis() + UUID.randomUUID());
        } catch (Exception unused) {
            return "";
        }
    }

    public static float getScreenDensity() {
        if (sContext == null || screenPx != null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) sContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static int getStatusBarHeight() {
        int identifier = sContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return sContext.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getSysLanguage() {
        Locale locale;
        LocaleList locales;
        if (sContext == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 24) {
            locales = sContext.getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = sContext.getResources().getConfiguration().locale;
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static Activity getTopActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUpdateMark() {
        try {
            return FrameSequence.nativeGetUpdate();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static int getVersionCode() {
        if (sContext == null || getPackageInfo() == null) {
            return 0;
        }
        return getPackageInfo().versionCode;
    }

    public static String getVersionName() {
        return (sContext == null || getPackageInfo() == null) ? "" : getPackageInfo().versionName;
    }

    public static boolean inRangeOfView(View view, MotionEvent motionEvent) {
        boolean z;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        float f = i;
        boolean z2 = motionEvent.getX() < f || motionEvent.getX() > ((float) (view.getWidth() + i)) || motionEvent.getY() < ((float) i2) || motionEvent.getY() > ((float) (view.getHeight() + i2));
        if (motionEvent.getX() >= f && motionEvent.getX() <= view.getWidth() + i && motionEvent.getY() >= i2 - getStatusBarHeight()) {
            if (motionEvent.getY() <= view.getHeight() + (i2 - getStatusBarHeight())) {
                z = false;
                return z2 || !z;
            }
        }
        z = true;
        if (z2) {
        }
    }

    public static void initUserAgent() {
        String string = SPUtil.getInstance().getString("userAgent", "");
        userAgent = string;
        if (TextUtils.isEmpty(string)) {
            loadUserAgent();
        } else {
            ThreadPoolManager.getInstance().schedule(new A2egSU(2), 120L, TimeUnit.SECONDS);
        }
    }

    public static boolean isAppList() {
        try {
            return !SPUtil.getInstance().get(SPUtil.UPLOAD_DATE, "").equals(getDate());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isContainMaterial(int i) {
        String valueOf = String.valueOf(i);
        List<String> list = materialAdvList;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return materialAdvList.contains(valueOf);
    }

    public static boolean isTablet() {
        Context context = sContext;
        return context != null && (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean isViewRange(MotionEvent motionEvent, View view, String str) {
        try {
            ArrayList<View> allChildren = getAllChildren(view);
            View view2 = null;
            for (int i = 0; i < allChildren.size(); i++) {
                if ((allChildren.get(i) instanceof TextView) && ((TextView) allChildren.get(i)).getText().toString().contains(str)) {
                    view2 = allChildren.get(i);
                }
            }
            if (view2 != null) {
                return inRangeOfView(view2, motionEvent);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TelephonyManager lambda$getOperators$0(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getOperators$1(String str) {
        isLoadOperators = true;
        return (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007")) ? "1" : (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) ? "2" : (str.startsWith("46003") || str.startsWith("46005") || str.startsWith("46011")) ? "3" : Constants.FAIL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadUserAgent$3() {
        try {
            LogcatUtil.d("loadUserAgentStart");
            Context context = sContext;
            if (context != null) {
                userAgent = WebSettings.getDefaultUserAgent(context);
                SPUtil.getInstance().putString("userAgent", userAgent);
            }
            LogcatUtil.d("loadUserAgent：" + userAgent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadUserAgent() {
        new Thread(new A2egSU(1)).start();
    }

    public static void postUI(Runnable runnable) {
        mainHandler.post(runnable);
    }

    public static void postUIDelayed(long j, Runnable runnable) {
        mainHandler.postDelayed(runnable, j);
    }

    public static int px2dip(float f) {
        Context context = sContext;
        if (context == null || f == 0.0f) {
            return 0;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void removePostUI(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        mainHandler.removeCallbacks(runnable);
    }

    public static void setContext(Context context) {
        sContext = context;
    }

    public static void setMaterialAdv(List<String> list) {
        materialAdvList = list;
    }

    public static int getOrientation(Context context) {
        return (context != null && context.getResources().getConfiguration().orientation == 2) ? 2 : 1;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, r.b.d);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = getPackageInfo(context, str);
            if (packageInfo == null) {
                return null;
            }
            return String.valueOf(packageInfo.versionCode);
        } catch (AndroidRuntimeException | Exception unused) {
            return null;
        }
    }
}
