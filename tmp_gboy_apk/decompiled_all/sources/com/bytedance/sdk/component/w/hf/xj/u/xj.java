package com.bytedance.sdk.component.w.hf.xj.u;

import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.ra;
import com.bytedance.sdk.component.w.hf.v;
import com.bytedance.sdk.component.w.hf.xj.hf.c;
import com.bytedance.sdk.component.w.hf.xj.w.f;
import com.bytedance.sdk.component.w.hf.xj.w.p;
import com.bytedance.sdk.component.w.hf.yo;
import com.bytedance.sdk.component.w.hf.z;
import com.bytedance.sdk.component.w.xj.d;
import com.bytedance.sdk.component.w.xj.jk;
import com.bytedance.sdk.component.w.xj.pl;
import com.bytedance.sdk.component.w.xj.yo;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj implements com.bytedance.sdk.component.w.hf.xj.w.w {
    final c hf;
    final com.bytedance.sdk.component.w.xj.u u;
    final com.bytedance.sdk.component.w.xj.kd w;
    final ra xj;
    int kd = 0;
    private long y = 262144;

    public final class hf implements yo {
        private final d hf;
        private boolean w;

        public hf() {
            this.hf = new d(xj.this.u.xj());
        }

        @Override // com.bytedance.sdk.component.w.xj.yo
        public void a_(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            if (this.w) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            xj.this.u.p(j);
            xj.this.u.hf("\r\n");
            xj.this.u.a_(wVar, j);
            xj.this.u.hf("\r\n");
        }

        @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.w) {
                return;
            }
            this.w = true;
            xj.this.u.hf("0\r\n\r\n");
            xj.this.xj(this.hf);
            xj.this.kd = 3;
        }

        @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
        public synchronized void flush() {
            if (this.w) {
                return;
            }
            xj.this.u.flush();
        }

        @Override // com.bytedance.sdk.component.w.xj.yo
        public jk xj() {
            return this.hf;
        }
    }

    public class kd extends AbstractC0124xj {
        private long y;

        public kd(long j) {
            super();
            this.y = j;
            if (j == 0) {
                xj(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.hf) {
                return;
            }
            if (this.y != 0 && !com.bytedance.sdk.component.w.hf.xj.w.xj(this, 100, TimeUnit.MILLISECONDS)) {
                xj(false, (IOException) null);
            }
            this.hf = true;
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.u.xj.AbstractC0124xj, com.bytedance.sdk.component.w.xj.v
        public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hf) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.y;
            if (j2 == 0) {
                return -1L;
            }
            long xj = super.xj(wVar, Math.min(j2, j));
            if (xj == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                xj(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.y - xj;
            this.y = j3;
            if (j3 == 0) {
                xj(true, (IOException) null);
            }
            return xj;
        }
    }

    public final class u implements yo {
        private final d hf;
        private long u;
        private boolean w;

        public u(long j) {
            this.hf = new d(xj.this.u.xj());
            this.u = j;
        }

        @Override // com.bytedance.sdk.component.w.xj.yo
        public void a_(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            if (this.w) {
                throw new IllegalStateException("closed");
            }
            com.bytedance.sdk.component.w.hf.xj.w.xj(wVar.hf(), 0L, j);
            if (j <= this.u) {
                xj.this.u.a_(wVar, j);
                this.u -= j;
            } else {
                throw new ProtocolException("expected " + this.u + " bytes but received " + j);
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.w) {
                return;
            }
            this.w = true;
            if (this.u > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            xj.this.xj(this.hf);
            xj.this.kd = 3;
        }

        @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
        public void flush() {
            if (this.w) {
                return;
            }
            xj.this.u.flush();
        }

        @Override // com.bytedance.sdk.component.w.xj.yo
        public jk xj() {
            return this.hf;
        }
    }

    public class w extends AbstractC0124xj {
        private long c;
        private boolean f;
        private final v y;

        public w(v vVar) {
            super();
            this.c = -1L;
            this.f = true;
            this.y = vVar;
        }

        private void hf() {
            if (this.c != -1) {
                xj.this.w.zg();
            }
            try {
                this.c = xj.this.w.g();
                String trim = xj.this.w.zg().trim();
                if (this.c < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.c + trim + "\"");
                }
                if (this.c == 0) {
                    this.f = false;
                    com.bytedance.sdk.component.w.hf.xj.w.kd.xj(xj.this.xj.y(), this.y, xj.this.u());
                    xj(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.hf) {
                return;
            }
            if (this.f && !com.bytedance.sdk.component.w.hf.xj.w.xj(this, 100, TimeUnit.MILLISECONDS)) {
                xj(false, (IOException) null);
            }
            this.hf = true;
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.u.xj.AbstractC0124xj, com.bytedance.sdk.component.w.xj.v
        public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hf) {
                throw new IllegalStateException("closed");
            }
            if (!this.f) {
                return -1L;
            }
            long j2 = this.c;
            if (j2 == 0 || j2 == -1) {
                hf();
                if (!this.f) {
                    return -1L;
                }
            }
            long xj = super.xj(wVar, Math.min(j, this.c));
            if (xj != -1) {
                this.c -= xj;
                return xj;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            xj(false, (IOException) protocolException);
            throw protocolException;
        }
    }

    /* renamed from: com.bytedance.sdk.component.w.hf.xj.u.xj$xj, reason: collision with other inner class name */
    public abstract class AbstractC0124xj implements com.bytedance.sdk.component.w.xj.v {
        protected boolean hf;
        protected long w;
        protected final d xj;

        private AbstractC0124xj() {
            this.xj = new d(xj.this.w.xj());
            this.w = 0L;
        }

        @Override // com.bytedance.sdk.component.w.xj.v
        public jk xj() {
            return this.xj;
        }

        @Override // com.bytedance.sdk.component.w.xj.v
        public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            try {
                long xj = xj.this.w.xj(wVar, j);
                if (xj <= 0) {
                    return xj;
                }
                this.w += xj;
                return xj;
            } catch (IOException e) {
                xj(false, e);
                throw e;
            }
        }

        public final void xj(boolean z, IOException iOException) {
            xj xjVar = xj.this;
            int i = xjVar.kd;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                xjVar.xj(this.xj);
                xj xjVar2 = xj.this;
                xjVar2.kd = 6;
                c cVar = xjVar2.hf;
                if (cVar != null) {
                    cVar.xj(!z, xjVar2, this.w, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + xj.this.kd);
        }
    }

    public class y extends AbstractC0124xj {
        private boolean y;

        public y() {
            super();
        }

        @Override // com.bytedance.sdk.component.w.xj.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.hf) {
                return;
            }
            if (!this.y) {
                xj(false, (IOException) null);
            }
            this.hf = true;
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.u.xj.AbstractC0124xj, com.bytedance.sdk.component.w.xj.v
        public long xj(com.bytedance.sdk.component.w.xj.w wVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.hf) {
                throw new IllegalStateException("closed");
            }
            if (this.y) {
                return -1L;
            }
            long xj = super.xj(wVar, j);
            if (xj != -1) {
                return xj;
            }
            this.y = true;
            xj(true, (IOException) null);
            return -1L;
        }
    }

    public xj(ra raVar, c cVar, com.bytedance.sdk.component.w.xj.kd kdVar, com.bytedance.sdk.component.w.xj.u uVar) {
        this.xj = raVar;
        this.hf = cVar;
        this.w = kdVar;
        this.u = uVar;
    }

    private String c() {
        String kd2 = this.w.kd(this.y);
        this.y -= kd2.length();
        return kd2;
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void hf() {
        this.u.flush();
    }

    public yo kd() {
        if (this.kd == 1) {
            this.kd = 2;
            return new hf();
        }
        throw new IllegalStateException("state: " + this.kd);
    }

    public com.bytedance.sdk.component.w.hf.yo u() {
        yo.xj xjVar = new yo.xj();
        while (true) {
            String c = c();
            if (c.length() == 0) {
                return xjVar.xj();
            }
            com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(xjVar, c);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void w() {
        com.bytedance.sdk.component.w.hf.xj.hf.w hf2 = this.hf.hf();
        if (hf2 != null) {
            hf2.hf();
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public com.bytedance.sdk.component.w.xj.yo xj(io ioVar, long j) {
        if ("chunked".equalsIgnoreCase(ioVar.xj(com.sigmob.sdk.downloader.core.c.h))) {
            return kd();
        }
        if (j != -1) {
            return xj(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public com.bytedance.sdk.component.w.xj.v y() {
        if (this.kd != 4) {
            throw new IllegalStateException("state: " + this.kd);
        }
        c cVar = this.hf;
        if (cVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.kd = 5;
        cVar.u();
        return new y();
    }

    public com.bytedance.sdk.component.w.xj.v hf(long j) {
        if (this.kd == 4) {
            this.kd = 5;
            return new kd(j);
        }
        throw new IllegalStateException("state: " + this.kd);
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void xj(io ioVar) {
        xj(ioVar.w(), com.bytedance.sdk.component.w.hf.xj.w.d.xj(ioVar, this.hf.hf().xj().hf().type()));
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public z xj(q qVar) {
        String xj = qVar.xj("Content-Type");
        if (!com.bytedance.sdk.component.w.hf.xj.w.kd.w(qVar)) {
            return new f(xj, 0L, pl.xj(hf(0L)));
        }
        if ("chunked".equalsIgnoreCase(qVar.xj(com.sigmob.sdk.downloader.core.c.h))) {
            return new f(xj, -1L, pl.xj(xj(qVar.xj().xj())));
        }
        long xj2 = com.bytedance.sdk.component.w.hf.xj.w.kd.xj(qVar);
        if (xj2 != -1) {
            return new f(xj, xj2, pl.xj(hf(xj2)));
        }
        return new f(xj, -1L, pl.xj(y()));
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public void xj() {
        this.u.flush();
    }

    public void xj(com.bytedance.sdk.component.w.hf.yo yoVar, String str) {
        if (this.kd == 0) {
            this.u.hf(str).hf("\r\n");
            int xj = yoVar.xj();
            for (int i = 0; i < xj; i++) {
                this.u.hf(yoVar.xj(i)).hf(": ").hf(yoVar.hf(i)).hf("\r\n");
            }
            this.u.hf("\r\n");
            this.kd = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.kd);
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.w.w
    public q.xj xj(boolean z) {
        int i = this.kd;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.kd);
        }
        try {
            p xj = p.xj(c());
            q.xj xj2 = new q.xj().xj(xj.xj).xj(xj.hf).xj(xj.w).xj(u());
            if (z && xj.hf == 100) {
                return null;
            }
            this.kd = 4;
            return xj2;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.hf);
            iOException.initCause(e);
            throw iOException;
        }
    }

    public com.bytedance.sdk.component.w.xj.yo xj(long j) {
        if (this.kd == 1) {
            this.kd = 2;
            return new u(j);
        }
        throw new IllegalStateException("state: " + this.kd);
    }

    public com.bytedance.sdk.component.w.xj.v xj(v vVar) {
        if (this.kd == 4) {
            this.kd = 5;
            return new w(vVar);
        }
        throw new IllegalStateException("state: " + this.kd);
    }

    public void xj(d dVar) {
        jk xj = dVar.xj();
        dVar.xj(jk.w);
        xj.y();
        xj.kd();
    }
}
