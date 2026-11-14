package com.fl.saas.videocache;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SourceInfo {
    public final long length;
    public final String mime;
    public final String url;

    public SourceInfo(String str, long j, String str2) {
        this.url = str;
        this.length = j;
        this.mime = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SourceInfo{url='");
        sb.append(this.url);
        sb.append("', length=");
        sb.append(this.length);
        sb.append(", mime='");
        return CtFAbx.B25kr6(sb, this.mime, "'}");
    }
}
