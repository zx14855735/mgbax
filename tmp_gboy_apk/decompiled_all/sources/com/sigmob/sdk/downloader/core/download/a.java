package com.sigmob.sdk.downloader.core.download;

import android.net.Uri;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    boolean f13386a;
    boolean b;
    boolean c;
    private boolean d;
    private final com.sigmob.sdk.downloader.f e;
    private final com.sigmob.sdk.downloader.core.breakpoint.c f;
    private final long g;

    public a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j) {
        this.e = fVar;
        this.f = cVar;
        this.g = j;
    }

    public boolean a() {
        return this.d;
    }

    public com.sigmob.sdk.downloader.core.cause.b b() {
        if (!this.b) {
            return com.sigmob.sdk.downloader.core.cause.b.INFO_DIRTY;
        }
        if (!this.f13386a) {
            return com.sigmob.sdk.downloader.core.cause.b.FILE_NOT_EXIST;
        }
        if (!this.c) {
            return com.sigmob.sdk.downloader.core.cause.b.OUTPUT_STREAM_NOT_SUPPORT;
        }
        throw new IllegalStateException("No cause find with dirty: " + this.d);
    }

    public boolean c() {
        int g = this.f.g();
        if (g <= 0 || this.f.b() || this.f.o() == null) {
            return false;
        }
        if (!this.f.o().equals(this.e.m()) || this.f.o().length() > this.f.j()) {
            return false;
        }
        if (this.g > 0 && this.f.j() != this.g) {
            return false;
        }
        for (int i = 0; i < g; i++) {
            if (this.f.b(i).d() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        if (com.sigmob.sdk.downloader.g.j().e().a()) {
            return true;
        }
        return this.f.g() == 1 && !com.sigmob.sdk.downloader.g.j().f().b(this.e);
    }

    public boolean e() {
        Uri h = this.e.h();
        if (com.sigmob.sdk.downloader.core.c.a(h)) {
            return com.sigmob.sdk.downloader.core.c.c(h) > 0;
        }
        File m = this.e.m();
        return m != null && m.exists();
    }

    public void f() {
        this.f13386a = e();
        this.b = c();
        boolean d = d();
        this.c = d;
        this.d = (this.b && this.f13386a && d) ? false : true;
    }

    public String toString() {
        return "fileExist[" + this.f13386a + "] infoRight[" + this.b + "] outputStreamSupport[" + this.c + "] " + super.toString();
    }
}
