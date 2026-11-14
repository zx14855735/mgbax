package com.bytedance.msdk.core.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private double hf;
    private String kd;
    private String p;
    private String tf;
    private double u;
    private double w;
    private double xj;
    private int y;
    private int c = 0;
    private int f = 0;
    private int d = 0;

    public xj(double d, double d2, double d3, double d4, int i, String str) {
        this.xj = d;
        this.hf = d2;
        this.w = d3;
        this.u = d4;
        this.kd = str;
        this.y = i;
    }

    private boolean kd() {
        return xj(this.hf, this.u);
    }

    private boolean u() {
        return xj(this.xj, this.w);
    }

    public double hf() {
        return this.xj;
    }

    public String toString() {
        return "adnName = " + this.tf + " adnRit = " + this.p + ", send = " + this.c + ", fill = " + this.f + ", show = " + this.d + " localSsr = " + this.xj + ", serviceSsr = " + this.w + ", localSrr = " + this.hf + ", serviceSrr = " + this.u + ", opt = " + this.kd + ", condition = " + this.y + ", compareBehaviorSsr = " + u() + ", compareBehaviorSrr = " + kd() + ", checkBehaviorRule = " + xj();
    }

    public double w() {
        return this.hf;
    }

    public boolean xj() {
        return u();
    }

    private boolean xj(double d, double d2) {
        String str = this.kd;
        str.getClass();
        switch (str) {
            case "1":
                if (d > d2) {
                }
                break;
            case "2":
                if (d < d2) {
                }
                break;
            case "3":
                if (d >= d2) {
                }
                break;
            case "4":
                if (d <= d2) {
                }
                break;
            case "5":
                if (d == d2) {
                }
                break;
        }
        return true;
    }

    public void hf(int i) {
        this.f = i;
    }

    public void w(int i) {
        this.d = i;
    }

    public void hf(String str) {
        this.p = str;
    }

    public void xj(int i) {
        this.c = i;
    }

    public void xj(String str) {
        this.tf = str;
    }
}
