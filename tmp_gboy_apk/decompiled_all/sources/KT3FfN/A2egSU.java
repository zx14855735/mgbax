package KT3FfN;

import ADYaiT.DUi7mC;
import JrXYwF.A5SV6n;
import JrXYwF.AMqCpz;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile JSONObject f4255A2egSU;

    public static JSONObject A2egSU(Map map) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (f4255A2egSU == null) {
            Context context = A5SV6n.f4149A2egSU;
            try {
                JSONObject jSONObject2 = new JSONObject();
                f4255A2egSU = jSONObject2;
                jSONObject2.put("os", "Android");
                f4255A2egSU.put("platform", "Android");
                f4255A2egSU.put("sdk_lib", "Android");
                JSONObject jSONObject3 = f4255A2egSU;
                String str = Build.VERSION.RELEASE;
                if (!str.contains(".")) {
                    str = str.concat(".0");
                }
                jSONObject3.put("os_version", str);
                f4255A2egSU.put("os_api", Build.VERSION.SDK_INT);
                f4255A2egSU.put("use_apm_sdk", "1");
                f4255A2egSU.put(PluginConstants.KEY_SDK_VERSION, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
                f4255A2egSU.put("sdk_version_code", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
                f4255A2egSU.put("sdk_version_name", "0.0.1-alpha.17-cloud");
                String str2 = Build.MODEL;
                String str3 = Build.BRAND;
                if (str2 == null) {
                    str2 = str3;
                } else if (str3 != null && !str2.contains(str3)) {
                    str2 = str3 + ' ' + str2;
                }
                f4255A2egSU.put("device_model", str2);
                f4255A2egSU.put("device_brand", str3);
                f4255A2egSU.put("device_manufacturer", Build.MANUFACTURER);
                f4255A2egSU.put("aid", String.valueOf(map.get("aid")));
                f4255A2egSU.put(n.r, map.get(n.r));
                f4255A2egSU.put("version_code", map.get("version_code"));
                f4255A2egSU.put("update_version_code", map.get("update_version_code"));
                f4255A2egSU.put("manifest_version_code", map.get("version_code"));
                f4255A2egSU.put("channel", map.get("channel"));
                f4255A2egSU.put("bd_did", A5SV6n.A2egSU().A5SV6n());
                f4255A2egSU.put("package", context.getPackageName());
                f4255A2egSU.put("display_name", context.getApplicationInfo().name);
                A4TApA(f4255A2egSU);
            } catch (Exception unused) {
            }
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", f4255A2egSU);
        jSONObject.put("local_time", currentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject4 = new JSONObject();
        long currentTimeMillis2 = System.currentTimeMillis();
        jSONObject4.put("local_time_ms", currentTimeMillis2);
        jSONObject4.put("tea_event_index", 10001);
        jSONObject4.put("session_id", UUID.randomUUID().toString());
        jSONObject4.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(currentTimeMillis2)));
        jSONArray.put(jSONObject4);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    public static void A4TApA(JSONObject jSONObject) {
        Object obj;
        DUi7mC dUi7mC = A5SV6n.f4151A5SV6n;
        if (dUi7mC == null || jSONObject == null) {
            return;
        }
        if (((Map) dUi7mC.f241AzWtSf) == null) {
            dUi7mC.f241AzWtSf = ((AMqCpz) dUi7mC.f240AmA8tU).c();
        }
        Map map = (Map) dUi7mC.f241AzWtSf;
        if (map != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str) && (obj = map.get(str)) != null) {
                        jSONObject2.put(str, obj);
                    }
                }
                jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
            } catch (Exception unused) {
                com.bumptech.glide.AMqCpz.C2rE4F();
            }
        }
    }
}
