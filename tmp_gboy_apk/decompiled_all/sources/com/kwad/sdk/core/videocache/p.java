package com.kwad.sdk.core.videocache;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class p implements m {
    protected volatile String aQr;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String Mn();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UrlSource{url='");
        sb.append(this.url);
        sb.append("', length=");
        sb.append(this.length);
        sb.append(", mime='");
        return CtFAbx.B25kr6(sb, this.aQr, "'}");
    }
}
