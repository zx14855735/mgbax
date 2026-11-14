package com.sigmob.sdk.base.models;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SigImage {
    private final int height;
    private final String imageUrl;
    private final int width;

    public SigImage(String str, int i, int i2) {
        this.imageUrl = str;
        this.width = i;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getWidth() {
        return this.width;
    }
}
