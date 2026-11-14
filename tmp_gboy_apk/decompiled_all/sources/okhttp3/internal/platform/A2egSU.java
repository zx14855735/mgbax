package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okio.Buffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A2egSU extends ARc23Z {
    private static final int MAX_LOG_LENGTH = 4000;
    private final A5SV6n closeGuard;
    private final AMqCpz getAlpnSelectedProtocol;
    private final AMqCpz setAlpnProtocols;
    private final AMqCpz setHostname;
    private final AMqCpz setUseSessionTickets;
    private final Class<?> sslParametersClass;

    /* renamed from: okhttp3.internal.platform.A2egSU$A2egSU, reason: collision with other inner class name */
    public static final class C0556A2egSU extends RpxDSP.A5SV6n {
        private final Method checkServerTrusted;
        private final Object x509TrustManagerExtensions;

        public C0556A2egSU(Object obj, Method method) {
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        @Override // RpxDSP.A5SV6n
        public final List A2egSU(String str, List list) {
            try {
                return (List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public final boolean equals(Object obj) {
            return obj instanceof C0556A2egSU;
        }

        public final int hashCode() {
            return 0;
        }
    }

    public static final class A4TApA implements RpxDSP.AMqCpz {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        public A4TApA(X509TrustManager x509TrustManager, Method method) {
            this.findByIssuerAndSignatureMethod = method;
            this.trustManager = x509TrustManager;
        }

        @Override // RpxDSP.AMqCpz
        public final X509Certificate A2egSU(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw okhttp3.internal.A5SV6n.A4TApA("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof A4TApA)) {
                return false;
            }
            A4TApA a4TApA = (A4TApA) obj;
            return this.trustManager.equals(a4TApA.trustManager) && this.findByIssuerAndSignatureMethod.equals(a4TApA.findByIssuerAndSignatureMethod);
        }

        public final int hashCode() {
            return (this.findByIssuerAndSignatureMethod.hashCode() * 31) + this.trustManager.hashCode();
        }
    }

    public static final class A5SV6n {
        private final Method getMethod;
        private final Method openMethod;
        private final Method warnIfOpenMethod;

        public A5SV6n(Method method, Method method2, Method method3) {
            this.getMethod = method;
            this.openMethod = method2;
            this.warnIfOpenMethod = method3;
        }

        public final Object A2egSU() {
            Method method = this.getMethod;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.openMethod.invoke(invoke, "response.body().close()");
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public final boolean A4TApA(Object obj) {
            if (obj != null) {
                try {
                    this.warnIfOpenMethod.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public A2egSU(Class<?> cls, AMqCpz aMqCpz, AMqCpz aMqCpz2, AMqCpz aMqCpz3, AMqCpz aMqCpz4) {
        Method method;
        Method method2;
        Method method3;
        try {
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard");
            method = cls2.getMethod("get", new Class[0]);
            method3 = cls2.getMethod("open", String.class);
            method2 = cls2.getMethod("warnIfOpen", new Class[0]);
        } catch (Exception unused) {
            method = null;
            method2 = null;
            method3 = null;
        }
        this.closeGuard = new A5SV6n(method, method3, method2);
        this.sslParametersClass = cls;
        this.setUseSessionTickets = aMqCpz;
        this.setHostname = aMqCpz2;
        this.getAlpnSelectedProtocol = aMqCpz3;
        this.setAlpnProtocols = aMqCpz4;
    }

    public static boolean B3GDIM(Class cls, Object obj, String str) {
        try {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
            } catch (NoSuchMethodException unused) {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
            }
        } catch (NoSuchMethodException unused2) {
            return true;
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final RpxDSP.A5SV6n ADYaiT(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0556A2egSU(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.ADYaiT(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final RpxDSP.AMqCpz AMqCpz(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new A4TApA(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.AMqCpz(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void ASJ6gh(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.setUseSessionTickets.A5SV6n(sSLSocket, Boolean.TRUE);
            this.setHostname.A5SV6n(sSLSocket, str);
        }
        AMqCpz aMqCpz = this.setAlpnProtocols;
        if (aMqCpz == null || aMqCpz.A2egSU(sSLSocket.getClass()) == null) {
            return;
        }
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        Object[] objArr = {buffer.readByteArray()};
        AMqCpz aMqCpz2 = this.setAlpnProtocols;
        aMqCpz2.getClass();
        try {
            aMqCpz2.A4TApA(sSLSocket, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void AYUAbz(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!okhttp3.internal.A5SV6n.B2KMhB(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 22) goto L16;
     */
    @Override // okhttp3.internal.platform.ARc23Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final javax.net.ssl.SSLContext AZkASS() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> L6
            r1 = 22
            if (r0 >= r1) goto Ld
        L6:
            java.lang.String r0 = "TLSv1.2"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> Ld
            return r0
        Ld:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L14
            return r0
        L14:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No TLS provider"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.A2egSU.AZkASS():javax.net.ssl.SSLContext");
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final String AaHO0E(SSLSocket sSLSocket) {
        AMqCpz aMqCpz = this.getAlpnSelectedProtocol;
        if (aMqCpz == null || aMqCpz.A2egSU(sSLSocket.getClass()) == null) {
            return null;
        }
        AMqCpz aMqCpz2 = this.getAlpnSelectedProtocol;
        Object[] objArr = new Object[0];
        aMqCpz2.getClass();
        try {
            byte[] bArr = (byte[]) aMqCpz2.A4TApA(sSLSocket, objArr);
            if (bArr != null) {
                return new String(bArr, okhttp3.internal.A5SV6n.UTF_8);
            }
            return null;
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final Object AcNBzu() {
        return this.closeGuard.A2egSU();
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final boolean AlLFFp(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return B3GDIM(cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return true;
        } catch (IllegalAccessException e) {
            e = e;
            throw okhttp3.internal.A5SV6n.A4TApA("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw okhttp3.internal.A5SV6n.A4TApA("unable to determine cleartext support", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw okhttp3.internal.A5SV6n.A4TApA("unable to determine cleartext support", e);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void AmA8tU(int i, String str, Throwable th) {
        int min;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int indexOf = str.indexOf(10, i2);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i2 + 4000);
                str.substring(i2, min);
                if (min >= indexOf) {
                    break;
                } else {
                    i2 = min;
                }
            }
            i2 = min + 1;
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void AzWtSf(Object obj, String str) {
        if (this.closeGuard.A4TApA(obj)) {
            return;
        }
        AmA8tU(5, str, null);
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final X509TrustManager B2KMhB(SSLSocketFactory sSLSocketFactory) {
        Object B25kr62 = ARc23Z.B25kr6(this.sslParametersClass, sSLSocketFactory, "sslParameters");
        if (B25kr62 == null) {
            try {
                B25kr62 = ARc23Z.B25kr6(Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), sSLSocketFactory, "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.B2KMhB(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) ARc23Z.B25kr6(X509TrustManager.class, B25kr62, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) ARc23Z.B25kr6(X509TrustManager.class, B25kr62, "trustManager");
    }
}
