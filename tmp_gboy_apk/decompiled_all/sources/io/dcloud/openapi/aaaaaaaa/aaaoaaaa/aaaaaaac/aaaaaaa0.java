package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaeaaa;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaa0 {
    private int aaaaaaa0 = 0;
    private final List aaaaaaaa;
    private boolean aaaaaaac;
    private boolean aaaaaaao;

    public aaaaaaa0(List list) {
        this.aaaaaaaa = list;
    }

    private boolean aaaaaaa0(SSLSocket sSLSocket) {
        for (int i = this.aaaaaaa0; i < this.aaaaaaaa.size(); i++) {
            if (((aaaaeaaa) this.aaaaaaaa.get(i)).aaaaaaaa(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public aaaaeaaa aaaaaaaa(SSLSocket sSLSocket) {
        aaaaeaaa aaaaeaaaVar;
        int i = this.aaaaaaa0;
        int size = this.aaaaaaaa.size();
        while (true) {
            if (i >= size) {
                aaaaeaaaVar = null;
                break;
            }
            aaaaeaaaVar = (aaaaeaaa) this.aaaaaaaa.get(i);
            if (aaaaeaaaVar.aaaaaaaa(sSLSocket)) {
                this.aaaaaaa0 = i + 1;
                break;
            }
            i++;
        }
        if (aaaaeaaaVar != null) {
            this.aaaaaaao = aaaaaaa0(sSLSocket);
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa.aaaaaaaa(aaaaeaaaVar, sSLSocket, this.aaaaaaac);
            return aaaaeaaaVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.aaaaaaac + ", modes=" + this.aaaaaaaa + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean aaaaaaaa(IOException iOException) {
        this.aaaaaaac = true;
        if (!this.aaaaaaao || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
