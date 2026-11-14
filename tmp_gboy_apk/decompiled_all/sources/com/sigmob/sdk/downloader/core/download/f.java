package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f implements Runnable {
    private static final ExecutorService h = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Cancel Block", false));
    private static final String i = "DownloadChain";
    long e;
    volatile Thread f;
    private final int j;
    private final com.sigmob.sdk.downloader.f k;
    private final com.sigmob.sdk.downloader.core.breakpoint.c l;
    private final d m;
    private long n;
    private volatile com.sigmob.sdk.downloader.core.connection.a o;
    private final j q;

    /* renamed from: a, reason: collision with root package name */
    final List<c.a> f13390a = new ArrayList();
    final List<c.b> b = new ArrayList();
    int c = 0;
    int d = 0;
    final AtomicBoolean g = new AtomicBoolean(false);
    private final Runnable r = new Runnable() { // from class: com.sigmob.sdk.downloader.core.download.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.m();
        }
    };
    private final com.sigmob.sdk.downloader.core.dispatcher.a p = com.sigmob.sdk.downloader.g.j().b();

    static {
        ULcMrjN();
    }

    private f(int i2, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, d dVar, j jVar) {
        this.j = i2;
        this.k = fVar;
        this.m = dVar;
        this.l = cVar;
        this.q = jVar;
    }

    private static /* synthetic */ void ULcMrjN() {
        char[] charArray = "ùõ÷´ýû÷ÿ´øõã´éòÿöö´ÐôóØèóþýÿ".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 154);
        }
        String str = new String(charArray);
        char[] charArray2 = "ùöóôóî".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 154);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public long a() {
        return this.n;
    }

    public void b() {
        if (this.g.get() || this.f == null) {
            return;
        }
        this.f.interrupt();
    }

    public com.sigmob.sdk.downloader.f c() {
        return this.k;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.c d() {
        return this.l;
    }

    public int e() {
        return this.j;
    }

    public d f() {
        return this.m;
    }

    public com.sigmob.sdk.downloader.core.file.d g() {
        return this.m.a();
    }

    public synchronized com.sigmob.sdk.downloader.core.connection.a h() {
        return this.o;
    }

    public synchronized com.sigmob.sdk.downloader.core.connection.a i() {
        try {
            if (this.m.k()) {
                throw com.sigmob.sdk.downloader.core.exception.c.f13396a;
            }
            if (this.o == null) {
                String b = this.m.b();
                if (b == null) {
                    b = this.l.l();
                }
                com.sigmob.sdk.downloader.core.c.b(i, "create connection on url: " + b);
                this.o = com.sigmob.sdk.downloader.g.j().d().a(b);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.o;
    }

    public void j() {
        if (this.e == 0) {
            return;
        }
        this.p.a().b(this.k, this.j, this.e);
        this.e = 0L;
    }

    public void k() {
        com.sigmob.sdk.downloader.core.dispatcher.a b = com.sigmob.sdk.downloader.g.j().b();
        com.sigmob.sdk.downloader.core.interceptor.d dVar = new com.sigmob.sdk.downloader.core.interceptor.d();
        com.sigmob.sdk.downloader.core.interceptor.a aVar = new com.sigmob.sdk.downloader.core.interceptor.a();
        this.f13390a.add(dVar);
        this.f13390a.add(aVar);
        this.f13390a.add(new com.sigmob.sdk.downloader.core.interceptor.connect.b());
        this.f13390a.add(new com.sigmob.sdk.downloader.core.interceptor.connect.a());
        this.c = 0;
        a.InterfaceC0451a n = n();
        if (this.m.k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f13396a;
        }
        b.a().a(this.k, this.j, a());
        com.sigmob.sdk.downloader.core.interceptor.b bVar = new com.sigmob.sdk.downloader.core.interceptor.b(this.j, n.e(), g(), this.k);
        this.b.add(dVar);
        this.b.add(aVar);
        this.b.add(bVar);
        this.d = 0;
        b.a().c(this.k, this.j, o());
    }

    public void l() {
        this.c = 1;
        m();
    }

    public synchronized void m() {
        try {
            if (this.o != null) {
                this.o.b();
                com.sigmob.sdk.downloader.core.c.b(i, "release connection " + this.o + " task[" + this.k.c() + "] block[" + this.j + "]");
            }
            this.o = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public a.InterfaceC0451a n() {
        if (this.m.k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f13396a;
        }
        List<c.a> list = this.f13390a;
        int i2 = this.c;
        this.c = i2 + 1;
        return list.get(i2).a(this);
    }

    public long o() {
        if (this.m.k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f13396a;
        }
        List<c.b> list = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        return list.get(i2).b(this);
    }

    public long p() {
        if (this.d == this.b.size()) {
            this.d--;
        }
        return o();
    }

    public boolean q() {
        return this.g.get();
    }

    public j r() {
        return this.q;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (q()) {
            throw new IllegalAccessError("The chain has been finished!");
        }
        this.f = Thread.currentThread();
        try {
            k();
        } catch (IOException unused) {
        } finally {
            this.g.set(true);
            s();
        }
    }

    public void s() {
        h.execute(this.r);
    }

    public static f a(int i2, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, d dVar, j jVar) {
        return new f(i2, fVar, cVar, dVar, jVar);
    }

    public void b(long j) {
        this.e += j;
    }

    public void a(long j) {
        this.n = j;
    }

    public synchronized void a(com.sigmob.sdk.downloader.core.connection.a aVar) {
        this.o = aVar;
    }

    public void a(String str) {
        this.m.a(str);
    }
}
