package com.sigmob.sdk.downloader.core.dispatcher;

import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.c;
import com.sigmob.sdk.downloader.core.download.e;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import com.sigmob.sdk.downloader.l;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {
    private static final String b = "DownloadDispatcher";

    /* renamed from: a, reason: collision with root package name */
    int f13385a;
    private final List<e> c;
    private final List<e> d;
    private final List<e> e;
    private final List<e> f;
    private final AtomicInteger g;
    private volatile ExecutorService h;
    private final AtomicInteger i;
    private j j;

    public b() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    private int d() {
        return this.d.size() - this.g.get();
    }

    private synchronized void i(f fVar) {
        c.b(b, "enqueueLocked for single task: " + fVar);
        if (h(fVar)) {
            return;
        }
        if (k(fVar)) {
            return;
        }
        int size = this.c.size();
        j(fVar);
        if (size != this.c.size()) {
            Collections.sort(this.c);
        }
    }

    private synchronized void j(f fVar) {
        try {
            e a2 = e.a(fVar, true, this.j);
            if (d() < this.f13385a) {
                this.d.add(a2);
                a().execute(a2);
            } else {
                this.c.add(a2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean k(f fVar) {
        return a(fVar, (Collection<f>) null, (Collection<f>) null);
    }

    public synchronized ExecutorService a() {
        try {
            if (this.h == null) {
                this.h = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("FileDownload Download", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.h;
    }

    public void b() {
        this.i.incrementAndGet();
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = this.c.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c);
        }
        Iterator<e> it2 = this.d.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().c);
        }
        Iterator<e> it3 = this.e.iterator();
        while (it3.hasNext()) {
            arrayList.add(it3.next().c);
        }
        if (!arrayList.isEmpty()) {
            b((com.sigmob.sdk.downloader.core.a[]) arrayList.toArray(new f[arrayList.size()]));
        }
        this.i.decrementAndGet();
    }

    public synchronized f c(f fVar) {
        c.b(b, "findSameTask: " + fVar.c());
        for (e eVar : this.c) {
            if (!eVar.d() && eVar.a(fVar)) {
                return eVar.c;
            }
        }
        for (e eVar2 : this.d) {
            if (!eVar2.d() && eVar2.a(fVar)) {
                return eVar2.c;
            }
        }
        for (e eVar3 : this.e) {
            if (!eVar3.d() && eVar3.a(fVar)) {
                return eVar3.c;
            }
        }
        return null;
    }

    public synchronized boolean e(f fVar) {
        c.b(b, "isCanceled: " + fVar.c());
        for (e eVar : this.e) {
            if (eVar.d() && eVar.a(fVar)) {
                return true;
            }
        }
        for (e eVar2 : this.d) {
            if (eVar2.d() && eVar2.a(fVar)) {
                return true;
            }
        }
        for (e eVar3 : this.c) {
            if (eVar3.d() && eVar3.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean f(f fVar) {
        c.b(b, "isPending: " + fVar.c());
        for (e eVar : this.c) {
            if (!eVar.d() && eVar.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean g(f fVar) {
        f fVar2;
        File m;
        f fVar3;
        File m2;
        c.b(b, "is file conflict after run: " + fVar.c());
        File m3 = fVar.m();
        if (m3 == null) {
            return false;
        }
        for (e eVar : this.e) {
            if (!eVar.d() && (fVar3 = eVar.c) != fVar && (m2 = fVar3.m()) != null && m3.equals(m2)) {
                return true;
            }
        }
        for (e eVar2 : this.d) {
            if (!eVar2.d() && (fVar2 = eVar2.c) != fVar && (m = fVar2.m()) != null && m3.equals(m)) {
                return true;
            }
        }
        return false;
    }

    public boolean h(f fVar) {
        return a(fVar, (Collection<f>) null);
    }

    public b(List<e> list, List<e> list2, List<e> list3, List<e> list4) {
        this.f13385a = 5;
        this.g = new AtomicInteger();
        this.i = new AtomicInteger();
        this.c = list;
        this.d = list2;
        this.e = list3;
        this.f = list4;
    }

    private synchronized void a(com.sigmob.sdk.downloader.core.a aVar, List<e> list, List<e> list2) {
        try {
            Iterator<e> it = this.c.iterator();
            while (it.hasNext()) {
                e next = it.next();
                f fVar = next.c;
                if (fVar != aVar && fVar.c() != aVar.c()) {
                }
                if (!next.d() && !next.e()) {
                    it.remove();
                    list.add(next);
                }
            }
            for (e eVar : this.d) {
                f fVar2 = eVar.c;
                if (fVar2 == aVar || fVar2.c() == aVar.c()) {
                    list.add(eVar);
                    list2.add(eVar);
                }
            }
            for (e eVar2 : this.e) {
                f fVar3 = eVar2.c;
                if (fVar3 == aVar || fVar3.c() == aVar.c()) {
                    list.add(eVar2);
                    list2.add(eVar2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void b(int i) {
        b a2 = g.j().a();
        if (a2.getClass() == b.class) {
            a2.f13385a = Math.max(1, i);
            return;
        }
        throw new IllegalStateException("The current dispatcher is " + a2 + " not DownloadDispatcher exactly!");
    }

    private synchronized void c() {
        try {
            if (this.i.get() > 0) {
                return;
            }
            if (d() >= this.f13385a) {
                return;
            }
            if (this.c.isEmpty()) {
                return;
            }
            Iterator<e> it = this.c.iterator();
            while (it.hasNext()) {
                e next = it.next();
                it.remove();
                f fVar = next.c;
                if (g(fVar)) {
                    g.j().b().a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                } else {
                    this.d.add(next);
                    a().execute(next);
                    if (d() >= this.f13385a) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean d(f fVar) {
        c.b(b, "isRunning: " + fVar.c());
        for (e eVar : this.e) {
            if (!eVar.d() && eVar.a(fVar)) {
                return true;
            }
        }
        for (e eVar2 : this.d) {
            if (!eVar2.d() && eVar2.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public void a(j jVar) {
        this.j = jVar;
    }

    public synchronized void b(e eVar) {
        c.b(b, "flying canceled: " + eVar.c.c());
        if (eVar.d) {
            this.g.incrementAndGet();
        }
    }

    public synchronized void c(e eVar) {
        try {
            boolean z = eVar.d;
            if (!(this.f.contains(eVar) ? this.f : z ? this.d : this.e).remove(eVar)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z && eVar.d()) {
                this.g.decrementAndGet();
            }
            if (z) {
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(e eVar) {
        eVar.run();
    }

    public void b(f fVar) {
        c.b(b, "execute: " + fVar);
        synchronized (this) {
            try {
                if (!h(fVar) && !k(fVar)) {
                    e a2 = e.a(fVar, false, this.j);
                    this.e.add(a2);
                    a(a2);
                }
            } finally {
            }
        }
    }

    private synchronized void b(com.sigmob.sdk.downloader.core.a[] aVarArr) {
        long uptimeMillis = SystemClock.uptimeMillis();
        c.b(b, "start cancel bunch task manually: " + aVarArr.length);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (com.sigmob.sdk.downloader.core.a aVar : aVarArr) {
                a(aVar, arrayList, arrayList2);
            }
        } finally {
            a(arrayList, arrayList2);
            c.b(b, "finish cancel bunch task manually: " + aVarArr.length + " consume " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
        }
    }

    public void a(f fVar) {
        this.i.incrementAndGet();
        i(fVar);
        this.i.decrementAndGet();
    }

    private synchronized void a(List<e> list, List<e> list2) {
        try {
            c.b(b, "handle cancel calls, cancel calls: " + list2.size());
            if (!list2.isEmpty()) {
                for (e eVar : list2) {
                    if (!eVar.c()) {
                        list.remove(eVar);
                    }
                }
            }
            c.b(b, "handle cancel calls, callback cancel event: " + list.size());
            if (!list.isEmpty()) {
                if (list.size() <= 1) {
                    g.j().b().a().a(list.get(0).c, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().c);
                    }
                    g.j().b().a(arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void b(f[] fVarArr) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            c.b(b, "start enqueueLocked for bunch task: " + fVarArr.length);
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, fVarArr);
            if (arrayList.size() > 1) {
                Collections.sort(arrayList);
            }
            int size = this.c.size();
            try {
                g.j().g().b();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (!a(fVar, arrayList2) && !a(fVar, (Collection<f>) arrayList3, (Collection<f>) arrayList4)) {
                        j(fVar);
                    }
                }
                g.j().b().a(arrayList2, arrayList3, arrayList4);
            } catch (UnknownHostException e) {
                g.j().b().a(new ArrayList(arrayList), e);
            }
            if (size != this.c.size()) {
                Collections.sort(this.c);
            }
            c.b(b, "end enqueueLocked for bunch task: " + fVarArr.length + " consume " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(com.sigmob.sdk.downloader.core.a[] aVarArr) {
        this.i.incrementAndGet();
        b(aVarArr);
        this.i.decrementAndGet();
        c();
    }

    public synchronized boolean b(com.sigmob.sdk.downloader.core.a aVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        c.b(b, "cancel manually: " + aVar.c());
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        try {
            a(aVar, arrayList, arrayList2);
            a(arrayList, arrayList2);
        } catch (Throwable th) {
            a(arrayList, arrayList2);
            throw th;
        }
        return arrayList.size() > 0 || arrayList2.size() > 0;
    }

    public void a(f[] fVarArr) {
        this.i.incrementAndGet();
        b(fVarArr);
        this.i.decrementAndGet();
    }

    public boolean a(int i) {
        this.i.incrementAndGet();
        boolean b2 = b(f.c(i));
        this.i.decrementAndGet();
        c();
        return b2;
    }

    public boolean a(com.sigmob.sdk.downloader.core.a aVar) {
        this.i.incrementAndGet();
        boolean b2 = b(aVar);
        this.i.decrementAndGet();
        c();
        return b2;
    }

    public boolean a(f fVar, Collection<f> collection) {
        if (!fVar.e() || !l.c(fVar)) {
            return false;
        }
        if (fVar.d() == null && !g.j().g().a(fVar)) {
            return false;
        }
        g.j().g().a(fVar, this.j);
        if (collection != null) {
            collection.add(fVar);
            return true;
        }
        g.j().b().a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
        return true;
    }

    private boolean a(f fVar, Collection<f> collection, Collection<f> collection2) {
        return a(fVar, this.c, collection, collection2) || a(fVar, this.d, collection, collection2) || a(fVar, this.e, collection, collection2);
    }

    public boolean a(f fVar, Collection<e> collection, Collection<f> collection2, Collection<f> collection3) {
        a b2 = g.j().b();
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!next.d()) {
                if (next.a(fVar)) {
                    if (!next.e()) {
                        if (collection2 != null) {
                            collection2.add(fVar);
                        } else {
                            b2.a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                        }
                        return true;
                    }
                    c.b(b, "task: " + fVar.c() + " is finishing, move it to finishing list");
                    this.f.add(next);
                    it.remove();
                    return false;
                }
                File g = next.g();
                File m = fVar.m();
                if (g != null && m != null && g.equals(m)) {
                    if (collection3 != null) {
                        collection3.add(fVar);
                    } else {
                        b2.a().a(fVar, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
