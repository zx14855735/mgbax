package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaeaaa;

import java.lang.reflect.Method;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaac implements HostnameVerifier {
    public static final aaaaaaac aaaaaaaa = new aaaaaaac();

    static {
        alLKMS();
    }

    private aaaaaaac() {
    }

    private boolean aaaaaaa0(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator it = aaaaaaaa(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (aaaaaaaa(lowerCase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean aaaaaaao(String str, X509Certificate x509Certificate) {
        List aaaaaaaa2 = aaaaaaaa(x509Certificate, 7);
        int size = aaaaaaaa2.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) aaaaaaaa2.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ void alLKMS() {
        char[] charArray = "6:8{2480{7:,{&=099{\u001f;<\u0017'<120".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'U');
        }
        String str = new String(charArray);
        char[] charArray2 = "69<;<!".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'U');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean aaaaaaaa(String str, X509Certificate x509Certificate) {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaac(str) ? aaaaaaao(str, x509Certificate) : aaaaaaa0(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return aaaaaaaa(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public static List aaaaaaaa(X509Certificate x509Certificate) {
        List aaaaaaaa2 = aaaaaaaa(x509Certificate, 7);
        List aaaaaaaa3 = aaaaaaaa(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(aaaaaaaa3.size() + aaaaaaaa2.size());
        arrayList.addAll(aaaaaaaa2);
        arrayList.addAll(aaaaaaaa3);
        return arrayList;
    }

    private static List aaaaaaaa(X509Certificate x509Certificate, int i) {
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

    public boolean aaaaaaaa(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str.concat(".");
            }
            if (!str2.endsWith(".")) {
                str2 = str2.concat(".");
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
