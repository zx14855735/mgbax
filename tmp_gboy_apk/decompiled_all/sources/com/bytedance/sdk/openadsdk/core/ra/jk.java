package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class jk {
    private int am;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int hf;
    private String jk;
    private int kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10410pl;
    private String pz;
    private int qt;
    private int tf;
    private int u;
    private int v;
    private int w;
    private int xj;
    private int y;
    private int yo;
    private int zg;

    public jk(JSONObject jSONObject) {
        this.xj = 0;
        this.hf = 1;
        this.w = 1;
        this.u = 1;
        this.kd = 1;
        this.y = 1;
        this.c = 0;
        this.f = 0;
        this.d = 0;
        this.tf = 300;
        this.p = -1;
        this.f10410pl = 1;
        this.g = 1;
        this.am = 31457280;
        this.qt = 0;
        this.zg = 0;
        this.e = 0;
        this.yo = 0;
        this.v = 0;
        if (jSONObject == null) {
            return;
        }
        this.y = jSONObject.optInt("auto_open", 1);
        this.c = jSONObject.optInt("download_mode", 0);
        this.f = jSONObject.optInt("auto_control", 0);
        this.d = jSONObject.optInt("auto_control_choose", 0);
        this.tf = jSONObject.optInt("auto_control_time", 300);
        this.p = jSONObject.optInt("download_type", -1);
        this.f10410pl = jSONObject.optInt("if_suspend_download", 1);
        this.xj = jSONObject.optInt("if_send_click", 0);
        this.hf = jSONObject.optInt("dl_popup", 1);
        this.w = jSONObject.optInt("market_popup", 1);
        this.u = jSONObject.optInt("if_pop_lp", 1);
        this.kd = jSONObject.optInt("pop_up_style_id", 1);
        this.g = jSONObject.optInt("dl_network", 1);
        this.am = jSONObject.optInt("dl_size", 31457280);
        this.qt = jSONObject.optInt("if_toast_market", 0);
        this.zg = jSONObject.optInt("enable_download_opt", 0);
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            this.e = 0;
        } else {
            this.e = jSONObject.optInt("dl_suspend_popup", 0);
        }
        this.yo = jSONObject.optInt("is_use_obm_convert", 0);
        this.v = jSONObject.optInt("enable_notification", 0);
        this.jk = jSONObject.optString("ugen_url");
        String optString = jSONObject.optString("ugen_md5");
        this.pz = optString;
        com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(this.jk, optString, (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
    }

    public static int am(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 1;
        }
        return ht.u;
    }

    public static boolean c(ws wsVar) {
        jk ht = ht(wsVar);
        return ht != null && ht.f == 1;
    }

    public static int d(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 300;
        }
        return ht.tf;
    }

    public static boolean e(ws wsVar) {
        jk ht = ht(wsVar);
        return ht != null && ht.qt == 1;
    }

    public static boolean f(ws wsVar) {
        jk ht = ht(wsVar);
        return ht != null && ht.d == 1;
    }

    public static int g(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 1;
        }
        return ht.w;
    }

    public static int hf(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 0;
        }
        return ht.u();
    }

    private static jk ht(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.kc();
    }

    public static String jk(ws wsVar) {
        jk ht = ht(wsVar);
        return ht == null ? "" : ht.jk;
    }

    public static int kd(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 0;
        }
        return ht.c;
    }

    public static int p(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 0;
        }
        return ht.xj;
    }

    public static int pl(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 1;
        }
        return ht.hf;
    }

    public static String pz(ws wsVar) {
        jk ht = ht(wsVar);
        return ht == null ? "" : ht.pz;
    }

    public static int qt(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 1;
        }
        return ht.g;
    }

    public static boolean tf(ws wsVar) {
        jk ht = ht(wsVar);
        return ht != null && ht.f10410pl == 1;
    }

    public static int u(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 1;
        }
        return ht.y;
    }

    public static int v(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 0;
        }
        return ht.e;
    }

    public static String w(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return "close_obm";
        }
        int u = ht.u();
        String lp = wsVar.lp();
        if (u == 1 && lp != null) {
            return "open";
        }
        return "close_" + u + "_" + lp;
    }

    public static boolean xj(ws wsVar) {
        jk ht = ht(wsVar);
        return ht != null && ht.zg == 1;
    }

    public static int y(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return -1;
        }
        return ht.p;
    }

    public static int yo(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 1;
        }
        return ht.kd;
    }

    public static int zg(ws wsVar) {
        jk ht = ht(wsVar);
        if (ht == null) {
            return 31457280;
        }
        return ht.am * 1048576;
    }

    public int hf() {
        return this.c;
    }

    public int kd() {
        return this.e;
    }

    public int u() {
        return this.yo;
    }

    public int xj() {
        return this.hf;
    }

    public void xj(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.y);
            jSONObject2.put("download_mode", this.c);
            jSONObject2.put("download_type", this.p);
            jSONObject2.put("auto_control", this.f);
            jSONObject2.put("auto_control_choose", this.d);
            jSONObject2.put("auto_control_time", this.tf);
            jSONObject2.put("if_suspend_download", this.f10410pl);
            jSONObject2.put("if_send_click", this.xj);
            jSONObject2.put("dl_popup", this.hf);
            jSONObject2.put("market_popup", this.w);
            jSONObject2.put("if_pop_lp", this.u);
            jSONObject2.put("pop_up_style_id", this.kd);
            jSONObject2.put("dl_network", this.g);
            jSONObject2.put("dl_size", this.am);
            jSONObject2.put("if_toast_market", this.qt);
            jSONObject2.put("enable_download_opt", this.zg);
            jSONObject2.put("dl_suspend_popup", this.e);
            jSONObject2.put("is_use_obm_convert", this.yo);
            jSONObject2.put("ugen_url", this.jk);
            jSONObject2.put("ugen_md5", this.pz);
            jSONObject2.put("enable_notification", this.v);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    public boolean w() {
        return this.f10410pl == 1;
    }
}
