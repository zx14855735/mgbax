package com.bytedance.sdk.component.w.hf.xj.w;

import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.j;
import com.bytedance.sdk.component.w.hf.jk;
import com.bytedance.sdk.component.w.hf.q;
import com.bytedance.sdk.component.w.hf.ra;
import com.bytedance.sdk.component.w.hf.v;
import com.bytedance.sdk.component.w.hf.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class tf implements jk {
    private final boolean hf;
    private volatile boolean kd;
    private Object u;
    private com.bytedance.sdk.component.w.hf.xj.hf.c w;
    private final ra xj;

    public tf(ra raVar, boolean z) {
        this.xj = raVar;
        this.hf = z;
    }

    public boolean hf() {
        return this.kd;
    }

    public void xj() {
        this.kd = true;
        com.bytedance.sdk.component.w.hf.xj.hf.c cVar = this.w;
        if (cVar != null) {
            cVar.kd();
        }
    }

    public void xj(Object obj) {
        this.u = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006b  */
    @Override // com.bytedance.sdk.component.w.hf.jk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.w.hf.q xj(com.bytedance.sdk.component.w.hf.jk.xj r21) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.w.tf.xj(com.bytedance.sdk.component.w.hf.jk$xj):com.bytedance.sdk.component.w.hf.q");
    }

    private com.bytedance.sdk.component.w.hf.xj xj(v vVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.bytedance.sdk.component.w.hf.c cVar;
        if (vVar.u()) {
            sSLSocketFactory = this.xj.tf();
            hostnameVerifier = this.xj.p();
            cVar = this.xj.pl();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            cVar = null;
        }
        return new com.bytedance.sdk.component.w.hf.xj(vVar.c(), vVar.f(), this.xj.f(), this.xj.d(), sSLSocketFactory, hostnameVerifier, cVar, this.xj.am(), this.xj.u(), this.xj.jk(), this.xj.pz(), this.xj.kd());
    }

    private boolean xj(IOException iOException, boolean z, io ioVar) {
        this.w.xj(iOException);
        if (this.xj.yo()) {
            return !(z && (ioVar.u() instanceof pl)) && xj(iOException, z) && this.w.y();
        }
        return false;
    }

    private boolean xj(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private io xj(q qVar) {
        String xj;
        v w;
        Proxy u;
        if (qVar != null) {
            com.bytedance.sdk.component.w.hf.xj.hf.w hf = this.w.hf();
            j xj2 = hf != null ? hf.xj() : null;
            int w2 = qVar.w();
            String hf2 = qVar.xj().hf();
            if (w2 == 307 || w2 == 308) {
                if (!hf2.equals(an.c) && !hf2.equals(com.sigmob.sdk.downloader.core.c.f13360a)) {
                    return null;
                }
            } else {
                if (w2 == 401) {
                    return this.xj.g().xj(xj2, qVar);
                }
                if (w2 == 407) {
                    if (xj2 != null) {
                        u = xj2.hf();
                    } else {
                        u = this.xj.u();
                    }
                    if (u.type() == Proxy.Type.HTTP) {
                        return this.xj.am().xj(xj2, qVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (w2 == 408) {
                    if (!this.xj.yo() || (qVar.xj().u() instanceof pl)) {
                        return null;
                    }
                    if (qVar.p() == null || qVar.p().w() != 408) {
                        return qVar.xj();
                    }
                    return null;
                }
                switch (w2) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.xj.e() || (xj = qVar.xj("Location")) == null || (w = qVar.xj().xj().w(xj)) == null) {
                return null;
            }
            if (!w.w().equals(qVar.xj().xj().w()) && !this.xj.zg()) {
                return null;
            }
            io.xj y = qVar.xj().y();
            if (y.w(hf2)) {
                boolean u2 = y.u(hf2);
                if (y.kd(hf2)) {
                    y.xj(an.c, (x) null);
                } else {
                    y.xj(hf2, u2 ? qVar.xj().u() : null);
                }
                if (!u2) {
                    y.hf(com.sigmob.sdk.downloader.core.c.h);
                    y.hf(com.sigmob.sdk.downloader.core.c.e);
                    y.hf("Content-Type");
                }
            }
            if (!xj(qVar, w)) {
                y.hf("Authorization");
            }
            return y.xj(w).xj();
        }
        throw new IllegalStateException();
    }

    private boolean xj(q qVar, v vVar) {
        v xj = qVar.xj().xj();
        return xj.c().equals(vVar.c()) && xj.f() == vVar.f() && xj.w().equals(vVar.w());
    }
}
