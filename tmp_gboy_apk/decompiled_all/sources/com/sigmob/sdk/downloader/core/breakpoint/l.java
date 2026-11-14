package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.sigmob.sdk.downloader.core.breakpoint.m;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l implements j, m.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13357a = "RemitStoreOnSQLite";
    private final n b;
    private final i c;
    private final e d;
    private final j e;

    public l(i iVar) {
        this.b = new n(this);
        this.c = iVar;
        this.e = iVar.b;
        this.d = iVar.f13355a;
    }

    public static void j(int i) {
        g c = com.sigmob.sdk.downloader.g.j().c();
        if (c instanceof l) {
            ((l) c).b.f13359a = Math.max(0, i);
        } else {
            throw new IllegalStateException("The current store is " + c + " not RemitStoreOnSQLite!");
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int i) {
        return this.c.a(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f fVar) {
        return this.c.b(fVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int i) {
        return this.c.c(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int i) {
        this.c.d(i);
        this.b.b(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int i) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int i) {
        return this.c.f(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int i) {
        return this.c.g(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void h(int i) {
        this.d.c(i);
        c a2 = this.e.a(i);
        if (a2 == null || a2.m() == null || a2.i() <= 0) {
            return;
        }
        this.d.a(a2);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void i(int i) {
        this.d.c(i);
    }

    public l(n nVar, i iVar, j jVar, e eVar) {
        this.b = nVar;
        this.c = iVar;
        this.e = jVar;
        this.d = eVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) {
        return this.b.a(fVar.c()) ? this.e.a(fVar) : this.c.a(fVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void b(int i) {
        this.e.b(i);
        this.b.d(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        return this.c.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.c.a(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.e.a(i, aVar, exc);
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.b.d(i);
        } else {
            this.b.c(i);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i, long j) {
        if (this.b.a(cVar.a())) {
            this.e.a(cVar, i, j);
        } else {
            this.c.a(cVar, i, j);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void a(List<Integer> list) {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                h(it.next().intValue());
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) {
        return this.b.a(cVar.a()) ? this.e.a(cVar) : this.c.a(cVar);
    }
}
