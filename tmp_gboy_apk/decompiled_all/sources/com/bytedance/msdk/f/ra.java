package com.bytedance.msdk.f;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ra {
    public static JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        Context context = com.bytedance.msdk.core.hf.getContext();
        try {
            jSONObject.put("device_id", dk.xj());
            jSONObject.put("user_unique_id", !TextUtils.isEmpty(dk.xj()) ? dk.xj() : UUID.randomUUID().toString());
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, com.bytedance.msdk.hf.hf.hf());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.hf.hf.u());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", dk.am());
            jSONObject.put("device_model", dk.c());
            jSONObject.put("resolution", com.bytedance.msdk.xj.kd.c.w(com.bytedance.msdk.core.hf.getContext()) + "x" + com.bytedance.msdk.xj.kd.c.hf(com.bytedance.msdk.core.hf.getContext()));
            jSONObject.put(MediaFormat.KEY_LANGUAGE, dk.d());
            jSONObject.put("timezone", dk.en());
            jSONObject.put("access", dk.y());
            jSONObject.put("openudid", dk.u());
            jSONObject.put("aid", "5685");
            jSONObject.put("display_name", d.hf());
            jSONObject.put(n.r, d.xj());
            jSONObject.put("package", l.xj());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", dk.j());
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            xj(context, jSONObject);
            jSONObject.put("display_density", dk.l());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", com.bytedance.msdk.xj.kd.c.kd(context));
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", dk.x());
            jSONObject.put("version_code", l.hf());
            jSONObject.put("udid", dk.pz());
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, w());
            String ht = dk.ht();
            if (TextUtils.isEmpty(ht)) {
                ht = "127.0.0.1";
            } else if (ht.contains(",")) {
                ht = xj(ht);
            }
            jSONObject.put("ip", ht);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.msdk.kd.hf.hf.xj("getUploadEventV3Header", "exception: " + e.toString());
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    private static JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", dk.pz());
            jSONObject.put("imei_md5", ht.xj(dk.pz()));
            jSONObject.put("gaid", f.xj().hf());
            jSONObject.put("applog_did", dk.xj());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.xj.p().e());
            jSONObject.put("android_id", dk.u());
            jSONObject.put("oaid", dk.hf());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", dk.g());
            jSONObject.put("imei", dk.pz());
            jSONObject.put("imei_md5", ht.xj(dk.pz()));
            jSONObject.put("gaid", f.xj().hf());
            jSONObject.put("oaid", dk.hf());
            jSONObject.put("applog_did", dk.xj());
            jSONObject.put("device_model", dk.c());
            jSONObject.put("vendor", dk.e());
            jSONObject.put("ua", dk.z());
            jSONObject.put("ip", dk.ht());
            jSONObject.put(n.p, l.xj());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.xj.p().e());
            jSONObject.put("android_id", dk.u());
            jSONObject.put("os_version", dk.am());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject xj(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", dk.pz());
            jSONObject.put("android_id", dk.u());
            jSONObject.put("uuid", dk.ra());
            jSONObject.put("ssid", dk.et());
            jSONObject.put("wifi_mac", dk.io());
            jSONObject.put("imsi", dk.dk());
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            jSONObject.put("power_on_time", sb.toString());
            jSONObject.put("rom_version", x.xj());
            jSONObject.put("sys_compiling_time", dk.w());
            jSONObject.put(PointParamKey.TYPE, dk.q());
            jSONObject.put("os", dk.g());
            jSONObject.put("os_version", dk.am());
            jSONObject.put("vendor", dk.e());
            jSONObject.put("device_model", dk.c());
            jSONObject.put(MediaFormat.KEY_LANGUAGE, dk.d());
            jSONObject.put("conn_type", dk.kd());
            jSONObject.put("mac", dk.ai());
            jSONObject.put("screen_width", com.bytedance.msdk.xj.kd.c.hf(context));
            jSONObject.put("screen_height", com.bytedance.msdk.xj.kd.c.w(context));
            jSONObject.put("oaid", dk.hf());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static void xj(Context context, JSONObject jSONObject) {
        ArrayList<String> xj;
        if (context == null || jSONObject == null || (xj = tf.xj(context, "MD5")) == null || xj.isEmpty()) {
            return;
        }
        try {
            jSONObject.put("sig_hash", Build.MANUFACTURER);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static String xj(String str) {
        String[] split = str.split(",");
        if (split != null && split.length > 0 && !TextUtils.isEmpty(split[0])) {
            return split[0].trim();
        }
        return "127.0.0.1";
    }
}
