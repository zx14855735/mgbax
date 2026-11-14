package com.bytedance.sdk.component.w.hf.xj.c;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.w.hf.dk;
import com.bytedance.sdk.component.w.hf.ra;
import com.bytedance.sdk.component.w.hf.xj.d.y;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static final kd xj = xj();
    private static final Logger hf = Logger.getLogger(ra.class.getName());

    static {
        lNienSA();
    }

    private static /* synthetic */ void lNienSA() {
        char[] charArray = "\u000e\u0002\u0000C\n\f\u0000\bC\u000f\u0002\u0014C\u001e\u0005\b\u0001\u0001C'\u0003\u0004/\u001f\u0004\t\n\b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'm');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u000e\u0001\u0004\u0003\u0004\u0019".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'm');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void hf(SSLSocket sSLSocket) {
    }

    public String w() {
        return "OkHttp";
    }

    public String xj(SSLSocket sSLSocket) {
        return null;
    }

    public boolean hf(String str) {
        return true;
    }

    public void xj(SSLSocket sSLSocket, String str, List<dk> list) {
    }

    public static kd hf() {
        return xj;
    }

    public void xj(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public static byte[] hf(List<dk> list) {
        com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            dk dkVar = list.get(i);
            if (dkVar != dk.HTTP_1_0) {
                wVar.d(dkVar.toString().length());
                wVar.hf(dkVar.toString());
            }
        }
        try {
            return wVar.e();
        } catch (IOException e) {
            pl.xj(e);
            return null;
        }
    }

    public void xj(int i, String str, Throwable th) {
        hf.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object xj(String str) {
        if (hf.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void xj(String str, Object obj) {
        if (obj == null) {
            str = CtFAbx.AcNBzu(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        xj(5, str, (Throwable) obj);
    }

    public y hf(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.w.hf.xj.d.hf(x509TrustManager.getAcceptedIssuers());
    }

    public static List<String> xj(List<dk> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            dk dkVar = list.get(i);
            if (dkVar != dk.HTTP_1_0) {
                arrayList.add(dkVar.toString());
            }
        }
        return arrayList;
    }

    public com.bytedance.sdk.component.w.hf.xj.d.w xj(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.w.hf.xj.d.xj(hf(x509TrustManager));
    }

    private static kd xj() {
        kd xj2 = xj.xj();
        if (xj2 != null) {
            return xj2;
        }
        hf xj3 = hf.xj();
        if (xj3 != null) {
            return xj3;
        }
        kd xj4 = w.xj();
        return xj4 != null ? xj4 : new kd();
    }
}
