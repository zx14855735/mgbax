package com.fl.saas.base.cache;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdCacheBean {
    private long id;
    private String key;
    private double price;
    private long time;
    private String value;

    public AdCacheBean() {
    }

    public long getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public double getPrice() {
        return this.price;
    }

    public long getTime() {
        return this.time;
    }

    public String getValue() {
        return this.value;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("User{id=");
        sb.append(this.id);
        sb.append(", key='");
        sb.append(this.key);
        sb.append("', time=");
        sb.append(this.time);
        sb.append(", value='");
        return CtFAbx.B25kr6(sb, this.value, "'}");
    }

    public AdCacheBean(String str, long j, double d, String str2) {
        this.key = str;
        this.time = j;
        this.price = d;
        this.value = str2;
    }
}
