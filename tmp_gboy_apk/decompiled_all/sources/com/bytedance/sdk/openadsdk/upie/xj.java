package com.bytedance.sdk.openadsdk.upie;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private JSONObject c;
    private String hf;
    private int kd;
    private int u;
    private String w;
    private String xj;
    private long y;

    /* renamed from: com.bytedance.sdk.openadsdk.upie.xj$xj, reason: collision with other inner class name */
    public static class C0208xj {
        private JSONObject c;
        private String hf;
        private int kd;
        private int u;
        private String w;
        private String xj;
        private long y;

        public C0208xj hf(String str) {
            this.hf = str;
            return this;
        }

        public C0208xj w(String str) {
            this.w = str;
            return this;
        }

        public C0208xj xj(String str) {
            this.xj = str;
            return this;
        }

        public C0208xj hf(int i) {
            this.kd = i;
            return this;
        }

        public C0208xj xj(int i) {
            this.u = i;
            return this;
        }

        public C0208xj xj(long j) {
            this.y = j;
            return this;
        }

        public C0208xj xj(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public xj xj() {
            xj xjVar = new xj();
            xjVar.xj = this.xj;
            xjVar.hf = this.hf;
            xjVar.w = this.w;
            xjVar.u = this.u;
            xjVar.kd = this.kd;
            xjVar.y = this.y;
            xjVar.c = this.c;
            return xjVar;
        }
    }

    public JSONObject c() {
        return this.c;
    }

    public int kd() {
        return this.kd;
    }

    public int u() {
        return this.u;
    }

    public long y() {
        return this.y;
    }

    public String w() {
        return this.w;
    }

    public String hf() {
        return this.hf;
    }

    public String xj() {
        return this.xj;
    }
}
