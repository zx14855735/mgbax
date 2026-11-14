package com.sigmob.sdk.downloader.core.breakpoint;

import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    final int f13347a;
    final File b;
    private final String c;
    private String d;
    private File e;
    private final g.a f;
    private final List<a> g = new ArrayList();
    private final boolean h;
    private boolean i;

    public c(int i, String str, File file, String str2) {
        this.f13347a = i;
        this.c = str;
        this.b = file;
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) str2)) {
            this.f = new g.a();
            this.h = true;
        } else {
            this.f = new g.a(str2);
            this.h = false;
            this.e = new File(file, str2);
        }
    }

    public int a() {
        return this.f13347a;
    }

    public a b(int i) {
        return this.g.get(i);
    }

    public c c(int i) {
        c cVar = new c(i, this.c, this.b, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().g());
        }
        return cVar;
    }

    public boolean d() {
        return this.h;
    }

    public void e() {
        this.g.clear();
        this.d = null;
    }

    public void f() {
        this.g.clear();
    }

    public int g() {
        return this.g.size();
    }

    public File h() {
        return this.b;
    }

    public long i() {
        Object[] array = this.g.toArray();
        long j = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    j = ((a) obj).a() + j;
                }
            }
        }
        return j;
    }

    public long j() {
        if (b()) {
            return i();
        }
        Object[] array = this.g.toArray();
        long j = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    j = ((a) obj).d() + j;
                }
            }
        }
        return j;
    }

    public String k() {
        return this.d;
    }

    public String l() {
        return this.c;
    }

    public String m() {
        return this.f.a();
    }

    public g.a n() {
        return this.f;
    }

    public File o() {
        String a2 = this.f.a();
        if (a2 == null) {
            return null;
        }
        if (this.e == null) {
            this.e = new File(this.b, a2);
        }
        return this.e;
    }

    public c p() {
        c cVar = new c(this.f13347a, this.c, this.b, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().g());
        }
        return cVar;
    }

    public String toString() {
        return "id[" + this.f13347a + "] url[" + this.c + "] etag[" + this.d + "] taskOnlyProvidedParentPath[" + this.h + "] parent path[" + this.b + "] filename[" + this.f.a() + "] block(s):" + this.g.toString();
    }

    public c(int i, String str, File file, String str2, boolean z) {
        this.f13347a = i;
        this.c = str;
        this.b = file;
        this.f = com.sigmob.sdk.downloader.core.c.a((CharSequence) str2) ? new g.a() : new g.a(str2);
        this.h = z;
    }

    public c a(int i, String str) {
        c cVar = new c(i, str, this.b, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().g());
        }
        return cVar;
    }

    public boolean b() {
        return this.i;
    }

    public boolean c() {
        return this.g.size() == 1;
    }

    public void a(a aVar) {
        this.g.add(aVar);
    }

    public void a(c cVar) {
        this.g.clear();
        this.g.addAll(cVar.g);
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a(int i) {
        return i == this.g.size() - 1;
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar) {
        if (!this.b.equals(fVar.l()) || !this.c.equals(fVar.i())) {
            return false;
        }
        String d = fVar.d();
        if (d != null && d.equals(this.f.a())) {
            return true;
        }
        if (this.h && fVar.a()) {
            return d == null || d.equals(this.f.a());
        }
        return false;
    }
}
