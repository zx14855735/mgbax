package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class dc {
    private int hf;
    private int kd;
    private int u;
    private String w;
    private int xj;
    private boolean y;

    public dc(JSONObject jSONObject) {
        this.y = false;
        JSONObject optJSONObject = jSONObject.optJSONObject("reward_live");
        if (optJSONObject != null) {
            this.y = true;
            hf(optJSONObject.optInt("reward_live_type", 1));
            w(optJSONObject.optInt("reward_live_style", 1));
            xj(optJSONObject.optString("reward_live_text"));
            xj(optJSONObject.optInt("reward_start_time", 5));
            u(optJSONObject.optInt("reward_close_time", 10));
        }
    }

    public static int c(ws wsVar) {
        dc d = d(wsVar);
        if (d == null) {
            return 5;
        }
        return Math.max(d.u, 0);
    }

    private static dc d(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.ob();
    }

    public static int f(ws wsVar) {
        dc d = d(wsVar);
        if (d == null) {
            return 10;
        }
        return Math.max(d.kd, 3);
    }

    public static int hf(ws wsVar) {
        dc d = d(wsVar);
        if (d == null) {
            return 1;
        }
        return d.xj;
    }

    public static int kd(ws wsVar) {
        dc d = d(wsVar);
        if (d == null) {
            return 1;
        }
        return d.hf;
    }

    public static boolean u(ws wsVar) {
        int i;
        dc d = d(wsVar);
        return d != null && d.y && com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(wsVar) && ((i = d.xj) == 3 || i == 4);
    }

    public static boolean w(ws wsVar) {
        dc d = d(wsVar);
        return d == null || !d.y || d.xj == 1;
    }

    public static String y(ws wsVar) {
        dc d = d(wsVar);
        return d == null ? "去抖音观看直播\n可提前5s获得奖励哦" : d.w;
    }

    public void xj(JSONObject jSONObject) {
        if (this.y) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.xj);
                jSONObject2.put("reward_live_style", this.hf);
                jSONObject2.put("reward_live_text", this.w);
                jSONObject2.put("reward_start_time", this.u);
                jSONObject2.put("reward_close_time", this.kd);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    private void hf(int i) {
        if (i != 2 && i != 3 && i != 4 && i != 1) {
            i = 1;
        }
        this.xj = i;
    }

    private void u(int i) {
        if (i <= 3) {
            i = 3;
        }
        this.kd = i;
    }

    private void w(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.hf = i;
    }

    public static boolean xj(ws wsVar) {
        dc d = d(wsVar);
        if (d == null) {
            return false;
        }
        return d.y;
    }

    private void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.hf == 3) {
                str = "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦";
            } else {
                str = "去抖音观看直播\n可提前5s获得奖励哦";
            }
        }
        this.w = str;
    }

    public void xj(int i) {
        this.u = i;
    }
}
