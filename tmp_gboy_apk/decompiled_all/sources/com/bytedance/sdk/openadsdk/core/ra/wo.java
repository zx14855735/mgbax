package com.bytedance.sdk.openadsdk.core.ra;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class wo {
    private String c;
    private int d;
    private String f;
    private boolean g;
    private String hf;
    private String kd;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10421pl;
    private int tf;
    private int u;
    private int w;
    private int xj;
    private String y;

    public wo(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("live_ad")) == null) {
            return;
        }
        this.g = true;
        xj(optJSONObject.optInt("live_show_time", 60));
        this.hf = optJSONObject.optString("live_author_nickname");
        this.w = optJSONObject.optInt("live_author_follower_count", -1);
        this.u = optJSONObject.optInt("live_watch_count", -1);
        this.kd = optJSONObject.optString("live_description");
        this.y = optJSONObject.optString("live_feed_url");
        this.c = optJSONObject.optString("live_cover_image_url");
        this.f = optJSONObject.optString("live_avatar_url");
        this.d = optJSONObject.optInt("live_avatar_width");
        this.tf = optJSONObject.optInt("live_avatar_height");
        this.p = optJSONObject.optInt("live_cover_width");
        this.f10421pl = optJSONObject.optInt("live_cover_height");
    }

    private static wo am(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.cp();
    }

    public static String c(ws wsVar) {
        wo am = am(wsVar);
        return am == null ? "" : am.y;
    }

    public static String d(ws wsVar) {
        wo am = am(wsVar);
        return am == null ? "" : am.f;
    }

    public static String f(ws wsVar) {
        wo am = am(wsVar);
        return am == null ? "" : am.c;
    }

    public static int g(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return 0;
        }
        return am.f10421pl;
    }

    public static int hf(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return 0;
        }
        return am.xj;
    }

    public static int kd(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return 0;
        }
        return am.u;
    }

    public static int p(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return 0;
        }
        return am.tf;
    }

    public static int pl(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return 0;
        }
        return am.p;
    }

    public static int tf(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return 0;
        }
        return am.d;
    }

    public static int u(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return 0;
        }
        return am.w;
    }

    public static String w(ws wsVar) {
        wo am = am(wsVar);
        return am == null ? "" : am.hf;
    }

    public static String y(ws wsVar) {
        wo am = am(wsVar);
        return am == null ? "" : am.kd;
    }

    public boolean xj() {
        return this.g;
    }

    public void xj(JSONObject jSONObject) {
        if (this.g) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.xj);
                jSONObject2.put("live_author_nickname", this.hf);
                jSONObject2.put("live_author_follower_count", this.w);
                jSONObject2.put("live_watch_count", this.u);
                jSONObject2.put("live_description", this.kd);
                jSONObject2.put("live_feed_url", this.y);
                jSONObject2.put("live_cover_image_url", this.c);
                jSONObject2.put("live_avatar_url", this.f);
                jSONObject2.put("live_cover_width", this.p);
                jSONObject2.put("live_cover_height", this.f10421pl);
                jSONObject2.put("live_avatar_width", this.d);
                jSONObject2.put("live_avatar_height", this.tf);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean xj(ws wsVar) {
        wo am = am(wsVar);
        if (am == null) {
            return false;
        }
        return am.g;
    }

    public void xj(int i) {
        if (i <= 0 || i > 300) {
            i = 60;
        }
        this.xj = i;
    }
}
