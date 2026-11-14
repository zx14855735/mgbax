package com.bytedance.sdk.openadsdk.api.plugin;

import ADYaiT.CtFAbx;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class y {
    private static SharedPreferences hf;
    private static final List<Pair<String, JSONObject>> w = new CopyOnWriteArrayList();
    static final Map<String, String> xj = new HashMap();

    static {
        uWFPKAk();
    }

    public static void hf(String str, JSONObject jSONObject) {
        w.add(new Pair<>(str, jSONObject));
    }

    private static void kd(final String str, final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.yo.xj.xj().w().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.y.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(y.y(str, jSONObject));
                y.hf(arrayList);
            }
        });
    }

    private static void u(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            kd(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("event_name", str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    private static /* synthetic */ void uWFPKAk() {
        char[] charArray = "ëçå¦ïéåí¦êçñ¦ûàíää¦ÂæáÊúáìïí".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 136);
        }
        String str = new String(charArray);
        char[] charArray2 = "ëäáæáü".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 136);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject y(String str, JSONObject jSONObject) {
        String str2 = "7.1.3.2";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            jSONObject.put("is_boost", true);
            jSONObject.put("is_only_armv8a", com.bytedance.sdk.openadsdk.api.plugin.w.w.w());
            jSONObject2.put("ad_sdk_version", "7.1.3.2");
            String xj2 = d.xj("com.byted.pangle");
            if (!TextUtils.isEmpty(xj2)) {
                str2 = xj2;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = xj;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put(PointParamKey.TYPE, str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(bn.i, Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        if (hf == null) {
            hf = hf.hf(TTAppContextHolder.getContext(), "tt_sdk_settings_other", 0);
        }
        String BI9f7h2 = CtFAbx.BI9f7h("https://", hf.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = w;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(y((String) pair.first, (JSONObject) pair.second));
                }
                w.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.hf.w.xj().xj(true, BI9f7h2, com.bytedance.sdk.openadsdk.api.plugin.w.hf.xj(jSONObject).toString().getBytes());
    }

    public static void xj(int i, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
            jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
            jSONObject.putOpt("message", str);
            jSONObject.putOpt("load_record", kd.xj());
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.y.xj(e);
        }
        kd("plugin_load_failed", jSONObject);
    }

    public static void xj(String str, JSONObject jSONObject) {
        u("zeus_".concat(String.valueOf(str)), jSONObject);
    }

    public static void xj() {
        List<Pair<String, JSONObject>> list = w;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    u((String) pair.first, (JSONObject) pair.second);
                }
            }
            w.clear();
        } catch (Exception unused) {
        }
    }

    public static void xj(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = xj;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        map.put("plugin_update_conf", pluginUpdateConfig != 0 ? String.valueOf(pluginUpdateConfig) : "2");
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }

    public static Map<String, String> hf() {
        return xj;
    }
}
