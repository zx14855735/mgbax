package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class vm {
    private boolean am;
    private boolean c;
    private int d;
    private int f;
    private int g;
    private int hf;
    private int kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10417pl;
    private int qt;
    private int tf;
    private int u;
    private boolean w;
    private boolean xj;
    private int y;
    private boolean zg;

    public vm(JSONObject jSONObject) {
        this.tf = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("reward_draw");
        if (optJSONObject != null) {
            this.hf = optJSONObject.optInt("max_draw_play_time", 10);
            this.u = optJSONObject.optInt("draw_rewarded_play_time", 30);
            this.kd = optJSONObject.optInt("skip_btn_left_style", 0);
            this.y = optJSONObject.optInt("skip_btn_right_style", 0);
            this.c = optJSONObject.optBoolean("auto_slide", false);
            this.f = optJSONObject.optInt("show_time_type", 0);
            this.d = optJSONObject.optInt("tip_time", 0);
            this.tf = optJSONObject.optInt("show_type", 0);
            this.w = optJSONObject.optBoolean("single_max_countdown", false);
            this.p = optJSONObject.optString("top_template_url");
            this.f10417pl = optJSONObject.optString("top_template_md5");
            this.g = optJSONObject.optInt("top_template_timeout");
            this.am = optJSONObject.optBoolean("can_cancel");
            this.qt = optJSONObject.optInt("init_status_time", 0);
            this.zg = optJSONObject.optBoolean("is_pause_tip_by_express", false);
        } else {
            this.hf = 10;
            this.u = 30;
        }
        if (jSONObject.optJSONObject("group_info") != null) {
            this.xj = !TextUtils.isEmpty(r6.optString("group_id"));
        }
    }

    public static boolean am(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return false;
        }
        return e.am;
    }

    public static int c(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return 10;
        }
        return e.f == 1 ? Math.min((int) Math.max(h.y(wsVar), w(wsVar)), 60) : w(wsVar);
    }

    public static int d(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return 25;
        }
        return e.d;
    }

    private static vm e(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.ao();
    }

    public static boolean f(ws wsVar) {
        vm e = e(wsVar);
        return e != null && xj(wsVar) && e.tf == 1;
    }

    public static int g(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return 0;
        }
        return e.g;
    }

    public static int hf(ws wsVar) {
        int i;
        vm e = e(wsVar);
        if (e != null && (i = e.hf) > 0) {
            return i;
        }
        return 10;
    }

    public static int kd(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return 0;
        }
        return e.y;
    }

    public static String p(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return null;
        }
        return e.p;
    }

    public static String pl(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return null;
        }
        return e.f10417pl;
    }

    public static int qt(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return 0;
        }
        return e.qt;
    }

    public static boolean tf(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return false;
        }
        return e.w;
    }

    public static int u(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return 0;
        }
        return e.kd;
    }

    public static int w(ws wsVar) {
        int i;
        vm e = e(wsVar);
        if (e != null && (i = e.u) > 0) {
            return i;
        }
        return 30;
    }

    public static boolean y(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return false;
        }
        return e.c;
    }

    public static boolean zg(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return false;
        }
        return e.zg;
    }

    public void xj(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.hf);
            jSONObject2.put("draw_rewarded_play_time", this.u);
            jSONObject2.put("skip_btn_left_style", this.kd);
            jSONObject2.put("skip_btn_right_style", this.y);
            jSONObject2.put("auto_slide", this.c);
            jSONObject2.put("show_time_type", this.f);
            jSONObject2.put("show_type", this.tf);
            jSONObject2.put("tip_time", this.d);
            jSONObject2.put("single_max_countdown", this.w);
            jSONObject2.put("top_template_url", this.p);
            jSONObject2.put("top_template_md5", this.f10417pl);
            jSONObject2.put("top_template_timeout", this.g);
            jSONObject2.put("can_cancel", this.am);
            jSONObject2.put("init_status_time", this.qt);
            jSONObject2.put("is_pause_tip_by_express", this.zg);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public static boolean xj(ws wsVar) {
        vm e = e(wsVar);
        if (e == null) {
            return false;
        }
        return e.xj;
    }
}
