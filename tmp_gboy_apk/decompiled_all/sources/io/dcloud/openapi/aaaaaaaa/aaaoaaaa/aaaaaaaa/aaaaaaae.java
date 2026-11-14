package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaae {
    public static final aaaaaaae aaaaaaao = new aaaaaaaa().aaaaaaaa();
    private final io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaaa0;
    private final Set aaaaaaaa;

    public static final class aaaaaaaa {
        private final List aaaaaaaa = new ArrayList();

        public aaaaaaae aaaaaaaa() {
            return new aaaaaaae(new LinkedHashSet(this.aaaaaaaa), null);
        }
    }

    static {
        Fupqx();
    }

    public aaaaaaae(Set set, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaaaoVar) {
        this.aaaaaaaa = set;
        this.aaaaaaa0 = aaaaaaaoVar;
    }

    private static /* synthetic */ void Fupqx() {
        char[] charArray = "¹µ·ô½»·¿ô¸µ£ô©²¿¶¶ô\u0090´³\u0098¨³¾½¿".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 218);
        }
        String str = new String(charArray);
        char[] charArray2 = "¹¶³´³®".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 218);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void aaaaaaaa(String str, List list) {
        List aaaaaaaa2 = aaaaaaaa(str);
        if (aaaaaaaa2.isEmpty()) {
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        if (aaaaaaaoVar != null) {
            list = aaaaaaaoVar.aaaaaaaa(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (aaaaaaaa2.size() > 0) {
                aaaaaaan.aaaaaaaa(aaaaaaaa2.get(0));
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            sb.append("\n    ");
            sb.append(aaaaaaaa((Certificate) x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size3 = aaaaaaaa2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            aaaaaaan.aaaaaaaa(aaaaaaaa2.get(i3));
            sb.append("\n    null");
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aaaaaaae)) {
            return false;
        }
        aaaaaaae aaaaaaaeVar = (aaaaaaae) obj;
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaa0, aaaaaaaeVar.aaaaaaa0) && this.aaaaaaaa.equals(aaaaaaaeVar.aaaaaaaa);
    }

    public int hashCode() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaaaoVar = this.aaaaaaa0;
        return this.aaaaaaaa.hashCode() + ((aaaaaaaoVar != null ? aaaaaaaoVar.hashCode() : 0) * 31);
    }

    public List aaaaaaaa(String str) {
        List list = Collections.EMPTY_LIST;
        Iterator it = this.aaaaaaaa.iterator();
        if (!it.hasNext()) {
            return list;
        }
        aaaaaaan.aaaaaaaa(it.next());
        throw null;
    }

    public aaaaaaae aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao aaaaaaaoVar) {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(this.aaaaaaa0, aaaaaaaoVar) ? this : new aaaaaaae(this.aaaaaaaa, aaaaaaaoVar);
    }

    public static String aaaaaaaa(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + aaaaaaaa((X509Certificate) certificate).aaaaaaaa();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan aaaaaaaa(X509Certificate x509Certificate) {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaan.aaaaaaaa(x509Certificate.getPublicKey().getEncoded()).aaaaaaao();
    }
}
