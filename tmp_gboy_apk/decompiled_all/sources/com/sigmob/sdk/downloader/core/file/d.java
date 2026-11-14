package com.sigmob.sdk.downloader.core.file;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    private static final String n = "MultiPointOutputStream";
    private static final ExecutorService o = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload file io", false));

    /* renamed from: a, reason: collision with root package name */
    final SparseArray<com.sigmob.sdk.downloader.core.file.a> f13402a;
    final SparseArray<AtomicLong> b;
    final AtomicLong c;
    final AtomicLong d;
    boolean e;
    volatile Future f;
    volatile Thread g;
    final SparseArray<Thread> h;
    IOException i;
    ArrayList<Integer> j;
    List<Integer> k;
    final a l;
    a m;
    private final int p;
    private final int q;
    private final int r;
    private final com.sigmob.sdk.downloader.core.breakpoint.c s;
    private final f t;
    private final j u;
    private final boolean v;
    private final boolean w;
    private final Runnable x;
    private String y;
    private volatile boolean z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f13405a;
        List<Integer> b = new ArrayList();
        List<Integer> c = new ArrayList();

        public boolean a() {
            return this.f13405a || this.c.size() > 0;
        }
    }

    static {
        KQVPiCn();
    }

    public d(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar) {
        this(fVar, cVar, jVar, null);
    }

    private static /* synthetic */ void KQVPiCn() {
        char[] charArray = "'+)j#%)!j&+=j7,!((j\u000e*-\u00066- #!".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'D');
        }
        String str = new String(charArray);
        char[] charArray2 = "'(-*-0".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'D');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void m() {
        if (this.y != null || this.t.m() == null) {
            return;
        }
        this.y = this.t.m().getAbsolutePath();
    }

    public void a() {
        o.execute(new Runnable() { // from class: com.sigmob.sdk.downloader.core.file.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
    }

    public synchronized void b() {
        List<Integer> list = this.k;
        if (list == null) {
            return;
        }
        if (this.e) {
            return;
        }
        this.e = true;
        this.j.addAll(list);
        try {
            if (this.c.get() <= 0) {
                for (Integer num : this.k) {
                    try {
                        c(num.intValue());
                    } catch (IOException e) {
                        com.sigmob.sdk.downloader.core.c.b(n, "OutputStream close failed task[" + this.t.c() + "] block[" + num + "]" + e);
                    }
                }
                this.u.a(this.t.c(), com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                return;
            }
            if (this.f != null && !this.f.isDone()) {
                m();
                g.j().f().a().a(this.y);
                try {
                    a(true, -1);
                    g.j().f().a().b(this.y);
                } catch (Throwable th) {
                    g.j().f().a().b(this.y);
                    throw th;
                }
            }
            for (Integer num2 : this.k) {
                try {
                    c(num2.intValue());
                } catch (IOException e2) {
                    com.sigmob.sdk.downloader.core.c.b(n, "OutputStream close failed task[" + this.t.c() + "] block[" + num2 + "]" + e2);
                }
            }
            this.u.a(this.t.c(), com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
            return;
        } finally {
        }
    }

    public synchronized void c(int i) {
        com.sigmob.sdk.downloader.core.file.a aVar = this.f13402a.get(i);
        if (aVar != null) {
            aVar.a();
            synchronized (this.b) {
                this.f13402a.remove(i);
                this.b.remove(i);
            }
            com.sigmob.sdk.downloader.core.c.b(n, "OutputStream close task[" + this.t.c() + "] block[" + i + "]");
        }
    }

    public void d() {
        IOException iOException = this.i;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f == null) {
            synchronized (this.x) {
                try {
                    if (this.f == null) {
                        this.f = f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public synchronized com.sigmob.sdk.downloader.core.file.a e(int i) {
        com.sigmob.sdk.downloader.core.file.a aVar;
        Uri h;
        try {
            aVar = this.f13402a.get(i);
            if (aVar == null) {
                boolean b = com.sigmob.sdk.downloader.core.c.b(this.t.h());
                if (b) {
                    File m = this.t.m();
                    if (m == null) {
                        throw new FileNotFoundException("Filename is not ready!");
                    }
                    File l = this.t.l();
                    if (!l.exists() && !l.mkdirs()) {
                        throw new IOException("Create parent folder failed!");
                    }
                    if (m.createNewFile()) {
                        com.sigmob.sdk.downloader.core.c.b(n, "Create new file: " + m.getName());
                    }
                    h = Uri.fromFile(m);
                } else {
                    h = this.t.h();
                }
                com.sigmob.sdk.downloader.core.file.a a2 = g.j().e().a(g.j().h(), h, this.p);
                if (this.v) {
                    long c = this.s.b(i).c();
                    if (c > 0) {
                        a2.a(c);
                        com.sigmob.sdk.downloader.core.c.b(n, "Create output stream write from (" + this.t.c() + ") block(" + i + ") " + c);
                    }
                }
                if (this.z) {
                    this.u.f(this.t.c());
                }
                if (!this.s.b() && this.z && this.w) {
                    long j = this.s.j();
                    if (b) {
                        File m2 = this.t.m();
                        long length = j - m2.length();
                        if (length > 0) {
                            a(new StatFs(m2.getAbsolutePath()), length);
                        }
                    }
                    a2.b(j);
                }
                synchronized (this.b) {
                    this.f13402a.put(i, a2);
                    this.b.put(i, new AtomicLong());
                }
                this.z = false;
                aVar = a2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public Future f() {
        return o.submit(this.x);
    }

    public void g() {
        try {
            h();
        } catch (IOException e) {
            this.i = e;
            com.sigmob.sdk.downloader.core.c.a(n, "Sync to breakpoint-store for task[" + this.t.c() + "] failed with cause: " + e);
        }
    }

    public void h() {
        com.sigmob.sdk.downloader.core.c.b(n, "OutputStream start flush looper task[" + this.t.c() + "] with syncBufferIntervalMills[" + this.r + "] syncBufferSize[" + this.q + "]");
        this.g = Thread.currentThread();
        long j = (long) this.r;
        l();
        while (true) {
            a(j);
            a(this.m);
            if (this.m.a()) {
                com.sigmob.sdk.downloader.core.c.b(n, "runSync state change isNoMoreStream[" + this.m.f13405a + "] newNoMoreStreamBlockList[" + this.m.c + "]");
                if (this.c.get() > 0) {
                    l();
                }
                for (Integer num : this.m.c) {
                    Thread thread = this.h.get(num.intValue());
                    this.h.remove(num.intValue());
                    if (thread != null) {
                        a(thread);
                    }
                }
                if (this.m.f13405a) {
                    break;
                }
            } else {
                if (!i()) {
                    j = j();
                    if (j <= 0) {
                        l();
                    }
                }
                j = this.r;
            }
        }
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            Thread valueAt = this.h.valueAt(i);
            if (valueAt != null) {
                a(valueAt);
            }
        }
        this.h.clear();
        com.sigmob.sdk.downloader.core.c.b(n, "OutputStream stop flush looper task[" + this.t.c() + "]");
    }

    public boolean i() {
        return this.c.get() < ((long) this.q);
    }

    public long j() {
        return this.r - (k() - this.d.get());
    }

    public long k() {
        return SystemClock.uptimeMillis();
    }

    public void l() {
        long j;
        synchronized (this.b) {
            int size = this.b.size();
            SparseArray sparseArray = new SparseArray(size);
            int i = 0;
            while (true) {
                j = 0;
                if (i >= size) {
                    break;
                }
                try {
                    int keyAt = this.b.keyAt(i);
                    long j2 = this.b.get(keyAt).get();
                    if (j2 > 0) {
                        sparseArray.put(keyAt, Long.valueOf(j2));
                        this.f13402a.get(keyAt).b();
                    }
                    i++;
                } catch (IOException e) {
                    com.sigmob.sdk.downloader.core.c.a(n, "OutputStream flush and sync data to filesystem failed " + e);
                }
            }
            int size2 = sparseArray.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int keyAt2 = sparseArray.keyAt(i2);
                long longValue = ((Long) sparseArray.valueAt(i2)).longValue();
                this.u.a(this.s, keyAt2, longValue);
                j += longValue;
                this.b.get(keyAt2).addAndGet(-longValue);
                com.sigmob.sdk.downloader.core.c.b(n, "OutputStream sync success (" + this.t.c() + ") block(" + keyAt2 + ")  syncLength(" + longValue + ") currentOffset(" + this.s.b(keyAt2).a() + ")");
            }
            this.c.addAndGet(-j);
            this.d.set(SystemClock.uptimeMillis());
        }
    }

    public d(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar, Runnable runnable) {
        this.f13402a = new SparseArray<>();
        this.b = new SparseArray<>();
        this.c = new AtomicLong();
        this.d = new AtomicLong();
        this.e = false;
        this.h = new SparseArray<>();
        this.l = new a();
        this.m = new a();
        this.z = true;
        this.t = fVar;
        this.p = fVar.p();
        this.q = fVar.q();
        this.r = fVar.r();
        this.s = cVar;
        this.u = jVar;
        this.v = g.j().e().a();
        this.w = g.j().f().b(fVar);
        this.j = new ArrayList<>();
        if (runnable == null) {
            this.x = new Runnable() { // from class: com.sigmob.sdk.downloader.core.file.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.g();
                }
            };
        } else {
            this.x = runnable;
        }
        File m = fVar.m();
        if (m != null) {
            this.y = m.getAbsolutePath();
        }
    }

    public synchronized void a(int i) {
        this.j.add(Integer.valueOf(i));
        try {
            IOException iOException = this.i;
            if (iOException != null) {
                throw iOException;
            }
            if (this.f != null && !this.f.isDone()) {
                AtomicLong atomicLong = this.b.get(i);
                if (atomicLong != null && atomicLong.get() > 0) {
                    a(this.l);
                    a(this.l.f13405a, i);
                }
            } else if (this.f == null) {
                com.sigmob.sdk.downloader.core.c.b(n, "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.t.c() + "] block[" + i + "]");
            } else {
                com.sigmob.sdk.downloader.core.c.b(n, "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.f.isDone() + "] task[" + this.t.c() + "] block[" + i + "]");
            }
            c(i);
        } catch (Throwable th) {
            c(i);
            throw th;
        }
    }

    public void b(int i) {
        com.sigmob.sdk.downloader.core.breakpoint.a b = this.s.b(i);
        if (b.d() == -1 || com.sigmob.sdk.downloader.core.c.a(b.a(), b.d())) {
            return;
        }
        throw new IOException("The current offset on block-info isn't update correct, " + b.a() + " != " + b.d() + " on " + i);
    }

    public boolean c() {
        return this.g != null;
    }

    public void d(int i) {
        this.j.add(Integer.valueOf(i));
    }

    public void e() {
        LockSupport.park();
    }

    public synchronized void a(int i, byte[] bArr, int i2) {
        if (this.e) {
            return;
        }
        e(i).a(bArr, 0, i2);
        long j = i2;
        this.c.addAndGet(j);
        this.b.get(i).addAndGet(j);
        d();
    }

    public void a(long j) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j));
    }

    public void a(StatFs statFs, long j) {
        long a2 = com.sigmob.sdk.downloader.core.c.a(statFs);
        if (a2 < j) {
            throw new com.sigmob.sdk.downloader.core.exception.e(j, a2);
        }
    }

    public void a(a aVar) {
        aVar.c.clear();
        int size = new HashSet((List) this.j.clone()).size();
        if (size != this.k.size()) {
            com.sigmob.sdk.downloader.core.c.b(n, "task[" + this.t.c() + "] current need fetching block count " + this.k.size() + " is not equal to no more stream block count " + size);
            aVar.f13405a = false;
        } else {
            com.sigmob.sdk.downloader.core.c.b(n, "task[" + this.t.c() + "] current need fetching block count " + this.k.size() + " is equal to no more stream block count " + size);
            aVar.f13405a = true;
        }
        SparseArray<com.sigmob.sdk.downloader.core.file.a> clone = this.f13402a.clone();
        int size2 = clone.size();
        for (int i = 0; i < size2; i++) {
            int keyAt = clone.keyAt(i);
            if (this.j.contains(Integer.valueOf(keyAt)) && !aVar.b.contains(Integer.valueOf(keyAt))) {
                aVar.b.add(Integer.valueOf(keyAt));
                aVar.c.add(Integer.valueOf(keyAt));
            }
        }
    }

    public void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    public void a(List<Integer> list) {
        this.k = list;
    }

    public void a(boolean z, int i) {
        if (this.f == null || this.f.isDone()) {
            return;
        }
        if (!z) {
            this.h.put(i, Thread.currentThread());
        }
        if (this.g == null) {
            while (!c()) {
                a(25L);
            }
        }
        a(this.g);
        if (!z) {
            e();
            return;
        }
        a(this.g);
        try {
            this.f.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }
}
