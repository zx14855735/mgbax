package com.czhj.sdk.common.mta;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class PointEntityBase extends PointEntitySuper {

    /* renamed from: a, reason: collision with root package name */
    private String f10562a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public String getAd_scene() {
        return this.f;
    }

    public String getAdtype() {
        return this.f10562a;
    }

    public String getLoad_id() {
        return this.c;
    }

    public String getPlacement_id() {
        return this.b;
    }

    public String getPlatform() {
        return this.d;
    }

    public String getScene_desc() {
        return this.g;
    }

    public String getScene_id() {
        return this.h;
    }

    public String getVtime() {
        return this.e;
    }

    public void setAd_scene(String str) {
        this.f = str;
    }

    public void setAdtype(String str) {
        this.f10562a = str;
    }

    public void setLoad_id(String str) {
        this.c = str;
    }

    public void setPlacement_id(String str) {
        this.b = str;
    }

    public void setPlatform(String str) {
        this.d = str;
    }

    public void setScene_desc(String str) {
        this.g = str;
    }

    public void setScene_id(String str) {
        this.h = str;
    }

    public void setVtime(String str) {
        this.e = str;
    }
}
