package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    JSONArray c;
    String d;
    boolean f;
    int hf;
    boolean kd;
    private boolean p;
    int tf;
    int u;
    int w;
    String xj;
    boolean y;

    public static class xj {
        int c;
        boolean d;
        int f;
        int hf;
        JSONArray kd;
        com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj tf;
        boolean u;
        int w;
        String xj;
        boolean y;

        public xj hf(int i) {
            this.w = i;
            return this;
        }

        public xj u(int i) {
            this.f = i;
            return this;
        }

        public xj w(int i) {
            this.c = i;
            return this;
        }

        public w xj() {
            return new w(this.xj, this.hf, this.w, this.f, this.u, this.kd, this.y, this.tf, this.c, this.d);
        }

        public xj hf(boolean z) {
            this.y = z;
            return this;
        }

        public xj w(boolean z) {
            this.d = z;
            return this;
        }

        public xj xj(String str) {
            this.xj = str;
            return this;
        }

        public xj xj(int i) {
            this.hf = i;
            return this;
        }

        public xj xj(boolean z) {
            this.u = z;
            return this;
        }

        public xj xj(Set<Integer> set) {
            this.kd = new JSONArray((Collection) set);
            return this;
        }

        public xj xj(com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj xjVar) {
            this.tf = xjVar;
            return this;
        }
    }

    public int c() {
        return this.tf;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.xj);
            jSONObject.put("consume_time", this.hf);
            jSONObject.put("reduce_time", this.w);
            jSONObject.put("is_video_completed", this.kd);
            jSONObject.put("is_user_interacted", this.y);
            jSONObject.put("reward_verify_array", this.c);
            jSONObject.put("is_mute", this.f);
            jSONObject.put("play_again_string", this.d);
            jSONObject.put("carousel_type", this.tf);
            jSONObject.put("eternal_global_time", this.u);
            jSONObject.put("first_ad_is_video", this.p);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public Map<Integer, Boolean> f() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < this.c.length(); i++) {
            try {
                hashMap.put((Integer) this.c.get(i), Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public int hf() {
        return this.hf;
    }

    public boolean kd() {
        return this.f;
    }

    public boolean p() {
        return this.p;
    }

    public int tf() {
        return this.u;
    }

    public boolean u() {
        return this.kd;
    }

    public int w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public String y() {
        return this.d;
    }

    private w(String str, int i, int i2, int i3, boolean z, JSONArray jSONArray, boolean z2, com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj xjVar, int i4, boolean z3) {
        this.xj = str;
        this.hf = i;
        this.w = i2;
        this.u = i3;
        this.kd = z;
        this.c = jSONArray;
        this.f = z2;
        this.d = xjVar.f();
        this.tf = i4;
        this.p = z3;
    }

    public w(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.xj = jSONObject.optString("meta_md5");
            this.hf = jSONObject.optInt("consume_time");
            this.w = jSONObject.optInt("reduce_time");
            this.kd = jSONObject.optBoolean("is_video_completed");
            this.c = jSONObject.optJSONArray("reward_verify_array");
            this.f = jSONObject.optBoolean("is_mute");
            this.d = jSONObject.optString("play_again_string");
            this.tf = jSONObject.optInt("carousel_type");
            this.u = jSONObject.optInt("eternal_global_time");
            this.p = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception unused) {
        }
    }
}
