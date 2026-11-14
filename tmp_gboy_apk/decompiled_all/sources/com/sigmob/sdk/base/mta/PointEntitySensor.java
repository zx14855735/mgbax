package com.sigmob.sdk.base.mta;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class PointEntitySensor extends PointEnitySigmobBase {

    /* renamed from: a, reason: collision with root package name */
    private String f13186a;
    private String b;
    private String c;

    public String getMotion_after() {
        return this.b;
    }

    public String getMotion_before() {
        return this.f13186a;
    }

    public String getMotion_interval() {
        return this.c;
    }

    public void setMotion_after(String str) {
        this.b = str;
    }

    public void setMotion_before(String str) {
        this.f13186a = str;
    }

    public void setMotion_interval(String str) {
        this.c = str;
    }
}
