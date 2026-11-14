package com.kwad.sdk.core.videocache;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class n {
    public final long aQq;
    public final String aQr;
    public final String url;

    public n(String str, long j, String str2) {
        this.url = str;
        this.aQq = j;
        this.aQr = str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SourceInfo{url='");
        sb.append(this.url);
        sb.append("', length=");
        sb.append(this.aQq);
        sb.append(", mime='");
        return CtFAbx.B25kr6(sb, this.aQr, "'}");
    }
}
