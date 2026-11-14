package com.bytedance.sdk.openadsdk.api.plugin.hf;

import java.lang.reflect.Method;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class xj implements HostnameVerifier {
    public static final xj xj = new xj();
    private static final Pattern hf = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        IkDKNsN();
    }

    private xj() {
    }

    private static /* synthetic */ void IkDKNsN() {
        char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 175);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 175);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean hf(String str, X509Certificate x509Certificate) {
        List<String> xj2 = xj(x509Certificate, 7);
        int size = xj2.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(xj2.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean w(String str, X509Certificate x509Certificate) {
        String xj2;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> xj3 = xj(x509Certificate, 2);
        int size = xj3.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (xj(lowerCase, xj3.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (xj2 = new hf(x509Certificate.getSubjectX500Principal()).xj("cn")) == null) {
            return false;
        }
        return xj(lowerCase, xj2);
    }

    private boolean xj(String str, X509Certificate x509Certificate) {
        return xj(str) ? hf(str, x509Certificate) : w(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return xj(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean xj(String str) {
        return hf.matcher(str).matches();
    }

    private static List<String> xj(X509Certificate x509Certificate, int i) {
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

    private boolean xj(String str, String str2) {
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
