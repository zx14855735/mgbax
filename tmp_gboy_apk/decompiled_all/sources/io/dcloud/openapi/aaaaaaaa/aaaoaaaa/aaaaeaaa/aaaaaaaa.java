package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa;

import ADYaiT.CtFAbx;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaaa extends aaaaaaao {
    private final aaaaaaau aaaaaaaa;

    public aaaaaaaa(aaaaaaau aaaaaaauVar) {
        this.aaaaaaaa = aaaaaaauVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaao
    public List aaaaaaaa(List list, String str) {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((Certificate) arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) CtFAbx.ADYaiT(arrayList, 1);
            X509Certificate aaaaaaaa = this.aaaaaaaa.aaaaaaaa(x509Certificate);
            if (aaaaaaaa == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (aaaaaaaa(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (!z) {
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                return arrayList;
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(aaaaaaaa)) {
                arrayList.add(aaaaaaaa);
            }
            if (aaaaaaaa(aaaaaaaa, aaaaaaaa)) {
                return arrayList;
            }
            z = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof aaaaaaaa) && ((aaaaaaaa) obj).aaaaaaaa.equals(this.aaaaaaaa);
    }

    public int hashCode() {
        return this.aaaaaaaa.hashCode();
    }

    private boolean aaaaaaaa(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
