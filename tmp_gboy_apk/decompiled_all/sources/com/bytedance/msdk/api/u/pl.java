package com.bytedance.msdk.api.u;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl {
    private String c;
    private String d;
    private Map<String, String> f;
    private int hf;
    private int[] kd;
    private boolean u;
    private boolean w;
    private boolean xj;
    private String[] y;

    public static class xj {
        private boolean xj = false;
        private int hf = 0;
        private boolean w = true;
        private boolean u = false;
        private int[] kd = {4, 3, 5};
        private String[] y = new String[0];
        private String c = "";
        private final Map<String, String> f = new HashMap();
        private String d = "";

        public xj hf(boolean z) {
            this.w = z;
            return this;
        }

        public xj xj(boolean z) {
            this.xj = z;
            return this;
        }

        public xj hf(String str) {
            this.d = str;
            return this;
        }

        public xj xj(int i) {
            this.hf = i;
            return this;
        }

        public xj xj(int... iArr) {
            this.kd = iArr;
            return this;
        }

        public xj xj(String str) {
            this.c = str;
            return this;
        }

        public xj xj(Map<String, String> map) {
            this.f.putAll(map);
            return this;
        }

        public pl xj() {
            return new pl(this);
        }
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public Map<String, String> f() {
        return this.f;
    }

    public int hf() {
        return this.hf;
    }

    public int[] kd() {
        return this.kd;
    }

    public boolean u() {
        return this.u;
    }

    public boolean w() {
        return this.w;
    }

    public boolean xj() {
        return this.xj;
    }

    public String[] y() {
        return this.y;
    }

    private pl(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
        this.kd = xjVar.kd;
        this.y = xjVar.y;
        this.c = xjVar.c;
        this.f = xjVar.f;
        this.d = xjVar.d;
    }
}
