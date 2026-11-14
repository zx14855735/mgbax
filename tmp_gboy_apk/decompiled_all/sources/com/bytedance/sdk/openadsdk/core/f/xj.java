package com.bytedance.sdk.openadsdk.core.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.yo;
import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.base.views.r;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static volatile String hf;
    private static String w;
    private static volatile String xj;

    public static String c() {
        return yo.w();
    }

    public static String f() {
        try {
            if (!TextUtils.isEmpty(w)) {
                return w;
            }
            String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("app_sha1", 2592000000L);
            w = w2;
            if (!TextUtils.isEmpty(w2)) {
                return w;
            }
            String xj2 = com.bytedance.sdk.component.utils.w.xj(pz.getContext());
            w = xj2;
            if (!xj(xj2)) {
                return "";
            }
            w = w.toUpperCase(Locale.getDefault());
            com.bytedance.sdk.openadsdk.core.w.u.xj().u("app_sha1", w);
            return w;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String hf() {
        return "1371";
    }

    public static String kd() {
        return f.zg().ht();
    }

    public static String u() {
        return wo.p();
    }

    public static String w() {
        return "7.1.3.2";
    }

    public static String xj() {
        return "open_news";
    }

    public static String y() {
        return am.c(pz.getContext());
    }

    public static String hf(Context context) {
        if (hf != null) {
            return hf;
        }
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            hf = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), r.b.d));
        } catch (Exception unused) {
        }
        return hf;
    }

    public static int w(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            pl.xj(e);
            return 0;
        }
    }

    public static String xj(Context context) {
        try {
        } catch (Throwable th) {
            pl.hf("getApplicationName:", th);
        }
        if (xj != null) {
            return xj;
        }
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), r.b.d);
        if (applicationInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && bundle.keySet() != null) {
            for (String str : bundle.keySet()) {
                if (str != null && str.toLowerCase().contains("channel")) {
                    Object obj = bundle.get(str);
                    jSONObject.putOpt(str, obj != null ? obj.toString() : "");
                }
            }
        }
        xj = jSONObject.toString();
        return xj;
    }

    private static boolean xj(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split(":")) != null && split.length >= 20) {
            for (String str2 : split) {
                if (!e.V.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
