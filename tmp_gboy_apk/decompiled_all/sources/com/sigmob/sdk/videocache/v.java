package com.sigmob.sdk.videocache;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f13745a;
    public final long b;
    public final String c;

    public v(String str, long j, String str2) {
        this.f13745a = str;
        this.b = j;
        this.c = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SourceInfo{url='");
        sb.append(this.f13745a);
        sb.append("', length=");
        sb.append(this.b);
        sb.append(", mime='");
        return CtFAbx.B25kr6(sb, this.c, "'}");
    }
}
