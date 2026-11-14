package com.kwad.sdk.crash.utils;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static final Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    static {
        uKwO();
    }

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    private static /* synthetic */ void uKwO() {
        char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '{');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '{');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
