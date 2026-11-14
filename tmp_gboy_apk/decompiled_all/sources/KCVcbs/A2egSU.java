package KCVcbs;

import ADYaiT.DUi7mC;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bumptech.glide.AMqCpz;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final String[] f4226A5SV6n = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* renamed from: A2egSU, reason: collision with root package name */
    public Context f4227A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public JSONObject f4228A4TApA;

    static {
        cYnJ();
    }

    public static String A2egSU() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.SUPPORTED_ABIS.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr = Build.SUPPORTED_ABIS;
                    if (i >= strArr.length) {
                        break;
                    }
                    sb.append(strArr[i]);
                    if (i != strArr.length - 1) {
                        sb.append(", ");
                    }
                    i++;
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? MediationConfigUserInfoForSegment.GENDER_UNKNOWN : sb.toString();
        } catch (Exception unused) {
            AMqCpz.C2rE4F();
            return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        }
    }

    public static A2egSU A5SV6n(Context context) {
        Object obj;
        int i;
        A2egSU a2egSU = new A2egSU();
        JSONObject jSONObject = new JSONObject();
        a2egSU.f4228A4TApA = jSONObject;
        a2egSU.f4227A2egSU = context;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo;
            if (applicationInfo != null && (i = applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", context.getString(i));
            }
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.17-cloud");
            jSONObject.put("os", "Android");
            String str = Build.VERSION.RELEASE;
            if (!str.contains(".")) {
                str = str.concat(".0");
            }
            jSONObject.put("os_version", str);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", A2egSU());
        } catch (Exception unused) {
        }
        try {
            DisplayMetrics displayMetrics = a2egSU.f4227A2egSU.getResources().getDisplayMetrics();
            int i2 = displayMetrics.densityDpi;
            String str2 = i2 != 120 ? i2 != 240 ? i2 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i2);
            jSONObject.put("display_density", str2);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused2) {
        }
        try {
            String language = a2egSU.f4227A2egSU.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(MediaFormat.KEY_LANGUAGE, language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused3) {
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (AlLFFp.D6DOie()) {
                sb.append("MIUI-");
            } else if (Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme")) {
                sb.append("FLYME-");
            } else {
                String D9tr6l2 = AlLFFp.D9tr6l();
                if (AlLFFp.D8cQ8b(D9tr6l2)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(D9tr6l2)) {
                    sb.append(D9tr6l2);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", AMqCpz.D8MqeW());
        } catch (Throwable unused4) {
        }
        try {
            jSONObject.put("access", AlLFFp.D8MqeW(a2egSU.f4227A2egSU));
        } catch (JSONException e) {
            pl.xj(e);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) a2egSU.f4227A2egSU.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    jSONObject.put("mcc_mnc", networkOperator);
                }
            }
        } catch (Exception e2) {
            pl.xj(e2);
        }
        DUi7mC dUi7mC = JrXYwF.A5SV6n.f4151A5SV6n;
        if (dUi7mC != null) {
            if (((Map) dUi7mC.f241AzWtSf) == null) {
                dUi7mC.f241AzWtSf = ((JrXYwF.AMqCpz) dUi7mC.f240AmA8tU).c();
            }
            Map map = (Map) dUi7mC.f241AzWtSf;
            if (map != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str3 : map.keySet()) {
                        if (!TextUtils.isEmpty(str3) && (obj = map.get(str3)) != null) {
                            jSONObject2.put(str3, obj);
                        }
                    }
                    jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
                } catch (Exception unused5) {
                    AMqCpz.C2rE4F();
                }
            }
        }
        return a2egSU;
    }

    private static /* synthetic */ void cYnJ() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A4TApA(String str) {
        JSONObject jSONObject = this.f4228A4TApA;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            jSONObject.put("user_id", str);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public final void ADYaiT(Map map) {
        JSONObject jSONObject = this.f4228A4TApA;
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (!jSONObject.has((String) entry.getKey())) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            String[] strArr = f4226A5SV6n;
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (map.containsKey(str)) {
                    try {
                        jSONObject.put(str, Integer.parseInt((String) map.get(str)));
                    } catch (Exception unused) {
                        jSONObject.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                jSONObject.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
            }
            if (map.containsKey("iid")) {
                jSONObject.put("udid", map.get("iid"));
                jSONObject.remove("iid");
            }
        } catch (Throwable unused2) {
        }
    }
}
