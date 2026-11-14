package com.ss.android.download.api.model;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private String hf;
    private String xj;

    public static class xj {
        private String hf;
        private String xj;

        public xj hf(String str) {
            this.hf = str;
            return this;
        }

        public xj xj(String str) {
            this.xj = str;
            return this;
        }

        public u xj() {
            return new u(this);
        }
    }

    public u(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
    }

    public String xj() {
        return this.xj;
    }
}
