package com.bytedance.sdk.openadsdk.qt;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.kd;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.jk;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.kuaishou.weapon.p0.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static String xj;

    public static void hf(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("imei", tf.f());
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    private static String kd() {
        if (TextUtils.isEmpty(xj)) {
            String f = tf.f();
            if (!TextUtils.isEmpty(f)) {
                xj = kd.hf(f);
            }
        }
        return xj;
    }

    public static void u(Context context, JSONObject jSONObject) {
        try {
            JSONArray xj2 = jk.xj(context);
            if (xj2 != null) {
                jSONObject.put("app_list", xj2);
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public static void w(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("udid", tf.f());
            jSONObject.put("mc", tf.pl());
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public static void xj(Context context, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.u.xj.w zg = tf.zg();
            float f = 0.0f;
            float latitude = zg == null ? 0.0f : zg.getLatitude();
            if (zg != null) {
                f = zg.getLongitude();
            }
            jSONObject.put("latitude", latitude);
            jSONObject.put("longitude", f);
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public static void hf() {
        tf.zg();
    }

    public static String u() {
        return "";
    }

    public static void w() {
        com.bytedance.sdk.openadsdk.core.j.w.xj().hf();
    }

    public static void xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar, List<String> list) {
        if (uVar.xj()) {
            list.add(g.h);
            list.add(g.g);
        }
    }

    public static void xj(JSONObject jSONObject, int i) {
        if (tf.zg() != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r5.getLatitude());
                jSONObject2.put("longitude", r5.getLongitude());
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static String xj() {
        if (f.zg().e().u()) {
            return tf.d();
        }
        return null;
    }

    public static boolean xj(String str) {
        return jk.xj(str);
    }

    public static void xj(Context context) {
        if ((pz.hf().ct() & 8) != 0) {
            return;
        }
        xj.xj(context);
    }
}
