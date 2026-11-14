package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.internal.an;
import com.sigmob.sdk.downloader.core.c;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.a0aaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aa0aaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaacaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.acaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa;
import java.io.FileNotFoundException;
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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaeaaaa implements aaaaaoaa {
    private final boolean aaaaaaa0;
    private final acaaaaaa aaaaaaaa;
    private Object aaaaaaac;
    private volatile io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaao;
    private volatile boolean aaaaaaau;

    public aaaeaaaa(acaaaaaa acaaaaaaVar, boolean z) {
        this.aaaaaaaa = acaaaaaaVar;
        this.aaaaaaa0 = z;
    }

    public boolean aaaaaaa0() {
        return this.aaaaaaau;
    }

    public void aaaaaaaa() {
        this.aaaaaaau = true;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar = this.aaaaaaao;
        if (aaaaaaaeVar != null) {
            aaaaaaaeVar.aaaaaaaa();
        }
    }

    public void aaaaaaaa(Object obj) {
        this.aaaaaaac = obj;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa
    public aaaaaaca aaaaaaaa(aaaaaoaa.aaaaaaaa aaaaaaaaVar) {
        aaaaaaca aaaaaaaa;
        aaaacaaa aaaaaaaa2;
        aaaacaaa aaaaaaac = aaaaaaaaVar.aaaaaaac();
        aaaaaaae aaaaaaaeVar = (aaaaaaae) aaaaaaaaVar;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaac aaaaaaau = aaaaaaaeVar.aaaaaaau();
        aoaaaaaa aaaaaaae = aaaaaaaeVar.aaaaaaae();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar2 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae(this.aaaaaaaa.aaaaaaau(), aaaaaaaa(aaaaaaac.aaaaaaae()), aaaaaaau, aaaaaaae, this.aaaaaaac);
        this.aaaaaaao = aaaaaaaeVar2;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar3 = aaaaaaaeVar2;
        aaaaaaca aaaaaacaVar = null;
        int i = 0;
        aaaacaaa aaaacaaaVar = aaaaaaac;
        while (!this.aaaaaaau) {
            try {
                try {
                    aaaaaaaa = aaaaaaaeVar.aaaaaaaa(aaaacaaaVar, aaaaaaaeVar3, null, null);
                    if (aaaaaacaVar != null) {
                        aaaaaaaa = aaaaaaaa.eaaaaaaa().aaaaaaac(aaaaaacaVar.eaaaaaaa().aaaaaaaa((a0aaaaaa) null).aaaaaaaa()).aaaaaaaa();
                    }
                    try {
                        aaaaaaaa2 = aaaaaaaa(aaaaaaaa, aaaaaaaeVar3.aaaaaaav());
                    } catch (IOException e) {
                        aaaaaaaeVar3.aaaaaaan();
                        throw e;
                    }
                } catch (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaau e2) {
                    if (!aaaaaaaa(e2.aaaaaaa0(), aaaaaaaeVar3, false, aaaacaaaVar)) {
                        throw e2.aaaaaaaa();
                    }
                } catch (IOException e3) {
                    if (!aaaaaaaa(e3, aaaaaaaeVar3, !(e3 instanceof io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaae.aaaaaaaa), aaaacaaaVar)) {
                        throw e3;
                    }
                }
                if (aaaaaaaa2 == null) {
                    aaaaaaaeVar3.aaaaaaan();
                    return aaaaaaaa;
                }
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaa.aaaaaaeo());
                int i2 = i + 1;
                if (i2 <= 20) {
                    aaaaaaaa2.aaaaaaaa();
                    if (!aaaaaaaa(aaaaaaaa, aaaaaaaa2.aaaaaaae())) {
                        aaaaaaaeVar3.aaaaaaan();
                        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar4 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae(this.aaaaaaaa.aaaaaaau(), aaaaaaaa(aaaaaaaa2.aaaaaaae()), aaaaaaau, aaaaaaae, this.aaaaaaac);
                        this.aaaaaaao = aaaaaaaeVar4;
                        aaaaaacaVar = aaaaaaaa;
                        aaaaaaaeVar3 = aaaaaaaeVar4;
                    } else {
                        if (aaaaaaaeVar3.aaaaaaa0() != null) {
                            throw new IllegalStateException("Closing the body of " + aaaaaaaa + " didn't close its backing stream. Bad interceptor?");
                        }
                        aaaaaacaVar = aaaaaaaa;
                    }
                    aaaacaaaVar = aaaaaaaa2;
                    i = i2;
                } else {
                    aaaaaaaeVar3.aaaaaaan();
                    throw new ProtocolException(CtFAbx.ARc23Z(i2, "Too many follow-up requests: "));
                }
            } catch (Throwable th) {
                aaaaaaaeVar3.aaaaaaaa((IOException) null);
                aaaaaaaeVar3.aaaaaaan();
                throw th;
            }
        }
        aaaaaaaeVar3.aaaaaaan();
        throw new IOException("Canceled");
    }

    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaae aaaaaaaeVar;
        if (aaaaoaaaVar.aaaaaaav()) {
            sSLSocketFactory = this.aaaaaaaa.aaaacaaa();
            hostnameVerifier = this.aaaaaaaa.aaaaaaea();
            aaaaaaaeVar = this.aaaaaaaa.aaaaaaao();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            aaaaaaaeVar = null;
        }
        return new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa(aaaaoaaaVar.aaaaaaae(), aaaaoaaaVar.aaaeaaaa(), this.aaaaaaaa.aaaaaaeo(), this.aaaaaaaa.aaacaaaa(), sSLSocketFactory, hostnameVerifier, aaaaaaaeVar, this.aaaaaaaa.aaaaaoaa(), this.aaaaaaaa.aaaaoaaa(), this.aaaaaaaa.aaaoaaaa(), this.aaaaaaaa.aaaaaaan(), this.aaaaaaaa.aaaaaaoa());
    }

    private boolean aaaaaaaa(IOException iOException, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar, boolean z, aaaacaaa aaaacaaaVar) {
        aaaaaaaeVar.aaaaaaaa(iOException);
        if (this.aaaaaaaa.aacaaaaa()) {
            return !(z && aaaaaaaa(iOException, aaaacaaaVar)) && aaaaaaaa(iOException, z) && aaaaaaaeVar.aaaaaaac();
        }
        return false;
    }

    private boolean aaaaaaaa(IOException iOException, aaaacaaa aaaacaaaVar) {
        aaaacaaaVar.aaaaaaaa();
        return iOException instanceof FileNotFoundException;
    }

    private boolean aaaaaaaa(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private aaaacaaa aaaaaaaa(aaaaaaca aaaaaacaVar, aa0aaaaa aa0aaaaaVar) {
        String aaaaaaa0;
        aaaaoaaa aaaaaaau;
        if (aaaaaacaVar != null) {
            int aaaaeaaa = aaaaaacaVar.aaaaeaaa();
            String aaaaaaau2 = aaaaaacaVar.aaoaaaaa().aaaaaaau();
            if (aaaaeaaa == 307 || aaaaeaaa == 308) {
                if (!aaaaaaau2.equals(an.c) && !aaaaaaau2.equals(c.f13360a)) {
                    return null;
                }
            } else {
                if (aaaaeaaa == 401) {
                    return this.aaaaaaaa.aaaaaaaa().aaaaaaaa(aa0aaaaaVar, aaaaaacaVar);
                }
                if (aaaaeaaa == 503) {
                    if ((aaaaaacaVar.aeaaaaaa() == null || aaaaaacaVar.aeaaaaaa().aaaaeaaa() != 503) && aaaaaaaa(aaaaaacaVar, Integer.MAX_VALUE) == 0) {
                        return aaaaaacaVar.aaoaaaaa();
                    }
                    return null;
                }
                if (aaaaeaaa == 407) {
                    if (aa0aaaaaVar.aaaaaaa0().type() == Proxy.Type.HTTP) {
                        return this.aaaaaaaa.aaaaaoaa().aaaaaaaa(aa0aaaaaVar, aaaaaacaVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (aaaaeaaa == 408) {
                    if (!this.aaaaaaaa.aacaaaaa()) {
                        return null;
                    }
                    aaaaaacaVar.aaoaaaaa().aaaaaaaa();
                    if ((aaaaaacaVar.aeaaaaaa() == null || aaaaaacaVar.aeaaaaaa().aaaaeaaa() != 408) && aaaaaaaa(aaaaaacaVar, 0) <= 0) {
                        return aaaaaacaVar.aaoaaaaa();
                    }
                    return null;
                }
                switch (aaaaeaaa) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.aaaaaaaa.aaaaeaaa() || (aaaaaaa0 = aaaaaacaVar.aaaaaaa0("Location")) == null || (aaaaaaau = aaaaaacaVar.aaoaaaaa().aaaaaaae().aaaaaaau(aaaaaaa0)) == null) {
                return null;
            }
            if (!aaaaaaau.aaaaaaea().equals(aaaaaacaVar.aaoaaaaa().aaaaaaae().aaaaaaea()) && !this.aaaaaaaa.aaaaaeaa()) {
                return null;
            }
            aaaacaaa.aaaaaaaa aaaaaaan = aaaaaacaVar.aaoaaaaa().aaaaaaan();
            if (aaaaaaan.aaaaaaaa(aaaaaaau2)) {
                boolean aaaaaaao = aaaaaaan.aaaaaaao(aaaaaaau2);
                if (aaaaaaan.aaaaaaa0(aaaaaaau2)) {
                    aaaaaaan.aaaaaaaa(an.c, (aaaaacaa) null);
                } else {
                    aaaaaaan.aaaaaaaa(aaaaaaau2, aaaaaaao ? aaaaaacaVar.aaoaaaaa().aaaaaaaa() : null);
                }
                if (!aaaaaaao) {
                    aaaaaaan.aaaaaaaa(c.h);
                    aaaaaaan.aaaaaaaa(c.e);
                    aaaaaaan.aaaaaaaa("Content-Type");
                }
            }
            if (!aaaaaaaa(aaaaaacaVar, aaaaaaau)) {
                aaaaaaan.aaaaaaaa("Authorization");
            }
            return aaaaaaan.aaaaaaaa(aaaaaaau).aaaaaaaa();
        }
        throw new IllegalStateException();
    }

    private int aaaaaaaa(aaaaaaca aaaaaacaVar, int i) {
        String aaaaaaa0 = aaaaaacaVar.aaaaaaa0("Retry-After");
        if (aaaaaaa0 == null) {
            return i;
        }
        if (aaaaaaa0.matches("\\d+")) {
            return Integer.valueOf(aaaaaaa0).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean aaaaaaaa(aaaaaaca aaaaaacaVar, aaaaoaaa aaaaoaaaVar) {
        aaaaoaaa aaaaaaae = aaaaaacaVar.aaoaaaaa().aaaaaaae();
        return aaaaaaae.aaaaaaae().equals(aaaaoaaaVar.aaaaaaae()) && aaaaaaae.aaaeaaaa() == aaaaoaaaVar.aaaeaaaa() && aaaaaaae.aaaaaaea().equals(aaaaoaaaVar.aaaaaaea());
    }
}
