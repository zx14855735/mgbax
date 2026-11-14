package com.kwai.adclient.kscommerciallogger.model;

import com.octopus.ad.ADBidEvent;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    public static final d bjZ = new d(ADBidEvent.OTHER);
    private final String value;

    static {
        WhzC();
    }

    public d(String str) {
        this.value = str;
    }

    private static /* synthetic */ void WhzC() {
        char[] charArray = "ieg$mkgo$hes$yboff$@dcHxcnmo".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\n');
        }
        String str = new String(charArray);
        char[] charArray2 = "ifcdc~".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String getValue() {
        return this.value;
    }
}
