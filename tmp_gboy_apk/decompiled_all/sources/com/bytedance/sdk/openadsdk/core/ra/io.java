package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class io {
    private xj hf;
    private int u;
    private hf w;
    private boolean xj;

    public static class xj {
        private int c;
        private String d;
        private int f;
        private int hf;
        private int kd;
        private String u;
        private String w;
        private int xj;
        private int y;

        public xj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.hf = jSONObject.optInt("displayAreaAndroid");
            this.w = jSONObject.optString("ugen_md5");
            this.u = jSONObject.optString("ugen_url");
            this.kd = jSONObject.optInt("need_backup_convert_area", 0);
            this.y = jSONObject.optInt("min_height", 0);
            this.c = jSONObject.optInt("min_width", 0);
            this.f = jSONObject.optInt("min_ratio", 0);
            this.d = jSONObject.optString("ugen_id");
            this.xj = jSONObject.optInt("render_sequence", 2);
        }

        public boolean c() {
            return !TextUtils.isEmpty(this.u);
        }

        public String hf() {
            return this.d;
        }

        public String kd() {
            return this.u;
        }

        public String u() {
            return this.w;
        }

        public int w() {
            return this.hf;
        }

        public int xj() {
            return this.xj;
        }

        public boolean y() {
            return this.kd == 1;
        }

        public boolean xj(int i, int i2) {
            int u = com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), i);
            int u2 = com.bytedance.sdk.openadsdk.core.a.r.u(com.bytedance.sdk.openadsdk.core.pz.getContext(), i2);
            int i3 = this.c;
            if (i3 != 0 && u < i3) {
                return false;
            }
            int i4 = this.y;
            if (i4 == 0 || u2 >= i4) {
                return u == 0 || u2 == 0 || ((float) u2) / ((float) u) >= ((float) this.f);
            }
            return false;
        }
    }

    public io(JSONObject jSONObject) {
        this.xj = false;
        if (jSONObject == null) {
            return;
        }
        this.xj = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject optJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (optJSONObject != null) {
            this.hf = new xj(optJSONObject.optJSONObject("components"));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("easy_playable");
        if (optJSONObject2 != null) {
            this.w = new hf(optJSONObject2.optJSONObject("components"));
        }
        this.u = jSONObject.optInt("style_category");
    }

    public static boolean hf(ws wsVar) {
        io nq;
        hf hfVar;
        return (wsVar == null || (nq = wsVar.nq()) == null || !nq.xj || (hfVar = nq.w) == null || !hfVar.xj()) ? false : true;
    }

    public static hf kd(ws wsVar) {
        io nq;
        if (wsVar == null || (nq = wsVar.nq()) == null) {
            return null;
        }
        return nq.w;
    }

    public static int u(ws wsVar) {
        if (wsVar == null) {
            return 0;
        }
        return wsVar.nq().u;
    }

    public static String w(ws wsVar) {
        io nq;
        xj xjVar;
        if (wsVar == null || (nq = wsVar.nq()) == null || (xjVar = nq.hf) == null) {
            return null;
        }
        return xjVar.hf();
    }

    public static boolean xj(ws wsVar) {
        io nq;
        xj xjVar;
        return (wsVar == null || (nq = wsVar.nq()) == null || (xjVar = nq.hf) == null || !xjVar.c()) ? false : true;
    }

    public static xj y(ws wsVar) {
        io nq;
        if (wsVar == null || (nq = wsVar.nq()) == null) {
            return null;
        }
        return nq.hf;
    }

    public static class hf {
        xj hf;
        xj xj;

        public static class xj {
            int hf;
            String xj;

            public xj(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.xj = jSONObject.optString("entry");
                this.hf = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean xj() {
                return !TextUtils.isEmpty(this.xj);
            }
        }

        public hf(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.xj = new xj(jSONObject.optJSONObject("vertical"));
            this.hf = new xj(jSONObject.optJSONObject("horizontal"));
        }

        public int hf() {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.hf;
            }
            xj xjVar2 = this.hf;
            if (xjVar2 != null) {
                return xjVar2.hf;
            }
            return 0;
        }

        public boolean xj() {
            xj xjVar = this.hf;
            if (xjVar != null && xjVar.xj()) {
                return true;
            }
            xj xjVar2 = this.xj;
            return xjVar2 != null && xjVar2.xj();
        }

        public String xj(boolean z) {
            xj xjVar;
            if (z && (xjVar = this.xj) != null && xjVar.xj()) {
                return this.xj.xj;
            }
            xj xjVar2 = this.hf;
            if (xjVar2 != null && xjVar2.xj()) {
                return this.hf.xj;
            }
            xj xjVar3 = this.xj;
            if (xjVar3 != null && xjVar3.xj()) {
                return this.xj.xj;
            }
            return "";
        }
    }

    public static boolean xj() {
        int i = com.bytedance.sdk.openadsdk.core.ai.w;
        return (i >= 6322 && i < 6400) || i >= 6406;
    }
}
