package com.octopus.ad.internal.utilities;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.octopus.ad.model.g;
import com.octopus.ad.utils.b.f;
import com.octopus.ad.utils.b.i;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DeviceInfoUtil {
    public static String ETHERNET_SERVICE = "ethernet";
    public static int SCREEN_DECIMAL_DIGITS = 2;
    private static DisplayMetrics displayMetrics;

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (displayMetrics == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    private static void getIdentifiersAndDevType(Context context, DeviceInfo deviceInfo) {
        try {
            if (((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getPhoneType() != 0) {
                deviceInfo.devType = g.b.DEVICE_PHONE;
            } else {
                deviceInfo.devType = g.b.DEVICE_FLAT;
            }
        } catch (SecurityException unused) {
            HaoboLog.e(HaoboLog.baseLogTag, "No permission to access imei");
            int i = context.getResources().getConfiguration().screenLayout & 15;
            if (i == 4 || i == 3) {
                deviceInfo.devType = g.b.DEVICE_FLAT;
            } else {
                deviceInfo.devType = g.b.DEVICE_PHONE;
            }
        }
        deviceInfo.root = i.a();
        deviceInfo.isVpnOpen = i.f();
        deviceInfo.isDeveloperMode = i.u(context);
    }

    private static void getScreenInformations(Context context, DeviceInfo deviceInfo) {
        String string = SPUtils.getString(context, "resolution");
        String string2 = SPUtils.getString(context, "screenSize");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            DisplayMetrics displayMetrics2 = getDisplayMetrics(context);
            String str = displayMetrics2.widthPixels + "_" + displayMetrics2.heightPixels;
            float f = displayMetrics2.heightPixels / displayMetrics2.ydpi;
            float f2 = displayMetrics2.widthPixels / displayMetrics2.xdpi;
            double sqrt = Math.sqrt((f * f) + (f2 * f2));
            String format = String.format(Locale.US, "%.2f", Double.valueOf(Math.round(sqrt * r6) / Math.pow(10.0d, SCREEN_DECIMAL_DIGITS)));
            SPUtils.put(context, "resolution", str);
            SPUtils.put(context, "screenSize", format);
            string2 = format;
            string = str;
        }
        deviceInfo.resolution = string;
        deviceInfo.screenSize = string2;
    }

    private static void getSdkUID(Context context, DeviceInfo deviceInfo) {
        String str = (String) SPUtils.get(context, DeviceInfo.SDK_UID_KEY_NEW, "");
        deviceInfo.sdkUID = str;
        if (TextUtils.isEmpty(str)) {
            deviceInfo.generateSdkUID(context);
        }
    }

    public static void retrieveDeviceInfo(Context context) {
        DeviceInfo deviceInfo = DeviceInfo.getInstance();
        if (TextUtils.isEmpty(deviceInfo.sdkUID)) {
            try {
                getIdentifiersAndDevType(context, deviceInfo);
                getScreenInformations(context, deviceInfo);
                getSdkUID(context, deviceInfo);
                deviceInfo.getMarks(context);
                deviceInfo.agVercode = i.m(context);
                deviceInfo.hmsVercode = i.n(context);
                deviceInfo.sysVersion = i.d();
                deviceInfo.appstoreVersion = i.o(context);
                deviceInfo.browserVersion = i.p(context);
                deviceInfo.visionWindowVersion = i.q(context);
                deviceInfo.vivoMiniGameVersion = i.r(context);
                deviceInfo.vivoMusicVersion = i.s(context);
                deviceInfo.wxInstalled = i.e(context, "com.tencent.mm");
                deviceInfo.appList = i.b(context);
            } catch (Throwable th) {
                f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
    }
}
