package RpxDSP;

import java.lang.reflect.Method;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ADYaiT implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final ADYaiT INSTANCE = new ADYaiT();

    static {
        yANJc();
    }

    private ADYaiT() {
    }

    public static ArrayList A2egSU(X509Certificate x509Certificate) {
        List A4TApA2 = A4TApA(x509Certificate, 7);
        List A4TApA3 = A4TApA(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(A4TApA3.size() + A4TApA2.size());
        arrayList.addAll(A4TApA2);
        arrayList.addAll(A4TApA3);
        return arrayList;
    }

    public static List A4TApA(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.EMPTY_LIST;
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[LOOP:1: B:14:0x0034->B:43:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A5SV6n(java.lang.String r8, java.security.cert.X509Certificate r9) {
        /*
            boolean r0 = okhttp3.internal.A5SV6n.BI9f7h(r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L25
            r0 = 7
            java.util.List r9 = A4TApA(r9, r0)
            int r0 = r9.size()
            r3 = 0
        L12:
            if (r3 >= r0) goto Le1
            java.lang.Object r4 = r9.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r8.equalsIgnoreCase(r4)
            if (r4 == 0) goto L22
            goto Le0
        L22:
            int r3 = r3 + 1
            goto L12
        L25:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r8 = r8.toLowerCase(r0)
            r0 = 2
            java.util.List r9 = A4TApA(r9, r0)
            java.util.Iterator r9 = r9.iterator()
        L34:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Le1
            java.lang.Object r0 = r9.next()
            java.lang.String r0 = (java.lang.String) r0
            if (r8 == 0) goto Lb3
            int r3 = r8.length()
            if (r3 == 0) goto Lb3
            java.lang.String r3 = "."
            boolean r4 = r8.startsWith(r3)
            if (r4 != 0) goto Lb3
            java.lang.String r4 = ".."
            boolean r5 = r8.endsWith(r4)
            if (r5 == 0) goto L59
            goto Lb3
        L59:
            if (r0 == 0) goto Lb3
            int r5 = r0.length()
            if (r5 == 0) goto Lb3
            boolean r5 = r0.startsWith(r3)
            if (r5 != 0) goto Lb3
            boolean r4 = r0.endsWith(r4)
            if (r4 == 0) goto L6e
            goto Lb3
        L6e:
            boolean r4 = r8.endsWith(r3)
            if (r4 != 0) goto L79
            java.lang.String r4 = r8.concat(r3)
            goto L7a
        L79:
            r4 = r8
        L7a:
            boolean r5 = r0.endsWith(r3)
            if (r5 != 0) goto L84
            java.lang.String r0 = r0.concat(r3)
        L84:
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r0 = r0.toLowerCase(r3)
            java.lang.String r3 = "*"
            boolean r3 = r0.contains(r3)
            if (r3 != 0) goto L97
            boolean r0 = r4.equals(r0)
            goto Lde
        L97:
            java.lang.String r3 = "*."
            boolean r5 = r0.startsWith(r3)
            if (r5 == 0) goto Lb3
            r5 = 42
            int r5 = r0.indexOf(r5, r2)
            r6 = -1
            if (r5 == r6) goto La9
            goto Lb3
        La9:
            int r5 = r4.length()
            int r7 = r0.length()
            if (r5 >= r7) goto Lb5
        Lb3:
            r0 = 0
            goto Lde
        Lb5:
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto Lbc
            goto Lb3
        Lbc:
            java.lang.String r0 = r0.substring(r2)
            boolean r3 = r4.endsWith(r0)
            if (r3 != 0) goto Lc7
            goto Lb3
        Lc7:
            int r3 = r4.length()
            int r0 = r0.length()
            int r3 = r3 - r0
            if (r3 <= 0) goto Ldd
            int r3 = r3 + (-1)
            r0 = 46
            int r0 = r4.lastIndexOf(r0, r3)
            if (r0 == r6) goto Ldd
            goto Lb3
        Ldd:
            r0 = 1
        Lde:
            if (r0 == 0) goto L34
        Le0:
            return r2
        Le1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: RpxDSP.ADYaiT.A5SV6n(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    private static /* synthetic */ void yANJc() {
        char[] charArray = "âîì¯æàìä¯ãîø¯òéäíí¯ËïèÃóèåæä".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 129);
        }
        String str = new String(charArray);
        char[] charArray2 = "âíèïèõ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 129);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return A5SV6n(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
