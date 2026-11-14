package com.octopus.ad.b.e;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    long f12362a;
    String b;
    String c;
    int d;

    public b(String str) {
        this.c = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b() {
        this.f12362a = 0L;
    }

    public void a(long j) {
        this.f12362a = j;
    }

    public void a(int i) {
        this.d = i;
    }

    public boolean a() {
        return this.f12362a > System.currentTimeMillis();
    }
}
