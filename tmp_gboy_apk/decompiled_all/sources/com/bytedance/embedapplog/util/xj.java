package com.bytedance.embedapplog.util;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private final String c;
    private final String[] hf;
    private final String kd;
    private final String u;
    private final String[] w;
    private final String xj;
    private final String y;

    /* renamed from: com.bytedance.embedapplog.util.xj$xj, reason: collision with other inner class name */
    public static class C0047xj {
        private String c;
        private String[] hf;
        private String kd;
        private String u;
        private String[] w;
        private String xj;
        private String y;

        public C0047xj hf(String[] strArr) {
            this.w = strArr;
            return this;
        }

        public C0047xj u(String str) {
            this.c = str;
            return this;
        }

        public C0047xj w(String str) {
            this.kd = str;
            return this;
        }

        public C0047xj xj(String str) {
            this.xj = str;
            return this;
        }

        public C0047xj hf(String str) {
            this.u = str;
            return this;
        }

        public C0047xj xj(String[] strArr) {
            this.hf = strArr;
            return this;
        }

        public xj xj() {
            return new xj(this);
        }
    }

    public String[] hf() {
        return this.hf;
    }

    public String u() {
        return this.kd;
    }

    public String w() {
        return this.u;
    }

    public String xj() {
        return this.xj;
    }

    private xj(C0047xj c0047xj) {
        this.xj = c0047xj.xj;
        this.hf = c0047xj.hf;
        this.w = c0047xj.w;
        this.u = c0047xj.u;
        this.kd = c0047xj.kd;
        this.y = c0047xj.y;
        this.c = c0047xj.c;
    }

    public static xj xj(int i) {
        return hf.xj(i);
    }
}
