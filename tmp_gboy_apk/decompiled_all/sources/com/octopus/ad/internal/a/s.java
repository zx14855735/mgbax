package com.octopus.ad.internal.a;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f12403a;
    public final long b;
    public final String c;

    public s(String str, long j, String str2) {
        this.f12403a = str;
        this.b = j;
        this.c = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SourceInfo{url='");
        sb.append(this.f12403a);
        sb.append("', length=");
        sb.append(this.b);
        sb.append(", mime='");
        return CtFAbx.B25kr6(sb, this.c, "'}");
    }
}
