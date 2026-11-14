package com.bytedance.adsdk.ugeno.w;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    private boolean c;
    private float d;
    private float f;
    private JSONObject hf;
    private String kd;
    private JSONObject u;
    private String w;
    private JSONObject xj;
    private JSONObject y;

    public static class xj {
        private String c;
        private boolean d;
        private String f;
        private String hf;
        private LinkedList<xj> kd;
        private boolean tf;
        private JSONObject u;
        private JSONObject w;
        private String xj;
        private xj y;

        public List<xj> kd() {
            return this.kd;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("UGNode{id='");
            sb.append(this.xj);
            sb.append("', name='");
            return CtFAbx.B25kr6(sb, this.hf, "'}");
        }

        public JSONObject y() {
            return this.u;
        }

        public JSONObject u() {
            return this.w;
        }

        public String hf() {
            return this.c;
        }

        public String w() {
            return this.hf;
        }

        public void hf(boolean z) {
            this.tf = z;
        }

        public String xj() {
            return this.xj;
        }

        public void hf(xj xjVar) {
            if (this.kd == null) {
                this.kd = new LinkedList<>();
            }
            this.kd.addLast(xjVar);
        }

        public void xj(String str) {
            this.hf = str;
        }

        public void xj(boolean z) {
            this.d = z;
        }

        public void xj(xj xjVar) {
            if (this.kd == null) {
                this.kd = new LinkedList<>();
            }
            this.kd.add(xjVar);
        }

        public void xj(int i, xj xjVar) {
            if (this.kd == null) {
                this.kd = new LinkedList<>();
            }
            this.kd.add(i, xjVar);
        }
    }

    public d(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    private xj kd() {
        if (!u()) {
            return xj(this.xj, (xj) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put(MediaFormat.KEY_WIDTH, "match_parent");
            jSONObject.put(MediaFormat.KEY_HEIGHT, "wrap_content");
            float f = this.f;
            if (f > 0.0f) {
                jSONObject.put(MediaFormat.KEY_WIDTH, f);
            }
            float f2 = this.d;
            if (f2 > 0.0f) {
                jSONObject.put(MediaFormat.KEY_HEIGHT, f2);
            }
            String optString = this.u.optString("xSize");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.optInt(MediaFormat.KEY_WIDTH) > 0) {
                    jSONObject.put(MediaFormat.KEY_WIDTH, jSONObject2.optInt(MediaFormat.KEY_WIDTH));
                }
                if (jSONObject2.optInt(MediaFormat.KEY_HEIGHT) > 0) {
                    jSONObject.put(MediaFormat.KEY_HEIGHT, jSONObject2.optInt(MediaFormat.KEY_HEIGHT));
                }
            }
        } catch (JSONException unused) {
        }
        xj xjVar = new xj();
        xjVar.hf = "View";
        xjVar.xj = "virtualNode";
        xjVar.w = jSONObject;
        xjVar.y = null;
        xjVar.c = this.w;
        xjVar.f = this.kd;
        xjVar.xj(xj(this.xj, xjVar));
        return xjVar;
    }

    public String hf() {
        return this.w;
    }

    public boolean u() {
        return this.c;
    }

    public List<xj> w() {
        if (this.hf == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.hf.keys();
        while (keys.hasNext()) {
            xj xj2 = xj(this.hf.optJSONObject(keys.next()), (xj) null);
            if (xj2 != null) {
                arrayList.add(xj2);
            }
        }
        return arrayList;
    }

    public xj xj() {
        return kd();
    }

    public d(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.xj = jSONObject.optJSONObject("body");
            } else {
                this.xj = jSONObject.optJSONObject("main_template");
            }
            this.hf = jSONObject.optJSONObject("sub_templates");
            JSONObject optJSONObject = jSONObject.has("meta") ? jSONObject.optJSONObject("meta") : jSONObject.optJSONObject("template_info");
            if (optJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.c = true;
                    String optString = optJSONObject.optString("version");
                    this.w = optString;
                    if (TextUtils.isEmpty(optString)) {
                        this.w = "3.0";
                    }
                } else {
                    this.w = optJSONObject.optString(PluginConstants.KEY_SDK_VERSION);
                }
                if (optJSONObject.has("adType")) {
                    this.kd = optJSONObject.optString("adType");
                }
            } else if (jSONObject.has("body")) {
                this.w = "3.0";
                this.c = true;
            }
            this.u = jSONObject2;
            this.y = jSONObject3;
        }
    }

    public static boolean u(xj xjVar) {
        return (xjVar == null || xjVar.w == null) ? false : true;
    }

    public boolean hf(xj xjVar) {
        JSONObject u;
        if (xjVar == null || (u = xjVar.u()) == null) {
            return false;
        }
        return TextUtils.equals(u.optString(MediaFormat.KEY_HEIGHT), "match_parent");
    }

    public void xj(float f, float f2) {
        this.f = f;
        this.d = f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.adsdk.ugeno.w.d.xj xj(org.json.JSONObject r12, com.bytedance.adsdk.ugeno.w.d.xj r13) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.w.d.xj(org.json.JSONObject, com.bytedance.adsdk.ugeno.w.d$xj):com.bytedance.adsdk.ugeno.w.d$xj");
    }

    public boolean w(xj xjVar) {
        JSONObject u;
        if (xjVar == null || (u = xjVar.u()) == null) {
            return false;
        }
        return TextUtils.equals(u.optString("position"), "absolute");
    }

    public boolean xj(xj xjVar) {
        JSONObject u;
        if (xjVar == null || (u = xjVar.u()) == null) {
            return false;
        }
        return TextUtils.equals(u.optString(MediaFormat.KEY_WIDTH), "match_parent");
    }

    private void xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.y == null || jSONObject2 == null) {
            return;
        }
        try {
            String optString = this.y.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(optString);
            JSONObject optJSONObject = jSONObject2.optJSONObject("targetProps");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = optJSONObject.opt(next);
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (opt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.y.hf.xj(jSONObject3.optJSONArray("events"), (JSONArray) opt);
                        }
                    } else {
                        jSONObject3.put(next, opt);
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("children");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", optJSONArray);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }
}
