package com.bytedance.sdk.component.w.hf.xj.hf;

import com.bytedance.sdk.component.w.hf.j;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.ra;
import com.bytedance.sdk.component.w.hf.tf;
import com.bytedance.sdk.component.w.hf.xj.hf.y;
import com.bytedance.sdk.component.w.hf.xj.kd.qt;
import com.bytedance.sdk.component.w.hf.zg;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    static final /* synthetic */ boolean u = true;
    private boolean am;
    private final tf c;
    private final y d;
    private final Object f;
    private boolean g;
    public final com.bytedance.sdk.component.w.hf.kd hf;
    private y.xj kd;
    private w p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10235pl;
    private com.bytedance.sdk.component.w.hf.xj.w.w qt;
    private int tf;
    public final zg w;
    public final com.bytedance.sdk.component.w.hf.xj xj;
    private j y;

    public static final class xj extends WeakReference<c> {
        public final Object xj;

        public xj(c cVar, Object obj) {
            super(cVar);
            this.xj = obj;
        }
    }

    public c(tf tfVar, com.bytedance.sdk.component.w.hf.xj xjVar, com.bytedance.sdk.component.w.hf.kd kdVar, zg zgVar, Object obj) {
        this.c = tfVar;
        this.xj = xjVar;
        this.hf = kdVar;
        this.w = zgVar;
        this.d = new y(xjVar, f(), kdVar, zgVar);
        this.f = obj;
    }

    private Socket c() {
        if (!u && !Thread.holdsLock(this.c)) {
            throw new AssertionError();
        }
        w wVar = this.p;
        if (wVar == null || !wVar.xj) {
            return null;
        }
        return xj(false, false, true);
    }

    private u f() {
        return com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(this.c);
    }

    public synchronized w hf() {
        return this.p;
    }

    public void kd() {
        com.bytedance.sdk.component.w.hf.xj.w.w wVar;
        w wVar2;
        synchronized (this.c) {
            this.am = true;
            wVar = this.qt;
            wVar2 = this.p;
        }
        if (wVar != null) {
            wVar.w();
        } else if (wVar2 != null) {
            wVar2.hf();
        }
    }

    public String toString() {
        w hf = hf();
        return hf != null ? hf.toString() : this.xj.toString();
    }

    public void u() {
        Socket xj2;
        synchronized (this.c) {
            xj2 = xj(true, false, false);
        }
        com.bytedance.sdk.component.w.hf.xj.w.xj(xj2);
    }

    public void w() {
        Socket xj2;
        synchronized (this.c) {
            xj2 = xj(false, true, false);
        }
        com.bytedance.sdk.component.w.hf.xj.w.xj(xj2);
    }

    public com.bytedance.sdk.component.w.hf.xj.w.w xj(ra raVar, jk.xj xjVar, boolean z) {
        try {
            com.bytedance.sdk.component.w.hf.xj.w.w xj2 = xj(xjVar.hf(), xjVar.w(), xjVar.u(), raVar.yo(), z).xj(raVar, xjVar, this);
            synchronized (this.c) {
                this.qt = xj2;
            }
            return xj2;
        } catch (IOException e) {
            throw new kd(e);
        }
    }

    public boolean y() {
        if (this.y != null) {
            return true;
        }
        y.xj xjVar = this.kd;
        return (xjVar != null && xjVar.xj()) || this.d.xj();
    }

    private void hf(w wVar) {
        int size = wVar.u.size();
        for (int i = 0; i < size; i++) {
            if (wVar.u.get(i).get() == this) {
                wVar.u.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private w xj(int i, int i2, int i3, boolean z, boolean z2) {
        while (true) {
            w xj2 = xj(i, i2, i3, z);
            synchronized (this.c) {
                try {
                    if (xj2.hf == 0) {
                        return xj2;
                    }
                    if (xj2.xj(z2)) {
                        return xj2;
                    }
                    u();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private w xj(int i, int i2, int i3, boolean z) {
        Socket c;
        w wVar;
        Socket socket;
        j jVar;
        boolean z2;
        boolean z3;
        w wVar2;
        y.xj xjVar;
        synchronized (this.c) {
            try {
                if (!this.g) {
                    if (this.qt == null) {
                        if (!this.am) {
                            c = c();
                            wVar = this.p;
                            socket = null;
                            if (wVar == null) {
                                wVar = null;
                            }
                            if (wVar == null) {
                                com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(this.c, this.xj, this, null);
                                w wVar3 = this.p;
                                if (wVar3 != null) {
                                    wVar = wVar3;
                                    z2 = true;
                                    jVar = null;
                                } else {
                                    jVar = this.y;
                                }
                            } else {
                                jVar = null;
                            }
                            z2 = false;
                        } else {
                            throw new IOException("Canceled");
                        }
                    } else {
                        throw new IllegalStateException("codec != null");
                    }
                } else {
                    throw new IllegalStateException("released");
                }
            } finally {
            }
        }
        com.bytedance.sdk.component.w.hf.xj.w.xj(c);
        if (wVar != null) {
            return wVar;
        }
        if (jVar != null || ((xjVar = this.kd) != null && xjVar.xj())) {
            z3 = false;
        } else {
            this.kd = this.d.hf();
            z3 = true;
        }
        synchronized (this.c) {
            try {
                if (this.am) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    List<j> w = this.kd.w();
                    int size = w.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        }
                        j jVar2 = w.get(i4);
                        com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(this.c, this.xj, this, jVar2);
                        w wVar4 = this.p;
                        if (wVar4 != null) {
                            this.y = jVar2;
                            wVar = wVar4;
                            z2 = true;
                            break;
                        }
                        i4++;
                    }
                }
                if (!z2) {
                    if (jVar == null) {
                        jVar = this.kd.hf();
                    }
                    this.y = jVar;
                    this.tf = 0;
                    wVar = new w(this.c, jVar);
                    xj(wVar, false);
                }
                wVar2 = wVar;
            } finally {
            }
        }
        if (z2) {
            return wVar2;
        }
        wVar2.xj(i, i2, i3, z, this.hf, this.w);
        f().hf(wVar2.xj());
        synchronized (this.c) {
            try {
                this.f10235pl = true;
                com.bytedance.sdk.component.w.hf.xj.xj.xj.hf(this.c, wVar2);
                if (wVar2.kd()) {
                    socket = com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(this.c, this.xj, this);
                    wVar2 = this.p;
                }
            } finally {
            }
        }
        com.bytedance.sdk.component.w.hf.xj.w.xj(socket);
        return wVar2;
    }

    public void xj(boolean z, com.bytedance.sdk.component.w.hf.xj.w.w wVar, long j, IOException iOException) {
        Socket xj2;
        synchronized (this.c) {
            if (wVar != null) {
                try {
                    if (wVar == this.qt) {
                        if (!z) {
                            this.p.hf++;
                        }
                        xj2 = xj(z, false, true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.qt + " but was " + wVar);
        }
        com.bytedance.sdk.component.w.hf.xj.w.xj(xj2);
        if (iOException != null) {
            this.w.xj(this.hf, iOException);
        }
    }

    public com.bytedance.sdk.component.w.hf.xj.w.w xj() {
        com.bytedance.sdk.component.w.hf.xj.w.w wVar;
        synchronized (this.c) {
            wVar = this.qt;
        }
        return wVar;
    }

    private Socket xj(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (!u && !Thread.holdsLock(this.c)) {
            throw new AssertionError();
        }
        if (z3) {
            this.qt = null;
        }
        if (z2) {
            this.g = true;
        }
        w wVar = this.p;
        if (wVar != null) {
            if (z) {
                wVar.xj = true;
            }
            if (this.qt == null && (this.g || wVar.xj)) {
                hf(wVar);
                if (this.p.u.isEmpty()) {
                    this.p.kd = System.nanoTime();
                    if (com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(this.c, this.p)) {
                        socket = this.p.w();
                        this.p = null;
                        return socket;
                    }
                }
                socket = null;
                this.p = null;
                return socket;
            }
        }
        return null;
    }

    public void xj(IOException iOException) {
        boolean z;
        Socket xj2;
        synchronized (this.c) {
            try {
                if (iOException instanceof qt) {
                    com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar = ((qt) iOException).xj;
                    com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar2 = com.bytedance.sdk.component.w.hf.xj.kd.hf.REFUSED_STREAM;
                    if (hfVar == hfVar2) {
                        this.tf++;
                    }
                    if (hfVar != hfVar2 || this.tf > 1) {
                        this.y = null;
                        z = true;
                    }
                    z = false;
                } else {
                    w wVar = this.p;
                    if (wVar != null && (!wVar.kd() || (iOException instanceof com.bytedance.sdk.component.w.hf.xj.kd.xj))) {
                        if (this.p.hf == 0) {
                            j jVar = this.y;
                            if (jVar != null && iOException != null) {
                                this.d.xj(jVar, iOException);
                            }
                            this.y = null;
                        }
                        z = true;
                    }
                    z = false;
                }
                xj2 = xj(z, false, true);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.bytedance.sdk.component.w.hf.xj.w.xj(xj2);
    }

    public void xj(w wVar, boolean z) {
        if (!u && !Thread.holdsLock(this.c)) {
            throw new AssertionError();
        }
        if (this.p == null) {
            this.p = wVar;
            this.f10235pl = z;
            wVar.u.add(new xj(this, this.f));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket xj(w wVar) {
        if (!u && !Thread.holdsLock(this.c)) {
            throw new AssertionError();
        }
        if (this.qt == null && this.p.u.size() == 1) {
            Reference<c> reference = this.p.u.get(0);
            Socket xj2 = xj(true, false, false);
            this.p = wVar;
            wVar.u.add(reference);
            return xj2;
        }
        throw new IllegalStateException();
    }
}
