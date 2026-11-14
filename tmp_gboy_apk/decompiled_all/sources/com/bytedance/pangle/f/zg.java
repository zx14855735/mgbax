package com.bytedance.pangle.f;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class zg extends yo {
    private int hf;
    private final byte[] xj;

    public zg(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.hf = -1;
        this.xj = bArr;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zg)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((zg) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.f.yo, java.security.cert.Certificate
    public byte[] getEncoded() {
        return this.xj;
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.hf == -1) {
            try {
                this.hf = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.hf = 0;
            }
        }
        return this.hf;
    }
}
