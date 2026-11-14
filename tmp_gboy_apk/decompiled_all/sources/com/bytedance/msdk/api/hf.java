package com.bytedance.msdk.api;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private String hf;
    private int kd;
    private String u;
    private String w;
    private String xj;
    private String y;

    public String hf() {
        return this.xj;
    }

    public int kd() {
        return this.kd;
    }

    public String toString() {
        return "{mediationRit='" + this.xj + "', adnName='" + this.hf + "', customAdnName='" + this.w + "', adType='" + this.u + "', errCode=" + this.kd + ", errMsg=" + this.y + '}';
    }

    public String u() {
        return this.w;
    }

    public String w() {
        return this.hf;
    }

    public String xj() {
        return this.u;
    }

    public String y() {
        return this.y;
    }

    public hf hf(String str) {
        this.xj = str;
        return this;
    }

    public hf kd(String str) {
        this.y = str;
        return this;
    }

    public hf u(String str) {
        this.w = str;
        return this;
    }

    public hf w(String str) {
        this.hf = str;
        return this;
    }

    public hf xj(String str) {
        this.u = str;
        return this;
    }

    public hf xj(int i) {
        this.kd = i;
        return this;
    }
}
