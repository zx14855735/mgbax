package com.bytedance.sdk.component.w.hf.xj.kd;

import com.bytedance.sdk.component.w.xj.jk;
import com.bytedance.sdk.component.w.xj.v;
import com.bytedance.sdk.component.w.xj.yo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d {
    static final /* synthetic */ boolean d = true;
    private final hf g;
    long hf;
    final xj kd;
    private List<com.bytedance.sdk.component.w.hf.xj.kd.w> p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10238pl;
    private final List<com.bytedance.sdk.component.w.hf.xj.kd.w> tf;
    final c u;
    final int w;
    long xj = 0;
    final w y = new w();
    final w c = new w();
    com.bytedance.sdk.component.w.hf.xj.kd.hf f = null;

    public class w extends com.bytedance.sdk.component.w.xj.xj {
        public w() {
        }

        public void f() {
            if (hf()) {
                throw hf((IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.xj
        public IOException hf(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.bytedance.sdk.component.w.xj.xj
        public void m_() {
            d.this.hf(com.bytedance.sdk.component.w.hf.xj.kd.hf.CANCEL);
        }
    }

    public d(int i, c cVar, boolean z, boolean z2, List<com.bytedance.sdk.component.w.hf.xj.kd.w> list) {
        if (cVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.w = i;
        this.u = cVar;
        this.hf = cVar.g.u();
        hf hfVar = new hf(cVar.f10237pl.u());
        this.g = hfVar;
        xj xjVar = new xj();
        this.kd = xjVar;
        hfVar.hf = z2;
        xjVar.hf = z;
        this.tf = list;
    }

    public v c() {
        return this.g;
    }

    public void d() {
        boolean hf2;
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.g.hf = true;
            hf2 = hf();
            notifyAll();
        }
        if (hf2) {
            return;
        }
        this.u.hf(this.w);
    }

    public yo f() {
        synchronized (this) {
            try {
                if (!this.f10238pl && !w()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.kd;
    }

    public synchronized boolean hf() {
        try {
            if (this.f != null) {
                return false;
            }
            hf hfVar = this.g;
            if (!hfVar.hf) {
                if (hfVar.xj) {
                }
                return true;
            }
            xj xjVar = this.kd;
            if (xjVar.hf || xjVar.xj) {
                if (this.f10238pl) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public jk kd() {
        return this.y;
    }

    public void p() {
        xj xjVar = this.kd;
        if (xjVar.xj) {
            throw new IOException("stream closed");
        }
        if (xjVar.hf) {
            throw new IOException("stream finished");
        }
        if (this.f != null) {
            throw new qt(this.f);
        }
    }

    public void pl() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public void tf() {
        boolean z;
        boolean hf2;
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                hf hfVar = this.g;
                if (!hfVar.hf && hfVar.xj) {
                    xj xjVar = this.kd;
                    if (!xjVar.hf) {
                        if (xjVar.xj) {
                        }
                    }
                    z = true;
                    hf2 = hf();
                }
                z = false;
                hf2 = hf();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            xj(com.bytedance.sdk.component.w.hf.xj.kd.hf.CANCEL);
        } else {
            if (hf2) {
                return;
            }
            this.u.hf(this.w);
        }
    }

    public synchronized List<com.bytedance.sdk.component.w.hf.xj.kd.w> u() {
        List<com.bytedance.sdk.component.w.hf.xj.kd.w> list;
        if (!w()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.y.xj();
        while (this.p == null && this.f == null) {
            try {
                pl();
            } catch (Throwable th) {
                this.y.f();
                throw th;
            }
        }
        this.y.f();
        list = this.p;
        if (list == null) {
            throw new qt(this.f);
        }
        this.p = null;
        return list;
    }

    public boolean w() {
        return this.u.hf == ((this.w & 1) == 1);
    }

    public int xj() {
        return this.w;
    }

    public jk y() {
        return this.c;
    }

    public void xj(com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        if (u(hfVar)) {
            this.u.hf(this.w, hfVar);
        }
    }

    public synchronized void w(com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        if (this.f == null) {
            this.f = hfVar;
            notifyAll();
        }
    }

    public void xj(List<com.bytedance.sdk.component.w.hf.xj.kd.w> list) {
        boolean z;
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            try {
                this.f10238pl = true;
                if (this.p == null) {
                    this.p = list;
                    z = hf();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.p);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.p = arrayList;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            return;
        }
        this.u.hf(this.w);
    }

    public void hf(com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        if (u(hfVar)) {
            this.u.xj(this.w, hfVar);
        }
    }

    private boolean u(com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.f != null) {
                    return false;
                }
                if (this.g.hf && this.kd.hf) {
                    return false;
                }
                this.f = hfVar;
                notifyAll();
                this.u.hf(this.w);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final class xj implements yo {
        static final /* synthetic */ boolean w = true;
        boolean hf;
        private final com.bytedance.sdk.component.w.xj.w kd = new com.bytedance.sdk.component.w.xj.w();
        boolean xj;

        public xj() {
        }

        private void xj(boolean z) {
            d dVar;
            long min;
            d dVar2;
            synchronized (d.this) {
                d.this.c.xj();
                while (true) {
                    try {
                        dVar = d.this;
                        if (dVar.hf > 0 || this.hf || this.xj || dVar.f != null) {
                            break;
                        } else {
                            dVar.pl();
                        }
                    } finally {
                        d.this.c.f();
                    }
                }
                dVar.c.f();
                d.this.p();
                min = Math.min(d.this.hf, this.kd.hf());
                dVar2 = d.this;
                dVar2.hf -= min;
            }
            dVar2.c.xj();
            try {
                d dVar3 = d.this;
                dVar3.u.xj(dVar3.w, z && min == this.kd.hf(), this.kd, min);
                d.this.c.f();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.yo
        public void a_(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            if (!w && Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            this.kd.a_(wVar, j);
            while (this.kd.hf() >= 16384) {
                xj(false);
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!w && Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            synchronized (d.this) {
                try {
                    if (this.xj) {
                        return;
                    }
                    if (!d.this.kd.hf) {
                        if (this.kd.hf() > 0) {
                            while (this.kd.hf() > 0) {
                                xj(true);
                            }
                        } else {
                            d dVar = d.this;
                            dVar.u.xj(dVar.w, true, (com.bytedance.sdk.component.w.xj.w) null, 0L);
                        }
                    }
                    synchronized (d.this) {
                        this.xj = true;
                    }
                    d.this.u.hf();
                    d.this.tf();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
        public void flush() {
            if (!w && Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            synchronized (d.this) {
                d.this.p();
            }
            while (this.kd.hf() > 0) {
                xj(false);
                d.this.u.hf();
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.yo
        public jk xj() {
            return d.this.c;
        }
    }

    public void xj(com.bytedance.sdk.component.w.xj.kd kdVar, int i) {
        if (!d && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.g.xj(kdVar, i);
    }

    public final class hf implements v {
        static final /* synthetic */ boolean w = true;
        private final long c;
        boolean hf;
        boolean xj;
        private final com.bytedance.sdk.component.w.xj.w kd = new com.bytedance.sdk.component.w.xj.w();
        private final com.bytedance.sdk.component.w.xj.w y = new com.bytedance.sdk.component.w.xj.w();

        public hf(long j) {
            this.c = j;
        }

        private void hf() {
            d.this.y.xj();
            while (this.y.hf() == 0 && !this.hf && !this.xj) {
                try {
                    d dVar = d.this;
                    if (dVar.f != null) {
                        break;
                    } else {
                        dVar.pl();
                    }
                } finally {
                    d.this.y.f();
                }
            }
        }

        private void w() {
            if (this.xj) {
                throw new IOException("stream closed");
            }
            if (d.this.f != null) {
                throw new qt(d.this.f);
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (d.this) {
                this.xj = true;
                this.y.yo();
                d.this.notifyAll();
            }
            d.this.tf();
        }

        @Override // com.bytedance.sdk.component.w.xj.v
        public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (d.this) {
                try {
                    hf();
                    w();
                    if (this.y.hf() == 0) {
                        return -1L;
                    }
                    com.bytedance.sdk.component.w.xj.w wVar2 = this.y;
                    long xj = wVar2.xj(wVar, Math.min(j, wVar2.hf()));
                    d dVar = d.this;
                    long j2 = dVar.xj + xj;
                    dVar.xj = j2;
                    if (j2 >= dVar.u.f10237pl.u() / 2) {
                        d dVar2 = d.this;
                        dVar2.u.xj(dVar2.w, dVar2.xj);
                        d.this.xj = 0L;
                    }
                    synchronized (d.this.u) {
                        try {
                            c cVar = d.this.u;
                            long j3 = cVar.tf + xj;
                            cVar.tf = j3;
                            if (j3 >= cVar.f10237pl.u() / 2) {
                                c cVar2 = d.this.u;
                                cVar2.xj(0, cVar2.tf);
                                d.this.u.tf = 0L;
                            }
                        } finally {
                        }
                    }
                    return xj;
                } finally {
                }
            }
        }

        public void xj(com.bytedance.sdk.component.w.xj.kd kdVar, long j) {
            boolean z;
            boolean z2;
            if (!w && Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (d.this) {
                    z = this.hf;
                    z2 = this.y.hf() + j > this.c;
                }
                if (z2) {
                    kdVar.f(j);
                    d.this.hf(com.bytedance.sdk.component.w.hf.xj.kd.hf.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    kdVar.f(j);
                    return;
                }
                long xj = kdVar.xj(this.kd, j);
                if (xj != -1) {
                    j -= xj;
                    synchronized (d.this) {
                        try {
                            boolean z3 = this.y.hf() == 0;
                            this.y.xj(this.kd);
                            if (z3) {
                                d.this.notifyAll();
                            }
                        } finally {
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.v
        public jk xj() {
            return d.this.y;
        }
    }

    public void xj(long j) {
        this.hf += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
