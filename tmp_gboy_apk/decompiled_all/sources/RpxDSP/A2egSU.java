package RpxDSP;

import ADYaiT.CtFAbx;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU extends A5SV6n {
    private static final int MAX_SIGNERS = 9;
    private final AMqCpz trustRootIndex;

    public A2egSU(AMqCpz aMqCpz) {
        this.trustRootIndex = aMqCpz;
    }

    @Override // RpxDSP.A5SV6n
    public final List A2egSU(String str, List list) {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) CtFAbx.ADYaiT(arrayList, 1);
            X509Certificate A2egSU2 = this.trustRootIndex.A2egSU(x509Certificate);
            if (A2egSU2 == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                        try {
                            x509Certificate.verify(x509Certificate2.getPublicKey());
                            it.remove();
                            arrayList.add(x509Certificate2);
                        } catch (GeneralSecurityException unused) {
                        }
                    }
                }
                if (!z) {
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                return arrayList;
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(A2egSU2)) {
                arrayList.add(A2egSU2);
            }
            if (A2egSU2.getIssuerDN().equals(A2egSU2.getSubjectDN())) {
                try {
                    A2egSU2.verify(A2egSU2.getPublicKey());
                    return arrayList;
                } catch (GeneralSecurityException unused2) {
                }
            }
            z = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof A2egSU) && ((A2egSU) obj).trustRootIndex.equals(this.trustRootIndex);
    }

    public final int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
