package okhttp3.internal.platform;

import ADYaiT.CtFAbx;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ARc23Z {
    public static final int INFO = 4;
    private static final ARc23Z PLATFORM;
    public static final int WARN = 5;
    private static final Logger logger;

    static {
        Class<?> cls;
        ARc23Z aRc23Z;
        AMqCpz aMqCpz;
        AMqCpz aMqCpz2;
        ADYaiT aDYaiT = null;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            AMqCpz aMqCpz3 = new AMqCpz(null, "setUseSessionTickets", Boolean.TYPE);
            AMqCpz aMqCpz4 = new AMqCpz(null, "setHostname", String.class);
            if (Security.getProvider("GMSCore_OpenSSL") == null) {
                try {
                    Class.forName("android.net.Network");
                } catch (ClassNotFoundException unused2) {
                    aMqCpz = null;
                    aMqCpz2 = null;
                }
            }
            aMqCpz = new AMqCpz(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            aMqCpz2 = new AMqCpz(null, "setAlpnProtocols", byte[].class);
            aRc23Z = new A2egSU(cls2, aMqCpz3, aMqCpz4, aMqCpz, aMqCpz2);
        } catch (ClassNotFoundException unused3) {
            aRc23Z = null;
        }
        if (aRc23Z == null) {
            if (!("conscrypt".equals(System.getProperty("okhttp.platform")) ? true : "Conscrypt".equals(Security.getProviders()[0].getName())) || (aRc23Z = A4TApA.B3GDIM()) == null) {
                try {
                    aRc23Z = new A5SV6n(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
                } catch (NoSuchMethodException unused4) {
                    aRc23Z = null;
                }
                if (aRc23Z == null) {
                    try {
                        Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        aDYaiT = new ADYaiT(cls3.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls3.getMethod("get", SSLSocket.class), cls3.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                    } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    }
                    aRc23Z = aDYaiT != null ? aDYaiT : new ARc23Z();
                }
            }
        }
        PLATFORM = aRc23Z;
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static ArrayList A4TApA(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public static ARc23Z AZOQYO() {
        return PLATFORM;
    }

    public static Object B25kr6(Class cls, Object obj, String str) {
        Object B25kr62;
        for (Class<?> cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (B25kr62 = B25kr6(Object.class, obj, "delegate")) == null) {
            return null;
        }
        return B25kr6(cls, B25kr62, str);
    }

    public void A2egSU(SSLSocket sSLSocket) {
    }

    public final RpxDSP.A5SV6n A5SV6n(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager B2KMhB2 = B2KMhB(sSLSocketFactory);
        if (B2KMhB2 != null) {
            return ADYaiT(B2KMhB2);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + PLATFORM + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public RpxDSP.A5SV6n ADYaiT(X509TrustManager x509TrustManager) {
        return new RpxDSP.A2egSU(AMqCpz(x509TrustManager));
    }

    public RpxDSP.AMqCpz AMqCpz(X509TrustManager x509TrustManager) {
        return new RpxDSP.A4TApA(x509TrustManager.getAcceptedIssuers());
    }

    public void ARc23Z(SSLSocketFactory sSLSocketFactory) {
    }

    public void ASJ6gh(SSLSocket sSLSocket, String str, List list) {
    }

    public void AYUAbz(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public SSLContext AZkASS() {
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

    public String AaHO0E(SSLSocket sSLSocket) {
        return null;
    }

    public Object AcNBzu() {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean AlLFFp(String str) {
        return true;
    }

    public void AmA8tU(int i, String str, Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void AzWtSf(Object obj, String str) {
        if (obj == null) {
            str = CtFAbx.AcNBzu(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        AmA8tU(5, str, (Throwable) obj);
    }

    public X509TrustManager B2KMhB(SSLSocketFactory sSLSocketFactory) {
        try {
            Object B25kr62 = B25kr6(Class.forName("sun.security.ssl.SSLContextImpl"), sSLSocketFactory, "context");
            if (B25kr62 == null) {
                return null;
            }
            return (X509TrustManager) B25kr6(X509TrustManager.class, B25kr62, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
