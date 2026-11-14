package com.bytedance.sdk.component.w.hf.xj.c;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.bytedance.pangle.wrapper.A5SV6n;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.w.hf.dk;
import com.bytedance.sdk.component.w.hf.xj.d.y;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class xj extends kd {
    private final u<Socket> hf;
    private final u<Socket> kd;
    private final u<Socket> u;
    private final u<Socket> w;
    private final Class<?> xj;
    private final w y = w.xj();

    public static final class hf implements y {
        private final Method hf;
        private final X509TrustManager xj;

        public hf(X509TrustManager x509TrustManager, Method method) {
            this.hf = method;
            this.xj = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof hf)) {
                return false;
            }
            hf hfVar = (hf) obj;
            return this.xj.equals(hfVar.xj) && this.hf.equals(hfVar.hf);
        }

        public int hashCode() {
            return (this.hf.hashCode() * 31) + this.xj.hashCode();
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.d.y
        public X509Certificate xj(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.hf.invoke(this.xj, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e) {
                throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.component.w.hf.xj.c.xj$xj, reason: collision with other inner class name */
    public static final class C0123xj extends com.bytedance.sdk.component.w.hf.xj.d.w {
        private final Method hf;
        private final Object xj;

        public C0123xj(Object obj, Method method) {
            this.xj = obj;
            this.hf = method;
        }

        public boolean equals(Object obj) {
            return obj instanceof C0123xj;
        }

        public int hashCode() {
            return 0;
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.d.w
        public List<Certificate> xj(List<Certificate> list, String str) {
            try {
                return (List) this.hf.invoke(this.xj, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }
    }

    public xj(Class<?> cls, u<Socket> uVar, u<Socket> uVar2, u<Socket> uVar3, u<Socket> uVar4) {
        this.xj = cls;
        this.hf = uVar;
        this.w = uVar2;
        this.u = uVar3;
        this.kd = uVar4;
    }

    private static boolean u() {
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

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public boolean hf(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return xj(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.hf(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            if (Build.VERSION.SDK_INT < 23) {
                return super.hf(str);
            }
            return false;
        } catch (InvocationTargetException e3) {
            e = e3;
            throw com.bytedance.sdk.component.w.hf.xj.w.xj("unable to determine cleartext support", e);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public void xj(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!com.bytedance.sdk.component.w.hf.xj.w.xj(e)) {
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
        } catch (Exception unused) {
        }
    }

    public static final class w {
        private final Method hf;
        private final Method w;
        private final Method xj;

        public w(Method method, Method method2, Method method3) {
            this.xj = method;
            this.hf = method2;
            this.w = method3;
        }

        public Object xj(String str) {
            Method method = this.xj;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.hf.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean xj(Object obj) {
            if (obj != null) {
                try {
                    this.w.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public static w xj() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new w(method, method3, method2);
        }
    }

    private boolean hf(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.hf(str);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public void xj(SSLSocket sSLSocket, String str, List<dk> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    A5SV6n.B3GDIM();
                    SNIHostName B2KMhB2 = A5SV6n.B2KMhB(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(B2KMhB2));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Throwable unused) {
                }
            } else {
                this.hf.hf(sSLSocket, Boolean.TRUE);
                this.w.hf(sSLSocket, str);
            }
        }
        u<Socket> uVar = this.kd;
        if (uVar == null || !uVar.xj((u<Socket>) sSLSocket)) {
            return;
        }
        this.kd.u(sSLSocket, kd.hf(list));
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public y hf(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new hf(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.hf(x509TrustManager);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public String xj(SSLSocket sSLSocket) {
        byte[] bArr;
        u<Socket> uVar = this.u;
        if (uVar == null || !uVar.xj((u<Socket>) sSLSocket) || (bArr = (byte[]) this.u.u(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.component.w.hf.xj.w.kd);
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public void xj(int i, String str, Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + TTAdConstant.INIT_LOCAL_FAIL_CODE);
                pl.xj(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i3 = min;
                }
            }
            i3 = min + 1;
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public Object xj(String str) {
        return this.y.xj(str);
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public void xj(String str, Object obj) {
        if (this.y.xj(obj)) {
            return;
        }
        xj(5, str, (Throwable) null);
    }

    private boolean xj(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return hf(str, cls, obj);
        }
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.c.kd
    public com.bytedance.sdk.component.w.hf.xj.d.w xj(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0123xj(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.xj(x509TrustManager);
        }
    }

    public static kd xj() {
        Class<?> cls;
        u uVar;
        u uVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            u uVar3 = new u(null, "setUseSessionTickets", Boolean.TYPE);
            u uVar4 = new u(null, "setHostname", String.class);
            if (u()) {
                uVar = new u(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                uVar2 = new u(null, "setAlpnProtocols", byte[].class);
            } else {
                uVar = null;
                uVar2 = null;
            }
            return new xj(cls2, uVar3, uVar4, uVar, uVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
