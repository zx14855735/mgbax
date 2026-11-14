package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import J3FDQU.A2egSU;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaeaaa {
    public static final aaaaeaaa aaaaaaae;
    private static final aaaaaaav[] aaaaaaan;
    private static final aaaaaaav[] aaaaaaau;
    public static final aaaaeaaa aaaaaaav;
    public static final aaaaeaaa aaaaaaeo;
    public static final aaaaeaaa aaaeaaaa;
    final boolean aaaaaaa0;
    final boolean aaaaaaaa;
    final String[] aaaaaaac;
    final String[] aaaaaaao;

    static {
        aaaaaaav aaaaaaavVar = aaaaaaav.s0;
        aaaaaaav aaaaaaavVar2 = aaaaaaav.t0;
        aaaaaaav aaaaaaavVar3 = aaaaaaav.u0;
        aaaaaaav aaaaaaavVar4 = aaaaaaav.v0;
        aaaaaaav aaaaaaavVar5 = aaaaaaav.w0;
        aaaaaaav aaaaaaavVar6 = aaaaaaav.e0;
        aaaaaaav aaaaaaavVar7 = aaaaaaav.i0;
        aaaaaaav aaaaaaavVar8 = aaaaaaav.f0;
        aaaaaaav aaaaaaavVar9 = aaaaaaav.j0;
        aaaaaaav aaaaaaavVar10 = aaaaaaav.p0;
        aaaaaaav aaaaaaavVar11 = aaaaaaav.o0;
        aaaaaaav[] aaaaaaavVarArr = {aaaaaaavVar, aaaaaaavVar2, aaaaaaavVar3, aaaaaaavVar4, aaaaaaavVar5, aaaaaaavVar6, aaaaaaavVar7, aaaaaaavVar8, aaaaaaavVar9, aaaaaaavVar10, aaaaaaavVar11};
        aaaaaaau = aaaaaaavVarArr;
        aaaaaaav[] aaaaaaavVarArr2 = {aaaaaaavVar, aaaaaaavVar2, aaaaaaavVar3, aaaaaaavVar4, aaaaaaavVar5, aaaaaaavVar6, aaaaaaavVar7, aaaaaaavVar8, aaaaaaavVar9, aaaaaaavVar10, aaaaaaavVar11, aaaaaaav.P, aaaaaaav.Q, aaaaaaav.n, aaaaaaav.o, aaaaaaav.aaaaaa0a, aaaaaaav.aaaanaaa, aaaaaaav.aaaaeaaa};
        aaaaaaan = aaaaaaavVarArr2;
        aaaaaaaa aaaaaaaa2 = new aaaaaaaa(true).aaaaaaaa(aaaaaaavVarArr);
        aaa0aaaa aaa0aaaaVar = aaa0aaaa.TLS_1_3;
        aaa0aaaa aaa0aaaaVar2 = aaa0aaaa.TLS_1_2;
        aaaaaaae = aaaaaaaa2.aaaaaaaa(aaa0aaaaVar, aaa0aaaaVar2).aaaaaaaa(true).aaaaaaaa();
        aaaaaaaa aaaaaaaa3 = new aaaaaaaa(true).aaaaaaaa(aaaaaaavVarArr2);
        aaa0aaaa aaa0aaaaVar3 = aaa0aaaa.TLS_1_0;
        aaaaaaav = aaaaaaaa3.aaaaaaaa(aaa0aaaaVar, aaa0aaaaVar2, aaa0aaaa.TLS_1_1, aaa0aaaaVar3).aaaaaaaa(true).aaaaaaaa();
        aaaaaaeo = new aaaaaaaa(true).aaaaaaaa(aaaaaaavVarArr2).aaaaaaaa(aaa0aaaaVar3).aaaaaaaa(true).aaaaaaaa();
        aaaeaaaa = new aaaaaaaa(false).aaaaaaaa();
        dKUkty();
    }

    public aaaaeaaa(aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaaa = aaaaaaaaVar.aaaaaaaa;
        this.aaaaaaao = aaaaaaaaVar.aaaaaaa0;
        this.aaaaaaac = aaaaaaaaVar.aaaaaaao;
        this.aaaaaaa0 = aaaaaaaaVar.aaaaaaac;
    }

    private static /* synthetic */ void dKUkty() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean aaaaaaa0() {
        return this.aaaaaaaa;
    }

    public List aaaaaaaa() {
        String[] strArr = this.aaaaaaao;
        if (strArr != null) {
            return aaaaaaav.aaaaaaaa(strArr);
        }
        return null;
    }

    public List aaaaaaac() {
        String[] strArr = this.aaaaaaac;
        if (strArr != null) {
            return aaa0aaaa.aaaaaaaa(strArr);
        }
        return null;
    }

    public boolean aaaaaaao() {
        return this.aaaaaaa0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aaaaeaaa)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        aaaaeaaa aaaaeaaaVar = (aaaaeaaa) obj;
        boolean z = this.aaaaaaaa;
        if (z != aaaaeaaaVar.aaaaaaaa) {
            return false;
        }
        return !z || (Arrays.equals(this.aaaaaaao, aaaaeaaaVar.aaaaaaao) && Arrays.equals(this.aaaaaaac, aaaaeaaaVar.aaaaaaac) && this.aaaaaaa0 == aaaaeaaaVar.aaaaaaa0);
    }

    public int hashCode() {
        if (this.aaaaaaaa) {
            return ((((Arrays.hashCode(this.aaaaaaao) + 527) * 31) + Arrays.hashCode(this.aaaaaaac)) * 31) + (!this.aaaaaaa0 ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.aaaaaaaa) {
            return "ConnectionSpec()";
        }
        StringBuilder BChYOn2 = A2egSU.BChYOn("ConnectionSpec(cipherSuites=", this.aaaaaaao != null ? aaaaaaaa().toString() : "[all enabled]", ", tlsVersions=", this.aaaaaaac != null ? aaaaaaac().toString() : "[all enabled]", ", supportsTlsExtensions=");
        BChYOn2.append(this.aaaaaaa0);
        BChYOn2.append(")");
        return BChYOn2.toString();
    }

    public static final class aaaaaaaa {
        String[] aaaaaaa0;
        boolean aaaaaaaa;
        boolean aaaaaaac;
        String[] aaaaaaao;

        public aaaaaaaa(boolean z) {
            this.aaaaaaaa = z;
        }

        public aaaaaaaa aaaaaaa0(String... strArr) {
            if (!this.aaaaaaaa) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.aaaaaaao = (String[]) strArr.clone();
            return this;
        }

        public aaaaaaaa aaaaaaaa(aaaaaaav... aaaaaaavVarArr) {
            if (!this.aaaaaaaa) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[aaaaaaavVarArr.length];
            for (int i = 0; i < aaaaaaavVarArr.length; i++) {
                strArr[i] = aaaaaaavVarArr[i].aaaaaaaa;
            }
            return aaaaaaaa(strArr);
        }

        public aaaaaaaa(aaaaeaaa aaaaeaaaVar) {
            this.aaaaaaaa = aaaaeaaaVar.aaaaaaaa;
            this.aaaaaaa0 = aaaaeaaaVar.aaaaaaao;
            this.aaaaaaao = aaaaeaaaVar.aaaaaaac;
            this.aaaaaaac = aaaaeaaaVar.aaaaaaa0;
        }

        public aaaaaaaa aaaaaaaa(String... strArr) {
            if (this.aaaaaaaa) {
                if (strArr.length != 0) {
                    this.aaaaaaa0 = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public aaaaaaaa aaaaaaaa(aaa0aaaa... aaa0aaaaVarArr) {
            if (this.aaaaaaaa) {
                String[] strArr = new String[aaa0aaaaVarArr.length];
                for (int i = 0; i < aaa0aaaaVarArr.length; i++) {
                    strArr[i] = aaa0aaaaVarArr[i].aaaaaaaa;
                }
                return aaaaaaa0(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public aaaaaaaa aaaaaaaa(boolean z) {
            if (this.aaaaaaaa) {
                this.aaaaaaac = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public aaaaeaaa aaaaaaaa() {
            return new aaaaeaaa(this);
        }
    }

    private aaaaeaaa aaaaaaa0(SSLSocket sSLSocket, boolean z) {
        String[] aaaaaaaa2 = this.aaaaaaao != null ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaav.aaaaaaa0, sSLSocket.getEnabledCipherSuites(), this.aaaaaaao) : sSLSocket.getEnabledCipherSuites();
        String[] aaaaaaaa3 = this.aaaaaaac != null ? io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaoaaaaa, sSLSocket.getEnabledProtocols(), this.aaaaaaac) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int aaaaaaaa4 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaav.aaaaaaa0, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && aaaaaaaa4 != -1) {
            aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaaa2, supportedCipherSuites[aaaaaaaa4]);
        }
        return new aaaaaaaa(this).aaaaaaaa(aaaaaaaa2).aaaaaaa0(aaaaaaaa3).aaaaaaaa();
    }

    public void aaaaaaaa(SSLSocket sSLSocket, boolean z) {
        aaaaeaaa aaaaaaa0 = aaaaaaa0(sSLSocket, z);
        String[] strArr = aaaaaaa0.aaaaaaac;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = aaaaaaa0.aaaaaaao;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean aaaaaaaa(SSLSocket sSLSocket) {
        if (!this.aaaaaaaa) {
            return false;
        }
        String[] strArr = this.aaaaaaac;
        if (strArr != null && !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaa0(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaoaaaaa, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.aaaaaaao;
        return strArr2 == null || io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaa0(aaaaaaav.aaaaaaa0, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
