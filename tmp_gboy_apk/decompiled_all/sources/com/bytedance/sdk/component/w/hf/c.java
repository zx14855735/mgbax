package com.bytedance.sdk.component.w.hf;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    public static final c xj = new xj().xj();
    private final Set<hf> hf;
    private final com.bytedance.sdk.component.w.hf.xj.d.w w;

    public static final class hf {
        final String hf;
        final com.bytedance.sdk.component.w.xj.y u;
        final String w;
        final String xj;

        public boolean equals(Object obj) {
            if (!(obj instanceof hf)) {
                return false;
            }
            hf hfVar = (hf) obj;
            return this.xj.equals(hfVar.xj) && this.w.equals(hfVar.w) && this.u.equals(hfVar.u);
        }

        public int hashCode() {
            return this.u.hashCode() + A2egSU.A2egSU(A2egSU.A2egSU(527, 31, this.xj), 31, this.w);
        }

        public String toString() {
            return this.w + this.u.hf();
        }

        public boolean xj(String str) {
            if (!this.xj.startsWith("*.")) {
                return str.equals(this.hf);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 != this.hf.length()) {
                return false;
            }
            String str2 = this.hf;
            return str.regionMatches(false, indexOf + 1, str2, 0, str2.length());
        }
    }

    public static final class xj {
        private final List<hf> xj = new ArrayList();

        public c xj() {
            return new c(new LinkedHashSet(this.xj), null);
        }
    }

    static {
        XQYRx();
    }

    public c(Set<hf> set, com.bytedance.sdk.component.w.hf.xj.d.w wVar) {
        this.hf = set;
        this.w = wVar;
    }

    private static /* synthetic */ void XQYRx() {
        char[] charArray = "ÑÝß\u009cÕÓß×\u009cÐÝË\u009cÁÚ×ÞÞ\u009cøÜÛðÀÛÖÕ×".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 178);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÑÞÛÜÛÆ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 178);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.bytedance.sdk.component.w.xj.y hf(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.w.xj.y.xj(x509Certificate.getPublicKey().getEncoded()).u();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return com.bytedance.sdk.component.w.hf.xj.w.xj(this.w, cVar.w) && this.hf.equals(cVar.hf);
    }

    public int hashCode() {
        com.bytedance.sdk.component.w.hf.xj.d.w wVar = this.w;
        return this.hf.hashCode() + ((wVar != null ? wVar.hashCode() : 0) * 31);
    }

    public void xj(String str, List<Certificate> list) {
        List<hf> xj2 = xj(str);
        if (xj2.isEmpty()) {
            return;
        }
        com.bytedance.sdk.component.w.hf.xj.d.w wVar = this.w;
        if (wVar != null) {
            list = wVar.xj(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = xj2.size();
            com.bytedance.sdk.component.w.xj.y yVar = null;
            com.bytedance.sdk.component.w.xj.y yVar2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                hf hfVar = xj2.get(i2);
                if (hfVar.w.equals("sha256/")) {
                    if (yVar == null) {
                        yVar = hf(x509Certificate);
                    }
                    if (hfVar.u.equals(yVar)) {
                        return;
                    }
                } else {
                    if (!hfVar.w.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + hfVar.w);
                    }
                    if (yVar2 == null) {
                        yVar2 = xj(x509Certificate);
                    }
                    if (hfVar.u.equals(yVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(xj((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = xj2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            hf hfVar2 = xj2.get(i4);
            sb.append("\n    ");
            sb.append(hfVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List<hf> xj(String str) {
        List<hf> list = Collections.EMPTY_LIST;
        for (hf hfVar : this.hf) {
            if (hfVar.xj(str)) {
                if (list.isEmpty()) {
                    list = new ArrayList<>();
                }
                list.add(hfVar);
            }
        }
        return list;
    }

    public c xj(com.bytedance.sdk.component.w.hf.xj.d.w wVar) {
        return com.bytedance.sdk.component.w.hf.xj.w.xj(this.w, wVar) ? this : new c(this.hf, wVar);
    }

    public static String xj(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + hf((X509Certificate) certificate).hf();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static com.bytedance.sdk.component.w.xj.y xj(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.w.xj.y.xj(x509Certificate.getPublicKey().getEncoded()).w();
    }
}
