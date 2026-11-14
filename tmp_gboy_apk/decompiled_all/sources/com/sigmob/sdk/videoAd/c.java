package com.sigmob.sdk.videoAd;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f13697a;
    private String b;
    private String c;
    private String title;

    public c(String str, String str2, String str3, String str4) {
        this.title = str;
        this.f13697a = str2;
        this.b = str3;
        this.c = str4;
    }

    public String a() {
        return this.title;
    }

    public String b() {
        return this.f13697a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DialogConfig{title='");
        sb.append(this.title);
        sb.append("', context='");
        sb.append(this.f13697a);
        sb.append("', cancelTxt='");
        sb.append(this.b);
        sb.append("', closeTxtl='");
        return CtFAbx.B25kr6(sb, this.c, "'}");
    }

    public void a(String str) {
        this.title = str;
    }

    public void b(String str) {
        this.f13697a = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.c = str;
    }
}
