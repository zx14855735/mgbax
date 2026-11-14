package com.bytedance.embedapplog;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class cy {
    private static final String[] xj = {"ab_version", "device_brand", MediaFormat.KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", com.sigmob.sdk.base.n.r, "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    private static final String[] hf = {"ab_version", "device_brand", MediaFormat.KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "device_type", "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    static {
        vBjqJeo();
    }

    private static /* synthetic */ void vBjqJeo() {
        char[] charArray = "çëéªãåéáªæëýª÷ìáèèªÎêíÆöíàãá".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 132);
        }
        String str = new String(charArray);
        char[] charArray2 = "çèíêíð".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 132);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String xj(Context context, JSONObject jSONObject, String str, boolean z, hf hfVar) {
        HashMap<String, String> xj2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap hashMap = new HashMap(xj.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = xj;
            if (i >= strArr.length) {
                break;
            }
            String optString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(hf[i], optString);
            }
            i++;
        }
        if (hfVar != null) {
            try {
                xj2 = hfVar.xj(context);
            } catch (Exception e) {
                cu.hf(e);
            }
        } else {
            xj2 = null;
        }
        if (no.w(context) && xj2 != null) {
            hashMap.putAll(xj2);
        }
        try {
            HashMap<String, String> xj3 = xj.w() == null ? null : xj.w().xj();
            if (xj3 != null) {
                hashMap.putAll(xj3);
            }
        } catch (Exception e2) {
            cu.hf(e2);
        }
        if (xj.w.size() > 0) {
            hashMap.putAll(xj.w);
        }
        if (z) {
            hashMap.put("ssmix", com.kuaishou.weapon.p0.t.f);
        }
        String xj4 = ua.xj(context);
        if (!TextUtils.isEmpty(xj4)) {
            hashMap.put("ac", xj4);
        }
        String str2 = (String) xj.xj("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) xj.xj("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("channel", str2);
        }
        String optString2 = jSONObject.optString("os_version", null);
        if (optString2 != null && optString2.length() > 10) {
            optString2 = optString2.substring(0, 10);
        }
        hashMap.put("os_version", optString2);
        hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
        hashMap.put("device_platform", "android");
        int intValue = ((Integer) xj.xj("version_code", -1)).intValue();
        if (intValue != -1) {
            hashMap.put("version_code", String.valueOf(intValue));
        }
        int intValue2 = ((Integer) xj.xj("manifest_version_code", -1)).intValue();
        if (intValue2 != -1) {
            hashMap.put("manifest_version_code", String.valueOf(intValue2));
        }
        int intValue3 = ((Integer) xj.xj("update_version_code", -1)).intValue();
        if (intValue3 != -1) {
            hashMap.put("update_version_code", String.valueOf(intValue3));
        }
        String xj5 = zm.xj(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(xj5)) {
            hashMap.put("oaid", xj5);
        }
        String optString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(optString3)) {
            hashMap.put("cdid", optString3);
        }
        if (!str.endsWith("/")) {
            str = str.concat("/");
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
        A4TApA2.append(str.indexOf(63) >= 0 ? '&' : '?');
        return no.xj(A4TApA2.toString(), hashMap, "UTF-8");
    }

    public static String[] xj(a aVar, Context context, JSONObject jSONObject) {
        String str;
        String[] hf2 = aVar.f().hf();
        String[] strArr = new String[hf2.length];
        if (xj.f()) {
            str = "?tt_data=a";
        } else {
            str = "?";
        }
        for (int i = 0; i < hf2.length; i++) {
            String xj2 = xj(context, jSONObject, CtFAbx.B25kr6(new StringBuilder(), hf2[i], str), true, xj.u());
            strArr[i] = xj2;
            strArr[i] = gj.xj(xj2, gj.hf);
        }
        return strArr;
    }
}
