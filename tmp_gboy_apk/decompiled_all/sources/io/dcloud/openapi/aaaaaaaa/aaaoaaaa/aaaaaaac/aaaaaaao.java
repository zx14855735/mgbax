package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aa0aaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaeo;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaacaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaeaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaeaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aacaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaoaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.acaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaeaa;
import java.io.IOException;
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
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaao extends aaaaaaae.aaaeaaaa implements aaaaaaeo {
    private final aaaeaaaa aaaaaaa0;
    private Socket aaaaaaac;
    private aacaaaaa aaaaaaae;
    private aaoaaaaa aaaaaaan;
    private final aa0aaaaa aaaaaaao;
    private Socket aaaaaaau;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae aaaaaaav;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaau aaaaaaeo;
    public int aaaaaeaa;
    public boolean aaaaeaaa;
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac aaaeaaaa;
    public int aaaaaaea = 1;
    public final List eaaaaaaa = new ArrayList();
    public long aeaaaaaa = Long.MAX_VALUE;

    public aaaaaaao(aaaeaaaa aaaeaaaaVar, aa0aaaaa aa0aaaaaVar) {
        this.aaaaaaa0 = aaaeaaaaVar;
        this.aaaaaaao = aa0aaaaaVar;
    }

    private aaaacaaa aaaaaaa0() {
        aaaacaaa aaaaaaaa = new aaaacaaa.aaaaaaaa().aaaaaaaa(this.aaaaaaao.aaaaaaaa().aaaaeaaa()).aaaaaaaa("CONNECT", (aaaaacaa) null).aaaaaaa0("Host", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaao.aaaaaaaa().aaaaeaaa(), true)).aaaaaaa0("Proxy-Connection", "Keep-Alive").aaaaaaa0("User-Agent", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaac.aaaaaaaa()).aaaaaaaa();
        aaaacaaa aaaaaaaa2 = this.aaaaaaao.aaaaaaaa().aaaaaaae().aaaaaaaa(this.aaaaaaao, new aaaaaaca.aaaaaaaa().aaaaaaaa(aaaaaaaa).aaaaaaaa(aacaaaaa.HTTP_1_1).aaaaaaaa(407).aaaaaaaa("Preemptive Authenticate").aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaao).aaaaaaa0(-1L).aaaaaaaa(-1L).aaaaaaa0("Proxy-Authenticate", "OkHttp-Preemptive").aaaaaaaa());
        return aaaaaaaa2 != null ? aaaaaaaa2 : aaaaaaaa;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void aaaaaaaa(int r13, int r14, int r15, int r16, boolean r17, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac r18, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa r19) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao.aaaaaaaa(int, int, int, int, boolean, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa):void");
    }

    public boolean aaaaaaac() {
        return this.aaaaaaav != null;
    }

    public Socket aaaaaaan() {
        return this.aaaaaaau;
    }

    public aaoaaaaa aaaaaaao() {
        return this.aaaaaaan;
    }

    public aa0aaaaa aaaaaaau() {
        return this.aaaaaaao;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.aaaaaaao.aaaaaaaa().aaaaeaaa().aaaaaaae());
        sb.append(":");
        sb.append(this.aaaaaaao.aaaaaaaa().aaaaeaaa().aaaeaaaa());
        sb.append(", proxy=");
        sb.append(this.aaaaaaao.aaaaaaa0());
        sb.append(" hostAddress=");
        sb.append(this.aaaaaaao.aaaaaaac());
        sb.append(" cipherSuite=");
        aaoaaaaa aaoaaaaaVar = this.aaaaaaan;
        sb.append(aaoaaaaaVar != null ? aaoaaaaaVar.aaaaaaaa() : "none");
        sb.append(" protocol=");
        sb.append(this.aaaaaaae);
        sb.append('}');
        return sb.toString();
    }

    private void aaaaaaaa(int i, int i2, int i3, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaacVar, aoaaaaaa aoaaaaaaVar) {
        aaaacaaa aaaaaaa0 = aaaaaaa0();
        aaaaoaaa aaaaaaae = aaaaaaa0.aaaaaaae();
        for (int i4 = 0; i4 < 21; i4++) {
            aaaaaaaa(i, i2, aaaaaaacVar, aoaaaaaaVar);
            aaaaaaa0 = aaaaaaaa(i2, i3, aaaaaaa0, aaaaaaae);
            if (aaaaaaa0 == null) {
                return;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaac);
            this.aaaaaaac = null;
            this.aaaeaaaa = null;
            this.aaaaaaeo = null;
            aoaaaaaaVar.aaaaaaaa(aaaaaaacVar, this.aaaaaaao.aaaaaaac(), this.aaaaaaao.aaaaaaa0(), null);
        }
    }

    private void aaaaaaaa(int i, int i2, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaacVar, aoaaaaaa aoaaaaaaVar) {
        Socket createSocket;
        Proxy aaaaaaa0 = this.aaaaaaao.aaaaaaa0();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaa = this.aaaaaaao.aaaaaaaa();
        if (aaaaaaa0.type() != Proxy.Type.DIRECT && aaaaaaa0.type() != Proxy.Type.HTTP) {
            createSocket = new Socket(aaaaaaa0);
        } else {
            createSocket = aaaaaaaa.aaaaaaeo().createSocket();
        }
        this.aaaaaaac = createSocket;
        aoaaaaaaVar.aaaaaaaa(aaaaaaacVar, this.aaaaaaao.aaaaaaac(), aaaaaaa0);
        this.aaaaaaac.setSoTimeout(i2);
        try {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa(this.aaaaaaac, this.aaaaaaao.aaaaaaac(), i);
            try {
                this.aaaaaaeo = aaaaaeaa.aaaaaaaa(aaaaaeaa.aaaaaaa0(this.aaaaaaac));
                this.aaaeaaaa = aaaaaeaa.aaaaaaaa(aaaaaeaa.aaaaaaaa(this.aaaaaaac));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.aaaaaaao.aaaaaaac());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void aaaaaaaa(aaaaaaa0 aaaaaaa0Var, int i, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaacVar, aoaaaaaa aoaaaaaaVar) {
        if (this.aaaaaaao.aaaaaaaa().aaaeaaaa() == null) {
            List aaaaaaau = this.aaaaaaao.aaaaaaaa().aaaaaaau();
            aacaaaaa aacaaaaaVar = aacaaaaa.H2_PRIOR_KNOWLEDGE;
            if (aaaaaaau.contains(aacaaaaaVar)) {
                this.aaaaaaau = this.aaaaaaac;
                this.aaaaaaae = aacaaaaaVar;
                aaaaaaaa(i);
                return;
            } else {
                this.aaaaaaau = this.aaaaaaac;
                this.aaaaaaae = aacaaaaa.HTTP_1_1;
                return;
            }
        }
        aoaaaaaaVar.aaaaaaae(aaaaaaacVar);
        aaaaaaaa(aaaaaaa0Var);
        aoaaaaaaVar.aaaaaaaa(aaaaaaacVar, this.aaaaaaan);
        if (this.aaaaaaae == aacaaaaa.HTTP_2) {
            aaaaaaaa(i);
        }
    }

    private void aaaaaaaa(int i) {
        this.aaaaaaau.setSoTimeout(0);
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae aaaaaaaa = new aaaaaaae.aaaaaaav(true).aaaaaaaa(this.aaaaaaau, this.aaaaaaao.aaaaaaaa().aaaaeaaa().aaaaaaae(), this.aaaaaaeo, this.aaaeaaaa).aaaaaaaa(this).aaaaaaaa(i).aaaaaaaa();
        this.aaaaaaav = aaaaaaaa;
        aaaaaaaa.aaaaaaea();
    }

    private void aaaaaaaa(aaaaaaa0 aaaaaaa0Var) {
        SSLSocket sSLSocket;
        aacaaaaa aacaaaaaVar;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaa = this.aaaaaaao.aaaaaaaa();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) aaaaaaaa.aaaeaaaa().createSocket(this.aaaaaaac, aaaaaaaa.aaaaeaaa().aaaaaaae(), aaaaaaaa.aaaaeaaa().aaaeaaaa(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            aaaaeaaa aaaaaaaa2 = aaaaaaa0Var.aaaaaaaa(sSLSocket);
            if (aaaaaaaa2.aaaaaaao()) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa(sSLSocket, aaaaaaaa.aaaaeaaa().aaaaaaae(), aaaaaaaa.aaaaaaau());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            aaoaaaaa aaaaaaaa3 = aaoaaaaa.aaaaaaaa(session);
            if (!aaaaaaaa.aaaaaaac().verify(aaaaaaaa.aaaaeaaa().aaaaaaae(), session)) {
                List aaaaaaa0 = aaaaaaaa3.aaaaaaa0();
                if (!aaaaaaa0.isEmpty()) {
                    X509Certificate x509Certificate = (X509Certificate) aaaaaaa0.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + aaaaaaaa.aaaaeaaa().aaaaaaae() + " not verified:\n    certificate: " + io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaae.aaaaaaaa((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaac.aaaaaaaa(x509Certificate));
                }
                throw new SSLPeerUnverifiedException("Hostname " + aaaaaaaa.aaaaeaaa().aaaaaaae() + " not verified (no certificates)");
            }
            aaaaaaaa.aaaaaaaa().aaaaaaaa(aaaaaaaa.aaaaeaaa().aaaaaaae(), aaaaaaaa3.aaaaaaa0());
            String aaaaaaa02 = aaaaaaaa2.aaaaaaao() ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaa0(sSLSocket) : null;
            this.aaaaaaau = sSLSocket;
            this.aaaaaaeo = aaaaaeaa.aaaaaaaa(aaaaaeaa.aaaaaaa0(sSLSocket));
            this.aaaeaaaa = aaaaaeaa.aaaaaaaa(aaaaaeaa.aaaaaaaa(this.aaaaaaau));
            this.aaaaaaan = aaaaaaaa3;
            if (aaaaaaa02 != null) {
                aacaaaaaVar = aacaaaaa.aaaaaaaa(aaaaaaa02);
            } else {
                aacaaaaaVar = aacaaaaa.HTTP_1_1;
            }
            this.aaaaaaae = aacaaaaaVar;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa(sSLSocket);
        } catch (AssertionError e2) {
            e = e2;
            if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa(sSLSocket2);
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa((Socket) sSLSocket2);
            throw th;
        }
    }

    private aaaacaaa aaaaaaaa(int i, int i2, aaaacaaa aaaacaaaVar, aaaaoaaa aaaaoaaaVar) {
        String str = "CONNECT " + io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaoaaaVar, true) + " HTTP/1.1";
        while (true) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaan.aaaaaaaa aaaaaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaan.aaaaaaaa(null, null, this.aaaaaaeo, this.aaaeaaaa);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.aaaaaaeo.aaaaaaa0().aaaaaaaa(i, timeUnit);
            this.aaaeaaaa.aaaaaaa0().aaaaaaaa(i2, timeUnit);
            aaaaaaaaVar.aaaaaaaa(aaaacaaaVar.aaaaaaao(), str);
            aaaaaaaaVar.aaaaaaaa();
            aaaaaaca aaaaaaaa = aaaaaaaaVar.aaaaaaaa(false).aaaaaaaa(aaaacaaaVar).aaaaaaaa();
            long aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaau.aaaaaaaa(aaaaaaaa);
            if (aaaaaaaa2 == -1) {
                aaaaaaaa2 = 0;
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaoaaa aaaaaaa0 = aaaaaaaaVar.aaaaaaa0(aaaaaaaa2);
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaa0(aaaaaaa0, Integer.MAX_VALUE, timeUnit);
            aaaaaaa0.close();
            int aaaaeaaa = aaaaaaaa.aaaaeaaa();
            if (aaaaeaaa == 200) {
                if (this.aaaaaaeo.aaaaaaaa().aaaaaaan() && this.aaaeaaaa.aaaaaaaa().aaaaaaan()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (aaaaeaaa == 407) {
                aaaacaaa aaaaaaaa3 = this.aaaaaaao.aaaaaaaa().aaaaaaae().aaaaaaaa(this.aaaaaaao, aaaaaaaa);
                if (aaaaaaaa3 != null) {
                    if ("close".equalsIgnoreCase(aaaaaaaa.aaaaaaa0("Connection"))) {
                        return aaaaaaaa3;
                    }
                    aaaacaaaVar = aaaaaaaa3;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + aaaaaaaa.aaaaeaaa());
            }
        }
    }

    public boolean aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, aa0aaaaa aa0aaaaaVar) {
        if (this.eaaaaaaa.size() >= this.aaaaaaea || this.aaaaeaaa || !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(this.aaaaaaao.aaaaaaaa(), aaaaaaaaVar)) {
            return false;
        }
        if (aaaaaaaaVar.aaaaeaaa().aaaaaaae().equals(aaaaaaau().aaaaaaaa().aaaaeaaa().aaaaaaae())) {
            return true;
        }
        if (this.aaaaaaav == null || aa0aaaaaVar == null) {
            return false;
        }
        Proxy.Type type = aa0aaaaaVar.aaaaaaa0().type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || this.aaaaaaao.aaaaaaa0().type() != type2 || !this.aaaaaaao.aaaaaaac().equals(aa0aaaaaVar.aaaaaaac()) || aa0aaaaaVar.aaaaaaaa().aaaaaaac() != io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaac.aaaaaaaa || !aaaaaaaa(aaaaaaaaVar.aaaaeaaa())) {
            return false;
        }
        try {
            aaaaaaaaVar.aaaaaaaa().aaaaaaaa(aaaaaaaaVar.aaaaeaaa().aaaaaaae(), aaaaaaao().aaaaaaa0());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        if (aaaaoaaaVar.aaaeaaaa() != this.aaaaaaao.aaaaaaaa().aaaaeaaa().aaaeaaaa()) {
            return false;
        }
        if (aaaaoaaaVar.aaaaaaae().equals(this.aaaaaaao.aaaaaaaa().aaaaeaaa().aaaaaaae())) {
            return true;
        }
        return this.aaaaaaan != null && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaac.aaaaaaaa.aaaaaaaa(aaaaoaaaVar.aaaaaaae(), (X509Certificate) this.aaaaaaan.aaaaaaa0().get(0));
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaao aaaaaaaa(acaaaaaa acaaaaaaVar, aaaaaoaa.aaaaaaaa aaaaaaaaVar, aaaaaaae aaaaaaaeVar) {
        if (this.aaaaaaav != null) {
            return new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaan(acaaaaaaVar, aaaaaaaaVar, aaaaaaaeVar, this.aaaaaaav);
        }
        this.aaaaaaau.setSoTimeout(aaaaaaaaVar.aaaaaaa0());
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaoaa aaaaaaa0 = this.aaaaaaeo.aaaaaaa0();
        long aaaaaaa02 = aaaaaaaaVar.aaaaaaa0();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aaaaaaa0.aaaaaaaa(aaaaaaa02, timeUnit);
        this.aaaeaaaa.aaaaaaa0().aaaaaaaa(aaaaaaaaVar.aaaaaaao(), timeUnit);
        return new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaan.aaaaaaaa(acaaaaaaVar, aaaaaaaeVar, this.aaaaaaeo, this.aaaeaaaa);
    }

    public void aaaaaaaa() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaac);
    }

    public boolean aaaaaaaa(boolean z) {
        if (this.aaaaaaau.isClosed() || this.aaaaaaau.isInputShutdown() || this.aaaaaaau.isOutputShutdown()) {
            return false;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae aaaaaaaeVar = this.aaaaaaav;
        if (aaaaaaaeVar != null) {
            return aaaaaaaeVar.aaaaaaan(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.aaaaaaau.getSoTimeout();
                try {
                    this.aaaaaaau.setSoTimeout(1);
                    return !this.aaaaaaeo.aaaaaaan();
                } finally {
                    this.aaaaaaau.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae.aaaeaaaa
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaeo aaaaaaeoVar) {
        aaaaaaeoVar.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaa0.REFUSED_STREAM);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae.aaaeaaaa
    public void aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaae aaaaaaaeVar) {
        synchronized (this.aaaaaaa0) {
            this.aaaaaaea = aaaaaaaeVar.aaaaeaaa();
        }
    }
}
