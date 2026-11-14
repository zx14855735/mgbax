package com.ss.android.downloadlib.addownload.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private int hf;
    private String w;
    private int xj;

    public c(int i) {
        this(i, 0, null);
    }

    public int getType() {
        return this.xj;
    }

    public String hf() {
        return this.w;
    }

    public int xj() {
        return this.hf;
    }

    public c(int i, int i2) {
        this(i, i2, null);
    }

    public c(int i, String str) {
        this(i, 0, str);
    }

    public c(int i, int i2, String str) {
        this.xj = i;
        this.hf = i2;
        this.w = str;
    }
}
