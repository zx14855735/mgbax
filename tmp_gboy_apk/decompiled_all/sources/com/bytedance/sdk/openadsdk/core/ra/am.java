package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am {
    private double c;
    private String hf;
    private String kd;
    private double u;
    private int w;
    private int xj;
    private double y;

    public double c() {
        return this.c;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.kd);
    }

    public String hf() {
        return this.hf;
    }

    public String kd() {
        return this.kd;
    }

    public double u() {
        return this.u;
    }

    public int w() {
        return this.w;
    }

    public int xj() {
        return this.xj;
    }

    public double y() {
        return this.y;
    }

    public void hf(int i) {
        this.w = i;
    }

    public void w(double d) {
        this.c = d;
    }

    public void xj(int i) {
        this.xj = i;
    }

    public void hf(String str) {
        this.kd = str;
    }

    public void xj(String str) {
        this.hf = str;
    }

    public void hf(double d) {
        this.y = d;
    }

    public void xj(double d) {
        this.u = d;
    }
}
