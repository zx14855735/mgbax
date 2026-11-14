package com.bytedance.sdk.openadsdk.core.l;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends xj {
    private static final String[] hf = {"TLSv1.2"};
    private final hf w;

    static {
        aKjfnRF();
    }

    public c(SSLSocketFactory sSLSocketFactory, hf hfVar) {
        this.xj = sSLSocketFactory;
        this.w = hfVar;
    }

    private static /* synthetic */ void aKjfnRF() {
        char[] charArray = "ÂÎÌ\u008fÆÀÌÄ\u008fÃÎØ\u008fÒÉÄÍÍ\u008fëÏÈãÓÈÅÆÄ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 161);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÂÍÈÏÈÕ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 161);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Socket xj(Socket socket) {
        boolean z = socket instanceof SSLSocket;
        this.w.xj("socketip", socket.getLocalAddress().getHostAddress());
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return xj(this.xj.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.xj.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.xj.getSupportedCipherSuites();
    }

    public String toString() {
        return "Tls12SocketFactory";
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return xj(this.xj.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return xj(this.xj.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return xj(this.xj.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return xj(this.xj.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return xj(this.xj.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
