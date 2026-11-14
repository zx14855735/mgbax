package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n extends ARc23Z {
    final Method getProtocolMethod;
    final Method setProtocolMethod;

    public A5SV6n(Method method, Method method2) {
        this.setProtocolMethod = method;
        this.getProtocolMethod = method2;
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void ASJ6gh(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList A4TApA2 = ARc23Z.A4TApA(list);
            this.setProtocolMethod.invoke(sSLParameters, A4TApA2.toArray(new String[A4TApA2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.A5SV6n.A4TApA("unable to set ssl parameters", e);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final String AaHO0E(SSLSocket sSLSocket) {
        try {
            String str = (String) this.getProtocolMethod.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.A5SV6n.A4TApA("unable to get selected protocols", e);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final X509TrustManager B2KMhB(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
