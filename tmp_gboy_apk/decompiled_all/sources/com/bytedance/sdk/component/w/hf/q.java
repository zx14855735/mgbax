package com.bytedance.sdk.component.w.hf;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.component.w.hf.yo;
import java.io.Closeable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class q implements Closeable {
    final z c;
    final q d;
    final q f;
    private volatile u g;
    final dk hf;
    final e kd;
    final long p;

    /* renamed from: pl, reason: collision with root package name */
    final long f10227pl;
    final q tf;
    final String u;
    final int w;
    final io xj;
    final yo y;

    public static class xj {
        z c;
        q d;
        q f;
        dk hf;
        e kd;
        long p;

        /* renamed from: pl, reason: collision with root package name */
        long f10228pl;
        q tf;
        String u;
        int w;
        io xj;
        yo.xj y;

        public xj() {
            this.w = -1;
            this.y = new yo.xj();
        }

        private void u(q qVar) {
            if (qVar.c != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public xj hf(q qVar) {
            if (qVar != null) {
                xj("cacheResponse", qVar);
            }
            this.d = qVar;
            return this;
        }

        public xj w(q qVar) {
            if (qVar != null) {
                u(qVar);
            }
            this.tf = qVar;
            return this;
        }

        public xj xj(io ioVar) {
            this.xj = ioVar;
            return this;
        }

        public xj xj(dk dkVar) {
            this.hf = dkVar;
            return this;
        }

        public xj hf(long j) {
            this.f10228pl = j;
            return this;
        }

        public xj xj(int i) {
            this.w = i;
            return this;
        }

        public xj(q qVar) {
            this.w = -1;
            this.xj = qVar.xj;
            this.hf = qVar.hf;
            this.w = qVar.w;
            this.u = qVar.u;
            this.kd = qVar.kd;
            this.y = qVar.y.hf();
            this.c = qVar.c;
            this.f = qVar.f;
            this.d = qVar.d;
            this.tf = qVar.tf;
            this.p = qVar.p;
            this.f10228pl = qVar.f10227pl;
        }

        public xj xj(String str) {
            this.u = str;
            return this;
        }

        public xj xj(e eVar) {
            this.kd = eVar;
            return this;
        }

        public xj xj(String str, String str2) {
            this.y.xj(str, str2);
            return this;
        }

        public xj xj(yo yoVar) {
            this.y = yoVar.hf();
            return this;
        }

        public xj xj(z zVar) {
            this.c = zVar;
            return this;
        }

        public xj xj(q qVar) {
            if (qVar != null) {
                xj("networkResponse", qVar);
            }
            this.f = qVar;
            return this;
        }

        private void xj(String str, q qVar) {
            if (qVar.c == null) {
                if (qVar.f == null) {
                    if (qVar.d == null) {
                        if (qVar.tf != null) {
                            throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".priorResponse != null"));
                        }
                        return;
                    }
                    throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".cacheResponse != null"));
                }
                throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".networkResponse != null"));
            }
            throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".body != null"));
        }

        public xj xj(long j) {
            this.p = j;
            return this;
        }

        public q xj() {
            if (this.xj != null) {
                if (this.hf != null) {
                    if (this.w >= 0) {
                        if (this.u != null) {
                            return new q(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.w);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public q(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w;
        this.u = xjVar.u;
        this.kd = xjVar.kd;
        this.y = xjVar.y.xj();
        this.c = xjVar.c;
        this.f = xjVar.f;
        this.d = xjVar.d;
        this.tf = xjVar.tf;
        this.p = xjVar.p;
        this.f10227pl = xjVar.f10228pl;
    }

    public long am() {
        return this.f10227pl;
    }

    public yo c() {
        return this.y;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z zVar = this.c;
        if (zVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        zVar.close();
    }

    public xj d() {
        return new xj(this);
    }

    public z f() {
        return this.c;
    }

    public long g() {
        return this.p;
    }

    public dk hf() {
        return this.hf;
    }

    public String kd() {
        return this.u;
    }

    public q p() {
        return this.tf;
    }

    public u pl() {
        u uVar = this.g;
        if (uVar != null) {
            return uVar;
        }
        u xj2 = u.xj(this.y);
        this.g = xj2;
        return xj2;
    }

    public ai qt() {
        io ioVar = this.xj;
        if (ioVar == null) {
            return null;
        }
        return ioVar.y;
    }

    public q tf() {
        return this.f;
    }

    public String toString() {
        return "Response{protocol=" + this.hf + ", code=" + this.w + ", message=" + this.u + ", url=" + this.xj.xj() + '}';
    }

    public boolean u() {
        int i = this.w;
        return i >= 200 && i < 300;
    }

    public int w() {
        return this.w;
    }

    public io xj() {
        return this.xj;
    }

    public e y() {
        return this.kd;
    }

    public String xj(String str) {
        return xj(str, null);
    }

    public String xj(String str, String str2) {
        String xj2 = this.y.xj(str);
        return xj2 != null ? xj2 : str2;
    }
}
