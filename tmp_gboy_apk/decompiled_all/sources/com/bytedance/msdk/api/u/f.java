package com.bytedance.msdk.api.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private String hf;
    private boolean u;
    private boolean w;
    private boolean xj;

    public static class xj {
        private boolean xj = false;
        private String hf = null;
        private boolean w = false;
        private boolean u = false;

        public xj hf(boolean z) {
            this.w = z;
            return this;
        }

        public xj w(boolean z) {
            this.u = z;
            return this;
        }

        public xj xj(boolean z) {
            this.xj = z;
            return this;
        }

        public xj xj(String str) {
            this.hf = str;
            return this;
        }

        public f xj() {
            return new f(this);
        }
    }

    public boolean hf() {
        return this.xj;
    }

    public boolean u() {
        return this.u;
    }

    public boolean w() {
        return this.w;
    }

    public String xj() {
        return this.hf;
    }

    private f(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
    }
}
