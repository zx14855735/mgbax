package com.sigmob.sdk.downloader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.file.a;
import com.sigmob.sdk.downloader.core.file.b;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    static volatile g f13424a;
    d b;
    private final com.sigmob.sdk.downloader.core.dispatcher.b c;
    private final com.sigmob.sdk.downloader.core.dispatcher.a d;
    private final com.sigmob.sdk.downloader.core.breakpoint.g e;
    private final a.b f;
    private final a.InterfaceC0454a g;
    private final com.sigmob.sdk.downloader.core.file.e h;
    private final com.sigmob.sdk.downloader.core.download.g i;
    private final Context j;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private com.sigmob.sdk.downloader.core.dispatcher.b f13425a;
        private com.sigmob.sdk.downloader.core.dispatcher.a b;
        private com.sigmob.sdk.downloader.core.breakpoint.j c;
        private a.b d;
        private com.sigmob.sdk.downloader.core.file.e e;
        private com.sigmob.sdk.downloader.core.download.g f;
        private a.InterfaceC0454a g;
        private d h;
        private final Context i;

        public a(Context context) {
            this.i = context.getApplicationContext();
        }

        public a a(com.sigmob.sdk.downloader.core.breakpoint.j jVar) {
            this.c = jVar;
            return this;
        }

        public a a(a.b bVar) {
            this.d = bVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.dispatcher.a aVar) {
            this.b = aVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.dispatcher.b bVar) {
            this.f13425a = bVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.download.g gVar) {
            this.f = gVar;
            return this;
        }

        public a a(a.InterfaceC0454a interfaceC0454a) {
            this.g = interfaceC0454a;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.file.e eVar) {
            this.e = eVar;
            return this;
        }

        public a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public g a() {
            if (this.f13425a == null) {
                this.f13425a = new com.sigmob.sdk.downloader.core.dispatcher.b();
            }
            if (this.b == null) {
                this.b = new com.sigmob.sdk.downloader.core.dispatcher.a();
            }
            if (this.c == null) {
                this.c = com.sigmob.sdk.downloader.core.c.a(this.i);
            }
            if (this.d == null) {
                this.d = com.sigmob.sdk.downloader.core.c.c();
            }
            if (this.g == null) {
                this.g = new b.a();
            }
            if (this.e == null) {
                this.e = new com.sigmob.sdk.downloader.core.file.e();
            }
            if (this.f == null) {
                this.f = new com.sigmob.sdk.downloader.core.download.g();
            }
            g gVar = new g(this.i, this.f13425a, this.b, this.c, this.d, this.g, this.e, this.f);
            gVar.a(this.h);
            com.sigmob.sdk.downloader.core.c.b("FileDownload", "downloadStore[" + this.c + "] connectionFactory[" + this.d);
            return gVar;
        }
    }

    public g(Context context, com.sigmob.sdk.downloader.core.dispatcher.b bVar, com.sigmob.sdk.downloader.core.dispatcher.a aVar, com.sigmob.sdk.downloader.core.breakpoint.j jVar, a.b bVar2, a.InterfaceC0454a interfaceC0454a, com.sigmob.sdk.downloader.core.file.e eVar, com.sigmob.sdk.downloader.core.download.g gVar) {
        this.j = context;
        this.c = bVar;
        this.d = aVar;
        this.e = jVar;
        this.f = bVar2;
        this.g = interfaceC0454a;
        this.h = eVar;
        this.i = gVar;
        bVar.a(com.sigmob.sdk.downloader.core.c.a(jVar));
    }

    public static g j() {
        if (f13424a == null) {
            synchronized (g.class) {
                try {
                    if (f13424a == null) {
                        if (com.sigmob.sdk.b.e() == null) {
                            throw new IllegalStateException("context == null");
                        }
                        f13424a = new a(com.sigmob.sdk.b.e()).a();
                    }
                } finally {
                }
            }
        }
        return f13424a;
    }

    public com.sigmob.sdk.downloader.core.dispatcher.b a() {
        return this.c;
    }

    public com.sigmob.sdk.downloader.core.dispatcher.a b() {
        return this.d;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.g c() {
        return this.e;
    }

    public a.b d() {
        return this.f;
    }

    public a.InterfaceC0454a e() {
        return this.g;
    }

    public com.sigmob.sdk.downloader.core.file.e f() {
        return this.h;
    }

    public com.sigmob.sdk.downloader.core.download.g g() {
        return this.i;
    }

    public Context h() {
        return this.j;
    }

    public d i() {
        return this.b;
    }

    public void a(d dVar) {
        this.b = dVar;
    }

    public static void a(g gVar) {
        if (f13424a != null) {
            throw new IllegalArgumentException("FileDownload must be null.");
        }
        synchronized (g.class) {
            try {
                if (f13424a != null) {
                    throw new IllegalArgumentException("FileDownload must be null.");
                }
                f13424a = gVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
