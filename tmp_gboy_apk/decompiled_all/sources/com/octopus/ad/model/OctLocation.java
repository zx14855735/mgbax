package com.octopus.ad.model;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctLocation {

    /* renamed from: a, reason: collision with root package name */
    private double f12604a;
    private double b;
    private int c;
    private long d;

    public OctLocation() {
    }

    public double getLatitude() {
        return this.b;
    }

    public double getLongitude() {
        return this.f12604a;
    }

    public long getTime() {
        return this.d;
    }

    public int getType() {
        return this.c;
    }

    public void setLatitude(double d) {
        this.b = d;
    }

    public void setLongitude(double d) {
        this.f12604a = d;
    }

    public void setTime(long j) {
        this.d = j;
    }

    public void setType(int i) {
        this.c = i;
    }

    public OctLocation(double d, double d2, int i, long j) {
        this.f12604a = d;
        this.b = d2;
        this.c = i;
        this.d = j;
    }
}
