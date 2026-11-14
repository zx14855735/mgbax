package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A4TApA extends ARc23Z {
    private A4TApA() {
    }

    public static A4TApA B3GDIM() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new A4TApA();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Provider B4ZgIw() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void ARc23Z(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final void ASJ6gh(SSLSocket sSLSocket, String str, List list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) ARc23Z.A4TApA(list).toArray(new String[0]));
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final SSLContext AZkASS() {
        try {
            return SSLContext.getInstance("TLSv1.3", B4ZgIw());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", B4ZgIw());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final String AaHO0E(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.ARc23Z
    public final X509TrustManager B2KMhB(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.B2KMhB(sSLSocketFactory);
        }
        try {
            Object B25kr62 = ARc23Z.B25kr6(Object.class, sSLSocketFactory, "sslParameters");
            if (B25kr62 != null) {
                return (X509TrustManager) ARc23Z.B25kr6(X509TrustManager.class, B25kr62, "x509TrustManager");
            }
            return null;
        } catch (Exception e) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
        }
    }
}
