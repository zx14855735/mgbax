package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum aaa0aaaa {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    final String aaaaaaaa;

    static {
        GxuOpd();
    }

    aaa0aaaa(String str) {
        this.aaaaaaaa = str;
    }

    private static /* synthetic */ void GxuOpd() {
        char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'p');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'p');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static aaa0aaaa aaaaaaaa(String str) {
        str.getClass();
        switch (str) {
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.3":
                return TLS_1_3;
            case "SSLv3":
                return SSL_3_0;
            case "TLSv1":
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
        }
    }

    public static List aaaaaaaa(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(aaaaaaaa(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
