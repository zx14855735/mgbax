package com.bytedance.sdk.component.w.hf.xj.hf;

import com.bytedance.sdk.component.w.hf.d;
import com.bytedance.sdk.component.w.hf.dk;
import com.bytedance.sdk.component.w.hf.e;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.j;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.p;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.ra;
import com.bytedance.sdk.component.w.hf.tf;
import com.bytedance.sdk.component.w.hf.v;
import com.bytedance.sdk.component.w.hf.xj.kd.c;
import com.bytedance.sdk.component.w.hf.zg;
import com.bytedance.sdk.component.w.xj.pl;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class w extends c.hf implements d {
    private com.bytedance.sdk.component.w.xj.kd am;
    private final tf c;
    private Socket d;
    private final j f;
    private com.bytedance.sdk.component.w.hf.xj.kd.c g;
    public int hf;
    private e p;

    /* renamed from: pl, reason: collision with root package name */
    private dk f10236pl;
    private com.bytedance.sdk.component.w.xj.u qt;
    private Socket tf;
    public boolean xj;
    public int w = 1;
    public final List<Reference<c>> u = new ArrayList();
    public long kd = Long.MAX_VALUE;

    public w(tf tfVar, j jVar) {
        this.c = tfVar;
        this.f = jVar;
    }

    private io y() {
        return new io.xj().xj(this.f.xj().xj()).xj("Host", com.bytedance.sdk.component.w.hf.xj.w.xj(this.f.xj().xj(), true)).xj("Proxy-Connection", "Keep-Alive").xj("User-Agent", com.bytedance.sdk.component.w.hf.xj.u.xj()).xj();
    }

    public void hf() {
        com.bytedance.sdk.component.w.hf.xj.w.xj(this.d);
    }

    public boolean kd() {
        return this.g != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.f.xj().xj().c());
        sb.append(":");
        sb.append(this.f.xj().xj().f());
        sb.append(", proxy=");
        sb.append(this.f.hf());
        sb.append(" hostAddress=");
        sb.append(this.f.w());
        sb.append(" cipherSuite=");
        e eVar = this.p;
        sb.append(eVar != null ? eVar.hf() : "none");
        sb.append(" protocol=");
        sb.append(this.f10236pl);
        sb.append('}');
        return sb.toString();
    }

    public e u() {
        return this.p;
    }

    public Socket w() {
        return this.tf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r1v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2, types: [javax.net.ssl.SSLSocketFactory] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(int r11, int r12, int r13, boolean r14, com.bytedance.sdk.component.w.hf.kd r15, com.bytedance.sdk.component.w.hf.zg r16) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.hf.w.xj(int, int, int, boolean, com.bytedance.sdk.component.w.hf.kd, com.bytedance.sdk.component.w.hf.zg):void");
    }

    private void xj(int i, int i2, int i3, com.bytedance.sdk.component.w.hf.kd kdVar, zg zgVar) {
        io y = y();
        v xj = y.xj();
        for (int i4 = 0; i4 < 21; i4++) {
            xj(i, i2, kdVar, zgVar);
            y = xj(i2, i3, y, xj);
            if (y == null) {
                return;
            }
            com.bytedance.sdk.component.w.hf.xj.w.xj(this.d);
            this.d = null;
            this.qt = null;
            this.am = null;
        }
    }

    private void xj(int i, int i2, com.bytedance.sdk.component.w.hf.kd kdVar, zg zgVar) {
        Proxy hf = this.f.hf();
        Socket createSocket = (hf.type() == Proxy.Type.DIRECT || hf.type() == Proxy.Type.HTTP) ? this.f.xj().w().createSocket() : new Socket(hf);
        this.d = createSocket;
        createSocket.setSoTimeout(i2);
        try {
            com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj(this.d, this.f.w(), i);
            try {
                this.am = pl.xj(pl.hf(this.d));
                this.qt = pl.xj(pl.xj(this.d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f.w());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void xj(hf hfVar, com.bytedance.sdk.component.w.hf.kd kdVar, zg zgVar) {
        if (this.f.xj().d() == null) {
            this.f10236pl = dk.HTTP_1_1;
            this.tf = this.d;
            return;
        }
        xj(hfVar);
        try {
            if (this.f10236pl == dk.HTTP_2) {
                this.tf.setSoTimeout(0);
                com.bytedance.sdk.component.w.hf.xj.kd.c xj = new c.xj(true).xj(this.tf, this.f.xj().xj().c(), this.am, this.qt).xj(this).xj();
                this.g = xj;
                xj.w();
            }
        } catch (Throwable unused) {
        }
    }

    private void xj(hf hfVar) {
        SSLSocket sSLSocket;
        com.bytedance.sdk.component.w.hf.xj xj = this.f.xj();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) xj.d().createSocket(this.d, xj.xj().c(), xj.xj().f(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            p xj2 = hfVar.xj(sSLSocket);
            if (xj2.u()) {
                com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj(sSLSocket, xj.xj().c(), xj.kd());
            }
            try {
                sSLSocket.startHandshake();
            } catch (Throwable unused) {
            }
            e xj3 = e.xj(sSLSocket.getSession());
            if (xj.tf().verify(xj.xj().c(), sSLSocket.getSession())) {
                xj.p().xj(xj.xj().c(), xj3.w());
                String xj4 = xj2.u() ? com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj(sSLSocket) : null;
                this.tf = sSLSocket;
                this.am = pl.xj(pl.hf(sSLSocket));
                this.qt = pl.xj(pl.xj(this.tf));
                this.p = xj3;
                this.f10236pl = xj4 != null ? dk.xj(xj4) : dk.HTTP_1_1;
                com.bytedance.sdk.component.w.hf.xj.c.kd.hf().hf(sSLSocket);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) xj3.w().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + xj.xj().c() + " not verified:\n    certificate: " + com.bytedance.sdk.component.w.hf.c.xj((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.w.hf.xj.d.kd.xj(x509Certificate));
        } catch (AssertionError e2) {
            e = e2;
            if (!com.bytedance.sdk.component.w.hf.xj.w.xj(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                com.bytedance.sdk.component.w.hf.xj.c.kd.hf().hf(sSLSocket2);
            }
            com.bytedance.sdk.component.w.hf.xj.w.xj((Socket) sSLSocket2);
            throw th;
        }
    }

    private io xj(int i, int i2, io ioVar, v vVar) {
        String str = "CONNECT " + com.bytedance.sdk.component.w.hf.xj.w.xj(vVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.w.hf.xj.u.xj xjVar = new com.bytedance.sdk.component.w.hf.xj.u.xj(null, null, this.am, this.qt);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.am.xj().xj(i, timeUnit);
            this.qt.xj().xj(i2, timeUnit);
            xjVar.xj(ioVar.w(), str);
            xjVar.hf();
            q xj = xjVar.xj(false).xj(ioVar).xj();
            long xj2 = com.bytedance.sdk.component.w.hf.xj.w.kd.xj(xj);
            if (xj2 == -1) {
                xj2 = 0;
            }
            com.bytedance.sdk.component.w.xj.v hf = xjVar.hf(xj2);
            com.bytedance.sdk.component.w.hf.xj.w.hf(hf, Integer.MAX_VALUE, timeUnit);
            hf.close();
            int w = xj.w();
            if (w == 200) {
                if (this.am.w().kd() && this.qt.w().kd()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (w == 407) {
                io xj3 = this.f.xj().u().xj(this.f, xj);
                if (xj3 != null) {
                    if ("close".equalsIgnoreCase(xj.xj("Connection"))) {
                        return xj3;
                    }
                    ioVar = xj3;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + xj.w());
            }
        }
    }

    public boolean xj(com.bytedance.sdk.component.w.hf.xj xjVar, j jVar) {
        if (this.u.size() >= this.w || this.xj || !com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(this.f.xj(), xjVar)) {
            return false;
        }
        if (xjVar.xj().c().equals(xj().xj().xj().c())) {
            return true;
        }
        if (this.g == null || jVar == null) {
            return false;
        }
        Proxy.Type type = jVar.hf().type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || this.f.hf().type() != type2 || !this.f.w().equals(jVar.w()) || jVar.xj().tf() != com.bytedance.sdk.component.w.hf.xj.d.kd.xj || !xj(xjVar.xj())) {
            return false;
        }
        try {
            xjVar.p().xj(xjVar.xj().c(), u().w());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean xj(v vVar) {
        if (vVar.f() != this.f.xj().xj().f()) {
            return false;
        }
        if (vVar.c().equals(this.f.xj().xj().c())) {
            return true;
        }
        return this.p != null && com.bytedance.sdk.component.w.hf.xj.d.kd.xj.xj(vVar.c(), (X509Certificate) this.p.w().get(0));
    }

    public com.bytedance.sdk.component.w.hf.xj.w.w xj(ra raVar, jk.xj xjVar, c cVar) {
        if (this.g != null) {
            return new com.bytedance.sdk.component.w.hf.xj.kd.y(raVar, xjVar, cVar, this.g);
        }
        this.tf.setSoTimeout(xjVar.w());
        com.bytedance.sdk.component.w.xj.jk xj = this.am.xj();
        long w = xjVar.w();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        xj.xj(w, timeUnit);
        this.qt.xj().xj(xjVar.u(), timeUnit);
        return new com.bytedance.sdk.component.w.hf.xj.u.xj(raVar, cVar, this.am, this.qt);
    }

    @Override // com.bytedance.sdk.component.w.hf.d
    public j xj() {
        return this.f;
    }

    public boolean xj(boolean z) {
        if (this.tf.isClosed() || this.tf.isInputShutdown() || this.tf.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.component.w.hf.xj.kd.c cVar = this.g;
        if (cVar != null) {
            return !cVar.u();
        }
        if (z) {
            try {
                int soTimeout = this.tf.getSoTimeout();
                try {
                    this.tf.setSoTimeout(1);
                    return !this.am.kd();
                } finally {
                    this.tf.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.kd.c.hf
    public void xj(com.bytedance.sdk.component.w.hf.xj.kd.d dVar) {
        dVar.xj(com.bytedance.sdk.component.w.hf.xj.kd.hf.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.kd.c.hf
    public void xj(com.bytedance.sdk.component.w.hf.xj.kd.c cVar) {
        synchronized (this.c) {
            this.w = cVar.xj();
        }
    }
}
