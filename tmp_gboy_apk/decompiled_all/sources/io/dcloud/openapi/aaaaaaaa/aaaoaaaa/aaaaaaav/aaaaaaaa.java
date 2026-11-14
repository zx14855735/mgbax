package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class aaaaaaaa extends aaaaaaa0 {
    public aaaaaaaa(Class cls) {
        super(cls, null, null, null, null);
    }

    public static aaaaaaan aaaaaaac() {
        try {
            if (aaaaaaa0.aaaaaaau() >= 29) {
                return new aaaaaaaa(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private void aaaaaaao(SSLSocket sSLSocket) {
        boolean isSupportedSocket;
        isSupportedSocket = SSLSockets.isSupportedSocket(sSLSocket);
        if (isSupportedSocket) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public String aaaaaaa0(SSLSocket sSLSocket) {
        String applicationProtocol;
        applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaa0, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(SSLSocket sSLSocket, String str, List list) {
        try {
            aaaaaaao(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) aaaaaaan.aaaaaaaa(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
