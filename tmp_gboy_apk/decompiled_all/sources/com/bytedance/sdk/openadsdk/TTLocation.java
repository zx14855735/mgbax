package com.bytedance.sdk.openadsdk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTLocation implements LocationProvider {
    private double hf;
    private double xj;

    public TTLocation(double d, double d2) {
        this.xj = d;
        this.hf = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.hf;
    }

    public void setLatitude(double d) {
        this.xj = d;
    }

    public void setLongitude(double d) {
        this.hf = d;
    }
}
