package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.embedapplog.kd;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ra {
    private static volatile String hf = "";
    private static volatile boolean u = false;
    private static volatile boolean w = false;
    private static volatile String xj = "";

    public static String hf(com.bytedance.sdk.openadsdk.qt.u uVar) {
        JSONObject xj2;
        if (uVar != null) {
            String type = uVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, "timeout")) {
                return "timeout";
            }
            kd.xj xj3 = uVar.xj();
            if (xj3 != null && !TextUtils.isEmpty(xj3.xj) && (xj2 = xj(xj3)) != null) {
                return xj2.toString();
            }
        }
        return "error";
    }

    private static void update(boolean z) {
        if (TextUtils.isEmpty(xj)) {
            return;
        }
        String hf2 = com.bytedance.sdk.component.utils.xj.hf(xj);
        com.bytedance.sdk.openadsdk.core.w.u.xj().u("app_log_oaid", xj);
        com.bytedance.sdk.openadsdk.core.w.u.xj().u("new_app_log_oaid", hf2);
        com.bytedance.sdk.openadsdk.core.w.u.xj().xj("is_use_dev_oaid", z);
    }

    public static String w(com.bytedance.sdk.openadsdk.qt.u uVar) {
        if (uVar == null) {
            return null;
        }
        String type = uVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, "timeout")) {
            return "timeout";
        }
        kd.xj xj2 = uVar.xj();
        return (xj2 == null || TextUtils.isEmpty(xj2.xj)) ? "error" : xj2.xj;
    }

    public static void xj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            w = true;
            xj = str;
            com.bytedance.sdk.openadsdk.tools.hf.hf(7, xj == null ? "" : xj);
            u = false;
            update(false);
        } catch (Throwable unused) {
        }
    }

    public static void xj(com.bytedance.sdk.openadsdk.qt.u uVar) {
        com.bytedance.sdk.openadsdk.xj.xj.xj.xj(uVar);
        com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(uVar);
    }

    public static kd.xj w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new kd.xj(str, false, xj(com.bytedance.sdk.openadsdk.core.pz.getContext()));
    }

    private static JSONObject xj(kd.xj xjVar) {
        if (xjVar == null) {
            return null;
        }
        String str = xjVar.xj;
        long j = xjVar.w;
        boolean z = xjVar.hf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(z));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(j));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(xj(com.bytedance.sdk.openadsdk.core.pz.getContext())));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    private static void hf() {
        u = com.bytedance.sdk.openadsdk.core.w.u.xj().hf("is_use_dev_oaid", false);
    }

    private static int xj(Context context) {
        String str = "com.huawei.hwid.tv";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                str = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                str = "com.huawei.hms";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return 0;
    }

    public static String xj(boolean z) {
        long j;
        if (!TextUtils.isEmpty(xj)) {
            return xj;
        }
        if (z && !TextUtils.isEmpty(hf)) {
            return hf;
        }
        try {
            String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("new_app_log_oaid", (String) null);
            if (TextUtils.isEmpty(w2)) {
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(w2);
                hf = com.bytedance.sdk.component.utils.xj.w(jSONObject.getString("value"));
                j = jSONObject.getLong("time");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(hf) && (z || System.currentTimeMillis() - j < 86400000)) {
            hf();
            return hf;
        }
        if (!w) {
            com.bytedance.sdk.openadsdk.core.y.xj().hf();
            com.bytedance.sdk.openadsdk.zg.w.w.u v = com.bytedance.sdk.openadsdk.core.f.zg().v();
            if (v != null && !TextUtils.isEmpty(v.pl())) {
                xj = v.pl();
                boolean z2 = !TextUtils.isEmpty(v.pl());
                u = z2;
                update(z2);
            }
            com.bytedance.sdk.openadsdk.tools.hf.hf(7, xj == null ? "" : xj);
        }
        return xj == null ? "" : xj;
    }

    public static int xj() {
        return u ? 1 : 0;
    }
}
