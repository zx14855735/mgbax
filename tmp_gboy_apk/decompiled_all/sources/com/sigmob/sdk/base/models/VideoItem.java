package com.sigmob.sdk.base.models;

import J3FDQU.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class VideoItem {
    public final int height;
    public final String url;
    public final int width;

    public VideoItem(String str, int i, int i2) {
        this.url = str;
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\"video\":{\"url\"=\"");
        sb.append(this.url);
        sb.append("\", \"width\"=");
        sb.append(this.width);
        sb.append(", \"height\"=");
        return A2egSU.B2KMhB(sb, this.height, '}');
    }
}
