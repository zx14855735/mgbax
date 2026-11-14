package com.bytedance.msdk.core.tf;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements Comparable<kd> {
    private double hf;
    private int u;
    private int w;
    private String xj;

    public kd(String str, double d, int i, int i2) {
        this.xj = str;
        this.hf = d;
        this.w = i;
        this.u = i2;
    }

    public double hf() {
        return this.hf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{mCsjRitId:");
        sb.append(this.xj);
        sb.append(",mEcpm:");
        sb.append(this.hf);
        sb.append(",mLoadSort:");
        sb.append(this.w);
        sb.append(",mShowSort:");
        return CtFAbx.AZkASS("}", this.u, sb);
    }

    public int u() {
        return this.u;
    }

    public int w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(kd kdVar) {
        if (kdVar == null) {
            return 1;
        }
        if (this.hf > kdVar.hf()) {
            return -1;
        }
        if (this.hf < kdVar.hf() || this.w > kdVar.w()) {
            return 1;
        }
        if (this.w < kdVar.w()) {
            return -1;
        }
        if (this.u > kdVar.u()) {
            return 1;
        }
        return this.u < kdVar.u() ? -1 : 0;
    }
}
