package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.ADBidEvent;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am {
    private static int c = 1;
    private static int f = 1;
    private static String hf;
    private static String kd;
    private static String u;
    private static Boolean w;
    private static String xj;
    private static Boolean y;

    public static String c() {
        return kd;
    }

    public static boolean d() {
        return p() == 0 && tf();
    }

    public static String f() {
        return u;
    }

    private static int g() {
        return f;
    }

    public static boolean hf() {
        Boolean bool = w;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static String kd() {
        return xj;
    }

    public static int p() {
        return c;
    }

    public static boolean pl() {
        Boolean bool = y;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean tf() {
        return pl() && xj(y(), kd()) && g() == 0;
    }

    public static boolean u() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toUpperCase().startsWith("HONOR")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toUpperCase().startsWith("HONOR");
    }

    public static boolean w() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toUpperCase().startsWith(ADBidEvent.HUAWEI)) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toUpperCase().startsWith(ADBidEvent.HUAWEI);
    }

    public static void xj() {
        if (w == null) {
            if (!u() && !w()) {
                w = Boolean.FALSE;
                return;
            }
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                w = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                w = Boolean.FALSE;
            }
            if (xj == null) {
                xj = xj("getApiVersion");
            }
            if (hf == null) {
                hf = xj("getVersion");
            }
            if (kd == null) {
                kd = xj("getReleaseType");
            }
            if (u == null) {
                u = xj("getBuildVersion");
            }
            if (y == null) {
                y = Boolean.FALSE;
                try {
                    y = Boolean.valueOf("156".equals(hf("ro.config.hw_optb", Constants.FAIL)) && "true".equals(hf("hw_mc.pure_mode.enable", "false")));
                } catch (Exception unused2) {
                }
            }
            try {
                c = Settings.Secure.getInt(com.bytedance.sdk.openadsdk.core.pz.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
            } catch (Throwable unused3) {
            }
            try {
                Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                f = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
            } catch (Throwable unused4) {
            }
        }
    }

    public static String y() {
        return hf;
    }

    private static int hf(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    private static String hf(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, MediationConfigUserInfoForSegment.GENDER_UNKNOWN);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return str2;
        } catch (Throwable unused) {
            return str2;
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

    public static boolean xj(Context context) {
        return context != null && hf(context) == 0 && pl();
    }

    public static void xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("pure_enhanced_mode", d() ? 1 : 2);
            jSONObject.put("pure_enhanced_mode_enable", tf() ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    private static boolean xj(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }
}
