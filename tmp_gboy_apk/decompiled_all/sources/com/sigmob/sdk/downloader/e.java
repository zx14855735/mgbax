package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.core.listener.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e extends com.sigmob.sdk.downloader.core.listener.b implements Runnable {
    static final int e = 0;
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload DynamicSerial", false));
    private static final String i = "DownloadSerialQueue";

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f13420a;
    volatile boolean b;
    volatile boolean c;
    volatile f d;
    com.sigmob.sdk.downloader.core.listener.f f;
    private final ArrayList<f> h;

    static {
        nsKTZfm();
    }

    public e() {
        this(null);
    }

    private static /* synthetic */ void nsKTZfm() {
        char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 197);
        }
        String str = new String(charArray);
        char[] charArray2 = "¦©¬«¬±".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 197);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public synchronized void a() {
        if (this.c) {
            com.sigmob.sdk.downloader.core.c.a(i, "require pause this queue(remain " + this.h.size() + "), butit has already been paused");
            return;
        }
        this.c = true;
        if (this.d != null) {
            this.d.E();
            this.h.add(0, this.d);
            this.d = null;
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a_(f fVar) {
        this.d = fVar;
    }

    public synchronized void b() {
        if (!this.c) {
            com.sigmob.sdk.downloader.core.c.a(i, "require resume this queue(remain " + this.h.size() + "), but it is still running");
            return;
        }
        this.c = false;
        if (!this.h.isEmpty() && !this.b) {
            this.b = true;
            f();
        }
    }

    public int c() {
        if (this.d != null) {
            return this.d.c();
        }
        return 0;
    }

    public int d() {
        return this.h.size();
    }

    public synchronized f[] e() {
        f[] fVarArr;
        try {
            this.f13420a = true;
            if (this.d != null) {
                this.d.E();
            }
            fVarArr = new f[this.h.size()];
            this.h.toArray(fVarArr);
            this.h.clear();
        } catch (Throwable th) {
            throw th;
        }
        return fVarArr;
    }

    public void f() {
        g.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        f remove;
        while (!this.f13420a) {
            synchronized (this) {
                if (!this.h.isEmpty() && !this.c) {
                    remove = this.h.remove(0);
                }
                this.d = null;
                this.b = false;
                return;
            }
            remove.c(this.f);
        }
    }

    public e(c cVar) {
        this(cVar, new ArrayList());
    }

    public void a(c cVar) {
        this.f = new f.a().a(this).a(cVar).a();
    }

    public synchronized void b(f fVar) {
        this.h.add(fVar);
        Collections.sort(this.h);
        if (!this.c && !this.b) {
            this.b = true;
            f();
        }
    }

    public e(c cVar, ArrayList<f> arrayList) {
        this.f13420a = false;
        this.b = false;
        this.c = false;
        this.f = new f.a().a(this).a(cVar).a();
        this.h = arrayList;
    }

    @Override // com.sigmob.sdk.downloader.c
    public synchronized void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar != com.sigmob.sdk.downloader.core.cause.a.CANCELED && fVar == this.d) {
            this.d = null;
        }
    }
}
