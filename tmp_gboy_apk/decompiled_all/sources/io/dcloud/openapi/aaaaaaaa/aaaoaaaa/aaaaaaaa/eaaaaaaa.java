package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaacaaaa;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class eaaaaaaa {
    static final /* synthetic */ boolean aaaaaaav = true;
    private ExecutorService aaaaaaac;
    private Runnable aaaaaaao;
    private int aaaaaaaa = 64;
    private int aaaaaaa0 = 5;
    private final Deque aaaaaaau = new ArrayDeque();
    private final Deque aaaaaaan = new ArrayDeque();
    private final Deque aaaaaaae = new ArrayDeque();

    private boolean aaaaaaa0() {
        int i;
        boolean z;
        if (!aaaaaaav && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.aaaaaaau.iterator();
                while (it.hasNext()) {
                    aaacaaaa.aaaaaaao aaaaaaaoVar = (aaacaaaa.aaaaaaao) it.next();
                    if (this.aaaaaaan.size() >= this.aaaaaaaa) {
                        break;
                    }
                    if (aaaaaaao(aaaaaaaoVar) < this.aaaaaaa0) {
                        it.remove();
                        arrayList.add(aaaaaaaoVar);
                        this.aaaaaaan.add(aaaaaaaoVar);
                    }
                }
                z = aaaaaaao() > 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((aaacaaaa.aaaaaaao) arrayList.get(i)).aaaaaaaa(aaaaaaaa());
        }
        return z;
    }

    private int aaaaaaao(aaacaaaa.aaaaaaao aaaaaaaoVar) {
        int i = 0;
        for (aaacaaaa.aaaaaaao aaaaaaaoVar2 : this.aaaaaaan) {
            if (!aaaaaaaoVar2.aaaaaaao().aaaaaaan && aaaaaaaoVar2.aaaaaaac().equals(aaaaaaaoVar.aaaaaaac())) {
                i++;
            }
        }
        return i;
    }

    public synchronized ExecutorService aaaaaaaa() {
        try {
            if (this.aaaaaaac == null) {
                this.aaaaaaac = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.aaaaaaac;
    }

    public synchronized int aaaaaaao() {
        return this.aaaaaaan.size() + this.aaaaaaae.size();
    }

    public void aaaaaaaa(aaacaaaa.aaaaaaao aaaaaaaoVar) {
        synchronized (this) {
            this.aaaaaaau.add(aaaaaaaoVar);
        }
        aaaaaaa0();
    }

    private void aaaaaaaa(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(obj)) {
                runnable = this.aaaaaaao;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (aaaaaaa0() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void aaaaaaa0(aaacaaaa.aaaaaaao aaaaaaaoVar) {
        aaaaaaaa(this.aaaaaaan, aaaaaaaoVar);
    }
}
