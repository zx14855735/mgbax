package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class jk {
    private static long hf = -1;
    private static final String xj = null;

    private static List<String> u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Context context) {
        try {
            List<String> xj2 = com.bytedance.sdk.openadsdk.core.j.w.xj().xj(context);
            if (xj2 != null && !xj2.isEmpty()) {
                List<String> u = u(com.bytedance.sdk.openadsdk.core.hf.xj().get("install_app_string", xj));
                hf(xj(xj2));
                if (u != null && !u.isEmpty()) {
                    xj2.removeAll(u);
                }
                w(xj(xj2));
            }
        } catch (Exception unused) {
        }
    }

    public static JSONArray xj(final Context context) {
        if (System.currentTimeMillis() - hf <= 1000) {
            return null;
        }
        hf = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.j.f.u() || !hf() || !com.bytedance.sdk.openadsdk.core.pz.hf().uf() || !com.bytedance.sdk.openadsdk.core.f.zg().e().hf()) {
            return null;
        }
        com.bytedance.sdk.component.tf.c.xj(new com.bytedance.sdk.component.tf.d("getIncrementalInstallApps") { // from class: com.bytedance.sdk.openadsdk.core.a.jk.1
            @Override // java.lang.Runnable
            public void run() {
                jk.w(context);
            }
        }, 1);
        return xj();
    }

    private static void hf(String str) {
        com.bytedance.sdk.openadsdk.core.hf.xj().put("install_app_string", str);
    }

    private static boolean hf() {
        long j = com.bytedance.sdk.openadsdk.core.hf.xj().get("apptime", -1L);
        return j == -1 || System.currentTimeMillis() - j > 43200000;
    }

    private static void w(String str) {
        com.bytedance.sdk.component.u.hf.w xj2 = com.bytedance.sdk.openadsdk.core.hf.xj();
        xj2.put("install_app_incremental_string", str);
        xj2.put("apptime", System.currentTimeMillis());
    }

    private static JSONArray xj() {
        try {
            String str = com.bytedance.sdk.openadsdk.core.hf.xj().get("install_app_incremental_string", xj);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONArray((Collection) u(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String xj(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            xj(0, 0, null);
            return false;
        }
        if (wo.hf(com.bytedance.sdk.openadsdk.core.pz.getContext()) && !wo.w(com.bytedance.sdk.openadsdk.core.pz.getContext(), str)) {
            xj(0, 0, null);
        }
        return false;
    }

    private static void xj(final int i, final int i2, final String str) {
        com.bytedance.sdk.openadsdk.core.ht.hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.jk.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("call_api_status", i);
                    jSONObject.put("has_actived", i2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("call_active_api").hf(jSONObject.toString());
            }
        }, "call_active_api", true);
    }
}
