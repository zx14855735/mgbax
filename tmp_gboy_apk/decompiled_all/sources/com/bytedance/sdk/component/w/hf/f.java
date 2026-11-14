package com.bytedance.sdk.component.w.hf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f {
    public static final f am;
    public static final f c;
    public static final f d;
    public static final f f;
    public static final f g;
    public static final f hf;
    public static final f kd;
    public static final f p;

    /* renamed from: pl, reason: collision with root package name */
    public static final f f10224pl;
    public static final f qt;
    public static final f tf;
    public static final f u;
    public static final f w;
    static final Comparator<String> xj;
    public static final f y;
    private static final Map<String, f> yo;
    public static final f zg;
    final String e;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.w.hf.f.1
            @Override // java.util.Comparator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int min = Math.min(str.length(), str2.length());
                for (int i = 4; i < min; i++) {
                    char charAt = str.charAt(i);
                    char charAt2 = str2.charAt(i);
                    if (charAt != charAt2) {
                        return charAt < charAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        xj = comparator;
        yo = new TreeMap(comparator);
        hf = xj("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        w = xj("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        u = xj("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        kd = xj("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        y = xj("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        c = xj("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        f = xj("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        d = xj("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        tf = xj("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        p = xj("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f10224pl = xj("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        g = xj("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        am = xj("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        qt = xj("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        zg = xj("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        evOcC();
    }

    private f(String str) {
        str.getClass();
        this.e = str;
    }

    private static /* synthetic */ void evOcC() {
        char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'y');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized f xj(String str) {
        f fVar;
        synchronized (f.class) {
            Map<String, f> map = yo;
            fVar = map.get(str);
            if (fVar == null) {
                fVar = new f(str);
                map.put(str, fVar);
            }
        }
        return fVar;
    }

    public String toString() {
        return this.e;
    }

    public static List<f> xj(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(xj(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static f xj(String str, int i) {
        return xj(str);
    }

    public String xj() {
        return this.e;
    }
}
