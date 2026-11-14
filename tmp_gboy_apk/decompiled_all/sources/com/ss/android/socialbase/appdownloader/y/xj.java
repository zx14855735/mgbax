package com.ss.android.socialbase.appdownloader.y;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private static final HashMap<String, c.xj> xj = new HashMap<>();

    static {
        wabA();
    }

    public static boolean hf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString("allow_os_api_range");
        int optInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                int parseInt = Integer.parseInt(split[i2]);
                int parseInt2 = Integer.parseInt(split[i2 + 1]);
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return false;
    }

    public static boolean w(JSONObject jSONObject) {
        return jSONObject == null || y.xj() || jSONObject.optInt("scy_mode") != 1;
    }

    private static /* synthetic */ void wabA() {
        char[] charArray = "º¶´÷¾¸´¼÷»¶ ÷ª±¼µµ÷\u0093·°\u009b«°½¾¼".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 217);
        }
        String str = new String(charArray);
        char[] charArray2 = "ºµ°·°\u00ad".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 217);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean xj(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.optString(PointParamKey.TYPE)) && xj(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return hf(jSONObject) && xj(jSONObject.optJSONArray("device_requirements")) && w(jSONObject);
    }

    public static boolean xj(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                String optString2 = optJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(",")) {
                    if (BaseConstants.SCHEME_MARKET.equals(str)) {
                        str = kd.tf();
                    }
                    c.xj hf = hf(str);
                    if (hf != null && !(z = xj(optJSONArray, optJSONArray2, optString2, hf))) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    private static boolean hf(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static c.xj hf(String str) {
        HashMap<String, c.xj> hashMap = xj;
        if (hashMap.containsKey(str)) {
            c.xj xjVar = hashMap.get(str);
            if (xjVar != null) {
                return xjVar;
            }
            return null;
        }
        c.xj hf = c.hf(str);
        hashMap.put(str, hf);
        if (hf != null) {
            return hf;
        }
        return null;
    }

    private static boolean xj(JSONArray jSONArray, JSONArray jSONArray2, String str, c.xj xjVar) {
        String c = xjVar.c();
        int y = xjVar.y();
        String str2 = y + "_" + c;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i = 0; i < split.length; i += 2) {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split[i + 1]);
                    if (y >= parseInt && y <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (hf(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !hf(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static c.xj xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                c.xj hf = hf(str);
                if (hf != null) {
                    return hf;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean xj(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString("s");
            try {
                String xj2 = w.xj(jSONObject.optString("az"), optString);
                String xj3 = w.xj(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(xj2);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(xj3);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
