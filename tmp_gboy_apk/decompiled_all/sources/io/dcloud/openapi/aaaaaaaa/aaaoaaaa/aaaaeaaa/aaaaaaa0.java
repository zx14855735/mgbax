package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaa0 implements aaaaaaau {
    private final Map aaaaaaaa = new LinkedHashMap();

    public aaaaaaa0(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = (Set) this.aaaaaaaa.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.aaaaaaaa.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa.aaaaaaau
    public X509Certificate aaaaaaaa(X509Certificate x509Certificate) {
        Set<X509Certificate> set = (Set) this.aaaaaaaa.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof aaaaaaa0) && ((aaaaaaa0) obj).aaaaaaaa.equals(this.aaaaaaaa);
    }

    public int hashCode() {
        return this.aaaaaaaa.hashCode();
    }
}
