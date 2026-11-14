package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.exception.i;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f13389a;
    private final com.sigmob.sdk.downloader.core.file.d b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile IOException i;

    public static class a extends d {
        public a(IOException iOException) {
            super(null);
            c(iOException);
        }
    }

    private d() {
        this.b = null;
    }

    public com.sigmob.sdk.downloader.core.file.d a() {
        com.sigmob.sdk.downloader.core.file.d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException();
    }

    public String b() {
        return this.f13389a;
    }

    public void c(IOException iOException) {
        this.f = true;
        this.i = iOException;
    }

    public void d(IOException iOException) {
        this.h = true;
        this.i = iOException;
    }

    public void e(IOException iOException) {
        if (d()) {
            return;
        }
        if (iOException instanceof com.sigmob.sdk.downloader.core.exception.f) {
            a(iOException);
            return;
        }
        if (iOException instanceof i) {
            b(iOException);
            return;
        }
        if (iOException == com.sigmob.sdk.downloader.core.exception.b.f13395a) {
            m();
            return;
        }
        if (iOException instanceof com.sigmob.sdk.downloader.core.exception.e) {
            d(iOException);
            return;
        }
        if (iOException != com.sigmob.sdk.downloader.core.exception.c.f13396a) {
            c(iOException);
            if (iOException instanceof SocketException) {
                return;
            }
            com.sigmob.sdk.downloader.core.c.b("DownloadCache", "catch unknown error " + iOException);
        }
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public IOException i() {
        return this.i;
    }

    public com.sigmob.sdk.downloader.core.cause.b j() {
        return ((com.sigmob.sdk.downloader.core.exception.f) this.i).a();
    }

    public boolean k() {
        return this.c || this.d || this.e || this.f || this.g || this.h;
    }

    public void l() {
        this.d = true;
    }

    public void m() {
        this.g = true;
    }

    public d(com.sigmob.sdk.downloader.core.file.d dVar) {
        this.b = dVar;
    }

    public void a(IOException iOException) {
        this.c = true;
        this.i = iOException;
    }

    public void b(IOException iOException) {
        this.e = true;
        this.i = iOException;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public void a(String str) {
        this.f13389a = str;
    }
}
