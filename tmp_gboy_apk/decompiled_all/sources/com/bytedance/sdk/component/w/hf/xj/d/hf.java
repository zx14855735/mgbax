package com.bytedance.sdk.component.w.hf.xj.d;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class hf implements y {
    private final Map<X500Principal, Set<X509Certificate>> xj = new LinkedHashMap();

    public hf(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.xj.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.xj.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof hf) && ((hf) obj).xj.equals(this.xj);
    }

    public int hashCode() {
        return this.xj.hashCode();
    }

    @Override // com.bytedance.sdk.component.w.hf.xj.d.y
    public X509Certificate xj(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.xj.get(x509Certificate.getIssuerX500Principal());
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
}
