package com.sigmob.sdk.downloader.core;

import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class a {
    public static final String f = "";
    public static final File g = new File("");

    static {
        IzOw();
    }

    private static /* synthetic */ void IzOw() {
        char[] charArray = "ùõ÷´ýû÷ÿ´øõã´éòÿöö´ÐôóØèóþýÿ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 154);
        }
        String str = new String(charArray);
        char[] charArray2 = "ùöóôóî".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 154);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean a(a aVar) {
        if (i().equals(aVar.i()) && !i().equals("") && !l().equals(g)) {
            if (k().equals(aVar.k())) {
                return true;
            }
            if (!l().equals(aVar.l())) {
                return false;
            }
            String d = d();
            String d2 = aVar.d();
            if (d2 != null && d != null && d2.equals(d)) {
                return true;
            }
        }
        return false;
    }

    public abstract int c();

    public abstract String d();

    public abstract String i();

    public abstract File k();

    public abstract File l();
}
