package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class f implements Runnable {
    private String hf;
    private final Map<String, String> u = y.hf();
    private String w;
    private final Context xj;

    public static final class xj {
        public int c;
        public String d;
        public int f;
        public int hf;
        public String kd;
        public boolean tf;
        public String u;
        public String w;
        public String xj;
        public int y;

        public String toString() {
            try {
                return new JSONObject().put(n.p, this.xj).put("version_code", this.hf).put("sign", this.u).put("max_version", this.c).put("min_version", this.y).put("is_revert", this.tf).put(TKDownloadReason.KSAD_TK_MD5, this.kd).put("plugin_file", this.d).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }

    public f(Context context) {
        this.xj = context;
    }

    private JSONObject hf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conn_type", com.bytedance.sdk.openadsdk.api.plugin.w.kd.hf(this.xj));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, "7.1.3.2");
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            jSONObject.put(n.r, u());
            jSONObject.put(n.p, this.w);
            jSONObject.put("vendor", Build.MANUFACTURER);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str = this.u.get("appid");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put(PluginConstants.KEY_APP_ID, str);
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.api.plugin.w.u.xj(str != null ? str.concat(String.valueOf(currentTimeMillis)).concat("7.1.3.2") : ""));
            jSONObject.put("channel", "main");
            jSONObject.put("imei", this.u.get("imei"));
            jSONObject.put(n.l, 0);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", w());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String u() {
        Context context;
        if (TextUtils.isEmpty(this.hf) && (context = this.xj) != null) {
            try {
                this.w = context.getPackageName();
                this.hf = this.xj.getPackageManager().getPackageInfo(this.w, 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return this.hf;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PluginConstants.KEY_APP_ID, this.u.get("appid"));
        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
        jSONObject2.put(PluginConstants.KEY_SDK_VERSION, "7.1.3.2");
        jSONObject2.put("plugin_update_network", "2");
        jSONObject.put("com.byted.pangle", jSONObject2);
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        kd.xj("plugin_download", "start run");
        String xj2 = com.bytedance.sdk.openadsdk.api.plugin.hf.w.xj().xj(true, "https://api-access.pangolin-sdk-toutiao.com/api/ad/union/sdk/settings/plugins", com.bytedance.sdk.openadsdk.api.plugin.w.hf.xj(hf()).toString().getBytes());
        if (xj2 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(xj2);
            if (jSONObject.optInt("cypher") == 3) {
                String hf = com.bytedance.sdk.openadsdk.api.plugin.w.hf.hf(jSONObject.optString("message"));
                if (TextUtils.isEmpty(hf)) {
                    return;
                }
                w.xj(this.xj).xj(xj(new JSONObject(hf).optJSONArray("plugins")));
            }
        } catch (JSONException e) {
            kd.xj("plugin_download", "failed:".concat(String.valueOf(e)));
        }
    }

    public void xj() {
        if (com.bytedance.sdk.openadsdk.api.plugin.w.kd.xj(this.xj)) {
            run();
        }
    }

    private List<xj> xj(JSONArray jSONArray) {
        kd.xj("plugin_download", "parse start");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    xj xjVar = new xj();
                    xjVar.xj = optJSONObject.optString(n.p);
                    xjVar.hf = optJSONObject.optInt("version_code");
                    xjVar.w = optJSONObject.optString("download_url");
                    xjVar.u = optJSONObject.optString("sign");
                    xjVar.y = xj(optJSONObject.optString("min_version"));
                    xjVar.c = xj(optJSONObject.optString("max_version"));
                    xjVar.f = optJSONObject.optInt("plugin_update_network");
                    arrayList.add(xjVar);
                    kd.xj("plugin_download", "parse " + i + " : " + xjVar);
                }
            }
        }
        return arrayList;
    }

    private int xj(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str.replace(".", ""));
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }
}
