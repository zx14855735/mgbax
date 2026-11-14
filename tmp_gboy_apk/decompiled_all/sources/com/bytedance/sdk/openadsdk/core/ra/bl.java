package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class bl {
    private int c;
    private int hf;
    private String kd;
    private String u;
    private int w;
    private boolean xj;
    private boolean y;

    public bl(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("splash_card")) == null) {
            return;
        }
        this.y = true;
        this.xj = optJSONObject.optBoolean("click_on_close", false);
        this.hf = optJSONObject.optInt("card_stay_count_down", 5);
        this.w = optJSONObject.optInt("card_click_area", 2);
        this.kd = optJSONObject.optString("card_text", "详情页或第三方应用");
        int optInt = optJSONObject.optInt("splash_card_style_id", 0);
        this.c = optInt;
        if (optInt == 1) {
            this.u = optJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
        } else {
            this.u = optJSONObject.optString("card_top_text", "点击跳转");
        }
    }

    public static boolean c(ws wsVar) {
        bl tf = tf(wsVar);
        return tf == null || tf.w == 1;
    }

    public static boolean d(ws wsVar) {
        if (wsVar == null || wsVar.uf() == null || !wsVar.uf().kd() || wsVar.lx() == null || wsVar.lx().isEmpty() || !wsVar.lx().get(0).kd() || TextUtils.isEmpty(wsVar.kr())) {
            return false;
        }
        if (TextUtils.isEmpty(wsVar.ci())) {
            return (wsVar.vh() == null || TextUtils.isEmpty(wsVar.vh().w())) ? false : true;
        }
        return true;
    }

    public static boolean f(ws wsVar) {
        bl tf = tf(wsVar);
        if (tf == null) {
            return true;
        }
        return tf.xj;
    }

    public static void hf(ws wsVar) {
        bl tf = tf(wsVar);
        if (tf == null || wsVar.rq() || wsVar.rs() == 2 || !tf.y || hf() >= com.bytedance.sdk.openadsdk.core.pz.hf().hx()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.am.u.w(wsVar, "splash_ad", "if_splash_card");
        if (d(wsVar)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.am.u.w(wsVar, "splash_ad", "card_show_fail");
    }

    public static int kd(ws wsVar) {
        bl tf = tf(wsVar);
        if (tf == null) {
            return 0;
        }
        return tf.c;
    }

    private static bl tf(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.s();
    }

    public static String u(ws wsVar) {
        bl tf = tf(wsVar);
        return tf == null ? "点击跳转" : kd(wsVar) == 1 ? TextUtils.isEmpty(tf.u) ? "摇一摇或点击了解更多" : tf.u : TextUtils.isEmpty(tf.u) ? "点击跳转" : tf.u;
    }

    public static String w(ws wsVar) {
        bl tf = tf(wsVar);
        return (tf == null || TextUtils.isEmpty(tf.kd)) ? "详情页或第三方应用" : tf.kd;
    }

    public static int y(ws wsVar) {
        int i;
        bl tf = tf(wsVar);
        if (tf != null && (i = tf.hf) > 0 && i <= 5) {
            return i;
        }
        return 5;
    }

    public void xj(JSONObject jSONObject) {
        try {
            if (this.y) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.xj);
                jSONObject2.put("card_stay_count_down", this.hf);
                jSONObject2.put("card_click_area", this.w);
                jSONObject2.put("card_text", this.kd);
                jSONObject2.put("card_top_text", this.u);
                jSONObject2.put("splash_card_style_id", this.c);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static int hf() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.a.j.xj(null);
        int i2 = xj.get("splash_card_show_day", -1);
        int i3 = xj.get("splash_card_show_count", 0);
        if (i2 == i) {
            return i3;
        }
        return 0;
    }

    public static boolean xj(ws wsVar) {
        bl tf = tf(wsVar);
        if (tf != null && !wsVar.rq() && wsVar.rs() != 2 && tf.y && hf() < com.bytedance.sdk.openadsdk.core.pz.hf().hx() && d(wsVar)) {
            return tf.y;
        }
        return false;
    }

    public static void xj() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.a.j.xj(null);
        int i2 = xj.get("splash_card_show_day", -1) == i ? xj.get("splash_card_show_count", 0) : 0;
        xj.put("splash_card_show_day", i);
        xj.put("splash_card_show_count", i2 + 1);
    }
}
