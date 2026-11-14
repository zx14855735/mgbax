package com.bytedance.sdk.component.w.hf;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e {
    private final f hf;
    private final List<Certificate> u;
    private final List<Certificate> w;
    private final en xj;

    private e(en enVar, f fVar, List<Certificate> list, List<Certificate> list2) {
        this.xj = enVar;
        this.hf = fVar;
        this.w = list;
        this.u = list2;
    }

    public static e xj(SSLSession sSLSession) {
        String str;
        Certificate[] certificateArr = null;
        try {
            str = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        f xj = f.xj(str);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        en xj2 = en.xj(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        List xj3 = certificateArr != null ? com.bytedance.sdk.component.w.hf.xj.w.xj(certificateArr) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new e(xj2, xj, xj3, localCertificates != null ? com.bytedance.sdk.component.w.hf.xj.w.xj(localCertificates) : Collections.EMPTY_LIST);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.xj.equals(eVar.xj) && this.hf.equals(eVar.hf) && this.w.equals(eVar.w) && this.u.equals(eVar.u);
    }

    public int hashCode() {
        return this.u.hashCode() + A2egSU.A5SV6n(this.w, (this.hf.hashCode() + ((this.xj.hashCode() + 527) * 31)) * 31, 31);
    }

    public f hf() {
        return this.hf;
    }

    public List<Certificate> u() {
        return this.u;
    }

    public List<Certificate> w() {
        return this.w;
    }

    public en xj() {
        return this.xj;
    }
}
