package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaoaaaaa {
    private final aaaaaaav aaaaaaa0;
    private final aaa0aaaa aaaaaaaa;
    private final List aaaaaaac;
    private final List aaaaaaao;

    private aaoaaaaa(aaa0aaaa aaa0aaaaVar, aaaaaaav aaaaaaavVar, List list, List list2) {
        this.aaaaaaaa = aaa0aaaaVar;
        this.aaaaaaa0 = aaaaaaavVar;
        this.aaaaaaao = list;
        this.aaaaaaac = list2;
    }

    public static aaoaaaaa aaaaaaaa(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        aaaaaaav aaaaaaaa = aaaaaaav.aaaaaaaa(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        aaa0aaaa aaaaaaaa2 = aaa0aaaa.aaaaaaaa(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List aaaaaaaa3 = certificateArr != null ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(certificateArr) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new aaoaaaaa(aaaaaaaa2, aaaaaaaa, aaaaaaaa3, localCertificates != null ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(localCertificates) : Collections.EMPTY_LIST);
    }

    public List aaaaaaa0() {
        return this.aaaaaaao;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aaoaaaaa)) {
            return false;
        }
        aaoaaaaa aaoaaaaaVar = (aaoaaaaa) obj;
        return this.aaaaaaaa.equals(aaoaaaaaVar.aaaaaaaa) && this.aaaaaaa0.equals(aaoaaaaaVar.aaaaaaa0) && this.aaaaaaao.equals(aaoaaaaaVar.aaaaaaao) && this.aaaaaaac.equals(aaoaaaaaVar.aaaaaaac);
    }

    public int hashCode() {
        return this.aaaaaaac.hashCode() + A2egSU.A5SV6n(this.aaaaaaao, (this.aaaaaaa0.hashCode() + ((this.aaaaaaaa.hashCode() + 527) * 31)) * 31, 31);
    }

    public aaaaaaav aaaaaaaa() {
        return this.aaaaaaa0;
    }
}
