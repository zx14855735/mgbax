package com.sigmob.sdk.downloader.core.listener.assist;

import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements d, e.b<b> {

    /* renamed from: a, reason: collision with root package name */
    private final e<b> f13410a;
    private InterfaceC0455a b;

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.a$a, reason: collision with other inner class name */
    public interface InterfaceC0455a {
        void a(f fVar, int i, long j, long j2);

        void a(f fVar, long j, long j2);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, b bVar);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.b bVar);

        void a(f fVar, b bVar);
    }

    public static class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final int f13411a;
        Boolean b;
        Boolean c;
        volatile Boolean d;
        int e;
        long f;
        final AtomicLong g = new AtomicLong();

        public b(int i) {
            this.f13411a = i;
        }

        public long a() {
            return this.f;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int b() {
            return this.f13411a;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.e = cVar.g();
            this.f = cVar.j();
            this.g.set(cVar.i());
            if (this.b == null) {
                this.b = Boolean.FALSE;
            }
            if (this.c == null) {
                this.c = Boolean.valueOf(this.g.get() > 0);
            }
            if (this.d == null) {
                this.d = Boolean.TRUE;
            }
        }
    }

    public a() {
        this.f13410a = new e<>(this);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b(int i) {
        return new b(i);
    }

    public a(e<b> eVar) {
        this.f13410a = eVar;
    }

    public void a(InterfaceC0455a interfaceC0455a) {
        this.b = interfaceC0455a;
    }

    public void b(f fVar) {
        b b2 = this.f13410a.b(fVar, fVar.y());
        if (b2 == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (bool.equals(b2.c) && bool.equals(b2.d)) {
            b2.d = Boolean.FALSE;
        }
        InterfaceC0455a interfaceC0455a = this.b;
        if (interfaceC0455a != null) {
            interfaceC0455a.a(fVar, b2.e, b2.g.get(), b2.f);
        }
    }

    public void a(f fVar) {
        b a2 = this.f13410a.a(fVar, null);
        InterfaceC0455a interfaceC0455a = this.b;
        if (interfaceC0455a != null) {
            interfaceC0455a.a(fVar, a2);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        this.f13410a.b(z);
    }

    public void a(f fVar, long j) {
        b b2 = this.f13410a.b(fVar, fVar.y());
        if (b2 == null) {
            return;
        }
        b2.g.addAndGet(j);
        InterfaceC0455a interfaceC0455a = this.b;
        if (interfaceC0455a != null) {
            interfaceC0455a.a(fVar, b2.g.get(), b2.f);
        }
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        b b2 = this.f13410a.b(fVar, cVar);
        if (b2 == null) {
            return;
        }
        b2.a(cVar);
        Boolean bool = Boolean.TRUE;
        b2.b = bool;
        b2.c = bool;
        b2.d = bool;
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        InterfaceC0455a interfaceC0455a;
        b b2 = this.f13410a.b(fVar, cVar);
        if (b2 == null) {
            return;
        }
        b2.a(cVar);
        if (b2.b.booleanValue() && (interfaceC0455a = this.b) != null) {
            interfaceC0455a.a(fVar, bVar);
        }
        Boolean bool = Boolean.TRUE;
        b2.b = bool;
        b2.c = Boolean.FALSE;
        b2.d = bool;
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        b c = this.f13410a.c(fVar, fVar.y());
        InterfaceC0455a interfaceC0455a = this.b;
        if (interfaceC0455a != null) {
            interfaceC0455a.a(fVar, aVar, exc, c);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.f13410a.a(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f13410a.a();
    }
}
