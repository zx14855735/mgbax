package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class GlobalSetting {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile Integer f12965A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile boolean f12966A4TApA = false;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static volatile boolean f12967A5SV6n = true;
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static volatile Integer f12968ADYaiT = null;
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static volatile Boolean AMqCpz = null;
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static volatile Boolean f12969ARc23Z = null;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static volatile Boolean f12970ASJ6gh = null;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static volatile Map f12971AYUAbz = new HashMap();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static volatile HashMap f12972AZOQYO = new HashMap();

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final HashMap f12973AZkASS = new HashMap();

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final JSONObject f12974AaHO0E = new JSONObject();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static volatile String f12975AcNBzu = null;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static volatile String f12976AlLFFp = null;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static volatile String f12977AmA8tU = null;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static volatile String f12978AzWtSf = null;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static volatile String f12979B25kr6 = null;
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final String COPPA = "coppa";
    public static final String CUSTOM_INFO_KEY = "custom_info";
    public static final String DARK_MODE_KEY = "dark_mode_info";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String NATIVE_EXPRESS_AD = "4";
    public static final String NATIVE_UNIFIED_AD = "6";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String REWARD_VIDEO_AD = "5";
    public static final String SPLASH_AD = "3";
    public static final String TT_SDK_WRAPPER = "TT";
    public static final String UNIFIED_BANNER_AD = "7";
    public static final String UNIFIED_INTERSTITIAL_FS_AD = "9";
    public static final String UNIFIED_INTERSTITIAL_HS_AD = "8";

    static {
        wpXDPgv();
    }

    public static Boolean getAgreeReadAndroidId() {
        return f12970ASJ6gh;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f12969ARc23Z;
    }

    public static Integer getChannel() {
        return f12965A2egSU;
    }

    public static String getCustomADActivityClassName() {
        return f12975AcNBzu;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f12978AzWtSf;
    }

    public static String getCustomPortraitActivityClassName() {
        return f12976AlLFFp;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f12979B25kr6;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f12977AmA8tU;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f12971AYUAbz);
    }

    public static Integer getPersonalizedState() {
        return f12968ADYaiT;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f12973AZkASS;
    }

    public static JSONObject getSettings() {
        return f12974AaHO0E;
    }

    public static boolean isAgreePrivacyStrategy() {
        return AMqCpz == null || AMqCpz.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f12970ASJ6gh == null) {
            return true;
        }
        return f12970ASJ6gh.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f12969ARc23Z == null) {
            return true;
        }
        return f12969ARc23Z.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f12966A4TApA;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f12967A5SV6n;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (AMqCpz == null) {
            AMqCpz = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z) {
        f12970ASJ6gh = Boolean.valueOf(z);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z) {
        f12969ARc23Z = Boolean.valueOf(z);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f12974AaHO0E.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e.toString());
        }
    }

    public static void setChannel(int i) {
        if (f12965A2egSU == null) {
            f12965A2egSU = Integer.valueOf(i);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f12974AaHO0E.putOpt(CONV_OPTIMIZE_KEY, new JSONObject(map));
        } catch (Exception e) {
            GDTLogger.e("setConvOptimizeInfo错误：" + e.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f12975AcNBzu = str;
    }

    public static void setCustomInfo(Map<String, Map<String, String>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            f12974AaHO0E.putOpt(CUSTOM_INFO_KEY, new JSONObject(map));
        } catch (Exception e) {
            GDTLogger.e("setCustomInfo：" + e);
        }
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f12978AzWtSf = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f12976AlLFFp = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f12979B25kr6 = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f12977AmA8tU = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            f12974AaHO0E.putOpt("ecais", Boolean.valueOf(z));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        f12966A4TApA = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        f12967A5SV6n = z;
    }

    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        f12971AYUAbz = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            f12972AZOQYO = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f12972AZOQYO.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f12974AaHO0E.putOpt("media_ext", new JSONObject(f12972AZOQYO));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i) {
        f12968ADYaiT = Integer.valueOf(i);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f12973AZkASS.putAll(map);
    }

    private static /* synthetic */ void wpXDPgv() {
        char[] charArray = "/#!b+-!)b.#5b?$)  b\u0006\"%\u000e>%(+)".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'L');
        }
        String str = new String(charArray);
        char[] charArray2 = "/ %\"%8".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'L');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
