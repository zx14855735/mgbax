package com.bykv.vk.component.ttvideo.utils;

import android.os.SystemClock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f10022a = 1;
    private int b = 2;
    private int c = 2;
    private int d = 0;
    private long e = 0;

    public void a() {
        this.d = 0;
        if (this.c == this.f10022a) {
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public int b() {
        if (this.c == this.f10022a) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.e);
            if (i >= 0) {
                this.d += i;
            }
            this.e = elapsedRealtime;
        }
        return this.d;
    }

    public void c() {
        this.c = this.b;
        this.d = 0;
        this.e = 0L;
    }

    public void d() {
        if (this.c == this.b) {
            this.c = this.f10022a;
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public void e() {
        if (this.c == this.f10022a) {
            this.c = this.b;
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.e);
            if (elapsedRealtime >= 0) {
                this.d += elapsedRealtime;
            }
        }
    }
}
