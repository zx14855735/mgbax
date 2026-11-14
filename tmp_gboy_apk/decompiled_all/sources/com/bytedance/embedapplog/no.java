package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.codec.CharEncoding;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class no {
    private static String xj = ":push";

    public static c c() {
        f g = xj.g();
        if (g == null) {
            return null;
        }
        return g.en();
    }

    public static Looper f() {
        c en;
        f g = xj.g();
        if (g == null || (en = g.en()) == null) {
            return null;
        }
        return en.y();
    }

    public static boolean hf() {
        c en;
        f g = xj.g();
        if (g == null || (en = g.en()) == null) {
            return false;
        }
        return en.w();
    }

    public static boolean kd() {
        f g = xj.g();
        if (g == null) {
            return false;
        }
        return g.et();
    }

    public static boolean u() {
        c en;
        f g = xj.g();
        if (g == null || (en = g.en()) == null) {
            return false;
        }
        return en.u();
    }

    public static String w() {
        c en;
        f g = xj.g();
        return (g == null || (en = g.en()) == null) ? "" : en.hf();
    }

    public static boolean xj(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean y() {
        f g = xj.g();
        if (g == null) {
            return false;
        }
        return g.yo();
    }

    public static boolean xj(JSONObject jSONObject, JSONObject jSONObject2) {
        return (jSONObject == null || jSONObject2 == null) ? xj((Object) jSONObject, (Object) jSONObject2) : jSONObject.toString().equals(jSONObject2.toString());
    }

    public static String hf(JSONObject jSONObject) {
        try {
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            if (bytes.length == 0) {
                return "";
            }
            return TTEncryptUtils.clientPackedBase64(bytes, bytes.length);
        } catch (Exception e) {
            v.hf("parseEncrypt#parse error: " + e.getMessage());
            return "";
        }
    }

    public static String xj(Context context) {
        c en;
        f g = xj.g();
        if (g != null && (en = g.en()) != null) {
            return en.xj(context);
        }
        return "";
    }

    public static boolean w(Context context) {
        String xj2 = xj(context);
        return xj2 != null && xj2.endsWith(xj);
    }

    public static JSONObject w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        hf(jSONObject2, jSONObject);
        try {
            String xj2 = zm.xj(jSONObject2.optJSONObject("oaid"));
            if (!TextUtils.isEmpty(xj2)) {
                jSONObject2.put("oaid", xj2);
            }
        } catch (Exception e) {
            cu.hf(e);
        }
        return jSONObject2;
    }

    public static SharedPreferences hf(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, wn.xj(), 0);
    }

    public static boolean xj() {
        f g = xj.g();
        if (g != null) {
            return g.ai();
        }
        return true;
    }

    public static Looper hf(wn wnVar) {
        f hl;
        c en;
        if (wnVar == null || (hl = wnVar.hl()) == null || (en = hl.en()) == null) {
            return null;
        }
        return en.y();
    }

    public static JSONObject xj(JSONObject jSONObject) {
        c en;
        f g = xj.g();
        return (g == null || (en = g.en()) == null) ? jSONObject : en.xj(jSONObject);
    }

    public static JSONObject hf(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            cu.hf(e);
        }
        return jSONObject;
    }

    public static JSONObject xj(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("aid", xj.c());
            jSONObject2.putOpt("os", "android");
            jSONObject2.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject2.putOpt("device_brand", Build.BRAND);
            jSONObject2.putOpt("device_type", Build.MODEL);
            jSONObject2.putOpt("device_platform", "android");
            if (jSONObject != null) {
                jSONObject2.putOpt(com.sigmob.sdk.base.n.r, jSONObject.optString(com.sigmob.sdk.base.n.r));
                if (TextUtils.isEmpty(str)) {
                    jSONObject2.putOpt("device_id", jSONObject.optString("device_id"));
                } else {
                    jSONObject2.putOpt("device_id", str);
                }
                jSONObject2.putOpt("device_model", jSONObject.optString("device_model"));
                jSONObject2.putOpt("os_api", Integer.valueOf(jSONObject.optInt("os_api")));
                jSONObject2.putOpt("display_name", jSONObject.optString("display_name"));
                jSONObject2.putOpt("package", jSONObject.optString("package"));
                jSONObject2.putOpt("rom", jSONObject.optString("rom"));
                jSONObject2.putOpt("rom_version", d.hf());
                jSONObject2.putOpt(PluginConstants.KEY_SDK_VERSION, jSONObject.optString("sdk_version_name"));
                jSONObject2.putOpt("version_code", jSONObject.optString("version_code"));
                return jSONObject2;
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject2;
    }

    public static Looper xj(wn wnVar) {
        f hl;
        c en;
        if (wnVar == null || (hl = wnVar.hl()) == null || (en = hl.en()) == null) {
            return null;
        }
        return en.kd();
    }

    public static String xj(String str, HashMap<String, String> hashMap, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : hashMap.keySet()) {
            String xj2 = xj(str3, str2);
            String str4 = hashMap.get(str3);
            String xj3 = str4 != null ? xj(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(xj2);
            sb.append("=");
            sb.append(xj3);
        }
        return sb.toString();
    }

    private static String xj(String str, String str2) {
        if (str2 == null) {
            str2 = CharEncoding.ISO_8859_1;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void xj(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                cu.xj(th);
            }
        }
    }

    public static void xj(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                cu.hf(th);
            }
        }
    }

    public static String xj(String str) {
        c en;
        f g = xj.g();
        if (g != null && (en = g.en()) != null) {
            return en.xj(str);
        }
        return "";
    }
}
