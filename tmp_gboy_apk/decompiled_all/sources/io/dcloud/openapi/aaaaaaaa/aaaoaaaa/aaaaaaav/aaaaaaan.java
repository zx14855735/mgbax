package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav;

import ADYaiT.CtFAbx;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aacaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.acaaaaaa;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaan {
    private static final aaaaaaan aaaaaaaa = aaaaaaaa();
    private static final Logger aaaaaaa0 = Logger.getLogger(acaaaaaa.class.getName());

    static {
        EZbPq();
    }

    private static /* synthetic */ void EZbPq() {
        char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 6);
        }
        String str = new String(charArray);
        char[] charArray2 = "ejohor".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 6);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String aaaaaaa0(SSLSocket sSLSocket) {
        return null;
    }

    public void aaaaaaaa(SSLSocket sSLSocket) {
    }

    public SSLContext aaaaaaao() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public boolean aaaaaaa0(String str) {
        return true;
    }

    public void aaaaaaaa(SSLSocket sSLSocket, String str, List list) {
    }

    public static aaaaaaan aaaaaaa0() {
        return aaaaaaaa;
    }

    public void aaaaaaaa(SSLSocketFactory sSLSocketFactory) {
    }

    public static byte[] aaaaaaa0(List list) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao aaaaaaaoVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaao();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            aacaaaaa aacaaaaaVar = (aacaaaaa) list.get(i);
            if (aacaaaaaVar != aacaaaaa.HTTP_1_0) {
                aaaaaaaoVar.writeByte(aacaaaaaVar.toString().length());
                aaaaaaaoVar.aaaaaaaa(aacaaaaaVar.toString());
            }
        }
        return aaaaaaaoVar.aaaaaaac();
    }

    public void aaaaaaaa(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void aaaaaaaa(int i, String str, Throwable th) {
        aaaaaaa0.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object aaaaaaaa(String str) {
        if (aaaaaaa0.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void aaaaaaaa(String str, Object obj) {
        if (obj == null) {
            str = CtFAbx.AcNBzu(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        aaaaaaaa(5, str, (Throwable) obj);
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaau aaaaaaa0(X509TrustManager x509TrustManager) {
        return new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaa0(x509TrustManager.getAcceptedIssuers());
    }

    public static List aaaaaaaa(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            aacaaaaa aacaaaaaVar = (aacaaaaa) list.get(i);
            if (aacaaaaaVar != aacaaaaa.HTTP_1_0) {
                arrayList.add(aacaaaaaVar.toString());
            }
        }
        return arrayList;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaaaa(X509TrustManager x509TrustManager) {
        return new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaaa(aaaaaaa0(x509TrustManager));
    }

    private static aaaaaaan aaaaaaaa() {
        aaaaaaan aaaaaaac = aaaaaaaa.aaaaaaac();
        if (aaaaaaac != null) {
            return aaaaaaac;
        }
        aaaaaaan aaaaaaac2 = aaaaaaa0.aaaaaaac();
        if (aaaaaaac2 != null) {
            return aaaaaaac2;
        }
        aaaaaaao aaaaaaac3 = aaaaaaao.aaaaaaac();
        if (aaaaaaac3 != null) {
            return aaaaaaac3;
        }
        aaaaaaan aaaaaaac4 = aaaaaaac.aaaaaaac();
        return aaaaaaac4 != null ? aaaaaaac4 : new aaaaaaan();
    }
}
