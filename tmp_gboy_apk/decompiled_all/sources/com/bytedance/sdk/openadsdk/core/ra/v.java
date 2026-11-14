package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class v {
    private boolean c;
    private String d;
    private String f;
    private int hf;
    private int kd;
    private int tf;
    private int u;
    private int w;
    private String xj;
    private int y;

    public v(JSONObject jSONObject) {
        this.hf = 0;
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("reward_browse_type", 0);
        this.hf = optInt;
        if (optInt < 0 || optInt > 3) {
            this.hf = 0;
        }
        if (this.hf == 2) {
            this.hf = 3;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
        if (optJSONObject != null) {
            this.xj = optJSONObject.optString("direct_landing_url");
            this.w = optJSONObject.optInt("display_duration", 0);
            this.u = optJSONObject.optInt("close_time", 0);
            this.kd = optJSONObject.optInt("page_type");
            this.y = optJSONObject.optInt("show_type");
            this.c = optJSONObject.optBoolean("is_landing_with_sound", false);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward_browse_banner");
            if (optJSONObject2 != null) {
                this.f = optJSONObject2.optString("ugen_url");
                this.d = optJSONObject2.optString("ugen_md5");
            }
            this.tf = optJSONObject.optInt("close_btn_position");
        }
    }

    public static boolean am(ws wsVar) {
        v zg = zg(wsVar);
        return zg != null && zg.tf == 2;
    }

    public static boolean c(ws wsVar) {
        v zg = zg(wsVar);
        if (zg == null) {
            return false;
        }
        return zg.c;
    }

    public static int d(ws wsVar) {
        int i;
        v zg = zg(wsVar);
        if (zg != null && (i = zg.w) >= 0) {
            return i;
        }
        return 0;
    }

    public static int f(ws wsVar) {
        v zg = zg(wsVar);
        if (zg == null) {
            return 0;
        }
        return zg.hf;
    }

    public static boolean g(ws wsVar) {
        v zg = zg(wsVar);
        return zg != null && zg.tf == 1;
    }

    public static boolean hf(ws wsVar) {
        if (xj(wsVar)) {
            return c(wsVar);
        }
        return false;
    }

    public static boolean kd(ws wsVar) {
        v zg = zg(wsVar);
        return zg != null && zg.y == 3;
    }

    public static boolean p(ws wsVar) {
        return zg(wsVar) != null && f(wsVar) == 3 && xj(wsVar);
    }

    public static com.bytedance.sdk.openadsdk.core.ugeno.y.xj pl(ws wsVar) {
        v zg = zg(wsVar);
        if (zg == null || TextUtils.isEmpty(zg.f)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar = new com.bytedance.sdk.openadsdk.core.ugeno.y.xj();
        xjVar.w(zg.f);
        xjVar.hf(zg.d);
        xjVar.xj(zg.f);
        return xjVar;
    }

    public static int qt(ws wsVar) {
        v zg = zg(wsVar);
        if (zg == null) {
            return 0;
        }
        return zg.tf;
    }

    public static int tf(ws wsVar) {
        int i;
        v zg = zg(wsVar);
        if (zg != null && (i = zg.u) >= 0) {
            return i;
        }
        return 0;
    }

    public static boolean u(ws wsVar) {
        v zg = zg(wsVar);
        return zg != null && xj(wsVar) && zg.hf == 1 && zg.kd == 2;
    }

    public static boolean w(ws wsVar) {
        v zg = zg(wsVar);
        return zg != null && zg.hf == 1 && zg.kd == 1;
    }

    public static String y(ws wsVar) {
        v zg = zg(wsVar);
        return zg == null ? "" : zg.xj;
    }

    private static v zg(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.tu();
    }

    public void xj(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.hf);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.xj);
            jSONObject2.put("display_duration", this.w);
            jSONObject2.put("close_time", this.u);
            jSONObject2.put("page_type", this.kd);
            jSONObject2.put("show_type", this.y);
            jSONObject2.put("close_btn_position", this.tf);
            jSONObject2.put("is_landing_with_sound", this.c);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.f);
            jSONObject3.put("ugen_md5", this.d);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
    }

    public static boolean xj(ws wsVar) {
        v zg = zg(wsVar);
        return (zg == null || f(wsVar) == 0 || TextUtils.isEmpty(zg.xj)) ? false : true;
    }
}
