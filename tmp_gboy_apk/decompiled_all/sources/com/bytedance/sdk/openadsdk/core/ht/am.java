package com.bytedance.sdk.openadsdk.core.ht;

import ADYaiT.CtFAbx;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.en;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra;
import com.bytedance.sdk.openadsdk.core.ra.s;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am {
    private static volatile am xj;

    private am() {
    }

    private boolean hf(com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar) {
        return hfVar == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void kd(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !str.startsWith("zeus") && !TextUtils.equals("plugin_load_failed", str)) {
                str = "zeus_".concat(str);
            }
            final String str3 = str;
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
            if (str2 != null) {
                jSONObject.put("current_version", "7.1.3.2");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            final int optInt = jSONObject.has("status_code") ? jSONObject.optInt("status_code") : jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
            final String optString = jSONObject.optString("message");
            final String optString2 = jSONObject.optString(MediationConstant.EXTRA_DURATION);
            final String jSONObject2 = jSONObject.toString();
            hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.41
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    return "zeus_load_finish".equals(str3) ? com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(str3).hf(jSONObject2).hf(optInt).c(optString).kd(optString2).xj(am.xj("7.1.3.2") ? 1 : 0) : com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(str3).hf(jSONObject2).hf(optInt).kd(optString2).c(optString);
                }
            }, str3, true);
        } catch (Throwable unused) {
        }
    }

    public static am xj() {
        if (xj == null) {
            synchronized (am.class) {
                try {
                    if (xj == null) {
                        xj = new am();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void c(com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        w(xjVar, "splash_creative_check");
    }

    public void d(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.38
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("type_realtime_feature_cost");
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "type_realtime_feature_cost", true);
    }

    public void f(final com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        if (xjVar == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.9
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return ((com.bytedance.sdk.openadsdk.core.ht.xj.hf) xjVar.xj()).xj("app_env").xj(System.currentTimeMillis() / 1000);
            }
        }, "app_env", true);
    }

    public void w(final String str, final String str2) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.42
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("lp_monitor").y(str2).hf(str);
            }
        }, "lp_monitor", true);
    }

    public void y(com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        u(xjVar, "show_backup_endcard");
    }

    private void u(final com.bytedance.sdk.openadsdk.p.xj.xj xjVar, final String str) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.5
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar = (com.bytedance.sdk.openadsdk.core.ht.xj.hf) xjVar.xj();
                hfVar.xj(str);
                hfVar.xj(currentTimeMillis);
                return hfVar;
            }
        }, str, true);
    }

    private void w(com.bytedance.sdk.openadsdk.p.xj.xj xjVar, String str) {
        xj(xjVar, str, true);
    }

    public void c(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.35
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("render_timeout_opt");
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "render_timeout_opt", true);
    }

    public void f(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.36
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("landingpage_check_info");
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "landingpage_check_info", true);
    }

    public void hf(final String str, final String str2) {
        com.bytedance.sdk.component.tf.c.w(new com.bytedance.sdk.component.tf.d("plugin_report") { // from class: com.bytedance.sdk.openadsdk.core.ht.am.40
            @Override // java.lang.Runnable
            public void run() {
                if (!"exception".equals(str)) {
                    am.kd(str, str2);
                    return;
                }
                try {
                    JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
                    if (str2 != null) {
                        am.this.xj(jSONObject.optString("scene"), jSONObject, (Throwable) null);
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    public void y(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.34
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("device_bytebench");
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "device_bytebench", true);
    }

    public void hf() {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.43
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.zg.w.w.u v = com.bytedance.sdk.openadsdk.core.f.zg().v();
                boolean hf = v.hf();
                boolean xj2 = v.xj();
                boolean kd = v.kd();
                boolean u = v.u();
                boolean w = v.w();
                boolean y = v.y();
                String pl2 = v.pl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("access_fine_location", xj2 ? 1 : 0);
                    jSONObject.put("applist", hf ? 1 : 0);
                    jSONObject.put("external_storage", kd ? 1 : 0);
                    jSONObject.put("wifi_state", u ? 1 : 0);
                    jSONObject.put("phone_state", w ? 1 : 0);
                    jSONObject.put("can_use_androidId", y ? 1 : 0);
                    jSONObject.put("dev_oaid", pl2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("sdk_permission").hf(jSONObject.toString());
            }
        }, "sdk_permission", true);
    }

    public void w(com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        w(xjVar, "outer_call_no_rsp");
    }

    public void hf(com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        w(xjVar, "outer_call_send");
    }

    public void u(com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        w(xjVar, "load_timeout");
    }

    public void w(JSONObject jSONObject) {
        xj("live_init_start", jSONObject);
    }

    public void hf(final int i) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.18
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("get_ad_cache_failed").hf(i);
            }
        }, "get_ad_cache_failed", true);
    }

    public void u(JSONObject jSONObject) {
        xj("live_init_success", jSONObject);
    }

    public void w(ws wsVar, String str) {
        xj(wsVar, str, (JSONObject) null);
    }

    public void hf(final String str) {
        if (str == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.19
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("error_ad_info").xj(System.currentTimeMillis() / 1000).d(str);
            }
        }, "error_ad_info", true);
    }

    public void hf(com.bytedance.sdk.openadsdk.p.xj.xj xjVar, String str) {
        hf.w().xj(xjVar, str, true);
    }

    public void xj(com.bytedance.sdk.openadsdk.p.xj.xj xjVar, String str) {
        hf.w().xj(xjVar, str, true);
    }

    public void hf(final JSONObject jSONObject) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.23
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("saas_schema").hf(jSONObject.toString());
            }
        }, "saas_schema");
    }

    public void xj(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("render_backup").hf(jSONObject.toString());
            }
        }, "render_backup", true);
    }

    public static void xj(SparseArray<Object> sparseArray, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        com.bytedance.sdk.openadsdk.zg.xj xjVar = new com.bytedance.sdk.openadsdk.zg.xj(sparseArray);
        PluginValueSet u = xjVar.u();
        boolean xj2 = xjVar.xj();
        int hf = xjVar.hf();
        String w = xjVar.w();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put(cb.o, xj2);
            jSONObject4.put(PluginConstants.KEY_ERROR_CODE, hf);
            jSONObject4.put("message", w);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        if (u != null) {
            JSONObject jSONObject5 = (JSONObject) u.objectValue(10, JSONObject.class);
            String stringValue = u.stringValue(5);
            r0 = jSONObject5 != null ? System.currentTimeMillis() - jSONObject5.optLong("run_package_start", 0L) : -1L;
            JSONObject jSONObject6 = (JSONObject) u.objectValue(3, JSONObject.class);
            jSONObject3 = (JSONObject) u.objectValue(4, JSONObject.class);
            jSONObject2 = jSONObject6;
            str = stringValue;
        } else {
            str = null;
            jSONObject2 = null;
            jSONObject3 = null;
        }
        xj().xj(str, jSONObject != null ? jSONObject.optString("business_type") : "", xj2, r0, jSONObject2, jSONObject3, jSONObject4);
    }

    public void hf(final ws wsVar, final String str) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.30
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("uttie_close");
                ws wsVar2 = wsVar;
                if (wsVar2 != null) {
                    xj2.y(wsVar2.zf());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "uttie_close");
    }

    public void kd(com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        u(xjVar, "express_ad_render");
    }

    public void kd(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.33
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("device_qty_compare");
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "device_qty_compare", true);
    }

    public void xj(final long j, final long j2, final int i) {
        final long j3 = j2 - j;
        if (j3 <= 0 || j3 >= 30000000) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.12
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j2);
                    jSONObject.put("start_type", i);
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("general_label");
                StringBuilder sb = new StringBuilder();
                sb.append(j3);
                return xj2.kd(sb.toString()).hf(jSONObject.toString());
            }
        }, "general_label", true);
    }

    public void xj(final String str, final String str2) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.22
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("sdk_retention").kd(str).hf(jSONObject.toString());
            }
        }, "sdk_retention", true);
    }

    public void xj(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.32
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    Object obj3 = obj;
                    if (obj3 instanceof Boolean) {
                        jSONObject.put("is_button", obj3);
                    }
                    Object obj4 = obj2;
                    if (obj4 instanceof Boolean) {
                        jSONObject.put("convert_result", obj4);
                    }
                    jSONObject.put("error_msg", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put(MediationConstant.EXTRA_ADID, str3);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("obm_result").hf(jSONObject.toString());
            }
        }, "obm_result", true);
    }

    public void xj(String str, int i, int i2, String str2, final int i3, final String str3, final long j) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i3);
            jSONObject.put("message", str3);
            jSONObject.put("version", i2);
            jSONObject.put("current_version", i);
            jSONObject.put(n.p, str);
            jSONObject.put("url", str2);
            jSONObject.put(MediationConstant.EXTRA_DURATION, j);
        } catch (Throwable unused) {
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.39
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf c = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("plugin_download").hf(i3).c(str3);
                StringBuilder sb = new StringBuilder();
                sb.append(j);
                return c.kd(sb.toString()).hf(jSONObject.toString());
            }
        }, "plugin_download", true);
    }

    public static boolean xj(String str) {
        com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
        String str2 = xj2.get("plugin_first_load", "");
        if (!TextUtils.isEmpty(str2) && str2.endsWith(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = CtFAbx.AlLFFp(str2, "-", str);
        }
        xj2.put("plugin_first_load", str);
        return true;
    }

    public void xj(final ws wsVar, final JSONObject jSONObject) {
        if (wsVar == null) {
            return;
        }
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf y = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("jsb_video_action").y(wsVar.zf());
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    y.hf(jSONObject2.toString());
                }
                y.w(wo.xj(wsVar, ""));
                return y;
            }
        }, "jsb_video_action", true);
    }

    public static void xj(final String str, final long j, final boolean z) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.3
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_agg", z);
                jSONObject.put("timestamp", j);
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("over_freq").w(str).hf(jSONObject.toString());
            }
        }, "over_freq", true);
    }

    private void xj(final com.bytedance.sdk.openadsdk.p.xj.xj xjVar, final String str, boolean z) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.4
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar = (com.bytedance.sdk.openadsdk.core.ht.xj.hf) xjVar.xj();
                hfVar.xj(str);
                hfVar.xj(currentTimeMillis);
                return hfVar;
            }
        }, str, true);
    }

    public void xj(com.bytedance.sdk.openadsdk.p.xj.xj xjVar) {
        w(xjVar, "outer_call");
    }

    private boolean xj(String str, int i) {
        com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
        int i2 = xj2.get(str, 0);
        boolean z = (i2 & 2) == 0 || (i2 & 1) != i;
        if (z) {
            xj2.put(str, i + 2);
        }
        return z;
    }

    public void xj(final int i, ws wsVar, final boolean z) {
        final String valueOf = String.valueOf(wo.d(wsVar));
        if (xj(valueOf, z ? 1 : 0)) {
            hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.6
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    com.bytedance.sdk.openadsdk.core.ht.xj.hf w = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(i).w(valueOf);
                    if (z) {
                        w.xj("reg_creative");
                        return w;
                    }
                    w.xj("no_reg_creative");
                    return w;
                }
            }, z ? "reg_creative" : "no_reg_creative", true);
        }
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar) {
        if (hf(hfVar)) {
            return;
        }
        hfVar.xj("load_icon_error");
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.7
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return hfVar;
            }
        }, "load_icon_error", true);
    }

    public void xj(final boolean z, final String[] strArr) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.8
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("if_sd", z ? 1 : 0);
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str);
                                sb.append(",");
                            }
                        }
                        jSONObject.put(PointCategory.PERMISSION, sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("download_permission").xj(System.currentTimeMillis() / 1000).hf(jSONObject.toString());
            }
        }, "download_permission", true);
    }

    public void xj(final String str, final String str2, final String str3, final boolean z) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.10
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("get_bidding_token");
                boolean hf = pz.hf().hf(str);
                JSONObject jSONObject = new JSONObject();
                if (hf) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, Constants.FAIL)) {
                        jSONObject.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject.put("no_cache_reason", 1);
                    }
                }
                if (z) {
                    jSONObject.put("opt_sample", 1);
                }
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "get_bidding_token", z);
    }

    public void xj(final long j, final com.bytedance.sdk.openadsdk.core.x.kd kdVar) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.11
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject.put("ext_plugin_code", en.hf());
                com.bytedance.sdk.openadsdk.core.x.kd kdVar2 = kdVar;
                if (kdVar2 != null) {
                    jSONObject.put(cb.o, kdVar2.xj() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.x.c hf = kdVar.hf();
                    if (hf != null) {
                        jSONObject.put(br.c, hf.toString());
                        jSONObject.put(PluginConstants.KEY_ERROR_CODE, hf.xj());
                    }
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("pitaya_init").hf(jSONObject.toString());
            }
        }, "pitaya_init", true);
    }

    public void xj(final String str, final String str2, final boolean z, final long j, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.13
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject4.put("business", str);
                jSONObject4.put("biztype", str2);
                jSONObject4.put("result", z);
                JSONObject jSONObject5 = jSONObject;
                if (jSONObject5 != null) {
                    jSONObject4.put("package_info", jSONObject5.toString());
                }
                JSONObject jSONObject6 = jSONObject2;
                if (jSONObject6 != null) {
                    jSONObject4.put("error_info", jSONObject6.toString());
                }
                JSONObject jSONObject7 = jSONObject3;
                if (jSONObject7 != null) {
                    jSONObject4.put("common_info", jSONObject7.toString());
                }
                jSONObject4.put("ext_plugin_code", en.hf());
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("pitaya_run_task").hf(jSONObject4.toString());
            }
        }, "pitaya_run_task", true);
    }

    public void xj(final int i, ra raVar) {
        if (raVar == null) {
            return;
        }
        final JSONObject xj2 = raVar.xj(-1L);
        final long hf = raVar.hf();
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.14
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj3 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("bid_token_time");
                try {
                    xj2.put("total", hf);
                    xj2.put("opt_sample", 1);
                    xj2.put("slot_type", i);
                    xj3.hf(xj2.toString());
                } catch (Throwable unused) {
                }
                return xj3;
            }
        }, "get_bidding_token", true);
    }

    public void xj(int i, long j, String str) {
        xj(i, j, (Boolean) null, str);
    }

    public void xj(final int i, final long j, final Boolean bool, final String str) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.15
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j2 = j;
                    if (j2 >= 0) {
                        jSONObject.put("cost_time", j2);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        jSONObject.put("init_succ", bool2.booleanValue() ? 1 : 2);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i2 = i;
                    if (i2 != -1) {
                        jSONObject.put("event_res", i2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(PointParamKey.TYPE, str);
                    }
                    xj2.hf(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return xj2;
            }
        }, "encrypt_track", true);
    }

    public void xj(final int i) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.16
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("has_pre_req").hf(i);
            }
        }, "has_pre_req", true);
    }

    public void xj(final int i, final String str, final String str2, final String str3, final String str4) {
        hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.17
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fetch_adm", i == 0 ? 1 : 0);
                jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
                jSONObject.put(br.c, str);
                jSONObject.put("material_keys", str4);
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("fetch_adm_status").hf(i).w(str3).y(str2).hf(jSONObject.toString());
            }
        }, "fetch_adm_status", true);
    }

    public void xj(final String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.20
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(str);
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    xj2.hf(jSONObject2.toString());
                }
                return xj2;
            }
        }, str);
    }

    public void xj(String str, Throwable th) {
        xj(str, (JSONObject) null, th);
    }

    public void xj(final String str, final JSONObject jSONObject, final Throwable th) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.21
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("scene", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("exception", th);
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("exception").hf(jSONObject2.toString());
            }
        }, "exception");
    }

    public void xj(final ws wsVar, final long j, final boolean z, final boolean z2) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.24
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("req_id", wsVar.zf());
                jSONObject.put("auth", z);
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                jSONObject.put("time_out", z2);
                s cc = wsVar.cc();
                if (cc != null) {
                    jSONObject.put("saas_info", cc.xj());
                }
                jSONObject.put(n.m, wsVar.jf());
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("auth_time").hf(jSONObject.toString());
            }
        }, "auth_time");
    }

    public void xj(final String str, final String str2, final int i, final JSONObject jSONObject) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.25
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("event_type", str2);
                jSONObject2.putOpt("event", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("state", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("convert_event").hf(jSONObject2.toString());
            }
        }, "convert_event");
    }

    public void xj(final ws wsVar, final Object obj) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.26
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("upie_img_play_success");
                ws wsVar2 = wsVar;
                if (wsVar2 != null) {
                    xj2.y(wsVar2.zf());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MediationConstant.EXTRA_DURATION, obj);
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, wsVar);
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "upie_img_play_success");
    }

    public void xj(final ws wsVar, final int i, final String str) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.27
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("upie_img_play_fail");
                ws wsVar2 = wsVar;
                if (wsVar2 != null) {
                    xj2.y(wsVar2.zf());
                }
                xj2.hf(i);
                xj2.c(str);
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, wsVar);
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "upie_img_play_fail");
    }

    public void xj(final ws wsVar, final String str) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.28
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("uttie_start");
                ws wsVar2 = wsVar;
                if (wsVar2 != null) {
                    xj2.y(wsVar2.zf());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "uttie_start");
    }

    public void xj(final ws wsVar, final String str, final long j) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.29
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("uttie_played");
                ws wsVar2 = wsVar;
                if (wsVar2 != null) {
                    xj2.y(wsVar2.zf());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                jSONObject.put(MediationConstant.EXTRA_DURATION, j);
                xj2.hf(jSONObject.toString());
                return xj2;
            }
        }, "uttie_played");
    }

    public void xj(final ws wsVar, final String str, final JSONObject jSONObject) {
        hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.31
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(str);
                ws wsVar2 = wsVar;
                if (wsVar2 != null) {
                    xj2.y(wsVar2.zf()).f(wsVar.jf());
                }
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    xj2.hf(jSONObject2.toString());
                }
                return xj2;
            }
        }, str);
    }

    public static void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final long j, final long j2, final long j3, final int i, final int i2, final int i3) {
        xj().c(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ht.am.37
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                int i4 = i3 > 0 ? 2 : 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i4));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j2));
                jSONObject.putOpt("total_duration", Long.valueOf(j3));
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(i));
                jSONObject.putOpt("check_count", Integer.valueOf(i2));
                jSONObject.putOpt("success_count", Integer.valueOf(i3));
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(i).w(hfVar.u()).hf((int) j).hf(jSONObject.toString());
            }
        });
    }
}
