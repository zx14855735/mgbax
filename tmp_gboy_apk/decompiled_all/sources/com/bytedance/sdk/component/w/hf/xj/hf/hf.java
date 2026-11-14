package com.bytedance.sdk.component.w.hf.xj.hf;

import com.bytedance.sdk.component.w.hf.p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class hf {
    private int hf = 0;
    private boolean u;
    private boolean w;
    private final List<p> xj;

    public hf(List<p> list) {
        this.xj = list;
    }

    private boolean hf(SSLSocket sSLSocket) {
        for (int i = this.hf; i < this.xj.size(); i++) {
            if (this.xj.get(i).xj(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public p xj(SSLSocket sSLSocket) {
        p pVar;
        int i = this.hf;
        int size = this.xj.size();
        while (true) {
            if (i >= size) {
                pVar = null;
                break;
            }
            pVar = this.xj.get(i);
            if (pVar.xj(sSLSocket)) {
                this.hf = i + 1;
                break;
            }
            i++;
        }
        if (pVar != null) {
            this.w = hf(sSLSocket);
            com.bytedance.sdk.component.w.hf.xj.xj.xj.xj(pVar, sSLSocket, this.u);
            return pVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.u + ", modes=" + this.xj + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean xj(IOException iOException) {
        this.u = true;
        if (!this.w || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
