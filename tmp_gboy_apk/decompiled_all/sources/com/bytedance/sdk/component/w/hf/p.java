package com.bytedance.sdk.component.w.hf;

import J3FDQU.A2egSU;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class p {
    private static final f[] f;
    public static final p hf;
    public static final p w;
    public static final p xj;
    final String[] c;
    final boolean kd;
    final boolean u;
    final String[] y;

    static {
        f[] fVarArr = {f.p, f.g, f.f10224pl, f.am, f.zg, f.qt, f.c, f.d, f.f, f.tf, f.kd, f.y, f.w, f.u, f.hf};
        f = fVarArr;
        xj xj2 = new xj(true).xj(fVarArr);
        en enVar = en.TLS_1_0;
        p xj3 = xj2.xj(en.TLS_1_3, en.TLS_1_2, en.TLS_1_1, enVar).xj(true).xj();
        xj = xj3;
        hf = new xj(xj3).xj(enVar).xj(true).xj();
        w = new xj(false).xj();
        NwUZa();
    }

    public p(xj xjVar) {
        this.u = xjVar.xj;
        this.y = xjVar.hf;
        this.c = xjVar.w;
        this.kd = xjVar.u;
    }

    private static /* synthetic */ void NwUZa() {
        char[] charArray = "ÇËÉ\u008aÃÅÉÁ\u008aÆËÝ\u008a×ÌÁÈÈ\u008aîÊÍæÖÍÀÃÁ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 164);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÇÈÍÊÍÐ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 164);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        p pVar = (p) obj;
        boolean z = this.u;
        if (z != pVar.u) {
            return false;
        }
        return !z || (Arrays.equals(this.y, pVar.y) && Arrays.equals(this.c, pVar.c) && this.kd == pVar.kd);
    }

    public int hashCode() {
        if (this.u) {
            return ((((Arrays.hashCode(this.y) + 527) * 31) + Arrays.hashCode(this.c)) * 31) + (!this.kd ? 1 : 0);
        }
        return 17;
    }

    public List<f> hf() {
        String[] strArr = this.y;
        if (strArr != null) {
            return f.xj(strArr);
        }
        return null;
    }

    public String toString() {
        if (!this.u) {
            return "ConnectionSpec()";
        }
        StringBuilder BChYOn2 = A2egSU.BChYOn("ConnectionSpec(cipherSuites=", this.y != null ? hf().toString() : "[all enabled]", ", tlsVersions=", this.c != null ? w().toString() : "[all enabled]", ", supportsTlsExtensions=");
        BChYOn2.append(this.kd);
        BChYOn2.append(")");
        return BChYOn2.toString();
    }

    public boolean u() {
        return this.kd;
    }

    public List<en> w() {
        String[] strArr = this.c;
        if (strArr != null) {
            return en.xj(strArr);
        }
        return null;
    }

    public boolean xj() {
        return this.u;
    }

    public static final class xj {
        String[] hf;
        boolean u;
        String[] w;
        boolean xj;

        public xj(boolean z) {
            this.xj = z;
        }

        public xj hf(String... strArr) {
            if (!this.xj) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.w = (String[]) strArr.clone();
            return this;
        }

        public xj xj(f... fVarArr) {
            if (!this.xj) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[fVarArr.length];
            for (int i = 0; i < fVarArr.length; i++) {
                strArr[i] = fVarArr[i].e;
            }
            return xj(strArr);
        }

        public xj(p pVar) {
            this.xj = pVar.u;
            this.hf = pVar.y;
            this.w = pVar.c;
            this.u = pVar.kd;
        }

        public xj xj(String... strArr) {
            if (this.xj) {
                if (strArr.length != 0) {
                    this.hf = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public xj xj(en... enVarArr) {
            if (this.xj) {
                String[] strArr = new String[enVarArr.length];
                for (int i = 0; i < enVarArr.length; i++) {
                    strArr[i] = enVarArr[i].y;
                }
                return hf(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public xj xj(boolean z) {
            if (this.xj) {
                this.u = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public p xj() {
            return new p(this);
        }
    }

    private p hf(SSLSocket sSLSocket, boolean z) {
        String[] xj2 = this.y != null ? com.bytedance.sdk.component.w.hf.xj.w.xj(f.xj, sSLSocket.getEnabledCipherSuites(), this.y) : sSLSocket.getEnabledCipherSuites();
        String[] xj3 = this.c != null ? com.bytedance.sdk.component.w.hf.xj.w.xj(com.bytedance.sdk.component.w.hf.xj.w.f, sSLSocket.getEnabledProtocols(), this.c) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int xj4 = com.bytedance.sdk.component.w.hf.xj.w.xj(f.xj, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && xj4 != -1) {
            xj2 = com.bytedance.sdk.component.w.hf.xj.w.xj(xj2, supportedCipherSuites[xj4]);
        }
        return new xj(this).xj(xj2).hf(xj3).xj();
    }

    public void xj(SSLSocket sSLSocket, boolean z) {
        p hf2 = hf(sSLSocket, z);
        String[] strArr = hf2.c;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = hf2.y;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean xj(SSLSocket sSLSocket) {
        if (!this.u) {
            return false;
        }
        String[] strArr = this.c;
        if (strArr != null && !com.bytedance.sdk.component.w.hf.xj.w.hf(com.bytedance.sdk.component.w.hf.xj.w.f, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.y;
        return strArr2 == null || com.bytedance.sdk.component.w.hf.xj.w.hf(f.xj, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
