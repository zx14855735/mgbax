package com.octopus.ad.model;

import J3FDQU.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ShakeValue {

    /* renamed from: a, reason: collision with root package name */
    private double f12605a;
    private double b;
    private int c;

    public ShakeValue() {
    }

    public double getAcceleration() {
        return this.f12605a;
    }

    public double getAngle() {
        return this.b;
    }

    public int getTime() {
        return this.c;
    }

    public void setAcceleration(double d) {
        this.f12605a = d;
    }

    public void setAngle(double d) {
        this.b = d;
    }

    public void setTime(int i) {
        this.c = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ShakeValue{acceleration=");
        sb.append(this.f12605a);
        sb.append(", angle=");
        sb.append(this.b);
        sb.append(", time=");
        return A2egSU.B2KMhB(sb, this.c, '}');
    }

    public ShakeValue(double d, double d2, int i) {
        this.f12605a = d;
        this.b = d2;
        this.c = i;
    }
}
