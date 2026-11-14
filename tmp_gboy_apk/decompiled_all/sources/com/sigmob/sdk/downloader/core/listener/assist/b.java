package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.b.c;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b<T extends c> implements d {

    /* renamed from: a, reason: collision with root package name */
    InterfaceC0456b f13412a;
    private a b;
    private final e<T> c;

    public interface a {
        boolean a(f fVar, int i, long j, c cVar);

        boolean a(f fVar, int i, c cVar);

        boolean a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z, c cVar2);

        boolean a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, c cVar);
    }

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.b$b, reason: collision with other inner class name */
    public interface InterfaceC0456b {
        void a(f fVar, int i, com.sigmob.sdk.downloader.core.breakpoint.a aVar);

        void a(f fVar, long j);

        void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z, c cVar2);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, c cVar);

        void d(f fVar, int i, long j);
    }

    public static class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        com.sigmob.sdk.downloader.core.breakpoint.c f13413a;
        long b;
        SparseArray<Long> c;
        private final int d;

        public c(int i) {
            this.d = i;
        }

        public long a(int i) {
            return this.c.get(i).longValue();
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int b() {
            return this.d;
        }

        public long c() {
            return this.b;
        }

        public SparseArray<Long> d() {
            return this.c.clone();
        }

        public com.sigmob.sdk.downloader.core.breakpoint.c e() {
            return this.f13413a;
        }

        public SparseArray<Long> a() {
            return this.c;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.f13413a = cVar;
            this.b = cVar.i();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int g = cVar.g();
            for (int i = 0; i < g; i++) {
                sparseArray.put(i, Long.valueOf(cVar.b(i).a()));
            }
            this.c = sparseArray;
        }
    }

    public b(e.b<T> bVar) {
        this.c = new e<>(bVar);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public a b() {
        return this.b;
    }

    public b(e<T> eVar) {
        this.c = eVar;
    }

    public void a(InterfaceC0456b interfaceC0456b) {
        this.f13412a = interfaceC0456b;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        this.c.b(z);
    }

    public void a(f fVar, int i) {
        InterfaceC0456b interfaceC0456b;
        T b = this.c.b(fVar, fVar.y());
        if (b == null) {
            return;
        }
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, i, b)) && (interfaceC0456b = this.f13412a) != null) {
            interfaceC0456b.a(fVar, i, b.f13413a.b(i));
        }
    }

    public void a(f fVar, int i, long j) {
        InterfaceC0456b interfaceC0456b;
        T b = this.c.b(fVar, fVar.y());
        if (b == null) {
            return;
        }
        long longValue = b.c.get(i).longValue() + j;
        b.c.put(i, Long.valueOf(longValue));
        b.b += j;
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, i, j, b)) && (interfaceC0456b = this.f13412a) != null) {
            interfaceC0456b.d(fVar, i, longValue);
            this.f13412a.a(fVar, b.b);
        }
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z) {
        InterfaceC0456b interfaceC0456b;
        T a2 = this.c.a(fVar, cVar);
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, cVar, z, a2)) && (interfaceC0456b = this.f13412a) != null) {
            interfaceC0456b.a(fVar, cVar, z, a2);
        }
    }

    public synchronized void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        T c2 = this.c.c(fVar, fVar.y());
        a aVar2 = this.b;
        if (aVar2 == null || !aVar2.a(fVar, aVar, exc, c2)) {
            InterfaceC0456b interfaceC0456b = this.f13412a;
            if (interfaceC0456b != null) {
                interfaceC0456b.a(fVar, aVar, exc, c2);
            }
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.c.a(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.c.a();
    }
}
