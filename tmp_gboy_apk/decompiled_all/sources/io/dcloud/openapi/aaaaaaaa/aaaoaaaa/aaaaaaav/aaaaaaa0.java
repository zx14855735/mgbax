package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav;

import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class aaaaaaa0 extends aaaaaaan {
    private final aaaaaaau aaaaaaac;
    private final aaaaaaau aaaaaaae;
    private final aaaaaaau aaaaaaan;
    private final Class aaaaaaao;
    private final aaaaaaau aaaaaaau;
    private final aaaaaaao aaaaaaav = aaaaaaao.aaaaaaaa();

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaa0$aaaaaaa0, reason: collision with other inner class name */
    public static final class C0522aaaaaaa0 implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaau {
        private final Method aaaaaaa0;
        private final X509TrustManager aaaaaaaa;

        public C0522aaaaaaa0(X509TrustManager x509TrustManager, Method method) {
            this.aaaaaaa0 = method;
            this.aaaaaaaa = x509TrustManager;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaau
        public X509Certificate aaaaaaaa(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.aaaaaaa0.invoke(this.aaaaaaaa, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0522aaaaaaa0)) {
                return false;
            }
            C0522aaaaaaa0 c0522aaaaaaa0 = (C0522aaaaaaa0) obj;
            return this.aaaaaaaa.equals(c0522aaaaaaa0.aaaaaaaa) && this.aaaaaaa0.equals(c0522aaaaaaa0.aaaaaaa0);
        }

        public int hashCode() {
            return (this.aaaaaaa0.hashCode() * 31) + this.aaaaaaaa.hashCode();
        }
    }

    public static final class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao {
        private final Method aaaaaaa0;
        private final Object aaaaaaaa;

        public aaaaaaaa(Object obj, Method method) {
            this.aaaaaaaa = obj;
            this.aaaaaaa0 = method;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao
        public List aaaaaaaa(List list, String str) {
            try {
                return (List) this.aaaaaaa0.invoke(this.aaaaaaaa, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof aaaaaaaa;
        }

        public int hashCode() {
            return 0;
        }
    }

    public aaaaaaa0(Class cls, aaaaaaau aaaaaaauVar, aaaaaaau aaaaaaauVar2, aaaaaaau aaaaaaauVar3, aaaaaaau aaaaaaauVar4) {
        this.aaaaaaao = cls;
        this.aaaaaaac = aaaaaaauVar;
        this.aaaaaaau = aaaaaaauVar2;
        this.aaaaaaan = aaaaaaauVar3;
        this.aaaaaaae = aaaaaaauVar4;
    }

    public static aaaaaaan aaaaaaac() {
        Class<?> cls;
        aaaaaaau aaaaaaauVar;
        aaaaaaau aaaaaaauVar2;
        if (aaaaaaau() == 0) {
            return null;
        }
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            aaaaaaau aaaaaaauVar3 = new aaaaaaau(null, "setUseSessionTickets", Boolean.TYPE);
            aaaaaaau aaaaaaauVar4 = new aaaaaaau(null, "setHostname", String.class);
            if (aaaaaaan()) {
                aaaaaaauVar = new aaaaaaau(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                aaaaaaauVar2 = new aaaaaaau(null, "setAlpnProtocols", byte[].class);
            } else {
                aaaaaaauVar = null;
                aaaaaaauVar2 = null;
            }
            return new aaaaaaa0(cls2, aaaaaaauVar3, aaaaaaauVar4, aaaaaaauVar, aaaaaaauVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private static boolean aaaaaaan() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static int aaaaaaau() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public String aaaaaaa0(SSLSocket sSLSocket) {
        byte[] bArr;
        aaaaaaau aaaaaaauVar = this.aaaaaaan;
        if (aaaaaaauVar == null || !aaaaaaauVar.aaaaaaaa(sSLSocket) || (bArr = (byte[]) this.aaaaaaan.aaaaaaac(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaeaaaa);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(e)) {
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
    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public javax.net.ssl.SSLContext aaaaaaao() {
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
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaa0.aaaaaaao():javax.net.ssl.SSLContext");
    }

    public static final class aaaaaaao {
        private final Method aaaaaaa0;
        private final Method aaaaaaaa;
        private final Method aaaaaaao;

        public aaaaaaao(Method method, Method method2, Method method3) {
            this.aaaaaaaa = method;
            this.aaaaaaa0 = method2;
            this.aaaaaaao = method3;
        }

        public Object aaaaaaaa(String str) {
            Method method = this.aaaaaaaa;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, null);
                    this.aaaaaaa0.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean aaaaaaaa(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.aaaaaaao.invoke(obj, null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public static aaaaaaao aaaaaaaa() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new aaaaaaao(method3, method2, method);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public boolean aaaaaaa0(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return super.aaaaaaa0(str);
        }
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return aaaaaaa0(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.aaaaaaa0(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to determine cleartext support", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("unable to determine cleartext support", e);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.aaaaaaac.aaaaaaao(sSLSocket, Boolean.TRUE);
            this.aaaaaaau.aaaaaaao(sSLSocket, str);
        }
        aaaaaaau aaaaaaauVar = this.aaaaaaae;
        if (aaaaaaauVar == null || !aaaaaaauVar.aaaaaaaa(sSLSocket)) {
            return;
        }
        this.aaaaaaae.aaaaaaac(sSLSocket, aaaaaaan.aaaaaaa0(list));
    }

    private boolean aaaaaaa0(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return aaaaaaaa(str, cls, obj);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaau aaaaaaa0(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C0522aaaaaaa0(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.aaaaaaa0(x509TrustManager);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(int i, String str, Throwable th) {
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
                min = Math.min(indexOf, i2 + TTAdConstant.INIT_LOCAL_FAIL_CODE);
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

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public Object aaaaaaaa(String str) {
        return this.aaaaaaav.aaaaaaaa(str);
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public void aaaaaaaa(String str, Object obj) {
        if (this.aaaaaaav.aaaaaaaa(obj)) {
            return;
        }
        aaaaaaaa(5, str, (Throwable) null);
    }

    private boolean aaaaaaaa(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.aaaaaaa0(str);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan
    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaaaa(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new aaaaaaaa(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.aaaaaaaa(x509TrustManager);
        }
    }
}
