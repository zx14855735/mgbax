package com.ss.android.socialbase.appdownloader.y;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static String hf;
    private static Boolean kd;
    private static String u;
    private static String w;
    private static String xj;

    public static String c() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean hf(Context context) {
        return context != null && u(context) == 0 && y();
    }

    public static boolean kd() {
        if (kd == null) {
            kd = Boolean.FALSE;
            try {
                kd = Boolean.valueOf("156".equals(xj("ro.config.hw_optb", Constants.FAIL)) && "true".equals(xj("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return kd.booleanValue();
    }

    public static String u() {
        if (u == null) {
            u = xj("getBuildVersion");
        }
        return u;
    }

    public static String w() {
        if (w == null) {
            w = xj("getReleaseType");
        }
        return w;
    }

    public static boolean xj(Context context) {
        return context != null && w(context) == 0 && kd();
    }

    public static boolean y() {
        return kd() && hf(hf(), xj()) && xj(Process.myUid()) == 0;
    }

    public static String hf() {
        if (hf == null) {
            hf = xj("getVersion");
        }
        return hf;
    }

    public static String xj() {
        if (xj == null) {
            xj = xj("getApiVersion");
        }
        return xj;
    }

    public static int u(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static int w(Context context) {
        if (context == null) {
            return 1;
        }
        if (hf(hf(), xj())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    private static boolean hf(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static String xj(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, MediationConfigUserInfoForSegment.GENDER_UNKNOWN);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int xj(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            pl.xj(th);
            return 1;
        }
    }

    private static String xj(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
