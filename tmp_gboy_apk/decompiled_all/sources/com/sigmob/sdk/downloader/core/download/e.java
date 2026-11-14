package com.sigmob.sdk.downloader.core.download;

import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e extends com.sigmob.sdk.downloader.core.b implements Comparable<e> {
    static final int b = 3;
    private static final ExecutorService j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Block", false));
    private static final String k = "DownloadCall";
    public final com.sigmob.sdk.downloader.f c;
    public final boolean d;
    final ArrayList<f> e;
    volatile d f;
    volatile boolean g;
    volatile boolean h;
    volatile Thread i;
    private final j l;

    static {
        XgHFdv();
    }

    private e(com.sigmob.sdk.downloader.f fVar, boolean z, j jVar) {
        this(fVar, z, new ArrayList(), jVar);
    }

    private static /* synthetic */ void XgHFdv() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void h() {
        this.l.d(this.c.c());
        com.sigmob.sdk.downloader.g.j().b().a().a_(this.c);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return eVar.f() - f();
    }

    public b b(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new b(this.c, cVar);
    }

    public void c(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        f.c.a(this.c, cVar);
    }

    public boolean d() {
        return this.g;
    }

    public boolean e() {
        return this.h;
    }

    public int f() {
        return this.c.G();
    }

    public File g() {
        return this.c.m();
    }

    public e(com.sigmob.sdk.downloader.f fVar, boolean z, ArrayList<f> arrayList, j jVar) {
        super("download call: " + fVar.c());
        this.c = fVar;
        this.d = z;
        this.e = arrayList;
        this.l = jVar;
    }

    public a a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j2) {
        return new a(this.c, cVar, j2);
    }

    @Override // com.sigmob.sdk.downloader.core.b
    public void b() {
        com.sigmob.sdk.downloader.g.j().a().c(this);
        com.sigmob.sdk.downloader.core.c.b(k, "call is finished " + this.c.c());
    }

    public boolean c() {
        synchronized (this) {
            try {
                if (this.g) {
                    return true;
                }
                if (this.h) {
                    return false;
                }
                this.g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                com.sigmob.sdk.downloader.g.j().a().b(this);
                d dVar = this.f;
                if (dVar != null) {
                    dVar.l();
                }
                Object[] array = this.e.toArray();
                if (array != null && array.length != 0) {
                    for (Object obj : array) {
                        if (obj instanceof f) {
                            ((f) obj).b();
                        }
                    }
                } else if (this.i != null) {
                    com.sigmob.sdk.downloader.core.c.b(k, "interrupt thread with cancel operation because of chains are not running " + this.c.c());
                    this.i.interrupt();
                }
                if (dVar != null) {
                    dVar.a().a();
                }
                com.sigmob.sdk.downloader.core.c.b(k, "cancel task " + this.c.c() + " consume: " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public d a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new d(com.sigmob.sdk.downloader.g.j().f().a(this.c, cVar, this.l));
    }

    public static e a(com.sigmob.sdk.downloader.f fVar, boolean z, j jVar) {
        return new e(fVar, z, jVar);
    }

    public Future<?> a(f fVar) {
        return j.submit(fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0164 A[EDGE_INSN: B:36:0x0164->B:37:0x0164 BREAK  A[LOOP:0: B:2:0x0013->B:60:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[LOOP:0: B:2:0x0013->B:60:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164 A[EDGE_INSN: B:64:0x0164->B:37:0x0164 BREAK  A[LOOP:0: B:2:0x0013->B:60:?], SYNTHETIC] */
    @Override // com.sigmob.sdk.downloader.core.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.download.e.a():void");
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, b bVar, com.sigmob.sdk.downloader.core.cause.b bVar2) {
        com.sigmob.sdk.downloader.core.c.a(this.c, cVar, bVar.e(), bVar.d());
        com.sigmob.sdk.downloader.g.j().b().a().a(this.c, cVar, bVar2);
    }

    public void a(d dVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        int g = cVar.g();
        ArrayList arrayList = new ArrayList(cVar.g());
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < g; i++) {
            com.sigmob.sdk.downloader.core.breakpoint.a b2 = cVar.b(i);
            if (!com.sigmob.sdk.downloader.core.c.a(b2.a(), b2.d())) {
                com.sigmob.sdk.downloader.core.c.a(b2);
                f a2 = f.a(i, this.c, cVar, dVar, this.l);
                arrayList.add(a2);
                arrayList2.add(Integer.valueOf(a2.e()));
            }
        }
        if (this.g) {
            return;
        }
        dVar.a().a(arrayList2);
        a(arrayList);
    }

    private void a(d dVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.CANCELED) {
            throw new IllegalAccessError("can't recognize cancelled on here");
        }
        synchronized (this) {
            try {
                if (this.g) {
                    return;
                }
                this.h = true;
                this.l.a(this.c.c(), aVar, exc);
                if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
                    this.l.g(this.c.c());
                    com.sigmob.sdk.downloader.g.j().f().a(dVar.a(), this.c);
                }
                com.sigmob.sdk.downloader.g.j().b().a().a(this.c, aVar, exc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.sigmob.sdk.downloader.core.b
    public void a(InterruptedException interruptedException) {
    }

    public void a(List<f> list) {
        ArrayList arrayList = new ArrayList(list.size());
        try {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            this.e.addAll(list);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Future future = (Future) it2.next();
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException | ExecutionException unused) {
                    }
                }
            }
            this.e.removeAll(list);
        } catch (Throwable th) {
            try {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((Future) it3.next()).cancel(true);
                }
                throw th;
            } finally {
                this.e.removeAll(list);
            }
        }
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar) {
        return this.c.equals(fVar);
    }
}
