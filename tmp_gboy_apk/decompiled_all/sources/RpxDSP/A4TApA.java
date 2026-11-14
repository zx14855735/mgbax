package RpxDSP;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA implements AMqCpz {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts = new LinkedHashMap();

    public A4TApA(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.subjectToCaCerts.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.subjectToCaCerts.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // RpxDSP.AMqCpz
    public final X509Certificate A2egSU(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
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

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof A4TApA) && ((A4TApA) obj).subjectToCaCerts.equals(this.subjectToCaCerts);
    }

    public final int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
