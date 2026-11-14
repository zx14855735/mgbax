package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private static String xj = "AppEnvironment";
    private Map<String, String> hf;
    private String kd;
    private boolean u;
    private long w;

    public static class xj {
        public static final u xj = new u();

        static {
            MrRvk();
        }

        private static /* synthetic */ void MrRvk() {
            char[] charArray = "ßÓÑ\u0092ÛÝÑÙ\u0092ÞÓÅ\u0092ÏÔÙÐÐ\u0092öÒÕþÎÕØÛÙ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 188);
            }
            String str = new String(charArray);
            char[] charArray2 = "ßÐÕÒÕÈ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 188);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject kd() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = pz.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put(PluginConstants.KEY_APP_ID, f.zg().pz());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void u() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) pz.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.bytedance.sdk.component.utils.pl.u(xj, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.bytedance.sdk.component.utils.pl.u(xj, "maxMemory: ".concat(String.valueOf(maxMemory)));
        com.bytedance.sdk.component.utils.pl.u(xj, "totalMemory: ".concat(String.valueOf(f)));
        com.bytedance.sdk.component.utils.pl.u(xj, "freeMemory: ".concat(String.valueOf((float) ((runtime.freeMemory() * 1.0d) / 1048576.0d))));
        int i = (int) ((f / maxMemory) * 100.0f);
        com.bytedance.sdk.component.utils.pl.u(xj, "totalMaxRate: ".concat(String.valueOf(i)));
        this.hf.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.hf.put("total_max_memory_rate", String.valueOf(i));
    }

    public void hf(String str) {
        this.hf.put("request_ad_info", str);
    }

    public void w(String str) {
        this.hf.put("show_ad_info", str);
    }

    private u() {
        this.kd = "";
        HashMap hashMap = new HashMap();
        this.hf = hashMap;
        hashMap.put("ad_style", "default");
        this.hf.put(MediationConstant.EXTRA_ADID, "default");
        this.hf.put("rit", "default");
        this.hf.put(PointParamKey.REQUEST_ID, "default");
        this.hf.put("ad_slot_type", "default");
        this.hf.put("net_type", "default");
        this.hf.put("low_memory", "default");
        this.hf.put("total_max_memory_rate", "default");
        this.hf.put("commit_hash", "c2d0b757b5");
        this.hf.put("branch", "");
        this.hf.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
        this.hf.put("sdk_api_version", ai.u);
        this.hf.put("setting_ab_version", com.bytedance.sdk.openadsdk.core.w.kd.xj().kd());
        this.w = com.bytedance.sdk.openadsdk.core.a.j.xj("tt_sp_app_env").get("last_app_env_time", 0L);
        this.u = false;
    }

    public void hf(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        this.hf.put(MediationConstant.EXTRA_ADID, wsVar.ho());
        Map<String, String> map = this.hf;
        StringBuilder sb = new StringBuilder();
        sb.append(wo.d(wsVar));
        map.put("rit", sb.toString());
        this.hf.put(PointParamKey.REQUEST_ID, wo.g(wsVar));
        Map<String, String> map2 = this.hf;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(wo.f(wsVar));
        map2.put("ad_slot_type", sb2.toString());
        this.hf.put("net_type", com.bytedance.sdk.component.utils.am.c(pz.getContext()));
        if (com.bytedance.sdk.openadsdk.core.a.ht.hf(wsVar)) {
            this.hf.put("ad_style", "is_playable");
        }
        u();
    }

    public void w() {
        if (this.u || wo.xj(this.w, System.currentTimeMillis())) {
            return;
        }
        this.u = true;
        com.bytedance.sdk.openadsdk.core.ht.am.xj().f(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.u.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                u.this.u = false;
                com.bytedance.sdk.openadsdk.core.ht.xj.hf<com.bytedance.sdk.openadsdk.core.ht.xj.hf> hf = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf();
                JSONObject kd = u.this.kd();
                if (kd != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    u.this.w = currentTimeMillis;
                    com.bytedance.sdk.openadsdk.core.a.j.xj("tt_sp_app_env").put("last_app_env_time", currentTimeMillis);
                    hf.hf(kd.toString());
                }
                return hf;
            }
        });
    }

    public static u xj() {
        return xj.xj;
    }

    public void xj(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        String og = wsVar.og();
        Map<String, String> map = this.hf;
        if (TextUtils.isEmpty(og)) {
            og = "";
        }
        map.put("ad_info", og);
    }

    public void xj(String str) {
        this.hf.put("dynamic_ptpl_id", str);
    }

    public Map<String, String> hf() {
        return this.hf;
    }
}
