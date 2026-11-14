package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aoaaaaaa;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class acaaaaaa implements Cloneable {
    private static SSLSocketFactory aa0aaaaa;
    final Proxy aaaaaaa0;
    final eaaaaaaa aaaaaaaa;
    final List aaaaaaac;
    final aoaaaaaa.aaaaaaao aaaaaaae;
    final List aaaaaaan;
    final List aaaaaaao;
    final List aaaaaaau;
    final ProxySelector aaaaaaav;
    final HostnameVerifier aaaaaaea;
    final aaaaaaea aaaaaaeo;
    final boolean aaaaaaoa;
    final int aaaaacaa;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaeaa;
    final boolean aaaaaoaa;
    final int aaaacaaa;
    final SSLSocketFactory aaaaeaaa;
    final boolean aaaaoaaa;
    final int aaacaaaa;
    final SocketFactory aaaeaaaa;
    final aeaaaaaa aaaoaaaa;
    final int aacaaaaa;
    final aaaeaaaa aaoaaaaa;
    final int acaaaaaa;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0 aeaaaaaa;
    final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0 aoaaaaaa;
    final aaaaaaae eaaaaaaa;
    static final List aaaaaaca = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aacaaaaa.HTTP_2, aacaaaaa.HTTP_1_1);
    static final List a0aaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaeaaa.aaaaaaav, aaaaeaaa.aaaeaaaa);

    public static final class aaaaaaa0 {
        Proxy aaaaaaa0;
        ProxySelector aaaaaaav;
        HostnameVerifier aaaaaaea;
        aaaaaaea aaaaaaeo;
        boolean aaaaaaoa;
        int aaaaacaa;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaeaa;
        boolean aaaaaoaa;
        int aaaacaaa;
        SSLSocketFactory aaaaeaaa;
        boolean aaaaoaaa;
        int aaacaaaa;
        SocketFactory aaaeaaaa;
        aeaaaaaa aaaoaaaa;
        int aacaaaaa;
        aaaeaaaa aaoaaaaa;
        int acaaaaaa;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0 aeaaaaaa;
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0 aoaaaaaa;
        aaaaaaae eaaaaaaa;
        final List aaaaaaau = new ArrayList();
        final List aaaaaaan = new ArrayList();
        eaaaaaaa aaaaaaaa = new eaaaaaaa();
        List aaaaaaao = acaaaaaa.aaaaaaca;
        List aaaaaaac = acaaaaaa.a0aaaaaa;
        aoaaaaaa.aaaaaaao aaaaaaae = aoaaaaaa.aaaaaaaa(aoaaaaaa.aaaaaaaa);

        public aaaaaaa0() {
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.aaaaaaav = proxySelector;
            if (proxySelector == null) {
                this.aaaaaaav = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaeo.aaaaaaaa();
            }
            this.aaaaaaeo = aaaaaaea.aaaaaaaa;
            this.aaaeaaaa = SocketFactory.getDefault();
            this.aaaaaaea = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaac.aaaaaaaa;
            this.eaaaaaaa = aaaaaaae.aaaaaaao;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0 aaaaaaa0Var = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0.aaaaaaaa;
            this.aeaaaaaa = aaaaaaa0Var;
            this.aoaaaaaa = aaaaaaa0Var;
            this.aaoaaaaa = new aaaeaaaa();
            this.aaaoaaaa = aeaaaaaa.aaaaaaaa;
            this.aaaaoaaa = true;
            this.aaaaaoaa = true;
            this.aaaaaaoa = true;
            this.acaaaaaa = 0;
            this.aacaaaaa = 10000;
            this.aaacaaaa = 10000;
            this.aaaacaaa = 10000;
            this.aaaaacaa = 0;
        }

        public acaaaaaa aaaaaaaa() {
            return new acaaaaaa(this);
        }
    }

    public class aaaaaaaa extends io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa {
        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public void aaaaaaa0(aaaeaaaa aaaeaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar) {
            aaaeaaaaVar.aaaaaaa0(aaaaaaaoVar);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public void aaaaaaaa(aaaoaaaa.aaaaaaaa aaaaaaaaVar, String str) {
            aaaaaaaaVar.aaaaaaaa(str);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public void aaaaaaaa(aaaoaaaa.aaaaaaaa aaaaaaaaVar, String str, String str2) {
            aaaaaaaaVar.aaaaaaa0(str, str2);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public boolean aaaaaaaa(aaaeaaaa aaaeaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaoVar) {
            return aaaeaaaaVar.aaaaaaaa(aaaaaaaoVar);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaao aaaaaaaa(aaaeaaaa aaaeaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar, aa0aaaaa aa0aaaaaVar) {
            return aaaeaaaaVar.aaaaaaaa(aaaaaaaaVar, aaaaaaaeVar, aa0aaaaaVar);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public boolean aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar2) {
            return aaaaaaaaVar.aaaaaaaa(aaaaaaaaVar2);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public Socket aaaaaaaa(aaaeaaaa aaaeaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaaa aaaaaaaaVar, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaae aaaaaaaeVar) {
            return aaaeaaaaVar.aaaaaaaa(aaaaaaaaVar, aaaaaaaeVar);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaac.aaaaaaac aaaaaaaa(aaaeaaaa aaaeaaaaVar) {
            return aaaeaaaaVar.aaaaaaau;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public int aaaaaaaa(aaaaaaca.aaaaaaaa aaaaaaaaVar) {
            return aaaaaaaaVar.aaaaaaao;
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public void aaaaaaaa(aaaaeaaa aaaaeaaaVar, SSLSocket sSLSocket, boolean z) {
            aaaaeaaaVar.aaaaaaaa(sSLSocket, z);
        }

        @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa
        public IOException aaaaaaaa(aaaaaaac aaaaaaacVar, IOException iOException) {
            return ((aaacaaaa) aaaaaaacVar).aaaaaaaa(iOException);
        }
    }

    static {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaaa.aaaaaaaa = new aaaaaaaa();
        aa0aaaaa = null;
        ufIlVv();
    }

    public acaaaaaa(aaaaaaa0 aaaaaaa0Var) {
        boolean z;
        this.aaaaaaaa = aaaaaaa0Var.aaaaaaaa;
        this.aaaaaaa0 = aaaaaaa0Var.aaaaaaa0;
        this.aaaaaaao = aaaaaaa0Var.aaaaaaao;
        List list = aaaaaaa0Var.aaaaaaac;
        this.aaaaaaac = list;
        this.aaaaaaau = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaa0Var.aaaaaaau);
        this.aaaaaaan = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaa0Var.aaaaaaan);
        this.aaaaaaae = aaaaaaa0Var.aaaaaaae;
        this.aaaaaaav = aaaaaaa0Var.aaaaaaav;
        this.aaaaaaeo = aaaaaaa0Var.aaaaaaeo;
        this.aaaeaaaa = aaaaaaa0Var.aaaeaaaa;
        Iterator it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || ((aaaaeaaa) it.next()).aaaaaaa0();
            }
        }
        SSLSocketFactory sSLSocketFactory = aaaaaaa0Var.aaaaeaaa;
        if (sSLSocketFactory == null && z) {
            X509TrustManager aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa();
            if (aa0aaaaa == null) {
                aa0aaaaa = aaaaaaaa(aaaaaaaa2);
            }
            this.aaaaeaaa = aa0aaaaa;
            this.aaaaaeaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao.aaaaaaaa(aaaaaaaa2);
        } else {
            this.aaaaeaaa = sSLSocketFactory;
            this.aaaaaeaa = aaaaaaa0Var.aaaaaeaa;
        }
        if (this.aaaaeaaa != null) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaaa(this.aaaaeaaa);
        }
        this.aaaaaaea = aaaaaaa0Var.aaaaaaea;
        this.eaaaaaaa = aaaaaaa0Var.eaaaaaaa.aaaaaaaa(this.aaaaaeaa);
        this.aeaaaaaa = aaaaaaa0Var.aeaaaaaa;
        this.aoaaaaaa = aaaaaaa0Var.aoaaaaaa;
        this.aaoaaaaa = aaaaaaa0Var.aaoaaaaa;
        this.aaaoaaaa = aaaaaaa0Var.aaaoaaaa;
        this.aaaaoaaa = aaaaaaa0Var.aaaaoaaa;
        this.aaaaaoaa = aaaaaaa0Var.aaaaaoaa;
        this.aaaaaaoa = aaaaaaa0Var.aaaaaaoa;
        this.acaaaaaa = aaaaaaa0Var.acaaaaaa;
        this.aacaaaaa = aaaaaaa0Var.aacaaaaa;
        this.aaacaaaa = aaaaaaa0Var.aaacaaaa;
        this.aaaacaaa = aaaaaaa0Var.aaaacaaa;
        this.aaaaacaa = aaaaaaa0Var.aaaaacaa;
        if (this.aaaaaaau.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.aaaaaaau);
        }
        if (this.aaaaaaan.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.aaaaaaan);
        }
    }

    private static SSLSocketFactory aaaaaaaa(X509TrustManager x509TrustManager) {
        try {
            SSLContext aaaaaaao = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaav.aaaaaaan.aaaaaaa0().aaaaaaao();
            aaaaaaao.init(null, new TrustManager[]{x509TrustManager}, null);
            return aaaaaaao.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("No System TLS", (Exception) e);
        }
    }

    private static /* synthetic */ void ufIlVv() {
        char[] charArray = "846u<:6>u94\"u(3>77u\u001152\u0019)2?<>".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '[');
        }
        String str = new String(charArray);
        char[] charArray2 = "87252/".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '[');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int aaaaaaa0() {
        return this.acaaaaaa;
    }

    public int aaaaaaac() {
        return this.aacaaaaa;
    }

    public aaaaaaea aaaaaaae() {
        return this.aaaaaaeo;
    }

    public List aaaaaaan() {
        return this.aaaaaaac;
    }

    public aaaaaaae aaaaaaao() {
        return this.eaaaaaaa;
    }

    public aaaeaaaa aaaaaaau() {
        return this.aaoaaaaa;
    }

    public eaaaaaaa aaaaaaav() {
        return this.aaaaaaaa;
    }

    public HostnameVerifier aaaaaaea() {
        return this.aaaaaaea;
    }

    public aeaaaaaa aaaaaaeo() {
        return this.aaaoaaaa;
    }

    public ProxySelector aaaaaaoa() {
        return this.aaaaaaav;
    }

    public int aaaaacaa() {
        return this.aaaacaaa;
    }

    public boolean aaaaaeaa() {
        return this.aaaaoaaa;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0 aaaaaoaa() {
        return this.aeaaaaaa;
    }

    public SSLSocketFactory aaaacaaa() {
        return this.aaaaeaaa;
    }

    public boolean aaaaeaaa() {
        return this.aaaaaoaa;
    }

    public Proxy aaaaoaaa() {
        return this.aaaaaaa0;
    }

    public SocketFactory aaacaaaa() {
        return this.aaaeaaaa;
    }

    public aoaaaaaa.aaaaaaao aaaeaaaa() {
        return this.aaaaaaae;
    }

    public List aaaoaaaa() {
        return this.aaaaaaao;
    }

    public boolean aacaaaaa() {
        return this.aaaaaaoa;
    }

    public int aaoaaaaa() {
        return this.aaaaacaa;
    }

    public int acaaaaaa() {
        return this.aaacaaaa;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaao.aaaaaaao aeaaaaaa() {
        return null;
    }

    public List aoaaaaaa() {
        return this.aaaaaaan;
    }

    public List eaaaaaaa() {
        return this.aaaaaaau;
    }

    public io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaa0 aaaaaaaa() {
        return this.aoaaaaaa;
    }

    public aaaaaaac aaaaaaaa(aaaacaaa aaaacaaaVar) {
        return aaacaaaa.aaaaaaaa(this, aaaacaaaVar, false);
    }
}
