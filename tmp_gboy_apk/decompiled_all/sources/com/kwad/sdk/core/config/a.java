package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static final String[] aDc = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    static {
        ocdO();
    }

    public static boolean cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (dJ(host)) {
                return true;
            }
            return dK(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : aDc) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = e.GO().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ void ocdO() {
        char[] charArray = "\u009b\u0097\u0095Ö\u009f\u0099\u0095\u009dÖ\u009a\u0097\u0081Ö\u008b\u0090\u009d\u0094\u0094Ö²\u0096\u0091º\u008a\u0091\u009c\u009f\u009d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 248);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009b\u0094\u0091\u0096\u0091\u008c".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 248);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
