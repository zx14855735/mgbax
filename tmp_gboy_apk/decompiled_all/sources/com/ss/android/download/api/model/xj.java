package com.ss.android.download.api.model;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    public String hf;
    public String kd;
    public String u;
    public String w;
    public String xj;

    /* renamed from: com.ss.android.download.api.model.xj$xj, reason: collision with other inner class name */
    public static class C0465xj {
        private String hf;
        private String kd;
        private String u;
        private String w;
        private String xj;

        public C0465xj hf(String str) {
            this.hf = str;
            return this;
        }

        public C0465xj u(String str) {
            this.kd = str;
            return this;
        }

        public C0465xj w(String str) {
            this.u = str;
            return this;
        }

        public C0465xj xj(String str) {
            this.xj = str;
            return this;
        }

        public xj xj() {
            return new xj(this);
        }
    }

    public xj(C0465xj c0465xj) {
        this.hf = "";
        this.xj = c0465xj.xj;
        this.hf = c0465xj.hf;
        this.w = c0465xj.w;
        this.u = c0465xj.u;
        this.kd = c0465xj.kd;
    }
}
