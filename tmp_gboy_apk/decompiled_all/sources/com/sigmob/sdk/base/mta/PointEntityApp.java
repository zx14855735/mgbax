package com.sigmob.sdk.base.mta;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class PointEntityApp extends PointEntitySigmobSuper {

    /* renamed from: a, reason: collision with root package name */
    private String f13184a;
    private String b;
    private String c;
    private String d;

    public String getApp_name() {
        return this.f13184a;
    }

    public String getApp_version() {
        return this.d;
    }

    public String getPackage_name() {
        return this.b;
    }

    public String getUpdate() {
        return this.c;
    }

    public void setApp_name(String str) {
        this.f13184a = str;
    }

    public void setApp_version(String str) {
        this.d = str;
    }

    public void setPackage_name(String str) {
        this.b = str;
    }

    public void setUpdate(String str) {
        this.c = str;
    }
}
