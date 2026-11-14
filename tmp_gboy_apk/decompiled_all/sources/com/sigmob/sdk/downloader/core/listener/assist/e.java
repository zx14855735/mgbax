package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.e.a;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e<T extends a> implements d {

    /* renamed from: a, reason: collision with root package name */
    volatile T f13415a;
    final SparseArray<T> b = new SparseArray<>();
    private Boolean c;
    private final b<T> d;

    public interface a {
        void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar);

        int b();
    }

    public interface b<T extends a> {
        T b(int i);
    }

    public e(b<T> bVar) {
        this.d = bVar;
    }

    public T a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T b2 = this.d.b(fVar.c());
        synchronized (this) {
            try {
                if (this.f13415a == null) {
                    this.f13415a = b2;
                } else {
                    this.b.put(fVar.c(), b2);
                }
                if (cVar != null) {
                    b2.a(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    public T b(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T t;
        int c = fVar.c();
        synchronized (this) {
            try {
                t = (this.f13415a == null || this.f13415a.b() != c) ? null : this.f13415a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (t == null) {
            t = this.b.get(c);
        }
        return (t == null && a()) ? a(fVar, cVar) : t;
    }

    public T c(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T t;
        int c = fVar.c();
        synchronized (this) {
            try {
                if (this.f13415a == null || this.f13415a.b() != c) {
                    t = this.b.get(c);
                    this.b.remove(c);
                } else {
                    t = this.f13415a;
                    this.f13415a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (t != null) {
            return t;
        }
        T b2 = this.d.b(c);
        if (cVar != null) {
            b2.a(cVar);
        }
        return b2;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.c = Boolean.valueOf(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        if (this.c == null) {
            this.c = Boolean.valueOf(z);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        Boolean bool = this.c;
        return bool != null && bool.booleanValue();
    }
}
